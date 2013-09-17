package cruise.attributes.test;

import org.junit.*;
import java.sql.*;


public class TypeInferenceTest
{
	TypeInference x = new TypeInference(null,0,null,false,0);
	
	@Test
	public void inferenceCheck()
	{
		Assert.assertTrue(x.getA() == 2);
		Assert.assertTrue(x.getB() == 3.0);
		Assert.assertTrue(x.getC() == false);
		Assert.assertTrue(x.getD().equals("hello world!"));
		Assert.assertTrue(x.getE() == null);
		Assert.assertTrue(x.getF() == 0);
        Assert.assertTrue(x.getG() == 42);
        Assert.assertTrue(x.getH().equals("hello"));
        Assert.assertTrue(x.getI() == null);
		Assert.assertTrue(x.getJ() == -1);
        Assert.assertTrue(x.getK() == -3.33333);
        Assert.assertTrue(x.getL().equals("-6"));
        Assert.assertTrue(x.getM().equals("-3.1415926"));
		Assert.assertTrue(x.getN().equals("99"));
        Assert.assertTrue(x.getO() == false);
        Assert.assertTrue(x.getP() == false);
        Assert.assertTrue(x.getQ() == 0);
		Assert.assertTrue(x.getR() == 3);
	}

	MoreTypeInference y = new MoreTypeInference(null,null);
	
	@Test
	public void moreInferenceCheck()
	{
	  Assert.assertTrue(y.getA() instanceof Time);
	  Assert.assertTrue(y.getB() == null);
	  Assert.assertTrue(y.getC() instanceof String);
	  Assert.assertTrue(y.getD() instanceof Time);
	  Assert.assertTrue(y.getE() instanceof String);
	  Assert.assertTrue(y.getF() instanceof String);
	  Assert.assertTrue(y.getG() instanceof Date);
	  Assert.assertTrue(y.getH() == null);
	  Assert.assertTrue(y.getI() instanceof String);
	  Assert.assertTrue(y.getJ() instanceof String);
 	  Assert.assertTrue(y.getK() instanceof Date);
	  Assert.assertTrue(y.getL() instanceof Object);
	}
}
