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
   * Returns a new object of class '<em>Abstract Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Element</em>'.
   * @generated
   */
  AbstractElement createAbstractElement();

  /**
   * Returns a new object of class '<em>Glossary</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Glossary</em>'.
   * @generated
   */
  Glossary createGlossary();

  /**
   * Returns a new object of class '<em>Word</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Word</em>'.
   * @generated
   */
  Word createWord();

  /**
   * Returns a new object of class '<em>Generate</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Generate</em>'.
   * @generated
   */
  Generate createGenerate();

  /**
   * Returns a new object of class '<em>Use Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Use Statement</em>'.
   * @generated
   */
  UseStatement createUseStatement();

  /**
   * Returns a new object of class '<em>Namespace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Namespace</em>'.
   * @generated
   */
  Namespace createNamespace();

  /**
   * Returns a new object of class '<em>Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entity</em>'.
   * @generated
   */
  Entity createEntity();

  /**
   * Returns a new object of class '<em>Class Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Definition</em>'.
   * @generated
   */
  ClassDefinition createClassDefinition();

  /**
   * Returns a new object of class '<em>External Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Definition</em>'.
   * @generated
   */
  ExternalDefinition createExternalDefinition();

  /**
   * Returns a new object of class '<em>Interface Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interface Definition</em>'.
   * @generated
   */
  InterfaceDefinition createInterfaceDefinition();

  /**
   * Returns a new object of class '<em>Association Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Definition</em>'.
   * @generated
   */
  AssociationDefinition createAssociationDefinition();

  /**
   * Returns a new object of class '<em>Class Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Content</em>'.
   * @generated
   */
  ClassContent createClassContent();

  /**
   * Returns a new object of class '<em>Association Class Content</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Class Content</em>'.
   * @generated
   */
  AssociationClassContent createAssociationClassContent();

  /**
   * Returns a new object of class '<em>Depend</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Depend</em>'.
   * @generated
   */
  Depend createDepend();

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
   * Returns a new object of class '<em>Single Association End</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Association End</em>'.
   * @generated
   */
  SingleAssociationEnd createSingleAssociationEnd();

  /**
   * Returns a new object of class '<em>Association Class Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Class Definition</em>'.
   * @generated
   */
  AssociationClassDefinition createAssociationClassDefinition();

  /**
   * Returns a new object of class '<em>Software Pattern</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Software Pattern</em>'.
   * @generated
   */
  SoftwarePattern createSoftwarePattern();

  /**
   * Returns a new object of class '<em>is A</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>is A</em>'.
   * @generated
   */
  isA createisA();

  /**
   * Returns a new object of class '<em>Singleton</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Singleton</em>'.
   * @generated
   */
  Singleton createSingleton();

  /**
   * Returns a new object of class '<em>Key Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key Definition</em>'.
   * @generated
   */
  KeyDefinition createKeyDefinition();

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
  Attribute createAttribute();

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
   * Returns a new object of class '<em>Enum</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum</em>'.
   * @generated
   */
  Enum createEnum();

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
   * Returns a new object of class '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event</em>'.
   * @generated
   */
  Event createEvent();

  /**
   * Returns a new object of class '<em>After Every Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>After Every Event</em>'.
   * @generated
   */
  AfterEveryEvent createAfterEveryEvent();

  /**
   * Returns a new object of class '<em>After Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>After Event</em>'.
   * @generated
   */
  AfterEvent createAfterEvent();

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
   * Returns a new object of class '<em>Element Position</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element Position</em>'.
   * @generated
   */
  ElementPosition createElementPosition();

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
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  UmpleElement createUmpleElement();

  /**
   * Returns a new object of class '<em>block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>block</em>'.
   * @generated
   */
  block createblock();

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
   * Returns a new object of class '<em>literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>literal</em>'.
   * @generated
   */
  literal createliteral();

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
   * Returns a new object of class '<em>endstatement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>endstatement</em>'.
   * @generated
   */
  endstatement createendstatement();

  /**
   * Returns a new object of class '<em>breakstatement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>breakstatement</em>'.
   * @generated
   */
  breakstatement createbreakstatement();

  /**
   * Returns a new object of class '<em>ifstatement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ifstatement</em>'.
   * @generated
   */
  ifstatement createifstatement();

  /**
   * Returns a new object of class '<em>forstatement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>forstatement</em>'.
   * @generated
   */
  forstatement createforstatement();

  /**
   * Returns a new object of class '<em>whilestatement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>whilestatement</em>'.
   * @generated
   */
  whilestatement createwhilestatement();

  /**
   * Returns a new object of class '<em>returnstatement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>returnstatement</em>'.
   * @generated
   */
  returnstatement createreturnstatement();

  /**
   * Returns a new object of class '<em>expressionstatement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>expressionstatement</em>'.
   * @generated
   */
  expressionstatement createexpressionstatement();

  /**
   * Returns a new object of class '<em>trystatement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>trystatement</em>'.
   * @generated
   */
  trystatement createtrystatement();

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
   * Returns a new object of class '<em>php Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>php Function</em>'.
   * @generated
   */
  phpFunction createphpFunction();

  /**
   * Returns a new object of class '<em>php Block</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>php Block</em>'.
   * @generated
   */
  phpBlock createphpBlock();

  /**
   * Returns a new object of class '<em>Key</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key</em>'.
   * @generated
   */
  Key createKey();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UmplePackage getUmplePackage();

} //UmpleFactory
