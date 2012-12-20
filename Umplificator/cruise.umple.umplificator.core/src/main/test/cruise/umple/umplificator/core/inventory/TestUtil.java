package cruise.umple.umplificator.core.inventory;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;

import cruise.umple.umplificator.core.util.JavaProjectSetupUtil;

public class TestUtil {

	public static String getJavaClassContents()  {
		
		StringBuilder sb = new StringBuilder();
		sb.append("package cruise;" + "\n");

		sb.append("import java.util.*;" + "\n");

		sb.append("public class TestClass{" + "\n");

		sb.append("int i;" + "\n");
		
		sb.append("public void doSomething(){ i=i++; }" + "\n");
		
		sb.append("}" + "\n");
		
		return sb.toString();
	}

	public static IJavaProject createJavaProjectWithRootSrc(String string) throws CoreException {
		IJavaProject project = JavaProjectSetupUtil.createJavaProject(string);
		JavaProjectSetupUtil.addProjectNature(project.getProject(), JavaProjectSetupUtil.NATURE_ID);
		JavaProjectSetupUtil.addSourceFolder(project, "src");
		return project;
	}

	public static IFolder addFolder(IJavaProject javaProject, String folderName) throws CoreException,
	JavaModelException {
		IProject project = javaProject.getProject();
		IFolder folder = JavaProjectSetupUtil.createSubFolder(project, folderName); 
		return folder;
	}

}
