<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Unit tests of UmpleOnline's server-side version history (scripts/version_history.php)

require_once(__DIR__."/../../scripts/version_history.php");

class TestClock
{
  public $time;

  function __construct($time)
  {
    $this->time = $time;
  }

  function advance($seconds)
  {
    $this->time += $seconds;
  }

  function __invoke()
  {
    return $this->time;
  }
}

function testStartTime()
{
  return gmmktime(9, 0, 0, 10, 4, 2026);
}

// Text as UmpleOnline saves it: the model followed by the diagram layout
function umpleText($model)
{
  return $model."\n".VersionHistory::MODEL_DELIMITER."\nnamespace -;\n";
}

// Returns array(history, model directory, clock) for a new model directory
// containing the given files
function newHistory(array $files = array())
{
  $dir = makeTemporaryDirectory("umple-version-history-");
  foreach ($files as $name => $content) file_put_contents($dir."/".$name, $content);
  $clock = new TestClock(testStartTime());
  return array(new VersionHistory($dir, $clock), $dir, $clock);
}

function backupAt($version, $time)
{
  return array("id" => "b".$version, "version" => $version, "time" => $time);
}

function sortedIds(array $backups)
{
  $ids = array_map(function($backup) { return $backup["id"]; }, $backups);
  sort($ids, SORT_STRING);
  return $ids;
}

UmpleTest::add("model ids are only accepted in the forms UmpleOnline creates", function() {
  assertSame("tmp1a2b3c", VersionHistory::normalizeModelId("tmp1a2b3c"));
  assertSame("261004abcd", VersionHistory::normalizeModelId("261004abcd"));
  assertSame("task-Demo.1-261004xyz", VersionHistory::normalizeModelId("task-Demo.1-261004xyz"));
  assertSame("tasks/taskroot-demo-261004xyz", VersionHistory::normalizeModelId("taskroot-demo-261004xyz"));
  foreach (array("", "..", "../etc", "tmp1/../../etc", "tmp1/x", ".hidden", "tasks/../x", "a b", "tmp1\0") as $bad) {
    assertSame(null, VersionHistory::normalizeModelId($bad), "for ".var_export($bad, true));
  }
  assertSame(null, VersionHistory::normalizeModelId(null));
  assertSame(null, VersionHistory::normalizeModelId(array("tmp1")));
});

UmpleTest::add("the base version sent by the browser is only used if it is a number", function() {
  $saved = $_REQUEST;
  UmpleTest::cleanup(function() use ($saved) { $_REQUEST = $saved; });
  $_REQUEST = array();
  assertSame(null, VersionHistory::requestedBaseVersion());
  $_REQUEST = array("baseVersion" => "17");
  assertSame(17, VersionHistory::requestedBaseVersion());
  $_REQUEST = array("baseVersion" => "-1");
  assertSame(null, VersionHistory::requestedBaseVersion());
  $_REQUEST = array("baseVersion" => "undefined");
  assertSame(null, VersionHistory::requestedBaseVersion());
});

UmpleTest::add("version and backup names record the version number and UTC time", function() {
  $time = gmmktime(9, 48, 3, 2, 6, 2021);
  $name = VersionHistory::formatName("currentVersion", 22, $time);
  assertSame("currentVersion00022-2021-02-06-09-48-03", $name);
  assertSame(array("version" => 22, "time" => $time), VersionHistory::parseName("currentVersion", $name));
  assertSame(array("version" => 123456, "time" => $time),
    VersionHistory::parseName("backup", VersionHistory::formatName("backup", 123456, $time)));
  assertSame(null, VersionHistory::parseName("backup", $name));
  assertSame(null, VersionHistory::parseName("backup", "backup00001-2021-02-06"));
  assertSame(null, VersionHistory::parseName("backup", "backup00001-2021-02-06-09-48-03/../x"));
  assertSame(null, VersionHistory::parseName("backup", null));
});

