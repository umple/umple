<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class TraceAttr
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceAttr Attributes
  private $name;
  private $address;
  private $salary;
  private $id;
  private $flag;

  /**
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
  private $str;
  private $traceFlag1;
  private $traceFlag2;
  private $traceFlag3;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aAddress, $aSalary, $aFlag, $aNumCond, $aStrCond, $aNumber1, $aNumber2, $aNumber3, $aNumber4, $aStr)
  {
    $this->name = $aName;
    $this->address = $aAddress;
    $this->salary = $aSalary;
    $this->id = array();
    $this->flag = $aFlag;
    $this->numCond = $aNumCond;
    $this->strCond = $aStrCond;
    $this->number1 = $aNumber1;
    $this->number2 = $aNumber2;
    $this->number3 = $aNumber3;
    $this->number4 = $aNumber4;
    $this->str = $aStr;
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
    ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/jc/subversion/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,14,TraceAttr,".spl_object_hash( $this ).",at_s,name,".$this->name.",".(""+$aName)null );
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function setAddress($aAddress)
  {
    $wasSet = false;
    $this->address = $aAddress;
    $wasSet = true;
    return $wasSet;
  }

  public function setSalary($aSalary)
  {
    $wasSet = false;
    ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/jc/subversion/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,17,TraceAttr,".spl_object_hash( $this ).",at_s,salary,".$this->salary.",".(""+$aSalary)null );
    $this->salary = $aSalary;
    $wasSet = true;
    return $wasSet;
  }

  public function addId($aId)
  {
    $wasAdded = false;
    $this->id[] = $aId;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeId($aId)
  {
    $wasRemoved = false;
    unset($this->id[$this->indexOfId($aId)]);
    $this->id = array_values($this->id);
    $wasRemoved = true;
    return $wasRemoved;
  }

  public function setFlag($aFlag)
  {
    $wasSet = false;
    $this->flag = $aFlag;
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
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/jc/subversion/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,30,TraceAttr,".spl_object_hash( $this ).",at_s,number1,".$this->number1.",".(""+$aNumber1)null );
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
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/jc/subversion/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,31,TraceAttr,".spl_object_hash( $this ).",at_s,number2,".$this->number2 );
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
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/jc/subversion/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,32,TraceAttr,".spl_object_hash( $this ).",at_s,number3,".$this->number3 );
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
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/jc/subversion/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,33,TraceAttr,".spl_object_hash( $this ).",at_s,number4,".$this->number4 );
        }
    $wasSet = true;
    return $wasSet;
  }

  public function setStr($aStr)
  {
    $wasSet = false;
      if($traceFlag3<3)
        {
        ConsoleTracer::handle( gettimeofday(true).",".uniqid().",/home/jc/subversion/umple/testbed_php/src/../../testbed/src/TestHarnessTracer.ump,34,TraceAttr,".spl_object_hash( $this ).",at_s,str,".$this->str.",".(""+$aStr)null );
      traceFlag3++;
        }
    $this->str = $aStr;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getAddress()
  {
    return $this->address;
  }

  public function getSalary()
  {
    return $this->salary;
  }

  public function getId($index)
  {
    $aId = $this->id[$index];
    return $aId;
  }

  public function getId()
  {
    $newId = $this->id;
    return $newId;
  }

  public function numberOfId()
  {
    $number = count($this->id);
    return $number;
  }

  public function hasId()
  {
    $has = id.size() > 0;
    return $has;
  }

  public function indexOfId($aId)
  {
    $rawAnswer = array_search($aId,$this->id);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function getFlag()
  {
    return $this->flag;
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

  public function getStr()
  {
    return $this->str;
  }

  public function isFlag()
  {
    return $this->flag;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>