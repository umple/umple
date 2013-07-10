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
  Model createModel();

  /**
   * Returns a new object of class '<em>Program </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Program </em>'.
   * @generated
   */
  Program_ createProgram_();

  /**
   * Returns a new object of class '<em>Anonymous program 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous program 1</em>'.
   * @generated
   */
  Anonymous_program_1_ createAnonymous_program_1_();

  /**
   * Returns a new object of class '<em>Directive </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Directive </em>'.
   * @generated
   */
  Directive_ createDirective_();

  /**
   * Returns a new object of class '<em>Glossary </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Glossary </em>'.
   * @generated
   */
  Glossary_ createGlossary_();

  /**
   * Returns a new object of class '<em>Word </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Word </em>'.
   * @generated
   */
  Word_ createWord_();

  /**
   * Returns a new object of class '<em>Strictness </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Strictness </em>'.
   * @generated
   */
  Strictness_ createStrictness_();

  /**
   * Returns a new object of class '<em>Anonymous strictness 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous strictness 1</em>'.
   * @generated
   */
  Anonymous_strictness_1_ createAnonymous_strictness_1_();

  /**
   * Returns a new object of class '<em>Generate </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Generate </em>'.
   * @generated
   */
  Generate_ createGenerate_();

  /**
   * Returns a new object of class '<em>Generate path </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Generate path </em>'.
   * @generated
   */
  Generate_path_ createGenerate_path_();

  /**
   * Returns a new object of class '<em>Use Statement </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Use Statement </em>'.
   * @generated
   */
  UseStatement_ createUseStatement_();

  /**
   * Returns a new object of class '<em>Namespace </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Namespace </em>'.
   * @generated
   */
  Namespace_ createNamespace_();

  /**
   * Returns a new object of class '<em>Entity </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entity </em>'.
   * @generated
   */
  Entity_ createEntity_();

  /**
   * Returns a new object of class '<em>Comment </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comment </em>'.
   * @generated
   */
  Comment_ createComment_();

  /**
   * Returns a new object of class '<em>Inline Comment </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inline Comment </em>'.
   * @generated
   */
  InlineComment_ createInlineComment_();

  /**
   * Returns a new object of class '<em>Multiline Comment </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiline Comment </em>'.
   * @generated
   */
  MultilineComment_ createMultilineComment_();

  /**
   * Returns a new object of class '<em>Debug </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Debug </em>'.
   * @generated
   */
  Debug_ createDebug_();

  /**
   * Returns a new object of class '<em>Abstract </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract </em>'.
   * @generated
   */
  Abstract_ createAbstract_();

  /**
   * Returns a new object of class '<em>Class Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Definition </em>'.
   * @generated
   */
  ClassDefinition_ createClassDefinition_();

  /**
   * Returns a new object of class '<em>External Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>External Definition </em>'.
   * @generated
   */
  ExternalDefinition_ createExternalDefinition_();

  /**
   * Returns a new object of class '<em>Interface Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interface Definition </em>'.
   * @generated
   */
  InterfaceDefinition_ createInterfaceDefinition_();

  /**
   * Returns a new object of class '<em>Association Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Definition </em>'.
   * @generated
   */
  AssociationDefinition_ createAssociationDefinition_();

  /**
   * Returns a new object of class '<em>Association Class Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Class Definition </em>'.
   * @generated
   */
  AssociationClassDefinition_ createAssociationClassDefinition_();

  /**
   * Returns a new object of class '<em>Class Content </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Class Content </em>'.
   * @generated
   */
  ClassContent_ createClassContent_();

  /**
   * Returns a new object of class '<em>Association Class Content </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Class Content </em>'.
   * @generated
   */
  AssociationClassContent_ createAssociationClassContent_();

  /**
   * Returns a new object of class '<em>Interface Body </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interface Body </em>'.
   * @generated
   */
  InterfaceBody_ createInterfaceBody_();

  /**
   * Returns a new object of class '<em>Interface Member Declaration </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Interface Member Declaration </em>'.
   * @generated
   */
  InterfaceMemberDeclaration_ createInterfaceMemberDeclaration_();

  /**
   * Returns a new object of class '<em>Constant Declaration </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Declaration </em>'.
   * @generated
   */
  ConstantDeclaration_ createConstantDeclaration_();

  /**
   * Returns a new object of class '<em>Anonymous constant Declaration 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous constant Declaration 1</em>'.
   * @generated
   */
  Anonymous_constantDeclaration_1_ createAnonymous_constantDeclaration_1_();

  /**
   * Returns a new object of class '<em>Anonymous constant Declaration 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous constant Declaration 2</em>'.
   * @generated
   */
  Anonymous_constantDeclaration_2_ createAnonymous_constantDeclaration_2_();

  /**
   * Returns a new object of class '<em>More Code </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>More Code </em>'.
   * @generated
   */
  MoreCode_ createMoreCode_();

  /**
   * Returns a new object of class '<em>Anonymous more Code 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous more Code 1</em>'.
   * @generated
   */
  Anonymous_moreCode_1_ createAnonymous_moreCode_1_();

  /**
   * Returns a new object of class '<em>Code Langs </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Code Langs </em>'.
   * @generated
   */
  CodeLangs_ createCodeLangs_();

  /**
   * Returns a new object of class '<em>Anonymous code Langs 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous code Langs 1</em>'.
   * @generated
   */
  Anonymous_codeLangs_1_ createAnonymous_codeLangs_1_();

  /**
   * Returns a new object of class '<em>Code Lang </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Code Lang </em>'.
   * @generated
   */
  CodeLang_ createCodeLang_();

  /**
   * Returns a new object of class '<em>Method Body </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method Body </em>'.
   * @generated
   */
  MethodBody_ createMethodBody_();

  /**
   * Returns a new object of class '<em>Anonymous method Body 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous method Body 1</em>'.
   * @generated
   */
  Anonymous_methodBody_1_ createAnonymous_methodBody_1_();

  /**
   * Returns a new object of class '<em>Anonymous method Body 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous method Body 2</em>'.
   * @generated
   */
  Anonymous_methodBody_2_ createAnonymous_methodBody_2_();

  /**
   * Returns a new object of class '<em>Concrete Method Declaration </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concrete Method Declaration </em>'.
   * @generated
   */
  ConcreteMethodDeclaration_ createConcreteMethodDeclaration_();

  /**
   * Returns a new object of class '<em>Anonymous concrete Method Declaration 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous concrete Method Declaration 1</em>'.
   * @generated
   */
  Anonymous_concreteMethodDeclaration_1_ createAnonymous_concreteMethodDeclaration_1_();

  /**
   * Returns a new object of class '<em>Anonymous concrete Method Declaration 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous concrete Method Declaration 2</em>'.
   * @generated
   */
  Anonymous_concreteMethodDeclaration_2_ createAnonymous_concreteMethodDeclaration_2_();

  /**
   * Returns a new object of class '<em>Abstract Method Declaration </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Method Declaration </em>'.
   * @generated
   */
  AbstractMethodDeclaration_ createAbstractMethodDeclaration_();

  /**
   * Returns a new object of class '<em>Method Declarator </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method Declarator </em>'.
   * @generated
   */
  MethodDeclarator_ createMethodDeclarator_();

  /**
   * Returns a new object of class '<em>Parameter List </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter List </em>'.
   * @generated
   */
  ParameterList_ createParameterList_();

  /**
   * Returns a new object of class '<em>Anonymous parameter List 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous parameter List 1</em>'.
   * @generated
   */
  Anonymous_parameterList_1_ createAnonymous_parameterList_1_();

  /**
   * Returns a new object of class '<em>Parameter </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter </em>'.
   * @generated
   */
  Parameter_ createParameter_();

  /**
   * Returns a new object of class '<em>Anonymous parameter 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous parameter 1</em>'.
   * @generated
   */
  Anonymous_parameter_1_ createAnonymous_parameter_1_();

  /**
   * Returns a new object of class '<em>Association </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association </em>'.
   * @generated
   */
  Association_ createAssociation_();

  /**
   * Returns a new object of class '<em>Symmetric Reflexive Association </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Symmetric Reflexive Association </em>'.
   * @generated
   */
  SymmetricReflexiveAssociation_ createSymmetricReflexiveAssociation_();

  /**
   * Returns a new object of class '<em>Inline Association </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inline Association </em>'.
   * @generated
   */
  InlineAssociation_ createInlineAssociation_();

  /**
   * Returns a new object of class '<em>Inline Association End </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inline Association End </em>'.
   * @generated
   */
  InlineAssociationEnd_ createInlineAssociationEnd_();

  /**
   * Returns a new object of class '<em>Single Association End </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Association End </em>'.
   * @generated
   */
  SingleAssociationEnd_ createSingleAssociationEnd_();

  /**
   * Returns a new object of class '<em>Association End </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association End </em>'.
   * @generated
   */
  AssociationEnd_ createAssociationEnd_();

  /**
   * Returns a new object of class '<em>Multiplicity </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity </em>'.
   * @generated
   */
  Multiplicity_ createMultiplicity_();

  /**
   * Returns a new object of class '<em>Is Sorted </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Is Sorted </em>'.
   * @generated
   */
  IsSorted_ createIsSorted_();

  /**
   * Returns a new object of class '<em>Attribute </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute </em>'.
   * @generated
   */
  Attribute_ createAttribute_();

  /**
   * Returns a new object of class '<em>Simple Attribute </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple Attribute </em>'.
   * @generated
   */
  SimpleAttribute_ createSimpleAttribute_();

  /**
   * Returns a new object of class '<em>Autounique Attribute </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Autounique Attribute </em>'.
   * @generated
   */
  AutouniqueAttribute_ createAutouniqueAttribute_();

  /**
   * Returns a new object of class '<em>Derived Attribute </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Derived Attribute </em>'.
   * @generated
   */
  DerivedAttribute_ createDerivedAttribute_();

  /**
   * Returns a new object of class '<em>Anonymous derived Attribute 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous derived Attribute 1</em>'.
   * @generated
   */
  Anonymous_derivedAttribute_1_ createAnonymous_derivedAttribute_1_();

  /**
   * Returns a new object of class '<em>Anonymous derived Attribute 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous derived Attribute 2</em>'.
   * @generated
   */
  Anonymous_derivedAttribute_2_ createAnonymous_derivedAttribute_2_();

  /**
   * Returns a new object of class '<em>Anonymous derived Attribute 3</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous derived Attribute 3</em>'.
   * @generated
   */
  Anonymous_derivedAttribute_3_ createAnonymous_derivedAttribute_3_();

  /**
   * Returns a new object of class '<em>Complex Attribute </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Complex Attribute </em>'.
   * @generated
   */
  ComplexAttribute_ createComplexAttribute_();

  /**
   * Returns a new object of class '<em>Anonymous complex Attribute 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous complex Attribute 1</em>'.
   * @generated
   */
  Anonymous_complexAttribute_1_ createAnonymous_complexAttribute_1_();

  /**
   * Returns a new object of class '<em>Anonymous complex Attribute 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous complex Attribute 2</em>'.
   * @generated
   */
  Anonymous_complexAttribute_2_ createAnonymous_complexAttribute_2_();

  /**
   * Returns a new object of class '<em>Key </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key </em>'.
   * @generated
   */
  Key_ createKey_();

  /**
   * Returns a new object of class '<em>Anonymous key 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous key 1</em>'.
   * @generated
   */
  Anonymous_key_1_ createAnonymous_key_1_();

  /**
   * Returns a new object of class '<em>Depend </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Depend </em>'.
   * @generated
   */
  Depend_ createDepend_();

  /**
   * Returns a new object of class '<em>Extra Code </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extra Code </em>'.
   * @generated
   */
  ExtraCode_ createExtraCode_();

  /**
   * Returns a new object of class '<em>Software Pattern </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Software Pattern </em>'.
   * @generated
   */
  SoftwarePattern_ createSoftwarePattern_();

  /**
   * Returns a new object of class '<em>Is A</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Is A</em>'.
   * @generated
   */
  IsA_ createIsA_();

  /**
   * Returns a new object of class '<em>Single Is A</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Single Is A</em>'.
   * @generated
   */
  SingleIsA_ createSingleIsA_();

  /**
   * Returns a new object of class '<em>Anonymous single Is A1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous single Is A1</em>'.
   * @generated
   */
  Anonymous_singleIsA_1_ createAnonymous_singleIsA_1_();

  /**
   * Returns a new object of class '<em>Multiple Is A</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiple Is A</em>'.
   * @generated
   */
  MultipleIsA_ createMultipleIsA_();

  /**
   * Returns a new object of class '<em>Anonymous multiple Is A1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous multiple Is A1</em>'.
   * @generated
   */
  Anonymous_multipleIsA_1_ createAnonymous_multipleIsA_1_();

  /**
   * Returns a new object of class '<em>Singleton </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Singleton </em>'.
   * @generated
   */
  Singleton_ createSingleton_();

  /**
   * Returns a new object of class '<em>Immutable </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Immutable </em>'.
   * @generated
   */
  Immutable_ createImmutable_();

  /**
   * Returns a new object of class '<em>Key Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key Definition </em>'.
   * @generated
   */
  KeyDefinition_ createKeyDefinition_();

  /**
   * Returns a new object of class '<em>Code Injection </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Code Injection </em>'.
   * @generated
   */
  CodeInjection_ createCodeInjection_();

  /**
   * Returns a new object of class '<em>Before Code </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Before Code </em>'.
   * @generated
   */
  BeforeCode_ createBeforeCode_();

  /**
   * Returns a new object of class '<em>Anonymous before Code 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous before Code 1</em>'.
   * @generated
   */
  Anonymous_beforeCode_1_ createAnonymous_beforeCode_1_();

  /**
   * Returns a new object of class '<em>Anonymous before Code 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous before Code 2</em>'.
   * @generated
   */
  Anonymous_beforeCode_2_ createAnonymous_beforeCode_2_();

  /**
   * Returns a new object of class '<em>After Code </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>After Code </em>'.
   * @generated
   */
  AfterCode_ createAfterCode_();

  /**
   * Returns a new object of class '<em>Anonymous after Code 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous after Code 1</em>'.
   * @generated
   */
  Anonymous_afterCode_1_ createAnonymous_afterCode_1_();

  /**
   * Returns a new object of class '<em>Anonymous after Code 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous after Code 2</em>'.
   * @generated
   */
  Anonymous_afterCode_2_ createAnonymous_afterCode_2_();

  /**
   * Returns a new object of class '<em>State Machine Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Machine Definition </em>'.
   * @generated
   */
  StateMachineDefinition_ createStateMachineDefinition_();

  /**
   * Returns a new object of class '<em>State Machine </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Machine </em>'.
   * @generated
   */
  StateMachine_ createStateMachine_();

  /**
   * Returns a new object of class '<em>Active Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Active Definition </em>'.
   * @generated
   */
  ActiveDefinition_ createActiveDefinition_();

  /**
   * Returns a new object of class '<em>Inline State Machine </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inline State Machine </em>'.
   * @generated
   */
  InlineStateMachine_ createInlineStateMachine_();

  /**
   * Returns a new object of class '<em>Anonymous inline State Machine 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous inline State Machine 1</em>'.
   * @generated
   */
  Anonymous_inlineStateMachine_1_ createAnonymous_inlineStateMachine_1_();

  /**
   * Returns a new object of class '<em>Referenced State Machine </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Referenced State Machine </em>'.
   * @generated
   */
  ReferencedStateMachine_ createReferencedStateMachine_();

  /**
   * Returns a new object of class '<em>Extended State Machine </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extended State Machine </em>'.
   * @generated
   */
  ExtendedStateMachine_ createExtendedStateMachine_();

  /**
   * Returns a new object of class '<em>Anonymous extended State Machine 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous extended State Machine 1</em>'.
   * @generated
   */
  Anonymous_extendedStateMachine_1_ createAnonymous_extendedStateMachine_1_();

  /**
   * Returns a new object of class '<em>Enum </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum </em>'.
   * @generated
   */
  Enum_ createEnum_();

  /**
   * Returns a new object of class '<em>Anonymous enum 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous enum 1</em>'.
   * @generated
   */
  Anonymous_enum_1_ createAnonymous_enum_1_();

  /**
   * Returns a new object of class '<em>State </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State </em>'.
   * @generated
   */
  State_ createState_();

  /**
   * Returns a new object of class '<em>Anonymous state 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous state 1</em>'.
   * @generated
   */
  Anonymous_state_1_ createAnonymous_state_1_();

  /**
   * Returns a new object of class '<em>State Internal </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Internal </em>'.
   * @generated
   */
  StateInternal_ createStateInternal_();

  /**
   * Returns a new object of class '<em>State Entity </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>State Entity </em>'.
   * @generated
   */
  StateEntity_ createStateEntity_();

  /**
   * Returns a new object of class '<em>Auto Transition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Auto Transition </em>'.
   * @generated
   */
  AutoTransition_ createAutoTransition_();

  /**
   * Returns a new object of class '<em>Auto Transition Block </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Auto Transition Block </em>'.
   * @generated
   */
  AutoTransitionBlock_ createAutoTransitionBlock_();

  /**
   * Returns a new object of class '<em>Transition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transition </em>'.
   * @generated
   */
  Transition_ createTransition_();

  /**
   * Returns a new object of class '<em>Event Definition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event Definition </em>'.
   * @generated
   */
  EventDefinition_ createEventDefinition_();

  /**
   * Returns a new object of class '<em>Anonymous event Definition 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous event Definition 1</em>'.
   * @generated
   */
  Anonymous_eventDefinition_1_ createAnonymous_eventDefinition_1_();

  /**
   * Returns a new object of class '<em>After Every Event </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>After Every Event </em>'.
   * @generated
   */
  AfterEveryEvent_ createAfterEveryEvent_();

  /**
   * Returns a new object of class '<em>After Event </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>After Event </em>'.
   * @generated
   */
  AfterEvent_ createAfterEvent_();

  /**
   * Returns a new object of class '<em>Action </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action </em>'.
   * @generated
   */
  Action_ createAction_();

  /**
   * Returns a new object of class '<em>Anonymous action 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous action 1</em>'.
   * @generated
   */
  Anonymous_action_1_ createAnonymous_action_1_();

  /**
   * Returns a new object of class '<em>Anonymous action 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous action 2</em>'.
   * @generated
   */
  Anonymous_action_2_ createAnonymous_action_2_();

  /**
   * Returns a new object of class '<em>Entry Or Exit Action </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entry Or Exit Action </em>'.
   * @generated
   */
  EntryOrExitAction_ createEntryOrExitAction_();

  /**
   * Returns a new object of class '<em>Anonymous entry Or Exit Action 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous entry Or Exit Action 1</em>'.
   * @generated
   */
  Anonymous_entryOrExitAction_1_ createAnonymous_entryOrExitAction_1_();

  /**
   * Returns a new object of class '<em>Anonymous entry Or Exit Action 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous entry Or Exit Action 2</em>'.
   * @generated
   */
  Anonymous_entryOrExitAction_2_ createAnonymous_entryOrExitAction_2_();

  /**
   * Returns a new object of class '<em>Activity </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Activity </em>'.
   * @generated
   */
  Activity_ createActivity_();

  /**
   * Returns a new object of class '<em>Anonymous activity 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous activity 1</em>'.
   * @generated
   */
  Anonymous_activity_1_ createAnonymous_activity_1_();

  /**
   * Returns a new object of class '<em>Anonymous activity 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous activity 2</em>'.
   * @generated
   */
  Anonymous_activity_2_ createAnonymous_activity_2_();

  /**
   * Returns a new object of class '<em>More Guards </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>More Guards </em>'.
   * @generated
   */
  MoreGuards_ createMoreGuards_();

  /**
   * Returns a new object of class '<em>Anonymous more Guards 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous more Guards 1</em>'.
   * @generated
   */
  Anonymous_moreGuards_1_ createAnonymous_moreGuards_1_();

  /**
   * Returns a new object of class '<em>Guard </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Guard </em>'.
   * @generated
   */
  Guard_ createGuard_();

  /**
   * Returns a new object of class '<em>Anonymous guard 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous guard 1</em>'.
   * @generated
   */
  Anonymous_guard_1_ createAnonymous_guard_1_();

  /**
   * Returns a new object of class '<em>Anonymous guard 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous guard 2</em>'.
   * @generated
   */
  Anonymous_guard_2_ createAnonymous_guard_2_();

  /**
   * Returns a new object of class '<em>Trace Type </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Type </em>'.
   * @generated
   */
  TraceType_ createTraceType_();

  /**
   * Returns a new object of class '<em>Anonymous trace Type 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous trace Type 1</em>'.
   * @generated
   */
  Anonymous_traceType_1_ createAnonymous_traceType_1_();

  /**
   * Returns a new object of class '<em>Anonymous trace Type 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous trace Type 2</em>'.
   * @generated
   */
  Anonymous_traceType_2_ createAnonymous_traceType_2_();

  /**
   * Returns a new object of class '<em>Trace </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace </em>'.
   * @generated
   */
  Trace_ createTrace_();

  /**
   * Returns a new object of class '<em>Trace Directive </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Directive </em>'.
   * @generated
   */
  TraceDirective_ createTraceDirective_();

  /**
   * Returns a new object of class '<em>Anonymous trace Directive 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous trace Directive 1</em>'.
   * @generated
   */
  Anonymous_traceDirective_1_ createAnonymous_traceDirective_1_();

  /**
   * Returns a new object of class '<em>Trace Item </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Item </em>'.
   * @generated
   */
  TraceItem_ createTraceItem_();

  /**
   * Returns a new object of class '<em>Trace Entity </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Entity </em>'.
   * @generated
   */
  TraceEntity_ createTraceEntity_();

  /**
   * Returns a new object of class '<em>Anonymous trace Entity 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous trace Entity 1</em>'.
   * @generated
   */
  Anonymous_traceEntity_1_ createAnonymous_traceEntity_1_();

  /**
   * Returns a new object of class '<em>Trace Options </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Options </em>'.
   * @generated
   */
  TraceOptions_ createTraceOptions_();

  /**
   * Returns a new object of class '<em>Anonymous trace Options 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous trace Options 1</em>'.
   * @generated
   */
  Anonymous_traceOptions_1_ createAnonymous_traceOptions_1_();

  /**
   * Returns a new object of class '<em>Trace Option </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Option </em>'.
   * @generated
   */
  TraceOption_ createTraceOption_();

  /**
   * Returns a new object of class '<em>Pre Or Post Condition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pre Or Post Condition </em>'.
   * @generated
   */
  PreOrPostCondition_ createPreOrPostCondition_();

  /**
   * Returns a new object of class '<em>Execute Clause </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Execute Clause </em>'.
   * @generated
   */
  ExecuteClause_ createExecuteClause_();

  /**
   * Returns a new object of class '<em>Trace When </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace When </em>'.
   * @generated
   */
  TraceWhen_ createTraceWhen_();

  /**
   * Returns a new object of class '<em>Trace For </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace For </em>'.
   * @generated
   */
  TraceFor_ createTraceFor_();

  /**
   * Returns a new object of class '<em>Trace Level </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Level </em>'.
   * @generated
   */
  TraceLevel_ createTraceLevel_();

  /**
   * Returns a new object of class '<em>Trace Period </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Period </em>'.
   * @generated
   */
  TracePeriod_ createTracePeriod_();

  /**
   * Returns a new object of class '<em>Trace During </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace During </em>'.
   * @generated
   */
  TraceDuring_ createTraceDuring_();

  /**
   * Returns a new object of class '<em>Trace Record </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Record </em>'.
   * @generated
   */
  TraceRecord_ createTraceRecord_();

  /**
   * Returns a new object of class '<em>Record Entity </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Entity </em>'.
   * @generated
   */
  RecordEntity_ createRecordEntity_();

  /**
   * Returns a new object of class '<em>Anonymous record Entity 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous record Entity 2</em>'.
   * @generated
   */
  Anonymous_recordEntity_2_ createAnonymous_recordEntity_2_();

  /**
   * Returns a new object of class '<em>Trace Condition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Condition </em>'.
   * @generated
   */
  TraceCondition_ createTraceCondition_();

  /**
   * Returns a new object of class '<em>Condition RHS </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Condition RHS </em>'.
   * @generated
   */
  ConditionRHS_ createConditionRHS_();

  /**
   * Returns a new object of class '<em>Trace Case </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Case </em>'.
   * @generated
   */
  TraceCase_ createTraceCase_();

  /**
   * Returns a new object of class '<em>Trace Case Def </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Case Def </em>'.
   * @generated
   */
  TraceCaseDef_ createTraceCaseDef_();

  /**
   * Returns a new object of class '<em>Trace Case Activation </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Case Activation </em>'.
   * @generated
   */
  TraceCaseActivation_ createTraceCaseActivation_();

  /**
   * Returns a new object of class '<em>Trace Case Deactivation </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace Case Deactivation </em>'.
   * @generated
   */
  TraceCaseDeactivation_ createTraceCaseDeactivation_();

  /**
   * Returns a new object of class '<em>De Activate For </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>De Activate For </em>'.
   * @generated
   */
  DeActivateFor_ createDeActivateFor_();

  /**
   * Returns a new object of class '<em>Precondition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Precondition </em>'.
   * @generated
   */
  Precondition_ createPrecondition_();

  /**
   * Returns a new object of class '<em>Postcondition </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Postcondition </em>'.
   * @generated
   */
  Postcondition_ createPostcondition_();

  /**
   * Returns a new object of class '<em>Invariant </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invariant </em>'.
   * @generated
   */
  Invariant_ createInvariant_();

  /**
   * Returns a new object of class '<em>Anonymous invariant 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous invariant 1</em>'.
   * @generated
   */
  Anonymous_invariant_1_ createAnonymous_invariant_1_();

  /**
   * Returns a new object of class '<em>Anonymous invariant 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous invariant 2</em>'.
   * @generated
   */
  Anonymous_invariant_2_ createAnonymous_invariant_2_();

  /**
   * Returns a new object of class '<em>Constraint Token </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Token </em>'.
   * @generated
   */
  ConstraintToken_ createConstraintToken_();

  /**
   * Returns a new object of class '<em>Constraint </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint </em>'.
   * @generated
   */
  Constraint_ createConstraint_();

  /**
   * Returns a new object of class '<em>Anonymous constraint 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous constraint 1</em>'.
   * @generated
   */
  Anonymous_constraint_1_ createAnonymous_constraint_1_();

  /**
   * Returns a new object of class '<em>Negative Constraint </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Negative Constraint </em>'.
   * @generated
   */
  NegativeConstraint_ createNegativeConstraint_();

  /**
   * Returns a new object of class '<em>Constraint Body </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Body </em>'.
   * @generated
   */
  ConstraintBody_ createConstraintBody_();

  /**
   * Returns a new object of class '<em>Anonymous constraint Body 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous constraint Body 1</em>'.
   * @generated
   */
  Anonymous_constraintBody_1_ createAnonymous_constraintBody_1_();

  /**
   * Returns a new object of class '<em>Linking Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Linking Op </em>'.
   * @generated
   */
  LinkingOp_ createLinkingOp_();

  /**
   * Returns a new object of class '<em>Anonymous linking Op 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous linking Op 1</em>'.
   * @generated
   */
  Anonymous_linkingOp_1_ createAnonymous_linkingOp_1_();

  /**
   * Returns a new object of class '<em>Anonymous linking Op 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous linking Op 2</em>'.
   * @generated
   */
  Anonymous_linkingOp_2_ createAnonymous_linkingOp_2_();

  /**
   * Returns a new object of class '<em>Anonymous linking Op 3</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous linking Op 3</em>'.
   * @generated
   */
  Anonymous_linkingOp_3_ createAnonymous_linkingOp_3_();

  /**
   * Returns a new object of class '<em>Constraint Expr </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint Expr </em>'.
   * @generated
   */
  ConstraintExpr_ createConstraintExpr_();

  /**
   * Returns a new object of class '<em>Anonymous constraint Expr 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous constraint Expr 1</em>'.
   * @generated
   */
  Anonymous_constraintExpr_1_ createAnonymous_constraintExpr_1_();

  /**
   * Returns a new object of class '<em>Compound Expr </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Compound Expr </em>'.
   * @generated
   */
  CompoundExpr_ createCompoundExpr_();

  /**
   * Returns a new object of class '<em>Bool Expr </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bool Expr </em>'.
   * @generated
   */
  BoolExpr_ createBoolExpr_();

  /**
   * Returns a new object of class '<em>String Expr </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Expr </em>'.
   * @generated
   */
  StringExpr_ createStringExpr_();

  /**
   * Returns a new object of class '<em>String Lit </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Lit </em>'.
   * @generated
   */
  StringLit_ createStringLit_();

  /**
   * Returns a new object of class '<em>Gen Expr </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Gen Expr </em>'.
   * @generated
   */
  GenExpr_ createGenExpr_();

  /**
   * Returns a new object of class '<em>Anonymous gen Expr 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous gen Expr 1</em>'.
   * @generated
   */
  Anonymous_genExpr_1_ createAnonymous_genExpr_1_();

  /**
   * Returns a new object of class '<em>Anonymous gen Expr 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous gen Expr 2</em>'.
   * @generated
   */
  Anonymous_genExpr_2_ createAnonymous_genExpr_2_();

  /**
   * Returns a new object of class '<em>Num Expr </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Num Expr </em>'.
   * @generated
   */
  NumExpr_ createNumExpr_();

  /**
   * Returns a new object of class '<em>Anonymous num Expr 1</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous num Expr 1</em>'.
   * @generated
   */
  Anonymous_numExpr_1_ createAnonymous_numExpr_1_();

  /**
   * Returns a new object of class '<em>Anonymous num Expr 2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous num Expr 2</em>'.
   * @generated
   */
  Anonymous_numExpr_2_ createAnonymous_numExpr_2_();

  /**
   * Returns a new object of class '<em>Anonymous num Expr 3</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous num Expr 3</em>'.
   * @generated
   */
  Anonymous_numExpr_3_ createAnonymous_numExpr_3_();

  /**
   * Returns a new object of class '<em>Anonymous num Expr 4</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Anonymous num Expr 4</em>'.
   * @generated
   */
  Anonymous_numExpr_4_ createAnonymous_numExpr_4_();

  /**
   * Returns a new object of class '<em>Equality Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equality Op </em>'.
   * @generated
   */
  EqualityOp_ createEqualityOp_();

  /**
   * Returns a new object of class '<em>Equals Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equals Op </em>'.
   * @generated
   */
  EqualsOp_ createEqualsOp_();

  /**
   * Returns a new object of class '<em>Notequals Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Notequals Op </em>'.
   * @generated
   */
  NotequalsOp_ createNotequalsOp_();

  /**
   * Returns a new object of class '<em>Ordinal Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ordinal Op </em>'.
   * @generated
   */
  OrdinalOp_ createOrdinalOp_();

  /**
   * Returns a new object of class '<em>Greater Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Greater Op </em>'.
   * @generated
   */
  GreaterOp_ createGreaterOp_();

  /**
   * Returns a new object of class '<em>Less Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Less Op </em>'.
   * @generated
   */
  LessOp_ createLessOp_();

  /**
   * Returns a new object of class '<em>More Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>More Op </em>'.
   * @generated
   */
  MoreOp_ createMoreOp_();

  /**
   * Returns a new object of class '<em>Smaller Op </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Smaller Op </em>'.
   * @generated
   */
  SmallerOp_ createSmallerOp_();

  /**
   * Returns a new object of class '<em>Position </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Position </em>'.
   * @generated
   */
  Position_ createPosition_();

  /**
   * Returns a new object of class '<em>Element Position </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element Position </em>'.
   * @generated
   */
  ElementPosition_ createElementPosition_();

  /**
   * Returns a new object of class '<em>Association Position </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Position </em>'.
   * @generated
   */
  AssociationPosition_ createAssociationPosition_();

  /**
   * Returns a new object of class '<em>Coordinate </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Coordinate </em>'.
   * @generated
   */
  Coordinate_ createCoordinate_();

  /**
   * Returns a new object of class '<em>Display Color </em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Display Color </em>'.
   * @generated
   */
  DisplayColor_ createDisplayColor_();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  UmplePackage getUmplePackage();

} //UmpleFactory
