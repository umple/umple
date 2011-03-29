<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.10.2.2921 modeling language!*/

class ClassOverview
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassOverview Attributes
  private $name;

  //ClassOverview Associations
  private $attributes;
  private $stateMachines;
  private $associationEnds;
  private $modelOverview;

  //Helper Variables
  private $cachedHashCode;
  private $canSetName;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName, $aModelOverview)
  {
    $this->name = $aName;
    $this->attributes = array();
    $this->stateMachines = array();
    $this->associationEnds = array();
    $didAddModelOverview = $this->setModelOverview($aModelOverview);
    if (!$didAddModelOverview)
    {
      throw new Exception("Unable to create classOverview due to modelOverview");
    }
    $this->cachedHashCode = -1;
    $this->canSetName = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    if (!$this->canSetName) { return false; }
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getAttribute($index)
  {
    $aAttribute = $this->attributes[$index];
    return $aAttribute;
  }

  public function getAttributes()
  {
    $newAttributes = $this->attributes;
    return $newAttributes;
  }

  public function numberOfAttributes()
  {
    $number = count($this->attributes);
    return $number;
  }

  public function hasAttributes()
  {
    $has = $this->numberOfAttributes() > 0;
    return $has;
  }

  public function indexOfAttribute($aAttribute)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->attributes as $attribute)
    {
      if ($attribute->equals($aAttribute))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getStateMachine($index)
  {
    $aStateMachine = $this->stateMachines[$index];
    return $aStateMachine;
  }

  public function getStateMachines()
  {
    $newStateMachines = $this->stateMachines;
    return $newStateMachines;
  }

  public function numberOfStateMachines()
  {
    $number = count($this->stateMachines);
    return $number;
  }

  public function hasStateMachines()
  {
    $has = $this->numberOfStateMachines() > 0;
    return $has;
  }

  public function indexOfStateMachine($aStateMachine)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stateMachines as $stateMachine)
    {
      if ($stateMachine->equals($aStateMachine))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getAssociationEnd($index)
  {
    $aAssociationEnd = $this->associationEnds[$index];
    return $aAssociationEnd;
  }

  public function getAssociationEnds()
  {
    $newAssociationEnds = $this->associationEnds;
    return $newAssociationEnds;
  }

  public function numberOfAssociationEnds()
  {
    $number = count($this->associationEnds);
    return $number;
  }

  public function hasAssociationEnds()
  {
    $has = $this->numberOfAssociationEnds() > 0;
    return $has;
  }

  public function indexOfAssociationEnd($aAssociationEnd)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->associationEnds as $associationEnd)
    {
      if ($associationEnd->equals($aAssociationEnd))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getModelOverview()
  {
    return $this->modelOverview;
  }

  public function addAttributeVia($aType, $aName, $aIsList)
  {
    return new Attribute($aType, $aName, $aIsList, $this);
  }

  public function addAttribute($aAttribute)
  {
    $wasAdded = false;
    if ($this->indexOfAttribute($aAttribute) !== -1) { return false; }
    $existingClassOverview = $aAttribute->getClassOverview();
    $isNewClassOverview = $existingClassOverview != null && $this !== $existingClassOverview;
    if ($isNewClassOverview)
    {
      $aAttribute->setClassOverview($this);
    }
    else
    {
      $this->attributes[] = $aAttribute;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeAttribute($aAttribute)
  {
    $wasRemoved = false;
    //Unable to remove aAttribute, as it must always have a classOverview
    if ($this !== $aAttribute->getClassOverview())
    {
      unset($this->attributes[$this->indexOfAttribute($aAttribute)]);
      $this->attributes = array_values($this->attributes);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addStateMachineVia($aName)
  {
    return new StateMachine($aName, $this);
  }

  public function addStateMachine($aStateMachine)
  {
    $wasAdded = false;
    if ($this->indexOfStateMachine($aStateMachine) !== -1) { return false; }
    $existingClassOverview = $aStateMachine->getClassOverview();
    $isNewClassOverview = $existingClassOverview != null && $this !== $existingClassOverview;
    if ($isNewClassOverview)
    {
      $aStateMachine->setClassOverview($this);
    }
    else
    {
      $this->stateMachines[] = $aStateMachine;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeStateMachine($aStateMachine)
  {
    $wasRemoved = false;
    //Unable to remove aStateMachine, as it must always have a classOverview
    if ($this !== $aStateMachine->getClassOverview())
    {
      unset($this->stateMachines[$this->indexOfStateMachine($aStateMachine)]);
      $this->stateMachines = array_values($this->stateMachines);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addAssociationEndVia($aLowerBound, $aUpperBound, $aRoleType, $aRoleName)
  {
    return new AssociationEnd($aLowerBound, $aUpperBound, $aRoleType, $aRoleName, $this);
  }

  public function addAssociationEnd($aAssociationEnd)
  {
    $wasAdded = false;
    if ($this->indexOfAssociationEnd($aAssociationEnd) !== -1) { return false; }
    $existingClassOverview = $aAssociationEnd->getClassOverview();
    $isNewClassOverview = $existingClassOverview != null && $this !== $existingClassOverview;
    if ($isNewClassOverview)
    {
      $aAssociationEnd->setClassOverview($this);
    }
    else
    {
      $this->associationEnds[] = $aAssociationEnd;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeAssociationEnd($aAssociationEnd)
  {
    $wasRemoved = false;
    //Unable to remove aAssociationEnd, as it must always have a classOverview
    if ($this !== $aAssociationEnd->getClassOverview())
    {
      unset($this->associationEnds[$this->indexOfAssociationEnd($aAssociationEnd)]);
      $this->associationEnds = array_values($this->associationEnds);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function setModelOverview($aModelOverview)
  {
    $wasSet = false;
    if ($aModelOverview == null)
    {
      return $wasSet;
    }
    
    $existingModelOverview = $this->modelOverview;
    $this->modelOverview = $aModelOverview;
    if ($existingModelOverview != null && $existingModelOverview != $aModelOverview)
    {
      $existingModelOverview->removeClassOverview($this);
    }
    $this->modelOverview->addClassOverview($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    if ($compareTo == null) { return false; }
    if (get_class($this) != get_class($compareTo)) { return false; }

    if ($this->name != $compareTo->name)
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
    if ($this->name != null)
    {
      $this->cachedHashCode = $this->cachedHashCode * 23 + spl_object_hash($this->name);
    }
    else
    {
      $this->cachedHashCode = $this->cachedHashCode * 23;
    }

    $this->canSetName = false;
    return $this->cachedHashCode;
  }

  public function delete()
  {
    foreach ($this->attributes as $aAttribute)
    {
      $aAttribute->delete();
    }
    foreach ($this->stateMachines as $aStateMachine)
    {
      $aStateMachine->delete();
    }
    foreach ($this->associationEnds as $aAssociationEnd)
    {
      $aAssociationEnd->delete();
    }
    $this->modelOverview->removeClassOverview($this);
  }

}
?>