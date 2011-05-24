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
      public Adapter caseUmpleElement(UmpleElement object)
      {
        return createUmpleElementAdapter();
      }
      @Override
      public Adapter caseWord(Word object)
      {
        return createWordAdapter();
      }
      @Override
      public Adapter caseGlossary(Glossary object)
      {
        return createGlossaryAdapter();
      }
      @Override
      public Adapter caseNamespace(Namespace object)
      {
        return createNamespaceAdapter();
      }
      @Override
      public Adapter caseUmpleClass(UmpleClass object)
      {
        return createUmpleClassAdapter();
      }
      @Override
      public Adapter caseUmpleInterface(UmpleInterface object)
      {
        return createUmpleInterfaceAdapter();
      }
      @Override
      public Adapter caseUmpleAssociation(UmpleAssociation object)
      {
        return createUmpleAssociationAdapter();
      }
      @Override
      public Adapter caseUmpleAssociationClass(UmpleAssociationClass object)
      {
        return createUmpleAssociationClassAdapter();
      }
      @Override
      public Adapter caseassociationClassContent(associationClassContent object)
      {
        return createassociationClassContentAdapter();
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
      public Adapter casesingleAssociationEnd(singleAssociationEnd object)
      {
        return createsingleAssociationEndAdapter();
      }
      @Override
      public Adapter caseSingleton(Singleton object)
      {
        return createSingletonAdapter();
      }
      @Override
      public Adapter caseCodeInjection(CodeInjection object)
      {
        return createCodeInjectionAdapter();
      }
      @Override
      public Adapter caseUmpleAttribute(UmpleAttribute object)
      {
        return createUmpleAttributeAdapter();
      }
      @Override
      public Adapter caseKey(Key object)
      {
        return createKeyAdapter();
      }
      @Override
      public Adapter caseDepend(Depend object)
      {
        return createDependAdapter();
      }
      @Override
      public Adapter caseStateMachineDefinition(StateMachineDefinition object)
      {
        return createStateMachineDefinitionAdapter();
      }
      @Override
      public Adapter caseStateMachine(StateMachine object)
      {
        return createStateMachineAdapter();
      }
      @Override
      public Adapter caseInlineStateMachine(InlineStateMachine object)
      {
        return createInlineStateMachineAdapter();
      }
      @Override
      public Adapter caseReferencedStateMachine(ReferencedStateMachine object)
      {
        return createReferencedStateMachineAdapter();
      }
      @Override
      public Adapter caseENUM(ENUM object)
      {
        return createENUMAdapter();
      }
      @Override
      public Adapter caseState(State object)
      {
        return createStateAdapter();
      }
      @Override
      public Adapter caseStateEntity(StateEntity object)
      {
        return createStateEntityAdapter();
      }
      @Override
      public Adapter caseTransition(Transition object)
      {
        return createTransitionAdapter();
      }
      @Override
      public Adapter caseEventDefinition(EventDefinition object)
      {
        return createEventDefinitionAdapter();
      }
      @Override
      public Adapter caseAction(Action object)
      {
        return createActionAdapter();
      }
      @Override
      public Adapter caseEntryOrExitAction(EntryOrExitAction object)
      {
        return createEntryOrExitActionAdapter();
      }
      @Override
      public Adapter caseActivity(Activity object)
      {
        return createActivityAdapter();
      }
      @Override
      public Adapter caseGuard(Guard object)
      {
        return createGuardAdapter();
      }
      @Override
      public Adapter caseGuardCode(GuardCode object)
      {
        return createGuardCodeAdapter();
      }
      @Override
      public Adapter casePosition(Position object)
      {
        return createPositionAdapter();
      }
      @Override
      public Adapter caseClassPosition(ClassPosition object)
      {
        return createClassPositionAdapter();
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
      public Adapter caseTraceDirective(TraceDirective object)
      {
        return createTraceDirectiveAdapter();
      }
      @Override
      public Adapter caseTraceCase(TraceCase object)
      {
        return createTraceCaseAdapter();
      }
      @Override
      public Adapter caseTraceRecord(TraceRecord object)
      {
        return createTraceRecordAdapter();
      }
      @Override
      public Adapter caseTraceCondition(TraceCondition object)
      {
        return createTraceConditionAdapter();
      }
      @Override
      public Adapter caseCompoundTraceCondition(CompoundTraceCondition object)
      {
        return createCompoundTraceConditionAdapter();
      }
      @Override
      public Adapter caseSimpleTraceCondition(SimpleTraceCondition object)
      {
        return createSimpleTraceConditionAdapter();
      }
      @Override
      public Adapter caseConditionRHS(ConditionRHS object)
      {
        return createConditionRHSAdapter();
      }
      @Override
      public Adapter caseModelElement(ModelElement object)
      {
        return createModelElementAdapter();
      }
      @Override
      public Adapter caseTraceMechanism(TraceMechanism object)
      {
        return createTraceMechanismAdapter();
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
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
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
      public Adapter caseblock(block object)
      {
        return createblockAdapter();
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
      public Adapter casejavaBlock(javaBlock object)
      {
        return createjavaBlockAdapter();
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UmpleClass <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UmpleClass
   * @generated
   */
  public Adapter createUmpleClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UmpleInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UmpleInterface
   * @generated
   */
  public Adapter createUmpleInterfaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UmpleAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UmpleAssociation
   * @generated
   */
  public Adapter createUmpleAssociationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UmpleAssociationClass <em>Association Class</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UmpleAssociationClass
   * @generated
   */
  public Adapter createUmpleAssociationClassAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.associationClassContent <em>association Class Content</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.associationClassContent
   * @generated
   */
  public Adapter createassociationClassContentAdapter()
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.singleAssociationEnd <em>single Association End</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.singleAssociationEnd
   * @generated
   */
  public Adapter createsingleAssociationEndAdapter()
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.UmpleAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.UmpleAttribute
   * @generated
   */
  public Adapter createUmpleAttributeAdapter()
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StateMachineDefinition <em>State Machine Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StateMachineDefinition
   * @generated
   */
  public Adapter createStateMachineDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StateMachine
   * @generated
   */
  public Adapter createStateMachineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.InlineStateMachine <em>Inline State Machine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.InlineStateMachine
   * @generated
   */
  public Adapter createInlineStateMachineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ReferencedStateMachine <em>Referenced State Machine</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ReferencedStateMachine
   * @generated
   */
  public Adapter createReferencedStateMachineAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ENUM <em>ENUM</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ENUM
   * @generated
   */
  public Adapter createENUMAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.State
   * @generated
   */
  public Adapter createStateAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.StateEntity <em>State Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.StateEntity
   * @generated
   */
  public Adapter createStateEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Transition
   * @generated
   */
  public Adapter createTransitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.EventDefinition <em>Event Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.EventDefinition
   * @generated
   */
  public Adapter createEventDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Action
   * @generated
   */
  public Adapter createActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.EntryOrExitAction <em>Entry Or Exit Action</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.EntryOrExitAction
   * @generated
   */
  public Adapter createEntryOrExitActionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Activity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Activity
   * @generated
   */
  public Adapter createActivityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Guard
   * @generated
   */
  public Adapter createGuardAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.GuardCode <em>Guard Code</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.GuardCode
   * @generated
   */
  public Adapter createGuardCodeAdapter()
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ClassPosition <em>Class Position</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ClassPosition
   * @generated
   */
  public Adapter createClassPositionAdapter()
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceDirective <em>Trace Directive</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceDirective
   * @generated
   */
  public Adapter createTraceDirectiveAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceCase <em>Trace Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceCase
   * @generated
   */
  public Adapter createTraceCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceRecord <em>Trace Record</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceRecord
   * @generated
   */
  public Adapter createTraceRecordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceCondition <em>Trace Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceCondition
   * @generated
   */
  public Adapter createTraceConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.CompoundTraceCondition <em>Compound Trace Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.CompoundTraceCondition
   * @generated
   */
  public Adapter createCompoundTraceConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.SimpleTraceCondition <em>Simple Trace Condition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.SimpleTraceCondition
   * @generated
   */
  public Adapter createSimpleTraceConditionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ConditionRHS <em>Condition RHS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ConditionRHS
   * @generated
   */
  public Adapter createConditionRHSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.ModelElement
   * @generated
   */
  public Adapter createModelElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.TraceMechanism <em>Trace Mechanism</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.TraceMechanism
   * @generated
   */
  public Adapter createTraceMechanismAdapter()
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
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
   * Creates a new adapter for an object of class '{@link cruise.umple.umple.javaBlock <em>java Block</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see cruise.umple.umple.javaBlock
   * @generated
   */
  public Adapter createjavaBlockAdapter()
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
