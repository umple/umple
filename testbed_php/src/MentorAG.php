<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

class MentorAG
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAG Attributes
  private $name;

  //MentorAG Associations
  private $friend;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aName)
  {
    $this->name = $aName;
    $this->friend = array();
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

  public function getFriend($index)
  {
    $aFriend = $this->friend[$index];
    return $aFriend;
  }

  public function getFriend()
  {
    $newFriend = $this->friend;
    return $newFriend;
  }

  public function numberOfFriend()
  {
    $number = count($this->friend);
    return $number;
  }

  public function hasFriend()
  {
    $has = $this->numberOfFriend() > 0;
    return $has;
  }

  public function indexOfFriend($aFriend)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->friend as $friend)
    {
      if ($friend->equals($aFriend))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfFriend()
  {
    return 0;
  }

  public function addFriend($aFriend)
  {
    $wasAdded = false;
    if ($this->indexOfFriend($aFriend) !== -1) { return false; }
    $this->friend[] = $aFriend;
    if ($aFriend->indexOfFriend($this) != -1)
    {
      $wasAdded = true;
    }
    else
    {
      $wasAdded = $aFriend->addFriend($this);
      if (!$wasAdded)
      {
        array_pop($this->friend);
      }
    }
    return $wasAdded;
  }

  public function removeFriend($aFriend)
  {
    $wasRemoved = false;
    if ($this->indexOfFriend($aFriend) == -1)
    {
      return $wasRemoved;
    }

    $oldIndex = $this->indexOfFriend($aFriend);
    unset($this->friend[$oldIndex]);
    if ($aFriend->indexOfFriend($this) == -1)
    {
      $wasRemoved = true;
    }
    else
    {
      $wasRemoved = $aFriend->removeFriend($this);
      if (!$wasRemoved)
      {
        $this->friend[$oldIndex] = $aFriend;
        ksort($this->friend);
      }
    }
    $this->friend = array_values($this->friend);
    return $wasRemoved;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $copyOfFriend = $this->friend;
    $this->friend = array();
    foreach ($copyOfFriend as $aFriend)
    {
      $aFriend->removeFriend($this);
    }
  }

}
?>