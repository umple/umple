<?php

require_once("compiler_config.php");

if (isset($_REQUEST["save"]))
{
  $input = $_REQUEST["umpleCode"];
  $filename = saveFile($input);
  echo $filename;
}
else if (isset($_REQUEST["load"]))
{
  $filename = $_REQUEST["filename"];
  $outputUmple = readTemporaryFile($filename);
  echo $outputUmple;
}
else if (isset($_REQUEST["action"]))
{
  handleUmpleTextChange();
}
else if (isset($_REQUEST["umpleCode"]))
{
  $input = $_REQUEST["umpleCode"];
  $language = $_REQUEST["language"];
  
  if ($language == "Simulate")
  {
    $filename = saveFile("generate Php;\n" . $input);
    executeCommand("java -jar umple.jar {$filename}");
    $filename = saveFile("generate Simulate;\n" . $input);
    executeCommand("java -jar umple.jar {$filename}");
    $modelId = getFilenameId($filename);
    echo $modelId;
    return;
  }
  elseif (!in_array($language,array("Php","Java","Ruby")))
  {  
    $filename = saveFile($input);
    $sourceCode = executeCommand("java -jar umplesync.jar -generate {$language} {$filename}");
    if ($language != "Json")
    {
      $sourceCode = htmlspecialchars($sourceCode);
    }
    echo $sourceCode;
    return;
  }

  $filename = saveFile("generate {$language};\n" . $input);
  $outputFilename = "{$filename}.output";
  $command = "java -jar umplesync.jar -source {$filename} > {$outputFilename}";    
  exec($command);
  
  $sourceCode = readTemporaryFile($outputFilename);
  $sourceCode = str_replace("<?php","",$sourceCode);
  $sourceCode = str_replace("?>","",$sourceCode);
  $sourceCode = htmlspecialchars($sourceCode);
  
  if ($sourceCode == "")
  {
    $html = "
        // An error occurred interpreting your Umple code, please review it and try again.
        // If the problem persists, please email the Umple code to
        // The umple-help google group: umple-help@googlegroups.com
        // Or post an issue at http://bugs.umple.org -- the umple issues page
        ";
    echo $html;
  }
  else
  {
    echo $sourceCode;
  }
}
else if (isset($_REQUEST["exampleCode"]))
{
  $filename = "../ump/" . $_REQUEST["exampleCode"];
  $outputUmple = readTemporaryFile($filename);
  echo $outputUmple;
}
else if (isset($_REQUEST["asImage"]))
{
  $asImage = $_REQUEST["asImage"];
  $json = json_decode($asImage);
  showUmlImage($json);
}
else if (isset($_REQUEST["asYuml"]))
{
  showYumlImage($_REQUEST["asYuml"]);
}
else if (isset($_REQUEST["asUI"]))
{ 
  showUserInterface($_REQUEST["asUI"]);
}
else
{
  echo "Invalid use of compiler";
}
?>