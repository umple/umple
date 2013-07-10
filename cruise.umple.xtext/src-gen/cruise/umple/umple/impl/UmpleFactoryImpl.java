/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UmpleFactoryImpl extends EFactoryImpl implements UmpleFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static UmpleFactory init()
  {
    try
    {
      UmpleFactory theUmpleFactory = (UmpleFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.umple.cruise/Umple"); 
      if (theUmpleFactory != null)
      {
        return theUmpleFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UmpleFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case UmplePackage.MODEL: return createModel();
      case UmplePackage.PROGRAM_: return createProgram_();
      case UmplePackage.ANONYMOUS_PROGRAM_1: return createAnonymous_program_1_();
      case UmplePackage.DIRECTIVE_: return createDirective_();
      case UmplePackage.GLOSSARY_: return createGlossary_();
      case UmplePackage.WORD_: return createWord_();
      case UmplePackage.STRICTNESS_: return createStrictness_();
      case UmplePackage.ANONYMOUS_STRICTNESS_1: return createAnonymous_strictness_1_();
      case UmplePackage.GENERATE_: return createGenerate_();
      case UmplePackage.GENERATE_PATH_: return createGenerate_path_();
      case UmplePackage.USE_STATEMENT_: return createUseStatement_();
      case UmplePackage.NAMESPACE_: return createNamespace_();
      case UmplePackage.ENTITY_: return createEntity_();
      case UmplePackage.COMMENT_: return createComment_();
      case UmplePackage.INLINE_COMMENT_: return createInlineComment_();
      case UmplePackage.MULTILINE_COMMENT_: return createMultilineComment_();
      case UmplePackage.DEBUG_: return createDebug_();
      case UmplePackage.ABSTRACT_: return createAbstract_();
      case UmplePackage.CLASS_DEFINITION_: return createClassDefinition_();
      case UmplePackage.EXTERNAL_DEFINITION_: return createExternalDefinition_();
      case UmplePackage.INTERFACE_DEFINITION_: return createInterfaceDefinition_();
      case UmplePackage.ASSOCIATION_DEFINITION_: return createAssociationDefinition_();
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION_: return createAssociationClassDefinition_();
      case UmplePackage.CLASS_CONTENT_: return createClassContent_();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT_: return createAssociationClassContent_();
      case UmplePackage.INTERFACE_BODY_: return createInterfaceBody_();
      case UmplePackage.INTERFACE_MEMBER_DECLARATION_: return createInterfaceMemberDeclaration_();
      case UmplePackage.CONSTANT_DECLARATION_: return createConstantDeclaration_();
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1: return createAnonymous_constantDeclaration_1_();
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_2: return createAnonymous_constantDeclaration_2_();
      case UmplePackage.MORE_CODE_: return createMoreCode_();
      case UmplePackage.ANONYMOUS_MORE_CODE_1: return createAnonymous_moreCode_1_();
      case UmplePackage.CODE_LANGS_: return createCodeLangs_();
      case UmplePackage.ANONYMOUS_CODE_LANGS_1: return createAnonymous_codeLangs_1_();
      case UmplePackage.CODE_LANG_: return createCodeLang_();
      case UmplePackage.METHOD_BODY_: return createMethodBody_();
      case UmplePackage.ANONYMOUS_METHOD_BODY_1: return createAnonymous_methodBody_1_();
      case UmplePackage.ANONYMOUS_METHOD_BODY_2: return createAnonymous_methodBody_2_();
      case UmplePackage.CONCRETE_METHOD_DECLARATION_: return createConcreteMethodDeclaration_();
      case UmplePackage.ANONYMOUS_CONCRETE_METHOD_DECLARATION_1: return createAnonymous_concreteMethodDeclaration_1_();
      case UmplePackage.ANONYMOUS_CONCRETE_METHOD_DECLARATION_2: return createAnonymous_concreteMethodDeclaration_2_();
      case UmplePackage.ABSTRACT_METHOD_DECLARATION_: return createAbstractMethodDeclaration_();
      case UmplePackage.METHOD_DECLARATOR_: return createMethodDeclarator_();
      case UmplePackage.PARAMETER_LIST_: return createParameterList_();
      case UmplePackage.ANONYMOUS_PARAMETER_LIST_1: return createAnonymous_parameterList_1_();
      case UmplePackage.PARAMETER_: return createParameter_();
      case UmplePackage.ANONYMOUS_PARAMETER_1: return createAnonymous_parameter_1_();
      case UmplePackage.ASSOCIATION_: return createAssociation_();
      case UmplePackage.SYMMETRIC_REFLEXIVE_ASSOCIATION_: return createSymmetricReflexiveAssociation_();
      case UmplePackage.INLINE_ASSOCIATION_: return createInlineAssociation_();
      case UmplePackage.INLINE_ASSOCIATION_END_: return createInlineAssociationEnd_();
      case UmplePackage.SINGLE_ASSOCIATION_END_: return createSingleAssociationEnd_();
      case UmplePackage.ASSOCIATION_END_: return createAssociationEnd_();
      case UmplePackage.MULTIPLICITY_: return createMultiplicity_();
      case UmplePackage.IS_SORTED_: return createIsSorted_();
      case UmplePackage.ATTRIBUTE_: return createAttribute_();
      case UmplePackage.SIMPLE_ATTRIBUTE_: return createSimpleAttribute_();
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE_: return createAutouniqueAttribute_();
      case UmplePackage.DERIVED_ATTRIBUTE_: return createDerivedAttribute_();
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_1: return createAnonymous_derivedAttribute_1_();
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2: return createAnonymous_derivedAttribute_2_();
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_3: return createAnonymous_derivedAttribute_3_();
      case UmplePackage.COMPLEX_ATTRIBUTE_: return createComplexAttribute_();
      case UmplePackage.ANONYMOUS_COMPLEX_ATTRIBUTE_1: return createAnonymous_complexAttribute_1_();
      case UmplePackage.ANONYMOUS_COMPLEX_ATTRIBUTE_2: return createAnonymous_complexAttribute_2_();
      case UmplePackage.KEY_: return createKey_();
      case UmplePackage.ANONYMOUS_KEY_1: return createAnonymous_key_1_();
      case UmplePackage.DEPEND_: return createDepend_();
      case UmplePackage.EXTRA_CODE_: return createExtraCode_();
      case UmplePackage.SOFTWARE_PATTERN_: return createSoftwarePattern_();
      case UmplePackage.IS_A: return createIsA_();
      case UmplePackage.SINGLE_IS_A: return createSingleIsA_();
      case UmplePackage.ANONYMOUS_SINGLE_IS_A1: return createAnonymous_singleIsA_1_();
      case UmplePackage.MULTIPLE_IS_A: return createMultipleIsA_();
      case UmplePackage.ANONYMOUS_MULTIPLE_IS_A1: return createAnonymous_multipleIsA_1_();
      case UmplePackage.SINGLETON_: return createSingleton_();
      case UmplePackage.IMMUTABLE_: return createImmutable_();
      case UmplePackage.KEY_DEFINITION_: return createKeyDefinition_();
      case UmplePackage.CODE_INJECTION_: return createCodeInjection_();
      case UmplePackage.BEFORE_CODE_: return createBeforeCode_();
      case UmplePackage.ANONYMOUS_BEFORE_CODE_1: return createAnonymous_beforeCode_1_();
      case UmplePackage.ANONYMOUS_BEFORE_CODE_2: return createAnonymous_beforeCode_2_();
      case UmplePackage.AFTER_CODE_: return createAfterCode_();
      case UmplePackage.ANONYMOUS_AFTER_CODE_1: return createAnonymous_afterCode_1_();
      case UmplePackage.ANONYMOUS_AFTER_CODE_2: return createAnonymous_afterCode_2_();
      case UmplePackage.STATE_MACHINE_DEFINITION_: return createStateMachineDefinition_();
      case UmplePackage.STATE_MACHINE_: return createStateMachine_();
      case UmplePackage.ACTIVE_DEFINITION_: return createActiveDefinition_();
      case UmplePackage.INLINE_STATE_MACHINE_: return createInlineStateMachine_();
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1: return createAnonymous_inlineStateMachine_1_();
      case UmplePackage.REFERENCED_STATE_MACHINE_: return createReferencedStateMachine_();
      case UmplePackage.EXTENDED_STATE_MACHINE_: return createExtendedStateMachine_();
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1: return createAnonymous_extendedStateMachine_1_();
      case UmplePackage.ENUM_: return createEnum_();
      case UmplePackage.ANONYMOUS_ENUM_1: return createAnonymous_enum_1_();
      case UmplePackage.STATE_: return createState_();
      case UmplePackage.ANONYMOUS_STATE_1: return createAnonymous_state_1_();
      case UmplePackage.STATE_INTERNAL_: return createStateInternal_();
      case UmplePackage.STATE_ENTITY_: return createStateEntity_();
      case UmplePackage.AUTO_TRANSITION_: return createAutoTransition_();
      case UmplePackage.AUTO_TRANSITION_BLOCK_: return createAutoTransitionBlock_();
      case UmplePackage.TRANSITION_: return createTransition_();
      case UmplePackage.EVENT_DEFINITION_: return createEventDefinition_();
      case UmplePackage.ANONYMOUS_EVENT_DEFINITION_1: return createAnonymous_eventDefinition_1_();
      case UmplePackage.AFTER_EVERY_EVENT_: return createAfterEveryEvent_();
      case UmplePackage.AFTER_EVENT_: return createAfterEvent_();
      case UmplePackage.ACTION_: return createAction_();
      case UmplePackage.ANONYMOUS_ACTION_1: return createAnonymous_action_1_();
      case UmplePackage.ANONYMOUS_ACTION_2: return createAnonymous_action_2_();
      case UmplePackage.ENTRY_OR_EXIT_ACTION_: return createEntryOrExitAction_();
      case UmplePackage.ANONYMOUS_ENTRY_OR_EXIT_ACTION_1: return createAnonymous_entryOrExitAction_1_();
      case UmplePackage.ANONYMOUS_ENTRY_OR_EXIT_ACTION_2: return createAnonymous_entryOrExitAction_2_();
      case UmplePackage.ACTIVITY_: return createActivity_();
      case UmplePackage.ANONYMOUS_ACTIVITY_1: return createAnonymous_activity_1_();
      case UmplePackage.ANONYMOUS_ACTIVITY_2: return createAnonymous_activity_2_();
      case UmplePackage.MORE_GUARDS_: return createMoreGuards_();
      case UmplePackage.ANONYMOUS_MORE_GUARDS_1: return createAnonymous_moreGuards_1_();
      case UmplePackage.GUARD_: return createGuard_();
      case UmplePackage.ANONYMOUS_GUARD_1: return createAnonymous_guard_1_();
      case UmplePackage.ANONYMOUS_GUARD_2: return createAnonymous_guard_2_();
      case UmplePackage.TRACE_TYPE_: return createTraceType_();
      case UmplePackage.ANONYMOUS_TRACE_TYPE_1: return createAnonymous_traceType_1_();
      case UmplePackage.ANONYMOUS_TRACE_TYPE_2: return createAnonymous_traceType_2_();
      case UmplePackage.TRACE_: return createTrace_();
      case UmplePackage.TRACE_DIRECTIVE_: return createTraceDirective_();
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1: return createAnonymous_traceDirective_1_();
      case UmplePackage.TRACE_ITEM_: return createTraceItem_();
      case UmplePackage.TRACE_ENTITY_: return createTraceEntity_();
      case UmplePackage.ANONYMOUS_TRACE_ENTITY_1: return createAnonymous_traceEntity_1_();
      case UmplePackage.TRACE_OPTIONS_: return createTraceOptions_();
      case UmplePackage.ANONYMOUS_TRACE_OPTIONS_1: return createAnonymous_traceOptions_1_();
      case UmplePackage.TRACE_OPTION_: return createTraceOption_();
      case UmplePackage.PRE_OR_POST_CONDITION_: return createPreOrPostCondition_();
      case UmplePackage.EXECUTE_CLAUSE_: return createExecuteClause_();
      case UmplePackage.TRACE_WHEN_: return createTraceWhen_();
      case UmplePackage.TRACE_FOR_: return createTraceFor_();
      case UmplePackage.TRACE_LEVEL_: return createTraceLevel_();
      case UmplePackage.TRACE_PERIOD_: return createTracePeriod_();
      case UmplePackage.TRACE_DURING_: return createTraceDuring_();
      case UmplePackage.TRACE_RECORD_: return createTraceRecord_();
      case UmplePackage.RECORD_ENTITY_: return createRecordEntity_();
      case UmplePackage.ANONYMOUS_RECORD_ENTITY_2: return createAnonymous_recordEntity_2_();
      case UmplePackage.TRACE_CONDITION_: return createTraceCondition_();
      case UmplePackage.CONDITION_RHS_: return createConditionRHS_();
      case UmplePackage.TRACE_CASE_: return createTraceCase_();
      case UmplePackage.TRACE_CASE_DEF_: return createTraceCaseDef_();
      case UmplePackage.TRACE_CASE_ACTIVATION_: return createTraceCaseActivation_();
      case UmplePackage.TRACE_CASE_DEACTIVATION_: return createTraceCaseDeactivation_();
      case UmplePackage.DE_ACTIVATE_FOR_: return createDeActivateFor_();
      case UmplePackage.PRECONDITION_: return createPrecondition_();
      case UmplePackage.POSTCONDITION_: return createPostcondition_();
      case UmplePackage.INVARIANT_: return createInvariant_();
      case UmplePackage.ANONYMOUS_INVARIANT_1: return createAnonymous_invariant_1_();
      case UmplePackage.ANONYMOUS_INVARIANT_2: return createAnonymous_invariant_2_();
      case UmplePackage.CONSTRAINT_TOKEN_: return createConstraintToken_();
      case UmplePackage.CONSTRAINT_: return createConstraint_();
      case UmplePackage.ANONYMOUS_CONSTRAINT_1: return createAnonymous_constraint_1_();
      case UmplePackage.NEGATIVE_CONSTRAINT_: return createNegativeConstraint_();
      case UmplePackage.CONSTRAINT_BODY_: return createConstraintBody_();
      case UmplePackage.ANONYMOUS_CONSTRAINT_BODY_1: return createAnonymous_constraintBody_1_();
      case UmplePackage.LINKING_OP_: return createLinkingOp_();
      case UmplePackage.ANONYMOUS_LINKING_OP_1: return createAnonymous_linkingOp_1_();
      case UmplePackage.ANONYMOUS_LINKING_OP_2: return createAnonymous_linkingOp_2_();
      case UmplePackage.ANONYMOUS_LINKING_OP_3: return createAnonymous_linkingOp_3_();
      case UmplePackage.CONSTRAINT_EXPR_: return createConstraintExpr_();
      case UmplePackage.ANONYMOUS_CONSTRAINT_EXPR_1: return createAnonymous_constraintExpr_1_();
      case UmplePackage.COMPOUND_EXPR_: return createCompoundExpr_();
      case UmplePackage.BOOL_EXPR_: return createBoolExpr_();
      case UmplePackage.STRING_EXPR_: return createStringExpr_();
      case UmplePackage.STRING_LIT_: return createStringLit_();
      case UmplePackage.GEN_EXPR_: return createGenExpr_();
      case UmplePackage.ANONYMOUS_GEN_EXPR_1: return createAnonymous_genExpr_1_();
      case UmplePackage.ANONYMOUS_GEN_EXPR_2: return createAnonymous_genExpr_2_();
      case UmplePackage.NUM_EXPR_: return createNumExpr_();
      case UmplePackage.ANONYMOUS_NUM_EXPR_1: return createAnonymous_numExpr_1_();
      case UmplePackage.ANONYMOUS_NUM_EXPR_2: return createAnonymous_numExpr_2_();
      case UmplePackage.ANONYMOUS_NUM_EXPR_3: return createAnonymous_numExpr_3_();
      case UmplePackage.ANONYMOUS_NUM_EXPR_4: return createAnonymous_numExpr_4_();
      case UmplePackage.EQUALITY_OP_: return createEqualityOp_();
      case UmplePackage.EQUALS_OP_: return createEqualsOp_();
      case UmplePackage.NOTEQUALS_OP_: return createNotequalsOp_();
      case UmplePackage.ORDINAL_OP_: return createOrdinalOp_();
      case UmplePackage.GREATER_OP_: return createGreaterOp_();
      case UmplePackage.LESS_OP_: return createLessOp_();
      case UmplePackage.MORE_OP_: return createMoreOp_();
      case UmplePackage.SMALLER_OP_: return createSmallerOp_();
      case UmplePackage.POSITION_: return createPosition_();
      case UmplePackage.ELEMENT_POSITION_: return createElementPosition_();
      case UmplePackage.ASSOCIATION_POSITION_: return createAssociationPosition_();
      case UmplePackage.COORDINATE_: return createCoordinate_();
      case UmplePackage.DISPLAY_COLOR_: return createDisplayColor_();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Program_ createProgram_()
  {
    Program_Impl program_ = new Program_Impl();
    return program_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_program_1_ createAnonymous_program_1_()
  {
    Anonymous_program_1_Impl anonymous_program_1_ = new Anonymous_program_1_Impl();
    return anonymous_program_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Directive_ createDirective_()
  {
    Directive_Impl directive_ = new Directive_Impl();
    return directive_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Glossary_ createGlossary_()
  {
    Glossary_Impl glossary_ = new Glossary_Impl();
    return glossary_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Word_ createWord_()
  {
    Word_Impl word_ = new Word_Impl();
    return word_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Strictness_ createStrictness_()
  {
    Strictness_Impl strictness_ = new Strictness_Impl();
    return strictness_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_strictness_1_ createAnonymous_strictness_1_()
  {
    Anonymous_strictness_1_Impl anonymous_strictness_1_ = new Anonymous_strictness_1_Impl();
    return anonymous_strictness_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Generate_ createGenerate_()
  {
    Generate_Impl generate_ = new Generate_Impl();
    return generate_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Generate_path_ createGenerate_path_()
  {
    Generate_path_Impl generate_path_ = new Generate_path_Impl();
    return generate_path_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UseStatement_ createUseStatement_()
  {
    UseStatement_Impl useStatement_ = new UseStatement_Impl();
    return useStatement_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Namespace_ createNamespace_()
  {
    Namespace_Impl namespace_ = new Namespace_Impl();
    return namespace_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity_ createEntity_()
  {
    Entity_Impl entity_ = new Entity_Impl();
    return entity_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Comment_ createComment_()
  {
    Comment_Impl comment_ = new Comment_Impl();
    return comment_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InlineComment_ createInlineComment_()
  {
    InlineComment_Impl inlineComment_ = new InlineComment_Impl();
    return inlineComment_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultilineComment_ createMultilineComment_()
  {
    MultilineComment_Impl multilineComment_ = new MultilineComment_Impl();
    return multilineComment_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Debug_ createDebug_()
  {
    Debug_Impl debug_ = new Debug_Impl();
    return debug_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Abstract_ createAbstract_()
  {
    Abstract_Impl abstract_ = new Abstract_Impl();
    return abstract_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDefinition_ createClassDefinition_()
  {
    ClassDefinition_Impl classDefinition_ = new ClassDefinition_Impl();
    return classDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalDefinition_ createExternalDefinition_()
  {
    ExternalDefinition_Impl externalDefinition_ = new ExternalDefinition_Impl();
    return externalDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfaceDefinition_ createInterfaceDefinition_()
  {
    InterfaceDefinition_Impl interfaceDefinition_ = new InterfaceDefinition_Impl();
    return interfaceDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationDefinition_ createAssociationDefinition_()
  {
    AssociationDefinition_Impl associationDefinition_ = new AssociationDefinition_Impl();
    return associationDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationClassDefinition_ createAssociationClassDefinition_()
  {
    AssociationClassDefinition_Impl associationClassDefinition_ = new AssociationClassDefinition_Impl();
    return associationClassDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassContent_ createClassContent_()
  {
    ClassContent_Impl classContent_ = new ClassContent_Impl();
    return classContent_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationClassContent_ createAssociationClassContent_()
  {
    AssociationClassContent_Impl associationClassContent_ = new AssociationClassContent_Impl();
    return associationClassContent_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfaceBody_ createInterfaceBody_()
  {
    InterfaceBody_Impl interfaceBody_ = new InterfaceBody_Impl();
    return interfaceBody_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InterfaceMemberDeclaration_ createInterfaceMemberDeclaration_()
  {
    InterfaceMemberDeclaration_Impl interfaceMemberDeclaration_ = new InterfaceMemberDeclaration_Impl();
    return interfaceMemberDeclaration_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantDeclaration_ createConstantDeclaration_()
  {
    ConstantDeclaration_Impl constantDeclaration_ = new ConstantDeclaration_Impl();
    return constantDeclaration_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_constantDeclaration_1_ createAnonymous_constantDeclaration_1_()
  {
    Anonymous_constantDeclaration_1_Impl anonymous_constantDeclaration_1_ = new Anonymous_constantDeclaration_1_Impl();
    return anonymous_constantDeclaration_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_constantDeclaration_2_ createAnonymous_constantDeclaration_2_()
  {
    Anonymous_constantDeclaration_2_Impl anonymous_constantDeclaration_2_ = new Anonymous_constantDeclaration_2_Impl();
    return anonymous_constantDeclaration_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MoreCode_ createMoreCode_()
  {
    MoreCode_Impl moreCode_ = new MoreCode_Impl();
    return moreCode_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_moreCode_1_ createAnonymous_moreCode_1_()
  {
    Anonymous_moreCode_1_Impl anonymous_moreCode_1_ = new Anonymous_moreCode_1_Impl();
    return anonymous_moreCode_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CodeLangs_ createCodeLangs_()
  {
    CodeLangs_Impl codeLangs_ = new CodeLangs_Impl();
    return codeLangs_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_codeLangs_1_ createAnonymous_codeLangs_1_()
  {
    Anonymous_codeLangs_1_Impl anonymous_codeLangs_1_ = new Anonymous_codeLangs_1_Impl();
    return anonymous_codeLangs_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CodeLang_ createCodeLang_()
  {
    CodeLang_Impl codeLang_ = new CodeLang_Impl();
    return codeLang_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodBody_ createMethodBody_()
  {
    MethodBody_Impl methodBody_ = new MethodBody_Impl();
    return methodBody_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_methodBody_1_ createAnonymous_methodBody_1_()
  {
    Anonymous_methodBody_1_Impl anonymous_methodBody_1_ = new Anonymous_methodBody_1_Impl();
    return anonymous_methodBody_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_methodBody_2_ createAnonymous_methodBody_2_()
  {
    Anonymous_methodBody_2_Impl anonymous_methodBody_2_ = new Anonymous_methodBody_2_Impl();
    return anonymous_methodBody_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConcreteMethodDeclaration_ createConcreteMethodDeclaration_()
  {
    ConcreteMethodDeclaration_Impl concreteMethodDeclaration_ = new ConcreteMethodDeclaration_Impl();
    return concreteMethodDeclaration_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_concreteMethodDeclaration_1_ createAnonymous_concreteMethodDeclaration_1_()
  {
    Anonymous_concreteMethodDeclaration_1_Impl anonymous_concreteMethodDeclaration_1_ = new Anonymous_concreteMethodDeclaration_1_Impl();
    return anonymous_concreteMethodDeclaration_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_concreteMethodDeclaration_2_ createAnonymous_concreteMethodDeclaration_2_()
  {
    Anonymous_concreteMethodDeclaration_2_Impl anonymous_concreteMethodDeclaration_2_ = new Anonymous_concreteMethodDeclaration_2_Impl();
    return anonymous_concreteMethodDeclaration_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractMethodDeclaration_ createAbstractMethodDeclaration_()
  {
    AbstractMethodDeclaration_Impl abstractMethodDeclaration_ = new AbstractMethodDeclaration_Impl();
    return abstractMethodDeclaration_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodDeclarator_ createMethodDeclarator_()
  {
    MethodDeclarator_Impl methodDeclarator_ = new MethodDeclarator_Impl();
    return methodDeclarator_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterList_ createParameterList_()
  {
    ParameterList_Impl parameterList_ = new ParameterList_Impl();
    return parameterList_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_parameterList_1_ createAnonymous_parameterList_1_()
  {
    Anonymous_parameterList_1_Impl anonymous_parameterList_1_ = new Anonymous_parameterList_1_Impl();
    return anonymous_parameterList_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter_ createParameter_()
  {
    Parameter_Impl parameter_ = new Parameter_Impl();
    return parameter_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_parameter_1_ createAnonymous_parameter_1_()
  {
    Anonymous_parameter_1_Impl anonymous_parameter_1_ = new Anonymous_parameter_1_Impl();
    return anonymous_parameter_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association_ createAssociation_()
  {
    Association_Impl association_ = new Association_Impl();
    return association_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SymmetricReflexiveAssociation_ createSymmetricReflexiveAssociation_()
  {
    SymmetricReflexiveAssociation_Impl symmetricReflexiveAssociation_ = new SymmetricReflexiveAssociation_Impl();
    return symmetricReflexiveAssociation_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InlineAssociation_ createInlineAssociation_()
  {
    InlineAssociation_Impl inlineAssociation_ = new InlineAssociation_Impl();
    return inlineAssociation_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InlineAssociationEnd_ createInlineAssociationEnd_()
  {
    InlineAssociationEnd_Impl inlineAssociationEnd_ = new InlineAssociationEnd_Impl();
    return inlineAssociationEnd_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleAssociationEnd_ createSingleAssociationEnd_()
  {
    SingleAssociationEnd_Impl singleAssociationEnd_ = new SingleAssociationEnd_Impl();
    return singleAssociationEnd_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationEnd_ createAssociationEnd_()
  {
    AssociationEnd_Impl associationEnd_ = new AssociationEnd_Impl();
    return associationEnd_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiplicity_ createMultiplicity_()
  {
    Multiplicity_Impl multiplicity_ = new Multiplicity_Impl();
    return multiplicity_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IsSorted_ createIsSorted_()
  {
    IsSorted_Impl isSorted_ = new IsSorted_Impl();
    return isSorted_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute_ createAttribute_()
  {
    Attribute_Impl attribute_ = new Attribute_Impl();
    return attribute_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleAttribute_ createSimpleAttribute_()
  {
    SimpleAttribute_Impl simpleAttribute_ = new SimpleAttribute_Impl();
    return simpleAttribute_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AutouniqueAttribute_ createAutouniqueAttribute_()
  {
    AutouniqueAttribute_Impl autouniqueAttribute_ = new AutouniqueAttribute_Impl();
    return autouniqueAttribute_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DerivedAttribute_ createDerivedAttribute_()
  {
    DerivedAttribute_Impl derivedAttribute_ = new DerivedAttribute_Impl();
    return derivedAttribute_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_derivedAttribute_1_ createAnonymous_derivedAttribute_1_()
  {
    Anonymous_derivedAttribute_1_Impl anonymous_derivedAttribute_1_ = new Anonymous_derivedAttribute_1_Impl();
    return anonymous_derivedAttribute_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_derivedAttribute_2_ createAnonymous_derivedAttribute_2_()
  {
    Anonymous_derivedAttribute_2_Impl anonymous_derivedAttribute_2_ = new Anonymous_derivedAttribute_2_Impl();
    return anonymous_derivedAttribute_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_derivedAttribute_3_ createAnonymous_derivedAttribute_3_()
  {
    Anonymous_derivedAttribute_3_Impl anonymous_derivedAttribute_3_ = new Anonymous_derivedAttribute_3_Impl();
    return anonymous_derivedAttribute_3_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexAttribute_ createComplexAttribute_()
  {
    ComplexAttribute_Impl complexAttribute_ = new ComplexAttribute_Impl();
    return complexAttribute_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_complexAttribute_1_ createAnonymous_complexAttribute_1_()
  {
    Anonymous_complexAttribute_1_Impl anonymous_complexAttribute_1_ = new Anonymous_complexAttribute_1_Impl();
    return anonymous_complexAttribute_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_complexAttribute_2_ createAnonymous_complexAttribute_2_()
  {
    Anonymous_complexAttribute_2_Impl anonymous_complexAttribute_2_ = new Anonymous_complexAttribute_2_Impl();
    return anonymous_complexAttribute_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Key_ createKey_()
  {
    Key_Impl key_ = new Key_Impl();
    return key_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_key_1_ createAnonymous_key_1_()
  {
    Anonymous_key_1_Impl anonymous_key_1_ = new Anonymous_key_1_Impl();
    return anonymous_key_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Depend_ createDepend_()
  {
    Depend_Impl depend_ = new Depend_Impl();
    return depend_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtraCode_ createExtraCode_()
  {
    ExtraCode_Impl extraCode_ = new ExtraCode_Impl();
    return extraCode_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SoftwarePattern_ createSoftwarePattern_()
  {
    SoftwarePattern_Impl softwarePattern_ = new SoftwarePattern_Impl();
    return softwarePattern_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IsA_ createIsA_()
  {
    IsA_Impl isA_ = new IsA_Impl();
    return isA_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SingleIsA_ createSingleIsA_()
  {
    SingleIsA_Impl singleIsA_ = new SingleIsA_Impl();
    return singleIsA_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_singleIsA_1_ createAnonymous_singleIsA_1_()
  {
    Anonymous_singleIsA_1_Impl anonymous_singleIsA_1_ = new Anonymous_singleIsA_1_Impl();
    return anonymous_singleIsA_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultipleIsA_ createMultipleIsA_()
  {
    MultipleIsA_Impl multipleIsA_ = new MultipleIsA_Impl();
    return multipleIsA_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_multipleIsA_1_ createAnonymous_multipleIsA_1_()
  {
    Anonymous_multipleIsA_1_Impl anonymous_multipleIsA_1_ = new Anonymous_multipleIsA_1_Impl();
    return anonymous_multipleIsA_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Singleton_ createSingleton_()
  {
    Singleton_Impl singleton_ = new Singleton_Impl();
    return singleton_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Immutable_ createImmutable_()
  {
    Immutable_Impl immutable_ = new Immutable_Impl();
    return immutable_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeyDefinition_ createKeyDefinition_()
  {
    KeyDefinition_Impl keyDefinition_ = new KeyDefinition_Impl();
    return keyDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CodeInjection_ createCodeInjection_()
  {
    CodeInjection_Impl codeInjection_ = new CodeInjection_Impl();
    return codeInjection_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BeforeCode_ createBeforeCode_()
  {
    BeforeCode_Impl beforeCode_ = new BeforeCode_Impl();
    return beforeCode_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_beforeCode_1_ createAnonymous_beforeCode_1_()
  {
    Anonymous_beforeCode_1_Impl anonymous_beforeCode_1_ = new Anonymous_beforeCode_1_Impl();
    return anonymous_beforeCode_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_beforeCode_2_ createAnonymous_beforeCode_2_()
  {
    Anonymous_beforeCode_2_Impl anonymous_beforeCode_2_ = new Anonymous_beforeCode_2_Impl();
    return anonymous_beforeCode_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AfterCode_ createAfterCode_()
  {
    AfterCode_Impl afterCode_ = new AfterCode_Impl();
    return afterCode_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_afterCode_1_ createAnonymous_afterCode_1_()
  {
    Anonymous_afterCode_1_Impl anonymous_afterCode_1_ = new Anonymous_afterCode_1_Impl();
    return anonymous_afterCode_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_afterCode_2_ createAnonymous_afterCode_2_()
  {
    Anonymous_afterCode_2_Impl anonymous_afterCode_2_ = new Anonymous_afterCode_2_Impl();
    return anonymous_afterCode_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachineDefinition_ createStateMachineDefinition_()
  {
    StateMachineDefinition_Impl stateMachineDefinition_ = new StateMachineDefinition_Impl();
    return stateMachineDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachine_ createStateMachine_()
  {
    StateMachine_Impl stateMachine_ = new StateMachine_Impl();
    return stateMachine_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActiveDefinition_ createActiveDefinition_()
  {
    ActiveDefinition_Impl activeDefinition_ = new ActiveDefinition_Impl();
    return activeDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InlineStateMachine_ createInlineStateMachine_()
  {
    InlineStateMachine_Impl inlineStateMachine_ = new InlineStateMachine_Impl();
    return inlineStateMachine_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_inlineStateMachine_1_ createAnonymous_inlineStateMachine_1_()
  {
    Anonymous_inlineStateMachine_1_Impl anonymous_inlineStateMachine_1_ = new Anonymous_inlineStateMachine_1_Impl();
    return anonymous_inlineStateMachine_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferencedStateMachine_ createReferencedStateMachine_()
  {
    ReferencedStateMachine_Impl referencedStateMachine_ = new ReferencedStateMachine_Impl();
    return referencedStateMachine_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedStateMachine_ createExtendedStateMachine_()
  {
    ExtendedStateMachine_Impl extendedStateMachine_ = new ExtendedStateMachine_Impl();
    return extendedStateMachine_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_extendedStateMachine_1_ createAnonymous_extendedStateMachine_1_()
  {
    Anonymous_extendedStateMachine_1_Impl anonymous_extendedStateMachine_1_ = new Anonymous_extendedStateMachine_1_Impl();
    return anonymous_extendedStateMachine_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Enum_ createEnum_()
  {
    Enum_Impl enum_ = new Enum_Impl();
    return enum_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_enum_1_ createAnonymous_enum_1_()
  {
    Anonymous_enum_1_Impl anonymous_enum_1_ = new Anonymous_enum_1_Impl();
    return anonymous_enum_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State_ createState_()
  {
    State_Impl state_ = new State_Impl();
    return state_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_state_1_ createAnonymous_state_1_()
  {
    Anonymous_state_1_Impl anonymous_state_1_ = new Anonymous_state_1_Impl();
    return anonymous_state_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateInternal_ createStateInternal_()
  {
    StateInternal_Impl stateInternal_ = new StateInternal_Impl();
    return stateInternal_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateEntity_ createStateEntity_()
  {
    StateEntity_Impl stateEntity_ = new StateEntity_Impl();
    return stateEntity_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AutoTransition_ createAutoTransition_()
  {
    AutoTransition_Impl autoTransition_ = new AutoTransition_Impl();
    return autoTransition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AutoTransitionBlock_ createAutoTransitionBlock_()
  {
    AutoTransitionBlock_Impl autoTransitionBlock_ = new AutoTransitionBlock_Impl();
    return autoTransitionBlock_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition_ createTransition_()
  {
    Transition_Impl transition_ = new Transition_Impl();
    return transition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventDefinition_ createEventDefinition_()
  {
    EventDefinition_Impl eventDefinition_ = new EventDefinition_Impl();
    return eventDefinition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_eventDefinition_1_ createAnonymous_eventDefinition_1_()
  {
    Anonymous_eventDefinition_1_Impl anonymous_eventDefinition_1_ = new Anonymous_eventDefinition_1_Impl();
    return anonymous_eventDefinition_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AfterEveryEvent_ createAfterEveryEvent_()
  {
    AfterEveryEvent_Impl afterEveryEvent_ = new AfterEveryEvent_Impl();
    return afterEveryEvent_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AfterEvent_ createAfterEvent_()
  {
    AfterEvent_Impl afterEvent_ = new AfterEvent_Impl();
    return afterEvent_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action_ createAction_()
  {
    Action_Impl action_ = new Action_Impl();
    return action_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_action_1_ createAnonymous_action_1_()
  {
    Anonymous_action_1_Impl anonymous_action_1_ = new Anonymous_action_1_Impl();
    return anonymous_action_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_action_2_ createAnonymous_action_2_()
  {
    Anonymous_action_2_Impl anonymous_action_2_ = new Anonymous_action_2_Impl();
    return anonymous_action_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntryOrExitAction_ createEntryOrExitAction_()
  {
    EntryOrExitAction_Impl entryOrExitAction_ = new EntryOrExitAction_Impl();
    return entryOrExitAction_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_entryOrExitAction_1_ createAnonymous_entryOrExitAction_1_()
  {
    Anonymous_entryOrExitAction_1_Impl anonymous_entryOrExitAction_1_ = new Anonymous_entryOrExitAction_1_Impl();
    return anonymous_entryOrExitAction_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_entryOrExitAction_2_ createAnonymous_entryOrExitAction_2_()
  {
    Anonymous_entryOrExitAction_2_Impl anonymous_entryOrExitAction_2_ = new Anonymous_entryOrExitAction_2_Impl();
    return anonymous_entryOrExitAction_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity_ createActivity_()
  {
    Activity_Impl activity_ = new Activity_Impl();
    return activity_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_activity_1_ createAnonymous_activity_1_()
  {
    Anonymous_activity_1_Impl anonymous_activity_1_ = new Anonymous_activity_1_Impl();
    return anonymous_activity_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_activity_2_ createAnonymous_activity_2_()
  {
    Anonymous_activity_2_Impl anonymous_activity_2_ = new Anonymous_activity_2_Impl();
    return anonymous_activity_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MoreGuards_ createMoreGuards_()
  {
    MoreGuards_Impl moreGuards_ = new MoreGuards_Impl();
    return moreGuards_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_moreGuards_1_ createAnonymous_moreGuards_1_()
  {
    Anonymous_moreGuards_1_Impl anonymous_moreGuards_1_ = new Anonymous_moreGuards_1_Impl();
    return anonymous_moreGuards_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard_ createGuard_()
  {
    Guard_Impl guard_ = new Guard_Impl();
    return guard_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_guard_1_ createAnonymous_guard_1_()
  {
    Anonymous_guard_1_Impl anonymous_guard_1_ = new Anonymous_guard_1_Impl();
    return anonymous_guard_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_guard_2_ createAnonymous_guard_2_()
  {
    Anonymous_guard_2_Impl anonymous_guard_2_ = new Anonymous_guard_2_Impl();
    return anonymous_guard_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceType_ createTraceType_()
  {
    TraceType_Impl traceType_ = new TraceType_Impl();
    return traceType_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_traceType_1_ createAnonymous_traceType_1_()
  {
    Anonymous_traceType_1_Impl anonymous_traceType_1_ = new Anonymous_traceType_1_Impl();
    return anonymous_traceType_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_traceType_2_ createAnonymous_traceType_2_()
  {
    Anonymous_traceType_2_Impl anonymous_traceType_2_ = new Anonymous_traceType_2_Impl();
    return anonymous_traceType_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Trace_ createTrace_()
  {
    Trace_Impl trace_ = new Trace_Impl();
    return trace_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceDirective_ createTraceDirective_()
  {
    TraceDirective_Impl traceDirective_ = new TraceDirective_Impl();
    return traceDirective_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_traceDirective_1_ createAnonymous_traceDirective_1_()
  {
    Anonymous_traceDirective_1_Impl anonymous_traceDirective_1_ = new Anonymous_traceDirective_1_Impl();
    return anonymous_traceDirective_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceItem_ createTraceItem_()
  {
    TraceItem_Impl traceItem_ = new TraceItem_Impl();
    return traceItem_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceEntity_ createTraceEntity_()
  {
    TraceEntity_Impl traceEntity_ = new TraceEntity_Impl();
    return traceEntity_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_traceEntity_1_ createAnonymous_traceEntity_1_()
  {
    Anonymous_traceEntity_1_Impl anonymous_traceEntity_1_ = new Anonymous_traceEntity_1_Impl();
    return anonymous_traceEntity_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceOptions_ createTraceOptions_()
  {
    TraceOptions_Impl traceOptions_ = new TraceOptions_Impl();
    return traceOptions_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_traceOptions_1_ createAnonymous_traceOptions_1_()
  {
    Anonymous_traceOptions_1_Impl anonymous_traceOptions_1_ = new Anonymous_traceOptions_1_Impl();
    return anonymous_traceOptions_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceOption_ createTraceOption_()
  {
    TraceOption_Impl traceOption_ = new TraceOption_Impl();
    return traceOption_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreOrPostCondition_ createPreOrPostCondition_()
  {
    PreOrPostCondition_Impl preOrPostCondition_ = new PreOrPostCondition_Impl();
    return preOrPostCondition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecuteClause_ createExecuteClause_()
  {
    ExecuteClause_Impl executeClause_ = new ExecuteClause_Impl();
    return executeClause_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceWhen_ createTraceWhen_()
  {
    TraceWhen_Impl traceWhen_ = new TraceWhen_Impl();
    return traceWhen_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceFor_ createTraceFor_()
  {
    TraceFor_Impl traceFor_ = new TraceFor_Impl();
    return traceFor_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceLevel_ createTraceLevel_()
  {
    TraceLevel_Impl traceLevel_ = new TraceLevel_Impl();
    return traceLevel_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TracePeriod_ createTracePeriod_()
  {
    TracePeriod_Impl tracePeriod_ = new TracePeriod_Impl();
    return tracePeriod_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceDuring_ createTraceDuring_()
  {
    TraceDuring_Impl traceDuring_ = new TraceDuring_Impl();
    return traceDuring_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceRecord_ createTraceRecord_()
  {
    TraceRecord_Impl traceRecord_ = new TraceRecord_Impl();
    return traceRecord_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordEntity_ createRecordEntity_()
  {
    RecordEntity_Impl recordEntity_ = new RecordEntity_Impl();
    return recordEntity_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_recordEntity_2_ createAnonymous_recordEntity_2_()
  {
    Anonymous_recordEntity_2_Impl anonymous_recordEntity_2_ = new Anonymous_recordEntity_2_Impl();
    return anonymous_recordEntity_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCondition_ createTraceCondition_()
  {
    TraceCondition_Impl traceCondition_ = new TraceCondition_Impl();
    return traceCondition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionRHS_ createConditionRHS_()
  {
    ConditionRHS_Impl conditionRHS_ = new ConditionRHS_Impl();
    return conditionRHS_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCase_ createTraceCase_()
  {
    TraceCase_Impl traceCase_ = new TraceCase_Impl();
    return traceCase_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCaseDef_ createTraceCaseDef_()
  {
    TraceCaseDef_Impl traceCaseDef_ = new TraceCaseDef_Impl();
    return traceCaseDef_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCaseActivation_ createTraceCaseActivation_()
  {
    TraceCaseActivation_Impl traceCaseActivation_ = new TraceCaseActivation_Impl();
    return traceCaseActivation_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCaseDeactivation_ createTraceCaseDeactivation_()
  {
    TraceCaseDeactivation_Impl traceCaseDeactivation_ = new TraceCaseDeactivation_Impl();
    return traceCaseDeactivation_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeActivateFor_ createDeActivateFor_()
  {
    DeActivateFor_Impl deActivateFor_ = new DeActivateFor_Impl();
    return deActivateFor_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Precondition_ createPrecondition_()
  {
    Precondition_Impl precondition_ = new Precondition_Impl();
    return precondition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Postcondition_ createPostcondition_()
  {
    Postcondition_Impl postcondition_ = new Postcondition_Impl();
    return postcondition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Invariant_ createInvariant_()
  {
    Invariant_Impl invariant_ = new Invariant_Impl();
    return invariant_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_invariant_1_ createAnonymous_invariant_1_()
  {
    Anonymous_invariant_1_Impl anonymous_invariant_1_ = new Anonymous_invariant_1_Impl();
    return anonymous_invariant_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_invariant_2_ createAnonymous_invariant_2_()
  {
    Anonymous_invariant_2_Impl anonymous_invariant_2_ = new Anonymous_invariant_2_Impl();
    return anonymous_invariant_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintToken_ createConstraintToken_()
  {
    ConstraintToken_Impl constraintToken_ = new ConstraintToken_Impl();
    return constraintToken_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Constraint_ createConstraint_()
  {
    Constraint_Impl constraint_ = new Constraint_Impl();
    return constraint_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_constraint_1_ createAnonymous_constraint_1_()
  {
    Anonymous_constraint_1_Impl anonymous_constraint_1_ = new Anonymous_constraint_1_Impl();
    return anonymous_constraint_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NegativeConstraint_ createNegativeConstraint_()
  {
    NegativeConstraint_Impl negativeConstraint_ = new NegativeConstraint_Impl();
    return negativeConstraint_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintBody_ createConstraintBody_()
  {
    ConstraintBody_Impl constraintBody_ = new ConstraintBody_Impl();
    return constraintBody_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_constraintBody_1_ createAnonymous_constraintBody_1_()
  {
    Anonymous_constraintBody_1_Impl anonymous_constraintBody_1_ = new Anonymous_constraintBody_1_Impl();
    return anonymous_constraintBody_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LinkingOp_ createLinkingOp_()
  {
    LinkingOp_Impl linkingOp_ = new LinkingOp_Impl();
    return linkingOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_linkingOp_1_ createAnonymous_linkingOp_1_()
  {
    Anonymous_linkingOp_1_Impl anonymous_linkingOp_1_ = new Anonymous_linkingOp_1_Impl();
    return anonymous_linkingOp_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_linkingOp_2_ createAnonymous_linkingOp_2_()
  {
    Anonymous_linkingOp_2_Impl anonymous_linkingOp_2_ = new Anonymous_linkingOp_2_Impl();
    return anonymous_linkingOp_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_linkingOp_3_ createAnonymous_linkingOp_3_()
  {
    Anonymous_linkingOp_3_Impl anonymous_linkingOp_3_ = new Anonymous_linkingOp_3_Impl();
    return anonymous_linkingOp_3_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintExpr_ createConstraintExpr_()
  {
    ConstraintExpr_Impl constraintExpr_ = new ConstraintExpr_Impl();
    return constraintExpr_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_constraintExpr_1_ createAnonymous_constraintExpr_1_()
  {
    Anonymous_constraintExpr_1_Impl anonymous_constraintExpr_1_ = new Anonymous_constraintExpr_1_Impl();
    return anonymous_constraintExpr_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompoundExpr_ createCompoundExpr_()
  {
    CompoundExpr_Impl compoundExpr_ = new CompoundExpr_Impl();
    return compoundExpr_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolExpr_ createBoolExpr_()
  {
    BoolExpr_Impl boolExpr_ = new BoolExpr_Impl();
    return boolExpr_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringExpr_ createStringExpr_()
  {
    StringExpr_Impl stringExpr_ = new StringExpr_Impl();
    return stringExpr_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLit_ createStringLit_()
  {
    StringLit_Impl stringLit_ = new StringLit_Impl();
    return stringLit_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GenExpr_ createGenExpr_()
  {
    GenExpr_Impl genExpr_ = new GenExpr_Impl();
    return genExpr_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_genExpr_1_ createAnonymous_genExpr_1_()
  {
    Anonymous_genExpr_1_Impl anonymous_genExpr_1_ = new Anonymous_genExpr_1_Impl();
    return anonymous_genExpr_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_genExpr_2_ createAnonymous_genExpr_2_()
  {
    Anonymous_genExpr_2_Impl anonymous_genExpr_2_ = new Anonymous_genExpr_2_Impl();
    return anonymous_genExpr_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumExpr_ createNumExpr_()
  {
    NumExpr_Impl numExpr_ = new NumExpr_Impl();
    return numExpr_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_numExpr_1_ createAnonymous_numExpr_1_()
  {
    Anonymous_numExpr_1_Impl anonymous_numExpr_1_ = new Anonymous_numExpr_1_Impl();
    return anonymous_numExpr_1_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_numExpr_2_ createAnonymous_numExpr_2_()
  {
    Anonymous_numExpr_2_Impl anonymous_numExpr_2_ = new Anonymous_numExpr_2_Impl();
    return anonymous_numExpr_2_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_numExpr_3_ createAnonymous_numExpr_3_()
  {
    Anonymous_numExpr_3_Impl anonymous_numExpr_3_ = new Anonymous_numExpr_3_Impl();
    return anonymous_numExpr_3_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Anonymous_numExpr_4_ createAnonymous_numExpr_4_()
  {
    Anonymous_numExpr_4_Impl anonymous_numExpr_4_ = new Anonymous_numExpr_4_Impl();
    return anonymous_numExpr_4_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityOp_ createEqualityOp_()
  {
    EqualityOp_Impl equalityOp_ = new EqualityOp_Impl();
    return equalityOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualsOp_ createEqualsOp_()
  {
    EqualsOp_Impl equalsOp_ = new EqualsOp_Impl();
    return equalsOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotequalsOp_ createNotequalsOp_()
  {
    NotequalsOp_Impl notequalsOp_ = new NotequalsOp_Impl();
    return notequalsOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrdinalOp_ createOrdinalOp_()
  {
    OrdinalOp_Impl ordinalOp_ = new OrdinalOp_Impl();
    return ordinalOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreaterOp_ createGreaterOp_()
  {
    GreaterOp_Impl greaterOp_ = new GreaterOp_Impl();
    return greaterOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LessOp_ createLessOp_()
  {
    LessOp_Impl lessOp_ = new LessOp_Impl();
    return lessOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MoreOp_ createMoreOp_()
  {
    MoreOp_Impl moreOp_ = new MoreOp_Impl();
    return moreOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SmallerOp_ createSmallerOp_()
  {
    SmallerOp_Impl smallerOp_ = new SmallerOp_Impl();
    return smallerOp_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Position_ createPosition_()
  {
    Position_Impl position_ = new Position_Impl();
    return position_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElementPosition_ createElementPosition_()
  {
    ElementPosition_Impl elementPosition_ = new ElementPosition_Impl();
    return elementPosition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationPosition_ createAssociationPosition_()
  {
    AssociationPosition_Impl associationPosition_ = new AssociationPosition_Impl();
    return associationPosition_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Coordinate_ createCoordinate_()
  {
    Coordinate_Impl coordinate_ = new Coordinate_Impl();
    return coordinate_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DisplayColor_ createDisplayColor_()
  {
    DisplayColor_Impl displayColor_ = new DisplayColor_Impl();
    return displayColor_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmplePackage getUmplePackage()
  {
    return (UmplePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UmplePackage getPackage()
  {
    return UmplePackage.eINSTANCE;
  }

} //UmpleFactoryImpl
