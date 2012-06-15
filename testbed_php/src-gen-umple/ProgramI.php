<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class ProgramI
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ProgramI Associations
  private $mentorI;
  private $studentI;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public function getMentorI()
  {
    return $this->mentorI;
  }

  public function getStudentI()
  {
    return $this->studentI;
  }

  public function setMentorI($newMentorI)
  {
    $wasSet = false;
    if ($newMentorI == null)
    {
      $existingMentorI = $this->mentorI;
      $this->mentorI = null;
      
      if ($existingMentorI != null && $existingMentorI->getProgram() != null)
      {
        $existingMentorI->setProgram(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentMentorI = $this->getMentorI();
    if ($currentMentorI != null && $currentMentorI != $newMentorI)
    {
      $currentMentorI->setProgram(null);
    }
    
    $this->mentorI = $newMentorI;
    $existingProgram = $newMentorI->getProgram();
    
    if ($this != $existingProgram)
    {
      $newMentorI->setProgram($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setStudentI($newStudentI)
  {
    $wasSet = false;
    if ($newStudentI == null)
    {
      $existingStudentI = $this->studentI;
      $this->studentI = null;
      
      if ($existingStudentI != null && $existingStudentI->getProgram() != null)
      {
        $existingStudentI->setProgram(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentStudentI = $this->getStudentI();
    if ($currentStudentI != null && $currentStudentI != $newStudentI)
    {
      $currentStudentI->setProgram(null);
    }
    
    $this->studentI = $newStudentI;
    $existingProgram = $newStudentI->getProgram();
    
    if ($this != $existingProgram)
    {
      $newStudentI->setProgram($this);
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
    if ($this->mentorI != null)
    {
      $this->mentorI->setProgram(null);
    }
    if ($this->studentI != null)
    {
      $this->studentI->setProgram(null);
    }
  }

}
?>