/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Attribute;
import cruise.umple.umple.ClassDefinition;
import cruise.umple.umple.Modifier;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.AttributeImpl#isAutounique <em>Autounique</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AttributeImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AttributeImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AttributeImpl#isList <em>List</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AttributeImpl#getObject <em>Object</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.AttributeImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends ClassContentImpl implements Attribute
{
  /**
   * The default value of the '{@link #isAutounique() <em>Autounique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAutounique()
   * @generated
   * @ordered
   */
  protected static final boolean AUTOUNIQUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAutounique() <em>Autounique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAutounique()
   * @generated
   * @ordered
   */
  protected boolean autounique = AUTOUNIQUE_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected static final boolean UNIQUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique()
   * @generated
   * @ordered
   */
  protected boolean unique = UNIQUE_EDEFAULT;

  /**
   * The default value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected static final Modifier MODIFIER_EDEFAULT = Modifier.IMMUTABLE;

  /**
   * The cached value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected Modifier modifier = MODIFIER_EDEFAULT;

  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final String TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected String type = TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #isList() <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isList()
   * @generated
   * @ordered
   */
  protected static final boolean LIST_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isList() <em>List</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isList()
   * @generated
   * @ordered
   */
  protected boolean list = LIST_EDEFAULT;

  /**
   * The cached value of the '{@link #getObject() <em>Object</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getObject()
   * @generated
   * @ordered
   */
  protected ClassDefinition object;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return UmplePackage.Literals.ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAutounique()
  {
    return autounique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAutounique(boolean newAutounique)
  {
    boolean oldAutounique = autounique;
    autounique = newAutounique;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ATTRIBUTE__AUTOUNIQUE, oldAutounique, autounique));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ATTRIBUTE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUnique()
  {
    return unique;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnique(boolean newUnique)
  {
    boolean oldUnique = unique;
    unique = newUnique;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ATTRIBUTE__UNIQUE, oldUnique, unique));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modifier getModifier()
  {
    return modifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModifier(Modifier newModifier)
  {
    Modifier oldModifier = modifier;
    modifier = newModifier == null ? MODIFIER_EDEFAULT : newModifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ATTRIBUTE__MODIFIER, oldModifier, modifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(String newType)
  {
    String oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ATTRIBUTE__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isList()
  {
    return list;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setList(boolean newList)
  {
    boolean oldList = list;
    list = newList;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ATTRIBUTE__LIST, oldList, list));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDefinition getObject()
  {
    if (object != null && object.eIsProxy())
    {
      InternalEObject oldObject = (InternalEObject)object;
      object = (ClassDefinition)eResolveProxy(oldObject);
      if (object != oldObject)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmplePackage.ATTRIBUTE__OBJECT, oldObject, object));
      }
    }
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassDefinition basicGetObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(ClassDefinition newObject)
  {
    ClassDefinition oldObject = object;
    object = newObject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ATTRIBUTE__OBJECT, oldObject, object));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.ATTRIBUTE__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case UmplePackage.ATTRIBUTE__AUTOUNIQUE:
        return isAutounique();
      case UmplePackage.ATTRIBUTE__NAME:
        return getName();
      case UmplePackage.ATTRIBUTE__UNIQUE:
        return isUnique();
      case UmplePackage.ATTRIBUTE__MODIFIER:
        return getModifier();
      case UmplePackage.ATTRIBUTE__TYPE:
        return getType();
      case UmplePackage.ATTRIBUTE__LIST:
        return isList();
      case UmplePackage.ATTRIBUTE__OBJECT:
        if (resolve) return getObject();
        return basicGetObject();
      case UmplePackage.ATTRIBUTE__VALUE:
        return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.ATTRIBUTE__AUTOUNIQUE:
        setAutounique((Boolean)newValue);
        return;
      case UmplePackage.ATTRIBUTE__NAME:
        setName((String)newValue);
        return;
      case UmplePackage.ATTRIBUTE__UNIQUE:
        setUnique((Boolean)newValue);
        return;
      case UmplePackage.ATTRIBUTE__MODIFIER:
        setModifier((Modifier)newValue);
        return;
      case UmplePackage.ATTRIBUTE__TYPE:
        setType((String)newValue);
        return;
      case UmplePackage.ATTRIBUTE__LIST:
        setList((Boolean)newValue);
        return;
      case UmplePackage.ATTRIBUTE__OBJECT:
        setObject((ClassDefinition)newValue);
        return;
      case UmplePackage.ATTRIBUTE__VALUE:
        setValue((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case UmplePackage.ATTRIBUTE__AUTOUNIQUE:
        setAutounique(AUTOUNIQUE_EDEFAULT);
        return;
      case UmplePackage.ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UmplePackage.ATTRIBUTE__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case UmplePackage.ATTRIBUTE__MODIFIER:
        setModifier(MODIFIER_EDEFAULT);
        return;
      case UmplePackage.ATTRIBUTE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case UmplePackage.ATTRIBUTE__LIST:
        setList(LIST_EDEFAULT);
        return;
      case UmplePackage.ATTRIBUTE__OBJECT:
        setObject((ClassDefinition)null);
        return;
      case UmplePackage.ATTRIBUTE__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case UmplePackage.ATTRIBUTE__AUTOUNIQUE:
        return autounique != AUTOUNIQUE_EDEFAULT;
      case UmplePackage.ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmplePackage.ATTRIBUTE__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
      case UmplePackage.ATTRIBUTE__MODIFIER:
        return modifier != MODIFIER_EDEFAULT;
      case UmplePackage.ATTRIBUTE__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case UmplePackage.ATTRIBUTE__LIST:
        return list != LIST_EDEFAULT;
      case UmplePackage.ATTRIBUTE__OBJECT:
        return object != null;
      case UmplePackage.ATTRIBUTE__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (autounique: ");
    result.append(autounique);
    result.append(", name: ");
    result.append(name);
    result.append(", unique: ");
    result.append(unique);
    result.append(", modifier: ");
    result.append(modifier);
    result.append(", type: ");
    result.append(type);
    result.append(", list: ");
    result.append(list);
    result.append(", value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //AttributeImpl
