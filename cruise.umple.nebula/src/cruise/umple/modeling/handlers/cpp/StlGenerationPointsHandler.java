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

import java.util.Arrays;
import java.util.List;

import cruise.umple.core.DecisionPoint;
import cruise.umple.core.GenerationArgumentDescriptor;
import cruise.umple.core.GenerationPoint;
import cruise.umple.core.GenerationPolicyRegistry;
import cruise.umple.core.IGenerationPointPriorityConstants;
import cruise.umple.core.GenerationCallback.GenerationArgument;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationElementParameter;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationCallback.GenerationProcedureParameter;
import cruise.umple.core.GenerationCallback.GenerationRegistry;
import cruise.umple.core.GenerationCallback.WatchedObjectValue;
import cruise.umple.core.GenerationPoint.InterceptorResponse;
import cruise.umple.cpp.utils.CPPTypesConstants;
import cruise.umple.cpp.utils.CommonTypesConstants;
import cruise.umple.modeling.handlers.IModelingConstructorDefinitionsConstants;
import cruise.umple.modeling.handlers.IModelingDecisions;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;


public class StlGenerationPointsHandler{
	
	@DecisionPoint(decisionPoint = IModelingDecisions.IS_LANGUAGE_PRIMITIVE_TYPE)
	public static boolean isPrimitiveType(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationArgument(id= IModelingDecisions.DEPENDS_TYPE_OBJECT_ARGUMENT) Object type){
		
		List<String> list = Arrays.asList(new String[]{ISTLConstants.STRING, ISTLConstants.TIME, ISTLConstants.DATE});
		if((type!= null&& list.contains(type))|| list.contains(typeName)){
			return true;
		}
		return false;
	}
	
	@DecisionPoint(decisionPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_FILTER_DEFAULT_ASSIGN)
	public static boolean avoidStringNullify(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		return ISTLConstants.STRING.equals(typeName);
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.IS_POINTER_TYPE, optimistic= true)
	public static boolean enableDateTimePointer(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		return Arrays.asList(new String[]{ISTLConstants.TIME, ISTLConstants.DATE}).contains(typeName);
	}
	
	@GenerationPoint(generationPoint = ICppDefinitions.ATTRIBUTE_EQUALITY, priority=IGenerationPointPriorityConstants.HIGH,  unique= true)
	public static String attributeEquality(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		
		if(!ISTLConstants.STRING.equals(typeName)|| isMany){
			return null;
		}
		
		return generationValueGetter.use(ICppDefinitions.STRING_ATTRIBUTE_EQUALITY,name);
	}
	
