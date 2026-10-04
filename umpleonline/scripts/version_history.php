<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Server-side version history of the models edited in UmpleOnline (issue 1923)
//
// Each model directory (ump/tmp..., bookmarks, task directories) can contain a
// versionHistory subdirectory holding:
//
//   currentVersion00022-2026-10-04-09-48-03
//     An empty marker file whose name records the number of the latest change to
//     the model's files and when it was made (UTC). Browser tabs compare this
//     number with the version they last saw to detect that another tab or window
//     has saved a newer version of the model.
//
//   backup00017-2026-10-04-09-40-11/
//     The model's .ump files (and tab_index, if any) as they were at version 17,
//     plus backupinfo.json recording why the backup was made. Files identical to
//     those in the previous backup are hard links, so unchanged tabs use no space.
//
// A backup is made automatically when there have been at least
// MIN_CHANGES_BETWEEN_BACKUPS changes and at least MIN_SECONDS_BETWEEN_BACKUPS
// seconds have passed since the previous backup. A backup is also made before an
// earlier version is restored, and before a browser tab that was showing an
// out-of-date version overwrites a newer one. Older backups are then thinned out
// (see selectBackupsToDelete).
//
// This file has no dependencies so that it can be unit tested on its own.

class VersionHistory
{
  const HISTORY_DIR = "versionHistory";
  const CURRENT_PREFIX = "currentVersion";
  const BACKUP_PREFIX = "backup";
  const BACKUP_INFO = "backupinfo.json";
  const INCOMPLETE_PREFIX = ".incomplete-";
  const TAB_INDEX = "tab_index";
  const MAIN_FILE = "model.ump";
  const LOCK_FILE = ".lockfile";
  const MODEL_DELIMITER = '//$?[End_of_model]$?';

  const MIN_CHANGES_BETWEEN_BACKUPS = 5;
  const MIN_SECONDS_BETWEEN_BACKUPS = 120;
  const MAX_BACKUPS = 500;

  // Each rule is (maximum age in seconds, period). Beyond the first rule only the
  // newest backup in each period is kept. Automatic backups are already at least
  // two minutes apart, so keeping everything for 30 minutes gives "every 2 minutes
  // for the last 30 minutes" while never deleting a backup just made before a
  // restore or an overwrite.
  private static $thinningRules = array(
    array(1800, 0),
    array(7200, 300),
    array(43200, 600),
    array(172800, 1800),
    array(2592000, "day"),
    array(PHP_INT_MAX, "month")
  );

  private $modelDir;
  private $historyDir;
  private $clock;
  private $replacedBackup = null;

  // $clock, if given, is a callable returning the current Unix time (for testing)
  function __construct($modelDir, $clock = null)
  {
    $this->modelDir = rtrim($modelDir, "/");
    $this->historyDir = $this->modelDir."/".self::HISTORY_DIR;
    $this->clock = $clock;
  }

  function getModelDir()
  {
    return $this->modelDir;
  }

  function getHistoryDir()
  {
    return $this->historyDir;
  }

  function now()
  {
    return $this->clock === null ? time() : (int) call_user_func($this->clock);
  }

  // ---------------------------------------------------------------------------
  // Request helpers

  // Model ids arrive from the browser, so only the forms UmpleOnline creates are
  // accepted. Task roots live under tasks/, as in tab_control.php.
  static function normalizeModelId($modelId)
  {
    if (!is_string($modelId)) return null;
    if (substr($modelId, 0, 8) == "taskroot") $modelId = "tasks/".$modelId;
    return preg_match('/^(tasks\/)?[A-Za-z0-9][A-Za-z0-9_.\-]*$/', $modelId) ? $modelId : null;
  }

  // The version that the browser tab making the request had last synchronized
  // with, or null if it did not say
  static function requestedBaseVersion()
  {
    if (!isset($_REQUEST["baseVersion"])) return null;
    $baseVersion = (string) $_REQUEST["baseVersion"];
    return ctype_digit($baseVersion) ? (int) $baseVersion : null;
  }

