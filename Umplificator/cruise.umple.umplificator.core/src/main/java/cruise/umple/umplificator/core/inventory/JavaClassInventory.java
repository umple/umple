package cruise.umple.umplificator.core.inventory;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

/**
 * Class used to get all components of a Java Class
 * Uses JDT Framework
 * @author Miguel Garzon
 *
 */

public class JavaClassInventory {
	
	private static Logger logger = Logger.getLogger(JavaClassInventory.class);

	public static IMethod[] getMethods(ICompilationUnit unit)
	{ 
		try{
			IType[] allTypes = unit.getAllTypes();
			IMethod[] methods = null;
			for (IType type : allTypes) {
				methods = type.getMethods();
			}
			return methods;
		} catch (JavaModelException e) {
			logger.error("Problem retrieving methods of Java Class " +unit.getElementName());
			return null;
		}
	}
	
	
	public static IField[] getFields(ICompilationUnit unit)
	{
		try{
			IType[] allTypes = unit.getAllTypes();
			IField[] fields = null;
			for (IType type : allTypes) {
				fields = type.getFields();
			}
			return fields;
		} catch (JavaModelException e) {
			logger.error("Problem retrieving fields of Java Class " +unit.getElementName());
			return null;
		}
	}
	
	public static String getPackageName(ICompilationUnit unit){
		IType type = unit.getType(unit.getElementName());
		return  type.getPackageFragment().getElementName();
	}
	
	
	public IImportDeclaration[] getImports(ICompilationUnit unit){
		IImportDeclaration[] imports;
		try {
			imports = unit.getImports();
			return imports;	
		} catch (JavaModelException e) {
			logger.error("Problem retrieving the imports of Java Class " +unit.getElementName());
			return null;
		}
	}
	
}
