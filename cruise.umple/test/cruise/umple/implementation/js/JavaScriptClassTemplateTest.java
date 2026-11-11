package cruise.umple.implementation.js;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleInternalParser;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.UmpleParser;
import cruise.umple.implementation.*;
import cruise.umple.parser.ErrorMessage;
import cruise.umple.parser.ParseResult;
import cruise.umple.parser.analysis.RuleBasedParser;
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
    SampleFileWriter.destroy(pathToInput + "/js/ConsoleTracer.js");
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
    SampleFileWriter.destroy(pathToInput + "/js/Thread.js");
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
    SampleFileWriter.destroy(pathToInput + "/js/Greeter.js");
    SampleFileWriter.destroy(pathToInput + "/js/Shape.js");
    SampleFileWriter.destroy(pathToInput + "/js/Circle.js");
    SampleFileWriter.destroy(pathToInput + "/js/Square.js");
    SampleFileWriter.destroy(pathToInput + "/js/Note.js");
  }

  //------------------------
  // Generated code
  //------------------------

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
  public void Comments()
  {
    assertUmpleTemplateFor("js/JavaScriptComments.ump","js/JavaScriptComments_Doc1.js.txt","Doc1");
  }

  @Test
  public void Methods()
  {
    assertUmpleTemplateFor("js/JavaScriptMethods.ump","js/JavaScriptMethods_Greeter.js.txt","Greeter");
    assertUmpleTemplateFor("js/JavaScriptMethods.ump","js/JavaScriptMethods_Shape.js.txt","Shape");
    assertUmpleTemplateFor("js/JavaScriptMethods.ump","js/JavaScriptMethods_Square.js.txt","Square");
  }

  // The base classes of a specialized association are generated although the subclasses are not
  @Test
  public void SpecializedAssociationBaseClasses()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedFeatures.ump");
    assertGeneratedEquals(model, "js/JavaScriptUnsupportedFeatures_Shelf.js.txt", "Shelf");
    assertGeneratedEquals(model, "js/JavaScriptUnsupportedFeatures_Item.js.txt", "Item");
  }

  //------------------------
  // Unsupported features
  //------------------------

  @Test
  public void UnsupportedStateMachine()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedStateMachine.ump");
    assertUnsupported(model, "Lamp", "State machines");
  }

  @Test
  public void UnsupportedFeatures()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedFeatures.ump");
    assertUnsupported(model, "Palette", "Interfaces, singletons, keys, constraints, enumerations and tracing");
    assertUnsupported(model, "Reading", "The fixml attribute x");
    assertUnsupported(model, "Sensor", "Interfaces, singletons, keys, constraints, enumerations and tracing");
    assertUnsupported(model, "BookShelf", "The specialized association items");
    assertUnsupported(model, "Novel", "The specialized association bookShelf");
    assertUnsupported(model, "Catalog", "The immutable association entries, which has a many end");
    // A class the compiler added for the trace directive has no position of its own to report
    assertNotGenerated(model, "ConsoleTracer");
    Assert.assertNull(messageFor(model, 9220, "ConsoleTracer"));
  }

  @Test
  public void UnsupportedOther()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedOther.ump");
    assertUnsupported(model, "Rect", "The derived attribute area");
    assertUnsupported(model, "Remote", "Distributed classes");
    assertUnsupported(model, "Loose", "Code that Umple could not interpret (extra code)");
  }

  @Test
  public void UnsupportedDistributedRuntime()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedOther.ump");
    Assert.assertNull(model.getGeneratedCode().get("UmpleRuntime"));
    Assert.assertNull(model.getGeneratedCode().get("IUmpleRuntime"));
    Assert.assertFalse(new File(pathToInput + "/js/UmpleRuntime.java").exists());
    Assert.assertFalse(new File(pathToInput + "/js/IUmpleRuntime.java").exists());
  }

  @Test
  public void UnsupportedSuperclass()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedSuperclass.ump");
    assertUnsupported(model, "Vehicle", "State machines");
    assertUnsupported(model, "Truck", "The superclass Vehicle");
    assertUnsupported(model, "Pickup", "The superclass Truck");
  }

  // An external class is never generated, so a subclass of one must not require a module that is
  // missing from the output
  @Test
  public void UnsupportedExternalSuperclass()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedSuperclass.ump");
    assertUnsupported(model, "Worker", "The external superclass Thread");
    Assert.assertFalse(new File(pathToInput + "/js/Thread.js").exists());
  }

  @Test
  public void UnsupportedInitialValue()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedInitialValue.ump");
    String[][] classAndAttribute = {{"Ratio", "half"}, {"Area", "side"}, {"Counter", "next"}, {"Ledger", "total"}, {"Mask", "bits"},
      {"Census", "people"}, {"Distance", "meters"}, {"Letter", "code"}, {"Session", "user"}, {"Shift", "steps"}, {"Sign", "level"}};
    for (String[] expected : classAndAttribute)
    {
      assertUnsupported(model, expected[0], "The initial value of attribute " + expected[1]);
    }
    //-0.0 is a negative zero in both Java and JavaScript
    Assert.assertTrue(model.getGeneratedCode().get("Floor").contains("this._height = -0.0;"));
  }

  @Test
  public void UnsupportedInnerClass()
  {
    UmpleModel model = generateWithDiagnostics("js/JavaScriptUnsupportedInnerClass.ump");
    assertUnsupported(model, "Panel", "Inner classes");
    assertUnsupported(model, "IconButton", "The superclass Button");
    Assert.assertFalse(new File(pathToInput + "/js/Button.js").exists());
  }

  //------------------------
  // Helpers
  //------------------------

  // Generates the model although some of its classes report diagnostics, which createUmpleSystem
  // treats as a failure, and keeps the messages for the assertions.
  private UmpleModel generateWithDiagnostics(String umpleFile)
  {
    File file = new File(pathToInput, umpleFile);
    UmpleModel model = new UmpleModel(new UmpleFile(pathToInput, umpleFile));
    model.setShouldGenerate(false);
    RuleBasedParser rbp = new RuleBasedParser();
    UmpleParser parser = new UmpleInternalParser(umpleParserName, model, rbp);
    ParseResult result = rbp.parse(file);
    model.extractAnalyzersFromParser(rbp);
    model.setLastResult(result);
    Assert.assertTrue("Syntax failed at:" + result.getPosition(), result.getWasSuccess());
    model.setUmpleFile(new UmpleFile(new File(pathToInput, umpleFile)));
    model.addGenerate(language);
    parser.analyze(true);
    return model;
  }

  // The class is not generated: E9220 names the feature and the class, no code is kept for it, no
  // file is written for it, and the command line reports the run as failed.
  private void assertUnsupported(UmpleModel model, String className, String feature)
  {
    ErrorMessage message = messageFor(model, 9220, className);
    Assert.assertNotNull("No message 9220 for " + className + " in " + messages(model), message);
    Assert.assertTrue(message.getFormattedMessage(), message.getFormattedMessage().startsWith(feature));
    Assert.assertEquals("E9220 for " + className + " points at its declaration",
      model.getUmpleClass(className).getPosition(0).getLineNumber(), message.getPosition().getLineNumber());
    assertNotGenerated(model, className);
    Assert.assertFalse("The run must fail so the command line exits with a non-zero status",
      model.getLastResult().getWasSuccess());
  }

  private void assertNotGenerated(UmpleModel model, String className)
  {
    Assert.assertNull("No code may be kept for " + className, model.getGeneratedCode().get(className));
    Assert.assertFalse("No file may be written for " + className,
      new File(pathToInput + "/js/" + className + ".js").exists());
  }

  private void assertGeneratedEquals(UmpleModel model, String codeFile, String className)
  {
    String actual = model.getGeneratedCode().get(className);
    Assert.assertNotNull("No generated code: " + className, actual);
    assertGeneratedJavaScriptParses(model);
    SampleFileWriter.assertFileContent(new File(pathToInput, codeFile), actual, true);
  }

  // The first message with this code that names the class, or null
  private ErrorMessage messageFor(UmpleModel model, int code, String className)
  {
    for (ErrorMessage m : model.getLastResult().getErrorMessages())
    {
      if (m.getErrorType().getErrorCode() == code && m.getFormattedMessage().contains("class " + className + " "))
      {
        return m;
      }
    }
    return null;
  }

  private List<String> messages(UmpleModel model)
  {
    List<String> all = new ArrayList<String>();
    for (ErrorMessage m : model.getLastResult().getErrorMessages())
    {
      all.add(m.getErrorType().getErrorCode() + ": " + m.getFormattedMessage());
    }
    return all;
  }
}
