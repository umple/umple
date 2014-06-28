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
package cruise.umple.cpp.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import cruise.umple.compiler.AssociationEnd;
import cruise.umple.compiler.AssociationVariable;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.CodeInjection;
import cruise.umple.compiler.Constraint;
import cruise.umple.compiler.ConstraintVariable;
import cruise.umple.compiler.Depend;
import cruise.umple.compiler.GenerateTarget;
import cruise.umple.compiler.Method;
import cruise.umple.compiler.MethodBody;
import cruise.umple.compiler.MethodParameter;
import cruise.umple.compiler.Position;
import cruise.umple.compiler.Precondition;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleClassifier;
import cruise.umple.compiler.UmpleElement;
import cruise.umple.compiler.UmpleInterface;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.UmpleVariable;
import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationCallback.GenerationBaseElement;
import cruise.umple.core.GenerationCallback.GenerationLoopElement;
import cruise.umple.core.GenerationValueAnnotation;
import cruise.umple.cpp.util.UmpleCPPGenerationUtil;
import cruise.umple.cpp.utils.StringUtil;
import cruise.umple.modeling.handlers.IModelingElementDefinitions;
import cruise.umple.modeling.handlers.VisibilityConstants;

public class UmpleModelGenerationPolicy{
	
	private static boolean IS_BUNDLEED= false;
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAMESPACE)
	public static String getNamespace(@GenerationBaseElement UmpleModel model) {
		return model.getDefaultNamespace();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.VERSION_NUMBER)
	public static String getVersionNumber() {
		return UmpleModel.VERSION_NUMBER;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.GENERATES)
	public static String getGeneratePath(@GenerationLoopElement UmpleModel model, String langaugeId) {
		if(IS_BUNDLEED){
			return getFileName(model);
		}
		
		String normalizedLanguageId= langaugeId== null? CommonConstants.BLANK: langaugeId;
		for(GenerateTarget generateTarget:  model.getGenerates()){
			if(normalizedLanguageId.equals(generateTarget.getLanguage())){
				String path = generateTarget.getPath();
				if(CommonConstants.BLANK.equals(path)){
					continue;
				}
				return path;
			}
		}
		return CommonConstants.BLANK;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.FILE)
	public static String getFileName(@GenerationBaseElement UmpleModel model) {
		String fileName = model.getUmpleFile().getFileName();
		return fileName.substring(0, fileName.lastIndexOf(CommonConstants.DOT));
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.FILE_PATH)
	public static String getFilePath(@GenerationBaseElement UmpleModel model) {
		return model.getUmpleFile().getPath();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAMESPACE)
	public static String getNamespace(@GenerationBaseElement UmpleElement element) {
		return element.getPackageName();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CLASSES)
	public static Collection<?> ownedClasses(@GenerationBaseElement UmpleModel model){
		return model.getUmpleClasses();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.INTERFACES)
	public static Collection<?> ownedInterfaces(@GenerationBaseElement UmpleModel model){
		return model.getUmpleInterfaces();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CODE)
	public static String getExtraCode(@GenerationBaseElement UmpleElement element){
		return element.getExtraCode();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CODE_INJECTION)
	public static List<String> getInjectedCode(@GenerationBaseElement UmpleClass element, @GenerationLoopElement UmpleModel modelPackage,
			String operationName, boolean after, String langauge){
		
		List<String> codes= new ArrayList<String>();
		for(CodeInjection codeInjection: element.getCodeInjections()){
			if(!(codeInjection.getType().equals("before")?!after: after)){ //$NON-NLS-1$
				continue;
			}
			String operation = codeInjection.getOperation();
			String qArr[] = operation.split("\\,"); //$NON-NLS-1$
			for (int i = 0; i < qArr.length; i++) {
				String regex = "(?=" + qArr[i]; //$NON-NLS-1$
				if (regex.indexOf("*") >= 0) { //$NON-NLS-1$
					regex = regex.replaceAll("\\*", ".*"); //$NON-NLS-1$ //$NON-NLS-2$
				}
				if (regex.indexOf("!") >= 0) { //$NON-NLS-1$
					regex = regex.replaceAll("\\!", "[^"); //$NON-NLS-1$ //$NON-NLS-2$
					regex += "]"; //$NON-NLS-1$
				}
				qArr[i] = regex + ")"; //$NON-NLS-1$
			}

			boolean matched = true;
			for (String pattern : qArr) {
				matched &= Pattern.compile(pattern).matcher(operationName).find();
			}

			if(matched){
				List<String> positions = UmpleCPPGenerationUtil.getPositions(Arrays.asList(new Position[]{codeInjection.getPosition()}), langauge, element, modelPackage);
				String positionsString= null;
				if(!positions.isEmpty()){
					positionsString= positions.get(0);
				}
				
				String code = codeInjection.getCode();
				String languageSpecificCode = codeInjection.getSnippet().getCode(langauge);
				if(languageSpecificCode!= null){
					if(positionsString!= null){
						languageSpecificCode= positionsString+ CommonConstants.NEW_LINE+ languageSpecificCode;
					}
					codes.add(languageSpecificCode);
				}else{
					if(code!= null){
						if(positionsString!= null){
							code= code+ CommonConstants.NEW_LINE+ code;
						}
						codes.add(code);
					}
				}
			}
		}
		return codes;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OPERATIONS)
	public static List<?> getOwnedOperations(@GenerationBaseElement UmpleClassifier classifier){
		return classifier.getMethods();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ATTRIBUTES)
	public static List<?> getOwnedAttributes(@GenerationBaseElement UmpleClass element){
		//Interface does not have attributes
		return element.getAttributes();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.LINE_NUMBERS)
	public static List<String> getLineNumbers(@GenerationBaseElement UmpleElement element, @GenerationLoopElement UmpleModel modelPackage,
			String language) {
		return UmpleCPPGenerationUtil.getPositions(element.getPositions(), language, element, modelPackage);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.LINE_NUMBERS)
	public static List<String> getLineNumbers(@GenerationBaseElement Method method, @GenerationLoopElement UmpleModel modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) UmpleElement parent,
			String language) {
		return UmpleCPPGenerationUtil.getPositions(Arrays.asList(new Position[]{method.getPosition()}), language, parent, modelPackage);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.LINE_NUMBERS)
	public static List<String> getLineNumbers(@GenerationBaseElement AssociationVariable associationVariable, @GenerationLoopElement UmpleModel modelPackage,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR, IModelingElementDefinitions.INTERFACES_PROCESSOR}) UmpleElement parent,
			String language) {
		AssociationEnd associationEnd = UmpleCPPGenerationUtil.getAssociationEnd(associationVariable);
		if(associationEnd== null){
			return null;
		}
		return UmpleCPPGenerationUtil.getPositions(Arrays.asList(new Position[]{associationEnd.getAssociation().getTokenPosition()}), language, parent, modelPackage);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OPERATION_PARAMETERS)
	public static List<?> getOperationParametersString(@GenerationBaseElement Method method){
		List<MethodParameter> parameters= new ArrayList<MethodParameter>();
		for(MethodParameter methodParameter: method.getMethodParameters()){
			parameters.add(methodParameter);
		}
		
		return parameters;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OPERATION_BODY)
	public static String getBody(@GenerationBaseElement Method method, String language){
		MethodBody methodBody = method.getMethodBody();
		if(methodBody== null){
			return CommonConstants.BLANK;
		}
		String code = methodBody.getCodeblock().getCode(language);
		if(code!= null&& !code.isEmpty()){
			return code;
		}
		String extraCode = methodBody.getExtraCode();
		return extraCode!=null?extraCode: CommonConstants.BLANK;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAME)
	public static String getName(@GenerationBaseElement Object element){
		if(element instanceof UmpleModel){
			return ((UmpleModel)element).getUmpleFile().getSimpleFileName();
		}else if(element instanceof UmpleElement){
			return ((UmpleElement) element).getName();
		}else if(element instanceof UmpleVariable){
			UmpleVariable umpleVariable = (UmpleVariable) element;
			return umpleVariable.getName();
		}else if(element instanceof Method){
			return ((Method) element).getName();
		}else if(element instanceof MethodParameter){
			return ((MethodParameter)element).getName();
		}else if(element instanceof Precondition){
			return ((Precondition)element).toString();
		}
		return null;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.SINGULAR_NAME)
	public static String getSingularName(@GenerationLoopElement UmpleModel modelPackage, String name){
		return modelPackage.getGlossary().getSingular(name);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.PLURAL_NAME)
	public static String getPluralName(@GenerationLoopElement UmpleModel modelPackage, String name){
		return modelPackage.getGlossary().getPlural(name);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.USE)
	public static String use(@GenerationBaseElement Depend depend){
		return depend.getName();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<Constraint> constraints(@GenerationBaseElement UmpleClass element){
		return element.getConstraints();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<Precondition> constraints(@GenerationBaseElement Method element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR/*, IModelingElementDefinitions.INTERFACES_PROCESSOR*/}) UmpleClass parent){
		List<Precondition> constraints= new ArrayList<Precondition>();
		if(parent== null){
			return constraints;
		}
		for(Precondition preCondition: parent.getPreconditions()){
			if(element.equals(preCondition.getMethod())){
				constraints.add(preCondition);
			}
		}
		return constraints;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<Constraint> constraints(@GenerationBaseElement Attribute element,
			@GenerationLoopElement(id= {IModelingElementDefinitions.CLASSES_PROCESSOR/*, IModelingElementDefinitions.INTERFACES_PROCESSOR*/}) UmpleClass parent){
		List<Constraint> constraints= new ArrayList<Constraint>();
		for(Constraint constraint: parent.getConstraints()){
			for(ConstraintVariable expression: constraint.getExpressions()){
				if(!constraints.contains(constraint)&& element.equals(expression.getAttribute(parent))){
					constraints.add(constraint);
				}
			}
		}
		return constraints;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINTS)
	public static List<Constraint> constraints(@GenerationBaseElement ConstraintVariable element){
		return Arrays.asList(element.getSubConstraint());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ATTRIBUTE)
	public static UmpleVariable constraintAttribute(@GenerationBaseElement ConstraintVariable element){
		return element.getFoundAttribute();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINT_EXPRESSIONS)
	public static List<ConstraintVariable> constraintExpressions(@GenerationBaseElement Constraint element){
		return Arrays.asList(element.getExpressions());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINT_EXPRESSION_TYPE)
	public static String constraintExpressionType(@GenerationBaseElement ConstraintVariable element){
		return element.getType();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINT_EXPRESSION_IS_ATTRIBUTE)
	public static boolean constraintExpressionIsAttribute(@GenerationBaseElement ConstraintVariable element){
		return element.getIsAttribute();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINT_EXPRESSION_VALUE)
	public static String constraintExpressionValue(@GenerationBaseElement ConstraintVariable element){
		return element.getValue();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINT_EXPRESSION_IS_OPERATOR)
	public static boolean constraintExpressionIsOperator(@GenerationBaseElement ConstraintVariable element){
		return element.getIsOperator();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.CONSTRAINT_EXPRESSION_IS_PRIMITIVE)
	public static boolean constraintExpressionIsPrimitive(@GenerationBaseElement ConstraintVariable element){
		return element.getIsPrimitive();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_SINGLETON)
	public static boolean isSingleton(@GenerationBaseElement UmpleClass element){
		return element.isIsSingleton();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ROLE_NAME)
	public static String getRoleName(@GenerationBaseElement AssociationVariable associationVariable){
		return getRole(associationVariable);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ROLE_NAME)
	public static String getRoleName(@GenerationBaseElement Attribute attribute){
		String name = attribute.getName();
		String type = StringUtil.firstCharacterToLowerCase(attribute.getType());
		
		String singular= name;
		if(singular.length()>1){
			singular= singular.substring(0, singular.length()-1);
		}
		if(type.equals(singular)){
			return null;
		}
		return name;
	}

	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OTHER_END_ROLE_NAME)
	public static String getOtherEndRoleName(@GenerationBaseElement AssociationVariable associationVariable){
		return getRole(associationVariable.getRelatedAssociation());
	}
	
	private static String getRole(AssociationVariable associationVariable) {
		//TODO: We shall be able to get the role name directly instead of doing these calculations
		AssociationEnd associationEnd = UmpleCPPGenerationUtil.getAssociationEnd(associationVariable);
		if(associationEnd== null){
			return null;
		}
		
		String roleName = associationEnd.getRoleName();
		if(roleName== null|| roleName.isEmpty()){
			return null;
		}
		String name = associationVariable.getName();
		String type = StringUtil.firstCharacterToLowerCase(associationVariable.getType());
		
		String singular= name;
		if(singular.length()>1){
			singular= singular.substring(0, singular.length()-1);
		}
		if(type.equals(singular)){
			return null;
		}
		
		if(associationEnd.isIsDefaultRoleName()){
			if(associationEnd.getClassName().toUpperCase().equals(singular)){
				//If it is not default name, then return null, as the generation handler will take care of deciding the proper naming
				//TODO: Not sure if the role name shall have a fabricated value if the user has not put it; instead, it must return null. Having a condition like
				//default role name makes it a bit confusing to know that fact.
				return null;
			}
			return name;
		}
		
		return name;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.DEPENDS)
	public static List<?> getDepends(@GenerationBaseElement UmpleClassifier classifier){
		return classifier.getDepends();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ELEMENT_VISIBILITY)
	public static String getElementVisibility(@GenerationBaseElement Object element){
		if(element instanceof Attribute){
			return ((Attribute)element).isConstant()? VisibilityConstants.PUBLIC: VisibilityConstants.PRIVATE;
		}else if(element instanceof Method){
			String modifier = ((Method) element).getModifier();
			if(modifier.contains(VisibilityConstants.PUBLIC)){
				return VisibilityConstants.PUBLIC;
			}else if(modifier.contains(VisibilityConstants.PRIVATE)){
				return VisibilityConstants.PRIVATE;
			}else if(modifier.contains(VisibilityConstants.PROTECTED)){
				return VisibilityConstants.PROTECTED;
			}
			return VisibilityConstants.PUBLIC;
		}else if(element instanceof UmpleElement){
			//TODO (Discussion): Return public static for all cases
			return VisibilityConstants.PUBLIC;
		}
		return null;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_NAVIGABLE)
	public static boolean isNavigable(@GenerationBaseElement AssociationVariable associationVariable){
		return associationVariable.getIsNavigable();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_OTHER_END_NAVIGABLE)
	public static boolean isOtherEndNavigable(@GenerationBaseElement AssociationVariable associationVariable){
		return associationVariable.getRelatedAssociation().getIsNavigable();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.TYPE_NAME)
	public static String getTypeName(@GenerationBaseElement UmpleVariable associationVariable){
		return sortedTypeHack(associationVariable.getType());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.TYPE_NAME)
	public static String getOperationName(@GenerationBaseElement Method method){
		return sortedTypeHack(method.getType());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_SORTED)
	public static boolean isSorted(@GenerationBaseElement UmpleVariable associationVariable){
		return isSorted(associationVariable.getType());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OTHER_END_TYPE_NAME)
	public static String getOtherEndTypeName(@GenerationBaseElement AssociationVariable associationVariable){
		AssociationVariable relatedAssociation = associationVariable.getRelatedAssociation();
		return sortedTypeHack(relatedAssociation.getType());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.PRIORITY)
	public static String priority(@GenerationBaseElement AssociationVariable associationVariable){
		return associationVariable.getPriority();
	}

	//FIXME: We have to apply this hack. The sorted association generator is Java dependent, and assumes that Comparator will work for all languages which is wrong
	//For now, let us just alter the current type value till we figure out a way to make the code more language-independent
	//Suggestion is to have an Umple pre-defined type called Comparator and it can be consumed by all generators.
	private static String sortedTypeHack(String type) {
		if(isSorted(type)){
			int indexOf = type.indexOf("<"); //$NON-NLS-1$
			int lastIndexOf = type.lastIndexOf(">"); //$NON-NLS-1$
			String altered= type.substring(indexOf+1, lastIndexOf);
			return altered;
		}
		return type;
	}

	private static boolean isSorted(String type) {
		return type.startsWith("Comparator<")&& type.endsWith(">"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.RETURN_TYPE)
	public static String getReturnType(@GenerationBaseElement Method element){
		return element.getType();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OTHER_END_UPPER_BOUND)
	public static int getOtherEndUpperBound(@GenerationBaseElement AssociationVariable associationVariable){
		return associationVariable.getRelatedAssociation().getMultiplicity().getUpperBound();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OTHER_END_LOWER_BOUND)
	public static int getOtherEndLowerBound(@GenerationBaseElement AssociationVariable associationVariable){
		return associationVariable.getRelatedAssociation().getMultiplicity().getLowerBound();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.UPPER_BOUND)
	public static int getMultiplicityUpperLimit(@GenerationBaseElement Object element){
		if(element instanceof AssociationVariable){
			return ((AssociationVariable)element).getMultiplicity().getUpperBound();
		}else if(element instanceof Attribute){
			return ((Attribute)element).isIsList()?-1:1;
		}
		return 0;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.LOWER_BOUND)
	public static int getLowerBound(@GenerationBaseElement Object element){
		if(element instanceof AssociationVariable){
			return ((AssociationVariable)element).getMultiplicity().getLowerBound();
		}else if(element instanceof Attribute){
			return 1;
		}
		return 0;
		
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OTHER_END_TYPE)
	public static UmpleClass getOtherEndType(@GenerationBaseElement AssociationVariable associationVariable){
		return associationVariable.getRelatedAssociation().getUmpleClass();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.TYPE)
	public static UmpleClass getType(@GenerationBaseElement AssociationVariable associationVariable){
		return associationVariable.getUmpleClass();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OTHER_END_NAME)
	public static String getOtherEndName(@GenerationBaseElement AssociationVariable associationVariable){
		return associationVariable.getRelatedAssociation().getName();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.OWNER_NAME)
	public static String getOwenrName(@GenerationBaseElement Object element){
		if(element instanceof AssociationVariable){
			((AssociationVariable)element).getUmpleClass().getName();
		}else if(element instanceof UmpleElement){
			((UmpleElement)element).getPackageName();
		}
		return null;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.COMMENTS)
	public static List<String> getComments(@GenerationBaseElement Object element) {
		if(element instanceof AssociationVariable){
			return UmpleCPPGenerationUtil.getCommentStrings(((AssociationVariable)element).getComments());
		}else if(element instanceof UmpleClass){
			return UmpleCPPGenerationUtil.getCommentStrings(((UmpleClass)element).getComments());
		}else if(element instanceof Method){
			return UmpleCPPGenerationUtil.getCommentStrings(((Method)element).getComments());
		}else if(element instanceof Attribute){
			return UmpleCPPGenerationUtil.getCommentStrings(((Attribute)element).getComments());
		}
		//TODO: Umple interface does not have comments? Even, we better have a common interface instead of checking for each element
		return null;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.PARENT_INTERFACES)
	public static List<?> getParentInterfaces(@GenerationBaseElement Object element){
		if(element instanceof UmpleClass){
			return ((UmpleClass)element).getParentInterface();
		}else if(element instanceof UmpleInterface){
			return ((UmpleInterface)element).getExtendsInterface();
		}
		return null;
		
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.PARENT_CLASS)
	public static Object getParentClass(@GenerationBaseElement UmpleClass element){
		return element.getExtendsClass();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.DEFAULT_VALUE)
	public static String getDefaultValue(@GenerationBaseElement Attribute attribute, String language){
		String code = attribute.getCodeblock().getCode(language);
		if(code!= null){
			return code;
		}
		return attribute.getValue();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_STATIC)
	public static boolean isStatic(@GenerationBaseElement Attribute attribute){
		return attribute.isConstant(); 
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_STATIC)
	public static boolean isStatic(@GenerationBaseElement Method method){
		String modifier = method.getModifier();
		return modifier!= null && modifier.contains("static");  //$NON-NLS-1$
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_CONSTANT)
	public static boolean isConstant(@GenerationBaseElement Attribute attribute){
		return attribute.isConstant(); 
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_DERIVED)
	public static boolean isDerived(@GenerationBaseElement Attribute attribute){
		return attribute.isIsDerived(); 
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_ABSTRACT)
	public static boolean isAbstract(@GenerationBaseElement UmpleClass element){
		return element.getIsAbstract();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.ASSOCIATION_VARIABLES)
	public static List<?> getAssociationVariables(@GenerationBaseElement UmpleClass umpleClass){
		return umpleClass.getAssociationVariables();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.NAVIGABLE_ASSOCIATION_VARIABLES)
	public static List<?> getNavigableAssociationVariables(@GenerationBaseElement UmpleClass umpleClass){
		List<AssociationVariable> associationVariables= new ArrayList<AssociationVariable>();
		for(AssociationVariable associationVariable: umpleClass.getAssociationVariables()){
			if(associationVariable.isIsNavigable()){
				associationVariables.add(associationVariable);
			}
		}
		return associationVariables;
	}
	
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_LAZY)
	public static boolean isLazy(@GenerationBaseElement Attribute attribute){
		return attribute.isIsLazy();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.MODIFIER)
	public static String modifier(@GenerationBaseElement Attribute attribute){
		return attribute.getModifier();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.MODIFIER)
	public static String modifier(@GenerationBaseElement UmpleInterface umpleInterface){
		return umpleInterface.getModifier();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.MODIFIER)
	public static String modifier(@GenerationBaseElement UmpleClass umpleClass){
		return umpleClass.getModifier();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.EXTERNAL)
	public static boolean external(@GenerationBaseElement UmpleClass umpleClass){
		return IModelingElementDefinitions.EXTERNAL.equals(umpleClass.getModifier());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.EXTERNAL)
	public static boolean external(@GenerationBaseElement UmpleInterface umpleInterface){
		return IModelingElementDefinitions.EXTERNAL.equals(umpleInterface.getModifier());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.HAS_KEY_MEMBERS)
	public static boolean getKey(@GenerationBaseElement UmpleClass element){
		return element.getKey().getMembers().length>0;
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_KEY_MEMBER)
	public static boolean isKeyMemeber(@GenerationBaseElement UmpleClass element, Attribute attribute){
		return Arrays.asList(element.getKey().getMembers()).contains(attribute.getName());
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_IMMUTABLE)
	public static boolean isImmutable(@GenerationBaseElement Attribute attribute){
		return attribute.isImmutable();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_IMMUTABLE)
	public static boolean isImmutable(@GenerationBaseElement UmpleClass element){
		return element.isImmutable();
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_DEFAULTED)
	public static boolean isDefaulted(@GenerationBaseElement Attribute attribute){
		String modifier = attribute.getModifier();
		if(modifier== null|| modifier.isEmpty()){
			return false;
		}
		return Arrays.asList(modifier.split(CommonConstants.SPACE)).contains(IModelingElementDefinitions.DEFAULTED_MODIFIER);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_INTERNAL)
	public static boolean isInternal(@GenerationBaseElement Attribute attribute){
		String modifier = attribute.getModifier();
		if(modifier== null|| modifier.isEmpty()){
			return false;
		}
		return Arrays.asList(modifier.split(CommonConstants.SPACE)).contains(IModelingElementDefinitions.INTERNAL);
	}
	
	@GenerationValueAnnotation(fieldName= IModelingElementDefinitions.IS_AUTO_UNIQUE)
	public static boolean isAutoUnique(@GenerationBaseElement Attribute attribute){
		return attribute.isIsAutounique();
	}
	
} 