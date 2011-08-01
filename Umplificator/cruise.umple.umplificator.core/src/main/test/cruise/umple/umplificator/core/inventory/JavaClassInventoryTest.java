package cruise.umple.umplificator.core.inventory;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.junit.*;
import org.apache.log4j.Logger;

public class JavaClassInventoryTest {

	ICompilationUnit cunit;
	private IJavaProject jProject;
	private static Logger logger = Logger.getLogger(JavaClassInventoryTest.class);

	@Before
	public void setUp(){
		try {
			jProject = TestUtil.createJavaProjectWithRootSrc("Test");
			for (IPackageFragmentRoot root : jProject.getPackageFragmentRoots()) {
				if (root.getElementName().equals("src")) {
					IPackageFragment pack= root.createPackageFragment("cruise", true, null);
					String content =  TestUtil.getJavaClassContents();
					cunit = pack.createCompilationUnit("TestClass.java",content, true, null);
				}
			}
		} catch (CoreException e) {
			logger.error(e);

		}
	}

	@Test
	public void testGetFields() throws CoreException{
		IField[] fields = JavaClassInventory.getFields(cunit);
		Assert.assertEquals(1, fields.length);
	}

	@Test
	public void testGetMethods() throws CoreException{
		IMethod[] methods = JavaClassInventory.getMethods(cunit);
		Assert.assertEquals(1, methods.length);
	}
	
	@Test
	public void testPackageName() throws CoreException{
		String packageName = JavaClassInventory.getPackageName(cunit);
		Assert.assertEquals("cruise", packageName);
	}

	@Test
	public void testImports() throws CoreException{
		String packageName = JavaClassInventory.getPackageName(cunit);
		Assert.assertEquals("cruise", packageName);
	}
	
}
