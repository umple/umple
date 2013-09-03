<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

class TypeInference
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TypeInference Attributes
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
  private $m;
  private $n;
  private $o;
  private $p;
  private $q;
  private $r;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aE, $aF, $aI, $aP, $aQ)
  {
    $this->a = 2;
    $this->b = 3.0;
    $this->c = false;
    $this->d = "hello world!";
    $this->e = $aE;
    $this->f = $aF;
    $this->g = 42;
    $this->h = "hello";
    $this->i = $aI;
    $this->j = -1;
    $this->k = -3.33333;
    $this->l = "-6";
    $this->m = "-3.1415926";
    $this->n = "99";
    $this->o = false;
    $this->p = $aP;
    $this->q = $aQ;
    $this->r = 3;
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

  public function setM($aM)
  {
    $wasSet = false;
    $this->m = $aM;
    $wasSet = true;
    return $wasSet;
  }

  public function setN($aN)
  {
    $wasSet = false;
    $this->n = $aN;
    $wasSet = true;
    return $wasSet;
  }

  public function setO($aO)
  {
    $wasSet = false;
    $this->o = $aO;
    $wasSet = true;
    return $wasSet;
  }

  public function setP($aP)
  {
    $wasSet = false;
    $this->p = $aP;
    $wasSet = true;
    return $wasSet;
  }

  public function setQ($aQ)
  {
    $wasSet = false;
    $this->q = $aQ;
    $wasSet = true;
    return $wasSet;
  }

  public function setR($aR)
  {
    $wasSet = false;
    $this->r = $aR;
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

  public function getM()
  {
    return $this->m;
  }

  public function getN()
  {
    return $this->n;
  }

  public function getO()
  {
    return $this->o;
  }

  public function getP()
  {
    return $this->p;
  }

  public function getQ()
  {
    return $this->q;
  }

  public function getR()
  {
    return $this->r;
  }

  public function isC()
  {
    return $this->c;
  }

  public function isO()
  {
    return $this->o;
  }

  public function isP()
  {
    return $this->p;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

}
?>