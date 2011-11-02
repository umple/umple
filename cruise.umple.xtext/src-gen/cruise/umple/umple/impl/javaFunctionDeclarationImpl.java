/**
 * <copyright>
 * </copyright>
 *

 */
package cruise.umple.umple.impl;

import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.javaFunctionDeclaration;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>java Function Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.javaFunctionDeclarationImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaFunctionDeclarationImpl#getReferenceType <em>Reference Type</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaFunctionDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaFunctionDeclarationImpl#getArgList <em>Arg List</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.javaFunctionDeclarationImpl#getArgListID <em>Arg List ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class javaFunctionDeclarationImpl extends MinimalEObjectImpl.Container implements javaFunctionDeclaration
{
  /**
   * The default value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected static final String RETURN_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturnType()
   * @generated
   * @ordered
   */
  protected String returnType = RETURN_TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getReferenceType() <em>Reference Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceType()
   * @generated
   * @ordered
   */
  protected static final String REFERENCE_TYPE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReferenceType() <em>Reference Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferenceType()
   * @generated
   * @ordered
   */
  protected String referenceType = REFERENCE_TYPE_EDEFAULT;

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
   * The cached value of the '{@link #getArgList() <em>Arg List</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgList()
   * @generated
   * @ordered
   */
  protected EList<String> argList;

  /**
   * The cached value of the '{@link #getArgListID() <em>Arg List ID</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgListID()
   * @generated
   * @ordered
   */
  protected EList<String> argListID;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected javaFunctionDeclarationImpl()
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
    return UmplePackage.Literals.JAVA_FUNCTION_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReturnType()
  {
    return returnType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReturnType(String newReturnType)
  {
    String oldReturnType = returnType;
    returnType = newReturnType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_FUNCTION_DECLARATION__RETURN_TYPE, oldReturnType, returnType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getReferenceType()
  {
    return referenceType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReferenceType(String newReferenceType)
  {
    String oldReferenceType = referenceType;
    referenceType = newReferenceType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_FUNCTION_DECLARATION__REFERENCE_TYPE, oldReferenceType, referenceType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.JAVA_FUNCTION_DECLARATION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getArgList()
  {
    if (argList == null)
    {
      argList = new EDataTypeEList<String>(String.class, this, UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST);
    }
    return argList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getArgListID()
  {
    if (argListID == null)
    {
      argListID = new EDataTypeEList<String>(String.class, this, UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST_ID);
    }
    return argListID;
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
      case UmplePackage.JAVA_FUNCTION_DECLARATION__RETURN_TYPE:
        return getReturnType();
      case UmplePackage.JAVA_FUNCTION_DECLARATION__REFERENCE_TYPE:
        return getReferenceType();
      case UmplePackage.JAVA_FUNCTION_DECLARATION__NAME:
        return getName();
      case UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST:
        return getArgList();
      case UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST_ID:
        return getArgListID();
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
      case UmplePackage.JAVA_FUNCTION_DECLARATION__RETURN_TYPE:
        setReturnType((String)newValue);
        return;
      case UmplePackage.JAVA_FUNCTION_DECLARATION__REFERENCE_TYPE:
        setReferenceType((String)newValue);
        return;
      case UmplePackage.JAVA_FUNCTION_DECLARATION__NAME:
        setName((String)newValue);
        return;
      case UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST:
        getArgList().clear();
        getArgList().addAll((Collection<? extends String>)newValue);
        return;
      case UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST_ID:
        getArgListID().clear();
        getArgListID().addAll((Collection<? extends String>)newValue);
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
      case UmplePackage.JAVA_FUNCTION_DECLARATION__RETURN_TYPE:
        setReturnType(RETURN_TYPE_EDEFAULT);
        return;
      case UmplePackage.JAVA_FUNCTION_DECLARATION__REFERENCE_TYPE:
        setReferenceType(REFERENCE_TYPE_EDEFAULT);
        return;
      case UmplePackage.JAVA_FUNCTION_DECLARATION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST:
        getArgList().clear();
        return;
      case UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST_ID:
        getArgListID().clear();
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
      case UmplePackage.JAVA_FUNCTION_DECLARATION__RETURN_TYPE:
        return RETURN_TYPE_EDEFAULT == null ? returnType != null : !RETURN_TYPE_EDEFAULT.equals(returnType);
      case UmplePackage.JAVA_FUNCTION_DECLARATION__REFERENCE_TYPE:
        return REFERENCE_TYPE_EDEFAULT == null ? referenceType != null : !REFERENCE_TYPE_EDEFAULT.equals(referenceType);
      case UmplePackage.JAVA_FUNCTION_DECLARATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST:
        return argList != null && !argList.isEmpty();
      case UmplePackage.JAVA_FUNCTION_DECLARATION__ARG_LIST_ID:
        return argListID != null && !argListID.isEmpty();
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
    result.append(" (returnType: ");
    result.append(returnType);
    result.append(", referenceType: ");
    result.append(referenceType);
    result.append(", name: ");
    result.append(name);
    result.append(", argList: ");
    result.append(argList);
    result.append(", argListID: ");
    result.append(argListID);
    result.append(')');
    return result.toString();
  }

} //javaFunctionDeclarationImpl
