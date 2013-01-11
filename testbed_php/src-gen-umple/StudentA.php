<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class StudentA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentA Associations
  private $mentor;

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

  public function setMentor($newMentor)
  {
    $wasSet = false;
    if ($newMentor == null)
    {
      $existingMentor = $this->mentor;
      $this->mentor = null;
      
      if ($existingMentor != null && $existingMentor->getStudent() != null)
      {
        $existingMentor->setStudent(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentMentor = $this->getMentor();
    if ($currentMentor != null && $currentMentor != $newMentor)
    {
      $currentMentor->setStudent(null);
    }
    
    $this->mentor = $newMentor;
    $existingStudent = $newMentor->getStudent();
    
    if ($this != $existingStudent)
    {
      $newMentor->setStudent($this);
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
      $this->mentor->setStudent(null);
    }
  }

}
?>