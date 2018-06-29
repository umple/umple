package cruise.umple.compiler.mixset;

import org.junit.*;
import cruise.umple.compiler.*;
import cruise.umple.*;
import cruise.umple.compiler.Method.Source;
import cruise.umple.util.SampleFileWriter;

public class UmpleMixsetTest {
		String pathToInput;
    UmpleModel uModel;
    String defaultPath;

/*
  @Before
  public void setup() {

    defaultPath = SampleFileWriter.rationalize("test/cruise/umple/compiler/mixset/");
    String code = "class Outer_1{ } mixset M1 { class Inner_M1 {name;} } Outer_2{ }"
			+ " use M1;"
			+ " ";
    uModel = getRunModel(code);
  }
  @Test
  public void mixsetDetectionTest() {
		Assert.assertEquals(1, uModel.hasMixsetOrFiles());
	}
*/
	

  @After
  public void tearDown() {
    SampleFileWriter.destroy("mixsetTest.ump");
  }

	@Test
	public void mixsetUseInConsoleTest() {
		String[] args = new String[] {"mixsetTest1.ump", "Mx"};
		
		SampleFileWriter.createFile("mixsetTest1.ump", " class Outer_1{ } mixset Mx { class Inner_M1 {name;} } class Outer_2{ }");

		try {
			UmpleConsoleMain.main(args);
			SampleFileWriter.assertFileExists("Inner_M1.java");
		}	
		catch (Exception e) {
		} 
		finally {
		//	SampleFileWriter.destroy("mixsetTest.ump");
		}
/*


		try {
		//	UmpleModel m = new UmpleModel(null); m.run();
			UmpleInternalParser i;
			RuleBasedParser l;
			UmpleConsoleMain.main(args);
			//SampleFileWriter.assertFileExists("mixset/B.java");
		

		}
		finally {}
		
		//finally {
			//SampleFileWriter.assertFileExists("CCCInnerClass.java");

			//SampleFileWriter.destroy("mixsetTest.ump.ump");
			//SampleFileWriter.destroy();
			SampleFileWriter.destroy("mixset/B.java");
		//	System.exit(210618);

		//}
*/
	}


	// -------------------------------------------------------------------------------------
	// ----------------------- Functional methods for this test case
	// -----------------------
	private UmpleModel getRunModel(String inCode) {
		SampleFileWriter.createFile("mixsetTest.ump", inCode);
		UmpleFile uFile = new UmpleFile("mixsetTest.ump");
		uModel = new UmpleModel(uFile);
		uModel.setShouldGenerate(true);
		try {
			uModel.run();
		} catch (Exception e) {
		} finally {
			SampleFileWriter.destroy("mixsetTest.ump");
		}
		return uModel;
	}

}
