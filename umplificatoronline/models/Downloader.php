<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

class Downloader
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Downloader Attributes
  private $projectRepo;
  private $remoteUrl;
  private $destinationDir;
  private $projectName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aProjectRepo, $aRemoteUrl, $aDestinationDir, $aProjectName)
  {
    $this->projectRepo = $aProjectRepo;
    $this->remoteUrl = $aRemoteUrl;
    $this->destinationDir = $aDestinationDir;
    $this->projectName = $aProjectName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setProjectRepo($aProjectRepo)
  {
    $wasSet = false;
    $this->projectRepo = $aProjectRepo;
    $wasSet = true;
    return $wasSet;
  }

  public function setRemoteUrl($aRemoteUrl)
  {
    $wasSet = false;
    $this->remoteUrl = $aRemoteUrl;
    $wasSet = true;
    return $wasSet;
  }

  public function setDestinationDir($aDestinationDir)
  {
    $wasSet = false;
    $this->destinationDir = $aDestinationDir;
    $wasSet = true;
    return $wasSet;
  }

  public function setProjectName($aProjectName)
  {
    $wasSet = false;
    $this->projectName = $aProjectName;
    $wasSet = true;
    return $wasSet;
  }

  public function getProjectRepo()
  {
    return $this->projectRepo;
  }

  public function getRemoteUrl()
  {
    return $this->remoteUrl;
  }

  public function getDestinationDir()
  {
    return $this->destinationDir;
  }

  public function getProjectName()
  {
    return $this->projectName;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

   public function downloadProjectGithub()
  {
    $zipFile = $this->getDestinationDir() . "/$this->getProjectName.zip"; // Local Zip File Path
	$zipResource = fopen($zipFile, "w");

	// Get The Zip File From Server
	echo("** Downloading project zip...\n");
	$ch = curl_init();
	curl_setopt($ch, CURLOPT_URL, $this->getRemoteUrl());
	curl_setopt($ch, CURLOPT_FAILONERROR, true);
	curl_setopt($ch, CURLOPT_HEADER, 0);
	curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
	curl_setopt($ch, CURLOPT_AUTOREFERER, true);
	curl_setopt($ch, CURLOPT_BINARYTRANSFER,true);
	curl_setopt($ch, CURLOPT_TIMEOUT, 10);
	curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
	curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0); 
	curl_setopt($ch, CURLOPT_FILE, $zipResource);
	$page = curl_exec($ch);
	if(!$page) {
	 echo "Error :- ".curl_error($ch);
	}
	curl_close($ch);

	// Extract project zip and save its name
	echo("** Extracting project zip...\n");
    $zip = new ZipArchive;
    $res = $zip->open($zipFile);
    $this->projectName = substr($zip->getNameIndex(0), 0, strlen($zip->getNameIndex(0))-1);

    if($res == TRUE) {
     $zip->extractTo($this->getDestinationDir());
     $zip->close();
    } else {
    	exit("Could not extract project archive!");
    }
  }

   public function downloadProjectGoogleCode()
  {
    echo("** Downloading project...\n");
    $command = 'hg clone ' . $this->getRemoteUrl() . ' ' . $this->getDestinationDir() . $this->getProjectName();
    exec($command);
  }

}
?>