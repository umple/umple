/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.block;
import cruise.umple.umple.trystatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>trystatement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.trystatementImpl#getTryBlock <em>Try Block</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.trystatementImpl#getCatchBlock <em>Catch Block</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class trystatementImpl extends statementImpl implements trystatement
{
  /**
   * The cached value of the '{@link #getTryBlock() <em>Try Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTryBlock()
   * @generated
   * @ordered
   */
  protected block tryBlock;

  /**
   * The cached value of the '{@link #getCatchBlock() <em>Catch Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCatchBlock()
   * @generated
   * @ordered
   */
  protected block catchBlock;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected trystatementImpl()
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
    return UmplePackage.Literals.TRYSTATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public block getTryBlock()
  {
    return tryBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTryBlock(block newTryBlock, NotificationChain msgs)
  {
    block oldTryBlock = tryBlock;
    tryBlock = newTryBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.TRYSTATEMENT__TRY_BLOCK, oldTryBlock, newTryBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTryBlock(block newTryBlock)
  {
    if (newTryBlock != tryBlock)
    {
      NotificationChain msgs = null;
      if (tryBlock != null)
        msgs = ((InternalEObject)tryBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRYSTATEMENT__TRY_BLOCK, null, msgs);
      if (newTryBlock != null)
        msgs = ((InternalEObject)newTryBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRYSTATEMENT__TRY_BLOCK, null, msgs);
      msgs = basicSetTryBlock(newTryBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRYSTATEMENT__TRY_BLOCK, newTryBlock, newTryBlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public block getCatchBlock()
  {
    return catchBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCatchBlock(block newCatchBlock, NotificationChain msgs)
  {
    block oldCatchBlock = catchBlock;
    catchBlock = newCatchBlock;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmplePackage.TRYSTATEMENT__CATCH_BLOCK, oldCatchBlock, newCatchBlock);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCatchBlock(block newCatchBlock)
  {
    if (newCatchBlock != catchBlock)
    {
      NotificationChain msgs = null;
      if (catchBlock != null)
        msgs = ((InternalEObject)catchBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRYSTATEMENT__CATCH_BLOCK, null, msgs);
      if (newCatchBlock != null)
        msgs = ((InternalEObject)newCatchBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UmplePackage.TRYSTATEMENT__CATCH_BLOCK, null, msgs);
      msgs = basicSetCatchBlock(newCatchBlock, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.TRYSTATEMENT__CATCH_BLOCK, newCatchBlock, newCatchBlock));
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
      case UmplePackage.TRYSTATEMENT__TRY_BLOCK:
        return basicSetTryBlock(null, msgs);
      case UmplePackage.TRYSTATEMENT__CATCH_BLOCK:
        return basicSetCatchBlock(null, msgs);
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
      case UmplePackage.TRYSTATEMENT__TRY_BLOCK:
        return getTryBlock();
      case UmplePackage.TRYSTATEMENT__CATCH_BLOCK:
        return getCatchBlock();
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
      case UmplePackage.TRYSTATEMENT__TRY_BLOCK:
        setTryBlock((block)newValue);
        return;
      case UmplePackage.TRYSTATEMENT__CATCH_BLOCK:
        setCatchBlock((block)newValue);
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
      case UmplePackage.TRYSTATEMENT__TRY_BLOCK:
        setTryBlock((block)null);
        return;
      case UmplePackage.TRYSTATEMENT__CATCH_BLOCK:
        setCatchBlock((block)null);
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
      case UmplePackage.TRYSTATEMENT__TRY_BLOCK:
        return tryBlock != null;
      case UmplePackage.TRYSTATEMENT__CATCH_BLOCK:
        return catchBlock != null;
    }
    return super.eIsSet(featureID);
  }

} //trystatementImpl
