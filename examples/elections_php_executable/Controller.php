<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class Controller
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Controller Attributes
  private $server;
  private $username;
  private $password;
  private $isConnected;

  //Controller State Machines
  private static $StatusInitial = 1;
  private static $StatusConnecting = 2;
  private static $StatusConnected = 3;
  private static $StatusFailed = 4;
  private $status;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aServer, $aUsername, $aPassword)
  {
    $this->server = $aServer;
    $this->username = $aUsername;
    $this->password = $aPassword;
    $this->isConnected = false;
    $this->setStatus(self::$StatusInitial);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setServer($aServer)
  {
    $wasSet = false;
    $this->server = $aServer;
    $wasSet = true;
    return $wasSet;
  }

  public function setUsername($aUsername)
  {
    $wasSet = false;
    $this->username = $aUsername;
    $wasSet = true;
    return $wasSet;
  }

  public function setPassword($aPassword)
  {
    $wasSet = false;
    $this->password = $aPassword;
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

  public function getServer()
  {
    return $this->server;
  }

  public function getUsername()
  {
    return $this->username;
  }

  public function getPassword()
  {
    return $this->password;
  }

  public function getIsConnected()
  {
    return $this->isConnected;
  }

  public function getStatus()
  {
    if ($this->status == self::$StatusInitial) { return "StatusInitial"; }
    elseif ($this->status == self::$StatusConnecting) { return "StatusConnecting"; }
    elseif ($this->status == self::$StatusConnected) { return "StatusConnected"; }
    elseif ($this->status == self::$StatusFailed) { return "StatusFailed"; }
    return null;
  }

  public function connect()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusInitial)
    {
      $this->setStatus(self::$StatusConnecting);
      $wasEventProcessed = true;
    }

    return $wasEventProcessed;
  }

  public function connected()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusConnecting)
    {
      if ($this->isConnected)
      {
        $this->setStatus(self::$StatusConnected);
        $wasEventProcessed = true;
      }
    }

    return $wasEventProcessed;
  }

  public function notConnected()
  {
    $wasEventProcessed = false;

    if ($this->status == self::$StatusConnecting)
    {
      if (!$this->isConnected)
      {
        $this->setStatus(self::$StatusFailed);
        $wasEventProcessed = true;
      }
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
    elseif ($this->status == self::$StatusConnecting)
    {
      $this->isConnected = mysql_connect($this->server,$this->username,$this->password);
      $this->connected();
      	  	$this->notConnected();
    }
    elseif ($this->status == self::$StatusConnected)
    {
      echo "Connected";
    }
    elseif ($this->status == self::$StatusFailed)
    {
      echo "<p  class='ErrorMessage'> Connection Failed! <a href='index.php'>Retry?</a></p>";
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