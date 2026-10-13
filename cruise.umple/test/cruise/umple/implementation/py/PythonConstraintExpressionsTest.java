/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

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

  @Override
  @Test
  @Ignore("the shared model has Java in untagged method bodies or extra code, which Python emits as native code; the corpus gate classifies it as generation-only")
  public void BasicPrecondition1()
  {
  }
}
