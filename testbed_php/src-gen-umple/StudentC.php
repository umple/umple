<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class StudentC
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentC Attributes
  private $id;

  //StudentC Associations
  private $program;
  private $mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId)
  {
    $this->id = $aId;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    $this->id = $aId;
    $wasSet = true;
    return $wasSet;
  }

  public function getId()
  {
    return $this->id;
  }

  public function getProgram()
  {
    return $this->program;
  }

  public function getMentor()
  {
    return $this->mentor;
  }

  public function setProgram($aNewProgram)
  {
    $wasSet = false;
    if ($aNewProgram == null)
    {
      $existingProgram = $this->program;
      $this->program = null;
      
      if ($existingProgram != null && $existingProgram->getStudent() != null)
      {
        $existingProgram->setStudent(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentProgram = $this->getProgram();
    if ($currentProgram != null && $currentProgram != $aNewProgram)
    {
      $currentProgram->setStudent(null);
    }
    
    $this->program = $aNewProgram;
    $existingStudent = $aNewProgram->getStudent();
    
    if ($this != $existingStudent)
    {
      $aNewProgram->setStudent($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setMentor($aMentor)
  {
    $wasSet = false;
    $existingMentor = $this->mentor;
    $this->mentor = $aMentor;
    if ($existingMentor != null && $existingMentor !== $aMentor)
    {
      $existingMentor->removeStudent($this);
    }
    if ($aMentor != null && $aMentor !== $existingMentor)
    {
      $aMentor->addStudent($this);
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
    if ($this->program != null)
    {
      $this->program->setStudent(null);
    }
    if ($this->mentor != null)
    {
      $this->mentor->removeStudent($this);
    }
  }

}
?>