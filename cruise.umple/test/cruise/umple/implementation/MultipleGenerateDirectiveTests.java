package cruise.umple.implementation;

import java.io.File;

import org.junit.Test;

import cruise.umple.compiler.GenerateTarget;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.util.SampleFileWriter;

public class MultipleGenerateDirectiveTests extends TemplateTest {
	
	@Test
	public void testConstraintJavaRubyPhp() {
		UmpleModel model = createUmpleSystem(pathToInput, "javaRubyPHPConstraint.ump");
		
		File javaOutput = new File(pathToInput, "Range.java");
		File rubyOutput = new File(pathToInput, "range.rb");
		File phpOutput = new File(pathToInput, "Range.php");
		
		//In case the test fails.
		javaOutput.deleteOnExit();
		rubyOutput.deleteOnExit();
		phpOutput.deleteOnExit();
		
		model.generate();
		
		
		SampleFileWriter.assertFileContent(new File(pathToInput, "/java/javaRubyPHPConstraint.java.txt"), javaOutput, false);
		SampleFileWriter.assertFileContent(new File(pathToInput, "/ruby/javaRubyPHPConstraint.ruby.txt"), rubyOutput, false);
		SampleFileWriter.assertFileContent(new File(pathToInput, "/php/javaRubyPHPConstraint.php.txt"), phpOutput, false);

		
		javaOutput.delete();
		rubyOutput.delete();
		phpOutput.delete();
	}
	
	@Test
	public void testConstraintPhpJavaRuby() {
		UmpleModel model = createUmpleSystem(pathToInput, "phpJavaRubyConstraint.ump");
		
		File javaOutput = new File(pathToInput, "Range.java");
		File rubyOutput = new File(pathToInput, "range.rb");
		File phpOutput = new File(pathToInput, "Range.php");
		
		//In case the test fails.
		javaOutput.deleteOnExit();
		rubyOutput.deleteOnExit();
		phpOutput.deleteOnExit();
		
		model.generate();
		
		
		SampleFileWriter.assertFileContent(new File(pathToInput, "/java/phpJavaRubyConstraint.java.txt"), javaOutput, false);
		SampleFileWriter.assertFileContent(new File(pathToInput, "/ruby/phpJavaRubyConstraint.ruby.txt"), rubyOutput, false);
		SampleFileWriter.assertFileContent(new File(pathToInput, "/php/phpJavaRubyConstraint.php.txt"), phpOutput, false);

		
		javaOutput.delete();
		rubyOutput.delete();
		phpOutput.delete();
	}
	
}
