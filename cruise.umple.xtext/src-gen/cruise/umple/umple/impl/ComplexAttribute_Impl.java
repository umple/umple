/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Anonymous_complexAttribute_1_;
import cruise.umple.umple.Anonymous_complexAttribute_2_;
import cruise.umple.umple.ComplexAttribute_;
import cruise.umple.umple.UmplePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Attribute </b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.ComplexAttribute_Impl#isUnique_1 <em>Unique 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ComplexAttribute_Impl#isLazy_1 <em>Lazy 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ComplexAttribute_Impl#getModifier_1 <em>Modifier 1</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ComplexAttribute_Impl#getAnonymous_complexAttribute_1_1 <em>Anonymous complex Attribute 11</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.ComplexAttribute_Impl#getAnonymous_complexAttribute_2_1 <em>Anonymous complex Attribute 21</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComplexAttribute_Impl extends MinimalEObjectImpl.Container implements ComplexAttribute_
{
  /**
   * The default value of the '{@link #isUnique_1() <em>Unique 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique_1()
   * @generated
   * @ordered
   */
  protected static final boolean UNIQUE_1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUnique_1() <em>Unique 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnique_1()
   * @generated
   * @ordered
   */
  protected boolean unique_1 = UNIQUE_1_EDEFAULT;

  /**
   * The default value of the '{@link #isLazy_1() <em>Lazy 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLazy_1()
   * @generated
   * @ordered
   */
  protected static final boolean LAZY_1_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLazy_1() <em>Lazy 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLazy_1()
   * @generated
   * @ordered
   */
  protected boolean lazy_1 = LAZY_1_EDEFAULT;

  /**
   * The default value of the '{@link #getModifier_1() <em>Modifier 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier_1()
   * @generated
   * @ordered
   */
  protected static final String MODIFIER_1_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModifier_1() <em>Modifier 1</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier_1()
   * @generated
   * @ordered
   */
  protected String modifier_1 = MODIFIER_1_EDEFAULT;

  /**
   * The cached value of the '{@link #getAnonymous_complexAttribute_1_1() <em>Anonymous complex Attribute 11</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_complexAttribute_1_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_complexAttribute_1_> anonymous_complexAttribute_1_1;

  /**
   * The cached value of the '{@link #getAnonymous_complexAttribute_2_1() <em>Anonymous complex Attribute 21</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAnonymous_complexAttribute_2_1()
   * @generated
   * @ordered
   */
  protected EList<Anonymous_complexAttribute_2_> anonymous_complexAttribute_2_1;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComplexAttribute_Impl()
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
    return UmplePackage.eINSTANCE.getComplexAttribute_();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUnique_1()
  {
    return unique_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnique_1(boolean newUnique_1)
  {
    boolean oldUnique_1 = unique_1;
    unique_1 = newUnique_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.COMPLEX_ATTRIBUTE___UNIQUE_1, oldUnique_1, unique_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isLazy_1()
  {
    return lazy_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLazy_1(boolean newLazy_1)
  {
    boolean oldLazy_1 = lazy_1;
    lazy_1 = newLazy_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.COMPLEX_ATTRIBUTE___LAZY_1, oldLazy_1, lazy_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getModifier_1()
  {
    return modifier_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModifier_1(String newModifier_1)
  {
    String oldModifier_1 = modifier_1;
    modifier_1 = newModifier_1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.COMPLEX_ATTRIBUTE___MODIFIER_1, oldModifier_1, modifier_1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_complexAttribute_1_> getAnonymous_complexAttribute_1_1()
  {
    if (anonymous_complexAttribute_1_1 == null)
    {
      anonymous_complexAttribute_1_1 = new EObjectContainmentEList<Anonymous_complexAttribute_1_>(Anonymous_complexAttribute_1_.class, this, UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_11);
    }
    return anonymous_complexAttribute_1_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Anonymous_complexAttribute_2_> getAnonymous_complexAttribute_2_1()
  {
    if (anonymous_complexAttribute_2_1 == null)
    {
      anonymous_complexAttribute_2_1 = new EObjectContainmentEList<Anonymous_complexAttribute_2_>(Anonymous_complexAttribute_2_.class, this, UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_21);
    }
    return anonymous_complexAttribute_2_1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_11:
        return ((InternalEList<?>)getAnonymous_complexAttribute_1_1()).basicRemove(otherEnd, msgs);
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_21:
        return ((InternalEList<?>)getAnonymous_complexAttribute_2_1()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case UmplePackage.COMPLEX_ATTRIBUTE___UNIQUE_1:
        return isUnique_1();
      case UmplePackage.COMPLEX_ATTRIBUTE___LAZY_1:
        return isLazy_1();
      case UmplePackage.COMPLEX_ATTRIBUTE___MODIFIER_1:
        return getModifier_1();
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_11:
        return getAnonymous_complexAttribute_1_1();
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_21:
        return getAnonymous_complexAttribute_2_1();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case UmplePackage.COMPLEX_ATTRIBUTE___UNIQUE_1:
        setUnique_1((Boolean)newValue);
        return;
      case UmplePackage.COMPLEX_ATTRIBUTE___LAZY_1:
        setLazy_1((Boolean)newValue);
        return;
      case UmplePackage.COMPLEX_ATTRIBUTE___MODIFIER_1:
        setModifier_1((String)newValue);
        return;
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_11:
        getAnonymous_complexAttribute_1_1().clear();
        getAnonymous_complexAttribute_1_1().addAll((Collection<? extends Anonymous_complexAttribute_1_>)newValue);
        return;
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_21:
        getAnonymous_complexAttribute_2_1().clear();
        getAnonymous_complexAttribute_2_1().addAll((Collection<? extends Anonymous_complexAttribute_2_>)newValue);
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
      case UmplePackage.COMPLEX_ATTRIBUTE___UNIQUE_1:
        setUnique_1(UNIQUE_1_EDEFAULT);
        return;
      case UmplePackage.COMPLEX_ATTRIBUTE___LAZY_1:
        setLazy_1(LAZY_1_EDEFAULT);
        return;
      case UmplePackage.COMPLEX_ATTRIBUTE___MODIFIER_1:
        setModifier_1(MODIFIER_1_EDEFAULT);
        return;
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_11:
        getAnonymous_complexAttribute_1_1().clear();
        return;
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_21:
        getAnonymous_complexAttribute_2_1().clear();
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
      case UmplePackage.COMPLEX_ATTRIBUTE___UNIQUE_1:
        return unique_1 != UNIQUE_1_EDEFAULT;
      case UmplePackage.COMPLEX_ATTRIBUTE___LAZY_1:
        return lazy_1 != LAZY_1_EDEFAULT;
      case UmplePackage.COMPLEX_ATTRIBUTE___MODIFIER_1:
        return MODIFIER_1_EDEFAULT == null ? modifier_1 != null : !MODIFIER_1_EDEFAULT.equals(modifier_1);
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_11:
        return anonymous_complexAttribute_1_1 != null && !anonymous_complexAttribute_1_1.isEmpty();
      case UmplePackage.COMPLEX_ATTRIBUTE___ANONYMOUS_COMPLEX_ATTRIBUTE_21:
        return anonymous_complexAttribute_2_1 != null && !anonymous_complexAttribute_2_1.isEmpty();
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
    result.append(" (unique_1: ");
    result.append(unique_1);
    result.append(", lazy_1: ");
    result.append(lazy_1);
    result.append(", modifier_1: ");
    result.append(modifier_1);
    result.append(')');
    return result.toString();
  }

} //ComplexAttribute_Impl
