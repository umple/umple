<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

class ManyAttribute
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ManyAttribute Attributes
  private $works;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->works = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function addWork($aWork)
  {
    $wasAdded = false;
    $this->works[] = $aWork;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeWork($aWork)
  {
    $wasRemoved = false;
    unset($this->works[$this->indexOfWork($aWork)]);
    $this->works = array_values($this->works);
    $wasRemoved = true;
    return $wasRemoved;
  }

  public function getWork($index)
  {
    $aWork = $this->works[$index];
    return $aWork;
  }

  public function getWorks()
  {
    $newWorks = $this->works;
    return $newWorks;
  }

  public function numberOfWorks()
  {
    $number = count($this->works);
    return $number;
  }

  public function hasWorks()
  {
    $has = works.size() > 0;
    return $has;
  }

  public function indexOfWork($aWork)
  {
    $rawAnswer = array_search($aWork,$this->works);
    $index = $rawAnswer == null && $rawAnswer !== 0 ? -1 : $rawAnswer;
    return $index;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>