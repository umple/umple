/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.umple.impl;

import cruise.umple.umple.Generate;
import cruise.umple.umple.UmplePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cruise.umple.umple.impl.GenerateImpl#isJava <em>Java</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.GenerateImpl#isPhp <em>Php</em>}</li>
 *   <li>{@link cruise.umple.umple.impl.GenerateImpl#getRuby <em>Ruby</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GenerateImpl extends AbstractElementImpl implements Generate
{
  /**
   * The default value of the '{@link #isJava() <em>Java</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isJava()
   * @generated
   * @ordered
   */
  protected static final boolean JAVA_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isJava() <em>Java</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isJava()
   * @generated
   * @ordered
   */
  protected boolean java = JAVA_EDEFAULT;

  /**
   * The default value of the '{@link #isPhp() <em>Php</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPhp()
   * @generated
   * @ordered
   */
  protected static final boolean PHP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPhp() <em>Php</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPhp()
   * @generated
   * @ordered
   */
  protected boolean php = PHP_EDEFAULT;

  /**
   * The default value of the '{@link #getRuby() <em>Ruby</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuby()
   * @generated
   * @ordered
   */
  protected static final String RUBY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRuby() <em>Ruby</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuby()
   * @generated
   * @ordered
   */
  protected String ruby = RUBY_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected GenerateImpl()
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
    return UmplePackage.Literals.GENERATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isJava()
  {
    return java;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setJava(boolean newJava)
  {
    boolean oldJava = java;
    java = newJava;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GENERATE__JAVA, oldJava, java));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPhp()
  {
    return php;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPhp(boolean newPhp)
  {
    boolean oldPhp = php;
    php = newPhp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GENERATE__PHP, oldPhp, php));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRuby()
  {
    return ruby;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRuby(String newRuby)
  {
    String oldRuby = ruby;
    ruby = newRuby;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, UmplePackage.GENERATE__RUBY, oldRuby, ruby));
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
      case UmplePackage.GENERATE__JAVA:
        return isJava();
      case UmplePackage.GENERATE__PHP:
        return isPhp();
      case UmplePackage.GENERATE__RUBY:
        return getRuby();
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
      case UmplePackage.GENERATE__JAVA:
        setJava((Boolean)newValue);
        return;
      case UmplePackage.GENERATE__PHP:
        setPhp((Boolean)newValue);
        return;
      case UmplePackage.GENERATE__RUBY:
        setRuby((String)newValue);
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
      case UmplePackage.GENERATE__JAVA:
        setJava(JAVA_EDEFAULT);
        return;
      case UmplePackage.GENERATE__PHP:
        setPhp(PHP_EDEFAULT);
        return;
      case UmplePackage.GENERATE__RUBY:
        setRuby(RUBY_EDEFAULT);
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
      case UmplePackage.GENERATE__JAVA:
        return java != JAVA_EDEFAULT;
      case UmplePackage.GENERATE__PHP:
        return php != PHP_EDEFAULT;
      case UmplePackage.GENERATE__RUBY:
        return RUBY_EDEFAULT == null ? ruby != null : !RUBY_EDEFAULT.equals(ruby);
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
    result.append(" (java: ");
    result.append(java);
    result.append(", Php: ");
    result.append(php);
    result.append(", Ruby: ");
    result.append(ruby);
    result.append(')');
    return result.toString();
  }

} //GenerateImpl