UmpleTest::add("a model starts at version 0 without creating any history", function() {
  list($history, $dir) = newHistory(array("model.ump" => umpleText("class A {}")));
  assertSame(0, $history->getCurrentVersion());
  assertSame(array("version" => 0, "savedAt" => null), $history->describeCurrentVersion());
  assertSame(array("version" => 0, "changed" => false), $history->writeFile("model.ump", umpleText("class A {}")));
  assertFalse(file_exists($dir."/versionHistory"));
});

UmpleTest::add("each change to a file is recorded as a new version", function() {
  list($history, $dir, $clock) = newHistory();
  assertSame(array("version" => 1, "changed" => true), $history->writeFile("A.ump", umpleText("class A {}")));
  $clock->advance(10);
  assertSame(array("version" => 2, "changed" => true), $history->writeFile("A.ump", umpleText("class A { name; }")));
  $clock->advance(10);
  assertSame(array("version" => 2, "changed" => false), $history->writeFile("A.ump", umpleText("class A { name; }")));
  assertSame(umpleText("class A { name; }"), file_get_contents($dir."/A.ump"));

  $markers = array_values(preg_grep('/^currentVersion/', scandir($dir."/versionHistory")));
  assertSame(array("currentVersion00002-2026-10-04-09-00-10"), $markers);
  assertSame(array("version" => 2, "savedAt" => testStartTime() + 10), $history->describeCurrentVersion());
});

UmpleTest::add("saves that only change whitespace at the end of the model are not new versions", function() {
  list($history, $dir) = newHistory();
  $delimiter = VersionHistory::MODEL_DELIMITER;
  $layout = "namespace -;\nclass A { position 1 2 3 4; }";
  $history->writeFile("A.ump", "class A {}\n".$delimiter."\n\n".$layout);

  // As when the model is loaded again, which adds a line break before the layout
  $reloaded = "class A {}\n\n".$delimiter."\n".$layout."\n";
  assertSame(array("version" => 1, "changed" => false), $history->writeFile("A.ump", $reloaded));
  assertSame($reloaded, file_get_contents($dir."/A.ump"), "the file is still saved");

  assertSame(array("version" => 2, "changed" => true), $history->writeFile("A.ump", "class  A {}\n".$delimiter."\n".$layout));
  assertSame(array("version" => 3, "changed" => true),
    $history->writeFile("A.ump", "class  A {}\n".$delimiter."\nnamespace -;\nclass A { position 5 6 7 8; }"));
  assertSame(array("version" => 4, "changed" => true), $history->writeFile("A.ump", "class  A {}\n"));
  assertSame(array("version" => 5, "changed" => true), $history->writeFile("A.ump", "\nclass  A {}\n"));
  assertSame(array("version" => 5, "changed" => false), $history->writeFile("A.ump", "\nclass  A {}  \n \n"));

  assertTrue(VersionHistory::sameFiles(array("A.ump" => "a\n", "tab_index" => "A"), array("A.ump" => "a", "tab_index" => "A\n")));
  assertFalse(VersionHistory::sameFiles(array("A.ump" => "a"), array("A.ump" => "a", "B.ump" => "")));
  assertFalse(VersionHistory::sameFiles(array("A.ump" => "a", "C.ump" => ""), array("A.ump" => "a", "B.ump" => "")));
});

UmpleTest::add("a backup differing from the latest only in whitespace at the end is not made", function() {
  list($history, $dir, $clock) = newHistory(array("A.ump" => umpleText("class A {}")));
  $first = $history->createBackup("auto");
  file_put_contents($dir."/A.ump", "class A {}\n\n\n".VersionHistory::MODEL_DELIMITER."\nnamespace -;\n\n");
  $clock->advance(300);
  assertSame($first["id"], $history->createBackup("auto")["id"]);
});

