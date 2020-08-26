<?php
/* 
Tab control handlers.
*/

header("Access-Control-Allow-Origin: *");
if(isset($_REQUEST["model"]))
{
    $modelId = $_REQUEST["model"];
    if (substr($modelId, 0, 8) == "taskroot")
    {
        $modelId = "tasks/" . $modelId;
    }
}

if (isset($_REQUEST["list"]) && isset($_REQUEST["model"]))
{
    $model = $modelId;

    // Try to obtain the lock, but we don't actually need to block on the load operation
    $lock_file = "../ump/".$model."/.lockfile";
    $fp = fopen($lock_file, "w");
    if (flock($fp, LOCK_EX)) {
        flock($fp, LOCK_UN);
    }

    $index_file_name = "tab_index";
    $index_file = "../ump/".$model."/".$index_file_name;
    $delim = "%NAME:CONTENT:DELIM%";
    // Index file should not be mandatory
    if (file_exists($index_file))
    {
        $contents = file($index_file, FILE_IGNORE_NEW_LINES);
        foreach($contents as $base) {
            $filename = "../ump/".$model."/".$base.".ump";
            if (file_exists($filename))
            {
                $contents = file_get_contents($filename);
                echo $base.$delim.$contents."<br />";
            }
        }
    }
    else
    {
        foreach (glob("../ump/".$model."/*.ump") as $filename) {
            $base = basename($filename, ".ump");
            $contents = file_get_contents($filename);
            echo $base.$delim.$contents."<br />";
        }
    }
}
else if (isset($_REQUEST["rename"]) &&
    isset($_REQUEST["model"]) &&
    isset($_REQUEST["oldname"]) &&
    isset($_REQUEST["newname"]))
{
    $model = $modelId;
    $oldfilename = "../ump/".$model."/".$_REQUEST["oldname"].".ump";
    $newfilename = "../ump/".$model."/".$_REQUEST["newname"].".ump";

    if (!file_exists($oldfilename) || file_exists($newfilename) || $oldfilename == $newfilename) {
        header('HTTP/1.0 404 Not Found');
        readfile('../404.shtml');
        exit();
    }

    rename($oldfilename, $newfilename);
    echo $newfilename;
}
else if (isset($_REQUEST["delete"]) &&
    isset($_REQUEST["model"]) &&
    isset($_REQUEST["name"]))
{
    $filename = "../ump/".$modelId."/".$_REQUEST["name"].".ump";

    // Do not allow deletion of model.ump
    if (!file_exists($filename) || $_REQUEST["name"] == "model") {
        header('HTTP/1.0 404 Not Found');
        readfile('../404.shtml');
        exit();
    }

    unlink($filename);
    echo $filename;
}
else if (isset($_REQUEST["download"]) && isset($_REQUEST["model"]))
{
    $model = $modelId;
    $zip_file_name = "umplefiles.zip";
    $zip_file = "../ump/".$model."/".$zip_file_name;
    if (file_exists($zip_file)) {
        unlink($zip_file);
    }

    // Try to obtain the lock
    $lock_file = "../ump/".$model."/.lockfile";
    $fp = fopen($lock_file, "w");
    if (flock($fp, LOCK_EX)) {
        try {
            $zip = new ZipArchive;
            if ($zip->open($zip_file,  ZipArchive::CREATE)) {
                foreach (glob("../ump/".$model."/*.ump") as $filename) {
                    if (basename($filename, ".ump") == "model") continue;
                    $zip->addFile($filename, basename($filename));
                }
                $zip->close();
                header('Content-disposition: attachment; filename='.$zip_file_name);
                header('Content-type: application/zip');
                readfile($zip_file);
            }
        } catch (Exception $e) {
            // Nothing to do here for now
        } finally {
            // Make sure we release the lock
            flock($fp, LOCK_UN);
        }
    }
}
else if (isset($_REQUEST["downloadTaskUserDir"]) && isset($_REQUEST["taskid"]))
{
  //file_put_contents("/home/jpan/test.html", "000000000000", FILE_APPEND);
  $taskId = $_REQUEST["taskid"];
  $zip_file_name = "umplefiles.zip";
  $zip_file = "../ump/tasks/" . $taskId . "/" . $zip_file_name;

  if (file_exists($zip_file)) 
  {
      unlink($zip_file);
  }

  // Try to obtain the lock
  $lock_file = "../ump/tasks/".$taskId."/.lockfile";
  $fp = fopen($lock_file, "w");
  if (flock($fp, LOCK_EX)) 
  {
    //file_put_contents("/home/jpan/test.html", "11111111111111", FILE_APPEND);
    try 
    {
      $zip = new ZipArchive; 
      if($zip -> open($zip_file, ZipArchive::CREATE)) 
      {
        foreach (new DirectoryIterator("../ump") as $file) 
        {
          if ($file->isDot()) continue;

          if ($file->isDir() && sizeof(explode("-", $file->getFilename())) > 1 && explode("-", $file->getFilename())[1] == explode("-", $taskId)[1])
          {
            //file_put_contents("/home/jpan/test.html", $pathdir . "/////////", FILE_APPEND);
            $pathdir = $file->getFilename();
            
            //$zip->addEmptyDir($pathdir);
            foreach (glob("../ump/".$pathdir."/*.ump") as $filename) {
                if (basename($filename, ".ump") == "model") continue;
                $zip->addFile($filename, $pathdir . "/" . basename($filename));
            }

            // $dir = opendir($pathdir); 
               
            // while($file2 = readdir($dir)) 
            // {
            //     file_put_contents("/home/jpan/test.html", $file2->getFilename() . "8888", FILE_APPEND);
            //   if(is_file($pathdir.$file2) && substr($file2->getFilename(), -4) == ".ump" && basename($file2->getFilename(), ".ump") != "model") 
            //   { 
            //     file_put_contents("/home/jpan/test.html", "5555555555/////////", FILE_APPEND);
            //       $zip -> addFile($pathdir.$file2, $file2); 
            //   } 
            // }          
          }
        }
          if ($zip->close() === false) 
            {
                //file_put_contents("/home/jpan/test.html", "ERROR////", FILE_APPEND);
            }
          header('Content-disposition: attachment; filename='.$zip_file_name);
          header('Content-type: application/zip');
          readfile($zip_file);
      }
    } catch (Exception $e) {
      // Nothing to do here for now
    } finally {
      // Make sure we release the lock
      flock($fp, LOCK_UN);
    }
  }
}
else if (isset($_REQUEST["index"]) && isset($_REQUEST["model"]))
{
    $model = $modelId;
 
    // Try to obtain the lock
    $lock_file = "../ump/".$model."/.lockfile";
    $fp = fopen($lock_file, "w");
    if (flock($fp, LOCK_EX)) {
        try {
            $index_file_name = "tab_index";
            $index_file = "../ump/".$model."/".$index_file_name;
            $index_contents = array();
            if (isset($_REQUEST["orderedTabNames"]))
            {
                $index_contents = json_decode($_REQUEST["orderedTabNames"]);
            }
            else
            {
                foreach (glob("../ump/".$model."/*.ump") as $filename) {
                    $index_contents[] = $filename;
                }
            }
        } catch (Exception $e) {
            // Nothing to do here for now
        } finally {
            // Make sure we release the lock
            flock($fp, LOCK_UN);
        }
    }
}
else {
    header('HTTP/1.0 404 Not Found');
    readfile('../404.shtml');
    exit();
}

?>
