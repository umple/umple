<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

class CodeAnalyzer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CodeAnalyzer Attributes
  private $projectDirectory;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aProjectDirectory)
  {
    $this->projectDirectory = $aProjectDirectory;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setProjectDirectory($aProjectDirectory)
  {
    $wasSet = false;
    $this->projectDirectory = $aProjectDirectory;
    $wasSet = true;
    return $wasSet;
  }

  public function getProjectDirectory()
  {
    return $this->projectDirectory;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

   public function getStats()
  {
    echo("** Getting Project Statistics...\n");
  	$command = 'java -jar ' . getcwd() . '/app/vendor/umple.jar -g CodeAnalysis ' . $this->projectDirectory . '/src-umple/Master.ump';
    exec($command);
    echo("** Code Analysis Complete!\n");
  }

}
?>