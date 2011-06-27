<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

class StudentQ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StudentQ Attributes
  private $number;

  //StudentQ Associations
  private $program;
  private $mentors;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aNumber)
  {
    $this->number = $aNumber;
    $this->mentors = array();
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

  public function getMentor($index)
  {
    $aMentor = $this->mentors[$index];
    return $aMentor;
  }

  public function getMentors()
  {
    $newMentors = $this->mentors;
    return $newMentors;
  }

  public function numberOfMentors()
  {
    $number = count($this->mentors);
    return $number;
  }

  public function hasMentors()
  {
    $has = $this->numberOfMentors() > 0;
    return $has;
  }

  public function indexOfMentor($aMentor)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->mentors as $mentor)
    {
      if ($mentor->equals($aMentor))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
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

  public static function minimumNumberOfMentors()
  {
    return 0;
  }

  public function addMentor($aMentor)
  {
    $wasAdded = false;
    if ($this->indexOfMentor($aMentor) !== -1) { return false; }
    $this->mentors[] = $aMentor;
    if ($aMentor->indexOfStudent($this) != -1)
    {
      $wasAdded = true;
    }
    else
    {
      $wasAdded = $aMentor->addStudent($this);
      if (!$wasAdded)
      {
        array_pop($this->mentors);
      }
    }
    return $wasAdded;
  }

  public function removeMentor($aMentor)
  {
    $wasRemoved = false;
    if ($this->indexOfMentor($aMentor) == -1)
    {
      return $wasRemoved;
    }

    $oldIndex = $this->indexOfMentor($aMentor);
    unset($this->mentors[$oldIndex]);
    if ($aMentor->indexOfStudent($this) == -1)
    {
      $wasRemoved = true;
    }
    else
    {
      $wasRemoved = $aMentor->removeStudent($this);
      if (!$wasRemoved)
      {
        $this->mentors[$oldIndex] = $aMentor;
        ksort($this->mentors);
      }
    }
    $this->mentors = array_values($this->mentors);
    return $wasRemoved;
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
    $copyOfMentors = $this->mentors;
    $this->mentors = array();
    foreach ($copyOfMentors as $aMentor)
    {
      if ($aMentor->numberOfStudents() <= MentorQ::minimumNumberOfStudents())
      {
        $aMentor->delete();
      }
      else
      {
        $aMentor->removeStudent($this);
      }
    }
  }

}
?>