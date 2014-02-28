package cruise.umple.compiler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConstraintTest {

	Constraint constraint;
	
	@Before
	public void setUp() {
	  constraint = new Constraint();
    constraint.addExpression(new ConstraintVariable("ATTRIBUTE","foo"));
		constraint.setInject("bar");
	}
	
	@Test
	public void getCode_javaGen() {
	  constraint.setGen(new JavaGenerator());
		
		String expected = "if (foo)\n{\n  bar\n}";
		assertEquals(expected, constraint.getCode());
	}
	
	@Test
	public void getCode_rubyGen() {
	  constraint.setGen(new RubyGenerator());
	  
	  String expected = "if @foo then\n  bar\nend";
	  assertEquals(expected, constraint.getCode());
	}
	
  @Test
  public void getCode_phpGen() {
    constraint.setGen(new PhpGenerator());
    
    String expected = "if ($foo)\n{\n  bar\n}";
    assertEquals(expected, constraint.getCode());
  }
  
  @Test
  public void getCode_multipleExpressions() {
    constraint.setGen(new JavaGenerator());
    constraint.addExpression(new ConstraintVariable("OPERATOR", "=="));
    constraint.addExpression(new ConstraintVariable("ATTRIBUTE", "fnord"));

    String expected = "if (foo==fnord)\n{\n  bar\n}";
    assertEquals(expected, constraint.getCode());
  }
  
  @Test
  public void getCode_negateExpression() {
    constraint.setGen(new JavaGenerator());
    constraint.setNegated(true);

    String expected = "if ( !(foo))\n{\n  bar\n}";
    assertEquals(expected, constraint.getCode());
  }
  
  @Test
  public void getCode_emptyExpression() {
    constraint.setGen(new JavaGenerator());
    constraint.removeExpression(new ConstraintVariable("ATTRIBUTE", "foo"));

    String expected = "if ()\n{\n  bar\n}";
    assertEquals(expected, constraint.getCode());
  }
  
  @Test
  public void getCode_emptyInject() {
    constraint.setGen(new JavaGenerator());
    constraint.setInject("");

    String expected = "if (foo)\n{\n  \n}";
    assertEquals(expected, constraint.getCode());
  }
}
