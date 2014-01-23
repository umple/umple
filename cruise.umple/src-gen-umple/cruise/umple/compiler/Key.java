/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * 
 * A key in a class is a set of attributes associations used to uniquely identify an object
 * 
 * @umplesource Umple.ump 316
 * @umplesource Umple_Code.ump 400
 */
// line 316 "../../../../src/Umple.ump"
// line 400 "../../../../src/Umple_Code.ump"
public class Key
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Key Attributes
  private boolean isDefault;
  private List<String> members;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Key()
  {
    isDefault = false;
    members = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setIsDefault(boolean aIsDefault)
  {
    boolean wasSet = false;
    isDefault = aIsDefault;
    wasSet = true;
    return wasSet;
  }

  public boolean addMember(String aMember)
  {
    boolean wasAdded = false;
    wasAdded = members.add(aMember);
    return wasAdded;
  }

  public boolean removeMember(String aMember)
  {
    boolean wasRemoved = false;
    wasRemoved = members.remove(aMember);
    return wasRemoved;
  }

  public boolean getIsDefault()
  {
    return isDefault;
  }

  public String getMember(int index)
  {
    String aMember = members.get(index);
    return aMember;
  }

  public String[] getMembers()
  {
    String[] newMembers = members.toArray(new String[members.size()]);
    return newMembers;
  }

  public int numberOfMembers()
  {
    int number = members.size();
    return number;
  }

  public boolean hasMembers()
  {
    boolean has = members.size() > 0;
    return has;
  }

  public int indexOfMember(String aMember)
  {
    int index = members.indexOf(aMember);
    return index;
  }

  public boolean isIsDefault()
  {
    return isDefault;
  }

  public void delete()
  {}

  @umplesourcefile(line={405},file={"Umple_Code.ump"},javaline={110},length={3})
   public boolean isProvided(){
    return isDefault || members.size() > 0;
  }

  @umplesourcefile(line={410},file={"Umple_Code.ump"},javaline={115},length={7})
   public boolean isMember(UmpleVariable av){
    if (av == null)
    {
      return false;
    }
    return indexOfMember(av.getName()) != -1;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "isDefault" + ":" + getIsDefault()+ "]"
     + outputString;
  }
}