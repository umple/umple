package cruise.umple.umplificator.core.generator.umple;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleInterface;
import cruise.umple.umplificator.core.inventory.JavaPackageInventory;
import cruise.umple.umplificator.core.inventory.JavaProjectInventory;
import cruise.umple.umplificator.UmpleClassGenerator;
import cruise.umple.umplificator.UmpleInterfaceGenerator;

/**
 * Class used to umplify the components of a Java Class
 * Most of these methods return Strings
 * Uses JDT Framework
 * @author Miguel Garzon
 *
 */
public class UmpleGenerator {

	private static Logger logger = Logger.getLogger(UmpleGenerator.class);
	
	public static void translateJavaElementsInPackage(IPackageFragment aPackage,int level) {
		ICompilationUnit [] units= JavaPackageInventory.getUnitsFromPackage(aPackage);
		List<String> processedJavaFiles = new ArrayList<String>();
		for (ICompilationUnit unit: units){
			translateJavaElement(unit,level);
			processedJavaFiles.add(FileGenerator.getGeneratedFileName(unit.getElementName()));
		}
			generateMasterUmpleFileForPackage(aPackage,processedJavaFiles);	
	}
	
	public static void translateJavaElementsInProject(IJavaProject project, int level) throws JavaModelException {
		IPackageFragment [] packages = JavaProjectInventory.getPackagesFromProject(project);
		List<String> processedJavaPackages = new ArrayList<String>();
		for (IPackageFragment aPackage: packages){
			if (aPackage.getCompilationUnits().length > 0){
				translateJavaElementsInPackage(aPackage,level);
				processedJavaPackages.add("Master_" + aPackage.getElementName() + ".ump");
			}
		}
		generateMasterUmpleFileForProject(project.getProject(),processedJavaPackages);	
	}
	
	public static void 	generateMasterUmpleFileForProject(IProject project,List<String> processedJavaPackages ){
		String masterFileName = "Master_" + project.getName() + ".ump";
		FileGenerator.writeMasterFile(getUseStatements(processedJavaPackages),project,masterFileName);
	} 
	
	public static void 	generateMasterUmpleFileForPackage(IPackageFragment aPackage,List<String> processedJavaFiles){
		String masterFileName = "Master_" + aPackage.getElementName() + ".ump";
		FileGenerator.writeMasterFile(getUseStatements(processedJavaFiles),aPackage.getJavaProject().getProject(),masterFileName);	
	} 
	
	public static String getUseStatements(List<String> processedElements ){
		StringBuffer sb =  new StringBuffer();
		for (String s: processedElements)
		{
			sb.append("use " + s + ";" );
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}
	
	public static void translateJavaElement(ICompilationUnit unit, int level){
		try {
			String type = unit.getSource();
			boolean isInterface= type.contains("public interface") || type.contains("interface");
			if (isInterface){
				translateJavaInterface(unit, level);
			}
			else
			{
				translateJavaClass(unit, level);
			}
		} catch (JavaModelException e) {
			logger.error("Error determining whether compilation unit is a class or interface");
		}
	}

	public static void translateJavaInterface(ICompilationUnit unit, int level){
	    JavaMetamodelConverter converter = new JavaMetamodelConverter();
	    UmpleInterface uInterface = converter.getUmpleInterfaceFromJavaInterface(unit, level);
	    UmpleInterfaceGenerator generator = new UmpleInterfaceGenerator();
		writeFile(unit, generator.getCode(null, uInterface));
	}
	
	public static void translateJavaClass(ICompilationUnit unit, int level){
		JavaMetamodelConverter converter = new JavaMetamodelConverter();
		UmpleClass uClass = converter.getUmpleClassFromJavaClass(unit, level);
		UmpleClassGenerator generator = new UmpleClassGenerator();
		writeFile(unit, generator.getCode(null, uClass));
	}
	
	
	public static void writeFile(ICompilationUnit unit, String contents){
		boolean result = false;
		result = FileGenerator.writeFile(unit, contents);
		
		if (result){
			logger.info("Umple File created successfully");
		}
		else {
			logger.error("Error when creating Umple File");
		}
	}
}
