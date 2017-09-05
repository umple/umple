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
package cruise.umple.modeling.handlers.cpp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationPolicyRegistryPriorities;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.core.ContentsDescriptor;
import cruise.umple.cpp.core.IGenerationCommonConstants;
import cruise.umple.cpp.gen.ActiveGenMethd;
import cruise.umple.cpp.gen.GenActiveField;
import cruise.umple.cpp.gen.GenAssociation;
import cruise.umple.cpp.gen.GenBody;
import cruise.umple.cpp.gen.GenClass;
import cruise.umple.cpp.gen.GenDepend;
import cruise.umple.cpp.gen.GenField;
import cruise.umple.cpp.gen.GenFieldGeneric;
import cruise.umple.cpp.gen.GenFieldInitializer;
import cruise.umple.cpp.gen.GenGroup;
import cruise.umple.cpp.gen.GenInterface;
import cruise.umple.cpp.gen.GenMethod;
import cruise.umple.cpp.gen.GenMethodParameter;
import cruise.umple.cpp.gen.GenPackage;
import cruise.umple.cpp.gen.GenPriorities;
import cruise.umple.cpp.gen.MemberInitializer;
import cruise.umple.cpp.gen.UniqueGenBody;
import cruise.umple.cpp.gen.Visibilities;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;


