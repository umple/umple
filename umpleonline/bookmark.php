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

if (!is_file($filename))
{
  header('HTTP/1.0 404 Not Found');
  readfile('../404.shtml');
  exit();
}

rename("ump/{$tempModelId}/model.ump","{$savedModel}");

// Empty anything else in directory and remove it
recursiveDelete("ump/{$tempModelId}");

header("Location: umple.php?model={$saveModelId}");
