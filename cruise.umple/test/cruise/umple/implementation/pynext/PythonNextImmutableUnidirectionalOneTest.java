/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation.pynext;

import org.junit.*;

import cruise.umple.implementation.ImmutableUnidirectionalOneTest;

public class PythonNextImmutableUnidirectionalOneTest extends ImmutableUnidirectionalOneTest
{
	  @Before
	  public void setUp()
	  {
	    super.setUp();
	    language = "PythonNext";
	    languagePath = "pynext";
	  }
}