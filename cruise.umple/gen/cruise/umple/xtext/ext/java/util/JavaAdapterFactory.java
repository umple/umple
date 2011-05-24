/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java.util;

import cruise.umple.xtext.ext.java.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see cruise.umple.xtext.ext.java.JavaPackage
 * @generated
 */
public class JavaAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static JavaPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = JavaPackage.eINSTANCE;
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
  protected JavaSwitch<Adapter> modelSwitch =
    new JavaSwitch<Adapter>()
    {
      @Override
      public Adapter caseblock(block object)
      {
        return createblockAdapter();
      }
      @Override
      public Adapter caseparExpression(parExpression object)
      {
        return createparExpressionAdapter();
      }
      @Override
      public Adapter caseexpressionList(expressionList object)
      {
        return createexpressionListAdapter();
      }
      @Override
      public Adapter caseexpression(expression object)
      {
        return createexpressionAdapter();
      }
      @Override
      public Adapter caseconditionalExpression(conditionalExpression object)
      {
        return createconditionalExpressionAdapter();
      }
      @Override
      public Adapter caseconditionalOrExpression(conditionalOrExpression object)
      {
        return createconditionalOrExpressionAdapter();
      }
      @Override
      public Adapter caseconditionalAndExpression(conditionalAndExpression object)
      {
        return createconditionalAndExpressionAdapter();
      }
      @Override
      public Adapter caseequalityExpression(equalityExpression object)
      {
        return createequalityExpressionAdapter();
      }
      @Override
      public Adapter caserelationalExpression(relationalExpression object)
      {
        return createrelationalExpressionAdapter();
      }
      @Override
      public Adapter caseadditiveExpression(additiveExpression object)
      {
        return createadditiveExpressionAdapter();
      }
      @Override
      public Adapter casemultiplicativeExpression(multiplicativeExpression object)
      {
        return createmultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter caseunaryExpression(unaryExpression object)
      {
        return createunaryExpressionAdapter();
      }
      @Override
      public Adapter caseunaryExpressionNotPlusMinus(unaryExpressionNotPlusMinus object)
      {
        return createunaryExpressionNotPlusMinusAdapter();
      }
      @Override
      public Adapter caseprimary(primary object)
      {
        return createprimaryAdapter();
      }
      @Override
      public Adapter caseliteral(literal object)
      {
        return createliteralAdapter();
      }
      @Override
      public Adapter casefunctionCall(functionCall object)
      {
        return createfunctionCallAdapter();
      }
      @Override
      public Adapter casefunctionDeclaration(functionDeclaration object)
      {
        return createfunctionDeclarationAdapter();
      }
      @Override
      public Adapter casefunctionDefinition(functionDefinition object)
      {
        return createfunctionDefinitionAdapter();
      }
      @Override
      public Adapter casejavaFunctionDeclaration(javaFunctionDeclaration object)
      {
        return createjavaFunctionDeclarationAdapter();
      }
      @Override
      public Adapter casejavaFunctionDefinition(javaFunctionDefinition object)
      {
        return createjavaFunctionDefinitionAdapter();
      }
      @Override
      public Adapter casejavaFunctionCall(javaFunctionCall object)
      {
        return createjavaFunctionCallAdapter();
      }
      @Override
      public Adapter caseblockStatement(blockStatement object)
      {
        return createblockStatementAdapter();
      }
      @Override
      public Adapter caselocalVariableDeclarationStatement(localVariableDeclarationStatement object)
      {
        return createlocalVariableDeclarationStatementAdapter();
      }
      @Override
      public Adapter caselocalVariableDeclaration(localVariableDeclaration object)
      {
        return createlocalVariableDeclarationAdapter();
      }
      @Override
      public Adapter casevariableDeclarators(variableDeclarators object)
      {
        return createvariableDeclaratorsAdapter();
      }
      @Override
      public Adapter casevariableDeclarator(variableDeclarator object)
      {
        return createvariableDeclaratorAdapter();
      }
      @Override
      public Adapter casestatement(statement object)
      {
        return createstatementAdapter();
      }
      @Override
      public Adapter caseforControl(forControl object)
      {
        return createforControlAdapter();
      }
      @Override
      public Adapter caseforInit(forInit object)
      {
        return createforInitAdapter();
      }
      @Override
      public Adapter caseforUpdate(forUpdate object)
      {
        return createforUpdateAdapter();
      }
      @Override
      public Adapter casephpFunction(phpFunction object)
      {
        return createphpFunctionAdapter();
      }
      @Override
      public Adapter casephpBlock(phpBlock object)
      {
        return createphpBlockAdapter();
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
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.block <em>block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.block
   * @generated
   */
  public Adapter createblockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.parExpression <em>par Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.parExpression
   * @generated
   */
  public Adapter createparExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.expressionList <em>expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.expressionList
   * @generated
   */
  public Adapter createexpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.expression <em>expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.expression
   * @generated
   */
  public Adapter createexpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.conditionalExpression <em>conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.conditionalExpression
   * @generated
   */
  public Adapter createconditionalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.conditionalOrExpression <em>conditional Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.conditionalOrExpression
   * @generated
   */
  public Adapter createconditionalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.conditionalAndExpression <em>conditional And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.conditionalAndExpression
   * @generated
   */
  public Adapter createconditionalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.equalityExpression <em>equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.equalityExpression
   * @generated
   */
  public Adapter createequalityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.relationalExpression <em>relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.relationalExpression
   * @generated
   */
  public Adapter createrelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.additiveExpression <em>additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.additiveExpression
   * @generated
   */
  public Adapter createadditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.multiplicativeExpression <em>multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.multiplicativeExpression
   * @generated
   */
  public Adapter createmultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.unaryExpression <em>unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.unaryExpression
   * @generated
   */
  public Adapter createunaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.unaryExpressionNotPlusMinus <em>unary Expression Not Plus Minus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.unaryExpressionNotPlusMinus
   * @generated
   */
  public Adapter createunaryExpressionNotPlusMinusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.primary <em>primary</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.primary
   * @generated
   */
  public Adapter createprimaryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.literal <em>literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.literal
   * @generated
   */
  public Adapter createliteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.functionCall <em>function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.functionCall
   * @generated
   */
  public Adapter createfunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.functionDeclaration <em>function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.functionDeclaration
   * @generated
   */
  public Adapter createfunctionDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.functionDefinition <em>function Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.functionDefinition
   * @generated
   */
  public Adapter createfunctionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.javaFunctionDeclaration <em>java Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.javaFunctionDeclaration
   * @generated
   */
  public Adapter createjavaFunctionDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.javaFunctionDefinition <em>java Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.javaFunctionDefinition
   * @generated
   */
  public Adapter createjavaFunctionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.javaFunctionCall <em>java Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.javaFunctionCall
   * @generated
   */
  public Adapter createjavaFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.blockStatement <em>block Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.blockStatement
   * @generated
   */
  public Adapter createblockStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.localVariableDeclarationStatement <em>local Variable Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.localVariableDeclarationStatement
   * @generated
   */
  public Adapter createlocalVariableDeclarationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.localVariableDeclaration <em>local Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.localVariableDeclaration
   * @generated
   */
  public Adapter createlocalVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.variableDeclarators <em>variable Declarators</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.variableDeclarators
   * @generated
   */
  public Adapter createvariableDeclaratorsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.variableDeclarator <em>variable Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.variableDeclarator
   * @generated
   */
  public Adapter createvariableDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.statement <em>statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.statement
   * @generated
   */
  public Adapter createstatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.forControl <em>for Control</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.forControl
   * @generated
   */
  public Adapter createforControlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.forInit <em>for Init</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.forInit
   * @generated
   */
  public Adapter createforInitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.forUpdate <em>for Update</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.forUpdate
   * @generated
   */
  public Adapter createforUpdateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.phpFunction <em>php Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.phpFunction
   * @generated
   */
  public Adapter createphpFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.xtext.ext.java.phpBlock <em>php Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.xtext.ext.java.phpBlock
   * @generated
   */
  public Adapter createphpBlockAdapter()
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

} //JavaAdapterFactory
