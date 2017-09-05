/*******************************************************************************
* Copyright (c) 2013 Ahmed M.Orabi, Mahmoud M.Orabi.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Ahmed M.Orabi
*     Mahmoud M.Orabi
*
* Please refer to the code authors before making any changes. 
* For any code reuse or copy, contact the authors and it is a MUST 
* to refer author names.
*
* @author -Ahmed M.Orabi {@link ahmedvc@hotmail.com}
* @author Mahmoud M.Orabi {@link mahmoud_3rabi@hotmail.com}
*******************************************************************************/
package cruise.umple.modeling.handlers;

import java.util.ArrayList;
import java.util.List;

import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationLoopAnnotation;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.Generator;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.gen.GenBody;
import cruise.umple.cpp.gen.GenClass;
import cruise.umple.cpp.gen.GenComment;
import cruise.umple.cpp.gen.GenDeleteMethod;
import cruise.umple.cpp.gen.GenEqualityMethod;
import cruise.umple.cpp.gen.GenGroup;
import cruise.umple.cpp.gen.GenInterface;
import cruise.umple.cpp.gen.GenMethod;
import cruise.umple.cpp.gen.GenMethodParameter;
import cruise.umple.cpp.gen.GenPackage;
import cruise.umple.cpp.gen.GenPriorities;
import cruise.umple.cpp.gen.Visibilities;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;


public class ModelingBaseGenerationPointsHandler {

