<?php
require_once ("scripts/compiler_config.php");

if (!isset($_REQUEST["model"]))
{
  echo "No model provided - nothing bookmarked";
  exit;
}

$tempModelId = $_REQUEST["model"];
$savedModel = nextFilename("ump","a");
$saveModelId = extractModelId($savedModel);

$filename = "ump/{$tempModelId}/model.ump";

if (!is_file($filename))
{
  echo "Temporary model {$tempModelId} no longer exist";
  exit;
}

executeCommand("mv ump/{$tempModelId} ump/{$saveModelId}");
header("Location: umple.php?model={$saveModelId}");
