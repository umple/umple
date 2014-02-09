package cruise.umple.compiler;

import org.junit.*;

import cruise.umple.compiler.UmpleParserTest;
import cruise.umple.util.SampleFileWriter;

public class ParserConstraintExpressionsTest extends UmpleParserTest {
	
	@Test
	public void canHandleDateConstraints() {
		assertParse("700_DateConstraint.ump");
	}
	
	@Test
	public void BasicConstraint2(){ // [agedfd > 12]
		assertHasWarningsParse("700_BasicConstraint2.ump",28);
	}
	
}
