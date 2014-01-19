<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

class StudentM
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentM Attributes
  private $number;

  //StudentM Associations
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
    //Must provide mentor to student
    if ($aMentor == null)
    {
      return $wasSet;
    }

    if ($this->mentor != null && $this->mentor->numberOfStudents() <= MentorM::minimumNumberOfStudents())
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