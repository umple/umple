<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class Controller
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Controller Attributes
  private $db_hostname;
  private $db_username;
  private $db_password;
  private $isConnected;

  //Controller State Machines
  private static $StatusInitial = 1;
  private static $StatusWriting = 2;
  private $status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aDb_hostname, $aDb_username, $aDb_password)
  {
    $this->db_hostname = $aDb_hostname;
    $this->db_username = $aDb_username;
    $this->db_password = $aDb_password;
    $this->isConnected = false;
    $this->setStatus(self::$StatusInitial);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setDb_hostname($aDb_hostname)
  {
    $wasSet = false;
    $this->db_hostname = $aDb_hostname;
    $wasSet = true;
    return $wasSet;
  }

  public function setDb_username($aDb_username)
  {
    $wasSet = false;
    $this->db_username = $aDb_username;
    $wasSet = true;
    return $wasSet;
  }

  public function setDb_password($aDb_password)
  {
    $wasSet = false;
    $this->db_password = $aDb_password;
    $wasSet = true;
    return $wasSet;
  }

  public function setIsConnected($aIsConnected)
  {
    $wasSet = false;
    $this->isConnected = $aIsConnected;
    $wasSet = true;
    return $wasSet;
  }

  public function getDb_hostname()
  {
    return $this->db_hostname;
  }

  public function getDb_username()
  {
    return $this->db_username;
  }

  public function getDb_password()
  {
    return $this->db_password;
  }

  public function getIsConnected()
  {
    return $this->isConnected;
  }

  public function getStatus()
  {
    if ($this->status == self::$StatusInitial) { return "StatusInitial"; }
    elseif ($this->status == self::$StatusWriting) { return "StatusWriting"; }
    return null;
  }

  public function write()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusInitial)
    {
      $this->setStatus(self::$StatusWriting);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  private function setStatus($aStatus)
  {
    $this->status = $aStatus;

    // entry actions and do activities
    if ($this->status == self::$StatusInitial)
    {
      echo "<link type='text/css' rel='stylesheet' href='elections_styles.css'>"; $this->connect();
    }
    elseif ($this->status == self::$StatusWriting)
    {
      echo "<a href='openPoll.php'>Open Poll</a>";
    }
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>