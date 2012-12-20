package cruise.umple.umplificator.core.inventory;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

/**
 * Class used to get all components of a Java Project
 * Uses JDT Framework
 * @author Miguel Garzon
 *
 */

public class JavaPackageInventory {
	
	private static Logger logger = Logger.getLogger(JavaPackageInventory.class);

	public static ICompilationUnit[] getUnitsFromPackage(IPackageFragment aPackage) {
		try {
			if (aPackage != null){
				return aPackage.getCompilationUnits();
			}
			else {
				logger.error("Package is null");
				return null;
			}
		} catch (JavaModelException e) {
			logger.error("Problem retrieving classes of the package " +aPackage.getElementName());
			return null;
		}
	}


}
