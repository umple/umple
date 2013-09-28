<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

class Client
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Client Attributes
  private $minAge;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aMinAge)
  {
    $this->minAge = $aMinAge;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setMinAge($aMinAge)
  {
    $wasSet = false;
    $this->minAge = $aMinAge;
    $wasSet = true;
    return $wasSet;
  }

  public function getMinAge()
  {
    return $this->minAge;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

  public function someMethod(Integer arg)
  {

    if ( !($arg>5))
    {
      throw new RuntimeException("Please provide a valid arg");
    }
    if ( !($minAge<8))
    {
      throw new RuntimeException("Please provide a valid minAge");
    }
    // rest of stuff that we don't interpret
 return 0;
  }

}
?>