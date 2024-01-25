package cruise.umple.compiler.featureModel;

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
 
}
 