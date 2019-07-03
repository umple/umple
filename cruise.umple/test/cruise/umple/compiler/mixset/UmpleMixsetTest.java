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
    FeatureLeaf source = ((FeatureLeaf) featureLink.getSourceFeature());
    FeatureNode target = featureLink.getTargetFeature().get(0);
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
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(0).getSourceFeature()).getMixsetOrFileNode().isIsMixset(), false); // false: its the source file
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(0).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"B");
    //source --> and A C
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(1).getSourceFeature()).getMixsetOrFileNode().isIsMixset(), false);
    Assert.assertEquals(((FeatureNode) featureModel.getFeaturelink(1).getTargetFeature(0)).getName() ,"and");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(2).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"C");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(3).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"A");
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
    Assert.assertEquals(((FeatureNode) featureModel.getFeaturelink(0).getTargetFeature(0)).getName() ,"and");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(1).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"B");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(2).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"A");
    //source --> opt C
    Assert.assertEquals(featureModel.getFeaturelink(3).getFeatureConnectingOpType().name(), "Optional");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(3).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"C");
    //source --> not D
    Assert.assertEquals(featureModel.getFeaturelink(4).getFeatureConnectingOpType().name(), "Exclude");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(4).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"D");
    //source --> (xor F E)
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(5).getSourceFeature()).getMixsetOrFileNode().isIsMixset(), false);
    Assert.assertEquals(featureModel.getFeaturelink(5).getFeatureConnectingOpType().name(), "XOR");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(6).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"F");
    Assert.assertEquals(((FeatureLeaf) featureModel.getFeaturelink(7).getTargetFeature(0)).getMixsetOrFileNode().getName() ,"E"); 
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

}
