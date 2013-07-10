/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.util;

import cruise.umple.umple.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cruise.umple.umple.UmplePackage
 * @generated
 */
public class UmpleAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UmplePackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = UmplePackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UmpleSwitch<Adapter> modelSwitch =
    new UmpleSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseProgram_(Program_ object)
      {
        return createProgram_Adapter();
      }
      @Override
      public Adapter caseAnonymous_program_1_(Anonymous_program_1_ object)
      {
        return createAnonymous_program_1_Adapter();
      }
      @Override
      public Adapter caseDirective_(Directive_ object)
      {
        return createDirective_Adapter();
      }
      @Override
      public Adapter caseGlossary_(Glossary_ object)
      {
        return createGlossary_Adapter();
      }
      @Override
      public Adapter caseWord_(Word_ object)
      {
        return createWord_Adapter();
      }
      @Override
      public Adapter caseStrictness_(Strictness_ object)
      {
        return createStrictness_Adapter();
      }
      @Override
      public Adapter caseAnonymous_strictness_1_(Anonymous_strictness_1_ object)
      {
        return createAnonymous_strictness_1_Adapter();
      }
      @Override
      public Adapter caseGenerate_(Generate_ object)
      {
        return createGenerate_Adapter();
      }
      @Override
      public Adapter caseGenerate_path_(Generate_path_ object)
      {
        return createGenerate_path_Adapter();
      }
      @Override
      public Adapter caseUseStatement_(UseStatement_ object)
      {
        return createUseStatement_Adapter();
      }
      @Override
      public Adapter caseNamespace_(Namespace_ object)
      {
        return createNamespace_Adapter();
      }
      @Override
      public Adapter caseEntity_(Entity_ object)
      {
        return createEntity_Adapter();
      }
      @Override
      public Adapter caseComment_(Comment_ object)
      {
        return createComment_Adapter();
      }
      @Override
      public Adapter caseInlineComment_(InlineComment_ object)
      {
        return createInlineComment_Adapter();
      }
      @Override
      public Adapter caseMultilineComment_(MultilineComment_ object)
      {
        return createMultilineComment_Adapter();
      }
      @Override
      public Adapter caseDebug_(Debug_ object)
      {
        return createDebug_Adapter();
      }
      @Override
      public Adapter caseAbstract_(Abstract_ object)
      {
        return createAbstract_Adapter();
      }
      @Override
      public Adapter caseClassDefinition_(ClassDefinition_ object)
      {
        return createClassDefinition_Adapter();
      }
      @Override
      public Adapter caseExternalDefinition_(ExternalDefinition_ object)
      {
        return createExternalDefinition_Adapter();
      }
      @Override
      public Adapter caseInterfaceDefinition_(InterfaceDefinition_ object)
      {
        return createInterfaceDefinition_Adapter();
      }
      @Override
      public Adapter caseAssociationDefinition_(AssociationDefinition_ object)
      {
        return createAssociationDefinition_Adapter();
      }
      @Override
      public Adapter caseAssociationClassDefinition_(AssociationClassDefinition_ object)
      {
        return createAssociationClassDefinition_Adapter();
      }
      @Override
      public Adapter caseClassContent_(ClassContent_ object)
      {
        return createClassContent_Adapter();
      }
      @Override
      public Adapter caseAssociationClassContent_(AssociationClassContent_ object)
      {
        return createAssociationClassContent_Adapter();
      }
      @Override
      public Adapter caseInterfaceBody_(InterfaceBody_ object)
      {
        return createInterfaceBody_Adapter();
      }
      @Override
      public Adapter caseInterfaceMemberDeclaration_(InterfaceMemberDeclaration_ object)
      {
        return createInterfaceMemberDeclaration_Adapter();
      }
      @Override
      public Adapter caseConstantDeclaration_(ConstantDeclaration_ object)
      {
        return createConstantDeclaration_Adapter();
      }
      @Override
      public Adapter caseAnonymous_constantDeclaration_1_(Anonymous_constantDeclaration_1_ object)
      {
        return createAnonymous_constantDeclaration_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_constantDeclaration_2_(Anonymous_constantDeclaration_2_ object)
      {
        return createAnonymous_constantDeclaration_2_Adapter();
      }
      @Override
      public Adapter caseMoreCode_(MoreCode_ object)
      {
        return createMoreCode_Adapter();
      }
      @Override
      public Adapter caseAnonymous_moreCode_1_(Anonymous_moreCode_1_ object)
      {
        return createAnonymous_moreCode_1_Adapter();
      }
      @Override
      public Adapter caseCodeLangs_(CodeLangs_ object)
      {
        return createCodeLangs_Adapter();
      }
      @Override
      public Adapter caseAnonymous_codeLangs_1_(Anonymous_codeLangs_1_ object)
      {
        return createAnonymous_codeLangs_1_Adapter();
      }
      @Override
      public Adapter caseCodeLang_(CodeLang_ object)
      {
        return createCodeLang_Adapter();
      }
      @Override
      public Adapter caseMethodBody_(MethodBody_ object)
      {
        return createMethodBody_Adapter();
      }
      @Override
      public Adapter caseAnonymous_methodBody_1_(Anonymous_methodBody_1_ object)
      {
        return createAnonymous_methodBody_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_methodBody_2_(Anonymous_methodBody_2_ object)
      {
        return createAnonymous_methodBody_2_Adapter();
      }
      @Override
      public Adapter caseConcreteMethodDeclaration_(ConcreteMethodDeclaration_ object)
      {
        return createConcreteMethodDeclaration_Adapter();
      }
      @Override
      public Adapter caseAnonymous_concreteMethodDeclaration_1_(Anonymous_concreteMethodDeclaration_1_ object)
      {
        return createAnonymous_concreteMethodDeclaration_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_concreteMethodDeclaration_2_(Anonymous_concreteMethodDeclaration_2_ object)
      {
        return createAnonymous_concreteMethodDeclaration_2_Adapter();
      }
      @Override
      public Adapter caseAbstractMethodDeclaration_(AbstractMethodDeclaration_ object)
      {
        return createAbstractMethodDeclaration_Adapter();
      }
      @Override
      public Adapter caseMethodDeclarator_(MethodDeclarator_ object)
      {
        return createMethodDeclarator_Adapter();
      }
      @Override
      public Adapter caseParameterList_(ParameterList_ object)
      {
        return createParameterList_Adapter();
      }
      @Override
      public Adapter caseAnonymous_parameterList_1_(Anonymous_parameterList_1_ object)
      {
        return createAnonymous_parameterList_1_Adapter();
      }
      @Override
      public Adapter caseParameter_(Parameter_ object)
      {
        return createParameter_Adapter();
      }
      @Override
      public Adapter caseAnonymous_parameter_1_(Anonymous_parameter_1_ object)
      {
        return createAnonymous_parameter_1_Adapter();
      }
      @Override
      public Adapter caseAssociation_(Association_ object)
      {
        return createAssociation_Adapter();
      }
      @Override
      public Adapter caseSymmetricReflexiveAssociation_(SymmetricReflexiveAssociation_ object)
      {
        return createSymmetricReflexiveAssociation_Adapter();
      }
      @Override
      public Adapter caseInlineAssociation_(InlineAssociation_ object)
      {
        return createInlineAssociation_Adapter();
      }
      @Override
      public Adapter caseInlineAssociationEnd_(InlineAssociationEnd_ object)
      {
        return createInlineAssociationEnd_Adapter();
      }
      @Override
      public Adapter caseSingleAssociationEnd_(SingleAssociationEnd_ object)
      {
        return createSingleAssociationEnd_Adapter();
      }
      @Override
      public Adapter caseAssociationEnd_(AssociationEnd_ object)
      {
        return createAssociationEnd_Adapter();
      }
      @Override
      public Adapter caseMultiplicity_(Multiplicity_ object)
      {
        return createMultiplicity_Adapter();
      }
      @Override
      public Adapter caseIsSorted_(IsSorted_ object)
      {
        return createIsSorted_Adapter();
      }
      @Override
      public Adapter caseAttribute_(Attribute_ object)
      {
        return createAttribute_Adapter();
      }
      @Override
      public Adapter caseSimpleAttribute_(SimpleAttribute_ object)
      {
        return createSimpleAttribute_Adapter();
      }
      @Override
      public Adapter caseAutouniqueAttribute_(AutouniqueAttribute_ object)
      {
        return createAutouniqueAttribute_Adapter();
      }
      @Override
      public Adapter caseDerivedAttribute_(DerivedAttribute_ object)
      {
        return createDerivedAttribute_Adapter();
      }
      @Override
      public Adapter caseAnonymous_derivedAttribute_1_(Anonymous_derivedAttribute_1_ object)
      {
        return createAnonymous_derivedAttribute_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_derivedAttribute_2_(Anonymous_derivedAttribute_2_ object)
      {
        return createAnonymous_derivedAttribute_2_Adapter();
      }
      @Override
      public Adapter caseAnonymous_derivedAttribute_3_(Anonymous_derivedAttribute_3_ object)
      {
        return createAnonymous_derivedAttribute_3_Adapter();
      }
      @Override
      public Adapter caseComplexAttribute_(ComplexAttribute_ object)
      {
        return createComplexAttribute_Adapter();
      }
      @Override
      public Adapter caseAnonymous_complexAttribute_1_(Anonymous_complexAttribute_1_ object)
      {
        return createAnonymous_complexAttribute_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_complexAttribute_2_(Anonymous_complexAttribute_2_ object)
      {
        return createAnonymous_complexAttribute_2_Adapter();
      }
      @Override
      public Adapter caseKey_(Key_ object)
      {
        return createKey_Adapter();
      }
      @Override
      public Adapter caseAnonymous_key_1_(Anonymous_key_1_ object)
      {
        return createAnonymous_key_1_Adapter();
      }
      @Override
      public Adapter caseDepend_(Depend_ object)
      {
        return createDepend_Adapter();
      }
      @Override
      public Adapter caseExtraCode_(ExtraCode_ object)
      {
        return createExtraCode_Adapter();
      }
      @Override
      public Adapter caseSoftwarePattern_(SoftwarePattern_ object)
      {
        return createSoftwarePattern_Adapter();
      }
      @Override
      public Adapter caseIsA_(IsA_ object)
      {
        return createIsA_Adapter();
      }
      @Override
      public Adapter caseSingleIsA_(SingleIsA_ object)
      {
        return createSingleIsA_Adapter();
      }
      @Override
      public Adapter caseAnonymous_singleIsA_1_(Anonymous_singleIsA_1_ object)
      {
        return createAnonymous_singleIsA_1_Adapter();
      }
      @Override
      public Adapter caseMultipleIsA_(MultipleIsA_ object)
      {
        return createMultipleIsA_Adapter();
      }
      @Override
      public Adapter caseAnonymous_multipleIsA_1_(Anonymous_multipleIsA_1_ object)
      {
        return createAnonymous_multipleIsA_1_Adapter();
      }
      @Override
      public Adapter caseSingleton_(Singleton_ object)
      {
        return createSingleton_Adapter();
      }
      @Override
      public Adapter caseImmutable_(Immutable_ object)
      {
        return createImmutable_Adapter();
      }
      @Override
      public Adapter caseKeyDefinition_(KeyDefinition_ object)
      {
        return createKeyDefinition_Adapter();
      }
      @Override
      public Adapter caseCodeInjection_(CodeInjection_ object)
      {
        return createCodeInjection_Adapter();
      }
      @Override
      public Adapter caseBeforeCode_(BeforeCode_ object)
      {
        return createBeforeCode_Adapter();
      }
      @Override
      public Adapter caseAnonymous_beforeCode_1_(Anonymous_beforeCode_1_ object)
      {
        return createAnonymous_beforeCode_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_beforeCode_2_(Anonymous_beforeCode_2_ object)
      {
        return createAnonymous_beforeCode_2_Adapter();
      }
      @Override
      public Adapter caseAfterCode_(AfterCode_ object)
      {
        return createAfterCode_Adapter();
      }
      @Override
      public Adapter caseAnonymous_afterCode_1_(Anonymous_afterCode_1_ object)
      {
        return createAnonymous_afterCode_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_afterCode_2_(Anonymous_afterCode_2_ object)
      {
        return createAnonymous_afterCode_2_Adapter();
      }
      @Override
      public Adapter caseStateMachineDefinition_(StateMachineDefinition_ object)
      {
        return createStateMachineDefinition_Adapter();
      }
      @Override
      public Adapter caseStateMachine_(StateMachine_ object)
      {
        return createStateMachine_Adapter();
      }
      @Override
      public Adapter caseActiveDefinition_(ActiveDefinition_ object)
      {
        return createActiveDefinition_Adapter();
      }
      @Override
      public Adapter caseInlineStateMachine_(InlineStateMachine_ object)
      {
        return createInlineStateMachine_Adapter();
      }
      @Override
      public Adapter caseAnonymous_inlineStateMachine_1_(Anonymous_inlineStateMachine_1_ object)
      {
        return createAnonymous_inlineStateMachine_1_Adapter();
      }
      @Override
      public Adapter caseReferencedStateMachine_(ReferencedStateMachine_ object)
      {
        return createReferencedStateMachine_Adapter();
      }
      @Override
      public Adapter caseExtendedStateMachine_(ExtendedStateMachine_ object)
      {
        return createExtendedStateMachine_Adapter();
      }
      @Override
      public Adapter caseAnonymous_extendedStateMachine_1_(Anonymous_extendedStateMachine_1_ object)
      {
        return createAnonymous_extendedStateMachine_1_Adapter();
      }
      @Override
      public Adapter caseEnum_(Enum_ object)
      {
        return createEnum_Adapter();
      }
      @Override
      public Adapter caseAnonymous_enum_1_(Anonymous_enum_1_ object)
      {
        return createAnonymous_enum_1_Adapter();
      }
      @Override
      public Adapter caseState_(State_ object)
      {
        return createState_Adapter();
      }
      @Override
      public Adapter caseAnonymous_state_1_(Anonymous_state_1_ object)
      {
        return createAnonymous_state_1_Adapter();
      }
      @Override
      public Adapter caseStateInternal_(StateInternal_ object)
      {
        return createStateInternal_Adapter();
      }
      @Override
      public Adapter caseStateEntity_(StateEntity_ object)
      {
        return createStateEntity_Adapter();
      }
      @Override
      public Adapter caseAutoTransition_(AutoTransition_ object)
      {
        return createAutoTransition_Adapter();
      }
      @Override
      public Adapter caseAutoTransitionBlock_(AutoTransitionBlock_ object)
      {
        return createAutoTransitionBlock_Adapter();
      }
      @Override
      public Adapter caseTransition_(Transition_ object)
      {
        return createTransition_Adapter();
      }
      @Override
      public Adapter caseEventDefinition_(EventDefinition_ object)
      {
        return createEventDefinition_Adapter();
      }
      @Override
      public Adapter caseAnonymous_eventDefinition_1_(Anonymous_eventDefinition_1_ object)
      {
        return createAnonymous_eventDefinition_1_Adapter();
      }
      @Override
      public Adapter caseAfterEveryEvent_(AfterEveryEvent_ object)
      {
        return createAfterEveryEvent_Adapter();
      }
      @Override
      public Adapter caseAfterEvent_(AfterEvent_ object)
      {
        return createAfterEvent_Adapter();
      }
      @Override
      public Adapter caseAction_(Action_ object)
      {
        return createAction_Adapter();
      }
      @Override
      public Adapter caseAnonymous_action_1_(Anonymous_action_1_ object)
      {
        return createAnonymous_action_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_action_2_(Anonymous_action_2_ object)
      {
        return createAnonymous_action_2_Adapter();
      }
      @Override
      public Adapter caseEntryOrExitAction_(EntryOrExitAction_ object)
      {
        return createEntryOrExitAction_Adapter();
      }
      @Override
      public Adapter caseAnonymous_entryOrExitAction_1_(Anonymous_entryOrExitAction_1_ object)
      {
        return createAnonymous_entryOrExitAction_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_entryOrExitAction_2_(Anonymous_entryOrExitAction_2_ object)
      {
        return createAnonymous_entryOrExitAction_2_Adapter();
      }
      @Override
      public Adapter caseActivity_(Activity_ object)
      {
        return createActivity_Adapter();
      }
      @Override
      public Adapter caseAnonymous_activity_1_(Anonymous_activity_1_ object)
      {
        return createAnonymous_activity_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_activity_2_(Anonymous_activity_2_ object)
      {
        return createAnonymous_activity_2_Adapter();
      }
      @Override
      public Adapter caseMoreGuards_(MoreGuards_ object)
      {
        return createMoreGuards_Adapter();
      }
      @Override
      public Adapter caseAnonymous_moreGuards_1_(Anonymous_moreGuards_1_ object)
      {
        return createAnonymous_moreGuards_1_Adapter();
      }
      @Override
      public Adapter caseGuard_(Guard_ object)
      {
        return createGuard_Adapter();
      }
      @Override
      public Adapter caseAnonymous_guard_1_(Anonymous_guard_1_ object)
      {
        return createAnonymous_guard_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_guard_2_(Anonymous_guard_2_ object)
      {
        return createAnonymous_guard_2_Adapter();
      }
      @Override
      public Adapter caseTraceType_(TraceType_ object)
      {
        return createTraceType_Adapter();
      }
      @Override
      public Adapter caseAnonymous_traceType_1_(Anonymous_traceType_1_ object)
      {
        return createAnonymous_traceType_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_traceType_2_(Anonymous_traceType_2_ object)
      {
        return createAnonymous_traceType_2_Adapter();
      }
      @Override
      public Adapter caseTrace_(Trace_ object)
      {
        return createTrace_Adapter();
      }
      @Override
      public Adapter caseTraceDirective_(TraceDirective_ object)
      {
        return createTraceDirective_Adapter();
      }
      @Override
      public Adapter caseAnonymous_traceDirective_1_(Anonymous_traceDirective_1_ object)
      {
        return createAnonymous_traceDirective_1_Adapter();
      }
      @Override
      public Adapter caseTraceItem_(TraceItem_ object)
      {
        return createTraceItem_Adapter();
      }
      @Override
      public Adapter caseTraceEntity_(TraceEntity_ object)
      {
        return createTraceEntity_Adapter();
      }
      @Override
      public Adapter caseAnonymous_traceEntity_1_(Anonymous_traceEntity_1_ object)
      {
        return createAnonymous_traceEntity_1_Adapter();
      }
      @Override
      public Adapter caseTraceOptions_(TraceOptions_ object)
      {
        return createTraceOptions_Adapter();
      }
      @Override
      public Adapter caseAnonymous_traceOptions_1_(Anonymous_traceOptions_1_ object)
      {
        return createAnonymous_traceOptions_1_Adapter();
      }
      @Override
      public Adapter caseTraceOption_(TraceOption_ object)
      {
        return createTraceOption_Adapter();
      }
      @Override
      public Adapter casePreOrPostCondition_(PreOrPostCondition_ object)
      {
        return createPreOrPostCondition_Adapter();
      }
      @Override
      public Adapter caseExecuteClause_(ExecuteClause_ object)
      {
        return createExecuteClause_Adapter();
      }
      @Override
      public Adapter caseTraceWhen_(TraceWhen_ object)
      {
        return createTraceWhen_Adapter();
      }
      @Override
      public Adapter caseTraceFor_(TraceFor_ object)
      {
        return createTraceFor_Adapter();
      }
      @Override
      public Adapter caseTraceLevel_(TraceLevel_ object)
      {
        return createTraceLevel_Adapter();
      }
      @Override
      public Adapter caseTracePeriod_(TracePeriod_ object)
      {
        return createTracePeriod_Adapter();
      }
      @Override
      public Adapter caseTraceDuring_(TraceDuring_ object)
      {
        return createTraceDuring_Adapter();
      }
      @Override
      public Adapter caseTraceRecord_(TraceRecord_ object)
      {
        return createTraceRecord_Adapter();
      }
      @Override
      public Adapter caseRecordEntity_(RecordEntity_ object)
      {
        return createRecordEntity_Adapter();
      }
      @Override
      public Adapter caseAnonymous_recordEntity_2_(Anonymous_recordEntity_2_ object)
      {
        return createAnonymous_recordEntity_2_Adapter();
      }
      @Override
      public Adapter caseTraceCondition_(TraceCondition_ object)
      {
        return createTraceCondition_Adapter();
      }
      @Override
      public Adapter caseConditionRHS_(ConditionRHS_ object)
      {
        return createConditionRHS_Adapter();
      }
      @Override
      public Adapter caseTraceCase_(TraceCase_ object)
      {
        return createTraceCase_Adapter();
      }
      @Override
      public Adapter caseTraceCaseDef_(TraceCaseDef_ object)
      {
        return createTraceCaseDef_Adapter();
      }
      @Override
      public Adapter caseTraceCaseActivation_(TraceCaseActivation_ object)
      {
        return createTraceCaseActivation_Adapter();
      }
      @Override
      public Adapter caseTraceCaseDeactivation_(TraceCaseDeactivation_ object)
      {
        return createTraceCaseDeactivation_Adapter();
      }
      @Override
      public Adapter caseDeActivateFor_(DeActivateFor_ object)
      {
        return createDeActivateFor_Adapter();
      }
      @Override
      public Adapter casePrecondition_(Precondition_ object)
      {
        return createPrecondition_Adapter();
      }
      @Override
      public Adapter casePostcondition_(Postcondition_ object)
      {
        return createPostcondition_Adapter();
      }
      @Override
      public Adapter caseInvariant_(Invariant_ object)
      {
        return createInvariant_Adapter();
      }
      @Override
      public Adapter caseAnonymous_invariant_1_(Anonymous_invariant_1_ object)
      {
        return createAnonymous_invariant_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_invariant_2_(Anonymous_invariant_2_ object)
      {
        return createAnonymous_invariant_2_Adapter();
      }
      @Override
      public Adapter caseConstraintToken_(ConstraintToken_ object)
      {
        return createConstraintToken_Adapter();
      }
      @Override
      public Adapter caseConstraint_(Constraint_ object)
      {
        return createConstraint_Adapter();
      }
      @Override
      public Adapter caseAnonymous_constraint_1_(Anonymous_constraint_1_ object)
      {
        return createAnonymous_constraint_1_Adapter();
      }
      @Override
      public Adapter caseNegativeConstraint_(NegativeConstraint_ object)
      {
        return createNegativeConstraint_Adapter();
      }
      @Override
      public Adapter caseConstraintBody_(ConstraintBody_ object)
      {
        return createConstraintBody_Adapter();
      }
      @Override
      public Adapter caseAnonymous_constraintBody_1_(Anonymous_constraintBody_1_ object)
      {
        return createAnonymous_constraintBody_1_Adapter();
      }
      @Override
      public Adapter caseLinkingOp_(LinkingOp_ object)
      {
        return createLinkingOp_Adapter();
      }
      @Override
      public Adapter caseAnonymous_linkingOp_1_(Anonymous_linkingOp_1_ object)
      {
        return createAnonymous_linkingOp_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_linkingOp_2_(Anonymous_linkingOp_2_ object)
      {
        return createAnonymous_linkingOp_2_Adapter();
      }
      @Override
      public Adapter caseAnonymous_linkingOp_3_(Anonymous_linkingOp_3_ object)
      {
        return createAnonymous_linkingOp_3_Adapter();
      }
      @Override
      public Adapter caseConstraintExpr_(ConstraintExpr_ object)
      {
        return createConstraintExpr_Adapter();
      }
      @Override
      public Adapter caseAnonymous_constraintExpr_1_(Anonymous_constraintExpr_1_ object)
      {
        return createAnonymous_constraintExpr_1_Adapter();
      }
      @Override
      public Adapter caseCompoundExpr_(CompoundExpr_ object)
      {
        return createCompoundExpr_Adapter();
      }
      @Override
      public Adapter caseBoolExpr_(BoolExpr_ object)
      {
        return createBoolExpr_Adapter();
      }
      @Override
      public Adapter caseStringExpr_(StringExpr_ object)
      {
        return createStringExpr_Adapter();
      }
      @Override
      public Adapter caseStringLit_(StringLit_ object)
      {
        return createStringLit_Adapter();
      }
      @Override
      public Adapter caseGenExpr_(GenExpr_ object)
      {
        return createGenExpr_Adapter();
      }
      @Override
      public Adapter caseAnonymous_genExpr_1_(Anonymous_genExpr_1_ object)
      {
        return createAnonymous_genExpr_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_genExpr_2_(Anonymous_genExpr_2_ object)
      {
        return createAnonymous_genExpr_2_Adapter();
      }
      @Override
      public Adapter caseNumExpr_(NumExpr_ object)
      {
        return createNumExpr_Adapter();
      }
      @Override
      public Adapter caseAnonymous_numExpr_1_(Anonymous_numExpr_1_ object)
      {
        return createAnonymous_numExpr_1_Adapter();
      }
      @Override
      public Adapter caseAnonymous_numExpr_2_(Anonymous_numExpr_2_ object)
      {
        return createAnonymous_numExpr_2_Adapter();
      }
      @Override
      public Adapter caseAnonymous_numExpr_3_(Anonymous_numExpr_3_ object)
      {
        return createAnonymous_numExpr_3_Adapter();
      }
      @Override
      public Adapter caseAnonymous_numExpr_4_(Anonymous_numExpr_4_ object)
      {
        return createAnonymous_numExpr_4_Adapter();
      }
      @Override
      public Adapter caseEqualityOp_(EqualityOp_ object)
      {
        return createEqualityOp_Adapter();
      }
      @Override
      public Adapter caseEqualsOp_(EqualsOp_ object)
      {
        return createEqualsOp_Adapter();
      }
      @Override
      public Adapter caseNotequalsOp_(NotequalsOp_ object)
      {
        return createNotequalsOp_Adapter();
      }
      @Override
      public Adapter caseOrdinalOp_(OrdinalOp_ object)
      {
        return createOrdinalOp_Adapter();
      }
      @Override
      public Adapter caseGreaterOp_(GreaterOp_ object)
      {
        return createGreaterOp_Adapter();
      }
      @Override
      public Adapter caseLessOp_(LessOp_ object)
      {
        return createLessOp_Adapter();
      }
      @Override
      public Adapter caseMoreOp_(MoreOp_ object)
      {
        return createMoreOp_Adapter();
      }
      @Override
      public Adapter caseSmallerOp_(SmallerOp_ object)
      {
        return createSmallerOp_Adapter();
      }
      @Override
      public Adapter casePosition_(Position_ object)
      {
        return createPosition_Adapter();
      }
      @Override
      public Adapter caseElementPosition_(ElementPosition_ object)
      {
        return createElementPosition_Adapter();
      }
      @Override
      public Adapter caseAssociationPosition_(AssociationPosition_ object)
      {
        return createAssociationPosition_Adapter();
      }
      @Override
      public Adapter caseCoordinate_(Coordinate_ object)
      {
        return createCoordinate_Adapter();
      }
      @Override
      public Adapter caseDisplayColor_(DisplayColor_ object)
      {
        return createDisplayColor_Adapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Program_ <em>Program </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Program_
   * @generated
   */
  public Adapter createProgram_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_program_1_ <em>Anonymous program 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_program_1_
   * @generated
   */
  public Adapter createAnonymous_program_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Directive_ <em>Directive </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Directive_
   * @generated
   */
  public Adapter createDirective_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Glossary_ <em>Glossary </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Glossary_
   * @generated
   */
  public Adapter createGlossary_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Word_ <em>Word </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Word_
   * @generated
   */
  public Adapter createWord_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Strictness_ <em>Strictness </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Strictness_
   * @generated
   */
  public Adapter createStrictness_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_strictness_1_ <em>Anonymous strictness 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_strictness_1_
   * @generated
   */
  public Adapter createAnonymous_strictness_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Generate_ <em>Generate </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Generate_
   * @generated
   */
  public Adapter createGenerate_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Generate_path_ <em>Generate path </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Generate_path_
   * @generated
   */
  public Adapter createGenerate_path_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UseStatement_ <em>Use Statement </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UseStatement_
   * @generated
   */
  public Adapter createUseStatement_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Namespace_ <em>Namespace </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Namespace_
   * @generated
   */
  public Adapter createNamespace_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Entity_ <em>Entity </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Entity_
   * @generated
   */
  public Adapter createEntity_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Comment_ <em>Comment </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Comment_
   * @generated
   */
  public Adapter createComment_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InlineComment_ <em>Inline Comment </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InlineComment_
   * @generated
   */
  public Adapter createInlineComment_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.MultilineComment_ <em>Multiline Comment </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.MultilineComment_
   * @generated
   */
  public Adapter createMultilineComment_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Debug_ <em>Debug </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Debug_
   * @generated
   */
  public Adapter createDebug_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Abstract_ <em>Abstract </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Abstract_
   * @generated
   */
  public Adapter createAbstract_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ClassDefinition_ <em>Class Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ClassDefinition_
   * @generated
   */
  public Adapter createClassDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ExternalDefinition_ <em>External Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ExternalDefinition_
   * @generated
   */
  public Adapter createExternalDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InterfaceDefinition_ <em>Interface Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InterfaceDefinition_
   * @generated
   */
  public Adapter createInterfaceDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationDefinition_ <em>Association Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationDefinition_
   * @generated
   */
  public Adapter createAssociationDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationClassDefinition_ <em>Association Class Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationClassDefinition_
   * @generated
   */
  public Adapter createAssociationClassDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ClassContent_ <em>Class Content </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ClassContent_
   * @generated
   */
  public Adapter createClassContent_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationClassContent_ <em>Association Class Content </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationClassContent_
   * @generated
   */
  public Adapter createAssociationClassContent_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InterfaceBody_ <em>Interface Body </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InterfaceBody_
   * @generated
   */
  public Adapter createInterfaceBody_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InterfaceMemberDeclaration_ <em>Interface Member Declaration </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InterfaceMemberDeclaration_
   * @generated
   */
  public Adapter createInterfaceMemberDeclaration_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ConstantDeclaration_ <em>Constant Declaration </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ConstantDeclaration_
   * @generated
   */
  public Adapter createConstantDeclaration_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_constantDeclaration_1_ <em>Anonymous constant Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_constantDeclaration_1_
   * @generated
   */
  public Adapter createAnonymous_constantDeclaration_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_constantDeclaration_2_ <em>Anonymous constant Declaration 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_constantDeclaration_2_
   * @generated
   */
  public Adapter createAnonymous_constantDeclaration_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.MoreCode_ <em>More Code </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.MoreCode_
   * @generated
   */
  public Adapter createMoreCode_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_moreCode_1_ <em>Anonymous more Code 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_moreCode_1_
   * @generated
   */
  public Adapter createAnonymous_moreCode_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.CodeLangs_ <em>Code Langs </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.CodeLangs_
   * @generated
   */
  public Adapter createCodeLangs_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_codeLangs_1_ <em>Anonymous code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_codeLangs_1_
   * @generated
   */
  public Adapter createAnonymous_codeLangs_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.CodeLang_ <em>Code Lang </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.CodeLang_
   * @generated
   */
  public Adapter createCodeLang_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.MethodBody_ <em>Method Body </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.MethodBody_
   * @generated
   */
  public Adapter createMethodBody_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_methodBody_1_ <em>Anonymous method Body 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_methodBody_1_
   * @generated
   */
  public Adapter createAnonymous_methodBody_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_methodBody_2_ <em>Anonymous method Body 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_methodBody_2_
   * @generated
   */
  public Adapter createAnonymous_methodBody_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ConcreteMethodDeclaration_ <em>Concrete Method Declaration </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ConcreteMethodDeclaration_
   * @generated
   */
  public Adapter createConcreteMethodDeclaration_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_ <em>Anonymous concrete Method Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_
   * @generated
   */
  public Adapter createAnonymous_concreteMethodDeclaration_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_2_ <em>Anonymous concrete Method Declaration 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_concreteMethodDeclaration_2_
   * @generated
   */
  public Adapter createAnonymous_concreteMethodDeclaration_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AbstractMethodDeclaration_ <em>Abstract Method Declaration </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AbstractMethodDeclaration_
   * @generated
   */
  public Adapter createAbstractMethodDeclaration_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.MethodDeclarator_ <em>Method Declarator </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.MethodDeclarator_
   * @generated
   */
  public Adapter createMethodDeclarator_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ParameterList_ <em>Parameter List </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ParameterList_
   * @generated
   */
  public Adapter createParameterList_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_parameterList_1_ <em>Anonymous parameter List 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_parameterList_1_
   * @generated
   */
  public Adapter createAnonymous_parameterList_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Parameter_ <em>Parameter </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Parameter_
   * @generated
   */
  public Adapter createParameter_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_parameter_1_ <em>Anonymous parameter 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_parameter_1_
   * @generated
   */
  public Adapter createAnonymous_parameter_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Association_ <em>Association </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Association_
   * @generated
   */
  public Adapter createAssociation_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SymmetricReflexiveAssociation_ <em>Symmetric Reflexive Association </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SymmetricReflexiveAssociation_
   * @generated
   */
  public Adapter createSymmetricReflexiveAssociation_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InlineAssociation_ <em>Inline Association </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InlineAssociation_
   * @generated
   */
  public Adapter createInlineAssociation_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InlineAssociationEnd_ <em>Inline Association End </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InlineAssociationEnd_
   * @generated
   */
  public Adapter createInlineAssociationEnd_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SingleAssociationEnd_ <em>Single Association End </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SingleAssociationEnd_
   * @generated
   */
  public Adapter createSingleAssociationEnd_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationEnd_ <em>Association End </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationEnd_
   * @generated
   */
  public Adapter createAssociationEnd_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Multiplicity_ <em>Multiplicity </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Multiplicity_
   * @generated
   */
  public Adapter createMultiplicity_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.IsSorted_ <em>Is Sorted </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.IsSorted_
   * @generated
   */
  public Adapter createIsSorted_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Attribute_ <em>Attribute </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Attribute_
   * @generated
   */
  public Adapter createAttribute_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SimpleAttribute_ <em>Simple Attribute </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SimpleAttribute_
   * @generated
   */
  public Adapter createSimpleAttribute_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AutouniqueAttribute_ <em>Autounique Attribute </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AutouniqueAttribute_
   * @generated
   */
  public Adapter createAutouniqueAttribute_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.DerivedAttribute_ <em>Derived Attribute </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.DerivedAttribute_
   * @generated
   */
  public Adapter createDerivedAttribute_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_derivedAttribute_1_ <em>Anonymous derived Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_1_
   * @generated
   */
  public Adapter createAnonymous_derivedAttribute_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_derivedAttribute_2_ <em>Anonymous derived Attribute 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_2_
   * @generated
   */
  public Adapter createAnonymous_derivedAttribute_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_derivedAttribute_3_ <em>Anonymous derived Attribute 3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_3_
   * @generated
   */
  public Adapter createAnonymous_derivedAttribute_3_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ComplexAttribute_ <em>Complex Attribute </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ComplexAttribute_
   * @generated
   */
  public Adapter createComplexAttribute_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_complexAttribute_1_ <em>Anonymous complex Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_complexAttribute_1_
   * @generated
   */
  public Adapter createAnonymous_complexAttribute_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_complexAttribute_2_ <em>Anonymous complex Attribute 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_complexAttribute_2_
   * @generated
   */
  public Adapter createAnonymous_complexAttribute_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Key_ <em>Key </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Key_
   * @generated
   */
  public Adapter createKey_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_key_1_ <em>Anonymous key 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_key_1_
   * @generated
   */
  public Adapter createAnonymous_key_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Depend_ <em>Depend </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Depend_
   * @generated
   */
  public Adapter createDepend_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ExtraCode_ <em>Extra Code </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ExtraCode_
   * @generated
   */
  public Adapter createExtraCode_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SoftwarePattern_ <em>Software Pattern </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SoftwarePattern_
   * @generated
   */
  public Adapter createSoftwarePattern_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.IsA_ <em>Is A</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.IsA_
   * @generated
   */
  public Adapter createIsA_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SingleIsA_ <em>Single Is A</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SingleIsA_
   * @generated
   */
  public Adapter createSingleIsA_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_singleIsA_1_ <em>Anonymous single Is A1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_singleIsA_1_
   * @generated
   */
  public Adapter createAnonymous_singleIsA_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.MultipleIsA_ <em>Multiple Is A</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.MultipleIsA_
   * @generated
   */
  public Adapter createMultipleIsA_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_multipleIsA_1_ <em>Anonymous multiple Is A1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_multipleIsA_1_
   * @generated
   */
  public Adapter createAnonymous_multipleIsA_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Singleton_ <em>Singleton </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Singleton_
   * @generated
   */
  public Adapter createSingleton_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Immutable_ <em>Immutable </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Immutable_
   * @generated
   */
  public Adapter createImmutable_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.KeyDefinition_ <em>Key Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.KeyDefinition_
   * @generated
   */
  public Adapter createKeyDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.CodeInjection_ <em>Code Injection </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.CodeInjection_
   * @generated
   */
  public Adapter createCodeInjection_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.BeforeCode_ <em>Before Code </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.BeforeCode_
   * @generated
   */
  public Adapter createBeforeCode_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_beforeCode_1_ <em>Anonymous before Code 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_beforeCode_1_
   * @generated
   */
  public Adapter createAnonymous_beforeCode_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_beforeCode_2_ <em>Anonymous before Code 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_beforeCode_2_
   * @generated
   */
  public Adapter createAnonymous_beforeCode_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AfterCode_ <em>After Code </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AfterCode_
   * @generated
   */
  public Adapter createAfterCode_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_afterCode_1_ <em>Anonymous after Code 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_afterCode_1_
   * @generated
   */
  public Adapter createAnonymous_afterCode_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_afterCode_2_ <em>Anonymous after Code 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_afterCode_2_
   * @generated
   */
  public Adapter createAnonymous_afterCode_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StateMachineDefinition_ <em>State Machine Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StateMachineDefinition_
   * @generated
   */
  public Adapter createStateMachineDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StateMachine_ <em>State Machine </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StateMachine_
   * @generated
   */
  public Adapter createStateMachine_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ActiveDefinition_ <em>Active Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ActiveDefinition_
   * @generated
   */
  public Adapter createActiveDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InlineStateMachine_ <em>Inline State Machine </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InlineStateMachine_
   * @generated
   */
  public Adapter createInlineStateMachine_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_inlineStateMachine_1_ <em>Anonymous inline State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_inlineStateMachine_1_
   * @generated
   */
  public Adapter createAnonymous_inlineStateMachine_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ReferencedStateMachine_ <em>Referenced State Machine </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ReferencedStateMachine_
   * @generated
   */
  public Adapter createReferencedStateMachine_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ExtendedStateMachine_ <em>Extended State Machine </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ExtendedStateMachine_
   * @generated
   */
  public Adapter createExtendedStateMachine_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_extendedStateMachine_1_ <em>Anonymous extended State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_extendedStateMachine_1_
   * @generated
   */
  public Adapter createAnonymous_extendedStateMachine_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Enum_ <em>Enum </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Enum_
   * @generated
   */
  public Adapter createEnum_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_enum_1_ <em>Anonymous enum 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_enum_1_
   * @generated
   */
  public Adapter createAnonymous_enum_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.State_ <em>State </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.State_
   * @generated
   */
  public Adapter createState_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_state_1_ <em>Anonymous state 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_state_1_
   * @generated
   */
  public Adapter createAnonymous_state_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StateInternal_ <em>State Internal </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StateInternal_
   * @generated
   */
  public Adapter createStateInternal_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StateEntity_ <em>State Entity </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StateEntity_
   * @generated
   */
  public Adapter createStateEntity_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AutoTransition_ <em>Auto Transition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AutoTransition_
   * @generated
   */
  public Adapter createAutoTransition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AutoTransitionBlock_ <em>Auto Transition Block </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AutoTransitionBlock_
   * @generated
   */
  public Adapter createAutoTransitionBlock_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Transition_ <em>Transition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Transition_
   * @generated
   */
  public Adapter createTransition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.EventDefinition_ <em>Event Definition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.EventDefinition_
   * @generated
   */
  public Adapter createEventDefinition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_eventDefinition_1_ <em>Anonymous event Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_eventDefinition_1_
   * @generated
   */
  public Adapter createAnonymous_eventDefinition_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AfterEveryEvent_ <em>After Every Event </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AfterEveryEvent_
   * @generated
   */
  public Adapter createAfterEveryEvent_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AfterEvent_ <em>After Event </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AfterEvent_
   * @generated
   */
  public Adapter createAfterEvent_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Action_ <em>Action </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Action_
   * @generated
   */
  public Adapter createAction_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_action_1_ <em>Anonymous action 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_action_1_
   * @generated
   */
  public Adapter createAnonymous_action_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_action_2_ <em>Anonymous action 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_action_2_
   * @generated
   */
  public Adapter createAnonymous_action_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.EntryOrExitAction_ <em>Entry Or Exit Action </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.EntryOrExitAction_
   * @generated
   */
  public Adapter createEntryOrExitAction_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_entryOrExitAction_1_ <em>Anonymous entry Or Exit Action 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_entryOrExitAction_1_
   * @generated
   */
  public Adapter createAnonymous_entryOrExitAction_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_entryOrExitAction_2_ <em>Anonymous entry Or Exit Action 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_entryOrExitAction_2_
   * @generated
   */
  public Adapter createAnonymous_entryOrExitAction_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Activity_ <em>Activity </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Activity_
   * @generated
   */
  public Adapter createActivity_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_activity_1_ <em>Anonymous activity 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_activity_1_
   * @generated
   */
  public Adapter createAnonymous_activity_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_activity_2_ <em>Anonymous activity 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_activity_2_
   * @generated
   */
  public Adapter createAnonymous_activity_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.MoreGuards_ <em>More Guards </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.MoreGuards_
   * @generated
   */
  public Adapter createMoreGuards_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_moreGuards_1_ <em>Anonymous more Guards 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_moreGuards_1_
   * @generated
   */
  public Adapter createAnonymous_moreGuards_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Guard_ <em>Guard </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Guard_
   * @generated
   */
  public Adapter createGuard_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_guard_1_ <em>Anonymous guard 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_guard_1_
   * @generated
   */
  public Adapter createAnonymous_guard_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_guard_2_ <em>Anonymous guard 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_guard_2_
   * @generated
   */
  public Adapter createAnonymous_guard_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceType_ <em>Trace Type </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceType_
   * @generated
   */
  public Adapter createTraceType_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_traceType_1_ <em>Anonymous trace Type 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_traceType_1_
   * @generated
   */
  public Adapter createAnonymous_traceType_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_traceType_2_ <em>Anonymous trace Type 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_traceType_2_
   * @generated
   */
  public Adapter createAnonymous_traceType_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Trace_ <em>Trace </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Trace_
   * @generated
   */
  public Adapter createTrace_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceDirective_ <em>Trace Directive </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceDirective_
   * @generated
   */
  public Adapter createTraceDirective_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_traceDirective_1_ <em>Anonymous trace Directive 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_
   * @generated
   */
  public Adapter createAnonymous_traceDirective_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceItem_ <em>Trace Item </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceItem_
   * @generated
   */
  public Adapter createTraceItem_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceEntity_ <em>Trace Entity </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceEntity_
   * @generated
   */
  public Adapter createTraceEntity_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_traceEntity_1_ <em>Anonymous trace Entity 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_traceEntity_1_
   * @generated
   */
  public Adapter createAnonymous_traceEntity_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceOptions_ <em>Trace Options </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceOptions_
   * @generated
   */
  public Adapter createTraceOptions_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_traceOptions_1_ <em>Anonymous trace Options 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_traceOptions_1_
   * @generated
   */
  public Adapter createAnonymous_traceOptions_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceOption_ <em>Trace Option </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceOption_
   * @generated
   */
  public Adapter createTraceOption_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.PreOrPostCondition_ <em>Pre Or Post Condition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.PreOrPostCondition_
   * @generated
   */
  public Adapter createPreOrPostCondition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ExecuteClause_ <em>Execute Clause </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ExecuteClause_
   * @generated
   */
  public Adapter createExecuteClause_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceWhen_ <em>Trace When </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceWhen_
   * @generated
   */
  public Adapter createTraceWhen_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceFor_ <em>Trace For </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceFor_
   * @generated
   */
  public Adapter createTraceFor_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceLevel_ <em>Trace Level </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceLevel_
   * @generated
   */
  public Adapter createTraceLevel_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TracePeriod_ <em>Trace Period </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TracePeriod_
   * @generated
   */
  public Adapter createTracePeriod_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceDuring_ <em>Trace During </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceDuring_
   * @generated
   */
  public Adapter createTraceDuring_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceRecord_ <em>Trace Record </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceRecord_
   * @generated
   */
  public Adapter createTraceRecord_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.RecordEntity_ <em>Record Entity </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.RecordEntity_
   * @generated
   */
  public Adapter createRecordEntity_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_recordEntity_2_ <em>Anonymous record Entity 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_recordEntity_2_
   * @generated
   */
  public Adapter createAnonymous_recordEntity_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceCondition_ <em>Trace Condition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceCondition_
   * @generated
   */
  public Adapter createTraceCondition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ConditionRHS_ <em>Condition RHS </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ConditionRHS_
   * @generated
   */
  public Adapter createConditionRHS_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceCase_ <em>Trace Case </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceCase_
   * @generated
   */
  public Adapter createTraceCase_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceCaseDef_ <em>Trace Case Def </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceCaseDef_
   * @generated
   */
  public Adapter createTraceCaseDef_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceCaseActivation_ <em>Trace Case Activation </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceCaseActivation_
   * @generated
   */
  public Adapter createTraceCaseActivation_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceCaseDeactivation_ <em>Trace Case Deactivation </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceCaseDeactivation_
   * @generated
   */
  public Adapter createTraceCaseDeactivation_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.DeActivateFor_ <em>De Activate For </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.DeActivateFor_
   * @generated
   */
  public Adapter createDeActivateFor_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Precondition_ <em>Precondition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Precondition_
   * @generated
   */
  public Adapter createPrecondition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Postcondition_ <em>Postcondition </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Postcondition_
   * @generated
   */
  public Adapter createPostcondition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Invariant_ <em>Invariant </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Invariant_
   * @generated
   */
  public Adapter createInvariant_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_invariant_1_ <em>Anonymous invariant 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_invariant_1_
   * @generated
   */
  public Adapter createAnonymous_invariant_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_invariant_2_ <em>Anonymous invariant 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_invariant_2_
   * @generated
   */
  public Adapter createAnonymous_invariant_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ConstraintToken_ <em>Constraint Token </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ConstraintToken_
   * @generated
   */
  public Adapter createConstraintToken_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Constraint_ <em>Constraint </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Constraint_
   * @generated
   */
  public Adapter createConstraint_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_constraint_1_ <em>Anonymous constraint 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_constraint_1_
   * @generated
   */
  public Adapter createAnonymous_constraint_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.NegativeConstraint_ <em>Negative Constraint </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.NegativeConstraint_
   * @generated
   */
  public Adapter createNegativeConstraint_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ConstraintBody_ <em>Constraint Body </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ConstraintBody_
   * @generated
   */
  public Adapter createConstraintBody_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_constraintBody_1_ <em>Anonymous constraint Body 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_constraintBody_1_
   * @generated
   */
  public Adapter createAnonymous_constraintBody_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.LinkingOp_ <em>Linking Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.LinkingOp_
   * @generated
   */
  public Adapter createLinkingOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_linkingOp_1_ <em>Anonymous linking Op 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_linkingOp_1_
   * @generated
   */
  public Adapter createAnonymous_linkingOp_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_linkingOp_2_ <em>Anonymous linking Op 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_linkingOp_2_
   * @generated
   */
  public Adapter createAnonymous_linkingOp_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_linkingOp_3_ <em>Anonymous linking Op 3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_linkingOp_3_
   * @generated
   */
  public Adapter createAnonymous_linkingOp_3_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ConstraintExpr_ <em>Constraint Expr </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ConstraintExpr_
   * @generated
   */
  public Adapter createConstraintExpr_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_constraintExpr_1_ <em>Anonymous constraint Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_constraintExpr_1_
   * @generated
   */
  public Adapter createAnonymous_constraintExpr_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.CompoundExpr_ <em>Compound Expr </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.CompoundExpr_
   * @generated
   */
  public Adapter createCompoundExpr_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.BoolExpr_ <em>Bool Expr </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.BoolExpr_
   * @generated
   */
  public Adapter createBoolExpr_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StringExpr_ <em>String Expr </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StringExpr_
   * @generated
   */
  public Adapter createStringExpr_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StringLit_ <em>String Lit </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StringLit_
   * @generated
   */
  public Adapter createStringLit_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.GenExpr_ <em>Gen Expr </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.GenExpr_
   * @generated
   */
  public Adapter createGenExpr_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_genExpr_1_ <em>Anonymous gen Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_genExpr_1_
   * @generated
   */
  public Adapter createAnonymous_genExpr_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_genExpr_2_ <em>Anonymous gen Expr 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_genExpr_2_
   * @generated
   */
  public Adapter createAnonymous_genExpr_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.NumExpr_ <em>Num Expr </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.NumExpr_
   * @generated
   */
  public Adapter createNumExpr_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_numExpr_1_ <em>Anonymous num Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_numExpr_1_
   * @generated
   */
  public Adapter createAnonymous_numExpr_1_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_numExpr_2_ <em>Anonymous num Expr 2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_numExpr_2_
   * @generated
   */
  public Adapter createAnonymous_numExpr_2_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_numExpr_3_ <em>Anonymous num Expr 3</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_numExpr_3_
   * @generated
   */
  public Adapter createAnonymous_numExpr_3_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Anonymous_numExpr_4_ <em>Anonymous num Expr 4</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Anonymous_numExpr_4_
   * @generated
   */
  public Adapter createAnonymous_numExpr_4_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.EqualityOp_ <em>Equality Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.EqualityOp_
   * @generated
   */
  public Adapter createEqualityOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.EqualsOp_ <em>Equals Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.EqualsOp_
   * @generated
   */
  public Adapter createEqualsOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.NotequalsOp_ <em>Notequals Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.NotequalsOp_
   * @generated
   */
  public Adapter createNotequalsOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.OrdinalOp_ <em>Ordinal Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.OrdinalOp_
   * @generated
   */
  public Adapter createOrdinalOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.GreaterOp_ <em>Greater Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.GreaterOp_
   * @generated
   */
  public Adapter createGreaterOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.LessOp_ <em>Less Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.LessOp_
   * @generated
   */
  public Adapter createLessOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.MoreOp_ <em>More Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.MoreOp_
   * @generated
   */
  public Adapter createMoreOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SmallerOp_ <em>Smaller Op </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SmallerOp_
   * @generated
   */
  public Adapter createSmallerOp_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Position_ <em>Position </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Position_
   * @generated
   */
  public Adapter createPosition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ElementPosition_ <em>Element Position </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ElementPosition_
   * @generated
   */
  public Adapter createElementPosition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationPosition_ <em>Association Position </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationPosition_
   * @generated
   */
  public Adapter createAssociationPosition_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Coordinate_ <em>Coordinate </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Coordinate_
   * @generated
   */
  public Adapter createCoordinate_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.DisplayColor_ <em>Display Color </em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.DisplayColor_
   * @generated
   */
  public Adapter createDisplayColor_Adapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //UmpleAdapterFactory
