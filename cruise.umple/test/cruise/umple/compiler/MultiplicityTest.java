/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class MultiplicityTest
{

  @Test
  public void Constructor_Nulls()
  {
    Multiplicity m = new Multiplicity();
    Assert.assertEquals(-2,m.getLowerBound());
    Assert.assertEquals(-2,m.getUpperBound());
  }
  
  @Test
  public void Constructor_Bound()
  {
    Multiplicity m = new Multiplicity();
    m.setBound("1");
    Assert.assertEquals(1,m.getLowerBound());
    Assert.assertEquals(1,m.getUpperBound());
  }

  @Test
  public void setRange_ExplicitBounds()
  {
    Multiplicity m = new Multiplicity();
    m.setRange("1", "2");
    Assert.assertEquals(1,m.getLowerBound());
    Assert.assertEquals(2,m.getUpperBound());
  }

  @Test
  public void Constructor_TakeBoundFirst()
  {
    Multiplicity m = new Multiplicity();
    m.setBound("3");
    m.setRange("1","2");
    Assert.assertEquals(3,m.getLowerBound());
    Assert.assertEquals(3,m.getUpperBound());
    Assert.assertEquals(true,m.isLowerBoundNumeric());
    Assert.assertEquals(true,m.isUpperBoundNumeric());
    
  }
  
  @Test
  public void Constructor_HandleStar()
  {
    Multiplicity m = new Multiplicity();
    m.setBound("*");
    
    Assert.assertEquals(0,m.getLowerBound());
    Assert.assertEquals(-1,m.getUpperBound());
    Assert.assertEquals(false,m.isLowerBoundMany());
    Assert.assertEquals(true,m.isUpperBoundMany());
    Assert.assertEquals(true,m.isLowerBoundNumeric());
    Assert.assertEquals(true,m.isUpperBoundNumeric());
    
  }  
  
  @Test
  public void Constructor_HandleNonNumerics()
  {
    Multiplicity m = new Multiplicity();
    m.setBound("abc");
    Assert.assertEquals(-2,m.getLowerBound());
    Assert.assertEquals(-2,m.getUpperBound());
    Assert.assertEquals(false,m.isLowerBoundNumeric());
    Assert.assertEquals(false,m.isUpperBoundNumeric());
  }  
  
  private Multiplicity createMultiplicity(String bound, String minimum, String maximum)
  {
    Multiplicity m = new Multiplicity();
    m.setBound(bound);
    m.setMinimum(minimum);
    m.setMaximum(maximum);
    return m;
  }
  
  @Test
  public void isValid()
  {
    Assert.assertEquals(true,createMultiplicity(null,"0","1").isValid());
    Assert.assertEquals(true,createMultiplicity(null,"1","1").isValid());
    Assert.assertEquals(true,createMultiplicity(null,"1","2").isValid());
    Assert.assertEquals(true,createMultiplicity(null,"1","*").isValid());
    Assert.assertEquals(true,createMultiplicity(null,"2","3").isValid());
    Assert.assertEquals(true,createMultiplicity(null,"2","*").isValid());
    
    Assert.assertEquals(false,createMultiplicity(null,"-1","-1").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"-2","-2").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"-3","-2").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"-1","0").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"-2","0").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"3","2").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"3","-1").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"3","-2").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"-2","1").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"-1","1").isValid());

    Assert.assertEquals(false,createMultiplicity(null,"*","*").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"*","0").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"*","1").isValid());
    Assert.assertEquals(false,createMultiplicity(null,"*","2").isValid());
    
    
    Assert.assertEquals(true,createMultiplicity("1",null,null).isValid());
    Assert.assertEquals(true,createMultiplicity("2",null,null).isValid());
    Assert.assertEquals(true,createMultiplicity("*",null,null).isValid());
    Assert.assertEquals(false,createMultiplicity("-1",null,null).isValid());
    Assert.assertEquals(false,createMultiplicity("-2",null,null).isValid());
    
  }

  @Test
  public void minimizeRange_bound()
  {
    Multiplicity m = new Multiplicity();
    m.setRange("3", "5");
    
    Multiplicity m2 = new Multiplicity();
    m2.setBound("4");
    
    m.minimizeRange(m2);
    Assert.assertEquals(3,m.getLowerBound());
    Assert.assertEquals(5,m.getUpperBound());
    Assert.assertEquals(null,m.getBound());
  }

  @Test
  public void minimizeRange_contract()
  {
    Multiplicity m2 = new Multiplicity();
    m2.setRange("3", "5");
    
    Multiplicity m = new Multiplicity();
    m.setRange("2","6");
    
    m.minimizeRange(m2);
    Assert.assertEquals(3,m.getLowerBound());
    Assert.assertEquals(5,m.getUpperBound());    
  }
  
  @Test
  public void minimizeRange_noChange()
  {
    Multiplicity m = new Multiplicity();
    m.setRange("3", "5");
    
    Multiplicity m2 = new Multiplicity();
    m2.setRange("2","6");
    
    m.minimizeRange(m2);
    Assert.assertEquals(3,m.getLowerBound());
    Assert.assertEquals(5,m.getUpperBound());
    
  }

  @Test
  public void minimizeRange_dealWithStar()
  {
    Multiplicity m2 = new Multiplicity();
    m2.setRange("*", "*");
    
    Multiplicity m = new Multiplicity();
    m.setRange("2","6");
    
    m.minimizeRange(m2);
    Assert.assertEquals(2,m.getLowerBound());
    Assert.assertEquals(6,m.getUpperBound());    
  }
  
  @Test
  public void getRange()
  {
    Multiplicity m = new Multiplicity();
    
    m.setBound("*");
    Assert.assertEquals("[0,*]",m.getRange());
    
    m.setBound(null);
    m.setRange("3", "5");
    Assert.assertEquals("[3,5]",m.getRange());
    
    m.setRange("3", "*");
    Assert.assertEquals("[3,*]",m.getRange());

    m.setBound("4");
    Assert.assertEquals("[4,4]",m.getRange());
  }
  
