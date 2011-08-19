<?php
require_once ("scripts/compiler_config.php");

if (!isset($_REQUEST["model"]))
{
  echo "No model provided - nothing bookmarked";
  exit;
}

$tempModel = $_REQUEST["model"];
$savedModel = nextFilename("ump","a");
$filename = "ump/{$tempModel}/model.ump";

if (!is_file($filename))
{
  echo "Temporary model {$tempModel} no longer exist";
  exit;
}

executeCommand("mv ump/{$model} ump/{$savedModel}");
header("Location: /umple.php?model={$savedModel}");
