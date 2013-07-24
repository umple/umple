<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class TraceRecord extends TraceStm
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceRecord Attributes
  private $number1;
  private $number2;
  private $str;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aNumber1, $aNumber2, $aStr)
  {
    parent::__construct();
    $this->number1 = $aNumber1;
    $this->number2 = $aNumber2;
    $this->str = $aStr;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setNumber1($aNumber1)
  {
    $wasSet = false;
    ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/nobackup-tmp/CheckoutForUmplePatchTest3/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,107,TraceRecord,".spl_object_hash( $this ).",at_s,number1,".$this->number1.",".$aNumber1.",TracingNumber1" );
    $this->number1 = $aNumber1;
    $wasSet = true;
    return $wasSet;
  }

  public function setNumber2($aNumber2)
  {
    $wasSet = false;
    ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/nobackup-tmp/CheckoutForUmplePatchTest3/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,108,TraceRecord,".spl_object_hash( $this ).",at_s,number2,".$this->number2.",".$aNumber2.",".str );
    $this->number2 = $aNumber2;
    $wasSet = true;
    return $wasSet;
  }

  public function setStr($aStr)
  {
    $wasSet = false;
    $this->str = $aStr;
    $wasSet = true;
    return $wasSet;
  }

  public function getNumber1()
  {
    return $this->number1;
  }

  public function getNumber2()
  {
    return $this->number2;
  }

  public function getStr()
  {
    return $this->str;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    parent::delete();
  }

}
?>