//  @Test
//  public void getParserable()
//  {
//    Multiplicity m = new Multiplicity();
//    
//    m.setBound("*");
//    Assert.assertEquals("*", m.getParserable());
//    
//    m.setBound(null);
//    m.setRange("3", "5");
//    Assert.assertEquals("3..5",m.getParserable());
//    
//    m.setRange("3", "*");
//    Assert.assertEquals("3..*",m.getParserable());
//
//    m.setRange("0", "*");
//    Assert.assertEquals("*",m.getParserable());
//
//    m.setBound("4");
//    Assert.assertEquals("4",m.getParserable());
//  }  
  
  @Test
  public void getRangeParts()
  {
    Multiplicity m = new Multiplicity();
    
    m.setBound("*");
    Assert.assertEquals("0",m.getRangeParts()[0]);
    Assert.assertEquals("*",m.getRangeParts()[1]);
    
    m.setBound(null);
    m.setRange("3", "5");
    Assert.assertEquals("3",m.getRangeParts()[0]);
    Assert.assertEquals("5",m.getRangeParts()[1]);
    
    m.setRange("3", "*");
    Assert.assertEquals("3",m.getRangeParts()[0]);
    Assert.assertEquals("*",m.getRangeParts()[1]);

    m.setBound("4");
    Assert.assertEquals("4",m.getRangeParts()[0]);
    Assert.assertEquals("4",m.getRangeParts()[1]);
  }
  
  @Test
  public void isMany()
  {
    Multiplicity m = new Multiplicity();
    
    m.setRange("0","*");
    Assert.assertEquals(true, m.isMany());
    Assert.assertEquals(false, m.isOne());

    m.setRange("0","4");
    Assert.assertEquals(true, m.isMany());
    Assert.assertEquals(false, m.isOne());

    m.setRange("0","1");
    Assert.assertEquals(false, m.isMany());
    Assert.assertEquals(true, m.isOne());
    
  }
  

}

