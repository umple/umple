<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class PersonA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PersonA Attributes
  private $name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    StringTracer::handle( gettimeofday(true).",".uniqid().",/home/geoff/programs/umple/hatch/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,9,PersonA,".spl_object_hash( $this ).",at_s,name,".$this->name.",".$aName );
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>