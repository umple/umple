<?php
/*
Run periodically to regenerate the menu listings for extra
example menus in UmpleOnline
*/

//Prepare to re-create the data file containing the menu items
$fhandle = fopen("../generatedExtraExample1Options.html","w");

// Loop through each example directory
foreach (new DirectoryIterator('../umplibrary/extraExamples1') as $fileInfo) {
  if($fileInfo->isDot()) continue;
  $fileNameFound = $fileInfo->getFilename();
  echo "DEBUG FILENAME: ".$fileNameFound . "<br>\n";
  $file = $fileInfo->openFile();
  // Loop through each line in the file, to obtain the Title
  while (!$file->eof()) {
    // get the current line
    $line  =  $file->fgets();

    // extract the title, when found
    if (!strcmp("Title: ",substr($line,0,7))) {
      $titleFound=substr($line,7,-1);
      echo("DEBUG FOUND TITLE: ".$titleFound."\n");
      
      
      $newLine = "<option name = \"optionExample\" value=\"extraExamples1/".
        $fileNameFound."\">".$titleFound."</option>\n";
      
      fwrite($fhandle,$newLine);
      
      break;
    }
  }
  $file = null; // documentation says need to do this to close file
}
fclose($fhandle);

?>