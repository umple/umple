package cruise.umple.umplificator.core.inventory;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

/**
 * Class used to get all components of a Java Project
 * Uses JDT Framework
 * @author Miguel Garzon
 *
 */

public class JavaProjectInventory {
	
	private static Logger logger = Logger.getLogger(JavaProjectInventory.class);

	
	public static IPackageFragment [] getPackagesFromProject(IJavaProject jProject) {
		try {
			if (jProject != null){
				return jProject.getPackageFragments();
			}
			else {
				logger.error("Project is null");
				return null;
			}
		} catch (JavaModelException e) {
			logger.error("Problem retrieving packages of project " +jProject.getElementName());
			return null;
		}
	}


}
