<?php
require_once ("scripts/compiler_config.php");

// if (!isset($_REQUEST["model"]) || !isset($_REQUEST["taskName"]) || !isset($_REQUEST["instructions"]))
// {
//   header('HTTP/1.0 404 Not Found');
//   readfile('../404.shtml');
//   exit();
// }

if (isset($_REQUEST["submitTaskWork"]))
{
  $tempModelId = $_REQUEST["model"];
  $tempModelData = dataStore()->openData($tempModelId);
  $tempModelData->writeData("submitted.md", " ");
  foreach (new DirectoryIterator("ump/tasks") as $file) 
  {
    if ($file->isDot()) continue;

    if ($file->isDir() && substr($file->getFilename(), 0, 8) == "taskroot") 
    {
      $taskName = explode("-", $file->getFilename())[1];
        if ($taskName == explode("-", $_REQUEST["model"])[1])
        {
          $dataHandle = dataStore()->openData("tasks/" . $file->getFilename());
          $taskdetails = $dataHandle->readData("taskdetails.json");
          $json = json_decode($taskdetails, true);
          file_put_contents("/home/jpan/test.html", $json["completionURL"], FILE_APPEND);
          echo $json["completionURL"];
          break;
        }
    }
  }
  exit();
}

if (isset($_REQUEST["cancelTaskResponse"]))
{
  $tempModelId = $_REQUEST["model"];
  $tempModelData = dataStore()->openData($tempModelId);
  $tempModelData->delete();
  header("Location: umple.php");
  exit();
}
// The following creates a random numbered directory in ump
// the result is ump/{dir}/model.ump
date_default_timezone_set('UTC');
if (isset($_REQUEST["edit"]))
{
  $tempModelId = $_REQUEST["model"];
  $editModelData = dataStore()->openData("tasks/" . $tempModelId);
  $editModelData->writeData("instructions.md", $_REQUEST["instructions"]);
  $json = json_decode($editModelData->readData("taskdetails.json"), true);
  // file_put_contents("/home/jpan/test.html", strval($json), FILE_APPEND);
  // exit();
  $json["requestorName"] = $_REQUEST["requestorName"];
  $editModelData->writeData("taskdetails.json", json_encode($json));
  //$editModelData->writeData("taskdetails.json", "{\"requestorName\" : \"" . $_REQUEST["requestorName"] . "\", \"taskName\" : \"" . $_REQUEST["taskName"] . "\"}");
  //header("Location: umple.php?task=1&model={$tempModelId}");
}
else
{
  //file_put_contents("/home/jpan/test.html", "7777777777", FILE_APPEND);
  foreach (new DirectoryIterator("ump/tasks") as $file) 
  {
    if ($file->isDot()) continue;

    if ($file->isDir() && substr($file->getFilename(), 0, 8) == "taskroot") 
    {
      $taskName = explode("-", $file->getFilename())[1];
      if ($taskName == strtolower($_REQUEST["taskName"])) // task name already existed
      {
        echo "Task name '" . $_REQUEST["taskName"] . "' already exists";
        //file_put_contents("/home/jpan/test.html", "7777777777", FILE_APPEND);
        exit();
      }
    }
  }
  $tempModelId = $_REQUEST["model"];
  $savedModelData = dataStore()->createData("tasks/taskroot-" . strtolower($_REQUEST["taskName"]) . "-" . date("ymd"));
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
  $savedModelData->writeData("taskdetails.json", "{\"requestorName\" : \"" . $_REQUEST["requestorName"] . "\", \"taskName\" : \"" . $_REQUEST["taskName"] . "\", \"completionURL\": \"" . $_REQUEST["completionURL"] . "\"}");

  // Empty anything else in directory and remove it
  $tempModelData->delete();

  echo $saveModelId;
  //header("Location: umple.php?task=1&model={$saveModelId}");
}
//header("Location: umple.php");
