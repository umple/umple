<?php
  // run on port 5556 if in a directory with 'test' as a substring, otherwise use 5555
  $portnumber = 5555;
  $specialPortFile = getcwd()."/specialPort.txt";
  if (file_exists($specialPortFile) && is_readable($specialPortFile) ) {
    $specialPortOpenFile = fopen($specialPortFile, "r");
    $portnumber = fgets($specialPortOpenFile,5);
    fclose($specialPortOpenFile);
  }
  else if(strpos(getcwd(),"test") !== false) {
    $portnumber = 5556;
  }
?>