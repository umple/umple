<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

class StudentG
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentG Attributes
  private $number;

  //StudentG Associations
  private $program;
  private $mentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aNumber = null, $aMentor = null)
  {
    if (func_num_args() == 0) { return; }

    $this->number = $aNumber;
    if ($aMentor == null || $aMentor->getStudent() != null)
    {
      throw new Exception("Unable to create StudentG due to aMentor");
    }
    $this->mentor = $aMentor;
  }
  public static function newInstance($aNumber, $aNameForMentor)
  {
    $thisInstance = new StudentG();
    $thisInstance->number = $aNumber;
    $thisInstance->mentor = new MentorG($aNameForMentor, $thisInstance);
    return $thisInstance;
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
    $existingMentor = $this->mentor;
    $this->mentor = null;
    if ($existingMentor != null)
    {
      $existingMentor->delete();
    }
  }

}
?>