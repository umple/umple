<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

class Credentials
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static $db_hostname = "localhost:3306";
  public static $db_username = "umple";
  public static $db_password = "ems";
  public static $db_database = "elections";

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>