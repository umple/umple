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
*i
* @author -Ahmed M.Orabi {@link ahmedvc@hotmail.com}
* @author Mahmoud M.Orabi {@link mahmoud_3rabi@hotmail.com}
*******************************************************************************/
package cruise.umple.modeling.handlers.cpp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.GenerationPolicyRegistryPriorities;
import cruise.umple.core.Generator;
import cruise.umple.core.LoopProcessorAnnotation;
import cruise.umple.core.LoopProcessorAnnotation.LoopAspectConstants;
import cruise.umple.core.LoopProcessorAnnotation.LoopProcessorAnnotations;
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;

public class CppTestsPointsHandler{
	
//	private static final String INTERNAL_DEFINED_VALUE = "@@@@"; //$NON-NLS-1$
//
//	public static boolean GENERATE_TESTS= true;
//	
//	private static final int FINALIZE_HIGH_PRIORITY= 600;
//	private final static String TEST_CLASS_INSTANCE_NAMES_TRACKER= "cpp.test.class.construct.name.tracker"; //$NON-NLS-1$
//	private final static String TEST_CLASS_PARAMETERS_DEFINED_INTERNALLY_TRACKER= "cpp.test.class.parameters.defined.internally.tracker"; //$NON-NLS-1$
//	private final static String TEST_CLASS_PARAMETERS_VALUES_IN_CONSTRUCTOR_TRACKER= "cpp.test.class.construct.parameters.values.in.constructor.tracker"; //$NON-NLS-1$
//	private final static String TEST_CLASS_PARAMETERS_NUMBER_OF_TRACKER= "cpp.test.class.number.of.tracker"; //$NON-NLS-1$
//	
//	private final static String TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER= "cpp.test.class.instance.associations.tracker"; //$NON-NLS-1$
//	
//	private final static String TEST_FILES_INCLUDES= "cpp.test.file"; //$NON-NLS-1$
//	
//	@GenerationPoint(generationPoint = ICppDefinitions.MAIN_PRE_CONTENTS)
//	public static String preContents(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
//			@GenerationLoopElement Object modelPackage){
//		if(!GENERATE_TESTS){
//			return null;
//		}
//		return CommonConstants.NEW_LINE+ GenerationUtil.getImplementationDetails(generationValueGetter, TEST_FILES_INCLUDES, modelPackage);
//	}
//	
//	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
//			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
//	}, aspect= LoopAspectConstants.FINALIZE, priority= GenerationPolicyRegistryPriorities.MEDIUM, aspectGroup= FINALIZE_HIGH_PRIORITY)
//	public static void classAfterProcessor(@GenerationRegistry final GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement final Object element,
//			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) final String name,
//			@GenerationLoopElement final Object modelPackage) throws IOException{
//		if(!GENERATE_TESTS){
//			return;
//		}
//		generateTests(generationValueGetter, element, name, modelPackage);
//		System.gc();
//		Runtime.getRuntime().freeMemory();
//	}
//	
////	@LoopProcessorAnnotation(aspect= LoopAspectConstants.TERMINATE)
////	public static void terminate(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
////			@GenerationLoopElement Object modelPackage) throws IOException{
////		if(!GENERATE_TESTS){
////			return;
////		}
////		List<Object> files = generationValueGetter.getValues(TEST_FILE, modelPackage);
////		if(!files.isEmpty()){
////			BufferedWriter output = (BufferedWriter) files.get(0);
////			
////			String endContents= generationValueGetter.generate(Generator.TEST_FILE_END, modelPackage);
////			output.write(endContents);
////			
////			output.close();
////			generationValueGetter.removeValue(TEST_FILE, output, modelPackage);
////		}
////	}
//
//	protected static void generateTests(GenerationPolicyRegistry generationValueGetter,
//			Object element, String name, Object modelPackage) throws IOException {
//		
//		String modelPath = generationValueGetter.getString(modelPackage, IModelingElementDefinitions.FILE_PATH);
//		
//		String methodTestName = "test"+StringUtil.firstCharacterToUpperCase(name); //$NON-NLS-1$
//		
//		List<Object> namesValues = generationValueGetter.getValues(TEST_CLASS_INSTANCE_NAMES_TRACKER, ICppTestsDefinitions.TEST_STUBS);
//		String testStubNextName = ICppTestsDefinitions.TEST_STUBS;
//		if(!namesValues.isEmpty()){
//			testStubNextName= testStubNextName+ namesValues.size();
//		}
//		generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_NAMES_TRACKER, testStubNextName, ICppTestsDefinitions.TEST_STUBS);
//		
//		File folderFile = new File(modelPath+ CommonConstants.BACK_SLASH+ testStubNextName+ ".h"); 	 //$NON-NLS-1$
//		 
//		if (!folderFile.exists()) {
//			folderFile.createNewFile();
//		}
//		BufferedWriter output = new BufferedWriter(new FileWriter(folderFile));
//		
//		//generationValueGetter.addUniqueValue(ICppDefinitions.MAIN_CONTENTS, assertStatements+ CommonConstants.NEW_LINE);
//			
//		String useAllNamespaces= CommonConstants.BLANK;
//		Iterator<Object> namespacesIterator = generationValueGetter.getAllValues(IModelingConstants.NAMESPACES_TRACKER, modelPackage).iterator();
//		while(namespacesIterator.hasNext()){
//			String object = namespacesIterator.next().toString();
//			object= object.replace(CommonConstants.UNDERSCORE, CPPCommonConstants.DECLARATION_COMMON_PREFIX).
//					replace(CommonConstants.DOT, CPPCommonConstants.DECLARATION_COMMON_PREFIX);
//			useAllNamespaces= useAllNamespaces+ generationValueGetter.generate(Generator.USE_NAMESPACE, CPPCommonConstants.DECLARATION_COMMON_PREFIX+object);
//			
//			if(namespacesIterator.hasNext()){
//				useAllNamespaces= useAllNamespaces+ CommonConstants.NEW_LINE;
//			}
//		}
//			
//		String implementationDetails = GenerationUtil.getImplementationDetails(generationValueGetter, CPPDependsPointsHandler.ALL_MODEL_INCLUDES_TRACKER, "Main"); //$NON-NLS-1$
//		if(!useAllNamespaces.isEmpty()){
//			if(!implementationDetails.isEmpty()){
//				implementationDetails= implementationDetails+ CommonConstants.NEW_LINE;
//			}
//			implementationDetails= implementationDetails+ useAllNamespaces;
//		}
//			
//		String startContents= generationValueGetter.generate(Generator.TEST_FILE_START, modelPackage, implementationDetails, testStubNextName, methodTestName);
//			output.write(startContents);
//		 
//		String instanceName= getNextAvailableName(generationValueGetter, element);
//		
//		constructInstance(generationValueGetter, output, modelPackage, element, name, instanceName);
//		
//		List<Object> ids = generationValueGetter.getValues(IModelingConstants.METHOD_IDS, element);
//		
//		if(!ids.isEmpty()){
//			List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, name);
//			
//			for(Object current: ids){
//				if(current instanceof String== false){
//					continue;
//				}
//				String identifier= (String) current;
//				assertGetter(generationValueGetter, modelPackage, output, element, instanceName, identifier);
//				assertSetter(generationValueGetter, output, element, modelPackage, instanceName, identifier);
//				assertInternalConstruct(generationValueGetter, output, element, modelPackage, instanceName, identifier);
//				assertMany(generationValueGetter, output, element, modelPackage, instanceName, identifier);
//			}
//			
//			String delete = Generator.DELETE_METHOD;
//			output.newLine();
//			appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, element, 
//					instanceName, delete));
//			
//			for(Object associationVariable: generationValueGetter.getList(element, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES)){
//				String type= generationValueGetter.getString(associationVariable, IModelingElementDefinitions.TYPE_NAME);
//				int lowerBound = generationValueGetter.getInt(associationVariable, IModelingElementDefinitions.LOWER_BOUND);
//				int upperBound = generationValueGetter.getInt(associationVariable, IModelingElementDefinitions.UPPER_BOUND);
//				
//				//Fixed are removed all
//				boolean mustBeZero= generationValueGetter.getBoolean(associationVariable, IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY)||
//						generationValueGetter.getBoolean(associationVariable, IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND);
//				
//				setSize(generationValueGetter, instanceName, type, lowerBound== upperBound||mustBeZero?0: lowerBound);
//			}
//			
//			for(Object current: ids){
//				appendToFile(output, assertRestrictions(generationValueGetter, (String) current,element,instanceName, values.get(0)));
//			}
//		}
//		
//		//output.write(StringUtil.indent(assertStatements+ CommonConstants.NEW_LINE, 1));
//		
//		String testStubCall= generationValueGetter.generate(Generator.METHOD_INVOCATION, methodTestName, CommonConstants.BLANK, Boolean.TRUE);
//		String endContents= generationValueGetter.generate(Generator.TEST_FILE_END, modelPackage);
//		output.write(endContents);
//		output.close();
//		generationValueGetter.addUniqueValue(ICppDefinitions.MAIN_CONTENTS, testStubCall);
//		
//		String rootPath = generationValueGetter.generationPointString(modelPackage, IModelingConstants.ROOT_PATH);
//		String include = generationValueGetter.generate(Generator.INCLUDE_STATEMENT, testStubNextName, rootPath);
//		generationValueGetter.addUniqueValue(TEST_FILES_INCLUDES, include, modelPackage);
//	}
//
//	private static void assertInternalConstruct(GenerationPolicyRegistry generationValueGetter, BufferedWriter output, Object element, Object modelPackage,
//			String instanceName, String identifier) throws IOException {
//		List<Object> internalConstructors = generationValueGetter.getValues(""/*IModelingConstructorDefinitionsConstants.CONSTRUCT_OBJECT_INTERNALLY*/, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		
//		if(internalConstructors.isEmpty()){
//			//TODO: Do not forget JUnit assertion here
//			return;
//		}
//		
//		Object object = internalConstructors.get(0);
//		if(object instanceof HashMap== false){
//			return;
//		}
//		
//		HashMap<?, ?> map= (HashMap<?, ?>) object;
//		Object methodObject = map.get(/*IModelingConstants.METHOD_OBJECT */"");
//		String typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.TYPE_NAME);
//		List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
//		
//		if(values.isEmpty()){
//			return;
//		}
//		
//		//generationValueGetter.generationPoint(values.get(0), ICppDefinitions.CONSTRUCTOR_INTERNAL_CONSTRUCTION_PARAMETERS_LIST,typeName, element);
//				
//		int numberOfLoops= !canAdd(generationValueGetter, instanceName, null, methodObject)? 1:
//				generationValueGetter.getInt(methodObject, IModelingElementDefinitions.UPPER_BOUND);
//		if(numberOfLoops==-1){
//			numberOfLoops=1;
//		}else{
//			numberOfLoops++;
//		}
//		
//		Object constructMethodNameObject = map.get(IModelingConstants.METHOD_NAME);
//		
//		Object containingObject = values.get(0);
//		
//		for(int index=0; index<numberOfLoops; index++){
//			List<String> randomValues= new ArrayList<String>();
//			output.newLine();
//			setConstrctorValues(generationValueGetter, output, modelPackage, containingObject, element, instanceName, randomValues, false, true);
//			
//			String parametersString= CommonConstants.BLANK;
//			
//			Iterator<String> iterator = randomValues.iterator();
//			while(iterator.hasNext()){
//				String randomValue = iterator.next();
//				
//				parametersString= parametersString+ randomValue;
//				if(iterator.hasNext()){
//					parametersString= parametersString+ CommonConstants.COMMA_SEPARATOR;
//				}
//			}
//			
//			appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, element,instanceName, constructMethodNameObject, 
//					parametersString));
//			
//			if(!canAdd(generationValueGetter, instanceName, null, methodObject)){
//				output.newLine();
//				appendToFile(output, "//Previous add must not have worked due to restrictions");  //$NON-NLS-1$
//				continue;
//			}
//			increaseSize(generationValueGetter, instanceName, typeName);
//			//generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, callee, instanceName);
//		}
//		output.newLine();
//	}
//
//	private static void assertSetter(GenerationPolicyRegistry generationValueGetter,BufferedWriter output, 
//			Object element, Object modelPackage, String instanceName, String identifier) throws IOException {
//		List<Object> setters = generationValueGetter.getValues(""/*TODO:Generator.SETTER_IMPLEMENTATION*/, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		
//		if(setters.isEmpty()){
//			//TODO: Do not forget JUnit assertion here
//			return;
//		}
//		
//		Object object = setters.get(0);
//		if(object instanceof HashMap== false){
//			return;
//			
//		}
//		
//		List<Object> getterValues = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		
//		if(getterValues.isEmpty()){
//			//TODO: Do not forget JUnit assertion here. It is weird to have setter and no getter
//			return;
//		}
//		
//		Object getterObject = getterValues.get(0);
//		
//		HashMap<?, ?> getterMap= (HashMap<?, ?>) getterObject;
//		Object getterMethodNameObject = getterMap.get(IModelingConstants.METHOD_NAME);
//		
//		output.newLine();
//		output.newLine();
//		
//		HashMap<?, ?> map= (HashMap<?, ?>) object;
//		
//		Object setterMethodNameObject = map.get(IModelingConstants.METHOD_NAME);
//		
//		Object methodObject = map.get(/*IModelingConstants.METHOD_OBJECT */"");
//		String typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.TYPE_NAME);
//		
//		
//		List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
//		
//		Object currentParamaeterInstanceValue= getDefinedValue(generationValueGetter, element, instanceName, typeName, identifier, methodObject);
//		String newParamaeterInstanceValue = getSomeRandomValue(generationValueGetter,output, modelPackage, instanceName, typeName, identifier, methodObject);
//		
//		//TODO: Find better condition
//		boolean isAssociationSetter = currentParamaeterInstanceValue== newParamaeterInstanceValue&& currentParamaeterInstanceValue== CPPCommonConstants.NULL;
//		
//		String nextAvailableName= null;
//		if(isAssociationSetter){
//			List<Object> allValues = values;
//			if(allValues.isEmpty()){
//				return;
//			}
//			Object typeCalss= allValues.get(0);
//			nextAvailableName = getNextAvailableName(generationValueGetter, typeCalss);
//			constructInstance(generationValueGetter,output, modelPackage, typeCalss, typeName, nextAvailableName);
//			
//			output.newLine();
//			newParamaeterInstanceValue = nextAvailableName;
//			
//			appendToFile(output, assertRestrictions(generationValueGetter, identifier,methodObject,nextAvailableName, instanceName));
//			output.newLine();
//		}
//		
//		appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, element,instanceName, setterMethodNameObject, newParamaeterInstanceValue));
//		output.newLine();
//		
//		int otherEndUpperBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.OTHER_END_UPPER_BOUND);
//		int otherEndLowerBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.OTHER_END_LOWER_BOUND);
//		
//		int otherRange= (otherEndUpperBound== otherEndLowerBound&& otherEndUpperBound==1)? 1:
//			otherEndUpperBound==-1?otherEndUpperBound:otherEndUpperBound- otherEndLowerBound;
//		
//		//int upperBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.UPPER_BOUND);
//		//int lowerBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.LOWER_BOUND);
//		//
//		//int range= (upperBound== lowerBound&& upperBound==1)? 1:
//		//	upperBound==-1?upperBound:upperBound- lowerBound;
//		
//		//Expected to be NULL for most case
//		String normalizedValue= generationValueGetter.generationPointString(methodObject, IModelingConstants.NORMALIZED_DEFAULT_VALUE);
//		
//		if(generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_DIRECTED)||
//				generationValueGetter.getPathMap(methodObject).get(IModelingElementDefinitions.ATTRIBUTES_PROCESSOR)!= null||
//				(generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OPTIONAL)&&
//						generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND)||
//						generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE)||
//						generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_UNBOUND)||
//						generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_OPTIONAL)||
//						generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL))/*||
//				(generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_ONE)&&
//				generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND))*/){
//			appendToFile(output, generationValueGetter.generate(Generator.ASSERT_GETTER, element, 
//					instanceName, getterMethodNameObject, newParamaeterInstanceValue));
//			output.newLine();
//		}else{
//			output.newLine();
//			appendToFile(output, "//Checking to see that the previous setter did not work due to the minimum restriction contraints"); //$NON-NLS-1$
//			output.newLine();
//			appendToFile(output, generationValueGetter.generate(Generator.ASSERT_GETTER, element,
//					instanceName, getterMethodNameObject, currentParamaeterInstanceValue));
//			output.newLine();
//		}
//		
////		if(otherRange==0|| generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY)){
////			if(otherEndUpperBound!=0 && otherEndLowerBound!= 0){
////				assertStatements.append(CommonConstants.NEW_LINE);
////				assertStatements.append("//Checking to see that the previous setter did not work due to the minimum restriction contraints"); //$NON-NLS-1$
////				assertStatements.append(CommonConstants.NEW_LINE);
////				assertStatements.append(generationValueGetter.generate(Generator.ASSERT_GETTER, element,
////						instanceName, getterMethodNameObject, currentParamaeterInstanceValue)+ CommonConstants.NEW_LINE);
////			}else{
////				assertStatements.append(generationValueGetter.generate(Generator.ASSERT_GETTER, element,
////						instanceName, getterMethodNameObject, newParamaeterInstanceValue)+ CommonConstants.NEW_LINE);
////			}
////		}else{
////			assertStatements.append(generationValueGetter.generate(Generator.ASSERT_GETTER, element,
////					instanceName, getterMethodNameObject, newParamaeterInstanceValue)+ CommonConstants.NEW_LINE);
////			
////			assertStatements.append(generationValueGetter.generate(Generator.METHOD_CALL, element,instanceName, setterMethodNameObject, normalizedValue));
////			
////			//If range is zero (fixed relations) or lower bound cannot be less than one, then set NULL must not have worked
////			if(otherEndLowerBound==1|| generationValueGetter.getInt(methodObject, IModelingElementDefinitions.LOWER_BOUND)>0){
////				assertStatements.append(CommonConstants.NEW_LINE);
////				assertStatements.append("//Checking to see that the previous setter did not work due to the minimum restriction contraints"); //$NON-NLS-1$
////				assertStatements.append(CommonConstants.NEW_LINE);
////				assertStatements.append(generationValueGetter.generate(Generator.ASSERT_GETTER, element,
////						instanceName, getterMethodNameObject, newParamaeterInstanceValue)+ CommonConstants.NEW_LINE);
////			}else{
////				assertStatements.append(CommonConstants.NEW_LINE);
////				assertStatements.append(generationValueGetter.generate(Generator.ASSERT_GETTER, element,
////						instanceName, getterMethodNameObject, normalizedValue)+ CommonConstants.NEW_LINE);
////			}
////		}
//		
//		if(isAssociationSetter){
//			appendToFile(output, assertRestrictions(generationValueGetter, identifier,methodObject,nextAvailableName, instanceName));
//			output.newLine();
//		}
//		
//		//Required check if the original value is NULL
//		//Required check if the setter was not working due to restrictions on the other side
//		if(!currentParamaeterInstanceValue.equals(INTERNAL_DEFINED_VALUE)&&
//				!currentParamaeterInstanceValue.equals(normalizedValue)&& otherRange!=0|| (otherRange==0&& otherEndUpperBound==0 && otherEndLowerBound== 0)){
//			//Reset and then assert the original value
//			appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, element,
//					instanceName, setterMethodNameObject, currentParamaeterInstanceValue));
//			
//			output.newLine();
//			appendToFile(output, generationValueGetter.generate(Generator.ASSERT_GETTER, element,
//					instanceName, getterMethodNameObject, currentParamaeterInstanceValue));
//		}
//		
//		if(isAssociationSetter){
//			appendToFile(output, assertRestrictions(generationValueGetter, identifier, methodObject,nextAvailableName, instanceName));
//			output.newLine();
//		}
//	}
//
//	private static void assertGetter(GenerationPolicyRegistry generationValueGetter,Object modelPackage, 
//			BufferedWriter output, Object element, String instanceName, String identifier) throws IOException {
//		List<Object> getterValues = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		
//		if(getterValues.isEmpty()){
//			//TODO: Do not forget JUnit assertion here
//			return;
//		}
//		
//		Object getterObject = getterValues.get(0);
//		
//		HashMap<?, ?> getterMap= (HashMap<?, ?>) getterObject;
//		Object getterMethodNameObject = getterMap.get(IModelingConstants.METHOD_NAME);
//		
//		Object methodObject = getterMap.get(/*IModelingConstants.METHOD_OBJECT */"");
//		String typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.TYPE_NAME);
//		
//		
//		Object paramaeterInstanceValue= getDefinedValue(generationValueGetter, element, instanceName, typeName, identifier, methodObject);
//		
//		String operator= null;
//		List<Object> trackedTypes = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
//		
//		if(INTERNAL_DEFINED_VALUE.equals(paramaeterInstanceValue)){
//			operator= CommonConstants.NOT+ CommonConstants.EQUAL;
//			paramaeterInstanceValue= CPPCommonConstants.NULL;
//		}else{
//			if(!trackedTypes.isEmpty()&& generationValueGetter.getValues(TEST_CLASS_PARAMETERS_DEFINED_INTERNALLY_TRACKER, element).contains(identifier)){
//				operator= CommonConstants.NOT+ CommonConstants.EQUAL;
//			}
//		}
//		
//		output.newLine();
//		appendToFile(output, generationValueGetter.generate(Generator.ASSERT_GETTER, element, 
//				instanceName, getterMethodNameObject, paramaeterInstanceValue, null, operator));
//	}
//
//	private static void assertMany(GenerationPolicyRegistry generationValueGetter,BufferedWriter output, 
//			Object element, Object modelPackage, String instanceName, String identifier) throws IOException {
//		if(getAddMethodName(generationValueGetter, identifier, element)== null){
//			return;
//		}
//		
//		List<Object> allAddImplementationsValues = generationValueGetter.getValues("" /* Generator.ADD_IMPLEMENTATION */, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		Object object = allAddImplementationsValues.get(0);
//		HashMap<?, ?> map= (HashMap<?, ?>) object;
//		Object methodObject = map.get(/*IModelingConstants.METHOD_OBJECT */"");
//		String typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.TYPE_NAME);
//		Object rootType = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName).get(0);
//		
//		int lowerBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.LOWER_BOUND);
//		int upperBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.UPPER_BOUND);
//		
//		appendToFile(output, assertRestrictions(generationValueGetter, identifier, element,instanceName, rootType));
//		
//		String typeInstanceName = addCall(generationValueGetter, modelPackage, output, identifier, instanceName, element);
//		
//		int otherEndUpperBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.OTHER_END_UPPER_BOUND);
//		int otherEndLowerBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.OTHER_END_LOWER_BOUND);
//		
//		int range= (otherEndUpperBound== otherEndLowerBound&& otherEndUpperBound==1)? 1:
//				otherEndUpperBound==-1?otherEndUpperBound:upperBound- lowerBound/*otherEndUpperBound- otherEndLowerBound*/;
//		
//		appendToFile(output, assertRestrictions(generationValueGetter, identifier,element,instanceName, methodObject));
//		
//		remove(generationValueGetter,modelPackage,output, element, instanceName, identifier, rootType, typeInstanceName, methodObject);
//		
//		if(range!=0){
//			List<String> someExtraAdds= new ArrayList<String>();
//			
//			String fullConstructedObject = fullConstructedObject(generationValueGetter, output, element, modelPackage, typeName, rootType);
//			if(fullConstructedObject!= null){
//				addCall(generationValueGetter, output, identifier, instanceName, element, fullConstructedObject);
//				appendToFile(output, assertRestrictions(generationValueGetter, identifier, element,instanceName, rootType));
//				
//				remove(generationValueGetter,modelPackage,
//						output, element, instanceName, identifier, rootType,
//						fullConstructedObject/*,lowerBound, expectedNewLength*/, methodObject);
//			}
//			
//			for(int i=0; i<4; i++){
//				String instanceNewVariable= getNextAvailableName(generationValueGetter, rootType, typeName);
//				
//				output.newLine();
//				constructInstance(generationValueGetter,output, modelPackage, rootType, typeName, instanceNewVariable);
//				
//				addCall(generationValueGetter, output, identifier, instanceName, element, instanceNewVariable);
//				someExtraAdds.add(instanceNewVariable);
//			}
//			
//			appendToFile(output, assertRestrictions(generationValueGetter, identifier, element,instanceName, rootType));
//		}
//		
//		addAt(generationValueGetter, output, element, modelPackage, instanceName, identifier, typeName, rootType, methodObject, 2);
//	}
//
//	private static void addAt(GenerationPolicyRegistry generationValueGetter,
//			BufferedWriter output, Object element, Object modelPackage,
//			String instanceName, String identifier, String typeName,
//			Object rootType, Object methodObject, int index) throws IOException {
//		List<Object> addAtImplementationsValues = generationValueGetter.getValues("" /* Generator.ADD_AT_IMPLEMENTATION */, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		
//		if(addAtImplementationsValues.isEmpty()){
//			return;
//		}
//		
//		Object addAtMethodName = ((HashMap<?, ?>)addAtImplementationsValues.get(0)).get(IModelingConstants.METHOD_NAME);
//		String instanceNewVariable= getNextAvailableName(generationValueGetter, rootType, typeName);
//		output.newLine();
//		constructInstance(generationValueGetter, output, modelPackage, rootType, typeName, instanceNewVariable);
//	
//		output.newLine();
//		appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, element, 
//				instanceName, addAtMethodName, instanceNewVariable+ CommonConstants.COMMA_SEPARATOR+ String.valueOf(index)));
//		
//		int expectedNewLength= getSize(generationValueGetter, instanceName, typeName);
//		int place= index;
//		
//		if(!canAdd(generationValueGetter, instanceName, instanceNewVariable, methodObject)){
//			//Means that it was not added due to maximum restriction violation
//			place= -1;
//			
//			output.newLine();
//			appendToFile(output, "//Previous add at must not have worked due to restrictions");  //$NON-NLS-1$
//			//TODO: add JUnit
//		}else{
//			expectedNewLength = 1+ expectedNewLength;
//			increaseSize(generationValueGetter, instanceName, typeName);
//		}
//		
//		List<Object> indexOfImplementationsValues = generationValueGetter.getValues("" /*Generator.INDEX_OF_IMPLEMENTATION*/, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		if(!indexOfImplementationsValues.isEmpty()){
//			Object indexOfMethodName = ((HashMap<?, ?>)indexOfImplementationsValues.get(0)).get(IModelingConstants.METHOD_NAME);
//			
//			if(place==-1){
//				output.newLine();
//				output.newLine();
//				appendToFile(output, "//Check for -1 as the previous add at should have not worked due to the upper bound restriction"); //$NON-NLS-1$
//			}
//			int updatedSize= getSize(generationValueGetter, instanceName, typeName);
//			if(place>=getSize(generationValueGetter, instanceName, typeName)){
//				place= updatedSize-1;
//				output.newLine();
//				appendToFile(output, "//Check for the end index as the last add at exceeded the size"); //$NON-NLS-1$
//			}
//			output.newLine();
//			appendToFile(output, generationValueGetter.generate(Generator.ASSERT_GETTER, element, 
//					instanceName, indexOfMethodName, String.valueOf(place), instanceNewVariable));
//		}
//	}
//
//	private static boolean remove(GenerationPolicyRegistry generationValueGetter,Object modelPackage, BufferedWriter output, Object element, String instanceName,
//			String identifier, Object rootType, String typeInstanceName, Object methodObject) throws IOException {
//		
//		List<Object> removeImplementationsValues = generationValueGetter.getValues("TODO"/*Generator.REMOVE_IMPLEMENTATION*/, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		if(removeImplementationsValues.isEmpty()){
//			return false;
//		}
//		
//		Object removeObject = removeImplementationsValues.get(0);
//		
//		if(removeObject instanceof HashMap== false){
//			return false;
//		}
//		
//		HashMap<?, ?> removeMap= (HashMap<?, ?>) removeObject;
//		
//		Object removeMethodNameObject = removeMap.get(IModelingConstants.METHOD_NAME);
//		
//		int currentLength= getSize(generationValueGetter, instanceName, rootType);
//		
//		String currentElementName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
//		Object associationElement = getAssociationElement(generationValueGetter, rootType, currentElementName);
//		String typeName= generationValueGetter.getString(rootType, IModelingElementDefinitions.NAME);
//		
//		if(associationElement!= null){
//			setToTheOriginal: {
//				int associationLowerBound= generationValueGetter.getInt(associationElement, IModelingElementDefinitions.LOWER_BOUND);
//				if(associationLowerBound==1){
//					String defaultPArameterName= getDefaultIdentifier(generationValueGetter, rootType, currentElementName);
//					List<Object> values = generationValueGetter.getValues(TEST_CLASS_PARAMETERS_VALUES_IN_CONSTRUCTOR_TRACKER, typeInstanceName, 
//							currentElementName, defaultPArameterName, rootType);
//					if(values.isEmpty()){
//						break setToTheOriginal;
//					}
//					
//					List<Object> setters = generationValueGetter.getValues(""/*TODO:Generator.SETTER_IMPLEMENTATION*/, defaultPArameterName, rootType, 
//							VisibilityConstants.PUBLIC);
//					
//					if(setters.isEmpty()){
//						currentLength= currentLength+1;
//						break setToTheOriginal;
//					}
//					
//					Object setterObject = setters.get(0);
//					if(setterObject instanceof HashMap== false){
//						currentLength= currentLength+1;
//						break setToTheOriginal;
//						
//					}
//					
//					HashMap<?, ?> subMap = (HashMap<?, ?>) setterObject;
//					Object setterMethodNameObject = subMap.get(IModelingConstants.METHOD_NAME);
//					Object subMethodObject = subMap.get(/*IModelingConstants.METHOD_OBJECT */"");
//					String subTypeName= generationValueGetter.getString(subMethodObject, IModelingElementDefinitions.TYPE_NAME);
//					
//					output.newLine();
//					output.newLine();
//					appendToFile(output, "//Reset the value of "+ typeInstanceName+ "'s "+ currentElementName+ " instead");  //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
//					
//					int setterUpperBound = generationValueGetter.getInt(subMethodObject, IModelingElementDefinitions.UPPER_BOUND);
//					int setterLowerBound = generationValueGetter.getInt(subMethodObject, IModelingElementDefinitions.LOWER_BOUND);
//					
//					String originalConstructorParameterValue;
//					int delta = 0;
//					if(setterUpperBound>1|| setterUpperBound==-1){
//						output.newLine();
//						String newListConstruct = generationValueGetter.generate(Generator.NEW_LIST_DEFINITION, subMethodObject);
//						String normalizedType = generationValueGetter.generationPointString(subMethodObject, IModelingConstants.NORMALIZED_TYPE_NAME);
//						originalConstructorParameterValue = typeInstanceName+ CommonConstants.UNDERSCORE+ subTypeName+ "_Many_Reset"; //$NON-NLS-1$
//						String assignStatement = generationValueGetter.generate(Generator.ASSIGN_STATEMENET, 
//								originalConstructorParameterValue, newListConstruct, normalizedType);
//						
//						appendToFile(output, assignStatement);
//						output.newLine();
//						
//						//Construct a number of instances and add them to the vector/set to match the minimum constraints requirements
//						for(int index=0; index<setterLowerBound; index++){
//							String newListValue = originalConstructorParameterValue+ CommonConstants.UNDERSCORE+ getNextAvailableName(generationValueGetter, element, subTypeName);
//							
//							output.newLine();
//							constructInstance(generationValueGetter, output, modelPackage, 
//									generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, subTypeName).get(0), subTypeName, newListValue);
//							output.newLine();
//							
//							String add= generationValueGetter.generationPointString(element, ""/*TODO TODOICppDefinitions.ADD_INVOCATION */,
//									GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, originalConstructorParameterValue),
//									GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, newListValue));
//							
//							generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, newListValue, typeInstanceName);
//							appendToFile(output, add);
//							output.newLine();
//						}
//						delta= delta-setterLowerBound;
//					}else{
//						delta=-1;
//						originalConstructorParameterValue =  getNextAvailableName(generationValueGetter, element); //values.get(0);
//						output.newLine();
//						constructInstance(generationValueGetter,output, modelPackage, element, currentElementName, originalConstructorParameterValue);
//					}
//					
//					output.newLine();
//					appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, rootType,typeInstanceName, setterMethodNameObject, 
//							originalConstructorParameterValue));
//					
//					
//					if(canDecrease(generationValueGetter, instanceName, typeInstanceName, rootType, element, methodObject, delta)){
//						updateSize(generationValueGetter, instanceName, typeName, delta);
//						
//						currentLength= getSize(generationValueGetter, instanceName, rootType);
//						generationValueGetter.removeValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, typeInstanceName, instanceName);
//					}else{
//						appendToFile(output, assertRestrictions(generationValueGetter, identifier, element,instanceName, rootType));
//					}
//				}
//			}
//		}
//		
//		output.newLine();
//		appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, element, 
//				instanceName, removeMethodNameObject, typeInstanceName));
//		
//		if(canDecrease(generationValueGetter, instanceName, typeInstanceName, rootType, element, methodObject,1)){
//			decreaseSize(generationValueGetter, instanceName, typeName);
//			currentLength= getSize(generationValueGetter, instanceName, rootType);
//			generationValueGetter.removeValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, typeInstanceName, instanceName);
//		}else{
//			output.newLine();
//			appendToFile(output, "//Previous remove must not have worked due to restrictions"); //$NON-NLS-1$
//		}
//		
//		appendToFile(output, assertRestrictions(generationValueGetter, identifier, element,instanceName, rootType));
//		
//		return true;
//	}
//
//	private static boolean canDecrease(GenerationPolicyRegistry generationValueGetter,
//			String instanceName, String typeInstanceName, Object rootType, Object element, Object methodObject, int delta) {
//		if(!generationValueGetter.getValues(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, instanceName).contains(typeInstanceName)){
//			return false;
//		}
//		
//		String typeName= generationValueGetter.getString(rootType, IModelingElementDefinitions.NAME);
//		String currentElementName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
//		int currentSize = getSize(generationValueGetter, typeInstanceName, currentElementName);
//		int otherCurrentSize = getSize(generationValueGetter, instanceName, typeName);
//		int currentLength= getSize(generationValueGetter, instanceName, rootType);
//		int expectedNewLength = currentLength- delta;
//		int lowerBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.LOWER_BOUND);
//		
//		int otherLowerBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.OTHER_END_LOWER_BOUND);
//		
//		boolean canDecreae= false;
//		decrease: {
//			if(generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_DIRECTED)){
//				canDecreae= otherCurrentSize>lowerBound;
//				break decrease;
//			}
//			
//			if(!generationValueGetter.getValues(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, instanceName).contains(typeInstanceName)){
//				canDecreae= false;
//				break decrease;
//			}
//			
//			if(generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_MANY)&&
//					generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY)){
//				canDecreae= expectedNewLength>=lowerBound && currentSize>otherLowerBound;
//				break decrease;
//			}
//			
//			if(generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL)&&
//					generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND)){
//				canDecreae= currentSize>otherLowerBound && otherCurrentSize>lowerBound;
//				break decrease;
//			}
//			
//			if(generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL)&&
//					generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED)){
//				canDecreae= currentSize>otherLowerBound;
//				break decrease;
//			}
//			
//			if(generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_UNBOUND)&&
//					generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND)){
//				canDecreae= currentSize>lowerBound /*&& otherCurrentSize>otherLowerBound*/;
//				break decrease;
//			}
//			
//			if(generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY)&&
//					generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED)){
//				canDecreae= otherCurrentSize>lowerBound;
//				break decrease;
//			}
//			
//			if(generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND)&&
//					generationValueGetter.decisionPoint(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED)){
//				canDecreae= expectedNewLength>=lowerBound && currentSize>otherLowerBound;
//				break decrease;
//			}
//			
//			if(expectedNewLength>=lowerBound&& generationValueGetter.getInt(methodObject, IModelingElementDefinitions.OTHER_END_LOWER_BOUND)<=
//				otherCurrentSize){
//				canDecreae= true;
//				break decrease;
//			}
//		}
//		return canDecreae;
//	}
//
//	private static String fullConstructedObject(GenerationPolicyRegistry generationValueGetter,
//			BufferedWriter output, Object element, Object modelPackage,
//			String typeName, Object rootType) throws IOException {
//		String nextTypeInstanceName= null;
//		//Create full object that used all setter in order to ensure that we will use other options if there due to having non-null values
//		List<Object> ids = generationValueGetter.getValues(IModelingConstants.METHOD_IDS, rootType);
//		if(!ids.isEmpty()){
//			//Here
//			nextTypeInstanceName= getNextAvailableName(generationValueGetter, rootType, typeName);
//			
//			output.newLine();
//			constructInstance(generationValueGetter,output, modelPackage, rootType, typeName, nextTypeInstanceName);
//			
//			for(Object current: ids){
//				if(current instanceof String== false){
//					continue;
//				}
//				String otherIdentifier= (String) current;
//				
//				List<Object> setters = generationValueGetter.getValues(""/*TODO:Generator.SETTER_IMPLEMENTATION*/, otherIdentifier, rootType, 
//						VisibilityConstants.PUBLIC);
//				
//				if(setters.isEmpty()){
//					continue;
//				}
//				
//				Object setterObject = setters.get(0);
//				
//				if(setterObject instanceof HashMap== false){
//					continue;
//				}
//				
//				output.newLine();
//				
//				HashMap<?, ?> subMap = (HashMap<?, ?>) setterObject;
//				Object setterMethodNameObject = subMap.get(IModelingConstants.METHOD_NAME);
//				
//				Object subMethodObject = subMap.get(/*IModelingConstants.METHOD_OBJECT */"");
//				
//				int lowerBound = generationValueGetter.getInt(subMethodObject, IModelingElementDefinitions.LOWER_BOUND);
//				int upperBound = generationValueGetter.getInt(subMethodObject, IModelingElementDefinitions.UPPER_BOUND);
//				
//				String subTypeName= generationValueGetter.getString(subMethodObject, IModelingElementDefinitions.TYPE_NAME);
//				
//				String newParamaeterInstanceValue;
//				if(upperBound>1|| upperBound==-1){
//					
//					String newListConstruct = generationValueGetter.generate(Generator.NEW_LIST_DEFINITION, subMethodObject);
//					String normalizedType = generationValueGetter.generationPointString(subMethodObject, IModelingConstants.NORMALIZED_TYPE_NAME);
//					newParamaeterInstanceValue = nextTypeInstanceName+ CommonConstants.UNDERSCORE+ subTypeName+ "_Many"; //$NON-NLS-1$
//					String assignStatement = generationValueGetter.generate(Generator.ASSIGN_STATEMENET, 
//							newParamaeterInstanceValue, newListConstruct, normalizedType);
//					
//					appendToFile(output, assignStatement);
//					output.newLine();
//					
//					//Construct a number of instances and add them to the vector/set to match the minimum constraints requirements
//					for(int index=0; index<lowerBound; index++){
//						String newListValue = newParamaeterInstanceValue+ CommonConstants.UNDERSCORE+ getNextAvailableName(generationValueGetter, element, subTypeName);
//						
//						output.newLine();
//						constructInstance(generationValueGetter, output, modelPackage, 
//								generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, subTypeName).get(0), subTypeName, newListValue);
//						output.newLine();
//						
//						String add= generationValueGetter.generationPointString(element, ""/*TODO TODOICppDefinitions.ADD_INVOCATION */,
//								GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, newParamaeterInstanceValue),
//								GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, newListValue));
//						
//						generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, newListValue, nextTypeInstanceName);
//						increaseSize(generationValueGetter, nextTypeInstanceName, subTypeName);
//						appendToFile(output, add);
//					}
//				}else{
//					newParamaeterInstanceValue = getSomeRandomValue(generationValueGetter,output, modelPackage, nextTypeInstanceName, 
//							subTypeName, otherIdentifier, subMethodObject);
//				}
//				
//				output.newLine();
//				
//				appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, element,nextTypeInstanceName, setterMethodNameObject, 
//						newParamaeterInstanceValue));
//				
//			}
//		}
//		return nextTypeInstanceName;
//	}
//	
//	private static Object getAssociationElement(GenerationPolicyRegistry generationValueGetter,
//			Object containingElement, String typeName) {
//		
//		for(Object item: getElementParameters(generationValueGetter, containingElement)){
//			@SuppressWarnings("unchecked")
//			SimpleEntry<Object, SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>> current= 
//					(SimpleEntry<Object, SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>>) item;
//			
//			SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>> simpleEntry= current.getValue();
//			SimpleEntry<String, String> simpleItemKey = simpleEntry.getKey();
//			
//			String currentType = simpleItemKey.getValue();
//			if(currentType.equals(typeName)){
//				return current.getKey();
//			}
//		}
//		return typeName;
//	}
//	
//	private static String getDefaultIdentifier(GenerationPolicyRegistry generationValueGetter,
//			Object containingElement, String typeName) {
//		
//		for(Object item: getElementParameters(generationValueGetter, containingElement)){
//			
//			@SuppressWarnings("unchecked")
//			SimpleEntry<Object, SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>> current= 
//					(SimpleEntry<Object, SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>>) item;
//			
//			SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>> simpleEntry= current.getValue();
//			SimpleEntry<String, String> simpleItemKey = simpleEntry.getKey();
//			
//			String currentType = simpleItemKey.getValue();
//			String currentNameInstance = simpleItemKey.getKey();
//			
//			if(currentType.equals(typeName)){
//				return currentNameInstance;
//			}
//		}
//		return CommonConstants.BLANK;
//	}
//
//	private static Set<Object> getElementParameters(GenerationPolicyRegistry generationValueGetter, Object containingElement) {
//		List<Object> parametersObjects = generationValueGetter.generationPointList(containingElement, ICppDefinitions.CONSTRUCTOR_PARAMETERS_LIST);
//		List<Object> parentParameters = generationValueGetter.generationPointList(generationValueGetter.getObject(containingElement, 
//				IModelingConstants.PARENT_CLASS), ICppDefinitions.CONSTRUCTOR_ALL_PARAMETERS_LIST);
//		
//		Set<Object> filtered= new LinkedHashSet<Object>(parentParameters);
//		filtered.addAll(parametersObjects);
//		return filtered;
//	}
//
//	private static String assertRestrictions(GenerationPolicyRegistry generationValueGetter, String identifier, Object element,
//			String otherEndInstanceName, Object methodObject) {
//		return assertRestrictions(generationValueGetter, identifier, element, otherEndInstanceName, null, methodObject);
//	}
//	
//	private static String assertRestrictions(GenerationPolicyRegistry generationValueGetter, String identifier, Object containingElement,String otherEndInstanceName, 
//			String instanceName, Object element) {
//		int number= getSize(generationValueGetter, otherEndInstanceName, element);
//		String assertStatements= CommonConstants.BLANK;
//		
//		List<Object> attributeContainses = generationValueGetter.getValues("" /*Generator.CONTAINS_IMPLEMENTATION*/, 
//				identifier, containingElement, VisibilityConstants.PUBLIC);
//		
//		if(!attributeContainses.isEmpty()){
//			Object attributeContains = ((HashMap<?, ?>)attributeContainses.get(0)).get(IModelingConstants.METHOD_NAME);
//			
//			List<Object> numberOfGetters = generationValueGetter.getValues("" /*TODO: Generator.NUMBER_OF_IMPLEMENTATION */, 
//					identifier, containingElement, VisibilityConstants.PUBLIC);
//			
//			HashMap<?, ?> map = (HashMap<?, ?>)numberOfGetters.get(0);
//			Object numberOf = map.get(IModelingConstants.METHOD_NAME);
//			Object methodObject = map.get(/*IModelingConstants.METHOD_OBJECT */"");
//			
//			number= getSize(generationValueGetter, otherEndInstanceName, methodObject);
//			
//			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(Generator.ASSERT_GETTER, containingElement, 
//					otherEndInstanceName, numberOf, String.valueOf(number));
//			
//			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(Generator.ASSERT_GETTER, containingElement, 
//					otherEndInstanceName, attributeContains, number>0?CPPTypesConstants.TRUE: CPPTypesConstants.FALSE);
//		}
//		
//		if(instanceName!= null){
//			String indexOfString= null;
//			List<Object> indexOfValues = generationValueGetter.getValues("TODO" /*Generator.INDEX_OF_IMPLEMENTATION*/, 
//					identifier, containingElement, VisibilityConstants.PUBLIC);
//			if(!indexOfValues.isEmpty()){
//				Object indexOf = ((HashMap<?, ?>)indexOfValues.get(0)).get(IModelingConstants.METHOD_NAME);
//				
//				//If number is more than zero, then check against index not being -1; otherwise, it must be "-1"
//				String getterOperator= number>0?CommonConstants.MORE_THAN: CommonConstants.EQUAL+ CommonConstants.EQUAL;
//				
//				indexOfString = generationValueGetter.generate(Generator.ASSERT_GETTER, containingElement, 
//						otherEndInstanceName, indexOf, String.valueOf(-1), instanceName, getterOperator);
//				assertStatements= assertStatements+ CommonConstants.NEW_LINE+ indexOfString;
//				
//				//If number is more than zero, then check against null; other than, it must be null
//				assertStatements = assertStatements+ assertGetterByIndex(generationValueGetter,
//						identifier, number>0?instanceName: null, containingElement, otherEndInstanceName, instanceName, indexOf);
//			}else{
//				//TODO: Add JUnit for this
//			}
//		}
//		
//		return assertStatements;
//	}
//
//	private static String assertGetterByIndex(GenerationPolicyRegistry generationValueGetter, String identifier,
//			String compareTo, Object element, String otherEndInstanceName,
//			String instanceName, Object indexOf) {
//		String assertStatements= CommonConstants.BLANK;
//		List<Object> getterByIndexValues = generationValueGetter.getValues("" /*TODO: Generator.GETTER_BY_INDEX_IMPLEMENTATION*/, 
//				identifier, element, VisibilityConstants.PUBLIC);
//		if(!getterByIndexValues.isEmpty()){
//			Object getterByIndex = ((HashMap<?, ?>)getterByIndexValues.get(0)).get(IModelingConstants.METHOD_NAME);
//			
//			String indexOfMethodCall = generationValueGetter.generate(Generator.METHOD_CALL, element, 
//					otherEndInstanceName, indexOf,instanceName , Boolean.TRUE);
//			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(Generator.ASSERT_GETTER, element, 
//					otherEndInstanceName, getterByIndex, compareTo== null?CPPCommonConstants.NULL:compareTo, indexOfMethodCall, 
//							CommonConstants.EQUAL+ CommonConstants.EQUAL);
//		}else{
//			//TODO: Add JUnit for this
//		}
//		return assertStatements;
//	}
//	
//	private static void constructInstance(GenerationPolicyRegistry generationValueGetter,BufferedWriter output, Object modelPackage, 
//			Object containingElement, String type, String instanceName) throws IOException {
//		constructInstance(generationValueGetter, output, modelPackage, containingElement, type, instanceName, false);
//	}
//	
//	private static void constructInstance(GenerationPolicyRegistry generationValueGetter,BufferedWriter output, Object modelPackage, 
//			Object containingElement, String type, String instanceName, boolean isRecursive) throws IOException {
//		
//		List<String> randomValues= new ArrayList<String>();
//		setConstrctorValues(generationValueGetter, output, modelPackage, containingElement, containingElement, instanceName, randomValues, false);
//		
//		String parametersString= CommonConstants.BLANK;
//		
//		Iterator<String> iterator = randomValues.iterator();
//		while(iterator.hasNext()){
//			String randomValue = iterator.next();
//			
//			parametersString= parametersString+ randomValue;
//			if(iterator.hasNext()){
//				parametersString= parametersString+ CommonConstants.COMMA_SEPARATOR;
//			}
//		}
//		
//		String generate = generationValueGetter.generate(""/*Generator.CONSTRUCT_CLASS*/, containingElement, parametersString, type,instanceName,
//				Boolean.TRUE);
//		
//		appendToFile(output, generate);
//		
//		if(!isRecursive){
//			for(Object associationVariable: generationValueGetter.getList(containingElement, IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES)){
//				boolean isOtherEndFixed = generationValueGetter.decisionPoint(associationVariable, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_FIXED);
//				boolean isRangedMandatory = generationValueGetter.decisionPoint(associationVariable, IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY);
//				
//				if(/*isFixed&& */isOtherEndFixed|| isRangedMandatory){
//					String typeName= generationValueGetter.getString(associationVariable, IModelingElementDefinitions.TYPE_NAME);
//					String name= generationValueGetter.getString(associationVariable, IModelingElementDefinitions.NAME);
//					
//					output.newLine();
//					
//					List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
//					
//					if(!values.isEmpty()){
//						List<Object> setters = generationValueGetter.getValues(""/*TODO:Generator.SETTER_IMPLEMENTATION*/, name, containingElement, 
//								VisibilityConstants.PUBLIC);
//						
//						Object value = values.get(0);
//						if(!setters.isEmpty()){
//							Object object = setters.get(0);
//							if(object instanceof HashMap== false){
//								return;
//							}
//							
//							String newParamaeterInstanceValue = constructObjectAttributeOrAssociation(generationValueGetter, output, modelPackage, typeName,
//									associationVariable, typeName, value, instanceName);
//							
//							HashMap<?, ?> map= (HashMap<?, ?>) object;
//							Object setterMethodNameObject = map.get(IModelingConstants.METHOD_NAME);
//							Object methodObject = map.get(/*IModelingConstants.METHOD_OBJECT */"");
//							
//							appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, containingElement,instanceName, setterMethodNameObject, 
//									newParamaeterInstanceValue));
//							
//							List<Object> ids = generationValueGetter.getValues(IModelingConstants.METHOD_IDS, ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, methodObject, 
//									containingElement);
//							
//							if(!ids.isEmpty()){
//								if(generationValueGetter.decisionPoint(associationVariable, IModelingDecisions.ATTRIBUTE_IS_ONE)){
//									//String defaultValue= generationValueGetter.generationPointString(associationVariable, IModelingConstants.NORMALIZED_DEFAULT_VALUE);
//										//generationValueGetter.addValue(TEST_CLASS_PARAMETERS_VALUES_IN_CONSTRUCTOR_TRACKER,defaultValue , 
//										//		instanceName, typeName, ids.get(0).toString(), containingElement);
//									output.newLine();
//									appendToFile(output, "//Previous set must not have worked due to rsstrictions"); //$NON-NLS-1$
//										assertGetter(generationValueGetter, modelPackage, output, containingElement, instanceName, ids.get(0).toString());
//								}else{
//									generationValueGetter.addValue(TEST_CLASS_PARAMETERS_VALUES_IN_CONSTRUCTOR_TRACKER,newParamaeterInstanceValue , 
//											instanceName, typeName, ids.get(0).toString(), containingElement);
//								}
//							}
//						}else{
//							List<Object> allAddImplementationsValues = generationValueGetter.getValues(""/*Generator.ADD_IMPLEMENTATION*/, 
//									name, containingElement, VisibilityConstants.PUBLIC);
//							
//							if(allAddImplementationsValues.isEmpty()){
//								return;
//							}
//							
//							Object object = allAddImplementationsValues.get(0);
//							
//							if(object instanceof HashMap== false){
//								return;
//							}
//							
//							HashMap<?, ?> map= (HashMap<?, ?>) object;
//							Object addMethodNameObject = map.get(IModelingConstants.METHOD_NAME);
//							
//							int bound= generationValueGetter.decisionPoint(associationVariable, IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL)?
//									generationValueGetter.getInt(associationVariable, IModelingElementDefinitions.UPPER_BOUND):
//									generationValueGetter.getInt(associationVariable, IModelingElementDefinitions.LOWER_BOUND);
//							Object methodObject = map.get(/*IModelingConstants.METHOD_OBJECT */"");
//							
//							if(bound>0){
//								for(int index=0; index<bound; index++){
//									String typeInstanceName= getNextAvailableName(generationValueGetter, value, typeName);
//									
//									constructInstance(generationValueGetter,output,modelPackage, value, typeName, typeInstanceName, true);
//									output.newLine();
//									appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, value,
//											instanceName, addMethodNameObject, typeInstanceName));
//									
//									if(canAdd(generationValueGetter, instanceName, typeInstanceName, methodObject)){
//										increaseSize(generationValueGetter, instanceName, typeName);
//									}
//									
//									if(index<bound-1){
//										output.newLine();
//									}
//									generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, typeInstanceName, instanceName);
//									
//									if(!canAdd(generationValueGetter, instanceName, typeInstanceName, methodObject)){
//										output.newLine();
//										appendToFile(output, "//Previous add must not have worked due to restrictions");  //$NON-NLS-1$
//										break;
//									}
//									increaseSize(generationValueGetter, instanceName, typeName);
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//
//	private static void setConstrctorValues(GenerationPolicyRegistry generationValueGetter, BufferedWriter output, Object modelPackage,
//			Object containingElement, Object root, String instanceName, List<String> randomValues, boolean isRecursive) throws IOException {
//		setConstrctorValues(generationValueGetter, output, modelPackage, containingElement, root, instanceName, randomValues, isRecursive, false);
//	}
//	
//	@SuppressWarnings("unchecked")
//	private static void setConstrctorValues(GenerationPolicyRegistry generationValueGetter, BufferedWriter contents, Object modelPackage,
//			Object containingElement, Object root, String instanceName, List<String> randomValues, boolean isRecursive, boolean isInternal) throws IOException {
//		List<Object> parameters = generationValueGetter.getValues(""/*IModelingConstructorDefinitionsConstants.CONSTRUCTOR_REGISTERED_PARAMETERS*/, containingElement);
//		
//		List<?> otherParams;
//		List<?> internalDefinedParams= new ArrayList<Object>();
//		if(isInternal){
//			otherParams= generationValueGetter.generationPointList(containingElement, ICppDefinitions.CONSTRUCTOR_ALL_PARAMETERS_LIST);
//			
//			otherParams = generationValueGetter.generationPointList(containingElement, ""
//					/*IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS_PROCESSOR*/, otherParams);
//		}else{
//			if(isRecursive){
//				otherParams= ((SimpleEntry<List<?>, Object>) parameters.get(0)).getKey();
//			}else{
//				otherParams= ((SimpleEntry<List<?>, Object>) parameters.get(parameters.size()-1)).getKey();
//				internalDefinedParams= ((SimpleEntry<List<?>, Object>) parameters.get(0)).getKey();
//			}
//		}
//		
//		List<Object> constrcutedKeys= new ArrayList<Object>();
//		for(Object obj: otherParams){
//			if(obj instanceof SimpleEntry== false){
//				continue;
//			}
//			
//			SimpleEntry<?, ?> simpleEntry = (SimpleEntry<?, ?>)obj;
//			
//			Object key = simpleEntry.getKey();
//			
//			String typeName = generationValueGetter.getString(key, IModelingElementDefinitions.TYPE_NAME);
//			List<Object> values = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, 
//					typeName);
//			if(isInternal&& values.contains(root)){
//				continue;
//			}
//			
//			SimpleEntry<?, ?> simpleEntryValue = (SimpleEntry<?, ?>)simpleEntry.getValue();
//			SimpleEntry<?, ?> entryKey = (SimpleEntry<?, ?>) (simpleEntryValue).getKey();
//			
//			String currentType = entryKey.getValue().toString();
//			String currentKey = entryKey.getKey().toString();
//			String randomValue = getSomeRandomValue(generationValueGetter,contents, modelPackage, instanceName, currentType, 
//					currentKey, simpleEntry.getKey());
//			generationValueGetter.addValue(TEST_CLASS_PARAMETERS_VALUES_IN_CONSTRUCTOR_TRACKER, randomValue, 
//					instanceName, currentType, currentKey, containingElement);
//			
//			constrcutedKeys.add(entryKey.toString());
//			randomValues.add(randomValue);
//		}
//		
//		for(Object obj: internalDefinedParams){
//			if(obj instanceof SimpleEntry== false){
//				continue;
//			}
//			
//			SimpleEntry<?, ?> simpleEntry = (SimpleEntry<?, ?>)obj;
//			SimpleEntry<?, ?> simpleEntryValue = (SimpleEntry<?, ?>)simpleEntry.getValue();
//			SimpleEntry<?, ?> entryKey = (SimpleEntry<?, ?>) (simpleEntryValue).getKey();
//			
//			if(constrcutedKeys.contains(entryKey.toString())){
//				continue;
//			}
//			
//			String currentType = entryKey.getValue().toString();
//			String currentKey = entryKey.getKey().toString();
//			
//			generationValueGetter.addValue(TEST_CLASS_PARAMETERS_VALUES_IN_CONSTRUCTOR_TRACKER, INTERNAL_DEFINED_VALUE,
//					instanceName, currentType, currentKey, containingElement);
//		}
//	}
//	
//	private static String getNextAvailableName(GenerationPolicyRegistry generationValueGetter, Object contaningElement){
//		String typName= generationValueGetter.getString(contaningElement, IModelingElementDefinitions.NAME);
//		return getNextAvailableName(generationValueGetter, contaningElement, typName);
//	}
//	
//	private static String getNextAvailableName(GenerationPolicyRegistry generationValueGetter, Object contaningElement, String typeName){
//		List<Object> namesValues = generationValueGetter.getValues(TEST_CLASS_INSTANCE_NAMES_TRACKER, contaningElement);
//		String typeInstanceName = StringUtil.firstCharacterToLowerCase(typeName)+ CommonConstants.UNDERSCORE+ namesValues.size();
//		generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_NAMES_TRACKER, typeInstanceName, contaningElement);
//		return typeInstanceName;
//	}
//	
//	private static String getSomeRandomValue(GenerationPolicyRegistry generationValueGetter, BufferedWriter contents, Object modelPackage,
//			String instanceName, String type, String value, Object element) throws IOException {
//		String paramaeterInstanceName;
//		if(ISTLConstants.STRING.equals(type)){
//			paramaeterInstanceName = CommonConstants.QUOTATION+ instanceName+ CommonConstants.UNDERSCORE+ value+ 
//					new SecureRandom().nextInt(5000)+ CommonConstants.QUOTATION;
//		}else if(CPPTypesConstants.INTEGER.equals(type)){
//			paramaeterInstanceName= String.valueOf(new SecureRandom().nextInt(5000));
//		}else if(CPPTypesConstants.BOOL.equals(type)){
//			paramaeterInstanceName= CPPTypesConstants.FALSE;
//		}else if(CPPTypesConstants.CHAR.equals(type)){
//			String string = UUID.randomUUID().toString();
//			paramaeterInstanceName= CommonConstants.QUOTATION+ string.substring(0, 1)+ CommonConstants.QUOTATION;
//		}else if(CPPTypesConstants.DOUBLE.equals(type)){
//			paramaeterInstanceName= String.valueOf(new SecureRandom().nextDouble());
//		}else if(CPPTypesConstants.FLOAT.equals(type)){
//			paramaeterInstanceName= String.valueOf(new SecureRandom().nextFloat());
//		}else if(CPPTypesConstants.FLOAT.equals(type)){
//			paramaeterInstanceName= String.valueOf(new SecureRandom().nextFloat());
//		}else{
//			String typeName= generationValueGetter.getString(element, IModelingElementDefinitions.TYPE_NAME);
//			List<Object> allValues = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName);
//			if(!allValues.isEmpty()){
//				Object containingElement = allValues.get(0);
//				
//				paramaeterInstanceName = constructObjectAttributeOrAssociation(
//						generationValueGetter, contents, modelPackage, type,
//						element, typeName, containingElement, instanceName);
//			}else{
//				paramaeterInstanceName= generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_DEFAULT_VALUE);
//			}
//			
//		}
//		return paramaeterInstanceName;
//	}
//
//	private static String constructObjectAttributeOrAssociation(GenerationPolicyRegistry generationValueGetter, BufferedWriter output, Object modelPackage, String type,
//			Object element, String typeName, Object containingElement, String instanceName) throws IOException {
//		String paramaeterInstanceName;
//		
//		int upperBound = generationValueGetter.getInt(element, IModelingElementDefinitions.UPPER_BOUND);
//		int bound= generationValueGetter.decisionPoint(element, IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL)?
//				upperBound: generationValueGetter.getInt(element, IModelingElementDefinitions.LOWER_BOUND);
//		
//		if(bound>1|| upperBound==-1|| upperBound>1){
//			String newListConstruct = generationValueGetter.generate(Generator.NEW_LIST_DEFINITION, element);
//			String normalizedType = generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME);
//			
//			
//			String parameterAsMany = getNextAvailableName(generationValueGetter, containingElement, type)+ "_Many"+ "_"+typeName; //$NON-NLS-1$ //$NON-NLS-2$
//			String assignStatement = generationValueGetter.generate(Generator.ASSIGN_STATEMENET, 
//					parameterAsMany, newListConstruct, normalizedType);
//			
//			appendToFile(output, assignStatement);
//			output.newLine();
//			
//			//Construct a number of instances and add them to the vector/set to match the minimum constraints requirements
//			for(int index=0; index<bound; index++){
//				String paramaeterInstanceListItem= getNextAvailableName(generationValueGetter, containingElement, type);
//				constructInstance(generationValueGetter,output,modelPackage, containingElement, typeName, paramaeterInstanceListItem, true);
//				output.newLine();
//				
//				String add= generationValueGetter.generationPointString(element, ""/*TODO ICppDefinitions.ADD_INVOCATION */,
//						GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_VARIABLE_ARGUMENT, parameterAsMany),
//						GenerationArgumentDescriptor.arg(ICppDefinitions.ADD_PARAMETER_ARGUMENT, paramaeterInstanceListItem));
//				
//				appendToFile(output, add);
//				output.newLine();
//				generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, paramaeterInstanceListItem, instanceName);
//			}
//			
//			//We shall use the list variable as our target instance for the constructor after we made sure that it contains the right number of instances
//			paramaeterInstanceName= parameterAsMany;
//		}else{
//			paramaeterInstanceName= getNextAvailableName(generationValueGetter, containingElement, type);
//			constructInstance(generationValueGetter,output,modelPackage, containingElement, typeName, paramaeterInstanceName, true);
//			output.newLine();
//		}
//		setSize(generationValueGetter, instanceName, typeName, bound);
//		generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, paramaeterInstanceName, instanceName);
//		
//		return paramaeterInstanceName;
//	}
//	
//	private static String getDefinedValue(GenerationPolicyRegistry generationValueGetter, Object containingElement, String instanceName, String type, Object value, Object element) {
//		List<Object> values = generationValueGetter.getValues(TEST_CLASS_PARAMETERS_VALUES_IN_CONSTRUCTOR_TRACKER, instanceName, type, value, containingElement);
//		if(values.isEmpty()){
//			return generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_DEFAULT_VALUE);
//		}
//		return (String) values.get(values.size()-1);
//	}
//	
//	private static String addCall(GenerationPolicyRegistry generationValueGetter, Object modelPackage, BufferedWriter output, String identifier, String caller, 
//			Object element) throws IOException{
//		
//		List<Object> allAddImplementationsValues = generationValueGetter.getValues("" /* Generator.ADD_IMPLEMENTATION */, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		if(allAddImplementationsValues.isEmpty()){
//			return null;
//		}
//		Object object = allAddImplementationsValues.get(0);
//		HashMap<?, ?> map= (HashMap<?, ?>) object;
//		Object methodObject = map.get(/*IModelingConstants.METHOD_OBJECT */"");
//		String typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.TYPE_NAME);
//		Object rootType = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName).get(0);
//		String typeInstanceName= getNextAvailableName(generationValueGetter, rootType, typeName);
//		output.newLine();
//		constructInstance(generationValueGetter,output, modelPackage, rootType, typeName, typeInstanceName);
//		addCall(generationValueGetter, output, identifier, caller, element, typeInstanceName);
//		return typeInstanceName;
//	}
//	
//	private static boolean addCall(GenerationPolicyRegistry generationValueGetter, BufferedWriter output, String identifier, String caller, 
//			Object element, String callee) throws IOException{
//		HashMap<?, ?> map = getAddMethodName(generationValueGetter, identifier, element);
//		if(map== null){
//			return false;
//		}
//		
//		String addMethodNameObject = (String) map.get(IModelingConstants.METHOD_NAME);
//		
//		Object methodObject = map.get(/*IModelingConstants.METHOD_OBJECT */"");
//		String typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.TYPE_NAME);
//		if(typeName== null|| CPPTypesConstants.VOID.equals(typeName)){
//			typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.NAME);
//		}
//
//		output.newLine();
//		appendToFile(output, generationValueGetter.generate(Generator.METHOD_CALL, element,
//				caller, addMethodNameObject, callee));
//		
//		if(!canAdd(generationValueGetter, caller, callee, methodObject)){
//			output.newLine();
//			appendToFile(output, "//Previous add must not have worked due to restrictions");  //$NON-NLS-1$
//			output.newLine();
//			return false;
//		}
//		generationValueGetter.addUniqueValue(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, callee, caller);
//		
//		
//		increaseSize(generationValueGetter, caller, typeName);
//		if(generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL)||
//				generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_UNBOUND)||
//				generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_RANGED_MANDATORY)){
//			String rootTypeName= generationValueGetter.getString(element, IModelingElementDefinitions.TYPE_NAME);
//			if(rootTypeName== null|| CPPTypesConstants.VOID.equals(rootTypeName)){
//				rootTypeName= generationValueGetter.getString(element, IModelingElementDefinitions.NAME);
//			}
//			increaseSize(generationValueGetter, callee, rootTypeName);
//		}
//		
//		return true;
//	}
//
//	private static boolean canAdd(GenerationPolicyRegistry generationValueGetter, String caller, String callee, Object methodObject) {
//		if(generationValueGetter.getValues(TEST_CLASS_INSTANCE_ASSOCIATIONS_TRACKER, caller).contains(callee)){
//			return false;
//		}
//		
//		String typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.TYPE_NAME);
//		if(typeName== null){
//			typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.NAME);
//		}
//		
//		setCanAdd: {
//			int upperBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.UPPER_BOUND);
//			int lowerBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.LOWER_BOUND);
//			
//			int size= getSize(generationValueGetter, caller, typeName);
//			int expectedNewLength = 1+ size;
//			
//			if(upperBound== lowerBound&& expectedNewLength>upperBound){
//				return false;
//			}
//			
//			String otherTypeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.OTHER_END_TYPE_NAME);
//			int otherSize= getSize(generationValueGetter, callee, otherTypeName);
//			
//			int otherUpperBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.OTHER_END_UPPER_BOUND);
//			int otherLowerBound = generationValueGetter.getInt(methodObject, IModelingElementDefinitions.OTHER_END_LOWER_BOUND);
//			
//			if(generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_RANGED_UNBOUND)&&
//					generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OTHER_END_ONE)){
//				
//				if(generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_DIRECTED)){
//					//No resitrctions if directed
//					return true;
//				}
//				
//				if(otherSize<=otherLowerBound){
//					return false;
//				}
//				//Adding ranged/unbound requires removing the other end one relation, so ensure that this relation is removed. This is why we check for the lower bound
//				//here
//				//Checking for zero is required for the intenral constructed objects
//				return size==0|| size-1>lowerBound;
//			}
//			
//			int expectedOtherNewLength = 1+ otherSize;
//			
//			if(upperBound== -1){
//				if(expectedOtherNewLength>otherUpperBound&& otherUpperBound!=-1&& otherUpperBound!=1){
//					return false;
//				}
//				break setCanAdd;
//			}
//			
//			if(expectedNewLength>upperBound){
//				return false;
//			}
//			
//			//In ranged optional/optional cases, we know that the add method will take care of removing the old references
//			if(generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_RANGED_OPTIONAL)||
//					generationValueGetter.getBoolean(methodObject, IModelingDecisions.ATTRIBUTE_IS_OPTIONAL)){
//				break setCanAdd;
//			}
//			
//			if(callee== null){
//				break setCanAdd;
//			}
//			
//			if(otherTypeName== null|| CPPTypesConstants.VOID.equals(otherTypeName)|| CPPCommonConstants.NULL.equals(otherTypeName)){
//				otherTypeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.OTHER_END_NAME);
//			}
//			
//			if(expectedOtherNewLength>otherUpperBound&& otherUpperBound!=-1){
//				return false;
//			}
//		}
//		return true;
//	}
//
//	private static void increaseSize(GenerationPolicyRegistry generationValueGetter, String caller,String type) {
//		updateSize(generationValueGetter, caller, type, 1);
//	}
//	
//	private static void decreaseSize(GenerationPolicyRegistry generationValueGetter, String caller,String type) {
//		updateSize(generationValueGetter, caller, type, -1);
//	}
//	
//	private static void updateSize(GenerationPolicyRegistry generationValueGetter, String caller,String type, int increment) {
//		int size= getSize(generationValueGetter, caller, type);
//		size= size+ increment;
//		setSize(generationValueGetter, caller, type, size);
//	}
//
//	private static void setSize(GenerationPolicyRegistry generationValueGetter, String caller, String type, int size) {
//		generationValueGetter.addValue(TEST_CLASS_PARAMETERS_NUMBER_OF_TRACKER, String.valueOf(size), caller, type);
//	}
//	
//	private static int getSize(GenerationPolicyRegistry generationValueGetter, String caller,Object typeObject) {
//		String typeName= generationValueGetter.getString(typeObject, IModelingElementDefinitions.TYPE_NAME);
//		if(typeName== null|| CPPTypesConstants.VOID.equals(typeName)|| CPPCommonConstants.NULL.equals(typeName)){
//			typeName= generationValueGetter.getString(typeObject, IModelingElementDefinitions.NAME);
//		}
//		
//		return getSize(generationValueGetter, caller, typeName);
//	}
//	
//	private static int getSize(GenerationPolicyRegistry generationValueGetter, String caller,String type) {
//		List<Object> values = generationValueGetter.getValues(TEST_CLASS_PARAMETERS_NUMBER_OF_TRACKER, caller, type);
//		return values.isEmpty()?0: Integer.valueOf((String) values.get(values.size()-1)).intValue();
//	}
//	
//	private static HashMap<?, ?> getAddMethodName(GenerationPolicyRegistry generationValueGetter, String identifier, Object element){
//		List<Object> allAddImplementationsValues = generationValueGetter.getValues("" /* Generator.ADD_IMPLEMENTATION */, identifier, element, 
//				VisibilityConstants.PUBLIC);
//		
//		if(allAddImplementationsValues.isEmpty()){
//			return null;
//		}
//		
//		Object object = allAddImplementationsValues.get(0);
//		
//		if(object instanceof HashMap== false){
//			return null;
//		}
//		HashMap<?, ?> map= (HashMap<?, ?>) object;
//		Object methodName = map.get(IModelingConstants.METHOD_NAME);
//		if(methodName instanceof String== false){
//			return null;
//		}
//		return map;
//	}
//	
//	private static void appendToFile(BufferedWriter output, CharSequence contents) throws IOException{
//		output.write(StringUtil.indent(contents.toString(), 1));
//	}
	
}