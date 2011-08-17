/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.functionDeclaration;
import cruise.umple.umple.javaFunctionDeclaration;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>function Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.functionDeclarationImpl#getJava <em>Java</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class functionDeclarationImpl extends MinimalEObjectImpl.Container implements functionDeclaration
{
  /**
   * The cached value of the '{@link #getJava() <em>Java</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJava()
   * @generated
   * @ordered
   */
  protected javaFunctionDeclaration java;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected functionDeclarationImpl()
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
    return UmplePackage.Literals.FUNCTION_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public javaFunctionDeclaration getJava()
  {
    return java;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetJava(javaFunctionDeclaration newJava, NotificationChain msgs)
  {
    javaFunctionDeclaration oldJava = java;
    java = newJava;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.FUNCTION_DECLARATION__JAVA, oldJava, newJava);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJava(javaFunctionDeclaration newJava)
  {
    if (newJava != java)
    {
      NotificationChain msgs = null;
      if (java != null)
        msgs = ((InternalEObject)java).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.FUNCTION_DECLARATION__JAVA, null, msgs);
      if (newJava != null)
        msgs = ((InternalEObject)newJava).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.FUNCTION_DECLARATION__JAVA, null, msgs);
      msgs = basicSetJava(newJava, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.FUNCTION_DECLARATION__JAVA, newJava, newJava));
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
      case UmplePackage.FUNCTION_DECLARATION__JAVA:
        return basicSetJava(null, msgs);
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
      case UmplePackage.FUNCTION_DECLARATION__JAVA:
        return getJava();
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
      case UmplePackage.FUNCTION_DECLARATION__JAVA:
        setJava((javaFunctionDeclaration)newValue);
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
      case UmplePackage.FUNCTION_DECLARATION__JAVA:
        setJava((javaFunctionDeclaration)null);
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
      case UmplePackage.FUNCTION_DECLARATION__JAVA:
        return java != null;
    }
    return super.eIsSet(featureID);
  }

} //functionDeclarationImpl
