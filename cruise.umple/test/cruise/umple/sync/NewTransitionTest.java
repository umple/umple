/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.sync;

import java.io.File;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class NewTransitionTest
{
  
  String pathToInput;
  
  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/sync");
  }
  
  @After
  public void tearDown() {
    SampleFileWriter.destroy(pathToInput + "/myfile.ump");
  }
  
  @Test
  public void Go_SameFromId()
  {
	    String umple =  SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go.before.ump"));
	    String json = SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go.before.json"));
	    String filename = pathToInput + "/NewTransitionTest_Go.before.ump";
	    
	    NewTransitionAction action = new NewTransitionAction(json,umple,filename);
	    action.go();
	    
	    SampleFileWriter.assertFileContent(new File(pathToInput,"NewTransitionTest_Go.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_AfterLastTransition()
  {
	    String umple =  SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go2.before.ump"));
	    String json = SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go2.before.json"));
	    String filename = pathToInput + "/NewTransitionTest_Go2.before.ump";
	    
	    NewTransitionAction action = new NewTransitionAction(json,umple,filename);
	    action.go();
	    
	    SampleFileWriter.assertFileContent(new File(pathToInput,"NewTransitionTest_Go2.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_NestedState()
  {
	    String umple =  SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go3.before.ump"));
	    String json = SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go3.before.json"));
	    String filename = pathToInput + "/NewTransitionTest_Go3.before.ump";
	    
	    NewTransitionAction action = new NewTransitionAction(json,umple,filename);
	    action.go();
	    
	    SampleFileWriter.assertFileContent(new File(pathToInput,"NewTransitionTest_Go3.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_InCorrectFromState()
  {
	    String umple =  SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go4.before.ump"));
	    String json = SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go4.before.json"));
	    String filename = pathToInput + "/NewTransitionTest_Go4.before.ump";
	    
	    NewTransitionAction action = new NewTransitionAction(json,umple,filename);
	    action.go();
	    
	    SampleFileWriter.assertFileContent(new File(pathToInput,"NewTransitionTest_Go4.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_AfterLastTransitionInNestState()
  {
	    String umple =  SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go5.before.ump"));
	    String json = SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go5.before.json"));
	    String filename = pathToInput + "/NewTransitionTest_Go5.before.ump";
	    
	    NewTransitionAction action = new NewTransitionAction(json,umple,filename);
	    action.go();
	    
	    SampleFileWriter.assertFileContent(new File(pathToInput,"NewTransitionTest_Go5.after.ump"), action.getUmpleCode());
  }  
  
  @Test
  public void Go_NestedStateIncorrectFromStateName()
  {
	    String umple =  SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go6.before.ump"));
	    String json = SampleFileWriter.readContent(new File(pathToInput,"NewTransitionTest_Go6.before.json"));
	    String filename = pathToInput + "/NewTransitionTest_Go6.before.ump";
	    
	    NewTransitionAction action = new NewTransitionAction(json,umple,filename);
	    action.go();
	    
	    SampleFileWriter.assertFileContent(new File(pathToInput,"NewTransitionTest_Go6.after.ump"), action.getUmpleCode());
  }  
}
