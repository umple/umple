/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.util;

import cruise.umple.umple.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

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
 * @see cruise.umple.umple.UmplePackage
 * @generated
 */
public class UmpleSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static UmplePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = UmplePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case UmplePackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.PROGRAM_:
      {
        Program_ program_ = (Program_)theEObject;
        T result = caseProgram_(program_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_PROGRAM_1:
      {
        Anonymous_program_1_ anonymous_program_1_ = (Anonymous_program_1_)theEObject;
        T result = caseAnonymous_program_1_(anonymous_program_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.DIRECTIVE_:
      {
        Directive_ directive_ = (Directive_)theEObject;
        T result = caseDirective_(directive_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.GLOSSARY_:
      {
        Glossary_ glossary_ = (Glossary_)theEObject;
        T result = caseGlossary_(glossary_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.WORD_:
      {
        Word_ word_ = (Word_)theEObject;
        T result = caseWord_(word_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.STRICTNESS_:
      {
        Strictness_ strictness_ = (Strictness_)theEObject;
        T result = caseStrictness_(strictness_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_STRICTNESS_1:
      {
        Anonymous_strictness_1_ anonymous_strictness_1_ = (Anonymous_strictness_1_)theEObject;
        T result = caseAnonymous_strictness_1_(anonymous_strictness_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.GENERATE_:
      {
        Generate_ generate_ = (Generate_)theEObject;
        T result = caseGenerate_(generate_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.GENERATE_PATH_:
      {
        Generate_path_ generate_path_ = (Generate_path_)theEObject;
        T result = caseGenerate_path_(generate_path_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.USE_STATEMENT_:
      {
        UseStatement_ useStatement_ = (UseStatement_)theEObject;
        T result = caseUseStatement_(useStatement_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.NAMESPACE_:
      {
        Namespace_ namespace_ = (Namespace_)theEObject;
        T result = caseNamespace_(namespace_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ENTITY_:
      {
        Entity_ entity_ = (Entity_)theEObject;
        T result = caseEntity_(entity_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.COMMENT_:
      {
        Comment_ comment_ = (Comment_)theEObject;
        T result = caseComment_(comment_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.INLINE_COMMENT_:
      {
        InlineComment_ inlineComment_ = (InlineComment_)theEObject;
        T result = caseInlineComment_(inlineComment_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.MULTILINE_COMMENT_:
      {
        MultilineComment_ multilineComment_ = (MultilineComment_)theEObject;
        T result = caseMultilineComment_(multilineComment_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.DEBUG_:
      {
        Debug_ debug_ = (Debug_)theEObject;
        T result = caseDebug_(debug_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ABSTRACT_:
      {
        Abstract_ abstract_ = (Abstract_)theEObject;
        T result = caseAbstract_(abstract_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CLASS_DEFINITION_:
      {
        ClassDefinition_ classDefinition_ = (ClassDefinition_)theEObject;
        T result = caseClassDefinition_(classDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.EXTERNAL_DEFINITION_:
      {
        ExternalDefinition_ externalDefinition_ = (ExternalDefinition_)theEObject;
        T result = caseExternalDefinition_(externalDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.INTERFACE_DEFINITION_:
      {
        InterfaceDefinition_ interfaceDefinition_ = (InterfaceDefinition_)theEObject;
        T result = caseInterfaceDefinition_(interfaceDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ASSOCIATION_DEFINITION_:
      {
        AssociationDefinition_ associationDefinition_ = (AssociationDefinition_)theEObject;
        T result = caseAssociationDefinition_(associationDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ASSOCIATION_CLASS_DEFINITION_:
      {
        AssociationClassDefinition_ associationClassDefinition_ = (AssociationClassDefinition_)theEObject;
        T result = caseAssociationClassDefinition_(associationClassDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CLASS_CONTENT_:
      {
        ClassContent_ classContent_ = (ClassContent_)theEObject;
        T result = caseClassContent_(classContent_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ASSOCIATION_CLASS_CONTENT_:
      {
        AssociationClassContent_ associationClassContent_ = (AssociationClassContent_)theEObject;
        T result = caseAssociationClassContent_(associationClassContent_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.INTERFACE_BODY_:
      {
        InterfaceBody_ interfaceBody_ = (InterfaceBody_)theEObject;
        T result = caseInterfaceBody_(interfaceBody_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.INTERFACE_MEMBER_DECLARATION_:
      {
        InterfaceMemberDeclaration_ interfaceMemberDeclaration_ = (InterfaceMemberDeclaration_)theEObject;
        T result = caseInterfaceMemberDeclaration_(interfaceMemberDeclaration_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CONSTANT_DECLARATION_:
      {
        ConstantDeclaration_ constantDeclaration_ = (ConstantDeclaration_)theEObject;
        T result = caseConstantDeclaration_(constantDeclaration_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_1:
      {
        Anonymous_constantDeclaration_1_ anonymous_constantDeclaration_1_ = (Anonymous_constantDeclaration_1_)theEObject;
        T result = caseAnonymous_constantDeclaration_1_(anonymous_constantDeclaration_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_CONSTANT_DECLARATION_2:
      {
        Anonymous_constantDeclaration_2_ anonymous_constantDeclaration_2_ = (Anonymous_constantDeclaration_2_)theEObject;
        T result = caseAnonymous_constantDeclaration_2_(anonymous_constantDeclaration_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.MORE_CODE_:
      {
        MoreCode_ moreCode_ = (MoreCode_)theEObject;
        T result = caseMoreCode_(moreCode_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_MORE_CODE_1:
      {
        Anonymous_moreCode_1_ anonymous_moreCode_1_ = (Anonymous_moreCode_1_)theEObject;
        T result = caseAnonymous_moreCode_1_(anonymous_moreCode_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CODE_LANGS_:
      {
        CodeLangs_ codeLangs_ = (CodeLangs_)theEObject;
        T result = caseCodeLangs_(codeLangs_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_CODE_LANGS_1:
      {
        Anonymous_codeLangs_1_ anonymous_codeLangs_1_ = (Anonymous_codeLangs_1_)theEObject;
        T result = caseAnonymous_codeLangs_1_(anonymous_codeLangs_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CODE_LANG_:
      {
        CodeLang_ codeLang_ = (CodeLang_)theEObject;
        T result = caseCodeLang_(codeLang_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.METHOD_BODY_:
      {
        MethodBody_ methodBody_ = (MethodBody_)theEObject;
        T result = caseMethodBody_(methodBody_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_METHOD_BODY_1:
      {
        Anonymous_methodBody_1_ anonymous_methodBody_1_ = (Anonymous_methodBody_1_)theEObject;
        T result = caseAnonymous_methodBody_1_(anonymous_methodBody_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_METHOD_BODY_2:
      {
        Anonymous_methodBody_2_ anonymous_methodBody_2_ = (Anonymous_methodBody_2_)theEObject;
        T result = caseAnonymous_methodBody_2_(anonymous_methodBody_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CONCRETE_METHOD_DECLARATION_:
      {
        ConcreteMethodDeclaration_ concreteMethodDeclaration_ = (ConcreteMethodDeclaration_)theEObject;
        T result = caseConcreteMethodDeclaration_(concreteMethodDeclaration_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_CONCRETE_METHOD_DECLARATION_1:
      {
        Anonymous_concreteMethodDeclaration_1_ anonymous_concreteMethodDeclaration_1_ = (Anonymous_concreteMethodDeclaration_1_)theEObject;
        T result = caseAnonymous_concreteMethodDeclaration_1_(anonymous_concreteMethodDeclaration_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_CONCRETE_METHOD_DECLARATION_2:
      {
        Anonymous_concreteMethodDeclaration_2_ anonymous_concreteMethodDeclaration_2_ = (Anonymous_concreteMethodDeclaration_2_)theEObject;
        T result = caseAnonymous_concreteMethodDeclaration_2_(anonymous_concreteMethodDeclaration_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ABSTRACT_METHOD_DECLARATION_:
      {
        AbstractMethodDeclaration_ abstractMethodDeclaration_ = (AbstractMethodDeclaration_)theEObject;
        T result = caseAbstractMethodDeclaration_(abstractMethodDeclaration_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.METHOD_DECLARATOR_:
      {
        MethodDeclarator_ methodDeclarator_ = (MethodDeclarator_)theEObject;
        T result = caseMethodDeclarator_(methodDeclarator_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.PARAMETER_LIST_:
      {
        ParameterList_ parameterList_ = (ParameterList_)theEObject;
        T result = caseParameterList_(parameterList_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_PARAMETER_LIST_1:
      {
        Anonymous_parameterList_1_ anonymous_parameterList_1_ = (Anonymous_parameterList_1_)theEObject;
        T result = caseAnonymous_parameterList_1_(anonymous_parameterList_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.PARAMETER_:
      {
        Parameter_ parameter_ = (Parameter_)theEObject;
        T result = caseParameter_(parameter_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_PARAMETER_1:
      {
        Anonymous_parameter_1_ anonymous_parameter_1_ = (Anonymous_parameter_1_)theEObject;
        T result = caseAnonymous_parameter_1_(anonymous_parameter_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ASSOCIATION_:
      {
        Association_ association_ = (Association_)theEObject;
        T result = caseAssociation_(association_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.SYMMETRIC_REFLEXIVE_ASSOCIATION_:
      {
        SymmetricReflexiveAssociation_ symmetricReflexiveAssociation_ = (SymmetricReflexiveAssociation_)theEObject;
        T result = caseSymmetricReflexiveAssociation_(symmetricReflexiveAssociation_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.INLINE_ASSOCIATION_:
      {
        InlineAssociation_ inlineAssociation_ = (InlineAssociation_)theEObject;
        T result = caseInlineAssociation_(inlineAssociation_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.INLINE_ASSOCIATION_END_:
      {
        InlineAssociationEnd_ inlineAssociationEnd_ = (InlineAssociationEnd_)theEObject;
        T result = caseInlineAssociationEnd_(inlineAssociationEnd_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.SINGLE_ASSOCIATION_END_:
      {
        SingleAssociationEnd_ singleAssociationEnd_ = (SingleAssociationEnd_)theEObject;
        T result = caseSingleAssociationEnd_(singleAssociationEnd_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ASSOCIATION_END_:
      {
        AssociationEnd_ associationEnd_ = (AssociationEnd_)theEObject;
        T result = caseAssociationEnd_(associationEnd_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.MULTIPLICITY_:
      {
        Multiplicity_ multiplicity_ = (Multiplicity_)theEObject;
        T result = caseMultiplicity_(multiplicity_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.IS_SORTED_:
      {
        IsSorted_ isSorted_ = (IsSorted_)theEObject;
        T result = caseIsSorted_(isSorted_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ATTRIBUTE_:
      {
        Attribute_ attribute_ = (Attribute_)theEObject;
        T result = caseAttribute_(attribute_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.SIMPLE_ATTRIBUTE_:
      {
        SimpleAttribute_ simpleAttribute_ = (SimpleAttribute_)theEObject;
        T result = caseSimpleAttribute_(simpleAttribute_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.AUTOUNIQUE_ATTRIBUTE_:
      {
        AutouniqueAttribute_ autouniqueAttribute_ = (AutouniqueAttribute_)theEObject;
        T result = caseAutouniqueAttribute_(autouniqueAttribute_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.DERIVED_ATTRIBUTE_:
      {
        DerivedAttribute_ derivedAttribute_ = (DerivedAttribute_)theEObject;
        T result = caseDerivedAttribute_(derivedAttribute_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_1:
      {
        Anonymous_derivedAttribute_1_ anonymous_derivedAttribute_1_ = (Anonymous_derivedAttribute_1_)theEObject;
        T result = caseAnonymous_derivedAttribute_1_(anonymous_derivedAttribute_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_2:
      {
        Anonymous_derivedAttribute_2_ anonymous_derivedAttribute_2_ = (Anonymous_derivedAttribute_2_)theEObject;
        T result = caseAnonymous_derivedAttribute_2_(anonymous_derivedAttribute_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_DERIVED_ATTRIBUTE_3:
      {
        Anonymous_derivedAttribute_3_ anonymous_derivedAttribute_3_ = (Anonymous_derivedAttribute_3_)theEObject;
        T result = caseAnonymous_derivedAttribute_3_(anonymous_derivedAttribute_3_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.COMPLEX_ATTRIBUTE_:
      {
        ComplexAttribute_ complexAttribute_ = (ComplexAttribute_)theEObject;
        T result = caseComplexAttribute_(complexAttribute_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_COMPLEX_ATTRIBUTE_1:
      {
        Anonymous_complexAttribute_1_ anonymous_complexAttribute_1_ = (Anonymous_complexAttribute_1_)theEObject;
        T result = caseAnonymous_complexAttribute_1_(anonymous_complexAttribute_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_COMPLEX_ATTRIBUTE_2:
      {
        Anonymous_complexAttribute_2_ anonymous_complexAttribute_2_ = (Anonymous_complexAttribute_2_)theEObject;
        T result = caseAnonymous_complexAttribute_2_(anonymous_complexAttribute_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.KEY_:
      {
        Key_ key_ = (Key_)theEObject;
        T result = caseKey_(key_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_KEY_1:
      {
        Anonymous_key_1_ anonymous_key_1_ = (Anonymous_key_1_)theEObject;
        T result = caseAnonymous_key_1_(anonymous_key_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.DEPEND_:
      {
        Depend_ depend_ = (Depend_)theEObject;
        T result = caseDepend_(depend_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.EXTRA_CODE_:
      {
        ExtraCode_ extraCode_ = (ExtraCode_)theEObject;
        T result = caseExtraCode_(extraCode_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.SOFTWARE_PATTERN_:
      {
        SoftwarePattern_ softwarePattern_ = (SoftwarePattern_)theEObject;
        T result = caseSoftwarePattern_(softwarePattern_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.IS_A:
      {
        IsA_ isA_ = (IsA_)theEObject;
        T result = caseIsA_(isA_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.SINGLE_IS_A:
      {
        SingleIsA_ singleIsA_ = (SingleIsA_)theEObject;
        T result = caseSingleIsA_(singleIsA_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_SINGLE_IS_A1:
      {
        Anonymous_singleIsA_1_ anonymous_singleIsA_1_ = (Anonymous_singleIsA_1_)theEObject;
        T result = caseAnonymous_singleIsA_1_(anonymous_singleIsA_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.MULTIPLE_IS_A:
      {
        MultipleIsA_ multipleIsA_ = (MultipleIsA_)theEObject;
        T result = caseMultipleIsA_(multipleIsA_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_MULTIPLE_IS_A1:
      {
        Anonymous_multipleIsA_1_ anonymous_multipleIsA_1_ = (Anonymous_multipleIsA_1_)theEObject;
        T result = caseAnonymous_multipleIsA_1_(anonymous_multipleIsA_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.SINGLETON_:
      {
        Singleton_ singleton_ = (Singleton_)theEObject;
        T result = caseSingleton_(singleton_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.IMMUTABLE_:
      {
        Immutable_ immutable_ = (Immutable_)theEObject;
        T result = caseImmutable_(immutable_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.KEY_DEFINITION_:
      {
        KeyDefinition_ keyDefinition_ = (KeyDefinition_)theEObject;
        T result = caseKeyDefinition_(keyDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CODE_INJECTION_:
      {
        CodeInjection_ codeInjection_ = (CodeInjection_)theEObject;
        T result = caseCodeInjection_(codeInjection_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.BEFORE_CODE_:
      {
        BeforeCode_ beforeCode_ = (BeforeCode_)theEObject;
        T result = caseBeforeCode_(beforeCode_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_BEFORE_CODE_1:
      {
        Anonymous_beforeCode_1_ anonymous_beforeCode_1_ = (Anonymous_beforeCode_1_)theEObject;
        T result = caseAnonymous_beforeCode_1_(anonymous_beforeCode_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_BEFORE_CODE_2:
      {
        Anonymous_beforeCode_2_ anonymous_beforeCode_2_ = (Anonymous_beforeCode_2_)theEObject;
        T result = caseAnonymous_beforeCode_2_(anonymous_beforeCode_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.AFTER_CODE_:
      {
        AfterCode_ afterCode_ = (AfterCode_)theEObject;
        T result = caseAfterCode_(afterCode_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_AFTER_CODE_1:
      {
        Anonymous_afterCode_1_ anonymous_afterCode_1_ = (Anonymous_afterCode_1_)theEObject;
        T result = caseAnonymous_afterCode_1_(anonymous_afterCode_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_AFTER_CODE_2:
      {
        Anonymous_afterCode_2_ anonymous_afterCode_2_ = (Anonymous_afterCode_2_)theEObject;
        T result = caseAnonymous_afterCode_2_(anonymous_afterCode_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.STATE_MACHINE_DEFINITION_:
      {
        StateMachineDefinition_ stateMachineDefinition_ = (StateMachineDefinition_)theEObject;
        T result = caseStateMachineDefinition_(stateMachineDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.STATE_MACHINE_:
      {
        StateMachine_ stateMachine_ = (StateMachine_)theEObject;
        T result = caseStateMachine_(stateMachine_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ACTIVE_DEFINITION_:
      {
        ActiveDefinition_ activeDefinition_ = (ActiveDefinition_)theEObject;
        T result = caseActiveDefinition_(activeDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.INLINE_STATE_MACHINE_:
      {
        InlineStateMachine_ inlineStateMachine_ = (InlineStateMachine_)theEObject;
        T result = caseInlineStateMachine_(inlineStateMachine_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_INLINE_STATE_MACHINE_1:
      {
        Anonymous_inlineStateMachine_1_ anonymous_inlineStateMachine_1_ = (Anonymous_inlineStateMachine_1_)theEObject;
        T result = caseAnonymous_inlineStateMachine_1_(anonymous_inlineStateMachine_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.REFERENCED_STATE_MACHINE_:
      {
        ReferencedStateMachine_ referencedStateMachine_ = (ReferencedStateMachine_)theEObject;
        T result = caseReferencedStateMachine_(referencedStateMachine_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.EXTENDED_STATE_MACHINE_:
      {
        ExtendedStateMachine_ extendedStateMachine_ = (ExtendedStateMachine_)theEObject;
        T result = caseExtendedStateMachine_(extendedStateMachine_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_EXTENDED_STATE_MACHINE_1:
      {
        Anonymous_extendedStateMachine_1_ anonymous_extendedStateMachine_1_ = (Anonymous_extendedStateMachine_1_)theEObject;
        T result = caseAnonymous_extendedStateMachine_1_(anonymous_extendedStateMachine_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ENUM_:
      {
        Enum_ enum_ = (Enum_)theEObject;
        T result = caseEnum_(enum_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_ENUM_1:
      {
        Anonymous_enum_1_ anonymous_enum_1_ = (Anonymous_enum_1_)theEObject;
        T result = caseAnonymous_enum_1_(anonymous_enum_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.STATE_:
      {
        State_ state_ = (State_)theEObject;
        T result = caseState_(state_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_STATE_1:
      {
        Anonymous_state_1_ anonymous_state_1_ = (Anonymous_state_1_)theEObject;
        T result = caseAnonymous_state_1_(anonymous_state_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.STATE_INTERNAL_:
      {
        StateInternal_ stateInternal_ = (StateInternal_)theEObject;
        T result = caseStateInternal_(stateInternal_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.STATE_ENTITY_:
      {
        StateEntity_ stateEntity_ = (StateEntity_)theEObject;
        T result = caseStateEntity_(stateEntity_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.AUTO_TRANSITION_:
      {
        AutoTransition_ autoTransition_ = (AutoTransition_)theEObject;
        T result = caseAutoTransition_(autoTransition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.AUTO_TRANSITION_BLOCK_:
      {
        AutoTransitionBlock_ autoTransitionBlock_ = (AutoTransitionBlock_)theEObject;
        T result = caseAutoTransitionBlock_(autoTransitionBlock_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRANSITION_:
      {
        Transition_ transition_ = (Transition_)theEObject;
        T result = caseTransition_(transition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.EVENT_DEFINITION_:
      {
        EventDefinition_ eventDefinition_ = (EventDefinition_)theEObject;
        T result = caseEventDefinition_(eventDefinition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_EVENT_DEFINITION_1:
      {
        Anonymous_eventDefinition_1_ anonymous_eventDefinition_1_ = (Anonymous_eventDefinition_1_)theEObject;
        T result = caseAnonymous_eventDefinition_1_(anonymous_eventDefinition_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.AFTER_EVERY_EVENT_:
      {
        AfterEveryEvent_ afterEveryEvent_ = (AfterEveryEvent_)theEObject;
        T result = caseAfterEveryEvent_(afterEveryEvent_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.AFTER_EVENT_:
      {
        AfterEvent_ afterEvent_ = (AfterEvent_)theEObject;
        T result = caseAfterEvent_(afterEvent_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ACTION_:
      {
        Action_ action_ = (Action_)theEObject;
        T result = caseAction_(action_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_ACTION_1:
      {
        Anonymous_action_1_ anonymous_action_1_ = (Anonymous_action_1_)theEObject;
        T result = caseAnonymous_action_1_(anonymous_action_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_ACTION_2:
      {
        Anonymous_action_2_ anonymous_action_2_ = (Anonymous_action_2_)theEObject;
        T result = caseAnonymous_action_2_(anonymous_action_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ENTRY_OR_EXIT_ACTION_:
      {
        EntryOrExitAction_ entryOrExitAction_ = (EntryOrExitAction_)theEObject;
        T result = caseEntryOrExitAction_(entryOrExitAction_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_ENTRY_OR_EXIT_ACTION_1:
      {
        Anonymous_entryOrExitAction_1_ anonymous_entryOrExitAction_1_ = (Anonymous_entryOrExitAction_1_)theEObject;
        T result = caseAnonymous_entryOrExitAction_1_(anonymous_entryOrExitAction_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_ENTRY_OR_EXIT_ACTION_2:
      {
        Anonymous_entryOrExitAction_2_ anonymous_entryOrExitAction_2_ = (Anonymous_entryOrExitAction_2_)theEObject;
        T result = caseAnonymous_entryOrExitAction_2_(anonymous_entryOrExitAction_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ACTIVITY_:
      {
        Activity_ activity_ = (Activity_)theEObject;
        T result = caseActivity_(activity_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_ACTIVITY_1:
      {
        Anonymous_activity_1_ anonymous_activity_1_ = (Anonymous_activity_1_)theEObject;
        T result = caseAnonymous_activity_1_(anonymous_activity_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_ACTIVITY_2:
      {
        Anonymous_activity_2_ anonymous_activity_2_ = (Anonymous_activity_2_)theEObject;
        T result = caseAnonymous_activity_2_(anonymous_activity_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.MORE_GUARDS_:
      {
        MoreGuards_ moreGuards_ = (MoreGuards_)theEObject;
        T result = caseMoreGuards_(moreGuards_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_MORE_GUARDS_1:
      {
        Anonymous_moreGuards_1_ anonymous_moreGuards_1_ = (Anonymous_moreGuards_1_)theEObject;
        T result = caseAnonymous_moreGuards_1_(anonymous_moreGuards_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.GUARD_:
      {
        Guard_ guard_ = (Guard_)theEObject;
        T result = caseGuard_(guard_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_GUARD_1:
      {
        Anonymous_guard_1_ anonymous_guard_1_ = (Anonymous_guard_1_)theEObject;
        T result = caseAnonymous_guard_1_(anonymous_guard_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_GUARD_2:
      {
        Anonymous_guard_2_ anonymous_guard_2_ = (Anonymous_guard_2_)theEObject;
        T result = caseAnonymous_guard_2_(anonymous_guard_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_TYPE_:
      {
        TraceType_ traceType_ = (TraceType_)theEObject;
        T result = caseTraceType_(traceType_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_TRACE_TYPE_1:
      {
        Anonymous_traceType_1_ anonymous_traceType_1_ = (Anonymous_traceType_1_)theEObject;
        T result = caseAnonymous_traceType_1_(anonymous_traceType_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_TRACE_TYPE_2:
      {
        Anonymous_traceType_2_ anonymous_traceType_2_ = (Anonymous_traceType_2_)theEObject;
        T result = caseAnonymous_traceType_2_(anonymous_traceType_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_:
      {
        Trace_ trace_ = (Trace_)theEObject;
        T result = caseTrace_(trace_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_DIRECTIVE_:
      {
        TraceDirective_ traceDirective_ = (TraceDirective_)theEObject;
        T result = caseTraceDirective_(traceDirective_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_TRACE_DIRECTIVE_1:
      {
        Anonymous_traceDirective_1_ anonymous_traceDirective_1_ = (Anonymous_traceDirective_1_)theEObject;
        T result = caseAnonymous_traceDirective_1_(anonymous_traceDirective_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_ITEM_:
      {
        TraceItem_ traceItem_ = (TraceItem_)theEObject;
        T result = caseTraceItem_(traceItem_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_ENTITY_:
      {
        TraceEntity_ traceEntity_ = (TraceEntity_)theEObject;
        T result = caseTraceEntity_(traceEntity_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_TRACE_ENTITY_1:
      {
        Anonymous_traceEntity_1_ anonymous_traceEntity_1_ = (Anonymous_traceEntity_1_)theEObject;
        T result = caseAnonymous_traceEntity_1_(anonymous_traceEntity_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_OPTIONS_:
      {
        TraceOptions_ traceOptions_ = (TraceOptions_)theEObject;
        T result = caseTraceOptions_(traceOptions_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_TRACE_OPTIONS_1:
      {
        Anonymous_traceOptions_1_ anonymous_traceOptions_1_ = (Anonymous_traceOptions_1_)theEObject;
        T result = caseAnonymous_traceOptions_1_(anonymous_traceOptions_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_OPTION_:
      {
        TraceOption_ traceOption_ = (TraceOption_)theEObject;
        T result = caseTraceOption_(traceOption_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.PRE_OR_POST_CONDITION_:
      {
        PreOrPostCondition_ preOrPostCondition_ = (PreOrPostCondition_)theEObject;
        T result = casePreOrPostCondition_(preOrPostCondition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.EXECUTE_CLAUSE_:
      {
        ExecuteClause_ executeClause_ = (ExecuteClause_)theEObject;
        T result = caseExecuteClause_(executeClause_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_WHEN_:
      {
        TraceWhen_ traceWhen_ = (TraceWhen_)theEObject;
        T result = caseTraceWhen_(traceWhen_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_FOR_:
      {
        TraceFor_ traceFor_ = (TraceFor_)theEObject;
        T result = caseTraceFor_(traceFor_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_LEVEL_:
      {
        TraceLevel_ traceLevel_ = (TraceLevel_)theEObject;
        T result = caseTraceLevel_(traceLevel_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_PERIOD_:
      {
        TracePeriod_ tracePeriod_ = (TracePeriod_)theEObject;
        T result = caseTracePeriod_(tracePeriod_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_DURING_:
      {
        TraceDuring_ traceDuring_ = (TraceDuring_)theEObject;
        T result = caseTraceDuring_(traceDuring_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_RECORD_:
      {
        TraceRecord_ traceRecord_ = (TraceRecord_)theEObject;
        T result = caseTraceRecord_(traceRecord_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.RECORD_ENTITY_:
      {
        RecordEntity_ recordEntity_ = (RecordEntity_)theEObject;
        T result = caseRecordEntity_(recordEntity_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_RECORD_ENTITY_2:
      {
        Anonymous_recordEntity_2_ anonymous_recordEntity_2_ = (Anonymous_recordEntity_2_)theEObject;
        T result = caseAnonymous_recordEntity_2_(anonymous_recordEntity_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_CONDITION_:
      {
        TraceCondition_ traceCondition_ = (TraceCondition_)theEObject;
        T result = caseTraceCondition_(traceCondition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CONDITION_RHS_:
      {
        ConditionRHS_ conditionRHS_ = (ConditionRHS_)theEObject;
        T result = caseConditionRHS_(conditionRHS_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_CASE_:
      {
        TraceCase_ traceCase_ = (TraceCase_)theEObject;
        T result = caseTraceCase_(traceCase_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_CASE_DEF_:
      {
        TraceCaseDef_ traceCaseDef_ = (TraceCaseDef_)theEObject;
        T result = caseTraceCaseDef_(traceCaseDef_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_CASE_ACTIVATION_:
      {
        TraceCaseActivation_ traceCaseActivation_ = (TraceCaseActivation_)theEObject;
        T result = caseTraceCaseActivation_(traceCaseActivation_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.TRACE_CASE_DEACTIVATION_:
      {
        TraceCaseDeactivation_ traceCaseDeactivation_ = (TraceCaseDeactivation_)theEObject;
        T result = caseTraceCaseDeactivation_(traceCaseDeactivation_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.DE_ACTIVATE_FOR_:
      {
        DeActivateFor_ deActivateFor_ = (DeActivateFor_)theEObject;
        T result = caseDeActivateFor_(deActivateFor_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.PRECONDITION_:
      {
        Precondition_ precondition_ = (Precondition_)theEObject;
        T result = casePrecondition_(precondition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.POSTCONDITION_:
      {
        Postcondition_ postcondition_ = (Postcondition_)theEObject;
        T result = casePostcondition_(postcondition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.INVARIANT_:
      {
        Invariant_ invariant_ = (Invariant_)theEObject;
        T result = caseInvariant_(invariant_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_INVARIANT_1:
      {
        Anonymous_invariant_1_ anonymous_invariant_1_ = (Anonymous_invariant_1_)theEObject;
        T result = caseAnonymous_invariant_1_(anonymous_invariant_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_INVARIANT_2:
      {
        Anonymous_invariant_2_ anonymous_invariant_2_ = (Anonymous_invariant_2_)theEObject;
        T result = caseAnonymous_invariant_2_(anonymous_invariant_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CONSTRAINT_TOKEN_:
      {
        ConstraintToken_ constraintToken_ = (ConstraintToken_)theEObject;
        T result = caseConstraintToken_(constraintToken_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CONSTRAINT_:
      {
        Constraint_ constraint_ = (Constraint_)theEObject;
        T result = caseConstraint_(constraint_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_CONSTRAINT_1:
      {
        Anonymous_constraint_1_ anonymous_constraint_1_ = (Anonymous_constraint_1_)theEObject;
        T result = caseAnonymous_constraint_1_(anonymous_constraint_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.NEGATIVE_CONSTRAINT_:
      {
        NegativeConstraint_ negativeConstraint_ = (NegativeConstraint_)theEObject;
        T result = caseNegativeConstraint_(negativeConstraint_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CONSTRAINT_BODY_:
      {
        ConstraintBody_ constraintBody_ = (ConstraintBody_)theEObject;
        T result = caseConstraintBody_(constraintBody_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_CONSTRAINT_BODY_1:
      {
        Anonymous_constraintBody_1_ anonymous_constraintBody_1_ = (Anonymous_constraintBody_1_)theEObject;
        T result = caseAnonymous_constraintBody_1_(anonymous_constraintBody_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.LINKING_OP_:
      {
        LinkingOp_ linkingOp_ = (LinkingOp_)theEObject;
        T result = caseLinkingOp_(linkingOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_LINKING_OP_1:
      {
        Anonymous_linkingOp_1_ anonymous_linkingOp_1_ = (Anonymous_linkingOp_1_)theEObject;
        T result = caseAnonymous_linkingOp_1_(anonymous_linkingOp_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_LINKING_OP_2:
      {
        Anonymous_linkingOp_2_ anonymous_linkingOp_2_ = (Anonymous_linkingOp_2_)theEObject;
        T result = caseAnonymous_linkingOp_2_(anonymous_linkingOp_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_LINKING_OP_3:
      {
        Anonymous_linkingOp_3_ anonymous_linkingOp_3_ = (Anonymous_linkingOp_3_)theEObject;
        T result = caseAnonymous_linkingOp_3_(anonymous_linkingOp_3_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.CONSTRAINT_EXPR_:
      {
        ConstraintExpr_ constraintExpr_ = (ConstraintExpr_)theEObject;
        T result = caseConstraintExpr_(constraintExpr_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_CONSTRAINT_EXPR_1:
      {
        Anonymous_constraintExpr_1_ anonymous_constraintExpr_1_ = (Anonymous_constraintExpr_1_)theEObject;
        T result = caseAnonymous_constraintExpr_1_(anonymous_constraintExpr_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.COMPOUND_EXPR_:
      {
        CompoundExpr_ compoundExpr_ = (CompoundExpr_)theEObject;
        T result = caseCompoundExpr_(compoundExpr_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.BOOL_EXPR_:
      {
        BoolExpr_ boolExpr_ = (BoolExpr_)theEObject;
        T result = caseBoolExpr_(boolExpr_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.STRING_EXPR_:
      {
        StringExpr_ stringExpr_ = (StringExpr_)theEObject;
        T result = caseStringExpr_(stringExpr_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.STRING_LIT_:
      {
        StringLit_ stringLit_ = (StringLit_)theEObject;
        T result = caseStringLit_(stringLit_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.GEN_EXPR_:
      {
        GenExpr_ genExpr_ = (GenExpr_)theEObject;
        T result = caseGenExpr_(genExpr_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_GEN_EXPR_1:
      {
        Anonymous_genExpr_1_ anonymous_genExpr_1_ = (Anonymous_genExpr_1_)theEObject;
        T result = caseAnonymous_genExpr_1_(anonymous_genExpr_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_GEN_EXPR_2:
      {
        Anonymous_genExpr_2_ anonymous_genExpr_2_ = (Anonymous_genExpr_2_)theEObject;
        T result = caseAnonymous_genExpr_2_(anonymous_genExpr_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.NUM_EXPR_:
      {
        NumExpr_ numExpr_ = (NumExpr_)theEObject;
        T result = caseNumExpr_(numExpr_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_NUM_EXPR_1:
      {
        Anonymous_numExpr_1_ anonymous_numExpr_1_ = (Anonymous_numExpr_1_)theEObject;
        T result = caseAnonymous_numExpr_1_(anonymous_numExpr_1_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_NUM_EXPR_2:
      {
        Anonymous_numExpr_2_ anonymous_numExpr_2_ = (Anonymous_numExpr_2_)theEObject;
        T result = caseAnonymous_numExpr_2_(anonymous_numExpr_2_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_NUM_EXPR_3:
      {
        Anonymous_numExpr_3_ anonymous_numExpr_3_ = (Anonymous_numExpr_3_)theEObject;
        T result = caseAnonymous_numExpr_3_(anonymous_numExpr_3_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ANONYMOUS_NUM_EXPR_4:
      {
        Anonymous_numExpr_4_ anonymous_numExpr_4_ = (Anonymous_numExpr_4_)theEObject;
        T result = caseAnonymous_numExpr_4_(anonymous_numExpr_4_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.EQUALITY_OP_:
      {
        EqualityOp_ equalityOp_ = (EqualityOp_)theEObject;
        T result = caseEqualityOp_(equalityOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.EQUALS_OP_:
      {
        EqualsOp_ equalsOp_ = (EqualsOp_)theEObject;
        T result = caseEqualsOp_(equalsOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.NOTEQUALS_OP_:
      {
        NotequalsOp_ notequalsOp_ = (NotequalsOp_)theEObject;
        T result = caseNotequalsOp_(notequalsOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ORDINAL_OP_:
      {
        OrdinalOp_ ordinalOp_ = (OrdinalOp_)theEObject;
        T result = caseOrdinalOp_(ordinalOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.GREATER_OP_:
      {
        GreaterOp_ greaterOp_ = (GreaterOp_)theEObject;
        T result = caseGreaterOp_(greaterOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.LESS_OP_:
      {
        LessOp_ lessOp_ = (LessOp_)theEObject;
        T result = caseLessOp_(lessOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.MORE_OP_:
      {
        MoreOp_ moreOp_ = (MoreOp_)theEObject;
        T result = caseMoreOp_(moreOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.SMALLER_OP_:
      {
        SmallerOp_ smallerOp_ = (SmallerOp_)theEObject;
        T result = caseSmallerOp_(smallerOp_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.POSITION_:
      {
        Position_ position_ = (Position_)theEObject;
        T result = casePosition_(position_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ELEMENT_POSITION_:
      {
        ElementPosition_ elementPosition_ = (ElementPosition_)theEObject;
        T result = caseElementPosition_(elementPosition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.ASSOCIATION_POSITION_:
      {
        AssociationPosition_ associationPosition_ = (AssociationPosition_)theEObject;
        T result = caseAssociationPosition_(associationPosition_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.COORDINATE_:
      {
        Coordinate_ coordinate_ = (Coordinate_)theEObject;
        T result = caseCoordinate_(coordinate_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case UmplePackage.DISPLAY_COLOR_:
      {
        DisplayColor_ displayColor_ = (DisplayColor_)theEObject;
        T result = caseDisplayColor_(displayColor_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Program </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Program </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProgram_(Program_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous program 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous program 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_program_1_(Anonymous_program_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Directive </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Directive </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDirective_(Directive_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Glossary </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Glossary </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGlossary_(Glossary_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Word </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Word </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWord_(Word_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Strictness </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Strictness </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStrictness_(Strictness_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous strictness 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous strictness 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_strictness_1_(Anonymous_strictness_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Generate </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Generate </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGenerate_(Generate_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Generate path </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Generate path </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGenerate_path_(Generate_path_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Use Statement </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Use Statement </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUseStatement_(UseStatement_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Namespace </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Namespace </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamespace_(Namespace_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entity </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entity </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntity_(Entity_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Comment </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Comment </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComment_(Comment_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inline Comment </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inline Comment </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInlineComment_(InlineComment_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiline Comment </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiline Comment </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultilineComment_(MultilineComment_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Debug </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Debug </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDebug_(Debug_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstract_(Abstract_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassDefinition_(ClassDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalDefinition_(ExternalDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interface Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interface Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterfaceDefinition_(InterfaceDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationDefinition_(AssociationDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Class Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Class Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationClassDefinition_(AssociationClassDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Class Content </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Class Content </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassContent_(ClassContent_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Class Content </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Class Content </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationClassContent_(AssociationClassContent_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interface Body </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interface Body </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterfaceBody_(InterfaceBody_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Interface Member Declaration </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Interface Member Declaration </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInterfaceMemberDeclaration_(InterfaceMemberDeclaration_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Declaration </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Declaration </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantDeclaration_(ConstantDeclaration_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous constant Declaration 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous constant Declaration 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_constantDeclaration_1_(Anonymous_constantDeclaration_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous constant Declaration 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous constant Declaration 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_constantDeclaration_2_(Anonymous_constantDeclaration_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>More Code </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>More Code </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMoreCode_(MoreCode_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous more Code 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous more Code 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_moreCode_1_(Anonymous_moreCode_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Code Langs </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Code Langs </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCodeLangs_(CodeLangs_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous code Langs 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous code Langs 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_codeLangs_1_(Anonymous_codeLangs_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Code Lang </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Code Lang </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCodeLang_(CodeLang_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Method Body </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method Body </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMethodBody_(MethodBody_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous method Body 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous method Body 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_methodBody_1_(Anonymous_methodBody_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous method Body 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous method Body 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_methodBody_2_(Anonymous_methodBody_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Concrete Method Declaration </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Concrete Method Declaration </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConcreteMethodDeclaration_(ConcreteMethodDeclaration_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous concrete Method Declaration 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous concrete Method Declaration 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_concreteMethodDeclaration_1_(Anonymous_concreteMethodDeclaration_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous concrete Method Declaration 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous concrete Method Declaration 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_concreteMethodDeclaration_2_(Anonymous_concreteMethodDeclaration_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Abstract Method Declaration </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Abstract Method Declaration </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAbstractMethodDeclaration_(AbstractMethodDeclaration_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Method Declarator </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method Declarator </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMethodDeclarator_(MethodDeclarator_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter List </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter List </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterList_(ParameterList_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous parameter List 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous parameter List 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_parameterList_1_(Anonymous_parameterList_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameter_(Parameter_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous parameter 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous parameter 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_parameter_1_(Anonymous_parameter_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociation_(Association_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Symmetric Reflexive Association </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Symmetric Reflexive Association </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSymmetricReflexiveAssociation_(SymmetricReflexiveAssociation_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inline Association </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inline Association </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInlineAssociation_(InlineAssociation_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inline Association End </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inline Association End </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInlineAssociationEnd_(InlineAssociationEnd_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Association End </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Association End </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleAssociationEnd_(SingleAssociationEnd_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association End </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association End </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationEnd_(AssociationEnd_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicity_(Multiplicity_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Is Sorted </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Is Sorted </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIsSorted_(IsSorted_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttribute_(Attribute_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Attribute </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Attribute </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleAttribute_(SimpleAttribute_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Autounique Attribute </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Autounique Attribute </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAutouniqueAttribute_(AutouniqueAttribute_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Derived Attribute </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Derived Attribute </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDerivedAttribute_(DerivedAttribute_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous derived Attribute 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous derived Attribute 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_derivedAttribute_1_(Anonymous_derivedAttribute_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous derived Attribute 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous derived Attribute 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_derivedAttribute_2_(Anonymous_derivedAttribute_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous derived Attribute 3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous derived Attribute 3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_derivedAttribute_3_(Anonymous_derivedAttribute_3_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Attribute </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Attribute </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexAttribute_(ComplexAttribute_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous complex Attribute 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous complex Attribute 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_complexAttribute_1_(Anonymous_complexAttribute_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous complex Attribute 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous complex Attribute 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_complexAttribute_2_(Anonymous_complexAttribute_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Key </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Key </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKey_(Key_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous key 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous key 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_key_1_(Anonymous_key_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Depend </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Depend </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDepend_(Depend_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extra Code </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extra Code </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtraCode_(ExtraCode_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Software Pattern </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Software Pattern </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSoftwarePattern_(SoftwarePattern_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Is A</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Is A</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIsA_(IsA_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Single Is A</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Single Is A</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleIsA_(SingleIsA_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous single Is A1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous single Is A1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_singleIsA_1_(Anonymous_singleIsA_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiple Is A</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiple Is A</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultipleIsA_(MultipleIsA_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous multiple Is A1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous multiple Is A1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_multipleIsA_1_(Anonymous_multipleIsA_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Singleton </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Singleton </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSingleton_(Singleton_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Immutable </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Immutable </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImmutable_(Immutable_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Key Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Key Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeyDefinition_(KeyDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Code Injection </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Code Injection </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCodeInjection_(CodeInjection_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Before Code </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Before Code </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBeforeCode_(BeforeCode_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous before Code 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous before Code 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_beforeCode_1_(Anonymous_beforeCode_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous before Code 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous before Code 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_beforeCode_2_(Anonymous_beforeCode_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>After Code </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>After Code </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAfterCode_(AfterCode_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous after Code 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous after Code 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_afterCode_1_(Anonymous_afterCode_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous after Code 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous after Code 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_afterCode_2_(Anonymous_afterCode_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Machine Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Machine Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateMachineDefinition_(StateMachineDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Machine </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Machine </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateMachine_(StateMachine_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Active Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Active Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActiveDefinition_(ActiveDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Inline State Machine </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Inline State Machine </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInlineStateMachine_(InlineStateMachine_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous inline State Machine 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous inline State Machine 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_inlineStateMachine_1_(Anonymous_inlineStateMachine_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Referenced State Machine </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Referenced State Machine </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReferencedStateMachine_(ReferencedStateMachine_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extended State Machine </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extended State Machine </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtendedStateMachine_(ExtendedStateMachine_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous extended State Machine 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous extended State Machine 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_extendedStateMachine_1_(Anonymous_extendedStateMachine_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnum_(Enum_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous enum 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous enum 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_enum_1_(Anonymous_enum_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseState_(State_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous state 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous state 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_state_1_(Anonymous_state_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Internal </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Internal </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateInternal_(StateInternal_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>State Entity </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>State Entity </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStateEntity_(StateEntity_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Auto Transition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Auto Transition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAutoTransition_(AutoTransition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Auto Transition Block </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Auto Transition Block </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAutoTransitionBlock_(AutoTransitionBlock_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransition_(Transition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Event Definition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Event Definition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEventDefinition_(EventDefinition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous event Definition 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous event Definition 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_eventDefinition_1_(Anonymous_eventDefinition_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>After Every Event </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>After Every Event </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAfterEveryEvent_(AfterEveryEvent_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>After Event </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>After Event </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAfterEvent_(AfterEvent_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Action </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Action </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAction_(Action_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous action 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous action 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_action_1_(Anonymous_action_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous action 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous action 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_action_2_(Anonymous_action_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Entry Or Exit Action </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Entry Or Exit Action </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEntryOrExitAction_(EntryOrExitAction_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous entry Or Exit Action 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous entry Or Exit Action 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_entryOrExitAction_1_(Anonymous_entryOrExitAction_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous entry Or Exit Action 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous entry Or Exit Action 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_entryOrExitAction_2_(Anonymous_entryOrExitAction_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Activity </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Activity </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseActivity_(Activity_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous activity 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous activity 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_activity_1_(Anonymous_activity_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous activity 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous activity 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_activity_2_(Anonymous_activity_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>More Guards </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>More Guards </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMoreGuards_(MoreGuards_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous more Guards 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous more Guards 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_moreGuards_1_(Anonymous_moreGuards_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Guard </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Guard </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGuard_(Guard_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous guard 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous guard 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_guard_1_(Anonymous_guard_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous guard 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous guard 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_guard_2_(Anonymous_guard_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Type </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Type </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceType_(TraceType_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous trace Type 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous trace Type 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_traceType_1_(Anonymous_traceType_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous trace Type 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous trace Type 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_traceType_2_(Anonymous_traceType_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrace_(Trace_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Directive </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Directive </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceDirective_(TraceDirective_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous trace Directive 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous trace Directive 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_traceDirective_1_(Anonymous_traceDirective_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Item </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Item </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceItem_(TraceItem_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Entity </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Entity </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceEntity_(TraceEntity_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous trace Entity 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous trace Entity 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_traceEntity_1_(Anonymous_traceEntity_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Options </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Options </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceOptions_(TraceOptions_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous trace Options 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous trace Options 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_traceOptions_1_(Anonymous_traceOptions_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Option </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Option </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceOption_(TraceOption_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pre Or Post Condition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pre Or Post Condition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePreOrPostCondition_(PreOrPostCondition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Execute Clause </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Execute Clause </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecuteClause_(ExecuteClause_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace When </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace When </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceWhen_(TraceWhen_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace For </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace For </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceFor_(TraceFor_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Level </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Level </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceLevel_(TraceLevel_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Period </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Period </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTracePeriod_(TracePeriod_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace During </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace During </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceDuring_(TraceDuring_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Record </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Record </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceRecord_(TraceRecord_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Entity </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Entity </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordEntity_(RecordEntity_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous record Entity 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous record Entity 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_recordEntity_2_(Anonymous_recordEntity_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Condition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Condition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceCondition_(TraceCondition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Condition RHS </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Condition RHS </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionRHS_(ConditionRHS_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Case </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Case </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceCase_(TraceCase_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Case Def </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Case Def </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceCaseDef_(TraceCaseDef_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Case Activation </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Case Activation </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceCaseActivation_(TraceCaseActivation_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trace Case Deactivation </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trace Case Deactivation </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTraceCaseDeactivation_(TraceCaseDeactivation_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>De Activate For </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>De Activate For </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDeActivateFor_(DeActivateFor_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Precondition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Precondition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrecondition_(Precondition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Postcondition </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Postcondition </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePostcondition_(Postcondition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invariant </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invariant </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvariant_(Invariant_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous invariant 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous invariant 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_invariant_1_(Anonymous_invariant_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous invariant 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous invariant 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_invariant_2_(Anonymous_invariant_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Token </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Token </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintToken_(ConstraintToken_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraint_(Constraint_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous constraint 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous constraint 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_constraint_1_(Anonymous_constraint_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Negative Constraint </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Negative Constraint </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegativeConstraint_(NegativeConstraint_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Body </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Body </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintBody_(ConstraintBody_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous constraint Body 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous constraint Body 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_constraintBody_1_(Anonymous_constraintBody_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Linking Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Linking Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLinkingOp_(LinkingOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous linking Op 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous linking Op 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_linkingOp_1_(Anonymous_linkingOp_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous linking Op 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous linking Op 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_linkingOp_2_(Anonymous_linkingOp_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous linking Op 3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous linking Op 3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_linkingOp_3_(Anonymous_linkingOp_3_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Expr </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Expr </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintExpr_(ConstraintExpr_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous constraint Expr 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous constraint Expr 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_constraintExpr_1_(Anonymous_constraintExpr_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Compound Expr </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Compound Expr </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCompoundExpr_(CompoundExpr_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Expr </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Expr </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolExpr_(BoolExpr_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Expr </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Expr </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringExpr_(StringExpr_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Lit </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Lit </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLit_(StringLit_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Gen Expr </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Gen Expr </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGenExpr_(GenExpr_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous gen Expr 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous gen Expr 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_genExpr_1_(Anonymous_genExpr_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous gen Expr 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous gen Expr 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_genExpr_2_(Anonymous_genExpr_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Num Expr </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Num Expr </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumExpr_(NumExpr_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous num Expr 1</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous num Expr 1</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_numExpr_1_(Anonymous_numExpr_1_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous num Expr 2</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous num Expr 2</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_numExpr_2_(Anonymous_numExpr_2_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous num Expr 3</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous num Expr 3</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_numExpr_3_(Anonymous_numExpr_3_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Anonymous num Expr 4</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Anonymous num Expr 4</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnonymous_numExpr_4_(Anonymous_numExpr_4_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equality Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equality Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualityOp_(EqualityOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equals Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equals Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualsOp_(EqualsOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Notequals Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Notequals Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNotequalsOp_(NotequalsOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Ordinal Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Ordinal Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOrdinalOp_(OrdinalOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Greater Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Greater Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGreaterOp_(GreaterOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Less Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Less Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLessOp_(LessOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>More Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>More Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMoreOp_(MoreOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Smaller Op </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Smaller Op </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSmallerOp_(SmallerOp_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Position </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Position </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePosition_(Position_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element Position </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element Position </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseElementPosition_(ElementPosition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Association Position </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Association Position </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAssociationPosition_(AssociationPosition_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Coordinate </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Coordinate </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCoordinate_(Coordinate_ object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Display Color </em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Display Color </em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDisplayColor_(DisplayColor_ object)
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
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //UmpleSwitch
