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
		assertFailedParse("700_BasicConstraint2.ump",28);
	}
	
	@Test
	public void ConstraintDataType() {
		assertParse("700_ConstraintDataType1.ump");
		assertFailedParse("700_ConstraintDataType2.ump",29);
		assertFailedParse("700_ConstraintDataType3.ump",29);
		assertFailedParse("700_ConstraintDataType4.ump",29);
		assertFailedParse("700_ConstraintDataType5.ump",29);
		assertFailedParse("700_ConstraintDataType6.ump",29);
		assertFailedParse("700_ConstraintDataType7.ump",29);
		assertFailedParse("700_ConstraintDataType8.ump",29);
	}
}
