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
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AbstractElementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAbstractElement()
   * @generated
   */
  int ABSTRACT_ELEMENT = 1;

  /**
   * The number of structural features of the '<em>Abstract Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.GlossaryImpl <em>Glossary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.GlossaryImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getGlossary()
   * @generated
   */
  int GLOSSARY = 2;

  /**
   * The feature id for the '<em><b>Words</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOSSARY__WORDS = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Glossary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOSSARY_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.WordImpl <em>Word</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.WordImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getWord()
   * @generated
   */
  int WORD = 3;

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
  int GENERATE__JAVA = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Php</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE__PHP = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Ruby</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE__RUBY = ABSTRACT_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Generate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GENERATE_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.UseStatementImpl <em>Use Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UseStatementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUseStatement()
   * @generated
   */
  int USE_STATEMENT = 5;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USE_STATEMENT__FILE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Use Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USE_STATEMENT_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.NamespaceImpl <em>Namespace</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.NamespaceImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getNamespace()
   * @generated
   */
  int NAMESPACE = 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE__VALUE = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Namespace</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMESPACE_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.EntityImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = ABSTRACT_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = ABSTRACT_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ClassDefinitionImpl <em>Class Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ClassDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getClassDefinition()
   * @generated
   */
  int CLASS_DEFINITION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEFINITION__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Class Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEFINITION__CLASS_CONTENT = ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Class Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEFINITION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ExternalDefinitionImpl <em>External Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ExternalDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getExternalDefinition()
   * @generated
   */
  int EXTERNAL_DEFINITION = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEFINITION__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Class Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEFINITION__CLASS_CONTENT = ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>External Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DEFINITION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InterfaceDefinitionImpl <em>Interface Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InterfaceDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInterfaceDefinition()
   * @generated
   */
  int INTERFACE_DEFINITION = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DEFINITION__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Depend</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DEFINITION__DEPEND = ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Interface Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_DEFINITION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationDefinitionImpl <em>Association Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationDefinition()
   * @generated
   */
  int ASSOCIATION_DEFINITION = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_DEFINITION__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_DEFINITION__ASSOCIATION = ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Association Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_DEFINITION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ClassContentImpl <em>Class Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ClassContentImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getClassContent()
   * @generated
   */
  int CLASS_CONTENT = 12;

  /**
   * The number of structural features of the '<em>Class Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_CONTENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationClassContentImpl <em>Association Class Content</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationClassContentImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationClassContent()
   * @generated
   */
  int ASSOCIATION_CLASS_CONTENT = 13;

  /**
   * The number of structural features of the '<em>Association Class Content</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_CONTENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.DependImpl <em>Depend</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.DependImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getDepend()
   * @generated
   */
  int DEPEND = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPEND__NAME = CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Depend</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPEND_FEATURE_COUNT = CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationImpl <em>Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociation()
   * @generated
   */
  int ASSOCIATION = 15;

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
  int SYMMETRIC_REFLEXIVE_ASSOCIATION = 16;

  /**
   * The feature id for the '<em><b>Rolename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION__ROLENAME = CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Symmetric Reflexive Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMMETRIC_REFLEXIVE_ASSOCIATION_FEATURE_COUNT = CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.InlineAssociationImpl <em>Inline Association</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.InlineAssociationImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getInlineAssociation()
   * @generated
   */
  int INLINE_ASSOCIATION = 17;

  /**
   * The feature id for the '<em><b>Rolename1</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION__ROLENAME1 = CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION__TYPE = CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Rolename2</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION__ROLENAME2 = CLASS_CONTENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Inline Association</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INLINE_ASSOCIATION_FEATURE_COUNT = CLASS_CONTENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SingleAssociationEndImpl <em>Single Association End</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SingleAssociationEndImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSingleAssociationEnd()
   * @generated
   */
  int SINGLE_ASSOCIATION_END = 18;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END__TYPE = 0;

  /**
   * The feature id for the '<em><b>Rolename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END__ROLENAME = 1;

  /**
   * The number of structural features of the '<em>Single Association End</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLE_ASSOCIATION_END_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationClassDefinitionImpl <em>Association Class Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationClassDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationClassDefinition()
   * @generated
   */
  int ASSOCIATION_CLASS_DEFINITION = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_DEFINITION__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Association Class Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_DEFINITION__ASSOCIATION_CLASS_CONTENT = ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Association Class Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_CLASS_DEFINITION_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SoftwarePatternImpl <em>Software Pattern</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SoftwarePatternImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSoftwarePattern()
   * @generated
   */
  int SOFTWARE_PATTERN = 20;

  /**
   * The number of structural features of the '<em>Software Pattern</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOFTWARE_PATTERN_FEATURE_COUNT = CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.isAImpl <em>is A</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.isAImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getisA()
   * @generated
   */
  int IS_A = 21;

  /**
   * The feature id for the '<em><b>Extends Class</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_A__EXTENDS_CLASS = SOFTWARE_PATTERN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>is A</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IS_A_FEATURE_COUNT = SOFTWARE_PATTERN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.SingletonImpl <em>Singleton</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.SingletonImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getSingleton()
   * @generated
   */
  int SINGLETON = 22;

  /**
   * The feature id for the '<em><b>Singleton</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLETON__SINGLETON = SOFTWARE_PATTERN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Singleton</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SINGLETON_FEATURE_COUNT = SOFTWARE_PATTERN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.KeyDefinitionImpl <em>Key Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.KeyDefinitionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getKeyDefinition()
   * @generated
   */
  int KEY_DEFINITION = 23;

  /**
   * The number of structural features of the '<em>Key Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_DEFINITION_FEATURE_COUNT = SOFTWARE_PATTERN_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CodeInjectionImpl <em>Code Injection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CodeInjectionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCodeInjection()
   * @generated
   */
  int CODE_INJECTION = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION__NAME = SOFTWARE_PATTERN_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION__CODE = SOFTWARE_PATTERN_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Code Injection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CODE_INJECTION_FEATURE_COUNT = SOFTWARE_PATTERN_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AttributeImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 25;

  /**
   * The feature id for the '<em><b>Autounique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__AUTOUNIQUE = CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = CLASS_CONTENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unique</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__UNIQUE = CLASS_CONTENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__MODIFIER = CLASS_CONTENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__TYPE = CLASS_CONTENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>List</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__LIST = CLASS_CONTENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Object</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__OBJECT = CLASS_CONTENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = CLASS_CONTENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = CLASS_CONTENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.PositionImpl <em>Position</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.PositionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getPosition()
   * @generated
   */
  int POSITION = 26;

  /**
   * The number of structural features of the '<em>Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSITION_FEATURE_COUNT = CLASS_CONTENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.ElementPositionImpl <em>Element Position</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.ElementPositionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getElementPosition()
   * @generated
   */
  int ELEMENT_POSITION = 27;

  /**
   * The feature id for the '<em><b>X</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION__X = POSITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Y</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION__Y = POSITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Width</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION__WIDTH = POSITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Height</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION__HEIGHT = POSITION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Element Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_POSITION_FEATURE_COUNT = POSITION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.AssociationPositionImpl <em>Association Position</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.AssociationPositionImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationPosition()
   * @generated
   */
  int ASSOCIATION_POSITION = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION__NAME = POSITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>C1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION__C1 = POSITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>C2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION__C2 = POSITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Association Position</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSOCIATION_POSITION_FEATURE_COUNT = POSITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.CoordinateImpl <em>Coordinate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.CoordinateImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getCoordinate()
   * @generated
   */
  int COORDINATE = 29;

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
   * The meta object id for the '{@link cruise.umple.umple.impl.UmpleElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.UmpleElementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleElement()
   * @generated
   */
  int UMPLE_ELEMENT = 30;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UMPLE_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.umple.impl.blockStatementImpl <em>block Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.blockStatementImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getblockStatement()
   * @generated
   */
  int BLOCK_STATEMENT = 52;

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
  int STATEMENT = 57;

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
  int BLOCK = 31;

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
  int UNARY_EXPRESSION_NOT_PLUS_MINUS = 43;

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
  int PRIMARY = 44;

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
  int PAR_EXPRESSION = 32;

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
  int FOR_UPDATE = 60;

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
  int EXPRESSION_LIST = 33;

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
  int EXPRESSION = 34;

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
  int CONDITIONAL_EXPRESSION = 35;

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
  int CONDITIONAL_OR_EXPRESSION = 36;

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
  int CONDITIONAL_AND_EXPRESSION = 37;

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
  int EQUALITY_EXPRESSION = 38;

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
  int RELATIONAL_EXPRESSION = 39;

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
  int ADDITIVE_EXPRESSION = 40;

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
  int MULTIPLICATIVE_EXPRESSION = 41;

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
  int UNARY_EXPRESSION = 42;

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
  int LITERAL = 45;

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
  int FUNCTION_CALL = 46;

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
  int FUNCTION_DECLARATION = 47;

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
  int FUNCTION_DEFINITION = 48;

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
  int JAVA_FUNCTION_DECLARATION = 49;

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
  int JAVA_FUNCTION_DEFINITION = 50;

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
  int JAVA_FUNCTION_CALL = 51;

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
  int LOCAL_VARIABLE_DECLARATION_STATEMENT = 53;

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
  int LOCAL_VARIABLE_DECLARATION = 54;

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
  int VARIABLE_DECLARATORS = 55;

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
  int VARIABLE_DECLARATOR = 56;

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
  int FOR_CONTROL = 58;

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
  int FOR_INIT = 59;

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
  int PHP_FUNCTION = 61;

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
  int PHP_BLOCK = 62;

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
   * The meta object id for the '{@link cruise.umple.umple.impl.KeyImpl <em>Key</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.impl.KeyImpl
   * @see cruise.umple.umple.impl.UmplePackageImpl#getKey()
   * @generated
   */
  int KEY = 63;

  /**
   * The feature id for the '<em><b>Keys</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY__KEYS = KEY_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Key</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_FEATURE_COUNT = KEY_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.umple.Modifier <em>Modifier</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.umple.Modifier
   * @see cruise.umple.umple.impl.UmplePackageImpl#getModifier()
   * @generated
   */
  int MODIFIER = 64;


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
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.UmpleModel#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see cruise.umple.umple.UmpleModel#getElements()
   * @see #getUmpleModel()
   * @generated
   */
  EReference getUmpleModel_Elements();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AbstractElement <em>Abstract Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Element</em>'.
   * @see cruise.umple.umple.AbstractElement
   * @generated
   */
  EClass getAbstractElement();

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
   * Returns the meta object for class '{@link cruise.umple.umple.UseStatement <em>Use Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Use Statement</em>'.
   * @see cruise.umple.umple.UseStatement
   * @generated
   */
  EClass getUseStatement();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.UseStatement#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see cruise.umple.umple.UseStatement#getFile()
   * @see #getUseStatement()
   * @generated
   */
  EAttribute getUseStatement_File();

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
   * Returns the meta object for class '{@link cruise.umple.umple.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see cruise.umple.umple.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Entity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.Entity#getName()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Name();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ClassDefinition <em>Class Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Definition</em>'.
   * @see cruise.umple.umple.ClassDefinition
   * @generated
   */
  EClass getClassDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ClassDefinition#getClassContent <em>Class Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Class Content</em>'.
   * @see cruise.umple.umple.ClassDefinition#getClassContent()
   * @see #getClassDefinition()
   * @generated
   */
  EReference getClassDefinition_ClassContent();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ExternalDefinition <em>External Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Definition</em>'.
   * @see cruise.umple.umple.ExternalDefinition
   * @generated
   */
  EClass getExternalDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.ExternalDefinition#getClassContent <em>Class Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Class Content</em>'.
   * @see cruise.umple.umple.ExternalDefinition#getClassContent()
   * @see #getExternalDefinition()
   * @generated
   */
  EReference getExternalDefinition_ClassContent();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.InterfaceDefinition <em>Interface Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Definition</em>'.
   * @see cruise.umple.umple.InterfaceDefinition
   * @generated
   */
  EClass getInterfaceDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.InterfaceDefinition#getDepend <em>Depend</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Depend</em>'.
   * @see cruise.umple.umple.InterfaceDefinition#getDepend()
   * @see #getInterfaceDefinition()
   * @generated
   */
  EReference getInterfaceDefinition_Depend();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationDefinition <em>Association Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Definition</em>'.
   * @see cruise.umple.umple.AssociationDefinition
   * @generated
   */
  EClass getAssociationDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationDefinition#getAssociation <em>Association</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association</em>'.
   * @see cruise.umple.umple.AssociationDefinition#getAssociation()
   * @see #getAssociationDefinition()
   * @generated
   */
  EReference getAssociationDefinition_Association();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.ClassContent <em>Class Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Content</em>'.
   * @see cruise.umple.umple.ClassContent
   * @generated
   */
  EClass getClassContent();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationClassContent <em>Association Class Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Class Content</em>'.
   * @see cruise.umple.umple.AssociationClassContent
   * @generated
   */
  EClass getAssociationClassContent();

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
   * Returns the meta object for class '{@link cruise.umple.umple.SingleAssociationEnd <em>Single Association End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Single Association End</em>'.
   * @see cruise.umple.umple.SingleAssociationEnd
   * @generated
   */
  EClass getSingleAssociationEnd();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SingleAssociationEnd#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see cruise.umple.umple.SingleAssociationEnd#getType()
   * @see #getSingleAssociationEnd()
   * @generated
   */
  EAttribute getSingleAssociationEnd_Type();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.SingleAssociationEnd#getRolename <em>Rolename</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rolename</em>'.
   * @see cruise.umple.umple.SingleAssociationEnd#getRolename()
   * @see #getSingleAssociationEnd()
   * @generated
   */
  EAttribute getSingleAssociationEnd_Rolename();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.AssociationClassDefinition <em>Association Class Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Association Class Definition</em>'.
   * @see cruise.umple.umple.AssociationClassDefinition
   * @generated
   */
  EClass getAssociationClassDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.umple.AssociationClassDefinition#getAssociationClassContent <em>Association Class Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Association Class Content</em>'.
   * @see cruise.umple.umple.AssociationClassDefinition#getAssociationClassContent()
   * @see #getAssociationClassDefinition()
   * @generated
   */
  EReference getAssociationClassDefinition_AssociationClassContent();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.SoftwarePattern <em>Software Pattern</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Software Pattern</em>'.
   * @see cruise.umple.umple.SoftwarePattern
   * @generated
   */
  EClass getSoftwarePattern();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.isA <em>is A</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>is A</em>'.
   * @see cruise.umple.umple.isA
   * @generated
   */
  EClass getisA();

  /**
   * Returns the meta object for the reference list '{@link cruise.umple.umple.isA#getExtendsClass <em>Extends Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Extends Class</em>'.
   * @see cruise.umple.umple.isA#getExtendsClass()
   * @see #getisA()
   * @generated
   */
  EReference getisA_ExtendsClass();

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
   * Returns the meta object for class '{@link cruise.umple.umple.KeyDefinition <em>Key Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Definition</em>'.
   * @see cruise.umple.umple.KeyDefinition
   * @generated
   */
  EClass getKeyDefinition();

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
   * Returns the meta object for the attribute '{@link cruise.umple.umple.CodeInjection#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code</em>'.
   * @see cruise.umple.umple.CodeInjection#getCode()
   * @see #getCodeInjection()
   * @generated
   */
  EAttribute getCodeInjection_Code();

  /**
   * Returns the meta object for class '{@link cruise.umple.umple.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see cruise.umple.umple.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Attribute#isAutounique <em>Autounique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Autounique</em>'.
   * @see cruise.umple.umple.Attribute#isAutounique()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Autounique();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Attribute#isUnique <em>Unique</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unique</em>'.
   * @see cruise.umple.umple.Attribute#isUnique()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Unique();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Attribute#getModifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Modifier</em>'.
   * @see cruise.umple.umple.Attribute#getModifier()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Modifier();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Attribute#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see cruise.umple.umple.Attribute#getType()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Type();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Attribute#isList <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>List</em>'.
   * @see cruise.umple.umple.Attribute#isList()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_List();

  /**
   * Returns the meta object for the reference '{@link cruise.umple.umple.Attribute#getObject <em>Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Object</em>'.
   * @see cruise.umple.umple.Attribute#getObject()
   * @see #getAttribute()
   * @generated
   */
  EReference getAttribute_Object();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see cruise.umple.umple.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

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
   * Returns the meta object for class '{@link cruise.umple.umple.ElementPosition <em>Element Position</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Position</em>'.
   * @see cruise.umple.umple.ElementPosition
   * @generated
   */
  EClass getElementPosition();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ElementPosition#getX <em>X</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>X</em>'.
   * @see cruise.umple.umple.ElementPosition#getX()
   * @see #getElementPosition()
   * @generated
   */
  EAttribute getElementPosition_X();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ElementPosition#getY <em>Y</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Y</em>'.
   * @see cruise.umple.umple.ElementPosition#getY()
   * @see #getElementPosition()
   * @generated
   */
  EAttribute getElementPosition_Y();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ElementPosition#getWidth <em>Width</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Width</em>'.
   * @see cruise.umple.umple.ElementPosition#getWidth()
   * @see #getElementPosition()
   * @generated
   */
  EAttribute getElementPosition_Width();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.umple.ElementPosition#getHeight <em>Height</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Height</em>'.
   * @see cruise.umple.umple.ElementPosition#getHeight()
   * @see #getElementPosition()
   * @generated
   */
  EAttribute getElementPosition_Height();

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
   * Returns the meta object for the attribute '{@link cruise.umple.umple.AssociationPosition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.umple.AssociationPosition#getName()
   * @see #getAssociationPosition()
   * @generated
   */
  EAttribute getAssociationPosition_Name();

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
   * Returns the meta object for class '{@link cruise.umple.umple.UmpleElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see cruise.umple.umple.UmpleElement
   * @generated
   */
  EClass getUmpleElement();

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
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UMPLE_MODEL__ELEMENTS = eINSTANCE.getUmpleModel_Elements();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.AbstractElementImpl <em>Abstract Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.AbstractElementImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getAbstractElement()
     * @generated
     */
    EClass ABSTRACT_ELEMENT = eINSTANCE.getAbstractElement();

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
     * The meta object literal for the '{@link cruise.umple.umple.impl.UseStatementImpl <em>Use Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UseStatementImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUseStatement()
     * @generated
     */
    EClass USE_STATEMENT = eINSTANCE.getUseStatement();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute USE_STATEMENT__FILE = eINSTANCE.getUseStatement_File();

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
     * The meta object literal for the '{@link cruise.umple.umple.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.EntityImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ClassDefinitionImpl <em>Class Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ClassDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getClassDefinition()
     * @generated
     */
    EClass CLASS_DEFINITION = eINSTANCE.getClassDefinition();

    /**
     * The meta object literal for the '<em><b>Class Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_DEFINITION__CLASS_CONTENT = eINSTANCE.getClassDefinition_ClassContent();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ExternalDefinitionImpl <em>External Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ExternalDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getExternalDefinition()
     * @generated
     */
    EClass EXTERNAL_DEFINITION = eINSTANCE.getExternalDefinition();

    /**
     * The meta object literal for the '<em><b>Class Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTERNAL_DEFINITION__CLASS_CONTENT = eINSTANCE.getExternalDefinition_ClassContent();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.InterfaceDefinitionImpl <em>Interface Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.InterfaceDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getInterfaceDefinition()
     * @generated
     */
    EClass INTERFACE_DEFINITION = eINSTANCE.getInterfaceDefinition();

    /**
     * The meta object literal for the '<em><b>Depend</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTERFACE_DEFINITION__DEPEND = eINSTANCE.getInterfaceDefinition_Depend();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.AssociationDefinitionImpl <em>Association Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.AssociationDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationDefinition()
     * @generated
     */
    EClass ASSOCIATION_DEFINITION = eINSTANCE.getAssociationDefinition();

    /**
     * The meta object literal for the '<em><b>Association</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_DEFINITION__ASSOCIATION = eINSTANCE.getAssociationDefinition_Association();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.ClassContentImpl <em>Class Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ClassContentImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getClassContent()
     * @generated
     */
    EClass CLASS_CONTENT = eINSTANCE.getClassContent();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.AssociationClassContentImpl <em>Association Class Content</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.AssociationClassContentImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationClassContent()
     * @generated
     */
    EClass ASSOCIATION_CLASS_CONTENT = eINSTANCE.getAssociationClassContent();

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
     * The meta object literal for the '{@link cruise.umple.umple.impl.SingleAssociationEndImpl <em>Single Association End</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.SingleAssociationEndImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getSingleAssociationEnd()
     * @generated
     */
    EClass SINGLE_ASSOCIATION_END = eINSTANCE.getSingleAssociationEnd();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_ASSOCIATION_END__TYPE = eINSTANCE.getSingleAssociationEnd_Type();

    /**
     * The meta object literal for the '<em><b>Rolename</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SINGLE_ASSOCIATION_END__ROLENAME = eINSTANCE.getSingleAssociationEnd_Rolename();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.AssociationClassDefinitionImpl <em>Association Class Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.AssociationClassDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getAssociationClassDefinition()
     * @generated
     */
    EClass ASSOCIATION_CLASS_DEFINITION = eINSTANCE.getAssociationClassDefinition();

    /**
     * The meta object literal for the '<em><b>Association Class Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSOCIATION_CLASS_DEFINITION__ASSOCIATION_CLASS_CONTENT = eINSTANCE.getAssociationClassDefinition_AssociationClassContent();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.SoftwarePatternImpl <em>Software Pattern</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.SoftwarePatternImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getSoftwarePattern()
     * @generated
     */
    EClass SOFTWARE_PATTERN = eINSTANCE.getSoftwarePattern();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.isAImpl <em>is A</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.isAImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getisA()
     * @generated
     */
    EClass IS_A = eINSTANCE.getisA();

    /**
     * The meta object literal for the '<em><b>Extends Class</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IS_A__EXTENDS_CLASS = eINSTANCE.getisA_ExtendsClass();

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
     * The meta object literal for the '{@link cruise.umple.umple.impl.KeyDefinitionImpl <em>Key Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.KeyDefinitionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getKeyDefinition()
     * @generated
     */
    EClass KEY_DEFINITION = eINSTANCE.getKeyDefinition();

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
     * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CODE_INJECTION__CODE = eINSTANCE.getCodeInjection_Code();

    /**
     * The meta object literal for the '{@link cruise.umple.umple.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.AttributeImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Autounique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__AUTOUNIQUE = eINSTANCE.getAttribute_Autounique();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__UNIQUE = eINSTANCE.getAttribute_Unique();

    /**
     * The meta object literal for the '<em><b>Modifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__MODIFIER = eINSTANCE.getAttribute_Modifier();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

    /**
     * The meta object literal for the '<em><b>List</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__LIST = eINSTANCE.getAttribute_List();

    /**
     * The meta object literal for the '<em><b>Object</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ATTRIBUTE__OBJECT = eINSTANCE.getAttribute_Object();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

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
     * The meta object literal for the '{@link cruise.umple.umple.impl.ElementPositionImpl <em>Element Position</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.ElementPositionImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getElementPosition()
     * @generated
     */
    EClass ELEMENT_POSITION = eINSTANCE.getElementPosition();

    /**
     * The meta object literal for the '<em><b>X</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT_POSITION__X = eINSTANCE.getElementPosition_X();

    /**
     * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT_POSITION__Y = eINSTANCE.getElementPosition_Y();

    /**
     * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT_POSITION__WIDTH = eINSTANCE.getElementPosition_Width();

    /**
     * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT_POSITION__HEIGHT = eINSTANCE.getElementPosition_Height();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSOCIATION_POSITION__NAME = eINSTANCE.getAssociationPosition_Name();

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
     * The meta object literal for the '{@link cruise.umple.umple.impl.UmpleElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.umple.impl.UmpleElementImpl
     * @see cruise.umple.umple.impl.UmplePackageImpl#getUmpleElement()
     * @generated
     */
    EClass UMPLE_ELEMENT = eINSTANCE.getUmpleElement();

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
