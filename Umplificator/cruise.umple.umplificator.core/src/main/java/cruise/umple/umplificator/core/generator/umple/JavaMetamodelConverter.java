package cruise.umple.umplificator.core.generator.umple;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;

import cruise.umple.compiler.*;
import cruise.umple.umplificator.core.analyzer.FieldAnalyzer;


public class JavaMetamodelConverter {
	
	private static Logger logger = Logger.getLogger(JavaMetamodelConverter.class);
	private List<Attribute> attributes = new ArrayList<Attribute>();
	public UmpleClass uClass;

	public UmpleClass getUmpleClassFromJavaClass(ICompilationUnit unit){
		String className= unit.getElementName().substring(0, unit.getElementName().length()-5);
		uClass = new UmpleClass(className);	
		setNamespace(unit);
		addExtendedClasses(unit);
		addUmpleAttributes(unit);
		return uClass;
	}

	public void addExtendedClasses(ICompilationUnit unit)
	{
		String superclass;
		try {
			IType [] types = unit.getAllTypes();
			superclass = types[0].getSuperclassName();
			if (superclass != null){
				UmpleClass uParent = new  UmpleClass(superclass);
				uClass.setExtendsClass(uParent);
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setNamespace(ICompilationUnit unit)
	{
		IType type = unit.getType(unit.getElementName());
		if (type != null && type.getPackageFragment() != null){
			if (type.getPackageFragment().getElementName() != null){
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
			logger.error(e);
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
			Attribute uAttribute  = new Attribute(name, type, "", value, isAutonique);
			return uAttribute;
		}
		else{
			return null;
		}
		
	}
	
	
	public AssociationVariable getAssociationFromJavaField(IField field){
		return null;		
	}
/*    isSingleton = false;
    associations = new ArrayList<Association>();
    key = new Key();
    codeInjections = new ArrayList<CodeInjection>();
    parentInterface = new ArrayList<UmpleInterface>();
    depends = new ArrayList<Depend>();
    methods = new ArrayList<Method>();
    constants = new ArrayList<Constant>();
    attributes = new ArrayList<Attribute>();
    associationVariables = new ArrayList<AssociationVariable>();
    traceItems = new ArrayList<TraceItem>();
    stateMachines = new ArrayList<StateMachine>();*/
}
