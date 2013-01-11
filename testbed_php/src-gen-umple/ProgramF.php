<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class ProgramF
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramF Associations
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

  public function setMentor($newMentor)
  {
    $wasSet = false;
    if ($newMentor == null)
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
    if ($currentMentor != null && $currentMentor != $newMentor)
    {
      $currentMentor->setProgram(null);
    }
    
    $this->mentor = $newMentor;
    $existingProgram = $newMentor->getProgram();
    
    if ($this != $existingProgram)
    {
      $newMentor->setProgram($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setStudent($newStudent)
  {
    $wasSet = false;
    if ($newStudent == null)
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
    if ($currentStudent != null && $currentStudent != $newStudent)
    {
      $currentStudent->setProgram(null);
    }
    
    $this->student = $newStudent;
    $existingProgram = $newStudent->getProgram();
    
    if ($this != $existingProgram)
    {
      $newStudent->setProgram($this);
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