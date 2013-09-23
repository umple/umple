<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

class ClassWithOneSortedAssociations
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassWithOneSortedAssociations Attributes
  private $studentCsPriority;

  //ClassWithOneSortedAssociations Associations
  private $studentCs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->studentCsPriority = 
      function($x, $y)
      {
        return $x->getId() -
               $y->getId();
      };
    $this->studentCs = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setStudentCsPriority($aStudentCsPriority)
  {
    $wasSet = false;
    $this->studentCsPriority = $aStudentCsPriority;
    $wasSet = true;
    return $wasSet;
  }

  public function getStudentCsPriority()
  {
    return $this->studentCsPriority;
  }

  public function getStudentC($index)
  {
    $aStudentC = $this->studentCs[$index];
    return $aStudentC;
  }

  public function getStudentCs()
  {
    $newStudentCs = $this->studentCs;
    return $newStudentCs;
  }

  public function numberOfStudentCs()
  {
    $number = count($this->studentCs);
    return $number;
  }

  public function hasStudentCs()
  {
    $has = $this->numberOfStudentCs() > 0;
    return $has;
  }

  public function indexOfStudentC($aStudentC)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->studentCs as $studentC)
    {
      if ($studentC->equals($aStudentC))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfStudentCs()
  {
    return 0;
  }

  public function addStudentC($aStudentC)
  {
    $wasAdded = false;
    if ($this->indexOfStudentC($aStudentC) !== -1) { return false; }
    $this->studentCs[] = $aStudentC;
    $wasAdded = true;
    if(wasAdded)
        usort($this->studentCs, $this->studentCsPriority);
    
    return $wasAdded;
  }

  public function removeStudentC($aStudentC)
  {
    $wasRemoved = false;
    if ($this->indexOfStudentC($aStudentC) != -1)
    {
      unset($this->studentCs[$this->indexOfStudentC($aStudentC)]);
      $this->studentCs = array_values($this->studentCs);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->studentCs = array();
  }

}
?>