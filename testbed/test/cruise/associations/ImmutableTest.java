package cruise.associations;

import org.junit.*;
import java.lang.reflect.*;

public class ImmutableTest
{
  @Test
  public void mutableClassHasSettersRemoversAndAddMethods()
  {
    MentorA mentor = new MentorA();
    Assert.assertTrue(objectClassHasSettersAddersOrRemovers(mentor));
  }

  @Test
  public void unidirectionalManyAssociation()
  {
    Otherclass other1 = new Otherclass("otherClass");
    Otherclass other2 = new Otherclass("otherClass");

    ClassManyAssociation many = new ClassManyAssociation();
    Assert.assertFalse(many.hasOtherclasses());
    many = new ClassManyAssociation(other1);
    Assert.assertTrue(many.hasOtherclasses());
    many.delete();
    Assert.assertTrue(many.hasOtherclasses());

    many = new ClassManyAssociation(other1, other2);
    Assert.assertTrue(many.hasOtherclasses());
    Assert.assertTrue(many.indexOfOtherclass(other1) >= 0);
    Assert.assertTrue(many.indexOfOtherclass(other2) >= 0);
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(many));
  }

  @Test
  public void unidirectionalMToNAssociation()
  {
    Otherclass other1 = new Otherclass("other");
    Otherclass other2 = new Otherclass("other");
    Otherclass other3 = new Otherclass("other");
    Otherclass other4 = new Otherclass("other");

    ClassMToNAssociation mToN;
    try {
      mToN = new ClassMToNAssociation();
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    try {
      mToN = new ClassMToNAssociation(other1);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    mToN = new ClassMToNAssociation(other1, other2);
    Assert.assertTrue(mToN.hasOtherclasses());
    Assert.assertTrue(mToN.indexOfOtherclass(other1) >= 0);
    Assert.assertTrue(mToN.indexOfOtherclass(other2) >= 0);
    mToN.delete();
    Assert.assertTrue(mToN.hasOtherclasses());

    mToN = new ClassMToNAssociation(other1, other2, other3);
    Assert.assertTrue(mToN.hasOtherclasses());

    try {
      mToN = new ClassMToNAssociation(other1, other2, other3, other4);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(mToN));
  }

  @Test
  public void unidirectionalMStarAssociation()
  {
    Otherclass other1 = new Otherclass("other");
    Otherclass other2 = new Otherclass("other");
    Otherclass other3 = new Otherclass("other");

    ClassMStarAssociation mStar;
    try {
      mStar = new ClassMStarAssociation();
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    try {
      mStar = new ClassMStarAssociation(other1);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    mStar = new ClassMStarAssociation(other1, other2);
    Assert.assertTrue(mStar.hasOtherclasses());
    Assert.assertTrue(mStar.indexOfOtherclass(other1) >= 0);
    Assert.assertTrue(mStar.indexOfOtherclass(other2) >= 0);
    mStar.delete();
    Assert.assertTrue(mStar.hasOtherclasses());

    mStar = new ClassMStarAssociation(other1, other2, other3);
    Assert.assertTrue(mStar.hasOtherclasses());
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(mStar));
  }

  @Test
  public void unidirectionalNAssociation()
  {
    Otherclass other1 = new Otherclass("other");
    Otherclass other2 = new Otherclass("other");
    Otherclass other3 = new Otherclass("other");

    ClassNAssociation n;
    try {
      n = new ClassNAssociation();
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    try {
      n = new ClassNAssociation(other1);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    n = new ClassNAssociation(other1, other2);
    Assert.assertTrue(n.hasOtherclasses());
    Assert.assertTrue(n.indexOfOtherclass(other1) >= 0);
    Assert.assertTrue(n.indexOfOtherclass(other2) >= 0);
    n.delete();
    Assert.assertTrue(n.hasOtherclasses());

    try {
      n = new ClassNAssociation(other1, other2, other3);
    } catch (RuntimeException ex) {}
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(n));
  }

  @Test
  public void unidirectionalOneAssociation()
  {
    Otherclass other = new Otherclass("otherClass");

    ClassOneAssociation one = new ClassOneAssociation(other);
    Assert.assertTrue(one.getOtherclass() == other);
    one.delete();
    Assert.assertTrue(one.getOtherclass() == other);

    try {
      one = new ClassOneAssociation(null);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}
    
    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(one));  
  }

  @Test
  public void unidirectionalOptionalNAssociation()
  {
    Otherclass other1 = new Otherclass("other");
    Otherclass other2 = new Otherclass("other");
    Otherclass other3 = new Otherclass("other");

    ClassOptionalNAssociation optN = new ClassOptionalNAssociation();
    Assert.assertFalse(optN.hasOtherclasses());
    
    optN = new ClassOptionalNAssociation(other1);
    Assert.assertTrue(optN.hasOtherclasses());
    Assert.assertTrue(optN.indexOfOtherclass(other1) >= 0);

    optN = new ClassOptionalNAssociation(other1, other2);
    Assert.assertTrue(optN.hasOtherclasses());
    Assert.assertTrue(optN.indexOfOtherclass(other1) >= 0);
    Assert.assertTrue(optN.indexOfOtherclass(other2) >= 0);
    optN.delete();
    Assert.assertTrue(optN.hasOtherclasses());

    try {
      optN = new ClassOptionalNAssociation(other1, other2, other3);
      Assert.fail("Constructor should have thrown RuntimeException");
    } catch (RuntimeException ex) {}

    Assert.assertFalse(objectClassHasSettersAddersOrRemovers(optN));   
  }

  @Test
  public void unidirectionalOptionalOneAssociation()
  {
    Otherclass other = new Otherclass("otherClass");

    ClassOptionalOneAssociation optOne = new ClassOptionalOneAssociation(other);
    Assert.assertTrue(optOne.getOtherclass() == other);
    optOne.delete();
    Assert.assertTrue(optOne.getOtherclass() == other);

    optOne = new ClassOptionalOneAssociation(null);
    Assert.assertTrue(optOne.getOtherclass() == null);
    
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
