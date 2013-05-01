<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class MultipleSortedAcademy
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MultipleSortedAcademy Attributes
  private $registrantsPriority;

  //MultipleSortedAcademy Associations
  private $multipleSortedCourses;
  private $registrants;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->registrantsPriority = 
      function($x, $y)
      {
        return $x->getId() -
               $y->getId();
      };
    $this->multipleSortedCourses = array();
    $this->registrants = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setRegistrantsPriority($aRegistrantsPriority)
  {
    $wasSet = false;
    $this->registrantsPriority = $aRegistrantsPriority;
    $wasSet = true;
    return $wasSet;
  }

  public function getRegistrantsPriority()
  {
    return $this->registrantsPriority;
  }

  public function getMultipleSortedCourse($index)
  {
    $aMultipleSortedCourse = $this->multipleSortedCourses[$index];
    return $aMultipleSortedCourse;
  }

  public function getMultipleSortedCourses()
  {
    $newMultipleSortedCourses = $this->multipleSortedCourses;
    return $newMultipleSortedCourses;
  }

  public function numberOfMultipleSortedCourses()
  {
    $number = count($this->multipleSortedCourses);
    return $number;
  }

  public function hasMultipleSortedCourses()
  {
    $has = $this->numberOfMultipleSortedCourses() > 0;
    return $has;
  }

  public function indexOfMultipleSortedCourse($aMultipleSortedCourse)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->multipleSortedCourses as $multipleSortedCourse)
    {
      if ($multipleSortedCourse->equals($aMultipleSortedCourse))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getRegistrant($index)
  {
    $aRegistrant = $this->registrants[$index];
    return $aRegistrant;
  }

  public function getRegistrants()
  {
    $newRegistrants = $this->registrants;
    return $newRegistrants;
  }

  public function numberOfRegistrants()
  {
    $number = count($this->registrants);
    return $number;
  }

  public function hasRegistrants()
  {
    $has = $this->numberOfRegistrants() > 0;
    return $has;
  }

  public function indexOfRegistrant($aRegistrant)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->registrants as $registrant)
    {
      if ($registrant->equals($aRegistrant))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfMultipleSortedCourses()
  {
    return 0;
  }

  public function addMultipleSortedCourseVia($aCode)
  {
    return new MultipleSortedCourse($aCode, $this);
  }

  public function addMultipleSortedCourse($aMultipleSortedCourse)
  {
    $wasAdded = false;
    if ($this->indexOfMultipleSortedCourse($aMultipleSortedCourse) !== -1) { return false; }
    $existingMultipleSortedAcademy = $aMultipleSortedCourse->getMultipleSortedAcademy();
    $isNewMultipleSortedAcademy = $existingMultipleSortedAcademy != null && $this !== $existingMultipleSortedAcademy;
    if ($isNewMultipleSortedAcademy)
    {
      $aMultipleSortedCourse->setMultipleSortedAcademy($this);
    }
    else
    {
      $this->multipleSortedCourses[] = $aMultipleSortedCourse;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeMultipleSortedCourse($aMultipleSortedCourse)
  {
    $wasRemoved = false;
    //Unable to remove aMultipleSortedCourse, as it must always have a multipleSortedAcademy
    if ($this !== $aMultipleSortedCourse->getMultipleSortedAcademy())
    {
      unset($this->multipleSortedCourses[$this->indexOfMultipleSortedCourse($aMultipleSortedCourse)]);
      $this->multipleSortedCourses = array_values($this->multipleSortedCourses);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addMultipleSortedCourseAt($aMultipleSortedCourse, $index)
  {  
    $wasAdded = false;
    if($this->addMultipleSortedCourse($aMultipleSortedCourse))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfMultipleSortedCourses()) { $index = $this->numberOfMultipleSortedCourses() - 1; }
      array_splice($this->multipleSortedCourses, $this->indexOfMultipleSortedCourse($aMultipleSortedCourse), 1);
      array_splice($this->multipleSortedCourses, $index, 0, array($aMultipleSortedCourse));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveMultipleSortedCourseAt($aMultipleSortedCourse, $index)
  {
    $wasAdded = false;
    if($this->indexOfMultipleSortedCourse($aMultipleSortedCourse) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfMultipleSortedCourses()) { $index = $this->numberOfMultipleSortedCourses() - 1; }
      array_splice($this->multipleSortedCourses, $this->indexOfMultipleSortedCourse($aMultipleSortedCourse), 1);
      array_splice($this->multipleSortedCourses, $index, 0, array($aMultipleSortedCourse));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addMultipleSortedCourseAt($aMultipleSortedCourse, $index);
    }
    return $wasAdded;
  }

  public static function minimumNumberOfRegistrants()
  {
    return 0;
  }

  public function addRegistrantVia($aId, $aName)
  {
    return new MultipleSortedStudent($aId, $aName, $this);
  }

  public function addRegistrant($aRegistrant)
  {
    $wasAdded = false;
    if ($this->indexOfRegistrant($aRegistrant) !== -1) { return false; }
    $existingMultipleSortedAcademy = $aRegistrant->getMultipleSortedAcademy();
    $isNewMultipleSortedAcademy = $existingMultipleSortedAcademy != null && $this !== $existingMultipleSortedAcademy;
    if ($isNewMultipleSortedAcademy)
    {
      $aRegistrant->setMultipleSortedAcademy($this);
    }
    else
    {
      $this->registrants[] = $aRegistrant;
    }
    $wasAdded = true;
    if(wasAdded)
        usort($this->registrants, $this->registrantsPriority);
    
    return $wasAdded;
  }

  public function removeRegistrant($aRegistrant)
  {
    $wasRemoved = false;
    //Unable to remove aRegistrant, as it must always have a multipleSortedAcademy
    if ($this !== $aRegistrant->getMultipleSortedAcademy())
    {
      unset($this->registrants[$this->indexOfRegistrant($aRegistrant)]);
      $this->registrants = array_values($this->registrants);
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
    foreach ($this->multipleSortedCourses as $aMultipleSortedCourse)
    {
      $aMultipleSortedCourse->delete();
    }
    foreach ($this->registrants as $aRegistrant)
    {
      $aRegistrant->delete();
    }
  }

}
?>