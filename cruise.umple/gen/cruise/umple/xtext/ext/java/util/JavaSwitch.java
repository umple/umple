/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java.util;

import cruise.umple.xtext.ext.java.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see cruise.umple.xtext.ext.java.JavaPackage
 * @generated
 */
public class JavaSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static JavaPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = JavaPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case JavaPackage.BLOCK:
      {
        block block = (block)theEObject;
        T result = caseblock(block);
        if (result == null) result = casestatement(block);
        if (result == null) result = caseblockStatement(block);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.PAR_EXPRESSION:
      {
        parExpression parExpression = (parExpression)theEObject;
        T result = caseparExpression(parExpression);
        if (result == null) result = caseprimary(parExpression);
        if (result == null) result = caseunaryExpressionNotPlusMinus(parExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.EXPRESSION_LIST:
      {
        expressionList expressionList = (expressionList)theEObject;
        T result = caseexpressionList(expressionList);
        if (result == null) result = caseforUpdate(expressionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.EXPRESSION:
      {
        expression expression = (expression)theEObject;
        T result = caseexpression(expression);
        if (result == null) result = caseparExpression(expression);
        if (result == null) result = casestatement(expression);
        if (result == null) result = caseprimary(expression);
        if (result == null) result = caseblockStatement(expression);
        if (result == null) result = caseunaryExpressionNotPlusMinus(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.CONDITIONAL_EXPRESSION:
      {
        conditionalExpression conditionalExpression = (conditionalExpression)theEObject;
        T result = caseconditionalExpression(conditionalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.CONDITIONAL_OR_EXPRESSION:
      {
        conditionalOrExpression conditionalOrExpression = (conditionalOrExpression)theEObject;
        T result = caseconditionalOrExpression(conditionalOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.CONDITIONAL_AND_EXPRESSION:
      {
        conditionalAndExpression conditionalAndExpression = (conditionalAndExpression)theEObject;
        T result = caseconditionalAndExpression(conditionalAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.EQUALITY_EXPRESSION:
      {
        equalityExpression equalityExpression = (equalityExpression)theEObject;
        T result = caseequalityExpression(equalityExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.RELATIONAL_EXPRESSION:
      {
        relationalExpression relationalExpression = (relationalExpression)theEObject;
        T result = caserelationalExpression(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.ADDITIVE_EXPRESSION:
      {
        additiveExpression additiveExpression = (additiveExpression)theEObject;
        T result = caseadditiveExpression(additiveExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.MULTIPLICATIVE_EXPRESSION:
      {
        multiplicativeExpression multiplicativeExpression = (multiplicativeExpression)theEObject;
        T result = casemultiplicativeExpression(multiplicativeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.UNARY_EXPRESSION:
      {
        unaryExpression unaryExpression = (unaryExpression)theEObject;
        T result = caseunaryExpression(unaryExpression);
        if (result == null) result = caseunaryExpressionNotPlusMinus(unaryExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.UNARY_EXPRESSION_NOT_PLUS_MINUS:
      {
        unaryExpressionNotPlusMinus unaryExpressionNotPlusMinus = (unaryExpressionNotPlusMinus)theEObject;
        T result = caseunaryExpressionNotPlusMinus(unaryExpressionNotPlusMinus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.PRIMARY:
      {
        primary primary = (primary)theEObject;
        T result = caseprimary(primary);
        if (result == null) result = caseunaryExpressionNotPlusMinus(primary);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.LITERAL:
      {
        literal literal = (literal)theEObject;
        T result = caseliteral(literal);
        if (result == null) result = caseprimary(literal);
        if (result == null) result = caseunaryExpressionNotPlusMinus(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.FUNCTION_CALL:
      {
        functionCall functionCall = (functionCall)theEObject;
        T result = casefunctionCall(functionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.FUNCTION_DECLARATION:
      {
        functionDeclaration functionDeclaration = (functionDeclaration)theEObject;
        T result = casefunctionDeclaration(functionDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.FUNCTION_DEFINITION:
      {
        functionDefinition functionDefinition = (functionDefinition)theEObject;
        T result = casefunctionDefinition(functionDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.JAVA_FUNCTION_DECLARATION:
      {
        javaFunctionDeclaration javaFunctionDeclaration = (javaFunctionDeclaration)theEObject;
        T result = casejavaFunctionDeclaration(javaFunctionDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.JAVA_FUNCTION_DEFINITION:
      {
        javaFunctionDefinition javaFunctionDefinition = (javaFunctionDefinition)theEObject;
        T result = casejavaFunctionDefinition(javaFunctionDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.JAVA_FUNCTION_CALL:
      {
        javaFunctionCall javaFunctionCall = (javaFunctionCall)theEObject;
        T result = casejavaFunctionCall(javaFunctionCall);
        if (result == null) result = caseliteral(javaFunctionCall);
        if (result == null) result = casefunctionCall(javaFunctionCall);
        if (result == null) result = caseprimary(javaFunctionCall);
        if (result == null) result = caseunaryExpressionNotPlusMinus(javaFunctionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.BLOCK_STATEMENT:
      {
        blockStatement blockStatement = (blockStatement)theEObject;
        T result = caseblockStatement(blockStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.LOCAL_VARIABLE_DECLARATION_STATEMENT:
      {
        localVariableDeclarationStatement localVariableDeclarationStatement = (localVariableDeclarationStatement)theEObject;
        T result = caselocalVariableDeclarationStatement(localVariableDeclarationStatement);
        if (result == null) result = caseblockStatement(localVariableDeclarationStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.LOCAL_VARIABLE_DECLARATION:
      {
        localVariableDeclaration localVariableDeclaration = (localVariableDeclaration)theEObject;
        T result = caselocalVariableDeclaration(localVariableDeclaration);
        if (result == null) result = caselocalVariableDeclarationStatement(localVariableDeclaration);
        if (result == null) result = caseforInit(localVariableDeclaration);
        if (result == null) result = caseblockStatement(localVariableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.VARIABLE_DECLARATORS:
      {
        variableDeclarators variableDeclarators = (variableDeclarators)theEObject;
        T result = casevariableDeclarators(variableDeclarators);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.VARIABLE_DECLARATOR:
      {
        variableDeclarator variableDeclarator = (variableDeclarator)theEObject;
        T result = casevariableDeclarator(variableDeclarator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.STATEMENT:
      {
        statement statement = (statement)theEObject;
        T result = casestatement(statement);
        if (result == null) result = caseblockStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.FOR_CONTROL:
      {
        forControl forControl = (forControl)theEObject;
        T result = caseforControl(forControl);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.FOR_INIT:
      {
        forInit forInit = (forInit)theEObject;
        T result = caseforInit(forInit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.FOR_UPDATE:
      {
        forUpdate forUpdate = (forUpdate)theEObject;
        T result = caseforUpdate(forUpdate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.PHP_FUNCTION:
      {
        phpFunction phpFunction = (phpFunction)theEObject;
        T result = casephpFunction(phpFunction);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case JavaPackage.PHP_BLOCK:
      {
        phpBlock phpBlock = (phpBlock)theEObject;
        T result = casephpBlock(phpBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseblock(block object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>par Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>par Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseparExpression(parExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>expression List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>expression List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseexpressionList(expressionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseexpression(expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>conditional Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseconditionalExpression(conditionalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>conditional Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>conditional Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseconditionalOrExpression(conditionalOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>conditional And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>conditional And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseconditionalAndExpression(conditionalAndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>equality Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>equality Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseequalityExpression(equalityExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>relational Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>relational Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserelationalExpression(relationalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>additive Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>additive Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseadditiveExpression(additiveExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>multiplicative Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>multiplicative Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casemultiplicativeExpression(multiplicativeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>unary Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>unary Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseunaryExpression(unaryExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>unary Expression Not Plus Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>unary Expression Not Plus Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseunaryExpressionNotPlusMinus(unaryExpressionNotPlusMinus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>primary</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>primary</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseprimary(primary object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseliteral(literal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casefunctionCall(functionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>function Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>function Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casefunctionDeclaration(functionDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>function Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>function Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casefunctionDefinition(functionDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>java Function Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>java Function Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casejavaFunctionDeclaration(javaFunctionDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>java Function Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>java Function Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casejavaFunctionDefinition(javaFunctionDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>java Function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>java Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casejavaFunctionCall(javaFunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>block Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>block Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseblockStatement(blockStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>local Variable Declaration Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>local Variable Declaration Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caselocalVariableDeclarationStatement(localVariableDeclarationStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>local Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>local Variable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caselocalVariableDeclaration(localVariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>variable Declarators</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>variable Declarators</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casevariableDeclarators(variableDeclarators object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>variable Declarator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>variable Declarator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casevariableDeclarator(variableDeclarator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casestatement(statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>for Control</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>for Control</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseforControl(forControl object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>for Init</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>for Init</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseforInit(forInit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>for Update</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>for Update</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseforUpdate(forUpdate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>php Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>php Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casephpFunction(phpFunction object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>php Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>php Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casephpBlock(phpBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //JavaSwitch
