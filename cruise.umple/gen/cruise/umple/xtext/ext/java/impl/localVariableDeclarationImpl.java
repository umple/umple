/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java.impl;

import cruise.umple.xtext.ext.java.JavaPackage;
import cruise.umple.xtext.ext.java.expression;
import cruise.umple.xtext.ext.java.forInit;
import cruise.umple.xtext.ext.java.localVariableDeclaration;
import cruise.umple.xtext.ext.java.variableDeclarators;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>local Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.xtext.ext.java.impl.localVariableDeclarationImpl#getExpressions <em>Expressions</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.impl.localVariableDeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link cruise.umple.xtext.ext.java.impl.localVariableDeclarationImpl#getDec <em>Dec</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class localVariableDeclarationImpl extends localVariableDeclarationStatementImpl implements localVariableDeclaration
{
  /**
   * The cached value of the '{@link #getExpressions() <em>Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressions()
   * @generated
   * @ordered
   */
  protected EList<expression> expressions;

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
   * The cached value of the '{@link #getDec() <em>Dec</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDec()
   * @generated
   * @ordered
   */
  protected variableDeclarators dec;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected localVariableDeclarationImpl()
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
    return JavaPackage.Literals.LOCAL_VARIABLE_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<expression> getExpressions()
  {
    if (expressions == null)
    {
      expressions = new EObjectContainmentEList<expression>(expression.class, this, JavaPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSIONS);
    }
    return expressions;
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
      eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.LOCAL_VARIABLE_DECLARATION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public variableDeclarators getDec()
  {
    return dec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDec(variableDeclarators newDec, NotificationChain msgs)
  {
    variableDeclarators oldDec = dec;
    dec = newDec;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC, oldDec, newDec);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDec(variableDeclarators newDec)
  {
    if (newDec != dec)
    {
      NotificationChain msgs = null;
      if (dec != null)
        msgs = ((InternalEObject)dec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC, null, msgs);
      if (newDec != null)
        msgs = ((InternalEObject)newDec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC, null, msgs);
      msgs = basicSetDec(newDec, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC, newDec, newDec));
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
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSIONS:
        return ((InternalEList<?>)getExpressions()).basicRemove(otherEnd, msgs);
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC:
        return basicSetDec(null, msgs);
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
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSIONS:
        return getExpressions();
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__TYPE:
        return getType();
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC:
        return getDec();
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
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSIONS:
        getExpressions().clear();
        getExpressions().addAll((Collection<? extends expression>)newValue);
        return;
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__TYPE:
        setType((String)newValue);
        return;
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC:
        setDec((variableDeclarators)newValue);
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
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSIONS:
        getExpressions().clear();
        return;
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__TYPE:
        setType(TYPE_EDEFAULT);
        return;
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC:
        setDec((variableDeclarators)null);
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
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSIONS:
        return expressions != null && !expressions.isEmpty();
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__TYPE:
        return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
      case JavaPackage.LOCAL_VARIABLE_DECLARATION__DEC:
        return dec != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == forInit.class)
    {
      switch (derivedFeatureID)
      {
        case JavaPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSIONS: return JavaPackage.FOR_INIT__EXPRESSIONS;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == forInit.class)
    {
      switch (baseFeatureID)
      {
        case JavaPackage.FOR_INIT__EXPRESSIONS: return JavaPackage.LOCAL_VARIABLE_DECLARATION__EXPRESSIONS;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //localVariableDeclarationImpl
