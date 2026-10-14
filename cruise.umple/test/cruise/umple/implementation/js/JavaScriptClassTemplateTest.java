package cruise.umple.implementation.js;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
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
    SampleFileWriter.destroy(pathToInput + "/js/Gadget.js");
    SampleFileWriter.destroy(pathToInput + "/js/Driver.js");
    SampleFileWriter.destroy(pathToInput + "/js/Car.js");
    SampleFileWriter.destroy(pathToInput + "/js/Badge.js");
    SampleFileWriter.destroy(pathToInput + "/js/Stamp.js");
    SampleFileWriter.destroy(pathToInput + "/js/Employee.js");
    SampleFileWriter.destroy(pathToInput + "/js/Friend.js");
    SampleFileWriter.destroy(pathToInput + "/js/Node.js");
    SampleFileWriter.destroy(pathToInput + "/js/Spouse.js");
    SampleFileWriter.destroy(pathToInput + "/js/Car2.js");
    SampleFileWriter.destroy(pathToInput + "/js/Engine.js");
    SampleFileWriter.destroy(pathToInput + "/js/Folder.js");
    SampleFileWriter.destroy(pathToInput + "/js/Doc.js");
    SampleFileWriter.destroy(pathToInput + "/js/Fleet.js");
    SampleFileWriter.destroy(pathToInput + "/js/Flag.js");
    SampleFileWriter.destroy(pathToInput + "/js/Doc1.js");
    SampleFileWriter.destroy(pathToInput + "/js/Rect.js");
    SampleFileWriter.destroy(pathToInput + "/js/Remote.js");
    SampleFileWriter.destroy(pathToInput + "/js/Loose.js");
    SampleFileWriter.destroy(pathToInput + "/js/UmpleRuntime.java");
    SampleFileWriter.destroy(pathToInput + "/js/IUmpleRuntime.java");
    SampleFileWriter.destroy(pathToInput + "/js/Vehicle.js");
    SampleFileWriter.destroy(pathToInput + "/js/Truck.js");
    SampleFileWriter.destroy(pathToInput + "/js/Pickup.js");
    SampleFileWriter.destroy(pathToInput + "/js/Worker.js");
    SampleFileWriter.destroy(pathToInput + "/js/Ratio.js");
    SampleFileWriter.destroy(pathToInput + "/js/Area.js");
    SampleFileWriter.destroy(pathToInput + "/js/Counter.js");
    SampleFileWriter.destroy(pathToInput + "/js/Ledger.js");
    SampleFileWriter.destroy(pathToInput + "/js/Mask.js");
    SampleFileWriter.destroy(pathToInput + "/js/Census.js");
    SampleFileWriter.destroy(pathToInput + "/js/Distance.js");
    SampleFileWriter.destroy(pathToInput + "/js/Letter.js");
    SampleFileWriter.destroy(pathToInput + "/js/Session.js");
    SampleFileWriter.destroy(pathToInput + "/js/Shift.js");
    SampleFileWriter.destroy(pathToInput + "/js/Sign.js");
    SampleFileWriter.destroy(pathToInput + "/js/Floor.js");
    SampleFileWriter.destroy(pathToInput + "/js/Panel.js");
    SampleFileWriter.destroy(pathToInput + "/js/Button.js");
    SampleFileWriter.destroy(pathToInput + "/js/IconButton.js");
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
  public void AdvancedAttributes()
  {
    assertUmpleTemplateFor("js/JavaScriptAdvancedAttributes.ump","js/JavaScriptAdvancedAttributes_Gadget.js.txt","Gadget");
  }

  @Test
  public void UnidirectionalOptionalOne()
  {
    assertUmpleTemplateFor("js/JavaScriptUnidirectionalOptionalOne.ump","js/JavaScriptUnidirectionalOptionalOne_Driver.js.txt","Driver");
    assertUmpleTemplateFor("js/JavaScriptUnidirectionalOptionalOne.ump","js/JavaScriptUnidirectionalOptionalOne_Badge.js.txt","Badge");
  }

  @Test
  public void ReflexiveAssociation()
  {
    assertUmpleTemplateFor("js/JavaScriptReflexiveAssociation.ump","js/JavaScriptReflexiveAssociation_Employee.js.txt","Employee");
    assertUmpleTemplateFor("js/JavaScriptReflexiveAssociation.ump","js/JavaScriptReflexiveAssociation_Friend.js.txt","Friend");
    assertUmpleTemplateFor("js/JavaScriptReflexiveAssociation.ump","js/JavaScriptReflexiveAssociation_Node.js.txt","Node");
    assertUmpleTemplateFor("js/JavaScriptReflexiveAssociation.ump","js/JavaScriptReflexiveAssociation_Spouse.js.txt","Spouse");
  }

  @Test
  public void CompositionVariants()
  {
    assertUmpleTemplateFor("js/JavaScriptCompositionVariants.ump","js/JavaScriptCompositionVariants_Car2.js.txt","Car2");
    assertUmpleTemplateFor("js/JavaScriptCompositionVariants.ump","js/JavaScriptCompositionVariants_Engine.js.txt","Engine");
    assertUmpleTemplateFor("js/JavaScriptCompositionVariants.ump","js/JavaScriptCompositionVariants_Folder.js.txt","Folder");
    assertUmpleTemplateFor("js/JavaScriptCompositionVariants.ump","js/JavaScriptCompositionVariants_Doc.js.txt","Doc");
    assertUmpleTemplateFor("js/JavaScriptCompositionVariants.ump","js/JavaScriptCompositionVariants_Fleet.js.txt","Fleet");
    assertUmpleTemplateFor("js/JavaScriptCompositionVariants.ump","js/JavaScriptCompositionVariants_Flag.js.txt","Flag");
  }

  @Test
  public void SpecializedAssociationBaseClasses()
  {
    assertUmpleTemplateFor("js/JavaScriptUnsupportedFeatures.ump","js/JavaScriptUnsupportedFeatures_Shelf.js.txt","Shelf");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedFeatures.ump","js/JavaScriptUnsupportedFeatures_Item.js.txt","Item");
  }

  @Test
  public void Comments()
  {
    assertUmpleTemplateFor("js/JavaScriptComments.ump","js/JavaScriptComments_Doc1.js.txt","Doc1");
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

  @Test
  public void UnsupportedOther()
  {
    assertUmpleTemplateFor("js/JavaScriptUnsupportedOther.ump","js/JavaScriptUnsupportedOther_Rect.js.txt","Rect");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedOther.ump","js/JavaScriptUnsupportedOther_Remote.js.txt","Remote");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedOther.ump","js/JavaScriptUnsupportedOther_Loose.js.txt","Loose");
  }

  @Test
  public void UnsupportedDistributedRuntime()
  {
    UmpleModel model = createUmpleSystem(pathToInput, "js/JavaScriptUnsupportedOther.ump");
    Assert.assertNotNull(model.getGeneratedCode().get("Remote"));
    Assert.assertNull(model.getGeneratedCode().get("UmpleRuntime"));
    Assert.assertNull(model.getGeneratedCode().get("IUmpleRuntime"));
    Assert.assertFalse(new File(pathToInput + "/js/UmpleRuntime.java").exists());
    Assert.assertFalse(new File(pathToInput + "/js/IUmpleRuntime.java").exists());
  }

  @Test
  public void UnsupportedSuperclass()
  {
    assertUmpleTemplateFor("js/JavaScriptUnsupportedSuperclass.ump","js/JavaScriptUnsupportedSuperclass_Truck.js.txt","Truck");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedSuperclass.ump","js/JavaScriptUnsupportedSuperclass_Pickup.js.txt","Pickup");
    assertUmpleTemplateFor("js/JavaScriptUnsupportedSuperclass.ump","js/JavaScriptUnsupportedSuperclass_Worker.js.txt","Worker");
  }

  @Test
  public void UnsupportedInitialValue()
  {
    String errors = generateAndReadErrors("js/JavaScriptUnsupportedInitialValue.ump");
    String[][] classAndAttribute = {{"Ratio", "half"}, {"Area", "side"}, {"Counter", "next"}, {"Ledger", "total"}, {"Mask", "bits"},
      {"Census", "people"}, {"Distance", "meters"}, {"Letter", "code"}, {"Session", "user"}, {"Shift", "steps"}, {"Sign", "level"}};
    for (String[] expected : classAndAttribute)
    {
      assertUnsupported(errors, expected[0], "The initial value of attribute '" + expected[1] + "' is currently unsupported for JavaScript generation.");
    }
    //-0.0 is a negative zero in both Java and JavaScript
    Assert.assertTrue(lastModel.getGeneratedCode().get("Floor").contains("this._height = -0.0;"));
  }

  @Test
  public void UnsupportedInnerClass()
  {
    String errors = generateAndReadErrors("js/JavaScriptUnsupportedInnerClass.ump");
    assertUnsupported(errors, "Panel", "Inner classes are currently unsupported for JavaScript generation.");
    assertUnsupported(errors, "IconButton", "The superclass 'Button' uses a feature that is currently unsupported for JavaScript generation.");
    Assert.assertFalse(new File(pathToInput + "/js/Button.js").exists());
  }

  private UmpleModel lastModel;

  // Generates the model and returns what the generator printed about unsupported features
  private String generateAndReadErrors(String umpleFile)
  {
    PrintStream originalErr = System.err;
    ByteArrayOutputStream errors = new ByteArrayOutputStream();
    System.setErr(new PrintStream(errors, true));
    try
    {
      lastModel = createUmpleSystem(pathToInput, umpleFile);
    }
    finally
    {
      System.setErr(originalErr);
    }
    return errors.toString();
  }

  // The class is not generated: its file holds only the comment, and the reason is reported for it
  private void assertUnsupported(String errors, String className, String reason)
  {
    Assert.assertEquals("//An Unsupported feature for JavaScript generation was used. File could not be generated.", lastModel.getGeneratedCode().get(className));
    Assert.assertTrue(new File(pathToInput + "/js/" + className + ".js").exists());
    Assert.assertTrue(errors, errors.contains("Could not Generate file '" + className + ".js'. This file will be missing from the output." + System.lineSeparator() + "\t" + reason));
  }
}
