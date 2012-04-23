package cruise.umple.umplificator.core.generator.umple;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

import cruise.umple.compiler.*;
import cruise.umple.umplificator.core.analyzer.ContructorAnalyzer;
import cruise.umple.umplificator.core.analyzer.FieldAnalyzer;


public class JavaMetamodelConverter {
	
	private static Logger logger = Logger.getLogger(JavaMetamodelConverter.class);
	private List<Attribute> attributes = new ArrayList<Attribute>();
	public UmpleClass uClass;
	public StringBuffer extraCode = new StringBuffer();
	
	public UmpleClass getUmpleClassFromJavaClass(ICompilationUnit unit, int level){
		String className= unit.getElementName().substring(0, unit.getElementName().length()-5);
		uClass = new UmpleClass(className);	
		StringBuffer extraCode = new StringBuffer();
		if (level == 0 ) {
			setNamespace(unit);
			addDepends(unit);
			addExtendedClasses(unit);
			extraCode.append(addJavaFields(unit));
			extraCode.append(addJavaMethods(unit));
			uClass.setExtraCode(extraCode.toString());
			// Fix constructor and destructor
			logger.info("Umplification Level 0 successfully completed for class:" + className);
		}
		if (level == 1 ) {
			setNamespace(unit);
			addDepends(unit);
			addExtendedClasses(unit);
			addUmpleAttributes(unit);
		}
		return uClass;
	}

	public void addDepends(ICompilationUnit unit)
	{
		try 
		{
			IImportDeclaration[] imports = unit.getImports();
			for (int i=0; i < imports.length ; i ++){
				Depend aDepend=  new Depend(imports[i].getElementName());
				uClass.addDepend(aDepend);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	
	public String addJavaMethods(ICompilationUnit unit)
	{
		try 
		{
		String fileName = unit.getElementName();
		String javaClassName= fileName.substring(0,fileName.length()-5);
		StringBuffer methodContent = new StringBuffer();
		IType[] allTypes = unit.getAllTypes();
		for (IType type : allTypes) {
			IMethod[] methods = type.getMethods();
			for (IMethod method : methods) {
				// Don't add the method if it is a constructor or destructor
				if (!(isAConstructorOrDestructor(method, javaClassName))){
					Method uMethod= new Method("",method.getElementName(), method.getReturnType(),false);
					MethodBody body = new MethodBody(method.getSource());
					uMethod.setMethodBody(body);
					uClass.addMethod(uMethod);
					methodContent.append(method.getSource()+ "\n");
				}
			}
		}
		return methodContent.toString();
		} catch (JavaModelException e) {
			logger.error("Error adding java Methods " + e);
		}
		return null;
	}
	
	public String addJavaFields(ICompilationUnit unit)  {
		try 
		{
		StringBuffer content = new StringBuffer();
		IType[] allTypes = unit.getAllTypes();
		for (IType type : allTypes) {
			IField[] fields = type.getFields();
			for (IField field : fields) {
				content.append(field.getSource() + "\n");
			}
		}
		return content.toString();
		} catch (JavaModelException e) {
			logger.error("Error adding java Fields " +e);
		}
		return null;
	}
	
	public boolean isAConstructorOrDestructor(IMethod method, String javaClassName) 
	{
		int nb = method.getNumberOfParameters();
		if (method.getElementName().equals(javaClassName)) 
		{
			if (nb == 0 ){
				ContructorAnalyzer.handleEmptyConstructor(method, uClass);
				return true;
			}
			return false;
		}
		else if (method.getElementName().equals("delete"))
		{
			return true;
		}
		return false;
	}
	

	public void addExtendedClasses(ICompilationUnit unit)
	{
		String superclassName= new String();
		try {
			IType [] types = unit.getAllTypes();
			if (types.length > 0){
				IType type  = types[0];
				if (type != null){
					if (type.getSuperclassName() !=null){
						superclassName = type.getSuperclassName();
					}
				}
				if (superclassName.length() > 0){
					UmpleClass uParent = new  UmpleClass(superclassName);
					uClass.setExtendsClass(uParent);
				}
			}
		} catch (JavaModelException e) {
			logger.error("Error when resolving super class of " +unit.getElementName());
		}
	}

	
	public void setNamespace(ICompilationUnit unit)
	{
		IType type = unit.getType(unit.getElementName());
		if (type != null && type.getPackageFragment() != null){
			if (!(type.getPackageFragment().getElementName().isEmpty())){
			String namespace = type.getPackageFragment().getElementName();
			uClass.addNamespace(namespace);
			}
		}
	}
	
	
	public void addUmpleAttributes(ICompilationUnit unit){
		try {
			IType[] allTypes;
			allTypes = unit.getAllTypes();
			for (IType type : allTypes) {
				IField[] fields = type.getFields();
				for (IField field : fields) {
					Attribute attr = getUmpleAttributeFromJavaField(field);
					uClass.addAttribute(attr);
					attributes.add(attr);
				}
			}	
		} catch (JavaModelException e) {
			logger.error("Error adding Java Attributes" + e);
		}
	}

	public UmpleVariable getUmpleAttributeOrAssoc(IField field){
		if (FieldAnalyzer.isPrimitiveType(field)){
			return (Attribute)getUmpleAttributeFromJavaField(field);
		}
		else{
			return (AssociationVariable) getAssociationFromJavaField(field);
		}
	}
	
	public Attribute getUmpleAttributeFromJavaField(IField field){
		if (FieldAnalyzer.isPrimitiveType(field)){
			String name=field.getElementName();
			String type = FieldAnalyzer.getUmpleType(field);
			String value = FieldAnalyzer.getValue(field);
			boolean isAutonique = false;
			Attribute uAttribute  = new Attribute(name, type, "", value, isAutonique, null);
			return uAttribute;
		}
		else{
			return null;
		}
		
	}
	
	
	public AssociationVariable getAssociationFromJavaField(IField field){
		return null;		
	}

}
