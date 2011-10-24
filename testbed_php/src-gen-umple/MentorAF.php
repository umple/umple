<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class MentorAF
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAF Attributes
  private $name;

  //MentorAF Associations
  private $friend;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName = null, $aFriend = null)
  {
    if (func_num_args() == 0) { return; }

    $this->name = $aName;
    if ($aFriend == null || $aFriend->getFriend() != null)
    {
      throw new Exception("Unable to create MentorAF due to aFriend");
    }
    $this->friend = $aFriend;
  }
  public static function newInstance($aName, $aNameForFriend)
  {
    $thisInstance = new MentorAF();
    $thisInstance->name = $aName;
    $thisInstance->friend = new MentorAF($aNameForFriend, $thisInstance);
    return $thisInstance;
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

  public function getFriend()
  {
    return $this->friend;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $existingFriend = $this->friend;
    $this->friend = null;
    if ($existingFriend != null)
    {
      $existingFriend->delete();
    }
  }

}
?>