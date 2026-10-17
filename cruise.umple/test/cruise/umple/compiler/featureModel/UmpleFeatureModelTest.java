package cruise.umple.compiler.featureModel;

import org.junit.*;
import cruise.umple.UmpleConsoleMain;
import cruise.umple.compiler.UmpleParserTest;
import cruise.umple.util.SampleFileWriter;
import cruise.umple.parser.Position;
import cruise.umple.parser.ErrorMessage;
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

public class UmpleFeatureModelTest {
  
  UmpleParserTest umpleParserTest;
 
  @Before
  public void setUp()
  {
    umpleParserTest = new UmpleParserTest();
    umpleParserTest.pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler/mixset");
  }
  @Test
  public void GvfeatureDiagramConsoleNoWarnings()
  {

    String[] args = {"-generate","GvFeatureDiagram","GvFeatureConsoleTest.ump"} ;
    SampleFileWriter.createFile("GvFeatureConsoleTest.ump", "require [A and B or C]; mixset A {} mixset B {} use A, B;");
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
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_featureModel.ump");
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
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_featureModel.ump");//reuse ump file from parseReqStArgumetToFeaureModel()
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
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_NotValidXorFeatureModel.ump");
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
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_NotvalidSetFeatureModel.ump");
    Assert.assertEquals(false,featureModel.satisfyFeatureModel());
  }
  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_6()
  {
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_NotvalidBitWiseFeatuerModel.ump");
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
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_NotvalidCombinedOpWithRoundBracket.ump");
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
  public void parseReqStArgumetToSatisfyFeatureModel_cycleAllUsed()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_cycleAllUsed.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel = model.getFeatureModel();
    Assert.assertEquals(true, featureModel.satisfyFeatureModel());
  }

  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_cycleBehindUnused()
  {
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_cycleBehindUnused.ump");
    Assert.assertEquals(false, featureModel.satisfyFeatureModel());
  }

  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_cycleThreeNodes()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_cycleThreeNodes.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel = model.getFeatureModel();
    Assert.assertEquals(true, featureModel.satisfyFeatureModel());
  }

  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_cycleSelfLoop()
  {
    umpleParserTest.assertNoWarningsParse("reqStArgumentParse_cycleSelfLoop.ump");
    Assert.assertEquals(true, umpleParserTest.model.getFeatureModel().satisfyFeatureModel());
  }

  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_diamondSharedRequire()
  {
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_diamondSharedRequire.ump");
    Assert.assertEquals(false, featureModel.satisfyFeatureModel());
    // only X's require statement fails
    Assert.assertEquals(1, umpleParserTest.parser.getParseResult().numberOfErrorMessages());
    Assert.assertEquals(7, umpleParserTest.parser.getParseResult().getErrorMessage(0).getPosition().getLineNumber());
  }

  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_cycleXorOver()
  {
    FeatureModel featureModel = parseUnsatisfiedFeatureModel("reqStArgumentParse_cycleXorOver.ump");
    Assert.assertEquals(false, featureModel.satisfyFeatureModel());
    // only Root's require statement fails
    Assert.assertEquals(1, umpleParserTest.parser.getParseResult().numberOfErrorMessages());
    Assert.assertEquals(10, umpleParserTest.parser.getParseResult().getErrorMessage(0).getPosition().getLineNumber());
  }

  @Test
  public void parseReqStArgumetToSatisfyFeatureModel_cycleTwoDisjoint()
  {
    UmpleFile umpleFile = new UmpleFile(umpleParserTest.pathToInput,"reqStArgumentParse_cycleTwoDisjoint.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();
    FeatureModel featureModel = model.getFeatureModel();
    Assert.assertEquals(true, featureModel.satisfyFeatureModel());
  }

  @Test
  public void requireSubfeatureLeafTracksUseStatement()
  {
    UmpleFile umpleFile = new UmpleFile(
        umpleParserTest.pathToInput,
        "reqStArgumentParse_UseWithRequireSubfeature.ump");
    UmpleModel model = new UmpleModel(umpleFile);
    model.setShouldGenerate(false);
    model.run();

    FeatureModel featureModel = model.getFeatureModel();

    FeatureLeaf designALeaf = featureModel.getFeatureLeafNode("DesignA");
    Assert.assertNotNull("DesignA leaf must exist", designALeaf);
    Assert.assertNotNull("DesignA leaf must carry a MixsetOrFile",
        designALeaf.getMixsetOrFileNode());
    Assert.assertNotNull(
        "DesignA leaf's MixsetOrFile must reflect the `use DesignA;` statement",
        designALeaf.getMixsetOrFileNode().getUseUmpleFile());
    Assert.assertSame(
        "DesignA leaf must point to the canonical Mixset registered in the model",
        model.getMixset("DesignA"),
        designALeaf.getMixsetOrFileNode());

    FeatureLeaf designBLeaf = featureModel.getFeatureLeafNode("DesignB");
    Assert.assertNotNull("DesignB leaf must exist", designBLeaf);
    Assert.assertNotNull("DesignB leaf must carry a MixsetOrFile",
        designBLeaf.getMixsetOrFileNode());
    Assert.assertNull(
        "DesignB leaf must NOT be marked used (no `use DesignB;`)",
        designBLeaf.getMixsetOrFileNode().getUseUmpleFile());
    Assert.assertSame(
        "DesignB leaf must also point to the canonical Mixset registered in the model",
        model.getMixset("DesignB"),
        designBLeaf.getMixsetOrFileNode());
  }

  @Test
  public void unsatisfiedRequireStatementsInUsedMixsetsRaiseWarning1514()
  {
    umpleParserTest.parseWarnings("requireStatementNotSatisfied.ump");
    Assert.assertEquals(2, umpleParserTest.parser.getParseResult().numberOfErrorMessages());
    Assert.assertEquals(1514, umpleParserTest.parser.getParseResult().getErrorMessage(0).getErrorType().getErrorCode());
    Assert.assertEquals(2, umpleParserTest.parser.getParseResult().getErrorMessage(0).getPosition().getLineNumber());
    Assert.assertEquals(1514, umpleParserTest.parser.getParseResult().getErrorMessage(1).getErrorType().getErrorCode());
    Assert.assertEquals(7, umpleParserTest.parser.getParseResult().getErrorMessage(1).getPosition().getLineNumber());
  }

  @Test
  public void unsatisfiedRequireStatementAtFileLevelRaisesWarning1514()
  {
    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"requireStatementMissingUse.ump");
    umpleParserTest.assertHasWarningsParse(file.getFileName(), new Position(file.getFileName(),1,0,0), 1514);
  }

  @Test
  public void requireStatementOfUnusedMixsetIsNotChecked()
  {
    umpleParserTest.assertNoWarningsParse("requireStatementInUnusedMixset.ump");
  }

  @Test
  public void requireStatementWithSeveralConstraintsRaisesOneWarning()
  {
    UmpleFile file = new UmpleFile(umpleParserTest.pathToInput,"requireStatementWithSeveralConstraints.ump");
    umpleParserTest.assertHasWarningsParse(file.getFileName(), new Position(file.getFileName(),1,0,0), 1514);
    Assert.assertEquals(1, umpleParserTest.parser.getParseResult().numberOfErrorMessages());
  }

  // Parses a model whose use statements do not satisfy its feature model: the parse must succeed,
  // and warning 1514 must be the only kind of message raised.
  private FeatureModel parseUnsatisfiedFeatureModel(String fileName)
  {
    Assert.assertTrue(umpleParserTest.parseWarnings(fileName));
    for(ErrorMessage message : umpleParserTest.parser.getParseResult().getErrorMessages())
    {
      Assert.assertEquals(1514, message.getErrorType().getErrorCode());
    }
    return umpleParserTest.model.getFeatureModel();
  }

}
