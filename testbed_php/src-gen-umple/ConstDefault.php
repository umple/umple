<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

class ConstDefault
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static $I1 = 0;
  public static $I2 = 0;
  public static $D1 = 0.0;
  public static $D2 = 0.0;
  public static $F1 = 0.0;
  public static $F2 = 0.0;
  public static $B1 = false;
  public static $B2 = false;
  public static $STR = "";
  public static $DATE = date("y-m-d", strtotime("2013-12-30"));
  public static $TIME = date("h:i:s", strtotime("00:00:00"));

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