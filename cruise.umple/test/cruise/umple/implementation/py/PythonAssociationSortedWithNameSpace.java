/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation.py;

import org.junit.*;

import cruise.umple.implementation.AssociationSortedWithNameSpace;;

public class PythonAssociationSortedWithNameSpace extends AssociationSortedWithNameSpace
{
	  @Before
	  public void setUp()
	  {
	    super.setUp();
	    language = "Python";
	    languagePath = "py";
	  }

	  @Test @Ignore
	  public void AssociationShouldHaveSortMethod1() {
		super.AssociationShouldHaveSortMethod1();
	  }

	  @Test @Ignore
	  public void AssociationShouldHaveSortMethod2() {
		super.AssociationShouldHaveSortMethod2();
	  }
}