	@DecisionPoint(decisionPoint = ICppDefinitions.ATTRIBUTE_DISABLE_DELETE)
	public static boolean disableDelete(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type) {
		return ISTLConstants.STRING.equals(type);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_GENERATION_POINT, priority= IGenerationPointPriorityConstants.HIGHEST,  
			unique= true)
	public static String copyConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationElementParameter(id = IModelingElementDefinitions.NAME) String name){
		if(!ISTLConstants.STRING.equals(typeName)){
			return null;
		}
		
		//Now, we are using STD library
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		return generationValueGetter.use(ICppDefinitions.COPY_STRING_ATTRIBUTE, name);
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.COPY_CONSTRUCTOR_GENERATION_POINT, priority= IGenerationPointPriorityConstants.HIGHEST,  
			unique= true)
	public static void dataTimeConditionsCopyConstructor(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		if(!Arrays.asList(new String[] {ISTLConstants.TIME, ISTLConstants.DATE}).contains(typeName)){
			return;
		}
		
		//Now, we are using STD library
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.C_TIME), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT,
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.C_TIME), 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY), 
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DEFAULT_LANGUAGE_TYPE_VALUE, priority=IGenerationPointPriorityConstants.HIGHEST, unique= true)
	public static String defaultCPPParameterValue(@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue,
			@GenerationLoopElement Object modelPackage,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName){
		
		if(ISTLConstants.DATE.equals(typeName)|| ISTLConstants.TIME.equals(typeName)){
			if(defaultValue!= null&& !defaultValue.isEmpty()){
				
				//Add time code helper
				generationValueGetter.addUniqueValue(ICppDefinitions.HELPER_CODES, generationValueGetter.use(ICppDefinitions.TIME_HELPER_CODE), modelPackage);
				generationValueGetter.addUniqueValue(ICppDefinitions.HELPER_INCLUDES, generationValueGetter.use(ICppDefinitions.TIME_HELPER_CODE_INCLUDES), modelPackage);
				return defaultValue;
			}
			return generationValueGetter.use(ISTLConstants.DATE.equals(typeName)?ISTLConstants.DEFAULT_DATE_ASSIGN: ISTLConstants.DEFAULT_TIME_ASSIGN);
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = ICppMethods.CLASS_INLINE_DECLARATION, unique= true)
	public static boolean filterClassInlineDeclarationForDateTime(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String type) {
		
		if(Arrays.asList(new String[] {ISTLConstants.TIME, ISTLConstants.DATE}).contains(type)){
			return true;
		}
		
		return false;
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.DEFAULT_LANGUAGE_TYPE_VALUE, unique= true)
	public static String defaultVectorValue(@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationProcedureParameter(id = ICppDefinitions.IS_POINTER_TYPE) Boolean isPointer,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter,
			@GenerationBaseElement Object element,
			@GenerationProcedureParameter(id = ICppDecisions.ATTRIBUTE_IS_MANY) boolean isMany,
			@GenerationProcedureParameter(id = IModelingElementDefinitions.DEFAULT_VALUE) String defaultValue){
		if(defaultValue== null|| defaultValue.isEmpty()){
			if(isMany){
				return generationValueGetter.generate(ISTLConstants.NEW_VECTOR_DEFINITION, element, typeName, isPointer);
			}
		}
		return null;
	}
	
	@GenerationPoint(generationPoint = IModelingConstructorDefinitionsConstants.CONSTRUCTOR_GENERATION_POINT)
	public static void constructorAutoUnique(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.IS_LAZY) boolean isLazy,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		if(isLazy&& ISTLConstants.TIME.equals(typeName)){
			generationValueGetter.addUniqueValue(IModelingConstructorDefinitionsConstants.CONSTRUCTOR_PRE_IMPLEMENTATION, 
					generationValueGetter.use(ISTLConstants.CURRENT_TIME_REFERENCE), parent);
		}
	}
	
	@GenerationPoint(generationPoint = IModelingDecisions.ATTRIBUTE_GENERATION_POINT, priority= IGenerationPointPriorityConstants.HIGH)
	public static void basicAttributeDeclaration(@GenerationRegistry GenerationPolicyRegistry generationValueGetter, 
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) Object parent) {
		
		if(!ISTLConstants.STRING.equals(typeName)){
			return;
		}
		
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING),
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.HEADER_INCLUDES_TRACKER));
		
		generationValueGetter.generationPointString(parent, ICppModelingDecisions.CPP_LIBRARY_DEPENDS_GENERATION_POINT, 
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_INCLUDE_ARGUMENT, ISTLConstants.STRING),
				GenerationArgumentDescriptor.arg(ICppModelingDecisions.CPP_LIBRARY_DEPENDS_LIBRARY_ARGUMENT, ISTLConstants.STD_LIBRARY),
				GenerationArgumentDescriptor.arg(IModelingDecisions.DEPENDS_INCLUDE_ID_ARGUMENT, ICppDefinitions.BODY_INCLUDES_TRACKER));
	}
	
	
	@GenerationPoint(intercept = {IModelingElementDefinitions.RETURN_TYPE})
	public static InterceptorResponse returnTypeName(@WatchedObjectValue String typeName){
		if(typeName== null){
			return new InterceptorResponse(CPPTypesConstants.VOID);
		}
		return typeName(typeName);
	}
	
	@GenerationPoint(intercept = {IModelingElementDefinitions.DEFAULT_VALUE})
	public static InterceptorResponse normalizedDateDefaultValue(@WatchedObjectValue String defaultValue,
			@GenerationElementParameter(id = IModelingElementDefinitions.TYPE_NAME) String typeName,
			@GenerationRegistry GenerationPolicyRegistry generationValueGetter){
		if(defaultValue== null|| defaultValue.isEmpty()){
			return null;
		}
		
		if(ISTLConstants.DATE.equals(typeName)){
			return new InterceptorResponse(generationValueGetter.use(ISTLConstants.DATE_ASSIGN, defaultValue));
		}else if(ISTLConstants.TIME.equals(typeName)){
			return new InterceptorResponse(generationValueGetter.use(ISTLConstants.TIME_ASSIGN, defaultValue));
		}
		
		return null;
	}
	
	@GenerationPoint(intercept = IModelingElementDefinitions.TYPE_NAME)
	public static InterceptorResponse typeName(@WatchedObjectValue String typeName){
		if(CommonTypesConstants.TIME.equals(typeName)){
			return new InterceptorResponse(ISTLConstants.TIME);
		}else if(CommonTypesConstants.DATE.equals(typeName)){
			return new InterceptorResponse(ISTLConstants.DATE);
		}else if(CommonTypesConstants.STRING.equals(typeName)){
			return new InterceptorResponse(ISTLConstants.STRING);
		}
		return null;
	}
	
}