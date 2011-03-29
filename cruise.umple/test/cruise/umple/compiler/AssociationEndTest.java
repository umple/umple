package cruise.umple.compiler;

import org.junit.*;

public class AssociationEndTest
{
  
  @Test
  public void getDisplayRoleName()
  {
    AssociationEnd end;
    
    end = new AssociationEnd("x","StudentPerson","c","d",createMultiplicity(0, 1));
    Assert.assertEquals("x",end.getDisplayRoleName());
    
    end = new AssociationEnd(null,"StudentPerson","c","d",createMultiplicity(0, 1));
    Assert.assertEquals("",end.getDisplayRoleName());

    end.setIsDefaultRoleName(true);
    Assert.assertEquals("",end.getDisplayRoleName());
  }
  

  
  @Test
  public void getUpperBoundString()
  {
    AssociationEnd end = new AssociationEnd("a","b","c","d",createMultiplicity(1, 1));
    Assert.assertEquals("1",end.getUpperBoundString());
    end.getMultiplicity().setMaximum("2");
    Assert.assertEquals("2",end.getUpperBoundString());
    end.getMultiplicity().setMaximum("*");
    Assert.assertEquals("*",end.getUpperBoundString());
  }
  
  @Test
  public void getLowerBoundString()
  {
    AssociationEnd end = new AssociationEnd("a","b","c","d",createMultiplicity(1,2));
    Assert.assertEquals("1",end.getLowerBoundString());
    end.getMultiplicity().setMinimum("2");
    Assert.assertEquals("2",end.getLowerBoundString());
    end.getMultiplicity().setMinimum("*");
    Assert.assertEquals("*",end.getLowerBoundString());
  }

  @Test
  public void fullConstructor()
  {
    AssociationEnd end = new AssociationEnd("a","b","c","d",createMultiplicity(1,2));

    Assert.assertEquals(1, end.getMultiplicity().getLowerBound());
    Assert.assertEquals(2, end.getMultiplicity().getUpperBound());
    Assert.assertEquals("a",end.getRoleName());
    Assert.assertEquals("b", end.getClassName());
    Assert.assertEquals("c",end.getModifier());
    Assert.assertEquals("d", end.getReferenceToClassName());    
  }
  
  @Test
  public void stringBoundsConstructor_normal()
  {
    AssociationEnd end = new AssociationEnd("a","b","c","d",createMultiplicity(1,2));

    Assert.assertEquals(1, end.getMultiplicity().getLowerBound());
    Assert.assertEquals(2, end.getMultiplicity().getUpperBound());
    Assert.assertEquals("a",end.getRoleName());
    Assert.assertEquals("b", end.getClassName());
    Assert.assertEquals("c",end.getModifier());
    Assert.assertEquals("d", end.getReferenceToClassName());    
  }  

  @Test
  public void stringBoundsConstructor_many()
  {
    AssociationEnd end = new AssociationEnd("a","b","c","d",createMultiplicity(-1,-1));

    Assert.assertEquals(-1, end.getMultiplicity().getLowerBound());
    Assert.assertEquals(-1, end.getMultiplicity().getUpperBound());
    Assert.assertEquals("a",end.getRoleName());
    Assert.assertEquals("b", end.getClassName());
    Assert.assertEquals("c",end.getModifier());
    Assert.assertEquals("d", end.getReferenceToClassName());    
  }  
  
