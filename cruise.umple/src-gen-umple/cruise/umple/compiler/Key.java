/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * 
 * A key in a class is a set of attributes associations used to uniquely identify an object
 * @umplesource Umple.ump 299
 * @umplesource Umple_Code.ump 383
 */
// line 299 "../../../../src/Umple.ump"
// line 383 "../../../../src/Umple_Code.ump"
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


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "isDefault" + ":" + getIsDefault()+ "]"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={384},file={"Umple_Code.ump"},javaline={120},length={14})
  @umplesourcefile(line={385},file={"Umple_Code.ump"},javaline={121},length={4})
  public boolean isProvided()
  {
    return isDefault || members.size() > 0;
  }

  @umplesourcefile(line={390},file={"Umple_Code.ump"},javaline={127},length={8})
  public boolean isMember(UmpleVariable av)
  {
    if (av == null)
    {
      return false;
    }
    return indexOfMember(av.getName()) != -1;
  }

}