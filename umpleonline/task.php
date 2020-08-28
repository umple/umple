<?php
require_once ("scripts/compiler_config.php");

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

          echo $json["completionURL"] . "task submit delimiter" . $json["taskName"] . "task submit delimiter" . $_REQUEST["responseURL"];
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
  $json["requestorName"] = $_REQUEST["requestorName"];
  $json["completionURL"] = $_REQUEST["completionURL"];
  $json["isExperiment"] = $_REQUEST["isExperiment"];
  $editModelData->writeData("taskdetails.json", json_encode($json));
}
else // create task
{
  foreach (new DirectoryIterator("ump/tasks") as $file) 
  {
    if ($file->isDot()) continue;

    if ($file->isDir() && substr($file->getFilename(), 0, 8) == "taskroot") 
    {
      $taskName = explode("-", $file->getFilename())[1];
      if ($taskName == strtolower($_REQUEST["taskName"])) // task name already existed
      {
        echo "Task name '" . $_REQUEST["taskName"] . "' already exists";
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

  $savedModelData->cloneFrom($tempModelData);
  $savedModelData->writeData("instructions.md", $_REQUEST["instructions"]);
  $savedModelData->writeData("taskdetails.json", "{\"requestorName\" : \"" . $_REQUEST["requestorName"] . "\", \n\"taskName\" : \"" . $_REQUEST["taskName"] . "\", \n\"completionURL\": \"" . $_REQUEST["completionURL"] . "\", \n\"isExperiment\" : \"" . $_REQUEST["isExperiment"] . "\"}");

  if ($_REQUEST["isExperiment"] == true)
  {
    $savedModelData->writeData("LogOfCommands.txt", "");
  }

  // Empty anything else in directory and remove it
  $tempModelData->delete();

  echo $saveModelId;
}
