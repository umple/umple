<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class WidgetSubclass extends WidgetImmutableA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetSubclass Attributes
  private $type;

  //Helper Variables
  private $canSetType;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aWidgetImmutableB, $aType)
  {
    parent::__construct($aName, $aWidgetImmutableB);
    $this->type = $aType;
    $this->canSetType = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getType()
  {
    return $this->type;
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