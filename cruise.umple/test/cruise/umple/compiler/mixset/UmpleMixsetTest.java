package cruise.umple.compiler.mixset;

import org.junit.*;
import cruise.umple.UmpleConsoleMain;
import cruise.umple.compiler.UmpleParserTest;
import cruise.umple.util.SampleFileWriter;
import cruise.umple.parser.Position;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.UmpleClass;
import java.util.List;
import cruise.umple.compiler.Method;
import cruise.umple.compiler.MethodBody;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.php.PhpClassGenerator;
import java.io.File;
import cruise.umple.compiler.UmpleAnnotaiveToCompositionGenerator;
import cruise.umple.compiler.GvFeatureDiagramGenerator;


public class UmpleMixsetTest {
  
  UmpleParserTest umpleParserTest;
 
  @Before
  public void setUp()
  {
    umpleParserTest = new UmpleParserTest();
    umpleParserTest.pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler/mixset");
  }

  @Test
  public void mixsetDefinition()
  {
    umpleParserTest.assertNoWarningsParse("mixsetDefinition.ump");
  }

  @Test
  public void emptyMixsetBody() {
   
    umpleParserTest.assertNoWarningsParse("emptyMixsetBody.ump");		
  }
  
  @Test
  public void mixsetUseStatement()
  {
	  umpleParserTest.assertNoWarningsParse("mixsetUse.ump");
  }
   
	
  @Test
  public void mixsetUseInSubsequentFile()
  {
    String[] args = new String[] {"first.ump"};
    SampleFileWriter.createFile("first.ump", " mixset MyMixset { class MyClass {} } use activateMixset.ump; ");
    SampleFileWriter.createFile	("activateMixset.ump"," use MyMixset; ");
    try 
    {
      UmpleConsoleMain.main(args);
      SampleFileWriter.assertFileExists("MyClass.java");
    }
    finally 
    {
      SampleFileWriter.destroy("first.ump");
      SampleFileWriter.destroy("MyClass.java");
      SampleFileWriter.destroy("activateMixset.ump");
    }
  }

  @Test
  public void mixsetUseInCodeTest() {
    String[] args = new String[] {"mixsetUseInCodeTest.ump"};
    SampleFileWriter.createFile("mixsetUseInCodeTest.ump", " class Outer_Mix_1{ } mixset Mix { class Inner_Mix {name;} } class Outer_Mix_2{ }"
      + "\n"
      + " use Mix; "
      + "\n");

    try 
    {
      UmpleConsoleMain.main(args);
      SampleFileWriter.assertFileExists("Inner_Mix.java");
      SampleFileWriter.assertFileExists("Outer_Mix_1.java");
      SampleFileWriter.assertFileExists("Outer_Mix_2.java");
    }	
    finally 
    {
      SampleFileWriter.destroy("mixsetUseInCodeTest.ump");
      SampleFileWriter.destroy("Inner_Mix.java");
      SampleFileWriter.destroy("Outer_Mix_1.java");
      SampleFileWriter.destroy("Outer_Mix_2.java");
    }
  }

  @Test
  public void mixsetUseInConsoleTest() {
    String[] args = new String[] {"mixsetUseInConsoleTest.ump", "Mx"};

    SampleFileWriter.createFile("mixsetUseInConsoleTest.ump", " class Outer_1{ } mixset Mx { class Inner_M1 {name;} } class Outer_2{ }");
   try 
   {
      UmpleConsoleMain.main(args);
      SampleFileWriter.assertFileExists("Inner_M1.java");
      SampleFileWriter.assertFileExists("Outer_1.java");
      SampleFileWriter.assertFileExists("Outer_2.java");
    }
    finally 
    {
      SampleFileWriter.destroy("mixsetUseInConsoleTest.ump");
      SampleFileWriter.destroy("Inner_M1.java");
      SampleFileWriter.destroy("Outer_1.java");
      SampleFileWriter.destroy("Outer_2.java");
    }
  }

