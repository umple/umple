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

import java.security.SecureRandom;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

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
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.VisibilityConstants;

public class CppTestsPointsHandler{
	
	private static final int FINALIZE_HIGH_PRIORITY= 600;
	private final static String TEST_CLASS_CONSTRUCT_NAME_TRACKER= "cpp.test.class.construct.name.tracker"; //$NON-NLS-1$
	
	@LoopProcessorAnnotations(loopProcessorAnnotations ={ 
			@LoopProcessorAnnotation(processPath = {IModelingElementDefinitions.CLASSES_PROCESSOR})
	}, aspect= LoopAspectConstants.FINALIZE, priority= GenerationPolicyRegistryPriorities.MEDIUM, aspectGroup= FINALIZE_HIGH_PRIORITY)
	public static void classAfterProcessor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, @GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement Object modelPackage){
		
		List<Object> parametersObjects = generationValueGetter.generationPointList(element, ICppDefinitions.CONSTRUCTOR_PARAMETERS_LIST);
		List<Object> parentParameters = generationValueGetter.generationPointList(generationValueGetter.getObject(element, 
				IModelingConstants.PARENT_CLASS), ICppDefinitions.CONSTRUCTOR_ALL_PARAMETERS_LIST);
		
		
		Set<Object> filtered= new LinkedHashSet<Object>(parentParameters);
		filtered.addAll(parametersObjects);
		
		List<Object> values = generationValueGetter.getValues(TEST_CLASS_CONSTRUCT_NAME_TRACKER, element);
		String instanceName= StringUtil.firstCharacterToLowerCase(name)+ values.size();
		generationValueGetter.addUniqueValue(TEST_CLASS_CONSTRUCT_NAME_TRACKER, instanceName, element);
		
		
		String assertStatements= CommonConstants.BLANK;
		
		List<String> constructorStrings= new ArrayList<String>();
		for(Object item: filtered){
			@SuppressWarnings("unchecked")
			SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>> simpleEntry= (SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>) item;
			
			SimpleEntry<String, String> entry = simpleEntry.getValue();
			
			String paramaeterInstanceValue;
			
			SimpleEntry<String, String> simpleItemKey = simpleEntry.getKey();
			String type = simpleItemKey.getValue();
			String identifier = simpleItemKey.getKey();
			
			paramaeterInstanceValue = getSomeRandomValue(instanceName, entry.getValue(), type);
			
			constructorStrings.add(paramaeterInstanceValue);
			
			List<Object> getterValues = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION, identifier, element, 
					VisibilityConstants.PUBLIC);
			
			for(Object object: getterValues){
				if(object instanceof HashMap){
					HashMap<?, ?> map= (HashMap<?, ?>) object;
					Object getterMethodNameObject = map.get(IModelingConstants.METHOD_NAME);
					
					if(!assertStatements.isEmpty()){
						assertStatements= assertStatements+ CommonConstants.NEW_LINE;
					}
					assertStatements= assertStatements+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
							instanceName, getterMethodNameObject, paramaeterInstanceValue);
					
					
					List<Object> setterValues = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION, identifier, element, 
							VisibilityConstants.PUBLIC);
							
					for(Object subObject: setterValues){
						if(object instanceof HashMap){
							HashMap<?, ?> subMap= (HashMap<?, ?>) subObject;
							Object setterMethodNameObject = subMap.get(IModelingConstants.METHOD_NAME);
							
							if(!assertStatements.isEmpty()){
								assertStatements= assertStatements+ CommonConstants.NEW_LINE;
							}
							
							//Set then assert new value
							String newParamaeterInstanceValue = getSomeRandomValue(instanceName, entry.getValue(), type);
							assertStatements= assertStatements+ generationValueGetter.generate(ICppTestsDefinitions.METHOD_CALL, element, 
									instanceName, setterMethodNameObject, newParamaeterInstanceValue);
							assertStatements= assertStatements+ CommonConstants.NEW_LINE;
							assertStatements= assertStatements+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
									instanceName, getterMethodNameObject, newParamaeterInstanceValue);
							
							assertStatements= assertStatements+ CommonConstants.NEW_LINE;
							
							//Reset and then assert the original value
							assertStatements= assertStatements+ generationValueGetter.generate(ICppTestsDefinitions.METHOD_CALL, element, 
									instanceName, setterMethodNameObject, paramaeterInstanceValue);
							assertStatements= assertStatements+ CommonConstants.NEW_LINE;
							assertStatements= assertStatements+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
									instanceName, getterMethodNameObject, paramaeterInstanceValue);
						}
					}
				}
			}
		}
		
		for(Object identifier: generationValueGetter.getValues(IModelingConstants.METHOD_IDS, element)){
			List<Object> allAddImplementationsValues = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.ADD_IMPLEMENTATION, identifier, element, 
					VisibilityConstants.PUBLIC);
			if(allAddImplementationsValues.isEmpty()){
				continue;
			}
			Object object = allAddImplementationsValues.get(0);
			
			if(object instanceof HashMap== false){
				continue;
			}
			
			List<Object> removeImplementationsValues = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.REMOVE_IMPLEMENTATION, identifier, element, 
					VisibilityConstants.PUBLIC);
			if(removeImplementationsValues.isEmpty()){
				continue;
			}
			Object removeObject = removeImplementationsValues.get(0);
			
			if(removeObject instanceof HashMap== false){
				continue;
			}
			
			HashMap<?, ?> removeMap= (HashMap<?, ?>) removeObject;
			HashMap<?, ?> map= (HashMap<?, ?>) object;
			
			Object removeMethodNameObject = removeMap.get(IModelingConstants.METHOD_NAME);
			
			List<Object> attributeGetters = generationValueGetter.getAllValues(ICppAssociationsDefinitionsConstants.NUMBER_OF_IMPLEMENTATION, 
					identifier, element, VisibilityConstants.PUBLIC);
			
			Object numberOf = ((HashMap<?, ?>)attributeGetters.get(0)).get(IModelingConstants.METHOD_NAME);
			
			
			List<Object> attributeContainses = generationValueGetter.getAllValues(ICppAssociationsDefinitionsConstants.CONTAINS_IMPLEMENTATION, 
					identifier, element, VisibilityConstants.PUBLIC);
			
			Object attributeContains = ((HashMap<?, ?>)attributeContainses.get(0)).get(IModelingConstants.METHOD_NAME);
			
			
			Object addMethodNameObject = map.get(IModelingConstants.METHOD_NAME);
			Object methodObject = map.get(IModelingConstants.METHOD_OBJECT);
			String typeName= generationValueGetter.getString(methodObject, IModelingElementDefinitions.TYPE_NAME);
			Object rootType = generationValueGetter.getValues(IModelingConstants.TYPES_TRACKER, modelPackage, typeName).get(0);
			
			String typeInstanceName= getNextAvailableName(generationValueGetter, typeName, rootType);
			
			List<Object> typeParametersObjects = generationValueGetter.generationPointList(rootType, ICppDefinitions.CONSTRUCTOR_PARAMETERS_LIST);
			List<Object> typeParentParameters = generationValueGetter.generationPointList(generationValueGetter.getObject(rootType, 
					IModelingConstants.PARENT_CLASS), ICppDefinitions.CONSTRUCTOR_ALL_PARAMETERS_LIST);
			
			Set<Object> typeFiltered= new LinkedHashSet<Object>(typeParentParameters);
			typeFiltered.addAll(typeParametersObjects);
			
			List<String> typesConstructorStrings= new ArrayList<String>();
			for(Object typeItem: typeFiltered){
				@SuppressWarnings("unchecked")
				SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>> simpleTypeEntry= 
					(SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>) typeItem;
				
				SimpleEntry<String, String> simpleTypeItemKey = simpleTypeEntry.getKey();
				typesConstructorStrings.add(getSomeRandomValue(instanceName, simpleTypeItemKey.getValue(), simpleTypeItemKey.getValue()));
			}
			
			String typeParametersString= getRandomConstructorString(typeFiltered, typeInstanceName);
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ 
					generationValueGetter.generate(ICppTestsDefinitions.CONSTRUCT_CLASS, rootType, typeName, 
							typeInstanceName, typeParametersString);
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, attributeContains, CPPTypesConstants.FALSE);
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.METHOD_CALL, element, 
					instanceName, addMethodNameObject, typeInstanceName);
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, numberOf, String.valueOf(1));
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, attributeContains, CPPTypesConstants.TRUE);
			
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.METHOD_CALL, element, 
					instanceName, removeMethodNameObject, typeInstanceName);
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, numberOf, String.valueOf(0));
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, attributeContains, CPPTypesConstants.FALSE);
			
			List<String> someExtraAdds= new ArrayList<String>();
			for(int i=0; i<4; i++){
				String instanceNewVariable= getNextAvailableName(generationValueGetter, typeName, rootType);
				
				assertStatements= assertStatements+ CommonConstants.NEW_LINE+ 
						generationValueGetter.generate(ICppTestsDefinitions.CONSTRUCT_CLASS, rootType, typeName, 
								instanceNewVariable, getRandomConstructorString(typeFiltered, instanceNewVariable));
				
				assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.METHOD_CALL, element, 
						instanceName, addMethodNameObject, instanceNewVariable);
				someExtraAdds.add(instanceNewVariable);
			}
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, numberOf, String.valueOf(4));
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, attributeContains, CPPTypesConstants.TRUE);
			
			List<Object> addAtImplementationsValues = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.ADD_AT_IMPLEMENTATION, identifier, element, 
					VisibilityConstants.PUBLIC);
			if(!addAtImplementationsValues.isEmpty()){
				Object addAtMethodName = ((HashMap<?, ?>)addAtImplementationsValues.get(0)).get(IModelingConstants.METHOD_NAME);
				String instanceNewVariable= getNextAvailableName(generationValueGetter, typeName, rootType);
				
				assertStatements= assertStatements+ CommonConstants.NEW_LINE+ 
						generationValueGetter.generate(ICppTestsDefinitions.CONSTRUCT_CLASS, rootType, typeName, 
								instanceNewVariable, getRandomConstructorString(typeFiltered, instanceNewVariable));
				
				assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.METHOD_CALL, element, 
						instanceName, addAtMethodName, instanceNewVariable+ CommonConstants.COMMA_SEPARATOR+ String.valueOf(2));
				
				List<Object> indexOfImplementationsValues = generationValueGetter.getValues(ICppAssociationsDefinitionsConstants.INDEX_OF_IMPLEMENTATION, identifier, element, 
						VisibilityConstants.PUBLIC);
				if(!indexOfImplementationsValues.isEmpty()){
					Object indexOfMethodName = ((HashMap<?, ?>)indexOfImplementationsValues.get(0)).get(IModelingConstants.METHOD_NAME);
					
					assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
							instanceName, indexOfMethodName, String.valueOf(2), instanceNewVariable);
				}
			}
			String delete = generationValueGetter.use(ICppNameConstants.DELETE_METHOD);
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.METHOD_CALL, element, 
					instanceName, delete);
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, numberOf, String.valueOf(0));
			
			assertStatements= assertStatements+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppTestsDefinitions.ASSERT_GETTER, element, 
					instanceName, attributeContains, CPPTypesConstants.FALSE);
			
		}
		
		
		String parentParametersString= GenerationUtil.asStringParameters(constructorStrings);
		
		String construct = generationValueGetter.generate(ICppTestsDefinitions.CONSTRUCT_CLASS, element, name, instanceName, parentParametersString);
		generationValueGetter.addUniqueValue(ICppDefinitions.MAIN_CONTENTS, construct);
		generationValueGetter.addUniqueValue(ICppDefinitions.MAIN_CONTENTS, assertStatements+ CommonConstants.NEW_LINE);
	}
	
	private static String getNextAvailableName(GenerationPolicyRegistry generationValueGetter, String typeName, Object rootType){
		List<Object> namesValues = generationValueGetter.getValues(TEST_CLASS_CONSTRUCT_NAME_TRACKER, rootType);
		String typeInstanceName = StringUtil.firstCharacterToLowerCase(typeName)+ namesValues.size();
		generationValueGetter.addUniqueValue(TEST_CLASS_CONSTRUCT_NAME_TRACKER, typeInstanceName, rootType);
		return typeInstanceName;
	}
	
	private static String getRandomConstructorString(Collection<Object> typeFiltered, String instanceName){
		List<String> typesConstructorStrings= new ArrayList<String>();
		for(Object typeItem: typeFiltered){
			@SuppressWarnings("unchecked")
			SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>> simpleTypeEntry= 
				(SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>) typeItem;
			
			SimpleEntry<String, String> simpleTypeItemKey = simpleTypeEntry.getKey();
			typesConstructorStrings.add(getSomeRandomValue(instanceName, simpleTypeItemKey.getKey(), simpleTypeItemKey.getValue()));
		}
		return GenerationUtil.asStringParameters(typesConstructorStrings);
	}

	private static String getSomeRandomValue(String instanceName, String value, String type) {
		String paramaeterInstanceName;
		if(ISTLConstants.STRING.equals(type)){
			paramaeterInstanceName = CommonConstants.QUOTATION+ instanceName+ CommonConstants.UNDERSCORE+ value+ 
					new SecureRandom().nextInt(5000)+ CommonConstants.QUOTATION;
		}else if(CPPTypesConstants.INTEGER.equals(type)){
			paramaeterInstanceName= String.valueOf(new SecureRandom().nextInt(5000));
		}else if(CPPTypesConstants.BOOL.equals(type)){
			paramaeterInstanceName= CPPTypesConstants.FALSE;
		}else if(CPPTypesConstants.CHAR.equals(type)){
			String string = UUID.randomUUID().toString();
			paramaeterInstanceName= CommonConstants.QUOTATION+ string.substring(0, 1)+ CommonConstants.QUOTATION;
		}else if(CPPTypesConstants.DOUBLE.equals(type)){
			paramaeterInstanceName= String.valueOf(new SecureRandom().nextDouble());
		}else if(CPPTypesConstants.FLOAT.equals(type)){
			paramaeterInstanceName= String.valueOf(new SecureRandom().nextFloat());
		}else if(CPPTypesConstants.FLOAT.equals(type)){
			paramaeterInstanceName= String.valueOf(new SecureRandom().nextFloat());
		}else{
			paramaeterInstanceName= CPPCommonConstants.NULL;
		}
		return paramaeterInstanceName;
	}
	
}