  // $replacedBackup is the backup returned by getReplacedBackup, if any
  static function sendVersionHeaders($version, $changed, $replacedBackup = null)
  {
    if (headers_sent()) return;
    header("X-Umple-Version: ".(int) $version);
    header("X-Umple-Version-Changed: ".($changed ? "1" : "0"));
    if ($replacedBackup !== null) header("X-Umple-Version-Replaced: ".$replacedBackup["id"]);
  }

  // Runs $action while holding the model's lock file, which compiler.php and
  // tab_control.php also hold while changing the model's files
  function withLock(callable $action)
  {
    $lock = @fopen($this->modelDir."/".self::LOCK_FILE, "c");
    if ($lock === false) return $action();
    flock($lock, LOCK_EX);
    try {
      return $action();
    } finally {
      flock($lock, LOCK_UN);
      fclose($lock);
    }
  }

  // ---------------------------------------------------------------------------
  // Versions

  static function formatName($prefix, $version, $time)
  {
    return sprintf("%s%05d-%s", $prefix, $version, gmdate("Y-m-d-H-i-s", $time));
  }

  // Returns array("version" => int, "time" => int) or null if $name is not of
  // the form produced by formatName with the given prefix
  static function parseName($prefix, $name)
  {
    $pattern = '/^'.preg_quote($prefix, '/').'(\d+)-(\d{4})-(\d\d)-(\d\d)-(\d\d)-(\d\d)-(\d\d)$/';
    if (!is_string($name) || !preg_match($pattern, $name, $m)) return null;
    $time = gmmktime((int) $m[5], (int) $m[6], (int) $m[7], (int) $m[3], (int) $m[4], (int) $m[2]);
    return array("version" => (int) $m[1], "time" => $time);
  }

  // Returns array("version" => int, "time" => int|null); version 0 means that
  // no change has been recorded yet
  function getCurrentVersionInfo()
  {
    $best = array("version" => 0, "time" => null);
    foreach ($this->historyEntries() as $name) {
      $parsed = self::parseName(self::CURRENT_PREFIX, $name);
      if ($parsed !== null && $parsed["version"] >= $best["version"]) $best = $parsed;
    }
    return $best;
  }

  function getCurrentVersion()
  {
    $info = $this->getCurrentVersionInfo();
    return $info["version"];
  }

  function describeCurrentVersion()
  {
    $info = $this->getCurrentVersionInfo();
    return array("version" => $info["version"], "savedAt" => $info["time"]);
  }

  private function setCurrentVersion($version, $time)
  {
    if (!$this->ensureHistoryDir()) return;
    $newPath = $this->historyDir."/".self::formatName(self::CURRENT_PREFIX, $version, $time);
    $markers = array();
    foreach ($this->historyEntries() as $name) {
      if (self::parseName(self::CURRENT_PREFIX, $name) !== null) $markers[] = $this->historyDir."/".$name;
    }
    $first = array_shift($markers);
    if ($first === null) @touch($newPath);
    else if ($first !== $newPath) @rename($first, $newPath);
    foreach ($markers as $extra) {
      if ($extra !== $newPath) @unlink($extra);
    }
  }

  // Writes one of the model's files, recording a new version if its content is
  // different. Returns array("version" => int, "changed" => bool).
  function writeFile($name, $content, $baseVersion = null)
  {
    $this->replacedBackup = null;
    $path = $this->modelDir."/".$name;
    if (is_file($path)) {
      $existing = file_get_contents($path);
      if ($existing === $content) {
        return array("version" => $this->getCurrentVersion(), "changed" => false);
      }
      if (self::sameModelText($existing, $content)) {
        file_put_contents($path, $content);
        return array("version" => $this->getCurrentVersion(), "changed" => false);
      }
    }
    $version = $this->recordChange(function() use ($path, $content) {
      file_put_contents($path, $content);
    }, $baseVersion);
    return array("version" => $version, "changed" => true);
  }

  // The backup made by the last change because the browser tab making it had an
  // out-of-date version, so the change replaced newer work; null if there was none
  function getReplacedBackup()
  {
    return $this->replacedBackup;
  }

