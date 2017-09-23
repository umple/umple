package cruise.associations;

import org.junit.*;
import java.sql.*;

public class InheritedTest
{
 @Test 
  public void InheritedAssociationKey() {
	  AssociationClass someclass = new AssociationClass(1);
	  AssociationClass someclass2 = new AssociationClass(1);
	  
	  Assert.assertEquals(true, someclass.equals(someclass2));
  }
 
 @Test
 public void InheritedAssociationManyKeys() {
	 AssociatedClassWithKey someAssociatedClass = new AssociatedClassWithKey(1);
	 AssociatedClassWithKey someAssociatedClass2 = new AssociatedClassWithKey(2);
	 AssociatedClassWithKey someAssociatedClass3 = new AssociatedClassWithKey(3);
	 AssociatedClassWithKey someAssociatedClass4 = new AssociatedClassWithKey(4);
	 
	 AssociationClassManyKeys someclass = new AssociationClassManyKeys();
	 AssociationClassManyKeys someclass2 = new AssociationClassManyKeys();
	 
	 someclass.addAssociatedClass(someAssociatedClass);
	 someclass.addAssociatedClass(someAssociatedClass2);
	 someclass.addAssociatedClass(someAssociatedClass3);
	 
	 someclass2.addAssociatedClass(someAssociatedClass);
	 someclass2.addAssociatedClass(someAssociatedClass2);
	 someclass2.addAssociatedClass(someAssociatedClass3);
	 
	 Assert.assertEquals(true, someclass.equals(someclass2));
	 
	 someclass.addAssociatedClass(someAssociatedClass4);
	 
	 Assert.assertEquals(false, someclass.equals(someclass2));
	 Assert.assertEquals(false, someclass2.equals(someclass));
 }
}
