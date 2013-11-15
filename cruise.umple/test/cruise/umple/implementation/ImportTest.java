/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.compiler.*;
import cruise.umple.compiler.java.*;
import cruise.umple.util.SampleFileWriter;

public class ImportTest {

	private String pathToInput;
	
	@Before
	  public void setUp()
	  {
	    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation");
	  }

	@After
	public void tearDown() {
		SampleFileWriter.destroy("ump1.txt");

		SampleFileWriter.destroy("example");

		SampleFileWriter.destroy(pathToInput + "/Person.java");
		SampleFileWriter.destroy(pathToInput + "/Player.java");
		SampleFileWriter.destroy(pathToInput + "/Goalie.java");
		SampleFileWriter.destroy(pathToInput + "/SadGoalie.java");
	}

	@Test
	public void Time() {
		SampleFileWriter
				.createFile("ump1.txt",
						"namespace example;\nclass HasTime { Time t; Time t2; }\nclass NoTime {}\n");

		UmpleModel model = runAndGenerateModelByUmpleFile("ump1.txt");
		JavaClassGenerator generator = new JavaClassGenerator();

		String code = getJavaCodeByClassName(model, generator, "HasTime");
		assertIfCodeOnlyContainsStatement(true, code, "import java.sql.Time;");

		code = getJavaCodeByClassName(model, generator, "NoTime");
		assertIfCodeContainsStatement(false, code, "import java.sql.Time;");

	}

	@Test
	public void Date() {
		SampleFileWriter
				.createFile("ump1.txt",
						"namespace example;\nclass HasDate { Date d; Date d2; }\nclass NoDate {}\n");

		UmpleModel model = runAndGenerateModelByUmpleFile("ump1.txt");
		JavaClassGenerator generator = new JavaClassGenerator();

		String code = getJavaCodeByClassName(model, generator, "HasDate");
		assertIfCodeOnlyContainsStatement(true, code, "import java.sql.Date;");

		code = getJavaCodeByClassName(model, generator, "NoDate");
		assertIfCodeContainsStatement(false, code, "import java.sql.Date;");
	}

	@Test
	public void ImportMultilevel() {

		UmpleModel model = runAndGenerateModelByUmpleFile(pathToInput
				+ "/ImportMultilevel.ump");
		JavaClassGenerator generator = new JavaClassGenerator();

		String code = getJavaCodeByClassName(model, generator, "Person");
		assertIfCodeOnlyContainsStatement(true, code, "import java.sql.Date;");

		code = getJavaCodeByClassName(model, generator, "Player");
		assertIfCodeOnlyContainsStatement(true, code, "import java.sql.Date;");

		code = getJavaCodeByClassName(model, generator, "Goalie");
		assertIfCodeOnlyContainsStatement(true, code, "import java.sql.Date;");
		assertIfCodeOnlyContainsStatement(true, code, "import java.sql.Time;");
		
		code = getJavaCodeByClassName(model, generator, "SadGoalie");
		assertIfCodeOnlyContainsStatement(true, code, "import java.sql.Date;");
		assertIfCodeOnlyContainsStatement(true, code, "import java.sql.Time;");
	}

	private static void assertIfCodeOnlyContainsStatement(boolean expected,
			String code, String importStatement) {
		Assert.assertEquals(expected, code.indexOf(importStatement) != -1);
		Assert.assertEquals(code.indexOf(importStatement),
				code.lastIndexOf(importStatement));
	}

	private static void assertIfCodeContainsStatement(boolean expected,
			String code, String importStatement) {
		Assert.assertEquals(expected, code.indexOf(importStatement) != -1);
	}

	private static UmpleModel runAndGenerateModelByUmpleFile(String filename) {
		UmpleFile file = new UmpleFile(filename);
		UmpleModel model = new UmpleModel(file);
		model.run();
		model.generate();
		return model;
	}

	private static String getJavaCodeByClassName(UmpleModel model,
			JavaClassGenerator generator, String className) {
		UmpleClass umpleClass = model.getUmpleClass(className);
		return generator.getCode(model, umpleClass);
	}
}

