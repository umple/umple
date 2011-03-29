package cruise.umple.util;

import junit.framework.Assert;

import org.junit.*;

import cruise.umple.util.Language;

public class LanguageTest {

  Language language;
  
  @Before
  public void Setup()
  {
    Language.reset();
    language = Language.getInstance();
  }
  
  
  @Test
  public void DefaultStrict()
  {
    Assert.assertEquals("abc",language.lookup("abc"));
    Assert.assertEquals("UNKNOWN: abc",language.lookup("abc",true));
  }

  @Test
  public void AddData()
  {
    language.add("what_is", "What is @1?  What is @2?");
    String answer = language.lookup("what_is",new String[]{"abc","def"});
    Assert.assertEquals("What is abc?  What is def?", answer);
  }

  @Test
  public void lookUpWithData()
  {
    language.add("what_is", "What is @1?  What is @2?");
    String answer = language.lookup("what_is",false,new String[]{"abc","def"});
    Assert.assertEquals("What is abc?  What is def?", answer);
  }

  
  @Test
  public void DefaultNotStrict()
  {
    Assert.assertEquals("abc",language.lookup("abc",false));
  }

  
  @Test
  public void UserEnglish()
  {
    language.add("application_name","CodeSnippet");
    
    Assert.assertEquals("CodeSnippet",language.lookup("application_name"));
    Assert.assertEquals("CodeSnippet",language.lookup("application_name",true));
    Assert.assertEquals("CodeSnippet",language.lookup("application_name",false));
    
  }
  
}