	@GenerationLoopAnnotation(id = IModelingElementDefinitions.CLASSES_PROCESSOR)
	public static List<?> getClasses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object model){
		return generationValueGetter.getList(model, IModelingElementDefinitions.CLASSES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.INTERFACES_PROCESSOR)
	public static List<?> getInterfaces(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object model){
		return generationValueGetter.getList(model, IModelingElementDefinitions.INTERFACES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.ASSOCIATION_VARIABLES_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getAssociationVariables(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.ASSOCIATION_VARIABLES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getNavigableAssociationVariables(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.ATTRIBUTES_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getAttributes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.ATTRIBUTES);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.OPERATIONS_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getOperations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.OPERATIONS);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.DEPENDS_PROCESSOR, 
			processes= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR})
	public static List<?> getDepends(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object classInterface){
		return generationValueGetter.getList(classInterface, IModelingElementDefinitions.DEPENDS);
	}
	
	@GenerationLoopAnnotation(id = IModelingElementDefinitions.OPERATIONS_PARAMETERS_PROCESSOR, 
			processes= {IModelingElementDefinitions.OPERATIONS_PROCESSOR})
	public static List<?> getOperationsParameters(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
									 @GenerationBaseElement Object operationObject){
		return generationValueGetter.getList(operationObject, IModelingElementDefinitions.OPERATION_PARAMETERS);
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.INITIAL, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void trackAllTypes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAMESPACE) String namespace,
			@GenerationLoopElement Object modelPackage){
		generationValueGetter.addUniqueValue(IModelingConstants.TYPES_TRACKER, element, modelPackage, name);	//Enable Retrieving by name
		generationValueGetter.addUniqueValue(IModelingConstants.TYPES_BY_NAMESPACES_TRACKER, element, modelPackage, namespace);	//Enable Retrieving by name
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void trackNamespaces(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAMESPACE) String namespace,
			@GenerationLoopElement Object modelPackage){
		
		if(namespace!=null&& !namespace.isEmpty()){
			generationValueGetter.addUniqueValue(IModelingConstants.NAMESPACES_TRACKER, namespace, modelPackage);	//Track all namespaces
		}
	}
	
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.INITIAL)
	public static void classInterfaceParentTypesProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element){
		generationValueGetter.rootModel.setVersion(generationValueGetter.getString(element, IModelingElementDefinitions.VERSION_NUMBER));
		
		String directory = generationValueGetter.getString(element, IModelingElementDefinitions.GENERATES, IModelingElementDefinitions.CPP_GENERATION_ID);
		if(directory!= null){
			generationValueGetter.rootModel.setDirectory(directory);
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL)
	public static void registerClasses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		String namespace = generationValueGetter.getString(element, IModelingElementDefinitions.NAMESPACE);
		
		GenPackage packageByName = namespace.isEmpty()? generationValueGetter.rootModel:generationValueGetter.rootModel.packageByName(namespace);
		if(packageByName== null){
			packageByName= new GenPackage();
			packageByName.setName(namespace);
			generationValueGetter.rootModel.addChild(packageByName);
		}
		
		GenClass genClass= new GenClass();
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		genClass.setName(name);
		genClass.setSingleton(generationValueGetter.getBoolean(parent, IModelingElementDefinitions.IS_SINGLETON));
		
		packageByName.addClass(genClass);
//		boolean isAbstract= generationValueGetter.getBoolean(element, IModelingElementDefinitions.IS_ABSTRACT);
//		if(isAbstract){
//			genClass.setIsAbstract(isAbstract);
//		}
//		List<?> operations = generationValueGetter.getList(element, IModelingElementDefinitions.OPERATIONS);
//		boolean shallContinue= true;
//		int index= 0;
//		while(index<operations.size()&& shallContinue){
//			Object operation = operations.get(index++);
//			boolean _isAbstract= generationValueGetter.getBoolean(operation, IModelingElementDefinitions.IS_ABSTRACT);
//			if(_isAbstract){
//				genClass.setIsAbstract(_isAbstract);
//				shallContinue= false;
//			}
//		}
		genClass.setIsAbstract(generationValueGetter.getBoolean(element, IModelingElementDefinitions.IS_ABSTRACT));
		
		GenMethod hashcode = hashCodeMethod(genClass);
		genClass.addMethod(hashcode);
		
		createEqualityMethods(genClass);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL+1)
	public static void setRemote(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		genClass.setIsRemote(generationValueGetter.getBoolean(element, IModelingElementDefinitions.IS_DISTRIBUTABLE));
	}

	private static void createEqualityMethods(GenClass genClass) {
		String name= genClass.getName();
		
		GenMethod equalityOperator= new GenEqualityMethod();
		equalityOperator.setName("operator == ");
		equalityOperator.setDisableRemote(true);
		equalityOperator.setIsOperator(true);
		setEqualityDefaultSignature(equalityOperator);
		addLeftRightParameters(name, equalityOperator);
		genClass.addMethod(equalityOperator);
		
		GenMethod inequalityOperator= new GenMethod();
		inequalityOperator.setName("operator != ");
		inequalityOperator.setIsHeader(true);
		inequalityOperator.setDisableRemote(true);
		inequalityOperator.setIsOperator(true);
		addLeftRightParameters(name, inequalityOperator);
		inequalityOperator.addBody(new GenBody("return !( Right == Left);"));
		setEqualityDefaultSignature(inequalityOperator);
		genClass.addMethod(inequalityOperator);
		
		addShortEqualityOperator(genClass, "operator == ", "return this == &Right;");
		addShortEqualityOperator(genClass, "operator != ", "return this != &Right;");
	}

	private static void addShortEqualityOperator(GenClass genClass, String operator, String body) {
		String name= genClass.getName();
		GenMethod equalityOperatorShort= new GenMethod();
		equalityOperatorShort.setName(operator);
		equalityOperatorShort.setIsConstant(true);
		equalityOperatorShort.setIsHeader(true);
		equalityOperatorShort.addBody(new GenBody(body));
		equalityOperatorShort.setExternalDefinition("");
		equalityOperatorShort.setVisibility(Visibilities.PUBLIC);
		equalityOperatorShort.setReturnType(CPPTypesConstants.BOOL);
		equalityOperatorShort.setGroup(new GenGroup(GenClass.PREDEFINED_OPERATOR_GROUP));
		equalityOperatorShort.setDisableRemote(true);
		equalityOperatorShort.setIsOperator(true);
		addRightParameter(name, equalityOperatorShort);
		genClass.addMethod(equalityOperatorShort);
	}

	private static void addRightParameter(String name, GenMethod equalityOperatorShort) {
		GenMethodParameter rightParameter = new GenMethodParameter(name, "Right");
		rightParameter.setIsConstant(true);
		rightParameter.setIsReference(true);
		equalityOperatorShort.addParameter(rightParameter);
	}

	private static void addLeftRightParameters(String name, GenMethod equalityOperator) {
		GenMethodParameter right = new GenMethodParameter(name, "Right");
		right.setIsReference(true);
		equalityOperator.addParameter(right);
		GenMethodParameter left = new GenMethodParameter(name, "Left");
		left.setIsReference(true);
		equalityOperator.addParameter(left);
	}

	private static void setEqualityDefaultSignature(GenMethod equalityOperator) {
		equalityOperator.setIsFriend(true);
		equalityOperator.setVisibility(Visibilities.PUBLIC);
		equalityOperator.setGroup(new GenGroup(GenClass.PREDEFINED_OPERATOR_GROUP));
		equalityOperator.setExternalDefinition("");
		equalityOperator.setReturnType(CPPTypesConstants.BOOL);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL)
	public static void registerInterfaces(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		GenClass genClass= new GenInterface();
		generationValueGetter.rootModel.addClass(genClass);
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		genClass.setName(name);
		genClass.setIsAbstract(true);
		
		GenMethod hashcode = hashCodeMethod(genClass);
		hashcode.setIsPure(true);
		genClass.addMethod(hashcode);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL + 2)
	public static void addComments(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		
		List<String> all= new ArrayList<String>();
		List<?> comments= generationValueGetter.getList(parent, IModelingElementDefinitions.COMMENTS);
		comments.forEach(c-> all.add(c.toString()));
		String multiLineComment = GenerationUtil.multiLineComment(all);
		if(!multiLineComment.isEmpty()){
			genClass.addComment(new GenComment(multiLineComment));
		}
		
		List<?> lineNumbers= generationValueGetter.getList(parent, IModelingElementDefinitions.LINE_NUMBERS, generationValueGetter.rootModel.getLanguage());
		lineNumbers.forEach(c-> genClass.addComment(new GenComment(c.toString().trim())));
	}
	
	private static GenMethod hashCodeMethod(GenClass genClass) {
		GenMethod hashcode = new GenMethod();
		hashcode.setName("hashCode");
		hashcode.addBody(new GenBody(genClass.hashCodeImplementation()));
		hashcode.setVisibility(Visibilities.PUBLIC);
		hashcode.setReturnType(CPPTypesConstants.SIZE_T);
		hashcode.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		hashcode.setIsVirtual(true);
		hashcode.setPriority(2);
		return hashcode;
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL + 1)
	public static void registerClassHierarchicalInformation(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		Object parentClass= generationValueGetter.getObject(element, IModelingElementDefinitions.PARENT_CLASS);
		
		GenClass parentGenClass= null;
		if(parentClass!= null){
			String parentName= generationValueGetter.getString(parentClass, IModelingElementDefinitions.NAME);
			parentGenClass = generationValueGetter.rootModel.classByName(parentName);
			genClass.setParent(parentGenClass);
		}
		
		List<?> parentInterfaces = generationValueGetter.getList(element, IModelingElementDefinitions.PARENT_INTERFACES);
		if(parentInterfaces!= null){
			for(Object obj: parentInterfaces){
				String inrerfaceName= generationValueGetter.getString(obj, IModelingElementDefinitions.NAME);
				GenClass interfaceGenClass = generationValueGetter.rootModel.classByName(inrerfaceName);
				if(interfaceGenClass instanceof GenInterface){
					genClass.addInterface((GenInterface) interfaceGenClass);
				}else{
					generationValueGetter.generationLogger.addError("Interface implemented is unkown");
				}
			}
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL + 1)
	public static void registerDeleteMethod(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		
		GenMethod deleteMethod = new GenDeleteMethod();
		deleteMethod.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		deleteMethod.setVisibility(Visibilities.PUBLIC);
		deleteMethod.setName("deleteAssociatedObjects");
		deleteMethod.setReturnType(CPPTypesConstants.VOID);
		deleteMethod.setGroup(new GenGroup(GenClass.DESTRUCTOR_GROUP));
		deleteMethod.setIsCore(true);
		GenClass genParent = genClass.getParent();
		if(genParent== null){
			deleteMethod.addDefaultImplementation(new GenBody(generationValueGetter.generate(Generator.NO_IMPLEMENTATION, null)));
		}else{
			GenBody genBody = new GenBody(genParent.getName()+"::deleteAssociatedObjects();");
			genBody.setPriority(GenPriorities.VERY_HIGH);
			genBody.setType(GenBody.BEFORE);
			deleteMethod.addDefaultImplementation(genBody);
		}
		
		genClass.addMethod(deleteMethod);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.DEPENDS_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.DEPENDS_PROCESSOR})
	}, aspect= LoopAspectConstants.PRE)
	public static void dependsProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.USE) String use,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		String name= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenPackage rootPackage = generationValueGetter.rootModel;
		GenClass baseClass = rootPackage.classByName(name);
		baseClass.addDependency(use);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation
	}, aspect= LoopAspectConstants.INITIAL -1)
	public static void registerClasses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		generationValueGetter.rootModel.setName("");
		generationValueGetter.rootModel.setProject(name);
	}
	
}