  // Calls $change, which changes the model's files, and records the result as a
  // new version, making any backups that are due. $baseVersion is the version
  // the browser tab requesting the change had last synchronized with; if it is
  // older than the current version, the current files are backed up first since
  // they may contain work from another tab that the change overwrites.
  // Returns the new version number.
  function recordChange(callable $change, $baseVersion = null)
  {
    $this->replacedBackup = null;
    $current = $this->getCurrentVersionInfo();
    $this->safely(function() use ($current, $baseVersion) {
      $stale = $baseVersion !== null && $baseVersion < $current["version"];
      if ($this->getLatestBackup() === null) {
        $backup = $this->createBackup("initial");
      } else if ($stale) {
        $backup = $this->createBackup("conflict", array("staleVersion" => (int) $baseVersion));
      }
      if ($stale) $this->replacedBackup = $backup;
    });

    $change();

    $newVersion = $current["version"] + 1;
    $now = $this->now();
    $this->safely(function() use ($newVersion, $now) {
      $this->setCurrentVersion($newVersion, $now);
      $latest = $this->getLatestBackup();
      if ($latest !== null
        && $newVersion - $latest["version"] >= self::MIN_CHANGES_BETWEEN_BACKUPS
        && $now - $latest["time"] >= self::MIN_SECONDS_BETWEEN_BACKUPS) {
        $this->createBackup("auto");
      }
    });
    return $newVersion;
  }

  // ---------------------------------------------------------------------------
  // Backups

  // Backups, newest first, each as array("id", "version", "time", "path")
  function listBackups()
  {
    $backups = array();
    foreach ($this->historyEntries() as $name) {
      $parsed = self::parseName(self::BACKUP_PREFIX, $name);
      if ($parsed === null || !is_dir($this->historyDir."/".$name)) continue;
      $parsed["id"] = $name;
      $parsed["path"] = $this->historyDir."/".$name;
      $backups[] = $parsed;
    }
    usort($backups, array("VersionHistory", "compareNewestFirst"));
    return $backups;
  }

  static function compareNewestFirst($a, $b)
  {
    if ($a["version"] != $b["version"]) return $b["version"] - $a["version"];
    return $b["time"] - $a["time"];
  }

  function getLatestBackup()
  {
    $backups = $this->listBackups();
    return count($backups) > 0 ? $backups[0] : null;
  }

  function findBackup($id)
  {
    if (self::parseName(self::BACKUP_PREFIX, $id) === null) return null;
    foreach ($this->listBackups() as $backup) {
      if ($backup["id"] === $id) return $backup;
    }
    return null;
  }

  // Information about a backup suitable for showing to the user
  function describeBackup($backup)
  {
    $info = @json_decode((string) @file_get_contents($backup["path"]."/".self::BACKUP_INFO), true);
    if (!is_array($info)) $info = array();
    $description = array(
      "id" => $backup["id"],
      "version" => $backup["version"],
      "savedAt" => $backup["time"],
      "reason" => isset($info["reason"]) ? $info["reason"] : "auto",
      "files" => self::fileNamesInDisplayOrder($backup["path"])
    );
    foreach (array("restoredVersion", "staleVersion") as $key) {
      if (isset($info[$key])) $description[$key] = (int) $info[$key];
    }
    if (isset($info["deletedFile"])) $description["deletedFile"] = (string) $info["deletedFile"];
    return $description;
  }

  function describeBackups()
  {
    $result = array();
    foreach ($this->listBackups() as $backup) $result[] = $this->describeBackup($backup);
    return $result;
  }

  // The files in a backup in the order UmpleOnline shows them as tabs, each as
  // array("name" => ..., "content" => ...), or null if there is no such backup
  function getBackupFiles($id)
  {
    $backup = $this->findBackup($id);
    if ($backup === null) return null;
    $files = self::readFiles($backup["path"]);
    $result = array();
    foreach (self::displayOrder($files) as $name) {
      $result[] = array("name" => $name, "content" => $files[$name]);
    }
    return $result;
  }

