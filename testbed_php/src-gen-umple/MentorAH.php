<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

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

  public function setStudent($newStudent)
  {
    $wasSet = false;
    if ($newStudent != null)
    {
      $this->student = $newStudent;
      $wasSet = true;
    }
    return $wasSet;
  }

  public function setProgram($newProgram)
  {
    $wasSet = false;
    if ($newProgram == null)
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
    if ($currentProgram != null && $currentProgram != $newProgram)
    {
      $currentProgram->setMentor(null);
    }
    
    $this->program = $newProgram;
    $existingMentor = $newProgram->getMentor();
    
    if ($this != $existingMentor)
    {
      $newProgram->setMentor($this);
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