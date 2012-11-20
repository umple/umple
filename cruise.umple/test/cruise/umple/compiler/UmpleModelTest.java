/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.io.*;
import java.util.*;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

public class UmpleModelTest
{
  
  UmpleFile uFile;
  UmpleModel model;
  
  @Before
  public void setUp()
  {
    SampleFileWriter.createFile("teacher.txt", "class Teacher {}");
    SampleFileWriter.createFile("student.txt", "class Student {}");

    uFile = new UmpleFile("teacher.txt");
    model = new UmpleModel(new UmpleFile("teacher.txt"));
    
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("teacher.txt");
    SampleFileWriter.destroy("student.txt");
  }
  

  @Test
  public void getDefaultGenerate()
  {
    Assert.assertEquals(null, model.getDefaultGenerate());
    model.addGenerate("Php");
    Assert.assertEquals("Php", model.getDefaultGenerate());
    model.addGenerate("Java");
    Assert.assertEquals("Php", model.getDefaultGenerate());
  }

  @Test
  public void addUmpleInterface()
  {
    Assert.assertEquals(null,model.getUmpleInterface("Teacher"));
    
    UmpleInterface aInterface = model.addUmpleInterface("Teacher");
    Assert.assertEquals(aInterface,model.getUmpleInterface("Teacher"));
  }

  @Test
  public void addUmpleClass()
  {
    Assert.assertEquals(null,model.getUmpleClass("Teacher"));
    
    UmpleClass uClass = model.addUmpleClass("Teacher");
    Assert.assertEquals(uClass,model.getUmpleClass("Teacher"));
  }



  @Test
  public void addUmpleClassMergeWithExisting()
  {
    Assert.assertEquals(null,model.getUmpleClass("Teacher"));
    
    UmpleClass uClass = model.addUmpleClass("Teacher");
    Attribute attr = new Attribute("x","String",null,null,false,uClass);
    
    UmpleClass sameClass = model.addUmpleClass("Teacher");
    Assert.assertSame(uClass,sameClass);
  }

  
  
   @Test
  public void shouldGenerate()
  {
    model = new UmpleModel(null);
    Assert.assertEquals(true,model.getShouldGenerate());
    
    model.setShouldGenerate(false);
    Assert.assertEquals(false,model.getShouldGenerate());

    model.setShouldGenerate(true);
    Assert.assertEquals(true,model.getShouldGenerate());
  }
  
  @Test
  public void umpleFile()
  {
    Assert.assertEquals("teacher", model.getUmpleFile().getSimpleFileName());
  }

  @Test
  public void constructor_checkPath()
  {
    File f = new File("teacher.txt");
    String path = new File(f.getAbsolutePath()).getParentFile().getAbsolutePath();
    Assert.assertEquals(path, uFile.getPath());
  }

  @Test
  public void constructor_checkFileName()
  {
    Assert.assertEquals("teacher.txt", model.getUmpleFile().getFileName());
  }
  
  @Test
  public void getClassByName()
  {
    UmpleClass aClass = new UmpleClass("Blah");
    Assert.assertEquals(null, model.getUmpleClass("Blah"));
    model.addUmpleClass(aClass);
    Assert.assertEquals(aClass, model.getUmpleClass("Blah"));
  }
  
  @Test
  public void addAssociationClass()
  {
    Assert.assertEquals(null, model.getUmpleClass("Blah"));
    model.addAssociationClass("Blah");
    Assert.assertEquals("Blah", model.getUmpleClass("Blah").getName());
  }
  
  @Test
  public void getStateMachineDefinition()
  {
    StateMachine sm = new StateMachine("Blah");
    Assert.assertEquals(null,model.getStateMachineDefinition("Blah"));
    model.addStateMachineDefinition(sm);
    Assert.assertEquals(sm,model.getStateMachineDefinition("Blah"));
  }
  
