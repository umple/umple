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

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;


public class CPPDependsPointsHandler{
	
	public final static String ALL_MODEL_INCLUDES_TRACKER= "cpp.model.all.includes.tracker"; //$NON-NLS-1$
	private final static String PARENT_OBJECTS_TRACKER= "cpp.object.parent.objects.tracker.internal"; //$NON-NLS-1$
	
	private final static String DEPEND_TYPES_TRACKER= "cpp.types.tracker"; //$NON-NLS-1$
	private final static String DEPEND_DIRECT_INCLUDES= "cpp.depends.direct.includes"; //$NON-NLS-1$
	
	
	/**
	 * This is an important usability feature to have in our CPP transformation. Asking the user to add "depend" statement for their code in each used
	 * parameter is some extra work. However, it is not that much, but the issue that in a language when the user forgets about adding the required depend,
	 * they can find a massive number of errors in the generated code due to that missing depends, and finding out that the missing depends is the reason can 
	 * take sometime. In a language such as Java, this is not a problem to realize that missing depend, but in CPP it can be even a nightmare in many cases. 
	 *  
	 */
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PROCESSOR})
	}, aspect= LoopAspectConstants.AFTER)
	public static void operationsProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		List<Object> userAddedDependTypes = generationValueGetter.getValues(DEPEND_TYPES_TRACKER, parent);
		List<Object> parametersArgument = generationValueGetter.getValues(IModelingDecisions.OPERATION_PARAMETER_ARGUMENT, element, parent);
		
		for(Object item: parametersArgument){
			if(item instanceof SimpleEntry== false){
				continue;
			}
			
			SimpleEntry<?, ?> simpleEntry= (SimpleEntry<?, ?>) item;
			Object type = simpleEntry.getKey();
			if(!userAddedDependTypes.contains(type)){
				List<Object> types = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, type);
				if(types.isEmpty()){
					continue;
				}
				
				addDepend(generationValueGetter, parent, type);
			}
		}
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.INCLUDES)
	public static String getHeaderIncludes(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationLoopElement Object modelPackage){
		List<Object> values = generationValueGetter.getValues(ICppDefinitions.HEADER_INCLUDES_TRACKER, element);
		
		List<Object> incompleteObjects = getIncompleteDelcarations(generationValueGetter, modelPackage, element);
		
		List<Object> parentObjects = generationValueGetter.getValues(PARENT_OBJECTS_TRACKER, element);
		
		List<Object> declarations= new ArrayList<Object>();
		for(Object object: values){
			if(object instanceof SimpleEntry){
				SimpleEntry<?, ?> entry= (SimpleEntry<?, ?>) object;
				Object value= entry.getValue();
				Object key = entry.getKey();
				if(value instanceof String== false|| (!parentObjects.contains(key)&& incompleteObjects.contains(key))){
					continue;
				}
				
				declarations.add(value);
			}
		}
		
		return getIncludedReferences(generationValueGetter, GenerationUtil.listToGeneratedString(0, 0, declarations), ICppDefinitions.HEADER_INCLUDES_TRACKER, element, false);
	}

	@GenerationPoint(generationPoint = ICppDefinitions.BODY_INCLUDES)
	public static String getBodyIncludes(@GenerationRegistry final GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement final Object element,
			@GenerationLoopElement Object modelPackage){
		List<Object> values = generationValueGetter.getValues(ICppDefinitions.BODY_INCLUDES_TRACKER, element);
		List<Object> incompleteObjects = getIncompleteDelcarations(generationValueGetter, modelPackage, element);
		
		List<Object> declarations= new ArrayList<Object>();
		List<Object> incompleteDeclaration= new ArrayList<Object>();
		
		List<SimpleEntry<?, ?>> sortedValues= new ArrayList<SimpleEntry<?, ?>>();
		for(Object object: values){
			if(object instanceof SimpleEntry){
				sortedValues.add((SimpleEntry<?, ?>) object);
			}
		}
		
		Collections.sort(sortedValues, new Comparator<SimpleEntry<?, ?>>() {

			@Override
			public int compare(SimpleEntry<?, ?> entry1, SimpleEntry<?, ?> entry2) {
				int entry1Priority= ((Integer)generationValueGetter.getValues(IModelingDecisions.DEPENDS_PRIORITY, entry1, element).get(0)).intValue();
				int entry2Priority= ((Integer)generationValueGetter.getValues(IModelingDecisions.DEPENDS_PRIORITY, entry2, element).get(0)).intValue();
				
				if(entry1Priority== entry2Priority){
					return 0;
				}
				
				return entry1Priority>entry2Priority?-1:1;
			}
			
		});
		
		for(Object object: values){
			if(object instanceof SimpleEntry){
				SimpleEntry<?, ?> entry= (SimpleEntry<?, ?>) object;
				Object key = entry.getKey();
				if(incompleteObjects.contains(key)){
					String modelPath = generationValueGetter.generationPointString(key, IModelingDecisions.MODEL_PATH);
					String typeName = generationValueGetter.getString(key, IModelingElementDefinitions.NAME);
					incompleteDeclaration.add(generationValueGetter.use(ICppDefinitions.INCLUDE_STATEMENT, typeName, modelPath));
				}else{
					Object value= entry.getValue();
					if(value instanceof String== false){
						continue;
					}
					declarations.add(value);
				}
			}
		}
		
		String contents= GenerationUtil.listToGeneratedString(0, 0, declarations);
		String incompleteContents= GenerationUtil.listToGeneratedString(0, 0, incompleteDeclaration);
		
		if(!contents.isEmpty()&& !incompleteContents.isEmpty()){
			contents= contents+ CommonConstants.NEW_LINE;
		}
		contents= contents+ incompleteContents;
		
		return getIncludedReferences(generationValueGetter, contents, ICppDefinitions.BODY_INCLUDES_TRACKER, element, false);
	}
	
	public static String getIncludedReferences(GenerationPolicyRegistry generationValueGetter, String contents, String id, Object element, boolean out){
		String includes= contents;
		
		String librariesUses= CommonConstants.BLANK;
		String librariesIncludes= CommonConstants.BLANK;
		
		List<Object> values = generationValueGetter.getValues(ICppModelingDecisions.CPP_USED_LIBRARIES, element);
		List<Object> outValues = generationValueGetter.getValues(ICppModelingDecisions.CPP_USED_LIBRARIES, element, Boolean.TRUE);
		
		Iterator<Object> iterator;
		if(out){
			iterator= outValues.iterator();
		}else{
			iterator= values.iterator();
		}
		iterator = out?outValues.iterator(): values.iterator();
		
		while(iterator.hasNext()){
			Object library = iterator.next();
			
			if(!out){
				if(outValues.contains(library)){
					continue;
				}
			}
			
			String use = generationValueGetter.use(ICppDefinitions.USE_NAMESPACE, library);
			if(out){
				use= CPPCommonConstants.DECLARATION_COMMON_PREFIX+ use;
			}
			
			librariesUses = librariesUses+ use;
			
			String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, id+ library, element);
			if(!implementationDetails.isEmpty()){
				librariesIncludes= librariesIncludes+ implementationDetails;
			}
			
			
			if(iterator.hasNext()){
				librariesUses= librariesUses+ CommonConstants.NEW_LINE;
				
				if(!implementationDetails.isEmpty()){
					librariesIncludes= librariesIncludes+ CommonConstants.NEW_LINE;
				}
			}
		}
		
		String directDepends = GenerationUtil.getImplementationDetails(generationValueGetter, DEPEND_DIRECT_INCLUDES, element);
		if(!directDepends.isEmpty()){
			if(!librariesIncludes.isEmpty()){
				librariesIncludes= librariesIncludes+ CommonConstants.NEW_LINE;
			}
			librariesIncludes+= directDepends;
		}
		
		return generationValueGetter.use(ICppDefinitions.INCLUDES_DECLARATIONS, out?CommonConstants.BLANK:includes, librariesUses, librariesIncludes);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.INCOMPLETE_DECLARATIONS)
	public static String inlineDeclarations(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage, @GenerationBaseElement Object element){
		
		List<Object> incompleteDEfinitions = generationValueGetter.getValues(ICppDefinitions.INCOMPLETE_NAMESPACES_DEFNITION, element, modelPackage);
		HashMap<Object, SimpleEntry<?, ?>> map= new HashMap<Object, SimpleEntry<?, ?>>();
		for(Object object: incompleteDEfinitions){
			SimpleEntry<?, ?> simple= (SimpleEntry<?, ?>) object;
			Object key = simple.getKey();
			map.put(key, (SimpleEntry<?, ?>) simple.getValue());
		}
		
		SimpleEntry<?, ?> simpleEntry = map.get(element);
		
		Map<SimpleEntry<?, ?>, HashSet<String>> outsideDeclarations= new HashMap<SimpleEntry<?, ?>, HashSet<String>>();
		
		List<Object> values = generationValueGetter.getValues(ICppDefinitions.INCOMPLETE_DECLARATIONS, element);
		for(Object object: values){
			if(object instanceof SimpleEntry){
				SimpleEntry<?, ?> entry= (SimpleEntry<?, ?>) object;
				Object key = entry.getKey();
				
				List<Object> types = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, key);
				
				Object value= entry.getValue();
				if(value instanceof String== false){
					continue;
				}
				
				if(types.isEmpty()){
					continue;
				}
				
				Object type = types.get(0);
				
				if(type.equals(element)){
					continue;
				}
				
				SimpleEntry<?, ?> currentEntry = map.get(type);
				if(simpleEntry== null? currentEntry== null: simpleEntry.equals(currentEntry)){
					continue;
				}
				
				if(currentEntry!= null){
					HashSet<String> set = outsideDeclarations.get(currentEntry);
					if(set== null){
						set= new HashSet<String>();
						outsideDeclarations.put(currentEntry, set);
					}
					set.add((String) value);
				}
			}
		}
		
		String implementationDetails= getExtenrnalIncompleteDefinitions(generationValueGetter, modelPackage, element);
		
		Iterator<SimpleEntry<?, ?>> iterator = outsideDeclarations.keySet().iterator();
		while(iterator.hasNext()){
			SimpleEntry<?, ?> entry = iterator.next();
			
			implementationDetails= implementationDetails+ entry.getKey()+ CommonConstants.NEW_LINE;
			
			String contents = GenerationUtil.listToGeneratedString(0, 0, new ArrayList<Object>(outsideDeclarations.get(entry)));
			contents= StringUtil.indent(contents, 1);
			
			implementationDetails= implementationDetails+ contents+ CommonConstants.NEW_LINE;
			implementationDetails= implementationDetails+ entry.getValue()+ CommonConstants.NEW_LINE;
		}
		
		String externalReferences = CommonConstants.BLANK;
		List<Object> external = generationValueGetter.getValues(ICppModelingDecisions.CPP_USED_LIBRARIES, element, Boolean.TRUE);
		for(Object item: external){
			externalReferences= externalReferences+
					generationValueGetter.use(ICppDefinitions.USE_NAMESPACE, CPPCommonConstants.DECLARATION_COMMON_PREFIX+item)+ CommonConstants.NEW_LINE;
		}
		
		if(!externalReferences.isEmpty()){
			implementationDetails= implementationDetails+ externalReferences;
		}
		
		if(!externalReferences.isEmpty()){
			implementationDetails= generationValueGetter.use(ICppDefinitions.EXTERNAL_NAMESPACES, implementationDetails);
		}
		
		if(implementationDetails.isEmpty()){
			return implementationDetails;
		}
		return CommonConstants.NEW_LINE+ implementationDetails;
	}

	private static String getExtenrnalIncompleteDefinitions(GenerationPolicyRegistry generationValueGetter,
			Object modelPackage, Object element) {
		List<Object> extenralDefinitions = generationValueGetter.getValues(ICppDefinitions.INCOMPLETE_EXTERNAL_NAMESPACES_DEFNITION, element, modelPackage);
		
		Map<SimpleEntry<?,?>, List<String>> map= new HashMap<SimpleEntry<?, ?>, List<String>>();
		for(Object object: extenralDefinitions){
			if(object instanceof SimpleEntry== false){
				continue;
			}
			SimpleEntry<?, ?> entry= (SimpleEntry<?, ?>) object;
			
			Object value = entry.getValue();
			if(value instanceof SimpleEntry== false){
				continue;
			}
			
			Object key = entry.getKey();
			if(key instanceof String== false){
				continue;
			}
			
			List<String> list = map.get(value);
			if(list== null){
				list= new ArrayList<String>();
				map.put((SimpleEntry<?, ?>) value, list);
			}
			list.add((String) key);
		}
		
		String all= CommonConstants.BLANK;
		for(SimpleEntry<?, ?> entry: map.keySet()){
			if(!all.isEmpty()){
				all= all+ CommonConstants.NEW_LINE;
			}
			all= all+ entry.getKey();
			
			List<String> list = map.get(entry);
			if(!list.isEmpty()){
				all= all+ CommonConstants.NEW_LINE;
			}
			
			String contents= CommonConstants.BLANK;
			for(String definition: list){
				if(!contents.isEmpty()){
					contents= contents+ CommonConstants.NEW_LINE;
				}
				contents= contents+ definition;
			}
			
			all= all+ StringUtil.indent(contents, 1)+ CommonConstants.NEW_LINE;
			all= all+ entry.getValue(); 
		}
		if(!all.isEmpty()){
			all= all+ CommonConstants.NEW_LINE;
		}
		return all;
	}

	@GenerationPoint(generationPoint = ICppDefinitions.INCOMPLETE_TYPES_DEFNITION)
	public static String incompleteTypeDefinition(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement Object modelPackage, @GenerationBaseElement Object element) {
		
		List<Object> values = generationValueGetter.getValues(ICppDefinitions.INCOMPLETE_DECLARATIONS, element);
		List<Object> declarations= new ArrayList<Object>();
		for(Object object: values){
			if(object instanceof SimpleEntry){
				SimpleEntry<?, ?> entry= (SimpleEntry<?, ?>) object;
				Object key = entry.getKey();
				
				List<Object> types = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, key);
				
				Object value= entry.getValue();
				if(value instanceof String== false){
					continue;
				}
				
				if(types.isEmpty()){
					continue;
				}
				
				Object type = types.get(0);
				
				if(type.equals(element)){
					continue;
				}
				
				declarations.add(value);
			}
		}
		
		String implementationDetails= CommonConstants.BLANK;
		

		implementationDetails = implementationDetails+ GenerationUtil.listToGeneratedString(0, 0, declarations);
		
		
		if(implementationDetails.isEmpty()){
			return implementationDetails;
		}
		
		return implementationDetails+ CommonConstants.NEW_LINE+ CommonConstants.NEW_LINE;
	}
	
	private static List<Object> getIncompleteDelcarations(GenerationPolicyRegistry generationValueGetter,Object modelPackage, Object element) {
		List<Object> incompleteDeclarations = generationValueGetter.getValues(ICppDefinitions.INCOMPLETE_DECLARATIONS, element);
		List<Object> incompleteObjects= new ArrayList<Object>();
		for(Object object: incompleteDeclarations){
			if(object instanceof SimpleEntry){
				SimpleEntry<?, ?> entry= (SimpleEntry<?, ?>) object;
				Object key= entry.getKey();
				List<Object> types = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, key);
				
				if(types.isEmpty()){
					continue;
				}
				
				incompleteObjects.add(types.get(0));
			}
		}
		return incompleteObjects;
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operation parameters paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, 
					IModelingElementDefinitions.OPERATIONS_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PARAMETERS_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, 
					IModelingElementDefinitions.OPERATIONS_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PARAMETERS_PROCESSOR})
	})
	public static void operationsParametersProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationLoopElement Object model,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, model, type);
		if(values== null|| values.isEmpty()){
			//ERROR: Means that the type is undefined
			return;
		}
		Object parameterObject = values.get(0);
		
		String parameterTypeName= generationValueGetter.getString(parameterObject, IModelingElementDefinitions.TYPE_NAME);
		if(parameterTypeName== null|| parameterTypeName.isEmpty()){
			//If type not defined, then, define by name. This is required for classes and interfaces
			parameterTypeName= generationValueGetter.getString(parameterObject, IModelingElementDefinitions.NAME);
		}
		
		//Will be required for the includes on the implementation/declaration signature
		generationValueGetter.generationPointString(parent, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, parameterTypeName), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(parent, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, parameterTypeName));
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Operations path*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.OPERATIONS_PROCESSOR})
	})
	public static void operationsProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.RETURN_TYPE) String returnType,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		if(returnType!= null){
			//Will be required for the for both delcaration/implementation return type include
			generationValueGetter.generationPointString(parent, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, returnType));
			
			generationValueGetter.generationPointString(parent, IModelingDecisions.DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, returnType), 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR})
	})
	public static void classAndInterfaceProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		
		String modelPackageName= generationValueGetter.generationPointString(element, CPPCommonConstants.PACKAGE_SUFFIX);
		
		//Include package header in both body and header files
		generationValueGetter.generationPointString(element, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, modelPackageName),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(element, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, modelPackageName),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT, Boolean.TRUE),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.EX_HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		//Add header include to the header file in the body
		generationValueGetter.generationPointString(element, IModelingDecisions.DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, name),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.HIGHEST)),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		generationValueGetter.addValue(ICppDefinitions.PRE_PROCESSING_DEFINITION_NAME, modelPackageName+ CommonConstants.UNDERSCORE+ name, element);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			/*Associations variables paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ASSOCIATION_VARIABLES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ASSOCIATION_VARIABLES_PROCESSOR}),
			
			/*Association paths*/
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.ATTRIBUTES_PROCESSOR})
	})
	public static void attributesAndAssociationsDeclarationProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		if(isMany){
			//If isMany, then this means we are going to use vector, so include it to the includes list of the header
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, manyTypeName),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
			
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, manyTypeName),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, 
			ifNotConditionIds= {ICppDefinitions.ATTRIBUTE_DISABLE_DELETE})
	public static void setDestructorDetails(
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		if(isMany){
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.ALGORITHM),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
			
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.MEMORY),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
		
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR}, aspect= LoopAspectConstants.BEFORE),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR}, aspect= LoopAspectConstants.BEFORE)
	})
	public static void classInterfaceParentTypesProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingConstants.PARENT_CLASS) Object parentClass,
			@GenerationElementParameter(id = IModelingConstants.PARENT_INTERFACES) List<?> parentInterfaces){
		
		if(parentClass!= null){
			//Make sure to include the parent class to the header incomplete type definitions
			generationValueGetter.generationPointString(element, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, parentClass));
			
			generationValueGetter.generationPointString(element, IModelingDecisions.DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, parentClass), 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.HIGH)),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
			
			generationValueGetter.addUniqueValue(PARENT_OBJECTS_TRACKER, parentClass, element);
		}
		
		if(parentInterfaces!= null){
			for(Object obj: parentInterfaces){
				generationValueGetter.generationPointString(element, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, obj));
				
				generationValueGetter.generationPointString(element, IModelingDecisions.DEPENDS_GENERATION_POINT, 
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, obj), 
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(IGenerationPointPriorityConstants.HIGH)),
						GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
				
				generationValueGetter.addUniqueValue(PARENT_OBJECTS_TRACKER, obj, element);
			}
		}
	}
	
	@GenerationPoint(generationPoint = ICppAssociationsDefinitionsConstants.SETTER_GENERATION_POINT)
	public static void setterIncludeDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= ICppAssociationsDefinitionsConstants.SetterMessages.HANDLE_ID) String id,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HASH_MAP_DECLARATION.equals(id)){
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.HASH_MAP),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, manyTypeName),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}else if(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MINIMUM_FIXED_DECLARATION.equals(id)){
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, manyTypeName),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT)
	public static void constructorIncludeDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument boolean isAttribute, @GenerationArgument String id,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		if(IModelingConstructorDefinitionsConstants.SET_NEW_ARRAY.equals(id)){
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, manyTypeName),
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ATTRIBUTE_GENERATION_POINT)
	public static void attributesAndAssociationsProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationProcedureParameter(id= IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		if(!isPrimitiveType){
			generationValueGetter.generationPointString(parent, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, type));
			
			generationValueGetter.generationPointString(parent, IModelingDecisions.DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, type), 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	@DecisionPoint(decisionPoint = IModelingDecisions.DEPENDS_CHECK_CIRCULARITY_ARGUMENT, optimistic= true)
	public static boolean avoidDependCirculairty(@GenerationArgument(id= IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT) String includeId) {
		return ICppDefinitions.HEADER_INCLUDES_TRACKER.equals(includeId);
	}
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.DEPENDS_PROCESSOR}),
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.INTERFACES_PROCESSOR, IModelingElementDefinitions.DEPENDS_PROCESSOR})
	}, aspect= LoopAspectConstants.PRE)
	public static void dependsProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.USE) String use,
			@GenerationLoopElement Object modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String headerExtension = CommonConstants.DOT+ CPPCommonConstants.HEADER_FILE_EXTENSION;
		
		//Check for "Or" instead of "and" in order to avoid buggy includes
		//depend "stdio.h"
		//depend <stdio.h>
		//Error i.e: <stdio.h
		if(use.startsWith(CommonConstants.LESS_THAN)|| use.endsWith(CommonConstants.LESS_THAN)|| use.endsWith(CommonConstants.QUOTATION)||use.startsWith(CommonConstants.QUOTATION)){
			String normalized = use;
			
			if(normalized.startsWith(CommonConstants.LESS_THAN)){
				normalized= normalized.substring(0, normalized.length()-1)+ CommonConstants.MORE_THAN;
			}else if(normalized.endsWith(CommonConstants.MORE_THAN)){
				normalized= CommonConstants.LESS_THAN+ normalized.substring(1, normalized.length());
			}else if(normalized.startsWith(CommonConstants.QUOTATION)){
				normalized= normalized.substring(0, normalized.length()-1)+ CommonConstants.QUOTATION;
			}else if(normalized.endsWith(CommonConstants.QUOTATION)){
				normalized= CommonConstants.QUOTATION+ normalized.substring(1, normalized.length());
			}else{
				//Buggy include
				//We make sure to detect bad includes as C++ return a lot of errors hard that make it hard to determine that
				//the bad include was the reason
				return;
			}
			
			String includeStatement = generationValueGetter.use(ICppDefinitions.INCLUDE_DIRECT_STATEMENT, normalized);
			generationValueGetter.addUniqueValue(DEPEND_DIRECT_INCLUDES, includeStatement, parent);
			return;
		}
		
		String normalized = use.replace(CommonConstants.DOT, CommonConstants.FORWARD_SLASH).replace(CommonConstants.STRICT_DOT, CommonConstants.FORWARD_SLASH);
		
		int lastIndexOf = normalized.lastIndexOf(CommonConstants.FORWARD_SLASH);
		
		if(lastIndexOf>-1){
			String namespace= normalized.substring(0, lastIndexOf).replace(CommonConstants.FORWARD_SLASH, CommonConstants.DOT);
			
			List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_BY_NAMESPACES_TRACKER, modelPackage, 
					namespace);
			if(values.isEmpty() /*external library */){
				String library= namespace.replace(CommonConstants.DOT, CPPCommonConstants.DECLARATION_COMMON_PREFIX);
				
				String[] trackers = new String[]{ICppDefinitions.BODY_INCLUDES_TRACKER, ICppDefinitions.HEADER_INCLUDES_TRACKER};
				
				for(String trackerId: trackers){
					generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
							GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, library), 
							GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, trackerId));
				}
				
				String include= normalized.substring(lastIndexOf+1, use.length());
				
				if(CommonConstants.ASTERISK.equals(include)){
					//Means that the user decided to go with using qualified names. i.e "using std", and then std::string
					//instead of "using std", "include <string>, and then use string directly
					return;
				}
				
				for(String trackerId: trackers){
					generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
							GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, include),
							GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, library),
							GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, trackerId));
				}
				
				return;
			}
			
			if(CommonConstants.ASTERISK.equals(use.substring(use.length()-1, use.length()))){
				namespace= use.substring(0, use.lastIndexOf(CommonConstants.ASTERISK)-1);
				values = generationValueGetter.getValues(IModelingConstants.TYPES_BY_NAMESPACES_TRACKER, modelPackage, namespace);
				
				String modelPath = generationValueGetter.generationPointString(modelPackage, IModelingDecisions.MODEL_PATH);
				for(Object value: values){
					String typeName= generationValueGetter.getString(value, IModelingElementDefinitions.NAME);
					String typeString= modelPath+ CommonConstants.FORWARD_SLASH+ typeName;
					typeString= typeString.replace(CommonConstants.DOT, CommonConstants.FORWARD_SLASH);
					
					normalized = typeString+ headerExtension;
					
					addDepend(generationValueGetter, parent, typeName);
				}
			}else{
				if(!normalized.endsWith(headerExtension)){
					normalized= normalized+ headerExtension;
				}
				
				String typeString = normalized.substring(lastIndexOf+1, normalized.lastIndexOf(headerExtension));
				addDepend(generationValueGetter, parent, typeString);
			}
		}else{
			if(generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, normalized).isEmpty()){
				//No namespace was found. No type tracked, then it must be added as an arbitrary include statement
				String includeStatement = generationValueGetter.use(ICppDefinitions.INCLUDE_DIRECT_STATEMENT, normalized, Boolean.TRUE);
				generationValueGetter.addUniqueValue(DEPEND_DIRECT_INCLUDES, includeStatement, parent);
			}else{
				addDepend(generationValueGetter, parent, normalized);
			}
		}
	}

	private static void addDepend(GenerationPolicyRegistry generationValueGetter, Object parent, Object typeString) {
		//Add the type of the header to the incomplete types, so it will compile in the header, and add the actual include in the body
		generationValueGetter.generationPointString(parent, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, typeString));
		
		generationValueGetter.generationPointString(parent, IModelingDecisions.DEPENDS_GENERATION_POINT, 
			GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, typeString),
			GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		generationValueGetter.addUniqueValue(DEPEND_TYPES_TRACKER, typeString, parent);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_GENERATION_POINT)
	public static void setGetterDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.MANY_TYPE_NAME) String manyTypeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		if(isMany){
			generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, manyTypeName), 
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ATTRIBUTE_GENERATION_POINT, 
			priority= IGenerationPointPriorityConstants.LOWEST, ifConditionIds= IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_CAN_PRINT, unique= true)
	public static void copyConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.OSTREAM), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.OSTREAM), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
	}
	
	@GenerationPoint(generationPoint = ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT)
	public static void addLibraryIncludeStatement(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object container,
			@GenerationArgument(id= ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT) String include,
			@GenerationArgument(id= ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT) String library,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_OUTSIDE_ARGUMENT) boolean isOutside,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT) String includeId) {
		
		
		if(include!= null&& !include.isEmpty()){
			String includeStatement = generationValueGetter.use(ICppDefinitions.BUILTIN_INCLUDE_STATEMENT, include);
			generationValueGetter.addUniqueValue((includeId!= null?includeId: CommonConstants.BLANK)+ library, includeStatement, container);
		}
		
		String normalized= library.replace(CommonConstants.UNDERSCORE, CommonConstants.DOT).replace(CommonConstants.FORWARD_SLASH, CommonConstants.DOT);
		
		List<String> filtered= new ArrayList<String>();
		for(String split: normalized.split("\\.")){ //$NON-NLS-1$
			if(CommonConstants.ASTERISK.equals(split)){
				continue;
			}
			filtered.add(split);
		}
		
		
		String qualifiedLibrary= CommonConstants.BLANK;
		
		Iterator<String> iterator = filtered.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			if(CommonConstants.ASTERISK.equals(next)){
				continue;
			}
			qualifiedLibrary= qualifiedLibrary+ next;
			if(iterator.hasNext()){
				qualifiedLibrary= qualifiedLibrary+ CPPCommonConstants.DECLARATION_COMMON_PREFIX;
			}
		}
		
		if(isOutside){
			generationValueGetter.addUniqueValue(ICppModelingDecisions.CPP_USED_LIBRARIES, qualifiedLibrary, container, Boolean.TRUE);
		}else{
			String typeNamespace= generationValueGetter.getString(container, IModelingElementDefinitions.NAMESPACE);
			if(typeNamespace!= null&& typeNamespace.startsWith(qualifiedLibrary.replace(CPPCommonConstants.DECLARATION_COMMON_PREFIX, CommonConstants.DOT))){
				return;
			}
			
			generationValueGetter.addUniqueValue(ICppModelingDecisions.CPP_USED_LIBRARIES, qualifiedLibrary, container);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS_IMPLEMENTATION, priority=IGenerationPointPriorityConstants.HIGH)
	public static void addParametersDepends(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument List<Object> allParameters){
		
		if(allParameters== null|| allParameters.isEmpty()){
			return;
		}
		
		for(Object item: allParameters){
			@SuppressWarnings("unchecked")
			SimpleEntry<Object, SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>> current= 
					(SimpleEntry<Object, SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>>) item;
			
			SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>> simpleEntry= current.getValue();
			
			String value = simpleEntry.getKey().getValue();
			generationValueGetter.generationPointString(parent, IModelingDecisions.DEPENDS_GENERATION_POINT, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, value), 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
			
			generationValueGetter.generationPointString(parent, ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, 
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT, value));
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DEPENDS_GENERATION_POINT)
	public static void addIncludeStatement(
			@GenerationProcedureParameter(id= IModelingDecisions.DEPENDS_CHECK_CIRCULARITY_ARGUMENT) boolean checkCirculaity,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object container,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_IS_ROOT_ARGUMENT) boolean isRoot,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object type, 
			@GenerationArgument(id= IModelingDecisions.DEPENDS_PRIORITY) int priority,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_IS_CUSTOM_ARGUMENT) boolean isCustom,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT) String includeId,
			@GenerationArgument(id= IModelingDecisions.MODEL_PATH, adjust= false) String modelPath,
			@GenerationProcedureParameter(id= IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationLoopElement Object modelPackage) {
		
		if(isPrimitiveType){
			//Language types, and no need for any includes
			return;
		}
		
		if(isRoot){
			String rootPath = generationValueGetter.generationPointString(modelPackage, IModelingConstants.ROOT_PATH);
			String rootName = generationValueGetter.generationPointString(modelPackage, IModelingConstants.ROOT_NAME);
			String modelName= generationValueGetter.generationPointString(modelPackage, CPPCommonConstants.PACKAGE_SUFFIX);
			
			String includeStatement = generationValueGetter.use(ICppDefinitions.INCLUDE_STATEMENT, modelName, rootPath);
			
			SimpleEntry<Object, String> entry= new SimpleEntry<Object, String>(modelPackage, includeStatement);
			generationValueGetter.addUniqueValue(includeId, entry, container);
			generationValueGetter.addUniqueValue(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(priority), entry, container);
			
			String alias = generationValueGetter.use(ICppDefinitions.ROOT_ALIAS, rootName,modelName);
			generationValueGetter.addUniqueValue(ICppDefinitions.ALIAS, alias, modelPackage, Boolean.TRUE);
			
			return;
		}
		
		Object rootType;
		String typeName= CommonConstants.BLANK;
		String includeStatement= CommonConstants.BLANK;
		if(isCustom){
			if(type instanceof String== false){
				return;
			}
			rootType= type;
			includeStatement = generationValueGetter.use(ICppDefinitions.BUILTIN_INCLUDE_STATEMENT, rootType);
		}else{
			if(type instanceof String== false){	//Allow including by object
				rootType= type;
				typeName= generationValueGetter.getString(type, IModelingElementDefinitions.NAME);
			}else{	
				//Allow including by string type
				typeName= (String) type;
				List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
				
				if(!values.isEmpty()){
					rootType= values.get(0);
				}else{
					rootType= modelPackage;
				}
			}
			
			if(checkCirculaity&& rootType== container){
				return;
			}
			
			String expectedModelPath = modelPath== null?generationValueGetter.generationPointString(rootType, IModelingDecisions.MODEL_PATH):modelPath;
			includeStatement = generationValueGetter.use(ICppDefinitions.INCLUDE_STATEMENT, typeName, expectedModelPath);
		}
		
		SimpleEntry<Object, String> entry= new SimpleEntry<Object, String>(rootType, includeStatement);
		generationValueGetter.addUniqueValue(includeId, entry, container);
		
		String typeNamespace= generationValueGetter.getString(rootType, IModelingElementDefinitions.NAMESPACE);
		if(typeNamespace== null){
			typeNamespace= CommonConstants.BLANK;
		}
		
		String alias = generationValueGetter.use(ICppDefinitions.ALIAS, typeName,typeNamespace.replace(CommonConstants.DOT, 
				CommonConstants.BACK_SLASH), typeNamespace.replace(CommonConstants.DOT, CommonConstants.FORWARD_SLASH));
		generationValueGetter.addUniqueValue(ICppDefinitions.ALIAS, alias, modelPackage);
		
		generationValueGetter.addUniqueValue(IModelingDecisions.DEPENDS_PRIORITY, Integer.valueOf(priority), entry, container);
		generationValueGetter.addUniqueValue(ALL_MODEL_INCLUDES_TRACKER, includeStatement, "Main"); //$NON-NLS-1$
	}
	
	@GenerationPoint(generationPoint = ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, priority= IGenerationPointPriorityConstants.HIGHEST, unique= true)
	public static boolean vectorExtraDefiniton(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object container,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT) String includeId,
			@GenerationArgument(id= ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT) String include) {
		
		if(ISTLConstants.HASH_MAP.equals(include)&& ICppDefinitions.BODY_INCLUDES_TRACKER.equals(includeId)){
			String use = generationValueGetter.use(ICppDefinitions.GNUC_DEFINITION);
			generationValueGetter.addUniqueValue(ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS, use, container);
			return true;
		}
		return false;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS)
	public static String preProcessorInclude(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element) {
		String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, ICppDefinitions.PRE_PROCESSORS_INCUDES_DEFINITIONS, element);
		if(implementationDetails.isEmpty()){
			return implementationDetails;
		}
		return implementationDetails+ CommonConstants.NEW_LINE;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.CLASS_INCOMPLETE_DECLARATION)
	public static void classInlineDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object type, 
			@GenerationBaseElement Object container,
			@GenerationLoopElement Object modelPackage,
			@GenerationProcedureParameter(id= IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType) {
		
		if(isPrimitiveType){
			//Language types, and no need for any includes
			return;
		}
		
		String typeName;
		
		if(type instanceof String== false){	//Allow including by object
			typeName= generationValueGetter.getString(type, IModelingElementDefinitions.NAME);
		}else{	
			//Allow including by string type
			typeName= (String) type;
		}
		
		List<Object> types = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
		
		if(types.isEmpty()){
			return;
		}
		
		Object typeObject = types.get(0);
		String typeNamespace= generationValueGetter.getString(typeObject, IModelingElementDefinitions.NAMESPACE);
		String containerNamespace= generationValueGetter.getString(container, IModelingElementDefinitions.NAMESPACE);
		if(typeNamespace!= containerNamespace){
			generationValueGetter.generationPointString(container, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
					GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, typeNamespace),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_OUTSIDE_ARGUMENT, Boolean.TRUE),
					GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
			addNamespace(generationValueGetter, typeNamespace, typeName, container, modelPackage);
		}else{
			String inlineClassDelcaration = generationValueGetter.use(ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, typeName);
			SimpleEntry<String, String> incompleteDeclaration= new SimpleEntry<String, String>(typeName, inlineClassDelcaration);
			generationValueGetter.addUniqueValue(ICppDefinitions.INCOMPLETE_DECLARATIONS, incompleteDeclaration, container);
		}
		
	}
	
	private static boolean addNamespace(GenerationPolicyRegistry generationValueGetter, String namespace, String typeName, Object container, Object model) {
		if(namespace== null|| namespace.isEmpty()){
			return false;
		}
		
		String normalized= namespace.replace(CommonConstants.UNDERSCORE, CommonConstants.DOT).replace(CommonConstants.FORWARD_SLASH, CommonConstants.DOT);
		String[] splits = normalized.split("\\."); //$NON-NLS-1$
		
		String open= CommonConstants.BLANK;
		String close= CommonConstants.BLANK;
		String defineBaseString= CommonConstants.BLANK;
		
		for(String split: splits){
			open= open+ generationValueGetter.use(ICppDefinitions.NAMESPACE, split)+ CommonConstants.SPACE+ CommonConstants.OPEN_BRACE+ CommonConstants.SPACE;
			close= close+ CommonConstants.CLOSE_BRACE+ CommonConstants.SPACE;
			defineBaseString= defineBaseString+ CommonConstants.UNDERSCORE+ split;
		}
		
		String begin = defineBaseString+ CommonConstants.UNDERSCORE+ CPPCommonConstants.BEGIN.toUpperCase();
		String end = defineBaseString+ CommonConstants.UNDERSCORE+ CPPCommonConstants.END.toUpperCase();
		
		String inlineClassDelcaration = generationValueGetter.use(ICppDefinitions.CLASS_INCOMPLETE_DECLARATION, typeName);
		SimpleEntry<Object, SimpleEntry<String, String>> entry = 
				new SimpleEntry<Object, SimpleEntry<String, String>>(inlineClassDelcaration, new SimpleEntry<String, String>(begin, end));
		generationValueGetter.addUniqueValue(ICppDefinitions.INCOMPLETE_EXTERNAL_NAMESPACES_DEFNITION, entry, container, model);
		
		return true;
	}
	
}