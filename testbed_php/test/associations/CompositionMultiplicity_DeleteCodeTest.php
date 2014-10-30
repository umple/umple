<?php

class CompositionMultiplicity_DeleteCodeTests extends UnitTestCase
{


  // 										LEFT TESTS

  public function test_OneToOne_LeftTest()
  {
    $y = new Y1_1();
    $x = new X1_1(1, $y);
    $x->delete();    

    $this->assertEqual(null, $y->getXVar());
    $this->assertEqual(null, $x->getY1_1());
  }

  public  function test_MToOne_LeftTest()
  {
    $x = new XM_1(1);
    $y = new YM_1($x);
    $x->delete();    

    $this->assertEqual(null, $y->getXVar());
    $this->assertEqual(0, count($x->getYm_1()));
  }

   
  public  function test_MToM_LeftTest()
  {
    $y1 = new YM_M();
    $y2 = new YM_M();
    $y2->setV(2);
    $y3 = new YM_M();
    $y3->setV(3);
     
    $x = new XM_M(1, array($y1, $y2, $y3)); 
   
    $x->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(0, count($y3->getXVar()));
    $this->assertEqual(0, count($x->getYm_m()));
  }

   
  public  function test_OneToStar_LeftTest()
  {
    $y = new Y1_star();
    
    $x = new X1_star(1, $y); 

    $x->delete();    

    $this->assertEqual(0, count($y->getXVar()));
    $this->assertEqual(null, $x->getY1_star());
  }

   
  public  function test_MToStar_LeftTest()
  {
    $y1 = new YM_star();
    $y2 = new YM_star();
    $y2->setV(2);
    $y3 = new YM_star();
    $y3->setV(3);
     
    $x = new XM_star(1, array($y1, $y2, $y3)); 

    $x->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(0, count($y3->getXVar()));
    $this->assertEqual(0, count($x->getYm_star()));
  }

   
  public  function test_StarToStar_LeftTest()
  {
    $y1 = new Ystar_star();
    $y2 = new Ystar_star();
    $y2->setV(2);
    $y3 = new Ystar_star();
    $y3->setV(3);
     
    $x1 = new Xstar_star(1);
    $x1->addYstar_star($y1);
    $x1->addYstar_star($y2);
    $x1->addYstar_star($y3);
    $x2 = new Xstar_star(2); 
    $x2->addYstar_star($y1);
    $x2->addYstar_star($y2);

    $x2->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(1, count($y3->getXVar()));
    $this->assertEqual(1, count($x1->getYstar_star()));
    $this->assertEqual(0, count($x2->getYstar_star()));
  }

   
  public  function test_MNToOne_LeftTest()
  {
    $x = new Xm_n__1(1);
    $y = new Ym_n__1($x);
    $x->delete();    

    $this->assertEqual(null, $y->getXVar());
    $this->assertEqual(0, count($x->getYm_n__1()));
  }

   
  public  function test_MNToM_LeftTest()
  {
    $y1 = new Ym_n__m();
    $y2 = new Ym_n__m();
    $y2->setV(2);
    $y3 = new Ym_n__m();
    $y3->setV(3);
     
    $x = new Xm_n__m(1); 
    $x->setYm_n__m(array($y1, $y2, $y3));    

    $x->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(0, count($y3->getXVar()));
    $this->assertEqual(0, count($x->getYm_n__m()));
  }

   
  public  function test_MNToStar_LeftTest()
  {
    $y1 = new Ym_n__star();
    $y2 = new Ym_n__star();
    $y2->setV(2);
    $y3 = new Ym_n__star();
    $y3->setV(3);
     
    $x = new Xm_n__star(1, array($y1, $y2)); 
    $x->addYm_n__star($y3);
   
    $x->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(0, count($y3->getXVar()));
    $this->assertEqual(0, count($x->getYm_n__star()));
  }

   
  public  function test_MNToMN_LeftTest()
  {
    $y1 = new Ym_n__m_n();
    $y2 = new Ym_n__m_n();
    $y2->setV(2);
     
    $x = new Xm_n__m_n(1); 
    $x->setYm_n__m_n(array($y1, $y2));    

    $x->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(0, count($x->getYm_n__m_n()));
  }

   
  public  function test__0NToOne_LeftTest()
  {
    $x = new X0_n__1(1);
    $y = new Y0_n__1($x);
    $x->delete();    

    $this->assertEqual(null, $y->getXVar());
    $this->assertEqual(0, count($x->getY0_n__1()));
  }

   
  public  function test__0NToM_LeftTest()
  {
    $y1 = new Y0_n__m();
    $y2 = new Y0_n__m();
    $y2->setV(2);
    $y3 = new Y0_n__m();
    $y3->setV(3);    
 
    $x = new X0_n__m(1); 
    $x->addY0_n__m($y1);
    $x->addY0_n__m($y2);
    $x->addY0_n__m($y3);
    
    $x->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(0, count($y3->getXVar()));
    $this->assertEqual(0, count($x->getY0_n__m()));
  }

   
  public  function test__0NToStar_LeftTest()
  {
    $y1 = new Y0_n__star();
    $y2 = new Y0_n__star();
    $y2->setV(2);
     
    $x = new X0_n__star(1); 
    $x->addY0_n__star($y1);
    $x->addY0_n__star($y2);
   
    $x->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(0, count($x->getY0_n__star()));
  }

   
  public  function test__0NTo0N_LeftTest()
  {
    $y1 = new Y0_n__0_n();
    $y2 = new Y0_n__0_n();
    $y2->setV(2);
     
    $x1 = new X0_n__0_n(1); 
    $x1->addY0_n__0_n($y1);
    $x1->addY0_n__0_n($y2);   
    $x2 = new X0_n__0_n(2); 
    $x2->addY0_n__0_n($y1);
    $x2->addY0_n__0_n($y2); 

    $x1->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(0, count($y2->getXVar()));
    $this->assertEqual(0, count($x1->getY0_n__0_n()));
    $this->assertEqual(0, count($x2->getY0_n__0_n()));
  }

   
  public  function test__0OneToOne_LeftTest()
  {
    $x = new X0_1__1(1);
    $y = new Y0_1__1($x);
    $y->getXVar()->delete();    

    $this->assertEqual(null, $y->getXVar());
    $this->assertEqual(null, $x->getY0_1__1());
  }

 
  public  function test__0OneToM_LeftTest()
  {
    $x1 = new X0_1__m(1);
    $x2 = new X0_1__m(2);
    $x3 = new X0_1__m(3);
     
    $y = new Y0_1__m(array($x1, $x2, $x3)); 
    
    $x1->delete();    

    $this->assertEqual(null, $x1->getY0_1__m());
    $this->assertEqual(null, $x2->getY0_1__m());
    $this->assertEqual(null, $x3->getY0_1__m());
    //$this->assertEqual(0, count($y->getXVar()));
  }

   
  public  function test__0OneToStar_LeftTest()
  {
    $y = new Y0_1__star();
    
    $x = new X0_1__star(1); 
    $x->setY0_1__star($y);

    $x->delete();    

    $this->assertEqual(0, count($y->getXVar()));
    $this->assertEqual(null, $x->getY0_1__star());
  }

   
  public  function test__0OneToMN_LeftTest()
  {
    $x1 = new X0_1__m_n(1);
    $x2 = new X0_1__m_n(2);
    $x3 = new X0_1__m_n(3); 
    
    $y = new Y0_1__m_n(array($x1, $x2, $x3));

    $x1->delete();    

    //$this->assertEqual(0, count($y->getXVar()));
    $this->assertEqual(null, $x1->getY0_1__m_n());
    $this->assertEqual(null, $x2->getY0_1__m_n());
    $this->assertEqual(null, $x3->getY0_1__m_n());
  }

 
  public  function test__01To0N_LeftTest()
  {
    $y1 = new Y0_1__0_n();
     
    $x1 = new X0_1__0_n(1, $y1); 
    $x2 = new X0_1__0_n(2, $y1); 
    
    $x1->delete();    

    $this->assertEqual(0, count($y1->getXVar()));
    $this->assertEqual(null, $x1->getY0_1__0_n());
    $this->assertEqual(null, $x2->getY0_1__0_n());
  }

   
  public  function test__0OneTo0One_LeftTest()
  {
    $x = new X0_1__0_1(1);
    $y = new Y0_1__0_1();
    $y->setXVar($x);
    
    $x->delete();    

    $this->assertEqual(null, $y->getXVar());
    $this->assertEqual(null, $x->getY0_1__0_1());
  }







