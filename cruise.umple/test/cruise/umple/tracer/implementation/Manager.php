<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class Manager
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Manager Associations
  private $companies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->companies = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getCompany($index)
  {
    $aCompany = $this->companies[$index];
    return $aCompany;
  }

  public function getCompanies()
  {
    $newCompanies = $this->companies;
    return $newCompanies;
  }

  public function numberOfCompanies()
  {
    $number = count($this->companies);
    return $number;
  }

  public function hasCompanies()
  {
    $has = $this->numberOfCompanies() > 0;
    return $has;
  }

  public function indexOfCompany($aCompany)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->companies as $company)
    {
      if ($company->equals($aCompany))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfCompanies()
  {
    return 0;
  }

  public function addCompany($aCompany)
  {
    $wasAdded = false;
    if ($this->indexOfCompany($aCompany) !== -1) { return false; }
    $this->companies[] = $aCompany;
    if ($aCompany->indexOfManager($this) != -1)
    {
      $wasAdded = true;
    }
    else
    {
      $wasAdded = $aCompany->addManager($this);
      if (!$wasAdded)
      {
        array_pop($this->companies);
      }
    }
    return $wasAdded;
  }

  public function removeCompany($aCompany)
  {
    $wasRemoved = false;
    if ($this->indexOfCompany($aCompany) == -1)
    {
      return $wasRemoved;
    }

    $oldIndex = $this->indexOfCompany($aCompany);
    unset($this->companies[$oldIndex]);
    if ($aCompany->indexOfManager($this) == -1)
    {
      $wasRemoved = true;
    }
    else
    {
      $wasRemoved = $aCompany->removeManager($this);
      if (!$wasRemoved)
      {
        $this->companies[$oldIndex] = $aCompany;
        ksort($this->companies);
      }
    }
    $this->companies = array_values($this->companies);
    return $wasRemoved;
  }

  public function addCompanyAt($aCompany, $index)
  {  
    $wasAdded = false;
    if($this->addCompany($aCompany))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfCompanies()) { $index = $this->numberOfCompanies() - 1; }
      array_splice($this->companies, $this->indexOfCompany($aCompany), 1);
      array_splice($this->companies, $index, 0, array($aCompany));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveCompanyAt($aCompany, $index)
  {
    $wasAdded = false;
    if($this->indexOfCompany($aCompany) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfCompanies()) { $index = $this->numberOfCompanies() - 1; }
      array_splice($this->companies, $this->indexOfCompany($aCompany), 1);
      array_splice($this->companies, $index, 0, array($aCompany));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addCompanyAt($aCompany, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $copyOfCompanies = $this->companies;
    $this->companies = array();
    foreach ($copyOfCompanies as $aCompany)
    {
      $aCompany->removeManager($this);
    }
  }

}
?>