UmpleTest::add("the current version is the highest even if several markers exist", function() {
  list($history, $dir, $clock) = newHistory();
  mkdir($dir."/versionHistory");
  touch($dir."/versionHistory/currentVersion00003-2026-10-04-08-00-00");
  touch($dir."/versionHistory/currentVersion00007-2026-10-04-08-30-00");
  assertSame(7, $history->getCurrentVersion());
  $history->writeFile("A.ump", umpleText("class A {}"));
  $markers = array_values(preg_grep('/^currentVersion/', scandir($dir."/versionHistory")));
  assertSame(array("currentVersion00008-2026-10-04-09-00-00"), $markers);
});

UmpleTest::add("the model as first loaded is backed up before it is first changed", function() {
  list($history) = newHistory(array("model.ump" => umpleText("class Loaded {}")));
  $history->writeFile("Loaded.ump", umpleText("class Loaded { more; }"));
  $backups = $history->describeBackups();
  assertSame(1, count($backups));
  assertSame("initial", $backups[0]["reason"]);
  assertSame(0, $backups[0]["version"]);
  assertSame(testStartTime(), $backups[0]["savedAt"]);
  assertSame(array("model.ump"), $backups[0]["files"]);
  assertSame(array(array("name" => "model.ump", "content" => umpleText("class Loaded {}"))),
    $history->getBackupFiles($backups[0]["id"]));
});

UmpleTest::add("a model with nothing in it is not backed up", function() {
  list($history) = newHistory(array("model.ump" => "\n".VersionHistory::MODEL_DELIMITER."\nnamespace -;\n"));
  $history->writeFile("Untitled.ump", "  \n".VersionHistory::MODEL_DELIMITER);
  assertSame(array(), $history->listBackups());
  assertSame(null, $history->createBackup("auto"));
  $history->writeFile("Untitled.ump", umpleText("class First {}"));
  assertSame(array(), $history->listBackups());
  $history->writeFile("Untitled.ump", umpleText("class Second {}"));
  $backups = $history->describeBackups();
  assertSame(1, count($backups));
  assertSame(2, $backups[0]["version"]);
  assertSame("initial", $backups[0]["reason"]);
});

UmpleTest::add("backups are made after at least 5 changes and at least 2 minutes", function() {
  list($history, $dir, $clock) = newHistory(array("A.ump" => umpleText("class A {}")));
  $history->writeFile("A.ump", umpleText("class A { a1; }"));
  assertSame(1, count($history->listBackups()));

  // Many changes, but within 2 minutes of the initial backup
  for ($i = 2; $i <= 8; $i++) {
    $clock->advance(10);
    $history->writeFile("A.ump", umpleText("class A { a$i; }"));
  }
  assertSame(1, count($history->listBackups()));

  $clock->advance(60);
  $history->writeFile("A.ump", umpleText("class A { a9; }"));
  $backups = $history->listBackups();
  assertSame(2, count($backups));
  assertSame(9, $backups[0]["version"]);
  assertSame(testStartTime() + 130, $backups[0]["time"]);
  $description = $history->describeBackup($backups[0]);
  assertSame("auto", $description["reason"]);
  assertSame(umpleText("class A { a9; }"), $history->getBackupFiles($backups[0]["id"])[0]["content"]);

  // Plenty of time, but only 4 changes
  for ($i = 10; $i <= 13; $i++) {
    $clock->advance(200);
    $history->writeFile("A.ump", umpleText("class A { a$i; }"));
  }
  assertSame(2, count($history->listBackups()));

  $clock->advance(200);
  $history->writeFile("A.ump", umpleText("class A { a14; }"));
  assertSame(3, count($history->listBackups()));
  $latest = $history->getLatestBackup();
  assertSame(14, $latest["version"]);
});

