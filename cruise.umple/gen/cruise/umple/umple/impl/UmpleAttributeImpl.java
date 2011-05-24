/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Modifier;
import cruise.umple.umple.UmpleAttribute;
import cruise.umple.umple.UmpleClass;
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
 *   <li>{@link cruise.umple.umple.impl.UmpleAttributeImpl#isAutounique <em>Autounique</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleAttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleAttributeImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleAttributeImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleAttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleAttributeImpl#isList <em>List</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleAttributeImpl#getObject <em>Object</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.UmpleAttributeImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UmpleAttributeImpl extends associationClassContentImpl implements UmpleAttribute
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
  protected UmpleClass object;

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
  protected UmpleAttributeImpl()
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
    return UmplePackage.Literals.UMPLE_ATTRIBUTE;
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ATTRIBUTE__AUTOUNIQUE, oldAutounique, autounique));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ATTRIBUTE__NAME, oldName, name));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ATTRIBUTE__UNIQUE, oldUnique, unique));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ATTRIBUTE__MODIFIER, oldModifier, modifier));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ATTRIBUTE__TYPE, oldType, type));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ATTRIBUTE__LIST, oldList, list));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleClass getObject()
  {
    if (object != null && object.eIsProxy())
    {
      InternalEObject oldObject = (InternalEObject)object;
      object = (UmpleClass)eResolveProxy(oldObject);
      if (object != oldObject)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmplePackage.UMPLE_ATTRIBUTE__OBJECT, oldObject, object));
      }
    }
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UmpleClass basicGetObject()
  {
    return object;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setObject(UmpleClass newObject)
  {
    UmpleClass oldObject = object;
    object = newObject;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ATTRIBUTE__OBJECT, oldObject, object));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.UMPLE_ATTRIBUTE__VALUE, oldValue, value));
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
      case UmplePackage.UMPLE_ATTRIBUTE__AUTOUNIQUE:
        return isAutounique();
      case UmplePackage.UMPLE_ATTRIBUTE__NAME:
        return getName();
      case UmplePackage.UMPLE_ATTRIBUTE__UNIQUE:
        return isUnique();
      case UmplePackage.UMPLE_ATTRIBUTE__MODIFIER:
        return getModifier();
      case UmplePackage.UMPLE_ATTRIBUTE__TYPE:
        return getType();
      case UmplePackage.UMPLE_ATTRIBUTE__LIST:
        return isList();
      case UmplePackage.UMPLE_ATTRIBUTE__OBJECT:
        if (resolve) return getObject();
        return basicGetObject();
      case UmplePackage.UMPLE_ATTRIBUTE__VALUE:
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
      case UmplePackage.UMPLE_ATTRIBUTE__AUTOUNIQUE:
        setAutounique((Boolean)newValue);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__NAME:
        setName((String)newValue);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__UNIQUE:
        setUnique((Boolean)newValue);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__MODIFIER:
        setModifier((Modifier)newValue);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__TYPE:
        setType((String)newValue);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__LIST:
        setList((Boolean)newValue);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__OBJECT:
        setObject((UmpleClass)newValue);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__VALUE:
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
      case UmplePackage.UMPLE_ATTRIBUTE__AUTOUNIQUE:
        setAutounique(AUTOUNIQUE_EDEFAULT);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__UNIQUE:
        setUnique(UNIQUE_EDEFAULT);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__MODIFIER:
        setModifier(MODIFIER_EDEFAULT);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__LIST:
        setList(LIST_EDEFAULT);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__OBJECT:
        setObject((UmpleClass)null);
        return;
      case UmplePackage.UMPLE_ATTRIBUTE__VALUE:
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
      case UmplePackage.UMPLE_ATTRIBUTE__AUTOUNIQUE:
        return autounique != AUTOUNIQUE_EDEFAULT;
      case UmplePackage.UMPLE_ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmplePackage.UMPLE_ATTRIBUTE__UNIQUE:
        return unique != UNIQUE_EDEFAULT;
      case UmplePackage.UMPLE_ATTRIBUTE__MODIFIER:
        return modifier != MODIFIER_EDEFAULT;
      case UmplePackage.UMPLE_ATTRIBUTE__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case UmplePackage.UMPLE_ATTRIBUTE__LIST:
        return list != LIST_EDEFAULT;
      case UmplePackage.UMPLE_ATTRIBUTE__OBJECT:
        return object != null;
      case UmplePackage.UMPLE_ATTRIBUTE__VALUE:
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

} //UmpleAttributeImpl
