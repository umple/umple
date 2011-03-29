/*

Copyright 2010 Andrew Forward, Timothy C. Lethbridge

This file is made available subject to the open source license found at:
http://cruise.site.uottawa.ca/UmpleMITLicense.html

*/

package cruise.umple.stats;

import java.io.File;

import org.junit.*;

import cruise.umple.util.FileManager;

public class MetricsCollectorTest
{
  
  MetricsCollector collector;
  
  @Before
  public void setUp()
  {
    collector = new MetricsCollector();
  }
  
  @After
  public void tearDown()
  {
    (new File("myapp.umple")).delete();
    (new File("myapp2.umple")).delete();
    (new File("myapp.results")).delete();
  } 
  
  @Test
  public void analyze_unknownFile()
  {
    boolean answer = collector.analyze("p1","myapp.umple");
    Assert.assertEquals(false,answer);
  }
  
  
  @Test
  public void analyze_knownFile()
  {
    FileManager.writeFileToDisk("myapp.umple", "");
    boolean answer = collector.analyze("p1","myapp.umple"); 
    Assert.assertEquals(true, answer);
  }
  
  @Test
  public void numberOf_noData()
  {
    Assert.assertEquals(0,collector.numberOf("p1","1","*"));
  }

  @Test
  public void numberOf_invalidData()
  {
    FileManager.writeFileToDisk("myapp.umple", "namespace Airline;\nclass Airline{1 -- * RegularFlight;}class RegularFlight {}");
    collector.analyze("p1","myapp.umple");
    Assert.assertEquals(0,collector.numberOf("p1","blah","blah"));
  }
  
  @Test
  public void numberOf_oneToMany()
  {
    FileManager.writeFileToDisk("myapp.umple", "namespace Airline;\nclass Airline{1 -- * RegularFlight;}class RegularFlight {}");
  
    collector.analyze("p1","myapp.umple");
    Assert.assertEquals(1,collector.numberOf("p1","1","*"));
    Assert.assertEquals(1,collector.numberOf("p1","*","1"));
  }  
  
  @Test
  public void numberOf_nToM()
  {
    FileManager.writeFileToDisk("myapp.umple", "namespace Airline;\nclass Airline{3 -- 5 RegularFlight;}class RegularFlight {2 -- 4 Gate;} class Gate {}");
  
    collector.analyze("p1","myapp.umple");
    Assert.assertEquals(2,collector.numberOf("p1","n","m"));
    Assert.assertEquals(2,collector.numberOf("p1","m","n"));
  }   

  @Test
  public void saveToDisk()
  {
    FileManager.writeFileToDisk("myapp.umple", "namespace Airline;\nclass Airline{1 -- * RegularFlight;}class RegularFlight {}");
  
    collector.analyze("p1","myapp.umple");
    collector.save("myapp.results");
    String results = FileManager.loadFile("myapp.results");
    String expected = "Project Id\t#1 -- *\np1\t1";
    Assert.assertEquals(expected,results);
  } 
  
  @Test
  public void toStringShowResults()
  {
    FileManager.writeFileToDisk("myapp.umple", "namespace Airline;\nclass Airline{1 -- * RegularFlight;}class RegularFlight {}");
  
    collector.analyze("p1","myapp.umple");
    String results = collector.toString();
    String expected = "Project Id\t#1 -- *\np1\t1\n";
    Assert.assertEquals(expected,results);
  } 
  
  @Test
  public void toStringMultiProjects()
  {
    FileManager.writeFileToDisk("myapp.umple", "namespace Airline;\nclass Airline{1 -- * RegularFlight;}class RegularFlight {}");
    FileManager.writeFileToDisk("myapp2.umple", "namespace Airline;\nclass Airline{1 -- 1 RegularFlight;}class RegularFlight {}");
  
    collector.analyze("p1","myapp.umple");
    collector.analyze("p2","myapp2.umple");
    String results = collector.toString();
    String expected = "Project Id\t#1 -- *\t#1 -- 1\np1\t1\t0\np2\t0\t1\n";
    Assert.assertEquals(expected,results);
  }
  
  @Test
  public void fileNotFound()
  {
    Boolean answer = collector.analyze("p1", "unknown.ump");
    Assert.assertEquals(false,answer);
    String[] logs = collector.getLogs();
    
    Assert.assertEquals(1,logs.length);
    Assert.assertEquals("Unable to read content: unknown.ump", logs[0]);
  }
  
}
