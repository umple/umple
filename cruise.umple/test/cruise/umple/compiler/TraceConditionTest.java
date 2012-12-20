/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class TraceConditionTest
{
  
  TraceCondition tc;
  ConditionRhs rhs;
  
  @Before
  public void setUp()
  {
	  rhs = new ConditionRhs();
	  tc = new TraceCondition(rhs);
  }

  @Test
  public void conditionRhs()
  {
	  Assert.assertEquals(null,rhs.getRhs());
	  rhs.setRhs("id");
	  Assert.assertEquals("id",rhs.getRhs());
	  rhs.setComparisonOperator("==");
	  Assert.assertEquals("==",rhs.getComparisonOperator());
  }
  
  @Test
  public void conditionType()
  {
	  Assert.assertEquals(null,tc.getConditionType());
	  tc.setConditionType("where");
	  Assert.assertEquals("where",tc.getConditionType());
	  tc.setConditionType("until");
	  Assert.assertEquals("until",tc.getConditionType());
	  tc.setConditionType("after");
	  Assert.assertEquals("after",tc.getConditionType());
  }
  
  @Test
  public void conditionLhs()
  {
	  Assert.assertEquals(null,tc.getLhs());
	  tc.setLhs("name");
	  Assert.assertEquals("name",tc.getLhs());
  }

}
