<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

class MentorH
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorH Attributes
  private $name;

  //MentorH Associations
  private $superMentor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setName($aName)
  {
    $wasSet = false;
    $this->name = $aName;
    $wasSet = true;
    return $wasSet;
  }

  public function getName()
  {
    return $this->name;
  }

  public function getSuperMentor()
  {
    return $this->superMentor;
  }

  public function setSuperMentor($aNewSuperMentor)
  {
    $wasSet = false;
    if ($aNewSuperMentor == null)
    {
      $existingSuperMentor = $this->superMentor;
      $this->superMentor = null;
      
      if ($existingSuperMentor != null && $existingSuperMentor->getSuperMentor() != null)
      {
        $existingSuperMentor->setSuperMentor(null);
      }
      $wasSet = true;
      return $wasSet;
    }
    
    $currentSuperMentor = $this->getSuperMentor();
    if ($currentSuperMentor != null && $currentSuperMentor != $aNewSuperMentor)
    {
      $currentSuperMentor->setSuperMentor(null);
    }
    
    $this->superMentor = $aNewSuperMentor;
    $existingSuperMentor = $aNewSuperMentor->getSuperMentor();
    
    if ($this != $existingSuperMentor)
    {
      $aNewSuperMentor->setSuperMentor($this);
    }
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    if ($this->superMentor != null)
    {
      $this->superMentor->setSuperMentor(null);
    }
  }

}
?>