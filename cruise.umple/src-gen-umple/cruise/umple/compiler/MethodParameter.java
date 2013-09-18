/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Represents a parameter in a method and its various forms.
 * @umplesource Umple.ump 180
 */
// line 180 "../../../../src/Umple.ump"
public class MethodParameter extends UmpleVariable
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MethodParameter Attributes
  private boolean isAutounique;
  private boolean isList;
  private boolean isDerived;
  private boolean isLazy;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MethodParameter(String aName, String aType, String aModifier, String aValue, boolean aIsAutounique)
  {
    super(aName, aType, aModifier, aValue);
    isAutounique = aIsAutounique;
    isList = false;
    isDerived = false;
    isLazy = false;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsAutounique(boolean aIsAutounique)
  {
    boolean wasSet = false;
    isAutounique = aIsAutounique;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsList(boolean aIsList)
  {
    boolean wasSet = false;
    isList = aIsList;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsDerived(boolean aIsDerived)
  {
    boolean wasSet = false;
    isDerived = aIsDerived;
    wasSet = true;
    return wasSet;
  }

  public boolean setIsLazy(boolean aIsLazy)
  {
    boolean wasSet = false;
    isLazy = aIsLazy;
    wasSet = true;
    return wasSet;
  }

  /**
   * Specifies whether or not the method parameter is auto unique.
   */
  public boolean getIsAutounique()
  {
    return isAutounique;
  }

  /**
   * TODO: should default to false, but constructors would need updating
   * Specifies whether or not the method parameter is a list.
   */
  public boolean getIsList()
  {
    return isList;
  }

  /**
   * Specifies whether or not the method parameter is derived.
   */
  public boolean getIsDerived()
  {
    return isDerived;
  }

  /**
   * Specifies whether or not the method parameter is lazy.
   */
  public boolean getIsLazy()
  {
    return isLazy;
  }

  public boolean isIsAutounique()
  {
    return isAutounique;
  }

  public boolean isIsList()
  {
    return isList;
  }

  public boolean isIsDerived()
  {
    return isDerived;
  }

  public boolean isIsLazy()
  {
    return isLazy;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isAutounique" + ":" + getIsAutounique()+ "," +
            "isList" + ":" + getIsList()+ "," +
            "isDerived" + ":" + getIsDerived()+ "," +
            "isLazy" + ":" + getIsLazy()+ "]"
     + outputString;
  }
}