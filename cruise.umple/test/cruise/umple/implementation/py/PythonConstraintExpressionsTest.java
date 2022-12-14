/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/
package cruise.umple.implementation.py;

import org.junit.*;

import cruise.umple.implementation.ConstraintExpressionsTest;

public class PythonConstraintExpressionsTest extends ConstraintExpressionsTest{
	
	@Before
	public void setUp()
	{
	  super.setUp();
	  language = "Python";
	  languagePath = "py";
	}
}
