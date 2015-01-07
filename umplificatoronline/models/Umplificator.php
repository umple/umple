<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

class Umplificator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Umplificator Attributes
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

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 6 umplificator.ump
  public function umplifyProject ($umplificationLevel) 
  {
    echo("** Umplifying project...\n");
  	$command = 'java -jar ' . getcwd() . '/app/vendor/umplificator.jar -level=' . $umplificationLevel . ' -path=' . $this->projectDirectory . '/src-umple/ ' . $this->projectDirectory;
    exec($command);
    echo("** Umplification complete! Resulting Umple files can be found at " . $this->projectDirectory . "/src-umple/\n");
  }

}
?>