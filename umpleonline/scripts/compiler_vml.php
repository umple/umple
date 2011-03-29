<?php

require_once("compiler_config.php");

if (isset($_REQUEST["save"]))
{
  $input = $_REQUEST["vmlCode"];
  $filename = createTemporaryFile($input);
  echo $filename;
}
else if (isset($_REQUEST["vmlCode"]))
{
  $input = $_REQUEST["vmlCode"];
  $language = $_REQUEST["language"];
  
  $filename = createTemporaryFile($input);
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
      createFile($outputFilename, "generate {$language};\n" . $genericCode);
      $command = "java -jar umpleplayground.jar -source {$outputFilename} > {$secondOutFilename}";
    } 
    else
    {
      createFile($outputFilename, $genericCode);
      
      $command = "java -jar umpleplayground.jar -generate {$language} {$outputFilename}  > {$secondOutFilename}";
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


// function createTemporaryFile($input)
// {
//   
//   if (!isset($_REQUEST["filename"]))
//   {
//     $filename = nextFilename();  
//   }
//   else
//   {
//     $filename = $_REQUEST["filename"];
//   }
//   return createFile($filename,$input);
// }
// 
// function createFile($filename,$input)
// {
//   $fh = fopen($filename, 'w');
//   fwrite($fh, $input);
//   fclose($fh);
//   return $filename;
// }
// 
// function readTemporaryFile($filename)
// {
//   if (!is_file($filename) || filesize($filename) == 0)
//   {
//     return "";
//   }
// 
//   $handle = fopen($filename, "r");
//   $contents = fread($handle, filesize($filename));
//   fclose($handle);
//   return $contents;
// }
// 
// 
// function nextFilename()
// {
//   while(true)
//   {
//     $id = rand(0,999999);
//     $filename = "../ump/__{$id}.vml";
//     
//     if (!file_exists($filename))
//     {
//       return $filename;
//     }
//   }
// }
// 
// function executeCommand($command)
// {
//   ob_start();
//   passthru($command);
//   $output = trim(ob_get_contents());
//   ob_clean();
//   return $output;
// }