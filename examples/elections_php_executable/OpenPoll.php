<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

class OpenPoll
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //OpenPoll Attributes
  private $db_hostname;
  private $db_username;
  private $db_password;
  private $isConnected;

  //OpenPoll State Machines
  private static $StatusInitial = 1;
  private static $StatusConnecting = 2;
  private static $StatusConnected = 3;
  private static $StatusFailed = 4;
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
      $this->isConnected = mysql_connect($this->db_hostname,$this->db_username,$this->db_password);
      $this->connected();
      	  	$this->notConnected();
    }
    elseif ($this->status == self::$StatusConnected)
    {
      echo "Connected!";
      $result = mysql_query("SELECT * FROM elections.election");

			require_once("Election.php");
			
			while($row = mysql_fetch_array($result)) {
				$anElection=new Election($row['idElection'],$row['name'],$row['description']);
				print_r($anElection);
				echo "<br/><a href=OpenPoll.php?id=".$anElection->getIdElection().">Open ".$anElection->getName()."</a><br/>";
			}

			mysql_close($this->isConnected);
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