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

	@Test @Ignore
	public void BasicPostcondition1(){
		super.BasicPostcondition1();
	}

	@Test @Ignore
	public void BasicPrecondition1(){
		super.BasicPrecondition1();
	}

	@Test @Ignore
	public void MultipleConstraints(){
		super.MultipleConstraints();
	}

	@Test @Ignore
	public void BasicConstraint1(){
		super.BasicConstraint1();
	}

	@Test @Ignore
	public void BasicConstraint3(){
		super.BasicConstraint3();
	}

	@Test @Ignore
	public void BasicConstraint5(){
		super.BasicConstraint5();
	}

	@Test @Ignore
	public void BasicConstraint6(){
		super.BasicConstraint6();
	}

	@Test @Ignore
	public void BasicConstraint7(){
		super.BasicConstraint7();
	}

	@Test @Ignore
	public void BasicConstraint8(){
		super.BasicConstraint8();
	}

	@Test @Ignore
	public void DateConstraint1(){
		super.DateConstraint1();
	}

}
