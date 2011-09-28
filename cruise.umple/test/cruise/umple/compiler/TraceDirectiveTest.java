package cruise.umple.compiler;

import org.junit.*;

public class TraceDirectiveTest
{
  
  TraceDirective traceDirective;
  
  @Before
  public void setUp()
  {
	  traceDirective = new TraceDirective();
  }
  
  @Test
  public void forClause()
  {
	  Assert.assertEquals(0,traceDirective.getForClause());
	  traceDirective.setForClause(100);
	  Assert.assertEquals(100,traceDirective.getForClause());
  }
  
  @Test
  public void periodClause()
  {
	  Assert.assertEquals(null,traceDirective.getPeriodClause());
	  traceDirective.setPeriodClause("10ms");
	  Assert.assertEquals("10ms",traceDirective.getPeriodClause());
	  traceDirective.setPeriodClause("50s");
	  Assert.assertEquals("50s",traceDirective.getPeriodClause());
  }
  
  @Test
  public void duringClause()
  {
	  Assert.assertEquals(null,traceDirective.getDuringClause());
	  traceDirective.setDuringClause("300s");
	  Assert.assertEquals("300s",traceDirective.getDuringClause());
	  traceDirective.setDuringClause("75ms");
	  Assert.assertEquals("75ms",traceDirective.getDuringClause());
  }
  
  @Test
  public void executeClause()
  {
	  Assert.assertEquals(null,traceDirective.getExecuteClause());
	  traceDirective.setExecuteClause("\"something\"");
	  Assert.assertEquals("\"something\"",traceDirective.getExecuteClause());
	  traceDirective.setExecuteClause("record(\"x\")");
	  Assert.assertEquals("record(\"x\")",traceDirective.getExecuteClause());
  }

  @Test
  public void attributes()
  {
    Assert.assertEquals(false,traceDirective.hasAttributes());
    Assert.assertEquals(0,traceDirective.numberOfAttributes());
    Attribute a = new Attribute("name","String",null,null,false);
    traceDirective.addAttribute(a);
    Assert.assertEquals(a,traceDirective.getAttribute(0));
    Attribute b = new Attribute("id","Integer",null,null,false);
    traceDirective.addAttribute(b);
    Assert.assertEquals(b,traceDirective.getAttribute(1));
  }
  
  @Test
  public void assocationVariable()
  {
	Assert.assertEquals(null,traceDirective.getAssociationVariable());
	AssociationVariable a = new AssociationVariable("aName","MyType","symmetricreflexive","",AssociationTest.createMultiplicity(0,1),true);
	traceDirective.setAssociationVariable(a);
    Assert.assertEquals(a, traceDirective.getAssociationVariable());
  }

  @Test
  public void umpleClass()
  {
    Assert.assertEquals(null,traceDirective.getUmpleClass());
    UmpleClass clazz = new UmpleClass("X");
    traceDirective.setUmpleClass(clazz);
    Assert.assertEquals(clazz,traceDirective.getUmpleClass());
  }

}
