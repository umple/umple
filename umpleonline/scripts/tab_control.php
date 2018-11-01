<?php
/* 
Tab control handlers.
*/

header("Access-Control-Allow-Origin: *");

if (isset($_REQUEST["list"]) && isset($_REQUEST["model"]))
{
    $model = $_REQUEST["model"];
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
    $model = $_REQUEST["model"];
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
    $filename = "../ump/".$_REQUEST["model"]."/".$_REQUEST["name"].".ump";

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
    $model = $_REQUEST["model"];
    $zip_file_name = "umplefiles.zip";
    $zip_file = "../ump/".$model."/".$zip_file_name;
    if (file_exists($zip_file)) {
        unlink($zip_file);
    }
    // TODO: use code below after validation
    exec("cd ../ump/".$model." && zip ".$zip_file_name." *.ump -x model.ump");
    header('Content-disposition: attachment; filename='.$zip_file_name);
    header('Content-type: application/zip');
    readfile($zip_file);

    /*
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
   } else {
        header('HTTP/1.0 404 Not Found');
        readfile('../404.shtml');
        exit();
   }*/
}
else if (isset($_REQUEST["index"]) && isset($_REQUEST["model"]))
{
    $model = $_REQUEST["model"];
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
    file_put_contents($index_file, implode("\n", $index_contents));
}
else {
    header('HTTP/1.0 404 Not Found');
    readfile('../404.shtml');
    exit();
}

?>
