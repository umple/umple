<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.10.2.2921 modeling language!*/

class ModelOverview
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ModelOverview Associations
  private $classOverviews;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->classOverviews = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getClassOverview($index)
  {
    $aClassOverview = $this->classOverviews[$index];
    return $aClassOverview;
  }

  public function getClassOverviews()
  {
    $newClassOverviews = $this->classOverviews;
    return $newClassOverviews;
  }

  public function numberOfClassOverviews()
  {
    $number = count($this->classOverviews);
    return $number;
  }

  public function hasClassOverviews()
  {
    $has = $this->numberOfClassOverviews() > 0;
    return $has;
  }

  public function indexOfClassOverview($aClassOverview)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->classOverviews as $classOverview)
    {
      if ($classOverview->equals($aClassOverview))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function addClassOverviewVia($aName)
  {
    return new ClassOverview($aName, $this);
  }

  public function addClassOverview($aClassOverview)
  {
    $wasAdded = false;
    if ($this->indexOfClassOverview($aClassOverview) !== -1) { return false; }
    $existingModelOverview = $aClassOverview->getModelOverview();
    $isNewModelOverview = $existingModelOverview != null && $this !== $existingModelOverview;
    if ($isNewModelOverview)
    {
      $aClassOverview->setModelOverview($this);
    }
    else
    {
      $this->classOverviews[] = $aClassOverview;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeClassOverview($aClassOverview)
  {
    $wasRemoved = false;
    //Unable to remove aClassOverview, as it must always have a modelOverview
    if ($this !== $aClassOverview->getModelOverview())
    {
      unset($this->classOverviews[$this->indexOfClassOverview($aClassOverview)]);
      $this->classOverviews = array_values($this->classOverviews);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->classOverviews as $aClassOverview)
    {
      $aClassOverview->delete();
    }
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public function getClass($obj)
  {
    if ($obj == null)
    {
      return null;
    }
    $className = get_class($obj);
    foreach ($this->classOverviews as $aClass)
    {
      if ($aClass->getName() == $className)
      {
        return $aClass;
      } 
    }
    return null;
  }
}
?>