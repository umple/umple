/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.docs;

import java.io.File;

import org.junit.*;

import cruise.umple.util.AssertHelper;
import cruise.umple.util.SampleFileWriter;
import cruise.umple.docs.Documenter;

public class DocumenterTest
{

  ContentParser parser;
  Documenter documenter;
  String pathToInput;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/docs");
    File f = new File("source");
    f.mkdirs();
    
    f = new File("target");
    f.mkdirs();
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("example");
    SampleFileWriter.destroy("source");
    SampleFileWriter.destroy("target");
    parser = null;
    documenter = null;
  }

/*
DISABLED BECAUSE OF MAJOR CHANGES WHEN GENERATING USER MANUAL 
  @Test
  public void NoSyntax()
  {
    assertParse("003_noSyntax.txt");
    String actual = documenter.toHtml("myTitle");
    
    File expected = new File(pathToInput,"003_noSyntax.html");
    // System.out.println(actual);
    SampleFileWriter.assertFileContent(expected,actual);
  }

  
  @Test
  public void UmpleGrammar()
  {
    assertParse("002_umpleGrammar.txt");
    String actual = documenter.toHtml("myGrammar");
    
    File expected = new File(pathToInput,"002_umpleGrammar.html");
    // System.out.println(actual);
    SampleFileWriter.assertFileContent(expected,actual);
  }
*/

/*
DISABLED BECAUSE OF MAJOR CHANGES WHEN GENERATING USER MANUAL

  @Test
  public void htmlBodyOne()
  {
    assertParse("001_oneExample.txt");
    String actual = documenter.toHtml("myTitle");
    
    File expected = new File(pathToInput,"001_oneExample.html");
    // System.out.println(actual);
    SampleFileWriter.assertFileContent(expected,actual);
  }
*/
/*
DISABLED BECAUSE OF MAJOR CHANGES WHEN GENERATING USER MANUAL

  @Test
  public void htmlMultipleExamples()
  {
    assertParse("001_multiExample.txt");
    String actual = documenter.toHtml("myTitle2");
    
    File expected = new File(pathToInput,"001_multiExample.html");
    // System.out.println(actual);
    SampleFileWriter.assertFileContent(expected,actual);
  }
*/
  
  @Test
  public void publishCreatesDirectories()
  {
    documenter = new Documenter("a","b");
    documenter.setParser(new ContentParser("content"));
    Assert.assertEquals(true,documenter.publish("example/two/three"));
    Assert.assertEquals(true,(new File("example")).exists());
    Assert.assertEquals(true,(new File("example/two")).exists());
    Assert.assertEquals(true,(new File("example/two/three")).exists());
  }
  
  @Test
  public void publishCreatesFiles()
  {
    assertParse("001_oneExample.txt", false);
    assertParse("001_spaceInName.txt", true);
    Assert.assertEquals(true,documenter.publish("example"));
    
    Assert.assertEquals(true,(new File("example/myTitle.html")).exists());
    Assert.assertEquals(true,(new File("example/myTitle3.html")).exists());
    
    Assert.assertEquals(2,documenter.numberOfMessages());
    AssertHelper.assertPathEquals("Created: example\\myTitle.html",documenter.getMessage(0));
    AssertHelper.assertPathEquals("Created: example\\myTitle3.html",documenter.getMessage(1));
    
  }
  
  @Test
  public void findMe()
  {
    String s = "a\\b";
    String newS = s.replace("\\", "/");
    Assert.assertEquals("a/b", newS);
        
  }
  
  @Test
  public void generate_invalidInput()
  {
    Documenter d = new Documenter("blah","target");
    Assert.assertEquals(false,d.generate());
    Assert.assertEquals("Unknown directory: blah", d.getMessage(0));
  }
  
  @Test
  public void generate_lookForGroupsFile()
  {
    Documenter d = new Documenter("source","target");
    SampleFileWriter.createFile("source/order.group", "General;\nMisc;");
    Assert.assertEquals(true,d.generate());
    Assert.assertEquals("Created Groups: [General] [Misc]",d.getMessage(0));
  }  

