package cruise.compiler;

import org.junit.*;

public class ErrorInMainTests
{
	CompilerErrorUtil tester;
	
	@Before
	public void setUp() {
		tester = new CompilerErrorUtil();
	}
	
	@After
	public void tearDown() {
		
	}
	
	@Test
	public void MainErrorTest() {
		tester.AssertCompileError("Main_Error.ump", "Main_Error.txt");
	}
	
	@Test
	public void MainErrorTest2() {
		tester.AssertCompileError("Main_Error2.ump", "Main_Error2.txt");
	}
	
	@Test
	public void MainErrorTest3() {
		tester.AssertCompileError("Main_Error3.ump", "Main_Error3.txt");
	}
}
