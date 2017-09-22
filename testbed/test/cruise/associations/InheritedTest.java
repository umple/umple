package cruise.associations;

import org.junit.*;
import java.sql.*;

public class InheritedTest
{
 @Test 
  public void InheritedAssociationKey() {
	  SomeAssociationClass someclass = new SomeAssociationClass(1);
	  SomeAssociationClass someclass2 = new SomeAssociationClass(1);
	  
	  Assert.assertEquals(true, someclass.equals(someclass2));
  }
 
 @Test
 public void InheritedAssociationManyKeys() {
	 SomeAssociatedClassWithKey someAssociatedClass = new SomeAssociatedClassWithKey(1);
	 SomeAssociatedClassWithKey someAssociatedClass2 = new SomeAssociatedClassWithKey(2);
	 SomeAssociatedClassWithKey someAssociatedClass3 = new SomeAssociatedClassWithKey(3);
	 
	 SomeAssociationClassMany someclass = new SomeAssociationClassMany();
	 SomeAssociationClassMany someclass2 = new SomeAssociationClassMany();
	 
	 someclass.addSomeAssociatedClassWithKey(someAssociatedClass);
	 someclass.addSomeAssociatedClassWithKey(someAssociatedClass2);
	 someclass.addSomeAssociatedClassWithKey(someAssociatedClass3);
	 
	 someclass2.addSomeAssociatedClassWithKey(someAssociatedClass);
	 someclass2.addSomeAssociatedClassWithKey(someAssociatedClass2);
	 someclass2.addSomeAssociatedClassWithKey(someAssociatedClass3);
	 
	 Assert.assertEquals(true, someclass.equals(someclass2));
 }
}
