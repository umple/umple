package cruise.compiler;

import org.junit.*;
import java.lang.ProcessBuilder;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CompilerErrorUtil
{
	static String UMPLE_ROOT = "../";
	static String SOURCE_FOLDER = (UMPLE_ROOT + "testbed/test/cruise/compiler/src/").replace("/", File.separator);
	static String EXPECTED_FOLDER = (UMPLE_ROOT + "testbed/test/cruise/compiler/expected/").replace("/", File.separator);
	static String UMPLE_JAR = (UMPLE_ROOT + "dist/umple.jar").replace("/", File.separator);
	
	public static void AssertCompileError(String umpleFile, String expectedOutputFile) {
		// Construct a sub-process to build the umple file and compile the resulting Java
		ProcessBuilder pb = new ProcessBuilder("java", "-jar", UMPLE_JAR, "-c-", SOURCE_FOLDER + umpleFile);
		try {
			Process p = pb.start();
			
			BufferedReader actualReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			BufferedReader expectedReader = new BufferedReader(new FileReader(Paths.get(EXPECTED_FOLDER + expectedOutputFile).toFile()));
			
			CompareCompiledOutputToExpected(actualReader, expectedReader);
			
			actualReader.close();
			expectedReader.close();
		}
		catch(Exception e) {
			Assert.fail(""+e.getMessage()+
			  " Current Dir . =" +Paths.get(".").toAbsolutePath().normalize().toString()+
			  " Parent Dir .. =" + Paths.get("..").toAbsolutePath().normalize().toString());
		}
	}
	
	public static void CompareCompiledOutputToExpected(BufferedReader actualReader, BufferedReader expectedReader) throws Exception{
		String error = actualReader.readLine();
		String expected = expectedReader.readLine();
		int line = 0;
		while (error != null && expected != null) {
			line++;
			Assert.assertEquals("Failed at: " + line, expected.trim(), error.trim());
			error = actualReader.readLine();
			expected = expectedReader.readLine();
		}
		Assert.assertNull("Actual output contains additional lines", error);
		Assert.assertNull("Expected output contains additional lines", expected);
	}
}