   // 										RIGHT TESTS

   
  public  function test_OneToOne_RightTest()
  {
    $z = new Z_1_1();
    $y = new Y_1_1($z);
    $y->delete();    

    $this->assertEqual(null, $y->getZVar());
    $this->assertEqual(null, $z->getY_1_1());
  }

   
  public  function test_MToOne_RightTest()
  {
    $z = new Z_M_1(1);
    $y = new Y_M_1($z);
    $z->delete();    

    $this->assertEqual(null, $y->getZVar());
    $this->assertEqual(0, count($z->getY_m_1()));
  }

   
  public  function test_MToM_RightTest()
  {
    $y1 = new Y_M_M();
    $y2 = new Y_M_M();
    $y2->setV(2);
    $y3 = new Y_M_M();
    $y3->setV(3);
     
    $z = new Z_M_M(1, array($y1, $y2, $y3)); 
    
    $z->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($y3->getZVar()));
    $this->assertEqual(0, count($z->getY_m_m()));
  }

   
  public  function test_OneToStar_RightTest()
  {
    $y = new Y_1_star();
    
    $z = new Z_1_star(1, $y); 

    $z->delete();    

    $this->assertEqual(0, count($y->getZVar()));
    $this->assertEqual(null, $z->getY_1_star());
  }

   
  public  function test_MToStar_RightTest()
  {
    $y1 = new Y_M_star();
    $y2 = new Y_M_star();
    $y2->setV(2);
    $y3 = new Y_M_star();
    $y3->setV(3);
     
    $z = new Z_M_star(1, array($y1, $y2, $y3)); 

    $z->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($y3->getZVar()));
    $this->assertEqual(0, count($z->getY_m_star()));
  }

   
  public  function test_StarToStar_RightTest()
  {
    $y1 = new Y_star_star();
    $y2 = new Y_star_star();
    $y2->setV(2);
    $y3 = new Y_star_star();
    $y3->setV(3);
     
    $z1 = new Z_star_star(1);
    $z1->addY_star_star($y1);
    $z1->addY_star_star($y2);
    $z1->addY_star_star($y3);
    $z2 = new Z_star_star(2); 
    $z2->addY_star_star($y1);
    $z2->addY_star_star($y2);

    $y1->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($y3->getZVar()));
    $this->assertEqual(0, count($z1->getY_star_star()));
    $this->assertEqual(0, count($z2->getY_star_star()));
  }

   
  public  function test_MNToOne_RightTest()
  {
    $z = new Z_m_n__1(1);
    $y = new Y_m_n__1($z);
    $z->delete();    

    $this->assertEqual(null, $y->getZVar());
    $this->assertEqual(0, count($z->getY_m_n__1()));
  }

   
  public  function test_MNToM_RightTest()
  {
    $y1 = new Y_m_n__m();
    $y2 = new Y_m_n__m();
    $y2->setV(2);
    $y3 = new Y_m_n__m();
    $y3->setV(3);
     
    $z = new Z_m_n__m(1); 
    $z->setY_m_n__m(array($y1, $y2, $y3));    

    $z->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($y3->getZVar()));
    $this->assertEqual(0, count($z->getY_m_n__m()));
  }

   
  public  function test_MNToStar_RightTest()
  {
    $y1 = new Y_m_n__star();
    $y2 = new Y_m_n__star();
    $y2->setV(2);
    $y3 = new Y_m_n__star();
    $y3->setV(3);
     
    $z = new Z_m_n__star(1, array($y1, $y2)); 
    $z->addY_m_n__star($y3);
   
    $z->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($y3->getZVar()));
    $this->assertEqual(0, count($z->getY_m_n__star()));
  }

   
  public  function test_MNToMN_RightTest()
  {
    $y1 = new Y_m_n__m_n();
    $y2 = new Y_m_n__m_n();
    $y2->setV(2);
     
    $z = new Z_m_n__m_n(1); 
    $z->setY_m_n__m_n(array($y1, $y2));    

    $z->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($z->getY_m_n__m_n()));
  }

   
  public  function test__0NToOne_RightTest()
  {
    $z = new Z_0_n__1(1);
    $y = new Y_0_n__1($z);
    $z->delete();    

    $this->assertEqual(null, $y->getZVar());
    $this->assertEqual(0, count($z->getY_0_n__1()));
  }

   
  public  function test__0NToM_RightTest()
  {
    $y1 = new Y_0_n__m();
    $y2 = new Y_0_n__m();
    $y2->setV(2);
    $y3 = new Y_0_n__m();
    $y3->setV(3);
     
    $z = new Z_0_n__m(1); 
    $z->addY_0_n__m($y1);
    $z->addY_0_n__m($y2);
    $z->addY_0_n__m($y3);
    
    $z->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($y3->getZVar()));
    $this->assertEqual(0, count($z->getY_0_n__m()));
  }

   
  public  function test__0NToStar_RightTest()
  {
    $y1 = new Y_0_n__star();
    $y2 = new Y_0_n__star();
    $y2->setV(2);
     
    $z = new Z_0_n__star(1); 
    $z->addY_0_n__star($y1);
    $z->addY_0_n__star($y2);
   
    $z->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($z->getY_0_n__star()));
  }

   
  public  function test__0NTo0N_RightTest()
  {
    $y1 = new Y_0_n__0_n();
    $y2 = new Y_0_n__0_n();
    $y2->setV(2);
     
    $z1 = new Z_0_n__0_n(1); 
    $z1->addY_0_n__0_n($y1);
    $z1->addY_0_n__0_n($y2);   
    $z2 = new Z_0_n__0_n(2); 
    $z2->addY_0_n__0_n($y1);
    $z2->addY_0_n__0_n($y2); 

    $y1->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(0, count($y2->getZVar()));
    $this->assertEqual(0, count($z1->getY_0_n__0_n()));
    $this->assertEqual(0, count($z2->getY_0_n__0_n()));
  }

   
  public  function test__0OneToOne_RightTest()
  {
    $z = new Z_0_1__1(1);
    $y = new Y_0_1__1($z);
    $y->delete();    

    $this->assertEqual(null, $y->getZVar());
    $this->assertEqual(null, $z->getY_0_1__1());
  }

   
  public  function test__0OneToM_RightTest()
  {
    $z1 = new Z_0_1__m(1);
    $z2 = new Z_0_1__m(2);
    $z3 = new Z_0_1__m(3);
     
    $y = new Y_0_1__m(array($z1, $z2, $z3)); 
    
    $y->delete();    

    $this->assertEqual(null, $z1->getY_0_1__m());
    $this->assertEqual(null, $z2->getY_0_1__m());
    $this->assertEqual(null, $z3->getY_0_1__m());
    $this->assertEqual(0, count($y->getZVar()));
  }

   
  public  function test__0OneToStar_RightTest()
  {
    $y = new Y_0_1__star();
    
    $z = new Z_0_1__star(1); 
    $z->setY_0_1__star($y);

    $z->delete();    

    $this->assertEqual(0, count($y->getZVar()));
    $this->assertEqual(null, $z->getY_0_1__star());
  }

   
  public  function test__0OneToMN_RightTest()
  {
    $z1 = new Z_0_1__m_n(1);
    $z2 = new Z_0_1__m_n(2);
    $z3 = new Z_0_1__m_n(3); 
    
    $y = new Y_0_1__m_n(array($z1, $z2, $z3));

    $y->delete();    

    $this->assertEqual(0, count($y->getZVar()));
    $this->assertEqual(null, $z1->getY_0_1__m_n());
    $this->assertEqual(null, $z2->getY_0_1__m_n());
    $this->assertEqual(null, $z3->getY_0_1__m_n());
  }

 
   
  public  function test__01To0N_RightTest()
  {
    $y1 = new Y_0_1__0_n();
     
    $z1 = new Z_0_1__0_n(1); 
    $z1->setY_0_1__0_n($y1);
    $z2 = new Z_0_1__0_n(2); 
    $z2->setY_0_1__0_n($y1);
    
    $y1->delete();    

    $this->assertEqual(0, count($y1->getZVar()));
    $this->assertEqual(null, $z1->getY_0_1__0_n());
    $this->assertEqual(null, $z2->getY_0_1__0_n());
  }

   
  public  function test__0OneTo0One_RightTest()
  {
    $z = new Z_0_1__0_1(1);
    $y = new Y_0_1__0_1();
    $y->setZVar($z);
    
    $z->delete();    

    $this->assertEqual(null, $y->getZVar());
    $this->assertEqual(null, $z->getY_0_1__0_1());
  }


}

?>
