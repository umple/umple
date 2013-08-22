<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

// attributes on both sides of the constraint's boolean expression
class Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private $minAge;
  private $age;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aMinAge, $aAge)
  {
    if ( !($aAge>$aMinAge))
    {
      throw new RuntimeException("Please provide a valid age");
    }
    if ( !($aAge>$aMinAge))
    {
      throw new RuntimeException("Please provide a valid minAge");
    }
    $this->minAge = $aMinAge;
    $this->age = $aAge;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setMinAge($aMinAge)
  {
    $wasSet = false;
    if ($age>$aMinAge)
    {
    $this->minAge = $aMinAge;
    $wasSet = true;
    }
    return $wasSet;
  }

  public function setAge($aAge)
  {
    $wasSet = false;
    if ($aAge>$minAge)
    {
    $this->age = $aAge;
    $wasSet = true;
    }
    return $wasSet;
  }

  public function getMinAge()
  {
    return $this->minAge;
  }

  public function getAge()
  {
    return $this->age;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>