UmpleTest::add("a backup identical to the latest one is not repeated, and unchanged files are shared", function() {
  list($history, $dir, $clock) = newHistory(array(
    "A.ump" => umpleText("class A {}"),
    "B.ump" => umpleText("class B {}")));
  $first = $history->createBackup("auto");
  $clock->advance(300);
  $again = $history->createBackup("auto");
  assertSame($first["id"], $again["id"]);
  assertSame(1, count($history->listBackups()));

  file_put_contents($dir."/A.ump", umpleText("class A { x; }"));
  $clock->advance(300);
  $second = $history->createBackup("auto");
  assertTrue($second["id"] !== $first["id"]);
  assertSame(2, count($history->listBackups()));
  assertSame(fileinode($first["path"]."/B.ump"), fileinode($second["path"]."/B.ump"), "unchanged tab should be a hard link");
  assertTrue(fileinode($first["path"]."/A.ump") !== fileinode($second["path"]."/A.ump"), "changed tab should be a new file");
  assertSame(umpleText("class A {}"), file_get_contents($first["path"]."/A.ump"));
  assertSame(umpleText("class A { x; }"), file_get_contents($second["path"]."/A.ump"));
});

UmpleTest::add("a change from a tab showing an out-of-date version first backs up the newer version", function() {
  list($history, $dir, $clock) = newHistory(array("A.ump" => umpleText("class A {}")));
  $history->writeFile("A.ump", umpleText("class A { fromWindow1; }"), 0);
  $clock->advance(5);
  $history->writeFile("A.ump", umpleText("class A { fromWindow1Again; }"), 1);
  assertSame(1, count($history->listBackups()), "only the initial backup");
  assertSame(null, $history->getReplacedBackup());

  $clock->advance(5);
  $result = $history->writeFile("A.ump", umpleText("class A { fromStaleWindow2; }"), 0);
  assertSame(array("version" => 3, "changed" => true), $result);
  $latest = $history->describeBackup($history->getLatestBackup());
  assertSame("conflict", $latest["reason"]);
  assertSame(2, $latest["version"]);
  assertSame(0, $latest["staleVersion"]);
  assertSame(umpleText("class A { fromWindow1Again; }"), $history->getBackupFiles($latest["id"])[0]["content"]);
  assertSame($latest["id"], $history->getReplacedBackup()["id"]);

  // Saves that change nothing replace nothing, even from an out-of-date window
  $history->writeFile("A.ump", umpleText("class A { fromStaleWindow2; }"), 0);
  assertSame(null, $history->getReplacedBackup());

  // Saves that do not say which version they are based on are not treated as conflicts
  $clock->advance(5);
  $history->writeFile("A.ump", umpleText("class A { other; }"));
  assertSame(2, count($history->listBackups()));
  assertSame(null, $history->getReplacedBackup());
});

UmpleTest::add("the first backup of a model is the replaced version if the change was out of date", function() {
  list($history, $dir) = newHistory();
  $history->writeFile("A.ump", "");
  $history->writeFile("A.ump", umpleText("class A {}"), 1);
  assertSame(0, count($history->listBackups()), "the model was empty, so nothing was backed up");

  $history->writeFile("A.ump", umpleText("class B {}"), 1);
  $replaced = $history->getReplacedBackup();
  assertSame("initial", $history->describeBackup($replaced)["reason"]);
  assertSame(2, $replaced["version"]);
  assertSame(umpleText("class A {}"), file_get_contents($replaced["path"]."/A.ump"));
});

UmpleTest::add("model.ump gets the text of the only tab, since it is what is shown when the model is loaded", function() {
  list($history, $dir) = newHistory(array("model.ump" => umpleText("class New {}")));
  $history->updateMainFileFromOnlyTab();
  assertSame(umpleText("class New {}"), file_get_contents($dir."/model.ump"), "a new model has no tabs yet");

  $history->writeFile("Student.ump", umpleText("class Student {}"));
  assertSame(umpleText("class New {}"), file_get_contents($dir."/model.ump"),
    "saving a tab leaves model.ump alone, since the page may be about to load it");
  $history->updateMainFileFromOnlyTab();
  assertSame(umpleText("class Student {}"), file_get_contents($dir."/model.ump"));
  assertSame(1, $history->getCurrentVersion(), "this is not a change to the model");

  // With several tabs, model.ump is the compiler's copy of whichever tab is selected
  $history->writeFile("Course.ump", umpleText("class Course {}"));
  $history->updateMainFileFromOnlyTab();
  assertSame(umpleText("class Student {}"), file_get_contents($dir."/model.ump"));
});

