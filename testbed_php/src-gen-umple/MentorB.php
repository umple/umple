<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class MentorB
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $nextY = 1;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Autounique Attributes
  private $y;

  //MentorB Associations
  private $student;
  private $program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aStudent)
  {
    $this->y = self::$nextY++;
    $didAddStudent = $this->setStudent($aStudent);
    if (!$didAddStudent)
    {
      throw new Exception("Unable to create mentor due to student");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getY()
  {
    return $this->y;
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
    if ($newStudent == null)
    {
      //Unable to setStudent to null, as mentor must always be associated to a student
      return $wasSet;
    }
    
    $existingMentor = $newStudent->getMentor();
    if ($existingMentor != null && $this != $existingMentor)
    {
      //Unable to setStudent, the current student already has a mentor, which would be orphaned if it were re-assigned
      return $wasSet;
    }
    
    $oldStudent = $this->student;
    $this->student = $newStudent;
    $this->student->setMentor($this);
    
    if ($oldStudent != null)
    {
      $oldStudent->setMentor(null);
    }
    $wasSet = true;
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
    $existingStudent = $this->student;
    $this->student = null;
    if ($existingStudent != null)
    {
      $existingStudent->setMentor(null);
    }
    if ($this->program != null)
    {
      $this->program->setMentor(null);
    }
  }

}
?>