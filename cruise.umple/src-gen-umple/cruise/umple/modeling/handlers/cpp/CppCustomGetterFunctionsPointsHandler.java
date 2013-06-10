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
import java.util.Arrays;
import java.util.HashMap;
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
import cruise.umple.cpp.utils.CPPCommonConstants;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.GenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.VisibilityConstants;


public class CppCustomGetterFunctionsPointsHandler{
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT)
	public static void setConstructorDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String copySegment= generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_GENERATION_POINT);
		if(!copySegment.isEmpty()){
			generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_IMPLEMENTATION, copySegment, parent);
		}
		generationValueGetter.generationPointString(element, IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_GENERATION_POINT);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT, 
			ifNotConditionIds= {ICppDefinitions.ATTRIBUTE_DISABLE_DELETE})
	public static void setDestructorDetails(
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String content=  isMany?generationValueGetter.use(ISTLConstants.DESTRUCT_VECTOR_DEFINITION, name, type):
			generationValueGetter.use(ICppDefinitions.DESTRUCT_ATTRIBUTE, name);
		
		generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.DESTRUCTOR_IMPLEMENTATION, content, parent);
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.ATTRIBUTE_DISABLE_DELETE)
	public static boolean disableDelete(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type) {
		return CPPTypesConstants.BASE_TYPES.contains(type);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_GENERATION_POINT, 
			priority= IGenerationPointPriorityConstants.LOWEST, ifConditionIds= IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_CAN_COPY, unique= true)
	public static String copyConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		return isMany?generationValueGetter.generate(IModelingConstructorDefinitionsConstants.COPY_COLLECTION, element, name):
			generationValueGetter.generate(IModelingConstructorDefinitionsConstants.COPY_ATTRIBUTE, element, name);
	}
	
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_GENERATION_POINT, priority= IGenerationPointPriorityConstants.LOW,
			ifConditionIds= IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_CAN_COPY, unique= true)
	public static String copyPrimitiveTypesConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimtiveType,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		//Low priority copy constructor for the primitive types. Users can create another generation point with higher priority in case they need different handling
		if(!isPrimtiveType){
			return null;
		}
		
		return generationValueGetter.use(ICppDefinitions.COPY_PRIMITIVE_ATTRIBUTE, name);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PARAMETERS_IMPLEMENTATION, priority=IGenerationPointPriorityConstants.HIGH)
	public static String constructorParametersImpl(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument List<Object> allParameters){
		
		if(allParameters.isEmpty()){
			return null;
		}
		
		List<String> parameterStrings= new ArrayList<String>();
		
		for(Object item: allParameters){
			@SuppressWarnings("unchecked")
			SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>> simpleEntry= (SimpleEntry<SimpleEntry<String, String>, SimpleEntry<String, String>>) item;
			
			SimpleEntry<String, String> entry = simpleEntry.getValue();
			parameterStrings.add(generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, entry.getKey(), entry.getValue()));			
		}
		
		return GenerationUtil.asStringParameters(parameterStrings);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ATTRIBUTE_GENERATION_POINT, 
			priority= IGenerationPointPriorityConstants.LOWEST, ifConditionIds= IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_CAN_PRINT, unique= true)
	public static void stream(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		if(isMany){
			//TODO: Not sure why we do not support many. 
			return;
		}
		
		String id= isPrimitiveType? IModelingConstructorDefinitionsConstants.STREAM_PRIMITIVE_ATTRIBUTE: 
			IModelingConstructorDefinitionsConstants.STREAM_ATTRIBUTE;
		
		String stream = generationValueGetter.generate(id, element, name);
		
		generationValueGetter.addValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_STREAM_IMPLEMENTATION, stream, parent, Boolean.valueOf(isPrimitiveType));
	}
	
	
	@GenerationPoint(generationPoint = IModelingDecisions.OPERATIONS_GENERATION_POINT)
	public static void operationsProcessor(
			@GenerationElementParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_RETURN_TYPE) String normalizedReturnType,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_VISIBILITY) String normalizedVisibility,
			@GenerationProcedureParameter(id = IModelingConstants.MULTILINE_COMMENTS_STRING) String commentsString,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String operationName,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.OPERATION_BODY) String operationCodeBody,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object interfaceObject,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		boolean isDefaultedImplementation= false;
		String codeBody= operationCodeBody;
		if(codeBody== null|| codeBody.isEmpty()){
			codeBody= generationValueGetter.use(ICppDefinitions.METHOD_TODO_STATEMENET, operationName);
			if(!CPPTypesConstants.VOID.equals(normalizedReturnType)){
				codeBody= codeBody+ CommonConstants.NEW_LINE+ generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, defaultValue);
			}
			codeBody= StringUtil.indent(codeBody, 1);
			
			isDefaultedImplementation= true;
		}else{
			codeBody= StringUtil.indent(codeBody, 1);
		}
		
		List<Object> parametersArgument = generationValueGetter.getValues(IModelingDecisions.OPERATION_PARAMETER_ARGUMENT, element, parent);
		
		
		