UmpleTest::add("restoring a backup replaces all of the model's files, and can itself be undone", function() {
  list($history, $dir, $clock) = newHistory(array(
    "model.ump" => umpleText("class B {}"),
    "A.ump" => umpleText("class A {}"),
    "B.ump" => umpleText("class B {}")));
  $original = $history->createBackup("auto");
  $clock->advance(60);
  $history->writeFile("A.ump", umpleText("class A { changed; }"));
  $history->recordChange(function() use ($dir) { unlink($dir."/B.ump"); });
  $history->writeFile("C.ump", umpleText("class C {}"));
  $before = $history->getCurrentVersion();
  assertSame(3, $before);
  $clock->advance(60);

  $result = $history->restoreBackup($original["id"]);

  assertSame(4, $result["version"]);
  assertSame(4, $history->getCurrentVersion());
  assertSame(0, $result["restoredVersion"]);
  assertSame("B.ump", $result["shownFile"]);
  assertSame(umpleText("class B {}"), $result["shownContent"]);
  assertSame(array("A.ump", "B.ump"), VersionHistory::modelFileNames($dir));
  assertSame(umpleText("class A {}"), file_get_contents($dir."/A.ump"));
  assertSame(umpleText("class B {}"), file_get_contents($dir."/B.ump"));
  assertSame(umpleText("class B {}"), file_get_contents($dir."/model.ump"));

  assertSame(3, $result["savedVersion"]);
  $saved = $history->describeBackup($history->findBackup($result["savedId"]));
  assertSame("beforeRestore", $saved["reason"]);
  assertSame(3, $saved["version"]);
  assertSame(0, $saved["restoredVersion"]);
  assertSame(array("A.ump", "C.ump"), $saved["files"]);

  $clock->advance(60);
  $undo = $history->restoreBackup($result["savedId"]);
  assertSame(5, $undo["version"]);
  assertSame("C.ump", $undo["shownFile"]);
  assertSame(array("A.ump", "C.ump"), VersionHistory::modelFileNames($dir));
  assertSame(umpleText("class A { changed; }"), file_get_contents($dir."/A.ump"));
  assertSame(umpleText("class C {}"), file_get_contents($dir."/model.ump"));
});

UmpleTest::add("restoring a backup made before any tab was saved removes the tab files", function() {
  list($history, $dir, $clock) = newHistory(array("model.ump" => umpleText("class Loaded {}")));
  $history->writeFile("Loaded.ump", umpleText("class Loaded { more; }"));
  $initial = $history->getLatestBackup();
  $clock->advance(60);
  $result = $history->restoreBackup($initial["id"]);
  assertSame("model.ump", $result["shownFile"]);
  assertSame(umpleText("class Loaded {}"), $result["shownContent"]);
  assertFalse(file_exists($dir."/Loaded.ump"));
  assertSame(array("model.ump"), VersionHistory::modelFileNames($dir));
  assertSame(umpleText("class Loaded {}"), file_get_contents($dir."/model.ump"));
});

UmpleTest::add("unknown or malformed backup ids are rejected", function() {
  list($history, $dir) = newHistory(array("A.ump" => umpleText("class A {}")));
  $backup = $history->createBackup("auto");
  $ids = array("backup00009-2026-10-04-09-00-00", "../A.ump", $backup["id"]."/../../A.ump",
    "versionHistory", "", null, array($backup["id"]));
  foreach ($ids as $id) {
    assertSame(null, $history->findBackup($id));
    assertSame(null, $history->getBackupFiles($id));
    assertSame(null, $history->restoreBackup($id));
  }
  assertSame(0, $history->getCurrentVersion());
  assertSame(umpleText("class A {}"), file_get_contents($dir."/A.ump"));
});

