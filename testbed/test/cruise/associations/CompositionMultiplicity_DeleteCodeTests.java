package cruise.associations;

import org.junit.*;

import cruise.associations.compositions.*;

public class CompositionMultiplicity_DeleteCodeTests
{


  // 										LEFT TESTS

  @Test
  public void OneToOne_LeftTest()
  {
    Y1_1 y = new Y1_1(1);
    X1_1 x = y.getXVar();
    y.getXVar().delete();    

    Assert.assertEquals(null, y.getXVar());
    Assert.assertEquals(null, x.getY1_1());
  }

  @Test
  public void MToOne_LeftTest()
  {
    XM_1 x = new XM_1(1);
    YM_1 y = new YM_1(x);
    x.delete();    

    Assert.assertEquals(null, y.getXVar());
    Assert.assertEquals(0, x.getYm_1().size());
  }

  @Test
  public void MToM_LeftTest()
  {
    YM_M y1 = new YM_M();
    YM_M y2 = new YM_M();
    YM_M y3 = new YM_M();
     
    XM_M x = new XM_M(1); 
    x.setYm_m(y1, y2, y3);    

    x.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(0, y3.getXVar().size());
    Assert.assertEquals(0, x.getYm_m().size());
  }

  @Test
  public void OneToStar_LeftTest()
  {
    Y1_star y = new Y1_star();
    
    X1_star x = new X1_star(1, y); 

    x.delete();    

    Assert.assertEquals(0, y.getXVar().size());
    Assert.assertEquals(null, x.getY1_star());
  }

  @Test
  public void MToStar_LeftTest()
  {
    YM_star y1 = new YM_star();
    YM_star y2 = new YM_star();
    YM_star y3 = new YM_star();
     
    XM_star x = new XM_star(1, y1, y2, y3); 

    x.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(0, y3.getXVar().size());
    Assert.assertEquals(0, x.getYm_star().size());
  }

  @Test
  public void StarToStar_LeftTest()
  {
    Ystar_star y1 = new Ystar_star();
    Ystar_star y2 = new Ystar_star();
    Ystar_star y3 = new Ystar_star();
     
    Xstar_star x1 = new Xstar_star(1);
    x1.addYstar_star(y1);
    x1.addYstar_star(y2);
    x1.addYstar_star(y3);
    Xstar_star x2 = new Xstar_star(2); 
    x2.addYstar_star(y1);
    x2.addYstar_star(y2);

    x2.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(1, y3.getXVar().size());
    Assert.assertEquals(1, x1.getYstar_star().size());
    Assert.assertEquals(0, x2.getYstar_star().size());
  }

  @Test
  public void MNToOne_LeftTest()
  {
    Xm_n__1 x = new Xm_n__1(1);
    Ym_n__1 y = new Ym_n__1(x);
    x.delete();    

    Assert.assertEquals(null, y.getXVar());
    Assert.assertEquals(0, x.getYm_n__1().size());
  }

  @Test
  public void MNToM_LeftTest()
  {
    Ym_n__m y1 = new Ym_n__m();
    Ym_n__m y2 = new Ym_n__m();
    Ym_n__m y3 = new Ym_n__m();
     
    Xm_n__m x = new Xm_n__m(1); 
    x.setYm_n__m(y1, y2, y3);    

    x.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(0, y3.getXVar().size());
    Assert.assertEquals(0, x.getYm_n__m().size());
  }

  @Test
  public void MNToStar_LeftTest()
  {
    Ym_n__star y1 = new Ym_n__star();
    Ym_n__star y2 = new Ym_n__star();
    Ym_n__star y3 = new Ym_n__star();
     
    Xm_n__star x = new Xm_n__star(1, y1, y2); 
    x.addYm_n__star(y3);
   
    x.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(0, y3.getXVar().size());
    Assert.assertEquals(0, x.getYm_n__star().size());
  }

  @Test
  public void MNToMN_LeftTest()
  {
    Ym_n__m_n y1 = new Ym_n__m_n();
    Ym_n__m_n y2 = new Ym_n__m_n();
     
    Xm_n__m_n x = new Xm_n__m_n(1); 
    x.setYm_n__m_n(y1, y2);    

    x.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(0, x.getYm_n__m_n().size());
  }

  @Test
  public void _0NToOne_LeftTest()
  {
    X0_n__1 x = new X0_n__1(1);
    Y0_n__1 y = new Y0_n__1(x);
    x.delete();    

    Assert.assertEquals(null, y.getXVar());
    Assert.assertEquals(0, x.getY0_n__1().size());
  }