//		String type= generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME, 
//		GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_AS_PARAMETER_ARGUMENT, Boolean.TRUE), Boolean.TRUE);
		
		List<String> parameterStrings= new ArrayList<String>();
		for(Object item: parametersArgument){
			if(item instanceof SimpleEntry== false){
				continue;
			}
			
			SimpleEntry<?, ?> simpleEntry= (SimpleEntry<?, ?>) item;
			Object type = simpleEntry.getKey();
			
			type= generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME, 
					GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_CRUD_TYPE_ARGUMENT, type),
					GenerationArgumentDescriptor.arg(IModelingConstants.NORMALIZED_TYPE_AS_PARAMETER_ARGUMENT, Boolean.TRUE), Boolean.TRUE);
					
			parameterStrings.add(generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, type, simpleEntry.getValue()));			
		}
		
		String parametersString= GenerationUtil.asStringParameters(parameterStrings);
		
		boolean isPureVirtual= interfaceObject!= null;
		
		addMethodDetails(generationValueGetter, IModelingConstants.OPERATIONS_IMPLEMENTATION, normalizedReturnType, parametersString, 
				codeBody, parent, element, operationName, normalizedVisibility, IModelingConstants.METHOD_OPERATIONS_GROUP, commentsString, 
				false, operationCodeBody, isPureVirtual, isPureVirtual, isDefaultedImplementation);
		
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ADD_GENERATION_POINT)
	public static void setAddDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimtiveType,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationArgument String id,
			@GenerationArgument Object generationArguments,
			@GenerationProcedureParameter(id = IModelingConstants.ADD_METHOD_NAME) String addMethodName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String newInstance= generationValueGetter.generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		String parametersString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, type, newInstance, Boolean.valueOf(!isPrimtiveType));
		
		String body = generationValueGetter.use(ICppAssociationsDefinitionsConstants.ADD_CHECK_EXISTING, name, newInstance);
		
		boolean hasMaximumGetter = generationValueGetter.getBoolean(element, IModelingDecisions.HAS_MAXIMUM_GETTER);
		if(hasMaximumGetter){
			body = body+ CommonConstants.NEW_LINE+ generationValueGetter.generate(ICppAssociationsDefinitionsConstants.ADD_MAXIMUM_CHECK, element);
		}
		body= body+ CommonConstants.NEW_LINE+ generationValueGetter.generate(id, element, generationArguments);
		
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.ADD_IMPLEMENTATION, 
				CPPTypesConstants.BOOL, parametersString, body, parent, element, addMethodName, 
				VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ADD_AT_GENERATION_POINT)
	public static void setAddAtDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimtiveType,
			@GenerationProcedureParameter(id = IModelingConstants.ADD_AT_METHOD_NAME) String addAtMethodName,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String newInstanceParameter= generationValueGetter.generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		
		String newInstanceParameterAsString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, type, 
				newInstanceParameter, Boolean.valueOf(!isPrimtiveType));
		
		String addAtIndexParameter = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, 
				CPPTypesConstants.INTEGER, CPPCommonConstants.INDEX_VARIABLE);
		String addAtParametersString= GenerationUtil.asStringParameters(Arrays.asList(new String[]{newInstanceParameterAsString, addAtIndexParameter}));
		
		String body=  generationValueGetter.generate(ICppAssociationsDefinitionsConstants.ADD_AT_IMPLEMENTATION, element, name, newInstanceParameter);
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.ADD_AT_IMPLEMENTATION, 
				CPPTypesConstants.BOOL, addAtParametersString, body, parent, element,addAtMethodName, 
				VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ADD_OR_MOVE_GENERATION_POINT)
	public static void addOrMoveDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimtiveType,
			@GenerationProcedureParameter(id = IModelingConstants.ADD_OR_MOVE_METHOD_NAME) String addOrMoveMethodName,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String newInstanceParameter = generationValueGetter.generationPointString(element, ICppNameConstants.NEW_INSTANCE, 
				GenerationArgumentDescriptor.arg(IModelingConstants.ATTRIBUTE_SEEK_OTHER_END_ARGUMENT, Boolean.FALSE));
		String newInstanceParameterAsString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, type, 
				newInstanceParameter, Boolean.valueOf(!isPrimtiveType));
		
		String addAtIndexParameter = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, 
				CPPTypesConstants.INTEGER, CPPCommonConstants.INDEX_VARIABLE);
		String addAtParametersString= GenerationUtil.asStringParameters(Arrays.asList(new String[]{newInstanceParameterAsString, addAtIndexParameter}));
		
		String addOrMoveBody = generationValueGetter.generate(ICppAssociationsDefinitionsConstants.ADD_OR_MOVE_AT_IMPLEMENTATION, element);
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.ADD_OR_MOVE_AT_IMPLEMENTATION, 
				CPPTypesConstants.BOOL, addAtParametersString, addOrMoveBody, 
				parent, element, addOrMoveMethodName, VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ADD_GENERATION_POINT)
	public static void setConstructDetails() {
		//TODO: construct argument
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.SETTER_GENERATION_POINT, ifConditionIds= IModelingDecisions.ATTRIBUTE_IS_SETTABLE, 
			priority= IGenerationPointPriorityConstants.LOWEST)
	public static void setSetterDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingConstants.SETTER_METHOD_NAME) String setterMethodName,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationProcedureParameter(id = ICppDefinitions.IS_POINTER_TYPE) boolean isPointer,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.MODELING_DEFAULT_NEW_PARAMETER_NAME) String instnace,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument String id, @GenerationArgument Object generationArguments) {
		
		String expectedType= !isPointer&& !isMany?generationValueGetter.generate(ICppDefinitions.CONSTANT_PARAMETER, element, normalizedType): normalizedType;
		String parametersString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, expectedType, instnace);
		
		String contents = generationValueGetter.generate(id, element, instnace, generationArguments);
		String extra= generationValueGetter.generationPointString(element, ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION_CONDITION, 
				GenerationArgumentDescriptor.arg(ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION_ARGUMENT, contents));
		if(extra!= null&& !extra.isEmpty()){
			contents= extra;
		}
		String setterDeclarationBody = generationValueGetter.generate(ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION, element, contents,
				GenerationArgumentDescriptor.arg(IModelingConstants.METHOD_NAME, setterMethodName));
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION, 
				CPPTypesConstants.BOOL, parametersString, setterDeclarationBody, parent, element, setterMethodName, VisibilityConstants.PUBLIC, 
				IModelingConstants.METHOD_OUTGOING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DELETE_GENERATION_POINT)
	public static void setDeleteDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationArgument String id,
			@GenerationArgument Object generationArguments) {
		
		if(ICppAssociationsDefinitionsConstants.DELETE_DIRECTLY.equals(id)){
			if(isMany){
				String thisName = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
				String clearMethodName= generationValueGetter.use(ICppNameConstants.CLEAR_VECTOR);
				String invocation = generationValueGetter.use(ICppDefinitions.METHOD_INVOCATION, 
						clearMethodName, CommonConstants.BLANK);
				String deleteImplementation = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_USE, thisName, invocation, Boolean.TRUE, Boolean.TRUE);
				
				generationValueGetter.addValue(IModelingConstants.REMOVE_ASSOCIATED_OBJECTS, deleteImplementation, parent);
			}else{
				String thisName = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
				String deleteImplementation= generationValueGetter.use(ICppDefinitions.ASSIGN_STATEMENET, thisName, CPPCommonConstants.NULL);
				generationValueGetter.addValue(IModelingConstants.REMOVE_ASSOCIATED_OBJECTS, deleteImplementation, parent);
			}
		}else{
			String deleteImplementation= generationValueGetter.generate(id, element, generationArguments);
			generationValueGetter.addValue(IModelingConstants.REMOVE_ASSOCIATED_OBJECTS, deleteImplementation, parent);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_SINGLE_GENERATION_POINT, ifConditionIds= IModelingDecisions.ATTRIBUTE_IS_SETTABLE)
	public static void getterSingle(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationProcedureParameter(id = IModelingConstants.GETTER_METHOD_NAME) String getterMethodName,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.MULTILINE_COMMENTS_STRING) String elementComments,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		getter(generationValueGetter, normalizedType, element, parent, getterMethodName, ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION,
				IModelingConstants.METHOD_INCOMING_GROUP, isPrimitiveType, name, elementComments);
		
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_AFTER, priority= IGenerationPointPriorityConstants.LOWEST-100, 
			ifNotConditionIds= {IModelingElementDefinitions.IS_DERIVED})
	public static String afterGetter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument(id= IModelingConstants.METHOD_ID) String methodId,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name) {
		if(!ICppAssociationsDefinitionsConstants.GETTER_IMPLEMENTATION.equals(methodId)){
			return null;
		}
		String thisName = generationValueGetter.use(ICppDefinitions.ATTRIBUTE_USE, CPPCommonConstants.THIS, name, Boolean.TRUE);
		String returnStatement= generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, thisName);
		return CommonConstants.NEW_LINE+ StringUtil.indent(returnStatement, 1);
	}
	
	
	@GenerationPoint(generationPoint = ICppAssociationsDefinitionsConstants.IS_A_GETTER_IMPLEMENTATION)
	public static void isAGetter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingConstants.GETTER_METHOD_NAME) String getterMethodName,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationProcedureParameter(id = IModelingConstants.MULTILINE_COMMENTS_STRING) String elementComments,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		getter(generationValueGetter, normalizedType, element, parent, getterMethodName, ICppAssociationsDefinitionsConstants.IS_A_GETTER_IMPLEMENTATION,
				IModelingConstants.METHOD_INCOMING_GROUP, true, name, elementComments);
		
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_MANY_GENERATION_POINT, ifConditionIds= IModelingDecisions.ATTRIBUTE_IS_SETTABLE)
	public static void getterMany(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingConstants.MULTILINE_COMMENTS_STRING) String elementComments,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_ROLE_NAME) String normalizedRoleName,
			@GenerationProcedureParameter(id = IModelingConstants.NORMALIZED_TYPE_NAME) String normalizedType,
			@GenerationProcedureParameter(id = IModelingConstants.GETTER_METHOD_NAME) String getterMethodName,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String copyOf= generationValueGetter.use(ICppNameConstants.COPY_OF, normalizedRoleName);
		String getterDeclarationBody = generationValueGetter.generate(ICppAssociationsDefinitionsConstants.MANY_GETTER_METHOD, element, normalizedRoleName, 
				copyOf);
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.GETTER_MANY_IMPLEMENTATION, 
				normalizedType, CPPTypesConstants.VOID, getterDeclarationBody, parent, element, getterMethodName, VisibilityConstants.PUBLIC, 
				IModelingConstants.METHOD_INCOMING_GROUP, elementComments, false, name, false, false, false);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.GETTER_BY_INDEX_GENERATION_POINT, ifConditionIds= IModelingDecisions.ATTRIBUTE_IS_SETTABLE)
	public static void getterByIndex(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.GETTER_BY_INDEX_METHOD_NAME) String getterByIndexMethodName,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String normalizedType = generationValueGetter.generationPointString(element, IModelingConstants.NORMALIZED_TYPE_NAME, Boolean.TRUE);
		
		String indexParametersString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, 
				CPPTypesConstants.INTEGER, CPPCommonConstants.INDEX_VARIABLE);
		
		String getterByIndexBody = generationValueGetter.generate(ICppAssociationsDefinitionsConstants.GETTER_BY_INDEX_IMPLEMENTATION, element, name);
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.GETTER_BY_INDEX_IMPLEMENTATION, 
				normalizedType, indexParametersString, getterByIndexBody, parent, element, getterByIndexMethodName, 
				VisibilityConstants.PUBLIC, IModelingConstants.METHOD_INCOMING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.NUMBER_OF_GENERATION_POINT)
	public static void numberOF(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationProcedureParameter(id = IModelingConstants.NUMBER_OF_METHOD_NAME) String numberOfMethodName,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String numberOfBody = generationValueGetter.use(ICppAssociationsDefinitionsConstants.NUMBER_OF_IMPLEMENTATION, name);			
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.NUMBER_OF_IMPLEMENTATION, 
				CPPTypesConstants.UNSIGNED_INTEGER, CPPTypesConstants.VOID, numberOfBody, parent, element, 
				numberOfMethodName, VisibilityConstants.PUBLIC, IModelingConstants.METHOD_INCOMING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.CONTAINS_GENERATION_POINT)
	public static void contains(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingConstants.NUMBER_OF_METHOD_NAME) String numberOfMethod,
			@GenerationProcedureParameter(id = IModelingConstants.CONTAINS_METHOD_NAME) String containsMethodName,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String containsBody = generationValueGetter.use(ICppAssociationsDefinitionsConstants.CONTAINS_IMPLEMENTATION, numberOfMethod);			
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.CONTAINS_IMPLEMENTATION, 
				CPPTypesConstants.BOOL, CPPTypesConstants.VOID, containsBody, parent, element, containsMethodName, 
				VisibilityConstants.PUBLIC, IModelingConstants.METHOD_INCOMING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.INDEX_OF_GENERATION_POINT)
	public static void indexOf(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationProcedureParameter(id = IModelingConstants.MODELING_DEFAULT_SINGLE_PARAMETER_NAME) String instanceParameter,
			@GenerationProcedureParameter(id = IModelingConstants.INDEX_OF_METHOD_NAME) String indexOfMethodName,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String indexOfparametersString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, type, 
				instanceParameter, Boolean.valueOf(!isPrimitiveType));
		
		String indexOfBody = generationValueGetter.generate(ICppAssociationsDefinitionsConstants.INDEX_OF_IMPLEMENTATION, element, name, instanceParameter);			
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.INDEX_OF_IMPLEMENTATION, 
				CPPTypesConstants.INTEGER, indexOfparametersString, indexOfBody, parent, element, indexOfMethodName, 
				VisibilityConstants.PUBLIC, IModelingConstants.METHOD_INCOMING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.REMOVE_GENERATION_POINT)
	public static void remove(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE) boolean isPrimitiveType,
			@GenerationProcedureParameter(id = IModelingConstants.REMOVE_METHOD_NAME) String removeMethod,
			@GenerationProcedureParameter(id = IModelingConstants.MODELING_DEFAULT_SINGLE_PARAMETER_NAME) String instanceParameter,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {

		String parametersString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, type, instanceParameter, Boolean.valueOf(!isPrimitiveType));
		
		String removeDeclarationOfBody = generationValueGetter.generate(ICppAssociationsDefinitionsConstants.REMOVE_IMPLEMENTATION, element);			
		removeDeclarationOfBody= StringUtil.indent(removeDeclarationOfBody, 1);
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.REMOVE_IMPLEMENTATION, 
				CPPTypesConstants.BOOL, parametersString, removeDeclarationOfBody, parent, element, 
				removeMethod, VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.REMOVE_AT_GENERATION_POINT)
	public static void remove(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationProcedureParameter(id = IModelingConstants.REMOVE_AT_METHOD_NAME) String removeAtMethod,
			@GenerationBaseElement Object element,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		String indexParametersString = generationValueGetter.use(ICppDefinitions.PARAMETER_ASSIGN_STATEMENET, 
				CPPTypesConstants.INTEGER, CPPCommonConstants.INDEX_VARIABLE);
		
		String removeAtBody = generationValueGetter.generate(ICppAssociationsDefinitionsConstants.REMOVE_AT_IMPLEMENTATION, element);
		
		addMethodDetails(generationValueGetter, ICppAssociationsDefinitionsConstants.REMOVE_AT_IMPLEMENTATION, 
				CPPTypesConstants.BOOL, indexParametersString, removeAtBody, parent, element, removeAtMethod, VisibilityConstants.PUBLIC, 
				IModelingConstants.METHOD_OUTGOING_GROUP, name);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.MINIMUM_NUMBER_GENERATION_POINT)
	public static void minimum(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.LOWER_BOUND) int lowerBound,
			@GenerationProcedureParameter(id = IModelingConstants.MINIMUM_NUMBER_OF) String minimumNumberOf,
			@GenerationBaseElement Object element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String returnStatement= generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, String.valueOf(lowerBound));
		returnStatement= StringUtil.indent(returnStatement, 1);
		
		addMethodDetails(generationValueGetter, IModelingConstants.MINIMUM_NUMBER_OF, 
				CPPTypesConstants.UNSIGNED_INTEGER, CPPTypesConstants.VOID, returnStatement, parent, element, minimumNumberOf, 
				VisibilityConstants.PUBLIC, IModelingConstants.METHOD_OUTGOING_GROUP, null);
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.MAXIMUM_NUMBER_GENERATION_POINT)
	public static void maximum(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.UPPER_BOUND) int upperBound,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = IModelingConstants.MAXIMUM_NUMBER_OF) String maximumNumberOf,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent){
		
		String returnStatement= generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, String.valueOf(upperBound));
		returnStatement= StringUtil.indent(returnStatement, 1);
		
		String inlineReturnType= CPPCommonConstants.INLINE_MODIFIER+ CommonConstants.SPACE+ CPPTypesConstants.UNSIGNED_INTEGER;
		
		addMethodDetails(generationValueGetter, IModelingConstants.MAXIMUM_NUMBER_OF, 
				inlineReturnType, CPPTypesConstants.VOID, returnStatement, parent, element, maximumNumberOf, VisibilityConstants.PUBLIC, 
				IModelingConstants.METHOD_OUTGOING_GROUP, null);
	}

	@GenerationPoint(generationPoint = IModelingDecisions.SETTER_GENERATION_POINT)
	public static void setterFriendsDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,@GenerationArgument String id,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE) Object otherEndType,
			@GenerationBaseElement Object element, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_MINIMUM_FIXED_DECLARATION.equals(id)|| 
				ICppAssociationsDefinitionsConstants.ATTRIBUTE_SETTER_HASH_MAP_DECLARATION.equals(id)){
			setFriendsSetter(generationValueGetter, otherEndType, element, parent);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ADD_GENERATION_POINT)
	public static void addFriendsDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,@GenerationArgument String id,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE) Object otherEndType,
			@GenerationBaseElement Object element, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(ICppAssociationsDefinitionsConstants.ADD_REMOVE_EXISTING.equals(id)){
			setFriendsSetter(generationValueGetter, otherEndType, element, parent);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DELETE_GENERATION_POINT)
	public static void deleteFriendsDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,@GenerationArgument String id,
			@GenerationElementParameter(id = IModelingElementDefinitions.OTHER_END_TYPE) Object otherEndType,
			@GenerationBaseElement Object element, 
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(ICppAssociationsDefinitionsConstants.DELETE_USE_FRIEND_SETTER.equals(id)){
			setFriendsSetter(generationValueGetter, otherEndType, element, parent);
		}
	}
	
	private static void setFriendsSetter(GenerationPolicyRegistry generationValueGetter, Object otherEndType, Object element, Object parent) {
		String declaration = generationValueGetter.generate(ICppDefinitions.FRIEND_SETTER_DECLARATION, element);
		generationValueGetter.addUniqueValue(ICppDefinitions.FRIEND_SETTER_DECLARATION, declaration, otherEndType);
		
		String implementation = generationValueGetter.generate(ICppDefinitions.FRIEND_SETTER_IMPLEMENTATION, element);
		generationValueGetter.addUniqueValue(ICppDefinitions.FRIEND_SETTER_IMPLEMENTATION, implementation, parent);
	}
	
	private static void getter(GenerationPolicyRegistry generationValueGetter,
			String normalizedType, Object element, Object parent, String getterMethod, String id, String group, boolean isPrimitiveType, String identifier, 
			String elementComments) {
		addMethodDetails(generationValueGetter, id, normalizedType, CPPTypesConstants.VOID, 
				CommonConstants.BLANK, parent, element, getterMethod, VisibilityConstants.PUBLIC, group, elementComments, isPrimitiveType, identifier, 
				false, false, false);
	}
	
	private static void addMethodDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, String id, String returnType, String parametersString,
			String codeBody, Object parent, Object element, String name, String visibility, String groupId, String identifier){
		addMethodDetails(generationValueGetter, id, returnType, parametersString, codeBody, parent, element, name, visibility, groupId, false, identifier);
	}
	
	private static void addMethodDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, String id, String returnType, String parametersString,
			String codeBody, Object parent, Object element, String name, String visibility, String groupId, boolean isPrimitiveType, String identifier){
		addMethodDetails(generationValueGetter, id, returnType, parametersString, codeBody, parent, element, name, visibility, groupId, null, 
				isPrimitiveType, identifier, false, false, false);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_BEFORE, priority= IGenerationPointPriorityConstants.EX_HIGHEST)
	public static String beforeSetter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationArgument(id= IModelingConstants.METHOD_ID) String methodId) {
		if(ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION.equals(methodId)){
			String use = generationValueGetter.use(ICppDefinitions.ASSIGN_STATEMENET, IModelingConstants.WAS_SET, Boolean.FALSE.toString(), CPPTypesConstants.BOOL);
			return StringUtil.indent(use, 1)+ CommonConstants.NEW_LINE;
		}else if(ICppAssociationsDefinitionsConstants.ADD_IMPLEMENTATION.equals(methodId)|| ICppAssociationsDefinitionsConstants.ADD_AT_IMPLEMENTATION.equals(methodId)){
			String use = generationValueGetter.use(ICppDefinitions.ASSIGN_STATEMENET, IModelingConstants.WAS_ADDED, Boolean.FALSE.toString(), CPPTypesConstants.BOOL);
			return StringUtil.indent(use, 1)+ CommonConstants.NEW_LINE;
		}else if(ICppAssociationsDefinitionsConstants.REMOVE_IMPLEMENTATION.equals(methodId)||
				ICppAssociationsDefinitionsConstants.REMOVE_AT_IMPLEMENTATION.equals(methodId)){
			String use = generationValueGetter.use(ICppDefinitions.ASSIGN_STATEMENET, IModelingConstants.WAS_REMOVED, Boolean.FALSE.toString(), CPPTypesConstants.BOOL);
			return StringUtil.indent(use, 1)+ CommonConstants.NEW_LINE;
		}
		
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_AFTER, priority= IGenerationPointPriorityConstants.LOWEST)
	public static String afterSetter(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationArgument(id= IModelingConstants.METHOD_ID) String methodId) {
		if(ICppAssociationsDefinitionsConstants.SETTER_IMPLEMENTATION.equals(methodId)){
			String use = generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, IModelingConstants.WAS_SET);
			return CommonConstants.NEW_LINE+ StringUtil.indent(use, 1);
		}else if(ICppAssociationsDefinitionsConstants.ADD_IMPLEMENTATION.equals(methodId)|| ICppAssociationsDefinitionsConstants.ADD_AT_IMPLEMENTATION.equals(methodId)){
			String use = generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, IModelingConstants.WAS_ADDED);
			return CommonConstants.NEW_LINE+ StringUtil.indent(use, 1);
		}else if(ICppAssociationsDefinitionsConstants.REMOVE_IMPLEMENTATION.equals(methodId)|| 
				ICppAssociationsDefinitionsConstants.REMOVE_AT_IMPLEMENTATION.equals(methodId)){
			String use = generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, IModelingConstants.WAS_REMOVED);
			return CommonConstants.NEW_LINE+ StringUtil.indent(use, 1);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.METHOD_IMPLEMENTATION_AFTER, priority= IGenerationPointPriorityConstants.LOWEST-1000)
	public static String afterRegisteredReturnStatement(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationArgument(id= IModelingConstants.METHOD_ID) String methodId) {
		
		List<Object> values = generationValueGetter.getValues(methodId+ ICppAssociationsDefinitionsConstants.IMPLEMENTATION_RETURN_TRACKER, element);
		if(values.isEmpty()){
			return null;
		}
		String use = generationValueGetter.use(ICppDefinitions.RETURN_STATEMENET, values.get(0));
		return CommonConstants.NEW_LINE+ StringUtil.indent(use, 1);
	}
	
	private static void addMethodDetails(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, String id, String returnType, String parametersString,
			String codeBody, Object parent, Object element, String name, String visibility, String groupId, String comment, boolean isConstant, String identifier, 
			boolean isVirtual, boolean isPure, boolean isDefaultedImplementation){
		Map<String, Object> map= new HashMap<String, Object>();
		map.put(IModelingConstants.METHOD_RETURN_TYPE, returnType);
		map.put(IModelingConstants.METHOD_PARAMETERS_STRING, parametersString);
		map.put(IModelingConstants.CODY_BODY, codeBody);
		map.put(IModelingConstants.METHOD_COMMENT, comment);
		map.put(IModelingConstants.METHOD_NAME, name);
		map.put(IModelingConstants.METHOD_ID, identifier);
		map.put(IModelingConstants.METHOD_GROUP, groupId);
		map.put(IModelingConstants.METHOD_OBJECT, element);
		map.put(ICppDefinitions.METHOD_CONST, Boolean.valueOf(isConstant));
		map.put(IModelingConstants.METHOD_DEFAULTED_IMPLEMENTATION, Boolean.valueOf(isDefaultedImplementation));
		map.put(ICppDefinitions.METHOD_VIRTUAL, Boolean.valueOf(isVirtual));
		map.put(ICppDefinitions.METHOD_PURE, Boolean.valueOf(isPure));
		generationValueGetter.addValue(id, map, parent, visibility);
		
		if(identifier!= null&& !identifier.isEmpty()){
			generationValueGetter.addValue(id, map, identifier, parent, visibility);
		}
		
		generationValueGetter.addUniqueValue(IModelingConstants.METHOD_IDS, identifier, parent);
		
	}
	
}