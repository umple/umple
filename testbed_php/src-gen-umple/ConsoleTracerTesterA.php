<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class ConsoleTracerTesterA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConsoleTracerTesterA Attributes
  private $name;

  /**
   * address;
   * trace get address;
   * Trace attributes with conditions
   */
  private $numCond;

  /**
   * ToBe added string constrints
   */
  private $strCond;
  private $number1;
  private $number2;
  private $number3;
  private $number4;
  private $number5;
  private $traceFlag1;
  private $traceFlag2;
  private $traceFlag3;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aNumCond, $aStrCond, $aNumber1, $aNumber2, $aNumber3, $aNumber4, $aNumber5)
  {
    $this->name = $aName;
    $this->numCond = $aNumCond;
    $this->strCond = $aStrCond;
    $this->number1 = $aNumber1;
    $this->number2 = $aNumber2;
    $this->number3 = $aNumber3;
    $this->number4 = $aNumber4;
    $this->number5 = $aNumber5;
    $this->traceFlag1 = false;
    $this->traceFlag2 = true;
    $this->traceFlag3 = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/Documents/7--Research/2-CRuiSE/codebase/googleumple/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,10,ConsoleTracerTesterA,".spl_object_hash( $this ).",at_s,name,".$this->name.",".$aName );
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function setNumCond($aNumCond)
  {
    $wasSet = false;
    $this->numCond = $aNumCond;
    $wasSet = true;
      if(@numCond==1) then
        
        traceFlag1=true;
         end
      if(@numCond<=0) then
        
        traceFlag2=false;
         end
    return $wasSet;
  }

  public function setStrCond($aStrCond)
  {
    $wasSet = false;
    $this->strCond = $aStrCond;
    $wasSet = true;
    return $wasSet;
  }

  public function setNumber1($aNumber1)
  {
    $wasSet = false;
      if($numCond>100)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/Documents/7--Research/2-CRuiSE/codebase/googleumple/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,26,ConsoleTracerTesterA,".spl_object_hash( $this ).",at_s,number1,".$this->number1.",".$aNumber1 );
        }
    $this->number1 = $aNumber1;
    $wasSet = true;
    return $wasSet;
  }

  public function setNumber2($aNumber2)
  {
    $wasSet = false;
    $this->number2 = $aNumber2;
      if($numCond==20)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/Documents/7--Research/2-CRuiSE/codebase/googleumple/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,27,ConsoleTracerTesterA,".spl_object_hash( $this ).",at_s,number2,".$this->number2 );
        }
    $wasSet = true;
    return $wasSet;
  }

  public function setNumber3($aNumber3)
  {
    $wasSet = false;
    $this->number3 = $aNumber3;
      if($traceFlag1)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/Documents/7--Research/2-CRuiSE/codebase/googleumple/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,28,ConsoleTracerTesterA,".spl_object_hash( $this ).",at_s,number3,".$this->number3 );
        }
    $wasSet = true;
    return $wasSet;
  }

  public function setNumber4($aNumber4)
  {
    $wasSet = false;
    $this->number4 = $aNumber4;
      if($traceFlag2)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/Documents/7--Research/2-CRuiSE/codebase/googleumple/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,29,ConsoleTracerTesterA,".spl_object_hash( $this ).",at_s,number4,".$this->number4 );
        }
    $wasSet = true;
    return $wasSet;
  }

  public function setNumber5($aNumber5)
  {
    $wasSet = false;
      if($traceFlag3<3)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/Users/tcl/Documents/7--Research/2-CRuiSE/codebase/googleumple/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,30,ConsoleTracerTesterA,".spl_object_hash( $this ).",at_s,number5,".$this->number5.",".$aNumber5 );
      traceFlag3++;
        }
    $this->number5 = $aNumber5;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getNumCond()
  {
    return $this->numCond;
  }

  public function getStrCond()
  {
    return $this->strCond;
  }

  public function getNumber1()
  {
    return $this->number1;
  }

  public function getNumber2()
  {
    return $this->number2;
  }

  public function getNumber3()
  {
    return $this->number3;
  }

  public function getNumber4()
  {
    return $this->number4;
  }

  public function getNumber5()
  {
    return $this->number5;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>