  // Backs up the model's current files unless they are empty or identical to the
  // latest backup. Returns the new (or identical latest) backup, or null.
  function createBackup($reason, array $info = array())
  {
    $files = self::readFiles($this->modelDir);
    if (self::isEmptyModel($files)) return null;
    $latest = $this->getLatestBackup();
    $latestFiles = $latest === null ? null : self::readFiles($latest["path"]);
    if ($latestFiles !== null && self::sameFiles($latestFiles, $files)) return $latest;
    if (!$this->ensureHistoryDir()) return null;

    $current = $this->getCurrentVersionInfo();
    $time = $this->now();
    $id = self::formatName(self::BACKUP_PREFIX, $current["version"], $time);
    $path = $this->historyDir."/".$id;
    if (file_exists($path)) return $this->findBackup($id);

    $incompletePath = $this->historyDir."/".self::INCOMPLETE_PREFIX.$id;
    if (file_exists($incompletePath)) self::deleteDirectory($incompletePath);
    if (!@mkdir($incompletePath)) return null;
    foreach ($files as $name => $content) {
      if ($latestFiles !== null && isset($latestFiles[$name]) && $latestFiles[$name] === $content
        && @link($latest["path"]."/".$name, $incompletePath."/".$name)) {
        continue;
      }
      if (@file_put_contents($incompletePath."/".$name, $content) === false) {
        self::deleteDirectory($incompletePath);
        return null;
      }
    }
    @file_put_contents($incompletePath."/".self::BACKUP_INFO, json_encode(array_merge(array("reason" => $reason), $info)));
    if (!@rename($incompletePath, $path)) {
      self::deleteDirectory($incompletePath);
      return null;
    }
    $this->thinBackups();
    return $this->findBackup($id);
  }

  function thinBackups()
  {
    foreach (self::selectBackupsToDelete($this->listBackups(), $this->now()) as $backup) {
      self::deleteDirectory($backup["path"]);
    }
  }

  // Given backups (each with "version" and "time"), returns those that thinning
  // removes: all backups less than 30 minutes old are kept; beyond that, only the
  // newest backup in each 5 minute period up to 2 hours old, each 10 minutes up to
  // 12 hours, each half hour up to 2 days, each day (UTC) up to 30 days and each
  // month after that. The newest backup is always kept, and at most MAX_BACKUPS.
  static function selectBackupsToDelete(array $backups, $now)
  {
    usort($backups, array("VersionHistory", "compareNewestFirst"));
    $kept = array();
    $toDelete = array();
    $periodsSeen = array();
    foreach ($backups as $index => $backup) {
      $period = self::thinningPeriod($backup["time"], $now);
      if ($period !== null) {
        if ($index > 0 && isset($periodsSeen[$period])) {
          $toDelete[] = $backup;
          continue;
        }
        $periodsSeen[$period] = true;
      }
      $kept[] = $backup;
    }
    while (count($kept) > self::MAX_BACKUPS) $toDelete[] = array_pop($kept);
    return $toDelete;
  }

  // A key identifying the thinning period that a backup made at $time is in, or
  // null if all backups of its age are kept. Periods are aligned to fixed clock
  // times so a backup stays in the same period as it ages within a rule.
  static function thinningPeriod($time, $now)
  {
    $age = max(0, $now - $time);
    foreach (self::$thinningRules as $index => $rule) {
      list($maxAge, $period) = $rule;
      if ($age >= $maxAge) continue;
      if ($period === 0) return null;
      if ($period === "day") return $index.":".gmdate("Y-m-d", $time);
      if ($period === "month") return $index.":".gmdate("Y-m", $time);
      return $index.":".intdiv($time, $period);
    }
    return null;
  }

