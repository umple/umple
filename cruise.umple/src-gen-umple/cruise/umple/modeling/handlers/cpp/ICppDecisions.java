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

public interface ICppDecisions {

	public static String ATTRIBUTE_IS_DIRECTED= "class.associations.attributes.isDirected"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OPTIONAL= "class.associations.attributes.isOptional"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_MANY= "class.associations.attributes.isMany"; //$NON-NLS-1$
	
	public static String ATTRIBUTE_IS_ONE= "class.associations.attributes.isOne"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_SETTABLE= "class.associations.attributes.isSettable"; //$NON-NLS-1$
	
	public static String ATTRIBUTE_IS_FIXED= "class.associations.attributes.isFixed"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_UNBOUND= "class.associations.attributes.isUnbound"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_RANGED_MANDATORY= "class.associations.attributes.isRangedMandatory"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_RANGED_UNBOUND= "class.associations.attributes.isRangedUnbound"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_RANGED_OPTIONAL= "class.associations.attributes.isRangedOptional"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_OPTIONAL= "class.associations.attributes.isOtherEndOptional"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_ONE= "class.associations.attributes.isOtherEndOne"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_RANGED_OPTIONAL= "class.associations.attributes.isOtherEndRangedOptional"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_RANGED_UNBOUND= "class.associations.attributes.isOtherEndRangedUnbound"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_UNBOUND= "class.associations.attributes.isOtherEndUnbound"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_BOUND_MANY= "class.associations.attributes.isOtherEndBoundMany"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_RANGED_MANDATORY= "class.associations.attributes.isOtherEndRangedMandatory"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_MANDATORY_UNBOUND= "class.associations.attributes.isOtherEndMandatoryUnbound"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_FIXED= "class.associations.attributes.isOtherEndFixed"; //$NON-NLS-1$
	public static String ATTRIBUTE_IS_OTHER_END_MANY= "class.associations.attributes.isOtherEndMany"; //$NON-NLS-1$
	
	public static String CAN_CONSTRUCT=	"class.associations.attributes.canConstruct";  //$NON-NLS-1$
	
	public static String HAS_MINIMUM_GETTER= "class.associations.attributes.hasMinimumFunction"; //$NON-NLS-1$
	public static String HAS_MAXIMUM_GETTER= "class.associations.attributes.hasMaximumFunction"; //$NON-NLS-1$
	public static String HAS_OTHER_MINIMUM_GETTER= "class.associations.attributes.other.hasMinimumFunction"; //$NON-NLS-1$
	public static String HAS_OTHER_MAXIMUM_GETTER= "class.associations.attributes.other.hasMaximumFunction"; //$NON-NLS-1$
	
}
