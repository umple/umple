package cruise.patterns.test;

import org.junit.*;
import java.lang.reflect.*;

public class ClassLevelImmutabilityTest
{

  @Test
  public void noDeleteForAssociationsAndAttributesOfImmutableClass()
  {
    WidgetImmutableB associated = new WidgetImmutableB("name");

    WidgetImmutableA widget = new WidgetImmutableA("Big Widget", associated);
    Assert.assertEquals(widget.getName(), "Big Widget");
    Assert.assertEquals(widget.getWidgetImmutableB(), associated);

    widget.delete();
    Assert.assertEquals(widget.getName(), "Big Widget");
    Assert.assertEquals(widget.getWidgetImmutableB(), associated);
  }
  
  @Test
  public void noDeleteForAssociationsAndAttributesOfSubclassOfImmutableClass()
  {
    WidgetImmutableB associated = new WidgetImmutableB("name");

    WidgetSubclass widget = new WidgetSubclass("Little Widget", "myType", associated);
    Assert.assertEquals(widget.getName(), "Little Widget");
    Assert.assertEquals(widget.getType(), "myType");
    Assert.assertEquals(widget.getWidgetImmutableB(0), associated);

    widget.delete();
    Assert.assertEquals(widget.getName(), "Little Widget");
    Assert.assertEquals(widget.getType(), "myType");
    Assert.assertEquals(widget.getWidgetImmutableB(0), associated);
  }

  @Test
  public void mutableClassHasSettersRemoversAndAddMethods()
  {
    WidgetMutableB widget = new WidgetMutableB();
    Assert.assertTrue(objectClassHasSettersAddersOrRemovers(widget));
  }

  @Test
  public void unidirectionalManyAssociation()
  {
    ClassOtherclass other1 = new ClassOtherclass("otherClass");
    ClassOtherclass other2 = new ClassOtherclass("otherClass");

    ClassMany many = new ClassMany();
    Assert.assertFalse(many.hasClassOtherclasses());
    many = new ClassMany(other1);
    Assert.assertTrue(many.hasClassOtherclasses());
    many = new ClassMany(other1, other2);
    Assert.assertTrue(many.hasClassOtherclasses());
    Assert.assertTrue(many.indexOfClassOtherclass(other1) >= 0);
    Assert.assertTrue(many.indexOfClassOtherclass(other2) >= 0);
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(many));
  }

  @Test
  public void unidirectionalMToNAssociation()
  {
    ClassOtherclass other1 = new ClassOtherclass("other");
    ClassOtherclass other2 = new ClassOtherclass("other");
    ClassOtherclass other3 = new ClassOtherclass("other");
    ClassOtherclass other4 = new ClassOtherclass("other");

    ClassMToN mToN;
    try {
      mToN = new ClassMToN();
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    try {
      mToN = new ClassMToN(other1);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    mToN = new ClassMToN(other1, other2);
    Assert.assertTrue(mToN.hasClassOtherclasses());
    Assert.assertTrue(mToN.indexOfClassOtherclass(other1) >= 0);
    Assert.assertTrue(mToN.indexOfClassOtherclass(other2) >= 0);

    mToN = new ClassMToN(other1, other2, other3);
    Assert.assertTrue(mToN.hasClassOtherclasses());

    try {
      mToN = new ClassMToN(other1, other2, other3, other4);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(mToN));
  }

  @Test
  public void unidirectionalMStarAssociation()
  {
    ClassOtherclass other1 = new ClassOtherclass("other");
    ClassOtherclass other2 = new ClassOtherclass("other");
    ClassOtherclass other3 = new ClassOtherclass("other");

    ClassMStar mStar;
    try {
      mStar = new ClassMStar();
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    try {
      mStar = new ClassMStar(other1);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    mStar = new ClassMStar(other1, other2);
    Assert.assertTrue(mStar.hasClassOtherclasses());
    Assert.assertTrue(mStar.indexOfClassOtherclass(other1) >= 0);
    Assert.assertTrue(mStar.indexOfClassOtherclass(other2) >= 0);

    mStar = new ClassMStar(other1, other2, other3);
    Assert.assertTrue(mStar.hasClassOtherclasses());
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(mStar));
  }

  @Test
  public void unidirectionalNAssociation()
  {
    ClassOtherclass other1 = new ClassOtherclass("other");
    ClassOtherclass other2 = new ClassOtherclass("other");
    ClassOtherclass other3 = new ClassOtherclass("other");

    ClassN n;
    try {
      n = new ClassN();
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    try {
      n = new ClassN(other1);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    n = new ClassN(other1, other2);
    Assert.assertTrue(n.hasClassOtherclasses());
    Assert.assertTrue(n.indexOfClassOtherclass(other1) >= 0);
    Assert.assertTrue(n.indexOfClassOtherclass(other2) >= 0);

    try {
      n = new ClassN(other1, other2, other3);
    } catch (RuntimeException ex) {}
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(n));
  }

  @Test
  public void unidirectionalOneAssociation()
  {
    ClassOtherclass other = new ClassOtherclass("otherClass");

    ClassOne one = new ClassOne(other);
    Assert.assertTrue(one.getClassOtherclass() == other);

    try {
      one = new ClassOne(null);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(one));  
  }

  @Test
  public void unidirectionalOptionalNAssociation()
  {
    ClassOtherclass other1 = new ClassOtherclass("other");
    ClassOtherclass other2 = new ClassOtherclass("other");
    ClassOtherclass other3 = new ClassOtherclass("other");

    ClassOptionalN optN = new ClassOptionalN();
    Assert.assertFalse(optN.hasClassOtherclasses());
    
    optN = new ClassOptionalN(other1);
    Assert.assertTrue(optN.hasClassOtherclasses());
    Assert.assertTrue(optN.indexOfClassOtherclass(other1) >= 0);

    optN = new ClassOptionalN(other1, other2);
    Assert.assertTrue(optN.hasClassOtherclasses());
    Assert.assertTrue(optN.indexOfClassOtherclass(other1) >= 0);
    Assert.assertTrue(optN.indexOfClassOtherclass(other2) >= 0);

    try {
      optN = new ClassOptionalN(other1, other2, other3);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(optN));   
  }

  @Test
  public void unidirectionalOptionalOneAssociation()
  {
    ClassOtherclass other = new ClassOtherclass("otherClass");

    ClassOptionalOne optOne = new ClassOptionalOne(other);
    Assert.assertTrue(optOne.getClassOtherclass() == other);

    optOne = new ClassOptionalOne(null);
    Assert.assertTrue(optOne.getClassOtherclass() == null);
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(optOne));    
  }


  private boolean objectClassHasSettersAddersOrRemovers(Object obj)
  {
    boolean hasMethods = false;

    Class<? extends Object> clazz = obj.getClass();
    Method[] methods = clazz.getMethods();
    String setterNameRegex = "(set|add|remove)[A-Z]+[a-zA-Z]*";

    for (Method m : methods)
    {
      if (m.getName().matches(setterNameRegex))
      {
        hasMethods = true;
        break;
      }
    }
    return hasMethods;
  }

}