public class CPPContentsPointsHandler{

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation
	}, aspect= LoopAspectConstants.AFTER)
	public static void registerClasses(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element){
		boolean usesKey= false;
		boolean isRemote= false;
		boolean usesSinglton= false;
		boolean usesVector= false;	//Will only be false with too trivial models that do not use associations whatsoever
		boolean usesTimeCode= false;
		GenPackage genPackage = generationValueGetter.rootModel;
		
		for(GenClass genClass: genPackage.allClasses()){
			if(genClass.isSingleton()){
				usesSinglton= true;
			}
			
			if(genClass.getIsRemote()){
				isRemote= true;
			}
			
			for(GenAssociation association: genClass.getAssociations()){
				if(association.getIsKey()){
					String baseComparator = association.baseComparator();
					genClass.addPredefinition(new UniqueGenBody(baseComparator, null));
					usesKey= true;
				}else{
					usesVector= true;
				}
			}
			
			for (GenField field : genClass.getFields()) {
				String type = field.getType();
				switch (type) {
				case "tm":
				case "time_t":
				case "Time":
				case "Date":
					for(String include: new String[]{ISTLConstants.TIME_INCLUDE, ISTLConstants.C_TYPE}){
						GenDepend genInclude = new GenDepend(include);
						genInclude.setNamespace(ISTLConstants.STD_LIBRARY);
						genInclude.setIsLibrary(true);
						genInclude.setAddSuffix(true);
						genPackage.addInclude(genInclude);
					}
					usesTimeCode= true;
					break;

				default:
					break;
				}
			}
		}
		
		if(isRemote){
			genPackage.addPredefinition(new UniqueGenBody(genPackage.getLocalHostInvoke(), null));
		}
		
		
		if(usesSinglton){
			genPackage.addPredefinition(new UniqueGenBody(genPackage.singletonTemplateDefinition(), null));
			genPackage.setRequiresThread(true);
		}
		
		if(usesKey){
			genPackage.addPredefinition(new UniqueGenBody(genPackage.getSetElementTemplateImplementation(), null));
			genPackage.addPredefinition(new UniqueGenBody(genPackage.copySetElementTemplateImplementation(), null));
		}
		
		if(usesVector){
			genPackage.addPredefinition(new UniqueGenBody(genPackage.getVectorElementTemplateImplementation(), null));
			genPackage.addPredefinition(new UniqueGenBody(genPackage.copyVectorElementTemplateImplementation(), null));
		}
		
		if(usesTimeCode){
			//Add time code helper
			genPackage.addPredefinition(new UniqueGenBody(genPackage.timeHelpCode(), null));
		}
		
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation
	}, aspect= LoopAspectConstants.AFTER)
	public static void addExternalDefinitions(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage){
		
		GenPackage genPackage = generationValueGetter.rootModel;
		if(genPackage.hasRemoteClass()){
			genPackage.addExternalDefinition(new UniqueGenBody(genPackage.jsonArray(), null));
			for(GenClass genClass: genPackage.getClasses()){
				if(genClass instanceof GenInterface == false && genClass.isGeneratable()){
					genPackage.addExternalDefinition(new UniqueGenBody(genPackage.jsonArrayEntry(genClass.getName()), null));
				}
			}
		}
	}
	
	@LoopProcessorAnnotations(aspect= LoopAspectConstants.AFTER, loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void classInterfaceParentTypesProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage){
		
		String name = generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
		GenClass genClass = generationValueGetter.rootModel.classByName(name);
		
		for (GenField field : genClass.getFields()) {
			if (field.getGroup() == null) {
				field.setGroup(genClass.getAttributeGroup(genClass.indexOfAttributeGroup(new GenGroup(GenClass.ATTRIBUTE_GROUP))));
			}
		}
		
		
		for (GenMethod method : genClass.getMethods()) {
			if (method.getGroup() == null) {
				method.setGroup(genClass.getAttributeGroup(genClass.indexOfAttributeGroup(new GenGroup(GenClass.METHOD_GROUP))));
			}
		}
		
		for(GenMethod method: genClass.getMethods()){
			injectMethod(generationValueGetter, element, method, method.getName());
		}
		
		injectMethod(generationValueGetter, element, genClass.methodByName(name), "constructor");
		
		addPortInterfaceProxyCalls(genClass);
		
		for(GenActiveField field: genClass.activeFields()){
			String fieldName = field.getName();
			GenMethod hasInterfaceMethodOfName = hasInterfaceMethodOfName(genClass, fieldName);
			if(hasInterfaceMethodOfName != null){
				//Required for interface-oriented approach, in which interfaces will have the same methods. So, we need to do that to avoid
				//name collisions
				field.setName(fieldName+ "_Port");
			}
		}
		
		interceptNamesForRemote(genClass);
		
		for (GenField field : genClass.getFields()) {
			String fieldName = field.getName();
			String type = field.getType();
			
			if(field.getIsPointer() && !field.isIsConstant() && !field.isRemote() && !field.getIsStatic() && !field.getIsReference()
					&& !field.getIsReference() && !field.getIsEnum() && !field.getIsMany()){
				GenClass fieldClass= generationValueGetter.rootModel.classByName(type);
				
				if(fieldClass != null){
					//Only initialize fields of user defined types/classes; otherwise, if field class is null, it means that it is a field defined for internal uses.
					MemberInitializer routerInitializer = new MemberInitializer(fieldName);
					routerInitializer.addInitializer(new GenFieldInitializer("NULL"));
					routerInitializer.setPriority(GenPriorities.VERY_HIGH);
					genClass.addMemberInitializer(routerInitializer);
				}
			}
		}
	}

	private static void addPortInterfaceProxyCalls(GenClass genClass) {
		for(GenActiveField field: genClass.activeFields()){
			String fieldName = field.getName();
			GenMethod interfaceMethodOfName = hasInterfaceMethodOfName(genClass, fieldName);
			if(interfaceMethodOfName != null){
				if(interfaceMethodOfName instanceof ActiveGenMethd == false && interfaceMethodOfName.getGenClass() instanceof GenInterface){
					String identifier = interfaceMethodOfName.identifier();
					List<GenMethod> identifierRecursive = identifierRecursive(genClass, identifier);
					if(!identifierRecursive.isEmpty()){
						GenMethod methodByIdentifier = genClass.methodByIdentifier(identifier);
						if(methodByIdentifier == null){
							methodByIdentifier = cloneMethod(interfaceMethodOfName, interfaceMethodOfName.getName());
							methodByIdentifier.setIsVirtual(false);
							methodByIdentifier.setIsPure(false);
							genClass.addMethod(methodByIdentifier);
						}
						
						String collect = interfaceMethodOfName.getParameters().stream().map(GenMethodParameter::getName).collect(Collectors.joining(","));
						String proxyCall = "this->"+ fieldName+"_Port("+ collect+");";
						methodByIdentifier.addBody(new GenBody(proxyCall));
					}
				}
			}
		}
	}

	private static List<GenMethod> identifierRecursive(GenClass genClass, String identifier) {
		List<GenMethod> methods= new ArrayList<GenMethod>();
		for(GenMethod m: genClass.allMethods()){
			if(m.identifier().equals(identifier)){
				methods.add(m);
			}
		}
		
		return methods;
	}
	
	private static GenMethod hasInterfaceMethodOfName(GenClass genClass, String methodName) {
		List<GenClass> collect = genClass.allParents().stream().filter(entry->entry instanceof GenInterface).collect(Collectors.toList());
		collect.add(genClass);
		
		for(GenClass entry: collect){
			for(GenMethod method: entry.getMethods()){
				if(method.getName().equals(methodName)){
					return method;
				}
			}
		}
		
		for(ActiveGenMethd method: genClass.activeMethods()){
			if(method.getBaseName().equals(methodName)){
				return method;
			}
		}
		
		return null;
	}

	private static void injectMethod(GenerationPolicyRegistry generationValueGetter, Object element, GenMethod method, String methodName) {
		List<?> before = generationValueGetter.getList(element, IModelingElementDefinitions.CODE_INJECTION, methodName, Boolean.FALSE, CPPCommonConstants.CPP_LANGUAGE);
		for(Object body: before){
			GenBody genBody = new GenBody(body.toString());
			genBody.setType(GenBody.BEFORE);
			genBody.setPriority(GenPriorities.HIGH);
			method.addBody(genBody);
		}
		
		List<?> after = generationValueGetter.getList(element, IModelingElementDefinitions.CODE_INJECTION, methodName, Boolean.TRUE, CPPCommonConstants.CPP_LANGUAGE);
		for(Object body: after){
			GenBody genBody = new GenBody(body.toString());
			genBody.setType(GenBody.AFTER);
			genBody.setPriority(GenPriorities.LOW);
			method.addBody(genBody);
		}
	}
	
	private static void interceptNamesForRemote(GenClass genClass) {
		if(genClass instanceof GenInterface){
			//Check1234 Interface    remove return
			return;
		}
		String parentName= genClass.getName();
		List<GenMethod> methods = genClass.getMethods();
		if(genClass.getIsRemote()){
			List<GenMethod> newMethods= new ArrayList<GenMethod>();
			for(GenMethod interceptedMethod: methods){
				String methodVisibility = interceptedMethod.getVisibility();
				if("public".equals(methodVisibility)&& !interceptedMethod.isDisableRemote()){
					String originalName= interceptedMethod.getName();
//					GenField inernal = genClass.fieldByName("internal_"+originalName);
//					if(inernal!= null){
//						System.out.println();
//						interceptedMethod.setIsGeneratable(false);
//						continue;
//					}
					
					String identifier = interceptedMethod.identifier().replaceAll("\\*", "").replaceAll("&", "");
					String returnType = interceptedMethod.isNormalize()?interceptedMethod.getNormalizedReturnType():interceptedMethod.getReturnType();
//					String newName= "hashCode".equals(originalName) || "deleteAssociatedObjects".equals(originalName)?originalName:"_"+ originalName;
					String newName= "_"+ originalName;
					GenMethod method = cloneMethod(interceptedMethod, newName);
					String invoke = invoke(interceptedMethod, identifier);
					method.addBody(new GenBody(invoke));
					
					MemberInitializer memberInitializer = new MemberInitializer("_"+ identifier);
					genClass.addMemberInitializer(memberInitializer);
					memberInitializer.addInitializer(new GenFieldInitializer("this"));
					memberInitializer.addInitializer(new GenFieldInitializer("&"+ parentName+ "::"+ newName));
					memberInitializer.addInitializer(new GenFieldInitializer("&_internalScheduler"));
					memberInitializer.addInitializer(new GenFieldInitializer("\""+ newName+ "\""));
					memberInitializer.addInitializer(new GenFieldInitializer("&_messageRouter"));
					
					GenField remoteMethodField = new GenField();
					//remoteMethodField.setVisibility(Visibilities.PUBLIC);
					remoteMethodField.setGroup(method.getGroup());
					remoteMethodField.addGeneric(new GenFieldGeneric(parentName));
					
					remoteMethodField.addGeneric(new GenFieldGeneric(returnType));
					
					List<GenMethodParameter> parameters = method.getParameters();
					for(GenMethodParameter param: parameters){
						String paramType= param.isNormalize()?param.declaration(false):param.getType();
						if(param.getName()!= null || !"void".equals(returnType)){
							remoteMethodField.addGeneric(new GenFieldGeneric(paramType));
						}
//						List<String> split = Arrays.asList(paramType.split(" "));
						
//						if(split.size()==1){
//							paramType= split.get(0);
//						}else{
//							paramType= split.subList(0, split.size()-2).stream().collect(Collectors.joining(" "));
//						}
						
//						if(paramType.contains("void") && parameters.size()== 1){
//							break;
//						}
					}
					
					remoteMethodField.setType("RemoteMethod");
					remoteMethodField.setName("_"+ identifier);
					remoteMethodField.setRemote(true);
					genClass.addField(remoteMethodField);
					//newMethods.add(method);
					interceptedMethod.setName(newName);
					//method.setVisibility("private");
					//String collect = genClass.getMethods().stream().map(GenMethod::getName).collect(Collectors.joining("\n"));
					
					//i.e.: _getSchool
					GenMethod proxyMethod= cloneMethod(interceptedMethod, identifier);
					proxyMethod.addBody(new GenBody(invoke(interceptedMethod, "_"+identifier)));
					newMethods.add(proxyMethod);
					
					//i.e.: getSchool
					GenMethod directProxyMethod= cloneMethod(interceptedMethod, originalName);
					directProxyMethod.setVisibility(Visibilities.PUBLIC);
					directProxyMethod.addBody(new GenBody(invoke(proxyMethod, identifier)));
					newMethods.add(directProxyMethod);
					
					if(interceptedMethod.isUserDefined()){
						//Check1234 Interface
						checkInterfaces(genClass, identifier);
					}
				}else if(interceptedMethod instanceof ActiveGenMethd){
					//FIXME: temp
					ActiveGenMethd active= (ActiveGenMethd) interceptedMethod;
					String base = active.getBaseName();
					for(GenInterface genInterface: genClass.getInterfaces()){
						GenMethod methodByIdentifier = genInterface.methodByName(base);
						if(methodByIdentifier != null){
							//Check1234 Interface
							//methodByIdentifier.setIsGeneratable(false);
							methodByIdentifier.setName("_"+ methodByIdentifier.getName());
						}
					}
				}
			}
			
			for(GenMethod method: newMethods){
				genClass.addMethod(method);
			}
		}
	}

	private static void checkInterfaces(GenClass genClass, String identifier) {
		for(GenInterface genInterface: genClass.getInterfaces()){
			GenMethod methodByIdentifier = genInterface.methodByIdentifier(identifier);
			if(methodByIdentifier != null){
				//methodByIdentifier.setIsGeneratable(false);
				methodByIdentifier.setName("_"+ methodByIdentifier.getName());
			}
		}
	}

	private static String invoke(GenMethod interceptedMethod, String identifier) {
		String invoke= identifier+"("+ interceptedMethod.getParameters().stream()
				.filter(p->p.getName()!= null).map(GenMethodParameter::getName).collect(Collectors.joining(", "))+ ");";
		
		if(!"void".equals(interceptedMethod.getReturnType())){
			invoke= "return "+ invoke;
		}
		
		return invoke;
	}

	private static GenMethod cloneMethod(GenMethod interceptedMethod, String originalName) {
		GenMethod method= new GenMethod();
		method.setName(originalName);
		method.setReturnType(interceptedMethod.getReturnType());
		method.setGroup(interceptedMethod.getGroup());
		method.setIsAbstract(interceptedMethod.getIsAbstract());
		method.setIsConstant(interceptedMethod.getIsConstant());
		method.setIsHeader(interceptedMethod.getIsHeader());
		method.setIsInline(interceptedMethod.getIsInline());
		method.setIsOperator(interceptedMethod.getIsOperator());
		method.setIsPointer(interceptedMethod.getIsPointer());
		method.setIsPure(interceptedMethod.getIsPure());
		method.setIsReference(interceptedMethod.getIsReference());
		method.setIsStatic(interceptedMethod.getIsStatic());
		method.setIsVirtual(interceptedMethod.getIsVirtual());
		method.setNormalize(interceptedMethod.getNormalize());
		method.setPriority(interceptedMethod.getPriority());
		method.setVisibility(Visibilities.PUBLIC);
		method.setDisableRemote(interceptedMethod.getDisableRemote());
		for(GenMethodParameter parameter: interceptedMethod.getParameters()){
			method.addParameter(parameter);
		}
		return method;
	}
	
	private static final int MAIN_ASPECT_GROUP_PRIORITY= 400;
	
	@LoopProcessorAnnotation
	public static void modelCodeIncludes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object modelPackage){
		for(String include: new String[]{ISTLConstants.VECTOR, ISTLConstants.ALGORITHM, ISTLConstants.IO_STREAM, ISTLConstants.CSTRING,
				ISTLConstants.IO_STREAM, ISTLConstants.QUEUE, ISTLConstants.IO_STREAM, ISTLConstants.MAP, 
				ISTLConstants.EXCEPTION, ISTLConstants.STD_EXCEPTION, ISTLConstants.ASSERT_LIBRARY}){
			GenDepend genInclude = new GenDepend(include);
			genInclude.setNamespace(ISTLConstants.STD_LIBRARY);
			genInclude.setIsLibrary(true);
			generationValueGetter.rootModel.addInclude(genInclude);
		}
		
		GenDepend genInclude = new GenDepend(ISTLConstants.STDIO);
		genInclude.setPrioritized(true);
		genInclude.setAddSuffix(true);
		generationValueGetter.rootModel.addInclude(genInclude);
	}
	
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.FINALIZE, priority= GenerationPolicyRegistryPriorities.HIEGHEST)
	public static void modelAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object model){
		String contents = generationValueGetter.rootModel.emitHeader();
		
		String modelPath = generationValueGetter.rootModel.getDirectory();
		String modelName= generationValueGetter.rootModel.rootIncludeName();
		String fileName= modelName+	CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		ContentsDescriptor contentsDescriptor = new ContentsDescriptor(contents, fileName, modelPath);
		
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, contentsDescriptor);
	}
	
	@LoopProcessorAnnotation(aspect= LoopAspectConstants.TERMINATE, priority= GenerationPolicyRegistryPriorities.LOWEST, aspectGroup= MAIN_ASPECT_GROUP_PRIORITY)
	public static void modelPathsAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.FILE_PATH) String filePath,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object model){
		
		String modelPath = generationValueGetter.rootModel.getDirectory();
		String fileName= generationValueGetter.rootModel.getProject()+"_Main" +CommonConstants.DOT +CPPCommonConstants.BODY_FILE_EXTENSION; //$NON-NLS-1$
		
		String mainFunction = generationValueGetter.rootModel.mainFunction();
		
		ContentsDescriptor contentsDescriptor = new ContentsDescriptor(mainFunction, fileName, modelPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, contentsDescriptor);
		
		ContentsDescriptor makeContentsDescriptor = new ContentsDescriptor(generationValueGetter.rootModel.cMake(), 
				"CMakeLists.txt", modelPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, makeContentsDescriptor);
	}

	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	}, aspect= LoopAspectConstants.FINALIZE, priority= GenerationPolicyRegistryPriorities.MEDIUM)
	public static void classAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String parentName){
		
		GenClass genClass = generationValueGetter.rootModel.classByName(parentName);
		if(!genClass.isGeneratable()){
			return;
		}
		
		String fullPath= genClass.fullPath();
		
		String implementationContents = genClass.emitBody();
		String implementationFileName= parentName + CommonConstants.DOT +CPPCommonConstants.BODY_FILE_EXTENSION;
		
		String headerContents = genClass.emitHeader();
		String headerFileName= parentName + CommonConstants.DOT +CPPCommonConstants.HEADER_FILE_EXTENSION;
		
		ContentsDescriptor headerContentsDescriptor = new ContentsDescriptor(headerContents, headerFileName, fullPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, headerContentsDescriptor);
		
		ContentsDescriptor implementationContentsDescriptor = new ContentsDescriptor(implementationContents, implementationFileName, fullPath);
		generationValueGetter.addValue(IGenerationCommonConstants.CONTENTS_DESCRIPTORS, implementationContentsDescriptor);
	}
	
}