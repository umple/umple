<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class MultipleSortedCourse
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MultipleSortedCourse Attributes
  private $code;
  private $multipleSortedRegistrationsPriority;

  //MultipleSortedCourse Associations
  private $multipleSortedAcademy;
  private $multipleSortedRegistrations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aCode, $aMultipleSortedAcademy)
  {
    $this->code = $aCode;
    $this->multipleSortedRegistrationsPriority = 
      function($x, $y)
      {
        return $x->getName() -
               $y->getName();
      };
    $didAddMultipleSortedAcademy = $this->setMultipleSortedAcademy($aMultipleSortedAcademy);
    if (!$didAddMultipleSortedAcademy)
    {
      throw new Exception("Unable to create multipleSortedCourse due to multipleSortedAcademy");
    }
    $this->multipleSortedRegistrations = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setCode($aCode)
  {
    $wasSet = false;
    $this->code = $aCode;
    $wasSet = true;
    return $wasSet;
  }

  public function setMultipleSortedRegistrationsPriority($aMultipleSortedRegistrationsPriority)
  {
    $wasSet = false;
    $this->multipleSortedRegistrationsPriority = $aMultipleSortedRegistrationsPriority;
    $wasSet = true;
    return $wasSet;
  }

  public function getCode()
  {
    return $this->code;
  }

  public function getMultipleSortedRegistrationsPriority()
  {
    return $this->multipleSortedRegistrationsPriority;
  }

  public function getMultipleSortedAcademy()
  {
    return $this->multipleSortedAcademy;
  }

  public function getMultipleSortedRegistration($index)
  {
    $aMultipleSortedRegistration = $this->multipleSortedRegistrations[$index];
    return $aMultipleSortedRegistration;
  }

  public function getMultipleSortedRegistrations()
  {
    $newMultipleSortedRegistrations = $this->multipleSortedRegistrations;
    return $newMultipleSortedRegistrations;
  }

  public function numberOfMultipleSortedRegistrations()
  {
    $number = count($this->multipleSortedRegistrations);
    return $number;
  }

  public function hasMultipleSortedRegistrations()
  {
    $has = $this->numberOfMultipleSortedRegistrations() > 0;
    return $has;
  }

  public function indexOfMultipleSortedRegistration($aMultipleSortedRegistration)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->multipleSortedRegistrations as $multipleSortedRegistration)
    {
      if ($multipleSortedRegistration->equals($aMultipleSortedRegistration))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function setMultipleSortedAcademy($aMultipleSortedAcademy)
  {
    $wasSet = false;
    if ($aMultipleSortedAcademy == null)
    {
      return $wasSet;
    }
    
    $existingMultipleSortedAcademy = $this->multipleSortedAcademy;
    $this->multipleSortedAcademy = $aMultipleSortedAcademy;
    if ($existingMultipleSortedAcademy != null && $existingMultipleSortedAcademy != $aMultipleSortedAcademy)
    {
      $existingMultipleSortedAcademy->removeMultipleSortedCourse($this);
    }
    $this->multipleSortedAcademy->addMultipleSortedCourse($this);
    $wasSet = true;
    return $wasSet;
  }

  public static function minimumNumberOfMultipleSortedRegistrations()
  {
    return 0;
  }

  public function addMultipleSortedRegistrationVia($aMultipleSortedStudent)
  {
    return new MultipleSortedRegistration($this, $aMultipleSortedStudent);
  }

  public function addMultipleSortedRegistration($aMultipleSortedRegistration)
  {
    $wasAdded = false;
    if ($this->indexOfMultipleSortedRegistration($aMultipleSortedRegistration) !== -1) { return false; }
    $existingMultipleSortedCourse = $aMultipleSortedRegistration->getMultipleSortedCourse();
    $isNewMultipleSortedCourse = $existingMultipleSortedCourse != null && $this !== $existingMultipleSortedCourse;
    if ($isNewMultipleSortedCourse)
    {
      $aMultipleSortedRegistration->setMultipleSortedCourse($this);
    }
    else
    {
      $this->multipleSortedRegistrations[] = $aMultipleSortedRegistration;
    }
    $wasAdded = true;
    if(wasAdded)
        usort($this->multipleSortedRegistrations, $this->multipleSortedRegistrationsPriority);
    
    return $wasAdded;
  }

  public function removeMultipleSortedRegistration($aMultipleSortedRegistration)
  {
    $wasRemoved = false;
    //Unable to remove aMultipleSortedRegistration, as it must always have a multipleSortedCourse
    if ($this !== $aMultipleSortedRegistration->getMultipleSortedCourse())
    {
      unset($this->multipleSortedRegistrations[$this->indexOfMultipleSortedRegistration($aMultipleSortedRegistration)]);
      $this->multipleSortedRegistrations = array_values($this->multipleSortedRegistrations);
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
    $placeholderMultipleSortedAcademy = $this->multipleSortedAcademy;
    $this->multipleSortedAcademy = null;
    $placeholderMultipleSortedAcademy->removeMultipleSortedCourse($this);
    foreach ($this->multipleSortedRegistrations as $aMultipleSortedRegistration)
    {
      $aMultipleSortedRegistration->delete();
    }
  }

}
?>