UmpleTest::add("partly written backups and stray files are never listed", function() {
  list($history, $dir) = newHistory(array("A.ump" => umpleText("class A {}")));
  mkdir($dir."/versionHistory");
  mkdir($dir."/versionHistory/.incomplete-backup00001-2026-10-04-09-00-00");
  file_put_contents($dir."/versionHistory/backup00002-2026-10-04-09-00-00", "a file, not a backup");
  mkdir($dir."/versionHistory/backupFolder");
  assertSame(array(), $history->listBackups());
  assertSame(null, $history->getLatestBackup());
});

UmpleTest::add("tabs are kept in tab_index order, with the last one shown after restoring", function() {
  $files = array("A.ump" => "a", "B.ump" => "b", "C.ump" => "c", "tab_index" => "C\nA\nMissing\nA\r\nB\n");
  assertSame(array("C.ump", "A.ump", "B.ump"), VersionHistory::displayOrder($files));
  assertSame(array("A.ump", "B.ump"), VersionHistory::displayOrder(array("B.ump" => "", "model.ump" => "", "A.ump" => "")));
  assertSame(array("model.ump"), VersionHistory::displayOrder(array("model.ump" => "")));
  assertSame(array(), VersionHistory::displayOrder(array()));

  list($history, $dir, $clock) = newHistory(array(
    "A.ump" => umpleText("class A {}"),
    "B.ump" => umpleText("class B {}"),
    "tab_index" => "B\nA\n"));
  $backup = $history->createBackup("auto");
  $description = $history->describeBackup($backup);
  assertSame(array("B.ump", "A.ump"), $description["files"]);
  assertSame(array("B.ump", "A.ump"), array_column($history->getBackupFiles($backup["id"]), "name"));

  unlink($dir."/tab_index");
  file_put_contents($dir."/A.ump", umpleText("class A { changed; }"));
  $clock->advance(60);
  $result = $history->restoreBackup($backup["id"]);
  assertSame("A.ump", $result["shownFile"]);
  assertSame("B\nA\n", file_get_contents($dir."/tab_index"));
  assertSame(umpleText("class A {}"), file_get_contents($dir."/model.ump"));
});

UmpleTest::add("model.ump only counts as part of the model before any tab is saved", function() {
  $dir = makeTemporaryDirectory();
  assertSame(array(), VersionHistory::modelFileNames($dir));
  assertSame(array(), VersionHistory::modelFileNames($dir."/missing"));
  file_put_contents($dir."/model.ump", "x");
  file_put_contents($dir."/.ump", "not a tab");
  assertSame(array("model.ump"), VersionHistory::modelFileNames($dir));
  file_put_contents($dir."/Tab.ump", "y");
  file_put_contents($dir."/Another.ump", "y");
  file_put_contents($dir."/notes.txt", "z");
  mkdir($dir."/Folder.ump");
  assertSame(array("Another.ump", "Tab.ump"), VersionHistory::modelFileNames($dir));
  file_put_contents($dir."/tab_index", "Tab\nAnother\n");
  assertSame(array("Another.ump" => "y", "Tab.ump" => "y", "tab_index" => "Tab\nAnother\n"), VersionHistory::readFiles($dir));
  assertSame(array("Tab.ump", "Another.ump"), VersionHistory::fileNamesInDisplayOrder($dir));
});

UmpleTest::add("a model is empty if nothing but whitespace precedes the layout", function() {
  assertTrue(VersionHistory::isEmptyModel(array()));
  assertTrue(VersionHistory::isEmptyModel(array("tab_index" => "A")));
  assertTrue(VersionHistory::isEmptyModel(array("A.ump" => " \n\t".VersionHistory::MODEL_DELIMITER."\nclass A { position 1 2 3 4; }")));
  assertTrue(VersionHistory::isEmptyModel(array("A.ump" => "", "B.ump" => "\n")));
  assertFalse(VersionHistory::isEmptyModel(array("A.ump" => "", "B.ump" => "class B {}")));
  assertFalse(VersionHistory::isEmptyModel(array("A.ump" => "// just a comment\n".VersionHistory::MODEL_DELIMITER)));
});

