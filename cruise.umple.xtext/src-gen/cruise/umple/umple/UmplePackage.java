/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cruise.umple.umple.UmpleFactory
 * @model kind="package"
 * @generated
 */
public interface UmplePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "umple";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.umple.cruise/Umple";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "umple";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  UmplePackage eINSTANCE = cruise.umple.umple.impl.UmplePackageImpl.init();

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ModelImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__MODEL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Program_Impl <em>Program </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Program_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getProgram_()
   * @generated
   */
  int PROGRAM_ = 1;

  /**
   * The feature id for the '<em><b>Anonymous program 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM___ANONYMOUS_PROGRAM_11 = 0;

  /**
   * The number of structural features of the '<em>Program </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_program_1_Impl <em>Anonymous program 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_program_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_program_1_()
   * @generated
   */
  int ANONYMOUS_PROGRAM_1 = 2;

  /**
   * The feature id for the '<em><b>Comment 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PROGRAM_1__COMMENT_1 = 0;

  /**
   * The feature id for the '<em><b>Directive 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PROGRAM_1__DIRECTIVE_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous program 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PROGRAM_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Directive_Impl <em>Directive </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Directive_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getDirective_()
   * @generated
   */
  int DIRECTIVE_ = 3;

  /**
   * The feature id for the '<em><b>Glossary 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___GLOSSARY_1 = 0;

  /**
   * The feature id for the '<em><b>Generate 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___GENERATE_1 = 1;

  /**
   * The feature id for the '<em><b>Generate path 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___GENERATE_PATH_1 = 2;

  /**
   * The feature id for the '<em><b>Use Statement 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___USE_STATEMENT_1 = 3;

  /**
   * The feature id for the '<em><b>Namespace 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___NAMESPACE_1 = 4;

  /**
   * The feature id for the '<em><b>Trace Type 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___TRACE_TYPE_1 = 5;

  /**
   * The feature id for the '<em><b>Entity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___ENTITY_1 = 6;

  /**
   * The feature id for the '<em><b>Debug 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___DEBUG_1 = 7;

  /**
   * The feature id for the '<em><b>Strictness 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE___STRICTNESS_1 = 8;

  /**
   * The number of structural features of the '<em>Directive </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIRECTIVE__FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Glossary_Impl <em>Glossary </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Glossary_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGlossary_()
   * @generated
   */
  int GLOSSARY_ = 4;

  /**
   * The feature id for the '<em><b>Word 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOSSARY___WORD_1 = 0;

  /**
   * The number of structural features of the '<em>Glossary </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOSSARY__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Word_Impl <em>Word </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Word_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getWord_()
   * @generated
   */
  int WORD_ = 5;

  /**
   * The feature id for the '<em><b>Singular 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD___SINGULAR_1 = 0;

  /**
   * The feature id for the '<em><b>Plural 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD___PLURAL_1 = 1;

  /**
   * The number of structural features of the '<em>Word </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Strictness_Impl <em>Strictness </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Strictness_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStrictness_()
   * @generated
   */
  int STRICTNESS_ = 6;

  /**
   * The feature id for the '<em><b>Anonymous strictness 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRICTNESS___ANONYMOUS_STRICTNESS_11 = 0;

  /**
   * The number of structural features of the '<em>Strictness </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRICTNESS__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_strictness_1_Impl <em>Anonymous strictness 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_strictness_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_strictness_1_()
   * @generated
   */
  int ANONYMOUS_STRICTNESS_1 = 7;

  /**
   * The feature id for the '<em><b>Strictness Level 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_STRICTNESS_1__STRICTNESS_LEVEL_1 = 0;

  /**
   * The feature id for the '<em><b>Message 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_STRICTNESS_1__MESSAGE_1 = 1;

  /**
   * The feature id for the '<em><b>Message Number 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_STRICTNESS_1__MESSAGE_NUMBER_1 = 2;

  /**
   * The number of structural features of the '<em>Anonymous strictness 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_STRICTNESS_1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Generate_Impl <em>Generate </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Generate_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGenerate_()
   * @generated
   */
  int GENERATE_ = 8;

  /**
   * The feature id for the '<em><b>Generate 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE___GENERATE_1 = 0;

  /**
   * The number of structural features of the '<em>Generate </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Generate_path_Impl <em>Generate path </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Generate_path_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGenerate_path_()
   * @generated
   */
  int GENERATE_PATH_ = 9;

  /**
   * The feature id for the '<em><b>Language 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE_PATH___LANGUAGE_1 = 0;

  /**
   * The feature id for the '<em><b>Output 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE_PATH___OUTPUT_1 = 1;

  /**
   * The feature id for the '<em><b>Override 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE_PATH___OVERRIDE_1 = 2;

  /**
   * The number of structural features of the '<em>Generate path </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE_PATH__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.UseStatement_Impl <em>Use Statement </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UseStatement_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUseStatement_()
   * @generated
   */
  int USE_STATEMENT_ = 10;

  /**
   * The feature id for the '<em><b>Use 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USE_STATEMENT___USE_1 = 0;

  /**
   * The number of structural features of the '<em>Use Statement </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USE_STATEMENT__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Namespace_Impl <em>Namespace </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Namespace_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getNamespace_()
   * @generated
   */
  int NAMESPACE_ = 11;

  /**
   * The feature id for the '<em><b>Namespace 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE___NAMESPACE_1 = 0;

  /**
   * The number of structural features of the '<em>Namespace </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Entity_Impl <em>Entity </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Entity_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEntity_()
   * @generated
   */
  int ENTITY_ = 12;

  /**
   * The feature id for the '<em><b>Class Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___CLASS_DEFINITION_1 = 0;

  /**
   * The feature id for the '<em><b>Interface Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___INTERFACE_DEFINITION_1 = 1;

  /**
   * The feature id for the '<em><b>External Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___EXTERNAL_DEFINITION_1 = 2;

  /**
   * The feature id for the '<em><b>Association Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___ASSOCIATION_DEFINITION_1 = 3;

  /**
   * The feature id for the '<em><b>Association Class Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___ASSOCIATION_CLASS_DEFINITION_1 = 4;

  /**
   * The feature id for the '<em><b>State Machine Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY___STATE_MACHINE_DEFINITION_1 = 5;

  /**
   * The number of structural features of the '<em>Entity </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Comment_Impl <em>Comment </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Comment_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getComment_()
   * @generated
   */
  int COMMENT_ = 13;

  /**
   * The feature id for the '<em><b>Inline Comment 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENT___INLINE_COMMENT_1 = 0;

  /**
   * The feature id for the '<em><b>Multiline Comment 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENT___MULTILINE_COMMENT_1 = 1;

  /**
   * The number of structural features of the '<em>Comment </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMMENT__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InlineComment_Impl <em>Inline Comment </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InlineComment_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineComment_()
   * @generated
   */
  int INLINE_COMMENT_ = 14;

  /**
   * The feature id for the '<em><b>Inline Comment 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_COMMENT___INLINE_COMMENT_1 = 0;

  /**
   * The number of structural features of the '<em>Inline Comment </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_COMMENT__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.MultilineComment_Impl <em>Multiline Comment </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.MultilineComment_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getMultilineComment_()
   * @generated
   */
  int MULTILINE_COMMENT_ = 15;

  /**
   * The feature id for the '<em><b>Multiline Comment 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTILINE_COMMENT___MULTILINE_COMMENT_1 = 0;

  /**
   * The number of structural features of the '<em>Multiline Comment </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTILINE_COMMENT__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Debug_Impl <em>Debug </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Debug_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getDebug_()
   * @generated
   */
  int DEBUG_ = 16;

  /**
   * The feature id for the '<em><b>Debug 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEBUG___DEBUG_1 = 0;

  /**
   * The number of structural features of the '<em>Debug </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEBUG__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Abstract_Impl <em>Abstract </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Abstract_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAbstract_()
   * @generated
   */
  int ABSTRACT_ = 17;

  /**
   * The feature id for the '<em><b>Abstract 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT___ABSTRACT_1 = 0;

  /**
   * The number of structural features of the '<em>Abstract </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ClassDefinition_Impl <em>Class Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ClassDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getClassDefinition_()
   * @generated
   */
  int CLASS_DEFINITION_ = 18;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEFINITION___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Class Content 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEFINITION___CLASS_CONTENT_1 = 1;

  /**
   * The number of structural features of the '<em>Class Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEFINITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ExternalDefinition_Impl <em>External Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ExternalDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getExternalDefinition_()
   * @generated
   */
  int EXTERNAL_DEFINITION_ = 19;

  /**
   * The feature id for the '<em><b>Interface 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEFINITION___INTERFACE_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEFINITION___NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Class Content 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEFINITION___CLASS_CONTENT_1 = 2;

  /**
   * The number of structural features of the '<em>External Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEFINITION__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InterfaceDefinition_Impl <em>Interface Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InterfaceDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInterfaceDefinition_()
   * @generated
   */
  int INTERFACE_DEFINITION_ = 20;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DEFINITION___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Depend 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DEFINITION___DEPEND_1 = 1;

  /**
   * The feature id for the '<em><b>Interface Body 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DEFINITION___INTERFACE_BODY_1 = 2;

  /**
   * The number of structural features of the '<em>Interface Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DEFINITION__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationDefinition_Impl <em>Association Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationDefinition_()
   * @generated
   */
  int ASSOCIATION_DEFINITION_ = 21;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_DEFINITION___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Association 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_DEFINITION___ASSOCIATION_1 = 1;

  /**
   * The number of structural features of the '<em>Association Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_DEFINITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationClassDefinition_Impl <em>Association Class Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationClassDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationClassDefinition_()
   * @generated
   */
  int ASSOCIATION_CLASS_DEFINITION_ = 22;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_DEFINITION___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Association Class Content 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_DEFINITION___ASSOCIATION_CLASS_CONTENT_1 = 1;

  /**
   * The number of structural features of the '<em>Association Class Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_DEFINITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ClassContent_Impl <em>Class Content </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ClassContent_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getClassContent_()
   * @generated
   */
  int CLASS_CONTENT_ = 23;

  /**
   * The feature id for the '<em><b>Comment 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___COMMENT_1 = 0;

  /**
   * The feature id for the '<em><b>Class Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___CLASS_DEFINITION_1 = 1;

  /**
   * The feature id for the '<em><b>Trace 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___TRACE_1 = 2;

  /**
   * The feature id for the '<em><b>Position 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___POSITION_1 = 3;

  /**
   * The feature id for the '<em><b>Display Color 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___DISPLAY_COLOR_1 = 4;

  /**
   * The feature id for the '<em><b>Abstract 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___ABSTRACT_1 = 5;

  /**
   * The feature id for the '<em><b>Invariant 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___INVARIANT_1 = 6;

  /**
   * The feature id for the '<em><b>Software Pattern 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___SOFTWARE_PATTERN_1 = 7;

  /**
   * The feature id for the '<em><b>Depend 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___DEPEND_1 = 8;

  /**
   * The feature id for the '<em><b>Symmetric Reflexive Association 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___SYMMETRIC_REFLEXIVE_ASSOCIATION_1 = 9;

  /**
   * The feature id for the '<em><b>Attribute 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___ATTRIBUTE_1 = 10;

  /**
   * The feature id for the '<em><b>State Machine 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___STATE_MACHINE_1 = 11;

  /**
   * The feature id for the '<em><b>Inline Association 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___INLINE_ASSOCIATION_1 = 12;

  /**
   * The feature id for the '<em><b>Concrete Method Declaration 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___CONCRETE_METHOD_DECLARATION_1 = 13;

  /**
   * The feature id for the '<em><b>Constant Declaration 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___CONSTANT_DECLARATION_1 = 14;

  /**
   * The feature id for the '<em><b>Extra Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT___EXTRA_CODE_1 = 15;

  /**
   * The number of structural features of the '<em>Class Content </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT__FEATURE_COUNT = 16;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationClassContent_Impl <em>Association Class Content </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationClassContent_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationClassContent_()
   * @generated
   */
  int ASSOCIATION_CLASS_CONTENT_ = 24;

  /**
   * The feature id for the '<em><b>Comment 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___COMMENT_1 = 0;

  /**
   * The feature id for the '<em><b>Class Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___CLASS_DEFINITION_1 = 1;

  /**
   * The feature id for the '<em><b>Position 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___POSITION_1 = 2;

  /**
   * The feature id for the '<em><b>Display Color 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___DISPLAY_COLOR_1 = 3;

  /**
   * The feature id for the '<em><b>Invariant 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___INVARIANT_1 = 4;

  /**
   * The feature id for the '<em><b>Software Pattern 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___SOFTWARE_PATTERN_1 = 5;

  /**
   * The feature id for the '<em><b>Depend 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___DEPEND_1 = 6;

  /**
   * The feature id for the '<em><b>Single Association End 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___SINGLE_ASSOCIATION_END_1 = 7;

  /**
   * The feature id for the '<em><b>State Machine 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___STATE_MACHINE_1 = 8;

  /**
   * The feature id for the '<em><b>Attribute 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___ATTRIBUTE_1 = 9;

  /**
   * The feature id for the '<em><b>Association 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___ASSOCIATION_1 = 10;

  /**
   * The feature id for the '<em><b>Inline Association 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___INLINE_ASSOCIATION_1 = 11;

  /**
   * The feature id for the '<em><b>Extra Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT___EXTRA_CODE_1 = 12;

  /**
   * The number of structural features of the '<em>Association Class Content </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT__FEATURE_COUNT = 13;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InterfaceBody_Impl <em>Interface Body </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InterfaceBody_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInterfaceBody_()
   * @generated
   */
  int INTERFACE_BODY_ = 25;

  /**
   * The feature id for the '<em><b>Interface Member Declaration 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_BODY___INTERFACE_MEMBER_DECLARATION_1 = 0;

  /**
   * The number of structural features of the '<em>Interface Body </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_BODY__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InterfaceMemberDeclaration_Impl <em>Interface Member Declaration </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InterfaceMemberDeclaration_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInterfaceMemberDeclaration_()
   * @generated
   */
  int INTERFACE_MEMBER_DECLARATION_ = 26;

  /**
   * The feature id for the '<em><b>Constant Declaration 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_MEMBER_DECLARATION___CONSTANT_DECLARATION_1 = 0;

  /**
   * The feature id for the '<em><b>Abstract Method Declaration 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_MEMBER_DECLARATION___ABSTRACT_METHOD_DECLARATION_1 = 1;

  /**
   * The feature id for the '<em><b>Position 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_MEMBER_DECLARATION___POSITION_1 = 2;

  /**
   * The feature id for the '<em><b>Display Color 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_MEMBER_DECLARATION___DISPLAY_COLOR_1 = 3;

  /**
   * The feature id for the '<em><b>Is A1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_MEMBER_DECLARATION___IS_A1 = 4;

  /**
   * The feature id for the '<em><b>Extra Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_MEMBER_DECLARATION___EXTRA_CODE_1 = 5;

  /**
   * The number of structural features of the '<em>Interface Member Declaration </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_MEMBER_DECLARATION__FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ConstantDeclaration_Impl <em>Constant Declaration </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ConstantDeclaration_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getConstantDeclaration_()
   * @generated
   */
  int CONSTANT_DECLARATION_ = 27;

  /**
   * The feature id for the '<em><b>Anonymous constant Declaration 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_11 = 0;

  /**
   * The feature id for the '<em><b>Anonymous constant Declaration 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECLARATION___ANONYMOUS_CONSTANT_DECLARATION_21 = 1;

  /**
   * The number of structural features of the '<em>Constant Declaration </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECLARATION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_constantDeclaration_1_Impl <em>Anonymous constant Declaration 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_constantDeclaration_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_constantDeclaration_1_()
   * @generated
   */
  int ANONYMOUS_CONSTANT_DECLARATION_1 = 28;

  /**
   * The feature id for the '<em><b>List 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTANT_DECLARATION_1__LIST_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTANT_DECLARATION_1__NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTANT_DECLARATION_1__TYPE_1 = 2;

  /**
   * The number of structural features of the '<em>Anonymous constant Declaration 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTANT_DECLARATION_1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_constantDeclaration_2_Impl <em>Anonymous constant Declaration 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_constantDeclaration_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_constantDeclaration_2_()
   * @generated
   */
  int ANONYMOUS_CONSTANT_DECLARATION_2 = 29;

  /**
   * The feature id for the '<em><b>Value 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTANT_DECLARATION_2__VALUE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous constant Declaration 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTANT_DECLARATION_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.MoreCode_Impl <em>More Code </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.MoreCode_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getMoreCode_()
   * @generated
   */
  int MORE_CODE_ = 30;

  /**
   * The feature id for the '<em><b>Anonymous more Code 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORE_CODE___ANONYMOUS_MORE_CODE_11 = 0;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORE_CODE___CODE_1 = 1;

  /**
   * The number of structural features of the '<em>More Code </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORE_CODE__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_moreCode_1_Impl <em>Anonymous more Code 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_moreCode_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_moreCode_1_()
   * @generated
   */
  int ANONYMOUS_MORE_CODE_1 = 31;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_MORE_CODE_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_MORE_CODE_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous more Code 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_MORE_CODE_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CodeLangs_Impl <em>Code Langs </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CodeLangs_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCodeLangs_()
   * @generated
   */
  int CODE_LANGS_ = 32;

  /**
   * The feature id for the '<em><b>Anonymous code Langs 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_LANGS___ANONYMOUS_CODE_LANGS_11 = 0;

  /**
   * The number of structural features of the '<em>Code Langs </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_LANGS__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_codeLangs_1_Impl <em>Anonymous code Langs 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_codeLangs_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_codeLangs_1_()
   * @generated
   */
  int ANONYMOUS_CODE_LANGS_1 = 33;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CODE_LANGS_1__CODE_LANG_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous code Langs 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CODE_LANGS_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CodeLang_Impl <em>Code Lang </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CodeLang_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCodeLang_()
   * @generated
   */
  int CODE_LANG_ = 34;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_LANG___CODE_LANG_1 = 0;

  /**
   * The number of structural features of the '<em>Code Lang </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_LANG__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.MethodBody_Impl <em>Method Body </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.MethodBody_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getMethodBody_()
   * @generated
   */
  int METHOD_BODY_ = 35;

  /**
   * The feature id for the '<em><b>Anonymous method Body 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_BODY___ANONYMOUS_METHOD_BODY_11 = 0;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_BODY___CODE_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous method Body 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_BODY___ANONYMOUS_METHOD_BODY_21 = 2;

  /**
   * The number of structural features of the '<em>Method Body </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_BODY__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_methodBody_1_Impl <em>Anonymous method Body 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_methodBody_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_methodBody_1_()
   * @generated
   */
  int ANONYMOUS_METHOD_BODY_1 = 36;

  /**
   * The feature id for the '<em><b>Precondition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_METHOD_BODY_1__PRECONDITION_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous method Body 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_METHOD_BODY_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_methodBody_2_Impl <em>Anonymous method Body 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_methodBody_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_methodBody_2_()
   * @generated
   */
  int ANONYMOUS_METHOD_BODY_2 = 37;

  /**
   * The feature id for the '<em><b>Postcondition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_METHOD_BODY_2__POSTCONDITION_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous method Body 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_METHOD_BODY_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ConcreteMethodDeclaration_Impl <em>Concrete Method Declaration </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ConcreteMethodDeclaration_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getConcreteMethodDeclaration_()
   * @generated
   */
  int CONCRETE_METHOD_DECLARATION_ = 38;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_METHOD_DECLARATION___TYPE_1 = 0;

  /**
   * The feature id for the '<em><b>Method Declarator 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_METHOD_DECLARATION___METHOD_DECLARATOR_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous concrete Method Declaration 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_11 = 2;

  /**
   * The feature id for the '<em><b>Method Body 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_METHOD_DECLARATION___METHOD_BODY_1 = 3;

  /**
   * The feature id for the '<em><b>Anonymous concrete Method Declaration 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_METHOD_DECLARATION___ANONYMOUS_CONCRETE_METHOD_DECLARATION_21 = 4;

  /**
   * The number of structural features of the '<em>Concrete Method Declaration </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONCRETE_METHOD_DECLARATION__FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_concreteMethodDeclaration_1_Impl <em>Anonymous concrete Method Declaration 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_concreteMethodDeclaration_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_concreteMethodDeclaration_1_()
   * @generated
   */
  int ANONYMOUS_CONCRETE_METHOD_DECLARATION_1 = 39;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONCRETE_METHOD_DECLARATION_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONCRETE_METHOD_DECLARATION_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous concrete Method Declaration 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONCRETE_METHOD_DECLARATION_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_concreteMethodDeclaration_2_Impl <em>Anonymous concrete Method Declaration 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_concreteMethodDeclaration_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_concreteMethodDeclaration_2_()
   * @generated
   */
  int ANONYMOUS_CONCRETE_METHOD_DECLARATION_2 = 40;

  /**
   * The feature id for the '<em><b>More Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONCRETE_METHOD_DECLARATION_2__MORE_CODE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous concrete Method Declaration 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONCRETE_METHOD_DECLARATION_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AbstractMethodDeclaration_Impl <em>Abstract Method Declaration </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AbstractMethodDeclaration_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAbstractMethodDeclaration_()
   * @generated
   */
  int ABSTRACT_METHOD_DECLARATION_ = 41;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_METHOD_DECLARATION___TYPE_1 = 0;

  /**
   * The feature id for the '<em><b>Method Declarator 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_METHOD_DECLARATION___METHOD_DECLARATOR_1 = 1;

  /**
   * The number of structural features of the '<em>Abstract Method Declaration </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_METHOD_DECLARATION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.MethodDeclarator_Impl <em>Method Declarator </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.MethodDeclarator_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getMethodDeclarator_()
   * @generated
   */
  int METHOD_DECLARATOR_ = 42;

  /**
   * The feature id for the '<em><b>Method Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATOR___METHOD_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Parameter List 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATOR___PARAMETER_LIST_1 = 1;

  /**
   * The number of structural features of the '<em>Method Declarator </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_DECLARATOR__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ParameterList_Impl <em>Parameter List </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ParameterList_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getParameterList_()
   * @generated
   */
  int PARAMETER_LIST_ = 43;

  /**
   * The feature id for the '<em><b>Parameter 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST___PARAMETER_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous parameter List 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST___ANONYMOUS_PARAMETER_LIST_11 = 1;

  /**
   * The number of structural features of the '<em>Parameter List </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_LIST__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_parameterList_1_Impl <em>Anonymous parameter List 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_parameterList_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_parameterList_1_()
   * @generated
   */
  int ANONYMOUS_PARAMETER_LIST_1 = 44;

  /**
   * The feature id for the '<em><b>Parameter 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PARAMETER_LIST_1__PARAMETER_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous parameter List 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PARAMETER_LIST_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Parameter_Impl <em>Parameter </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Parameter_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getParameter_()
   * @generated
   */
  int PARAMETER_ = 45;

  /**
   * The feature id for the '<em><b>Anonymous parameter 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER___ANONYMOUS_PARAMETER_11 = 0;

  /**
   * The number of structural features of the '<em>Parameter </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_parameter_1_Impl <em>Anonymous parameter 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_parameter_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_parameter_1_()
   * @generated
   */
  int ANONYMOUS_PARAMETER_1 = 46;

  /**
   * The feature id for the '<em><b>List 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PARAMETER_1__LIST_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PARAMETER_1__NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PARAMETER_1__TYPE_1 = 2;

  /**
   * The number of structural features of the '<em>Anonymous parameter 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_PARAMETER_1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Association_Impl <em>Association </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Association_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociation_()
   * @generated
   */
  int ASSOCIATION_ = 47;

  /**
   * The feature id for the '<em><b>Modifier 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION___MODIFIER_1 = 0;

  /**
   * The feature id for the '<em><b>Association End 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION___ASSOCIATION_END_1 = 1;

  /**
   * The feature id for the '<em><b>Arrow 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION___ARROW_1 = 2;

  /**
   * The feature id for the '<em><b>Association End 2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION___ASSOCIATION_END_2 = 3;

  /**
   * The number of structural features of the '<em>Association </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SymmetricReflexiveAssociation_Impl <em>Symmetric Reflexive Association </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SymmetricReflexiveAssociation_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSymmetricReflexiveAssociation_()
   * @generated
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION_ = 48;

  /**
   * The feature id for the '<em><b>Multiplicity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION___MULTIPLICITY_1 = 0;

  /**
   * The feature id for the '<em><b>Role Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION___ROLE_NAME_1 = 1;

  /**
   * The number of structural features of the '<em>Symmetric Reflexive Association </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InlineAssociation_Impl <em>Inline Association </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InlineAssociation_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineAssociation_()
   * @generated
   */
  int INLINE_ASSOCIATION_ = 49;

  /**
   * The feature id for the '<em><b>Modifier 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION___MODIFIER_1 = 0;

  /**
   * The feature id for the '<em><b>Inline Association End 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION___INLINE_ASSOCIATION_END_1 = 1;

  /**
   * The feature id for the '<em><b>Arrow 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION___ARROW_1 = 2;

  /**
   * The feature id for the '<em><b>Association End 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION___ASSOCIATION_END_1 = 3;

  /**
   * The number of structural features of the '<em>Inline Association </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InlineAssociationEnd_Impl <em>Inline Association End </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InlineAssociationEnd_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineAssociationEnd_()
   * @generated
   */
  int INLINE_ASSOCIATION_END_ = 50;

  /**
   * The feature id for the '<em><b>Multiplicity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION_END___MULTIPLICITY_1 = 0;

  /**
   * The feature id for the '<em><b>Is Sorted 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION_END___IS_SORTED_1 = 1;

  /**
   * The feature id for the '<em><b>Role Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION_END___ROLE_NAME_1 = 2;

  /**
   * The number of structural features of the '<em>Inline Association End </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION_END__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SingleAssociationEnd_Impl <em>Single Association End </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SingleAssociationEnd_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSingleAssociationEnd_()
   * @generated
   */
  int SINGLE_ASSOCIATION_END_ = 51;

  /**
   * The feature id for the '<em><b>Multiplicity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END___MULTIPLICITY_1 = 0;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END___TYPE_1 = 1;

  /**
   * The feature id for the '<em><b>Role Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END___ROLE_NAME_1 = 2;

  /**
   * The number of structural features of the '<em>Single Association End </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationEnd_Impl <em>Association End </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationEnd_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationEnd_()
   * @generated
   */
  int ASSOCIATION_END_ = 52;

  /**
   * The feature id for the '<em><b>Multiplicity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END___MULTIPLICITY_1 = 0;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END___TYPE_1 = 1;

  /**
   * The feature id for the '<em><b>Role Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END___ROLE_NAME_1 = 2;

  /**
   * The feature id for the '<em><b>Is Sorted 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END___IS_SORTED_1 = 3;

  /**
   * The number of structural features of the '<em>Association End </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_END__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Multiplicity_Impl <em>Multiplicity </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Multiplicity_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getMultiplicity_()
   * @generated
   */
  int MULTIPLICITY_ = 53;

  /**
   * The feature id for the '<em><b>Bound 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY___BOUND_1 = 0;

  /**
   * The feature id for the '<em><b>Lower Bound 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY___LOWER_BOUND_1 = 1;

  /**
   * The feature id for the '<em><b>Upper Bound 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY___UPPER_BOUND_1 = 2;

  /**
   * The feature id for the '<em><b>Bound int</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY___BOUND_INT = 3;

  /**
   * The number of structural features of the '<em>Multiplicity </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.IsSorted_Impl <em>Is Sorted </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.IsSorted_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getIsSorted_()
   * @generated
   */
  int IS_SORTED_ = 54;

  /**
   * The feature id for the '<em><b>Priority 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_SORTED___PRIORITY_1 = 0;

  /**
   * The number of structural features of the '<em>Is Sorted </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_SORTED__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Attribute_Impl <em>Attribute </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Attribute_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAttribute_()
   * @generated
   */
  int ATTRIBUTE_ = 55;

  /**
   * The feature id for the '<em><b>Simple Attribute 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___SIMPLE_ATTRIBUTE_1 = 0;

  /**
   * The feature id for the '<em><b>Autounique Attribute 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___AUTOUNIQUE_ATTRIBUTE_1 = 1;

  /**
   * The feature id for the '<em><b>Derived Attribute 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___DERIVED_ATTRIBUTE_1 = 2;

  /**
   * The feature id for the '<em><b>Complex Attribute 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE___COMPLEX_ATTRIBUTE_1 = 3;

  /**
   * The number of structural features of the '<em>Attribute </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SimpleAttribute_Impl <em>Simple Attribute </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SimpleAttribute_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSimpleAttribute_()
   * @generated
   */
  int SIMPLE_ATTRIBUTE_ = 56;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ATTRIBUTE___NAME_1 = 0;

  /**
   * The number of structural features of the '<em>Simple Attribute </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_ATTRIBUTE__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AutouniqueAttribute_Impl <em>Autounique Attribute </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AutouniqueAttribute_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAutouniqueAttribute_()
   * @generated
   */
  int AUTOUNIQUE_ATTRIBUTE_ = 57;

  /**
   * The feature id for the '<em><b>Autounique 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTOUNIQUE_ATTRIBUTE___AUTOUNIQUE_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTOUNIQUE_ATTRIBUTE___NAME_1 = 1;

  /**
   * The number of structural features of the '<em>Autounique Attribute </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTOUNIQUE_ATTRIBUTE__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.DerivedAttribute_Impl <em>Derived Attribute </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.DerivedAttribute_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getDerivedAttribute_()
   * @generated
   */
  int DERIVED_ATTRIBUTE_ = 58;

  /**
   * The feature id for the '<em><b>Modifier 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_ATTRIBUTE___MODIFIER_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous derived Attribute 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_ATTRIBUTE___ANONYMOUS_DERIVED_ATTRIBUTE_11 = 1;

  /**
   * The feature id for the '<em><b>Anonymous derived Attribute 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_ATTRIBUTE___ANONYMOUS_DERIVED_ATTRIBUTE_21 = 2;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_ATTRIBUTE___CODE_1 = 3;

  /**
   * The feature id for the '<em><b>Anonymous derived Attribute 31</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_ATTRIBUTE___ANONYMOUS_DERIVED_ATTRIBUTE_31 = 4;

  /**
   * The number of structural features of the '<em>Derived Attribute </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DERIVED_ATTRIBUTE__FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_derivedAttribute_1_Impl <em>Anonymous derived Attribute 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_derivedAttribute_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_derivedAttribute_1_()
   * @generated
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_1 = 59;

  /**
   * The feature id for the '<em><b>List 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_1__LIST_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_1__NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_1__TYPE_1 = 2;

  /**
   * The number of structural features of the '<em>Anonymous derived Attribute 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_derivedAttribute_2_Impl <em>Anonymous derived Attribute 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_derivedAttribute_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_derivedAttribute_2_()
   * @generated
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_2 = 60;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_2__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous derived Attribute 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_2_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_derivedAttribute_3_Impl <em>Anonymous derived Attribute 3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_derivedAttribute_3_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_derivedAttribute_3_()
   * @generated
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_3 = 61;

  /**
   * The feature id for the '<em><b>More Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_3__MORE_CODE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous derived Attribute 3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_DERIVED_ATTRIBUTE_3_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ComplexAttribute_Impl <em>Complex Attribute </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ComplexAttribute_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getComplexAttribute_()
   * @generated
   */
  int COMPLEX_ATTRIBUTE_ = 62;

  /**
   * The feature id for the '<em><b>Unique 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_ATTRIBUTE___UNIQUE_1 = 0;

  /**
   * The feature id for the '<em><b>Lazy 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_ATTRIBUTE___LAZY_1 = 1;

  /**
   * The feature id for the '<em><b>Modifier 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_ATTRIBUTE___MODIFIER_1 = 2;

  /**
   * The feature id for the '<em><b>Anonymous complex Attribute 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_11 = 3;

  /**
   * The feature id for the '<em><b>Anonymous complex Attribute 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_21 = 4;

  /**
   * The number of structural features of the '<em>Complex Attribute </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_ATTRIBUTE__FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_complexAttribute_1_Impl <em>Anonymous complex Attribute 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_complexAttribute_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_complexAttribute_1_()
   * @generated
   */
  int ANONYMOUS_COMPLEX_ATTRIBUTE_1 = 63;

  /**
   * The feature id for the '<em><b>List 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_COMPLEX_ATTRIBUTE_1__LIST_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_COMPLEX_ATTRIBUTE_1__NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_COMPLEX_ATTRIBUTE_1__TYPE_1 = 2;

  /**
   * The number of structural features of the '<em>Anonymous complex Attribute 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_COMPLEX_ATTRIBUTE_1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_complexAttribute_2_Impl <em>Anonymous complex Attribute 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_complexAttribute_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_complexAttribute_2_()
   * @generated
   */
  int ANONYMOUS_COMPLEX_ATTRIBUTE_2 = 64;

  /**
   * The feature id for the '<em><b>Value 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_COMPLEX_ATTRIBUTE_2__VALUE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous complex Attribute 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_COMPLEX_ATTRIBUTE_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Key_Impl <em>Key </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Key_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getKey_()
   * @generated
   */
  int KEY_ = 65;

  /**
   * The feature id for the '<em><b>Key Id 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY___KEY_ID_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous key 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY___ANONYMOUS_KEY_11 = 1;

  /**
   * The number of structural features of the '<em>Key </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_key_1_Impl <em>Anonymous key 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_key_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_key_1_()
   * @generated
   */
  int ANONYMOUS_KEY_1 = 66;

  /**
   * The feature id for the '<em><b>Key Id 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_KEY_1__KEY_ID_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous key 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_KEY_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Depend_Impl <em>Depend </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Depend_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getDepend_()
   * @generated
   */
  int DEPEND_ = 67;

  /**
   * The feature id for the '<em><b>Depend 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPEND___DEPEND_1 = 0;

  /**
   * The number of structural features of the '<em>Depend </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPEND__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ExtraCode_Impl <em>Extra Code </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ExtraCode_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getExtraCode_()
   * @generated
   */
  int EXTRA_CODE_ = 68;

  /**
   * The feature id for the '<em><b>Extra Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTRA_CODE___EXTRA_CODE_1 = 0;

  /**
   * The number of structural features of the '<em>Extra Code </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTRA_CODE__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SoftwarePattern_Impl <em>Software Pattern </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SoftwarePattern_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSoftwarePattern_()
   * @generated
   */
  int SOFTWARE_PATTERN_ = 69;

  /**
   * The feature id for the '<em><b>Is A1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_PATTERN___IS_A1 = 0;

  /**
   * The feature id for the '<em><b>Singleton 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_PATTERN___SINGLETON_1 = 1;

  /**
   * The feature id for the '<em><b>Immutable 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_PATTERN___IMMUTABLE_1 = 2;

  /**
   * The feature id for the '<em><b>Key Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_PATTERN___KEY_DEFINITION_1 = 3;

  /**
   * The feature id for the '<em><b>Code Injection 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_PATTERN___CODE_INJECTION_1 = 4;

  /**
   * The number of structural features of the '<em>Software Pattern </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_PATTERN__FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.IsA_Impl <em>Is A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.IsA_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getIsA_()
   * @generated
   */
  int IS_A = 70;

  /**
   * The feature id for the '<em><b>Single Is A1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_A__SINGLE_IS_A1 = 0;

  /**
   * The feature id for the '<em><b>Multiple Is A1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_A__MULTIPLE_IS_A1 = 1;

  /**
   * The number of structural features of the '<em>Is A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_A_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SingleIsA_Impl <em>Single Is A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SingleIsA_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSingleIsA_()
   * @generated
   */
  int SINGLE_IS_A = 71;

  /**
   * The feature id for the '<em><b>Extends Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_IS_A__EXTENDS_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous single Is A11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_IS_A__ANONYMOUS_SINGLE_IS_A11 = 1;

  /**
   * The number of structural features of the '<em>Single Is A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_IS_A_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_singleIsA_1_Impl <em>Anonymous single Is A1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_singleIsA_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_singleIsA_1_()
   * @generated
   */
  int ANONYMOUS_SINGLE_IS_A1 = 72;

  /**
   * The feature id for the '<em><b>Extends Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_SINGLE_IS_A1__EXTENDS_NAME_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous single Is A1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_SINGLE_IS_A1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.MultipleIsA_Impl <em>Multiple Is A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.MultipleIsA_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getMultipleIsA_()
   * @generated
   */
  int MULTIPLE_IS_A = 73;

  /**
   * The feature id for the '<em><b>Extends Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLE_IS_A__EXTENDS_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous multiple Is A11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLE_IS_A__ANONYMOUS_MULTIPLE_IS_A11 = 1;

  /**
   * The number of structural features of the '<em>Multiple Is A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLE_IS_A_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_multipleIsA_1_Impl <em>Anonymous multiple Is A1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_multipleIsA_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_multipleIsA_1_()
   * @generated
   */
  int ANONYMOUS_MULTIPLE_IS_A1 = 74;

  /**
   * The feature id for the '<em><b>Extends Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_MULTIPLE_IS_A1__EXTENDS_NAME_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous multiple Is A1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_MULTIPLE_IS_A1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Singleton_Impl <em>Singleton </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Singleton_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSingleton_()
   * @generated
   */
  int SINGLETON_ = 75;

  /**
   * The feature id for the '<em><b>Singleton 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLETON___SINGLETON_1 = 0;

  /**
   * The number of structural features of the '<em>Singleton </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLETON__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Immutable_Impl <em>Immutable </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Immutable_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getImmutable_()
   * @generated
   */
  int IMMUTABLE_ = 76;

  /**
   * The feature id for the '<em><b>Immutable 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMMUTABLE___IMMUTABLE_1 = 0;

  /**
   * The number of structural features of the '<em>Immutable </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMMUTABLE__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.KeyDefinition_Impl <em>Key Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.KeyDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getKeyDefinition_()
   * @generated
   */
  int KEY_DEFINITION_ = 77;

  /**
   * The feature id for the '<em><b>Default Key 1</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_DEFINITION___DEFAULT_KEY_1 = 0;

  /**
   * The feature id for the '<em><b>Key 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_DEFINITION___KEY_1 = 1;

  /**
   * The number of structural features of the '<em>Key Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_DEFINITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CodeInjection_Impl <em>Code Injection </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CodeInjection_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCodeInjection_()
   * @generated
   */
  int CODE_INJECTION_ = 78;

  /**
   * The feature id for the '<em><b>Before Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION___BEFORE_CODE_1 = 0;

  /**
   * The feature id for the '<em><b>After Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION___AFTER_CODE_1 = 1;

  /**
   * The number of structural features of the '<em>Code Injection </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.BeforeCode_Impl <em>Before Code </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.BeforeCode_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getBeforeCode_()
   * @generated
   */
  int BEFORE_CODE_ = 79;

  /**
   * The feature id for the '<em><b>Operation Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEFORE_CODE___OPERATION_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous before Code 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEFORE_CODE___ANONYMOUS_BEFORE_CODE_11 = 1;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEFORE_CODE___CODE_1 = 2;

  /**
   * The feature id for the '<em><b>Anonymous before Code 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEFORE_CODE___ANONYMOUS_BEFORE_CODE_21 = 3;

  /**
   * The number of structural features of the '<em>Before Code </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEFORE_CODE__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_beforeCode_1_Impl <em>Anonymous before Code 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_beforeCode_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_beforeCode_1_()
   * @generated
   */
  int ANONYMOUS_BEFORE_CODE_1 = 80;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_BEFORE_CODE_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_BEFORE_CODE_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous before Code 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_BEFORE_CODE_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_beforeCode_2_Impl <em>Anonymous before Code 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_beforeCode_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_beforeCode_2_()
   * @generated
   */
  int ANONYMOUS_BEFORE_CODE_2 = 81;

  /**
   * The feature id for the '<em><b>More Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_BEFORE_CODE_2__MORE_CODE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous before Code 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_BEFORE_CODE_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AfterCode_Impl <em>After Code </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AfterCode_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAfterCode_()
   * @generated
   */
  int AFTER_CODE_ = 82;

  /**
   * The feature id for the '<em><b>Operation Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_CODE___OPERATION_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous after Code 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_CODE___ANONYMOUS_AFTER_CODE_11 = 1;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_CODE___CODE_1 = 2;

  /**
   * The feature id for the '<em><b>Anonymous after Code 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_CODE___ANONYMOUS_AFTER_CODE_21 = 3;

  /**
   * The number of structural features of the '<em>After Code </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_CODE__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_afterCode_1_Impl <em>Anonymous after Code 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_afterCode_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_afterCode_1_()
   * @generated
   */
  int ANONYMOUS_AFTER_CODE_1 = 83;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_AFTER_CODE_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_AFTER_CODE_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous after Code 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_AFTER_CODE_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_afterCode_2_Impl <em>Anonymous after Code 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_afterCode_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_afterCode_2_()
   * @generated
   */
  int ANONYMOUS_AFTER_CODE_2 = 84;

  /**
   * The feature id for the '<em><b>More Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_AFTER_CODE_2__MORE_CODE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous after Code 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_AFTER_CODE_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StateMachineDefinition_Impl <em>State Machine Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StateMachineDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStateMachineDefinition_()
   * @generated
   */
  int STATE_MACHINE_DEFINITION_ = 85;

  /**
   * The feature id for the '<em><b>Queued 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_DEFINITION___QUEUED_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_DEFINITION___NAME_1 = 1;

  /**
   * The feature id for the '<em><b>State 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_DEFINITION___STATE_1 = 2;

  /**
   * The number of structural features of the '<em>State Machine Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_DEFINITION__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StateMachine_Impl <em>State Machine </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StateMachine_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStateMachine_()
   * @generated
   */
  int STATE_MACHINE_ = 86;

  /**
   * The feature id for the '<em><b>Enum 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE___ENUM_1 = 0;

  /**
   * The feature id for the '<em><b>Inline State Machine 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE___INLINE_STATE_MACHINE_1 = 1;

  /**
   * The feature id for the '<em><b>Referenced State Machine 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE___REFERENCED_STATE_MACHINE_1 = 2;

  /**
   * The feature id for the '<em><b>Active Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE___ACTIVE_DEFINITION_1 = 3;

  /**
   * The number of structural features of the '<em>State Machine </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ActiveDefinition_Impl <em>Active Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ActiveDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getActiveDefinition_()
   * @generated
   */
  int ACTIVE_DEFINITION_ = 87;

  /**
   * The feature id for the '<em><b>Active 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVE_DEFINITION___ACTIVE_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVE_DEFINITION___NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVE_DEFINITION___CODE_1 = 2;

  /**
   * The number of structural features of the '<em>Active Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVE_DEFINITION__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InlineStateMachine_Impl <em>Inline State Machine </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InlineStateMachine_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineStateMachine_()
   * @generated
   */
  int INLINE_STATE_MACHINE_ = 88;

  /**
   * The feature id for the '<em><b>Queued 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_STATE_MACHINE___QUEUED_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_STATE_MACHINE___NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous inline State Machine 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_STATE_MACHINE___ANONYMOUS_INLINE_STATE_MACHINE_11 = 2;

  /**
   * The number of structural features of the '<em>Inline State Machine </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_STATE_MACHINE__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_inlineStateMachine_1_Impl <em>Anonymous inline State Machine 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_inlineStateMachine_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_inlineStateMachine_1_()
   * @generated
   */
  int ANONYMOUS_INLINE_STATE_MACHINE_1 = 89;

  /**
   * The feature id for the '<em><b>Comment 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_INLINE_STATE_MACHINE_1__COMMENT_1 = 0;

  /**
   * The feature id for the '<em><b>State 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_INLINE_STATE_MACHINE_1__STATE_1 = 1;

  /**
   * The feature id for the '<em><b>Trace 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_INLINE_STATE_MACHINE_1__TRACE_1 = 2;

  /**
   * The number of structural features of the '<em>Anonymous inline State Machine 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_INLINE_STATE_MACHINE_1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ReferencedStateMachine_Impl <em>Referenced State Machine </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ReferencedStateMachine_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getReferencedStateMachine_()
   * @generated
   */
  int REFERENCED_STATE_MACHINE_ = 90;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_STATE_MACHINE___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Definition Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_STATE_MACHINE___DEFINITION_NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Extended State Machine 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_STATE_MACHINE___EXTENDED_STATE_MACHINE_1 = 2;

  /**
   * The number of structural features of the '<em>Referenced State Machine </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_STATE_MACHINE__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ExtendedStateMachine_Impl <em>Extended State Machine </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ExtendedStateMachine_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getExtendedStateMachine_()
   * @generated
   */
  int EXTENDED_STATE_MACHINE_ = 91;

  /**
   * The feature id for the '<em><b>Anonymous extended State Machine 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENDED_STATE_MACHINE___ANONYMOUS_EXTENDED_STATE_MACHINE_11 = 0;

  /**
   * The number of structural features of the '<em>Extended State Machine </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENDED_STATE_MACHINE__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_extendedStateMachine_1_Impl <em>Anonymous extended State Machine 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_extendedStateMachine_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_extendedStateMachine_1_()
   * @generated
   */
  int ANONYMOUS_EXTENDED_STATE_MACHINE_1 = 92;

  /**
   * The feature id for the '<em><b>Comment 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_EXTENDED_STATE_MACHINE_1__COMMENT_1 = 0;

  /**
   * The feature id for the '<em><b>Change Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_EXTENDED_STATE_MACHINE_1__CHANGE_TYPE_1 = 1;

  /**
   * The feature id for the '<em><b>State 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_EXTENDED_STATE_MACHINE_1__STATE_1 = 2;

  /**
   * The number of structural features of the '<em>Anonymous extended State Machine 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_EXTENDED_STATE_MACHINE_1_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Enum_Impl <em>Enum </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Enum_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEnum_()
   * @generated
   */
  int ENUM_ = 93;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>State Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM___STATE_NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous enum 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM___ANONYMOUS_ENUM_11 = 2;

  /**
   * The number of structural features of the '<em>Enum </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_enum_1_Impl <em>Anonymous enum 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_enum_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_enum_1_()
   * @generated
   */
  int ANONYMOUS_ENUM_1 = 94;

  /**
   * The feature id for the '<em><b>State Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ENUM_1__STATE_NAME_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous enum 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ENUM_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.State_Impl <em>State </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.State_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getState_()
   * @generated
   */
  int STATE_ = 95;

  /**
   * The feature id for the '<em><b>State Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE___STATE_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>State Internal 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE___STATE_INTERNAL_1 = 1;

  /**
   * The feature id for the '<em><b>Final 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE___FINAL_1 = 2;

  /**
   * The feature id for the '<em><b>Anonymous state 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE___ANONYMOUS_STATE_11 = 3;

  /**
   * The number of structural features of the '<em>State </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_state_1_Impl <em>Anonymous state 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_state_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_state_1_()
   * @generated
   */
  int ANONYMOUS_STATE_1 = 96;

  /**
   * The feature id for the '<em><b>State Internal 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_STATE_1__STATE_INTERNAL_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous state 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_STATE_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StateInternal_Impl <em>State Internal </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StateInternal_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStateInternal_()
   * @generated
   */
  int STATE_INTERNAL_ = 97;

  /**
   * The feature id for the '<em><b>Comment 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_INTERNAL___COMMENT_1 = 0;

  /**
   * The feature id for the '<em><b>Change Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_INTERNAL___CHANGE_TYPE_1 = 1;

  /**
   * The feature id for the '<em><b>State Entity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_INTERNAL___STATE_ENTITY_1 = 2;

  /**
   * The number of structural features of the '<em>State Internal </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_INTERNAL__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StateEntity_Impl <em>State Entity </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StateEntity_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStateEntity_()
   * @generated
   */
  int STATE_ENTITY_ = 98;

  /**
   * The feature id for the '<em><b>Entry Or Exit Action 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY___ENTRY_OR_EXIT_ACTION_1 = 0;

  /**
   * The feature id for the '<em><b>Auto Transition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY___AUTO_TRANSITION_1 = 1;

  /**
   * The feature id for the '<em><b>Transition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY___TRANSITION_1 = 2;

  /**
   * The feature id for the '<em><b>Activity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY___ACTIVITY_1 = 3;

  /**
   * The feature id for the '<em><b>State 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY___STATE_1 = 4;

  /**
   * The feature id for the '<em><b>Trace 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY___TRACE_1 = 5;

  /**
   * The number of structural features of the '<em>State Entity </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY__FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AutoTransition_Impl <em>Auto Transition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AutoTransition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAutoTransition_()
   * @generated
   */
  int AUTO_TRANSITION_ = 99;

  /**
   * The feature id for the '<em><b>Auto Transition Block 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTO_TRANSITION___AUTO_TRANSITION_BLOCK_1 = 0;

  /**
   * The feature id for the '<em><b>Activity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTO_TRANSITION___ACTIVITY_1 = 1;

  /**
   * The number of structural features of the '<em>Auto Transition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTO_TRANSITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AutoTransitionBlock_Impl <em>Auto Transition Block </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AutoTransitionBlock_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAutoTransitionBlock_()
   * @generated
   */
  int AUTO_TRANSITION_BLOCK_ = 100;

  /**
   * The feature id for the '<em><b>Guard 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTO_TRANSITION_BLOCK___GUARD_1 = 0;

  /**
   * The feature id for the '<em><b>Action 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTO_TRANSITION_BLOCK___ACTION_1 = 1;

  /**
   * The feature id for the '<em><b>State Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTO_TRANSITION_BLOCK___STATE_NAME_1 = 2;

  /**
   * The number of structural features of the '<em>Auto Transition Block </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUTO_TRANSITION_BLOCK__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Transition_Impl <em>Transition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Transition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTransition_()
   * @generated
   */
  int TRANSITION_ = 101;

  /**
   * The feature id for the '<em><b>Guard 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION___GUARD_1 = 0;

  /**
   * The feature id for the '<em><b>Event Definition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION___EVENT_DEFINITION_1 = 1;

  /**
   * The feature id for the '<em><b>Action 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION___ACTION_1 = 2;

  /**
   * The feature id for the '<em><b>State Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION___STATE_NAME_1 = 3;

  /**
   * The number of structural features of the '<em>Transition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.EventDefinition_Impl <em>Event Definition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.EventDefinition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEventDefinition_()
   * @generated
   */
  int EVENT_DEFINITION_ = 102;

  /**
   * The feature id for the '<em><b>After Every Event 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION___AFTER_EVERY_EVENT_1 = 0;

  /**
   * The feature id for the '<em><b>After Event 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION___AFTER_EVENT_1 = 1;

  /**
   * The feature id for the '<em><b>Event 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION___EVENT_1 = 2;

  /**
   * The feature id for the '<em><b>Anonymous event Definition 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION___ANONYMOUS_EVENT_DEFINITION_11 = 3;

  /**
   * The number of structural features of the '<em>Event Definition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_eventDefinition_1_Impl <em>Anonymous event Definition 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_eventDefinition_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_eventDefinition_1_()
   * @generated
   */
  int ANONYMOUS_EVENT_DEFINITION_1 = 103;

  /**
   * The feature id for the '<em><b>Parameter List 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_EVENT_DEFINITION_1__PARAMETER_LIST_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous event Definition 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_EVENT_DEFINITION_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AfterEveryEvent_Impl <em>After Every Event </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AfterEveryEvent_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAfterEveryEvent_()
   * @generated
   */
  int AFTER_EVERY_EVENT_ = 104;

  /**
   * The feature id for the '<em><b>Timer 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_EVERY_EVENT___TIMER_1 = 0;

  /**
   * The number of structural features of the '<em>After Every Event </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_EVERY_EVENT__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AfterEvent_Impl <em>After Event </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AfterEvent_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAfterEvent_()
   * @generated
   */
  int AFTER_EVENT_ = 105;

  /**
   * The feature id for the '<em><b>Timer 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_EVENT___TIMER_1 = 0;

  /**
   * The number of structural features of the '<em>After Event </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFTER_EVENT__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Action_Impl <em>Action </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Action_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAction_()
   * @generated
   */
  int ACTION_ = 106;

  /**
   * The feature id for the '<em><b>Anonymous action 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION___ANONYMOUS_ACTION_11 = 0;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION___CODE_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous action 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION___ANONYMOUS_ACTION_21 = 2;

  /**
   * The number of structural features of the '<em>Action </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_action_1_Impl <em>Anonymous action 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_action_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_action_1_()
   * @generated
   */
  int ANONYMOUS_ACTION_1 = 107;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTION_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTION_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous action 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTION_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_action_2_Impl <em>Anonymous action 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_action_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_action_2_()
   * @generated
   */
  int ANONYMOUS_ACTION_2 = 108;

  /**
   * The feature id for the '<em><b>More Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTION_2__MORE_CODE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous action 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTION_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.EntryOrExitAction_Impl <em>Entry Or Exit Action </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.EntryOrExitAction_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEntryOrExitAction_()
   * @generated
   */
  int ENTRY_OR_EXIT_ACTION_ = 109;

  /**
   * The feature id for the '<em><b>Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION___TYPE_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous entry Or Exit Action 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_11 = 1;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION___CODE_1 = 2;

  /**
   * The feature id for the '<em><b>Anonymous entry Or Exit Action 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION___ANONYMOUS_ENTRY_OR_EXIT_ACTION_21 = 3;

  /**
   * The number of structural features of the '<em>Entry Or Exit Action </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_entryOrExitAction_1_Impl <em>Anonymous entry Or Exit Action 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_entryOrExitAction_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_entryOrExitAction_1_()
   * @generated
   */
  int ANONYMOUS_ENTRY_OR_EXIT_ACTION_1 = 110;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ENTRY_OR_EXIT_ACTION_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ENTRY_OR_EXIT_ACTION_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous entry Or Exit Action 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ENTRY_OR_EXIT_ACTION_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_entryOrExitAction_2_Impl <em>Anonymous entry Or Exit Action 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_entryOrExitAction_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_entryOrExitAction_2_()
   * @generated
   */
  int ANONYMOUS_ENTRY_OR_EXIT_ACTION_2 = 111;

  /**
   * The feature id for the '<em><b>More Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ENTRY_OR_EXIT_ACTION_2__MORE_CODE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous entry Or Exit Action 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ENTRY_OR_EXIT_ACTION_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Activity_Impl <em>Activity </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Activity_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getActivity_()
   * @generated
   */
  int ACTIVITY_ = 112;

  /**
   * The feature id for the '<em><b>Anonymous activity 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY___ANONYMOUS_ACTIVITY_11 = 0;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY___CODE_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous activity 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY___ANONYMOUS_ACTIVITY_21 = 2;

  /**
   * The number of structural features of the '<em>Activity </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_activity_1_Impl <em>Anonymous activity 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_activity_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_activity_1_()
   * @generated
   */
  int ANONYMOUS_ACTIVITY_1 = 113;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTIVITY_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTIVITY_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous activity 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTIVITY_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_activity_2_Impl <em>Anonymous activity 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_activity_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_activity_2_()
   * @generated
   */
  int ANONYMOUS_ACTIVITY_2 = 114;

  /**
   * The feature id for the '<em><b>More Code 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTIVITY_2__MORE_CODE_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous activity 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_ACTIVITY_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.MoreGuards_Impl <em>More Guards </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.MoreGuards_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getMoreGuards_()
   * @generated
   */
  int MORE_GUARDS_ = 115;

  /**
   * The feature id for the '<em><b>Anonymous more Guards 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORE_GUARDS___ANONYMOUS_MORE_GUARDS_11 = 0;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORE_GUARDS___CODE_1 = 1;

  /**
   * The number of structural features of the '<em>More Guards </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORE_GUARDS__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_moreGuards_1_Impl <em>Anonymous more Guards 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_moreGuards_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_moreGuards_1_()
   * @generated
   */
  int ANONYMOUS_MORE_GUARDS_1 = 116;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_MORE_GUARDS_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_MORE_GUARDS_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous more Guards 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_MORE_GUARDS_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Guard_Impl <em>Guard </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Guard_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGuard_()
   * @generated
   */
  int GUARD_ = 117;

  /**
   * The feature id for the '<em><b>Anonymous guard 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD___ANONYMOUS_GUARD_11 = 0;

  /**
   * The feature id for the '<em><b>Code 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD___CODE_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous guard 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD___ANONYMOUS_GUARD_21 = 2;

  /**
   * The number of structural features of the '<em>Guard </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_guard_1_Impl <em>Anonymous guard 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_guard_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_guard_1_()
   * @generated
   */
  int ANONYMOUS_GUARD_1 = 118;

  /**
   * The feature id for the '<em><b>Code Lang 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GUARD_1__CODE_LANG_1 = 0;

  /**
   * The feature id for the '<em><b>Code Langs 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GUARD_1__CODE_LANGS_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous guard 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GUARD_1_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_guard_2_Impl <em>Anonymous guard 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_guard_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_guard_2_()
   * @generated
   */
  int ANONYMOUS_GUARD_2 = 119;

  /**
   * The feature id for the '<em><b>More Guards 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GUARD_2__MORE_GUARDS_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous guard 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GUARD_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceType_Impl <em>Trace Type </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceType_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceType_()
   * @generated
   */
  int TRACE_TYPE_ = 120;

  /**
   * The feature id for the '<em><b>Tracer Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_TYPE___TRACER_TYPE_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous trace Type 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_TYPE___ANONYMOUS_TRACE_TYPE_11 = 1;

  /**
   * The feature id for the '<em><b>Anonymous trace Type 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_TYPE___ANONYMOUS_TRACE_TYPE_21 = 2;

  /**
   * The number of structural features of the '<em>Trace Type </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_TYPE__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_traceType_1_Impl <em>Anonymous trace Type 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_traceType_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_traceType_1_()
   * @generated
   */
  int ANONYMOUS_TRACE_TYPE_1 = 121;

  /**
   * The feature id for the '<em><b>Verbisty 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_TYPE_1__VERBISTY_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous trace Type 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_TYPE_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_traceType_2_Impl <em>Anonymous trace Type 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_traceType_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_traceType_2_()
   * @generated
   */
  int ANONYMOUS_TRACE_TYPE_2 = 122;

  /**
   * The feature id for the '<em><b>Tracer Argument 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_TYPE_2__TRACER_ARGUMENT_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous trace Type 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_TYPE_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Trace_Impl <em>Trace </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Trace_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTrace_()
   * @generated
   */
  int TRACE_ = 123;

  /**
   * The feature id for the '<em><b>Trace Directive 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE___TRACE_DIRECTIVE_1 = 0;

  /**
   * The feature id for the '<em><b>Trace Case 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE___TRACE_CASE_1 = 1;

  /**
   * The number of structural features of the '<em>Trace </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceDirective_Impl <em>Trace Directive </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceDirective_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceDirective_()
   * @generated
   */
  int TRACE_DIRECTIVE_ = 124;

  /**
   * The feature id for the '<em><b>Trace Item 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DIRECTIVE___TRACE_ITEM_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous trace Directive 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DIRECTIVE___ANONYMOUS_TRACE_DIRECTIVE_11 = 1;

  /**
   * The number of structural features of the '<em>Trace Directive </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DIRECTIVE__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl <em>Anonymous trace Directive 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_traceDirective_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_traceDirective_1_()
   * @generated
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1 = 125;

  /**
   * The feature id for the '<em><b>Execute Clause 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1__EXECUTE_CLAUSE_1 = 0;

  /**
   * The feature id for the '<em><b>Trace When 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_WHEN_1 = 1;

  /**
   * The feature id for the '<em><b>Trace For 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_FOR_1 = 2;

  /**
   * The feature id for the '<em><b>Trace Period 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_PERIOD_1 = 3;

  /**
   * The feature id for the '<em><b>Trace During 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_DURING_1 = 4;

  /**
   * The feature id for the '<em><b>Trace Case Activation 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_CASE_ACTIVATION_1 = 5;

  /**
   * The feature id for the '<em><b>Trace Record 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_RECORD_1 = 6;

  /**
   * The feature id for the '<em><b>Trace Level 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1__TRACE_LEVEL_1 = 7;

  /**
   * The number of structural features of the '<em>Anonymous trace Directive 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_DIRECTIVE_1_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceItem_Impl <em>Trace Item </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceItem_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceItem_()
   * @generated
   */
  int TRACE_ITEM_ = 126;

  /**
   * The feature id for the '<em><b>Trace Entity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_ITEM___TRACE_ENTITY_1 = 0;

  /**
   * The feature id for the '<em><b>Pre Or Post Condition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_ITEM___PRE_OR_POST_CONDITION_1 = 1;

  /**
   * The number of structural features of the '<em>Trace Item </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_ITEM__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceEntity_Impl <em>Trace Entity </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceEntity_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceEntity_()
   * @generated
   */
  int TRACE_ENTITY_ = 127;

  /**
   * The feature id for the '<em><b>Trace Options 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_ENTITY___TRACE_OPTIONS_1 = 0;

  /**
   * The feature id for the '<em><b>Trace entity 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_ENTITY___TRACE_ENTITY_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous trace Entity 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_ENTITY___ANONYMOUS_TRACE_ENTITY_11 = 2;

  /**
   * The number of structural features of the '<em>Trace Entity </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_ENTITY__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_traceEntity_1_Impl <em>Anonymous trace Entity 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_traceEntity_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_traceEntity_1_()
   * @generated
   */
  int ANONYMOUS_TRACE_ENTITY_1 = 128;

  /**
   * The feature id for the '<em><b>Trace entity 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_ENTITY_1__TRACE_ENTITY_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous trace Entity 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_ENTITY_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceOptions_Impl <em>Trace Options </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceOptions_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceOptions_()
   * @generated
   */
  int TRACE_OPTIONS_ = 129;

  /**
   * The feature id for the '<em><b>Trace Option 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_OPTIONS___TRACE_OPTION_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous trace Options 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_OPTIONS___ANONYMOUS_TRACE_OPTIONS_11 = 1;

  /**
   * The number of structural features of the '<em>Trace Options </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_OPTIONS__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_traceOptions_1_Impl <em>Anonymous trace Options 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_traceOptions_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_traceOptions_1_()
   * @generated
   */
  int ANONYMOUS_TRACE_OPTIONS_1 = 130;

  /**
   * The feature id for the '<em><b>Trace Option 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_OPTIONS_1__TRACE_OPTION_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous trace Options 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_TRACE_OPTIONS_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceOption_Impl <em>Trace Option </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceOption_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceOption_()
   * @generated
   */
  int TRACE_OPTION_ = 131;

  /**
   * The feature id for the '<em><b>Option 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_OPTION___OPTION_1 = 0;

  /**
   * The number of structural features of the '<em>Trace Option </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_OPTION__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.PreOrPostCondition_Impl <em>Pre Or Post Condition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.PreOrPostCondition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getPreOrPostCondition_()
   * @generated
   */
  int PRE_OR_POST_CONDITION_ = 132;

  /**
   * The feature id for the '<em><b>Anonymous Pre Or Post Condition 11</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_OR_POST_CONDITION___ANONYMOUS_PRE_OR_POST_CONDITION_11 = 0;

  /**
   * The feature id for the '<em><b>Trace Condition 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_OR_POST_CONDITION___TRACE_CONDITION_1 = 1;

  /**
   * The number of structural features of the '<em>Pre Or Post Condition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_OR_POST_CONDITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ExecuteClause_Impl <em>Execute Clause </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ExecuteClause_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getExecuteClause_()
   * @generated
   */
  int EXECUTE_CLAUSE_ = 133;

  /**
   * The feature id for the '<em><b>Trace execute 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CLAUSE___TRACE_EXECUTE_1 = 0;

  /**
   * The number of structural features of the '<em>Execute Clause </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTE_CLAUSE__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceWhen_Impl <em>Trace When </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceWhen_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceWhen_()
   * @generated
   */
  int TRACE_WHEN_ = 134;

  /**
   * The feature id for the '<em><b>Condition Type 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_WHEN___CONDITION_TYPE_1 = 0;

  /**
   * The feature id for the '<em><b>Constraint Token 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_WHEN___CONSTRAINT_TOKEN_1 = 1;

  /**
   * The number of structural features of the '<em>Trace When </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_WHEN__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceFor_Impl <em>Trace For </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceFor_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceFor_()
   * @generated
   */
  int TRACE_FOR_ = 135;

  /**
   * The feature id for the '<em><b>Trace for 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_FOR___TRACE_FOR_1 = 0;

  /**
   * The number of structural features of the '<em>Trace For </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_FOR__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceLevel_Impl <em>Trace Level </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceLevel_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceLevel_()
   * @generated
   */
  int TRACE_LEVEL_ = 136;

  /**
   * The feature id for the '<em><b>Trace level 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_LEVEL___TRACE_LEVEL_1 = 0;

  /**
   * The number of structural features of the '<em>Trace Level </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_LEVEL__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TracePeriod_Impl <em>Trace Period </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TracePeriod_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTracePeriod_()
   * @generated
   */
  int TRACE_PERIOD_ = 137;

  /**
   * The feature id for the '<em><b>Trace period 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_PERIOD___TRACE_PERIOD_1 = 0;

  /**
   * The number of structural features of the '<em>Trace Period </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_PERIOD__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceDuring_Impl <em>Trace During </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceDuring_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceDuring_()
   * @generated
   */
  int TRACE_DURING_ = 138;

  /**
   * The feature id for the '<em><b>Trace duration 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DURING___TRACE_DURATION_1 = 0;

  /**
   * The number of structural features of the '<em>Trace During </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DURING__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceRecord_Impl <em>Trace Record </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceRecord_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceRecord_()
   * @generated
   */
  int TRACE_RECORD_ = 139;

  /**
   * The feature id for the '<em><b>Record Entity 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_RECORD___RECORD_ENTITY_1 = 0;

  /**
   * The number of structural features of the '<em>Trace Record </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_RECORD__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.RecordEntity_Impl <em>Record Entity </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.RecordEntity_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getRecordEntity_()
   * @generated
   */
  int RECORD_ENTITY_ = 140;

  /**
   * The feature id for the '<em><b>Anonymous record Entity 11</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_11 = 0;

  /**
   * The feature id for the '<em><b>Trace record 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ENTITY___TRACE_RECORD_1 = 1;

  /**
   * The feature id for the '<em><b>Anonymous record Entity 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ENTITY___ANONYMOUS_RECORD_ENTITY_21 = 2;

  /**
   * The number of structural features of the '<em>Record Entity </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ENTITY__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_recordEntity_2_Impl <em>Anonymous record Entity 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_recordEntity_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_recordEntity_2_()
   * @generated
   */
  int ANONYMOUS_RECORD_ENTITY_2 = 141;

  /**
   * The feature id for the '<em><b>Trace record 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_RECORD_ENTITY_2__TRACE_RECORD_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous record Entity 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_RECORD_ENTITY_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceCondition_Impl <em>Trace Condition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceCondition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCondition_()
   * @generated
   */
  int TRACE_CONDITION_ = 142;

  /**
   * The feature id for the '<em><b>LHS 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CONDITION___LHS_1 = 0;

  /**
   * The feature id for the '<em><b>Condition RHS 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CONDITION___CONDITION_RHS_1 = 1;

  /**
   * The number of structural features of the '<em>Trace Condition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CONDITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ConditionRHS_Impl <em>Condition RHS </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ConditionRHS_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getConditionRHS_()
   * @generated
   */
  int CONDITION_RHS_ = 143;

  /**
   * The feature id for the '<em><b>Comparison operator 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_RHS___COMPARISON_OPERATOR_1 = 0;

  /**
   * The feature id for the '<em><b>RHS 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_RHS___RHS_1 = 1;

  /**
   * The number of structural features of the '<em>Condition RHS </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_RHS__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceCase_Impl <em>Trace Case </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceCase_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCase_()
   * @generated
   */
  int TRACE_CASE_ = 144;

  /**
   * The feature id for the '<em><b>Trace Case Def 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE___TRACE_CASE_DEF_1 = 0;

  /**
   * The feature id for the '<em><b>Trace Case Activation 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE___TRACE_CASE_ACTIVATION_1 = 1;

  /**
   * The feature id for the '<em><b>Trace Case Deactivation 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE___TRACE_CASE_DEACTIVATION_1 = 2;

  /**
   * The number of structural features of the '<em>Trace Case </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceCaseDef_Impl <em>Trace Case Def </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceCaseDef_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCaseDef_()
   * @generated
   */
  int TRACE_CASE_DEF_ = 145;

  /**
   * The feature id for the '<em><b>Tracecase name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_DEF___TRACECASE_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Trace Directive 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_DEF___TRACE_DIRECTIVE_1 = 1;

  /**
   * The number of structural features of the '<em>Trace Case Def </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_DEF__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceCaseActivation_Impl <em>Trace Case Activation </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceCaseActivation_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCaseActivation_()
   * @generated
   */
  int TRACE_CASE_ACTIVATION_ = 146;

  /**
   * The feature id for the '<em><b>Tracecase act name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_ACTIVATION___TRACECASE_ACT_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous trace Case Activation 11</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_ACTIVATION___ANONYMOUS_TRACE_CASE_ACTIVATION_11 = 1;

  /**
   * The number of structural features of the '<em>Trace Case Activation </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_ACTIVATION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceCaseDeactivation_Impl <em>Trace Case Deactivation </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceCaseDeactivation_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCaseDeactivation_()
   * @generated
   */
  int TRACE_CASE_DEACTIVATION_ = 147;

  /**
   * The feature id for the '<em><b>Tracecase deact name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_DEACTIVATION___TRACECASE_DEACT_NAME_1 = 0;

  /**
   * The feature id for the '<em><b>De Activate For 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_DEACTIVATION___DE_ACTIVATE_FOR_1 = 1;

  /**
   * The number of structural features of the '<em>Trace Case Deactivation </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_DEACTIVATION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.DeActivateFor_Impl <em>De Activate For </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.DeActivateFor_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getDeActivateFor_()
   * @generated
   */
  int DE_ACTIVATE_FOR_ = 148;

  /**
   * The feature id for the '<em><b>Deactivate for 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DE_ACTIVATE_FOR___DEACTIVATE_FOR_1 = 0;

  /**
   * The number of structural features of the '<em>De Activate For </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DE_ACTIVATE_FOR__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Precondition_Impl <em>Precondition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Precondition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getPrecondition_()
   * @generated
   */
  int PRECONDITION_ = 149;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Constraint 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION___CONSTRAINT_1 = 1;

  /**
   * The number of structural features of the '<em>Precondition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECONDITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Postcondition_Impl <em>Postcondition </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Postcondition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getPostcondition_()
   * @generated
   */
  int POSTCONDITION_ = 150;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTCONDITION___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Constraint 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTCONDITION___CONSTRAINT_1 = 1;

  /**
   * The number of structural features of the '<em>Postcondition </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTCONDITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Invariant_Impl <em>Invariant </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Invariant_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInvariant_()
   * @generated
   */
  int INVARIANT_ = 151;

  /**
   * The feature id for the '<em><b>Anonymous invariant 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVARIANT___ANONYMOUS_INVARIANT_11 = 0;

  /**
   * The feature id for the '<em><b>Anonymous invariant 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVARIANT___ANONYMOUS_INVARIANT_21 = 1;

  /**
   * The number of structural features of the '<em>Invariant </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVARIANT__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_invariant_1_Impl <em>Anonymous invariant 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_invariant_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_invariant_1_()
   * @generated
   */
  int ANONYMOUS_INVARIANT_1 = 152;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_INVARIANT_1__NAME_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous invariant 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_INVARIANT_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_invariant_2_Impl <em>Anonymous invariant 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_invariant_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_invariant_2_()
   * @generated
   */
  int ANONYMOUS_INVARIANT_2 = 153;

  /**
   * The feature id for the '<em><b>Constraint 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_INVARIANT_2__CONSTRAINT_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous invariant 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_INVARIANT_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ConstraintToken_Impl <em>Constraint Token </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ConstraintToken_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getConstraintToken_()
   * @generated
   */
  int CONSTRAINT_TOKEN_ = 154;

  /**
   * The feature id for the '<em><b>Constraint 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_TOKEN___CONSTRAINT_1 = 0;

  /**
   * The number of structural features of the '<em>Constraint Token </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_TOKEN__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Constraint_Impl <em>Constraint </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Constraint_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getConstraint_()
   * @generated
   */
  int CONSTRAINT_ = 155;

  /**
   * The feature id for the '<em><b>Anonymous constraint 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT___ANONYMOUS_CONSTRAINT_11 = 0;

  /**
   * The feature id for the '<em><b>Constraint Body 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT___CONSTRAINT_BODY_1 = 1;

  /**
   * The number of structural features of the '<em>Constraint </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_constraint_1_Impl <em>Anonymous constraint 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_constraint_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_constraint_1_()
   * @generated
   */
  int ANONYMOUS_CONSTRAINT_1 = 156;

  /**
   * The feature id for the '<em><b>Constraint Body 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTRAINT_1__CONSTRAINT_BODY_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous constraint 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTRAINT_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.NegativeConstraint_Impl <em>Negative Constraint </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.NegativeConstraint_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getNegativeConstraint_()
   * @generated
   */
  int NEGATIVE_CONSTRAINT_ = 157;

  /**
   * The feature id for the '<em><b>Constraint 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATIVE_CONSTRAINT___CONSTRAINT_1 = 0;

  /**
   * The number of structural features of the '<em>Negative Constraint </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEGATIVE_CONSTRAINT__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ConstraintBody_Impl <em>Constraint Body </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ConstraintBody_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getConstraintBody_()
   * @generated
   */
  int CONSTRAINT_BODY_ = 158;

  /**
   * The feature id for the '<em><b>Constraint Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_BODY___CONSTRAINT_EXPR_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous constraint Body 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_BODY___ANONYMOUS_CONSTRAINT_BODY_11 = 1;

  /**
   * The number of structural features of the '<em>Constraint Body </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_BODY__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_constraintBody_1_Impl <em>Anonymous constraint Body 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_constraintBody_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_constraintBody_1_()
   * @generated
   */
  int ANONYMOUS_CONSTRAINT_BODY_1 = 159;

  /**
   * The feature id for the '<em><b>Linking Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTRAINT_BODY_1__LINKING_OP_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous constraint Body 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTRAINT_BODY_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.LinkingOp_Impl <em>Linking Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.LinkingOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getLinkingOp_()
   * @generated
   */
  int LINKING_OP_ = 160;

  /**
   * The feature id for the '<em><b>Anonymous linking Op 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINKING_OP___ANONYMOUS_LINKING_OP_11 = 0;

  /**
   * The feature id for the '<em><b>Anonymous linking Op 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINKING_OP___ANONYMOUS_LINKING_OP_21 = 1;

  /**
   * The feature id for the '<em><b>Anonymous linking Op 31</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINKING_OP___ANONYMOUS_LINKING_OP_31 = 2;

  /**
   * The number of structural features of the '<em>Linking Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINKING_OP__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_linkingOp_1_Impl <em>Anonymous linking Op 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_linkingOp_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_linkingOp_1_()
   * @generated
   */
  int ANONYMOUS_LINKING_OP_1 = 161;

  /**
   * The feature id for the '<em><b>Constraint Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_LINKING_OP_1__CONSTRAINT_EXPR_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous linking Op 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_LINKING_OP_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_linkingOp_2_Impl <em>Anonymous linking Op 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_linkingOp_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_linkingOp_2_()
   * @generated
   */
  int ANONYMOUS_LINKING_OP_2 = 162;

  /**
   * The feature id for the '<em><b>And Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_LINKING_OP_2__AND_OP_1 = 0;

  /**
   * The feature id for the '<em><b>Constraint Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_LINKING_OP_2__CONSTRAINT_EXPR_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous linking Op 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_LINKING_OP_2_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_linkingOp_3_Impl <em>Anonymous linking Op 3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_linkingOp_3_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_linkingOp_3_()
   * @generated
   */
  int ANONYMOUS_LINKING_OP_3 = 163;

  /**
   * The feature id for the '<em><b>Or Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_LINKING_OP_3__OR_OP_1 = 0;

  /**
   * The feature id for the '<em><b>Constraint Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_LINKING_OP_3__CONSTRAINT_EXPR_1 = 1;

  /**
   * The number of structural features of the '<em>Anonymous linking Op 3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_LINKING_OP_3_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ConstraintExpr_Impl <em>Constraint Expr </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ConstraintExpr_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getConstraintExpr_()
   * @generated
   */
  int CONSTRAINT_EXPR_ = 164;

  /**
   * The feature id for the '<em><b>Negative Constraint 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_EXPR___NEGATIVE_CONSTRAINT_1 = 0;

  /**
   * The feature id for the '<em><b>String Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_EXPR___STRING_EXPR_1 = 1;

  /**
   * The feature id for the '<em><b>Bool Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_EXPR___BOOL_EXPR_1 = 2;

  /**
   * The feature id for the '<em><b>Gen Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_EXPR___GEN_EXPR_1 = 3;

  /**
   * The feature id for the '<em><b>Num Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_EXPR___NUM_EXPR_1 = 4;

  /**
   * The feature id for the '<em><b>Lone Boolean 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_EXPR___LONE_BOOLEAN_1 = 5;

  /**
   * The feature id for the '<em><b>Anonymous constraint Expr 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_EXPR___ANONYMOUS_CONSTRAINT_EXPR_11 = 6;

  /**
   * The number of structural features of the '<em>Constraint Expr </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_EXPR__FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_constraintExpr_1_Impl <em>Anonymous constraint Expr 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_constraintExpr_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_constraintExpr_1_()
   * @generated
   */
  int ANONYMOUS_CONSTRAINT_EXPR_1 = 165;

  /**
   * The feature id for the '<em><b>Index 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTRAINT_EXPR_1__INDEX_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous constraint Expr 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_CONSTRAINT_EXPR_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CompoundExpr_Impl <em>Compound Expr </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CompoundExpr_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCompoundExpr_()
   * @generated
   */
  int COMPOUND_EXPR_ = 166;

  /**
   * The feature id for the '<em><b>String Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_EXPR___STRING_EXPR_1 = 0;

  /**
   * The feature id for the '<em><b>Bool Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_EXPR___BOOL_EXPR_1 = 1;

  /**
   * The feature id for the '<em><b>Num Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_EXPR___NUM_EXPR_1 = 2;

  /**
   * The feature id for the '<em><b>Gen Expr 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_EXPR___GEN_EXPR_1 = 3;

  /**
   * The number of structural features of the '<em>Compound Expr </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_EXPR__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.BoolExpr_Impl <em>Bool Expr </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.BoolExpr_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getBoolExpr_()
   * @generated
   */
  int BOOL_EXPR_ = 167;

  /**
   * The feature id for the '<em><b>Literal 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR___LITERAL_1 = 0;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR___NAME_1 = 1;

  /**
   * The feature id for the '<em><b>Equality Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR___EQUALITY_OP_1 = 2;

  /**
   * The feature id for the '<em><b>Index 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR___INDEX_1 = 3;

  /**
   * The number of structural features of the '<em>Bool Expr </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StringExpr_Impl <em>String Expr </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StringExpr_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStringExpr_()
   * @generated
   */
  int STRING_EXPR_ = 168;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Equality Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR___EQUALITY_OP_1 = 1;

  /**
   * The feature id for the '<em><b>String Lit 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR___STRING_LIT_1 = 2;

  /**
   * The feature id for the '<em><b>Index 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR___INDEX_1 = 3;

  /**
   * The number of structural features of the '<em>String Expr </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StringLit_Impl <em>String Lit </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StringLit_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStringLit_()
   * @generated
   */
  int STRING_LIT_ = 169;

  /**
   * The feature id for the '<em><b>Quote 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LIT___QUOTE_1 = 0;

  /**
   * The number of structural features of the '<em>String Lit </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LIT__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.GenExpr_Impl <em>Gen Expr </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.GenExpr_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGenExpr_()
   * @generated
   */
  int GEN_EXPR_ = 170;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_EXPR___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous gen Expr 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_EXPR___ANONYMOUS_GEN_EXPR_11 = 1;

  /**
   * The feature id for the '<em><b>Equality Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_EXPR___EQUALITY_OP_1 = 2;

  /**
   * The feature id for the '<em><b>Name 2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_EXPR___NAME_2 = 3;

  /**
   * The feature id for the '<em><b>Anonymous gen Expr 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_EXPR___ANONYMOUS_GEN_EXPR_21 = 4;

  /**
   * The number of structural features of the '<em>Gen Expr </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GEN_EXPR__FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_genExpr_1_Impl <em>Anonymous gen Expr 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_genExpr_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_genExpr_1_()
   * @generated
   */
  int ANONYMOUS_GEN_EXPR_1 = 171;

  /**
   * The feature id for the '<em><b>Index 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GEN_EXPR_1__INDEX_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous gen Expr 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GEN_EXPR_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_genExpr_2_Impl <em>Anonymous gen Expr 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_genExpr_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_genExpr_2_()
   * @generated
   */
  int ANONYMOUS_GEN_EXPR_2 = 172;

  /**
   * The feature id for the '<em><b>Index 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GEN_EXPR_2__INDEX_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous gen Expr 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_GEN_EXPR_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.NumExpr_Impl <em>Num Expr </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.NumExpr_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getNumExpr_()
   * @generated
   */
  int NUM_EXPR_ = 173;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_EXPR___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Anonymous num Expr 11</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_EXPR___ANONYMOUS_NUM_EXPR_11 = 1;

  /**
   * The feature id for the '<em><b>Anonymous num Expr 21</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_EXPR___ANONYMOUS_NUM_EXPR_21 = 2;

  /**
   * The feature id for the '<em><b>Ordinal Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_EXPR___ORDINAL_OP_1 = 3;

  /**
   * The feature id for the '<em><b>Name 2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_EXPR___NAME_2 = 4;

  /**
   * The feature id for the '<em><b>Anonymous num Expr 31</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_EXPR___ANONYMOUS_NUM_EXPR_31 = 5;

  /**
   * The feature id for the '<em><b>Anonymous num Expr 41</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_EXPR___ANONYMOUS_NUM_EXPR_41 = 6;

  /**
   * The number of structural features of the '<em>Num Expr </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUM_EXPR__FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_numExpr_1_Impl <em>Anonymous num Expr 1</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_numExpr_1_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_numExpr_1_()
   * @generated
   */
  int ANONYMOUS_NUM_EXPR_1 = 174;

  /**
   * The feature id for the '<em><b>Tail 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_NUM_EXPR_1__TAIL_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous num Expr 1</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_NUM_EXPR_1_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_numExpr_2_Impl <em>Anonymous num Expr 2</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_numExpr_2_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_numExpr_2_()
   * @generated
   */
  int ANONYMOUS_NUM_EXPR_2 = 175;

  /**
   * The feature id for the '<em><b>Index 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_NUM_EXPR_2__INDEX_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous num Expr 2</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_NUM_EXPR_2_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_numExpr_3_Impl <em>Anonymous num Expr 3</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_numExpr_3_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_numExpr_3_()
   * @generated
   */
  int ANONYMOUS_NUM_EXPR_3 = 176;

  /**
   * The feature id for the '<em><b>Tail 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_NUM_EXPR_3__TAIL_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous num Expr 3</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_NUM_EXPR_3_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Anonymous_numExpr_4_Impl <em>Anonymous num Expr 4</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Anonymous_numExpr_4_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAnonymous_numExpr_4_()
   * @generated
   */
  int ANONYMOUS_NUM_EXPR_4 = 177;

  /**
   * The feature id for the '<em><b>Index 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_NUM_EXPR_4__INDEX_1 = 0;

  /**
   * The number of structural features of the '<em>Anonymous num Expr 4</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANONYMOUS_NUM_EXPR_4_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.EqualityOp_Impl <em>Equality Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.EqualityOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEqualityOp_()
   * @generated
   */
  int EQUALITY_OP_ = 178;

  /**
   * The feature id for the '<em><b>Equals Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_OP___EQUALS_OP_1 = 0;

  /**
   * The feature id for the '<em><b>Notequals Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_OP___NOTEQUALS_OP_1 = 1;

  /**
   * The number of structural features of the '<em>Equality Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_OP__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.EqualsOp_Impl <em>Equals Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.EqualsOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEqualsOp_()
   * @generated
   */
  int EQUALS_OP_ = 179;

  /**
   * The feature id for the '<em><b>Equals Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALS_OP___EQUALS_OP_1 = 0;

  /**
   * The number of structural features of the '<em>Equals Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALS_OP__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.NotequalsOp_Impl <em>Notequals Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.NotequalsOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getNotequalsOp_()
   * @generated
   */
  int NOTEQUALS_OP_ = 180;

  /**
   * The feature id for the '<em><b>Notequals Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTEQUALS_OP___NOTEQUALS_OP_1 = 0;

  /**
   * The number of structural features of the '<em>Notequals Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOTEQUALS_OP__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.OrdinalOp_Impl <em>Ordinal Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.OrdinalOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getOrdinalOp_()
   * @generated
   */
  int ORDINAL_OP_ = 181;

  /**
   * The feature id for the '<em><b>Greater Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORDINAL_OP___GREATER_OP_1 = 0;

  /**
   * The feature id for the '<em><b>Less Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORDINAL_OP___LESS_OP_1 = 1;

  /**
   * The feature id for the '<em><b>More Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORDINAL_OP___MORE_OP_1 = 2;

  /**
   * The feature id for the '<em><b>Smaller Op 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORDINAL_OP___SMALLER_OP_1 = 3;

  /**
   * The number of structural features of the '<em>Ordinal Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ORDINAL_OP__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.GreaterOp_Impl <em>Greater Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.GreaterOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGreaterOp_()
   * @generated
   */
  int GREATER_OP_ = 182;

  /**
   * The feature id for the '<em><b>Greater Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_OP___GREATER_OP_1 = 0;

  /**
   * The number of structural features of the '<em>Greater Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_OP__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.LessOp_Impl <em>Less Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.LessOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getLessOp_()
   * @generated
   */
  int LESS_OP_ = 183;

  /**
   * The feature id for the '<em><b>Less Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_OP___LESS_OP_1 = 0;

  /**
   * The number of structural features of the '<em>Less Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_OP__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.MoreOp_Impl <em>More Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.MoreOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getMoreOp_()
   * @generated
   */
  int MORE_OP_ = 184;

  /**
   * The feature id for the '<em><b>More Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORE_OP___MORE_OP_1 = 0;

  /**
   * The number of structural features of the '<em>More Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MORE_OP__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SmallerOp_Impl <em>Smaller Op </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SmallerOp_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSmallerOp_()
   * @generated
   */
  int SMALLER_OP_ = 185;

  /**
   * The feature id for the '<em><b>Smaller Op 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SMALLER_OP___SMALLER_OP_1 = 0;

  /**
   * The number of structural features of the '<em>Smaller Op </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SMALLER_OP__FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Position_Impl <em>Position </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Position_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getPosition_()
   * @generated
   */
  int POSITION_ = 186;

  /**
   * The feature id for the '<em><b>Association Position 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION___ASSOCIATION_POSITION_1 = 0;

  /**
   * The feature id for the '<em><b>Element Position 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION___ELEMENT_POSITION_1 = 1;

  /**
   * The number of structural features of the '<em>Position </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ElementPosition_Impl <em>Element Position </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ElementPosition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getElementPosition_()
   * @generated
   */
  int ELEMENT_POSITION_ = 187;

  /**
   * The feature id for the '<em><b>X1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION___X1 = 0;

  /**
   * The feature id for the '<em><b>Y1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION___Y1 = 1;

  /**
   * The feature id for the '<em><b>Width 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION___WIDTH_1 = 2;

  /**
   * The feature id for the '<em><b>Height 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION___HEIGHT_1 = 3;

  /**
   * The number of structural features of the '<em>Element Position </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION__FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationPosition_Impl <em>Association Position </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationPosition_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationPosition_()
   * @generated
   */
  int ASSOCIATION_POSITION_ = 188;

  /**
   * The feature id for the '<em><b>Name 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION___NAME_1 = 0;

  /**
   * The feature id for the '<em><b>Coordinate 1</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION___COORDINATE_1 = 1;

  /**
   * The feature id for the '<em><b>Coordinate 2</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION___COORDINATE_2 = 2;

  /**
   * The number of structural features of the '<em>Association Position </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION__FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.Coordinate_Impl <em>Coordinate </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.Coordinate_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCoordinate_()
   * @generated
   */
  int COORDINATE_ = 189;

  /**
   * The feature id for the '<em><b>X1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATE___X1 = 0;

  /**
   * The feature id for the '<em><b>Y1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATE___Y1 = 1;

  /**
   * The number of structural features of the '<em>Coordinate </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATE__FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.DisplayColor_Impl <em>Display Color </em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.DisplayColor_Impl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getDisplayColor_()
   * @generated
   */
  int DISPLAY_COLOR_ = 190;

  /**
   * The feature id for the '<em><b>Anonymous display Color 11</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPLAY_COLOR___ANONYMOUS_DISPLAY_COLOR_11 = 0;

  /**
   * The feature id for the '<em><b>Color Value 1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPLAY_COLOR___COLOR_VALUE_1 = 1;

  /**
   * The number of structural features of the '<em>Display Color </em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISPLAY_COLOR__FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see cruise.umple.umple.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.Model#getModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model</em>'.
   * @see cruise.umple.umple.Model#getModel()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Model();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Program_ <em>Program </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program </em>'.
   * @see cruise.umple.umple.Program_
   * @generated
   */
  EClass getProgram_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Program_#getAnonymous_program_1_1 <em>Anonymous program 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous program 11</em>'.
   * @see cruise.umple.umple.Program_#getAnonymous_program_1_1()
   * @see #getProgram_()
   * @generated
   */
  EReference getProgram__Anonymous_program_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_program_1_ <em>Anonymous program 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous program 1</em>'.
   * @see cruise.umple.umple.Anonymous_program_1_
   * @generated
   */
  EClass getAnonymous_program_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_program_1_#getComment_1 <em>Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comment 1</em>'.
   * @see cruise.umple.umple.Anonymous_program_1_#getComment_1()
   * @see #getAnonymous_program_1_()
   * @generated
   */
  EReference getAnonymous_program_1__Comment_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_program_1_#getDirective_1 <em>Directive 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Directive 1</em>'.
   * @see cruise.umple.umple.Anonymous_program_1_#getDirective_1()
   * @see #getAnonymous_program_1_()
   * @generated
   */
  EReference getAnonymous_program_1__Directive_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Directive_ <em>Directive </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Directive </em>'.
   * @see cruise.umple.umple.Directive_
   * @generated
   */
  EClass getDirective_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getGlossary_1 <em>Glossary 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Glossary 1</em>'.
   * @see cruise.umple.umple.Directive_#getGlossary_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__Glossary_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getGenerate_1 <em>Generate 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generate 1</em>'.
   * @see cruise.umple.umple.Directive_#getGenerate_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__Generate_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getGenerate_path_1 <em>Generate path 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Generate path 1</em>'.
   * @see cruise.umple.umple.Directive_#getGenerate_path_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__Generate_path_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getUseStatement_1 <em>Use Statement 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Use Statement 1</em>'.
   * @see cruise.umple.umple.Directive_#getUseStatement_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__UseStatement_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getNamespace_1 <em>Namespace 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Namespace 1</em>'.
   * @see cruise.umple.umple.Directive_#getNamespace_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__Namespace_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getTraceType_1 <em>Trace Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Type 1</em>'.
   * @see cruise.umple.umple.Directive_#getTraceType_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__TraceType_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getEntity_1 <em>Entity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entity 1</em>'.
   * @see cruise.umple.umple.Directive_#getEntity_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__Entity_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getDebug_1 <em>Debug 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Debug 1</em>'.
   * @see cruise.umple.umple.Directive_#getDebug_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__Debug_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Directive_#getStrictness_1 <em>Strictness 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Strictness 1</em>'.
   * @see cruise.umple.umple.Directive_#getStrictness_1()
   * @see #getDirective_()
   * @generated
   */
  EReference getDirective__Strictness_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Glossary_ <em>Glossary </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Glossary </em>'.
   * @see cruise.umple.umple.Glossary_
   * @generated
   */
  EClass getGlossary_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Glossary_#getWord_1 <em>Word 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Word 1</em>'.
   * @see cruise.umple.umple.Glossary_#getWord_1()
   * @see #getGlossary_()
   * @generated
   */
  EReference getGlossary__Word_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Word_ <em>Word </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Word </em>'.
   * @see cruise.umple.umple.Word_
   * @generated
   */
  EClass getWord_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Word_#getSingular_1 <em>Singular 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Singular 1</em>'.
   * @see cruise.umple.umple.Word_#getSingular_1()
   * @see #getWord_()
   * @generated
   */
  EAttribute getWord__Singular_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Word_#getPlural_1 <em>Plural 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plural 1</em>'.
   * @see cruise.umple.umple.Word_#getPlural_1()
   * @see #getWord_()
   * @generated
   */
  EAttribute getWord__Plural_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Strictness_ <em>Strictness </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Strictness </em>'.
   * @see cruise.umple.umple.Strictness_
   * @generated
   */
  EClass getStrictness_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Strictness_#getAnonymous_strictness_1_1 <em>Anonymous strictness 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous strictness 11</em>'.
   * @see cruise.umple.umple.Strictness_#getAnonymous_strictness_1_1()
   * @see #getStrictness_()
   * @generated
   */
  EReference getStrictness__Anonymous_strictness_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_strictness_1_ <em>Anonymous strictness 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous strictness 1</em>'.
   * @see cruise.umple.umple.Anonymous_strictness_1_
   * @generated
   */
  EClass getAnonymous_strictness_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_strictness_1_#getStrictnessLevel_1 <em>Strictness Level 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Strictness Level 1</em>'.
   * @see cruise.umple.umple.Anonymous_strictness_1_#getStrictnessLevel_1()
   * @see #getAnonymous_strictness_1_()
   * @generated
   */
  EAttribute getAnonymous_strictness_1__StrictnessLevel_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_strictness_1_#getMessage_1 <em>Message 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message 1</em>'.
   * @see cruise.umple.umple.Anonymous_strictness_1_#getMessage_1()
   * @see #getAnonymous_strictness_1_()
   * @generated
   */
  EAttribute getAnonymous_strictness_1__Message_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_strictness_1_#getMessageNumber_1 <em>Message Number 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message Number 1</em>'.
   * @see cruise.umple.umple.Anonymous_strictness_1_#getMessageNumber_1()
   * @see #getAnonymous_strictness_1_()
   * @generated
   */
  EAttribute getAnonymous_strictness_1__MessageNumber_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Generate_ <em>Generate </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generate </em>'.
   * @see cruise.umple.umple.Generate_
   * @generated
   */
  EClass getGenerate_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Generate_#getGenerate_1 <em>Generate 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Generate 1</em>'.
   * @see cruise.umple.umple.Generate_#getGenerate_1()
   * @see #getGenerate_()
   * @generated
   */
  EAttribute getGenerate__Generate_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Generate_path_ <em>Generate path </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generate path </em>'.
   * @see cruise.umple.umple.Generate_path_
   * @generated
   */
  EClass getGenerate_path_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Generate_path_#getLanguage_1 <em>Language 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Language 1</em>'.
   * @see cruise.umple.umple.Generate_path_#getLanguage_1()
   * @see #getGenerate_path_()
   * @generated
   */
  EAttribute getGenerate_path__Language_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Generate_path_#getOutput_1 <em>Output 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Output 1</em>'.
   * @see cruise.umple.umple.Generate_path_#getOutput_1()
   * @see #getGenerate_path_()
   * @generated
   */
  EAttribute getGenerate_path__Output_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Generate_path_#getOverride_1 <em>Override 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Override 1</em>'.
   * @see cruise.umple.umple.Generate_path_#getOverride_1()
   * @see #getGenerate_path_()
   * @generated
   */
  EAttribute getGenerate_path__Override_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.UseStatement_ <em>Use Statement </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Use Statement </em>'.
   * @see cruise.umple.umple.UseStatement_
   * @generated
   */
  EClass getUseStatement_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UseStatement_#getUse_1 <em>Use 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Use 1</em>'.
   * @see cruise.umple.umple.UseStatement_#getUse_1()
   * @see #getUseStatement_()
   * @generated
   */
  EAttribute getUseStatement__Use_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Namespace_ <em>Namespace </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Namespace </em>'.
   * @see cruise.umple.umple.Namespace_
   * @generated
   */
  EClass getNamespace_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Namespace_#getNamespace_1 <em>Namespace 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Namespace 1</em>'.
   * @see cruise.umple.umple.Namespace_#getNamespace_1()
   * @see #getNamespace_()
   * @generated
   */
  EAttribute getNamespace__Namespace_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Entity_ <em>Entity </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity </em>'.
   * @see cruise.umple.umple.Entity_
   * @generated
   */
  EClass getEntity_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Entity_#getClassDefinition_1 <em>Class Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Class Definition 1</em>'.
   * @see cruise.umple.umple.Entity_#getClassDefinition_1()
   * @see #getEntity_()
   * @generated
   */
  EReference getEntity__ClassDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Entity_#getInterfaceDefinition_1 <em>Interface Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface Definition 1</em>'.
   * @see cruise.umple.umple.Entity_#getInterfaceDefinition_1()
   * @see #getEntity_()
   * @generated
   */
  EReference getEntity__InterfaceDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Entity_#getExternalDefinition_1 <em>External Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>External Definition 1</em>'.
   * @see cruise.umple.umple.Entity_#getExternalDefinition_1()
   * @see #getEntity_()
   * @generated
   */
  EReference getEntity__ExternalDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Entity_#getAssociationDefinition_1 <em>Association Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Definition 1</em>'.
   * @see cruise.umple.umple.Entity_#getAssociationDefinition_1()
   * @see #getEntity_()
   * @generated
   */
  EReference getEntity__AssociationDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Entity_#getAssociationClassDefinition_1 <em>Association Class Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Class Definition 1</em>'.
   * @see cruise.umple.umple.Entity_#getAssociationClassDefinition_1()
   * @see #getEntity_()
   * @generated
   */
  EReference getEntity__AssociationClassDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Entity_#getStateMachineDefinition_1 <em>State Machine Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Machine Definition 1</em>'.
   * @see cruise.umple.umple.Entity_#getStateMachineDefinition_1()
   * @see #getEntity_()
   * @generated
   */
  EReference getEntity__StateMachineDefinition_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Comment_ <em>Comment </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Comment </em>'.
   * @see cruise.umple.umple.Comment_
   * @generated
   */
  EClass getComment_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Comment_#getInlineComment_1 <em>Inline Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inline Comment 1</em>'.
   * @see cruise.umple.umple.Comment_#getInlineComment_1()
   * @see #getComment_()
   * @generated
   */
  EReference getComment__InlineComment_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Comment_#getMultilineComment_1 <em>Multiline Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multiline Comment 1</em>'.
   * @see cruise.umple.umple.Comment_#getMultilineComment_1()
   * @see #getComment_()
   * @generated
   */
  EReference getComment__MultilineComment_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InlineComment_ <em>Inline Comment </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inline Comment </em>'.
   * @see cruise.umple.umple.InlineComment_
   * @generated
   */
  EClass getInlineComment_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineComment_#getInlineComment_1 <em>Inline Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Inline Comment 1</em>'.
   * @see cruise.umple.umple.InlineComment_#getInlineComment_1()
   * @see #getInlineComment_()
   * @generated
   */
  EAttribute getInlineComment__InlineComment_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.MultilineComment_ <em>Multiline Comment </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiline Comment </em>'.
   * @see cruise.umple.umple.MultilineComment_
   * @generated
   */
  EClass getMultilineComment_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.MultilineComment_#getMultilineComment_1 <em>Multiline Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Multiline Comment 1</em>'.
   * @see cruise.umple.umple.MultilineComment_#getMultilineComment_1()
   * @see #getMultilineComment_()
   * @generated
   */
  EAttribute getMultilineComment__MultilineComment_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Debug_ <em>Debug </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Debug </em>'.
   * @see cruise.umple.umple.Debug_
   * @generated
   */
  EClass getDebug_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Debug_#isDebug_1 <em>Debug 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Debug 1</em>'.
   * @see cruise.umple.umple.Debug_#isDebug_1()
   * @see #getDebug_()
   * @generated
   */
  EAttribute getDebug__Debug_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Abstract_ <em>Abstract </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract </em>'.
   * @see cruise.umple.umple.Abstract_
   * @generated
   */
  EClass getAbstract_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Abstract_#isAbstract_1 <em>Abstract 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract 1</em>'.
   * @see cruise.umple.umple.Abstract_#isAbstract_1()
   * @see #getAbstract_()
   * @generated
   */
  EAttribute getAbstract__Abstract_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ClassDefinition_ <em>Class Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Definition </em>'.
   * @see cruise.umple.umple.ClassDefinition_
   * @generated
   */
  EClass getClassDefinition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ClassDefinition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.ClassDefinition_#getName_1()
   * @see #getClassDefinition_()
   * @generated
   */
  EAttribute getClassDefinition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassDefinition_#getClassContent_1 <em>Class Content 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Class Content 1</em>'.
   * @see cruise.umple.umple.ClassDefinition_#getClassContent_1()
   * @see #getClassDefinition_()
   * @generated
   */
  EReference getClassDefinition__ClassContent_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ExternalDefinition_ <em>External Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Definition </em>'.
   * @see cruise.umple.umple.ExternalDefinition_
   * @generated
   */
  EClass getExternalDefinition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ExternalDefinition_#isInterface_1 <em>Interface 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface 1</em>'.
   * @see cruise.umple.umple.ExternalDefinition_#isInterface_1()
   * @see #getExternalDefinition_()
   * @generated
   */
  EAttribute getExternalDefinition__Interface_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ExternalDefinition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.ExternalDefinition_#getName_1()
   * @see #getExternalDefinition_()
   * @generated
   */
  EAttribute getExternalDefinition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ExternalDefinition_#getClassContent_1 <em>Class Content 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Class Content 1</em>'.
   * @see cruise.umple.umple.ExternalDefinition_#getClassContent_1()
   * @see #getExternalDefinition_()
   * @generated
   */
  EReference getExternalDefinition__ClassContent_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InterfaceDefinition_ <em>Interface Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Definition </em>'.
   * @see cruise.umple.umple.InterfaceDefinition_
   * @generated
   */
  EClass getInterfaceDefinition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InterfaceDefinition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.InterfaceDefinition_#getName_1()
   * @see #getInterfaceDefinition_()
   * @generated
   */
  EAttribute getInterfaceDefinition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceDefinition_#getDepend_1 <em>Depend 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Depend 1</em>'.
   * @see cruise.umple.umple.InterfaceDefinition_#getDepend_1()
   * @see #getInterfaceDefinition_()
   * @generated
   */
  EReference getInterfaceDefinition__Depend_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceDefinition_#getInterfaceBody_1 <em>Interface Body 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface Body 1</em>'.
   * @see cruise.umple.umple.InterfaceDefinition_#getInterfaceBody_1()
   * @see #getInterfaceDefinition_()
   * @generated
   */
  EReference getInterfaceDefinition__InterfaceBody_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationDefinition_ <em>Association Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Definition </em>'.
   * @see cruise.umple.umple.AssociationDefinition_
   * @generated
   */
  EClass getAssociationDefinition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AssociationDefinition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.AssociationDefinition_#getName_1()
   * @see #getAssociationDefinition_()
   * @generated
   */
  EAttribute getAssociationDefinition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationDefinition_#getAssociation_1 <em>Association 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association 1</em>'.
   * @see cruise.umple.umple.AssociationDefinition_#getAssociation_1()
   * @see #getAssociationDefinition_()
   * @generated
   */
  EReference getAssociationDefinition__Association_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationClassDefinition_ <em>Association Class Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Class Definition </em>'.
   * @see cruise.umple.umple.AssociationClassDefinition_
   * @generated
   */
  EClass getAssociationClassDefinition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AssociationClassDefinition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.AssociationClassDefinition_#getName_1()
   * @see #getAssociationClassDefinition_()
   * @generated
   */
  EAttribute getAssociationClassDefinition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassDefinition_#getAssociationClassContent_1 <em>Association Class Content 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Class Content 1</em>'.
   * @see cruise.umple.umple.AssociationClassDefinition_#getAssociationClassContent_1()
   * @see #getAssociationClassDefinition_()
   * @generated
   */
  EReference getAssociationClassDefinition__AssociationClassContent_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ClassContent_ <em>Class Content </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Content </em>'.
   * @see cruise.umple.umple.ClassContent_
   * @generated
   */
  EClass getClassContent_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getComment_1 <em>Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comment 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getComment_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__Comment_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getClassDefinition_1 <em>Class Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Class Definition 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getClassDefinition_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__ClassDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getTrace_1 <em>Trace 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getTrace_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__Trace_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getPosition_1 <em>Position 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Position 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getPosition_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__Position_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getDisplayColor_1 <em>Display Color 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Display Color 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getDisplayColor_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__DisplayColor_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getAbstract_1 <em>Abstract 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Abstract 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getAbstract_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__Abstract_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getInvariant_1 <em>Invariant 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invariant 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getInvariant_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__Invariant_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getSoftwarePattern_1 <em>Software Pattern 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Software Pattern 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getSoftwarePattern_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__SoftwarePattern_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getDepend_1 <em>Depend 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Depend 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getDepend_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__Depend_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getSymmetricReflexiveAssociation_1 <em>Symmetric Reflexive Association 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Symmetric Reflexive Association 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getSymmetricReflexiveAssociation_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__SymmetricReflexiveAssociation_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getAttribute_1 <em>Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getAttribute_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__Attribute_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getStateMachine_1 <em>State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Machine 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getStateMachine_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__StateMachine_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getInlineAssociation_1 <em>Inline Association 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inline Association 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getInlineAssociation_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__InlineAssociation_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getConcreteMethodDeclaration_1 <em>Concrete Method Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Concrete Method Declaration 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getConcreteMethodDeclaration_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__ConcreteMethodDeclaration_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getConstantDeclaration_1 <em>Constant Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constant Declaration 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getConstantDeclaration_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__ConstantDeclaration_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassContent_#getExtraCode_1 <em>Extra Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extra Code 1</em>'.
   * @see cruise.umple.umple.ClassContent_#getExtraCode_1()
   * @see #getClassContent_()
   * @generated
   */
  EReference getClassContent__ExtraCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationClassContent_ <em>Association Class Content </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Class Content </em>'.
   * @see cruise.umple.umple.AssociationClassContent_
   * @generated
   */
  EClass getAssociationClassContent_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getComment_1 <em>Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comment 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getComment_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__Comment_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getClassDefinition_1 <em>Class Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Class Definition 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getClassDefinition_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__ClassDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getPosition_1 <em>Position 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Position 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getPosition_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__Position_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getDisplayColor_1 <em>Display Color 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Display Color 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getDisplayColor_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__DisplayColor_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getInvariant_1 <em>Invariant 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invariant 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getInvariant_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__Invariant_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getSoftwarePattern_1 <em>Software Pattern 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Software Pattern 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getSoftwarePattern_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__SoftwarePattern_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getDepend_1 <em>Depend 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Depend 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getDepend_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__Depend_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getSingleAssociationEnd_1 <em>Single Association End 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Single Association End 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getSingleAssociationEnd_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__SingleAssociationEnd_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getStateMachine_1 <em>State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Machine 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getStateMachine_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__StateMachine_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getAttribute_1 <em>Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attribute 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getAttribute_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__Attribute_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getAssociation_1 <em>Association 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getAssociation_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__Association_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getInlineAssociation_1 <em>Inline Association 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inline Association 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getInlineAssociation_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__InlineAssociation_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassContent_#getExtraCode_1 <em>Extra Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extra Code 1</em>'.
   * @see cruise.umple.umple.AssociationClassContent_#getExtraCode_1()
   * @see #getAssociationClassContent_()
   * @generated
   */
  EReference getAssociationClassContent__ExtraCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InterfaceBody_ <em>Interface Body </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Body </em>'.
   * @see cruise.umple.umple.InterfaceBody_
   * @generated
   */
  EClass getInterfaceBody_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceBody_#getInterfaceMemberDeclaration_1 <em>Interface Member Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Interface Member Declaration 1</em>'.
   * @see cruise.umple.umple.InterfaceBody_#getInterfaceMemberDeclaration_1()
   * @see #getInterfaceBody_()
   * @generated
   */
  EReference getInterfaceBody__InterfaceMemberDeclaration_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InterfaceMemberDeclaration_ <em>Interface Member Declaration </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Member Declaration </em>'.
   * @see cruise.umple.umple.InterfaceMemberDeclaration_
   * @generated
   */
  EClass getInterfaceMemberDeclaration_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceMemberDeclaration_#getConstantDeclaration_1 <em>Constant Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constant Declaration 1</em>'.
   * @see cruise.umple.umple.InterfaceMemberDeclaration_#getConstantDeclaration_1()
   * @see #getInterfaceMemberDeclaration_()
   * @generated
   */
  EReference getInterfaceMemberDeclaration__ConstantDeclaration_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceMemberDeclaration_#getAbstractMethodDeclaration_1 <em>Abstract Method Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Abstract Method Declaration 1</em>'.
   * @see cruise.umple.umple.InterfaceMemberDeclaration_#getAbstractMethodDeclaration_1()
   * @see #getInterfaceMemberDeclaration_()
   * @generated
   */
  EReference getInterfaceMemberDeclaration__AbstractMethodDeclaration_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceMemberDeclaration_#getPosition_1 <em>Position 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Position 1</em>'.
   * @see cruise.umple.umple.InterfaceMemberDeclaration_#getPosition_1()
   * @see #getInterfaceMemberDeclaration_()
   * @generated
   */
  EReference getInterfaceMemberDeclaration__Position_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceMemberDeclaration_#getDisplayColor_1 <em>Display Color 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Display Color 1</em>'.
   * @see cruise.umple.umple.InterfaceMemberDeclaration_#getDisplayColor_1()
   * @see #getInterfaceMemberDeclaration_()
   * @generated
   */
  EReference getInterfaceMemberDeclaration__DisplayColor_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceMemberDeclaration_#getIsA_1 <em>Is A1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Is A1</em>'.
   * @see cruise.umple.umple.InterfaceMemberDeclaration_#getIsA_1()
   * @see #getInterfaceMemberDeclaration_()
   * @generated
   */
  EReference getInterfaceMemberDeclaration__IsA_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceMemberDeclaration_#getExtraCode_1 <em>Extra Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extra Code 1</em>'.
   * @see cruise.umple.umple.InterfaceMemberDeclaration_#getExtraCode_1()
   * @see #getInterfaceMemberDeclaration_()
   * @generated
   */
  EReference getInterfaceMemberDeclaration__ExtraCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ConstantDeclaration_ <em>Constant Declaration </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Declaration </em>'.
   * @see cruise.umple.umple.ConstantDeclaration_
   * @generated
   */
  EClass getConstantDeclaration_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstantDeclaration_#getAnonymous_constantDeclaration_1_1 <em>Anonymous constant Declaration 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous constant Declaration 11</em>'.
   * @see cruise.umple.umple.ConstantDeclaration_#getAnonymous_constantDeclaration_1_1()
   * @see #getConstantDeclaration_()
   * @generated
   */
  EReference getConstantDeclaration__Anonymous_constantDeclaration_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstantDeclaration_#getAnonymous_constantDeclaration_2_1 <em>Anonymous constant Declaration 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous constant Declaration 21</em>'.
   * @see cruise.umple.umple.ConstantDeclaration_#getAnonymous_constantDeclaration_2_1()
   * @see #getConstantDeclaration_()
   * @generated
   */
  EReference getConstantDeclaration__Anonymous_constantDeclaration_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_constantDeclaration_1_ <em>Anonymous constant Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous constant Declaration 1</em>'.
   * @see cruise.umple.umple.Anonymous_constantDeclaration_1_
   * @generated
   */
  EClass getAnonymous_constantDeclaration_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_constantDeclaration_1_#isList_1 <em>List 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>List 1</em>'.
   * @see cruise.umple.umple.Anonymous_constantDeclaration_1_#isList_1()
   * @see #getAnonymous_constantDeclaration_1_()
   * @generated
   */
  EAttribute getAnonymous_constantDeclaration_1__List_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_constantDeclaration_1_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.Anonymous_constantDeclaration_1_#getName_1()
   * @see #getAnonymous_constantDeclaration_1_()
   * @generated
   */
  EAttribute getAnonymous_constantDeclaration_1__Name_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_constantDeclaration_1_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.Anonymous_constantDeclaration_1_#getType_1()
   * @see #getAnonymous_constantDeclaration_1_()
   * @generated
   */
  EAttribute getAnonymous_constantDeclaration_1__Type_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_constantDeclaration_2_ <em>Anonymous constant Declaration 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous constant Declaration 2</em>'.
   * @see cruise.umple.umple.Anonymous_constantDeclaration_2_
   * @generated
   */
  EClass getAnonymous_constantDeclaration_2_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_constantDeclaration_2_#getValue_1 <em>Value 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value 1</em>'.
   * @see cruise.umple.umple.Anonymous_constantDeclaration_2_#getValue_1()
   * @see #getAnonymous_constantDeclaration_2_()
   * @generated
   */
  EAttribute getAnonymous_constantDeclaration_2__Value_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.MoreCode_ <em>More Code </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>More Code </em>'.
   * @see cruise.umple.umple.MoreCode_
   * @generated
   */
  EClass getMoreCode_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.MoreCode_#getAnonymous_moreCode_1_1 <em>Anonymous more Code 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous more Code 11</em>'.
   * @see cruise.umple.umple.MoreCode_#getAnonymous_moreCode_1_1()
   * @see #getMoreCode_()
   * @generated
   */
  EReference getMoreCode__Anonymous_moreCode_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.MoreCode_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.MoreCode_#getCode_1()
   * @see #getMoreCode_()
   * @generated
   */
  EAttribute getMoreCode__Code_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_moreCode_1_ <em>Anonymous more Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous more Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_moreCode_1_
   * @generated
   */
  EClass getAnonymous_moreCode_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_moreCode_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_moreCode_1_#getCodeLang_1()
   * @see #getAnonymous_moreCode_1_()
   * @generated
   */
  EReference getAnonymous_moreCode_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_moreCode_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_moreCode_1_#getCodeLangs_1()
   * @see #getAnonymous_moreCode_1_()
   * @generated
   */
  EReference getAnonymous_moreCode_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.CodeLangs_ <em>Code Langs </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code Langs </em>'.
   * @see cruise.umple.umple.CodeLangs_
   * @generated
   */
  EClass getCodeLangs_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.CodeLangs_#getAnonymous_codeLangs_1_1 <em>Anonymous code Langs 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous code Langs 11</em>'.
   * @see cruise.umple.umple.CodeLangs_#getAnonymous_codeLangs_1_1()
   * @see #getCodeLangs_()
   * @generated
   */
  EReference getCodeLangs__Anonymous_codeLangs_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_codeLangs_1_ <em>Anonymous code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_codeLangs_1_
   * @generated
   */
  EClass getAnonymous_codeLangs_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_codeLangs_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_codeLangs_1_#getCodeLang_1()
   * @see #getAnonymous_codeLangs_1_()
   * @generated
   */
  EReference getAnonymous_codeLangs_1__CodeLang_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.CodeLang_ <em>Code Lang </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code Lang </em>'.
   * @see cruise.umple.umple.CodeLang_
   * @generated
   */
  EClass getCodeLang_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.CodeLang_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.CodeLang_#getCodeLang_1()
   * @see #getCodeLang_()
   * @generated
   */
  EAttribute getCodeLang__CodeLang_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.MethodBody_ <em>Method Body </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Body </em>'.
   * @see cruise.umple.umple.MethodBody_
   * @generated
   */
  EClass getMethodBody_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.MethodBody_#getAnonymous_methodBody_1_1 <em>Anonymous method Body 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous method Body 11</em>'.
   * @see cruise.umple.umple.MethodBody_#getAnonymous_methodBody_1_1()
   * @see #getMethodBody_()
   * @generated
   */
  EReference getMethodBody__Anonymous_methodBody_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.MethodBody_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.MethodBody_#getCode_1()
   * @see #getMethodBody_()
   * @generated
   */
  EAttribute getMethodBody__Code_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.MethodBody_#getAnonymous_methodBody_2_1 <em>Anonymous method Body 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous method Body 21</em>'.
   * @see cruise.umple.umple.MethodBody_#getAnonymous_methodBody_2_1()
   * @see #getMethodBody_()
   * @generated
   */
  EReference getMethodBody__Anonymous_methodBody_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_methodBody_1_ <em>Anonymous method Body 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous method Body 1</em>'.
   * @see cruise.umple.umple.Anonymous_methodBody_1_
   * @generated
   */
  EClass getAnonymous_methodBody_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_methodBody_1_#getPrecondition_1 <em>Precondition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Precondition 1</em>'.
   * @see cruise.umple.umple.Anonymous_methodBody_1_#getPrecondition_1()
   * @see #getAnonymous_methodBody_1_()
   * @generated
   */
  EReference getAnonymous_methodBody_1__Precondition_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_methodBody_2_ <em>Anonymous method Body 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous method Body 2</em>'.
   * @see cruise.umple.umple.Anonymous_methodBody_2_
   * @generated
   */
  EClass getAnonymous_methodBody_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_methodBody_2_#getPostcondition_1 <em>Postcondition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Postcondition 1</em>'.
   * @see cruise.umple.umple.Anonymous_methodBody_2_#getPostcondition_1()
   * @see #getAnonymous_methodBody_2_()
   * @generated
   */
  EReference getAnonymous_methodBody_2__Postcondition_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ConcreteMethodDeclaration_ <em>Concrete Method Declaration </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Concrete Method Declaration </em>'.
   * @see cruise.umple.umple.ConcreteMethodDeclaration_
   * @generated
   */
  EClass getConcreteMethodDeclaration_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ConcreteMethodDeclaration_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.ConcreteMethodDeclaration_#getType_1()
   * @see #getConcreteMethodDeclaration_()
   * @generated
   */
  EAttribute getConcreteMethodDeclaration__Type_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConcreteMethodDeclaration_#getMethodDeclarator_1 <em>Method Declarator 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Method Declarator 1</em>'.
   * @see cruise.umple.umple.ConcreteMethodDeclaration_#getMethodDeclarator_1()
   * @see #getConcreteMethodDeclaration_()
   * @generated
   */
  EReference getConcreteMethodDeclaration__MethodDeclarator_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConcreteMethodDeclaration_#getAnonymous_concreteMethodDeclaration_1_1 <em>Anonymous concrete Method Declaration 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous concrete Method Declaration 11</em>'.
   * @see cruise.umple.umple.ConcreteMethodDeclaration_#getAnonymous_concreteMethodDeclaration_1_1()
   * @see #getConcreteMethodDeclaration_()
   * @generated
   */
  EReference getConcreteMethodDeclaration__Anonymous_concreteMethodDeclaration_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConcreteMethodDeclaration_#getMethodBody_1 <em>Method Body 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Method Body 1</em>'.
   * @see cruise.umple.umple.ConcreteMethodDeclaration_#getMethodBody_1()
   * @see #getConcreteMethodDeclaration_()
   * @generated
   */
  EReference getConcreteMethodDeclaration__MethodBody_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConcreteMethodDeclaration_#getAnonymous_concreteMethodDeclaration_2_1 <em>Anonymous concrete Method Declaration 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous concrete Method Declaration 21</em>'.
   * @see cruise.umple.umple.ConcreteMethodDeclaration_#getAnonymous_concreteMethodDeclaration_2_1()
   * @see #getConcreteMethodDeclaration_()
   * @generated
   */
  EReference getConcreteMethodDeclaration__Anonymous_concreteMethodDeclaration_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_ <em>Anonymous concrete Method Declaration 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous concrete Method Declaration 1</em>'.
   * @see cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_
   * @generated
   */
  EClass getAnonymous_concreteMethodDeclaration_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_#getCodeLang_1()
   * @see #getAnonymous_concreteMethodDeclaration_1_()
   * @generated
   */
  EReference getAnonymous_concreteMethodDeclaration_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_concreteMethodDeclaration_1_#getCodeLangs_1()
   * @see #getAnonymous_concreteMethodDeclaration_1_()
   * @generated
   */
  EReference getAnonymous_concreteMethodDeclaration_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_2_ <em>Anonymous concrete Method Declaration 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous concrete Method Declaration 2</em>'.
   * @see cruise.umple.umple.Anonymous_concreteMethodDeclaration_2_
   * @generated
   */
  EClass getAnonymous_concreteMethodDeclaration_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_concreteMethodDeclaration_2_#getMoreCode_1 <em>More Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_concreteMethodDeclaration_2_#getMoreCode_1()
   * @see #getAnonymous_concreteMethodDeclaration_2_()
   * @generated
   */
  EReference getAnonymous_concreteMethodDeclaration_2__MoreCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AbstractMethodDeclaration_ <em>Abstract Method Declaration </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Method Declaration </em>'.
   * @see cruise.umple.umple.AbstractMethodDeclaration_
   * @generated
   */
  EClass getAbstractMethodDeclaration_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AbstractMethodDeclaration_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.AbstractMethodDeclaration_#getType_1()
   * @see #getAbstractMethodDeclaration_()
   * @generated
   */
  EAttribute getAbstractMethodDeclaration__Type_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AbstractMethodDeclaration_#getMethodDeclarator_1 <em>Method Declarator 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Method Declarator 1</em>'.
   * @see cruise.umple.umple.AbstractMethodDeclaration_#getMethodDeclarator_1()
   * @see #getAbstractMethodDeclaration_()
   * @generated
   */
  EReference getAbstractMethodDeclaration__MethodDeclarator_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.MethodDeclarator_ <em>Method Declarator </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Declarator </em>'.
   * @see cruise.umple.umple.MethodDeclarator_
   * @generated
   */
  EClass getMethodDeclarator_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.MethodDeclarator_#getMethodName_1 <em>Method Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method Name 1</em>'.
   * @see cruise.umple.umple.MethodDeclarator_#getMethodName_1()
   * @see #getMethodDeclarator_()
   * @generated
   */
  EAttribute getMethodDeclarator__MethodName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.MethodDeclarator_#getParameterList_1 <em>Parameter List 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter List 1</em>'.
   * @see cruise.umple.umple.MethodDeclarator_#getParameterList_1()
   * @see #getMethodDeclarator_()
   * @generated
   */
  EReference getMethodDeclarator__ParameterList_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ParameterList_ <em>Parameter List </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter List </em>'.
   * @see cruise.umple.umple.ParameterList_
   * @generated
   */
  EClass getParameterList_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ParameterList_#getParameter_1 <em>Parameter 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter 1</em>'.
   * @see cruise.umple.umple.ParameterList_#getParameter_1()
   * @see #getParameterList_()
   * @generated
   */
  EReference getParameterList__Parameter_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ParameterList_#getAnonymous_parameterList_1_1 <em>Anonymous parameter List 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous parameter List 11</em>'.
   * @see cruise.umple.umple.ParameterList_#getAnonymous_parameterList_1_1()
   * @see #getParameterList_()
   * @generated
   */
  EReference getParameterList__Anonymous_parameterList_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_parameterList_1_ <em>Anonymous parameter List 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous parameter List 1</em>'.
   * @see cruise.umple.umple.Anonymous_parameterList_1_
   * @generated
   */
  EClass getAnonymous_parameterList_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_parameterList_1_#getParameter_1 <em>Parameter 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter 1</em>'.
   * @see cruise.umple.umple.Anonymous_parameterList_1_#getParameter_1()
   * @see #getAnonymous_parameterList_1_()
   * @generated
   */
  EReference getAnonymous_parameterList_1__Parameter_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Parameter_ <em>Parameter </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter </em>'.
   * @see cruise.umple.umple.Parameter_
   * @generated
   */
  EClass getParameter_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Parameter_#getAnonymous_parameter_1_1 <em>Anonymous parameter 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous parameter 11</em>'.
   * @see cruise.umple.umple.Parameter_#getAnonymous_parameter_1_1()
   * @see #getParameter_()
   * @generated
   */
  EReference getParameter__Anonymous_parameter_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_parameter_1_ <em>Anonymous parameter 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous parameter 1</em>'.
   * @see cruise.umple.umple.Anonymous_parameter_1_
   * @generated
   */
  EClass getAnonymous_parameter_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_parameter_1_#isList_1 <em>List 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>List 1</em>'.
   * @see cruise.umple.umple.Anonymous_parameter_1_#isList_1()
   * @see #getAnonymous_parameter_1_()
   * @generated
   */
  EAttribute getAnonymous_parameter_1__List_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_parameter_1_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.Anonymous_parameter_1_#getName_1()
   * @see #getAnonymous_parameter_1_()
   * @generated
   */
  EAttribute getAnonymous_parameter_1__Name_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_parameter_1_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.Anonymous_parameter_1_#getType_1()
   * @see #getAnonymous_parameter_1_()
   * @generated
   */
  EAttribute getAnonymous_parameter_1__Type_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Association_ <em>Association </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association </em>'.
   * @see cruise.umple.umple.Association_
   * @generated
   */
  EClass getAssociation_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Association_#getModifier_1 <em>Modifier 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Modifier 1</em>'.
   * @see cruise.umple.umple.Association_#getModifier_1()
   * @see #getAssociation_()
   * @generated
   */
  EAttribute getAssociation__Modifier_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Association_#getAssociationEnd_1 <em>Association End 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association End 1</em>'.
   * @see cruise.umple.umple.Association_#getAssociationEnd_1()
   * @see #getAssociation_()
   * @generated
   */
  EReference getAssociation__AssociationEnd_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Association_#getArrow_1 <em>Arrow 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Arrow 1</em>'.
   * @see cruise.umple.umple.Association_#getArrow_1()
   * @see #getAssociation_()
   * @generated
   */
  EAttribute getAssociation__Arrow_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Association_#getAssociationEnd_2 <em>Association End 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association End 2</em>'.
   * @see cruise.umple.umple.Association_#getAssociationEnd_2()
   * @see #getAssociation_()
   * @generated
   */
  EReference getAssociation__AssociationEnd_2();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SymmetricReflexiveAssociation_ <em>Symmetric Reflexive Association </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Symmetric Reflexive Association </em>'.
   * @see cruise.umple.umple.SymmetricReflexiveAssociation_
   * @generated
   */
  EClass getSymmetricReflexiveAssociation_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.SymmetricReflexiveAssociation_#getMultiplicity_1 <em>Multiplicity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multiplicity 1</em>'.
   * @see cruise.umple.umple.SymmetricReflexiveAssociation_#getMultiplicity_1()
   * @see #getSymmetricReflexiveAssociation_()
   * @generated
   */
  EReference getSymmetricReflexiveAssociation__Multiplicity_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SymmetricReflexiveAssociation_#getRoleName_1 <em>Role Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Role Name 1</em>'.
   * @see cruise.umple.umple.SymmetricReflexiveAssociation_#getRoleName_1()
   * @see #getSymmetricReflexiveAssociation_()
   * @generated
   */
  EAttribute getSymmetricReflexiveAssociation__RoleName_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InlineAssociation_ <em>Inline Association </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inline Association </em>'.
   * @see cruise.umple.umple.InlineAssociation_
   * @generated
   */
  EClass getInlineAssociation_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineAssociation_#getModifier_1 <em>Modifier 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Modifier 1</em>'.
   * @see cruise.umple.umple.InlineAssociation_#getModifier_1()
   * @see #getInlineAssociation_()
   * @generated
   */
  EAttribute getInlineAssociation__Modifier_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InlineAssociation_#getInlineAssociationEnd_1 <em>Inline Association End 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inline Association End 1</em>'.
   * @see cruise.umple.umple.InlineAssociation_#getInlineAssociationEnd_1()
   * @see #getInlineAssociation_()
   * @generated
   */
  EReference getInlineAssociation__InlineAssociationEnd_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineAssociation_#getArrow_1 <em>Arrow 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Arrow 1</em>'.
   * @see cruise.umple.umple.InlineAssociation_#getArrow_1()
   * @see #getInlineAssociation_()
   * @generated
   */
  EAttribute getInlineAssociation__Arrow_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InlineAssociation_#getAssociationEnd_1 <em>Association End 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association End 1</em>'.
   * @see cruise.umple.umple.InlineAssociation_#getAssociationEnd_1()
   * @see #getInlineAssociation_()
   * @generated
   */
  EReference getInlineAssociation__AssociationEnd_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InlineAssociationEnd_ <em>Inline Association End </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inline Association End </em>'.
   * @see cruise.umple.umple.InlineAssociationEnd_
   * @generated
   */
  EClass getInlineAssociationEnd_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InlineAssociationEnd_#getMultiplicity_1 <em>Multiplicity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multiplicity 1</em>'.
   * @see cruise.umple.umple.InlineAssociationEnd_#getMultiplicity_1()
   * @see #getInlineAssociationEnd_()
   * @generated
   */
  EReference getInlineAssociationEnd__Multiplicity_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InlineAssociationEnd_#getIsSorted_1 <em>Is Sorted 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Is Sorted 1</em>'.
   * @see cruise.umple.umple.InlineAssociationEnd_#getIsSorted_1()
   * @see #getInlineAssociationEnd_()
   * @generated
   */
  EReference getInlineAssociationEnd__IsSorted_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineAssociationEnd_#getRoleName_1 <em>Role Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Role Name 1</em>'.
   * @see cruise.umple.umple.InlineAssociationEnd_#getRoleName_1()
   * @see #getInlineAssociationEnd_()
   * @generated
   */
  EAttribute getInlineAssociationEnd__RoleName_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SingleAssociationEnd_ <em>Single Association End </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Association End </em>'.
   * @see cruise.umple.umple.SingleAssociationEnd_
   * @generated
   */
  EClass getSingleAssociationEnd_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.SingleAssociationEnd_#getMultiplicity_1 <em>Multiplicity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multiplicity 1</em>'.
   * @see cruise.umple.umple.SingleAssociationEnd_#getMultiplicity_1()
   * @see #getSingleAssociationEnd_()
   * @generated
   */
  EReference getSingleAssociationEnd__Multiplicity_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SingleAssociationEnd_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.SingleAssociationEnd_#getType_1()
   * @see #getSingleAssociationEnd_()
   * @generated
   */
  EAttribute getSingleAssociationEnd__Type_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SingleAssociationEnd_#getRoleName_1 <em>Role Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Role Name 1</em>'.
   * @see cruise.umple.umple.SingleAssociationEnd_#getRoleName_1()
   * @see #getSingleAssociationEnd_()
   * @generated
   */
  EAttribute getSingleAssociationEnd__RoleName_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationEnd_ <em>Association End </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association End </em>'.
   * @see cruise.umple.umple.AssociationEnd_
   * @generated
   */
  EClass getAssociationEnd_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationEnd_#getMultiplicity_1 <em>Multiplicity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multiplicity 1</em>'.
   * @see cruise.umple.umple.AssociationEnd_#getMultiplicity_1()
   * @see #getAssociationEnd_()
   * @generated
   */
  EReference getAssociationEnd__Multiplicity_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AssociationEnd_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.AssociationEnd_#getType_1()
   * @see #getAssociationEnd_()
   * @generated
   */
  EAttribute getAssociationEnd__Type_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AssociationEnd_#getRoleName_1 <em>Role Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Role Name 1</em>'.
   * @see cruise.umple.umple.AssociationEnd_#getRoleName_1()
   * @see #getAssociationEnd_()
   * @generated
   */
  EAttribute getAssociationEnd__RoleName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationEnd_#getIsSorted_1 <em>Is Sorted 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Is Sorted 1</em>'.
   * @see cruise.umple.umple.AssociationEnd_#getIsSorted_1()
   * @see #getAssociationEnd_()
   * @generated
   */
  EReference getAssociationEnd__IsSorted_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Multiplicity_ <em>Multiplicity </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity </em>'.
   * @see cruise.umple.umple.Multiplicity_
   * @generated
   */
  EClass getMultiplicity_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Multiplicity_#getBound_1 <em>Bound 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bound 1</em>'.
   * @see cruise.umple.umple.Multiplicity_#getBound_1()
   * @see #getMultiplicity_()
   * @generated
   */
  EAttribute getMultiplicity__Bound_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Multiplicity_#getLowerBound_1 <em>Lower Bound 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound 1</em>'.
   * @see cruise.umple.umple.Multiplicity_#getLowerBound_1()
   * @see #getMultiplicity_()
   * @generated
   */
  EAttribute getMultiplicity__LowerBound_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Multiplicity_#getUpperBound_1 <em>Upper Bound 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound 1</em>'.
   * @see cruise.umple.umple.Multiplicity_#getUpperBound_1()
   * @see #getMultiplicity_()
   * @generated
   */
  EAttribute getMultiplicity__UpperBound_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Multiplicity_#getBound_int <em>Bound int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bound int</em>'.
   * @see cruise.umple.umple.Multiplicity_#getBound_int()
   * @see #getMultiplicity_()
   * @generated
   */
  EAttribute getMultiplicity__Bound_int();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.IsSorted_ <em>Is Sorted </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Is Sorted </em>'.
   * @see cruise.umple.umple.IsSorted_
   * @generated
   */
  EClass getIsSorted_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.IsSorted_#getPriority_1 <em>Priority 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority 1</em>'.
   * @see cruise.umple.umple.IsSorted_#getPriority_1()
   * @see #getIsSorted_()
   * @generated
   */
  EAttribute getIsSorted__Priority_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Attribute_ <em>Attribute </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute </em>'.
   * @see cruise.umple.umple.Attribute_
   * @generated
   */
  EClass getAttribute_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Attribute_#getSimpleAttribute_1 <em>Simple Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Simple Attribute 1</em>'.
   * @see cruise.umple.umple.Attribute_#getSimpleAttribute_1()
   * @see #getAttribute_()
   * @generated
   */
  EReference getAttribute__SimpleAttribute_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Attribute_#getAutouniqueAttribute_1 <em>Autounique Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Autounique Attribute 1</em>'.
   * @see cruise.umple.umple.Attribute_#getAutouniqueAttribute_1()
   * @see #getAttribute_()
   * @generated
   */
  EReference getAttribute__AutouniqueAttribute_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Attribute_#getDerivedAttribute_1 <em>Derived Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Derived Attribute 1</em>'.
   * @see cruise.umple.umple.Attribute_#getDerivedAttribute_1()
   * @see #getAttribute_()
   * @generated
   */
  EReference getAttribute__DerivedAttribute_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Attribute_#getComplexAttribute_1 <em>Complex Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Complex Attribute 1</em>'.
   * @see cruise.umple.umple.Attribute_#getComplexAttribute_1()
   * @see #getAttribute_()
   * @generated
   */
  EReference getAttribute__ComplexAttribute_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SimpleAttribute_ <em>Simple Attribute </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Attribute </em>'.
   * @see cruise.umple.umple.SimpleAttribute_
   * @generated
   */
  EClass getSimpleAttribute_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SimpleAttribute_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.SimpleAttribute_#getName_1()
   * @see #getSimpleAttribute_()
   * @generated
   */
  EAttribute getSimpleAttribute__Name_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AutouniqueAttribute_ <em>Autounique Attribute </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Autounique Attribute </em>'.
   * @see cruise.umple.umple.AutouniqueAttribute_
   * @generated
   */
  EClass getAutouniqueAttribute_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AutouniqueAttribute_#isAutounique_1 <em>Autounique 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Autounique 1</em>'.
   * @see cruise.umple.umple.AutouniqueAttribute_#isAutounique_1()
   * @see #getAutouniqueAttribute_()
   * @generated
   */
  EAttribute getAutouniqueAttribute__Autounique_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AutouniqueAttribute_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.AutouniqueAttribute_#getName_1()
   * @see #getAutouniqueAttribute_()
   * @generated
   */
  EAttribute getAutouniqueAttribute__Name_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.DerivedAttribute_ <em>Derived Attribute </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Derived Attribute </em>'.
   * @see cruise.umple.umple.DerivedAttribute_
   * @generated
   */
  EClass getDerivedAttribute_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.DerivedAttribute_#getModifier_1 <em>Modifier 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Modifier 1</em>'.
   * @see cruise.umple.umple.DerivedAttribute_#getModifier_1()
   * @see #getDerivedAttribute_()
   * @generated
   */
  EAttribute getDerivedAttribute__Modifier_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_1_1 <em>Anonymous derived Attribute 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous derived Attribute 11</em>'.
   * @see cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_1_1()
   * @see #getDerivedAttribute_()
   * @generated
   */
  EReference getDerivedAttribute__Anonymous_derivedAttribute_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_2_1 <em>Anonymous derived Attribute 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous derived Attribute 21</em>'.
   * @see cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_2_1()
   * @see #getDerivedAttribute_()
   * @generated
   */
  EReference getDerivedAttribute__Anonymous_derivedAttribute_2_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.DerivedAttribute_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.DerivedAttribute_#getCode_1()
   * @see #getDerivedAttribute_()
   * @generated
   */
  EAttribute getDerivedAttribute__Code_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_3_1 <em>Anonymous derived Attribute 31</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous derived Attribute 31</em>'.
   * @see cruise.umple.umple.DerivedAttribute_#getAnonymous_derivedAttribute_3_1()
   * @see #getDerivedAttribute_()
   * @generated
   */
  EReference getDerivedAttribute__Anonymous_derivedAttribute_3_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_derivedAttribute_1_ <em>Anonymous derived Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous derived Attribute 1</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_1_
   * @generated
   */
  EClass getAnonymous_derivedAttribute_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_derivedAttribute_1_#isList_1 <em>List 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>List 1</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_1_#isList_1()
   * @see #getAnonymous_derivedAttribute_1_()
   * @generated
   */
  EAttribute getAnonymous_derivedAttribute_1__List_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_derivedAttribute_1_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_1_#getName_1()
   * @see #getAnonymous_derivedAttribute_1_()
   * @generated
   */
  EAttribute getAnonymous_derivedAttribute_1__Name_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_derivedAttribute_1_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_1_#getType_1()
   * @see #getAnonymous_derivedAttribute_1_()
   * @generated
   */
  EAttribute getAnonymous_derivedAttribute_1__Type_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_derivedAttribute_2_ <em>Anonymous derived Attribute 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous derived Attribute 2</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_2_
   * @generated
   */
  EClass getAnonymous_derivedAttribute_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_derivedAttribute_2_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_2_#getCodeLang_1()
   * @see #getAnonymous_derivedAttribute_2_()
   * @generated
   */
  EReference getAnonymous_derivedAttribute_2__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_derivedAttribute_2_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_2_#getCodeLangs_1()
   * @see #getAnonymous_derivedAttribute_2_()
   * @generated
   */
  EReference getAnonymous_derivedAttribute_2__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_derivedAttribute_3_ <em>Anonymous derived Attribute 3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous derived Attribute 3</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_3_
   * @generated
   */
  EClass getAnonymous_derivedAttribute_3_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_derivedAttribute_3_#getMoreCode_1 <em>More Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_derivedAttribute_3_#getMoreCode_1()
   * @see #getAnonymous_derivedAttribute_3_()
   * @generated
   */
  EReference getAnonymous_derivedAttribute_3__MoreCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ComplexAttribute_ <em>Complex Attribute </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Attribute </em>'.
   * @see cruise.umple.umple.ComplexAttribute_
   * @generated
   */
  EClass getComplexAttribute_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ComplexAttribute_#isUnique_1 <em>Unique 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique 1</em>'.
   * @see cruise.umple.umple.ComplexAttribute_#isUnique_1()
   * @see #getComplexAttribute_()
   * @generated
   */
  EAttribute getComplexAttribute__Unique_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ComplexAttribute_#isLazy_1 <em>Lazy 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lazy 1</em>'.
   * @see cruise.umple.umple.ComplexAttribute_#isLazy_1()
   * @see #getComplexAttribute_()
   * @generated
   */
  EAttribute getComplexAttribute__Lazy_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ComplexAttribute_#getModifier_1 <em>Modifier 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Modifier 1</em>'.
   * @see cruise.umple.umple.ComplexAttribute_#getModifier_1()
   * @see #getComplexAttribute_()
   * @generated
   */
  EAttribute getComplexAttribute__Modifier_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ComplexAttribute_#getAnonymous_complexAttribute_1_1 <em>Anonymous complex Attribute 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous complex Attribute 11</em>'.
   * @see cruise.umple.umple.ComplexAttribute_#getAnonymous_complexAttribute_1_1()
   * @see #getComplexAttribute_()
   * @generated
   */
  EReference getComplexAttribute__Anonymous_complexAttribute_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ComplexAttribute_#getAnonymous_complexAttribute_2_1 <em>Anonymous complex Attribute 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous complex Attribute 21</em>'.
   * @see cruise.umple.umple.ComplexAttribute_#getAnonymous_complexAttribute_2_1()
   * @see #getComplexAttribute_()
   * @generated
   */
  EReference getComplexAttribute__Anonymous_complexAttribute_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_complexAttribute_1_ <em>Anonymous complex Attribute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous complex Attribute 1</em>'.
   * @see cruise.umple.umple.Anonymous_complexAttribute_1_
   * @generated
   */
  EClass getAnonymous_complexAttribute_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_complexAttribute_1_#isList_1 <em>List 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>List 1</em>'.
   * @see cruise.umple.umple.Anonymous_complexAttribute_1_#isList_1()
   * @see #getAnonymous_complexAttribute_1_()
   * @generated
   */
  EAttribute getAnonymous_complexAttribute_1__List_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_complexAttribute_1_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.Anonymous_complexAttribute_1_#getName_1()
   * @see #getAnonymous_complexAttribute_1_()
   * @generated
   */
  EAttribute getAnonymous_complexAttribute_1__Name_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_complexAttribute_1_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.Anonymous_complexAttribute_1_#getType_1()
   * @see #getAnonymous_complexAttribute_1_()
   * @generated
   */
  EAttribute getAnonymous_complexAttribute_1__Type_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_complexAttribute_2_ <em>Anonymous complex Attribute 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous complex Attribute 2</em>'.
   * @see cruise.umple.umple.Anonymous_complexAttribute_2_
   * @generated
   */
  EClass getAnonymous_complexAttribute_2_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_complexAttribute_2_#getValue_1 <em>Value 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value 1</em>'.
   * @see cruise.umple.umple.Anonymous_complexAttribute_2_#getValue_1()
   * @see #getAnonymous_complexAttribute_2_()
   * @generated
   */
  EAttribute getAnonymous_complexAttribute_2__Value_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Key_ <em>Key </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key </em>'.
   * @see cruise.umple.umple.Key_
   * @generated
   */
  EClass getKey_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Key_#getKeyId_1 <em>Key Id 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key Id 1</em>'.
   * @see cruise.umple.umple.Key_#getKeyId_1()
   * @see #getKey_()
   * @generated
   */
  EAttribute getKey__KeyId_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Key_#getAnonymous_key_1_1 <em>Anonymous key 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous key 11</em>'.
   * @see cruise.umple.umple.Key_#getAnonymous_key_1_1()
   * @see #getKey_()
   * @generated
   */
  EReference getKey__Anonymous_key_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_key_1_ <em>Anonymous key 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous key 1</em>'.
   * @see cruise.umple.umple.Anonymous_key_1_
   * @generated
   */
  EClass getAnonymous_key_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_key_1_#getKeyId_1 <em>Key Id 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key Id 1</em>'.
   * @see cruise.umple.umple.Anonymous_key_1_#getKeyId_1()
   * @see #getAnonymous_key_1_()
   * @generated
   */
  EAttribute getAnonymous_key_1__KeyId_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Depend_ <em>Depend </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Depend </em>'.
   * @see cruise.umple.umple.Depend_
   * @generated
   */
  EClass getDepend_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Depend_#getDepend_1 <em>Depend 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Depend 1</em>'.
   * @see cruise.umple.umple.Depend_#getDepend_1()
   * @see #getDepend_()
   * @generated
   */
  EAttribute getDepend__Depend_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ExtraCode_ <em>Extra Code </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Extra Code </em>'.
   * @see cruise.umple.umple.ExtraCode_
   * @generated
   */
  EClass getExtraCode_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ExtraCode_#getExtraCode_1 <em>Extra Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extra Code 1</em>'.
   * @see cruise.umple.umple.ExtraCode_#getExtraCode_1()
   * @see #getExtraCode_()
   * @generated
   */
  EAttribute getExtraCode__ExtraCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SoftwarePattern_ <em>Software Pattern </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Software Pattern </em>'.
   * @see cruise.umple.umple.SoftwarePattern_
   * @generated
   */
  EClass getSoftwarePattern_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.SoftwarePattern_#getIsA_1 <em>Is A1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Is A1</em>'.
   * @see cruise.umple.umple.SoftwarePattern_#getIsA_1()
   * @see #getSoftwarePattern_()
   * @generated
   */
  EReference getSoftwarePattern__IsA_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.SoftwarePattern_#getSingleton_1 <em>Singleton 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Singleton 1</em>'.
   * @see cruise.umple.umple.SoftwarePattern_#getSingleton_1()
   * @see #getSoftwarePattern_()
   * @generated
   */
  EReference getSoftwarePattern__Singleton_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.SoftwarePattern_#getImmutable_1 <em>Immutable 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Immutable 1</em>'.
   * @see cruise.umple.umple.SoftwarePattern_#getImmutable_1()
   * @see #getSoftwarePattern_()
   * @generated
   */
  EReference getSoftwarePattern__Immutable_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.SoftwarePattern_#getKeyDefinition_1 <em>Key Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Key Definition 1</em>'.
   * @see cruise.umple.umple.SoftwarePattern_#getKeyDefinition_1()
   * @see #getSoftwarePattern_()
   * @generated
   */
  EReference getSoftwarePattern__KeyDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.SoftwarePattern_#getCodeInjection_1 <em>Code Injection 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Injection 1</em>'.
   * @see cruise.umple.umple.SoftwarePattern_#getCodeInjection_1()
   * @see #getSoftwarePattern_()
   * @generated
   */
  EReference getSoftwarePattern__CodeInjection_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.IsA_ <em>Is A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Is A</em>'.
   * @see cruise.umple.umple.IsA_
   * @generated
   */
  EClass getIsA_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.IsA_#getSingleIsA_1 <em>Single Is A1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Single Is A1</em>'.
   * @see cruise.umple.umple.IsA_#getSingleIsA_1()
   * @see #getIsA_()
   * @generated
   */
  EReference getIsA__SingleIsA_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.IsA_#getMultipleIsA_1 <em>Multiple Is A1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Multiple Is A1</em>'.
   * @see cruise.umple.umple.IsA_#getMultipleIsA_1()
   * @see #getIsA_()
   * @generated
   */
  EReference getIsA__MultipleIsA_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SingleIsA_ <em>Single Is A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Is A</em>'.
   * @see cruise.umple.umple.SingleIsA_
   * @generated
   */
  EClass getSingleIsA_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SingleIsA_#getExtendsName_1 <em>Extends Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extends Name 1</em>'.
   * @see cruise.umple.umple.SingleIsA_#getExtendsName_1()
   * @see #getSingleIsA_()
   * @generated
   */
  EAttribute getSingleIsA__ExtendsName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.SingleIsA_#getAnonymous_singleIsA_1_1 <em>Anonymous single Is A11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous single Is A11</em>'.
   * @see cruise.umple.umple.SingleIsA_#getAnonymous_singleIsA_1_1()
   * @see #getSingleIsA_()
   * @generated
   */
  EReference getSingleIsA__Anonymous_singleIsA_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_singleIsA_1_ <em>Anonymous single Is A1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous single Is A1</em>'.
   * @see cruise.umple.umple.Anonymous_singleIsA_1_
   * @generated
   */
  EClass getAnonymous_singleIsA_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_singleIsA_1_#getExtendsName_1 <em>Extends Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extends Name 1</em>'.
   * @see cruise.umple.umple.Anonymous_singleIsA_1_#getExtendsName_1()
   * @see #getAnonymous_singleIsA_1_()
   * @generated
   */
  EAttribute getAnonymous_singleIsA_1__ExtendsName_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.MultipleIsA_ <em>Multiple Is A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiple Is A</em>'.
   * @see cruise.umple.umple.MultipleIsA_
   * @generated
   */
  EClass getMultipleIsA_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.MultipleIsA_#getExtendsName_1 <em>Extends Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extends Name 1</em>'.
   * @see cruise.umple.umple.MultipleIsA_#getExtendsName_1()
   * @see #getMultipleIsA_()
   * @generated
   */
  EAttribute getMultipleIsA__ExtendsName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.MultipleIsA_#getAnonymous_multipleIsA_1_1 <em>Anonymous multiple Is A11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous multiple Is A11</em>'.
   * @see cruise.umple.umple.MultipleIsA_#getAnonymous_multipleIsA_1_1()
   * @see #getMultipleIsA_()
   * @generated
   */
  EReference getMultipleIsA__Anonymous_multipleIsA_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_multipleIsA_1_ <em>Anonymous multiple Is A1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous multiple Is A1</em>'.
   * @see cruise.umple.umple.Anonymous_multipleIsA_1_
   * @generated
   */
  EClass getAnonymous_multipleIsA_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_multipleIsA_1_#getExtendsName_1 <em>Extends Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Extends Name 1</em>'.
   * @see cruise.umple.umple.Anonymous_multipleIsA_1_#getExtendsName_1()
   * @see #getAnonymous_multipleIsA_1_()
   * @generated
   */
  EAttribute getAnonymous_multipleIsA_1__ExtendsName_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Singleton_ <em>Singleton </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Singleton </em>'.
   * @see cruise.umple.umple.Singleton_
   * @generated
   */
  EClass getSingleton_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Singleton_#isSingleton_1 <em>Singleton 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Singleton 1</em>'.
   * @see cruise.umple.umple.Singleton_#isSingleton_1()
   * @see #getSingleton_()
   * @generated
   */
  EAttribute getSingleton__Singleton_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Immutable_ <em>Immutable </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Immutable </em>'.
   * @see cruise.umple.umple.Immutable_
   * @generated
   */
  EClass getImmutable_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Immutable_#isImmutable_1 <em>Immutable 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Immutable 1</em>'.
   * @see cruise.umple.umple.Immutable_#isImmutable_1()
   * @see #getImmutable_()
   * @generated
   */
  EAttribute getImmutable__Immutable_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.KeyDefinition_ <em>Key Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Definition </em>'.
   * @see cruise.umple.umple.KeyDefinition_
   * @generated
   */
  EClass getKeyDefinition_();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.KeyDefinition_#getDefaultKey_1 <em>Default Key 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Default Key 1</em>'.
   * @see cruise.umple.umple.KeyDefinition_#getDefaultKey_1()
   * @see #getKeyDefinition_()
   * @generated
   */
  EAttribute getKeyDefinition__DefaultKey_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.KeyDefinition_#getKey_1 <em>Key 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Key 1</em>'.
   * @see cruise.umple.umple.KeyDefinition_#getKey_1()
   * @see #getKeyDefinition_()
   * @generated
   */
  EReference getKeyDefinition__Key_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.CodeInjection_ <em>Code Injection </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code Injection </em>'.
   * @see cruise.umple.umple.CodeInjection_
   * @generated
   */
  EClass getCodeInjection_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.CodeInjection_#getBeforeCode_1 <em>Before Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Before Code 1</em>'.
   * @see cruise.umple.umple.CodeInjection_#getBeforeCode_1()
   * @see #getCodeInjection_()
   * @generated
   */
  EReference getCodeInjection__BeforeCode_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.CodeInjection_#getAfterCode_1 <em>After Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>After Code 1</em>'.
   * @see cruise.umple.umple.CodeInjection_#getAfterCode_1()
   * @see #getCodeInjection_()
   * @generated
   */
  EReference getCodeInjection__AfterCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.BeforeCode_ <em>Before Code </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Before Code </em>'.
   * @see cruise.umple.umple.BeforeCode_
   * @generated
   */
  EClass getBeforeCode_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.BeforeCode_#getOperationName_1 <em>Operation Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation Name 1</em>'.
   * @see cruise.umple.umple.BeforeCode_#getOperationName_1()
   * @see #getBeforeCode_()
   * @generated
   */
  EAttribute getBeforeCode__OperationName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.BeforeCode_#getAnonymous_beforeCode_1_1 <em>Anonymous before Code 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous before Code 11</em>'.
   * @see cruise.umple.umple.BeforeCode_#getAnonymous_beforeCode_1_1()
   * @see #getBeforeCode_()
   * @generated
   */
  EReference getBeforeCode__Anonymous_beforeCode_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.BeforeCode_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.BeforeCode_#getCode_1()
   * @see #getBeforeCode_()
   * @generated
   */
  EAttribute getBeforeCode__Code_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.BeforeCode_#getAnonymous_beforeCode_2_1 <em>Anonymous before Code 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous before Code 21</em>'.
   * @see cruise.umple.umple.BeforeCode_#getAnonymous_beforeCode_2_1()
   * @see #getBeforeCode_()
   * @generated
   */
  EReference getBeforeCode__Anonymous_beforeCode_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_beforeCode_1_ <em>Anonymous before Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous before Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_beforeCode_1_
   * @generated
   */
  EClass getAnonymous_beforeCode_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_beforeCode_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_beforeCode_1_#getCodeLang_1()
   * @see #getAnonymous_beforeCode_1_()
   * @generated
   */
  EReference getAnonymous_beforeCode_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_beforeCode_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_beforeCode_1_#getCodeLangs_1()
   * @see #getAnonymous_beforeCode_1_()
   * @generated
   */
  EReference getAnonymous_beforeCode_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_beforeCode_2_ <em>Anonymous before Code 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous before Code 2</em>'.
   * @see cruise.umple.umple.Anonymous_beforeCode_2_
   * @generated
   */
  EClass getAnonymous_beforeCode_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_beforeCode_2_#getMoreCode_1 <em>More Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_beforeCode_2_#getMoreCode_1()
   * @see #getAnonymous_beforeCode_2_()
   * @generated
   */
  EReference getAnonymous_beforeCode_2__MoreCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AfterCode_ <em>After Code </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>After Code </em>'.
   * @see cruise.umple.umple.AfterCode_
   * @generated
   */
  EClass getAfterCode_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AfterCode_#getOperationName_1 <em>Operation Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation Name 1</em>'.
   * @see cruise.umple.umple.AfterCode_#getOperationName_1()
   * @see #getAfterCode_()
   * @generated
   */
  EAttribute getAfterCode__OperationName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AfterCode_#getAnonymous_afterCode_1_1 <em>Anonymous after Code 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous after Code 11</em>'.
   * @see cruise.umple.umple.AfterCode_#getAnonymous_afterCode_1_1()
   * @see #getAfterCode_()
   * @generated
   */
  EReference getAfterCode__Anonymous_afterCode_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AfterCode_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.AfterCode_#getCode_1()
   * @see #getAfterCode_()
   * @generated
   */
  EAttribute getAfterCode__Code_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AfterCode_#getAnonymous_afterCode_2_1 <em>Anonymous after Code 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous after Code 21</em>'.
   * @see cruise.umple.umple.AfterCode_#getAnonymous_afterCode_2_1()
   * @see #getAfterCode_()
   * @generated
   */
  EReference getAfterCode__Anonymous_afterCode_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_afterCode_1_ <em>Anonymous after Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous after Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_afterCode_1_
   * @generated
   */
  EClass getAnonymous_afterCode_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_afterCode_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_afterCode_1_#getCodeLang_1()
   * @see #getAnonymous_afterCode_1_()
   * @generated
   */
  EReference getAnonymous_afterCode_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_afterCode_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_afterCode_1_#getCodeLangs_1()
   * @see #getAnonymous_afterCode_1_()
   * @generated
   */
  EReference getAnonymous_afterCode_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_afterCode_2_ <em>Anonymous after Code 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous after Code 2</em>'.
   * @see cruise.umple.umple.Anonymous_afterCode_2_
   * @generated
   */
  EClass getAnonymous_afterCode_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_afterCode_2_#getMoreCode_1 <em>More Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_afterCode_2_#getMoreCode_1()
   * @see #getAnonymous_afterCode_2_()
   * @generated
   */
  EReference getAnonymous_afterCode_2__MoreCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StateMachineDefinition_ <em>State Machine Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Machine Definition </em>'.
   * @see cruise.umple.umple.StateMachineDefinition_
   * @generated
   */
  EClass getStateMachineDefinition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.StateMachineDefinition_#isQueued_1 <em>Queued 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Queued 1</em>'.
   * @see cruise.umple.umple.StateMachineDefinition_#isQueued_1()
   * @see #getStateMachineDefinition_()
   * @generated
   */
  EAttribute getStateMachineDefinition__Queued_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.StateMachineDefinition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.StateMachineDefinition_#getName_1()
   * @see #getStateMachineDefinition_()
   * @generated
   */
  EAttribute getStateMachineDefinition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateMachineDefinition_#getState_1 <em>State 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State 1</em>'.
   * @see cruise.umple.umple.StateMachineDefinition_#getState_1()
   * @see #getStateMachineDefinition_()
   * @generated
   */
  EReference getStateMachineDefinition__State_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StateMachine_ <em>State Machine </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Machine </em>'.
   * @see cruise.umple.umple.StateMachine_
   * @generated
   */
  EClass getStateMachine_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateMachine_#getEnum_1 <em>Enum 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enum 1</em>'.
   * @see cruise.umple.umple.StateMachine_#getEnum_1()
   * @see #getStateMachine_()
   * @generated
   */
  EReference getStateMachine__Enum_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateMachine_#getInlineStateMachine_1 <em>Inline State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inline State Machine 1</em>'.
   * @see cruise.umple.umple.StateMachine_#getInlineStateMachine_1()
   * @see #getStateMachine_()
   * @generated
   */
  EReference getStateMachine__InlineStateMachine_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateMachine_#getReferencedStateMachine_1 <em>Referenced State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Referenced State Machine 1</em>'.
   * @see cruise.umple.umple.StateMachine_#getReferencedStateMachine_1()
   * @see #getStateMachine_()
   * @generated
   */
  EReference getStateMachine__ReferencedStateMachine_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateMachine_#getActiveDefinition_1 <em>Active Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Active Definition 1</em>'.
   * @see cruise.umple.umple.StateMachine_#getActiveDefinition_1()
   * @see #getStateMachine_()
   * @generated
   */
  EReference getStateMachine__ActiveDefinition_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ActiveDefinition_ <em>Active Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Active Definition </em>'.
   * @see cruise.umple.umple.ActiveDefinition_
   * @generated
   */
  EClass getActiveDefinition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ActiveDefinition_#isActive_1 <em>Active 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Active 1</em>'.
   * @see cruise.umple.umple.ActiveDefinition_#isActive_1()
   * @see #getActiveDefinition_()
   * @generated
   */
  EAttribute getActiveDefinition__Active_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ActiveDefinition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.ActiveDefinition_#getName_1()
   * @see #getActiveDefinition_()
   * @generated
   */
  EAttribute getActiveDefinition__Name_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ActiveDefinition_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.ActiveDefinition_#getCode_1()
   * @see #getActiveDefinition_()
   * @generated
   */
  EAttribute getActiveDefinition__Code_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InlineStateMachine_ <em>Inline State Machine </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inline State Machine </em>'.
   * @see cruise.umple.umple.InlineStateMachine_
   * @generated
   */
  EClass getInlineStateMachine_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineStateMachine_#isQueued_1 <em>Queued 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Queued 1</em>'.
   * @see cruise.umple.umple.InlineStateMachine_#isQueued_1()
   * @see #getInlineStateMachine_()
   * @generated
   */
  EAttribute getInlineStateMachine__Queued_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineStateMachine_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.InlineStateMachine_#getName_1()
   * @see #getInlineStateMachine_()
   * @generated
   */
  EAttribute getInlineStateMachine__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InlineStateMachine_#getAnonymous_inlineStateMachine_1_1 <em>Anonymous inline State Machine 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous inline State Machine 11</em>'.
   * @see cruise.umple.umple.InlineStateMachine_#getAnonymous_inlineStateMachine_1_1()
   * @see #getInlineStateMachine_()
   * @generated
   */
  EReference getInlineStateMachine__Anonymous_inlineStateMachine_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_inlineStateMachine_1_ <em>Anonymous inline State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous inline State Machine 1</em>'.
   * @see cruise.umple.umple.Anonymous_inlineStateMachine_1_
   * @generated
   */
  EClass getAnonymous_inlineStateMachine_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_inlineStateMachine_1_#getComment_1 <em>Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comment 1</em>'.
   * @see cruise.umple.umple.Anonymous_inlineStateMachine_1_#getComment_1()
   * @see #getAnonymous_inlineStateMachine_1_()
   * @generated
   */
  EReference getAnonymous_inlineStateMachine_1__Comment_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_inlineStateMachine_1_#getState_1 <em>State 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State 1</em>'.
   * @see cruise.umple.umple.Anonymous_inlineStateMachine_1_#getState_1()
   * @see #getAnonymous_inlineStateMachine_1_()
   * @generated
   */
  EReference getAnonymous_inlineStateMachine_1__State_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_inlineStateMachine_1_#getTrace_1 <em>Trace 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace 1</em>'.
   * @see cruise.umple.umple.Anonymous_inlineStateMachine_1_#getTrace_1()
   * @see #getAnonymous_inlineStateMachine_1_()
   * @generated
   */
  EReference getAnonymous_inlineStateMachine_1__Trace_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ReferencedStateMachine_ <em>Referenced State Machine </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Referenced State Machine </em>'.
   * @see cruise.umple.umple.ReferencedStateMachine_
   * @generated
   */
  EClass getReferencedStateMachine_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ReferencedStateMachine_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.ReferencedStateMachine_#getName_1()
   * @see #getReferencedStateMachine_()
   * @generated
   */
  EAttribute getReferencedStateMachine__Name_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ReferencedStateMachine_#getDefinitionName_1 <em>Definition Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Definition Name 1</em>'.
   * @see cruise.umple.umple.ReferencedStateMachine_#getDefinitionName_1()
   * @see #getReferencedStateMachine_()
   * @generated
   */
  EAttribute getReferencedStateMachine__DefinitionName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ReferencedStateMachine_#getExtendedStateMachine_1 <em>Extended State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Extended State Machine 1</em>'.
   * @see cruise.umple.umple.ReferencedStateMachine_#getExtendedStateMachine_1()
   * @see #getReferencedStateMachine_()
   * @generated
   */
  EReference getReferencedStateMachine__ExtendedStateMachine_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ExtendedStateMachine_ <em>Extended State Machine </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Extended State Machine </em>'.
   * @see cruise.umple.umple.ExtendedStateMachine_
   * @generated
   */
  EClass getExtendedStateMachine_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ExtendedStateMachine_#getAnonymous_extendedStateMachine_1_1 <em>Anonymous extended State Machine 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous extended State Machine 11</em>'.
   * @see cruise.umple.umple.ExtendedStateMachine_#getAnonymous_extendedStateMachine_1_1()
   * @see #getExtendedStateMachine_()
   * @generated
   */
  EReference getExtendedStateMachine__Anonymous_extendedStateMachine_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_extendedStateMachine_1_ <em>Anonymous extended State Machine 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous extended State Machine 1</em>'.
   * @see cruise.umple.umple.Anonymous_extendedStateMachine_1_
   * @generated
   */
  EClass getAnonymous_extendedStateMachine_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_extendedStateMachine_1_#getComment_1 <em>Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comment 1</em>'.
   * @see cruise.umple.umple.Anonymous_extendedStateMachine_1_#getComment_1()
   * @see #getAnonymous_extendedStateMachine_1_()
   * @generated
   */
  EReference getAnonymous_extendedStateMachine_1__Comment_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_extendedStateMachine_1_#getChangeType_1 <em>Change Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Change Type 1</em>'.
   * @see cruise.umple.umple.Anonymous_extendedStateMachine_1_#getChangeType_1()
   * @see #getAnonymous_extendedStateMachine_1_()
   * @generated
   */
  EAttribute getAnonymous_extendedStateMachine_1__ChangeType_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_extendedStateMachine_1_#getState_1 <em>State 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State 1</em>'.
   * @see cruise.umple.umple.Anonymous_extendedStateMachine_1_#getState_1()
   * @see #getAnonymous_extendedStateMachine_1_()
   * @generated
   */
  EReference getAnonymous_extendedStateMachine_1__State_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Enum_ <em>Enum </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum </em>'.
   * @see cruise.umple.umple.Enum_
   * @generated
   */
  EClass getEnum_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Enum_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.Enum_#getName_1()
   * @see #getEnum_()
   * @generated
   */
  EAttribute getEnum__Name_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Enum_#getStateName_1 <em>State Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name 1</em>'.
   * @see cruise.umple.umple.Enum_#getStateName_1()
   * @see #getEnum_()
   * @generated
   */
  EAttribute getEnum__StateName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Enum_#getAnonymous_enum_1_1 <em>Anonymous enum 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous enum 11</em>'.
   * @see cruise.umple.umple.Enum_#getAnonymous_enum_1_1()
   * @see #getEnum_()
   * @generated
   */
  EReference getEnum__Anonymous_enum_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_enum_1_ <em>Anonymous enum 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous enum 1</em>'.
   * @see cruise.umple.umple.Anonymous_enum_1_
   * @generated
   */
  EClass getAnonymous_enum_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_enum_1_#getStateName_1 <em>State Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name 1</em>'.
   * @see cruise.umple.umple.Anonymous_enum_1_#getStateName_1()
   * @see #getAnonymous_enum_1_()
   * @generated
   */
  EAttribute getAnonymous_enum_1__StateName_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.State_ <em>State </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State </em>'.
   * @see cruise.umple.umple.State_
   * @generated
   */
  EClass getState_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.State_#getStateName_1 <em>State Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name 1</em>'.
   * @see cruise.umple.umple.State_#getStateName_1()
   * @see #getState_()
   * @generated
   */
  EAttribute getState__StateName_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.State_#getStateInternal_1 <em>State Internal 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Internal 1</em>'.
   * @see cruise.umple.umple.State_#getStateInternal_1()
   * @see #getState_()
   * @generated
   */
  EReference getState__StateInternal_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.State_#isFinal_1 <em>Final 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final 1</em>'.
   * @see cruise.umple.umple.State_#isFinal_1()
   * @see #getState_()
   * @generated
   */
  EAttribute getState__Final_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.State_#getAnonymous_state_1_1 <em>Anonymous state 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous state 11</em>'.
   * @see cruise.umple.umple.State_#getAnonymous_state_1_1()
   * @see #getState_()
   * @generated
   */
  EReference getState__Anonymous_state_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_state_1_ <em>Anonymous state 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous state 1</em>'.
   * @see cruise.umple.umple.Anonymous_state_1_
   * @generated
   */
  EClass getAnonymous_state_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_state_1_#getStateInternal_1 <em>State Internal 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Internal 1</em>'.
   * @see cruise.umple.umple.Anonymous_state_1_#getStateInternal_1()
   * @see #getAnonymous_state_1_()
   * @generated
   */
  EReference getAnonymous_state_1__StateInternal_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StateInternal_ <em>State Internal </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Internal </em>'.
   * @see cruise.umple.umple.StateInternal_
   * @generated
   */
  EClass getStateInternal_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateInternal_#getComment_1 <em>Comment 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Comment 1</em>'.
   * @see cruise.umple.umple.StateInternal_#getComment_1()
   * @see #getStateInternal_()
   * @generated
   */
  EReference getStateInternal__Comment_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.StateInternal_#getChangeType_1 <em>Change Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Change Type 1</em>'.
   * @see cruise.umple.umple.StateInternal_#getChangeType_1()
   * @see #getStateInternal_()
   * @generated
   */
  EAttribute getStateInternal__ChangeType_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateInternal_#getStateEntity_1 <em>State Entity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Entity 1</em>'.
   * @see cruise.umple.umple.StateInternal_#getStateEntity_1()
   * @see #getStateInternal_()
   * @generated
   */
  EReference getStateInternal__StateEntity_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StateEntity_ <em>State Entity </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Entity </em>'.
   * @see cruise.umple.umple.StateEntity_
   * @generated
   */
  EClass getStateEntity_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateEntity_#getEntryOrExitAction_1 <em>Entry Or Exit Action 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entry Or Exit Action 1</em>'.
   * @see cruise.umple.umple.StateEntity_#getEntryOrExitAction_1()
   * @see #getStateEntity_()
   * @generated
   */
  EReference getStateEntity__EntryOrExitAction_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateEntity_#getAutoTransition_1 <em>Auto Transition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Auto Transition 1</em>'.
   * @see cruise.umple.umple.StateEntity_#getAutoTransition_1()
   * @see #getStateEntity_()
   * @generated
   */
  EReference getStateEntity__AutoTransition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateEntity_#getTransition_1 <em>Transition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transition 1</em>'.
   * @see cruise.umple.umple.StateEntity_#getTransition_1()
   * @see #getStateEntity_()
   * @generated
   */
  EReference getStateEntity__Transition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateEntity_#getActivity_1 <em>Activity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Activity 1</em>'.
   * @see cruise.umple.umple.StateEntity_#getActivity_1()
   * @see #getStateEntity_()
   * @generated
   */
  EReference getStateEntity__Activity_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateEntity_#getState_1 <em>State 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State 1</em>'.
   * @see cruise.umple.umple.StateEntity_#getState_1()
   * @see #getStateEntity_()
   * @generated
   */
  EReference getStateEntity__State_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateEntity_#getTrace_1 <em>Trace 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace 1</em>'.
   * @see cruise.umple.umple.StateEntity_#getTrace_1()
   * @see #getStateEntity_()
   * @generated
   */
  EReference getStateEntity__Trace_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AutoTransition_ <em>Auto Transition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Auto Transition </em>'.
   * @see cruise.umple.umple.AutoTransition_
   * @generated
   */
  EClass getAutoTransition_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AutoTransition_#getAutoTransitionBlock_1 <em>Auto Transition Block 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Auto Transition Block 1</em>'.
   * @see cruise.umple.umple.AutoTransition_#getAutoTransitionBlock_1()
   * @see #getAutoTransition_()
   * @generated
   */
  EReference getAutoTransition__AutoTransitionBlock_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AutoTransition_#getActivity_1 <em>Activity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Activity 1</em>'.
   * @see cruise.umple.umple.AutoTransition_#getActivity_1()
   * @see #getAutoTransition_()
   * @generated
   */
  EReference getAutoTransition__Activity_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AutoTransitionBlock_ <em>Auto Transition Block </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Auto Transition Block </em>'.
   * @see cruise.umple.umple.AutoTransitionBlock_
   * @generated
   */
  EClass getAutoTransitionBlock_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AutoTransitionBlock_#getGuard_1 <em>Guard 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Guard 1</em>'.
   * @see cruise.umple.umple.AutoTransitionBlock_#getGuard_1()
   * @see #getAutoTransitionBlock_()
   * @generated
   */
  EReference getAutoTransitionBlock__Guard_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AutoTransitionBlock_#getAction_1 <em>Action 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Action 1</em>'.
   * @see cruise.umple.umple.AutoTransitionBlock_#getAction_1()
   * @see #getAutoTransitionBlock_()
   * @generated
   */
  EReference getAutoTransitionBlock__Action_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AutoTransitionBlock_#getStateName_1 <em>State Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name 1</em>'.
   * @see cruise.umple.umple.AutoTransitionBlock_#getStateName_1()
   * @see #getAutoTransitionBlock_()
   * @generated
   */
  EAttribute getAutoTransitionBlock__StateName_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Transition_ <em>Transition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition </em>'.
   * @see cruise.umple.umple.Transition_
   * @generated
   */
  EClass getTransition_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Transition_#getGuard_1 <em>Guard 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Guard 1</em>'.
   * @see cruise.umple.umple.Transition_#getGuard_1()
   * @see #getTransition_()
   * @generated
   */
  EReference getTransition__Guard_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Transition_#getEventDefinition_1 <em>Event Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Event Definition 1</em>'.
   * @see cruise.umple.umple.Transition_#getEventDefinition_1()
   * @see #getTransition_()
   * @generated
   */
  EReference getTransition__EventDefinition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Transition_#getAction_1 <em>Action 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Action 1</em>'.
   * @see cruise.umple.umple.Transition_#getAction_1()
   * @see #getTransition_()
   * @generated
   */
  EReference getTransition__Action_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Transition_#getStateName_1 <em>State Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name 1</em>'.
   * @see cruise.umple.umple.Transition_#getStateName_1()
   * @see #getTransition_()
   * @generated
   */
  EAttribute getTransition__StateName_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.EventDefinition_ <em>Event Definition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Definition </em>'.
   * @see cruise.umple.umple.EventDefinition_
   * @generated
   */
  EClass getEventDefinition_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.EventDefinition_#getAfterEveryEvent_1 <em>After Every Event 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>After Every Event 1</em>'.
   * @see cruise.umple.umple.EventDefinition_#getAfterEveryEvent_1()
   * @see #getEventDefinition_()
   * @generated
   */
  EReference getEventDefinition__AfterEveryEvent_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.EventDefinition_#getAfterEvent_1 <em>After Event 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>After Event 1</em>'.
   * @see cruise.umple.umple.EventDefinition_#getAfterEvent_1()
   * @see #getEventDefinition_()
   * @generated
   */
  EReference getEventDefinition__AfterEvent_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.EventDefinition_#getEvent_1 <em>Event 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Event 1</em>'.
   * @see cruise.umple.umple.EventDefinition_#getEvent_1()
   * @see #getEventDefinition_()
   * @generated
   */
  EAttribute getEventDefinition__Event_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.EventDefinition_#getAnonymous_eventDefinition_1_1 <em>Anonymous event Definition 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous event Definition 11</em>'.
   * @see cruise.umple.umple.EventDefinition_#getAnonymous_eventDefinition_1_1()
   * @see #getEventDefinition_()
   * @generated
   */
  EReference getEventDefinition__Anonymous_eventDefinition_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_eventDefinition_1_ <em>Anonymous event Definition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous event Definition 1</em>'.
   * @see cruise.umple.umple.Anonymous_eventDefinition_1_
   * @generated
   */
  EClass getAnonymous_eventDefinition_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_eventDefinition_1_#getParameterList_1 <em>Parameter List 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter List 1</em>'.
   * @see cruise.umple.umple.Anonymous_eventDefinition_1_#getParameterList_1()
   * @see #getAnonymous_eventDefinition_1_()
   * @generated
   */
  EReference getAnonymous_eventDefinition_1__ParameterList_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AfterEveryEvent_ <em>After Every Event </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>After Every Event </em>'.
   * @see cruise.umple.umple.AfterEveryEvent_
   * @generated
   */
  EClass getAfterEveryEvent_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AfterEveryEvent_#getTimer_1 <em>Timer 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timer 1</em>'.
   * @see cruise.umple.umple.AfterEveryEvent_#getTimer_1()
   * @see #getAfterEveryEvent_()
   * @generated
   */
  EAttribute getAfterEveryEvent__Timer_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AfterEvent_ <em>After Event </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>After Event </em>'.
   * @see cruise.umple.umple.AfterEvent_
   * @generated
   */
  EClass getAfterEvent_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AfterEvent_#getTimer_1 <em>Timer 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timer 1</em>'.
   * @see cruise.umple.umple.AfterEvent_#getTimer_1()
   * @see #getAfterEvent_()
   * @generated
   */
  EAttribute getAfterEvent__Timer_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Action_ <em>Action </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action </em>'.
   * @see cruise.umple.umple.Action_
   * @generated
   */
  EClass getAction_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Action_#getAnonymous_action_1_1 <em>Anonymous action 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous action 11</em>'.
   * @see cruise.umple.umple.Action_#getAnonymous_action_1_1()
   * @see #getAction_()
   * @generated
   */
  EReference getAction__Anonymous_action_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Action_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.Action_#getCode_1()
   * @see #getAction_()
   * @generated
   */
  EAttribute getAction__Code_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Action_#getAnonymous_action_2_1 <em>Anonymous action 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous action 21</em>'.
   * @see cruise.umple.umple.Action_#getAnonymous_action_2_1()
   * @see #getAction_()
   * @generated
   */
  EReference getAction__Anonymous_action_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_action_1_ <em>Anonymous action 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous action 1</em>'.
   * @see cruise.umple.umple.Anonymous_action_1_
   * @generated
   */
  EClass getAnonymous_action_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_action_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_action_1_#getCodeLang_1()
   * @see #getAnonymous_action_1_()
   * @generated
   */
  EReference getAnonymous_action_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_action_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_action_1_#getCodeLangs_1()
   * @see #getAnonymous_action_1_()
   * @generated
   */
  EReference getAnonymous_action_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_action_2_ <em>Anonymous action 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous action 2</em>'.
   * @see cruise.umple.umple.Anonymous_action_2_
   * @generated
   */
  EClass getAnonymous_action_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_action_2_#getMoreCode_1 <em>More Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_action_2_#getMoreCode_1()
   * @see #getAnonymous_action_2_()
   * @generated
   */
  EReference getAnonymous_action_2__MoreCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.EntryOrExitAction_ <em>Entry Or Exit Action </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Or Exit Action </em>'.
   * @see cruise.umple.umple.EntryOrExitAction_
   * @generated
   */
  EClass getEntryOrExitAction_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.EntryOrExitAction_#getType_1 <em>Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type 1</em>'.
   * @see cruise.umple.umple.EntryOrExitAction_#getType_1()
   * @see #getEntryOrExitAction_()
   * @generated
   */
  EAttribute getEntryOrExitAction__Type_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.EntryOrExitAction_#getAnonymous_entryOrExitAction_1_1 <em>Anonymous entry Or Exit Action 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous entry Or Exit Action 11</em>'.
   * @see cruise.umple.umple.EntryOrExitAction_#getAnonymous_entryOrExitAction_1_1()
   * @see #getEntryOrExitAction_()
   * @generated
   */
  EReference getEntryOrExitAction__Anonymous_entryOrExitAction_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.EntryOrExitAction_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.EntryOrExitAction_#getCode_1()
   * @see #getEntryOrExitAction_()
   * @generated
   */
  EAttribute getEntryOrExitAction__Code_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.EntryOrExitAction_#getAnonymous_entryOrExitAction_2_1 <em>Anonymous entry Or Exit Action 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous entry Or Exit Action 21</em>'.
   * @see cruise.umple.umple.EntryOrExitAction_#getAnonymous_entryOrExitAction_2_1()
   * @see #getEntryOrExitAction_()
   * @generated
   */
  EReference getEntryOrExitAction__Anonymous_entryOrExitAction_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_entryOrExitAction_1_ <em>Anonymous entry Or Exit Action 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous entry Or Exit Action 1</em>'.
   * @see cruise.umple.umple.Anonymous_entryOrExitAction_1_
   * @generated
   */
  EClass getAnonymous_entryOrExitAction_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_entryOrExitAction_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_entryOrExitAction_1_#getCodeLang_1()
   * @see #getAnonymous_entryOrExitAction_1_()
   * @generated
   */
  EReference getAnonymous_entryOrExitAction_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_entryOrExitAction_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_entryOrExitAction_1_#getCodeLangs_1()
   * @see #getAnonymous_entryOrExitAction_1_()
   * @generated
   */
  EReference getAnonymous_entryOrExitAction_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_entryOrExitAction_2_ <em>Anonymous entry Or Exit Action 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous entry Or Exit Action 2</em>'.
   * @see cruise.umple.umple.Anonymous_entryOrExitAction_2_
   * @generated
   */
  EClass getAnonymous_entryOrExitAction_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_entryOrExitAction_2_#getMoreCode_1 <em>More Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_entryOrExitAction_2_#getMoreCode_1()
   * @see #getAnonymous_entryOrExitAction_2_()
   * @generated
   */
  EReference getAnonymous_entryOrExitAction_2__MoreCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Activity_ <em>Activity </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activity </em>'.
   * @see cruise.umple.umple.Activity_
   * @generated
   */
  EClass getActivity_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Activity_#getAnonymous_activity_1_1 <em>Anonymous activity 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous activity 11</em>'.
   * @see cruise.umple.umple.Activity_#getAnonymous_activity_1_1()
   * @see #getActivity_()
   * @generated
   */
  EReference getActivity__Anonymous_activity_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Activity_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.Activity_#getCode_1()
   * @see #getActivity_()
   * @generated
   */
  EAttribute getActivity__Code_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Activity_#getAnonymous_activity_2_1 <em>Anonymous activity 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous activity 21</em>'.
   * @see cruise.umple.umple.Activity_#getAnonymous_activity_2_1()
   * @see #getActivity_()
   * @generated
   */
  EReference getActivity__Anonymous_activity_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_activity_1_ <em>Anonymous activity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous activity 1</em>'.
   * @see cruise.umple.umple.Anonymous_activity_1_
   * @generated
   */
  EClass getAnonymous_activity_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_activity_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_activity_1_#getCodeLang_1()
   * @see #getAnonymous_activity_1_()
   * @generated
   */
  EReference getAnonymous_activity_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_activity_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_activity_1_#getCodeLangs_1()
   * @see #getAnonymous_activity_1_()
   * @generated
   */
  EReference getAnonymous_activity_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_activity_2_ <em>Anonymous activity 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous activity 2</em>'.
   * @see cruise.umple.umple.Anonymous_activity_2_
   * @generated
   */
  EClass getAnonymous_activity_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_activity_2_#getMoreCode_1 <em>More Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Code 1</em>'.
   * @see cruise.umple.umple.Anonymous_activity_2_#getMoreCode_1()
   * @see #getAnonymous_activity_2_()
   * @generated
   */
  EReference getAnonymous_activity_2__MoreCode_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.MoreGuards_ <em>More Guards </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>More Guards </em>'.
   * @see cruise.umple.umple.MoreGuards_
   * @generated
   */
  EClass getMoreGuards_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.MoreGuards_#getAnonymous_moreGuards_1_1 <em>Anonymous more Guards 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous more Guards 11</em>'.
   * @see cruise.umple.umple.MoreGuards_#getAnonymous_moreGuards_1_1()
   * @see #getMoreGuards_()
   * @generated
   */
  EReference getMoreGuards__Anonymous_moreGuards_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.MoreGuards_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.MoreGuards_#getCode_1()
   * @see #getMoreGuards_()
   * @generated
   */
  EAttribute getMoreGuards__Code_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_moreGuards_1_ <em>Anonymous more Guards 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous more Guards 1</em>'.
   * @see cruise.umple.umple.Anonymous_moreGuards_1_
   * @generated
   */
  EClass getAnonymous_moreGuards_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_moreGuards_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_moreGuards_1_#getCodeLang_1()
   * @see #getAnonymous_moreGuards_1_()
   * @generated
   */
  EReference getAnonymous_moreGuards_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_moreGuards_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_moreGuards_1_#getCodeLangs_1()
   * @see #getAnonymous_moreGuards_1_()
   * @generated
   */
  EReference getAnonymous_moreGuards_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Guard_ <em>Guard </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard </em>'.
   * @see cruise.umple.umple.Guard_
   * @generated
   */
  EClass getGuard_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Guard_#getAnonymous_guard_1_1 <em>Anonymous guard 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous guard 11</em>'.
   * @see cruise.umple.umple.Guard_#getAnonymous_guard_1_1()
   * @see #getGuard_()
   * @generated
   */
  EReference getGuard__Anonymous_guard_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Guard_#getCode_1 <em>Code 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code 1</em>'.
   * @see cruise.umple.umple.Guard_#getCode_1()
   * @see #getGuard_()
   * @generated
   */
  EAttribute getGuard__Code_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Guard_#getAnonymous_guard_2_1 <em>Anonymous guard 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous guard 21</em>'.
   * @see cruise.umple.umple.Guard_#getAnonymous_guard_2_1()
   * @see #getGuard_()
   * @generated
   */
  EReference getGuard__Anonymous_guard_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_guard_1_ <em>Anonymous guard 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous guard 1</em>'.
   * @see cruise.umple.umple.Anonymous_guard_1_
   * @generated
   */
  EClass getAnonymous_guard_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_guard_1_#getCodeLang_1 <em>Code Lang 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Lang 1</em>'.
   * @see cruise.umple.umple.Anonymous_guard_1_#getCodeLang_1()
   * @see #getAnonymous_guard_1_()
   * @generated
   */
  EReference getAnonymous_guard_1__CodeLang_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_guard_1_#getCodeLangs_1 <em>Code Langs 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Code Langs 1</em>'.
   * @see cruise.umple.umple.Anonymous_guard_1_#getCodeLangs_1()
   * @see #getAnonymous_guard_1_()
   * @generated
   */
  EReference getAnonymous_guard_1__CodeLangs_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_guard_2_ <em>Anonymous guard 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous guard 2</em>'.
   * @see cruise.umple.umple.Anonymous_guard_2_
   * @generated
   */
  EClass getAnonymous_guard_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_guard_2_#getMoreGuards_1 <em>More Guards 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Guards 1</em>'.
   * @see cruise.umple.umple.Anonymous_guard_2_#getMoreGuards_1()
   * @see #getAnonymous_guard_2_()
   * @generated
   */
  EReference getAnonymous_guard_2__MoreGuards_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceType_ <em>Trace Type </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Type </em>'.
   * @see cruise.umple.umple.TraceType_
   * @generated
   */
  EClass getTraceType_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceType_#getTracerType_1 <em>Tracer Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tracer Type 1</em>'.
   * @see cruise.umple.umple.TraceType_#getTracerType_1()
   * @see #getTraceType_()
   * @generated
   */
  EAttribute getTraceType__TracerType_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceType_#getAnonymous_traceType_1_1 <em>Anonymous trace Type 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous trace Type 11</em>'.
   * @see cruise.umple.umple.TraceType_#getAnonymous_traceType_1_1()
   * @see #getTraceType_()
   * @generated
   */
  EReference getTraceType__Anonymous_traceType_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceType_#getAnonymous_traceType_2_1 <em>Anonymous trace Type 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous trace Type 21</em>'.
   * @see cruise.umple.umple.TraceType_#getAnonymous_traceType_2_1()
   * @see #getTraceType_()
   * @generated
   */
  EReference getTraceType__Anonymous_traceType_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_traceType_1_ <em>Anonymous trace Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous trace Type 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceType_1_
   * @generated
   */
  EClass getAnonymous_traceType_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_traceType_1_#getVerbisty_1 <em>Verbisty 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Verbisty 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceType_1_#getVerbisty_1()
   * @see #getAnonymous_traceType_1_()
   * @generated
   */
  EAttribute getAnonymous_traceType_1__Verbisty_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_traceType_2_ <em>Anonymous trace Type 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous trace Type 2</em>'.
   * @see cruise.umple.umple.Anonymous_traceType_2_
   * @generated
   */
  EClass getAnonymous_traceType_2_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_traceType_2_#getTracerArgument_1 <em>Tracer Argument 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tracer Argument 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceType_2_#getTracerArgument_1()
   * @see #getAnonymous_traceType_2_()
   * @generated
   */
  EAttribute getAnonymous_traceType_2__TracerArgument_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Trace_ <em>Trace </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace </em>'.
   * @see cruise.umple.umple.Trace_
   * @generated
   */
  EClass getTrace_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Trace_#getTraceDirective_1 <em>Trace Directive 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Directive 1</em>'.
   * @see cruise.umple.umple.Trace_#getTraceDirective_1()
   * @see #getTrace_()
   * @generated
   */
  EReference getTrace__TraceDirective_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Trace_#getTraceCase_1 <em>Trace Case 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Case 1</em>'.
   * @see cruise.umple.umple.Trace_#getTraceCase_1()
   * @see #getTrace_()
   * @generated
   */
  EReference getTrace__TraceCase_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceDirective_ <em>Trace Directive </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Directive </em>'.
   * @see cruise.umple.umple.TraceDirective_
   * @generated
   */
  EClass getTraceDirective_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceDirective_#getTraceItem_1 <em>Trace Item 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Item 1</em>'.
   * @see cruise.umple.umple.TraceDirective_#getTraceItem_1()
   * @see #getTraceDirective_()
   * @generated
   */
  EReference getTraceDirective__TraceItem_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceDirective_#getAnonymous_traceDirective_1_1 <em>Anonymous trace Directive 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous trace Directive 11</em>'.
   * @see cruise.umple.umple.TraceDirective_#getAnonymous_traceDirective_1_1()
   * @see #getTraceDirective_()
   * @generated
   */
  EReference getTraceDirective__Anonymous_traceDirective_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_traceDirective_1_ <em>Anonymous trace Directive 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous trace Directive 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_
   * @generated
   */
  EClass getAnonymous_traceDirective_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceDirective_1_#getExecuteClause_1 <em>Execute Clause 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Execute Clause 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_#getExecuteClause_1()
   * @see #getAnonymous_traceDirective_1_()
   * @generated
   */
  EReference getAnonymous_traceDirective_1__ExecuteClause_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceDirective_1_#getTraceWhen_1 <em>Trace When 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace When 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_#getTraceWhen_1()
   * @see #getAnonymous_traceDirective_1_()
   * @generated
   */
  EReference getAnonymous_traceDirective_1__TraceWhen_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceDirective_1_#getTraceFor_1 <em>Trace For 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace For 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_#getTraceFor_1()
   * @see #getAnonymous_traceDirective_1_()
   * @generated
   */
  EReference getAnonymous_traceDirective_1__TraceFor_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceDirective_1_#getTracePeriod_1 <em>Trace Period 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Period 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_#getTracePeriod_1()
   * @see #getAnonymous_traceDirective_1_()
   * @generated
   */
  EReference getAnonymous_traceDirective_1__TracePeriod_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceDirective_1_#getTraceDuring_1 <em>Trace During 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace During 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_#getTraceDuring_1()
   * @see #getAnonymous_traceDirective_1_()
   * @generated
   */
  EReference getAnonymous_traceDirective_1__TraceDuring_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceDirective_1_#getTraceCaseActivation_1 <em>Trace Case Activation 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Case Activation 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_#getTraceCaseActivation_1()
   * @see #getAnonymous_traceDirective_1_()
   * @generated
   */
  EReference getAnonymous_traceDirective_1__TraceCaseActivation_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceDirective_1_#getTraceRecord_1 <em>Trace Record 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Record 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_#getTraceRecord_1()
   * @see #getAnonymous_traceDirective_1_()
   * @generated
   */
  EReference getAnonymous_traceDirective_1__TraceRecord_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceDirective_1_#getTraceLevel_1 <em>Trace Level 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Level 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceDirective_1_#getTraceLevel_1()
   * @see #getAnonymous_traceDirective_1_()
   * @generated
   */
  EReference getAnonymous_traceDirective_1__TraceLevel_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceItem_ <em>Trace Item </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Item </em>'.
   * @see cruise.umple.umple.TraceItem_
   * @generated
   */
  EClass getTraceItem_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceItem_#getTraceEntity_1 <em>Trace Entity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Entity 1</em>'.
   * @see cruise.umple.umple.TraceItem_#getTraceEntity_1()
   * @see #getTraceItem_()
   * @generated
   */
  EReference getTraceItem__TraceEntity_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceItem_#getPreOrPostCondition_1 <em>Pre Or Post Condition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Pre Or Post Condition 1</em>'.
   * @see cruise.umple.umple.TraceItem_#getPreOrPostCondition_1()
   * @see #getTraceItem_()
   * @generated
   */
  EReference getTraceItem__PreOrPostCondition_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceEntity_ <em>Trace Entity </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Entity </em>'.
   * @see cruise.umple.umple.TraceEntity_
   * @generated
   */
  EClass getTraceEntity_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceEntity_#getTraceOptions_1 <em>Trace Options 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Options 1</em>'.
   * @see cruise.umple.umple.TraceEntity_#getTraceOptions_1()
   * @see #getTraceEntity_()
   * @generated
   */
  EReference getTraceEntity__TraceOptions_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceEntity_#getTrace_entity_1 <em>Trace entity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace entity 1</em>'.
   * @see cruise.umple.umple.TraceEntity_#getTrace_entity_1()
   * @see #getTraceEntity_()
   * @generated
   */
  EAttribute getTraceEntity__Trace_entity_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceEntity_#getAnonymous_traceEntity_1_1 <em>Anonymous trace Entity 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous trace Entity 11</em>'.
   * @see cruise.umple.umple.TraceEntity_#getAnonymous_traceEntity_1_1()
   * @see #getTraceEntity_()
   * @generated
   */
  EReference getTraceEntity__Anonymous_traceEntity_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_traceEntity_1_ <em>Anonymous trace Entity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous trace Entity 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceEntity_1_
   * @generated
   */
  EClass getAnonymous_traceEntity_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_traceEntity_1_#getTrace_entity_1 <em>Trace entity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace entity 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceEntity_1_#getTrace_entity_1()
   * @see #getAnonymous_traceEntity_1_()
   * @generated
   */
  EAttribute getAnonymous_traceEntity_1__Trace_entity_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceOptions_ <em>Trace Options </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Options </em>'.
   * @see cruise.umple.umple.TraceOptions_
   * @generated
   */
  EClass getTraceOptions_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceOptions_#getTraceOption_1 <em>Trace Option 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Option 1</em>'.
   * @see cruise.umple.umple.TraceOptions_#getTraceOption_1()
   * @see #getTraceOptions_()
   * @generated
   */
  EReference getTraceOptions__TraceOption_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceOptions_#getAnonymous_traceOptions_1_1 <em>Anonymous trace Options 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous trace Options 11</em>'.
   * @see cruise.umple.umple.TraceOptions_#getAnonymous_traceOptions_1_1()
   * @see #getTraceOptions_()
   * @generated
   */
  EReference getTraceOptions__Anonymous_traceOptions_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_traceOptions_1_ <em>Anonymous trace Options 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous trace Options 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceOptions_1_
   * @generated
   */
  EClass getAnonymous_traceOptions_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_traceOptions_1_#getTraceOption_1 <em>Trace Option 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Option 1</em>'.
   * @see cruise.umple.umple.Anonymous_traceOptions_1_#getTraceOption_1()
   * @see #getAnonymous_traceOptions_1_()
   * @generated
   */
  EReference getAnonymous_traceOptions_1__TraceOption_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceOption_ <em>Trace Option </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Option </em>'.
   * @see cruise.umple.umple.TraceOption_
   * @generated
   */
  EClass getTraceOption_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceOption_#getOption_1 <em>Option 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Option 1</em>'.
   * @see cruise.umple.umple.TraceOption_#getOption_1()
   * @see #getTraceOption_()
   * @generated
   */
  EAttribute getTraceOption__Option_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.PreOrPostCondition_ <em>Pre Or Post Condition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pre Or Post Condition </em>'.
   * @see cruise.umple.umple.PreOrPostCondition_
   * @generated
   */
  EClass getPreOrPostCondition_();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.PreOrPostCondition_#getAnonymous_PreOrPostCondition_1_1 <em>Anonymous Pre Or Post Condition 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Anonymous Pre Or Post Condition 11</em>'.
   * @see cruise.umple.umple.PreOrPostCondition_#getAnonymous_PreOrPostCondition_1_1()
   * @see #getPreOrPostCondition_()
   * @generated
   */
  EAttribute getPreOrPostCondition__Anonymous_PreOrPostCondition_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.PreOrPostCondition_#getTraceCondition_1 <em>Trace Condition 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Condition 1</em>'.
   * @see cruise.umple.umple.PreOrPostCondition_#getTraceCondition_1()
   * @see #getPreOrPostCondition_()
   * @generated
   */
  EReference getPreOrPostCondition__TraceCondition_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ExecuteClause_ <em>Execute Clause </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execute Clause </em>'.
   * @see cruise.umple.umple.ExecuteClause_
   * @generated
   */
  EClass getExecuteClause_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ExecuteClause_#getTrace_execute_1 <em>Trace execute 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace execute 1</em>'.
   * @see cruise.umple.umple.ExecuteClause_#getTrace_execute_1()
   * @see #getExecuteClause_()
   * @generated
   */
  EAttribute getExecuteClause__Trace_execute_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceWhen_ <em>Trace When </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace When </em>'.
   * @see cruise.umple.umple.TraceWhen_
   * @generated
   */
  EClass getTraceWhen_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceWhen_#getConditionType_1 <em>Condition Type 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Condition Type 1</em>'.
   * @see cruise.umple.umple.TraceWhen_#getConditionType_1()
   * @see #getTraceWhen_()
   * @generated
   */
  EAttribute getTraceWhen__ConditionType_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceWhen_#getConstraintToken_1 <em>Constraint Token 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Token 1</em>'.
   * @see cruise.umple.umple.TraceWhen_#getConstraintToken_1()
   * @see #getTraceWhen_()
   * @generated
   */
  EReference getTraceWhen__ConstraintToken_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceFor_ <em>Trace For </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace For </em>'.
   * @see cruise.umple.umple.TraceFor_
   * @generated
   */
  EClass getTraceFor_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceFor_#getTrace_for_1 <em>Trace for 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace for 1</em>'.
   * @see cruise.umple.umple.TraceFor_#getTrace_for_1()
   * @see #getTraceFor_()
   * @generated
   */
  EAttribute getTraceFor__Trace_for_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceLevel_ <em>Trace Level </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Level </em>'.
   * @see cruise.umple.umple.TraceLevel_
   * @generated
   */
  EClass getTraceLevel_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceLevel_#getTrace_level_1 <em>Trace level 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace level 1</em>'.
   * @see cruise.umple.umple.TraceLevel_#getTrace_level_1()
   * @see #getTraceLevel_()
   * @generated
   */
  EAttribute getTraceLevel__Trace_level_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TracePeriod_ <em>Trace Period </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Period </em>'.
   * @see cruise.umple.umple.TracePeriod_
   * @generated
   */
  EClass getTracePeriod_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TracePeriod_#getTrace_period_1 <em>Trace period 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace period 1</em>'.
   * @see cruise.umple.umple.TracePeriod_#getTrace_period_1()
   * @see #getTracePeriod_()
   * @generated
   */
  EAttribute getTracePeriod__Trace_period_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceDuring_ <em>Trace During </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace During </em>'.
   * @see cruise.umple.umple.TraceDuring_
   * @generated
   */
  EClass getTraceDuring_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceDuring_#getTrace_duration_1 <em>Trace duration 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace duration 1</em>'.
   * @see cruise.umple.umple.TraceDuring_#getTrace_duration_1()
   * @see #getTraceDuring_()
   * @generated
   */
  EAttribute getTraceDuring__Trace_duration_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceRecord_ <em>Trace Record </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Record </em>'.
   * @see cruise.umple.umple.TraceRecord_
   * @generated
   */
  EClass getTraceRecord_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceRecord_#getRecordEntity_1 <em>Record Entity 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Record Entity 1</em>'.
   * @see cruise.umple.umple.TraceRecord_#getRecordEntity_1()
   * @see #getTraceRecord_()
   * @generated
   */
  EReference getTraceRecord__RecordEntity_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.RecordEntity_ <em>Record Entity </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Entity </em>'.
   * @see cruise.umple.umple.RecordEntity_
   * @generated
   */
  EClass getRecordEntity_();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.RecordEntity_#getAnonymous_recordEntity_1_1 <em>Anonymous record Entity 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Anonymous record Entity 11</em>'.
   * @see cruise.umple.umple.RecordEntity_#getAnonymous_recordEntity_1_1()
   * @see #getRecordEntity_()
   * @generated
   */
  EAttribute getRecordEntity__Anonymous_recordEntity_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.RecordEntity_#getTrace_record_1 <em>Trace record 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace record 1</em>'.
   * @see cruise.umple.umple.RecordEntity_#getTrace_record_1()
   * @see #getRecordEntity_()
   * @generated
   */
  EAttribute getRecordEntity__Trace_record_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.RecordEntity_#getAnonymous_recordEntity_2_1 <em>Anonymous record Entity 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous record Entity 21</em>'.
   * @see cruise.umple.umple.RecordEntity_#getAnonymous_recordEntity_2_1()
   * @see #getRecordEntity_()
   * @generated
   */
  EReference getRecordEntity__Anonymous_recordEntity_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_recordEntity_2_ <em>Anonymous record Entity 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous record Entity 2</em>'.
   * @see cruise.umple.umple.Anonymous_recordEntity_2_
   * @generated
   */
  EClass getAnonymous_recordEntity_2_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_recordEntity_2_#getTrace_record_1 <em>Trace record 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace record 1</em>'.
   * @see cruise.umple.umple.Anonymous_recordEntity_2_#getTrace_record_1()
   * @see #getAnonymous_recordEntity_2_()
   * @generated
   */
  EAttribute getAnonymous_recordEntity_2__Trace_record_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceCondition_ <em>Trace Condition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Condition </em>'.
   * @see cruise.umple.umple.TraceCondition_
   * @generated
   */
  EClass getTraceCondition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceCondition_#getLHS_1 <em>LHS 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>LHS 1</em>'.
   * @see cruise.umple.umple.TraceCondition_#getLHS_1()
   * @see #getTraceCondition_()
   * @generated
   */
  EAttribute getTraceCondition__LHS_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceCondition_#getConditionRHS_1 <em>Condition RHS 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Condition RHS 1</em>'.
   * @see cruise.umple.umple.TraceCondition_#getConditionRHS_1()
   * @see #getTraceCondition_()
   * @generated
   */
  EReference getTraceCondition__ConditionRHS_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ConditionRHS_ <em>Condition RHS </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition RHS </em>'.
   * @see cruise.umple.umple.ConditionRHS_
   * @generated
   */
  EClass getConditionRHS_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ConditionRHS_#getComparison_operator_1 <em>Comparison operator 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Comparison operator 1</em>'.
   * @see cruise.umple.umple.ConditionRHS_#getComparison_operator_1()
   * @see #getConditionRHS_()
   * @generated
   */
  EAttribute getConditionRHS__Comparison_operator_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ConditionRHS_#getRHS_1 <em>RHS 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>RHS 1</em>'.
   * @see cruise.umple.umple.ConditionRHS_#getRHS_1()
   * @see #getConditionRHS_()
   * @generated
   */
  EAttribute getConditionRHS__RHS_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceCase_ <em>Trace Case </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Case </em>'.
   * @see cruise.umple.umple.TraceCase_
   * @generated
   */
  EClass getTraceCase_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceCase_#getTraceCaseDef_1 <em>Trace Case Def 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Case Def 1</em>'.
   * @see cruise.umple.umple.TraceCase_#getTraceCaseDef_1()
   * @see #getTraceCase_()
   * @generated
   */
  EReference getTraceCase__TraceCaseDef_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceCase_#getTraceCaseActivation_1 <em>Trace Case Activation 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Case Activation 1</em>'.
   * @see cruise.umple.umple.TraceCase_#getTraceCaseActivation_1()
   * @see #getTraceCase_()
   * @generated
   */
  EReference getTraceCase__TraceCaseActivation_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceCase_#getTraceCaseDeactivation_1 <em>Trace Case Deactivation 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Case Deactivation 1</em>'.
   * @see cruise.umple.umple.TraceCase_#getTraceCaseDeactivation_1()
   * @see #getTraceCase_()
   * @generated
   */
  EReference getTraceCase__TraceCaseDeactivation_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceCaseDef_ <em>Trace Case Def </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Case Def </em>'.
   * @see cruise.umple.umple.TraceCaseDef_
   * @generated
   */
  EClass getTraceCaseDef_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceCaseDef_#getTracecase_name_1 <em>Tracecase name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tracecase name 1</em>'.
   * @see cruise.umple.umple.TraceCaseDef_#getTracecase_name_1()
   * @see #getTraceCaseDef_()
   * @generated
   */
  EAttribute getTraceCaseDef__Tracecase_name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceCaseDef_#getTraceDirective_1 <em>Trace Directive 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Directive 1</em>'.
   * @see cruise.umple.umple.TraceCaseDef_#getTraceDirective_1()
   * @see #getTraceCaseDef_()
   * @generated
   */
  EReference getTraceCaseDef__TraceDirective_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceCaseActivation_ <em>Trace Case Activation </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Case Activation </em>'.
   * @see cruise.umple.umple.TraceCaseActivation_
   * @generated
   */
  EClass getTraceCaseActivation_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceCaseActivation_#getTracecase_act_name_1 <em>Tracecase act name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tracecase act name 1</em>'.
   * @see cruise.umple.umple.TraceCaseActivation_#getTracecase_act_name_1()
   * @see #getTraceCaseActivation_()
   * @generated
   */
  EAttribute getTraceCaseActivation__Tracecase_act_name_1();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.TraceCaseActivation_#getAnonymous_traceCaseActivation_1_1 <em>Anonymous trace Case Activation 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Anonymous trace Case Activation 11</em>'.
   * @see cruise.umple.umple.TraceCaseActivation_#getAnonymous_traceCaseActivation_1_1()
   * @see #getTraceCaseActivation_()
   * @generated
   */
  EAttribute getTraceCaseActivation__Anonymous_traceCaseActivation_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceCaseDeactivation_ <em>Trace Case Deactivation </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Case Deactivation </em>'.
   * @see cruise.umple.umple.TraceCaseDeactivation_
   * @generated
   */
  EClass getTraceCaseDeactivation_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceCaseDeactivation_#getTracecase_deact_name_1 <em>Tracecase deact name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tracecase deact name 1</em>'.
   * @see cruise.umple.umple.TraceCaseDeactivation_#getTracecase_deact_name_1()
   * @see #getTraceCaseDeactivation_()
   * @generated
   */
  EAttribute getTraceCaseDeactivation__Tracecase_deact_name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceCaseDeactivation_#getDeActivateFor_1 <em>De Activate For 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>De Activate For 1</em>'.
   * @see cruise.umple.umple.TraceCaseDeactivation_#getDeActivateFor_1()
   * @see #getTraceCaseDeactivation_()
   * @generated
   */
  EReference getTraceCaseDeactivation__DeActivateFor_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.DeActivateFor_ <em>De Activate For </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>De Activate For </em>'.
   * @see cruise.umple.umple.DeActivateFor_
   * @generated
   */
  EClass getDeActivateFor_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.DeActivateFor_#getDeactivate_for_1 <em>Deactivate for 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Deactivate for 1</em>'.
   * @see cruise.umple.umple.DeActivateFor_#getDeactivate_for_1()
   * @see #getDeActivateFor_()
   * @generated
   */
  EAttribute getDeActivateFor__Deactivate_for_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Precondition_ <em>Precondition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Precondition </em>'.
   * @see cruise.umple.umple.Precondition_
   * @generated
   */
  EClass getPrecondition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Precondition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.Precondition_#getName_1()
   * @see #getPrecondition_()
   * @generated
   */
  EAttribute getPrecondition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Precondition_#getConstraint_1 <em>Constraint 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint 1</em>'.
   * @see cruise.umple.umple.Precondition_#getConstraint_1()
   * @see #getPrecondition_()
   * @generated
   */
  EReference getPrecondition__Constraint_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Postcondition_ <em>Postcondition </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Postcondition </em>'.
   * @see cruise.umple.umple.Postcondition_
   * @generated
   */
  EClass getPostcondition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Postcondition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.Postcondition_#getName_1()
   * @see #getPostcondition_()
   * @generated
   */
  EAttribute getPostcondition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Postcondition_#getConstraint_1 <em>Constraint 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint 1</em>'.
   * @see cruise.umple.umple.Postcondition_#getConstraint_1()
   * @see #getPostcondition_()
   * @generated
   */
  EReference getPostcondition__Constraint_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Invariant_ <em>Invariant </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invariant </em>'.
   * @see cruise.umple.umple.Invariant_
   * @generated
   */
  EClass getInvariant_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Invariant_#getAnonymous_invariant_1_1 <em>Anonymous invariant 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous invariant 11</em>'.
   * @see cruise.umple.umple.Invariant_#getAnonymous_invariant_1_1()
   * @see #getInvariant_()
   * @generated
   */
  EReference getInvariant__Anonymous_invariant_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Invariant_#getAnonymous_invariant_2_1 <em>Anonymous invariant 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous invariant 21</em>'.
   * @see cruise.umple.umple.Invariant_#getAnonymous_invariant_2_1()
   * @see #getInvariant_()
   * @generated
   */
  EReference getInvariant__Anonymous_invariant_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_invariant_1_ <em>Anonymous invariant 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous invariant 1</em>'.
   * @see cruise.umple.umple.Anonymous_invariant_1_
   * @generated
   */
  EClass getAnonymous_invariant_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_invariant_1_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.Anonymous_invariant_1_#getName_1()
   * @see #getAnonymous_invariant_1_()
   * @generated
   */
  EAttribute getAnonymous_invariant_1__Name_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_invariant_2_ <em>Anonymous invariant 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous invariant 2</em>'.
   * @see cruise.umple.umple.Anonymous_invariant_2_
   * @generated
   */
  EClass getAnonymous_invariant_2_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_invariant_2_#getConstraint_1 <em>Constraint 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint 1</em>'.
   * @see cruise.umple.umple.Anonymous_invariant_2_#getConstraint_1()
   * @see #getAnonymous_invariant_2_()
   * @generated
   */
  EReference getAnonymous_invariant_2__Constraint_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ConstraintToken_ <em>Constraint Token </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint Token </em>'.
   * @see cruise.umple.umple.ConstraintToken_
   * @generated
   */
  EClass getConstraintToken_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintToken_#getConstraint_1 <em>Constraint 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint 1</em>'.
   * @see cruise.umple.umple.ConstraintToken_#getConstraint_1()
   * @see #getConstraintToken_()
   * @generated
   */
  EReference getConstraintToken__Constraint_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Constraint_ <em>Constraint </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint </em>'.
   * @see cruise.umple.umple.Constraint_
   * @generated
   */
  EClass getConstraint_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Constraint_#getAnonymous_constraint_1_1 <em>Anonymous constraint 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous constraint 11</em>'.
   * @see cruise.umple.umple.Constraint_#getAnonymous_constraint_1_1()
   * @see #getConstraint_()
   * @generated
   */
  EReference getConstraint__Anonymous_constraint_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Constraint_#getConstraintBody_1 <em>Constraint Body 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Body 1</em>'.
   * @see cruise.umple.umple.Constraint_#getConstraintBody_1()
   * @see #getConstraint_()
   * @generated
   */
  EReference getConstraint__ConstraintBody_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_constraint_1_ <em>Anonymous constraint 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous constraint 1</em>'.
   * @see cruise.umple.umple.Anonymous_constraint_1_
   * @generated
   */
  EClass getAnonymous_constraint_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_constraint_1_#getConstraintBody_1 <em>Constraint Body 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Body 1</em>'.
   * @see cruise.umple.umple.Anonymous_constraint_1_#getConstraintBody_1()
   * @see #getAnonymous_constraint_1_()
   * @generated
   */
  EReference getAnonymous_constraint_1__ConstraintBody_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.NegativeConstraint_ <em>Negative Constraint </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Negative Constraint </em>'.
   * @see cruise.umple.umple.NegativeConstraint_
   * @generated
   */
  EClass getNegativeConstraint_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.NegativeConstraint_#getConstraint_1 <em>Constraint 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint 1</em>'.
   * @see cruise.umple.umple.NegativeConstraint_#getConstraint_1()
   * @see #getNegativeConstraint_()
   * @generated
   */
  EReference getNegativeConstraint__Constraint_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ConstraintBody_ <em>Constraint Body </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint Body </em>'.
   * @see cruise.umple.umple.ConstraintBody_
   * @generated
   */
  EClass getConstraintBody_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintBody_#getConstraintExpr_1 <em>Constraint Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Expr 1</em>'.
   * @see cruise.umple.umple.ConstraintBody_#getConstraintExpr_1()
   * @see #getConstraintBody_()
   * @generated
   */
  EReference getConstraintBody__ConstraintExpr_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintBody_#getAnonymous_constraintBody_1_1 <em>Anonymous constraint Body 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous constraint Body 11</em>'.
   * @see cruise.umple.umple.ConstraintBody_#getAnonymous_constraintBody_1_1()
   * @see #getConstraintBody_()
   * @generated
   */
  EReference getConstraintBody__Anonymous_constraintBody_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_constraintBody_1_ <em>Anonymous constraint Body 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous constraint Body 1</em>'.
   * @see cruise.umple.umple.Anonymous_constraintBody_1_
   * @generated
   */
  EClass getAnonymous_constraintBody_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_constraintBody_1_#getLinkingOp_1 <em>Linking Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Linking Op 1</em>'.
   * @see cruise.umple.umple.Anonymous_constraintBody_1_#getLinkingOp_1()
   * @see #getAnonymous_constraintBody_1_()
   * @generated
   */
  EReference getAnonymous_constraintBody_1__LinkingOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.LinkingOp_ <em>Linking Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Linking Op </em>'.
   * @see cruise.umple.umple.LinkingOp_
   * @generated
   */
  EClass getLinkingOp_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.LinkingOp_#getAnonymous_linkingOp_1_1 <em>Anonymous linking Op 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous linking Op 11</em>'.
   * @see cruise.umple.umple.LinkingOp_#getAnonymous_linkingOp_1_1()
   * @see #getLinkingOp_()
   * @generated
   */
  EReference getLinkingOp__Anonymous_linkingOp_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.LinkingOp_#getAnonymous_linkingOp_2_1 <em>Anonymous linking Op 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous linking Op 21</em>'.
   * @see cruise.umple.umple.LinkingOp_#getAnonymous_linkingOp_2_1()
   * @see #getLinkingOp_()
   * @generated
   */
  EReference getLinkingOp__Anonymous_linkingOp_2_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.LinkingOp_#getAnonymous_linkingOp_3_1 <em>Anonymous linking Op 31</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous linking Op 31</em>'.
   * @see cruise.umple.umple.LinkingOp_#getAnonymous_linkingOp_3_1()
   * @see #getLinkingOp_()
   * @generated
   */
  EReference getLinkingOp__Anonymous_linkingOp_3_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_linkingOp_1_ <em>Anonymous linking Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous linking Op 1</em>'.
   * @see cruise.umple.umple.Anonymous_linkingOp_1_
   * @generated
   */
  EClass getAnonymous_linkingOp_1_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_linkingOp_1_#getConstraintExpr_1 <em>Constraint Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Expr 1</em>'.
   * @see cruise.umple.umple.Anonymous_linkingOp_1_#getConstraintExpr_1()
   * @see #getAnonymous_linkingOp_1_()
   * @generated
   */
  EReference getAnonymous_linkingOp_1__ConstraintExpr_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_linkingOp_2_ <em>Anonymous linking Op 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous linking Op 2</em>'.
   * @see cruise.umple.umple.Anonymous_linkingOp_2_
   * @generated
   */
  EClass getAnonymous_linkingOp_2_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_linkingOp_2_#getAndOp_1 <em>And Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>And Op 1</em>'.
   * @see cruise.umple.umple.Anonymous_linkingOp_2_#getAndOp_1()
   * @see #getAnonymous_linkingOp_2_()
   * @generated
   */
  EAttribute getAnonymous_linkingOp_2__AndOp_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_linkingOp_2_#getConstraintExpr_1 <em>Constraint Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Expr 1</em>'.
   * @see cruise.umple.umple.Anonymous_linkingOp_2_#getConstraintExpr_1()
   * @see #getAnonymous_linkingOp_2_()
   * @generated
   */
  EReference getAnonymous_linkingOp_2__ConstraintExpr_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_linkingOp_3_ <em>Anonymous linking Op 3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous linking Op 3</em>'.
   * @see cruise.umple.umple.Anonymous_linkingOp_3_
   * @generated
   */
  EClass getAnonymous_linkingOp_3_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_linkingOp_3_#getOrOp_1 <em>Or Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Or Op 1</em>'.
   * @see cruise.umple.umple.Anonymous_linkingOp_3_#getOrOp_1()
   * @see #getAnonymous_linkingOp_3_()
   * @generated
   */
  EAttribute getAnonymous_linkingOp_3__OrOp_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Anonymous_linkingOp_3_#getConstraintExpr_1 <em>Constraint Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constraint Expr 1</em>'.
   * @see cruise.umple.umple.Anonymous_linkingOp_3_#getConstraintExpr_1()
   * @see #getAnonymous_linkingOp_3_()
   * @generated
   */
  EReference getAnonymous_linkingOp_3__ConstraintExpr_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ConstraintExpr_ <em>Constraint Expr </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint Expr </em>'.
   * @see cruise.umple.umple.ConstraintExpr_
   * @generated
   */
  EClass getConstraintExpr_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintExpr_#getNegativeConstraint_1 <em>Negative Constraint 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Negative Constraint 1</em>'.
   * @see cruise.umple.umple.ConstraintExpr_#getNegativeConstraint_1()
   * @see #getConstraintExpr_()
   * @generated
   */
  EReference getConstraintExpr__NegativeConstraint_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintExpr_#getStringExpr_1 <em>String Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>String Expr 1</em>'.
   * @see cruise.umple.umple.ConstraintExpr_#getStringExpr_1()
   * @see #getConstraintExpr_()
   * @generated
   */
  EReference getConstraintExpr__StringExpr_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintExpr_#getBoolExpr_1 <em>Bool Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bool Expr 1</em>'.
   * @see cruise.umple.umple.ConstraintExpr_#getBoolExpr_1()
   * @see #getConstraintExpr_()
   * @generated
   */
  EReference getConstraintExpr__BoolExpr_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintExpr_#getGenExpr_1 <em>Gen Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Expr 1</em>'.
   * @see cruise.umple.umple.ConstraintExpr_#getGenExpr_1()
   * @see #getConstraintExpr_()
   * @generated
   */
  EReference getConstraintExpr__GenExpr_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintExpr_#getNumExpr_1 <em>Num Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Num Expr 1</em>'.
   * @see cruise.umple.umple.ConstraintExpr_#getNumExpr_1()
   * @see #getConstraintExpr_()
   * @generated
   */
  EReference getConstraintExpr__NumExpr_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ConstraintExpr_#getLoneBoolean_1 <em>Lone Boolean 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lone Boolean 1</em>'.
   * @see cruise.umple.umple.ConstraintExpr_#getLoneBoolean_1()
   * @see #getConstraintExpr_()
   * @generated
   */
  EAttribute getConstraintExpr__LoneBoolean_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ConstraintExpr_#getAnonymous_constraintExpr_1_1 <em>Anonymous constraint Expr 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous constraint Expr 11</em>'.
   * @see cruise.umple.umple.ConstraintExpr_#getAnonymous_constraintExpr_1_1()
   * @see #getConstraintExpr_()
   * @generated
   */
  EReference getConstraintExpr__Anonymous_constraintExpr_1_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_constraintExpr_1_ <em>Anonymous constraint Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous constraint Expr 1</em>'.
   * @see cruise.umple.umple.Anonymous_constraintExpr_1_
   * @generated
   */
  EClass getAnonymous_constraintExpr_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_constraintExpr_1_#getIndex_1 <em>Index 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index 1</em>'.
   * @see cruise.umple.umple.Anonymous_constraintExpr_1_#getIndex_1()
   * @see #getAnonymous_constraintExpr_1_()
   * @generated
   */
  EAttribute getAnonymous_constraintExpr_1__Index_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.CompoundExpr_ <em>Compound Expr </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compound Expr </em>'.
   * @see cruise.umple.umple.CompoundExpr_
   * @generated
   */
  EClass getCompoundExpr_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.CompoundExpr_#getStringExpr_1 <em>String Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>String Expr 1</em>'.
   * @see cruise.umple.umple.CompoundExpr_#getStringExpr_1()
   * @see #getCompoundExpr_()
   * @generated
   */
  EReference getCompoundExpr__StringExpr_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.CompoundExpr_#getBoolExpr_1 <em>Bool Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bool Expr 1</em>'.
   * @see cruise.umple.umple.CompoundExpr_#getBoolExpr_1()
   * @see #getCompoundExpr_()
   * @generated
   */
  EReference getCompoundExpr__BoolExpr_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.CompoundExpr_#getNumExpr_1 <em>Num Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Num Expr 1</em>'.
   * @see cruise.umple.umple.CompoundExpr_#getNumExpr_1()
   * @see #getCompoundExpr_()
   * @generated
   */
  EReference getCompoundExpr__NumExpr_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.CompoundExpr_#getGenExpr_1 <em>Gen Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Gen Expr 1</em>'.
   * @see cruise.umple.umple.CompoundExpr_#getGenExpr_1()
   * @see #getCompoundExpr_()
   * @generated
   */
  EReference getCompoundExpr__GenExpr_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.BoolExpr_ <em>Bool Expr </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Expr </em>'.
   * @see cruise.umple.umple.BoolExpr_
   * @generated
   */
  EClass getBoolExpr_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.BoolExpr_#getLiteral_1 <em>Literal 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Literal 1</em>'.
   * @see cruise.umple.umple.BoolExpr_#getLiteral_1()
   * @see #getBoolExpr_()
   * @generated
   */
  EAttribute getBoolExpr__Literal_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.BoolExpr_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.BoolExpr_#getName_1()
   * @see #getBoolExpr_()
   * @generated
   */
  EAttribute getBoolExpr__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.BoolExpr_#getEqualityOp_1 <em>Equality Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Equality Op 1</em>'.
   * @see cruise.umple.umple.BoolExpr_#getEqualityOp_1()
   * @see #getBoolExpr_()
   * @generated
   */
  EReference getBoolExpr__EqualityOp_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.BoolExpr_#getIndex_1 <em>Index 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index 1</em>'.
   * @see cruise.umple.umple.BoolExpr_#getIndex_1()
   * @see #getBoolExpr_()
   * @generated
   */
  EAttribute getBoolExpr__Index_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StringExpr_ <em>String Expr </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Expr </em>'.
   * @see cruise.umple.umple.StringExpr_
   * @generated
   */
  EClass getStringExpr_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.StringExpr_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.StringExpr_#getName_1()
   * @see #getStringExpr_()
   * @generated
   */
  EAttribute getStringExpr__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StringExpr_#getEqualityOp_1 <em>Equality Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Equality Op 1</em>'.
   * @see cruise.umple.umple.StringExpr_#getEqualityOp_1()
   * @see #getStringExpr_()
   * @generated
   */
  EReference getStringExpr__EqualityOp_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StringExpr_#getStringLit_1 <em>String Lit 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>String Lit 1</em>'.
   * @see cruise.umple.umple.StringExpr_#getStringLit_1()
   * @see #getStringExpr_()
   * @generated
   */
  EReference getStringExpr__StringLit_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.StringExpr_#getIndex_1 <em>Index 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index 1</em>'.
   * @see cruise.umple.umple.StringExpr_#getIndex_1()
   * @see #getStringExpr_()
   * @generated
   */
  EAttribute getStringExpr__Index_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StringLit_ <em>String Lit </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Lit </em>'.
   * @see cruise.umple.umple.StringLit_
   * @generated
   */
  EClass getStringLit_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.StringLit_#getQuote_1 <em>Quote 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quote 1</em>'.
   * @see cruise.umple.umple.StringLit_#getQuote_1()
   * @see #getStringLit_()
   * @generated
   */
  EAttribute getStringLit__Quote_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.GenExpr_ <em>Gen Expr </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gen Expr </em>'.
   * @see cruise.umple.umple.GenExpr_
   * @generated
   */
  EClass getGenExpr_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.GenExpr_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.GenExpr_#getName_1()
   * @see #getGenExpr_()
   * @generated
   */
  EAttribute getGenExpr__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.GenExpr_#getAnonymous_genExpr_1_1 <em>Anonymous gen Expr 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous gen Expr 11</em>'.
   * @see cruise.umple.umple.GenExpr_#getAnonymous_genExpr_1_1()
   * @see #getGenExpr_()
   * @generated
   */
  EReference getGenExpr__Anonymous_genExpr_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.GenExpr_#getEqualityOp_1 <em>Equality Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Equality Op 1</em>'.
   * @see cruise.umple.umple.GenExpr_#getEqualityOp_1()
   * @see #getGenExpr_()
   * @generated
   */
  EReference getGenExpr__EqualityOp_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.GenExpr_#getName_2 <em>Name 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 2</em>'.
   * @see cruise.umple.umple.GenExpr_#getName_2()
   * @see #getGenExpr_()
   * @generated
   */
  EAttribute getGenExpr__Name_2();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.GenExpr_#getAnonymous_genExpr_2_1 <em>Anonymous gen Expr 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous gen Expr 21</em>'.
   * @see cruise.umple.umple.GenExpr_#getAnonymous_genExpr_2_1()
   * @see #getGenExpr_()
   * @generated
   */
  EReference getGenExpr__Anonymous_genExpr_2_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_genExpr_1_ <em>Anonymous gen Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous gen Expr 1</em>'.
   * @see cruise.umple.umple.Anonymous_genExpr_1_
   * @generated
   */
  EClass getAnonymous_genExpr_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_genExpr_1_#getIndex_1 <em>Index 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index 1</em>'.
   * @see cruise.umple.umple.Anonymous_genExpr_1_#getIndex_1()
   * @see #getAnonymous_genExpr_1_()
   * @generated
   */
  EAttribute getAnonymous_genExpr_1__Index_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_genExpr_2_ <em>Anonymous gen Expr 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous gen Expr 2</em>'.
   * @see cruise.umple.umple.Anonymous_genExpr_2_
   * @generated
   */
  EClass getAnonymous_genExpr_2_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_genExpr_2_#getIndex_1 <em>Index 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index 1</em>'.
   * @see cruise.umple.umple.Anonymous_genExpr_2_#getIndex_1()
   * @see #getAnonymous_genExpr_2_()
   * @generated
   */
  EAttribute getAnonymous_genExpr_2__Index_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.NumExpr_ <em>Num Expr </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Num Expr </em>'.
   * @see cruise.umple.umple.NumExpr_
   * @generated
   */
  EClass getNumExpr_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.NumExpr_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.NumExpr_#getName_1()
   * @see #getNumExpr_()
   * @generated
   */
  EAttribute getNumExpr__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.NumExpr_#getAnonymous_numExpr_1_1 <em>Anonymous num Expr 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous num Expr 11</em>'.
   * @see cruise.umple.umple.NumExpr_#getAnonymous_numExpr_1_1()
   * @see #getNumExpr_()
   * @generated
   */
  EReference getNumExpr__Anonymous_numExpr_1_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.NumExpr_#getAnonymous_numExpr_2_1 <em>Anonymous num Expr 21</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous num Expr 21</em>'.
   * @see cruise.umple.umple.NumExpr_#getAnonymous_numExpr_2_1()
   * @see #getNumExpr_()
   * @generated
   */
  EReference getNumExpr__Anonymous_numExpr_2_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.NumExpr_#getOrdinalOp_1 <em>Ordinal Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ordinal Op 1</em>'.
   * @see cruise.umple.umple.NumExpr_#getOrdinalOp_1()
   * @see #getNumExpr_()
   * @generated
   */
  EReference getNumExpr__OrdinalOp_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.NumExpr_#getName_2 <em>Name 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 2</em>'.
   * @see cruise.umple.umple.NumExpr_#getName_2()
   * @see #getNumExpr_()
   * @generated
   */
  EAttribute getNumExpr__Name_2();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.NumExpr_#getAnonymous_numExpr_3_1 <em>Anonymous num Expr 31</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous num Expr 31</em>'.
   * @see cruise.umple.umple.NumExpr_#getAnonymous_numExpr_3_1()
   * @see #getNumExpr_()
   * @generated
   */
  EReference getNumExpr__Anonymous_numExpr_3_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.NumExpr_#getAnonymous_numExpr_4_1 <em>Anonymous num Expr 41</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Anonymous num Expr 41</em>'.
   * @see cruise.umple.umple.NumExpr_#getAnonymous_numExpr_4_1()
   * @see #getNumExpr_()
   * @generated
   */
  EReference getNumExpr__Anonymous_numExpr_4_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_numExpr_1_ <em>Anonymous num Expr 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous num Expr 1</em>'.
   * @see cruise.umple.umple.Anonymous_numExpr_1_
   * @generated
   */
  EClass getAnonymous_numExpr_1_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_numExpr_1_#getTail_1 <em>Tail 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tail 1</em>'.
   * @see cruise.umple.umple.Anonymous_numExpr_1_#getTail_1()
   * @see #getAnonymous_numExpr_1_()
   * @generated
   */
  EAttribute getAnonymous_numExpr_1__Tail_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_numExpr_2_ <em>Anonymous num Expr 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous num Expr 2</em>'.
   * @see cruise.umple.umple.Anonymous_numExpr_2_
   * @generated
   */
  EClass getAnonymous_numExpr_2_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_numExpr_2_#getIndex_1 <em>Index 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index 1</em>'.
   * @see cruise.umple.umple.Anonymous_numExpr_2_#getIndex_1()
   * @see #getAnonymous_numExpr_2_()
   * @generated
   */
  EAttribute getAnonymous_numExpr_2__Index_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_numExpr_3_ <em>Anonymous num Expr 3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous num Expr 3</em>'.
   * @see cruise.umple.umple.Anonymous_numExpr_3_
   * @generated
   */
  EClass getAnonymous_numExpr_3_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_numExpr_3_#getTail_1 <em>Tail 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tail 1</em>'.
   * @see cruise.umple.umple.Anonymous_numExpr_3_#getTail_1()
   * @see #getAnonymous_numExpr_3_()
   * @generated
   */
  EAttribute getAnonymous_numExpr_3__Tail_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Anonymous_numExpr_4_ <em>Anonymous num Expr 4</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Anonymous num Expr 4</em>'.
   * @see cruise.umple.umple.Anonymous_numExpr_4_
   * @generated
   */
  EClass getAnonymous_numExpr_4_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Anonymous_numExpr_4_#getIndex_1 <em>Index 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index 1</em>'.
   * @see cruise.umple.umple.Anonymous_numExpr_4_#getIndex_1()
   * @see #getAnonymous_numExpr_4_()
   * @generated
   */
  EAttribute getAnonymous_numExpr_4__Index_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.EqualityOp_ <em>Equality Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equality Op </em>'.
   * @see cruise.umple.umple.EqualityOp_
   * @generated
   */
  EClass getEqualityOp_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.EqualityOp_#getEqualsOp_1 <em>Equals Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Equals Op 1</em>'.
   * @see cruise.umple.umple.EqualityOp_#getEqualsOp_1()
   * @see #getEqualityOp_()
   * @generated
   */
  EReference getEqualityOp__EqualsOp_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.EqualityOp_#getNotequalsOp_1 <em>Notequals Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Notequals Op 1</em>'.
   * @see cruise.umple.umple.EqualityOp_#getNotequalsOp_1()
   * @see #getEqualityOp_()
   * @generated
   */
  EReference getEqualityOp__NotequalsOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.EqualsOp_ <em>Equals Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equals Op </em>'.
   * @see cruise.umple.umple.EqualsOp_
   * @generated
   */
  EClass getEqualsOp_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.EqualsOp_#getEqualsOp_1 <em>Equals Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Equals Op 1</em>'.
   * @see cruise.umple.umple.EqualsOp_#getEqualsOp_1()
   * @see #getEqualsOp_()
   * @generated
   */
  EAttribute getEqualsOp__EqualsOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.NotequalsOp_ <em>Notequals Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Notequals Op </em>'.
   * @see cruise.umple.umple.NotequalsOp_
   * @generated
   */
  EClass getNotequalsOp_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.NotequalsOp_#getNotequalsOp_1 <em>Notequals Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Notequals Op 1</em>'.
   * @see cruise.umple.umple.NotequalsOp_#getNotequalsOp_1()
   * @see #getNotequalsOp_()
   * @generated
   */
  EAttribute getNotequalsOp__NotequalsOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.OrdinalOp_ <em>Ordinal Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Ordinal Op </em>'.
   * @see cruise.umple.umple.OrdinalOp_
   * @generated
   */
  EClass getOrdinalOp_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.OrdinalOp_#getGreaterOp_1 <em>Greater Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Greater Op 1</em>'.
   * @see cruise.umple.umple.OrdinalOp_#getGreaterOp_1()
   * @see #getOrdinalOp_()
   * @generated
   */
  EReference getOrdinalOp__GreaterOp_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.OrdinalOp_#getLessOp_1 <em>Less Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Less Op 1</em>'.
   * @see cruise.umple.umple.OrdinalOp_#getLessOp_1()
   * @see #getOrdinalOp_()
   * @generated
   */
  EReference getOrdinalOp__LessOp_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.OrdinalOp_#getMoreOp_1 <em>More Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Op 1</em>'.
   * @see cruise.umple.umple.OrdinalOp_#getMoreOp_1()
   * @see #getOrdinalOp_()
   * @generated
   */
  EReference getOrdinalOp__MoreOp_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.OrdinalOp_#getSmallerOp_1 <em>Smaller Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Smaller Op 1</em>'.
   * @see cruise.umple.umple.OrdinalOp_#getSmallerOp_1()
   * @see #getOrdinalOp_()
   * @generated
   */
  EReference getOrdinalOp__SmallerOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.GreaterOp_ <em>Greater Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater Op </em>'.
   * @see cruise.umple.umple.GreaterOp_
   * @generated
   */
  EClass getGreaterOp_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.GreaterOp_#getGreaterOp_1 <em>Greater Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Greater Op 1</em>'.
   * @see cruise.umple.umple.GreaterOp_#getGreaterOp_1()
   * @see #getGreaterOp_()
   * @generated
   */
  EAttribute getGreaterOp__GreaterOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.LessOp_ <em>Less Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Less Op </em>'.
   * @see cruise.umple.umple.LessOp_
   * @generated
   */
  EClass getLessOp_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.LessOp_#getLessOp_1 <em>Less Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Less Op 1</em>'.
   * @see cruise.umple.umple.LessOp_#getLessOp_1()
   * @see #getLessOp_()
   * @generated
   */
  EAttribute getLessOp__LessOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.MoreOp_ <em>More Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>More Op </em>'.
   * @see cruise.umple.umple.MoreOp_
   * @generated
   */
  EClass getMoreOp_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.MoreOp_#getMoreOp_1 <em>More Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>More Op 1</em>'.
   * @see cruise.umple.umple.MoreOp_#getMoreOp_1()
   * @see #getMoreOp_()
   * @generated
   */
  EAttribute getMoreOp__MoreOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SmallerOp_ <em>Smaller Op </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Smaller Op </em>'.
   * @see cruise.umple.umple.SmallerOp_
   * @generated
   */
  EClass getSmallerOp_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SmallerOp_#getSmallerOp_1 <em>Smaller Op 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Smaller Op 1</em>'.
   * @see cruise.umple.umple.SmallerOp_#getSmallerOp_1()
   * @see #getSmallerOp_()
   * @generated
   */
  EAttribute getSmallerOp__SmallerOp_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Position_ <em>Position </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Position </em>'.
   * @see cruise.umple.umple.Position_
   * @generated
   */
  EClass getPosition_();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Position_#getAssociationPosition_1 <em>Association Position 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Position 1</em>'.
   * @see cruise.umple.umple.Position_#getAssociationPosition_1()
   * @see #getPosition_()
   * @generated
   */
  EReference getPosition__AssociationPosition_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Position_#getElementPosition_1 <em>Element Position 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Element Position 1</em>'.
   * @see cruise.umple.umple.Position_#getElementPosition_1()
   * @see #getPosition_()
   * @generated
   */
  EReference getPosition__ElementPosition_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ElementPosition_ <em>Element Position </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Position </em>'.
   * @see cruise.umple.umple.ElementPosition_
   * @generated
   */
  EClass getElementPosition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ElementPosition_#getX_1 <em>X1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X1</em>'.
   * @see cruise.umple.umple.ElementPosition_#getX_1()
   * @see #getElementPosition_()
   * @generated
   */
  EAttribute getElementPosition__X_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ElementPosition_#getY_1 <em>Y1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y1</em>'.
   * @see cruise.umple.umple.ElementPosition_#getY_1()
   * @see #getElementPosition_()
   * @generated
   */
  EAttribute getElementPosition__Y_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ElementPosition_#getWidth_1 <em>Width 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width 1</em>'.
   * @see cruise.umple.umple.ElementPosition_#getWidth_1()
   * @see #getElementPosition_()
   * @generated
   */
  EAttribute getElementPosition__Width_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ElementPosition_#getHeight_1 <em>Height 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Height 1</em>'.
   * @see cruise.umple.umple.ElementPosition_#getHeight_1()
   * @see #getElementPosition_()
   * @generated
   */
  EAttribute getElementPosition__Height_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationPosition_ <em>Association Position </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Position </em>'.
   * @see cruise.umple.umple.AssociationPosition_
   * @generated
   */
  EClass getAssociationPosition_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AssociationPosition_#getName_1 <em>Name 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name 1</em>'.
   * @see cruise.umple.umple.AssociationPosition_#getName_1()
   * @see #getAssociationPosition_()
   * @generated
   */
  EAttribute getAssociationPosition__Name_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationPosition_#getCoordinate_1 <em>Coordinate 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Coordinate 1</em>'.
   * @see cruise.umple.umple.AssociationPosition_#getCoordinate_1()
   * @see #getAssociationPosition_()
   * @generated
   */
  EReference getAssociationPosition__Coordinate_1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationPosition_#getCoordinate_2 <em>Coordinate 2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Coordinate 2</em>'.
   * @see cruise.umple.umple.AssociationPosition_#getCoordinate_2()
   * @see #getAssociationPosition_()
   * @generated
   */
  EReference getAssociationPosition__Coordinate_2();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Coordinate_ <em>Coordinate </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Coordinate </em>'.
   * @see cruise.umple.umple.Coordinate_
   * @generated
   */
  EClass getCoordinate_();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Coordinate_#getX_1 <em>X1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X1</em>'.
   * @see cruise.umple.umple.Coordinate_#getX_1()
   * @see #getCoordinate_()
   * @generated
   */
  EAttribute getCoordinate__X_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Coordinate_#getY_1 <em>Y1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y1</em>'.
   * @see cruise.umple.umple.Coordinate_#getY_1()
   * @see #getCoordinate_()
   * @generated
   */
  EAttribute getCoordinate__Y_1();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.DisplayColor_ <em>Display Color </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Display Color </em>'.
   * @see cruise.umple.umple.DisplayColor_
   * @generated
   */
  EClass getDisplayColor_();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.DisplayColor_#getAnonymous_displayColor_1_1 <em>Anonymous display Color 11</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Anonymous display Color 11</em>'.
   * @see cruise.umple.umple.DisplayColor_#getAnonymous_displayColor_1_1()
   * @see #getDisplayColor_()
   * @generated
   */
  EAttribute getDisplayColor__Anonymous_displayColor_1_1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.DisplayColor_#getColorValue_1 <em>Color Value 1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Color Value 1</em>'.
   * @see cruise.umple.umple.DisplayColor_#getColorValue_1()
   * @see #getDisplayColor_()
   * @generated
   */
  EAttribute getDisplayColor__ColorValue_1();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UmpleFactory getUmpleFactory();

} //UmplePackage
