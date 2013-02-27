package cruise.patterns.test;

import org.junit.*;

public class CodeInjectionTest
{

  @Test
  public void BeforeAfterSet_Attribute()
  {
    WidgetD widgetD = new WidgetD("blah");
    
    Assert.assertEquals(0, widgetD.numberOfLogs());
    widgetD.setId("moreBlah");
    Assert.assertEquals(2, widgetD.numberOfLogs());
    Assert.assertEquals("before setId:blah",widgetD.getLog(0));
    Assert.assertEquals("after setId:moreBlah",widgetD.getLog(1));
  }
  
  @Test
  public void BeforeAfterGet_Attribute()
  {
    WidgetD widget = new WidgetD("blah");
    
    Assert.assertEquals(0, widget.numberOfLogs());
    widget.getId();
    Assert.assertEquals(2, widget.numberOfLogs());
    Assert.assertEquals("before getId",widget.getLog(0));
    Assert.assertEquals("after getId",widget.getLog(1));
  }

  @Test
  public void BeforeAfterAdd_Attribute()
  {
    WidgetE widget = new WidgetE();
    
    Assert.assertEquals(0, widget.numberOfLogs());
    widget.addId("anId");
    Assert.assertEquals(2, widget.numberOfLogs());
    Assert.assertEquals("before addId:0",widget.getLog(0));
    Assert.assertEquals("after addId:1",widget.getLog(1));
  }  

  @Test
  public void BeforeAfterRemove_Attribute()
  {
    WidgetE widget = new WidgetE();
    
    Assert.assertEquals(0, widget.numberOfLogs());
    widget.addId("anId");
    widget.removeId("anId");
    Assert.assertEquals(4, widget.numberOfLogs());
    Assert.assertEquals("before removeId:1",widget.getLog(2));
    Assert.assertEquals("after removeId:0",widget.getLog(3));
  } 

  @Test
  public void BeforeAfterIndexOf_Attribute()
  {
    WidgetE widget = new WidgetE();
    
    Assert.assertEquals(0, widget.numberOfLogs());
    widget.indexOfId("abc");
    Assert.assertEquals(2, widget.numberOfLogs());
    Assert.assertEquals("before indexOfId",widget.getLog(0));
    Assert.assertEquals("after indexOfId",widget.getLog(1));
  } 

  @Test
  public void BeforeAfterGetAtIndex_Attribute()
  {
    WidgetE widget = new WidgetE();
    
    Assert.assertEquals(0, widget.numberOfLogs());
    widget.addId("abc");
    widget.getId(0);
    Assert.assertEquals(4, widget.numberOfLogs());
    Assert.assertEquals("before getId",widget.getLog(2));
    Assert.assertEquals("after getId",widget.getLog(3));
  } 

  @Test
  public void BeforeAfterGetIds_Attribute()
  {
    WidgetE widget = new WidgetE();
    
    Assert.assertEquals(0, widget.numberOfLogs());
    widget.getIds();
    Assert.assertEquals(2, widget.numberOfLogs());
    Assert.assertEquals("before getIds",widget.getLog(0));
    Assert.assertEquals("after getIds",widget.getLog(1));
  }

  @Test
  public void BeforeAfterNumberOfIds_Attribute()
  {
    WidgetF widget = new WidgetF();
    
    Assert.assertEquals(0, widget.numberOfLogs());
    widget.numberOfIds();
    Assert.assertEquals(2, widget.numberOfLogs());
    Assert.assertEquals("before numberOfIds",widget.getLog(0));
    Assert.assertEquals("after numberOfIds",widget.getLog(1));
  }
    
  @Test
  public void MultiLanguagedCodeBlocks()
  {
  	LanguageSpecificCodeBlock cb = new LanguageSpecificCodeBlock("Hello");
  	cb.setName("World");
    Assert.assertEquals("My lang is java",cb.getName());
    Assert.assertTrue(cb.isJava());
    
    cb.applySpecificAction();
    Assert.assertEquals("action=java",cb.getName());
    
    Assert.assertEquals("Java",cb.getLanguageImplementedIn());
  }  
}
