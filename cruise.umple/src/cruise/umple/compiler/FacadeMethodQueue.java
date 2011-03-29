/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

public class FacadeMethodQueue
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static FacadeMethodQueue theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FacadeMethodQueue Attributes
  private Queue<FacadeMethod> queue;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private FacadeMethodQueue()
  {
    queue = new LinkedList<FacadeMethod>();
  }

  public static FacadeMethodQueue getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new FacadeMethodQueue();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public void cleanUp()
  {
    while (poll() != null);
  }

  public void add(FacadeMethod method) {
    queue.add(method);
  }

  public FacadeMethod peek() {
    return queue.peek();
  }
  
  public FacadeMethod poll() {
    return queue.poll();
  }
}