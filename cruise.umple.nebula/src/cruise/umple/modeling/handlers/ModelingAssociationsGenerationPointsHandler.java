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
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.Generator;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.gen.GenAspectableReturnBody;
import cruise.umple.cpp.gen.GenAssociation;
import cruise.umple.cpp.gen.GenAssociationEnd;
import cruise.umple.cpp.gen.GenBaseConstructorMethod;
import cruise.umple.cpp.gen.GenBody;
import cruise.umple.cpp.gen.GenClass;
import cruise.umple.cpp.gen.GenComment;
import cruise.umple.cpp.gen.GenConstraint;
import cruise.umple.cpp.gen.GenConstraintCondition;
import cruise.umple.cpp.gen.GenConstraintVariable;
import cruise.umple.cpp.gen.GenConstructorMethod;
import cruise.umple.cpp.gen.GenDepend;
import cruise.umple.cpp.gen.GenDestructorMethod;
import cruise.umple.cpp.gen.GenField;
import cruise.umple.cpp.gen.GenGroup;
import cruise.umple.cpp.gen.GenInternalCopyMethod;
import cruise.umple.cpp.gen.GenMethod;
import cruise.umple.cpp.gen.GenMethodParameter;
import cruise.umple.cpp.gen.GenPriorities;
import cruise.umple.cpp.gen.GenStreamMethod;
import cruise.umple.cpp.gen.MemberInitializer;
import cruise.umple.cpp.gen.Visibilities;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.modeling.handlers.cpp.ISTLConstants;

public class ModelingAssociationsGenerationPointsHandler{
	
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL+1)
	public static void registerInternalCopyMethod(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String name = generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		if(genClass.isSingleton()){
			return;
		}
		
		GenMethod method = new GenInternalCopyMethod();
		method.setName("internalCopy");
		method.setIsOperator(true);
		method.setVisibility(Visibilities.PUBLIC);
		method.setReturnType(CPPTypesConstants.VOID);
		GenMethodParameter methodParameter = new GenMethodParameter(name, "other");
		methodParameter.setIsReference(true);
		method.addParameter(methodParameter);
		
		method.addDefaultImplementation(new GenBody(generationValueGetter.generate(Generator.NO_IMPLEMENTATION, null)));
		genClass.addMethod(method);
		
		method.setDisableRemote(true);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			//@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL+1)
	public static void registerStreamMethod(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String name = generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		
		GenMethod helperMethod = new GenStreamMethod();
		helperMethod.setName("toOstream");
		helperMethod.setVisibility(Visibilities.PROTECTED);
		helperMethod.setReturnType(CPPTypesConstants.VOID);
		helperMethod.addDefaultImplementation(new GenBody(generationValueGetter.generate(Generator.NO_IMPLEMENTATION, null)));
		helperMethod.setIsVirtual(true);
		helperMethod.setIsCore(true);
		helperMethod.setIsConstant(true);
		helperMethod.setGroup(new GenGroup(GenClass.STREAM_HELPER_GROUP));
		GenMethodParameter methodParameter = new GenMethodParameter("ostream", "os");
		methodParameter.setIsReference(true);
		helperMethod.addParameter(methodParameter);
		genClass.addMethod(helperMethod);
		helperMethod.setDisableRemote(true);
		
		GenMethod helperMethodCaller= new GenMethod();
		helperMethodCaller.setGroup(new GenGroup(GenClass.STREAM_HELPER_GROUP));
		helperMethodCaller.setName("operator<<");
		helperMethodCaller.setIsOperator(true);
		helperMethodCaller.setReturnType("ostream");
		helperMethodCaller.setIsReference(true);
		helperMethodCaller.setIsFriend(true);
		helperMethodCaller.setIsCore(true);
		helperMethodCaller.setVisibility(Visibilities.PUBLIC);
		helperMethodCaller.setDisableRemote(true);
		genClass.addMethod(helperMethodCaller);
		helperMethodCaller.setExternalDefinition("");
		GenMethodParameter osParameter = new GenMethodParameter("ostream", "os");
		osParameter.setIsReference(true);
		helperMethodCaller.addParameter(osParameter);
		
		GenMethodParameter instanceParameter = new GenMethodParameter(name, "dt");
		instanceParameter.setIsConstant(true);
		instanceParameter.setIsReference(true);
		helperMethodCaller.addParameter(instanceParameter);
		
		helperMethodCaller.addBody(new GenBody("dt.toOstream(os);"));
		GenBody returnBody = new GenBody("return os;");
		returnBody.setPriority(GenPriorities.EXTREMLY_LOW);
		helperMethodCaller.addBody(returnBody);
		
		
		GenMethod method = new GenMethod();
		method.setGroup(new GenGroup(GenClass.PREDEFINED_OPERATOR_GROUP));
		method.setName("operator=");
		method.setVisibility(Visibilities.PUBLIC);
		method.setIsOperator(true);
		method.setReturnType(name);
		method.setIsReference(true);
		//method.setIsFriend(true);	//Not a friend
		method.setDisableRemote(true);
		
		GenMethodParameter otherParameter = new GenMethodParameter(name, "other");
		otherParameter.setIsReference(true);
		method.addParameter(otherParameter);
		genClass.addMethod(method);
		
		if(!genClass.isSingleton()){
			method.addBody(new GenBody("internalCopy(other);"));
		}
		
		GenBody returnThisBody = new GenBody("return *this;");
		returnThisBody.setPriority(GenPriorities.EXTREMLY_LOW);
		method.addBody(returnThisBody);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL+1)
	public static void registerDestructorMethod(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String name = generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		if(genClass.isSingleton()){
			return;
		}
		
		GenMethod method = new GenDestructorMethod();
		method.setIsConstructor(true);
		method.setName("~"+ name);
		method.setIsVirtual(true);
		method.setVisibility(Visibilities.PUBLIC);
		method.addDefaultImplementation(new GenBody(generationValueGetter.generate(Generator.NO_IMPLEMENTATION, null)));
		genClass.addMethod(method);
		
		method.setGroup(new GenGroup(GenClass.DESTRUCTOR_GROUP));
		method.setDisableRemote(true);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.INITIAL+1)
	public static void registerConstructorMethod(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String name = generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		
		constructorMethodInstance(generationValueGetter, genClass);
		
		if(!genClass.isSingleton()){
			GenMethod copyConstructor = new GenBaseConstructorMethod();
			copyConstructor.setIsConstructor(true);
			copyConstructor.setName(genClass.getName());
			copyConstructor.setVisibility(Visibilities.PUBLIC);
			copyConstructor.addBody(new GenBody(interfaceObject == null?"internalCopy(other);": generationValueGetter.generate(Generator.NO_IMPLEMENTATION, null)));
			copyConstructor.setDisableRemote(true);
			GenMethodParameter other = new GenMethodParameter(name, "other");
			other.setIsReference(true);
			copyConstructor.addParameter(other);
			copyConstructor.setGroup(new GenGroup(GenClass.CONSTRUCTOR_GROUP));
			copyConstructor.setPriority(GenPriorities.LOW);
			genClass.addMethod(copyConstructor);
		}
	}

	private static GenConstructorMethod constructorMethodInstance(GenerationPolicyRegistry generationValueGetter, GenClass genClass) {
		GenConstructorMethod method = new GenConstructorMethod();
		method.setIsConstructor(true);
		method.setName(genClass.getName());
		method.setVisibility(Visibilities.PUBLIC);
		method.addDefaultImplementation(new GenBody(generationValueGetter.generate(Generator.NO_IMPLEMENTATION, null)));
		genClass.addMethod(method);
		
		method.setGroup(new GenGroup(GenClass.CONSTRUCTOR_GROUP));
		method.setDisableRemote(true);
		return method;
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	}, aspect= LoopAspectConstants.BEFORE-1, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static void prepareAttributeHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_DERIVED) boolean isDerived,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_SORTED) boolean isSorted,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_AUTO_UNIQUE) boolean isAutoUnique,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_DEFAULTED) boolean isdefaulted,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_IMMUTABLE) boolean isImmutable,
			@GenerationElementParameter(id = IModelingElementDefinitions.VALUE) String defaultValue,
			
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){

		GenAssociation association = assignAssociation(generationValueGetter, element, parent, false);
		GenAssociationEnd source = association.getSource();
		GenAssociationEnd target = association.getTarget();
		source.setRole(source.getName());
		target.setRole(target.getName());
		
		association.setIsAttribute(true);
		association.setDerived(isDerived);
		association.setAutounique(isAutoUnique);
		association.setConstant(isConstant);
		association.setImmutable(isImmutable);
		association.setIsLazy(isLazy);
		association.setIsStatic(isStatic);
		
		association.setValue(defaultValue); 
		association.setInternal(generationValueGetter.getBoolean(element, IModelingElementDefinitions.IS_INTERNAL));
		association.setDefaulted(isdefaulted);
		
		String name= source.getName();
		if(association.isDefaulted()){
			String defaultGetterMethod= generationValueGetter.generator.defaultName(name);
			String resetCall= generationValueGetter.generator.resetName(name);
			
			GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
			genClass.addConstructorContent(new GenBody(
					generationValueGetter.generate(Generator.METHOD_INVOCATION, resetCall, CommonConstants.BLANK, Boolean.TRUE)));
			
			//Default getter extra method for the defaulted attributes
			String typeName= generationValueGetter.getString(element, IModelingElementDefinitions.TYPE_NAME);
			GenMethod defaulted = new GenMethod();
			defaulted.setName(defaultGetterMethod);
			defaulted.setReturnType(typeName);
			defaulted.setNormalize(true);
			defaulted.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
			GenAspectableReturnBody returnBody = new GenAspectableReturnBody(defaultValue, 
					generationValueGetter.generator.variableInstance(name), CPPTypesConstants.BOOL);
			defaulted.addBody(returnBody);
			genClass.addMethod(defaulted);

			GenMethod reset = new GenMethod();
			reset.setName(resetCall);
			reset.setReturnType(CPPTypesConstants.BOOL);
			GenBody fistBody = new GenBody("bool wasReset= false;");
			fistBody.setPriority(GenPriorities.HIGH);
			fistBody.setType(GenBody.BEFORE);
			reset.addBody(fistBody);
			reset.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
			GenBody lastBody = new GenBody("return wasReset;");
			lastBody.setPriority(GenPriorities.EXTREMLY_LOW);
			lastBody.setType(GenBody.POST_BLOCK);
			reset.addBody(lastBody);
			reset.addBody(new GenBody(generationValueGetter.generate(Generator.RESET_IMPLEMENTATION, name, defaultGetterMethod)));
			genClass.addMethod(reset);
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
	}, aspect= LoopAspectConstants.BEFORE-1, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static void prepareAssociationsHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		GenAssociation assignAssociation = assignAssociation(generationValueGetter, element, parent, true);
		//init(generationValueGetter, element, parent, assignAssociation);
	}
	
