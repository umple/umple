<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.10.2.2921 modeling language!*/

class AssociationEnd
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssociationEnd Attributes
  private $lowerBound;
  private $upperBound;
  private $roleType;
  private $roleName;

  //AssociationEnd Associations
  private $classOverview;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aLowerBound, $aUpperBound, $aRoleType, $aRoleName, $aClassOverview)
  {
    $this->lowerBound = $aLowerBound;
    $this->upperBound = $aUpperBound;
    $this->roleType = $aRoleType;
    $this->roleName = $aRoleName;
    $didAddClassOverview = $this->setClassOverview($aClassOverview);
    if (!$didAddClassOverview)
    {
      throw new Exception("Unable to create associationEnd due to classOverview");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setLowerBound($aLowerBound)
  {
    $wasSet = false;
    $this->lowerBound = $aLowerBound;
    $wasSet = true;
    return $wasSet;
  }

  public function setUpperBound($aUpperBound)
  {
    $wasSet = false;
    $this->upperBound = $aUpperBound;
    $wasSet = true;
    return $wasSet;
  }

  public function setRoleType($aRoleType)
  {
    $wasSet = false;
    $this->roleType = $aRoleType;
    $wasSet = true;
    return $wasSet;
  }

  public function setRoleName($aRoleName)
  {
    $wasSet = false;
    $this->roleName = $aRoleName;
    $wasSet = true;
    return $wasSet;
  }

  public function getLowerBound()
  {
    return $this->lowerBound;
  }

  public function getUpperBound()
  {
    return $this->upperBound;
  }

  public function getRoleType()
  {
    return $this->roleType;
  }

  public function getRoleName()
  {
    return $this->roleName;
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
      $existingClassOverview->removeAssociationEnd($this);
    }
    $this->classOverview->addAssociationEnd($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->classOverview->removeAssociationEnd($this);
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  function getValue($simulator)
  {
    $obj = $simulator->getModel();

    if ($this->getUpperBound() == 1)
    {
      $uc = ucfirst($this->getRoleName());
      $value = call_user_func(array($obj,"get{$uc}"));
    }
    else
    {
      $uc = ucfirst($this->getRoleName());
      $value = call_user_func(array($obj,"get{$uc}s"));
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
      return "{$offset} <a href=\"javascript:simulateCommand('load {$offset}');\">{$this->getRoleType()}</a>";
    }
    else
    {
      return "?{$value}?";
    }
  }
}
?>