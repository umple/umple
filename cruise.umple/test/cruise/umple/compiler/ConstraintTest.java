package cruise.umple.compiler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cruise.umple.util.SampleFileWriter;
import cruise.umple.util.StringFormatter;

public class ConstraintTest {

	UmpleModel model;
	UmpleClass uClass;
	ConstraintTree constraint;
	String inject = "";

	@Before
	public void setUp() {

		UmpleFile file = new UmpleFile(SampleFileWriter.rationalize("test/cruise/umple/compiler"),"700_BasicConstraint3.ump");
		model = new UmpleModel(file);
		model.setShouldGenerate(false);
		constraint = new ConstraintTree();
		uClass = new UmpleClass("Student", model);
		Attribute foo = new Attribute("foo","boolean","","true", false,uClass);
		constraint.addElement(new ConstraintAttribute(foo));
		inject = "bar";
	}

	@Test
	public void getCode_javaGen() {
		String expected = "if (getFoo())\n{\n  bar\n}";
		JavaGenerator gen = new JavaGenerator();
		gen.setModel(model);
		assertEquals(expected, StringFormatter.format(gen.translate("Closed",constraint),inject));
	}

	@Test
	public void getCode_rubyGen() {
		String expected = "if get_foo() then\n  bar\nend";
		RubyGenerator gen = new RubyGenerator();
		gen.setModel(model);
		assertEquals(expected, StringFormatter.format(gen.translate("Closed",constraint),inject));
	}

	@Test
	public void getCode_phpGen() {
		String expected = "if ($this->getFoo())\n{\n  bar\n}";
		PhpGenerator gen = new PhpGenerator();
		gen.setModel(model);
		assertEquals(expected, StringFormatter.format(gen.translate("Closed",constraint),inject));
	}

	@Test
	public void getCode_multipleExpressions() {
		ConstraintTree old = constraint;
		ConstraintTree constraint = new ConstraintTree();
		constraint.addElementAll(old.getRoot());
		JavaGenerator gen = new JavaGenerator();
		gen.setModel(model);
		constraint.addElement(new ConstraintOperator("=="));
		constraint.addElement(new ConstraintAttribute(new Attribute("fnord","boolean","","true",false, uClass)));

		String expected = "if (getFoo()==getFnord())\n{\n  bar\n}";
		assertEquals(expected, StringFormatter.format(gen.translate("Closed",constraint),inject));
	}

	@Test
	public void getCode_negateExpression() {
		ConstraintTree old = constraint;
		ConstraintTree constraint = new ConstraintTree();
		constraint.addElementAll(old);
		JavaGenerator gen = new JavaGenerator();
		gen.setModel(model);
		constraint.negate();

		String expected = "if (!getFoo())\n{\n  bar\n}";
		assertEquals(expected, StringFormatter.format(gen.translate("Closed",constraint),inject));
	}

	@Test
	public void getCode_emptyExpression() {
		ConstraintTree constraint = new ConstraintTree();
		constraint.addElement(new ConstraintTree());
		JavaGenerator gen = new JavaGenerator();
		gen.setModel(model);

		String expected = "if ()\n{\n  bar\n}";
		assertEquals(expected, StringFormatter.format(gen.translate("Closed",constraint),inject));
	}

	@Test
	public void getCode_emptyInject() {

		JavaGenerator gen = new JavaGenerator();
		gen.setModel(model);

		String expected = "if (getFoo())\n{\n  \n}";
		assertEquals(expected, StringFormatter.format(gen.translate("Closed",constraint),""));
	}
}
