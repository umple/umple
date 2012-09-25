<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class StudentK
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentK Attributes
  private $number;

  //StudentK Associations
  private $program;
  private $mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aNumber, $aMentor)
  {
    $this->number = $aNumber;
    $didAddMentor = $this->setMentor($aMentor);
    if (!$didAddMentor)
    {
      throw new Exception("Unable to create student due to mentor");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setNumber($aNumber)
  {
    $wasSet = false;
    $this->number = $aNumber;
    $wasSet = true;
    return $wasSet;
  }

  public function getNumber()
  {
    return $this->number;
  }

  public function getProgram()
  {
    return $this->program;
  }

  public function getMentor()
  {
    return $this->mentor;
  }

  public function setProgram($newProgram)
  {
    $wasSet = false;
    if ($newProgram == null)
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
    if ($currentProgram != null && $currentProgram != $newProgram)
    {
      $currentProgram->setStudent(null);
    }
    
    $this->program = $newProgram;
    $existingStudent = $newProgram->getStudent();
    
    if ($this != $existingStudent)
    {
      $newProgram->setStudent($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setMentor($aMentor)
  {
    $wasSet = false;
    //Must provide mentor to student
    if ($aMentor == null)
    {
      return $wasSet;
    }

    //mentor already at maximum (3)
    if ($aMentor->numberOfStudents() >= MentorK::maximumNumberOfStudents())
    {
      return $wasSet;
    }
    
    $existingMentor = $this->mentor;
    $this->mentor = $aMentor;
    if ($existingMentor != null && $existingMentor != $aMentor)
    {
      $didRemove = $existingMentor->removeStudent($this);
      if (!$didRemove)
      {
        $this->mentor = $existingMentor;
        return $wasSet;
      }
    }
    $this->mentor->addStudent($this);
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
    $placeholderMentor = $this->mentor;
    $this->mentor = null;
    $placeholderMentor->removeStudent($this);
  }

}
?>