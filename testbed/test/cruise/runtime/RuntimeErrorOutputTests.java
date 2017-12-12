package cruise.runtime;

import org.junit.*;

public class RuntimeErrorOutputTests
{
	
	@Test
	public void InMain() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("InMain", "InMain.txt");
	}
	
	@Test
	public void Before() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("Before", "Before.txt");
	}
	
	@Test
	public void BeforeAfter() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("BeforeAfter", "BeforeAfter.txt");
	}
	
	@Ignore @Test
	public void BeforeAfterCustomInOriginal() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("BeforeAfterCustomInOriginal", "BeforeAfterCustomInOriginal.txt");
	}
	
	@Test
	public void BeforeCustomInOriginal() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("BeforeCustomInOriginal", "BeforeCustomInOriginal.txt");
	}
	
	@Test
	public void InAfterCustom() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("InAfterCustom", "InAfterCustom.txt");
	}
	
	@Test
	public void InAfterCustomMultipleReturns() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("InAfterCustomMultipleReturns", "InAfterCustomMultipleReturns.txt");
	}
	
	@Test
	public void SameFunctionFirst() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("SameFunctionFirst", "SameFunctionFirst.txt");
	}
	
	@Test
	public void SameFunctionMiddle() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("SameFunctionMiddle", "SameFunctionMiddle.txt");
	}
	
	@Test
	public void FuncitonWithException() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("FunctionWithException", "FunctionWithException.txt");
	}
	
	@Ignore @Test
	public void ExtendsClassExternal() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("ExtendsClassExternal", "ExtendsClassExternal.txt");
	}
	
	@Test
	public void ExtendsClassUse() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("ExtendsClassUse", "ExtendsClassUse.txt");
	}
	
	@Test
	public void ExtendsClassOneFile() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("ExtendsClassOneFile", "ExtendsClassOneFile.txt");
	}
	
	@Test
	public void IsATrait() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("IsATrait", "IsATrait.txt");
	}
	
	@Test
	public void StateMachineDo() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("StateMachineDo", "StateMachineDo.txt");
	}
	
	@Test
	public void StateMachineEntry() throws Exception {
		RuntimeErrorUtil.AssertRuntimeError("StateMachineEntry", "StateMachineEntry.txt");
	}
}