  @Test
  public void multipleMixsetUseInConsoleTest() {
    String[] args = new String[] {"mixset_1.ump", "M2", "mixset_2.ump", "M1"};
    SampleFileWriter.createFile("mixset_1.ump", "mixset M1 { class Inner_1 { } }" );
    SampleFileWriter.createFile("mixset_2.ump", "mixset M2 { class Inner_2 { } }");

    try 
    {
      UmpleConsoleMain.main(args);
      SampleFileWriter.assertFileExists("Inner_1.java");
      SampleFileWriter.assertFileExists("Inner_2.java");
    }	
    finally 
    {
      SampleFileWriter.destroy("mixset_1.ump");
      SampleFileWriter.destroy("mixset_2.ump");
      SampleFileWriter.destroy("Inner_1.java");
      SampleFileWriter.destroy("Inner_2.java");
    }
  }
  @Test
  public void middleOfMixsetBodyError() {

    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"mixsetInnerBodyError.ump");
    int line = 12;
    int errorCode = 1503;
    int offset= 1;
    int charOff = 12;
    umpleParserTest.assertFailedParse(file.getFileName(), new Position(file.getPath()+"/"+file.getFileName(),line,offset,charOff),errorCode);		
  }

  @Test
  public void nestedMixsetBodyWarning() {

    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"warningInnerMixset.ump");
    int line = 11;
    int errorCode = 1007;
    int offset= 0;
    int charOff = 12;
    umpleParserTest.assertHasWarningsParse(file.getFileName(), new Position(file.getPath()+"/"+file.getFileName(),line,offset,charOff),errorCode);
  }

	@Test
  public void oneElementMixsetBodyError() {
    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"oneElementMixsetBodyError.ump");
    int line = 5;
    int errorCode = 1502;
    int offset= 0;
    int charOff = 0;
    umpleParserTest.assertFailedParse(file.getFileName(), new Position(file.getPath()+"/"+file.getFileName(),line,offset,charOff),errorCode);
 }

  @Test
  public void lastElementMixsetBodyError() {
    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"lastElementError.ump");
    int line = 3;
    int errorCode = 1502;
    int offset= 0;
    int charOff = 14;
    umpleParserTest.assertFailedParse(file.getFileName(), new Position(file.getPath()+"/"+file.getFileName(),line,offset,charOff),errorCode);

 }

 @Test
  public void fileMaintainItsOrderWithMixset() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"mixsetUseUmpleFileOrder.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.get(0).getAttribute(0).getName(),"one");
    Assert.assertEquals(umpleClasses.get(0).getAttribute(1).getName(),"two");
    Assert.assertEquals(umpleClasses.get(0).getAttribute(2).getName(),"three");
    Assert.assertEquals(umpleClasses.get(0).getAttribute(3).getName(),"four");
    Assert.assertEquals(umpleClasses.get(0).getAttribute(4).getName(),"five");
 }

