<?php
require_once ("scripts/compiler_config.php");

if (!isset($_REQUEST["model"]) || !isset($_REQUEST["taskName"]) || !isset($_REQUEST["instructions"]))
{
  header('HTTP/1.0 404 Not Found');
  readfile('../404.shtml');
  exit();
}

$tempModelId = $_REQUEST["model"];

// The following creates a random numbered directory in ump
// the result is ump/{dir}/model.ump
date_default_timezone_set('UTC');
$savedModelData = dataStore()->createData("task-" . $_REQUEST["taskName"] . "-" . date("ymd"));
$tempModelData = dataStore()->openData($tempModelId);

$saveModelId = $savedModelData->getName();

// If boomkarking is being attempted by a crawler that has no javascript
// and has just created a model.ump file, then this is an error.
// It is also an error if an attempt is made to later on bookmark some
// file that has long since been deleted
if (!$tempModelData || !$tempModelData->hasData('model.ump'))
{
  header('HTTP/1.0 404 Not Found');
  readfile(rootDir().'/404.shtml');
  if(substr($tempModelId,0,3) == "tmp" && $tempModelData) {
    $tempModelData->delete();
  }
  $savedModelData->delete();
  exit();
}
/*
if (!$tempModelData->hasData('model.ump.erroroutput'))
{
  header('HTTP/1.0 412 Precondition Failed');
  echo "<html><head><title>Javascript Off</title></head><body><p>You cannot make a bookmarked page when JavaScript is turned off. Please turn it on.</p></body></html>";
  if(substr($tempModelId,0,3) == "tmp") {
    $tempModelData->delete();
  }
  $savedModelData->delete();
  exit();
} */

$savedModelData->cloneFrom($tempModelData);
$savedModelData->writeData("instructions.md", $_REQUEST["instructions"]);
$savedModelData->writeData("taskdetails.json", "{\"profName\" : \"Timothy Lethbridge\", \"taskName\" : \"" . $_REQUEST["taskName"] . "\"}");

// Empty anything else in directory and remove it
$tempModelData->delete();

header("Location: umple.php?model={$saveModelId}");