  // Replaces the model's files with those in the given backup, first backing up
  // the current files so that the restore can itself be undone.
  // Returns null if there is no such backup, otherwise array("version" => new
  // version, "restoredVersion", "savedId" and "savedVersion" => the backup
  // holding the files from before the restore (null if they were empty),
  // "shownFile" and "shownContent" => the file shown first after reloading).
  function restoreBackup($id)
  {
    $backup = $this->findBackup($id);
    if ($backup === null) return null;
    $files = self::readFiles($backup["path"]);
    $saved = $this->safely(function() use ($backup) {
      return $this->createBackup("beforeRestore", array("restoredVersion" => $backup["version"]));
    });
    $shownFile = null;
    $version = $this->recordChange(function() use ($files, &$shownFile) {
      $shownFile = $this->replaceModelFiles($files);
    });
    return array(
      "version" => $version,
      "restoredVersion" => $backup["version"],
      "savedId" => $saved === null ? null : $saved["id"],
      "savedVersion" => $saved === null ? null : $saved["version"],
      "shownFile" => $shownFile,
      "shownContent" => (string) @file_get_contents($this->modelDir."/".self::MAIN_FILE)
    );
  }

  // model.ump is the compiler's working copy of the tab being edited, and is
  // what UmpleOnline shows first when a model with a single tab is loaded, so it
  // is set to the tab that is selected last when the tabs are loaded.
  private function replaceModelFiles(array $files)
  {
    foreach (self::modelFileNames($this->modelDir) as $name) {
      if ($name !== self::MAIN_FILE) unlink($this->modelDir."/".$name);
    }
    if (is_file($this->modelDir."/".self::TAB_INDEX)) unlink($this->modelDir."/".self::TAB_INDEX);
    foreach ($files as $name => $content) {
      if ($name !== self::MAIN_FILE) file_put_contents($this->modelDir."/".$name, $content);
    }
    $order = self::displayOrder($files);
    $shownFile = count($order) > 0 ? $order[count($order) - 1] : self::MAIN_FILE;
    if (isset($files[$shownFile])) file_put_contents($this->modelDir."/".self::MAIN_FILE, $files[$shownFile]);
    return $shownFile;
  }

  // When a model with a single tab is loaded, UmpleOnline shows model.ump rather
  // than the tab's file. model.ump is only brought up to date when the model is
  // compiled, so just after a change is saved (as when another browser tab has
  // just saved one) it can be out of date. Called when the page is loaded.
  function updateMainFileFromOnlyTab()
  {
    $names = self::modelFileNames($this->modelDir);
    if (count($names) != 1 || $names[0] === self::MAIN_FILE) return;
    $tabContent = file_get_contents($this->modelDir."/".$names[0]);
    $mainPath = $this->modelDir."/".self::MAIN_FILE;
    if ($tabContent !== false && (!is_file($mainPath) || file_get_contents($mainPath) !== $tabContent)) {
      file_put_contents($mainPath, $tabContent);
    }
  }

  // Gives a model created from this one (by bookmarking or forking) the same
  // history. If $move is true this model is about to be deleted.
  function transferHistoryTo($targetModelDir, $move)
  {
    if (!is_dir($this->historyDir)) return;
    $target = rtrim($targetModelDir, "/")."/".self::HISTORY_DIR;
    if (file_exists($target)) return;
    if ($move && @rename($this->historyDir, $target)) return;
    self::copyDirectory($this->historyDir, $target);
  }

  // ---------------------------------------------------------------------------
  // Files

  // The names of the .ump files making up the model in $dir, sorted. model.ump is
  // only included when there are no others, i.e. before any tab has been saved.
  static function modelFileNames($dir)
  {
    $names = array();
    $entries = is_dir($dir) ? scandir($dir) : array();
    foreach ($entries as $name) {
      if (strlen($name) > 4 && substr($name, -4) === ".ump" && is_file($dir."/".$name)) $names[] = $name;
    }
    sort($names, SORT_STRING);
    $tabFiles = array_values(array_diff($names, array(self::MAIN_FILE)));
    return count($tabFiles) > 0 ? $tabFiles : $names;
  }

  // Map from file name to content for the model's files (and tab_index) in $dir
  static function readFiles($dir)
  {
    $files = array();
    foreach (self::modelFileNames($dir) as $name) {
      $files[$name] = (string) file_get_contents($dir."/".$name);
    }
    if (is_file($dir."/".self::TAB_INDEX)) {
      $files[self::TAB_INDEX] = (string) file_get_contents($dir."/".self::TAB_INDEX);
    }
    return $files;
  }

