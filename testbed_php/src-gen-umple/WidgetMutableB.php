<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class WidgetMutableB
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetMutableB Associations
  private $widgetImmutableBs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->widgetImmutableBs = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getWidgetImmutableB($index)
  {
    $aWidgetImmutableB = $this->widgetImmutableBs[$index];
    return $aWidgetImmutableB;
  }

  public function getWidgetImmutableBs()
  {
    $newWidgetImmutableBs = $this->widgetImmutableBs;
    return $newWidgetImmutableBs;
  }

  public function numberOfWidgetImmutableBs()
  {
    $number = count($this->widgetImmutableBs);
    return $number;
  }

  public function hasWidgetImmutableBs()
  {
    $has = $this->numberOfWidgetImmutableBs() > 0;
    return $has;
  }

  public function indexOfWidgetImmutableB($aWidgetImmutableB)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->widgetImmutableBs as $widgetImmutableB)
    {
      if ($widgetImmutableB->equals($aWidgetImmutableB))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfWidgetImmutableBs()
  {
    return 0;
  }

  public static function maximumNumberOfWidgetImmutableBs()
  {
    return 10;
  }

  public function addWidgetImmutableB($aWidgetImmutableB)
  {
    $wasAdded = false;
    if ($this->indexOfWidgetImmutableB($aWidgetImmutableB) !== -1) { return false; }
    if ($this->numberOfWidgetImmutableBs() < self::maximumNumberOfWidgetImmutableBs())
    {
      $this->widgetImmutableBs[] = $aWidgetImmutableB;
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function removeWidgetImmutableB($aWidgetImmutableB)
  {
    $wasRemoved = false;
    if ($this->indexOfWidgetImmutableB($aWidgetImmutableB) != -1)
    {
      unset($this->widgetImmutableBs[$this->indexOfWidgetImmutableB($aWidgetImmutableB)]);
      $this->widgetImmutableBs = array_values($this->widgetImmutableBs);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function setWidgetImmutableBs($newWidgetImmutableBs)
  {
    $wasSet = false;
    $verifiedWidgetImmutableBs = array();
    foreach ($newWidgetImmutableBs as $aWidgetImmutableB)
    {
      if (array_search($aWidgetImmutableB,$verifiedWidgetImmutableBs) !== false)
      {
        continue;
      }
      $verifiedWidgetImmutableBs[] = $aWidgetImmutableB;
    }

    if (count($verifiedWidgetImmutableBs) != count($newWidgetImmutableBs) || count($verifiedWidgetImmutableBs) > self::maximumNumberOfWidgetImmutableBs())
    {
      return $wasSet;
    }

    $this->widgetImmutableBs = $verifiedWidgetImmutableBs;
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->widgetImmutableBs = array();
  }

}
?>