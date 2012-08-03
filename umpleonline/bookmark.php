<?php
require_once ("scripts/compiler_config.php");

if (!isset($_REQUEST["model"]))
{
  header('HTTP/1.0 404 Not Found');
  readfile('../404.shtml');
  exit();
}

$tempModelId = $_REQUEST["model"];

// The following creates a random numbered directory in ump
// the result is ump/{dir}/model.ump
date_default_timezone_set('UTC');
$savedModel = nextFilename("ump",date("ymd"));

$saveModelId = extractModelId($savedModel);

$filename = "ump/{$tempModelId}/model.ump";

// If boomkarking is being attempted by a crawler that has no javascript
// and has just created a model.ump file, then this is an error.
// It is also an error if an attempt is made to later on bookmark some
// file that has long since been deleted
if (!is_file($filename))
{
  header('HTTP/1.0 404 Not Found');
  readfile('../404.shtml');
  if(substr($tempModelId,0,3) == "tmp") {
    recursiveDelete("ump/{$tempModelId}");
  }
  recursiveDelete("ump/{$saveModelId}");
  exit();
}

if (!is_file("ump/{$tempModelId}/model.ump.erroroutput"))
{
  header('HTTP/1.0 412 Precondition Failed');
  echo "<html><head><title>Javascript Off</title></head><body><p>You cannot make a bookmarked page when JavaScript is turned off. Please turn it on.</p></body></html>";
  if(substr($tempModelId,0,3) == "tmp") {
    recursiveDelete("ump/{$tempModelId}");
  }
  recursiveDelete("ump/{$saveModelId}");
  exit();
}

rename("ump/{$tempModelId}/model.ump","{$savedModel}");

// Empty anything else in directory and remove it
recursiveDelete("ump/{$tempModelId}");

header("Location: umple.php?model={$saveModelId}");
