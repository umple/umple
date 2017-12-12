package cruise.runtime;

import org.junit.*;
import java.lang.ProcessBuilder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class RuntimeErrorUtil
{
	static String UMPLE_ROOT = "../";
	static String SOURCE_FOLDER = (UMPLE_ROOT + "testbed/bin/").replaceAll("/", File.separator);
	static String EXPECTED_FOLDER = (UMPLE_ROOT + "testbed/test/cruise/runtime/expected/").replaceAll("/", File.separator);
	static String PACKAGE_NAME = "cruise.runtime.";

	public static void AssertRuntimeError(String javaClass, String expectedOutputFile) {
		// Construct a sub-process to run the generated java file
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", SOURCE_FOLDER, PACKAGE_NAME + javaClass);
		try {
			Process p = pb.start();
			
			BufferedReader actualReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			BufferedReader expectedReader = new BufferedReader(new FileReader(Paths.get(EXPECTED_FOLDER + expectedOutputFile).toFile()));
			
			CompareOutputToExpected(actualReader, expectedReader);
			
			actualReader.close();
			expectedReader.close();
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	public static void CompareOutputToExpected(BufferedReader actualReader, BufferedReader expectedReader) throws Exception{
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
