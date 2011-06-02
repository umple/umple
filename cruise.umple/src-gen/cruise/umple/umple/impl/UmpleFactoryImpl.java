/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
      case UmplePackage.UMPLE_MODEL: return createUmpleModel();
      case UmplePackage.UMPLE_ELEMENT: return createUmpleElement();
      case UmplePackage.WORD: return createWord();
      case UmplePackage.GLOSSARY: return createGlossary();
      case UmplePackage.GENERATE: return createGenerate();
      case UmplePackage.NAMESPACE: return createNamespace();
      case UmplePackage.UMPLE_CLASS: return createUmpleClass();
      case UmplePackage.EXTERNAL_LANGUAGE: return createExternalLanguage();
      case UmplePackage.UMPLE_INTERFACE: return createUmpleInterface();
      case UmplePackage.UMPLE_ASSOCIATION: return createUmpleAssociation();
      case UmplePackage.UMPLE_ASSOCIATION_CLASS: return createUmpleAssociationClass();
      case UmplePackage.ASSOCIATION_CLASS_CONTENT: return createassociationClassContent();
      case UmplePackage.ASSOCIATION: return createAssociation();
      case UmplePackage.SYMMETRIC_REFLEXIVE_ASSOCIATION: return createSymmetricReflexiveAssociation();
      case UmplePackage.INLINE_ASSOCIATION: return createInlineAssociation();
      case UmplePackage.SINGLE_ASSOCIATION_END: return createsingleAssociationEnd();
      case UmplePackage.SINGLETON: return createSingleton();
      case UmplePackage.CODE_INJECTION: return createCodeInjection();
      case UmplePackage.UMPLE_ATTRIBUTE: return createUmpleAttribute();
      case UmplePackage.KEY: return createKey();
      case UmplePackage.DEPEND: return createDepend();
      case UmplePackage.STATE_MACHINE_DEFINITION: return createStateMachineDefinition();
      case UmplePackage.STATE_MACHINE: return createStateMachine();
      case UmplePackage.INLINE_STATE_MACHINE: return createInlineStateMachine();
      case UmplePackage.REFERENCED_STATE_MACHINE: return createReferencedStateMachine();
      case UmplePackage.ENUM: return createENUM();
      case UmplePackage.STATE: return createState();
      case UmplePackage.STATE_ENTITY: return createStateEntity();
      case UmplePackage.TRANSITION: return createTransition();
      case UmplePackage.EVENT_DEFINITION: return createEventDefinition();
      case UmplePackage.ACTION: return createAction();
      case UmplePackage.ENTRY_OR_EXIT_ACTION: return createEntryOrExitAction();
      case UmplePackage.ACTIVITY: return createActivity();
      case UmplePackage.GUARD: return createGuard();
      case UmplePackage.GUARD_CODE: return createGuardCode();
      case UmplePackage.POSITION: return createPosition();
      case UmplePackage.CLASS_POSITION: return createClassPosition();
      case UmplePackage.ASSOCIATION_POSITION: return createAssociationPosition();
      case UmplePackage.COORDINATE: return createCoordinate();
      case UmplePackage.TRACE_DIRECTIVE: return createTraceDirective();
      case UmplePackage.TRACE_CASE: return createTraceCase();
      case UmplePackage.TRACE_RECORD: return createTraceRecord();
      case UmplePackage.TRACE_CONDITION: return createTraceCondition();
      case UmplePackage.COMPOUND_TRACE_CONDITION: return createCompoundTraceCondition();
      case UmplePackage.SIMPLE_TRACE_CONDITION: return createSimpleTraceCondition();
      case UmplePackage.CONDITION_RHS: return createConditionRHS();
      case UmplePackage.MODEL_ELEMENT: return createModelElement();
      case UmplePackage.TRACE_MECHANISM: return createTraceMechanism();
      case UmplePackage.BLOCK: return createblock();
      case UmplePackage.PAR_EXPRESSION: return createparExpression();
      case UmplePackage.EXPRESSION_LIST: return createexpressionList();
      case UmplePackage.EXPRESSION: return createexpression();
      case UmplePackage.CONDITIONAL_EXPRESSION: return createconditionalExpression();
      case UmplePackage.CONDITIONAL_OR_EXPRESSION: return createconditionalOrExpression();
      case UmplePackage.CONDITIONAL_AND_EXPRESSION: return createconditionalAndExpression();
      case UmplePackage.EQUALITY_EXPRESSION: return createequalityExpression();
      case UmplePackage.RELATIONAL_EXPRESSION: return createrelationalExpression();
      case UmplePackage.ADDITIVE_EXPRESSION: return createadditiveExpression();
      case UmplePackage.MULTIPLICATIVE_EXPRESSION: return createmultiplicativeExpression();
      case UmplePackage.UNARY_EXPRESSION: return createunaryExpression();
      case UmplePackage.UNARY_EXPRESSION_NOT_PLUS_MINUS: return createunaryExpressionNotPlusMinus();
      case UmplePackage.PRIMARY: return createprimary();
      case UmplePackage.LITERAL: return createliteral();
      case UmplePackage.FUNCTION_CALL: return createfunctionCall();
      case UmplePackage.FUNCTION_DECLARATION: return createfunctionDeclaration();
      case UmplePackage.FUNCTION_DEFINITION: return createfunctionDefinition();
      case UmplePackage.JAVA_FUNCTION_DECLARATION: return createjavaFunctionDeclaration();
      case UmplePackage.JAVA_FUNCTION_DEFINITION: return createjavaFunctionDefinition();
      case UmplePackage.JAVA_FUNCTION_CALL: return createjavaFunctionCall();
      case UmplePackage.BLOCK_STATEMENT: return createblockStatement();
      case UmplePackage.LOCAL_VARIABLE_DECLARATION_STATEMENT: return createlocalVariableDeclarationStatement();
      case UmplePackage.LOCAL_VARIABLE_DECLARATION: return createlocalVariableDeclaration();
      case UmplePackage.VARIABLE_DECLARATORS: return createvariableDeclarators();
      case UmplePackage.VARIABLE_DECLARATOR: return createvariableDeclarator();
      case UmplePackage.STATEMENT: return createstatement();
      case UmplePackage.FOR_CONTROL: return createforControl();
      case UmplePackage.FOR_INIT: return createforInit();
      case UmplePackage.FOR_UPDATE: return createforUpdate();
      case UmplePackage.PHP_FUNCTION: return createphpFunction();
      case UmplePackage.PHP_BLOCK: return createphpBlock();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case UmplePackage.MODIFIER:
        return createModifierFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case UmplePackage.MODIFIER:
        return convertModifierToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleModel createUmpleModel()
  {
    UmpleModelImpl umpleModel = new UmpleModelImpl();
    return umpleModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleElement createUmpleElement()
  {
    UmpleElementImpl umpleElement = new UmpleElementImpl();
    return umpleElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Word createWord()
  {
    WordImpl word = new WordImpl();
    return word;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Glossary createGlossary()
  {
    GlossaryImpl glossary = new GlossaryImpl();
    return glossary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Generate createGenerate()
  {
    GenerateImpl generate = new GenerateImpl();
    return generate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Namespace createNamespace()
  {
    NamespaceImpl namespace = new NamespaceImpl();
    return namespace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleClass createUmpleClass()
  {
    UmpleClassImpl umpleClass = new UmpleClassImpl();
    return umpleClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalLanguage createExternalLanguage()
  {
    ExternalLanguageImpl externalLanguage = new ExternalLanguageImpl();
    return externalLanguage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleInterface createUmpleInterface()
  {
    UmpleInterfaceImpl umpleInterface = new UmpleInterfaceImpl();
    return umpleInterface;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleAssociation createUmpleAssociation()
  {
    UmpleAssociationImpl umpleAssociation = new UmpleAssociationImpl();
    return umpleAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleAssociationClass createUmpleAssociationClass()
  {
    UmpleAssociationClassImpl umpleAssociationClass = new UmpleAssociationClassImpl();
    return umpleAssociationClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public associationClassContent createassociationClassContent()
  {
    associationClassContentImpl associationClassContent = new associationClassContentImpl();
    return associationClassContent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Association createAssociation()
  {
    AssociationImpl association = new AssociationImpl();
    return association;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SymmetricReflexiveAssociation createSymmetricReflexiveAssociation()
  {
    SymmetricReflexiveAssociationImpl symmetricReflexiveAssociation = new SymmetricReflexiveAssociationImpl();
    return symmetricReflexiveAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InlineAssociation createInlineAssociation()
  {
    InlineAssociationImpl inlineAssociation = new InlineAssociationImpl();
    return inlineAssociation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public singleAssociationEnd createsingleAssociationEnd()
  {
    singleAssociationEndImpl singleAssociationEnd = new singleAssociationEndImpl();
    return singleAssociationEnd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Singleton createSingleton()
  {
    SingletonImpl singleton = new SingletonImpl();
    return singleton;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CodeInjection createCodeInjection()
  {
    CodeInjectionImpl codeInjection = new CodeInjectionImpl();
    return codeInjection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleAttribute createUmpleAttribute()
  {
    UmpleAttributeImpl umpleAttribute = new UmpleAttributeImpl();
    return umpleAttribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Key createKey()
  {
    KeyImpl key = new KeyImpl();
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Depend createDepend()
  {
    DependImpl depend = new DependImpl();
    return depend;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachineDefinition createStateMachineDefinition()
  {
    StateMachineDefinitionImpl stateMachineDefinition = new StateMachineDefinitionImpl();
    return stateMachineDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateMachine createStateMachine()
  {
    StateMachineImpl stateMachine = new StateMachineImpl();
    return stateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InlineStateMachine createInlineStateMachine()
  {
    InlineStateMachineImpl inlineStateMachine = new InlineStateMachineImpl();
    return inlineStateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferencedStateMachine createReferencedStateMachine()
  {
    ReferencedStateMachineImpl referencedStateMachine = new ReferencedStateMachineImpl();
    return referencedStateMachine;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ENUM createENUM()
  {
    ENUMImpl enum_ = new ENUMImpl();
    return enum_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateEntity createStateEntity()
  {
    StateEntityImpl stateEntity = new StateEntityImpl();
    return stateEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transition createTransition()
  {
    TransitionImpl transition = new TransitionImpl();
    return transition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventDefinition createEventDefinition()
  {
    EventDefinitionImpl eventDefinition = new EventDefinitionImpl();
    return eventDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action createAction()
  {
    ActionImpl action = new ActionImpl();
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntryOrExitAction createEntryOrExitAction()
  {
    EntryOrExitActionImpl entryOrExitAction = new EntryOrExitActionImpl();
    return entryOrExitAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Activity createActivity()
  {
    ActivityImpl activity = new ActivityImpl();
    return activity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Guard createGuard()
  {
    GuardImpl guard = new GuardImpl();
    return guard;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GuardCode createGuardCode()
  {
    GuardCodeImpl guardCode = new GuardCodeImpl();
    return guardCode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Position createPosition()
  {
    PositionImpl position = new PositionImpl();
    return position;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassPosition createClassPosition()
  {
    ClassPositionImpl classPosition = new ClassPositionImpl();
    return classPosition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssociationPosition createAssociationPosition()
  {
    AssociationPositionImpl associationPosition = new AssociationPositionImpl();
    return associationPosition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Coordinate createCoordinate()
  {
    CoordinateImpl coordinate = new CoordinateImpl();
    return coordinate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceDirective createTraceDirective()
  {
    TraceDirectiveImpl traceDirective = new TraceDirectiveImpl();
    return traceDirective;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCase createTraceCase()
  {
    TraceCaseImpl traceCase = new TraceCaseImpl();
    return traceCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceRecord createTraceRecord()
  {
    TraceRecordImpl traceRecord = new TraceRecordImpl();
    return traceRecord;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceCondition createTraceCondition()
  {
    TraceConditionImpl traceCondition = new TraceConditionImpl();
    return traceCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompoundTraceCondition createCompoundTraceCondition()
  {
    CompoundTraceConditionImpl compoundTraceCondition = new CompoundTraceConditionImpl();
    return compoundTraceCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleTraceCondition createSimpleTraceCondition()
  {
    SimpleTraceConditionImpl simpleTraceCondition = new SimpleTraceConditionImpl();
    return simpleTraceCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionRHS createConditionRHS()
  {
    ConditionRHSImpl conditionRHS = new ConditionRHSImpl();
    return conditionRHS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement createModelElement()
  {
    ModelElementImpl modelElement = new ModelElementImpl();
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TraceMechanism createTraceMechanism()
  {
    TraceMechanismImpl traceMechanism = new TraceMechanismImpl();
    return traceMechanism;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public block createblock()
  {
    blockImpl block = new blockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public parExpression createparExpression()
  {
    parExpressionImpl parExpression = new parExpressionImpl();
    return parExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public expressionList createexpressionList()
  {
    expressionListImpl expressionList = new expressionListImpl();
    return expressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public expression createexpression()
  {
    expressionImpl expression = new expressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public conditionalExpression createconditionalExpression()
  {
    conditionalExpressionImpl conditionalExpression = new conditionalExpressionImpl();
    return conditionalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public conditionalOrExpression createconditionalOrExpression()
  {
    conditionalOrExpressionImpl conditionalOrExpression = new conditionalOrExpressionImpl();
    return conditionalOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public conditionalAndExpression createconditionalAndExpression()
  {
    conditionalAndExpressionImpl conditionalAndExpression = new conditionalAndExpressionImpl();
    return conditionalAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public equalityExpression createequalityExpression()
  {
    equalityExpressionImpl equalityExpression = new equalityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public relationalExpression createrelationalExpression()
  {
    relationalExpressionImpl relationalExpression = new relationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public additiveExpression createadditiveExpression()
  {
    additiveExpressionImpl additiveExpression = new additiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public multiplicativeExpression createmultiplicativeExpression()
  {
    multiplicativeExpressionImpl multiplicativeExpression = new multiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public unaryExpression createunaryExpression()
  {
    unaryExpressionImpl unaryExpression = new unaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public unaryExpressionNotPlusMinus createunaryExpressionNotPlusMinus()
  {
    unaryExpressionNotPlusMinusImpl unaryExpressionNotPlusMinus = new unaryExpressionNotPlusMinusImpl();
    return unaryExpressionNotPlusMinus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public primary createprimary()
  {
    primaryImpl primary = new primaryImpl();
    return primary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public literal createliteral()
  {
    literalImpl literal = new literalImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public functionCall createfunctionCall()
  {
    functionCallImpl functionCall = new functionCallImpl();
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public functionDeclaration createfunctionDeclaration()
  {
    functionDeclarationImpl functionDeclaration = new functionDeclarationImpl();
    return functionDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public functionDefinition createfunctionDefinition()
  {
    functionDefinitionImpl functionDefinition = new functionDefinitionImpl();
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public javaFunctionDeclaration createjavaFunctionDeclaration()
  {
    javaFunctionDeclarationImpl javaFunctionDeclaration = new javaFunctionDeclarationImpl();
    return javaFunctionDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public javaFunctionDefinition createjavaFunctionDefinition()
  {
    javaFunctionDefinitionImpl javaFunctionDefinition = new javaFunctionDefinitionImpl();
    return javaFunctionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public javaFunctionCall createjavaFunctionCall()
  {
    javaFunctionCallImpl javaFunctionCall = new javaFunctionCallImpl();
    return javaFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public blockStatement createblockStatement()
  {
    blockStatementImpl blockStatement = new blockStatementImpl();
    return blockStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public localVariableDeclarationStatement createlocalVariableDeclarationStatement()
  {
    localVariableDeclarationStatementImpl localVariableDeclarationStatement = new localVariableDeclarationStatementImpl();
    return localVariableDeclarationStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public localVariableDeclaration createlocalVariableDeclaration()
  {
    localVariableDeclarationImpl localVariableDeclaration = new localVariableDeclarationImpl();
    return localVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public variableDeclarators createvariableDeclarators()
  {
    variableDeclaratorsImpl variableDeclarators = new variableDeclaratorsImpl();
    return variableDeclarators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public variableDeclarator createvariableDeclarator()
  {
    variableDeclaratorImpl variableDeclarator = new variableDeclaratorImpl();
    return variableDeclarator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public statement createstatement()
  {
    statementImpl statement = new statementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public forControl createforControl()
  {
    forControlImpl forControl = new forControlImpl();
    return forControl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public forInit createforInit()
  {
    forInitImpl forInit = new forInitImpl();
    return forInit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public forUpdate createforUpdate()
  {
    forUpdateImpl forUpdate = new forUpdateImpl();
    return forUpdate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public phpFunction createphpFunction()
  {
    phpFunctionImpl phpFunction = new phpFunctionImpl();
    return phpFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public phpBlock createphpBlock()
  {
    phpBlockImpl phpBlock = new phpBlockImpl();
    return phpBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modifier createModifierFromString(EDataType eDataType, String initialValue)
  {
    Modifier result = Modifier.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertModifierToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
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
