package cruise.compiler;

import org.junit.*;

public class CompilerErrorOutputTests
{
	
	@Test
	public void MainTest() {
		CompilerErrorUtil.AssertCompileError("Main.ump", "Main.txt");
	}
	
	@Test
	public void MainTest2() {
		CompilerErrorUtil.AssertCompileError("Main2.ump", "Main2.txt");
	}
	
	@Test
	public void MainTest3() {
		CompilerErrorUtil.AssertCompileError("Main3.ump", "Main3.txt");
	}
	
	@Test
	public void BeforeTest() {
		CompilerErrorUtil.AssertCompileError("Before.ump", "Before.txt");
	}
	
	@Test
	public void AfterTest() {
		CompilerErrorUtil.AssertCompileError("After.ump", "After.txt");
	}
	
	@Test
	public void BeforeCustomTest() {
		CompilerErrorUtil.AssertCompileError("Before_Custom.ump", "Before_Custom.txt");
	}
	
	@Test
	public void AfterCustomTest() {
		CompilerErrorUtil.AssertCompileError("After_Custom.ump", "After_Custom.txt");
	}
	
	@Test
	public void BeforeAfterCustomTest() {
		CompilerErrorUtil.AssertCompileError("Before_After_Custom.ump", "Before_After_Custom.txt");
	}
	
	@Ignore @Test
	public void MultipleClassesTest() {
		CompilerErrorUtil.AssertCompileError("Multiple_Classes.ump", "Multiple_Classes.txt");
	}
	
	@Test
	public void ConstructorTest() {
		CompilerErrorUtil.AssertCompileError("Constructor.ump", "Constructor.txt");
	}
	
	@Test
	public void OneLineTest() {
		CompilerErrorUtil.AssertCompileError("One_Line.ump", "One_Line.txt");
	}
	
	@Test
	public void StaticMethodTest() {
		CompilerErrorUtil.AssertCompileError("Static_Method.ump", "Static_Method.txt");
	}
	
	@Test
	public void ProtectedMethodTest() {
		CompilerErrorUtil.AssertCompileError("Protected_Method.ump", "Protected_Method.txt");
	}
	
	@Test
	public void NoModifierMethodTest() {
		CompilerErrorUtil.AssertCompileError("No_Modifier_Method.ump", "No_Modifier_Method.txt");
	}
	
	@Test
	public void AbstractMethodTest() {
		CompilerErrorUtil.AssertCompileError("Abstract_Method.ump", "Abstract_Method.txt");
	}
	
	@Test
	public void StateMachineTest() {
		CompilerErrorUtil.AssertCompileError("State_Machine.ump", "State_Machine.txt");
	}
	
	@Ignore @Test
	public void TraitTest() {
		CompilerErrorUtil.AssertCompileError("Trait.ump", "Trait.txt");
	}
	
	@Ignore @Test
	public void PrivateMemberClasses() {
		CompilerErrorUtil.AssertCompileError("Private_Member_Classes.ump", "Private_Member_Classes.txt");
	}
	
	@Test
	public void MismatchedBracketsTest() {
		CompilerErrorUtil.AssertCompileError("Mismatched_Brackets_Method.ump", "Mismatched_Brackets_Method.txt");
	}
}