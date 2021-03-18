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
import cruise.umple.compiler.FeatureModel;
import cruise.umple.compiler.FeatureLink;
import cruise.umple.compiler.FeatureNode;
import cruise.umple.compiler.FeatureLeaf;
import cruise.umple.compiler.Method;
import cruise.umple.compiler.MethodBody;
import cruise.umple.compiler.exceptions.*;
import java.io.File;

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
  public void GvfeatureDiagramConsoleNoWarnings()
  {

    String[] args = {"-generate","GvFeatureDiagram","GvFeatureConsoleTest.ump"} ;
    SampleFileWriter.createFile("GvFeatureConsoleTest.ump", "require [A and B or C];");
   try 
    {
      UmpleConsoleMain.main(args);
      SampleFileWriter.assertFileExists("GvFeatureConsoleTestGvFeatureDiagram.gv");
    }	
    finally 
    {
     SampleFileWriter.destroy("GvFeatureConsoleTestGvFeatureDiagram.gv");
     SampleFileWriter.destroy("GvFeatureConsoleTest.ump");
    }
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
  public void parseOneReqStArgument()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_oneArgument.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    FeatureLink featureLink = featureModel.getFeaturelink().get(0);
    FeatureLeaf source = ((FeatureLeaf) featureLink.getSourceFeatureNode());
    FeatureNode target = featureLink.getTargetFeatureNode();
    Assert.assertEquals(featureModel.getFeaturelink().size(),1); // test 
    Assert.assertEquals(false,source.getMixsetOrFileNode().getIsMixset());  // false
    Assert.assertEquals("reqStArgumentParse_oneArgument",source.getMixsetOrFileNode().getName());// == filename 
    Assert.assertTrue (((FeatureLeaf) target).getMixsetOrFileNode().getIsMixset()); // true 
    Assert.assertEquals("M1",((FeatureLeaf) target).getMixsetOrFileNode().getName()); // mixstName 
  }
  @Test
  public void parseMultipleAndsOpReqStArgument()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_MultipleAndsOp.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    int numOfLinks = featureModel.getFeaturelink().size();// == 6;
    int numOfFeatures = featureModel.getNode().size();// == 7   
    Assert.assertEquals(numOfLinks,6); 
    Assert.assertEquals(numOfFeatures,7); 
    Assert.assertEquals(false,  ((FeatureLeaf)featureModel.getNode().get(0)).getMixsetOrFileNode().isIsMixset() );  // false: its a file
    Assert.assertEquals(featureModel.getNode().get(1).getName(), "and");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(2)).getMixsetOrFileNode().getName(),"E");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(3)).getMixsetOrFileNode().getName(), "D");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(4)).getMixsetOrFileNode().getName(),"C");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(5)).getMixsetOrFileNode().getName(), "B");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(6)).getMixsetOrFileNode().getName() ,"A"); 
  }
  @Test
  public void parseMultipleOpReqStArgument()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_MultipleOp.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    int numOfLinks = featureModel.getFeaturelink().size();
    int numOfFeatures = featureModel.getNode().size();
    Assert.assertEquals(numOfLinks,7);
    Assert.assertEquals(numOfFeatures,11);

    Assert.assertEquals(false,  ((FeatureLeaf)featureModel.getNode().get(0)).getMixsetOrFileNode().isIsMixset() );  // false: its a file
    Assert.assertEquals(featureModel.getNode().get(1).getName(), "or");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(2)).getMixsetOrFileNode().getName(),"M6");
    Assert.assertEquals(featureModel.getNode().get(3).getName(), "xor");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(4)).getMixsetOrFileNode().getName() ,"M5");
    Assert.assertEquals(featureModel.getNode().get(5).getName(), "and");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(6)).getMixsetOrFileNode().getName() ,"M4");
    Assert.assertEquals(featureModel.getNode().get(7).getName(), "multiplicityTerminal");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(8)).getMixsetOrFileNode().getName() ,"M1");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(9)).getMixsetOrFileNode().getName() ,"M2");
    Assert.assertEquals(((FeatureLeaf)featureModel.getNode().get(10)).getMixsetOrFileNode().getName() ,"M3");
  }

  @Test
  public void parseNotOptSingleReqStArgumet()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_NotOptSingleArg.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();    
    int numOfLinks = featureModel.getFeaturelink().size();
    Assert.assertEquals(numOfLinks,2); 
    Assert.assertEquals(false,  ((FeatureLeaf)featureModel.getNode().get(0)).getMixsetOrFileNode().isIsMixset() );  // false: its a file
    Assert.assertEquals(featureModel.getFeaturelink(0).getFeatureConnectingOpType().name(), "Optional");
    Assert.assertEquals(featureModel.getFeaturelink(1).getFeatureConnectingOpType().name(), "Exclude"); 
  }
  @Test
  public void parseTerminalNotOptTerminalReqStArgumet()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_TerminalOpTerminal.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    //source --> opt B
    Assert.assertEquals(featureModel.getFeaturelink(0).getFeatureConnectingOpType().name(), "Optional");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(0).getSourceFeatureNode()).getMixsetOrFileNode().isIsMixset(), false); // false: its the source file
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(0).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"B");
    //source --> and A C
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(1).getSourceFeatureNode()).getMixsetOrFileNode().isIsMixset(), false);
    Assert.assertEquals(((FeatureNode) featureModel.getFeaturelink(1).getTargetFeatureNode()).getName() ,"and");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(2).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"C");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(3).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"A");
  }
  @Test
  public void parseReqStArgumetToFeaureModel()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_featureModel.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    //source --> (and A B)
    Assert.assertEquals(((FeatureNode) featureModel.getFeaturelink(0).getTargetFeatureNode()).getName() ,"and");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(1).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"B");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(2).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"A");
    //source --> opt C
    Assert.assertEquals(featureModel.getFeaturelink(3).getFeatureConnectingOpType().name(), "Optional");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(3).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"C");
    //source --> not D
    Assert.assertEquals(featureModel.getFeaturelink(4).getFeatureConnectingOpType().name(), "Exclude");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(4).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"D");
    //source --> (xor F E)
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(5).getSourceFeatureNode()).getMixsetOrFileNode().isIsMixset(), false);
    Assert.assertEquals(featureModel.getFeaturelink(5).getFeatureConnectingOpType().name(), "XOR");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(6).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"F");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(7).getTargetFeatureNode()).getMixsetOrFileNode().getName() ,"E"); 
  }
  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_1()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_featureModel.ump");//reuse ump file from parseReqStArgumetToFeaureModel()
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(featureModel.satisfyFeatureModel(), false);
  }
  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_2()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_validFeatureModel.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(true,featureModel.satisfyFeatureModel());
  }
  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_3()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_NotValidXorFeatureModel.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(false,featureModel.satisfyFeatureModel());
  }
  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_4()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_validSetFeatureModel.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(true,featureModel.satisfyFeatureModel());
  }
  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_5()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_NotvalidSetFeatureModel.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(false,featureModel.satisfyFeatureModel());
  }
  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_6()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_NotvalidBitWiseFeatuerModel.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(false,featureModel.satisfyFeatureModel());
  }
 @Test
  public void parseReqStArgumetToSatisfyFeatureModel_7()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_validCombinedOpFeatuerModel.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(true,featureModel.satisfyFeatureModel());
  }
 @Test
  public void parseReqStArgumetToSatisfyFeatureModel_8()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_validCombinedOpWithRoundBracket.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(true,featureModel.satisfyFeatureModel());
  }
 @Test
  public void parseReqStArgumetToSatisfyFeatureModel_9()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_NotvalidCombinedOpWithRoundBracket.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(false,featureModel.satisfyFeatureModel());
  }
 @Test
  public void parseReqStArgumetToSatisfyFeatureModel_10()
  {
    UmpleFile umpleFile = new  UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_validCombinedOpWithComplexRoundBracket.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel= model.getFeatureModel();
    Assert.assertEquals(true,featureModel.satisfyFeatureModel());
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

}