UmpleTest::add("backups less than 30 minutes old are never thinned", function() {
  $now = gmmktime(12, 0, 0, 6, 15, 2026);
  $backups = array();
  for ($i = 0; $i < 30; $i++) $backups[] = backupAt($i, $now - 1799 + $i * 60);
  assertSame(array(), VersionHistory::selectBackupsToDelete($backups, $now));
});

UmpleTest::add("older backups are thinned to one per 5 minutes, 10 minutes, half hour, day and month", function() {
  $now = gmmktime(12, 0, 0, 6, 15, 2026);
  $backups = array(
    backupAt(100, $now - 60),
    // 30 minutes to 2 hours old: the newest in each 5 minute period
    backupAt(90, gmmktime(11, 21, 0, 6, 15, 2026)),
    backupAt(89, gmmktime(11, 20, 0, 6, 15, 2026)),
    backupAt(88, gmmktime(11, 14, 59, 6, 15, 2026)),
    // 2 to 12 hours old: each 10 minutes
    backupAt(80, gmmktime(8, 5, 0, 6, 15, 2026)),
    backupAt(79, gmmktime(8, 1, 0, 6, 15, 2026)),
    backupAt(78, gmmktime(7, 59, 0, 6, 15, 2026)),
    // 12 hours to 2 days old: each half hour
    backupAt(70, gmmktime(20, 25, 0, 6, 14, 2026)),
    backupAt(69, gmmktime(20, 2, 0, 6, 14, 2026)),
    backupAt(68, gmmktime(19, 59, 0, 6, 14, 2026)),
    // 2 to 30 days old: the last of each day
    backupAt(60, gmmktime(23, 0, 0, 6, 10, 2026)),
    backupAt(59, gmmktime(1, 0, 0, 6, 10, 2026)),
    backupAt(58, gmmktime(23, 0, 0, 6, 9, 2026)),
    // Older: the last of each month
    backupAt(50, gmmktime(10, 0, 0, 4, 28, 2026)),
    backupAt(49, gmmktime(10, 0, 0, 4, 2, 2026)),
    backupAt(48, gmmktime(10, 0, 0, 3, 30, 2026))
  );
  shuffle($backups);
  assertSame(array("b49", "b59", "b69", "b79", "b89"), sortedIds(VersionHistory::selectBackupsToDelete($backups, $now)));
});

UmpleTest::add("thinning periods are aligned to the clock and differ between rules", function() {
  $now = gmmktime(12, 0, 0, 6, 15, 2026);
  assertSame(null, VersionHistory::thinningPeriod($now, $now));
  assertSame(null, VersionHistory::thinningPeriod($now + 600, $now));
  assertSame(null, VersionHistory::thinningPeriod($now - 1799, $now));
  assertTrue(VersionHistory::thinningPeriod($now - 1800, $now) !== null);
  assertSame(VersionHistory::thinningPeriod(gmmktime(11, 20, 0, 6, 15, 2026), $now),
    VersionHistory::thinningPeriod(gmmktime(11, 24, 59, 6, 15, 2026), $now));
  assertSame("4:2026-06-10", VersionHistory::thinningPeriod(gmmktime(1, 0, 0, 6, 10, 2026), $now));
  assertSame("5:2025-12", VersionHistory::thinningPeriod(gmmktime(1, 0, 0, 12, 31, 2025), $now));
});

UmpleTest::add("the newest backup is always kept, and at most MAX_BACKUPS", function() {
  $now = gmmktime(12, 0, 0, 6, 15, 2026);
  $deleted = VersionHistory::selectBackupsToDelete(array(
    backupAt(1, gmmktime(10, 0, 0, 1, 10, 2026)),
    backupAt(2, gmmktime(10, 0, 0, 1, 20, 2026))), $now);
  assertSame(array("b1"), sortedIds($deleted));

  $backups = array();
  $count = VersionHistory::MAX_BACKUPS + 5;
  for ($i = 0; $i < $count; $i++) $backups[] = backupAt($i, $now - ($count - $i));
  $deleted = VersionHistory::selectBackupsToDelete($backups, $now);
  assertSame(array("b0", "b1", "b2", "b3", "b4"), sortedIds($deleted));
});