/*
DISABLED BECAUSE OF MAJOR CHANGES WHEN GENERATING USER MANUAL
  @Test
  public void generate_onlyReadDotTxtFiles()
  {
    Documenter d = new Documenter("source","target");
    SampleFileWriter.createFile("source/order.group", "General;\nMisc;\nMore Stuff;\n");
    SampleFileWriter.createFile("source/blah.txt", "myTitle\n General\n @@description adesc @@syntax async");
    SampleFileWriter.createFile("source/ignore.me", "Should not be read");
    Assert.assertEquals(true,d.generate());
    Assert.assertEquals("Created Groups: [General] [Misc] [More Stuff]",d.getMessage(0));
    AssertHelper.assertPathEquals("Created: target\\myTitle.html",d.getMessage(1));
  }
*/  
/*
DISABLED BECAUSE OF MAJOR CHANGES WHEN GENERATING USER MANUAL

  @Test
  public void generate_replaceReferencesWithAnchors()
  {
    Documenter d = new Documenter("source","target");
    SampleFileWriter.createFile("source/one.txt", "myOne\n General\n @@description myTwo reference okay @@syntax blah myTwo moreBlab");
    SampleFileWriter.createFile("source/two.txt", "myTwo\n General\n @@description myOne references myTwo @@syntax myOne blah myTwo");
    Assert.assertEquals(true,d.generate());

    File expected = new File(pathToInput,"004_myOne.html");
    String actual = SampleFileWriter.readContent(new File("target","myOne.html"));
    // System.out.println(actual);
    SampleFileWriter.assertFileContent(expected,actual);


    File expected2 = new File(pathToInput,"004_myTwo.html");
    String actual2 = SampleFileWriter.readContent(new File("target","myTwo.html"));
    // System.out.println(actual2);
    SampleFileWriter.assertFileContent(expected2,actual2);
  }
*/
/*
DISABLED BECAUSE OF MAJOR CHANGES WHEN GENERATING USER MANUAL

  @Test
  public void generate_doNotReplaceReferencesIfRequested()
  {
    Documenter d = new Documenter("source","target");
    SampleFileWriter.createFile("source/one.txt", "myOne\n General\n noreferences @@description myTwo reference okay @@syntax blah myTwo moreBlab");
    SampleFileWriter.createFile("source/two.txt", "myTwo\n General\n @@description myOne references myTwo @@syntax myOne blah myTwo");
    Assert.assertEquals(true,d.generate());

    File expected = new File(pathToInput,"004_myOneNoReferences.html");
    String actual = SampleFileWriter.readContent(new File("target","myOne.html"));
    System.out.println(actual);
   SampleFileWriter.assertFileContent(expected,actual);

    File expected2 = new File(pathToInput,"004_myTwo.html");
    String actual2 = SampleFileWriter.readContent(new File("target","myTwo.html"));
    System.out.println(actual2);
    SampleFileWriter.assertFileContent(expected2,actual2);
  }

  
  @Test
  public void generate_noSyntaxIsOkay()
  {
    Documenter d = new Documenter("source","target");
    SampleFileWriter.createFile("source/one.txt", "myOne\n General\n @@description myTwo reference okay");
    SampleFileWriter.createFile("source/two.txt", "myTwo\n General\n @@description myOne references myTwo @@syntax myOne blah myTwo");
    Assert.assertEquals(true,d.generate());

    File expected = new File(pathToInput,"005_myOne.html");
    String actual = SampleFileWriter.readContent(new File("target","myOne.html"));
    // System.out.println(actual);
    SampleFileWriter.assertFileContent(expected,actual);
  }
*/
  
  private void assertParse(String filename)
  {
    assertParse(filename, true);
  }

  private void assertParse(String filename, boolean shouldAnalyze)
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, filename));
    
    if (parser == null)
    {
      parser = new ContentParser("content"); 
      documenter = new Documenter("a","b");
      documenter.setParser(parser);
    }
    
    
    boolean answer = parser.parse("content",input).getWasSuccess();
    
    if (answer == false)
    {
      System.out.println("failed at:" + parser.getParseResult().getPosition());
    }

    if (shouldAnalyze)
    {
      answer = parser.analyze().getWasSuccess();
    }
    
    Assert.assertEquals(true, answer);
  }
  
}
