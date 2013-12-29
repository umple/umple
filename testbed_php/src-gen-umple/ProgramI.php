<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

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

  public function setMentorI($aNewMentorI)
  {
    $wasSet = false;
    if ($aNewMentorI == null)
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
    if ($currentMentorI != null && $currentMentorI != $aNewMentorI)
    {
      $currentMentorI->setProgram(null);
    }
    
    $this->mentorI = $aNewMentorI;
    $existingProgram = $aNewMentorI->getProgram();
    
    if ($this != $existingProgram)
    {
      $aNewMentorI->setProgram($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function setStudentI($aNewStudentI)
  {
    $wasSet = false;
    if ($aNewStudentI == null)
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
    if ($currentStudentI != null && $currentStudentI != $aNewStudentI)
    {
      $currentStudentI->setProgram(null);
    }
    
    $this->studentI = $aNewStudentI;
    $existingProgram = $aNewStudentI->getProgram();
    
    if ($this != $existingProgram)
    {
      $aNewStudentI->setProgram($this);
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