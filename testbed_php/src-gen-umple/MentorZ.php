<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class MentorZ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorZ Attributes
  private $name;

  //MentorZ Associations
  private $students;
  private $program;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
    $this->students = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getStudent($index)
  {
    $aStudent = $this->students[$index];
    return $aStudent;
  }

  public function getStudents()
  {
    $newStudents = $this->students;
    return $newStudents;
  }

  public function numberOfStudents()
  {
    $number = count($this->students);
    return $number;
  }

  public function hasStudents()
  {
    $has = $this->numberOfStudents() > 0;
    return $has;
  }

  public function indexOfStudent($aStudent)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->students as $student)
    {
      if ($student->equals($aStudent))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getProgram()
  {
    return $this->program;
  }

  public static function minimumNumberOfStudents()
  {
    return 0;
  }

  public static function maximumNumberOfStudents()
  {
    return 3;
  }

  public function addStudentVia($aNumber)
  {
    if ($this->numberOfStudents() >= self::maximumNumberOfStudents())
    {
      return null;
    }
    else
    {
      return new StudentZ($aNumber, $this);
    }
  }

  public function addStudent($aStudent)
  {
    $wasAdded = false;
    if ($this->indexOfStudent($aStudent) !== -1) { return false; }
    if ($this->numberOfStudents() >= self::maximumNumberOfStudents())
    {
      return $wasAdded;
    }

    $existingMentor = $aStudent->getMentor();
    $isNewMentor = $existingMentor != null && $this !== $existingMentor;
    if ($isNewMentor)
    {
      $aStudent->setMentor($this);
    }
    else
    {
      $this->students[] = $aStudent;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStudent($aStudent)
  {
    $wasRemoved = false;
    //Unable to remove aStudent, as it must always have a mentor
    if ($this !== $aStudent->getMentor())
    {
      unset($this->students[$this->indexOfStudent($aStudent)]);
      $this->students = array_values($this->students);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStudentAt($aStudent, $index)
  {  
    $wasAdded = false;
    if($this->addStudent($aStudent))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStudents()) { $index = $this->numberOfStudents() - 1; }
      array_splice($this->students, $this->indexOfStudent($aStudent), 1);
      array_splice($this->students, $index, 0, array($aStudent));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStudentAt($aStudent, $index)
  {
    $wasAdded = false;
    if($this->indexOfStudent($aStudent) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStudents()) { $index = $this->numberOfStudents() - 1; }
      array_splice($this->students, $this->indexOfStudent($aStudent), 1);
      array_splice($this->students, $index, 0, array($aStudent));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStudentAt($aStudent, $index);
    }
    return $wasAdded;
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
    foreach ($this->students as $aStudent)
    {
      $aStudent->delete();
    }
    if ($this->program != null)
    {
      $this->program->setMentor(null);
    }
  }

}
?>