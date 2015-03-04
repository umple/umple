/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    SampleFileWriter.createFile("sub/Teacher2.ump", "namespace sub; class Teacher2{}");
    SampleFileWriter.createFile("sub/student2.ump", "namespace sub; class Student2 {}");
    SampleFileWriter.createFile("TestSymmetric.txt", "class Course { * self isMutuallyExclusiveWith;}");

    uFile = new UmpleFile("teacher.txt");
    model = new UmpleModel(new UmpleFile("teacher.txt"));
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("teacher.txt");
    SampleFileWriter.destroy("student.txt");
    SampleFileWriter.destroy("TestSymmetric.txt");
    SampleFileWriter.destroy("Course.java");
    SampleFileWriter.destroy("Teacher.java");
    SampleFileWriter.destroy("sub/");
  }

  @Test
  public void getDefaultGenerate()
  {
    assertEquals(null, model.getDefaultGenerate());
    model.addGenerate("Php");
    assertEquals("Php", model.getDefaultGenerate());
    model.addGenerate("Java");
    assertEquals("Php", model.getDefaultGenerate());
  }

  @Test
  public void addUmpleInterface()
  {
    assertEquals(null,model.getUmpleInterface("Teacher"));
    UmpleInterface aInterface = model.addUmpleInterface("Teacher");
    assertEquals(aInterface,model.getUmpleInterface("Teacher"));
  }

  @Test
  public void addUmpleClass()
  {
    assertEquals(null,model.getUmpleClass("Teacher"));
    UmpleClass uClass = model.addUmpleClass("Teacher");
    assertEquals(uClass,model.getUmpleClass("Teacher"));
  }

  @Test
  public void addUmpleClassMergeWithExisting()
  {
    assertEquals(null,model.getUmpleClass("Teacher"));

    UmpleClass uClass = model.addUmpleClass("Teacher");
    new Attribute("x","String",null,null,false,uClass); // this adds the attribute to uClass
    UmpleClass sameClass = model.addUmpleClass("Teacher");
    assertSame(uClass,sameClass);
  }

  @Test
  public void shouldGenerate()
  {
    model = new UmpleModel(null);
    assertEquals(true,model.getShouldGenerate());
    model.setShouldGenerate(false);
    assertEquals(false,model.getShouldGenerate());
    model.setShouldGenerate(true);
    assertEquals(true,model.getShouldGenerate());
  }

  @Test
  public void umpleFile()
  {
    assertEquals("teacher", model.getUmpleFile().getSimpleFileName());
  }

  @Test
  public void umpleFileWithLinkedFiles() {
    uFile.addLinkedFiles("sub/student2.ump");
    model = new UmpleModel(uFile);
    model.run();
    
    List<String> classNames = model.getUmpleClasses().stream().map(UmpleClass::getName).collect(Collectors.toList());
    assertTrue(classNames.contains("Student2"));
    assertTrue(classNames.contains("Teacher"));
    
    uFile = new UmpleFile("sub/Teacher2.ump");
    uFile.addLinkedFiles("student2.ump");
    model = new UmpleModel(uFile);
    model.run();
    
    classNames = model.getUmpleClasses().stream().map(UmpleClass::getName).collect(Collectors.toList());
    assertTrue(classNames.contains("Student2"));
    assertTrue(classNames.contains("Teacher2"));
  }

  @Test

  public void constructor_checkPath()

  {

    File f = new File("teacher.txt");

    String path = new File(f.getAbsolutePath()).getParentFile().getAbsolutePath();

    assertEquals(path, uFile.getPath());

  }



  @Test

  public void constructor_checkFileName()

  {

    assertEquals("teacher.txt", model.getUmpleFile().getFileName());

  }



  @Test

  public void getClassByName()

  {

    UmpleClass aClass = new UmpleClass("Blah");

    assertEquals(null, model.getUmpleClass("Blah"));

    model.addUmpleClass(aClass);

    assertEquals(aClass, model.getUmpleClass("Blah"));

  }



  @Test

  public void addAssociationClass()

  {

    assertEquals(null, model.getUmpleClass("Blah"));

    model.addAssociationClass("Blah");

    assertEquals("Blah", model.getUmpleClass("Blah").getName());

  }



  @Test

  public void getStateMachineDefinition()

  {

    StateMachine sm = new StateMachine("Blah");

    assertEquals(null,model.getStateMachineDefinition("Blah"));

    model.addStateMachineDefinition(sm);

    assertEquals(sm,model.getStateMachineDefinition("Blah"));

  }



  @Test

  public void getDefaultAssociationPosition()

  {

    UmpleClass c1 = new UmpleClass("Student");

    UmpleClass c2 = new UmpleClass("Mentor");



    AssociationEnd end1 = new AssociationEnd("",c1.getName(),"","",new Multiplicity());

    AssociationEnd end2 = new AssociationEnd("",c2.getName(),"","",new Multiplicity());

	Association a = new Association(true,true,false,false,end1,end2);



	UmpleModel model = new UmpleModel(null);

	model.addUmpleClass(c1);

	model.addUmpleClass(c2);

	model.addAssociation(a);

	c1.setCoordinates(model.getDefaultClassPosition(0));

	c2.setCoordinates(model.getDefaultClassPosition(1));



	//class two to the right of class one

	c1.getCoordinates().setX(0);

	c1.getCoordinates().setY(0);

	c2.getCoordinates().setX(200);

	c2.getCoordinates().setY(0);

	Coordinate[] defaults = model.getDefaultAssociationPosition(a);

	a.addPosition(defaults[0]);

	a.addPosition(defaults[1]);

	assertEquals(new Coordinate(109,10,0,0), a.getPosition(0));

	assertEquals(new Coordinate(0,10,0,0), a.getPosition(1));

	a.removePosition(defaults[0]);

	a.removePosition(defaults[1]);



	//class two to the left of class one

	c1.getCoordinates().setX(200);

	c1.getCoordinates().setY(0);

	c2.getCoordinates().setX(0);

	c2.getCoordinates().setY(0);

	defaults = model.getDefaultAssociationPosition(a);

	a.addPosition(defaults[0]);

	a.addPosition(defaults[1]);

	assertEquals(new Coordinate(0,10,0,0), a.getPosition(0));

	assertEquals(new Coordinate(109,10,0,0), a.getPosition(1));

	a.removePosition(defaults[0]);

	a.removePosition(defaults[1]);



	//class two below class one

	c1.getCoordinates().setX(0);

	c1.getCoordinates().setY(0);

	c2.getCoordinates().setX(0);

	c2.getCoordinates().setY(150);

	defaults = model.getDefaultAssociationPosition(a);

	a.addPosition(defaults[0]);

	a.addPosition(defaults[1]);

	assertEquals(new Coordinate(30,45,0,0), a.getPosition(0));

	assertEquals(new Coordinate(30,0,0,0), a.getPosition(1));

	a.removePosition(defaults[0]);

	a.removePosition(defaults[1]);



	//class two above class one

	c1.getCoordinates().setX(0);

	c1.getCoordinates().setY(150);

	c2.getCoordinates().setX(0);

	c2.getCoordinates().setY(0);

	defaults = model.getDefaultAssociationPosition(a);

	a.addPosition(defaults[0]);

	a.addPosition(defaults[1]);

	assertEquals(new Coordinate(30,0,0,0), a.getPosition(0));

	assertEquals(new Coordinate(30,45,0,0), a.getPosition(1));

	a.removePosition(defaults[0]);

	a.removePosition(defaults[1]);



	//diagonal

	c1.getCoordinates().setX(0);

	c1.getCoordinates().setY(0);

	c2.getCoordinates().setX(210);

	c2.getCoordinates().setY(69);

	defaults = model.getDefaultAssociationPosition(a);

	a.addPosition(defaults[0]);

	a.addPosition(defaults[1]);

	assertEquals(new Coordinate(109,10,0,0), a.getPosition(0));

	assertEquals(new Coordinate(0,10,0,0), a.getPosition(1));

	a.removePosition(defaults[0]);

	a.removePosition(defaults[1]);

  }



  @Test

  public void getDefaultReflexiveAssociationPosition()

  {

	  UmpleClass c1 = new UmpleClass("Student");



	  AssociationEnd end1 = new AssociationEnd("role1",c1.getName(),"","",new Multiplicity());

	  AssociationEnd end2 = new AssociationEnd("role2",c1.getName(),"","",new Multiplicity());

	  Association a = new Association(true,true,false,false,end1,end2);



	  UmpleModel model = new UmpleModel(null);

	  model.addUmpleClass(c1);

	  model.addAssociation(a);

	  c1.setCoordinates(model.getDefaultClassPosition(0));

	  Coordinate[] defaults = model.getDefaultAssociationPosition(a);

	  a.addPosition(defaults[0]);

	  a.addPosition(defaults[1]);

	  assertEquals(new Coordinate(15,45,0,0), a.getPosition(0));

	  assertEquals(new Coordinate(0,30,0,0), a.getPosition(1));

  }



  @Test

  public void getUmpleElements()

  {

    UmpleClass x = model.addUmpleClass("X");

    UmpleInterface y = model.addUmpleInterface("Y");

    List<UmpleElement> all = model.getUmpleElements();

    assertEquals(2,all.size());

    assertEquals(x,all.get(0));

    assertEquals(y,all.get(1));



  }

  @Test
  public void SymmetricReflexiveTest (){
	  UmpleModel inModel = new UmpleModel(new UmpleFile("TestSymmetric.txt"));
	  inModel.run();
	  assertEquals(1,inModel.getUmpleClass(0).getAssociations().length);
  }

  @Test
  public void getAllTranslatorsTest_ModelWithNormalGenerators() {
    // Note that this test is not exhaustive. This test implementation was
    //  chosen because the supported translators may change frequently and
    //  we don't want to have to keep changing this test. As long as we know
    //  that the method does not blow up, we are good.

    model.addGenerate("Php");
    model.addGenerate("Java");

    Map<String, CodeTranslator> allTranslators = model.getAllTranslators();

    assertTrue(allTranslators.containsKey("Php"));
    assertNotNull(allTranslators.get("Php"));
    assertTrue(allTranslators.containsKey("Java"));
    assertNotNull(allTranslators.get("Java"));
  }

  @Test
  public void getAllTranslatorsTest_ModelWithNoGenerators() {
    Map<String, CodeTranslator> allTranslators = model.getAllTranslators();

    assertTrue(allTranslators.isEmpty());
  }

}

