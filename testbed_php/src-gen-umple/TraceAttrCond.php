<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class TraceAttrCond
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceAttrCond Attributes
  private $n1;
  private $n2;
  private $n3;
  private $n4;
  private $numCond;
  private $traceFlag4;
  private $traceFlag5;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aN1, $aN2, $aN3, $aN4, $aNumCond)
  {
    $this->n1 = $aN1;
    $this->n2 = $aN2;
    $this->n3 = $aN3;
    $this->n4 = $aN4;
    $this->numCond = $aNumCond;
    $this->traceFlag4 = 0;
    $this->traceFlag5 = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setN1($aN1)
  {
    $wasSet = false;
      if($aN1>100&&$traceFlag4<2)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/geoff/programs/umple/umple/build/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,80,TraceAttrCond,".spl_object_hash( $this ).",at_s,n1,".$this->n1.",".$aN1 );
      traceFlag4++;
        }
    $this->n1 = $aN1;
    $wasSet = true;
    return $wasSet;
  }

  public function setN2($aN2)
  {
    $wasSet = false;
    $this->n2 = $aN2;
      if($aN2>50&&$traceFlag5<2)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/geoff/programs/umple/umple/build/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,81,TraceAttrCond,".spl_object_hash( $this ).",at_s,n2,".$this->n2 );
      traceFlag5++;
        }
    $wasSet = true;
    return $wasSet;
  }

  public function setN3($aN3)
  {
    $wasSet = false;
    $this->n3 = $aN3;
    $wasSet = true;
    return $wasSet;
  }

  public function setN4($aN4)
  {
    $wasSet = false;
    $this->n4 = $aN4;
    $wasSet = true;
    return $wasSet;
  }

  public function setNumCond($aNumCond)
  {
    $wasSet = false;
    $this->numCond = $aNumCond;
    $wasSet = true;
    return $wasSet;
  }

  public function getN1()
  {
    return $this->n1;
  }

  public function getN2()
  {
    return $this->n2;
  }

  public function getN3()
  {
    return $this->n3;
  }

  public function getN4()
  {
    return $this->n4;
  }

  public function getNumCond()
  {
    return $this->numCond;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>