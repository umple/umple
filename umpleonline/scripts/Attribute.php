<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.10.2.2921 modeling language!*/

class Attribute
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Attribute Attributes
  private $type;
  private $name;
  private $isList;

  //Attribute Associations
  private $classOverview;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aType, $aName, $aIsList, $aClassOverview)
  {
    $this->type = $aType;
    $this->name = $aName;
    $this->isList = $aIsList;
    $didAddClassOverview = $this->setClassOverview($aClassOverview);
    if (!$didAddClassOverview)
    {
      throw new Exception("Unable to create attribute due to classOverview");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setType($aType)
  {
    $wasSet = false;
    $this->type = $aType;
    $wasSet = true;
    return $wasSet;
  }

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function setIsList($aIsList)
  {
    $wasSet = false;
    $this->isList = $aIsList;
    $wasSet = true;
    return $wasSet;
  }

  public function getType()
  {
    return $this->type;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getIsList()
  {
    return $this->isList;
  }

  public function getClassOverview()
  {
    return $this->classOverview;
  }

  public function setClassOverview($aClassOverview)
  {
    $wasSet = false;
    if ($aClassOverview == null)
    {
      return $wasSet;
    }
    
    $existingClassOverview = $this->classOverview;
    $this->classOverview = $aClassOverview;
    if ($existingClassOverview != null && $existingClassOverview != $aClassOverview)
    {
      $existingClassOverview->removeAttribute($this);
    }
    $this->classOverview->addAttribute($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->classOverview->removeAttribute($this);
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  function getDisplayName()
  {
    return $this->getIsList() ? "{$this->name}s" : $this->name;
  }

  function getValue($simulator)
  {
    $obj = $simulator->getModel();

    if ($this->getIsList())
    {
      $uc = ucfirst($this->getName());
      $value = call_user_func(array($obj,"get{$uc}s"));
    }
    else
    {
      $uc = ucfirst($this->getName());
      $value = call_user_func(array($obj,"get{$uc}"));
    }

    if ($value == null)
    {
      return "--";
    }
    elseif (is_array($value))
    {
      $answer = "<ul>";
      foreach ($value as $obj)
      {
        $answer .= "<li>";
        $answer .= $this->getInstanceValue($simulator,$obj);
        $answer .= "</li>";
      }
      
      $answer .= "</ul>";
      return $answer;
    }
    else
    {
      return $this->getInstanceValue($simulator,$value);
    }

  }
  
  public function getInstanceValue($simulator,$obj)
  {
    $model = $this->getClassOverview()->getModelOverview();
    $classOverview = $model->getClass($obj);
  
    if ($classOverview != null)
    {
      $offset = $simulator->indexOfInstance($obj) + 1;
      return "[{$offset}] <a href=\"javascript:simulateCommand('load {$offset}');\">{$this->getType()}</a>";
    }
    else
    {
      return $obj;
    }
  }
}
?>