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
  echo "<html><body>Javascript seems to be off. You cannot save the model.<br> <a href=\"download_eclipse_umple_plugin.html\">Use Umple locally on your machine.</a></body></html>";
  exit;
}

executeCommand("mv ump/{$tempModelId} ump/{$saveModelId}");
header("Location: umple.php?model={$saveModelId}");
