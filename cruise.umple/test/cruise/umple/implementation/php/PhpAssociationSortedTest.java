/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation.php;

import org.junit.*;

import cruise.umple.implementation.AssociationSortedTest;

public class PhpAssociationSortedTest extends AssociationSortedTest
{
	  @Before
	  public void setUp()
	  {
	    super.setUp();
	    language = "Php";
	    languagePath = "php";
	  }
}
