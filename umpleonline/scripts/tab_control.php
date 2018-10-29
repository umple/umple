<?php
/* 
Tab control handlers.
*/

if (isset($_REQUEST["list"]) && isset($_REQUEST["model"]))
{
    $model = $_REQUEST["model"];
    foreach (glob("../ump/".$model."/*.ump") as $filename) {
        echo basename($filename, ".ump")."<br />";
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
    $zip_file = "../ump/".$model."/umplefiles.zip";
    if (file_exists($zip_file)) {
        unlink($zip_file);
    }
    $zip = new ZipArchive;
    if ($zip->open($zip_file,  ZipArchive::CREATE)) {
        foreach (glob("../ump/".$model."/*.ump") as $filename) {
            if (basename($filename, ".ump") == "model") continue;
            $zip->addFile($filename, basename($filename));
        }
        $zip->close();
        header('Content-disposition: attachment; filename=umplefiles.zip');
        header('Content-type: application/zip');
        readfile($zip_file);
   } else {
        header('HTTP/1.0 404 Not Found');
        readfile('../404.shtml');
        exit();
   }
}
else {
    header('HTTP/1.0 404 Not Found');
    readfile('../404.shtml');
    exit();
}

?>