  @Test
  public void _0NToM_LeftTest()
  {
    Y0_n__m y1 = new Y0_n__m();
    Y0_n__m y2 = new Y0_n__m();
    Y0_n__m y3 = new Y0_n__m();
     
    X0_n__m x = new X0_n__m(1); 
    x.addY0_n__m(y1);
    x.addY0_n__m(y2);
    x.addY0_n__m(y3);
    
    x.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(0, y3.getXVar().size());
    Assert.assertEquals(0, x.getY0_n__m().size());
  }

  @Test
  public void _0NToStar_LeftTest()
  {
    Y0_n__star y1 = new Y0_n__star();
    Y0_n__star y2 = new Y0_n__star();
     
    X0_n__star x = new X0_n__star(1); 
    x.addY0_n__star(y1);
    x.addY0_n__star(y2);
   
    x.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(0, x.getY0_n__star().size());
  }

  @Test
  public void _0NTo0N_LeftTest()
  {
    Y0_n__0_n y1 = new Y0_n__0_n();
    Y0_n__0_n y2 = new Y0_n__0_n();
     
    X0_n__0_n x1 = new X0_n__0_n(1); 
    x1.addY0_n__0_n(y1);
    x1.addY0_n__0_n(y2);   
    X0_n__0_n x2 = new X0_n__0_n(2); 
    x2.addY0_n__0_n(y1);
    x2.addY0_n__0_n(y2); 

    x1.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(0, y2.getXVar().size());
    Assert.assertEquals(0, x1.getY0_n__0_n().size());
    Assert.assertEquals(0, x2.getY0_n__0_n().size());
  }

  @Test
  public void _0OneToOne_LeftTest()
  {
    X0_1__1 x = new X0_1__1(1);
    Y0_1__1 y = new Y0_1__1(x);
    y.getXVar().delete();    

    Assert.assertEquals(null, y.getXVar());
    Assert.assertEquals(null, x.getY0_1__1());
  }

  @Test
  public void _0OneToM_LeftTest()
  {
    X0_1__m x1 = new X0_1__m(1);
    X0_1__m x2 = new X0_1__m(2);
    X0_1__m x3 = new X0_1__m(3);
     
    Y0_1__m y = new Y0_1__m(x1, x2, x3); 
    
    x1.delete();    

    Assert.assertEquals(null, x1.getY0_1__m());
    Assert.assertEquals(null, x2.getY0_1__m());
    Assert.assertEquals(null, x3.getY0_1__m());
    Assert.assertEquals(0, y.getXVar().size());
  }

  @Test
  public void _0OneToStar_LeftTest()
  {
    Y0_1__star y = new Y0_1__star();
    
    X0_1__star x = new X0_1__star(1); 
    x.setY0_1__star(y);

    x.delete();    

    Assert.assertEquals(0, y.getXVar().size());
    Assert.assertEquals(null, x.getY0_1__star());
  }

  @Test
  public void _0OneToMN_LeftTest()
  {
    X0_1__m_n x1 = new X0_1__m_n(1);
    X0_1__m_n x2 = new X0_1__m_n(2);
    X0_1__m_n x3 = new X0_1__m_n(3); 
    
    Y0_1__m_n y = new Y0_1__m_n(x1, x2, x3);

    x1.delete();    

    Assert.assertEquals(0, y.getXVar().size());
    Assert.assertEquals(null, x1.getY0_1__m_n());
    Assert.assertEquals(null, x2.getY0_1__m_n());
    Assert.assertEquals(null, x3.getY0_1__m_n());
  }

 
  @Test
  public void _01To0N_LeftTest()
  {
    Y0_1__0_n y1 = new Y0_1__0_n();
     
    X0_1__0_n x1 = new X0_1__0_n(1); 
    x1.setY0_1__0_n(y1);
    X0_1__0_n x2 = new X0_1__0_n(2); 
    x2.setY0_1__0_n(y1);
    
    x1.delete();    

    Assert.assertEquals(0, y1.getXVar().size());
    Assert.assertEquals(null, x1.getY0_1__0_n());
    Assert.assertEquals(null, x2.getY0_1__0_n());
  }

  @Test
  public void _0OneTo0One_LeftTest()
  {
    X0_1__0_1 x = new X0_1__0_1(1);
    Y0_1__0_1 y = new Y0_1__0_1();
    y.setXVar(x);
    
    x.delete();    

    Assert.assertEquals(null, y.getXVar());
    Assert.assertEquals(null, x.getY0_1__0_1());
  }







   // 										RIGHT TESTS

