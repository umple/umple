<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

class Student
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Student Attributes
  private $age;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aAge)
  {
    if ( !($aAge>18))
    {
      throw new RuntimeException("Please provide a valid age");
    }
    $this->age = $aAge;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setAge($aAge)
  {
    $wasSet = false;
    if ($aAge>18)
    {
    $this->age = $aAge;
    $wasSet = true;
    }
    return $wasSet;
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