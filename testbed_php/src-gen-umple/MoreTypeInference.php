<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class MoreTypeInference
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MoreTypeInference Attributes
  private $a;
  private $b;
  private $c;
  private $d;
  private $e;
  private $f;
  private $g;
  private $h;
  private $i;
  private $j;
  private $k;
  private $l;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aB, $aH)
  {
    $this->a = date("h:i:s", strtotime("12:12:12"));
    $this->b = $aB;
    $this->c = "12:12";
    $this->d = date("h:i:s", strtotime("12:12:12"));
    $this->e = "99:99:99";
    $this->f = "2000:01:01";
    $this->g = date("y-m-d", strtotime("2000-01-01"));
    $this->h = $aH;
    $this->i = "2000-01";
    $this->j = "2000:01:01";
    $this->k = date("y-m-d", strtotime("2000-01-01"));
    $this->l = new Object();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setA($aA)
  {
    $wasSet = false;
    $this->a = $aA;
    $wasSet = true;
    return $wasSet;
  }

  public function setB($aB)
  {
    $wasSet = false;
    $this->b = $aB;
    $wasSet = true;
    return $wasSet;
  }

  public function setC($aC)
  {
    $wasSet = false;
    $this->c = $aC;
    $wasSet = true;
    return $wasSet;
  }

  public function setD($aD)
  {
    $wasSet = false;
    $this->d = $aD;
    $wasSet = true;
    return $wasSet;
  }

  public function setE($aE)
  {
    $wasSet = false;
    $this->e = $aE;
    $wasSet = true;
    return $wasSet;
  }

  public function setF($aF)
  {
    $wasSet = false;
    $this->f = $aF;
    $wasSet = true;
    return $wasSet;
  }

  public function setG($aG)
  {
    $wasSet = false;
    $this->g = $aG;
    $wasSet = true;
    return $wasSet;
  }

  public function setH($aH)
  {
    $wasSet = false;
    $this->h = $aH;
    $wasSet = true;
    return $wasSet;
  }

  public function setI($aI)
  {
    $wasSet = false;
    $this->i = $aI;
    $wasSet = true;
    return $wasSet;
  }

  public function setJ($aJ)
  {
    $wasSet = false;
    $this->j = $aJ;
    $wasSet = true;
    return $wasSet;
  }

  public function setK($aK)
  {
    $wasSet = false;
    $this->k = $aK;
    $wasSet = true;
    return $wasSet;
  }

  public function setL($aL)
  {
    $wasSet = false;
    $this->l = $aL;
    $wasSet = true;
    return $wasSet;
  }

  public function getA()
  {
    return $this->a;
  }

  public function getB()
  {
    return $this->b;
  }

  public function getC()
  {
    return $this->c;
  }

  public function getD()
  {
    return $this->d;
  }

  public function getE()
  {
    return $this->e;
  }

  public function getF()
  {
    return $this->f;
  }

  public function getG()
  {
    return $this->g;
  }

  public function getH()
  {
    return $this->h;
  }

  public function getI()
  {
    return $this->i;
  }

  public function getJ()
  {
    return $this->j;
  }

  public function getK()
  {
    return $this->k;
  }

  public function getL()
  {
    return $this->l;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>