  @Test
  public void OneToOne_RightTest()
  {
    Y_1_1 y = new Y_1_1(1);
    Z_1_1 z = y.getZVar();
    y.getZVar().delete();    

    Assert.assertEquals(null, y.getZVar());
    Assert.assertEquals(null, z.getY_1_1());
  }

  @Test
  public void MToOne_RightTest()
  {
    Z_M_1 z = new Z_M_1(1);
    Y_M_1 y = new Y_M_1(z);
    z.delete();    

    Assert.assertEquals(null, y.getZVar());
    Assert.assertEquals(0, z.getY_m_1().size());
  }

  @Test
  public void MToM_RightTest()
  {
    Y_M_M y1 = new Y_M_M();
    Y_M_M y2 = new Y_M_M();
    Y_M_M y3 = new Y_M_M();
     
    Z_M_M z = new Z_M_M(1); 
    z.setY_m_m(y1, y2, y3);    

    z.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, y3.getZVar().size());
    Assert.assertEquals(0, z.getY_m_m().size());
  }

  @Test
  public void OneToStar_RightTest()
  {
    Y_1_star y = new Y_1_star();
    
    Z_1_star z = new Z_1_star(1, y); 

    z.delete();    

    Assert.assertEquals(0, y.getZVar().size());
    Assert.assertEquals(null, z.getY_1_star());
  }

  @Test
  public void MToStar_RightTest()
  {
    Y_M_star y1 = new Y_M_star();
    Y_M_star y2 = new Y_M_star();
    Y_M_star y3 = new Y_M_star();
     
    Z_M_star z = new Z_M_star(1, y1, y2, y3); 

    z.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, y3.getZVar().size());
    Assert.assertEquals(0, z.getY_m_star().size());
  }

  @Test
  public void StarToStar_RightTest()
  {
    Y_star_star y1 = new Y_star_star();
    Y_star_star y2 = new Y_star_star();
    Y_star_star y3 = new Y_star_star();
     
    Z_star_star z1 = new Z_star_star(1);
    z1.addY_star_star(y1);
    z1.addY_star_star(y2);
    z1.addY_star_star(y3);
    Z_star_star z2 = new Z_star_star(2); 
    z2.addY_star_star(y1);
    z2.addY_star_star(y2);

    y1.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, y3.getZVar().size());
    Assert.assertEquals(0, z1.getY_star_star().size());
    Assert.assertEquals(0, z2.getY_star_star().size());
  }

  @Test
  public void MNToOne_RightTest()
  {
    Z_m_n__1 z = new Z_m_n__1(1);
    Y_m_n__1 y = new Y_m_n__1(z);
    z.delete();    

    Assert.assertEquals(null, y.getZVar());
    Assert.assertEquals(0, z.getY_m_n__1().size());
  }

  @Test
  public void MNToM_RightTest()
  {
    Y_m_n__m y1 = new Y_m_n__m();
    Y_m_n__m y2 = new Y_m_n__m();
    Y_m_n__m y3 = new Y_m_n__m();
     
    Z_m_n__m z = new Z_m_n__m(1); 
    z.setY_m_n__m(y1, y2, y3);    

    z.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, y3.getZVar().size());
    Assert.assertEquals(0, z.getY_m_n__m().size());
  }

  @Test
  public void MNToStar_RightTest()
  {
    Y_m_n__star y1 = new Y_m_n__star();
    Y_m_n__star y2 = new Y_m_n__star();
    Y_m_n__star y3 = new Y_m_n__star();
     
    Z_m_n__star z = new Z_m_n__star(1, y1, y2); 
    z.addY_m_n__star(y3);
   
    z.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, y3.getZVar().size());
    Assert.assertEquals(0, z.getY_m_n__star().size());
  }

  @Test
  public void MNToMN_RightTest()
  {
    Y_m_n__m_n y1 = new Y_m_n__m_n();
    Y_m_n__m_n y2 = new Y_m_n__m_n();
     
    Z_m_n__m_n z = new Z_m_n__m_n(1); 
    z.setY_m_n__m_n(y1, y2);    

    z.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, z.getY_m_n__m_n().size());
  }

  @Test
  public void _0NToOne_RightTest()
  {
    Z_0_n__1 z = new Z_0_n__1(1);
    Y_0_n__1 y = new Y_0_n__1(z);
    z.delete();    

    Assert.assertEquals(null, y.getZVar());
    Assert.assertEquals(0, z.getY_0_n__1().size());
  }

  @Test
  public void _0NToM_RightTest()
  {
    Y_0_n__m y1 = new Y_0_n__m();
    Y_0_n__m y2 = new Y_0_n__m();
    Y_0_n__m y3 = new Y_0_n__m();
     
    Z_0_n__m z = new Z_0_n__m(1); 
    z.addY_0_n__m(y1);
    z.addY_0_n__m(y2);
    z.addY_0_n__m(y3);
    
    z.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, y3.getZVar().size());
    Assert.assertEquals(0, z.getY_0_n__m().size());
  }

  @Test
  public void _0NToStar_RightTest()
  {
    Y_0_n__star y1 = new Y_0_n__star();
    Y_0_n__star y2 = new Y_0_n__star();
     
    Z_0_n__star z = new Z_0_n__star(1); 
    z.addY_0_n__star(y1);
    z.addY_0_n__star(y2);
   
    z.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, z.getY_0_n__star().size());
  }

  @Test
  public void _0NTo0N_RightTest()
  {
    Y_0_n__0_n y1 = new Y_0_n__0_n();
    Y_0_n__0_n y2 = new Y_0_n__0_n();
     
    Z_0_n__0_n z1 = new Z_0_n__0_n(1); 
    z1.addY_0_n__0_n(y1);
    z1.addY_0_n__0_n(y2);   
    Z_0_n__0_n z2 = new Z_0_n__0_n(2); 
    z2.addY_0_n__0_n(y1);
    z2.addY_0_n__0_n(y2); 

    y1.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(0, y2.getZVar().size());
    Assert.assertEquals(0, z1.getY_0_n__0_n().size());
    Assert.assertEquals(0, z2.getY_0_n__0_n().size());
  }

  @Test
  public void _0OneToOne_RightTest()
  {
    Z_0_1__1 z = new Z_0_1__1(1);
    Y_0_1__1 y = new Y_0_1__1(z);
    y.getZVar().delete();    

    Assert.assertEquals(null, y.getZVar());
    Assert.assertEquals(null, z.getY_0_1__1());
  }

  @Test
  public void _0OneToM_RightTest()
  {
    Z_0_1__m z1 = new Z_0_1__m(1);
    Z_0_1__m z2 = new Z_0_1__m(2);
    Z_0_1__m z3 = new Z_0_1__m(3);
     
    Y_0_1__m y = new Y_0_1__m(z1, z2, z3); 
    
    z1.delete();    

    Assert.assertEquals(null, z1.getY_0_1__m());
    Assert.assertEquals(null, z2.getY_0_1__m());
    Assert.assertEquals(null, z3.getY_0_1__m());
    Assert.assertEquals(0, y.getZVar().size());
  }

  @Test
  public void _0OneToStar_RightTest()
  {
    Y_0_1__star y = new Y_0_1__star();
    
    Z_0_1__star z = new Z_0_1__star(1); 
    z.setY_0_1__star(y);

    z.delete();    

    Assert.assertEquals(0, y.getZVar().size());
    Assert.assertEquals(null, z.getY_0_1__star());
  }

  @Test
  public void _0OneToMN_RightTest()
  {
    Z_0_1__m_n z1 = new Z_0_1__m_n(1);
    Z_0_1__m_n z2 = new Z_0_1__m_n(2);
    Z_0_1__m_n z3 = new Z_0_1__m_n(3); 
    
    Y_0_1__m_n y = new Y_0_1__m_n(z1, z2, z3);

    y.delete();    

    Assert.assertEquals(0, y.getZVar().size());
    Assert.assertEquals(null, z1.getY_0_1__m_n());
    Assert.assertEquals(null, z2.getY_0_1__m_n());
    Assert.assertEquals(null, z3.getY_0_1__m_n());
  }

 
  @Test
  public void _01To0N_RightTest()
  {
    Y_0_1__0_n y1 = new Y_0_1__0_n();
     
    Z_0_1__0_n z1 = new Z_0_1__0_n(1); 
    z1.setY_0_1__0_n(y1);
    Z_0_1__0_n z2 = new Z_0_1__0_n(2); 
    z2.setY_0_1__0_n(y1);
    
    y1.delete();    

    Assert.assertEquals(0, y1.getZVar().size());
    Assert.assertEquals(null, z1.getY_0_1__0_n());
    Assert.assertEquals(null, z2.getY_0_1__0_n());
  }

  @Test
  public void _0OneTo0One_RightTest()
  {
    Z_0_1__0_1 z = new Z_0_1__0_1(1);
    Y_0_1__0_1 y = new Y_0_1__0_1();
    y.setZVar(z);
    
    z.delete();    

    Assert.assertEquals(null, y.getZVar());
    Assert.assertEquals(null, z.getY_0_1__0_1());
  }


}
