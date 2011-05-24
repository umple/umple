/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see cruise.umple.xtext.ext.java.JavaPackage
 * @generated
 */
public interface JavaFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JavaFactory eINSTANCE = cruise.umple.xtext.ext.java.impl.JavaFactoryImpl.init();

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
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  JavaPackage getJavaPackage();

} //JavaFactory
