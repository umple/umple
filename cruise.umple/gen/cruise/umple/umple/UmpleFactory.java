/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cruise.umple.umple.UmplePackage
 * @generated
 */
public interface UmpleFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmpleFactory eINSTANCE = cruise.umple.umple.impl.UmpleFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  UmpleModel createUmpleModel();

  /**
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  UmpleElement createUmpleElement();

  /**
   * Returns a new object of class '<em>Word</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Word</em>'.
   * @generated
   */
  Word createWord();

  /**
   * Returns a new object of class '<em>Glossary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Glossary</em>'.
   * @generated
   */
  Glossary createGlossary();

  /**
   * Returns a new object of class '<em>Namespace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Namespace</em>'.
   * @generated
   */
  Namespace createNamespace();

  /**
   * Returns a new object of class '<em>Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class</em>'.
   * @generated
   */
  UmpleClass createUmpleClass();

  /**
   * Returns a new object of class '<em>Interface</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interface</em>'.
   * @generated
   */
  UmpleInterface createUmpleInterface();

  /**
   * Returns a new object of class '<em>Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association</em>'.
   * @generated
   */
  UmpleAssociation createUmpleAssociation();

  /**
   * Returns a new object of class '<em>Association Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Class</em>'.
   * @generated
   */
  UmpleAssociationClass createUmpleAssociationClass();

  /**
   * Returns a new object of class '<em>association Class Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>association Class Content</em>'.
   * @generated
   */
  associationClassContent createassociationClassContent();

  /**
   * Returns a new object of class '<em>Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association</em>'.
   * @generated
   */
  Association createAssociation();

  /**
   * Returns a new object of class '<em>Symmetric Reflexive Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Symmetric Reflexive Association</em>'.
   * @generated
   */
  SymmetricReflexiveAssociation createSymmetricReflexiveAssociation();

  /**
   * Returns a new object of class '<em>Inline Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inline Association</em>'.
   * @generated
   */
  InlineAssociation createInlineAssociation();

  /**
   * Returns a new object of class '<em>single Association End</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>single Association End</em>'.
   * @generated
   */
  singleAssociationEnd createsingleAssociationEnd();

  /**
   * Returns a new object of class '<em>Singleton</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Singleton</em>'.
   * @generated
   */
  Singleton createSingleton();

  /**
   * Returns a new object of class '<em>Code Injection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Code Injection</em>'.
   * @generated
   */
  CodeInjection createCodeInjection();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  UmpleAttribute createUmpleAttribute();

  /**
   * Returns a new object of class '<em>Key</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key</em>'.
   * @generated
   */
  Key createKey();

  /**
   * Returns a new object of class '<em>Depend</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Depend</em>'.
   * @generated
   */
  Depend createDepend();

  /**
   * Returns a new object of class '<em>State Machine Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Machine Definition</em>'.
   * @generated
   */
  StateMachineDefinition createStateMachineDefinition();

  /**
   * Returns a new object of class '<em>State Machine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Machine</em>'.
   * @generated
   */
  StateMachine createStateMachine();

  /**
   * Returns a new object of class '<em>Inline State Machine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inline State Machine</em>'.
   * @generated
   */
  InlineStateMachine createInlineStateMachine();

  /**
   * Returns a new object of class '<em>Referenced State Machine</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Referenced State Machine</em>'.
   * @generated
   */
  ReferencedStateMachine createReferencedStateMachine();

  /**
   * Returns a new object of class '<em>ENUM</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ENUM</em>'.
   * @generated
   */
  ENUM createENUM();

  /**
   * Returns a new object of class '<em>State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State</em>'.
   * @generated
   */
  State createState();

  /**
   * Returns a new object of class '<em>State Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Entity</em>'.
   * @generated
   */
  StateEntity createStateEntity();

  /**
   * Returns a new object of class '<em>Transition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition</em>'.
   * @generated
   */
  Transition createTransition();

  /**
   * Returns a new object of class '<em>Event Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Definition</em>'.
   * @generated
   */
  EventDefinition createEventDefinition();

  /**
   * Returns a new object of class '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action</em>'.
   * @generated
   */
  Action createAction();

  /**
   * Returns a new object of class '<em>Entry Or Exit Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry Or Exit Action</em>'.
   * @generated
   */
  EntryOrExitAction createEntryOrExitAction();

  /**
   * Returns a new object of class '<em>Activity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity</em>'.
   * @generated
   */
  Activity createActivity();

  /**
   * Returns a new object of class '<em>Guard</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard</em>'.
   * @generated
   */
  Guard createGuard();

  /**
   * Returns a new object of class '<em>Guard Code</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard Code</em>'.
   * @generated
   */
  GuardCode createGuardCode();

  /**
   * Returns a new object of class '<em>Position</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Position</em>'.
   * @generated
   */
  Position createPosition();

  /**
   * Returns a new object of class '<em>Class Position</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Position</em>'.
   * @generated
   */
  ClassPosition createClassPosition();

  /**
   * Returns a new object of class '<em>Association Position</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Position</em>'.
   * @generated
   */
  AssociationPosition createAssociationPosition();

  /**
   * Returns a new object of class '<em>Coordinate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Coordinate</em>'.
   * @generated
   */
  Coordinate createCoordinate();

  /**
   * Returns a new object of class '<em>Trace Directive</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Directive</em>'.
   * @generated
   */
  TraceDirective createTraceDirective();

  /**
   * Returns a new object of class '<em>Trace Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Case</em>'.
   * @generated
   */
  TraceCase createTraceCase();

  /**
   * Returns a new object of class '<em>Trace Record</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Record</em>'.
   * @generated
   */
  TraceRecord createTraceRecord();

  /**
   * Returns a new object of class '<em>Trace Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Condition</em>'.
   * @generated
   */
  TraceCondition createTraceCondition();

  /**
   * Returns a new object of class '<em>Compound Trace Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compound Trace Condition</em>'.
   * @generated
   */
  CompoundTraceCondition createCompoundTraceCondition();

  /**
   * Returns a new object of class '<em>Simple Trace Condition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Trace Condition</em>'.
   * @generated
   */
  SimpleTraceCondition createSimpleTraceCondition();

  /**
   * Returns a new object of class '<em>Condition RHS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Condition RHS</em>'.
   * @generated
   */
  ConditionRHS createConditionRHS();

  /**
   * Returns a new object of class '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Element</em>'.
   * @generated
   */
  ModelElement createModelElement();

  /**
   * Returns a new object of class '<em>Trace Mechanism</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Mechanism</em>'.
   * @generated
   */
  TraceMechanism createTraceMechanism();

  /**
   * Returns a new object of class '<em>par Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>par Expression</em>'.
   * @generated
   */
  parExpression createparExpression();

  /**
   * Returns a new object of class '<em>expression List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>expression List</em>'.
   * @generated
   */
  expressionList createexpressionList();

  /**
   * Returns a new object of class '<em>expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>expression</em>'.
   * @generated
   */
  expression createexpression();

  /**
   * Returns a new object of class '<em>conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>conditional Expression</em>'.
   * @generated
   */
  conditionalExpression createconditionalExpression();

  /**
   * Returns a new object of class '<em>conditional Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>conditional Or Expression</em>'.
   * @generated
   */
  conditionalOrExpression createconditionalOrExpression();

  /**
   * Returns a new object of class '<em>conditional And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>conditional And Expression</em>'.
   * @generated
   */
  conditionalAndExpression createconditionalAndExpression();

  /**
   * Returns a new object of class '<em>equality Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>equality Expression</em>'.
   * @generated
   */
  equalityExpression createequalityExpression();

  /**
   * Returns a new object of class '<em>relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>relational Expression</em>'.
   * @generated
   */
  relationalExpression createrelationalExpression();

  /**
   * Returns a new object of class '<em>additive Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>additive Expression</em>'.
   * @generated
   */
  additiveExpression createadditiveExpression();

  /**
   * Returns a new object of class '<em>multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>multiplicative Expression</em>'.
   * @generated
   */
  multiplicativeExpression createmultiplicativeExpression();

  /**
   * Returns a new object of class '<em>unary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>unary Expression</em>'.
   * @generated
   */
  unaryExpression createunaryExpression();

  /**
   * Returns a new object of class '<em>unary Expression Not Plus Minus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>unary Expression Not Plus Minus</em>'.
   * @generated
   */
  unaryExpressionNotPlusMinus createunaryExpressionNotPlusMinus();

  /**
   * Returns a new object of class '<em>primary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>primary</em>'.
   * @generated
   */
  primary createprimary();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>function Call</em>'.
   * @generated
   */
  functionCall createfunctionCall();

  /**
   * Returns a new object of class '<em>function Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>function Declaration</em>'.
   * @generated
   */
  functionDeclaration createfunctionDeclaration();

  /**
   * Returns a new object of class '<em>function Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>function Definition</em>'.
   * @generated
   */
  functionDefinition createfunctionDefinition();

  /**
   * Returns a new object of class '<em>block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>block</em>'.
   * @generated
   */
  block createblock();

  /**
   * Returns a new object of class '<em>java Function Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>java Function Declaration</em>'.
   * @generated
   */
  javaFunctionDeclaration createjavaFunctionDeclaration();

  /**
   * Returns a new object of class '<em>java Function Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>java Function Definition</em>'.
   * @generated
   */
  javaFunctionDefinition createjavaFunctionDefinition();

  /**
   * Returns a new object of class '<em>java Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>java Function Call</em>'.
   * @generated
   */
  javaFunctionCall createjavaFunctionCall();

  /**
   * Returns a new object of class '<em>java Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>java Block</em>'.
   * @generated
   */
  javaBlock createjavaBlock();

  /**
   * Returns a new object of class '<em>block Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>block Statement</em>'.
   * @generated
   */
  blockStatement createblockStatement();

  /**
   * Returns a new object of class '<em>local Variable Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>local Variable Declaration Statement</em>'.
   * @generated
   */
  localVariableDeclarationStatement createlocalVariableDeclarationStatement();

  /**
   * Returns a new object of class '<em>local Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>local Variable Declaration</em>'.
   * @generated
   */
  localVariableDeclaration createlocalVariableDeclaration();

  /**
   * Returns a new object of class '<em>variable Declarators</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>variable Declarators</em>'.
   * @generated
   */
  variableDeclarators createvariableDeclarators();

  /**
   * Returns a new object of class '<em>variable Declarator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>variable Declarator</em>'.
   * @generated
   */
  variableDeclarator createvariableDeclarator();

  /**
   * Returns a new object of class '<em>statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>statement</em>'.
   * @generated
   */
  statement createstatement();

  /**
   * Returns a new object of class '<em>for Control</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>for Control</em>'.
   * @generated
   */
  forControl createforControl();

  /**
   * Returns a new object of class '<em>for Init</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>for Init</em>'.
   * @generated
   */
  forInit createforInit();

  /**
   * Returns a new object of class '<em>for Update</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>for Update</em>'.
   * @generated
   */
  forUpdate createforUpdate();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UmplePackage getUmplePackage();

} //UmpleFactory