  @Test
  public void getDefaultAssociationPosition()
  {
    UmpleClass c1 = new UmpleClass("Student");
    UmpleClass c2 = new UmpleClass("Mentor");
    
    AssociationEnd end1 = new AssociationEnd("",c1.getName(),"","",new Multiplicity());
    AssociationEnd end2 = new AssociationEnd("",c2.getName(),"","",new Multiplicity());
	Association a = new Association(true,true,end1,end2);
	
	UmpleModel model = new UmpleModel(null);
	model.addUmpleClass(c1);
	model.addUmpleClass(c2);
	model.addAssociation(a);
	c1.setPosition(model.getDefaultClassPosition(0));
	c2.setPosition(model.getDefaultClassPosition(1));
	
	//class two to the right of class one
	c1.getPosition().setX(0);
	c1.getPosition().setY(0);
	c2.getPosition().setX(200);
	c2.getPosition().setY(0);
	Coordinate[] defaults = model.getDefaultAssociationPosition(a);
	a.addPosition(defaults[0]);
	a.addPosition(defaults[1]);
	Assert.assertEquals(new Coordinate(109,10,0,0), a.getPosition(0));
	Assert.assertEquals(new Coordinate(0,10,0,0), a.getPosition(1));
	a.removePosition(defaults[0]);
	a.removePosition(defaults[1]);
	
	//class two to the left of class one
	c1.getPosition().setX(200);
	c1.getPosition().setY(0);
	c2.getPosition().setX(0);
	c2.getPosition().setY(0);
	defaults = model.getDefaultAssociationPosition(a);
	a.addPosition(defaults[0]);
	a.addPosition(defaults[1]);
	Assert.assertEquals(new Coordinate(0,10,0,0), a.getPosition(0));
	Assert.assertEquals(new Coordinate(109,10,0,0), a.getPosition(1));
	a.removePosition(defaults[0]);
	a.removePosition(defaults[1]);
	
	//class two below class one
	c1.getPosition().setX(0);
	c1.getPosition().setY(0);
	c2.getPosition().setX(0);
	c2.getPosition().setY(150);
	defaults = model.getDefaultAssociationPosition(a);
	a.addPosition(defaults[0]);
	a.addPosition(defaults[1]);
	Assert.assertEquals(new Coordinate(30,45,0,0), a.getPosition(0));
	Assert.assertEquals(new Coordinate(30,0,0,0), a.getPosition(1));  
	a.removePosition(defaults[0]);
	a.removePosition(defaults[1]);
	
	//class two above class one
	c1.getPosition().setX(0);
	c1.getPosition().setY(150);
	c2.getPosition().setX(0);
	c2.getPosition().setY(0);
	defaults = model.getDefaultAssociationPosition(a);
	a.addPosition(defaults[0]);
	a.addPosition(defaults[1]);
	Assert.assertEquals(new Coordinate(30,0,0,0), a.getPosition(0));
	Assert.assertEquals(new Coordinate(30,45,0,0), a.getPosition(1));
	a.removePosition(defaults[0]);
	a.removePosition(defaults[1]);
	
	//diagonal
	c1.getPosition().setX(0);
	c1.getPosition().setY(0);
	c2.getPosition().setX(210);
	c2.getPosition().setY(69);
	defaults = model.getDefaultAssociationPosition(a);
	a.addPosition(defaults[0]);
	a.addPosition(defaults[1]);
	Assert.assertEquals(new Coordinate(109,10,0,0), a.getPosition(0));
	Assert.assertEquals(new Coordinate(0,10,0,0), a.getPosition(1));
	a.removePosition(defaults[0]);
	a.removePosition(defaults[1]);
  }  
  
  @Test
  public void getDefaultReflexiveAssociationPosition()
  {
	  UmpleClass c1 = new UmpleClass("Student");
	    
	  AssociationEnd end1 = new AssociationEnd("role1",c1.getName(),"","",new Multiplicity());
	  AssociationEnd end2 = new AssociationEnd("role2",c1.getName(),"","",new Multiplicity());
	  Association a = new Association(true,true,end1,end2);
		
	  UmpleModel model = new UmpleModel(null);
	  model.addUmpleClass(c1);
	  model.addAssociation(a);
	  c1.setPosition(model.getDefaultClassPosition(0));
	  Coordinate[] defaults = model.getDefaultAssociationPosition(a);
	  a.addPosition(defaults[0]);
	  a.addPosition(defaults[1]);
	  Assert.assertEquals(new Coordinate(15,45,0,0), a.getPosition(0));
	  Assert.assertEquals(new Coordinate(0,30,0,0), a.getPosition(1));
  }
  
  @Test
  public void getUmpleElements()
  {
    UmpleClass x = model.addUmpleClass("X");
    UmpleInterface y = model.addUmpleInterface("Y");
    List<UmpleElement> all = model.getUmpleElements();
    Assert.assertEquals(2,all.size());
    Assert.assertEquals(x,all.get(0));
    Assert.assertEquals(y,all.get(1));
    
  }
  
  @Test
  public void getVersionNumber()
  {
    Assert.assertEquals("1.15.0.2188",UmpleModel.versionNumber);
  }
  
}
