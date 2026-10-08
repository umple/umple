package cruise.umple.implementation.js;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class JavaScriptClassTemplateTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "JavaScript";
    languagePath = "js";
  }

  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/js/Empty.js");
    SampleFileWriter.destroy(pathToInput + "/js/Person.js");
    SampleFileWriter.destroy(pathToInput + "/js/Animal.js");
    SampleFileWriter.destroy(pathToInput + "/js/Dog.js");
    SampleFileWriter.destroy(pathToInput + "/js/Library.js");
    SampleFileWriter.destroy(pathToInput + "/js/Book.js");
    SampleFileWriter.destroy(pathToInput + "/js/Team.js");
    SampleFileWriter.destroy(pathToInput + "/js/Player.js");
    SampleFileWriter.destroy(pathToInput + "/js/Lamp.js");
    SampleFileWriter.destroy(pathToInput + "/js/Course.js");
    SampleFileWriter.destroy(pathToInput + "/js/Student.js");
    SampleFileWriter.destroy(pathToInput + "/js/Desk.js");
    SampleFileWriter.destroy(pathToInput + "/js/Chair.js");
    SampleFileWriter.destroy(pathToInput + "/js/House.js");
    SampleFileWriter.destroy(pathToInput + "/js/Room.js");
    SampleFileWriter.destroy(pathToInput + "/js/Palette.js");
    SampleFileWriter.destroy(pathToInput + "/js/Reading.js");
    SampleFileWriter.destroy(pathToInput + "/js/Sensor.js");
    SampleFileWriter.destroy(pathToInput + "/js/cruise");
    SampleFileWriter.destroy(pathToInput + "/js/Shelf.js");
    SampleFileWriter.destroy(pathToInput + "/js/Item.js");
    SampleFileWriter.destroy(pathToInput + "/js/BookShelf.js");
    SampleFileWriter.destroy(pathToInput + "/js/Novel.js");
    SampleFileWriter.destroy(pathToInput + "/js/Catalog.js");
    SampleFileWriter.destroy(pathToInput + "/js/Entry.js");
  }

  @Test
  public void EmptyClass()
  {
    assertUmpleTemplateFor("js/JavaScriptEmptyClass.ump","js/JavaScriptEmptyClass_Empty.js.txt","Empty");
  }

  @Test
  public void Attributes()
  {
    assertUmpleTemplateFor("js/JavaScriptAttributes.ump","js/JavaScriptAttributes_Person.js.txt","Person");
  }

  @Test
  public void Inheritance()
  {
    assertUmpleTemplateFor("js/JavaScriptInheritance.ump","js/JavaScriptInheritance_Dog.js.txt","Dog");
  }

  @Test
  public void DirectedAssociation()
  {
    assertUmpleTemplateFor("js/JavaScriptDirectedAssociation.ump","js/JavaScriptDirectedAssociation_Library.js.txt","Library");
    assertUmpleTemplateFor("js/JavaScriptDirectedAssociation.ump","js/JavaScriptDirectedAssociation_Book.js.txt","Book");
  }

  @Test
  public void OptionalAssociation()
  {
    assertUmpleTemplateFor("js/JavaScriptOptionalAssociation.ump","js/JavaScriptOptionalAssociation_Team.js.txt","Team");
    assertUmpleTemplateFor("js/JavaScriptOptionalAssociation.ump","js/JavaScriptOptionalAssociation_Player.js.txt","Player");
  }

  @Test
  public void ManyToManyAssociation()
  {
    assertUmpleTemplateFor("js/JavaScriptManyToManyAssociation.ump","js/JavaScriptManyToManyAssociation_Course.js.txt","Course");
  }

  @Test
  public void OptionalOneToOneAssociation()
  {
    assertUmpleTemplateFor("js/JavaScriptOptionalOneToOneAssociation.ump","js/JavaScriptOptionalOneToOneAssociation_Desk.js.txt","Desk");
  }

  @Test
  public void Composition()
  {
    assertUmpleTemplateFor("js/JavaScriptComposition.ump","js/JavaScriptComposition_House.js.txt","House");
  }

  @Test
  public void UnsupportedStateMachine()
  {
    assertUmpleTemplateFor("js/JavaScriptUnsupportedStateMachine.ump","js/JavaScriptUnsupportedStateMachine_Lamp.js.txt","Lamp");
  }

  @Test
  public void UnsupportedFeatures()
  {
    assertUmpleTemplateFor("js/JavaScriptUnsupportedFeatures.ump","js/JavaScriptUnsupportedFeatures_Palette.js.txt","Palette");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedFeatures.ump","js/JavaScriptUnsupportedFeatures_Reading.js.txt","Reading");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedFeatures.ump","js/JavaScriptUnsupportedFeatures_Sensor.js.txt","Sensor");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedFeatures.ump","js/JavaScriptUnsupportedFeatures_BookShelf.js.txt","BookShelf");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedFeatures.ump","js/JavaScriptUnsupportedFeatures_Novel.js.txt","Novel");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedFeatures.ump","js/JavaScriptUnsupportedFeatures_Catalog.js.txt","Catalog");
  }
}
