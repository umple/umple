/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java.impl;

import cruise.umple.xtext.ext.java.*;

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
public class JavaFactoryImpl extends EFactoryImpl implements JavaFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static JavaFactory init()
  {
    try
    {
      JavaFactory theJavaFactory = (JavaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.umple.cruise/xtext/ext/Java"); 
      if (theJavaFactory != null)
      {
        return theJavaFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new JavaFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaFactoryImpl()
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
      case JavaPackage.BLOCK: return createblock();
      case JavaPackage.PAR_EXPRESSION: return createparExpression();
      case JavaPackage.EXPRESSION_LIST: return createexpressionList();
      case JavaPackage.EXPRESSION: return createexpression();
      case JavaPackage.CONDITIONAL_EXPRESSION: return createconditionalExpression();
      case JavaPackage.CONDITIONAL_OR_EXPRESSION: return createconditionalOrExpression();
      case JavaPackage.CONDITIONAL_AND_EXPRESSION: return createconditionalAndExpression();
      case JavaPackage.EQUALITY_EXPRESSION: return createequalityExpression();
      case JavaPackage.RELATIONAL_EXPRESSION: return createrelationalExpression();
      case JavaPackage.ADDITIVE_EXPRESSION: return createadditiveExpression();
      case JavaPackage.MULTIPLICATIVE_EXPRESSION: return createmultiplicativeExpression();
      case JavaPackage.UNARY_EXPRESSION: return createunaryExpression();
      case JavaPackage.UNARY_EXPRESSION_NOT_PLUS_MINUS: return createunaryExpressionNotPlusMinus();
      case JavaPackage.PRIMARY: return createprimary();
      case JavaPackage.LITERAL: return createliteral();
      case JavaPackage.FUNCTION_CALL: return createfunctionCall();
      case JavaPackage.FUNCTION_DECLARATION: return createfunctionDeclaration();
      case JavaPackage.FUNCTION_DEFINITION: return createfunctionDefinition();
      case JavaPackage.JAVA_FUNCTION_DECLARATION: return createjavaFunctionDeclaration();
      case JavaPackage.JAVA_FUNCTION_DEFINITION: return createjavaFunctionDefinition();
      case JavaPackage.JAVA_FUNCTION_CALL: return createjavaFunctionCall();
      case JavaPackage.BLOCK_STATEMENT: return createblockStatement();
      case JavaPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT: return createlocalVariableDeclarationStatement();
      case JavaPackage.LOCAL_VARIABLE_DECLARATION: return createlocalVariableDeclaration();
      case JavaPackage.VARIABLE_DECLARATORS: return createvariableDeclarators();
      case JavaPackage.VARIABLE_DECLARATOR: return createvariableDeclarator();
      case JavaPackage.STATEMENT: return createstatement();
      case JavaPackage.FOR_CONTROL: return createforControl();
      case JavaPackage.FOR_INIT: return createforInit();
      case JavaPackage.FOR_UPDATE: return createforUpdate();
      case JavaPackage.PHP_FUNCTION: return createphpFunction();
      case JavaPackage.PHP_BLOCK: return createphpBlock();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
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
  public JavaPackage getJavaPackage()
  {
    return (JavaPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static JavaPackage getPackage()
  {
    return JavaPackage.eINSTANCE;
  }

} //JavaFactoryImpl
