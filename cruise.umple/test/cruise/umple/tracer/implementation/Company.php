<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class Company
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Company Associations
  private $manager;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->manager = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getManager($index)
  {
    $aManager = $this->manager[$index];
    return $aManager;
  }

  public function getManager()
  {
    $newManager = $this->manager;
    return $newManager;
  }

  public function numberOfManager()
  {
    $number = count($this->manager);
    return $number;
  }

  public function hasManager()
  {
    $has = $this->numberOfManager() > 0;
    return $has;
  }

  public function indexOfManager($aManager)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->manager as $manager)
    {
      if ($manager->equals($aManager))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfManager()
  {
    return 0;
  }

  public function addManager($aManager)
  {
    $wasAdded = false;
    if ($this->indexOfManager($aManager) !== -1) { return false; }
    $this->manager[] = $aManager;
    if ($aManager->indexOfCompany($this) != -1)
    {
      $wasAdded = true;
    }
    else
    {
      $wasAdded = $aManager->addCompany($this);
      if (!$wasAdded)
      {
        array_pop($this->manager);
      }
    }
    return $wasAdded;
  }

  public function removeManager($aManager)
  {
    $wasRemoved = false;
    if ($this->indexOfManager($aManager) == -1)
    {
      return $wasRemoved;
    }

    $oldIndex = $this->indexOfManager($aManager);
    unset($this->manager[$oldIndex]);
    if ($aManager->indexOfCompany($this) == -1)
    {
      $wasRemoved = true;
    }
    else
    {
      $wasRemoved = $aManager->removeCompany($this);
      if (!$wasRemoved)
      {
        $this->manager[$oldIndex] = $aManager;
        ksort($this->manager);
      }
    }
    $this->manager = array_values($this->manager);
    return $wasRemoved;
  }

  public function addManagerAt($aManager, $index)
  {  
    $wasAdded = false;
    if($this->addManager($aManager))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfManager()) { $index = $this->numberOfManager() - 1; }
      array_splice($this->manager, $this->indexOfManager($aManager), 1);
      array_splice($this->manager, $index, 0, array($aManager));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveManagerAt($aManager, $index)
  {
    $wasAdded = false;
    if($this->indexOfManager($aManager) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfManager()) { $index = $this->numberOfManager() - 1; }
      array_splice($this->manager, $this->indexOfManager($aManager), 1);
      array_splice($this->manager, $index, 0, array($aManager));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addManagerAt($aManager, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $copyOfManager = $this->manager;
    $this->manager = array();
    foreach ($copyOfManager as $aManager)
    {
      $aManager->removeCompany($this);
    }
  }

}
?>