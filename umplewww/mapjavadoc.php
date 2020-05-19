<?php
  // Open the correct web page for a class in Javadoc that varies by package

  $query=$_SERVER['QUERY_STRING'];
  $rootDir="umple-compiler-javadoc/cruise/";

  // Try in the parser package
  $toOpen=$rootDir."umple/parser/".$query.".html";
  if(file_exists($toOpen)) 
  {
    header("Location: ".$toOpen);
    exit;
  }

  // Try in the compiler package
  $toOpen=$rootDir."umple/compiler/".$query.".html";
  if(file_exists($toOpen)) 
  {
    header("Location: ".$toOpen);
    exit;
  }

  // If we get this far, the file isn't in the parser or compiler package, so we look
  // in any of the others

  $searchpat=$rootDir."*/".$query.".html";
  // echo("Will search: ".$searchpat. "<br/>\n");
  foreach (glob($searchpat) as $toOpen) {
    header("Location: ".$toOpen);
    exit;
    echo "$filename size " . filesize($toOpen) . "\n";
  }
  $searchpat=$rootDir."*/*/".$query.".html";
  // echo("Will search: ".$searchpat. "<br/>\n");
  foreach (glob($searchpat) as $toOpen) {
    header("Location: ".$toOpen);
    exit;
    echo "$filename size " . filesize($toOpen) . "\n";
  }
  $searchpat=$rootDir."*/*/*/".$query.".html";
  // echo("Will search: ".$searchpat. "<br/>\n");
  foreach (glob($searchpat) as $toOpen) {
    header("Location: ".$toOpen);
    exit;
    echo "$filename size " . filesize($toOpen) . "<br/>\n";
  }


  echo("No class found: ".$query. "<br/>\n");
  exit;

  echo("<html><h1>got here</h1></html>"); exit;

 ?>  
