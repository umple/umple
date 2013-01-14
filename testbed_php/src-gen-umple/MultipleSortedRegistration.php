<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

class MultipleSortedRegistration
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MultipleSortedRegistration Associations
  private $multipleSortedCourse;
  private $multipleSortedStudent;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aMultipleSortedCourse, $aMultipleSortedStudent)
  {
    $didAddMultipleSortedCourse = $this->setMultipleSortedCourse($aMultipleSortedCourse);
    if (!$didAddMultipleSortedCourse)
    {
      throw new Exception("Unable to create multipleSortedRegistration due to multipleSortedCourse");
    }
    $didAddMultipleSortedStudent = $this->setMultipleSortedStudent($aMultipleSortedStudent);
    if (!$didAddMultipleSortedStudent)
    {
      throw new Exception("Unable to create multipleSortedRegistration due to multipleSortedStudent");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getName()
  {
    return getMultipleSortedStudent().getName();
  }

  public function getCode()
  {
    return getMultipleSortedCourse().getCode();
  }

  public function getMultipleSortedCourse()
  {
    return $this->multipleSortedCourse;
  }

  public function getMultipleSortedStudent()
  {
    return $this->multipleSortedStudent;
  }

  public function setMultipleSortedCourse($aMultipleSortedCourse)
  {
    $wasSet = false;
    if ($aMultipleSortedCourse == null)
    {
      return $wasSet;
    }
    
    $existingMultipleSortedCourse = $this->multipleSortedCourse;
    $this->multipleSortedCourse = $aMultipleSortedCourse;
    if ($existingMultipleSortedCourse != null && $existingMultipleSortedCourse != $aMultipleSortedCourse)
    {
      $existingMultipleSortedCourse->removeMultipleSortedRegistration($this);
    }
    $this->multipleSortedCourse->addMultipleSortedRegistration($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setMultipleSortedStudent($aMultipleSortedStudent)
  {
    $wasSet = false;
    if ($aMultipleSortedStudent == null)
    {
      return $wasSet;
    }
    
    $existingMultipleSortedStudent = $this->multipleSortedStudent;
    $this->multipleSortedStudent = $aMultipleSortedStudent;
    if ($existingMultipleSortedStudent != null && $existingMultipleSortedStudent != $aMultipleSortedStudent)
    {
      $existingMultipleSortedStudent->removeMultipleSortedRegistration($this);
    }
    $this->multipleSortedStudent->addMultipleSortedRegistration($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderMultipleSortedCourse = $this->multipleSortedCourse;
    $this->multipleSortedCourse = null;
    $placeholderMultipleSortedCourse->removeMultipleSortedRegistration($this);
    $placeholderMultipleSortedStudent = $this->multipleSortedStudent;
    $this->multipleSortedStudent = null;
    $placeholderMultipleSortedStudent->removeMultipleSortedRegistration($this);
  }

}
?>