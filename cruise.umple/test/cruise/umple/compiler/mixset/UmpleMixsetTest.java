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

 
  		
}

