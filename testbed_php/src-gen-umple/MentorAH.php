<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

class MentorAH
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAH Attributes
  private $name;

  //MentorAH Associations
  private $student;
  private $program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aStudent)
  {
    $this->name = $aName;
    if (!$this->setStudent($aStudent))
    {
      throw new Exception("Unable to create MentorAH due to aStudent");
    }
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

  public function setStudent($aNewStudent)
  {
    $wasSet = false;
    if ($aNewStudent != null)
    {
      $this->student = $aNewStudent;
      $wasSet = true;
    }
    return $wasSet;
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
    $this->student = null;
    if ($this->program != null)
    {
      $this->program->setMentor(null);
    }
  }

}
?>