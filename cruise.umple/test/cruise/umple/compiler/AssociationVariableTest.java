package cruise.umple.compiler;

import org.junit.*;

public class AssociationVariableTest
{

  @Test
  public void isSymmetricReflexive()
  {
    AssociationVariable var = new AssociationVariable("aName","MyType","symmetricreflexive","",createMultiplicity(0,1),true);
    AssociationVariable var2 = new AssociationVariable("anotherName","MyType","not","",createMultiplicity(0,1),true);
    AssociationVariable var3 = new AssociationVariable("thirdName","NotMyType","symmetricreflexive","",createMultiplicity(0,1),true);

    Assert.assertEquals(false, var.isSymmetricReflexive());
    
    var.setRelatedAssociation(var2);
    Assert.assertEquals(false, var2.isSymmetricReflexive());
    
    var.setRelatedAssociation(var3);
    Assert.assertEquals(true, var.isSymmetricReflexive());
  }
    
  @Test
  public void MinAndMaxBasedOnMinusOneAsMany()
  {
    Assert.assertEquals(3,AssociationVariable.min(3,4));
    Assert.assertEquals(4,AssociationVariable.min(-1,4));
    Assert.assertEquals(-1,AssociationVariable.min(-1,-1));

    Assert.assertEquals(4,AssociationVariable.max(3,4));
    Assert.assertEquals(-1,AssociationVariable.max(-1,4));
    Assert.assertEquals(-1,AssociationVariable.max(-1,-1));
  
  }
  
  @Test
  public void isMany()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(true,var.isMany());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(true,var.isMany());

    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false,var.isMany());
  }

  @Test
  public void isOptionalN()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isOptionalN());

    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(true,var.isOptionalN());

    var.getMultiplicity().setMaximum("3");
    Assert.assertEquals(true,var.isOptionalN());

    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false,var.isOptionalN());
  }

  @Test
  public void isOne()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isOne());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isOne());

    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(true,var.isOne());
  }

  @Test
  public void isOnlyOne()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isOnlyOne());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isOnlyOne());

    var.getMultiplicity().setMinimum("1");
    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(true,var.isOnlyOne());

    var.getMultiplicity().setMinimum("0");
    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false,var.isOnlyOne());
  }

  @Test
  public void isOptionalOne()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isOptionalOne());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isOptionalOne());

    var.getMultiplicity().setMinimum("1");
    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false,var.isOptionalOne());

    var.getMultiplicity().setMinimum("0");
    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(true,var.isOptionalOne());
  }
  
  @Test
  public void isN()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isN());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isN());

    var.getMultiplicity().setMinimum("1");
    Assert.assertEquals(false,var.isN());

    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false,var.isN());

    var.getMultiplicity().setMinimum("2");
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(true,var.isN());
    
    var.getMultiplicity().setMinimum("*");
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isN());    
  }  
  
  @Test
  public void isMN()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isMN());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isMN());

    var.getMultiplicity().setMinimum("1");
    Assert.assertEquals(true,var.isMN());

    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false,var.isMN());

    var.getMultiplicity().setMinimum("2");
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isMN());

    var.getMultiplicity().setMinimum("2");
    var.getMultiplicity().setMaximum("5");
    Assert.assertEquals(true,var.isMN());

    var.getMultiplicity().setMinimum("2");
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(true,var.isMN());
  }   

  @Test
  public void isMStar()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isMStar());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isMStar());

    var.getMultiplicity().setMinimum("1");
    Assert.assertEquals(false,var.isMStar());

    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false,var.isMStar());

    var.getMultiplicity().setMinimum("2");
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isMStar());

    var.getMultiplicity().setMinimum("2");
    var.getMultiplicity().setMaximum("5");
    Assert.assertEquals(false,var.isMStar());

    var.getMultiplicity().setMinimum("2");
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(true,var.isMStar());
    
  }   
  
  
  @Test
  public void isStar()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(true,var.isStar());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isStar());

  }   

  
  @Test
  public void isMandatory()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isMandatory());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isMandatory());

    var.getMultiplicity().setMinimum("1");
    Assert.assertEquals(true,var.isMandatory());

    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(true,var.isMandatory());
  }
  
  @Test
  public void isMandatoryMany()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isMandatoryMany());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isMandatoryMany());

    var.getMultiplicity().setMinimum("1");
    Assert.assertEquals(true,var.isMandatoryMany());

    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false,var.isMandatoryMany());
  }
  
  @Test
  public void isMandatoryOne()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    var.getMultiplicity().setMinimum("1");
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isMandatoryOne());

    var.getMultiplicity().setMinimum("0");
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(false,var.isMandatoryOne());

    var.getMultiplicity().setMinimum("1");
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isMandatoryOne());

    var.getMultiplicity().setMinimum("0");
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(false,var.isMandatoryOne());

    var.getMultiplicity().setMinimum("1");
    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(true,var.isMandatoryOne());

    var.getMultiplicity().setMinimum("3");
    var.getMultiplicity().setMaximum("6");
    Assert.assertEquals(false,var.isMandatoryOne());

  }

  @Test
  public void isOptionalMany()
  {
    AssociationVariable var = new AssociationVariable("x","y","","",createMultiplicity(0,1),true);
    
    var.getMultiplicity().setMinimum("1");
    Assert.assertEquals(false, var.isOptionalMany());

    var.getMultiplicity().setMinimum("0");
    var.getMultiplicity().setMaximum("1");
    Assert.assertEquals(false, var.isOptionalMany());
    
    var.getMultiplicity().setMaximum("2");
    Assert.assertEquals(true, var.isOptionalMany());
    
    var.getMultiplicity().setMaximum("*");
    Assert.assertEquals(true, var.isOptionalMany());
    
  }
  
  @Test
  public void getAssociatedName()
  {
    AssociationVariable var1 = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    AssociationVariable var2 = new AssociationVariable("x","y","","",createMultiplicity(0,0),true);
    
    Assert.assertEquals(null, var1.getRelatedAssociation());
    
    var2.setRelatedAssociation(var1);
    Assert.assertEquals(var2, var1.getRelatedAssociation());
    Assert.assertEquals(var1, var2.getRelatedAssociation());
  }

  private Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }

}
