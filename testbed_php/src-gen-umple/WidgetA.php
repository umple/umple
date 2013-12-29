<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

class WidgetA
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WidgetA Attributes
  private $id;
  private $intId;
  private $doubleId;
  private $boolId;
  private $dateId;
  private $widgetId;
  private $ignore;

  //Helper Variables
  private $cachedHashCode;
  private $canSetId;
  private $canSetIntId;
  private $canSetDoubleId;
  private $canSetBoolId;
  private $canSetDateId;
  private $canSetWidgetId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId, $aIntId, $aDoubleId, $aBoolId, $aDateId, $aWidgetId, $aIgnore)
  {
    $this->cachedHashCode = -1;
    $this->canSetId = true;
    $this->canSetIntId = true;
    $this->canSetDoubleId = true;
    $this->canSetBoolId = true;
    $this->canSetDateId = true;
    $this->canSetWidgetId = true;
    $this->id = $aId;
    $this->intId = $aIntId;
    $this->doubleId = $aDoubleId;
    $this->boolId = $aBoolId;
    $this->dateId = $aDateId;
    $this->widgetId = $aWidgetId;
    $this->ignore = $aIgnore;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    if (!$this->canSetId) { return false; }
    $this->id = $aId;
    $wasSet = true;
    return $wasSet;
  }

  public function setIntId($aIntId)
  {
    $wasSet = false;
    if (!$this->canSetIntId) { return false; }
    $this->intId = $aIntId;
    $wasSet = true;
    return $wasSet;
  }

  public function setDoubleId($aDoubleId)
  {
    $wasSet = false;
    if (!$this->canSetDoubleId) { return false; }
    $this->doubleId = $aDoubleId;
    $wasSet = true;
    return $wasSet;
  }

  public function setBoolId($aBoolId)
  {
    $wasSet = false;
    if (!$this->canSetBoolId) { return false; }
    $this->boolId = $aBoolId;
    $wasSet = true;
    return $wasSet;
  }

  public function setDateId($aDateId)
  {
    $wasSet = false;
    if (!$this->canSetDateId) { return false; }
    $this->dateId = $aDateId;
    $wasSet = true;
    return $wasSet;
  }

  public function setWidgetId($aWidgetId)
  {
    $wasSet = false;
    if (!$this->canSetWidgetId) { return false; }
    $this->widgetId = $aWidgetId;
    $wasSet = true;
    return $wasSet;
  }

  public function setIgnore($aIgnore)
  {
    $wasSet = false;
    $this->ignore = $aIgnore;
    $wasSet = true;
    return $wasSet;
  }

  public function getId()
  {
    return $this->id;
  }

  public function getIntId()
  {
    return $this->intId;
  }

  public function getDoubleId()
  {
    return $this->doubleId;
  }

  public function getBoolId()
  {
    return $this->boolId;
  }

  public function getDateId()
  {
    return $this->dateId;
  }

  public function getWidgetId()
  {
    return $this->widgetId;
  }

  public function getIgnore()
  {
    return $this->ignore;
  }

  public function isBoolId()
  {
    return $this->boolId;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->id != $compareTo->id)
    {
      return false;
    }

    if ($this->intId != $compareTo->intId)
    {
      return false;
    }

    if ($this->doubleId != $compareTo->doubleId)
    {
      return false;
    }

    if ($this->boolId != $compareTo->boolId)
    {
      return false;
    }

    if ($this->dateId != $compareTo->dateId)
    {
      return false;
    }

    if ($this->widgetId != $compareTo->widgetId)
    {
      return false;
    }

    return true;
  }

  public function hashCode()
  {
    if ($this->cachedHashCode != -1)
    {
      return $this->cachedHashCode;
    }
    $this->cachedHashCode = 17;
    if ($this->id != null)
    {
      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->id);
    }
    else
    {
      $this->cachedHashCode = $this->cachedHashCode * 23;
    }

    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->intId;

    $this->cachedHashCode = $this->cachedHashCode * 23 + $this->doubleId;

    $this->cachedHashCode = $this->cachedHashCode * 23 + ($this->boolId ? 1 : 0);

    if ($this->dateId != null)
    {
      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->dateId);
    }
    else
    {
      $this->cachedHashCode = $this->cachedHashCode * 23;
    }

    if ($this->widgetId != null)
    {
      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->widgetId);
    }
    else
    {
      $this->cachedHashCode = $this->cachedHashCode * 23;
    }

    $this->canSetId = false;
    $this->canSetIntId = false;
    $this->canSetDoubleId = false;
    $this->canSetBoolId = false;
    $this->canSetDateId = false;
    $this->canSetWidgetId = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {}

}
?>