package cruise.umple.umplificator.core.generator.umple;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

public  class FileGenerator {

	public final static String UMPLE_SRC_FOLDER = "srcUmple";
	
    public static IFolder createSubFolder(IProject project, String folderName) throws CoreException {
        IFolder folder = project.getFolder(folderName);
        if (folder.exists()==false) {
                folder.create(true, true, null);
        }
        return folder;
    }
	
	
	public static boolean writeFile(ICompilationUnit unit, String contents){
		String javaFileName = unit.getElementName();
		try {
		    // Used if we want to generate in the same folder
			//String pathForUmpleFile = getPathForUmpleFile(javaFileName, unit) ;
			IProject project  = unit.getJavaProject().getProject();
			IFolder umpleFolder = createSubFolder(project, UMPLE_SRC_FOLDER);
			IFile outputFile = umpleFolder.getFile(getGeneratedFileName(javaFileName));
			InputStream source = new ByteArrayInputStream(contents.toString().getBytes());
			
			if (outputFile.exists()) {
				outputFile.setContents(source, false, false, null);
			} else {
				outputFile.create(source, true, null);
			}
			
			return true;
		} catch (CoreException e) {
			return false;
		}
	}
	
	
	// USED IF WE WANT TO HAVE UMPLE FILES IN THE SAME FOLDERS AS JAVA FILES
    private static String getPathForUmpleFile(String javaFileName, ICompilationUnit unit) {
        //Remove Extension
    	IType sourceType = unit.getType(javaFileName);
    	String sourceFolderNames = getSourceFolderNames(unit);
    	String subFolderNames = sourceType.getPackageFragment().getElementName().replace(".", File.separator);
    	return sourceFolderNames +  File.separator + subFolderNames +   File.separator + getGeneratedFileName(javaFileName);
    }

    private static String getSourceFolderNames(ICompilationUnit unit)
    {
    	String sourceFolders = "";
    	IJavaProject javaProject = unit.getJavaProject();
    	List<IPath> paths = getSourceFolders(javaProject);
    	for (IPath path: paths){
    		if (path != null){
    			sourceFolders= path.toOSString();
    		}
    	}
    	
    	return sourceFolders;
    }
    
    public static List<IPath> getSourceFolders(IJavaProject project)  {
        List<IPath> paths = new ArrayList<IPath>();

        try {
			for (IClasspathEntry cpe : project.getRawClasspath()) {
			    if (cpe.getEntryKind() == IClasspathEntry.CPE_SOURCE)
			    	paths.add(cpe.getPath());
			}
		} catch (JavaModelException e) {
			
		}
        
        return paths;
    }
	
    private static String getGeneratedFileName(String javaFileName) {
        //Get Folders of Java File 
        javaFileName = javaFileName.substring(0,javaFileName.length()-5);
        return javaFileName + ".ump";
    }

    
    
}
