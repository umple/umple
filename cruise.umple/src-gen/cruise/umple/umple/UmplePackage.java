/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
   * The meta object id for the '{@link cruise.umple.umple.impl.UmpleModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UmpleModelImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleModel()
   * @generated
   */
  int UMPLE_MODEL = 0;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__NAMESPACE = 0;

  /**
   * The feature id for the '<em><b>Glossary</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__GLOSSARY = 1;

  /**
   * The feature id for the '<em><b>Generate </b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__GENERATE_ = 2;

  /**
   * The feature id for the '<em><b>Trace Mechanism</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__TRACE_MECHANISM = 3;

  /**
   * The feature id for the '<em><b>Uses</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__USES = 4;

  /**
   * The feature id for the '<em><b>Umple Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__UMPLE_ELEMENTS = 5;

  /**
   * The feature id for the '<em><b>Associations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__ASSOCIATIONS = 6;

  /**
   * The feature id for the '<em><b>Association Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__ASSOCIATION_CLASSES = 7;

  /**
   * The feature id for the '<em><b>Statemachines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__STATEMACHINES = 8;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL_FEATURE_COUNT = 9;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.UmpleElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UmpleElementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleElement()
   * @generated
   */
  int UMPLE_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Depends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ELEMENT__DEPENDS = 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.WordImpl <em>Word</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.WordImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getWord()
   * @generated
   */
  int WORD = 2;

  /**
   * The feature id for the '<em><b>Singular</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD__SINGULAR = 0;

  /**
   * The feature id for the '<em><b>Plural</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD__PLURAL = 1;

  /**
   * The number of structural features of the '<em>Word</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WORD_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.GlossaryImpl <em>Glossary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.GlossaryImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGlossary()
   * @generated
   */
  int GLOSSARY = 3;

  /**
   * The feature id for the '<em><b>Words</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOSSARY__WORDS = 0;

  /**
   * The number of structural features of the '<em>Glossary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOSSARY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.GenerateImpl <em>Generate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.GenerateImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGenerate()
   * @generated
   */
  int GENERATE = 4;

  /**
   * The feature id for the '<em><b>Java</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE__JAVA = 0;

  /**
   * The feature id for the '<em><b>Php</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE__PHP = 1;

  /**
   * The feature id for the '<em><b>Ruby</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE__RUBY = 2;

  /**
   * The number of structural features of the '<em>Generate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.NamespaceImpl <em>Namespace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.NamespaceImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getNamespace()
   * @generated
   */
  int NAMESPACE = 5;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE__VALUE = 0;

  /**
   * The number of structural features of the '<em>Namespace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.UmpleClassImpl <em>Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UmpleClassImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleClass()
   * @generated
   */
  int UMPLE_CLASS = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__NAME = UMPLE_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Depends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__DEPENDS = UMPLE_ELEMENT__DEPENDS;

  /**
   * The feature id for the '<em><b>Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__PACKAGE_NAME = UMPLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>External</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__EXTERNAL = UMPLE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Singleton</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__SINGLETON = UMPLE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__KEY = UMPLE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Code Injection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__CODE_INJECTION = UMPLE_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Extends Class</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__EXTENDS_CLASS = UMPLE_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__ATTRIBUTES = UMPLE_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Symmetric Reflexive Associations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__SYMMETRIC_REFLEXIVE_ASSOCIATIONS = UMPLE_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Inline Associations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__INLINE_ASSOCIATIONS = UMPLE_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Positions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__POSITIONS = UMPLE_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>State Machines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__STATE_MACHINES = UMPLE_ELEMENT_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Trace Directives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__TRACE_DIRECTIVES = UMPLE_ELEMENT_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Trace Cases</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__TRACE_CASES = UMPLE_ELEMENT_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>External Language</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS__EXTERNAL_LANGUAGE = UMPLE_ELEMENT_FEATURE_COUNT + 13;

  /**
   * The number of structural features of the '<em>Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_CLASS_FEATURE_COUNT = UMPLE_ELEMENT_FEATURE_COUNT + 14;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ExternalLanguageImpl <em>External Language</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ExternalLanguageImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getExternalLanguage()
   * @generated
   */
  int EXTERNAL_LANGUAGE = 7;

  /**
   * The feature id for the '<em><b>Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_LANGUAGE__FUNCTIONS = 0;

  /**
   * The feature id for the '<em><b>Ruby Functions</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_LANGUAGE__RUBY_FUNCTIONS = 1;

  /**
   * The feature id for the '<em><b>Php Functions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_LANGUAGE__PHP_FUNCTIONS = 2;

  /**
   * The number of structural features of the '<em>External Language</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_LANGUAGE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.UmpleInterfaceImpl <em>Interface</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UmpleInterfaceImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleInterface()
   * @generated
   */
  int UMPLE_INTERFACE = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_INTERFACE__NAME = UMPLE_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Depends</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_INTERFACE__DEPENDS = UMPLE_ELEMENT__DEPENDS;

  /**
   * The feature id for the '<em><b>Extends Interface</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_INTERFACE__EXTENDS_INTERFACE = UMPLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Extra Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_INTERFACE__EXTRA_CODE = UMPLE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Interface</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_INTERFACE_FEATURE_COUNT = UMPLE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.UmpleAssociationImpl <em>Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UmpleAssociationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleAssociation()
   * @generated
   */
  int UMPLE_ASSOCIATION = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ASSOCIATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Associations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ASSOCIATION__ASSOCIATIONS = 1;

  /**
   * The number of structural features of the '<em>Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ASSOCIATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.UmpleAssociationClassImpl <em>Association Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UmpleAssociationClassImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleAssociationClass()
   * @generated
   */
  int UMPLE_ASSOCIATION_CLASS = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ASSOCIATION_CLASS__NAME = 0;

  /**
   * The feature id for the '<em><b>Association Class Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ASSOCIATION_CLASS__ASSOCIATION_CLASS_CONTENTS = 1;

  /**
   * The number of structural features of the '<em>Association Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ASSOCIATION_CLASS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.associationClassContentImpl <em>association Class Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.associationClassContentImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getassociationClassContent()
   * @generated
   */
  int ASSOCIATION_CLASS_CONTENT = 11;

  /**
   * The number of structural features of the '<em>association Class Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationImpl <em>Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociation()
   * @generated
   */
  int ASSOCIATION = 12;

  /**
   * The feature id for the '<em><b>Type1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__TYPE1 = 0;

  /**
   * The feature id for the '<em><b>Rolename1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__ROLENAME1 = 1;

  /**
   * The feature id for the '<em><b>Type2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__TYPE2 = 2;

  /**
   * The feature id for the '<em><b>Rolename2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION__ROLENAME2 = 3;

  /**
   * The number of structural features of the '<em>Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SymmetricReflexiveAssociationImpl <em>Symmetric Reflexive Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SymmetricReflexiveAssociationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSymmetricReflexiveAssociation()
   * @generated
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION = 13;

  /**
   * The feature id for the '<em><b>Rolename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION__ROLENAME = 0;

  /**
   * The number of structural features of the '<em>Symmetric Reflexive Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InlineAssociationImpl <em>Inline Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InlineAssociationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineAssociation()
   * @generated
   */
  int INLINE_ASSOCIATION = 14;

  /**
   * The feature id for the '<em><b>Rolename1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION__ROLENAME1 = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION__TYPE = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rolename2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION__ROLENAME2 = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Inline Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION_FEATURE_COUNT = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.singleAssociationEndImpl <em>single Association End</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.singleAssociationEndImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getsingleAssociationEnd()
   * @generated
   */
  int SINGLE_ASSOCIATION_END = 15;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END__TYPE = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Rolename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END__ROLENAME = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>single Association End</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END_FEATURE_COUNT = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SingletonImpl <em>Singleton</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SingletonImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSingleton()
   * @generated
   */
  int SINGLETON = 16;

  /**
   * The feature id for the '<em><b>Singleton</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLETON__SINGLETON = 0;

  /**
   * The number of structural features of the '<em>Singleton</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLETON_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CodeInjectionImpl <em>Code Injection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CodeInjectionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCodeInjection()
   * @generated
   */
  int CODE_INJECTION = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION__NAME = 0;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION__CODE = 1;

  /**
   * The number of structural features of the '<em>Code Injection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.UmpleAttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UmpleAttributeImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleAttribute()
   * @generated
   */
  int UMPLE_ATTRIBUTE = 18;

  /**
   * The feature id for the '<em><b>Autounique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE__AUTOUNIQUE = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE__NAME = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE__UNIQUE = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE__MODIFIER = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE__TYPE = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>List</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE__LIST = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE__OBJECT = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE__VALUE = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ATTRIBUTE_FEATURE_COUNT = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.KeyImpl <em>Key</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.KeyImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getKey()
   * @generated
   */
  int KEY = 19;

  /**
   * The feature id for the '<em><b>Keys</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY__KEYS = 0;

  /**
   * The number of structural features of the '<em>Key</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.DependImpl <em>Depend</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.DependImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getDepend()
   * @generated
   */
  int DEPEND = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPEND__NAME = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Depend</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPEND_FEATURE_COUNT = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StateMachineDefinitionImpl <em>State Machine Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StateMachineDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStateMachineDefinition()
   * @generated
   */
  int STATE_MACHINE_DEFINITION = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_DEFINITION__STATES = 1;

  /**
   * The number of structural features of the '<em>State Machine Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StateMachineImpl <em>State Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StateMachineImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStateMachine()
   * @generated
   */
  int STATE_MACHINE = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE__NAME = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>State Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_MACHINE_FEATURE_COUNT = ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InlineStateMachineImpl <em>Inline State Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InlineStateMachineImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineStateMachine()
   * @generated
   */
  int INLINE_STATE_MACHINE = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_STATE_MACHINE__NAME = STATE_MACHINE__NAME;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_STATE_MACHINE__STATES = STATE_MACHINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Inline State Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_STATE_MACHINE_FEATURE_COUNT = STATE_MACHINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ReferencedStateMachineImpl <em>Referenced State Machine</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ReferencedStateMachineImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getReferencedStateMachine()
   * @generated
   */
  int REFERENCED_STATE_MACHINE = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_STATE_MACHINE__NAME = STATE_MACHINE__NAME;

  /**
   * The feature id for the '<em><b>Machine</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_STATE_MACHINE__MACHINE = STATE_MACHINE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Referenced State Machine</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCED_STATE_MACHINE_FEATURE_COUNT = STATE_MACHINE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ENUMImpl <em>ENUM</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ENUMImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getENUM()
   * @generated
   */
  int ENUM = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__NAME = STATE_MACHINE__NAME;

  /**
   * The feature id for the '<em><b>State1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__STATE1 = STATE_MACHINE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>States</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM__STATES = STATE_MACHINE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ENUM</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_FEATURE_COUNT = STATE_MACHINE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StateEntityImpl <em>State Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StateEntityImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getStateEntity()
   * @generated
   */
  int STATE_ENTITY = 27;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>State Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ENTITY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.StateImpl <em>State</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.StateImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getState()
   * @generated
   */
  int STATE = 26;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__EXPRESSION = STATE_ENTITY__EXPRESSION;

  /**
   * The feature id for the '<em><b>State Trace Directive</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__STATE_TRACE_DIRECTIVE = STATE_ENTITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>State Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__STATE_NAME = STATE_ENTITY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>States</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE__STATES = STATE_ENTITY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>State</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_FEATURE_COUNT = STATE_ENTITY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TransitionImpl <em>Transition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TransitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTransition()
   * @generated
   */
  int TRANSITION = 28;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__EXPRESSION = STATE_ENTITY__EXPRESSION;

  /**
   * The feature id for the '<em><b>A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__A = STATE_ENTITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>State Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION__STATE_NAME = STATE_ENTITY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Transition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_FEATURE_COUNT = STATE_ENTITY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.EventDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEventDefinition()
   * @generated
   */
  int EVENT_DEFINITION = 29;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__EXPRESSION = TRANSITION__EXPRESSION;

  /**
   * The feature id for the '<em><b>A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__A = TRANSITION__A;

  /**
   * The feature id for the '<em><b>State Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__STATE_NAME = TRANSITION__STATE_NAME;

  /**
   * The feature id for the '<em><b>G</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__G = TRANSITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Event ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__EVENT_ID = TRANSITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Event Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ActionImpl <em>Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ActionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAction()
   * @generated
   */
  int ACTION = 30;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION__CODE = 0;

  /**
   * The number of structural features of the '<em>Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.EntryOrExitActionImpl <em>Entry Or Exit Action</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.EntryOrExitActionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEntryOrExitAction()
   * @generated
   */
  int ENTRY_OR_EXIT_ACTION = 31;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION__EXPRESSION = STATE_ENTITY__EXPRESSION;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION__TYPE = STATE_ENTITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION__CODE = STATE_ENTITY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Entry Or Exit Action</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_OR_EXIT_ACTION_FEATURE_COUNT = STATE_ENTITY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ActivityImpl <em>Activity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ActivityImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getActivity()
   * @generated
   */
  int ACTIVITY = 32;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__EXPRESSION = STATE_ENTITY__EXPRESSION;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY__CODE = STATE_ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Activity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVITY_FEATURE_COUNT = STATE_ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.GuardImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGuard()
   * @generated
   */
  int GUARD = 33;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__EXPRESSION = TRANSITION__EXPRESSION;

  /**
   * The feature id for the '<em><b>A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__A = TRANSITION__A;

  /**
   * The feature id for the '<em><b>State Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__STATE_NAME = TRANSITION__STATE_NAME;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__EVENTS = TRANSITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.GuardCodeImpl <em>Guard Code</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.GuardCodeImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGuardCode()
   * @generated
   */
  int GUARD_CODE = 34;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_CODE__EXPRESSION = GUARD__EXPRESSION;

  /**
   * The feature id for the '<em><b>A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_CODE__A = GUARD__A;

  /**
   * The feature id for the '<em><b>State Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_CODE__STATE_NAME = GUARD__STATE_NAME;

  /**
   * The feature id for the '<em><b>Events</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_CODE__EVENTS = GUARD__EVENTS;

  /**
   * The feature id for the '<em><b>Native Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_CODE__NATIVE_EXPRESSION = GUARD_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Guard Code</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_CODE_FEATURE_COUNT = GUARD_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.PositionImpl <em>Position</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.PositionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getPosition()
   * @generated
   */
  int POSITION = 35;

  /**
   * The feature id for the '<em><b>A</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION__A = 0;

  /**
   * The feature id for the '<em><b>C</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION__C = 1;

  /**
   * The number of structural features of the '<em>Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ClassPositionImpl <em>Class Position</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ClassPositionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getClassPosition()
   * @generated
   */
  int CLASS_POSITION = 36;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_POSITION__X = 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_POSITION__Y = 1;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_POSITION__WIDTH = 2;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_POSITION__HEIGHT = 3;

  /**
   * The number of structural features of the '<em>Class Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_POSITION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationPositionImpl <em>Association Position</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationPositionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationPosition()
   * @generated
   */
  int ASSOCIATION_POSITION = 37;

  /**
   * The feature id for the '<em><b>Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION__INDEX = 0;

  /**
   * The feature id for the '<em><b>C1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION__C1 = 1;

  /**
   * The feature id for the '<em><b>C2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION__C2 = 2;

  /**
   * The number of structural features of the '<em>Association Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CoordinateImpl <em>Coordinate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CoordinateImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCoordinate()
   * @generated
   */
  int COORDINATE = 38;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATE__X = 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATE__Y = 1;

  /**
   * The number of structural features of the '<em>Coordinate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COORDINATE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceDirectiveImpl <em>Trace Directive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceDirectiveImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceDirective()
   * @generated
   */
  int TRACE_DIRECTIVE = 39;

  /**
   * The feature id for the '<em><b>Trace Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DIRECTIVE__TRACE_START = 0;

  /**
   * The feature id for the '<em><b>Model Element</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DIRECTIVE__MODEL_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Condition RHS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DIRECTIVE__CONDITION_RHS = 2;

  /**
   * The feature id for the '<em><b>Element Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DIRECTIVE__ELEMENT_PATTERN = 3;

  /**
   * The number of structural features of the '<em>Trace Directive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_DIRECTIVE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceCaseImpl <em>Trace Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceCaseImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCase()
   * @generated
   */
  int TRACE_CASE = 40;

  /**
   * The feature id for the '<em><b>Trace Case Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE__TRACE_CASE_NAME = 0;

  /**
   * The feature id for the '<em><b>Trace Directive</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE__TRACE_DIRECTIVE = 1;

  /**
   * The number of structural features of the '<em>Trace Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CASE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceRecordImpl <em>Trace Record</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceRecordImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceRecord()
   * @generated
   */
  int TRACE_RECORD = 41;

  /**
   * The feature id for the '<em><b>Object Being Traced</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_RECORD__OBJECT_BEING_TRACED = 0;

  /**
   * The feature id for the '<em><b>Text Output</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_RECORD__TEXT_OUTPUT = 1;

  /**
   * The number of structural features of the '<em>Trace Record</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_RECORD_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceConditionImpl <em>Trace Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceConditionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCondition()
   * @generated
   */
  int TRACE_CONDITION = 42;

  /**
   * The number of structural features of the '<em>Trace Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_CONDITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CompoundTraceConditionImpl <em>Compound Trace Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CompoundTraceConditionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCompoundTraceCondition()
   * @generated
   */
  int COMPOUND_TRACE_CONDITION = 43;

  /**
   * The feature id for the '<em><b>Operand</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_TRACE_CONDITION__OPERAND = TRACE_CONDITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Compound Trace Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPOUND_TRACE_CONDITION_FEATURE_COUNT = TRACE_CONDITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SimpleTraceConditionImpl <em>Simple Trace Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SimpleTraceConditionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSimpleTraceCondition()
   * @generated
   */
  int SIMPLE_TRACE_CONDITION = 44;

  /**
   * The feature id for the '<em><b>Lhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TRACE_CONDITION__LHS = TRACE_CONDITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Condition RHS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TRACE_CONDITION__CONDITION_RHS = TRACE_CONDITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Simple Trace Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_TRACE_CONDITION_FEATURE_COUNT = TRACE_CONDITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ConditionRHSImpl <em>Condition RHS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ConditionRHSImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getConditionRHS()
   * @generated
   */
  int CONDITION_RHS = 45;

  /**
   * The feature id for the '<em><b>Operand</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_RHS__OPERAND = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_RHS__VALUE = 1;

  /**
   * The number of structural features of the '<em>Condition RHS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITION_RHS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ModelElementImpl <em>Model Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ModelElementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getModelElement()
   * @generated
   */
  int MODEL_ELEMENT = 46;

  /**
   * The feature id for the '<em><b>Execute On Entry</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__EXECUTE_ON_ENTRY = 0;

  /**
   * The feature id for the '<em><b>Execute On Exit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__EXECUTE_ON_EXIT = 1;

  /**
   * The feature id for the '<em><b>Cflow</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__CFLOW = 2;

  /**
   * The feature id for the '<em><b>AMethod</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__AMETHOD = 3;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT__ATTRIBUTE = 4;

  /**
   * The number of structural features of the '<em>Model Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_ELEMENT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.TraceMechanismImpl <em>Trace Mechanism</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.TraceMechanismImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceMechanism()
   * @generated
   */
  int TRACE_MECHANISM = 47;

  /**
   * The feature id for the '<em><b>Trace Mechanism</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_MECHANISM__TRACE_MECHANISM = 0;

  /**
   * The number of structural features of the '<em>Trace Mechanism</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRACE_MECHANISM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.blockStatementImpl <em>block Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.blockStatementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getblockStatement()
   * @generated
   */
  int BLOCK_STATEMENT = 69;

  /**
   * The number of structural features of the '<em>block Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.statementImpl <em>statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.statementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getstatement()
   * @generated
   */
  int STATEMENT = 74;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__CONDITION = BLOCK_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>State1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__STATE1 = BLOCK_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>State2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__STATE2 = BLOCK_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__CONTROL = BLOCK_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__STATE = BLOCK_STATEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Ret Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__RET_VAL = BLOCK_STATEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__TRY_BLOCK = BLOCK_STATEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Catch Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__CATCH_BLOCK = BLOCK_STATEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = BLOCK_STATEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.blockImpl <em>block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.blockImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getblock()
   * @generated
   */
  int BLOCK = 48;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__CONDITION = STATEMENT__CONDITION;

  /**
   * The feature id for the '<em><b>State1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATE1 = STATEMENT__STATE1;

  /**
   * The feature id for the '<em><b>State2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATE2 = STATEMENT__STATE2;

  /**
   * The feature id for the '<em><b>Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__CONTROL = STATEMENT__CONTROL;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATE = STATEMENT__STATE;

  /**
   * The feature id for the '<em><b>Ret Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__RET_VAL = STATEMENT__RET_VAL;

  /**
   * The feature id for the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__TRY_BLOCK = STATEMENT__TRY_BLOCK;

  /**
   * The feature id for the '<em><b>Catch Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__CATCH_BLOCK = STATEMENT__CATCH_BLOCK;

  /**
   * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__BLOCKS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.unaryExpressionNotPlusMinusImpl <em>unary Expression Not Plus Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.unaryExpressionNotPlusMinusImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getunaryExpressionNotPlusMinus()
   * @generated
   */
  int UNARY_EXPRESSION_NOT_PLUS_MINUS = 60;

  /**
   * The number of structural features of the '<em>unary Expression Not Plus Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.primaryImpl <em>primary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.primaryImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getprimary()
   * @generated
   */
  int PRIMARY = 61;

  /**
   * The number of structural features of the '<em>primary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_FEATURE_COUNT = UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.parExpressionImpl <em>par Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.parExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getparExpression()
   * @generated
   */
  int PAR_EXPRESSION = 49;

  /**
   * The number of structural features of the '<em>par Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAR_EXPRESSION_FEATURE_COUNT = PRIMARY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.forUpdateImpl <em>for Update</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.forUpdateImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getforUpdate()
   * @generated
   */
  int FOR_UPDATE = 77;

  /**
   * The number of structural features of the '<em>for Update</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_UPDATE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.expressionListImpl <em>expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.expressionListImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getexpressionList()
   * @generated
   */
  int EXPRESSION_LIST = 50;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST__EXPRESSIONS = FOR_UPDATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>expression List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_FEATURE_COUNT = FOR_UPDATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.expressionImpl <em>expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.expressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getexpression()
   * @generated
   */
  int EXPRESSION = 51;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__CONDITION = PAR_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>State1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__STATE1 = PAR_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>State2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__STATE2 = PAR_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__CONTROL = PAR_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__STATE = PAR_EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Ret Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__RET_VAL = PAR_EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__TRY_BLOCK = PAR_EXPRESSION_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Catch Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__CATCH_BLOCK = PAR_EXPRESSION_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPRESSION1 = PAR_EXPRESSION_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Expression2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPRESSION2 = PAR_EXPRESSION_FEATURE_COUNT + 9;

  /**
   * The number of structural features of the '<em>expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = PAR_EXPRESSION_FEATURE_COUNT + 10;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.conditionalExpressionImpl <em>conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.conditionalExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getconditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 52;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPRESSION2 = 1;

  /**
   * The feature id for the '<em><b>Expression3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPRESSION3 = 2;

  /**
   * The number of structural features of the '<em>conditional Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.conditionalOrExpressionImpl <em>conditional Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.conditionalOrExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getconditionalOrExpression()
   * @generated
   */
  int CONDITIONAL_OR_EXPRESSION = 53;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>conditional Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.conditionalAndExpressionImpl <em>conditional And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.conditionalAndExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getconditionalAndExpression()
   * @generated
   */
  int CONDITIONAL_AND_EXPRESSION = 54;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>conditional And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.equalityExpressionImpl <em>equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.equalityExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getequalityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 55;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.relationalExpressionImpl <em>relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.relationalExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getrelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 56;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.additiveExpressionImpl <em>additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.additiveExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getadditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 57;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.multiplicativeExpressionImpl <em>multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.multiplicativeExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getmultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 58;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.unaryExpressionImpl <em>unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.unaryExpressionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getunaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 59;

  /**
   * The feature id for the '<em><b>Exp1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXP1 = UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exp2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXP2 = UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.literalImpl <em>literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.literalImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getliteral()
   * @generated
   */
  int LITERAL = 62;

  /**
   * The number of structural features of the '<em>literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = PRIMARY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.functionCallImpl <em>function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.functionCallImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getfunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 63;

  /**
   * The number of structural features of the '<em>function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.functionDeclarationImpl <em>function Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.functionDeclarationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getfunctionDeclaration()
   * @generated
   */
  int FUNCTION_DECLARATION = 64;

  /**
   * The feature id for the '<em><b>Java</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION__JAVA = 0;

  /**
   * The number of structural features of the '<em>function Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.functionDefinitionImpl <em>function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.functionDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getfunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 65;

  /**
   * The feature id for the '<em><b>Java</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__JAVA = 0;

  /**
   * The number of structural features of the '<em>function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.javaFunctionDeclarationImpl <em>java Function Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.javaFunctionDeclarationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getjavaFunctionDeclaration()
   * @generated
   */
  int JAVA_FUNCTION_DECLARATION = 66;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__RETURN_TYPE = 0;

  /**
   * The feature id for the '<em><b>Reference Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__REFERENCE_TYPE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__NAME = 2;

  /**
   * The feature id for the '<em><b>Arg List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__ARG_LIST = 3;

  /**
   * The feature id for the '<em><b>Arg List ID</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__ARG_LIST_ID = 4;

  /**
   * The number of structural features of the '<em>java Function Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.javaFunctionDefinitionImpl <em>java Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.javaFunctionDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getjavaFunctionDefinition()
   * @generated
   */
  int JAVA_FUNCTION_DEFINITION = 67;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DEFINITION__DECL = 0;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DEFINITION__CODE = 1;

  /**
   * The number of structural features of the '<em>java Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.javaFunctionCallImpl <em>java Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.javaFunctionCallImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getjavaFunctionCall()
   * @generated
   */
  int JAVA_FUNCTION_CALL = 68;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_CALL__NAME = LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_CALL__ARGS = LITERAL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>java Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_CALL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.localVariableDeclarationStatementImpl <em>local Variable Declaration Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.localVariableDeclarationStatementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getlocalVariableDeclarationStatement()
   * @generated
   */
  int LOCAL_VARIABLE_DECLARATION_STATEMENT = 70;

  /**
   * The number of structural features of the '<em>local Variable Declaration Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT = BLOCK_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.localVariableDeclarationImpl <em>local Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.localVariableDeclarationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getlocalVariableDeclaration()
   * @generated
   */
  int LOCAL_VARIABLE_DECLARATION = 71;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION__EXPRESSIONS = LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION__TYPE = LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Dec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION__DEC = LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>local Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION_FEATURE_COUNT = LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.variableDeclaratorsImpl <em>variable Declarators</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.variableDeclaratorsImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getvariableDeclarators()
   * @generated
   */
  int VARIABLE_DECLARATORS = 72;

  /**
   * The feature id for the '<em><b>Vd</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATORS__VD = 0;

  /**
   * The number of structural features of the '<em>variable Declarators</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATORS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.variableDeclaratorImpl <em>variable Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.variableDeclaratorImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getvariableDeclarator()
   * @generated
   */
  int VARIABLE_DECLARATOR = 73;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATOR__NAME = 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATOR__EXP = 1;

  /**
   * The number of structural features of the '<em>variable Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.forControlImpl <em>for Control</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.forControlImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getforControl()
   * @generated
   */
  int FOR_CONTROL = 75;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_CONTROL__INIT = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_CONTROL__CONDITION = 1;

  /**
   * The feature id for the '<em><b>Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_CONTROL__UPDATE = 2;

  /**
   * The number of structural features of the '<em>for Control</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_CONTROL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.forInitImpl <em>for Init</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.forInitImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getforInit()
   * @generated
   */
  int FOR_INIT = 76;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_INIT__EXPRESSIONS = 0;

  /**
   * The number of structural features of the '<em>for Init</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_INIT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.phpFunctionImpl <em>php Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.phpFunctionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getphpFunction()
   * @generated
   */
  int PHP_FUNCTION = 78;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_FUNCTION__NAME = 0;

  /**
   * The feature id for the '<em><b>Codeblock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_FUNCTION__CODEBLOCK = 1;

  /**
   * The number of structural features of the '<em>php Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_FUNCTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.phpBlockImpl <em>php Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.phpBlockImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getphpBlock()
   * @generated
   */
  int PHP_BLOCK = 79;

  /**
   * The feature id for the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_BLOCK__CODE = 0;

  /**
   * The number of structural features of the '<em>php Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_BLOCK_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.Modifier <em>Modifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.Modifier
   * @see cruise.umple.umple.impl.UmplePackageImpl#getModifier()
   * @generated
   */
  int MODIFIER = 80;


  /**
   * Returns the meta object for class '{@link cruise.umple.umple.UmpleModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see cruise.umple.umple.UmpleModel
   * @generated
   */
  EClass getUmpleModel();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleModel#getNamespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Namespace</em>'.
   * @see cruise.umple.umple.UmpleModel#getNamespace()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_Namespace();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleModel#getGlossary <em>Glossary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Glossary</em>'.
   * @see cruise.umple.umple.UmpleModel#getGlossary()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_Glossary();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleModel#getGenerate_ <em>Generate </em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Generate </em>'.
   * @see cruise.umple.umple.UmpleModel#getGenerate_()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_Generate_();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleModel#getTraceMechanism <em>Trace Mechanism</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trace Mechanism</em>'.
   * @see cruise.umple.umple.UmpleModel#getTraceMechanism()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_TraceMechanism();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.UmpleModel#getUses <em>Uses</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Uses</em>'.
   * @see cruise.umple.umple.UmpleModel#getUses()
   * @see #getUmpleModel()
   * @generated
   */
  EAttribute getUmpleModel_Uses();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleModel#getUmpleElements <em>Umple Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Umple Elements</em>'.
   * @see cruise.umple.umple.UmpleModel#getUmpleElements()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_UmpleElements();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleModel#getAssociations <em>Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Associations</em>'.
   * @see cruise.umple.umple.UmpleModel#getAssociations()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_Associations();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleModel#getAssociationClasses <em>Association Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Classes</em>'.
   * @see cruise.umple.umple.UmpleModel#getAssociationClasses()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_AssociationClasses();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleModel#getStatemachines <em>Statemachines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statemachines</em>'.
   * @see cruise.umple.umple.UmpleModel#getStatemachines()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_Statemachines();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.UmpleElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see cruise.umple.umple.UmpleElement
   * @generated
   */
  EClass getUmpleElement();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.UmpleElement#getName()
   * @see #getUmpleElement()
   * @generated
   */
  EAttribute getUmpleElement_Name();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleElement#getDepends <em>Depends</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Depends</em>'.
   * @see cruise.umple.umple.UmpleElement#getDepends()
   * @see #getUmpleElement()
   * @generated
   */
  EReference getUmpleElement_Depends();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Word <em>Word</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Word</em>'.
   * @see cruise.umple.umple.Word
   * @generated
   */
  EClass getWord();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Word#getSingular <em>Singular</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Singular</em>'.
   * @see cruise.umple.umple.Word#getSingular()
   * @see #getWord()
   * @generated
   */
  EAttribute getWord_Singular();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Word#getPlural <em>Plural</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Plural</em>'.
   * @see cruise.umple.umple.Word#getPlural()
   * @see #getWord()
   * @generated
   */
  EAttribute getWord_Plural();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Glossary <em>Glossary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Glossary</em>'.
   * @see cruise.umple.umple.Glossary
   * @generated
   */
  EClass getGlossary();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Glossary#getWords <em>Words</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Words</em>'.
   * @see cruise.umple.umple.Glossary#getWords()
   * @see #getGlossary()
   * @generated
   */
  EReference getGlossary_Words();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Generate <em>Generate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generate</em>'.
   * @see cruise.umple.umple.Generate
   * @generated
   */
  EClass getGenerate();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Generate#isJava <em>Java</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Java</em>'.
   * @see cruise.umple.umple.Generate#isJava()
   * @see #getGenerate()
   * @generated
   */
  EAttribute getGenerate_Java();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Generate#isPhp <em>Php</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Php</em>'.
   * @see cruise.umple.umple.Generate#isPhp()
   * @see #getGenerate()
   * @generated
   */
  EAttribute getGenerate_Php();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Generate#getRuby <em>Ruby</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ruby</em>'.
   * @see cruise.umple.umple.Generate#getRuby()
   * @see #getGenerate()
   * @generated
   */
  EAttribute getGenerate_Ruby();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Namespace <em>Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Namespace</em>'.
   * @see cruise.umple.umple.Namespace
   * @generated
   */
  EClass getNamespace();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Namespace#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see cruise.umple.umple.Namespace#getValue()
   * @see #getNamespace()
   * @generated
   */
  EAttribute getNamespace_Value();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.UmpleClass <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class</em>'.
   * @see cruise.umple.umple.UmpleClass
   * @generated
   */
  EClass getUmpleClass();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleClass#getPackageName <em>Package Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Package Name</em>'.
   * @see cruise.umple.umple.UmpleClass#getPackageName()
   * @see #getUmpleClass()
   * @generated
   */
  EAttribute getUmpleClass_PackageName();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleClass#isExternal <em>External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>External</em>'.
   * @see cruise.umple.umple.UmpleClass#isExternal()
   * @see #getUmpleClass()
   * @generated
   */
  EAttribute getUmpleClass_External();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleClass#isSingleton <em>Singleton</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Singleton</em>'.
   * @see cruise.umple.umple.UmpleClass#isSingleton()
   * @see #getUmpleClass()
   * @generated
   */
  EAttribute getUmpleClass_Singleton();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleClass#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Key</em>'.
   * @see cruise.umple.umple.UmpleClass#getKey()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_Key();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleClass#getCodeInjection <em>Code Injection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code Injection</em>'.
   * @see cruise.umple.umple.UmpleClass#getCodeInjection()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_CodeInjection();

  /**
   * Returns the meta object for the reference list '{@link cruise.umple.umple.UmpleClass#getExtendsClass <em>Extends Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Extends Class</em>'.
   * @see cruise.umple.umple.UmpleClass#getExtendsClass()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_ExtendsClass();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleClass#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see cruise.umple.umple.UmpleClass#getAttributes()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleClass#getSymmetricReflexiveAssociations <em>Symmetric Reflexive Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Symmetric Reflexive Associations</em>'.
   * @see cruise.umple.umple.UmpleClass#getSymmetricReflexiveAssociations()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_SymmetricReflexiveAssociations();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleClass#getInlineAssociations <em>Inline Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Inline Associations</em>'.
   * @see cruise.umple.umple.UmpleClass#getInlineAssociations()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_InlineAssociations();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleClass#getPositions <em>Positions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Positions</em>'.
   * @see cruise.umple.umple.UmpleClass#getPositions()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_Positions();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleClass#getStateMachines <em>State Machines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Machines</em>'.
   * @see cruise.umple.umple.UmpleClass#getStateMachines()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_StateMachines();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleClass#getTraceDirectives <em>Trace Directives</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Directives</em>'.
   * @see cruise.umple.umple.UmpleClass#getTraceDirectives()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_TraceDirectives();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleClass#getTraceCases <em>Trace Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Cases</em>'.
   * @see cruise.umple.umple.UmpleClass#getTraceCases()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_TraceCases();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleClass#getExternalLanguage <em>External Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>External Language</em>'.
   * @see cruise.umple.umple.UmpleClass#getExternalLanguage()
   * @see #getUmpleClass()
   * @generated
   */
  EReference getUmpleClass_ExternalLanguage();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ExternalLanguage <em>External Language</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Language</em>'.
   * @see cruise.umple.umple.ExternalLanguage
   * @generated
   */
  EClass getExternalLanguage();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ExternalLanguage#getFunctions <em>Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Functions</em>'.
   * @see cruise.umple.umple.ExternalLanguage#getFunctions()
   * @see #getExternalLanguage()
   * @generated
   */
  EReference getExternalLanguage_Functions();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.ExternalLanguage#getRubyFunctions <em>Ruby Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Ruby Functions</em>'.
   * @see cruise.umple.umple.ExternalLanguage#getRubyFunctions()
   * @see #getExternalLanguage()
   * @generated
   */
  EAttribute getExternalLanguage_RubyFunctions();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ExternalLanguage#getPhpFunctions <em>Php Functions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Php Functions</em>'.
   * @see cruise.umple.umple.ExternalLanguage#getPhpFunctions()
   * @see #getExternalLanguage()
   * @generated
   */
  EReference getExternalLanguage_PhpFunctions();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.UmpleInterface <em>Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface</em>'.
   * @see cruise.umple.umple.UmpleInterface
   * @generated
   */
  EClass getUmpleInterface();

  /**
   * Returns the meta object for the reference list '{@link cruise.umple.umple.UmpleInterface#getExtendsInterface <em>Extends Interface</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Extends Interface</em>'.
   * @see cruise.umple.umple.UmpleInterface#getExtendsInterface()
   * @see #getUmpleInterface()
   * @generated
   */
  EReference getUmpleInterface_ExtendsInterface();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleInterface#getExtraCode <em>Extra Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Extra Code</em>'.
   * @see cruise.umple.umple.UmpleInterface#getExtraCode()
   * @see #getUmpleInterface()
   * @generated
   */
  EReference getUmpleInterface_ExtraCode();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.UmpleAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association</em>'.
   * @see cruise.umple.umple.UmpleAssociation
   * @generated
   */
  EClass getUmpleAssociation();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAssociation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.UmpleAssociation#getName()
   * @see #getUmpleAssociation()
   * @generated
   */
  EAttribute getUmpleAssociation_Name();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.UmpleAssociation#getAssociations <em>Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Associations</em>'.
   * @see cruise.umple.umple.UmpleAssociation#getAssociations()
   * @see #getUmpleAssociation()
   * @generated
   */
  EReference getUmpleAssociation_Associations();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.UmpleAssociationClass <em>Association Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Class</em>'.
   * @see cruise.umple.umple.UmpleAssociationClass
   * @generated
   */
  EClass getUmpleAssociationClass();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAssociationClass#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.UmpleAssociationClass#getName()
   * @see #getUmpleAssociationClass()
   * @generated
   */
  EAttribute getUmpleAssociationClass_Name();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleAssociationClass#getAssociationClassContents <em>Association Class Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Class Contents</em>'.
   * @see cruise.umple.umple.UmpleAssociationClass#getAssociationClassContents()
   * @see #getUmpleAssociationClass()
   * @generated
   */
  EReference getUmpleAssociationClass_AssociationClassContents();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.associationClassContent <em>association Class Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>association Class Content</em>'.
   * @see cruise.umple.umple.associationClassContent
   * @generated
   */
  EClass getassociationClassContent();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Association <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association</em>'.
   * @see cruise.umple.umple.Association
   * @generated
   */
  EClass getAssociation();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Association#getType1 <em>Type1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type1</em>'.
   * @see cruise.umple.umple.Association#getType1()
   * @see #getAssociation()
   * @generated
   */
  EAttribute getAssociation_Type1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Association#getRolename1 <em>Rolename1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rolename1</em>'.
   * @see cruise.umple.umple.Association#getRolename1()
   * @see #getAssociation()
   * @generated
   */
  EAttribute getAssociation_Rolename1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Association#getType2 <em>Type2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type2</em>'.
   * @see cruise.umple.umple.Association#getType2()
   * @see #getAssociation()
   * @generated
   */
  EAttribute getAssociation_Type2();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Association#getRolename2 <em>Rolename2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rolename2</em>'.
   * @see cruise.umple.umple.Association#getRolename2()
   * @see #getAssociation()
   * @generated
   */
  EAttribute getAssociation_Rolename2();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SymmetricReflexiveAssociation <em>Symmetric Reflexive Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Symmetric Reflexive Association</em>'.
   * @see cruise.umple.umple.SymmetricReflexiveAssociation
   * @generated
   */
  EClass getSymmetricReflexiveAssociation();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SymmetricReflexiveAssociation#getRolename <em>Rolename</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rolename</em>'.
   * @see cruise.umple.umple.SymmetricReflexiveAssociation#getRolename()
   * @see #getSymmetricReflexiveAssociation()
   * @generated
   */
  EAttribute getSymmetricReflexiveAssociation_Rolename();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InlineAssociation <em>Inline Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inline Association</em>'.
   * @see cruise.umple.umple.InlineAssociation
   * @generated
   */
  EClass getInlineAssociation();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineAssociation#getRolename1 <em>Rolename1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rolename1</em>'.
   * @see cruise.umple.umple.InlineAssociation#getRolename1()
   * @see #getInlineAssociation()
   * @generated
   */
  EAttribute getInlineAssociation_Rolename1();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineAssociation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see cruise.umple.umple.InlineAssociation#getType()
   * @see #getInlineAssociation()
   * @generated
   */
  EAttribute getInlineAssociation_Type();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.InlineAssociation#getRolename2 <em>Rolename2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rolename2</em>'.
   * @see cruise.umple.umple.InlineAssociation#getRolename2()
   * @see #getInlineAssociation()
   * @generated
   */
  EAttribute getInlineAssociation_Rolename2();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.singleAssociationEnd <em>single Association End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>single Association End</em>'.
   * @see cruise.umple.umple.singleAssociationEnd
   * @generated
   */
  EClass getsingleAssociationEnd();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.singleAssociationEnd#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see cruise.umple.umple.singleAssociationEnd#getType()
   * @see #getsingleAssociationEnd()
   * @generated
   */
  EAttribute getsingleAssociationEnd_Type();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.singleAssociationEnd#getRolename <em>Rolename</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rolename</em>'.
   * @see cruise.umple.umple.singleAssociationEnd#getRolename()
   * @see #getsingleAssociationEnd()
   * @generated
   */
  EAttribute getsingleAssociationEnd_Rolename();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Singleton <em>Singleton</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Singleton</em>'.
   * @see cruise.umple.umple.Singleton
   * @generated
   */
  EClass getSingleton();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Singleton#isSingleton <em>Singleton</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Singleton</em>'.
   * @see cruise.umple.umple.Singleton#isSingleton()
   * @see #getSingleton()
   * @generated
   */
  EAttribute getSingleton_Singleton();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.CodeInjection <em>Code Injection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Code Injection</em>'.
   * @see cruise.umple.umple.CodeInjection
   * @generated
   */
  EClass getCodeInjection();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.CodeInjection#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.CodeInjection#getName()
   * @see #getCodeInjection()
   * @generated
   */
  EAttribute getCodeInjection_Name();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.CodeInjection#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see cruise.umple.umple.CodeInjection#getCode()
   * @see #getCodeInjection()
   * @generated
   */
  EReference getCodeInjection_Code();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.UmpleAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see cruise.umple.umple.UmpleAttribute
   * @generated
   */
  EClass getUmpleAttribute();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAttribute#isAutounique <em>Autounique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Autounique</em>'.
   * @see cruise.umple.umple.UmpleAttribute#isAutounique()
   * @see #getUmpleAttribute()
   * @generated
   */
  EAttribute getUmpleAttribute_Autounique();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAttribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.UmpleAttribute#getName()
   * @see #getUmpleAttribute()
   * @generated
   */
  EAttribute getUmpleAttribute_Name();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAttribute#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see cruise.umple.umple.UmpleAttribute#isUnique()
   * @see #getUmpleAttribute()
   * @generated
   */
  EAttribute getUmpleAttribute_Unique();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAttribute#getModifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Modifier</em>'.
   * @see cruise.umple.umple.UmpleAttribute#getModifier()
   * @see #getUmpleAttribute()
   * @generated
   */
  EAttribute getUmpleAttribute_Modifier();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAttribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see cruise.umple.umple.UmpleAttribute#getType()
   * @see #getUmpleAttribute()
   * @generated
   */
  EAttribute getUmpleAttribute_Type();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAttribute#isList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>List</em>'.
   * @see cruise.umple.umple.UmpleAttribute#isList()
   * @see #getUmpleAttribute()
   * @generated
   */
  EAttribute getUmpleAttribute_List();

  /**
   * Returns the meta object for the reference '{@link cruise.umple.umple.UmpleAttribute#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object</em>'.
   * @see cruise.umple.umple.UmpleAttribute#getObject()
   * @see #getUmpleAttribute()
   * @generated
   */
  EReference getUmpleAttribute_Object();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UmpleAttribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see cruise.umple.umple.UmpleAttribute#getValue()
   * @see #getUmpleAttribute()
   * @generated
   */
  EAttribute getUmpleAttribute_Value();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Key <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key</em>'.
   * @see cruise.umple.umple.Key
   * @generated
   */
  EClass getKey();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.Key#getKeys <em>Keys</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Keys</em>'.
   * @see cruise.umple.umple.Key#getKeys()
   * @see #getKey()
   * @generated
   */
  EAttribute getKey_Keys();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Depend <em>Depend</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Depend</em>'.
   * @see cruise.umple.umple.Depend
   * @generated
   */
  EClass getDepend();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Depend#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.Depend#getName()
   * @see #getDepend()
   * @generated
   */
  EAttribute getDepend_Name();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StateMachineDefinition <em>State Machine Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Machine Definition</em>'.
   * @see cruise.umple.umple.StateMachineDefinition
   * @generated
   */
  EClass getStateMachineDefinition();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.StateMachineDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.StateMachineDefinition#getName()
   * @see #getStateMachineDefinition()
   * @generated
   */
  EAttribute getStateMachineDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.StateMachineDefinition#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see cruise.umple.umple.StateMachineDefinition#getStates()
   * @see #getStateMachineDefinition()
   * @generated
   */
  EReference getStateMachineDefinition_States();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StateMachine <em>State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Machine</em>'.
   * @see cruise.umple.umple.StateMachine
   * @generated
   */
  EClass getStateMachine();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.StateMachine#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.StateMachine#getName()
   * @see #getStateMachine()
   * @generated
   */
  EAttribute getStateMachine_Name();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InlineStateMachine <em>Inline State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Inline State Machine</em>'.
   * @see cruise.umple.umple.InlineStateMachine
   * @generated
   */
  EClass getInlineStateMachine();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InlineStateMachine#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see cruise.umple.umple.InlineStateMachine#getStates()
   * @see #getInlineStateMachine()
   * @generated
   */
  EReference getInlineStateMachine_States();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ReferencedStateMachine <em>Referenced State Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Referenced State Machine</em>'.
   * @see cruise.umple.umple.ReferencedStateMachine
   * @generated
   */
  EClass getReferencedStateMachine();

  /**
   * Returns the meta object for the reference '{@link cruise.umple.umple.ReferencedStateMachine#getMachine <em>Machine</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Machine</em>'.
   * @see cruise.umple.umple.ReferencedStateMachine#getMachine()
   * @see #getReferencedStateMachine()
   * @generated
   */
  EReference getReferencedStateMachine_Machine();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ENUM <em>ENUM</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ENUM</em>'.
   * @see cruise.umple.umple.ENUM
   * @generated
   */
  EClass getENUM();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ENUM#getState1 <em>State1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State1</em>'.
   * @see cruise.umple.umple.ENUM#getState1()
   * @see #getENUM()
   * @generated
   */
  EAttribute getENUM_State1();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.ENUM#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>States</em>'.
   * @see cruise.umple.umple.ENUM#getStates()
   * @see #getENUM()
   * @generated
   */
  EAttribute getENUM_States();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.State <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State</em>'.
   * @see cruise.umple.umple.State
   * @generated
   */
  EClass getState();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.State#getStateTraceDirective <em>State Trace Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>State Trace Directive</em>'.
   * @see cruise.umple.umple.State#getStateTraceDirective()
   * @see #getState()
   * @generated
   */
  EReference getState_StateTraceDirective();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.State#getStateName <em>State Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name</em>'.
   * @see cruise.umple.umple.State#getStateName()
   * @see #getState()
   * @generated
   */
  EAttribute getState_StateName();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.State#getStates <em>States</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>States</em>'.
   * @see cruise.umple.umple.State#getStates()
   * @see #getState()
   * @generated
   */
  EReference getState_States();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.StateEntity <em>State Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Entity</em>'.
   * @see cruise.umple.umple.StateEntity
   * @generated
   */
  EClass getStateEntity();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.StateEntity#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see cruise.umple.umple.StateEntity#getExpression()
   * @see #getStateEntity()
   * @generated
   */
  EReference getStateEntity_Expression();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Transition <em>Transition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition</em>'.
   * @see cruise.umple.umple.Transition
   * @generated
   */
  EClass getTransition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.Transition#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>A</em>'.
   * @see cruise.umple.umple.Transition#getA()
   * @see #getTransition()
   * @generated
   */
  EReference getTransition_A();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Transition#getStateName <em>State Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>State Name</em>'.
   * @see cruise.umple.umple.Transition#getStateName()
   * @see #getTransition()
   * @generated
   */
  EAttribute getTransition_StateName();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.EventDefinition <em>Event Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Definition</em>'.
   * @see cruise.umple.umple.EventDefinition
   * @generated
   */
  EClass getEventDefinition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.EventDefinition#getG <em>G</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>G</em>'.
   * @see cruise.umple.umple.EventDefinition#getG()
   * @see #getEventDefinition()
   * @generated
   */
  EReference getEventDefinition_G();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.EventDefinition#getEventID <em>Event ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Event ID</em>'.
   * @see cruise.umple.umple.EventDefinition#getEventID()
   * @see #getEventDefinition()
   * @generated
   */
  EAttribute getEventDefinition_EventID();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Action <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Action</em>'.
   * @see cruise.umple.umple.Action
   * @generated
   */
  EClass getAction();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.Action#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see cruise.umple.umple.Action#getCode()
   * @see #getAction()
   * @generated
   */
  EReference getAction_Code();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.EntryOrExitAction <em>Entry Or Exit Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Or Exit Action</em>'.
   * @see cruise.umple.umple.EntryOrExitAction
   * @generated
   */
  EClass getEntryOrExitAction();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.EntryOrExitAction#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see cruise.umple.umple.EntryOrExitAction#getType()
   * @see #getEntryOrExitAction()
   * @generated
   */
  EAttribute getEntryOrExitAction_Type();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.EntryOrExitAction#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see cruise.umple.umple.EntryOrExitAction#getCode()
   * @see #getEntryOrExitAction()
   * @generated
   */
  EReference getEntryOrExitAction_Code();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Activity <em>Activity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Activity</em>'.
   * @see cruise.umple.umple.Activity
   * @generated
   */
  EClass getActivity();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.Activity#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see cruise.umple.umple.Activity#getCode()
   * @see #getActivity()
   * @generated
   */
  EReference getActivity_Code();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see cruise.umple.umple.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.Guard#getEvents <em>Events</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Events</em>'.
   * @see cruise.umple.umple.Guard#getEvents()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_Events();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.GuardCode <em>Guard Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard Code</em>'.
   * @see cruise.umple.umple.GuardCode
   * @generated
   */
  EClass getGuardCode();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.GuardCode#getNativeExpression <em>Native Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Native Expression</em>'.
   * @see cruise.umple.umple.GuardCode#getNativeExpression()
   * @see #getGuardCode()
   * @generated
   */
  EReference getGuardCode_NativeExpression();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Position <em>Position</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Position</em>'.
   * @see cruise.umple.umple.Position
   * @generated
   */
  EClass getPosition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.Position#getA <em>A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>A</em>'.
   * @see cruise.umple.umple.Position#getA()
   * @see #getPosition()
   * @generated
   */
  EReference getPosition_A();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.Position#getC <em>C</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>C</em>'.
   * @see cruise.umple.umple.Position#getC()
   * @see #getPosition()
   * @generated
   */
  EReference getPosition_C();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ClassPosition <em>Class Position</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Position</em>'.
   * @see cruise.umple.umple.ClassPosition
   * @generated
   */
  EClass getClassPosition();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ClassPosition#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see cruise.umple.umple.ClassPosition#getX()
   * @see #getClassPosition()
   * @generated
   */
  EAttribute getClassPosition_X();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ClassPosition#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see cruise.umple.umple.ClassPosition#getY()
   * @see #getClassPosition()
   * @generated
   */
  EAttribute getClassPosition_Y();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ClassPosition#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width</em>'.
   * @see cruise.umple.umple.ClassPosition#getWidth()
   * @see #getClassPosition()
   * @generated
   */
  EAttribute getClassPosition_Width();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ClassPosition#getHeight <em>Height</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Height</em>'.
   * @see cruise.umple.umple.ClassPosition#getHeight()
   * @see #getClassPosition()
   * @generated
   */
  EAttribute getClassPosition_Height();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationPosition <em>Association Position</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Position</em>'.
   * @see cruise.umple.umple.AssociationPosition
   * @generated
   */
  EClass getAssociationPosition();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AssociationPosition#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Index</em>'.
   * @see cruise.umple.umple.AssociationPosition#getIndex()
   * @see #getAssociationPosition()
   * @generated
   */
  EAttribute getAssociationPosition_Index();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.AssociationPosition#getC1 <em>C1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>C1</em>'.
   * @see cruise.umple.umple.AssociationPosition#getC1()
   * @see #getAssociationPosition()
   * @generated
   */
  EReference getAssociationPosition_C1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.AssociationPosition#getC2 <em>C2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>C2</em>'.
   * @see cruise.umple.umple.AssociationPosition#getC2()
   * @see #getAssociationPosition()
   * @generated
   */
  EReference getAssociationPosition_C2();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Coordinate <em>Coordinate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Coordinate</em>'.
   * @see cruise.umple.umple.Coordinate
   * @generated
   */
  EClass getCoordinate();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Coordinate#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see cruise.umple.umple.Coordinate#getX()
   * @see #getCoordinate()
   * @generated
   */
  EAttribute getCoordinate_X();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Coordinate#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see cruise.umple.umple.Coordinate#getY()
   * @see #getCoordinate()
   * @generated
   */
  EAttribute getCoordinate_Y();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceDirective <em>Trace Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Directive</em>'.
   * @see cruise.umple.umple.TraceDirective
   * @generated
   */
  EClass getTraceDirective();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceDirective#getTraceStart <em>Trace Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace Start</em>'.
   * @see cruise.umple.umple.TraceDirective#getTraceStart()
   * @see #getTraceDirective()
   * @generated
   */
  EAttribute getTraceDirective_TraceStart();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceDirective#getModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Model Element</em>'.
   * @see cruise.umple.umple.TraceDirective#getModelElement()
   * @see #getTraceDirective()
   * @generated
   */
  EReference getTraceDirective_ModelElement();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.TraceDirective#getConditionRHS <em>Condition RHS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition RHS</em>'.
   * @see cruise.umple.umple.TraceDirective#getConditionRHS()
   * @see #getTraceDirective()
   * @generated
   */
  EReference getTraceDirective_ConditionRHS();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceDirective#getElementPattern <em>Element Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Element Pattern</em>'.
   * @see cruise.umple.umple.TraceDirective#getElementPattern()
   * @see #getTraceDirective()
   * @generated
   */
  EAttribute getTraceDirective_ElementPattern();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceCase <em>Trace Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Case</em>'.
   * @see cruise.umple.umple.TraceCase
   * @generated
   */
  EClass getTraceCase();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceCase#getTraceCaseName <em>Trace Case Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace Case Name</em>'.
   * @see cruise.umple.umple.TraceCase#getTraceCaseName()
   * @see #getTraceCase()
   * @generated
   */
  EAttribute getTraceCase_TraceCaseName();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.TraceCase#getTraceDirective <em>Trace Directive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Trace Directive</em>'.
   * @see cruise.umple.umple.TraceCase#getTraceDirective()
   * @see #getTraceCase()
   * @generated
   */
  EReference getTraceCase_TraceDirective();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceRecord <em>Trace Record</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Record</em>'.
   * @see cruise.umple.umple.TraceRecord
   * @generated
   */
  EClass getTraceRecord();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceRecord#getObjectBeingTraced <em>Object Being Traced</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Object Being Traced</em>'.
   * @see cruise.umple.umple.TraceRecord#getObjectBeingTraced()
   * @see #getTraceRecord()
   * @generated
   */
  EAttribute getTraceRecord_ObjectBeingTraced();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceRecord#getTextOutput <em>Text Output</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text Output</em>'.
   * @see cruise.umple.umple.TraceRecord#getTextOutput()
   * @see #getTraceRecord()
   * @generated
   */
  EAttribute getTraceRecord_TextOutput();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceCondition <em>Trace Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Condition</em>'.
   * @see cruise.umple.umple.TraceCondition
   * @generated
   */
  EClass getTraceCondition();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.CompoundTraceCondition <em>Compound Trace Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compound Trace Condition</em>'.
   * @see cruise.umple.umple.CompoundTraceCondition
   * @generated
   */
  EClass getCompoundTraceCondition();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.CompoundTraceCondition#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operand</em>'.
   * @see cruise.umple.umple.CompoundTraceCondition#getOperand()
   * @see #getCompoundTraceCondition()
   * @generated
   */
  EAttribute getCompoundTraceCondition_Operand();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SimpleTraceCondition <em>Simple Trace Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Trace Condition</em>'.
   * @see cruise.umple.umple.SimpleTraceCondition
   * @generated
   */
  EClass getSimpleTraceCondition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.SimpleTraceCondition#getLhs <em>Lhs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Lhs</em>'.
   * @see cruise.umple.umple.SimpleTraceCondition#getLhs()
   * @see #getSimpleTraceCondition()
   * @generated
   */
  EReference getSimpleTraceCondition_Lhs();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.SimpleTraceCondition#getConditionRHS <em>Condition RHS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition RHS</em>'.
   * @see cruise.umple.umple.SimpleTraceCondition#getConditionRHS()
   * @see #getSimpleTraceCondition()
   * @generated
   */
  EReference getSimpleTraceCondition_ConditionRHS();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ConditionRHS <em>Condition RHS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Condition RHS</em>'.
   * @see cruise.umple.umple.ConditionRHS
   * @generated
   */
  EClass getConditionRHS();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ConditionRHS#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operand</em>'.
   * @see cruise.umple.umple.ConditionRHS#getOperand()
   * @see #getConditionRHS()
   * @generated
   */
  EAttribute getConditionRHS_Operand();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ConditionRHS#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see cruise.umple.umple.ConditionRHS#getValue()
   * @see #getConditionRHS()
   * @generated
   */
  EAttribute getConditionRHS_Value();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Element</em>'.
   * @see cruise.umple.umple.ModelElement
   * @generated
   */
  EClass getModelElement();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ModelElement#isExecuteOnEntry <em>Execute On Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Execute On Entry</em>'.
   * @see cruise.umple.umple.ModelElement#isExecuteOnEntry()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_ExecuteOnEntry();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ModelElement#isExecuteOnExit <em>Execute On Exit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Execute On Exit</em>'.
   * @see cruise.umple.umple.ModelElement#isExecuteOnExit()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_ExecuteOnExit();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ModelElement#isCflow <em>Cflow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Cflow</em>'.
   * @see cruise.umple.umple.ModelElement#isCflow()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_Cflow();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ModelElement#getAMethod <em>AMethod</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>AMethod</em>'.
   * @see cruise.umple.umple.ModelElement#getAMethod()
   * @see #getModelElement()
   * @generated
   */
  EAttribute getModelElement_AMethod();

  /**
   * Returns the meta object for the reference '{@link cruise.umple.umple.ModelElement#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Attribute</em>'.
   * @see cruise.umple.umple.ModelElement#getAttribute()
   * @see #getModelElement()
   * @generated
   */
  EReference getModelElement_Attribute();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.TraceMechanism <em>Trace Mechanism</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trace Mechanism</em>'.
   * @see cruise.umple.umple.TraceMechanism
   * @generated
   */
  EClass getTraceMechanism();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.TraceMechanism#getTraceMechanism <em>Trace Mechanism</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Trace Mechanism</em>'.
   * @see cruise.umple.umple.TraceMechanism#getTraceMechanism()
   * @see #getTraceMechanism()
   * @generated
   */
  EAttribute getTraceMechanism_TraceMechanism();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.block <em>block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>block</em>'.
   * @see cruise.umple.umple.block
   * @generated
   */
  EClass getblock();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.block#getBlocks <em>Blocks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Blocks</em>'.
   * @see cruise.umple.umple.block#getBlocks()
   * @see #getblock()
   * @generated
   */
  EReference getblock_Blocks();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.parExpression <em>par Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>par Expression</em>'.
   * @see cruise.umple.umple.parExpression
   * @generated
   */
  EClass getparExpression();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.expressionList <em>expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>expression List</em>'.
   * @see cruise.umple.umple.expressionList
   * @generated
   */
  EClass getexpressionList();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.expressionList#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see cruise.umple.umple.expressionList#getExpressions()
   * @see #getexpressionList()
   * @generated
   */
  EReference getexpressionList_Expressions();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.expression <em>expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>expression</em>'.
   * @see cruise.umple.umple.expression
   * @generated
   */
  EClass getexpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.expression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.umple.expression#getExpression1()
   * @see #getexpression()
   * @generated
   */
  EReference getexpression_Expression1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.expression#getExpression2 <em>Expression2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression2</em>'.
   * @see cruise.umple.umple.expression#getExpression2()
   * @see #getexpression()
   * @generated
   */
  EReference getexpression_Expression2();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.conditionalExpression <em>conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>conditional Expression</em>'.
   * @see cruise.umple.umple.conditionalExpression
   * @generated
   */
  EClass getconditionalExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.conditionalExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.umple.conditionalExpression#getExpression1()
   * @see #getconditionalExpression()
   * @generated
   */
  EReference getconditionalExpression_Expression1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.conditionalExpression#getExpression2 <em>Expression2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression2</em>'.
   * @see cruise.umple.umple.conditionalExpression#getExpression2()
   * @see #getconditionalExpression()
   * @generated
   */
  EReference getconditionalExpression_Expression2();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.conditionalExpression#getExpression3 <em>Expression3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression3</em>'.
   * @see cruise.umple.umple.conditionalExpression#getExpression3()
   * @see #getconditionalExpression()
   * @generated
   */
  EReference getconditionalExpression_Expression3();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.conditionalOrExpression <em>conditional Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>conditional Or Expression</em>'.
   * @see cruise.umple.umple.conditionalOrExpression
   * @generated
   */
  EClass getconditionalOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.conditionalOrExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.umple.conditionalOrExpression#getExpression1()
   * @see #getconditionalOrExpression()
   * @generated
   */
  EReference getconditionalOrExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.conditionalOrExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.umple.conditionalOrExpression#getExpressionRest()
   * @see #getconditionalOrExpression()
   * @generated
   */
  EReference getconditionalOrExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.conditionalAndExpression <em>conditional And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>conditional And Expression</em>'.
   * @see cruise.umple.umple.conditionalAndExpression
   * @generated
   */
  EClass getconditionalAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.conditionalAndExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.umple.conditionalAndExpression#getExpression1()
   * @see #getconditionalAndExpression()
   * @generated
   */
  EReference getconditionalAndExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.conditionalAndExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.umple.conditionalAndExpression#getExpressionRest()
   * @see #getconditionalAndExpression()
   * @generated
   */
  EReference getconditionalAndExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.equalityExpression <em>equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>equality Expression</em>'.
   * @see cruise.umple.umple.equalityExpression
   * @generated
   */
  EClass getequalityExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.equalityExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.umple.equalityExpression#getExpression1()
   * @see #getequalityExpression()
   * @generated
   */
  EReference getequalityExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.equalityExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.umple.equalityExpression#getExpressionRest()
   * @see #getequalityExpression()
   * @generated
   */
  EReference getequalityExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.relationalExpression <em>relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>relational Expression</em>'.
   * @see cruise.umple.umple.relationalExpression
   * @generated
   */
  EClass getrelationalExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.relationalExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.umple.relationalExpression#getExpression1()
   * @see #getrelationalExpression()
   * @generated
   */
  EReference getrelationalExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.relationalExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.umple.relationalExpression#getExpressionRest()
   * @see #getrelationalExpression()
   * @generated
   */
  EReference getrelationalExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.additiveExpression <em>additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>additive Expression</em>'.
   * @see cruise.umple.umple.additiveExpression
   * @generated
   */
  EClass getadditiveExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.additiveExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.umple.additiveExpression#getExpression1()
   * @see #getadditiveExpression()
   * @generated
   */
  EReference getadditiveExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.additiveExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.umple.additiveExpression#getExpressionRest()
   * @see #getadditiveExpression()
   * @generated
   */
  EReference getadditiveExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.multiplicativeExpression <em>multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>multiplicative Expression</em>'.
   * @see cruise.umple.umple.multiplicativeExpression
   * @generated
   */
  EClass getmultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.multiplicativeExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.umple.multiplicativeExpression#getExpression1()
   * @see #getmultiplicativeExpression()
   * @generated
   */
  EReference getmultiplicativeExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.multiplicativeExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.umple.multiplicativeExpression#getExpressionRest()
   * @see #getmultiplicativeExpression()
   * @generated
   */
  EReference getmultiplicativeExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.unaryExpression <em>unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>unary Expression</em>'.
   * @see cruise.umple.umple.unaryExpression
   * @generated
   */
  EClass getunaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.unaryExpression#getExp1 <em>Exp1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp1</em>'.
   * @see cruise.umple.umple.unaryExpression#getExp1()
   * @see #getunaryExpression()
   * @generated
   */
  EReference getunaryExpression_Exp1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.unaryExpression#getExp2 <em>Exp2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp2</em>'.
   * @see cruise.umple.umple.unaryExpression#getExp2()
   * @see #getunaryExpression()
   * @generated
   */
  EReference getunaryExpression_Exp2();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.unaryExpressionNotPlusMinus <em>unary Expression Not Plus Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>unary Expression Not Plus Minus</em>'.
   * @see cruise.umple.umple.unaryExpressionNotPlusMinus
   * @generated
   */
  EClass getunaryExpressionNotPlusMinus();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.primary <em>primary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>primary</em>'.
   * @see cruise.umple.umple.primary
   * @generated
   */
  EClass getprimary();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.literal <em>literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>literal</em>'.
   * @see cruise.umple.umple.literal
   * @generated
   */
  EClass getliteral();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.functionCall <em>function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>function Call</em>'.
   * @see cruise.umple.umple.functionCall
   * @generated
   */
  EClass getfunctionCall();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.functionDeclaration <em>function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>function Declaration</em>'.
   * @see cruise.umple.umple.functionDeclaration
   * @generated
   */
  EClass getfunctionDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.functionDeclaration#getJava <em>Java</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Java</em>'.
   * @see cruise.umple.umple.functionDeclaration#getJava()
   * @see #getfunctionDeclaration()
   * @generated
   */
  EReference getfunctionDeclaration_Java();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.functionDefinition <em>function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>function Definition</em>'.
   * @see cruise.umple.umple.functionDefinition
   * @generated
   */
  EClass getfunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.functionDefinition#getJava <em>Java</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Java</em>'.
   * @see cruise.umple.umple.functionDefinition#getJava()
   * @see #getfunctionDefinition()
   * @generated
   */
  EReference getfunctionDefinition_Java();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.javaFunctionDeclaration <em>java Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>java Function Declaration</em>'.
   * @see cruise.umple.umple.javaFunctionDeclaration
   * @generated
   */
  EClass getjavaFunctionDeclaration();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.javaFunctionDeclaration#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Return Type</em>'.
   * @see cruise.umple.umple.javaFunctionDeclaration#getReturnType()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_ReturnType();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.javaFunctionDeclaration#getReferenceType <em>Reference Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reference Type</em>'.
   * @see cruise.umple.umple.javaFunctionDeclaration#getReferenceType()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_ReferenceType();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.javaFunctionDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.javaFunctionDeclaration#getName()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_Name();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.javaFunctionDeclaration#getArgList <em>Arg List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Arg List</em>'.
   * @see cruise.umple.umple.javaFunctionDeclaration#getArgList()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_ArgList();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.umple.javaFunctionDeclaration#getArgListID <em>Arg List ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Arg List ID</em>'.
   * @see cruise.umple.umple.javaFunctionDeclaration#getArgListID()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_ArgListID();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.javaFunctionDefinition <em>java Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>java Function Definition</em>'.
   * @see cruise.umple.umple.javaFunctionDefinition
   * @generated
   */
  EClass getjavaFunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.javaFunctionDefinition#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl</em>'.
   * @see cruise.umple.umple.javaFunctionDefinition#getDecl()
   * @see #getjavaFunctionDefinition()
   * @generated
   */
  EReference getjavaFunctionDefinition_Decl();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.javaFunctionDefinition#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see cruise.umple.umple.javaFunctionDefinition#getCode()
   * @see #getjavaFunctionDefinition()
   * @generated
   */
  EReference getjavaFunctionDefinition_Code();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.javaFunctionCall <em>java Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>java Function Call</em>'.
   * @see cruise.umple.umple.javaFunctionCall
   * @generated
   */
  EClass getjavaFunctionCall();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.javaFunctionCall#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.javaFunctionCall#getName()
   * @see #getjavaFunctionCall()
   * @generated
   */
  EAttribute getjavaFunctionCall_Name();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.javaFunctionCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Args</em>'.
   * @see cruise.umple.umple.javaFunctionCall#getArgs()
   * @see #getjavaFunctionCall()
   * @generated
   */
  EReference getjavaFunctionCall_Args();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.blockStatement <em>block Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>block Statement</em>'.
   * @see cruise.umple.umple.blockStatement
   * @generated
   */
  EClass getblockStatement();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.localVariableDeclarationStatement <em>local Variable Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>local Variable Declaration Statement</em>'.
   * @see cruise.umple.umple.localVariableDeclarationStatement
   * @generated
   */
  EClass getlocalVariableDeclarationStatement();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.localVariableDeclaration <em>local Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>local Variable Declaration</em>'.
   * @see cruise.umple.umple.localVariableDeclaration
   * @generated
   */
  EClass getlocalVariableDeclaration();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.localVariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see cruise.umple.umple.localVariableDeclaration#getType()
   * @see #getlocalVariableDeclaration()
   * @generated
   */
  EAttribute getlocalVariableDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.localVariableDeclaration#getDec <em>Dec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dec</em>'.
   * @see cruise.umple.umple.localVariableDeclaration#getDec()
   * @see #getlocalVariableDeclaration()
   * @generated
   */
  EReference getlocalVariableDeclaration_Dec();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.variableDeclarators <em>variable Declarators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>variable Declarators</em>'.
   * @see cruise.umple.umple.variableDeclarators
   * @generated
   */
  EClass getvariableDeclarators();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.variableDeclarators#getVd <em>Vd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vd</em>'.
   * @see cruise.umple.umple.variableDeclarators#getVd()
   * @see #getvariableDeclarators()
   * @generated
   */
  EReference getvariableDeclarators_Vd();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.variableDeclarator <em>variable Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>variable Declarator</em>'.
   * @see cruise.umple.umple.variableDeclarator
   * @generated
   */
  EClass getvariableDeclarator();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.variableDeclarator#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.variableDeclarator#getName()
   * @see #getvariableDeclarator()
   * @generated
   */
  EAttribute getvariableDeclarator_Name();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.variableDeclarator#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see cruise.umple.umple.variableDeclarator#getExp()
   * @see #getvariableDeclarator()
   * @generated
   */
  EReference getvariableDeclarator_Exp();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.statement <em>statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>statement</em>'.
   * @see cruise.umple.umple.statement
   * @generated
   */
  EClass getstatement();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.statement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see cruise.umple.umple.statement#getCondition()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_Condition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.statement#getState1 <em>State1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State1</em>'.
   * @see cruise.umple.umple.statement#getState1()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_State1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.statement#getState2 <em>State2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State2</em>'.
   * @see cruise.umple.umple.statement#getState2()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_State2();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.statement#getControl <em>Control</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Control</em>'.
   * @see cruise.umple.umple.statement#getControl()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_Control();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.statement#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State</em>'.
   * @see cruise.umple.umple.statement#getState()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_State();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.statement#getRetVal <em>Ret Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ret Val</em>'.
   * @see cruise.umple.umple.statement#getRetVal()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_RetVal();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.statement#getTryBlock <em>Try Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Try Block</em>'.
   * @see cruise.umple.umple.statement#getTryBlock()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_TryBlock();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.statement#getCatchBlock <em>Catch Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Catch Block</em>'.
   * @see cruise.umple.umple.statement#getCatchBlock()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_CatchBlock();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.forControl <em>for Control</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>for Control</em>'.
   * @see cruise.umple.umple.forControl
   * @generated
   */
  EClass getforControl();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.forControl#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see cruise.umple.umple.forControl#getInit()
   * @see #getforControl()
   * @generated
   */
  EReference getforControl_Init();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.forControl#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see cruise.umple.umple.forControl#getCondition()
   * @see #getforControl()
   * @generated
   */
  EReference getforControl_Condition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.umple.forControl#getUpdate <em>Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Update</em>'.
   * @see cruise.umple.umple.forControl#getUpdate()
   * @see #getforControl()
   * @generated
   */
  EReference getforControl_Update();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.forInit <em>for Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>for Init</em>'.
   * @see cruise.umple.umple.forInit
   * @generated
   */
  EClass getforInit();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.forInit#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see cruise.umple.umple.forInit#getExpressions()
   * @see #getforInit()
   * @generated
   */
  EReference getforInit_Expressions();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.forUpdate <em>for Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>for Update</em>'.
   * @see cruise.umple.umple.forUpdate
   * @generated
   */
  EClass getforUpdate();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.phpFunction <em>php Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>php Function</em>'.
   * @see cruise.umple.umple.phpFunction
   * @generated
   */
  EClass getphpFunction();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.phpFunction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.phpFunction#getName()
   * @see #getphpFunction()
   * @generated
   */
  EAttribute getphpFunction_Name();

  /**
   * Returns the meta object for the reference '{@link cruise.umple.umple.phpFunction#getCodeblock <em>Codeblock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Codeblock</em>'.
   * @see cruise.umple.umple.phpFunction#getCodeblock()
   * @see #getphpFunction()
   * @generated
   */
  EReference getphpFunction_Codeblock();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.phpBlock <em>php Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>php Block</em>'.
   * @see cruise.umple.umple.phpBlock
   * @generated
   */
  EClass getphpBlock();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.phpBlock#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code</em>'.
   * @see cruise.umple.umple.phpBlock#getCode()
   * @see #getphpBlock()
   * @generated
   */
  EAttribute getphpBlock_Code();

  /**
   * Returns the meta object for enum '{@link cruise.umple.umple.Modifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Modifier</em>'.
   * @see cruise.umple.umple.Modifier
   * @generated
   */
  EEnum getModifier();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  UmpleFactory getUmpleFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.UmpleModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UmpleModelImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleModel()
     * @generated
     */
    EClass UMPLE_MODEL = eINSTANCE.getUmpleModel();

    /**
     * The meta object literal for the '<em><b>Namespace</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__NAMESPACE = eINSTANCE.getUmpleModel_Namespace();

    /**
     * The meta object literal for the '<em><b>Glossary</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__GLOSSARY = eINSTANCE.getUmpleModel_Glossary();

    /**
     * The meta object literal for the '<em><b>Generate </b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__GENERATE_ = eINSTANCE.getUmpleModel_Generate_();

    /**
     * The meta object literal for the '<em><b>Trace Mechanism</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__TRACE_MECHANISM = eINSTANCE.getUmpleModel_TraceMechanism();

    /**
     * The meta object literal for the '<em><b>Uses</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_MODEL__USES = eINSTANCE.getUmpleModel_Uses();

    /**
     * The meta object literal for the '<em><b>Umple Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__UMPLE_ELEMENTS = eINSTANCE.getUmpleModel_UmpleElements();

    /**
     * The meta object literal for the '<em><b>Associations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__ASSOCIATIONS = eINSTANCE.getUmpleModel_Associations();

    /**
     * The meta object literal for the '<em><b>Association Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__ASSOCIATION_CLASSES = eINSTANCE.getUmpleModel_AssociationClasses();

    /**
     * The meta object literal for the '<em><b>Statemachines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__STATEMACHINES = eINSTANCE.getUmpleModel_Statemachines();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.UmpleElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UmpleElementImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleElement()
     * @generated
     */
    EClass UMPLE_ELEMENT = eINSTANCE.getUmpleElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ELEMENT__NAME = eINSTANCE.getUmpleElement_Name();

    /**
     * The meta object literal for the '<em><b>Depends</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_ELEMENT__DEPENDS = eINSTANCE.getUmpleElement_Depends();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.WordImpl <em>Word</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.WordImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getWord()
     * @generated
     */
    EClass WORD = eINSTANCE.getWord();

    /**
     * The meta object literal for the '<em><b>Singular</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WORD__SINGULAR = eINSTANCE.getWord_Singular();

    /**
     * The meta object literal for the '<em><b>Plural</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WORD__PLURAL = eINSTANCE.getWord_Plural();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.GlossaryImpl <em>Glossary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.GlossaryImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getGlossary()
     * @generated
     */
    EClass GLOSSARY = eINSTANCE.getGlossary();

    /**
     * The meta object literal for the '<em><b>Words</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GLOSSARY__WORDS = eINSTANCE.getGlossary_Words();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.GenerateImpl <em>Generate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.GenerateImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getGenerate()
     * @generated
     */
    EClass GENERATE = eINSTANCE.getGenerate();

    /**
     * The meta object literal for the '<em><b>Java</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATE__JAVA = eINSTANCE.getGenerate_Java();

    /**
     * The meta object literal for the '<em><b>Php</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATE__PHP = eINSTANCE.getGenerate_Php();

    /**
     * The meta object literal for the '<em><b>Ruby</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GENERATE__RUBY = eINSTANCE.getGenerate_Ruby();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.NamespaceImpl <em>Namespace</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.NamespaceImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getNamespace()
     * @generated
     */
    EClass NAMESPACE = eINSTANCE.getNamespace();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMESPACE__VALUE = eINSTANCE.getNamespace_Value();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.UmpleClassImpl <em>Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UmpleClassImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleClass()
     * @generated
     */
    EClass UMPLE_CLASS = eINSTANCE.getUmpleClass();

    /**
     * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_CLASS__PACKAGE_NAME = eINSTANCE.getUmpleClass_PackageName();

    /**
     * The meta object literal for the '<em><b>External</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_CLASS__EXTERNAL = eINSTANCE.getUmpleClass_External();

    /**
     * The meta object literal for the '<em><b>Singleton</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_CLASS__SINGLETON = eINSTANCE.getUmpleClass_Singleton();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__KEY = eINSTANCE.getUmpleClass_Key();

    /**
     * The meta object literal for the '<em><b>Code Injection</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__CODE_INJECTION = eINSTANCE.getUmpleClass_CodeInjection();

    /**
     * The meta object literal for the '<em><b>Extends Class</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__EXTENDS_CLASS = eINSTANCE.getUmpleClass_ExtendsClass();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__ATTRIBUTES = eINSTANCE.getUmpleClass_Attributes();

    /**
     * The meta object literal for the '<em><b>Symmetric Reflexive Associations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__SYMMETRIC_REFLEXIVE_ASSOCIATIONS = eINSTANCE.getUmpleClass_SymmetricReflexiveAssociations();

    /**
     * The meta object literal for the '<em><b>Inline Associations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__INLINE_ASSOCIATIONS = eINSTANCE.getUmpleClass_InlineAssociations();

    /**
     * The meta object literal for the '<em><b>Positions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__POSITIONS = eINSTANCE.getUmpleClass_Positions();

    /**
     * The meta object literal for the '<em><b>State Machines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__STATE_MACHINES = eINSTANCE.getUmpleClass_StateMachines();

    /**
     * The meta object literal for the '<em><b>Trace Directives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__TRACE_DIRECTIVES = eINSTANCE.getUmpleClass_TraceDirectives();

    /**
     * The meta object literal for the '<em><b>Trace Cases</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__TRACE_CASES = eINSTANCE.getUmpleClass_TraceCases();

    /**
     * The meta object literal for the '<em><b>External Language</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_CLASS__EXTERNAL_LANGUAGE = eINSTANCE.getUmpleClass_ExternalLanguage();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ExternalLanguageImpl <em>External Language</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ExternalLanguageImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getExternalLanguage()
     * @generated
     */
    EClass EXTERNAL_LANGUAGE = eINSTANCE.getExternalLanguage();

    /**
     * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_LANGUAGE__FUNCTIONS = eINSTANCE.getExternalLanguage_Functions();

    /**
     * The meta object literal for the '<em><b>Ruby Functions</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_LANGUAGE__RUBY_FUNCTIONS = eINSTANCE.getExternalLanguage_RubyFunctions();

    /**
     * The meta object literal for the '<em><b>Php Functions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_LANGUAGE__PHP_FUNCTIONS = eINSTANCE.getExternalLanguage_PhpFunctions();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.UmpleInterfaceImpl <em>Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UmpleInterfaceImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleInterface()
     * @generated
     */
    EClass UMPLE_INTERFACE = eINSTANCE.getUmpleInterface();

    /**
     * The meta object literal for the '<em><b>Extends Interface</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_INTERFACE__EXTENDS_INTERFACE = eINSTANCE.getUmpleInterface_ExtendsInterface();

    /**
     * The meta object literal for the '<em><b>Extra Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_INTERFACE__EXTRA_CODE = eINSTANCE.getUmpleInterface_ExtraCode();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.UmpleAssociationImpl <em>Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UmpleAssociationImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleAssociation()
     * @generated
     */
    EClass UMPLE_ASSOCIATION = eINSTANCE.getUmpleAssociation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ASSOCIATION__NAME = eINSTANCE.getUmpleAssociation_Name();

    /**
     * The meta object literal for the '<em><b>Associations</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_ASSOCIATION__ASSOCIATIONS = eINSTANCE.getUmpleAssociation_Associations();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.UmpleAssociationClassImpl <em>Association Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UmpleAssociationClassImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleAssociationClass()
     * @generated
     */
    EClass UMPLE_ASSOCIATION_CLASS = eINSTANCE.getUmpleAssociationClass();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ASSOCIATION_CLASS__NAME = eINSTANCE.getUmpleAssociationClass_Name();

    /**
     * The meta object literal for the '<em><b>Association Class Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_ASSOCIATION_CLASS__ASSOCIATION_CLASS_CONTENTS = eINSTANCE.getUmpleAssociationClass_AssociationClassContents();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.associationClassContentImpl <em>association Class Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.associationClassContentImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getassociationClassContent()
     * @generated
     */
    EClass ASSOCIATION_CLASS_CONTENT = eINSTANCE.getassociationClassContent();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.AssociationImpl <em>Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.AssociationImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociation()
     * @generated
     */
    EClass ASSOCIATION = eINSTANCE.getAssociation();

    /**
     * The meta object literal for the '<em><b>Type1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION__TYPE1 = eINSTANCE.getAssociation_Type1();

    /**
     * The meta object literal for the '<em><b>Rolename1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION__ROLENAME1 = eINSTANCE.getAssociation_Rolename1();

    /**
     * The meta object literal for the '<em><b>Type2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION__TYPE2 = eINSTANCE.getAssociation_Type2();

    /**
     * The meta object literal for the '<em><b>Rolename2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION__ROLENAME2 = eINSTANCE.getAssociation_Rolename2();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.SymmetricReflexiveAssociationImpl <em>Symmetric Reflexive Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.SymmetricReflexiveAssociationImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getSymmetricReflexiveAssociation()
     * @generated
     */
    EClass SYMMETRIC_REFLEXIVE_ASSOCIATION = eINSTANCE.getSymmetricReflexiveAssociation();

    /**
     * The meta object literal for the '<em><b>Rolename</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SYMMETRIC_REFLEXIVE_ASSOCIATION__ROLENAME = eINSTANCE.getSymmetricReflexiveAssociation_Rolename();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.InlineAssociationImpl <em>Inline Association</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.InlineAssociationImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineAssociation()
     * @generated
     */
    EClass INLINE_ASSOCIATION = eINSTANCE.getInlineAssociation();

    /**
     * The meta object literal for the '<em><b>Rolename1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INLINE_ASSOCIATION__ROLENAME1 = eINSTANCE.getInlineAssociation_Rolename1();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INLINE_ASSOCIATION__TYPE = eINSTANCE.getInlineAssociation_Type();

    /**
     * The meta object literal for the '<em><b>Rolename2</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INLINE_ASSOCIATION__ROLENAME2 = eINSTANCE.getInlineAssociation_Rolename2();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.singleAssociationEndImpl <em>single Association End</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.singleAssociationEndImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getsingleAssociationEnd()
     * @generated
     */
    EClass SINGLE_ASSOCIATION_END = eINSTANCE.getsingleAssociationEnd();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_ASSOCIATION_END__TYPE = eINSTANCE.getsingleAssociationEnd_Type();

    /**
     * The meta object literal for the '<em><b>Rolename</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_ASSOCIATION_END__ROLENAME = eINSTANCE.getsingleAssociationEnd_Rolename();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.SingletonImpl <em>Singleton</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.SingletonImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getSingleton()
     * @generated
     */
    EClass SINGLETON = eINSTANCE.getSingleton();

    /**
     * The meta object literal for the '<em><b>Singleton</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLETON__SINGLETON = eINSTANCE.getSingleton_Singleton();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.CodeInjectionImpl <em>Code Injection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.CodeInjectionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getCodeInjection()
     * @generated
     */
    EClass CODE_INJECTION = eINSTANCE.getCodeInjection();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODE_INJECTION__NAME = eINSTANCE.getCodeInjection_Name();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CODE_INJECTION__CODE = eINSTANCE.getCodeInjection_Code();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.UmpleAttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UmpleAttributeImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleAttribute()
     * @generated
     */
    EClass UMPLE_ATTRIBUTE = eINSTANCE.getUmpleAttribute();

    /**
     * The meta object literal for the '<em><b>Autounique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ATTRIBUTE__AUTOUNIQUE = eINSTANCE.getUmpleAttribute_Autounique();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ATTRIBUTE__NAME = eINSTANCE.getUmpleAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ATTRIBUTE__UNIQUE = eINSTANCE.getUmpleAttribute_Unique();

    /**
     * The meta object literal for the '<em><b>Modifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ATTRIBUTE__MODIFIER = eINSTANCE.getUmpleAttribute_Modifier();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ATTRIBUTE__TYPE = eINSTANCE.getUmpleAttribute_Type();

    /**
     * The meta object literal for the '<em><b>List</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ATTRIBUTE__LIST = eINSTANCE.getUmpleAttribute_List();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_ATTRIBUTE__OBJECT = eINSTANCE.getUmpleAttribute_Object();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UMPLE_ATTRIBUTE__VALUE = eINSTANCE.getUmpleAttribute_Value();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.KeyImpl <em>Key</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.KeyImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getKey()
     * @generated
     */
    EClass KEY = eINSTANCE.getKey();

    /**
     * The meta object literal for the '<em><b>Keys</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY__KEYS = eINSTANCE.getKey_Keys();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.DependImpl <em>Depend</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.DependImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getDepend()
     * @generated
     */
    EClass DEPEND = eINSTANCE.getDepend();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEPEND__NAME = eINSTANCE.getDepend_Name();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.StateMachineDefinitionImpl <em>State Machine Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.StateMachineDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getStateMachineDefinition()
     * @generated
     */
    EClass STATE_MACHINE_DEFINITION = eINSTANCE.getStateMachineDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_MACHINE_DEFINITION__NAME = eINSTANCE.getStateMachineDefinition_Name();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_MACHINE_DEFINITION__STATES = eINSTANCE.getStateMachineDefinition_States();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.StateMachineImpl <em>State Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.StateMachineImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getStateMachine()
     * @generated
     */
    EClass STATE_MACHINE = eINSTANCE.getStateMachine();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE_MACHINE__NAME = eINSTANCE.getStateMachine_Name();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.InlineStateMachineImpl <em>Inline State Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.InlineStateMachineImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineStateMachine()
     * @generated
     */
    EClass INLINE_STATE_MACHINE = eINSTANCE.getInlineStateMachine();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INLINE_STATE_MACHINE__STATES = eINSTANCE.getInlineStateMachine_States();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ReferencedStateMachineImpl <em>Referenced State Machine</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ReferencedStateMachineImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getReferencedStateMachine()
     * @generated
     */
    EClass REFERENCED_STATE_MACHINE = eINSTANCE.getReferencedStateMachine();

    /**
     * The meta object literal for the '<em><b>Machine</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCED_STATE_MACHINE__MACHINE = eINSTANCE.getReferencedStateMachine_Machine();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ENUMImpl <em>ENUM</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ENUMImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getENUM()
     * @generated
     */
    EClass ENUM = eINSTANCE.getENUM();

    /**
     * The meta object literal for the '<em><b>State1</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM__STATE1 = eINSTANCE.getENUM_State1();

    /**
     * The meta object literal for the '<em><b>States</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM__STATES = eINSTANCE.getENUM_States();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.StateImpl <em>State</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.StateImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getState()
     * @generated
     */
    EClass STATE = eINSTANCE.getState();

    /**
     * The meta object literal for the '<em><b>State Trace Directive</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__STATE_TRACE_DIRECTIVE = eINSTANCE.getState_StateTraceDirective();

    /**
     * The meta object literal for the '<em><b>State Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STATE__STATE_NAME = eINSTANCE.getState_StateName();

    /**
     * The meta object literal for the '<em><b>States</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE__STATES = eINSTANCE.getState_States();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.StateEntityImpl <em>State Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.StateEntityImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getStateEntity()
     * @generated
     */
    EClass STATE_ENTITY = eINSTANCE.getStateEntity();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_ENTITY__EXPRESSION = eINSTANCE.getStateEntity_Expression();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.TransitionImpl <em>Transition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.TransitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getTransition()
     * @generated
     */
    EClass TRANSITION = eINSTANCE.getTransition();

    /**
     * The meta object literal for the '<em><b>A</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION__A = eINSTANCE.getTransition_A();

    /**
     * The meta object literal for the '<em><b>State Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSITION__STATE_NAME = eINSTANCE.getTransition_StateName();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.EventDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getEventDefinition()
     * @generated
     */
    EClass EVENT_DEFINITION = eINSTANCE.getEventDefinition();

    /**
     * The meta object literal for the '<em><b>G</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_DEFINITION__G = eINSTANCE.getEventDefinition_G();

    /**
     * The meta object literal for the '<em><b>Event ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_DEFINITION__EVENT_ID = eINSTANCE.getEventDefinition_EventID();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ActionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getAction()
     * @generated
     */
    EClass ACTION = eINSTANCE.getAction();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTION__CODE = eINSTANCE.getAction_Code();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.EntryOrExitActionImpl <em>Entry Or Exit Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.EntryOrExitActionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getEntryOrExitAction()
     * @generated
     */
    EClass ENTRY_OR_EXIT_ACTION = eINSTANCE.getEntryOrExitAction();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTRY_OR_EXIT_ACTION__TYPE = eINSTANCE.getEntryOrExitAction_Type();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTRY_OR_EXIT_ACTION__CODE = eINSTANCE.getEntryOrExitAction_Code();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ActivityImpl <em>Activity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ActivityImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getActivity()
     * @generated
     */
    EClass ACTIVITY = eINSTANCE.getActivity();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTIVITY__CODE = eINSTANCE.getActivity_Code();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.GuardImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getGuard()
     * @generated
     */
    EClass GUARD = eINSTANCE.getGuard();

    /**
     * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__EVENTS = eINSTANCE.getGuard_Events();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.GuardCodeImpl <em>Guard Code</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.GuardCodeImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getGuardCode()
     * @generated
     */
    EClass GUARD_CODE = eINSTANCE.getGuardCode();

    /**
     * The meta object literal for the '<em><b>Native Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD_CODE__NATIVE_EXPRESSION = eINSTANCE.getGuardCode_NativeExpression();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.PositionImpl <em>Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.PositionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getPosition()
     * @generated
     */
    EClass POSITION = eINSTANCE.getPosition();

    /**
     * The meta object literal for the '<em><b>A</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSITION__A = eINSTANCE.getPosition_A();

    /**
     * The meta object literal for the '<em><b>C</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POSITION__C = eINSTANCE.getPosition_C();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ClassPositionImpl <em>Class Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ClassPositionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getClassPosition()
     * @generated
     */
    EClass CLASS_POSITION = eINSTANCE.getClassPosition();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_POSITION__X = eINSTANCE.getClassPosition_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_POSITION__Y = eINSTANCE.getClassPosition_Y();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_POSITION__WIDTH = eINSTANCE.getClassPosition_Width();

    /**
     * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASS_POSITION__HEIGHT = eINSTANCE.getClassPosition_Height();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.AssociationPositionImpl <em>Association Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.AssociationPositionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationPosition()
     * @generated
     */
    EClass ASSOCIATION_POSITION = eINSTANCE.getAssociationPosition();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION_POSITION__INDEX = eINSTANCE.getAssociationPosition_Index();

    /**
     * The meta object literal for the '<em><b>C1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_POSITION__C1 = eINSTANCE.getAssociationPosition_C1();

    /**
     * The meta object literal for the '<em><b>C2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_POSITION__C2 = eINSTANCE.getAssociationPosition_C2();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.CoordinateImpl <em>Coordinate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.CoordinateImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getCoordinate()
     * @generated
     */
    EClass COORDINATE = eINSTANCE.getCoordinate();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COORDINATE__X = eINSTANCE.getCoordinate_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COORDINATE__Y = eINSTANCE.getCoordinate_Y();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.TraceDirectiveImpl <em>Trace Directive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.TraceDirectiveImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceDirective()
     * @generated
     */
    EClass TRACE_DIRECTIVE = eINSTANCE.getTraceDirective();

    /**
     * The meta object literal for the '<em><b>Trace Start</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRACE_DIRECTIVE__TRACE_START = eINSTANCE.getTraceDirective_TraceStart();

    /**
     * The meta object literal for the '<em><b>Model Element</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRACE_DIRECTIVE__MODEL_ELEMENT = eINSTANCE.getTraceDirective_ModelElement();

    /**
     * The meta object literal for the '<em><b>Condition RHS</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRACE_DIRECTIVE__CONDITION_RHS = eINSTANCE.getTraceDirective_ConditionRHS();

    /**
     * The meta object literal for the '<em><b>Element Pattern</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRACE_DIRECTIVE__ELEMENT_PATTERN = eINSTANCE.getTraceDirective_ElementPattern();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.TraceCaseImpl <em>Trace Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.TraceCaseImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCase()
     * @generated
     */
    EClass TRACE_CASE = eINSTANCE.getTraceCase();

    /**
     * The meta object literal for the '<em><b>Trace Case Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRACE_CASE__TRACE_CASE_NAME = eINSTANCE.getTraceCase_TraceCaseName();

    /**
     * The meta object literal for the '<em><b>Trace Directive</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRACE_CASE__TRACE_DIRECTIVE = eINSTANCE.getTraceCase_TraceDirective();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.TraceRecordImpl <em>Trace Record</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.TraceRecordImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceRecord()
     * @generated
     */
    EClass TRACE_RECORD = eINSTANCE.getTraceRecord();

    /**
     * The meta object literal for the '<em><b>Object Being Traced</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRACE_RECORD__OBJECT_BEING_TRACED = eINSTANCE.getTraceRecord_ObjectBeingTraced();

    /**
     * The meta object literal for the '<em><b>Text Output</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRACE_RECORD__TEXT_OUTPUT = eINSTANCE.getTraceRecord_TextOutput();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.TraceConditionImpl <em>Trace Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.TraceConditionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceCondition()
     * @generated
     */
    EClass TRACE_CONDITION = eINSTANCE.getTraceCondition();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.CompoundTraceConditionImpl <em>Compound Trace Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.CompoundTraceConditionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getCompoundTraceCondition()
     * @generated
     */
    EClass COMPOUND_TRACE_CONDITION = eINSTANCE.getCompoundTraceCondition();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPOUND_TRACE_CONDITION__OPERAND = eINSTANCE.getCompoundTraceCondition_Operand();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.SimpleTraceConditionImpl <em>Simple Trace Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.SimpleTraceConditionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getSimpleTraceCondition()
     * @generated
     */
    EClass SIMPLE_TRACE_CONDITION = eINSTANCE.getSimpleTraceCondition();

    /**
     * The meta object literal for the '<em><b>Lhs</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_TRACE_CONDITION__LHS = eINSTANCE.getSimpleTraceCondition_Lhs();

    /**
     * The meta object literal for the '<em><b>Condition RHS</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIMPLE_TRACE_CONDITION__CONDITION_RHS = eINSTANCE.getSimpleTraceCondition_ConditionRHS();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ConditionRHSImpl <em>Condition RHS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ConditionRHSImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getConditionRHS()
     * @generated
     */
    EClass CONDITION_RHS = eINSTANCE.getConditionRHS();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITION_RHS__OPERAND = eINSTANCE.getConditionRHS_Operand();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONDITION_RHS__VALUE = eINSTANCE.getConditionRHS_Value();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ModelElementImpl <em>Model Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ModelElementImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getModelElement()
     * @generated
     */
    EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

    /**
     * The meta object literal for the '<em><b>Execute On Entry</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__EXECUTE_ON_ENTRY = eINSTANCE.getModelElement_ExecuteOnEntry();

    /**
     * The meta object literal for the '<em><b>Execute On Exit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__EXECUTE_ON_EXIT = eINSTANCE.getModelElement_ExecuteOnExit();

    /**
     * The meta object literal for the '<em><b>Cflow</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__CFLOW = eINSTANCE.getModelElement_Cflow();

    /**
     * The meta object literal for the '<em><b>AMethod</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_ELEMENT__AMETHOD = eINSTANCE.getModelElement_AMethod();

    /**
     * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_ELEMENT__ATTRIBUTE = eINSTANCE.getModelElement_Attribute();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.TraceMechanismImpl <em>Trace Mechanism</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.TraceMechanismImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getTraceMechanism()
     * @generated
     */
    EClass TRACE_MECHANISM = eINSTANCE.getTraceMechanism();

    /**
     * The meta object literal for the '<em><b>Trace Mechanism</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRACE_MECHANISM__TRACE_MECHANISM = eINSTANCE.getTraceMechanism_TraceMechanism();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.blockImpl <em>block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.blockImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getblock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getblock();

    /**
     * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__BLOCKS = eINSTANCE.getblock_Blocks();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.parExpressionImpl <em>par Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.parExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getparExpression()
     * @generated
     */
    EClass PAR_EXPRESSION = eINSTANCE.getparExpression();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.expressionListImpl <em>expression List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.expressionListImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getexpressionList()
     * @generated
     */
    EClass EXPRESSION_LIST = eINSTANCE.getexpressionList();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LIST__EXPRESSIONS = eINSTANCE.getexpressionList_Expressions();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.expressionImpl <em>expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.expressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getexpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getexpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPRESSION1 = eINSTANCE.getexpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPRESSION2 = eINSTANCE.getexpression_Expression2();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.conditionalExpressionImpl <em>conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.conditionalExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getconditionalExpression()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION = eINSTANCE.getconditionalExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXPRESSION1 = eINSTANCE.getconditionalExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXPRESSION2 = eINSTANCE.getconditionalExpression_Expression2();

    /**
     * The meta object literal for the '<em><b>Expression3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXPRESSION3 = eINSTANCE.getconditionalExpression_Expression3();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.conditionalOrExpressionImpl <em>conditional Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.conditionalOrExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getconditionalOrExpression()
     * @generated
     */
    EClass CONDITIONAL_OR_EXPRESSION = eINSTANCE.getconditionalOrExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_OR_EXPRESSION__EXPRESSION1 = eINSTANCE.getconditionalOrExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_OR_EXPRESSION__EXPRESSION_REST = eINSTANCE.getconditionalOrExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.conditionalAndExpressionImpl <em>conditional And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.conditionalAndExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getconditionalAndExpression()
     * @generated
     */
    EClass CONDITIONAL_AND_EXPRESSION = eINSTANCE.getconditionalAndExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_AND_EXPRESSION__EXPRESSION1 = eINSTANCE.getconditionalAndExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_AND_EXPRESSION__EXPRESSION_REST = eINSTANCE.getconditionalAndExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.equalityExpressionImpl <em>equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.equalityExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getequalityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getequalityExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__EXPRESSION1 = eINSTANCE.getequalityExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__EXPRESSION_REST = eINSTANCE.getequalityExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.relationalExpressionImpl <em>relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.relationalExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getrelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getrelationalExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__EXPRESSION1 = eINSTANCE.getrelationalExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__EXPRESSION_REST = eINSTANCE.getrelationalExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.additiveExpressionImpl <em>additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.additiveExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getadditiveExpression()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION = eINSTANCE.getadditiveExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__EXPRESSION1 = eINSTANCE.getadditiveExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__EXPRESSION_REST = eINSTANCE.getadditiveExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.multiplicativeExpressionImpl <em>multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.multiplicativeExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getmultiplicativeExpression()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getmultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__EXPRESSION1 = eINSTANCE.getmultiplicativeExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST = eINSTANCE.getmultiplicativeExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.unaryExpressionImpl <em>unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.unaryExpressionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getunaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getunaryExpression();

    /**
     * The meta object literal for the '<em><b>Exp1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXP1 = eINSTANCE.getunaryExpression_Exp1();

    /**
     * The meta object literal for the '<em><b>Exp2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXP2 = eINSTANCE.getunaryExpression_Exp2();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.unaryExpressionNotPlusMinusImpl <em>unary Expression Not Plus Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.unaryExpressionNotPlusMinusImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getunaryExpressionNotPlusMinus()
     * @generated
     */
    EClass UNARY_EXPRESSION_NOT_PLUS_MINUS = eINSTANCE.getunaryExpressionNotPlusMinus();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.primaryImpl <em>primary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.primaryImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getprimary()
     * @generated
     */
    EClass PRIMARY = eINSTANCE.getprimary();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.literalImpl <em>literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.literalImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getliteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getliteral();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.functionCallImpl <em>function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.functionCallImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getfunctionCall()
     * @generated
     */
    EClass FUNCTION_CALL = eINSTANCE.getfunctionCall();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.functionDeclarationImpl <em>function Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.functionDeclarationImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getfunctionDeclaration()
     * @generated
     */
    EClass FUNCTION_DECLARATION = eINSTANCE.getfunctionDeclaration();

    /**
     * The meta object literal for the '<em><b>Java</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DECLARATION__JAVA = eINSTANCE.getfunctionDeclaration_Java();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.functionDefinitionImpl <em>function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.functionDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getfunctionDefinition()
     * @generated
     */
    EClass FUNCTION_DEFINITION = eINSTANCE.getfunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Java</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__JAVA = eINSTANCE.getfunctionDefinition_Java();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.javaFunctionDeclarationImpl <em>java Function Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.javaFunctionDeclarationImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getjavaFunctionDeclaration()
     * @generated
     */
    EClass JAVA_FUNCTION_DECLARATION = eINSTANCE.getjavaFunctionDeclaration();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__RETURN_TYPE = eINSTANCE.getjavaFunctionDeclaration_ReturnType();

    /**
     * The meta object literal for the '<em><b>Reference Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__REFERENCE_TYPE = eINSTANCE.getjavaFunctionDeclaration_ReferenceType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__NAME = eINSTANCE.getjavaFunctionDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Arg List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__ARG_LIST = eINSTANCE.getjavaFunctionDeclaration_ArgList();

    /**
     * The meta object literal for the '<em><b>Arg List ID</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__ARG_LIST_ID = eINSTANCE.getjavaFunctionDeclaration_ArgListID();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.javaFunctionDefinitionImpl <em>java Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.javaFunctionDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getjavaFunctionDefinition()
     * @generated
     */
    EClass JAVA_FUNCTION_DEFINITION = eINSTANCE.getjavaFunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_FUNCTION_DEFINITION__DECL = eINSTANCE.getjavaFunctionDefinition_Decl();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_FUNCTION_DEFINITION__CODE = eINSTANCE.getjavaFunctionDefinition_Code();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.javaFunctionCallImpl <em>java Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.javaFunctionCallImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getjavaFunctionCall()
     * @generated
     */
    EClass JAVA_FUNCTION_CALL = eINSTANCE.getjavaFunctionCall();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_CALL__NAME = eINSTANCE.getjavaFunctionCall_Name();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_FUNCTION_CALL__ARGS = eINSTANCE.getjavaFunctionCall_Args();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.blockStatementImpl <em>block Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.blockStatementImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getblockStatement()
     * @generated
     */
    EClass BLOCK_STATEMENT = eINSTANCE.getblockStatement();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.localVariableDeclarationStatementImpl <em>local Variable Declaration Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.localVariableDeclarationStatementImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getlocalVariableDeclarationStatement()
     * @generated
     */
    EClass LOCAL_VARIABLE_DECLARATION_STATEMENT = eINSTANCE.getlocalVariableDeclarationStatement();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.localVariableDeclarationImpl <em>local Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.localVariableDeclarationImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getlocalVariableDeclaration()
     * @generated
     */
    EClass LOCAL_VARIABLE_DECLARATION = eINSTANCE.getlocalVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOCAL_VARIABLE_DECLARATION__TYPE = eINSTANCE.getlocalVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Dec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_VARIABLE_DECLARATION__DEC = eINSTANCE.getlocalVariableDeclaration_Dec();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.variableDeclaratorsImpl <em>variable Declarators</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.variableDeclaratorsImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getvariableDeclarators()
     * @generated
     */
    EClass VARIABLE_DECLARATORS = eINSTANCE.getvariableDeclarators();

    /**
     * The meta object literal for the '<em><b>Vd</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATORS__VD = eINSTANCE.getvariableDeclarators_Vd();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.variableDeclaratorImpl <em>variable Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.variableDeclaratorImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getvariableDeclarator()
     * @generated
     */
    EClass VARIABLE_DECLARATOR = eINSTANCE.getvariableDeclarator();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATOR__NAME = eINSTANCE.getvariableDeclarator_Name();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATOR__EXP = eINSTANCE.getvariableDeclarator_Exp();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.statementImpl <em>statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.statementImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getstatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getstatement();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__CONDITION = eINSTANCE.getstatement_Condition();

    /**
     * The meta object literal for the '<em><b>State1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__STATE1 = eINSTANCE.getstatement_State1();

    /**
     * The meta object literal for the '<em><b>State2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__STATE2 = eINSTANCE.getstatement_State2();

    /**
     * The meta object literal for the '<em><b>Control</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__CONTROL = eINSTANCE.getstatement_Control();

    /**
     * The meta object literal for the '<em><b>State</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__STATE = eINSTANCE.getstatement_State();

    /**
     * The meta object literal for the '<em><b>Ret Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__RET_VAL = eINSTANCE.getstatement_RetVal();

    /**
     * The meta object literal for the '<em><b>Try Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__TRY_BLOCK = eINSTANCE.getstatement_TryBlock();

    /**
     * The meta object literal for the '<em><b>Catch Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__CATCH_BLOCK = eINSTANCE.getstatement_CatchBlock();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.forControlImpl <em>for Control</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.forControlImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getforControl()
     * @generated
     */
    EClass FOR_CONTROL = eINSTANCE.getforControl();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_CONTROL__INIT = eINSTANCE.getforControl_Init();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_CONTROL__CONDITION = eINSTANCE.getforControl_Condition();

    /**
     * The meta object literal for the '<em><b>Update</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_CONTROL__UPDATE = eINSTANCE.getforControl_Update();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.forInitImpl <em>for Init</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.forInitImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getforInit()
     * @generated
     */
    EClass FOR_INIT = eINSTANCE.getforInit();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_INIT__EXPRESSIONS = eINSTANCE.getforInit_Expressions();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.forUpdateImpl <em>for Update</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.forUpdateImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getforUpdate()
     * @generated
     */
    EClass FOR_UPDATE = eINSTANCE.getforUpdate();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.phpFunctionImpl <em>php Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.phpFunctionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getphpFunction()
     * @generated
     */
    EClass PHP_FUNCTION = eINSTANCE.getphpFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHP_FUNCTION__NAME = eINSTANCE.getphpFunction_Name();

    /**
     * The meta object literal for the '<em><b>Codeblock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHP_FUNCTION__CODEBLOCK = eINSTANCE.getphpFunction_Codeblock();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.phpBlockImpl <em>php Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.phpBlockImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getphpBlock()
     * @generated
     */
    EClass PHP_BLOCK = eINSTANCE.getphpBlock();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHP_BLOCK__CODE = eINSTANCE.getphpBlock_Code();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.Modifier <em>Modifier</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.Modifier
     * @see cruise.umple.umple.impl.UmplePackageImpl#getModifier()
     * @generated
     */
    EEnum MODIFIER = eINSTANCE.getModifier();

  }

} //UmplePackage