@Test
  public void mixsetWithNoUseStatementHasNoEffect() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"mixsetDefinition.ump"); //mixsetDefinition.ump is reused for a different purpose.
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.size(), 1);
    Assert.assertEquals(umpleClasses.get(0).getAttributes().size(), 0);
 }

  @Test
  public void innerMixsetHasNoEffectWhenParentMixsetNotUsed()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parentMixsetWithNoUseStatement.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
		List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.size(), 1);
    Assert.assertEquals(umpleClasses.get(0).getAttributes().size(), 0);
    Assert.assertEquals(umpleClasses.get(0).getName(),"OuterClass");

  }

 @Test
  public void useStatementsDependency()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"UseStatementsDependency.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.size(), 1);
    Assert.assertEquals(umpleClasses.get(0).getName(),"Target");

  }
 
  @Test
  public void mixsetRequireStatementNoWarnings()
  {
    umpleParserTest.assertNoWarningsParse("mixsetRequireStatementNoWarnings.ump");
  }

  @Test
  public void mixsetRequireSubStatementNoWarnings()
  {
    umpleParserTest.assertNoWarningsParse("mixsetRequireSubStatementNoWarnings.ump");
  }

 @Test
  public void stateMachine_State_HasMixset()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"stateMachineStateHasMixset.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.get(0).getName(),"Booking");
    Assert.assertEquals(umpleClasses.get(0).getStateMachine("state").getStates().size(),5);
    Assert.assertEquals(umpleClasses.get(0).getStateMachine("state").getAllTransitions().size(), 6);

  }

  @Test
  public void stateMachine_StateEntity_HasMixset()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"stateMachineTransitionHasMixset.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.get(0).getName(),"Booking");
    Assert.assertEquals(umpleClasses.get(0).getStateMachine("state").getStates().size(),5);
    Assert.assertEquals(umpleClasses.get(0).getStateMachine("state").getAllTransitions().size(), 6);

  }
 @Test
  public void TraitHasMixset()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"TraitHasMixet.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.get(0).getName(),"ClassA");
    Assert.assertEquals(umpleClasses.get(0).getAttributes().size(), 2);
  }
 @Test
  public void associationHasMixset()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"associationHasMixset.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.get(0).getAssociations().length, 2);
  }
 @Test
  public void parseInlineMixsetInsideMixset()
  {
    umpleParserTest.assertNoWarningsParse("InlineMixsetInsideMixset.ump");
  }
  @Test
  public void parseInlineMixsetInsideUmpleEntity()
  {
    umpleParserTest.assertNoWarningsParse("inlineMixsetInsideUmpleEntity.ump");
    UmpleFile umpleFile = new  UmpleFile(umpleParserTest.pathToInput,"inlineMixsetInsideUmpleEntity.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    List<UmpleClass> umpleClasses = model.getUmpleClasses();
    Assert.assertEquals(umpleClasses.get(0).getAttribute(0).getName(),"attr1");
  }
  @Test
  public void parseLabelsInsideMethod()
  {    
    UmpleFile umpleFile =new  UmpleFile(umpleParserTest.pathToInput,"parseLabelsInsideMethod_basic.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(5);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
    String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf("SecondLabel:"));
    String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf("SecondLabel:"));
    
    Assert.assertEquals(true, beforeLabelCode.contains("code added before the SecondLabel in staticMethod()."));
    Assert.assertEquals(true, methodBodyCode.contains("SecondLabel:"));
    Assert.assertEquals(true, afterLabelCode.contains("code added after the SecondLabel in staticMethod()."));
   try 
    {
      SampleFileWriter.assertFileExists(umpleParserTest.pathToInput+"/"+"InjectToLabel.java");
    }
    finally 
    {
      SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"InjectToLabel.java");
    }
  }
  @Test
  public void multipleAspectsForOneLabelMethod() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseLabelsInsideMethod_multpleAspectForOneMethod.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(5);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();

    String keyWord = "NewLabel:";
    String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf(keyWord));
    String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf(keyWord));

    Assert.assertEquals(true, beforeLabelCode.contains("code added before the SecondLabel by first Injection"));
    Assert.assertEquals(true, methodBodyCode.contains(keyWord));
    Assert.assertEquals(true, afterLabelCode.contains("code added before the SecondLabel by second Injection"));

    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"InjectToLabel.java");
  }
  @Test
  public void mixsetInsideMethods_noUseStatement() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideMethod.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(0);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
    String keyWord = "Code after (outside) mixset M1";
    String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf(keyWord));
    String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf(keyWord));
    Assert.assertEquals(true, methodBodyCode.contains(keyWord));
    //before checks: 
    Assert.assertEquals(true, beforeLabelCode.contains("this is aMethod."));
    Assert.assertEquals(false, beforeLabelCode.contains("code for InnerMixset"));
    Assert.assertEquals(false, beforeLabelCode.contains("mixset M1 { "));
    Assert.assertEquals(false, beforeLabelCode.contains("x++;"));
    Assert.assertEquals(false, beforeLabelCode.contains("extra code for the mixset M1"));
    //after checks:
    Assert.assertEquals(false, afterLabelCode.contains("code for mixset M2."));
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"MixsetWithinMethodClass.java");
  }
  @Test
  public void mixsetInsideMethods_useM1Statement() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideMethod_M1.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(0);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
    String keyWord = "Code after (outside) mixset M1";
    String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf(keyWord));
    String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf(keyWord));
    Assert.assertEquals(true, methodBodyCode.contains(keyWord));
    //before checks: 
    Assert.assertEquals(true, beforeLabelCode.contains("this is aMethod."));
    Assert.assertEquals(false, beforeLabelCode.contains("code for InnerMixset"));
    Assert.assertEquals(false, beforeLabelCode.contains("mixset M1 { "));
    Assert.assertEquals(true, beforeLabelCode.contains("x++;"));
    Assert.assertEquals(true, beforeLabelCode.contains("extra code for the mixset M1"));
    //after checks:
    Assert.assertEquals(false, afterLabelCode.contains("code for mixset M2."));
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"MixsetWithinMethodClass.java");
  }
  @Test
  public void mixsetInsideMethods_useM2Statement() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideMethod_M2.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(0);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
    String keyWord = "Code after (outside) mixset M1";
    String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf(keyWord));
    String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf(keyWord));
    Assert.assertEquals(true, methodBodyCode.contains(keyWord));
    //before checks: 
    Assert.assertEquals(true, beforeLabelCode.contains("this is aMethod."));
    Assert.assertEquals(false, beforeLabelCode.contains("code for InnerMixset"));
    Assert.assertEquals(false, beforeLabelCode.contains("mixset M1 { "));
    Assert.assertEquals(false, beforeLabelCode.contains("x++;"));
    Assert.assertEquals(false, beforeLabelCode.contains("extra code for the mixset M1"));
    //after checks:
    Assert.assertEquals(true, afterLabelCode.contains("code for mixset M2."));
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"MixsetWithinMethodClass.java");
  }
  @Test
  public void mixsetInsideMethods_useM1andInnerMixsetStatement() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideMethod_M1_InnerMixset.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(0);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
    String keyWord = "Code after (outside) mixset M1";
    String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf(keyWord));
    String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf(keyWord));
    Assert.assertEquals(true, methodBodyCode.contains(keyWord));
    //before checks: 
    Assert.assertEquals(true, beforeLabelCode.contains("this is aMethod."));
    Assert.assertEquals(true, beforeLabelCode.contains("code for InnerMixset"));
    Assert.assertEquals(false, beforeLabelCode.contains("mixset M1 { "));
    Assert.assertEquals(true, beforeLabelCode.contains("x++;"));
    Assert.assertEquals(true, beforeLabelCode.contains("extra code for the mixset M1"));
    //after checks:
    Assert.assertEquals(false, afterLabelCode.contains("code for mixset M2."));
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"MixsetWithinMethodClass.java");
  }
 @Test
  public void mixsetInsideMethods_useM1andM2Statement() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideMethod_M1_M2.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(0);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
    String keyWord = "Code after (outside) mixset M1";
    String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf(keyWord));
    String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf(keyWord));
    Assert.assertEquals(true, methodBodyCode.contains(keyWord));
    //before checks: 
    Assert.assertEquals(true, beforeLabelCode.contains("this is aMethod."));
    Assert.assertEquals(false, beforeLabelCode.contains("code for InnerMixset"));
    Assert.assertEquals(false, beforeLabelCode.contains("mixset M1 { "));
    Assert.assertEquals(true, beforeLabelCode.contains("x++;"));
    Assert.assertEquals(true, beforeLabelCode.contains("extra code for the mixset M1"));
    //after checks:
    Assert.assertEquals(true, afterLabelCode.contains("code for mixset M2."));
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"MixsetWithinMethodClass.java");
  }
  @Test
  public void mixsetInsideMethods_useM1andInnerMixsetandM2Statement() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideMethod_M1_InnerMixset_M2.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(0);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
    String keyWord = "Code after (outside) mixset M1";
    String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf(keyWord));
    String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf(keyWord));
    Assert.assertEquals(true, methodBodyCode.contains(keyWord));
    //before checks: 
    Assert.assertEquals(true, beforeLabelCode.contains("this is aMethod."));
    Assert.assertEquals(true, beforeLabelCode.contains("code for InnerMixset"));
    Assert.assertEquals(false, beforeLabelCode.contains("mixset M1 { "));
    Assert.assertEquals(true, beforeLabelCode.contains("x++;"));
    Assert.assertEquals(true, beforeLabelCode.contains("extra code for the mixset M1"));
    //after checks:
    Assert.assertEquals(true, afterLabelCode.contains("code for mixset M2."));
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"MixsetWithinMethodClass.java");
  }

  @Test 
  public void mixsetInsideMethods_deleteProperCloseBracket()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideMethod_properDeleteOfClosingBracket.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    umodel.run();
    umodel.generate();
    UmpleClass uClass = umodel.getUmpleClass(0);
    Method aMethod = uClass.getMethod(0);
    String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
    String keyWord1 = "//TAG_MIXSET_BEFORE_CLOSE";
    String keyWord2 = "//TAG_MIXSET_CLOSE";
  
    int indexOfKeyWord1= methodBodyCode.indexOf(keyWord1);
    int indexOfKeyWord2= methodBodyCode.indexOf(keyWord2);

    Assert.assertEquals(true, methodBodyCode.contains(keyWord1));
    Assert.assertEquals(true, methodBodyCode.contains(keyWord2));
    Assert.assertEquals(false, methodBodyCode.substring(indexOfKeyWord1, indexOfKeyWord2).contains("}"));
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"MixsetWithinMethodClass_CloseBracket.java");

  }

  @Test
  public void testAround_twoLabels() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"aroundInjectionTwoLabels.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    Method aMethod ;
    try{
      umodel.run();
      umodel.generate();
    }
    catch (UmpleCompilerException e)
    {
      if(!e.getMessage().contains("1013")) // ignore warning caused by aspect injection.
    	{
    	  throw e;
    	}
    }
    finally 
    {  
      UmpleClass uClass = umodel.getUmpleClass(0);
      aMethod = uClass.getMethod(0);
      String methodBodyCode= aMethod.getMethodBody().getCodeblock().getCode();
      String keyWord = "int x";
      String beforeLabelCode = methodBodyCode.substring(0,methodBodyCode.indexOf(keyWord));
      String afterLabelCode = methodBodyCode.substring(methodBodyCode.indexOf(keyWord));
      Assert.assertEquals(true, methodBodyCode.contains(keyWord));
      //before checks: 
      Assert.assertEquals(true, beforeLabelCode.contains("if (true) {"));
      //after checks:
      Assert.assertEquals(true, afterLabelCode.contains("}"));
      Assert.assertEquals(true, afterLabelCode.contains("code after around."));
      Assert.assertEquals(true, afterLabelCode.contains("Label2:"));
      SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"AroundClass.java");
   }
  }
  @Test
  public void testAround_noLabels() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"aroundInjectionNoLabels.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    Method aMethod ;
    try{
      umodel.run();
      umodel.generate();

    }
    catch (UmpleCompilerException e)
    {
      if(!e.getMessage().contains("1013")) // ignore warning caused by aspect injection.
    	{
    	  throw e;
    	}
    }
    finally 
    {  
      String pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler/mixset/");
      SampleFileWriter.assertFileExists(pathToInput+"AroundClass.java");
      String actual = umodel.getGeneratedCode().get("AroundClass");
      File expected = new File(pathToInput + "AroundClass.java.txt");
      SampleFileWriter.assertFileContent(expected, actual,true);
      SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"AroundClass.java");
   }
  }

  @Test
  public void testCasecadeExtentionOfLabeledAspect() {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"casecadExtentionForLabeledAspect.ump");
    UmpleModel umodel = new UmpleModel(umpleFile);
    Method aMethod ;
    try{
      umodel.run();
      umodel.generate();
    }
    catch (UmpleCompilerException e)
    {
      if(!e.getMessage().contains("1013")) // ignore warning caused by aspect injection.
    	{
    	  throw e;
    	}
    }
    finally 
    { 
      MethodBody mBody = umodel.getUmpleClass(0).getMethod(0).getMethodBody();
      String code = mBody.getCodeblock().getCode();
      int label0Index =  code.indexOf("Label_0");
      int label3Index =  code.indexOf("Label3");
      int label2Index =  code.indexOf("Label2");
      int label1Index =  code.indexOf("Label1:");
      Assert.assertTrue(label0Index < label3Index);
      Assert.assertTrue(label3Index < label2Index);
      Assert.assertTrue(label2Index < label1Index);
      String pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler/mixset/");
      SampleFileWriter.assertFileExists(pathToInput+"Aclass.java");
      SampleFileWriter.destroy(umpleParserTest.pathToInput+"/"+"Aclass.java");
   }
  }
 @Test
  public void reqStatmentForMixsetNotusedIsParsed()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseReqStInsideMixsetNotUsed.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    Assert.assertEquals(model.getMixsetOrFiles().size() , 9);
  }

 @Test
  public void umpFileInsideMixsetNotusedIsParsed()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseUmpFileInsideMixsetNotUsed.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    Assert.assertEquals(model.getMixsetOrFiles().size() , 10);
  }
  @Test
  public void multipleMixsetsInOneUseStatment()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetUseInOneUseStatement.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    Assert.assertEquals(model.getUmpleClasses().size() , 3);
  }
  @Test
  public void inlineMixsetsInTemplate()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideTemplate.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(true);
    try
    {
       model.run();
    }
    catch (UmpleCompilerException e)
    {
      String generatedFile =  umpleParserTest.pathToInput+"/TemplateMixset.java";
      SampleFileWriter.assertFileExists(generatedFile);
      String templateGeneratedCode = SampleFileWriter.readContent(new File(generatedFile));
      //  included mixsets
      Assert.assertTrue(templateGeneratedCode.contains("Print out the following "));
      Assert.assertTrue(templateGeneratedCode.contains("M1 is used, this line should be included"));
      Assert.assertTrue(templateGeneratedCode.contains("M2 is used, this line should be included"));
      // not included mixsets
      Assert.assertFalse(templateGeneratedCode.contains("M3 is not used, this line NOT should be included"));
      Assert.assertFalse(templateGeneratedCode.contains("I am outer , this line should NOT be included"));
      Assert.assertFalse(templateGeneratedCode.contains("I am inner , this line should NOT be included"));
      // no mixset definitions i
      Assert.assertFalse(templateGeneratedCode.contains("mixset M1"));
      Assert.assertFalse(templateGeneratedCode.contains("mixset M2"));
      Assert.assertFalse(templateGeneratedCode.contains("mixset M3"));
      Assert.assertFalse(templateGeneratedCode.contains("mixset Outer"));
      Assert.assertFalse(templateGeneratedCode.contains("mixset Inner"));
      //delete generated file
      SampleFileWriter.destroy(generatedFile);
    }

    
  }
  @Test
  public void inlineMixsetsInsideMethodPhpCode()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideMethod_generic.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(true);
    model.run();
    PhpClassGenerator phpGenerator = new PhpClassGenerator();		
    String code = phpGenerator.getCode(model, model.getUmpleClass(0));
    Assert.assertTrue(code.contains("M2 is used mixset."));
    // not included mixsets
    Assert.assertFalse(code.contains("M1 is not used mixset"));
    // no mixset definitions 
    Assert.assertFalse(code.contains("mixset M1 {"));
    Assert.assertFalse(code.contains("mixset M2 {"));
    //delete generated file
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/AphpClass.java");
  }
  @Test
  public void inlineMixsetsInsideAspectCode()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseMixsetsInsideAspect.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(true);
    model.run();
    String code = model.getGeneratedCode().get("AspectClass");
    Assert.assertTrue(code.contains("public void doMethodOne()"));
    Assert.assertTrue(code.contains("public void doMethodTwo"));
    Assert.assertTrue(code.contains("M2 code to stay"));
    Assert.assertTrue(code.contains("int y"));
    // not included mixsets
    Assert.assertFalse(code.contains("M1 code to be removed"));
    Assert.assertFalse(code.contains("int x"));
    // no mixset definitions 
    Assert.assertFalse(code.contains("mixset M1 {"));
    Assert.assertFalse(code.contains("mixset M2 {"));
    //delete generated file
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/AspectClass.java");
  }
  @Test
  public void refactorInlineMixsetIntoCompMixset()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"parseRefactorInlineMixsetIntoCompMixset.ump");
    UmpleModel umpModel = new UmpleModel(umpleFile);
    umpModel.setShouldGenerate(true);
    umpModel.run();
    UmpleAnnotaiveToCompositionGenerator umpleAnnotaiveToCompositionGenerator = new UmpleAnnotaiveToCompositionGenerator();
    umpleAnnotaiveToCompositionGenerator.setModel(umpModel);
    umpleAnnotaiveToCompositionGenerator.generate();
    String generatedFile =  umpleParserTest.pathToInput+"/parseRefactorInlineMixsetIntoCompMixset_refactoredToComposition.ump";
    SampleFileWriter.assertFileExists(generatedFile);
    String templateGeneratedCode = SampleFileWriter.readContent(new File(generatedFile));
    //  included mixsets
    Assert.assertTrue(templateGeneratedCode.contains("class Bank { 1 -- 1..* Branch; }"));
    SampleFileWriter.destroy(generatedFile);
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/Bank.java");
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/Account.java");
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/Branch.java");
  }

  @Test
  public void featureDependencies()
  { 
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"featureDepend.ump");
    UmpleModel umpModel = new UmpleModel(umpleFile);
    umpModel.setShouldGenerate(true);
    umpModel.run();
    GvFeatureDiagramGenerator gen = new GvFeatureDiagramGenerator();
    gen.setModel(umpModel);
    gen.generate();
    SampleFileWriter.destroy(umpleParserTest.pathToInput+"/featureDependGvFeatureDiagram.gv");
  }

  @Test
  public void featureUseIsValid()
  {
    UmpleFile file1 = new UmpleFile(umpleParserTest.pathToInput,"mobileSPL_1.ump");
    UmpleModel model1 = new UmpleModel(file1);
    model1.run();
    boolean file1Test = model1.getFeatureModel().satisfyFeatureModel();
    Assert.assertTrue(file1Test);

    UmpleFile file2 = new UmpleFile(umpleParserTest.pathToInput,"mobileSPL_2.ump");
    UmpleModel model2 = new UmpleModel(file2);
    model2.run();
    boolean file2Test = model2.getFeatureModel().satisfyFeatureModel();
    Assert.assertFalse(file2Test);   
  }
  @Test
  public void sameLabelManyTimesWarning() {
    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"sameLabelManyTimes.ump");
    int line = 5;
    int errorCode = 1512;
    int offset= 4;
    int charOff = 64;
    umpleParserTest.assertHasWarningsParse(file.getFileName(), new Position(file.getFileName(),line,offset,charOff),errorCode);
  }
  @Test
  public void isFeatureKeyword()
  {
    UmpleFile file1 = new UmpleFile(umpleParserTest.pathToInput,"isFeatureStatements.ump");
    UmpleModel model1 = new UmpleModel(file1);
    model1.run();
    boolean file1Test = model1.getFeatureModel().satisfyFeatureModel();
    int numberOfFeatures = model1.getFeatureModel().getNode().size();
    Assert.assertTrue(file1Test);
    Assert.assertEquals(numberOfFeatures, 6); // 5 features + root feature 
  }
  
  @Test
  public void mixsetUsedHasNoDefinition()
  {  
    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"mixsetUseNoDefinition.ump");
    int line = 17;
    int errorCode = 1513;
    int offset= 0;
    int charOff = 0;
    umpleParserTest.assertHasWarningsParse(file.getFileName(), new Position(file.getFileName(),line,offset,charOff),errorCode);
  }
  
  @Test
  public void mixsetWithEmptyClassError1805()
  {  
    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"mixsetWithEmptyClass.ump");
    umpleParserTest.assertHasNoWarningsParse(file.getFileName());
  }
  @Test
  public void mixsetHideErrorsWhenUsedError1803()
  {  
    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"errorsHiddenWhenMixsetIsUsed.ump");
    umpleParserTest.assertHasWarningsParse(file.getFileName(), 1);

  }


}