UmpleTest::add("thinning deletes old backups from disk when a new backup is made", function() {
  list($history, $dir, $clock) = newHistory(array("A.ump" => umpleText("class A { v0; }")));
  // A backup every 3 minutes for an hour, from 9:00 to 10:00
  for ($i = 1; $i <= 20; $i++) {
    $history->createBackup("auto");
    $clock->advance(180);
    file_put_contents($dir."/A.ump", umpleText("class A { v$i; }"));
  }
  $history->createBackup("auto");

  $times = array_map(function($backup) { return gmdate("H:i", $backup["time"]); }, $history->listBackups());
  assertSame(array(
    "10:00", "09:57", "09:54", "09:51", "09:48", "09:45", "09:42", "09:39", "09:36", "09:33",
    "09:30", "09:27", "09:24", "09:18", "09:12", "09:09", "09:03"), $times);
  $directories = preg_grep('/^backup/', scandir($dir."/versionHistory"));
  assertSame(17, count($directories));
});

UmpleTest::add("a bookmark takes over the history of the model it was made from, and a fork gets a copy", function() {
  list($history, $dir, $clock) = newHistory(array("A.ump" => umpleText("class A {}")));
  $history->writeFile("A.ump", umpleText("class A { x; }"));

  $fork = makeTemporaryDirectory();
  $history->transferHistoryTo($fork, false);
  assertTrue(is_dir($dir."/versionHistory"));
  $forkHistory = new VersionHistory($fork, $clock);
  assertSame(1, $forkHistory->getCurrentVersion());
  assertSame(1, count($forkHistory->listBackups()));

  // The copies are independent
  file_put_contents($fork."/A.ump", umpleText("class A { forked; }"));
  $forkHistory->writeFile("A.ump", umpleText("class A { forked again; }"));
  assertSame(1, $history->getCurrentVersion());

  $bookmark = makeTemporaryDirectory();
  $history->transferHistoryTo($bookmark, true);
  assertFalse(file_exists($dir."/versionHistory"));
  $bookmarkHistory = new VersionHistory($bookmark, $clock);
  assertSame(1, $bookmarkHistory->getCurrentVersion());
  assertSame(1, count($bookmarkHistory->listBackups()));

  // Nothing to transfer, and an existing history is never overwritten
  $empty = makeTemporaryDirectory();
  $history->transferHistoryTo($empty, true);
  assertFalse(file_exists($empty."/versionHistory"));
  $bookmarkHistory->transferHistoryTo($fork, true);
  assertSame(2, $forkHistory->getCurrentVersion());
  assertTrue(is_dir($bookmark."/versionHistory"));
});

UmpleTest::add("the user's change is still saved if no history can be kept", function() {
  list($history, $dir) = newHistory(array("A.ump" => umpleText("class A {}")));
  file_put_contents($dir."/versionHistory", "a file where the history directory should be");
  $result = $history->writeFile("A.ump", umpleText("class A { saved; }"));
  assertTrue($result["changed"]);
  assertSame(umpleText("class A { saved; }"), file_get_contents($dir."/A.ump"));
  assertSame(array(), $history->listBackups());
});

UmpleTest::add("withLock returns the result of the action while holding the model's lock file", function() {
  list($history, $dir) = newHistory();
  assertSame(42, $history->withLock(function() use ($dir) {
    $other = fopen($dir."/.lockfile", "c");
    $gotLock = flock($other, LOCK_EX | LOCK_NB);
    fclose($other);
    assertFalse($gotLock, "the lock should be held");
    return 42;
  }));
  $other = fopen($dir."/.lockfile", "c");
  assertTrue(flock($other, LOCK_EX | LOCK_NB), "the lock should be released");
  fclose($other);
});