//	private static void init(GenerationPolicyRegistry generationValueGetter, Object element, Object parent,
//			GenAssociation assignAssociation) {
//		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
//		GenAssociationEnd source = assignAssociation.getSource();
//		if(source.isOne()){
//			String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
//			String typeName= generationValueGetter.getString(element, IModelingElementDefinitions.TYPE_NAME);
//			 
//			GenClass genClass= generationValueGetter.rootModel.classByName(parentName);
//			MemberInitializer routerInitializer = new MemberInitializer(typeName);
//			routerInitializer.setPriority(-20);
//			genClass.addMemberInitializer(routerInitializer);
//		}
//	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void prepareAttributeHandlerCopy(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_DERIVED) boolean isDerived,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_SORTED) boolean isSorted,
			
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass= generationValueGetter.rootModel.classByName(parentName);
		
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(Arrays.asList(new String[] {ISTLConstants.TIME, ISTLConstants.DATE}).contains(typeName)){
			GenDepend cTimeDepend = new GenDepend(ISTLConstants.C_TIME);
			cTimeDepend.setNamespace(ISTLConstants.STD_LIBRARY);
			cTimeDepend.setIsLibrary(true);
			genClass.addDependency(cTimeDepend);
		}
		
		if(association.getSource().isMany() && !generationValueGetter.rootModel.isPrimitive(typeName)){
			GenDepend algorithmDepend = new GenDepend(ISTLConstants.ALGORITHM);
			algorithmDepend.setNamespace(ISTLConstants.STD_LIBRARY);
			algorithmDepend.setIsLibrary(true);
			genClass.addDependency(algorithmDepend);
			
			GenDepend memoryDepend = new GenDepend(ISTLConstants.MEMORY);
			memoryDepend.setNamespace(ISTLConstants.STD_LIBRARY);
			memoryDepend.setIsLibrary(true);
			genClass.addDependency(memoryDepend);
		}
	}

	private static GenAssociation assignAssociation(GenerationPolicyRegistry generationValueGetter, Object element, Object parent, boolean check) {
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		String typeName= generationValueGetter.getString(element, IModelingElementDefinitions.TYPE_NAME);
		
		String otherName= generationValueGetter.getString(element, IModelingElementDefinitions.OTHER_END_NAME);
		String otherTypeName= generationValueGetter.getString(element, IModelingElementDefinitions.OTHER_END_TYPE_NAME);
		
		String role= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, name);
		String roles= generationValueGetter.getString(element, IModelingElementDefinitions.PLURAL_NAME, name);
		
		String otherRole= generationValueGetter.getString(element, IModelingElementDefinitions.SINGULAR_NAME, otherName);
		String otherRoles= generationValueGetter.getString(element, IModelingElementDefinitions.PLURAL_NAME, otherName);
		
		String sortKey= generationValueGetter.getString(element, IModelingElementDefinitions.PRIORITY);
		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass= generationValueGetter.rootModel.classByName(parentName);
		
		GenAssociation association= new GenAssociation();
		GenAssociationEnd source = new GenAssociationEnd(name, typeName, role, roles,
				generationValueGetter.getBoolean(element, IModelingElementDefinitions.IS_OTHER_END_NAVIGABLE));
		source.setLowerBound(generationValueGetter.getInt(element, IModelingElementDefinitions.LOWER_BOUND));
		source.setUpperBound(generationValueGetter.getInt(element, IModelingElementDefinitions.UPPER_BOUND));
		association.setSource(source);
		
		GenAssociationEnd target = new GenAssociationEnd(otherName, otherTypeName, otherRole, otherRoles,
				generationValueGetter.getBoolean(element, IModelingElementDefinitions.IS_NAVIGABLE));
		target.setLowerBound(generationValueGetter.getInt(element, IModelingElementDefinitions.OTHER_END_LOWER_BOUND));
		target.setUpperBound(generationValueGetter.getInt(element, IModelingElementDefinitions.OTHER_END_UPPER_BOUND));
		association.setTarget(target);
		association.setIsSorted(generationValueGetter.getBoolean(element, IModelingElementDefinitions.IS_SORTED));
		
		association.setSortKey(sortKey);
		genClass.addAssociation(association);
		
		if(check){
			association.setCheckUnique(check);
		}
		
		return association;
	}
	
	public static List<GenComment> addComments(GenerationPolicyRegistry generationValueGetter, Object element){
		List<String> all= new ArrayList<String>();
		List<GenComment> _comments= new ArrayList<GenComment>();
		List<?> comments= generationValueGetter.getList(element, IModelingElementDefinitions.COMMENTS);
		comments.forEach(c-> all.add(c.toString()));
		String multiLineComment = GenerationUtil.multiLineComment(all);
		if(!multiLineComment.isEmpty()){
			_comments.add(new GenComment(multiLineComment));
		}
		
		List<?> lineNumbers= generationValueGetter.getList(element, IModelingElementDefinitions.LINE_NUMBERS, generationValueGetter.rootModel.getLanguage());
		lineNumbers.forEach(c-> _comments.add(new GenComment(c.toString().trim())));
		
		return _comments;
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	})
	public static void associationsVairablesSetter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(association== null || !association.isSettable()){
			return;
		}
		
		GenMethod setterMethod = associationHandle(association, "wasSet", association.normalizedType());
		GenAssociationEnd source = association.getSource();
		setterMethod.setName(association.setInstance(source.isMany()?source.getRoles(): source.getRole()));
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	})
	public static void associationsVairablesHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(association== null ||!association.isSettable()){
			return;
		}
		
		registerSetterMethod(association, generationValueGetter, element, parent, modelPackage);
	}

	private static GenMethod associationHandle(GenAssociation association, String variable, String normalizedType) {
		boolean isMany = association.getSource().isMany();
		return associationHandle(association, variable, normalizedType, isMany);
	}

	private static GenMethod associationHandle(GenAssociation association, String variable, String normalizedType, boolean isMany) {
		GenAssociationEnd source = association.getSource();
		GenMethod method = new GenMethod();
		method.setVisibility(Visibilities.PUBLIC);
		method.setReturnType( CPPTypesConstants.BOOL);
		String newInstance = association.newInstanceInstance(isMany?source.getRoles(): source.getRole(), isMany);
		GenMethodParameter methodParameter = new GenMethodParameter(normalizedType, newInstance);
		methodParameter.setNormalize(true);
		method.addParameter(methodParameter);
		addChecker(variable, method);
		return method;
	}

	private static void addChecker(String variable, GenMethod method) {
		GenBody fistBody = new GenBody("bool "+ variable+ "= false;");
		fistBody.setPriority(GenPriorities.HIGH);
		fistBody.setType(GenBody.BEFORE);
		method.addBody(fistBody);
		
		GenBody lastBody = new GenBody("return "+ variable+ ";");
		lastBody.setPriority(GenPriorities.EXTREMLY_LOW);
		lastBody.setType(GenBody.POST_BLOCK);
		method.addBody(lastBody);
	}
	
	private static void setFriendsSetter(GenerationPolicyRegistry generationValueGetter, Object element, Object parent) {
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		GenClass genClass = association.getOwner().getGenPackage().classByName(association.getSource().getType());
		GenMethod friendSetter = new GenMethod();
		friendSetter.setVisibility(Visibilities.GLOBAL);
		friendSetter.setGroup(new GenGroup(GenClass.GLOBAL_GROUP));
		friendSetter.setIsFriend(true);
		genClass.addMethod(friendSetter);
		friendSetter.setReturnType(CPPTypesConstants.VOID);
		friendSetter.setName(association.friendMethodName());
		GenAssociationEnd source = association.getSource();
		GenAssociationEnd target = association.getTarget();
		
		String type = source.getType();
		String otherType = target.getType();
		
		String instance = association.newInstanceInstance(type);
		String otherInstance = association.newInstanceInstance(otherType);
		GenMethodParameter param1 = new GenMethodParameter(type, instance);
		param1.setNormalize(true);
		friendSetter.addParameter(param1);
		
		GenMethodParameter param2 = new GenMethodParameter(otherType, otherInstance);
		param2.setNormalize(true);
		friendSetter.addParameter(param2);
		friendSetter.declaration();
		friendSetter.addBody(new GenBody(instance+ "->" +target.getName()+ "= "+ otherInstance+ ";"));
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void attributesHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_IMMUTABLE) boolean isImmutable,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy){
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(!association.isSettable()){
			return;
		}
		
		GenMethod setterMethod = registerSetterMethod(association, generationValueGetter, element, parent, modelPackage);
		
		if(isLazy&& isImmutable|| generationValueGetter.getBoolean(parent, IModelingElementDefinitions.IS_IMMUTABLE) || 
				generationValueGetter.getBoolean(parent,IModelingElementDefinitions.IS_KEY_MEMBER, element)){
			String canSet = association.canSetInstance(name);
			GenClass genClass = association.getOwner();
			GenField field = new GenField();
			field.setVisibility(Visibilities.PRIVATE);
			field.setType(CPPTypesConstants.BOOL);
			field.setName(canSet);
			field.setValue(Boolean.TRUE.toString());
			field.setParameterized(true);
			field.setIsComparable(false);
			genClass.addField(field);
			field.setGroup(genClass.getAttributeGroup(genClass.indexOfAttributeGroup(new GenGroup(GenClass.HELPER_GROUP))));
			
			//And, then update the setter method to have the lazy check code segment
			String generate = generationValueGetter.generate(Generator.SETTER_CAN_SET_CHECK, canSet);
			GenBody fistBody = new GenBody(generate);
			fistBody.setPriority(GenPriorities.LOW);
			fistBody.setType(GenBody.BEFORE);
			setterMethod.addBody(fistBody);
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void attributesAndAssociationsDeclarationProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_CONSTANT) boolean isConstant,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_DERIVED) boolean isDerived,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_SORTED) boolean isSorted,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_AUTO_UNIQUE) boolean isAutoUnique,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			
			@GenerationLoopElement(id= {IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}) Object attribute,
			@GenerationBaseElement Object element,
			
			@GenerationElementParameter(id = IModelingElementDefinitions.ELEMENT_VISIBILITY) String visibility,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_INTERNAL) boolean isInternal,
			@GenerationElementParameter(id = IModelingElementDefinitions.MODIFIER) String modifier,
			
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		if(isDerived/* || isSorted*/){
			return;
		}
		
		if(modifier!= null && modifier.startsWith("fixml")){
			return;
		}
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(association== null){
			return;
		}
		
		String attributeValue= generationValueGetter.getString(element,IModelingElementDefinitions.DEFAULT_VALUE, CPPCommonConstants.CPP_LANGUAGE);
		
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		boolean isMany = association.getSource().isMany();
		if(isAutoUnique){
			GenField autouniqueField = new GenField();
			autouniqueField.setGroup(new GenGroup(GenClass.AUTOUNIQUE_ATTRIBUTE_GROUP));
			autouniqueField.setNormalize(true);
			autouniqueField.setName(name);
			autouniqueField.setType(typeName);
			genClass.addField(autouniqueField);
			
			GenField autouniqueAssignField = new GenField();
			autouniqueAssignField.setGroup(new GenGroup(GenClass.STATIC_ATTRIBUTE_GROUP));
			autouniqueAssignField.setName(generationValueGetter.generator.nextName(name));
			autouniqueAssignField.setIsStatic(true);
			autouniqueAssignField.setNormalize(true);
			autouniqueAssignField.setAutounique(name);
			autouniqueAssignField.setValue("1");
			autouniqueAssignField.setType(typeName);
			genClass.addField(autouniqueAssignField);
		}else{
			GenField field = new GenField();
			field.setParameterized(attribute!= null && !isStatic && isInternal);
			
			field.setType(typeName);
			field.setNormalize(true);
			field.setVisibility(visibility);
			field.setValue(attributeValue);
			addComments(generationValueGetter, element).forEach(comment->field.addComment(comment));
			
			if(isStatic){
				field.setGroup(new GenGroup(GenClass.STATIC_ATTRIBUTE_GROUP));
			}else{
				field.setGroup(new GenGroup(attribute== null? GenClass.ASSOCIATION_GROUP: GenClass.ATTRIBUTE_GROUP));
				field.setIsIdentifier(true);
			}
			field.setName(name);
			field.setNormalize(true);
			field.setIsMany(isMany);
			field.setIsStatic(isStatic);
			field.setIsConstant(generationValueGetter.getBoolean(element, IModelingElementDefinitions.IS_CONSTANT));
			field.setRelatedAssociation(association);
			genClass.addField(field);
		}
		helper(generationValueGetter, element,  parent, typeName);
	}
	
	public static void helper(GenerationPolicyRegistry generationValueGetter, Object element, Object parent, String typeName){
		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass= generationValueGetter.rootModel.classByName(parentName);
		
		//TODO: if(stream!= null && !stream.isEmpty()){
		GenDepend genDepend = new GenDepend(ISTLConstants.OSTREAM);
		genDepend.setNamespace(ISTLConstants.STD_LIBRARY);
		genDepend.setIsLibrary(true);
		genClass.addDependency(genDepend);
		
		if(ISTLConstants.STRING.equals(typeName)){
			GenDepend _genDepend = new GenDepend(ISTLConstants.STRING);
			_genDepend.setIsLibrary(true);
			_genDepend.setNamespace(ISTLConstants.STD_LIBRARY);
			genClass.addDependency(_genDepend);
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	}, aspect= LoopAspectConstants.PRE+1, priority= IGenerationPointPriorityConstants.HIGHEST)
	public static void registerGetterMethods(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element, @GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(association== null || !association.isGettable()){
			return;
		}
		
		if(!association.isMany()){
			registerSingleGetterMethod(association);
			if(generationValueGetter.rootModel.isBoolean(association.getSource().getType())){
				registerIsAMethod(association);
			}
			return;
		}
		
		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass= generationValueGetter.rootModel.classByName(parentName);
		
		String sortKey = association.getSortKey();
		GenDepend hashMapDepend = new GenDepend(sortKey!= null && !sortKey.isEmpty()?ISTLConstants.SET: ISTLConstants.VECTOR);
		hashMapDepend.setIsLibrary(true);
		hashMapDepend.setNamespace(ISTLConstants.STD_LIBRARY);
		genClass.addDependency(hashMapDepend);
		
		registerGetAllMethod(association);
		registerGetByIndex(association);
		registerNumberOfMethod(association);
		registerContainsMethod(association);
		registerIndexOfMethod(association);
		
		if(association.deleteDecision()!= null){
			registerRemoveMethod(association);
			registerRemoveAtMethod(association);
		}
	}
	
	private static GenMethod registerGetAllMethod(GenAssociation association) {
		GenClass genClass = association.getOwner();
		GenAssociationEnd source = association.getSource();
		String roles = source.getRoles();
		String copyOf= association.copyOfInstance(roles);
		String getterDeclarationBody = association.copyCall(0, null, copyOf);
		
		GenMethod method = new GenMethod();
		method.setName(association.getInstance(roles)); 
		
		GenMethod existing= genClass.methodByIdentifier(method.identifier());
		if(existing != null){
			method= existing;
		}else{
			genClass.addMethod(method);
		}
		
		method.setReturnType(association.normalizedType(true));
		
		method.setVisibility(Visibilities.PUBLIC);
		for(GenComment comment: association.getComments()){
			method.addComment(comment);
		}
		method.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		
		method.addBody(new GenBody(getterDeclarationBody));
		GenBody returnBody = new GenBody("return "+ copyOf+ ";");
		returnBody.setType(GenBody.POST_BLOCK);
		returnBody.setPriority(GenPriorities.VERY_LOW);
		method.addBody(returnBody);
		
		return method;
	}

	private static GenMethod registerGetByIndex(GenAssociation association) {
		GenClass genClass = association.getOwner();
		GenAssociationEnd source = association.getSource();
		GenMethod method = new GenMethod();
		method.setReturnType(source.getType());
		String role = source.getRole();
		method.setName(association.getInstance(role));
		method.addParameter(new GenMethodParameter(CPPTypesConstants.INTEGER, "index"));
		
		GenMethod existing= genClass.methodByIdentifier(method.identifier());
		if(existing != null){
			method= existing;
		}else{
			genClass.addMethod(method);
		}
		
		method.setNormalize(true);
		String instanceName= association.variableInstance(role);
		method.setVisibility(Visibilities.PUBLIC);
		method.addBody(new GenBody(association.getterByIndexImplementation()));
		
		GenBody returnBody = new GenBody("return "+ instanceName+ ";");
		returnBody.setType(GenBody.POST_BLOCK);
		returnBody.setPriority(GenPriorities.VERY_LOW);
		method.addBody(returnBody);
		return method;
	}

	private static GenMethod registerSingleGetterMethod(GenAssociation association) {
		GenClass genClass = association.getOwner();
		GenAssociationEnd source = association.getSource();
		String role = source.getRole();
		String getterMethodName= association.getInstance(role);
		
		GenMethod method = new GenMethod();
		method.setName(getterMethodName);

		GenMethod existing= genClass.methodByIdentifier(method.identifier());
		if(existing!= null){
			method= existing;
		}else{
			genClass.addMethod(method);
		}
		
		method.setNormalize(true);
		method.setVisibility(Visibilities.PUBLIC);
		method.setReturnType(source.getType());
		method.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		
		for(GenComment comment: association.getComments()){
			method.addComment(comment);
		}
		
		String instanceName= association.variableInstance(role);
		
		method.addBody(new GenAspectableReturnBody("this->"+ source.getName(), instanceName, method.getNormalizedReturnType()));
		return method;
	}

	private static GenMethod registerIndexOfMethod(GenAssociation association){
		GenAssociationEnd source = association.getSource();
		String role = source.getRole();
		String containsMethodName = association.indexOfInstance(role);
		String containsBody = association.indexOfImplementation();
		String normalizedType = association.getOwner().getGenPackage().getNormalizedType(source.getType());
		
		GenMethod method = new GenMethod();
		method.addParameter(new GenMethodParameter(normalizedType, association.variableInstance(role)));
		method.setReturnType(CPPTypesConstants.INTEGER);
		method.setName(containsMethodName);
		
		GenClass genClass = association.getOwner();
		GenMethod existing= genClass.methodByIdentifier(method.identifier());
		if(existing != null){
			method= existing;
		}else{
			genClass.addMethod(method);
		}
		
		method.setVisibility(Visibilities.PUBLIC);
		method.addBody(new GenAspectableReturnBody(containsBody, "index", CPPTypesConstants.INTEGER));
		
		return method;
	}
	
	private static GenMethod registerContainsMethod(GenAssociation association){
		String containsMethodName = association.hasInstance(association.getSource().getRole());
		String containsBody = association.containsImplementation();			
		GenMethod method = new GenMethod();
		
		method.setReturnType(CPPTypesConstants.BOOL);
		method.setName(containsMethodName);
		
		GenClass genClass = association.getOwner();
		GenMethod existing= genClass.methodByIdentifier(method.identifier());
		if(existing != null){
			method= existing;
		}else{
			genClass.addMethod(method);
		}
		
		
		method.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		
		method.setVisibility(Visibilities.PUBLIC);
		method.addBody(new GenAspectableReturnBody(containsBody, "has", CPPTypesConstants.BOOL));
		
		return method;
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	})
	public static void attributesAndAssociationsProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(association== null){
			return;
		}
		
		if(association.isUseMinimum()|| association.isUseMaximum()){
			registerMinimumNumberOfMethod(association);
		}
		
		if(association.isUseMaximum()){
			registerMaximumNumberOfMethod(association);
		}
	}
	
	private static GenMethod registerMinimumNumberOfMethod(GenAssociation association) {
		GenAssociationEnd source = association.getSource();
		return registerBoundMethod(association, association.minimumNumberOfInstance(source.getRoles()), source.getUpperBound());
	}

	private static GenMethod registerMaximumNumberOfMethod(GenAssociation association) {
		GenAssociationEnd source = association.getSource();
		return registerBoundMethod(association, association.maximumNumberOfInstance(source.getRoles()), source.getLowerBound());
	}
	
	private static GenMethod registerBoundMethod(GenAssociation association, String methodName, int bound) {
		GenClass genClass = association.getOwner();
		GenMethod method = new GenMethod();
		method.setName(methodName);
		method.setReturnType(CPPTypesConstants.UNSIGNED_INTEGER);
		
		GenMethod existing= genClass.methodByIdentifier(method.identifier());
		if(existing != null){
			method= existing;
		}else{
			genClass.addMethod(method);
		}
		
		method.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		method.setVisibility(Visibilities.PUBLIC);
		method.addBody(new GenBody("return " + bound+ ";"));
		method.setIsInline(true);
		method.setIsHeader(true);
		return method;
	}
	
	private static GenMethod registerIsAMethod(GenAssociation association) {
		GenClass genClass = association.getOwner();
		String role = association.getSource().getRole();
		String thisName = "this->"+role;
		String methodName = association.isAInstance(role);
		
		GenMethod isAMethod = new GenMethod();
		isAMethod.setReturnType(CPPTypesConstants.BOOL);
		
		GenMethod existing= genClass.methodByIdentifier(isAMethod.identifier());
		if(existing != null){
			isAMethod= existing;
		}else{
			genClass.addMethod(isAMethod);
		}
		
		
		genClass.addMethod(isAMethod);
		
		isAMethod.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		isAMethod.setVisibility(Visibilities.PUBLIC);
		isAMethod.addBody(new GenAspectableReturnBody(thisName, association.variableInstance(role), CPPTypesConstants.BOOL));
		isAMethod.setName(methodName);
		return isAMethod;
	}

	private static GenMethod registerNumberOfMethod(GenAssociation association) {
		GenClass genClass = association.getOwner();
		GenMethod numberOfMethod = new GenMethod();
		GenAssociationEnd source = association.getSource();
		String numberOfMethodName = association.numberOfInstance(source.getRoles());
		numberOfMethod.setName(numberOfMethodName);
		numberOfMethod.setReturnType(CPPTypesConstants.UNSIGNED_INTEGER);
		
		GenMethod existing= genClass.methodByIdentifier(numberOfMethod.identifier());
		if(existing != null){
			numberOfMethod= existing;
		}else{
			genClass.addMethod(numberOfMethod);
		}
		
		numberOfMethod.setVisibility(Visibilities.PUBLIC);
		numberOfMethod.addParameter(new GenMethodParameter(CPPTypesConstants.VOID, null));
		
		
		numberOfMethod.addBody(new GenBody(association.numberOfImplementation()));
		
		GenBody returnBody = new GenBody("return number;");
		returnBody.setPriority(GenPriorities.EXTREMLY_LOW);
		returnBody.setType(GenBody.POST_BLOCK);
		numberOfMethod.addBody(returnBody);
		return numberOfMethod;
	}

	private static GenMethod registerRemoveAtMethod(GenAssociation association) {
		GenClass genClass = association.getOwner();
		GenAssociationEnd source = association.getSource();
		
		GenMethod removeAtMethod = new GenMethod();
		removeAtMethod.setReturnType(CPPTypesConstants.BOOL);
		removeAtMethod.addParameter(new GenMethodParameter(CPPTypesConstants.INTEGER, "index"));
		String removeAtMethodName = association.removeAtInstance(source.getRole());
		removeAtMethod.setName(removeAtMethodName);
		
		GenMethod existing= genClass.methodByIdentifier(removeAtMethod.identifier());
		if(existing != null){
			removeAtMethod= existing;
		}else{
			genClass.addMethod(removeAtMethod);
		}
		
		removeAtMethod.setVisibility(Visibilities.PUBLIC);
		addChecker("wasRemoved", removeAtMethod);
		removeAtMethod.addBody(new GenBody(association.removeAtImplementation()));
		return removeAtMethod;
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES_PROCESSOR})
	}, aspect= LoopAspectConstants.PRE+1)
	public static void associationsVairablesAddHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		 
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(association== null || association.addDecision()== null){
			return;
		}
		
		if(GenAssociation.ADD_REMOVE_EXISTING.equals(association.addDecision())){
			setFriendsSetter(generationValueGetter, element, parent);
		}
		
		registerAddMethod(association);
		if(!association.isIsSorted()){
			registerAddAtMethod(association);
			registerAddOrMoveAt(association);
		}
		
		
		if(association.getHasAdditionalAdd()){
			registerProxyAdd(association);
		}
	}
	
	private static GenMethod registerSetterMethod(GenAssociation association, GenerationPolicyRegistry generationValueGetter, Object element, Object parent, Object modelPackage) {
		GenClass genClass= association.getOwner();
		GenMethod setterMethod = associationHandle(association, "wasSet", association.normalizedType());
		GenAssociationEnd source = association.getSource();
		setterMethod.setName(association.setInstance(source.isMany()?source.getRoles(): source.getRole()));
		 
		String setterBody = association.getSetterBody();
		if(setterBody!= null){
			String setterDecision = association.setterDecision();
			if(GenAssociation.SETTER_HASHMAP.equals(setterDecision)){
				GenDepend hashMapDepend = new GenDepend(ISTLConstants.HASH_MAP);
				hashMapDepend.setIsLibrary(true);
				hashMapDepend.setNamespace(ISTLConstants.STD_LIBRARY);
				genClass.addDependency(hashMapDepend);
			}else if(GenAssociation.SETTER_MINIMUM_FIXED.equals(setterDecision)){
				setFriendsSetter(generationValueGetter, element, parent);
			}
			
			addConstraints(generationValueGetter, element, setterMethod);
			
			GenMethod existing= genClass.methodByName(setterMethod.getName());
			if(existing != null){
				setterMethod= existing;
			}else{
				genClass.addMethod(setterMethod);
			}
			
			setterMethod.addBody(new GenBody(setterBody));
		}
		
		return setterMethod;
	}
	
	private static void addConstraints(GenerationPolicyRegistry generationValueGetter, Object element, GenMethod method) {
		List<?> constraintObjects= generationValueGetter.getList(element, IModelingElementDefinitions.CONSTRAINTS_FOR_ATTRIBUTE);
		for(Object constraint: constraintObjects){
			GenConstraintCondition aCondition = new GenConstraintCondition();
			aCondition.setString(generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS, Boolean.FALSE));
			method.addConstraintCondition(aCondition);
		}
	}
	
	private static void registerAddMethod(GenAssociation association) {
		String normalizedType = association.getOwner().getGenPackage().getNormalizedType(association.getSource().getType());
		GenMethod getterMethod = associationHandle(association, "wasAdded", normalizedType, false);
		GenAssociationEnd source = association.getSource();
		getterMethod.setName(association.addInstance(source.getRole()));
		
		String addBody = association.getAddBody();
		if(addBody== null){
			return;
		}
		
		getterMethod.addBody(new GenBody(addBody));
		association.getOwner().addMethod(getterMethod);
	}

	private static GenAssociation getAssociation(GenerationPolicyRegistry generationValueGetter, Object element,
			Object parent) {
		String name= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		String otherName= generationValueGetter.getString(element, IModelingElementDefinitions.OTHER_END_NAME);
		String parentName= generationValueGetter.getString(parent, IModelingElementDefinitions.NAME);
		GenClass genClass= generationValueGetter.rootModel.classByName(parentName);
		GenAssociation association= genClass.associationByName(name+ otherName);
		return association;
	}

	private static GenMethod registerAddOrMoveAt(GenAssociation association) {
		GenClass genClass = association.getOwner();
		GenAssociationEnd source = association.getSource();
		String newInstance= association.newInstanceInstance(source.getRole(), false);
		String normalizedType = association.getOwner().getGenPackage().getNormalizedType(association.getSource().getType());
		
		GenMethod addOrMoveAt = new GenMethod();
		addOrMoveAt.setReturnType(CPPTypesConstants.BOOL);
		addOrMoveAt.addParameter(new GenMethodParameter(normalizedType, newInstance));
		addOrMoveAt.addParameter(new GenMethodParameter(CPPTypesConstants.INTEGER, "index"));
		
		GenMethod existing= genClass.methodByIdentifier(addOrMoveAt.identifier());
		if(existing != null){
			addOrMoveAt= existing;
		}else{
			genClass.addMethod(addOrMoveAt);
		}
		
		addOrMoveAt.setVisibility(Visibilities.PUBLIC);
		addOrMoveAt.addBody(new GenBody(association.addOrMoveImplementation()));
		String addOrMoveAtInstance = association.addOrMoveAtInstance(source.getRole());
		addOrMoveAt.setName(addOrMoveAtInstance);
		addChecker("wasAdded", addOrMoveAt);
		
		return addOrMoveAt;
	}
	
	private static GenMethod registerRemoveMethod(GenAssociation association) {
		GenClass genClass = association.getOwner();
		GenAssociationEnd source = association.getSource();
		String newInstance= association.variableInstance(source.getRole(), false);
		String normalizedType = association.getOwner().getGenPackage().getNormalizedType(association.getSource().getType());
		
		GenMethod removeMethod = new GenMethod();
		removeMethod.setReturnType(CPPTypesConstants.BOOL);
		removeMethod.addParameter(new GenMethodParameter(normalizedType, newInstance));
		String removeMethodName = association.removeInstance(source.getRole());
		removeMethod.setName(removeMethodName);
		
		GenMethod existing= genClass.methodByIdentifier(removeMethod.identifier());
		if(existing != null){
			removeMethod= existing;
		}else{
			genClass.addMethod(removeMethod);
		}
		
		removeMethod.setVisibility(Visibilities.PUBLIC);
		addChecker("wasRemoved", removeMethod);
		removeMethod.addBody(new GenBody(association.removeImplementation()));
		return removeMethod;
	}

	private static GenMethod registerAddAtMethod(GenAssociation association) {
		GenClass genClass = association.getOwner();
		GenAssociationEnd source = association.getSource();
		String newInstance= association.newInstanceInstance(source.getRole(), false);
		String normalizedType = association.getOwner().getGenPackage().getNormalizedType(association.getSource().getType());
		
		GenMethod addAtMethod = new GenMethod();
		addAtMethod.setReturnType(CPPTypesConstants.BOOL);
		addAtMethod.addParameter(new GenMethodParameter(normalizedType, newInstance));
		addAtMethod.addParameter(new GenMethodParameter(CPPTypesConstants.INTEGER, "index"));
		addAtMethod.setName(association.addAtInstance(source.getRole()));
		
		GenMethod existing= genClass.methodByIdentifier(addAtMethod.identifier());
		if(existing != null){
			addAtMethod= existing;
		}else{
			genClass.addMethod(addAtMethod);
		}
		
		addAtMethod.setVisibility(Visibilities.PUBLIC);
		
		addAtMethod.addBody(new GenBody(association.addAtImplementation()));
		addChecker("wasAdded", addAtMethod);
		
		return addAtMethod;
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PROCESSOR})
	}, aspect= LoopAspectConstants.PRE)
	public static void operationsProcessor(
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String operationName,
			@GenerationElementParameter(id = IModelingElementDefinitions.ELEMENT_VISIBILITY) String visibility,
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_STATIC) boolean isStatic,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		if(genClass.getName().equals(operationName)){
			return;
		}
		
		boolean isPureVirtual= interfaceObject!= null;
		GenMethod method = new GenMethod();
		
		method.setReturnType(typeName== null || typeName.isEmpty()? "void": typeName);
		method.setName(operationName);
		
		for(Object parameter: generationValueGetter.getList(element, IModelingElementDefinitions.OPERATION_PARAMETERS)){
			String param_type= generationValueGetter.getString(parameter, IModelingElementDefinitions.TYPE_NAME);
			String param_name= generationValueGetter.getString(parameter, IModelingElementDefinitions.NAME);
			GenMethodParameter aParameter = new GenMethodParameter(param_type, param_name);
			aParameter.setNormalize(true);
			method.addParameter(aParameter);
		}
		
		GenMethod existing= genClass.methodByName(method.getName());
		if(existing != null){
			return;
		}
		
		method.setUserDefined(true);
		
		String operationBody= generationValueGetter.getString(element, IModelingElementDefinitions.OPERATION_BODY, CPPCommonConstants.CPP_LANGUAGE);
		List<?> constraints = generationValueGetter.getList(element, IModelingElementDefinitions.CONSTRAINTS);
		for (Object constraint : constraints) {
			List<?> names = generationValueGetter.getList(constraint, IModelingElementDefinitions.NAMES);
			for (Object _name : names) {
				GenConstraint genConstraint = new GenConstraint();
				genConstraint.setPriority(GenPriorities.LOW);
				GenConstraintCondition aCondition = new GenConstraintCondition();
				aCondition.setString(generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS, Boolean.FALSE));
				
				genConstraint.addCondition(aCondition);
				GenConstraintVariable constraintVariable = new GenConstraintVariable();
				String name = _name.toString();
				constraintVariable.setName(name);
				constraintVariable.setPlural(generationValueGetter.getBoolean(generationValueGetter.rootElement, IModelingElementDefinitions.IS_PLURAL, name));
				genConstraint.addVariable(constraintVariable);
				genConstraint.setType(GenBody.BEFORE);
				method.addBody(genConstraint);
				
			}
		}
		
		genClass.addMethod(method);
		boolean isAbstract= genClass.getIsAbstract();
		method.setNormalize(true);
		method.setVisibility(Visibilities.PUBLIC);
		addComments(generationValueGetter, element).forEach(comment->method.addComment(comment));
		method.setIsStatic(Boolean.valueOf(isStatic));
		method.setIsVirtual(isAbstract || isPureVirtual);
		method.setIsPure(isAbstract || isPureVirtual);
		method.setIsAbstract(isAbstract);
		
		if(operationBody!= null && !operationBody.isEmpty()){
			method.addBody(new GenBody(operationBody));
		}
		
		method.addDefaultImplementation(new GenBody(generationValueGetter.generate(Generator.METHOD_TODO_STATEMENET, operationName)));
		if(!CPPTypesConstants.VOID.equals(typeName)){
			String defaultValue= generationValueGetter.rootModel.getDefaultValue(typeName);
			method.addDefaultImplementation(new GenBody(generationValueGetter.generate(Generator.RETURN_STATEMENET, defaultValue)));
		}
	}
	
	public static void registerProxyAdd(GenAssociation association) {
		GenAssociationEnd source = association.getSource();
		GenAssociationEnd target = association.getTarget();
		String type= source.getType();
		String otherType= target.getType();
		
		GenClass toClass = association.getOwner();
		//TODO: vulnerable assumption, as we can have the same class name but in different packages
		GenClass genClass= toClass.getGenPackage().rootPackage().classByName(type);
		
		GenConstructorMethod genConstructorMethod = (GenConstructorMethod)genClass.methodByName(genClass.getName());
		List<GenMethodParameter> parameters = genConstructorMethod.asParameters();
		GenMethod method = new GenMethod();
		method.setNormalize(true);
		method.setName(association.addInstance(source.getRole()));
		method.setReturnType(type);
		method.setIsPointer(true);
		method.setVisibility(Visibilities.PUBLIC);
		toClass.addMethod(method);
		
		List<String> parameterStrings= new ArrayList<String>();
		for(GenMethodParameter param: parameters){
			String crudType = param.getCrudType();
			if(!otherType.equals(crudType)){
				String variableInstance = param.getName();
				GenMethodParameter genMethodParameter = new GenMethodParameter(crudType, variableInstance);
				genMethodParameter.setNormalize(true);
				method.addParameter(genMethodParameter);
				parameterStrings.add(variableInstance);
			}else{
				parameterStrings.add("this");
			}
		} 
		String parameterString = parameterStrings.stream().collect(Collectors.joining(", "));
		method.addBody(new GenBody(association.attributeConstructAndAdd(parameterString)));
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void manyAttributesAddHandler(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		GenAssociation association = getAssociation(generationValueGetter, element, parent);
		if(association.getSource().isMany()){
			return;
		}
		if(association == null || association.addDecision()== null){
			return;
		}
		
		registerAddMethod(association);
		registerAddAtMethod(association);
		registerAddOrMoveAt(association);
	}
	
	@LoopProcessorAnnotations(priority= IGenerationPointPriorityConstants.HIGHEST, aspect= LoopAspectConstants.BEFORE, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void setConstructorConstraints(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		addConstraints(generationValueGetter, parent);
	}
	
	private static void addConstraints(GenerationPolicyRegistry generationValueGetter, Object parent) {
		List<?> constraintObjects= generationValueGetter.getList(parent, IModelingElementDefinitions.CONSTRAINTS);
		GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(parent, IModelingElementDefinitions.NAME));
		GenConstraint genConstraint= new GenConstraint();
		genConstraint.setPriority(GenPriorities.LOW);
		for(Object constraint: constraintObjects){
			List<?> names = generationValueGetter.getList(constraint, IModelingElementDefinitions.NAMES);
			for(Object _name: names){
				GenConstraintVariable constraintVariable = new GenConstraintVariable();
				String name = _name.toString();
				constraintVariable.setName(name); 
				constraintVariable.setPlural(generationValueGetter.getBoolean(generationValueGetter.rootElement, IModelingElementDefinitions.IS_PLURAL, name));
				genConstraint.addVariable(constraintVariable);
			}
			
			GenConstraintCondition aCondition = new GenConstraintCondition();
			aCondition.setString(generationValueGetter.getString(constraint, IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS_CONTENTS, Boolean.FALSE));
			genConstraint.addCondition(aCondition);
		}
		
		if(genConstraint.hasConditions()){
			genClass.addConstructorContent(genConstraint);
		}
	}
	
	private static final String MAIN_EXTRACTOR_REGULAR_EXPRESSION = ".*(static)[ |\\t]+(void)[ |\\t]+(main)[ |\\t]*[(][ |\\t]*(int)[ |\\t]+[a-z|A-Z|0-9|_]+(,)[ |\\t]*(char)[ |\\t]*(\\*).*"; //$NON-NLS-1$
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void searchAndRegisterExtraMains(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		String code = generationValueGetter.getString(element, IModelingElementDefinitions.CODE);
		String generate = extractMain(code);
		if(generate!= null&& !generate.isEmpty()){
			GenClass genClass = generationValueGetter.rootModel.classByName(generationValueGetter.getString(element, IModelingElementDefinitions.NAME));
			GenMethod receiveMethod = new GenMethod();
			genClass.addMethod(receiveMethod);
			receiveMethod.addParameter(new GenMethodParameter("int", "argc"));
			receiveMethod.addParameter(new GenMethodParameter("char", "*argv[]"));
			receiveMethod.setReturnType(CPPTypesConstants.VOID);
			receiveMethod.setVisibility(Visibilities.PUBLIC);
			receiveMethod.setIsStatic(true);
			receiveMethod.setDisableRemote(true);
			receiveMethod.addBody(new GenBody(generate.trim()));
			receiveMethod.setName("main");	//$NON-NLS-1$
		}
	}
	
	public static String extractMain(String code){
		StringBuilder sb = new StringBuilder();
		final Pattern openBrace = Pattern.compile("\\{"); //$NON-NLS-1$
		final Pattern closeBrace = Pattern.compile("\\}"); //$NON-NLS-1$
		int brkCnt = 0;
		boolean mainClass = false;
		String processingString = code.replace("{", "{\n"); //$NON-NLS-1$ //$NON-NLS-2$
		processingString= processingString.replace("}", "}\n"); //$NON-NLS-1$ //$NON-NLS-2$
		for(String line:processingString.split("\n")){ //$NON-NLS-1$
	        if(mainClass) {
	        	for(Matcher mtch=openBrace.matcher(line);mtch.find();brkCnt++);
	        	for(Matcher mtch=closeBrace.matcher(line);mtch.find();brkCnt--);
	        	if(brkCnt <= 0 )  {mainClass = false;} else {
	        	sb.append(line);
	        	sb.append("\n"); //$NON-NLS-1$
	        	}
	        }
	        if(line.matches(MAIN_EXTRACTOR_REGULAR_EXPRESSION) || line.contains("int main "))
	        {
	        	mainClass = true;
	        	brkCnt++;
	        }
		}
		String string = sb.toString();
		if(string.isEmpty()){
			return null;
		}
		
		String trim = string.trim();
		if(trim.startsWith("{")){ //$NON-NLS-1$
			trim= trim.substring(1);
		}
		
		if(trim.endsWith("}")){ //$NON-NLS-1$
			trim= trim.substring(0, trim.length()-2);
		}
		
		return trim.trim();
	}
	
}