<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Gives umple_version_history.js access to the versions and backups that
// UmpleOnline keeps of each model (see version_history.php). Responses are JSON.
//
//   status=1&model=M              the current version number and when it was saved
//   list=1&model=M                the current version and the backups, newest first
//   files=1&model=M&id=B          the files in backup B, in tab order
//   backup=1&model=M&restoring=B  (POST) back up the model's files now, before
//                                 backup B is restored in the browser
//   backup=1&model=M&staleVersion=V  (POST) back up the model's files now, before
//                                 a tab showing version V overwrites them
//   restore=1&model=M&id=B        (POST) replace the model's files with those in B

require_once("compiler_config.php");

header("Content-Type: application/json; charset=utf-8");
header("Cache-Control: no-store");

function versionControlRespond($status, $data)
{
  http_response_code($status);
  echo json_encode($data);
  exit();
}

$modelId = VersionHistory::normalizeModelId(isset($_REQUEST["model"]) ? $_REQUEST["model"] : null);
if ($modelId === null) {
  versionControlRespond(400, array("error" => "Invalid model"));
}
$dataHandle = dataStore()->openData($modelId);
if (!$dataHandle) {
  versionControlRespond(404, array("error" => "Model not found"));
}
$history = new VersionHistory($dataHandle->getWorkDir()->getPath());
$isPost = $_SERVER["REQUEST_METHOD"] === "POST";
$backupId = isset($_REQUEST["id"]) ? $_REQUEST["id"] : null;

if (isset($_REQUEST["status"]))
{
  versionControlRespond(200, $history->describeCurrentVersion());
}
else if (isset($_REQUEST["list"]))
{
  $result = $history->describeCurrentVersion();
  $result["backups"] = $history->describeBackups();
  versionControlRespond(200, $result);
}
else if (isset($_REQUEST["files"]) && $backupId !== null)
{
  $backup = $history->findBackup($backupId);
  if ($backup === null) {
    versionControlRespond(404, array("error" => "Version not found"));
  }
  versionControlRespond(200, array(
    "backup" => $history->describeBackup($backup),
    "files" => $history->getBackupFiles($backupId)));
}
else if (isset($_REQUEST["backup"]) && $isPost)
{
  $reason = "beforeRestore";
  $info = array();
  if (isset($_REQUEST["restoring"])) {
    $restoring = $history->findBackup($_REQUEST["restoring"]);
    if ($restoring !== null) $info["restoredVersion"] = $restoring["version"];
  } else if (isset($_REQUEST["staleVersion"]) && ctype_digit((string) $_REQUEST["staleVersion"])) {
    $reason = "conflict";
    $info["staleVersion"] = (int) $_REQUEST["staleVersion"];
  }
  $backup = $history->withLock(function() use ($history, $reason, $info) {
    return $history->createBackup($reason, $info);
  });
  $result = $history->describeCurrentVersion();
  $result["backup"] = $backup === null ? null : $history->describeBackup($backup);
  versionControlRespond(200, $result);
}
else if (isset($_REQUEST["restore"]) && $backupId !== null && $isPost)
{
  $result = $history->withLock(function() use ($history, $backupId) {
    return $history->restoreBackup($backupId);
  });
  if ($result === null) {
    versionControlRespond(404, array("error" => "Version not found"));
  }
  VersionHistory::sendVersionHeaders($result["version"], true);
  versionControlRespond(200, $result);
}
else
{
  versionControlRespond(400, array("error" => "Unknown request"));
}
