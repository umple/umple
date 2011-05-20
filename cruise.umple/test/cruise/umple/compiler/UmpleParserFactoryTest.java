package cruise.umple.compiler;

import org.junit.*;

public class UmpleParserFactoryTest
{
  
  @Test
  public void returnUmpleInternalParser()
  {
    UmpleParser p = UmpleParserFactory.create("cruise.umple.compiler.UmpleInternalParser");
    Assert.assertEquals(UmpleInternalParser.class,p.getClass());
    
    p = UmpleParserFactory.create("UmpleInternalParser");
    Assert.assertEquals(UmpleInternalParser.class,p.getClass());
  }
  
  @Test
  public void returnUmpleXtextParser()
  {
    UmpleParser p = UmpleParserFactory.create("cruise.umple.compiler.UmpleXtextParser");
    Assert.assertEquals(UmpleXtextParser.class,p.getClass());
    
    p = UmpleParserFactory.create("UmpleXtextParser");
    Assert.assertEquals(UmpleXtextParser.class,p.getClass());    
  }
  

  @Test
  public void returnNullIfInvalidName()
  {
    Assert.assertEquals(null,UmpleParserFactory.create("blah"));
    Assert.assertEquals(null,UmpleParserFactory.create(null));
  }
  
  @Test
  public void shouldLeaveInternalModelAlone()
  {
    UmpleParser p = UmpleParserFactory.create("cruise.umple.compiler.UmpleInternalParser",null);
    Assert.assertNotNull(p.getModel());
  }
  
  @Test
  public void setModel()
  {
    UmpleModel model = new UmpleModel(null);
    UmpleParser p = UmpleParserFactory.create("cruise.umple.compiler.UmpleInternalParser",model);
    Assert.assertEquals(UmpleInternalParser.class,p.getClass());
    Assert.assertSame(model, p.getModel());
  }

  @Test(expected = AssertionError.class)
  public void assertFailIfRequested()
  {
    UmpleModel model = new UmpleModel(null);
    UmpleParserFactory.create("blah",model,true);
  }

  @Test
  public void doNotAssertFailIfOkayEvenIfRequested()
  {
    UmpleModel model = new UmpleModel(null);
    UmpleParser p = UmpleParserFactory.create("cruise.umple.compiler.UmpleInternalParser",model,true);
    Assert.assertEquals(UmpleInternalParser.class,p.getClass());
    Assert.assertSame(model, p.getModel());
  }

  
}