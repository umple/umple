<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

class ItemWithUniqueId
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static $itemwithuniqueidsById = array();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ItemWithUniqueId Attributes
  private $id;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aId)
  {
    if (!$this->setId($aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setId($aId)
  {
    $wasSet = false;
    if (isset($this->id)) {
      $anOldId = $this->getId();
    }
    if (ItemWithUniqueId::hasWithId($aId)) {
      return $wasSet;
    }
    $this->id = $aId;
    $wasSet = true;
    if (isset($anOldId)) {
      unset(ItemWithUniqueId::$itemwithuniqueidsById[(string)$anOldId]);
    }
    ItemWithUniqueId::$itemwithuniqueidsById[(string)$aId] = $this;
    return $wasSet;
  }

  public function getId()
  {
    return $this->id;
  }

  public static function getWithId($aId)
  {
    return ItemWithUniqueId::$itemwithuniqueidsById[(string)$aId];
  }

  public static function hasWithId($aId)
  {
    return array_key_exists((string)$aId, ItemWithUniqueId::$itemwithuniqueidsById);
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    unset(ItemWithUniqueId::$itemwithuniqueidsById[(string)$this->getId()]);
  }

}
?>