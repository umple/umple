<?php

require_once("compiler_config.php");

if (isset($_REQUEST["save"]))
{
  $input = $_REQUEST["umpleCode"];
  $filename = createTemporaryFile($input);
  echo $filename;
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
    $filename = createTemporaryFile("generate Php;\n" . $input);
    executeCommand("java -jar umple.jar {$filename}");
    $filename = createTemporaryFile("generate Simulate;\n" . $input);
    executeCommand("java -jar umple.jar {$filename}");
    $modelId = getFilenameId($filename);
    echo $modelId;
    return;
  }
  elseif (!in_array($language,array("Php","Java","Ruby")))
  {  
    $filename = createTemporaryFile($input);
    $sourceCode = executeCommand("java -jar umpleplayground.jar -generate {$language} {$filename}");
    if ($language != "Json")
    {
      $sourceCode = htmlspecialchars($sourceCode);
    }
    echo $sourceCode;
    return;
  }

  $filename = createTemporaryFile("generate {$language};\n" . $input);
  $outputFilename = "{$filename}.output";
  $command = "java -jar umpleplayground.jar -source {$filename} > {$outputFilename}";    
  exec($command);
  
  $sourceCode = readTemporaryFile($outputFilename);
  $sourceCode = str_replace("<?php","",$sourceCode);
  $sourceCode = str_replace("?>","",$sourceCode);
  $sourceCode = htmlspecialchars($sourceCode);
  
  if ($sourceCode == "")
  {
    $html = "
        //An error occurred interpreting your Umple code, please review it and try again.
        //If the problem persists, please email the Umple code to
        //Andrew at aforward@site.uottawa.ca.
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