  // The .ump files among $files in the order tab_control.php lists them as tabs
  // (tab_index order if there is one, otherwise alphabetical), or model.ump alone
  static function displayOrder(array $files)
  {
    $names = array();
    if (isset($files[self::TAB_INDEX])) {
      foreach (preg_split('/\R/', $files[self::TAB_INDEX]) as $base) {
        if ($base !== "" && isset($files[$base.".ump"]) && !in_array($base.".ump", $names)) $names[] = $base.".ump";
      }
    } else {
      foreach (array_keys($files) as $name) {
        if (substr($name, -4) === ".ump") $names[] = $name;
      }
      sort($names, SORT_STRING);
    }
    $tabFiles = array_values(array_diff($names, array(self::MAIN_FILE)));
    if (count($tabFiles) == 0 && isset($files[self::MAIN_FILE])) return array(self::MAIN_FILE);
    return $tabFiles;
  }

  static function fileNamesInDisplayOrder($dir)
  {
    $files = array_fill_keys(self::modelFileNames($dir), "");
    if (is_file($dir."/".self::TAB_INDEX)) {
      $files[self::TAB_INDEX] = (string) file_get_contents($dir."/".self::TAB_INDEX);
    }
    return self::displayOrder($files);
  }

  // Each time a model is loaded, UmpleOnline saves it with an extra line break
  // before the layout, so whitespace at the end of the model text and around the
  // layout is ignored when deciding whether the model has changed
  static function sameModelText($a, $b)
  {
    return self::normalizeModelText($a) === self::normalizeModelText($b);
  }

  private static function normalizeModelText($content)
  {
    $end = strpos($content, self::MODEL_DELIMITER);
    if ($end === false) return rtrim($content);
    return rtrim(substr($content, 0, $end))."\n".self::MODEL_DELIMITER."\n"
      .trim(substr($content, $end + strlen(self::MODEL_DELIMITER)));
  }

  static function sameFiles(array $a, array $b)
  {
    if (count($a) != count($b)) return false;
    foreach ($a as $name => $content) {
      if (!array_key_exists($name, $b) || !self::sameModelText($content, $b[$name])) return false;
    }
    return true;
  }

  // True if none of the files contains anything but whitespace before the layout
  static function isEmptyModel(array $files)
  {
    foreach ($files as $name => $content) {
      if ($name === self::TAB_INDEX) continue;
      $end = strpos($content, self::MODEL_DELIMITER);
      if (trim($end === false ? $content : substr($content, 0, $end)) !== "") return false;
    }
    return true;
  }

  private function historyEntries()
  {
    if (!is_dir($this->historyDir)) return array();
    $entries = @scandir($this->historyDir);
    return $entries === false ? array() : $entries;
  }

  private function ensureHistoryDir()
  {
    return is_dir($this->historyDir) || @mkdir($this->historyDir) || is_dir($this->historyDir);
  }

  // Backing up must never prevent the user's own change from being saved
  private function safely(callable $action)
  {
    try {
      return $action();
    } catch (Throwable $e) {
      error_log("UmpleOnline version history (".$this->modelDir."): ".$e->getMessage());
      return null;
    }
  }

  static function deleteDirectory($dir)
  {
    if (!is_dir($dir) || is_link($dir)) return;
    foreach (scandir($dir) as $name) {
      if ($name === "." || $name === "..") continue;
      $path = $dir."/".$name;
      if (is_dir($path) && !is_link($path)) self::deleteDirectory($path);
      else @unlink($path);
    }
    @rmdir($dir);
  }

  // Backups never change once made, so files are hard linked where possible
  static function copyDirectory($from, $to)
  {
    if (!@mkdir($to) && !is_dir($to)) return;
    foreach (scandir($from) as $name) {
      if ($name === "." || $name === "..") continue;
      if (is_dir($from."/".$name)) self::copyDirectory($from."/".$name, $to."/".$name);
      else if (!@link($from."/".$name, $to."/".$name)) @copy($from."/".$name, $to."/".$name);
    }
  }
}
