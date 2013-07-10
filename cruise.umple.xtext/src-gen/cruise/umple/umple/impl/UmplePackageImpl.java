/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmpleFactory;
import cruise.umple.umple.UmplePackage;

import java.io.IOException;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmplePackageImpl extends EPackageImpl implements UmplePackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected String packageFilename = "umple.ecore";

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass program_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_program_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass directive_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass glossary_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass word_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass strictness_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_strictness_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass generate_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass generate_path_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass useStatement_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namespace_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entity_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass comment_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inlineComment_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multilineComment_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass debug_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstract_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationClassDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classContent_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationClassContent_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceBody_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceMemberDeclaration_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantDeclaration_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_constantDeclaration_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_constantDeclaration_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moreCode_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_moreCode_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codeLangs_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_codeLangs_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codeLang_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodBody_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_methodBody_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_methodBody_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass concreteMethodDeclaration_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_concreteMethodDeclaration_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_concreteMethodDeclaration_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractMethodDeclaration_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodDeclarator_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterList_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_parameterList_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameter_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_parameter_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass association_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass symmetricReflexiveAssociation_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inlineAssociation_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inlineAssociationEnd_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleAssociationEnd_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationEnd_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicity_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isSorted_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attribute_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleAttribute_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass autouniqueAttribute_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass derivedAttribute_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_derivedAttribute_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_derivedAttribute_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_derivedAttribute_3_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complexAttribute_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_complexAttribute_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_complexAttribute_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass key_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_key_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass depend_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extraCode_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass softwarePattern_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isA_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleIsA_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_singleIsA_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multipleIsA_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_multipleIsA_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleton_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass immutable_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keyDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass codeInjection_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass beforeCode_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_beforeCode_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_beforeCode_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass afterCode_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_afterCode_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_afterCode_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateMachineDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateMachine_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inlineStateMachine_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_inlineStateMachine_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass referencedStateMachine_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass extendedStateMachine_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_extendedStateMachine_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enum_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_enum_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass state_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_state_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateInternal_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateEntity_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass autoTransition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass autoTransitionBlock_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventDefinition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_eventDefinition_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass afterEveryEvent_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass afterEvent_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass action_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_action_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_action_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entryOrExitAction_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_entryOrExitAction_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_entryOrExitAction_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activity_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_activity_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_activity_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moreGuards_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_moreGuards_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass guard_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_guard_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_guard_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceType_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_traceType_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_traceType_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trace_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceDirective_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_traceDirective_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceItem_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceEntity_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_traceEntity_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceOptions_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_traceOptions_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceOption_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preOrPostCondition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executeClause_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceWhen_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceFor_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceLevel_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tracePeriod_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceDuring_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceRecord_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordEntity_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_recordEntity_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceCondition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionRHS_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceCase_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceCaseDef_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceCaseActivation_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass traceCaseDeactivation_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass deActivateFor_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass precondition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postcondition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invariant_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_invariant_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_invariant_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintToken_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraint_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_constraint_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass negativeConstraint_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintBody_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_constraintBody_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkingOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_linkingOp_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_linkingOp_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_linkingOp_3_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintExpr_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_constraintExpr_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass compoundExpr_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass boolExpr_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringExpr_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLit_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass genExpr_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_genExpr_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_genExpr_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numExpr_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_numExpr_1_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_numExpr_2_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_numExpr_3_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anonymous_numExpr_4_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalityOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalsOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass notequalsOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ordinalOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass greaterOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass lessOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moreOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass smallerOp_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass position_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementPosition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationPosition_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass coordinate_EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass displayColor_EClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see cruise.umple.umple.UmplePackage#eNS_URI
   * @see #init()
   * @generated
   */
  private UmplePackageImpl()
  {
    super(eNS_URI, UmpleFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link UmplePackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @generated
   */
  public static UmplePackage init()
  {
    if (isInited) return (UmplePackage)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI);

    // Obtain or create and register package
    UmplePackageImpl theUmplePackage = (UmplePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UmplePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UmplePackageImpl());

    isInited = true;

    // Load packages
    theUmplePackage.loadPackage();

    // Fix loaded packages
    theUmplePackage.fixPackageContents();

    // Mark meta-data to indicate it can't be changed
    theUmplePackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(UmplePackage.eNS_URI, theUmplePackage);
    return theUmplePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    if (modelEClass == null)
    {
      modelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(0);
    }
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Model()
  {
        return (EReference)getModel().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProgram_()
  {
    if (program_EClass == null)
    {
      program_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(1);
    }
    return program_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getProgram__Anonymous_program_1_1()
  {
        return (EReference)getProgram_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_program_1_()
  {
    if (anonymous_program_1_EClass == null)
    {
      anonymous_program_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(2);
    }
    return anonymous_program_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_program_1__Comment_1()
  {
        return (EReference)getAnonymous_program_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_program_1__Directive_1()
  {
        return (EReference)getAnonymous_program_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDirective_()
  {
    if (directive_EClass == null)
    {
      directive_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(3);
    }
    return directive_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__Glossary_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__Generate_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__Generate_path_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__UseStatement_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__Namespace_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__TraceType_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__Entity_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__Debug_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDirective__Strictness_1()
  {
        return (EReference)getDirective_().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGlossary_()
  {
    if (glossary_EClass == null)
    {
      glossary_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(4);
    }
    return glossary_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGlossary__Word_1()
  {
        return (EReference)getGlossary_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWord_()
  {
    if (word_EClass == null)
    {
      word_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(5);
    }
    return word_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWord__Singular_1()
  {
        return (EAttribute)getWord_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getWord__Plural_1()
  {
        return (EAttribute)getWord_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStrictness_()
  {
    if (strictness_EClass == null)
    {
      strictness_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(6);
    }
    return strictness_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStrictness__Anonymous_strictness_1_1()
  {
        return (EReference)getStrictness_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_strictness_1_()
  {
    if (anonymous_strictness_1_EClass == null)
    {
      anonymous_strictness_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(7);
    }
    return anonymous_strictness_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_strictness_1__StrictnessLevel_1()
  {
        return (EAttribute)getAnonymous_strictness_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_strictness_1__Message_1()
  {
        return (EAttribute)getAnonymous_strictness_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_strictness_1__MessageNumber_1()
  {
        return (EAttribute)getAnonymous_strictness_1_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGenerate_()
  {
    if (generate_EClass == null)
    {
      generate_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(8);
    }
    return generate_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGenerate__Generate_1()
  {
        return (EAttribute)getGenerate_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGenerate_path_()
  {
    if (generate_path_EClass == null)
    {
      generate_path_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(9);
    }
    return generate_path_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGenerate_path__Language_1()
  {
        return (EAttribute)getGenerate_path_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGenerate_path__Output_1()
  {
        return (EAttribute)getGenerate_path_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGenerate_path__Override_1()
  {
        return (EAttribute)getGenerate_path_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUseStatement_()
  {
    if (useStatement_EClass == null)
    {
      useStatement_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(10);
    }
    return useStatement_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUseStatement__Use_1()
  {
        return (EAttribute)getUseStatement_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamespace_()
  {
    if (namespace_EClass == null)
    {
      namespace_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(11);
    }
    return namespace_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamespace__Namespace_1()
  {
        return (EAttribute)getNamespace_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntity_()
  {
    if (entity_EClass == null)
    {
      entity_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(12);
    }
    return entity_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity__ClassDefinition_1()
  {
        return (EReference)getEntity_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity__InterfaceDefinition_1()
  {
        return (EReference)getEntity_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity__ExternalDefinition_1()
  {
        return (EReference)getEntity_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity__AssociationDefinition_1()
  {
        return (EReference)getEntity_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity__AssociationClassDefinition_1()
  {
        return (EReference)getEntity_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntity__StateMachineDefinition_1()
  {
        return (EReference)getEntity_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComment_()
  {
    if (comment_EClass == null)
    {
      comment_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(13);
    }
    return comment_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComment__InlineComment_1()
  {
        return (EReference)getComment_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComment__MultilineComment_1()
  {
        return (EReference)getComment_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInlineComment_()
  {
    if (inlineComment_EClass == null)
    {
      inlineComment_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(14);
    }
    return inlineComment_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInlineComment__InlineComment_1()
  {
        return (EAttribute)getInlineComment_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultilineComment_()
  {
    if (multilineComment_EClass == null)
    {
      multilineComment_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(15);
    }
    return multilineComment_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultilineComment__MultilineComment_1()
  {
        return (EAttribute)getMultilineComment_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDebug_()
  {
    if (debug_EClass == null)
    {
      debug_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(16);
    }
    return debug_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDebug__Debug_1()
  {
        return (EAttribute)getDebug_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstract_()
  {
    if (abstract_EClass == null)
    {
      abstract_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(17);
    }
    return abstract_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstract__Abstract_1()
  {
        return (EAttribute)getAbstract_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassDefinition_()
  {
    if (classDefinition_EClass == null)
    {
      classDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(18);
    }
    return classDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassDefinition__Name_1()
  {
        return (EAttribute)getClassDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassDefinition__ClassContent_1()
  {
        return (EReference)getClassDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalDefinition_()
  {
    if (externalDefinition_EClass == null)
    {
      externalDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(19);
    }
    return externalDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalDefinition__Interface_1()
  {
        return (EAttribute)getExternalDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalDefinition__Name_1()
  {
        return (EAttribute)getExternalDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalDefinition__ClassContent_1()
  {
        return (EReference)getExternalDefinition_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterfaceDefinition_()
  {
    if (interfaceDefinition_EClass == null)
    {
      interfaceDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(20);
    }
    return interfaceDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInterfaceDefinition__Name_1()
  {
        return (EAttribute)getInterfaceDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceDefinition__Depend_1()
  {
        return (EReference)getInterfaceDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceDefinition__InterfaceBody_1()
  {
        return (EReference)getInterfaceDefinition_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationDefinition_()
  {
    if (associationDefinition_EClass == null)
    {
      associationDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(21);
    }
    return associationDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssociationDefinition__Name_1()
  {
        return (EAttribute)getAssociationDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationDefinition__Association_1()
  {
        return (EReference)getAssociationDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationClassDefinition_()
  {
    if (associationClassDefinition_EClass == null)
    {
      associationClassDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(22);
    }
    return associationClassDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssociationClassDefinition__Name_1()
  {
        return (EAttribute)getAssociationClassDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassDefinition__AssociationClassContent_1()
  {
        return (EReference)getAssociationClassDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassContent_()
  {
    if (classContent_EClass == null)
    {
      classContent_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(23);
    }
    return classContent_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__Comment_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__ClassDefinition_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__Trace_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__Position_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__DisplayColor_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__Abstract_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__Invariant_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__SoftwarePattern_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__Depend_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__SymmetricReflexiveAssociation_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__Attribute_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__StateMachine_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__InlineAssociation_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__ConcreteMethodDeclaration_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__ConstantDeclaration_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassContent__ExtraCode_1()
  {
        return (EReference)getClassContent_().getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationClassContent_()
  {
    if (associationClassContent_EClass == null)
    {
      associationClassContent_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(24);
    }
    return associationClassContent_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__Comment_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__ClassDefinition_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__Position_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__DisplayColor_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__Invariant_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__SoftwarePattern_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__Depend_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__SingleAssociationEnd_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__StateMachine_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__Attribute_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__Association_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__InlineAssociation_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationClassContent__ExtraCode_1()
  {
        return (EReference)getAssociationClassContent_().getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterfaceBody_()
  {
    if (interfaceBody_EClass == null)
    {
      interfaceBody_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(25);
    }
    return interfaceBody_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceBody__InterfaceMemberDeclaration_1()
  {
        return (EReference)getInterfaceBody_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterfaceMemberDeclaration_()
  {
    if (interfaceMemberDeclaration_EClass == null)
    {
      interfaceMemberDeclaration_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(26);
    }
    return interfaceMemberDeclaration_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceMemberDeclaration__ConstantDeclaration_1()
  {
        return (EReference)getInterfaceMemberDeclaration_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceMemberDeclaration__AbstractMethodDeclaration_1()
  {
        return (EReference)getInterfaceMemberDeclaration_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceMemberDeclaration__Position_1()
  {
        return (EReference)getInterfaceMemberDeclaration_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceMemberDeclaration__DisplayColor_1()
  {
        return (EReference)getInterfaceMemberDeclaration_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceMemberDeclaration__IsA_1()
  {
        return (EReference)getInterfaceMemberDeclaration_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInterfaceMemberDeclaration__ExtraCode_1()
  {
        return (EReference)getInterfaceMemberDeclaration_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantDeclaration_()
  {
    if (constantDeclaration_EClass == null)
    {
      constantDeclaration_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(27);
    }
    return constantDeclaration_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDeclaration__Anonymous_constantDeclaration_1_1()
  {
        return (EReference)getConstantDeclaration_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDeclaration__Anonymous_constantDeclaration_2_1()
  {
        return (EReference)getConstantDeclaration_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_constantDeclaration_1_()
  {
    if (anonymous_constantDeclaration_1_EClass == null)
    {
      anonymous_constantDeclaration_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(28);
    }
    return anonymous_constantDeclaration_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_constantDeclaration_1__List_1()
  {
        return (EAttribute)getAnonymous_constantDeclaration_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_constantDeclaration_1__Name_1()
  {
        return (EAttribute)getAnonymous_constantDeclaration_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_constantDeclaration_1__Type_1()
  {
        return (EAttribute)getAnonymous_constantDeclaration_1_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_constantDeclaration_2_()
  {
    if (anonymous_constantDeclaration_2_EClass == null)
    {
      anonymous_constantDeclaration_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(29);
    }
    return anonymous_constantDeclaration_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_constantDeclaration_2__Value_1()
  {
        return (EAttribute)getAnonymous_constantDeclaration_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMoreCode_()
  {
    if (moreCode_EClass == null)
    {
      moreCode_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(30);
    }
    return moreCode_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMoreCode__Anonymous_moreCode_1_1()
  {
        return (EReference)getMoreCode_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMoreCode__Code_1()
  {
        return (EAttribute)getMoreCode_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_moreCode_1_()
  {
    if (anonymous_moreCode_1_EClass == null)
    {
      anonymous_moreCode_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(31);
    }
    return anonymous_moreCode_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_moreCode_1__CodeLang_1()
  {
        return (EReference)getAnonymous_moreCode_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_moreCode_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_moreCode_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCodeLangs_()
  {
    if (codeLangs_EClass == null)
    {
      codeLangs_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(32);
    }
    return codeLangs_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCodeLangs__Anonymous_codeLangs_1_1()
  {
        return (EReference)getCodeLangs_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_codeLangs_1_()
  {
    if (anonymous_codeLangs_1_EClass == null)
    {
      anonymous_codeLangs_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(33);
    }
    return anonymous_codeLangs_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_codeLangs_1__CodeLang_1()
  {
        return (EReference)getAnonymous_codeLangs_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCodeLang_()
  {
    if (codeLang_EClass == null)
    {
      codeLang_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(34);
    }
    return codeLang_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCodeLang__CodeLang_1()
  {
        return (EAttribute)getCodeLang_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodBody_()
  {
    if (methodBody_EClass == null)
    {
      methodBody_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(35);
    }
    return methodBody_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodBody__Anonymous_methodBody_1_1()
  {
        return (EReference)getMethodBody_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMethodBody__Code_1()
  {
        return (EAttribute)getMethodBody_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodBody__Anonymous_methodBody_2_1()
  {
        return (EReference)getMethodBody_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_methodBody_1_()
  {
    if (anonymous_methodBody_1_EClass == null)
    {
      anonymous_methodBody_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(36);
    }
    return anonymous_methodBody_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_methodBody_1__Precondition_1()
  {
        return (EReference)getAnonymous_methodBody_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_methodBody_2_()
  {
    if (anonymous_methodBody_2_EClass == null)
    {
      anonymous_methodBody_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(37);
    }
    return anonymous_methodBody_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_methodBody_2__Postcondition_1()
  {
        return (EReference)getAnonymous_methodBody_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConcreteMethodDeclaration_()
  {
    if (concreteMethodDeclaration_EClass == null)
    {
      concreteMethodDeclaration_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(38);
    }
    return concreteMethodDeclaration_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConcreteMethodDeclaration__Type_1()
  {
        return (EAttribute)getConcreteMethodDeclaration_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcreteMethodDeclaration__MethodDeclarator_1()
  {
        return (EReference)getConcreteMethodDeclaration_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcreteMethodDeclaration__Anonymous_concreteMethodDeclaration_1_1()
  {
        return (EReference)getConcreteMethodDeclaration_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcreteMethodDeclaration__MethodBody_1()
  {
        return (EReference)getConcreteMethodDeclaration_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConcreteMethodDeclaration__Anonymous_concreteMethodDeclaration_2_1()
  {
        return (EReference)getConcreteMethodDeclaration_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_concreteMethodDeclaration_1_()
  {
    if (anonymous_concreteMethodDeclaration_1_EClass == null)
    {
      anonymous_concreteMethodDeclaration_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(39);
    }
    return anonymous_concreteMethodDeclaration_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_concreteMethodDeclaration_1__CodeLang_1()
  {
        return (EReference)getAnonymous_concreteMethodDeclaration_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_concreteMethodDeclaration_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_concreteMethodDeclaration_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_concreteMethodDeclaration_2_()
  {
    if (anonymous_concreteMethodDeclaration_2_EClass == null)
    {
      anonymous_concreteMethodDeclaration_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(40);
    }
    return anonymous_concreteMethodDeclaration_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_concreteMethodDeclaration_2__MoreCode_1()
  {
        return (EReference)getAnonymous_concreteMethodDeclaration_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractMethodDeclaration_()
  {
    if (abstractMethodDeclaration_EClass == null)
    {
      abstractMethodDeclaration_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(41);
    }
    return abstractMethodDeclaration_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAbstractMethodDeclaration__Type_1()
  {
        return (EAttribute)getAbstractMethodDeclaration_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractMethodDeclaration__MethodDeclarator_1()
  {
        return (EReference)getAbstractMethodDeclaration_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodDeclarator_()
  {
    if (methodDeclarator_EClass == null)
    {
      methodDeclarator_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(42);
    }
    return methodDeclarator_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMethodDeclarator__MethodName_1()
  {
        return (EAttribute)getMethodDeclarator_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodDeclarator__ParameterList_1()
  {
        return (EReference)getMethodDeclarator_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterList_()
  {
    if (parameterList_EClass == null)
    {
      parameterList_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(43);
    }
    return parameterList_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterList__Parameter_1()
  {
        return (EReference)getParameterList_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterList__Anonymous_parameterList_1_1()
  {
        return (EReference)getParameterList_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_parameterList_1_()
  {
    if (anonymous_parameterList_1_EClass == null)
    {
      anonymous_parameterList_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(44);
    }
    return anonymous_parameterList_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_parameterList_1__Parameter_1()
  {
        return (EReference)getAnonymous_parameterList_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameter_()
  {
    if (parameter_EClass == null)
    {
      parameter_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(45);
    }
    return parameter_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameter__Anonymous_parameter_1_1()
  {
        return (EReference)getParameter_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_parameter_1_()
  {
    if (anonymous_parameter_1_EClass == null)
    {
      anonymous_parameter_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(46);
    }
    return anonymous_parameter_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_parameter_1__List_1()
  {
        return (EAttribute)getAnonymous_parameter_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_parameter_1__Name_1()
  {
        return (EAttribute)getAnonymous_parameter_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_parameter_1__Type_1()
  {
        return (EAttribute)getAnonymous_parameter_1_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociation_()
  {
    if (association_EClass == null)
    {
      association_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(47);
    }
    return association_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssociation__Modifier_1()
  {
        return (EAttribute)getAssociation_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociation__AssociationEnd_1()
  {
        return (EReference)getAssociation_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssociation__Arrow_1()
  {
        return (EAttribute)getAssociation_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociation__AssociationEnd_2()
  {
        return (EReference)getAssociation_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSymmetricReflexiveAssociation_()
  {
    if (symmetricReflexiveAssociation_EClass == null)
    {
      symmetricReflexiveAssociation_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(48);
    }
    return symmetricReflexiveAssociation_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSymmetricReflexiveAssociation__Multiplicity_1()
  {
        return (EReference)getSymmetricReflexiveAssociation_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSymmetricReflexiveAssociation__RoleName_1()
  {
        return (EAttribute)getSymmetricReflexiveAssociation_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInlineAssociation_()
  {
    if (inlineAssociation_EClass == null)
    {
      inlineAssociation_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(49);
    }
    return inlineAssociation_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInlineAssociation__Modifier_1()
  {
        return (EAttribute)getInlineAssociation_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInlineAssociation__InlineAssociationEnd_1()
  {
        return (EReference)getInlineAssociation_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInlineAssociation__Arrow_1()
  {
        return (EAttribute)getInlineAssociation_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInlineAssociation__AssociationEnd_1()
  {
        return (EReference)getInlineAssociation_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInlineAssociationEnd_()
  {
    if (inlineAssociationEnd_EClass == null)
    {
      inlineAssociationEnd_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(50);
    }
    return inlineAssociationEnd_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInlineAssociationEnd__Multiplicity_1()
  {
        return (EReference)getInlineAssociationEnd_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInlineAssociationEnd__IsSorted_1()
  {
        return (EReference)getInlineAssociationEnd_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInlineAssociationEnd__RoleName_1()
  {
        return (EAttribute)getInlineAssociationEnd_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleAssociationEnd_()
  {
    if (singleAssociationEnd_EClass == null)
    {
      singleAssociationEnd_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(51);
    }
    return singleAssociationEnd_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleAssociationEnd__Multiplicity_1()
  {
        return (EReference)getSingleAssociationEnd_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleAssociationEnd__Type_1()
  {
        return (EAttribute)getSingleAssociationEnd_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleAssociationEnd__RoleName_1()
  {
        return (EAttribute)getSingleAssociationEnd_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationEnd_()
  {
    if (associationEnd_EClass == null)
    {
      associationEnd_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(52);
    }
    return associationEnd_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationEnd__Multiplicity_1()
  {
        return (EReference)getAssociationEnd_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssociationEnd__Type_1()
  {
        return (EAttribute)getAssociationEnd_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssociationEnd__RoleName_1()
  {
        return (EAttribute)getAssociationEnd_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationEnd__IsSorted_1()
  {
        return (EReference)getAssociationEnd_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicity_()
  {
    if (multiplicity_EClass == null)
    {
      multiplicity_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(53);
    }
    return multiplicity_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity__Bound_1()
  {
        return (EAttribute)getMultiplicity_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity__LowerBound_1()
  {
        return (EAttribute)getMultiplicity_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity__UpperBound_1()
  {
        return (EAttribute)getMultiplicity_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicity__Bound_int()
  {
        return (EAttribute)getMultiplicity_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsSorted_()
  {
    if (isSorted_EClass == null)
    {
      isSorted_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(54);
    }
    return isSorted_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIsSorted__Priority_1()
  {
        return (EAttribute)getIsSorted_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute_()
  {
    if (attribute_EClass == null)
    {
      attribute_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(55);
    }
    return attribute_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute__SimpleAttribute_1()
  {
        return (EReference)getAttribute_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute__AutouniqueAttribute_1()
  {
        return (EReference)getAttribute_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute__DerivedAttribute_1()
  {
        return (EReference)getAttribute_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute__ComplexAttribute_1()
  {
        return (EReference)getAttribute_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleAttribute_()
  {
    if (simpleAttribute_EClass == null)
    {
      simpleAttribute_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(56);
    }
    return simpleAttribute_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSimpleAttribute__Name_1()
  {
        return (EAttribute)getSimpleAttribute_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAutouniqueAttribute_()
  {
    if (autouniqueAttribute_EClass == null)
    {
      autouniqueAttribute_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(57);
    }
    return autouniqueAttribute_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAutouniqueAttribute__Autounique_1()
  {
        return (EAttribute)getAutouniqueAttribute_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAutouniqueAttribute__Name_1()
  {
        return (EAttribute)getAutouniqueAttribute_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDerivedAttribute_()
  {
    if (derivedAttribute_EClass == null)
    {
      derivedAttribute_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(58);
    }
    return derivedAttribute_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDerivedAttribute__Modifier_1()
  {
        return (EAttribute)getDerivedAttribute_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDerivedAttribute__Anonymous_derivedAttribute_1_1()
  {
        return (EReference)getDerivedAttribute_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDerivedAttribute__Anonymous_derivedAttribute_2_1()
  {
        return (EReference)getDerivedAttribute_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDerivedAttribute__Code_1()
  {
        return (EAttribute)getDerivedAttribute_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDerivedAttribute__Anonymous_derivedAttribute_3_1()
  {
        return (EReference)getDerivedAttribute_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_derivedAttribute_1_()
  {
    if (anonymous_derivedAttribute_1_EClass == null)
    {
      anonymous_derivedAttribute_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(59);
    }
    return anonymous_derivedAttribute_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_derivedAttribute_1__List_1()
  {
        return (EAttribute)getAnonymous_derivedAttribute_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_derivedAttribute_1__Name_1()
  {
        return (EAttribute)getAnonymous_derivedAttribute_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_derivedAttribute_1__Type_1()
  {
        return (EAttribute)getAnonymous_derivedAttribute_1_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_derivedAttribute_2_()
  {
    if (anonymous_derivedAttribute_2_EClass == null)
    {
      anonymous_derivedAttribute_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(60);
    }
    return anonymous_derivedAttribute_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_derivedAttribute_2__CodeLang_1()
  {
        return (EReference)getAnonymous_derivedAttribute_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_derivedAttribute_2__CodeLangs_1()
  {
        return (EReference)getAnonymous_derivedAttribute_2_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_derivedAttribute_3_()
  {
    if (anonymous_derivedAttribute_3_EClass == null)
    {
      anonymous_derivedAttribute_3_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(61);
    }
    return anonymous_derivedAttribute_3_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_derivedAttribute_3__MoreCode_1()
  {
        return (EReference)getAnonymous_derivedAttribute_3_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplexAttribute_()
  {
    if (complexAttribute_EClass == null)
    {
      complexAttribute_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(62);
    }
    return complexAttribute_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplexAttribute__Unique_1()
  {
        return (EAttribute)getComplexAttribute_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplexAttribute__Lazy_1()
  {
        return (EAttribute)getComplexAttribute_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComplexAttribute__Modifier_1()
  {
        return (EAttribute)getComplexAttribute_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComplexAttribute__Anonymous_complexAttribute_1_1()
  {
        return (EReference)getComplexAttribute_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComplexAttribute__Anonymous_complexAttribute_2_1()
  {
        return (EReference)getComplexAttribute_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_complexAttribute_1_()
  {
    if (anonymous_complexAttribute_1_EClass == null)
    {
      anonymous_complexAttribute_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(63);
    }
    return anonymous_complexAttribute_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_complexAttribute_1__List_1()
  {
        return (EAttribute)getAnonymous_complexAttribute_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_complexAttribute_1__Name_1()
  {
        return (EAttribute)getAnonymous_complexAttribute_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_complexAttribute_1__Type_1()
  {
        return (EAttribute)getAnonymous_complexAttribute_1_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_complexAttribute_2_()
  {
    if (anonymous_complexAttribute_2_EClass == null)
    {
      anonymous_complexAttribute_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(64);
    }
    return anonymous_complexAttribute_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_complexAttribute_2__Value_1()
  {
        return (EAttribute)getAnonymous_complexAttribute_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKey_()
  {
    if (key_EClass == null)
    {
      key_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(65);
    }
    return key_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKey__KeyId_1()
  {
        return (EAttribute)getKey_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getKey__Anonymous_key_1_1()
  {
        return (EReference)getKey_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_key_1_()
  {
    if (anonymous_key_1_EClass == null)
    {
      anonymous_key_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(66);
    }
    return anonymous_key_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_key_1__KeyId_1()
  {
        return (EAttribute)getAnonymous_key_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDepend_()
  {
    if (depend_EClass == null)
    {
      depend_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(67);
    }
    return depend_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDepend__Depend_1()
  {
        return (EAttribute)getDepend_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtraCode_()
  {
    if (extraCode_EClass == null)
    {
      extraCode_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(68);
    }
    return extraCode_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExtraCode__ExtraCode_1()
  {
        return (EAttribute)getExtraCode_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSoftwarePattern_()
  {
    if (softwarePattern_EClass == null)
    {
      softwarePattern_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(69);
    }
    return softwarePattern_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSoftwarePattern__IsA_1()
  {
        return (EReference)getSoftwarePattern_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSoftwarePattern__Singleton_1()
  {
        return (EReference)getSoftwarePattern_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSoftwarePattern__Immutable_1()
  {
        return (EReference)getSoftwarePattern_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSoftwarePattern__KeyDefinition_1()
  {
        return (EReference)getSoftwarePattern_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSoftwarePattern__CodeInjection_1()
  {
        return (EReference)getSoftwarePattern_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsA_()
  {
    if (isA_EClass == null)
    {
      isA_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(70);
    }
    return isA_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIsA__SingleIsA_1()
  {
        return (EReference)getIsA_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIsA__MultipleIsA_1()
  {
        return (EReference)getIsA_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleIsA_()
  {
    if (singleIsA_EClass == null)
    {
      singleIsA_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(71);
    }
    return singleIsA_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleIsA__ExtendsName_1()
  {
        return (EAttribute)getSingleIsA_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSingleIsA__Anonymous_singleIsA_1_1()
  {
        return (EReference)getSingleIsA_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_singleIsA_1_()
  {
    if (anonymous_singleIsA_1_EClass == null)
    {
      anonymous_singleIsA_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(72);
    }
    return anonymous_singleIsA_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_singleIsA_1__ExtendsName_1()
  {
        return (EAttribute)getAnonymous_singleIsA_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultipleIsA_()
  {
    if (multipleIsA_EClass == null)
    {
      multipleIsA_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(73);
    }
    return multipleIsA_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultipleIsA__ExtendsName_1()
  {
        return (EAttribute)getMultipleIsA_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultipleIsA__Anonymous_multipleIsA_1_1()
  {
        return (EReference)getMultipleIsA_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_multipleIsA_1_()
  {
    if (anonymous_multipleIsA_1_EClass == null)
    {
      anonymous_multipleIsA_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(74);
    }
    return anonymous_multipleIsA_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_multipleIsA_1__ExtendsName_1()
  {
        return (EAttribute)getAnonymous_multipleIsA_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleton_()
  {
    if (singleton_EClass == null)
    {
      singleton_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(75);
    }
    return singleton_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSingleton__Singleton_1()
  {
        return (EAttribute)getSingleton_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImmutable_()
  {
    if (immutable_EClass == null)
    {
      immutable_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(76);
    }
    return immutable_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImmutable__Immutable_1()
  {
        return (EAttribute)getImmutable_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeyDefinition_()
  {
    if (keyDefinition_EClass == null)
    {
      keyDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(77);
    }
    return keyDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyDefinition__DefaultKey_1()
  {
        return (EAttribute)getKeyDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getKeyDefinition__Key_1()
  {
        return (EReference)getKeyDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCodeInjection_()
  {
    if (codeInjection_EClass == null)
    {
      codeInjection_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(78);
    }
    return codeInjection_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCodeInjection__BeforeCode_1()
  {
        return (EReference)getCodeInjection_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCodeInjection__AfterCode_1()
  {
        return (EReference)getCodeInjection_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBeforeCode_()
  {
    if (beforeCode_EClass == null)
    {
      beforeCode_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(79);
    }
    return beforeCode_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBeforeCode__OperationName_1()
  {
        return (EAttribute)getBeforeCode_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBeforeCode__Anonymous_beforeCode_1_1()
  {
        return (EReference)getBeforeCode_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBeforeCode__Code_1()
  {
        return (EAttribute)getBeforeCode_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBeforeCode__Anonymous_beforeCode_2_1()
  {
        return (EReference)getBeforeCode_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_beforeCode_1_()
  {
    if (anonymous_beforeCode_1_EClass == null)
    {
      anonymous_beforeCode_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(80);
    }
    return anonymous_beforeCode_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_beforeCode_1__CodeLang_1()
  {
        return (EReference)getAnonymous_beforeCode_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_beforeCode_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_beforeCode_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_beforeCode_2_()
  {
    if (anonymous_beforeCode_2_EClass == null)
    {
      anonymous_beforeCode_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(81);
    }
    return anonymous_beforeCode_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_beforeCode_2__MoreCode_1()
  {
        return (EReference)getAnonymous_beforeCode_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAfterCode_()
  {
    if (afterCode_EClass == null)
    {
      afterCode_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(82);
    }
    return afterCode_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAfterCode__OperationName_1()
  {
        return (EAttribute)getAfterCode_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAfterCode__Anonymous_afterCode_1_1()
  {
        return (EReference)getAfterCode_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAfterCode__Code_1()
  {
        return (EAttribute)getAfterCode_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAfterCode__Anonymous_afterCode_2_1()
  {
        return (EReference)getAfterCode_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_afterCode_1_()
  {
    if (anonymous_afterCode_1_EClass == null)
    {
      anonymous_afterCode_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(83);
    }
    return anonymous_afterCode_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_afterCode_1__CodeLang_1()
  {
        return (EReference)getAnonymous_afterCode_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_afterCode_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_afterCode_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_afterCode_2_()
  {
    if (anonymous_afterCode_2_EClass == null)
    {
      anonymous_afterCode_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(84);
    }
    return anonymous_afterCode_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_afterCode_2__MoreCode_1()
  {
        return (EReference)getAnonymous_afterCode_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateMachineDefinition_()
  {
    if (stateMachineDefinition_EClass == null)
    {
      stateMachineDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(85);
    }
    return stateMachineDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateMachineDefinition__Queued_1()
  {
        return (EAttribute)getStateMachineDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateMachineDefinition__Name_1()
  {
        return (EAttribute)getStateMachineDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateMachineDefinition__State_1()
  {
        return (EReference)getStateMachineDefinition_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateMachine_()
  {
    if (stateMachine_EClass == null)
    {
      stateMachine_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(86);
    }
    return stateMachine_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateMachine__Enum_1()
  {
        return (EReference)getStateMachine_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateMachine__InlineStateMachine_1()
  {
        return (EReference)getStateMachine_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateMachine__ReferencedStateMachine_1()
  {
        return (EReference)getStateMachine_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateMachine__ActiveDefinition_1()
  {
        return (EReference)getStateMachine_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveDefinition_()
  {
    if (activeDefinition_EClass == null)
    {
      activeDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(87);
    }
    return activeDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActiveDefinition__Active_1()
  {
        return (EAttribute)getActiveDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActiveDefinition__Name_1()
  {
        return (EAttribute)getActiveDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActiveDefinition__Code_1()
  {
        return (EAttribute)getActiveDefinition_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInlineStateMachine_()
  {
    if (inlineStateMachine_EClass == null)
    {
      inlineStateMachine_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(88);
    }
    return inlineStateMachine_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInlineStateMachine__Queued_1()
  {
        return (EAttribute)getInlineStateMachine_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInlineStateMachine__Name_1()
  {
        return (EAttribute)getInlineStateMachine_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInlineStateMachine__Anonymous_inlineStateMachine_1_1()
  {
        return (EReference)getInlineStateMachine_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_inlineStateMachine_1_()
  {
    if (anonymous_inlineStateMachine_1_EClass == null)
    {
      anonymous_inlineStateMachine_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(89);
    }
    return anonymous_inlineStateMachine_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_inlineStateMachine_1__Comment_1()
  {
        return (EReference)getAnonymous_inlineStateMachine_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_inlineStateMachine_1__State_1()
  {
        return (EReference)getAnonymous_inlineStateMachine_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_inlineStateMachine_1__Trace_1()
  {
        return (EReference)getAnonymous_inlineStateMachine_1_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReferencedStateMachine_()
  {
    if (referencedStateMachine_EClass == null)
    {
      referencedStateMachine_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(90);
    }
    return referencedStateMachine_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReferencedStateMachine__Name_1()
  {
        return (EAttribute)getReferencedStateMachine_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReferencedStateMachine__DefinitionName_1()
  {
        return (EAttribute)getReferencedStateMachine_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReferencedStateMachine__ExtendedStateMachine_1()
  {
        return (EReference)getReferencedStateMachine_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExtendedStateMachine_()
  {
    if (extendedStateMachine_EClass == null)
    {
      extendedStateMachine_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(91);
    }
    return extendedStateMachine_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExtendedStateMachine__Anonymous_extendedStateMachine_1_1()
  {
        return (EReference)getExtendedStateMachine_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_extendedStateMachine_1_()
  {
    if (anonymous_extendedStateMachine_1_EClass == null)
    {
      anonymous_extendedStateMachine_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(92);
    }
    return anonymous_extendedStateMachine_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_extendedStateMachine_1__Comment_1()
  {
        return (EReference)getAnonymous_extendedStateMachine_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_extendedStateMachine_1__ChangeType_1()
  {
        return (EAttribute)getAnonymous_extendedStateMachine_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_extendedStateMachine_1__State_1()
  {
        return (EReference)getAnonymous_extendedStateMachine_1_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnum_()
  {
    if (enum_EClass == null)
    {
      enum_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(93);
    }
    return enum_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnum__Name_1()
  {
        return (EAttribute)getEnum_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnum__StateName_1()
  {
        return (EAttribute)getEnum_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnum__Anonymous_enum_1_1()
  {
        return (EReference)getEnum_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_enum_1_()
  {
    if (anonymous_enum_1_EClass == null)
    {
      anonymous_enum_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(94);
    }
    return anonymous_enum_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_enum_1__StateName_1()
  {
        return (EAttribute)getAnonymous_enum_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getState_()
  {
    if (state_EClass == null)
    {
      state_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(95);
    }
    return state_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState__StateName_1()
  {
        return (EAttribute)getState_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState__StateInternal_1()
  {
        return (EReference)getState_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState__Final_1()
  {
        return (EAttribute)getState_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState__Anonymous_state_1_1()
  {
        return (EReference)getState_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_state_1_()
  {
    if (anonymous_state_1_EClass == null)
    {
      anonymous_state_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(96);
    }
    return anonymous_state_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_state_1__StateInternal_1()
  {
        return (EReference)getAnonymous_state_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateInternal_()
  {
    if (stateInternal_EClass == null)
    {
      stateInternal_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(97);
    }
    return stateInternal_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateInternal__Comment_1()
  {
        return (EReference)getStateInternal_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStateInternal__ChangeType_1()
  {
        return (EAttribute)getStateInternal_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateInternal__StateEntity_1()
  {
        return (EReference)getStateInternal_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateEntity_()
  {
    if (stateEntity_EClass == null)
    {
      stateEntity_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(98);
    }
    return stateEntity_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateEntity__EntryOrExitAction_1()
  {
        return (EReference)getStateEntity_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateEntity__AutoTransition_1()
  {
        return (EReference)getStateEntity_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateEntity__Transition_1()
  {
        return (EReference)getStateEntity_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateEntity__Activity_1()
  {
        return (EReference)getStateEntity_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateEntity__State_1()
  {
        return (EReference)getStateEntity_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateEntity__Trace_1()
  {
        return (EReference)getStateEntity_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAutoTransition_()
  {
    if (autoTransition_EClass == null)
    {
      autoTransition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(99);
    }
    return autoTransition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAutoTransition__AutoTransitionBlock_1()
  {
        return (EReference)getAutoTransition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAutoTransition__Activity_1()
  {
        return (EReference)getAutoTransition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAutoTransitionBlock_()
  {
    if (autoTransitionBlock_EClass == null)
    {
      autoTransitionBlock_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(100);
    }
    return autoTransitionBlock_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAutoTransitionBlock__Guard_1()
  {
        return (EReference)getAutoTransitionBlock_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAutoTransitionBlock__Action_1()
  {
        return (EReference)getAutoTransitionBlock_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAutoTransitionBlock__StateName_1()
  {
        return (EAttribute)getAutoTransitionBlock_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransition_()
  {
    if (transition_EClass == null)
    {
      transition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(101);
    }
    return transition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition__Guard_1()
  {
        return (EReference)getTransition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition__EventDefinition_1()
  {
        return (EReference)getTransition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition__Action_1()
  {
        return (EReference)getTransition_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransition__StateName_1()
  {
        return (EAttribute)getTransition_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventDefinition_()
  {
    if (eventDefinition_EClass == null)
    {
      eventDefinition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(102);
    }
    return eventDefinition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDefinition__AfterEveryEvent_1()
  {
        return (EReference)getEventDefinition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDefinition__AfterEvent_1()
  {
        return (EReference)getEventDefinition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventDefinition__Event_1()
  {
        return (EAttribute)getEventDefinition_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDefinition__Anonymous_eventDefinition_1_1()
  {
        return (EReference)getEventDefinition_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_eventDefinition_1_()
  {
    if (anonymous_eventDefinition_1_EClass == null)
    {
      anonymous_eventDefinition_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(103);
    }
    return anonymous_eventDefinition_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_eventDefinition_1__ParameterList_1()
  {
        return (EReference)getAnonymous_eventDefinition_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAfterEveryEvent_()
  {
    if (afterEveryEvent_EClass == null)
    {
      afterEveryEvent_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(104);
    }
    return afterEveryEvent_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAfterEveryEvent__Timer_1()
  {
        return (EAttribute)getAfterEveryEvent_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAfterEvent_()
  {
    if (afterEvent_EClass == null)
    {
      afterEvent_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(105);
    }
    return afterEvent_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAfterEvent__Timer_1()
  {
        return (EAttribute)getAfterEvent_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAction_()
  {
    if (action_EClass == null)
    {
      action_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(106);
    }
    return action_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAction__Anonymous_action_1_1()
  {
        return (EReference)getAction_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAction__Code_1()
  {
        return (EAttribute)getAction_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAction__Anonymous_action_2_1()
  {
        return (EReference)getAction_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_action_1_()
  {
    if (anonymous_action_1_EClass == null)
    {
      anonymous_action_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(107);
    }
    return anonymous_action_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_action_1__CodeLang_1()
  {
        return (EReference)getAnonymous_action_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_action_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_action_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_action_2_()
  {
    if (anonymous_action_2_EClass == null)
    {
      anonymous_action_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(108);
    }
    return anonymous_action_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_action_2__MoreCode_1()
  {
        return (EReference)getAnonymous_action_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntryOrExitAction_()
  {
    if (entryOrExitAction_EClass == null)
    {
      entryOrExitAction_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(109);
    }
    return entryOrExitAction_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEntryOrExitAction__Type_1()
  {
        return (EAttribute)getEntryOrExitAction_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntryOrExitAction__Anonymous_entryOrExitAction_1_1()
  {
        return (EReference)getEntryOrExitAction_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEntryOrExitAction__Code_1()
  {
        return (EAttribute)getEntryOrExitAction_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntryOrExitAction__Anonymous_entryOrExitAction_2_1()
  {
        return (EReference)getEntryOrExitAction_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_entryOrExitAction_1_()
  {
    if (anonymous_entryOrExitAction_1_EClass == null)
    {
      anonymous_entryOrExitAction_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(110);
    }
    return anonymous_entryOrExitAction_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_entryOrExitAction_1__CodeLang_1()
  {
        return (EReference)getAnonymous_entryOrExitAction_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_entryOrExitAction_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_entryOrExitAction_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_entryOrExitAction_2_()
  {
    if (anonymous_entryOrExitAction_2_EClass == null)
    {
      anonymous_entryOrExitAction_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(111);
    }
    return anonymous_entryOrExitAction_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_entryOrExitAction_2__MoreCode_1()
  {
        return (EReference)getAnonymous_entryOrExitAction_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActivity_()
  {
    if (activity_EClass == null)
    {
      activity_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(112);
    }
    return activity_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivity__Anonymous_activity_1_1()
  {
        return (EReference)getActivity_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getActivity__Code_1()
  {
        return (EAttribute)getActivity_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActivity__Anonymous_activity_2_1()
  {
        return (EReference)getActivity_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_activity_1_()
  {
    if (anonymous_activity_1_EClass == null)
    {
      anonymous_activity_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(113);
    }
    return anonymous_activity_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_activity_1__CodeLang_1()
  {
        return (EReference)getAnonymous_activity_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_activity_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_activity_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_activity_2_()
  {
    if (anonymous_activity_2_EClass == null)
    {
      anonymous_activity_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(114);
    }
    return anonymous_activity_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_activity_2__MoreCode_1()
  {
        return (EReference)getAnonymous_activity_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMoreGuards_()
  {
    if (moreGuards_EClass == null)
    {
      moreGuards_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(115);
    }
    return moreGuards_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMoreGuards__Anonymous_moreGuards_1_1()
  {
        return (EReference)getMoreGuards_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMoreGuards__Code_1()
  {
        return (EAttribute)getMoreGuards_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_moreGuards_1_()
  {
    if (anonymous_moreGuards_1_EClass == null)
    {
      anonymous_moreGuards_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(116);
    }
    return anonymous_moreGuards_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_moreGuards_1__CodeLang_1()
  {
        return (EReference)getAnonymous_moreGuards_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_moreGuards_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_moreGuards_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGuard_()
  {
    if (guard_EClass == null)
    {
      guard_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(117);
    }
    return guard_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuard__Anonymous_guard_1_1()
  {
        return (EReference)getGuard_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGuard__Code_1()
  {
        return (EAttribute)getGuard_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGuard__Anonymous_guard_2_1()
  {
        return (EReference)getGuard_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_guard_1_()
  {
    if (anonymous_guard_1_EClass == null)
    {
      anonymous_guard_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(118);
    }
    return anonymous_guard_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_guard_1__CodeLang_1()
  {
        return (EReference)getAnonymous_guard_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_guard_1__CodeLangs_1()
  {
        return (EReference)getAnonymous_guard_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_guard_2_()
  {
    if (anonymous_guard_2_EClass == null)
    {
      anonymous_guard_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(119);
    }
    return anonymous_guard_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_guard_2__MoreGuards_1()
  {
        return (EReference)getAnonymous_guard_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceType_()
  {
    if (traceType_EClass == null)
    {
      traceType_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(120);
    }
    return traceType_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceType__TracerType_1()
  {
        return (EAttribute)getTraceType_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceType__Anonymous_traceType_1_1()
  {
        return (EReference)getTraceType_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceType__Anonymous_traceType_2_1()
  {
        return (EReference)getTraceType_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_traceType_1_()
  {
    if (anonymous_traceType_1_EClass == null)
    {
      anonymous_traceType_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(121);
    }
    return anonymous_traceType_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_traceType_1__Verbisty_1()
  {
        return (EAttribute)getAnonymous_traceType_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_traceType_2_()
  {
    if (anonymous_traceType_2_EClass == null)
    {
      anonymous_traceType_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(122);
    }
    return anonymous_traceType_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_traceType_2__TracerArgument_1()
  {
        return (EAttribute)getAnonymous_traceType_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrace_()
  {
    if (trace_EClass == null)
    {
      trace_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(123);
    }
    return trace_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrace__TraceDirective_1()
  {
        return (EReference)getTrace_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrace__TraceCase_1()
  {
        return (EReference)getTrace_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceDirective_()
  {
    if (traceDirective_EClass == null)
    {
      traceDirective_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(124);
    }
    return traceDirective_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceDirective__TraceItem_1()
  {
        return (EReference)getTraceDirective_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceDirective__Anonymous_traceDirective_1_1()
  {
        return (EReference)getTraceDirective_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_traceDirective_1_()
  {
    if (anonymous_traceDirective_1_EClass == null)
    {
      anonymous_traceDirective_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(125);
    }
    return anonymous_traceDirective_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceDirective_1__ExecuteClause_1()
  {
        return (EReference)getAnonymous_traceDirective_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceDirective_1__TraceWhen_1()
  {
        return (EReference)getAnonymous_traceDirective_1_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceDirective_1__TraceFor_1()
  {
        return (EReference)getAnonymous_traceDirective_1_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceDirective_1__TracePeriod_1()
  {
        return (EReference)getAnonymous_traceDirective_1_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceDirective_1__TraceDuring_1()
  {
        return (EReference)getAnonymous_traceDirective_1_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceDirective_1__TraceCaseActivation_1()
  {
        return (EReference)getAnonymous_traceDirective_1_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceDirective_1__TraceRecord_1()
  {
        return (EReference)getAnonymous_traceDirective_1_().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceDirective_1__TraceLevel_1()
  {
        return (EReference)getAnonymous_traceDirective_1_().getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceItem_()
  {
    if (traceItem_EClass == null)
    {
      traceItem_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(126);
    }
    return traceItem_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceItem__TraceEntity_1()
  {
        return (EReference)getTraceItem_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceItem__PreOrPostCondition_1()
  {
        return (EReference)getTraceItem_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceEntity_()
  {
    if (traceEntity_EClass == null)
    {
      traceEntity_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(127);
    }
    return traceEntity_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceEntity__TraceOptions_1()
  {
        return (EReference)getTraceEntity_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceEntity__Trace_entity_1()
  {
        return (EAttribute)getTraceEntity_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceEntity__Anonymous_traceEntity_1_1()
  {
        return (EReference)getTraceEntity_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_traceEntity_1_()
  {
    if (anonymous_traceEntity_1_EClass == null)
    {
      anonymous_traceEntity_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(128);
    }
    return anonymous_traceEntity_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_traceEntity_1__Trace_entity_1()
  {
        return (EAttribute)getAnonymous_traceEntity_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceOptions_()
  {
    if (traceOptions_EClass == null)
    {
      traceOptions_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(129);
    }
    return traceOptions_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceOptions__TraceOption_1()
  {
        return (EReference)getTraceOptions_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceOptions__Anonymous_traceOptions_1_1()
  {
        return (EReference)getTraceOptions_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_traceOptions_1_()
  {
    if (anonymous_traceOptions_1_EClass == null)
    {
      anonymous_traceOptions_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(130);
    }
    return anonymous_traceOptions_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_traceOptions_1__TraceOption_1()
  {
        return (EReference)getAnonymous_traceOptions_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceOption_()
  {
    if (traceOption_EClass == null)
    {
      traceOption_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(131);
    }
    return traceOption_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceOption__Option_1()
  {
        return (EAttribute)getTraceOption_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPreOrPostCondition_()
  {
    if (preOrPostCondition_EClass == null)
    {
      preOrPostCondition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(132);
    }
    return preOrPostCondition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPreOrPostCondition__Anonymous_PreOrPostCondition_1_1()
  {
        return (EAttribute)getPreOrPostCondition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPreOrPostCondition__TraceCondition_1()
  {
        return (EReference)getPreOrPostCondition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExecuteClause_()
  {
    if (executeClause_EClass == null)
    {
      executeClause_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(133);
    }
    return executeClause_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExecuteClause__Trace_execute_1()
  {
        return (EAttribute)getExecuteClause_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceWhen_()
  {
    if (traceWhen_EClass == null)
    {
      traceWhen_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(134);
    }
    return traceWhen_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceWhen__ConditionType_1()
  {
        return (EAttribute)getTraceWhen_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceWhen__ConstraintToken_1()
  {
        return (EReference)getTraceWhen_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceFor_()
  {
    if (traceFor_EClass == null)
    {
      traceFor_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(135);
    }
    return traceFor_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceFor__Trace_for_1()
  {
        return (EAttribute)getTraceFor_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceLevel_()
  {
    if (traceLevel_EClass == null)
    {
      traceLevel_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(136);
    }
    return traceLevel_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceLevel__Trace_level_1()
  {
        return (EAttribute)getTraceLevel_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTracePeriod_()
  {
    if (tracePeriod_EClass == null)
    {
      tracePeriod_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(137);
    }
    return tracePeriod_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTracePeriod__Trace_period_1()
  {
        return (EAttribute)getTracePeriod_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceDuring_()
  {
    if (traceDuring_EClass == null)
    {
      traceDuring_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(138);
    }
    return traceDuring_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceDuring__Trace_duration_1()
  {
        return (EAttribute)getTraceDuring_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceRecord_()
  {
    if (traceRecord_EClass == null)
    {
      traceRecord_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(139);
    }
    return traceRecord_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceRecord__RecordEntity_1()
  {
        return (EReference)getTraceRecord_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordEntity_()
  {
    if (recordEntity_EClass == null)
    {
      recordEntity_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(140);
    }
    return recordEntity_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordEntity__Anonymous_recordEntity_1_1()
  {
        return (EAttribute)getRecordEntity_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordEntity__Trace_record_1()
  {
        return (EAttribute)getRecordEntity_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordEntity__Anonymous_recordEntity_2_1()
  {
        return (EReference)getRecordEntity_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_recordEntity_2_()
  {
    if (anonymous_recordEntity_2_EClass == null)
    {
      anonymous_recordEntity_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(141);
    }
    return anonymous_recordEntity_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_recordEntity_2__Trace_record_1()
  {
        return (EAttribute)getAnonymous_recordEntity_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceCondition_()
  {
    if (traceCondition_EClass == null)
    {
      traceCondition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(142);
    }
    return traceCondition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceCondition__LHS_1()
  {
        return (EAttribute)getTraceCondition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceCondition__ConditionRHS_1()
  {
        return (EReference)getTraceCondition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionRHS_()
  {
    if (conditionRHS_EClass == null)
    {
      conditionRHS_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(143);
    }
    return conditionRHS_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConditionRHS__Comparison_operator_1()
  {
        return (EAttribute)getConditionRHS_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConditionRHS__RHS_1()
  {
        return (EAttribute)getConditionRHS_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceCase_()
  {
    if (traceCase_EClass == null)
    {
      traceCase_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(144);
    }
    return traceCase_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceCase__TraceCaseDef_1()
  {
        return (EReference)getTraceCase_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceCase__TraceCaseActivation_1()
  {
        return (EReference)getTraceCase_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceCase__TraceCaseDeactivation_1()
  {
        return (EReference)getTraceCase_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceCaseDef_()
  {
    if (traceCaseDef_EClass == null)
    {
      traceCaseDef_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(145);
    }
    return traceCaseDef_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceCaseDef__Tracecase_name_1()
  {
        return (EAttribute)getTraceCaseDef_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceCaseDef__TraceDirective_1()
  {
        return (EReference)getTraceCaseDef_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceCaseActivation_()
  {
    if (traceCaseActivation_EClass == null)
    {
      traceCaseActivation_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(146);
    }
    return traceCaseActivation_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceCaseActivation__Tracecase_act_name_1()
  {
        return (EAttribute)getTraceCaseActivation_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceCaseActivation__Anonymous_traceCaseActivation_1_1()
  {
        return (EAttribute)getTraceCaseActivation_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTraceCaseDeactivation_()
  {
    if (traceCaseDeactivation_EClass == null)
    {
      traceCaseDeactivation_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(147);
    }
    return traceCaseDeactivation_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTraceCaseDeactivation__Tracecase_deact_name_1()
  {
        return (EAttribute)getTraceCaseDeactivation_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTraceCaseDeactivation__DeActivateFor_1()
  {
        return (EReference)getTraceCaseDeactivation_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeActivateFor_()
  {
    if (deActivateFor_EClass == null)
    {
      deActivateFor_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(148);
    }
    return deActivateFor_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDeActivateFor__Deactivate_for_1()
  {
        return (EAttribute)getDeActivateFor_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrecondition_()
  {
    if (precondition_EClass == null)
    {
      precondition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(149);
    }
    return precondition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrecondition__Name_1()
  {
        return (EAttribute)getPrecondition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrecondition__Constraint_1()
  {
        return (EReference)getPrecondition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostcondition_()
  {
    if (postcondition_EClass == null)
    {
      postcondition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(150);
    }
    return postcondition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPostcondition__Name_1()
  {
        return (EAttribute)getPostcondition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostcondition__Constraint_1()
  {
        return (EReference)getPostcondition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvariant_()
  {
    if (invariant_EClass == null)
    {
      invariant_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(151);
    }
    return invariant_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvariant__Anonymous_invariant_1_1()
  {
        return (EReference)getInvariant_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvariant__Anonymous_invariant_2_1()
  {
        return (EReference)getInvariant_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_invariant_1_()
  {
    if (anonymous_invariant_1_EClass == null)
    {
      anonymous_invariant_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(152);
    }
    return anonymous_invariant_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_invariant_1__Name_1()
  {
        return (EAttribute)getAnonymous_invariant_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_invariant_2_()
  {
    if (anonymous_invariant_2_EClass == null)
    {
      anonymous_invariant_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(153);
    }
    return anonymous_invariant_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_invariant_2__Constraint_1()
  {
        return (EReference)getAnonymous_invariant_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintToken_()
  {
    if (constraintToken_EClass == null)
    {
      constraintToken_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(154);
    }
    return constraintToken_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintToken__Constraint_1()
  {
        return (EReference)getConstraintToken_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraint_()
  {
    if (constraint_EClass == null)
    {
      constraint_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(155);
    }
    return constraint_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraint__Anonymous_constraint_1_1()
  {
        return (EReference)getConstraint_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraint__ConstraintBody_1()
  {
        return (EReference)getConstraint_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_constraint_1_()
  {
    if (anonymous_constraint_1_EClass == null)
    {
      anonymous_constraint_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(156);
    }
    return anonymous_constraint_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_constraint_1__ConstraintBody_1()
  {
        return (EReference)getAnonymous_constraint_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNegativeConstraint_()
  {
    if (negativeConstraint_EClass == null)
    {
      negativeConstraint_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(157);
    }
    return negativeConstraint_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNegativeConstraint__Constraint_1()
  {
        return (EReference)getNegativeConstraint_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintBody_()
  {
    if (constraintBody_EClass == null)
    {
      constraintBody_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(158);
    }
    return constraintBody_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintBody__ConstraintExpr_1()
  {
        return (EReference)getConstraintBody_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintBody__Anonymous_constraintBody_1_1()
  {
        return (EReference)getConstraintBody_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_constraintBody_1_()
  {
    if (anonymous_constraintBody_1_EClass == null)
    {
      anonymous_constraintBody_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(159);
    }
    return anonymous_constraintBody_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_constraintBody_1__LinkingOp_1()
  {
        return (EReference)getAnonymous_constraintBody_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinkingOp_()
  {
    if (linkingOp_EClass == null)
    {
      linkingOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(160);
    }
    return linkingOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkingOp__Anonymous_linkingOp_1_1()
  {
        return (EReference)getLinkingOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkingOp__Anonymous_linkingOp_2_1()
  {
        return (EReference)getLinkingOp_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkingOp__Anonymous_linkingOp_3_1()
  {
        return (EReference)getLinkingOp_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_linkingOp_1_()
  {
    if (anonymous_linkingOp_1_EClass == null)
    {
      anonymous_linkingOp_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(161);
    }
    return anonymous_linkingOp_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_linkingOp_1__ConstraintExpr_1()
  {
        return (EReference)getAnonymous_linkingOp_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_linkingOp_2_()
  {
    if (anonymous_linkingOp_2_EClass == null)
    {
      anonymous_linkingOp_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(162);
    }
    return anonymous_linkingOp_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_linkingOp_2__AndOp_1()
  {
        return (EAttribute)getAnonymous_linkingOp_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_linkingOp_2__ConstraintExpr_1()
  {
        return (EReference)getAnonymous_linkingOp_2_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_linkingOp_3_()
  {
    if (anonymous_linkingOp_3_EClass == null)
    {
      anonymous_linkingOp_3_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(163);
    }
    return anonymous_linkingOp_3_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_linkingOp_3__OrOp_1()
  {
        return (EAttribute)getAnonymous_linkingOp_3_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnonymous_linkingOp_3__ConstraintExpr_1()
  {
        return (EReference)getAnonymous_linkingOp_3_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintExpr_()
  {
    if (constraintExpr_EClass == null)
    {
      constraintExpr_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(164);
    }
    return constraintExpr_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintExpr__NegativeConstraint_1()
  {
        return (EReference)getConstraintExpr_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintExpr__StringExpr_1()
  {
        return (EReference)getConstraintExpr_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintExpr__BoolExpr_1()
  {
        return (EReference)getConstraintExpr_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintExpr__GenExpr_1()
  {
        return (EReference)getConstraintExpr_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintExpr__NumExpr_1()
  {
        return (EReference)getConstraintExpr_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstraintExpr__LoneBoolean_1()
  {
        return (EAttribute)getConstraintExpr_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintExpr__Anonymous_constraintExpr_1_1()
  {
        return (EReference)getConstraintExpr_().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_constraintExpr_1_()
  {
    if (anonymous_constraintExpr_1_EClass == null)
    {
      anonymous_constraintExpr_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(165);
    }
    return anonymous_constraintExpr_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_constraintExpr_1__Index_1()
  {
        return (EAttribute)getAnonymous_constraintExpr_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCompoundExpr_()
  {
    if (compoundExpr_EClass == null)
    {
      compoundExpr_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(166);
    }
    return compoundExpr_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundExpr__StringExpr_1()
  {
        return (EReference)getCompoundExpr_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundExpr__BoolExpr_1()
  {
        return (EReference)getCompoundExpr_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundExpr__NumExpr_1()
  {
        return (EReference)getCompoundExpr_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCompoundExpr__GenExpr_1()
  {
        return (EReference)getCompoundExpr_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBoolExpr_()
  {
    if (boolExpr_EClass == null)
    {
      boolExpr_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(167);
    }
    return boolExpr_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBoolExpr__Literal_1()
  {
        return (EAttribute)getBoolExpr_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBoolExpr__Name_1()
  {
        return (EAttribute)getBoolExpr_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBoolExpr__EqualityOp_1()
  {
        return (EReference)getBoolExpr_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBoolExpr__Index_1()
  {
        return (EAttribute)getBoolExpr_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringExpr_()
  {
    if (stringExpr_EClass == null)
    {
      stringExpr_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(168);
    }
    return stringExpr_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringExpr__Name_1()
  {
        return (EAttribute)getStringExpr_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringExpr__EqualityOp_1()
  {
        return (EReference)getStringExpr_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStringExpr__StringLit_1()
  {
        return (EReference)getStringExpr_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringExpr__Index_1()
  {
        return (EAttribute)getStringExpr_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLit_()
  {
    if (stringLit_EClass == null)
    {
      stringLit_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(169);
    }
    return stringLit_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringLit__Quote_1()
  {
        return (EAttribute)getStringLit_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGenExpr_()
  {
    if (genExpr_EClass == null)
    {
      genExpr_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(170);
    }
    return genExpr_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGenExpr__Name_1()
  {
        return (EAttribute)getGenExpr_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGenExpr__Anonymous_genExpr_1_1()
  {
        return (EReference)getGenExpr_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGenExpr__EqualityOp_1()
  {
        return (EReference)getGenExpr_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGenExpr__Name_2()
  {
        return (EAttribute)getGenExpr_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGenExpr__Anonymous_genExpr_2_1()
  {
        return (EReference)getGenExpr_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_genExpr_1_()
  {
    if (anonymous_genExpr_1_EClass == null)
    {
      anonymous_genExpr_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(171);
    }
    return anonymous_genExpr_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_genExpr_1__Index_1()
  {
        return (EAttribute)getAnonymous_genExpr_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_genExpr_2_()
  {
    if (anonymous_genExpr_2_EClass == null)
    {
      anonymous_genExpr_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(172);
    }
    return anonymous_genExpr_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_genExpr_2__Index_1()
  {
        return (EAttribute)getAnonymous_genExpr_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumExpr_()
  {
    if (numExpr_EClass == null)
    {
      numExpr_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(173);
    }
    return numExpr_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumExpr__Name_1()
  {
        return (EAttribute)getNumExpr_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumExpr__Anonymous_numExpr_1_1()
  {
        return (EReference)getNumExpr_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumExpr__Anonymous_numExpr_2_1()
  {
        return (EReference)getNumExpr_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumExpr__OrdinalOp_1()
  {
        return (EReference)getNumExpr_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumExpr__Name_2()
  {
        return (EAttribute)getNumExpr_().getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumExpr__Anonymous_numExpr_3_1()
  {
        return (EReference)getNumExpr_().getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumExpr__Anonymous_numExpr_4_1()
  {
        return (EReference)getNumExpr_().getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_numExpr_1_()
  {
    if (anonymous_numExpr_1_EClass == null)
    {
      anonymous_numExpr_1_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(174);
    }
    return anonymous_numExpr_1_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_numExpr_1__Tail_1()
  {
        return (EAttribute)getAnonymous_numExpr_1_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_numExpr_2_()
  {
    if (anonymous_numExpr_2_EClass == null)
    {
      anonymous_numExpr_2_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(175);
    }
    return anonymous_numExpr_2_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_numExpr_2__Index_1()
  {
        return (EAttribute)getAnonymous_numExpr_2_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_numExpr_3_()
  {
    if (anonymous_numExpr_3_EClass == null)
    {
      anonymous_numExpr_3_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(176);
    }
    return anonymous_numExpr_3_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_numExpr_3__Tail_1()
  {
        return (EAttribute)getAnonymous_numExpr_3_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnonymous_numExpr_4_()
  {
    if (anonymous_numExpr_4_EClass == null)
    {
      anonymous_numExpr_4_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(177);
    }
    return anonymous_numExpr_4_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnonymous_numExpr_4__Index_1()
  {
        return (EAttribute)getAnonymous_numExpr_4_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualityOp_()
  {
    if (equalityOp_EClass == null)
    {
      equalityOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(178);
    }
    return equalityOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityOp__EqualsOp_1()
  {
        return (EReference)getEqualityOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEqualityOp__NotequalsOp_1()
  {
        return (EReference)getEqualityOp_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEqualsOp_()
  {
    if (equalsOp_EClass == null)
    {
      equalsOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(179);
    }
    return equalsOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEqualsOp__EqualsOp_1()
  {
        return (EAttribute)getEqualsOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNotequalsOp_()
  {
    if (notequalsOp_EClass == null)
    {
      notequalsOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(180);
    }
    return notequalsOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNotequalsOp__NotequalsOp_1()
  {
        return (EAttribute)getNotequalsOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOrdinalOp_()
  {
    if (ordinalOp_EClass == null)
    {
      ordinalOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(181);
    }
    return ordinalOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrdinalOp__GreaterOp_1()
  {
        return (EReference)getOrdinalOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrdinalOp__LessOp_1()
  {
        return (EReference)getOrdinalOp_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrdinalOp__MoreOp_1()
  {
        return (EReference)getOrdinalOp_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOrdinalOp__SmallerOp_1()
  {
        return (EReference)getOrdinalOp_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGreaterOp_()
  {
    if (greaterOp_EClass == null)
    {
      greaterOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(182);
    }
    return greaterOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGreaterOp__GreaterOp_1()
  {
        return (EAttribute)getGreaterOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLessOp_()
  {
    if (lessOp_EClass == null)
    {
      lessOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(183);
    }
    return lessOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLessOp__LessOp_1()
  {
        return (EAttribute)getLessOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMoreOp_()
  {
    if (moreOp_EClass == null)
    {
      moreOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(184);
    }
    return moreOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMoreOp__MoreOp_1()
  {
        return (EAttribute)getMoreOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSmallerOp_()
  {
    if (smallerOp_EClass == null)
    {
      smallerOp_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(185);
    }
    return smallerOp_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSmallerOp__SmallerOp_1()
  {
        return (EAttribute)getSmallerOp_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPosition_()
  {
    if (position_EClass == null)
    {
      position_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(186);
    }
    return position_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPosition__AssociationPosition_1()
  {
        return (EReference)getPosition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPosition__ElementPosition_1()
  {
        return (EReference)getPosition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElementPosition_()
  {
    if (elementPosition_EClass == null)
    {
      elementPosition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(187);
    }
    return elementPosition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getElementPosition__X_1()
  {
        return (EAttribute)getElementPosition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getElementPosition__Y_1()
  {
        return (EAttribute)getElementPosition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getElementPosition__Width_1()
  {
        return (EAttribute)getElementPosition_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getElementPosition__Height_1()
  {
        return (EAttribute)getElementPosition_().getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationPosition_()
  {
    if (associationPosition_EClass == null)
    {
      associationPosition_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(188);
    }
    return associationPosition_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssociationPosition__Name_1()
  {
        return (EAttribute)getAssociationPosition_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationPosition__Coordinate_1()
  {
        return (EReference)getAssociationPosition_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationPosition__Coordinate_2()
  {
        return (EReference)getAssociationPosition_().getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCoordinate_()
  {
    if (coordinate_EClass == null)
    {
      coordinate_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(189);
    }
    return coordinate_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCoordinate__X_1()
  {
        return (EAttribute)getCoordinate_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCoordinate__Y_1()
  {
        return (EAttribute)getCoordinate_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDisplayColor_()
  {
    if (displayColor_EClass == null)
    {
      displayColor_EClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(UmplePackage.eNS_URI).getEClassifiers().get(190);
    }
    return displayColor_EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDisplayColor__Anonymous_displayColor_1_1()
  {
        return (EAttribute)getDisplayColor_().getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDisplayColor__ColorValue_1()
  {
        return (EAttribute)getDisplayColor_().getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleFactory getUmpleFactory()
  {
    return (UmpleFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isLoaded = false;

  /**
   * Laods the package and any sub-packages from their serialized form.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void loadPackage()
  {
    if (isLoaded) return;
    isLoaded = true;

    URL url = getClass().getResource(packageFilename);
    if (url == null)
    {
      throw new RuntimeException("Missing serialized package: " + packageFilename);
    }
    URI uri = URI.createURI(url.toString());
    Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
    try
    {
      resource.load(null);
    }
    catch (IOException exception)
    {
      throw new WrappedException(exception);
    }
    initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
    createResource(eNS_URI);
  }


  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isFixed = false;

  /**
   * Fixes up the loaded package, to make it appear as if it had been programmatically built.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fixPackageContents()
  {
    if (isFixed) return;
    isFixed = true;
    fixEClassifiers();
  }

  /**
   * Sets the instance class on the given classifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void fixInstanceClass(EClassifier eClassifier)
  {
    if (eClassifier.getInstanceClassName() == null)
    {
      eClassifier.setInstanceClassName("cruise.umple.umple." + eClassifier.getName());
      setGeneratedClassName(eClassifier);
    }
  }

} //UmplePackageImpl
