<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class MentorG
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorG Attributes
  private $name;

  //MentorG Associations
  private $student;
  private $program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName = null, $aStudent = null)
  {
    if (func_num_args() == 0) { return; }

    $this->name = $aName;
    if ($aStudent == null || $aStudent->getMentor() != null)
    {
      throw new Exception("Unable to create MentorG due to aStudent");
    }
    $this->student = $aStudent;
  }
  public static function newInstance($aName, $aNumberForStudent)
  {
    $thisInstance = new MentorG();
    $thisInstance->name = $aName;
    $thisInstance->student = new StudentG($aNumberForStudent, $thisInstance);
    return $thisInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getStudent()
  {
    return $this->student;
  }

  public function getProgram()
  {
    return $this->program;
  }

  public function setProgram($aNewProgram)
  {
    $wasSet = false;
    if ($aNewProgram == null)
    {
      $existingProgram = $this->program;
      $this->program = null;
      
      if ($existingProgram != null && $existingProgram->getMentor() != null)
      {
        $existingProgram->setMentor(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentProgram = $this->getProgram();
    if ($currentProgram != null && $currentProgram != $aNewProgram)
    {
      $currentProgram->setMentor(null);
    }
    
    $this->program = $aNewProgram;
    $existingMentor = $aNewProgram->getMentor();
    
    if ($this != $existingMentor)
    {
      $aNewProgram->setMentor($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingStudent = $this->student;
    $this->student = null;
    if ($existingStudent != null)
    {
      $existingStudent->delete();
    }
    if ($this->program != null)
    {
      $this->program->setMentor(null);
    }
  }

}
?>