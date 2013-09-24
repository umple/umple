<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

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
  private $n5;
  private $n6;
  private $n7;
  private $n8;
  private $n9;
  private $n10;
  private $numCond;
  private $traceFlag4;
  private $traceFlag5;
  private $traceFlag6;
  private $traceFlag7;
  private $traceFlag8;
  private $traceFlag9;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aN1, $aN2, $aN3, $aN4, $aN5, $aN6, $aN7, $aN8, $aN9, $aN10, $aNumCond)
  {
    $this->n1 = $aN1;
    $this->n2 = $aN2;
    $this->n3 = $aN3;
    $this->n4 = $aN4;
    $this->n5 = $aN5;
    $this->n6 = $aN6;
    $this->n7 = $aN7;
    $this->n8 = $aN8;
    $this->n9 = $aN9;
    $this->n10 = $aN10;
    $this->numCond = $aNumCond;
    $this->traceFlag4 = 0;
    $this->traceFlag5 = 0;
    $this->traceFlag6 = false;
    $this->traceFlag7 = 0;
    $this->traceFlag8 = true;
    $this->traceFlag9 = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setN1($aN1)
  {
    $wasSet = false;
      if($aN1>100&&$traceFlag4<2)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/nobackup-tmp/CheckoutForUmplePatchTest3/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,53,TraceAttrCond,".spl_object_hash( $this ).",at_s,n1,".$this->n1.",".(""+$aN1)null );
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
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/nobackup-tmp/CheckoutForUmplePatchTest3/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,54,TraceAttrCond,".spl_object_hash( $this ).",at_s,n2,".$this->n2 );
      traceFlag5++;
        }
    $wasSet = true;
    return $wasSet;
  }

  public function setN3($aN3)
  {
    $wasSet = false;
    $this->n3 = $aN3;
      if($traceFlag6&&$traceFlag7<2)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/nobackup-tmp/CheckoutForUmplePatchTest3/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,55,TraceAttrCond,".spl_object_hash( $this ).",at_s,n3,".$this->n3 );
      traceFlag7++;
        }
    $wasSet = true;
      if(@n3>20) then
        
        traceFlag6=true;
         end
    return $wasSet;
  }

  public function setN4($aN4)
  {
    $wasSet = false;
    $this->n4 = $aN4;
      if($traceFlag8&&$traceFlag9<2)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/nobackup-tmp/CheckoutForUmplePatchTest3/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,56,TraceAttrCond,".spl_object_hash( $this ).",at_s,n4,".$this->n4 );
      traceFlag9++;
        }
    $wasSet = true;
      if(@n4>10) then
        
        traceFlag8=false;
         end
    return $wasSet;
  }

  public function setN5($aN5)
  {
    $wasSet = false;
    $this->n5 = $aN5;
    $wasSet = true;
    return $wasSet;
  }

  public function setN6($aN6)
  {
    $wasSet = false;
    $this->n6 = $aN6;
    $wasSet = true;
    return $wasSet;
  }

  public function setN7($aN7)
  {
    $wasSet = false;
    $this->n7 = $aN7;
    $wasSet = true;
    return $wasSet;
  }

  public function setN8($aN8)
  {
    $wasSet = false;
    $this->n8 = $aN8;
    $wasSet = true;
    return $wasSet;
  }

  public function setN9($aN9)
  {
    $wasSet = false;
    $this->n9 = $aN9;
    $wasSet = true;
    return $wasSet;
  }

  public function setN10($aN10)
  {
    $wasSet = false;
    $this->n10 = $aN10;
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

  public function getN5()
  {
    return $this->n5;
  }

  public function getN6()
  {
    return $this->n6;
  }

  public function getN7()
  {
    return $this->n7;
  }

  public function getN8()
  {
    return $this->n8;
  }

  public function getN9()
  {
    return $this->n9;
  }

  public function getN10()
  {
    return $this->n10;
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