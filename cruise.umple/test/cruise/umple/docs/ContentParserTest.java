/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.docs;

import java.io.File;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class ContentParserTest
{

  ContentParser parser;
  String pathToInput;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/docs");
  }

  @Test
  public void oneExample()
  {
    assertParse("001_oneExample.txt", "[content][title:myTitle][group:Misc][description:This is\nmy content][syntax:the syntax looks like this][example:here is an example to consider][filename:001_oneExample.txt]");
    
    Assert.assertEquals(1,parser.numberOfGroups());
    Group misc = parser.getGroup(0);
    Assert.assertEquals("Misc",misc.getName());
    
    Assert.assertEquals(1,misc.numberOfContents());
    Content content = misc.getContent(0);
    Assert.assertEquals("myTitle",content.getTitle());
    Assert.assertEquals("This is\nmy content",content.getDescription());
    Assert.assertEquals("the syntax looks like this",content.getSyntax());
    
    Assert.assertEquals(1, content.numberOfExamples());
    Assert.assertEquals("here is an example to consider",content.getExample(0).getText());
  }
  
  @Test
  public void multipleExamples()
  {
    assertParse("001_multiExample.txt", "[content][title:myTitle2][group:Misc][description:This is\nmy content2][syntax:the syntax looks like this2][example:one example to consider][example:a second example to consider][filename:001_multiExample.txt]");

    Assert.assertEquals(1,parser.numberOfGroups());
    Group misc = parser.getGroup(0);
    Assert.assertEquals("Misc",misc.getName());

    Assert.assertEquals(1,misc.numberOfContents());
    Content content = misc.getContent(0);
    Assert.assertEquals("myTitle2",content.getTitle());
    Assert.assertEquals("This is\nmy content2",content.getDescription());
    Assert.assertEquals("the syntax looks like this2",content.getSyntax());
    
    Assert.assertEquals(2, content.numberOfExamples());
    Assert.assertEquals("one example to consider",content.getExample(0).getText());
    Assert.assertEquals("a second example to consider",content.getExample(1).getText());
  }  

  @Test
  public void explicitGroup()
  {
    assertParse("002_explicitGroup.txt", "[content][title:aTitle][group:aGroupName][description:the description][syntax:the syntax][example:the example][filename:002_explicitGroup.txt]");
    
    Assert.assertEquals(1,parser.numberOfGroups());
    Group misc = parser.getGroup(0);
    Assert.assertEquals("aGroupName",misc.getName());
    Assert.assertEquals(1,misc.numberOfContents());

  }

  @Test
  public void noReferences()
  {
    assertParse("006_noref.txt", "[content][title:MyTitle][group:MyGroup][noreferences:noreferences][description:This is a description][filename:006_noref.txt]");
    Content content = parser.getGroup(0).getContent(0);
    Assert.assertEquals(false,content.getShouldIncludeReferences());
  }

  @Test
  public void defaultHasReferences()
  {
    assertParse("002_explicitGroup.txt", "[content][title:aTitle][group:aGroupName][description:the description][syntax:the syntax][example:the example][filename:002_explicitGroup.txt]");
    Content content = parser.getGroup(0).getContent(0);
    Assert.assertEquals(true,content.getShouldIncludeReferences());
  }
  
  @Test
  public void groupOrder()
  {
    assertParse("003_groupOrder.txt","[groupOrder][group:Group1][group:Group2][group:Group3][group:Group4]","groupOrder");
    
    Assert.assertEquals(4,parser.numberOfGroups());
    Assert.assertEquals("Group1",parser.getGroup(0).getName());
    Assert.assertEquals("Group2",parser.getGroup(1).getName());
    Assert.assertEquals("Group3",parser.getGroup(2).getName());
    Assert.assertEquals("Group4",parser.getGroup(3).getName());
  }

  private void assertParse(String filename, String expectedOutput)
  {
    assertParse(filename, expectedOutput, "content");
  }

  private void assertParse(String filename, String expectedOutput, String root)
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, filename));
    parser = new ContentParser("content");
    boolean answer = parser.parse(root,input).getWasSuccess();
    
    if (answer == false)
    {
      System.out.println("failed at:" + parser.getParseResult().getPosition());
    }
    
    Assert.assertEquals(true, answer);
    parser.analyze();
    Assert.assertEquals(expectedOutput, parser.toString());  
  }
  
}
