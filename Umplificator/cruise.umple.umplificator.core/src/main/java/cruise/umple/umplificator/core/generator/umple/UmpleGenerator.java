package cruise.umple.umplificator.core.generator.umple;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import cruise.umple.compiler.UmpleClass;
import cruise.umple.umplificator.core.analyzer.FieldAnalyzer;
import cruise.umple.umplificator.core.inventory.JavaPackageInventory;
import cruise.umple.umplificator.core.inventory.JavaProjectInventory;
import cruise.umple.umplificator.UmpleClassGenerator;


/**
 * Class used to umplify the components of a Java Class
 * Most of these methods return Strings
 * Uses JDT Framework
 * @author Miguel Garzon
 *
 */
public class UmpleGenerator {
	
	private static Logger logger = Logger.getLogger(UmpleGenerator.class);
	
	public static String translatePackageName(ICompilationUnit unit) throws JavaModelException {
		IType type = unit.getType(unit.getElementName());
		return "namespace " + type.getPackageFragment().getElementName() + ";";
	}
	
	public static String translateImports(ICompilationUnit unit) throws JavaModelException {
		IImportDeclaration[] imports = unit.getImports();
		StringBuffer importsBuffer = new StringBuffer();
		for (int i=0; i < imports.length ; i ++){
			importsBuffer.append("depend " + imports[i].getElementName() + ";" + "\n");
		}
		return importsBuffer.toString();
	} 
	

	public static String translateFields(ICompilationUnit unit) throws JavaModelException {
		IType[] allTypes = unit.getAllTypes();
		StringBuffer fieldsContent = new StringBuffer();
		for (IType type : allTypes) {
			IField[] fields = type.getFields();
			for (IField field : fields) {
				fieldsContent.append(translateFieldsToUmpleAttribute(field));
			}
		}
		return fieldsContent.toString();
	}
	
	public static String translateFieldsToUmpleAttribute(IField field) {
		String name ="";
		String type ="";	
		String value= "";
		if (FieldAnalyzer.isPrimitiveType(field))
		{
			name = field.getElementName();
			type = FieldAnalyzer.getUmpleType(field);
			if (FieldAnalyzer.hasValue(field)){
				value = " =";
				value += FieldAnalyzer.getValue(field);
			}
			return type + " " + name + value + ";" +  "\n";			
		}
		else{
			return "";
		}
	}
	
	public static String translateMethods(ICompilationUnit unit) throws JavaModelException {
		IType[] allTypes = unit.getAllTypes();
		StringBuffer methodContent = new StringBuffer();
		for (IType type : allTypes) {
			IMethod[] methods = type.getMethods();
			for (IMethod method : methods) {
				methodContent.append(method.getSource()+ "\n");
			}
		}
		return methodContent.toString();
	}
	
	public static void translateJavaClassesInPackage(IPackageFragment aPackage,int level) {
		ICompilationUnit [] units= JavaPackageInventory.getUnitsFromPackage(aPackage);
		for (ICompilationUnit unit: units){
			translateJavaClass(unit,level);
		}
		
	}
	
	public static void translateJavaClassesInProject(IJavaProject project, int level) {
		IPackageFragment [] packages = JavaProjectInventory.getPackagesFromProject(project);
		for (IPackageFragment aPackage: packages){
			translateJavaClassesInPackage(aPackage,level);
		}
	}
	
	public static void translateJavaClass(ICompilationUnit unit, int level){
	    JavaMetamodelConverter converter = new JavaMetamodelConverter();
	    UmpleClass uClass = converter.getUmpleClassFromJavaClass(unit, level);
	    UmpleClassGenerator generator = new UmpleClassGenerator();
		writeFile(unit, generator.getCode(null, uClass));
	}
	
/*	contents = new StringBuilder();
	contents.append(translatePackageName(unit)+ "\n");
	contents.append("\n");
	contents.append("class " + className +"{" + "\n");
	contents.append(translateImports(unit)+ "\n");
	contents.append(translateFields(unit)+ "\n");
	contents.append(translateMethods(unit)+ "\n");
	contents.append("}"+ "\n");*/
	
	
	public static void writeFile(ICompilationUnit unit, String contents){
		String className= unit.getElementName().substring(0, unit.getElementName().length()-5);
		String fileName= className + ".ump";
		try {
			String subFolderNames = unit.getType(unit.getElementName()).getPackageFragment().getElementName().replace(".", File.separator);
			String pathForUmpleFile = File.separator + "src/main/java" +  File.separator + subFolderNames +   File.separator + fileName; 
			IFile outputFile = unit.getJavaProject().getProject().getFile(pathForUmpleFile);
			InputStream source = new ByteArrayInputStream(contents.toString().getBytes());
			
			if (outputFile.exists()) {
				outputFile.setContents(source, false, false, null);
			} else {
				outputFile.create(source, true, null);
			}

		} catch (CoreException e) {
			logger.error(e);
		}
	}
}
