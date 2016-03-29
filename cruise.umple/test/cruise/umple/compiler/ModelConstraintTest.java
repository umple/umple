package cruise.umple.compiler;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.parser.ErrorTypeSingleton;
import cruise.umple.parser.ParseResult;
import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.util.SampleFileWriter;

public class ModelConstraintTest {
	public UmpleParser parser;
	public UmpleModel model;
	public String pathToInput;
	public String umpleParserName;

	@Before
	public void setUp()
	{
		pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
		umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
	}

	@Test
	public void testFailingModels(){
		assertFailedParse("150_badAttributeNameConstrained.ump", 90);
		assertFailedParse("150_badAttributeClassConstrained.ump", 91);
		assertFailedParse("150_badSubClassConstrained.ump", 92);
		assertFailedParse("150_badMultiLayerSubClassConstrained.ump", 92);
		assertFailedParse("150_badSuperClassConstrained.ump", 93);
		assertFailedParse("150_badMultiLayerSuperClassConstrained.ump", 93);
		assertFailedParse("150_badAssociationToConstrained.ump", 94);
		assertFailedParse("150_badAssociationInvalidMultiplicityConstrained.ump", 94);
	}
	
	@Test
	public void testConstrainedAttributes(){
		Assert.assertEquals(true, parse("151_constrainedAttributeClassInModel.ump"));
		Assert.assertEquals(true, parse("151_constrainedAttributeNameInModel.ump"));

		Assert.assertEquals(true, parse("151_constrainedSubClassInModel.ump"));
		Assert.assertEquals(true, parse("151_constrainedSuperClassInModel.ump"));
		
		Assert.assertEquals(true, parse("151_constrainedAssociationInModel.ump"));
	}

	public boolean parse(String filename)
	{
		//String input = SampleFileWriter.readContent(new File(pathToInput, filename));
		File file = new File(pathToInput,filename);
		ErrorTypeSingleton.getInstance().reset();
		model = new UmpleModel(new UmpleFile(pathToInput,filename));
		model.setShouldGenerate(false);
		RuleBasedParser rbp = new RuleBasedParser();
		parser = new UmpleInternalParser(umpleParserName,model,rbp);
		ParseResult result = rbp.parse(file);
    model.extractAnalyzersFromParser(rbp);
		model.setLastResult(result);
		boolean answer = result.getWasSuccess();
		if (answer)
		{
			answer = parser.analyze(false).getWasSuccess();
		}
		System.out.println(parser.getModel().getLastResult());
		return answer;
	}
	public void assertFailedParse(String filename, int expectedError)
	{
		boolean answer = parse(filename);
		Assert.assertEquals(false, answer);
		Assert.assertEquals(expectedError, model.getLastResult().getErrorMessage(0).getErrorType().getErrorCode());
	}
}