  @Test
  public void toSimpleGenericString()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,null,null,null,createMultiplicity(0,1));
    Assert.assertEquals("0..1", end.toGenericString());
    
    end = new AssociationEnd(null,null,null,null,createMultiplicity(0,-1));
    Assert.assertEquals("*", end.toGenericString());
    
    end = new AssociationEnd(null,null,null,null,createMultiplicity(0,3));
    Assert.assertEquals("0..n", end.toGenericString());

    end = new AssociationEnd(null,null,null,null,createMultiplicity(1,1));
    Assert.assertEquals("1", end.toGenericString());
    
    end = new AssociationEnd(null,null,null,null,createMultiplicity(1,-1));
    Assert.assertEquals("1..*", end.toGenericString());

    end = new AssociationEnd(null,null,null,null,createMultiplicity(1,8));
    Assert.assertEquals("1..n", end.toGenericString());
    
    end = new AssociationEnd(null,null,null,null,createMultiplicity(4,4));
    Assert.assertEquals("n", end.toGenericString());
  
    end = new AssociationEnd(null,null,null,null,createMultiplicity(4,-1));
    Assert.assertEquals("n..*", end.toGenericString());
  
    end = new AssociationEnd(null,null,null,null,createMultiplicity(4,8));
    Assert.assertEquals("n..m", end.toGenericString());
}
  
  @Test
  public void toSimpleStringNoRange()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,null,null,null,createMultiplicity(1,1));
    Assert.assertEquals("1", end.toSimpleString());
    
    end = new AssociationEnd(null,null,null,null,createMultiplicity(3,3));
    Assert.assertEquals("3", end.toSimpleString());
  }
  
  @Test
  public void toSimpleStringHasRange()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,null,null,null,createMultiplicity(0,1));
    Assert.assertEquals("0..1", end.toSimpleString());
    
    end = new AssociationEnd(null,null,null,null,createMultiplicity(3,5));
    Assert.assertEquals("3..5", end.toSimpleString());

    end = new AssociationEnd(null,null,null,null,createMultiplicity(4,-1));
    Assert.assertEquals("4..*", end.toSimpleString());
    
  }  
  
  @Test
  public void toSimpleStringSpecialCases()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,null,null,null,createMultiplicity(0,-1));
    Assert.assertEquals("*", end.toSimpleString());
    
    end = new AssociationEnd(null,null,null,null,createMultiplicity(-1,-1));
    Assert.assertEquals("*..*", end.toSimpleString());    
  }  
  
  @Test
  public void toStringNothingToShow()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,null,null,null,createMultiplicity(1,3));
    Assert.assertEquals("1..3", end.toString());
  }
  
  @Test
  public void toStringAlsoIgnoreEmptyString()
  {
    AssociationEnd end;

    end = new AssociationEnd("","","","",createMultiplicity(1,3));
    Assert.assertEquals("1..3", end.toString());
  }
  
  @Test
  public void toStringRole()
  {
    AssociationEnd end;

    end = new AssociationEnd("r",null,null,null,createMultiplicity(0,1));
    Assert.assertEquals("0..1 [r]", end.toString());
  }  

  @Test
  public void toStringClass()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,"c",null,null,createMultiplicity(0,1));
    Assert.assertEquals("0..1 c", end.toString());
  }  
  
  @Test
  public void toStringModifier()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,null,"ordered",null,createMultiplicity(0,1));
    Assert.assertEquals("ordered 0..1", end.toString());
  }    
  
  @Test
  public void toStringReferenceTo()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,null,null,"c2",createMultiplicity(0,1));
    Assert.assertEquals("0..1 -- c2", end.toString());
  }    

  @Test
  public void toStringEverythingTo()
  {
    AssociationEnd end;

    end = new AssociationEnd("r","c","ordered","c2",createMultiplicity(0,1));
    Assert.assertEquals("ordered 0..1 [r] c -- c2", end.toString());
  } 
  
  @Test
  public void equals_null()
  {
    AssociationEnd end;

    end = new AssociationEnd(null,null,null,null,createMultiplicity(0,-1));
    Assert.assertEquals(false,end.equals(null));
    Assert.assertEquals(false,end.equals("blah"));
  }   

  @Test
  public void equals_checkAllData_notEquals()
  {
    AssociationEnd end,compareTo;

    end = new AssociationEnd("a","b","c","d",createMultiplicity(1,2));
    compareTo = new AssociationEnd("a","b","c","d",createMultiplicity(10,2));
    Assert.assertEquals(false,end.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(end));

    compareTo = new AssociationEnd("a","b","c","d",createMultiplicity(1,20));
    Assert.assertEquals(false,end.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(end));
    
    compareTo = new AssociationEnd("aa","b","c","d",createMultiplicity(1,2));
    Assert.assertEquals(false,end.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(end));

    compareTo = new AssociationEnd("a","bb","c","d",createMultiplicity(1,2));
    Assert.assertEquals(false,end.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(end));

    compareTo = new AssociationEnd("a","b","cc","d",createMultiplicity(1,2));
    Assert.assertEquals(false,end.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(end));

    compareTo = new AssociationEnd("a","b","c","dd",createMultiplicity(1,2));
    Assert.assertEquals(false,end.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(end));
    
  }   

  @Test
  public void equals_checkAllData_okay()
  {
    AssociationEnd end,compareTo;

    end = new AssociationEnd("a","b","c","d",createMultiplicity(1,2));
    compareTo = new AssociationEnd("a","b","c","d",createMultiplicity(1,2));
    Assert.assertEquals(true,end.equals(compareTo));
    Assert.assertEquals(true,compareTo.equals(end));
    Assert.assertEquals(true,end.equals(end));
  }   
  
  @Test
  public void equals_checkAllData_nullNoLongerSameAsEmpty()
  {
    AssociationEnd end,compareTo;

    end = new AssociationEnd(null,null,null,null,createMultiplicity(1,2));
    compareTo = new AssociationEnd("","","","",createMultiplicity(1,2));
    Assert.assertEquals(false,end.equals(compareTo));
    Assert.assertEquals(false,compareTo.equals(end));
    Assert.assertEquals(true,end.equals(end));
  }   
  
  @Test
  public void isNavigable()
  {
    AssociationEnd end;
    
    end = new AssociationEnd(null,null,null,null,createMultiplicity(1,2));
    Assert.assertEquals(true,end.isNavigable());

    end = new AssociationEnd(null,null,"x",null,createMultiplicity(1,2));
    Assert.assertEquals(true,end.isNavigable());
    
    end = new AssociationEnd(null,null,"nonNavigable",null,createMultiplicity(1,2));
    Assert.assertEquals(false,end.isNavigable());

    end = new AssociationEnd(null,null,"NonNaviGabLe",null,createMultiplicity(1,2));
    Assert.assertEquals(false,end.isNavigable());
    
  }

  private Multiplicity createMultiplicity(int lowerBound, int upperBound)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lowerBound + "", upperBound + "");
    return m;
  }
  
}
