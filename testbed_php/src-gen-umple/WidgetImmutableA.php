<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class WidgetImmutableA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetImmutableA Attributes
  private $name;

  //WidgetImmutableA Associations
  private $widgetImmutableB;

  //Helper Variables
  private $canSetName;
  private $canSetWidgetImmutableB;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aWidgetImmutableB)
  {
    $this->name = $aName;
    $this->canSetName = false;
    $this->canSetWidgetImmutableB = true;
    $this->setWidgetImmutableB($aWidgetImmutableB);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getName()
  {
    return $this->name;
  }

  public function getWidgetImmutableB()
  {
    return $this->widgetImmutableB;
  }

  private function setWidgetImmutableB($newWidgetImmutableB)
  {
    $wasSet = false;
    if (!$this->canSetWidgetImmutableB) { return false; }
    $this->canSetWidgetImmutableB = false;
    $this->widgetImmutableB = $newWidgetImmutableB;
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>