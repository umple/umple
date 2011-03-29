package cruise.umple.util;

import org.junit.*;

import cruise.umple.util.ActionResponse;
import cruise.umple.util.Language;

public class ActionResponseTest 
{
  
  @Before
  @After
  public void setUp()
  {
    Language.reset();
  }
  
  @Test
  public void IsValid()
  {
    ActionResponse response = new ActionResponse();
    Assert.assertEquals(true,response.isValid());
    
    response.addError(new ErrorItem("1"));
    Assert.assertEquals(false,response.isValid());
  }

  @Test
  public void IsError()
  {
    ActionResponse response = new ActionResponse();
    Assert.assertEquals(false,response.isError("1"));
    
    response.addError(new ErrorItem("1"));
    Assert.assertEquals(true,response.isError("1"));
  }

  @Test
  public void GetMessageSuccess()
  {
    ActionResponse response = new ActionResponse();
    Assert.assertEquals("Success!", response.getMessage());
  }
  
  @Test
  public void SetSuccessMessage()
  {
    ActionResponse response = new ActionResponse();
    Language.getInstance().add("gj", "Great Job");
    response.setSuccessMessage("gj");
    Assert.assertEquals("Great Job", response.getMessage());
  }

  @Test
  public void GetMessageTrackData()
  {
    Language.getInstance().add("error_x", "translate @1");
    
    ActionResponse response = new ActionResponse();
    response.addError(new ErrorItem("error_x",new String[]{"biatch"}));
    Assert.assertEquals("translate biatch", response.getMessage());
  }

  
  @Test
  public void OneError()
  {
    ActionResponse response = new ActionResponse();
    response.addError(new ErrorItem("error_1"));
    Assert.assertEquals("error_1", response.getMessage());
  }

  @Test
  public void MultipleErrors()
  {
    ActionResponse response = new ActionResponse();
    response.addError(new ErrorItem("error_1"));
    response.addError(new ErrorItem("error_2"));
    Assert.assertEquals("error_1,\nerror_2", response.getMessage());
  }
  
  @Test
  public void TranslateErrorIds()
  {
    Language.getInstance().add("error_1", "Error 1 occurred");
    
    ActionResponse response = new ActionResponse();
    response.addError(new ErrorItem("error_1"));
    Assert.assertEquals("Error 1 occurred", response.getMessage());
  }
  
  @Test
  public void Merge()
  {
    ActionResponse response = new ActionResponse();
    response.addError(new ErrorItem("error_1"));

    ActionResponse other = new ActionResponse();
    
    response.merge(other);
    Assert.assertEquals(true,response.isError("error_1"));
    
    other.addError(new ErrorItem("error_1"));
    response.merge(other);
    Assert.assertEquals(true,response.isError("error_1"));

    other.addError(new ErrorItem("error_2"));
    response.merge(other);
    Assert.assertEquals(true,response.isError("error_1"));
    Assert.assertEquals(true,response.isError("error_2"));

    
  }

  @Test
  public void MergeErrorData()
  {
    ActionResponse response = new ActionResponse();
    response.addError(new ErrorItem("error_1",new String[]{"a"}));

    ActionResponse other = new ActionResponse();
    
    other.merge(response);
    Assert.assertEquals(true,other.isError("error_1"));
    Assert.assertEquals(true,other.isError("error_1",new String[]{"a"}));
  }

  
  @Test
  public void isErrorWithData()
  {
    ActionResponse response = new ActionResponse();
    response.addError(new ErrorItem("error_1",new String[] {"a","b","c"}));
    
    Assert.assertEquals(true,response.isError("error_1"));
    Assert.assertEquals(true,response.isError("error_1",new String[] {"a","b","c"}));
    Assert.assertEquals(false,response.isError("error_1",new String[] {"d","b","c"}));
    Assert.assertEquals(false,response.isError("error_1",new String[] {"d"}));
    Assert.assertEquals(false,response.isError("error_1",new String[] {"a","b","c","f"}));
    
  }
  
}
