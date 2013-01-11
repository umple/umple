/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.patterns.test;
import java.util.*;

// line 37 "../../../../src/TestHarnessPatternsImmutable.ump"
public class ClassMToN
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassMToN Associations
  private List<ClassOtherclass> classOtherclasses;

  //Helper Variables
  private boolean canSetClassOtherclasses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassMToN(ClassOtherclass... allClassOtherclasses)
  {
    canSetClassOtherclasses = true;
    classOtherclasses = new ArrayList<ClassOtherclass>();
    boolean didAddClassOtherclasses = setClassOtherclasses(allClassOtherclasses);
    if (!didAddClassOtherclasses)
    {
      throw new RuntimeException("Unable to create ClassMToN, must have 2 to 3 classOtherclasses");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public ClassOtherclass getClassOtherclass(int index)
  {
    ClassOtherclass aClassOtherclass = classOtherclasses.get(index);
    return aClassOtherclass;
  }

  public List<ClassOtherclass> getClassOtherclasses()
  {
    List<ClassOtherclass> newClassOtherclasses = Collections.unmodifiableList(classOtherclasses);
    return newClassOtherclasses;
  }

  public int numberOfClassOtherclasses()
  {
    int number = classOtherclasses.size();
    return number;
  }

  public boolean hasClassOtherclasses()
  {
    boolean has = classOtherclasses.size() > 0;
    return has;
  }

  public int indexOfClassOtherclass(ClassOtherclass aClassOtherclass)
  {
    int index = classOtherclasses.indexOf(aClassOtherclass);
    return index;
  }

  public static int minimumNumberOfClassOtherclasses()
  {
    return 2;
  }

  public static int maximumNumberOfClassOtherclasses()
  {
    return 3;
  }

  private boolean setClassOtherclasses(ClassOtherclass... newClassOtherclasses)
  {
    boolean wasSet = false;
    if (!canSetClassOtherclasses) { return false; }
    canSetClassOtherclasses = false;
    ArrayList<ClassOtherclass> verifiedClassOtherclasses = new ArrayList<ClassOtherclass>();
    for (ClassOtherclass aClassOtherclass : newClassOtherclasses)
    {
      if (verifiedClassOtherclasses.contains(aClassOtherclass))
      {
        continue;
      }
      verifiedClassOtherclasses.add(aClassOtherclass);
    }

    if (verifiedClassOtherclasses.size() != newClassOtherclasses.length || verifiedClassOtherclasses.size() < minimumNumberOfClassOtherclasses() || verifiedClassOtherclasses.size() > maximumNumberOfClassOtherclasses())
    {
      return wasSet;
    }

    classOtherclasses.clear();
    classOtherclasses.addAll(verifiedClassOtherclasses);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {}

}