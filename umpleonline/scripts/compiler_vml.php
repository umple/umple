<?php

require_once("compiler_config.php");

if (isset($_REQUEST["save"]))
{
  $input = $_REQUEST["vmlCode"];
  $filename = saveFile($input);
  echo $filename;
}
else if (isset($_REQUEST["vmlCode"]))
{
  $input = $_REQUEST["vmlCode"];
  $language = $_REQUEST["language"];
  
  $filename = saveFile($input);
  $outputFilename = "{$filename}.output";
  
  $command = "java -jar vml.jar $outputFilename $filename";
  exec($command);

  $genericCode = readTemporaryFile($outputFilename);
  
  if ($language == "Generic")
  {
    $sourceCode = $genericCode;
  }
  else
  {
    
    $secondOutFilename = "{$filename}.{$language}.output";

    if (!in_array($language,array("Php","Java","Ruby")))
    {  
      saveFile("generate {$language};\n" . $genericCode,$outputFilename);
      $command = "java -jar umplesync.jar -source {$outputFilename} > {$secondOutFilename}";
    } 
    else
    {
      saveFile($genericCode,$outputFilename);
      
      $command = "java -jar umplesync.jar -generate {$language} {$outputFilename}  > {$secondOutFilename}";
    }

    exec($command);
  
    $sourceCode = readTemporaryFile($secondOutFilename);
    $sourceCode = str_replace("<?php","",$sourceCode);
    $sourceCode = str_replace("?>","",$sourceCode);
    
    if ($sourceCode == "")
    {
      $sourceCode = "//Generated code did not compile in Umple, please review the Umple code below and then fix your VML code\n\n";
      $sourceCode .= $genericCode;
    }
  }
  
  if ($language != "Json")
  {
    $sourceCode = htmlspecialchars($sourceCode);
  }
  
  if ($sourceCode == "")
  {
    $html = "
        //An error occurred interpreting your VML code, please review it and try again.
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
else
{
  echo "Invalid use of vml compiler";
}
