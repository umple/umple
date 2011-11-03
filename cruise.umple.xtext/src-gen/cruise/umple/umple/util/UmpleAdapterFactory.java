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
      public Adapter caseUmpleModel(UmpleModel object)
      {
        return createUmpleModelAdapter();
      }
      @Override
      public Adapter caseAbstractElement(AbstractElement object)
      {
        return createAbstractElementAdapter();
      }
      @Override
      public Adapter caseGlossary(Glossary object)
      {
        return createGlossaryAdapter();
      }
      @Override
      public Adapter caseWord(Word object)
      {
        return createWordAdapter();
      }
      @Override
      public Adapter caseGenerate(Generate object)
      {
        return createGenerateAdapter();
      }
      @Override
      public Adapter caseUseStatement(UseStatement object)
      {
        return createUseStatementAdapter();
      }
      @Override
      public Adapter caseNamespace(Namespace object)
      {
        return createNamespaceAdapter();
      }
      @Override
      public Adapter caseEntity(Entity object)
      {
        return createEntityAdapter();
      }
      @Override
      public Adapter caseClassDefinition(ClassDefinition object)
      {
        return createClassDefinitionAdapter();
      }
      @Override
      public Adapter caseExternalDefinition(ExternalDefinition object)
      {
        return createExternalDefinitionAdapter();
      }
      @Override
      public Adapter caseInterfaceDefinition(InterfaceDefinition object)
      {
        return createInterfaceDefinitionAdapter();
      }
      @Override
      public Adapter caseAssociationDefinition(AssociationDefinition object)
      {
        return createAssociationDefinitionAdapter();
      }
      @Override
      public Adapter caseClassContent(ClassContent object)
      {
        return createClassContentAdapter();
      }
      @Override
      public Adapter caseAssociationClassContent(AssociationClassContent object)
      {
        return createAssociationClassContentAdapter();
      }
      @Override
      public Adapter caseDepend(Depend object)
      {
        return createDependAdapter();
      }
      @Override
      public Adapter caseAssociation(Association object)
      {
        return createAssociationAdapter();
      }
      @Override
      public Adapter caseSymmetricReflexiveAssociation(SymmetricReflexiveAssociation object)
      {
        return createSymmetricReflexiveAssociationAdapter();
      }
      @Override
      public Adapter caseInlineAssociation(InlineAssociation object)
      {
        return createInlineAssociationAdapter();
      }
      @Override
      public Adapter caseSingleAssociationEnd(SingleAssociationEnd object)
      {
        return createSingleAssociationEndAdapter();
      }
      @Override
      public Adapter caseAssociationClassDefinition(AssociationClassDefinition object)
      {
        return createAssociationClassDefinitionAdapter();
      }
      @Override
      public Adapter caseSoftwarePattern(SoftwarePattern object)
      {
        return createSoftwarePatternAdapter();
      }
      @Override
      public Adapter caseisA(isA object)
      {
        return createisAAdapter();
      }
      @Override
      public Adapter caseSingleton(Singleton object)
      {
        return createSingletonAdapter();
      }
      @Override
      public Adapter caseKeyDefinition(KeyDefinition object)
      {
        return createKeyDefinitionAdapter();
      }
      @Override
      public Adapter caseCodeInjection(CodeInjection object)
      {
        return createCodeInjectionAdapter();
      }
      @Override
      public Adapter caseAttribute(Attribute object)
      {
        return createAttributeAdapter();
      }
      @Override
      public Adapter casePosition(Position object)
      {
        return createPositionAdapter();
      }
      @Override
      public Adapter caseElementPosition(ElementPosition object)
      {
        return createElementPositionAdapter();
      }
      @Override
      public Adapter caseAssociationPosition(AssociationPosition object)
      {
        return createAssociationPositionAdapter();
      }
      @Override
      public Adapter caseCoordinate(Coordinate object)
      {
        return createCoordinateAdapter();
      }
      @Override
      public Adapter caseUmpleElement(UmpleElement object)
      {
        return createUmpleElementAdapter();
      }
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
      public Adapter caseKey(Key object)
      {
        return createKeyAdapter();
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UmpleModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UmpleModel
   * @generated
   */
  public Adapter createUmpleModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AbstractElement
   * @generated
   */
  public Adapter createAbstractElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Glossary <em>Glossary</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Glossary
   * @generated
   */
  public Adapter createGlossaryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Word <em>Word</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Word
   * @generated
   */
  public Adapter createWordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Generate <em>Generate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Generate
   * @generated
   */
  public Adapter createGenerateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UseStatement <em>Use Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UseStatement
   * @generated
   */
  public Adapter createUseStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Namespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Namespace
   * @generated
   */
  public Adapter createNamespaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Entity
   * @generated
   */
  public Adapter createEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ClassDefinition <em>Class Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ClassDefinition
   * @generated
   */
  public Adapter createClassDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ExternalDefinition <em>External Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ExternalDefinition
   * @generated
   */
  public Adapter createExternalDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InterfaceDefinition <em>Interface Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InterfaceDefinition
   * @generated
   */
  public Adapter createInterfaceDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationDefinition <em>Association Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationDefinition
   * @generated
   */
  public Adapter createAssociationDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ClassContent <em>Class Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ClassContent
   * @generated
   */
  public Adapter createClassContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationClassContent <em>Association Class Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationClassContent
   * @generated
   */
  public Adapter createAssociationClassContentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Depend <em>Depend</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Depend
   * @generated
   */
  public Adapter createDependAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Association
   * @generated
   */
  public Adapter createAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SymmetricReflexiveAssociation <em>Symmetric Reflexive Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SymmetricReflexiveAssociation
   * @generated
   */
  public Adapter createSymmetricReflexiveAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InlineAssociation <em>Inline Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InlineAssociation
   * @generated
   */
  public Adapter createInlineAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SingleAssociationEnd <em>Single Association End</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SingleAssociationEnd
   * @generated
   */
  public Adapter createSingleAssociationEndAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationClassDefinition <em>Association Class Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationClassDefinition
   * @generated
   */
  public Adapter createAssociationClassDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SoftwarePattern <em>Software Pattern</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SoftwarePattern
   * @generated
   */
  public Adapter createSoftwarePatternAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.isA <em>is A</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.isA
   * @generated
   */
  public Adapter createisAAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Singleton <em>Singleton</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Singleton
   * @generated
   */
  public Adapter createSingletonAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.KeyDefinition <em>Key Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.KeyDefinition
   * @generated
   */
  public Adapter createKeyDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.CodeInjection <em>Code Injection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.CodeInjection
   * @generated
   */
  public Adapter createCodeInjectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Attribute
   * @generated
   */
  public Adapter createAttributeAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Position <em>Position</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Position
   * @generated
   */
  public Adapter createPositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ElementPosition <em>Element Position</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ElementPosition
   * @generated
   */
  public Adapter createElementPositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.AssociationPosition <em>Association Position</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.AssociationPosition
   * @generated
   */
  public Adapter createAssociationPositionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Coordinate <em>Coordinate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Coordinate
   * @generated
   */
  public Adapter createCoordinateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UmpleElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UmpleElement
   * @generated
   */
  public Adapter createUmpleElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.block <em>block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.block
   * @generated
   */
  public Adapter createblockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.parExpression <em>par Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.parExpression
   * @generated
   */
  public Adapter createparExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.expressionList <em>expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.expressionList
   * @generated
   */
  public Adapter createexpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.expression <em>expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.expression
   * @generated
   */
  public Adapter createexpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.conditionalExpression <em>conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.conditionalExpression
   * @generated
   */
  public Adapter createconditionalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.conditionalOrExpression <em>conditional Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.conditionalOrExpression
   * @generated
   */
  public Adapter createconditionalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.conditionalAndExpression <em>conditional And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.conditionalAndExpression
   * @generated
   */
  public Adapter createconditionalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.equalityExpression <em>equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.equalityExpression
   * @generated
   */
  public Adapter createequalityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.relationalExpression <em>relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.relationalExpression
   * @generated
   */
  public Adapter createrelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.additiveExpression <em>additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.additiveExpression
   * @generated
   */
  public Adapter createadditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.multiplicativeExpression <em>multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.multiplicativeExpression
   * @generated
   */
  public Adapter createmultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.unaryExpression <em>unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.unaryExpression
   * @generated
   */
  public Adapter createunaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.unaryExpressionNotPlusMinus <em>unary Expression Not Plus Minus</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.unaryExpressionNotPlusMinus
   * @generated
   */
  public Adapter createunaryExpressionNotPlusMinusAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.primary <em>primary</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.primary
   * @generated
   */
  public Adapter createprimaryAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.literal <em>literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.literal
   * @generated
   */
  public Adapter createliteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.functionCall <em>function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.functionCall
   * @generated
   */
  public Adapter createfunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.functionDeclaration <em>function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.functionDeclaration
   * @generated
   */
  public Adapter createfunctionDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.functionDefinition <em>function Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.functionDefinition
   * @generated
   */
  public Adapter createfunctionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.javaFunctionDeclaration <em>java Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.javaFunctionDeclaration
   * @generated
   */
  public Adapter createjavaFunctionDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.javaFunctionDefinition <em>java Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.javaFunctionDefinition
   * @generated
   */
  public Adapter createjavaFunctionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.javaFunctionCall <em>java Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.javaFunctionCall
   * @generated
   */
  public Adapter createjavaFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.blockStatement <em>block Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.blockStatement
   * @generated
   */
  public Adapter createblockStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.localVariableDeclarationStatement <em>local Variable Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.localVariableDeclarationStatement
   * @generated
   */
  public Adapter createlocalVariableDeclarationStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.localVariableDeclaration <em>local Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.localVariableDeclaration
   * @generated
   */
  public Adapter createlocalVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.variableDeclarators <em>variable Declarators</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.variableDeclarators
   * @generated
   */
  public Adapter createvariableDeclaratorsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.variableDeclarator <em>variable Declarator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.variableDeclarator
   * @generated
   */
  public Adapter createvariableDeclaratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.statement <em>statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.statement
   * @generated
   */
  public Adapter createstatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.forControl <em>for Control</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.forControl
   * @generated
   */
  public Adapter createforControlAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.forInit <em>for Init</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.forInit
   * @generated
   */
  public Adapter createforInitAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.forUpdate <em>for Update</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.forUpdate
   * @generated
   */
  public Adapter createforUpdateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.phpFunction <em>php Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.phpFunction
   * @generated
   */
  public Adapter createphpFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.phpBlock <em>php Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.phpBlock
   * @generated
   */
  public Adapter createphpBlockAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Key <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Key
   * @generated
   */
  public Adapter createKeyAdapter()
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
