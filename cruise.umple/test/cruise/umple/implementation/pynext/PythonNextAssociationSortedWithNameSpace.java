/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation.pynext;

import org.junit.*;

import cruise.umple.implementation.AssociationSortedWithNameSpace;;

public class PythonNextAssociationSortedWithNameSpace extends AssociationSortedWithNameSpace
{
	  @Before
	  public void setUp()
	  {
	    super.setUp();
	    language = "PythonNext";
	    languagePath = "pynext";
	  }

	  @Test
	  public void AssociationShouldHaveSortMethod1() {
		super.AssociationShouldHaveSortMethod1();
	  }

	  @Test
	  public void AssociationShouldHaveSortMethod2() {
		super.AssociationShouldHaveSortMethod2();
	  }
}
