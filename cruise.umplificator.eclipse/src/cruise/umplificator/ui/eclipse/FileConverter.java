package cruise.umplificator.ui.eclipse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

public class FileConverter {

	public static List<File> getFileFromCompilationUnit(
			ICompilationUnit compilationUnit) throws JavaModelException {
		List<File> files= new ArrayList<File>();
		IResource resource = compilationUnit.getUnderlyingResource();
		if (resource.getType() == IResource.FILE) {
			IFile ifile = (IFile) resource;
			files = FileConverter.getFileFromIFile(ifile);
		}

		return files;
	}

	public static List<File> getFilesFromPackageFragment(
			IPackageFragment packageFragment) throws JavaModelException {
		List<File> files= new ArrayList<File>();
		for (ICompilationUnit compilationUnit: packageFragment.getCompilationUnits())
		{
			files.addAll(FileConverter.getFileFromCompilationUnit(compilationUnit));
		}
		return files;
	}

	public static List<File> getFilesFromProject(IJavaProject javaProject) throws JavaModelException {
		List<File> files= new ArrayList<File>();
		for (IPackageFragment mypackage : javaProject.getPackageFragments()) {
			files.addAll(FileConverter.getFilesFromPackageFragment(mypackage));
		}
		return files;
	}

	public static List<File> getFileFromIFile(IFile aFile) {
		IPath location = aFile.getLocation();
		List<File> files= new ArrayList<File>();
		if (location != null)
		{
			files.add(location.toFile());
		}
		return files;
	}
}
