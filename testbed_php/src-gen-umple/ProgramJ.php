<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

class ProgramJ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramJ Associations
  private $mentor;
  private $student;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public function getMentor()
  {
    return $this->mentor;
  }

  public function getStudent()
  {
    return $this->student;
  }

  public function setMentor($aNewMentor)
  {
    $wasSet = false;
    if ($aNewMentor == null)
    {
      $existingMentor = $this->mentor;
      $this->mentor = null;
      
      if ($existingMentor != null && $existingMentor->getProgram() != null)
      {
        $existingMentor->setProgram(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentMentor = $this->getMentor();
    if ($currentMentor != null && $currentMentor != $aNewMentor)
    {
      $currentMentor->setProgram(null);
    }
    
    $this->mentor = $aNewMentor;
    $existingProgram = $aNewMentor->getProgram();
    
    if ($this != $existingProgram)
    {
      $aNewMentor->setProgram($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setStudent($aNewStudent)
  {
    $wasSet = false;
    if ($aNewStudent == null)
    {
      $existingStudent = $this->student;
      $this->student = null;
      
      if ($existingStudent != null && $existingStudent->getProgram() != null)
      {
        $existingStudent->setProgram(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentStudent = $this->getStudent();
    if ($currentStudent != null && $currentStudent != $aNewStudent)
    {
      $currentStudent->setProgram(null);
    }
    
    $this->student = $aNewStudent;
    $existingProgram = $aNewStudent->getProgram();
    
    if ($this != $existingProgram)
    {
      $aNewStudent->setProgram($this);
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
    if ($this->mentor != null)
    {
      $this->mentor->setProgram(null);
    }
    if ($this->student != null)
    {
      $this->student->setProgram(null);
    }
  }

}
?>