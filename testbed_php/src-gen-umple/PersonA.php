<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

// tracer String;
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
    ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/nobackup-tmp/CheckoutForUmplePatchTest3/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,9,PersonA,".spl_object_hash( $this ).",at_s,name,".$this->name.",".$aName );
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