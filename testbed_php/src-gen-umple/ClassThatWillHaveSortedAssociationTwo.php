<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class ClassThatWillHaveSortedAssociationTwo
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassThatWillHaveSortedAssociationTwo Attributes
  private $massPriority;

  //ClassThatWillHaveSortedAssociationTwo Associations
  private $mass;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->massPriority = "name";
    $this->mass = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setMassPriority($aMassPriority)
  {
    $wasSet = false;
    $this->massPriority = $aMassPriority;
    $wasSet = true;
    return $wasSet;
  }

  public function getMassPriority()
  {
    return $this->massPriority;
  }

  public function getMass($index)
  {
    $aMass = $this->mass[$index];
    return $aMass;
  }

  public function getMass()
  {
    $newMass = $this->mass;
    return $newMass;
  }

  public function numberOfMass()
  {
    $number = count($this->mass);
    return $number;
  }

  public function hasMass()
  {
    $has = $this->numberOfMass() > 0;
    return $has;
  }

  public function indexOfMass($aMass)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->mass as $mass)
    {
      if ($mass->equals($aMass))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfMass()
  {
    return 0;
  }

  public function addMass($aMass)
  {
    $wasAdded = false;
    if ($this->indexOfMass($aMass) !== -1) { return false; }
    $this->mass[] = $aMass;
    $wasAdded = true;
    $this->sort($this->mass, $this->massPriority);
    
    return $wasAdded;
  }

  public function removeMass($aMass)
  {
    $wasRemoved = false;
    if ($this->indexOfMass($aMass) != -1)
    {
      unset($this->mass[$this->indexOfMass($aMass)]);
      $this->mass = array_values($this->mass);
      $wasRemoved = true;
    }
    $this->sort($this->mass, $this->massPriority);
    
    return $wasRemoved;
  }

  public function sort(&$toSort, $thePriority)
  {
    if(count($toSort) > 0)
    {
      $methodName = "get".ucfirst($thePriority);
      usort($toSort, function($x, $y) use ($methodName)
      {
        $var1 = call_user_func(array($x, $methodName));
        $var2 = call_user_func(array($y, $methodName));
        return $var1 - $var2;
      });
    }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->mass = array();
  }

}
?>