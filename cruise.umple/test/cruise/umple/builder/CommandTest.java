package cruise.umple.builder;

import org.junit.*;
import cruise.umple.util.*;

public class CommandTest 
{
  
  Command cmd;
  
  @Before
  public void setUp()
  {
    cmd = new Command(getClass().getClassLoader());
  }
  
  @Test
  public void constructor()
  {
    Assert.assertEquals(0,cmd.getMessages().length);
  }
  
  @Test
  public void exec_addsToHistory()
  {
    cmd.exec("new String");
    Assert.assertEquals(new String[] { "new String" },cmd.getHistory());
  }

  @Test
  public void exec_newObject()
  {
    cmd.exec("new java.lang.String");
    Assert.assertEquals("",(String)cmd.getCurrentObject());
  }

  @Test
  public void exec_newObject_message_ok()
  {
    cmd.exec("new java.lang.String");
    Assert.assertArrayEquals(new String[] { "Created java.lang.String" },cmd.popMessages());
  }

  @Test
  public void exec_newObject_message_notok()
  {
    cmd.exec("new Garble");
    Assert.assertArrayEquals(new String[] { "Unable to create Garble" },cmd.popMessages());
  }

  @Test
  public void exec_runMethod()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    TestClass obj = (TestClass)cmd.getCurrentObject();
    Assert.assertEquals(0,obj.i());
    cmd.exec("inc");
    cmd.exec("inc");
    Assert.assertEquals(2,obj.i());
  }

  @Test
  public void exec_runMethod_message_ok()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    cmd.popMessages();
    cmd.exec("inc");
    Assert.assertArrayEquals(new String[] { "Executed #inc" },cmd.popMessages());
  }

  @Test
  public void exec_runMethod_message_notok()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    cmd.popMessages();
    cmd.exec("garble");
    Assert.assertArrayEquals(new String[] { "Unable to execute #garble" },cmd.popMessages());
  }


  @Test
  public void exec_showMehtod()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    Assert.assertEquals(null,cmd.exec("inc"));
    Assert.assertEquals("1",cmd.exec("show i").toString());
  }

  @Test
  public void exec_showMehtod_messages()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    cmd.exec("inc");
    cmd.popMessages();
    cmd.exec("show i");
    Assert.assertEquals("i = 1",cmd.popMessages()[0]);
  }

  @Test
  public void exec_showMehtod_messages_unknown()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    cmd.exec("inc");
    cmd.popMessages();
    cmd.exec("show blah");
    Assert.assertEquals(new String[] { "Unable to execute #blah" },cmd.popMessages());
  }

  @Test
  public void exec_showMehtod_messages_null()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    cmd.exec("inc");
    cmd.popMessages();
    cmd.exec("show alwaysNull");
    Assert.assertEquals(new String[] { "alwaysNull = [NULL]" },cmd.popMessages());
  }

  @Test
  public void popMessages()
  {
    Assert.assertEquals(0,cmd.popMessages().length);
    cmd.addMessage("Hello");
    cmd.addMessage("Friend");
    
    String[] answer = cmd.popMessages();
    Assert.assertEquals(2,answer.length);
    Assert.assertEquals("Hello",answer[0]);
    Assert.assertEquals("Friend",answer[1]);
    Assert.assertEquals(0,cmd.popMessages().length);
  }

  @Test
  public void newObject_unknown()
  {
    Object obj = cmd.newObject("Garbligook");
    Assert.assertEquals(null,(String)obj);
  }
  
  @Test
  public void newObject()
  {
    Object obj = cmd.newObject("java.lang.String");
    Assert.assertEquals("",(String)obj);
  }

  @Test
  public void runMethod()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    TestClass obj = (TestClass)cmd.getCurrentObject();

    cmd.runMethod("inc");
    Assert.assertEquals(1,obj.i());

    cmd.runMethod("inc");
    Assert.assertEquals(2,obj.i());
  }

  @Test
  public void showResults()
  {
    cmd.exec("new cruise.umple.builder.TestClass");
    TestClass obj = (TestClass)cmd.getCurrentObject();

    cmd.runMethod("inc");
    Object ans = cmd.showResults("i");
    Assert.assertEquals("1",ans.toString());

    cmd.runMethod("inc");
    ans = cmd.showResults("i");
    Assert.assertEquals("2",ans.toString());
  }

  
  
}

