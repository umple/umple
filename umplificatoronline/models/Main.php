<?php
  include("Downloader.php");
  include("Umplificator.php");
  include("CodeAnalyzer.php");
  include("Grapher.php");

  // Fetch command-line arguments
  $repo = $argv[1];
  $name = $argv[2];
  $umplificationLevel = $argv[3];
  $dir = $argv[4];

  // Get project URL
  if(strcmp($repo, 'gh') == 0) {
    // GitHub URL
    $url = "https://github.com/" . $name . "/archive/master.zip";
  } else if(strcmp($repo, 'gc') == 0) {
    // Google Code URL
    $url = "https://code.google.com/p/" . $name;
  }

  // Create Downloader instance
  $myDownloader = new Downloader($repo, $url, $dir, $name);

  if(strcmp($myDownloader->getProjectRepo(), 'gh') == 0) {
    // Download project from Github & unzip
    $myDownloader->downloadProjectGithub();
  }

  else if(strcmp($myDownloader->getProjectRepo(), 'gc') == 0) {
    // Download project from Google Code using hg command
    $myDownloader->downloadProjectGoogleCode();
  }

  else {
    echo("** ERROR: Repo must be gh for Github or gc for Google Code\n");
  }

  // Umplify project
   $myUmplificator = new Umplificator($myDownloader->getDestinationDir() . $myDownloader->getProjectName());
   $myUmplificator->umplifyProject($umplificationLevel);

   // Run Code Analyzer
   $myCodeAnalyzer = new CodeAnalyzer($myDownloader->getDestinationDir() . $myDownloader->getProjectName());
   $myCodeAnalyzer->getStats();

   // Build graph
   $myGrapher = new Grapher($myDownloader->getDestinationDir() . $myDownloader->getProjectName() . "/src-umple/");
   $myGrapher->run();
   $myGrapher->generateGraph();