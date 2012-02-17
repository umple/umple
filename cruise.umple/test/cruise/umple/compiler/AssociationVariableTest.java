/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

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
  
  
  @Test
  public void isImmutable()
  {
	AssociationVariable assoc1 = new AssociationVariable("x","y","","",createMultiplicity(1,1),true);
	Assert.assertEquals(false, assoc1.isImmutable());
	
	AssociationVariable assoc2 = new AssociationVariable("x","y", "","",createMultiplicity(1,1),true);
	assoc1.setRelatedAssociation(assoc2);
	Assert.assertEquals(false, assoc1.isImmutable());
	Assert.assertEquals(false, assoc2.isImmutable());
	
	assoc1.setModifier("immutable");
	Assert.assertEquals(true, assoc1.isImmutable());
    Assert.assertEquals(true, assoc2.isImmutable());
    
    assoc2.setModifier("immutable");
	Assert.assertEquals(true, assoc1.isImmutable());
    Assert.assertEquals(true, assoc2.isImmutable());
  }
  
  @Test
  public void isImmutable_basedOnClass()
  {
    UmpleClass c = new UmpleClass("Student");
    UmpleClass c2 = new UmpleClass("Mentor");
    
    AssociationVariable assoc1 = new AssociationVariable("x","Mentor","","",createMultiplicity(1,1),true);
	AssociationVariable assoc2 = new AssociationVariable("y","Student", "","",createMultiplicity(1,1),false);
	assoc1.setRelatedAssociation(assoc2);
	c.addAssociationVariable(assoc1);
	Assert.assertEquals(false, assoc1.isImmutable());
	Assert.assertEquals(false, assoc2.isImmutable());
	
	Assert.assertTrue(c.setImmutable(true));
	Assert.assertEquals(true, assoc1.isImmutable());
    Assert.assertEquals(true, assoc2.isImmutable());
    
    c.removeAssociationVariable(assoc1);
    Assert.assertTrue(c.setImmutable(false));
    
    
    assoc1 = new AssociationVariable("x","Mentor","","",createMultiplicity(0,1),true);
	assoc2 = new AssociationVariable("y","Student", "","",createMultiplicity(0,2),false);
	assoc1.setRelatedAssociation(assoc2);
	Assert.assertTrue(c.addAssociationVariable(assoc1));
	Assert.assertTrue(c2.addAssociationVariable(assoc2));
	
	Assert.assertEquals(false, assoc1.isImmutable());
	Assert.assertEquals(false, assoc2.isImmutable());
	
	Assert.assertTrue(c2.setImmutable(true));
	Assert.assertTrue(c.setImmutable(true));
	Assert.assertEquals(true, assoc1.isImmutable());
    Assert.assertEquals(true, assoc2.isImmutable());
    
    Assert.assertTrue(c.setImmutable(false));
    Assert.assertEquals(false, assoc1.isImmutable());
	Assert.assertEquals(false, assoc2.isImmutable());
  }
  
  @Test
  public void canBeMadeImmutable()
  {
	UmpleClass c = new UmpleClass("Student");
	UmpleClass c2 = new UmpleClass("Mentor");
	    
	AssociationVariable assoc1 = new AssociationVariable("x","Mentor","","",createMultiplicity(1,1),true);
	AssociationVariable assoc2 = new AssociationVariable("y","Student", "","",createMultiplicity(1,1),true);
	assoc1.setRelatedAssociation(assoc2);
	
	Assert.assertFalse(assoc1.setImmutable(true));
	assoc1.setIsNavigable(false);
	Assert.assertTrue(assoc1.setImmutable(true));
	
	Assert.assertTrue(assoc1.setImmutable(false));
	assoc1.setIsNavigable(true);
	
	c.addAssociationVariable(assoc1);
	c2.addAssociationVariable(assoc2);
	Assert.assertFalse(assoc1.setImmutable(true));
	assoc1.setIsNavigable(false);
	Assert.assertTrue(assoc1.setImmutable(true));
  }
  
  @Test
  public void canBeMadeNavigableWithImmutableClass()
  {
	UmpleClass c = new UmpleClass("Student");
	UmpleClass c2 = new UmpleClass("Mentor");
	    
	AssociationVariable assoc1 = new AssociationVariable("x","Mentor","","",createMultiplicity(1,1),true);
	AssociationVariable assoc2 = new AssociationVariable("y","Student", "","",createMultiplicity(1,1),false);
	assoc1.setRelatedAssociation(assoc2);	
	
	Assert.assertTrue(assoc2.setIsNavigable(true));
	Assert.assertTrue(assoc2.setIsNavigable(false));
	
	c2.setImmutable(true);
	c2.addAssociationVariable(assoc2);
	Assert.assertFalse(assoc2.setIsNavigable(true));
	Assert.assertTrue(assoc1.setIsNavigable(false));
	Assert.assertTrue(assoc2.setIsNavigable(true));
	
	Assert.assertTrue(assoc2.setIsNavigable(false));
	Assert.assertTrue(assoc1.setIsNavigable(true));
	
	c.addAssociationVariable(assoc1);
	Assert.assertFalse(assoc2.setIsNavigable(true));
	Assert.assertTrue(assoc1.setIsNavigable(false));
	Assert.assertTrue(assoc2.setIsNavigable(true));
  }
  
  @Test
  public void canSetRelatedAssociationWithImmutableClass()
  {
	  UmpleClass aClass = new UmpleClass("aClass");
	  UmpleClass bClass = new UmpleClass("bClass");
	  
	  Multiplicity mult = new Multiplicity();
	  mult.setRange("0", "10");
	  AssociationVariable a = new AssociationVariable("a", "a", "", "", mult, true);
	  mult = new Multiplicity();
	  mult.setRange("1", "1");
	  AssociationVariable b = new AssociationVariable("b", "b", "", "", mult, true);
	  
	  aClass.addAssociationVariable(a);
	  bClass.addAssociationVariable(b);	  
	  Assert.assertTrue(a.setRelatedAssociation(b));
	  
	  aClass.removeAssociationVariable(a);
	  
	  a = new AssociationVariable("a", "a", "", "", mult, true);
	  b = new AssociationVariable("b", "b", "", "", mult, true);
	  aClass.addAssociationVariable(a);
	  bClass.addAssociationVariable(b);
	  Assert.assertTrue(aClass.setImmutable(true)); 
	  Assert.assertFalse(a.setRelatedAssociation(b));
	  
	  b.setIsNavigable(false);	  
	  Assert.assertFalse(a.setRelatedAssociation(b));
	  
	  b.setIsNavigable(true);
	  a.setIsNavigable(false);
	  Assert.assertTrue(a.setRelatedAssociation(b));
	  
	  a = new AssociationVariable("a", "a", "", "", mult, true);
	  b = new AssociationVariable("b", "b", "", "", mult, false);
	  aClass.addAssociationVariable(a);
	  bClass.addAssociationVariable(b);
	  bClass.setImmutable(true);
	  Assert.assertTrue(a.setRelatedAssociation(b));
	  
	  // asymmetric reflexive association
	  a = new AssociationVariable("a", "a", "", "", mult, true);
	  b = new AssociationVariable("b", "b", "", "", mult, false);
	  aClass.addAssociationVariable(a);
	  aClass.addAssociationVariable(b);
	  Assert.assertTrue(a.setRelatedAssociation(b));
  }

  private Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }

}
