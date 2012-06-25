/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class ViewUtils
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static ViewUtils theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ViewUtils Attributes
  private JFrame toBeCenteredFrame;
  private Dimension dim;

  //ViewUtils State Machines
  enum ServiceProvidingCycle { Idle, FrameCentering }
  private ServiceProvidingCycle ServiceProvidingCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private ViewUtils()
  {
    dim = Toolkit.getDefaultToolkit().getScreenSize();
    setServiceProvidingCycle(ServiceProvidingCycle.Idle);
  }

  public static ViewUtils getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new ViewUtils();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setToBeCenteredFrame(JFrame aToBeCenteredFrame)
  {
    boolean wasSet = false;
    toBeCenteredFrame = aToBeCenteredFrame;
    wasSet = true;
    center();
    return wasSet;
  }

  public JFrame getToBeCenteredFrame()
  {
    return toBeCenteredFrame;
  }

  public String getServiceProvidingCycleFullName()
  {
    String answer = ServiceProvidingCycle.toString();
    return answer;
  }

  public ServiceProvidingCycle getServiceProvidingCycle()
  {
    return ServiceProvidingCycle;
  }

  public boolean center()
  {
    boolean wasEventProcessed = false;
    
    ServiceProvidingCycle aServiceProvidingCycle = ServiceProvidingCycle;
    switch (aServiceProvidingCycle)
    {
      case Idle:
        setServiceProvidingCycle(ServiceProvidingCycle.FrameCentering);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition650__()
  {
    boolean wasEventProcessed = false;
    
    ServiceProvidingCycle aServiceProvidingCycle = ServiceProvidingCycle;
    switch (aServiceProvidingCycle)
    {
      case FrameCentering:
        setServiceProvidingCycle(ServiceProvidingCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setServiceProvidingCycle(ServiceProvidingCycle aServiceProvidingCycle)
  {
    ServiceProvidingCycle = aServiceProvidingCycle;

    // entry actions and do activities
    switch(ServiceProvidingCycle)
    {
      case FrameCentering:
        performCentering();
        __autotransition650__();
        break;
    }
  }

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void performCentering()
  {
    int w = toBeCenteredFrame.getSize().width;
    int h = toBeCenteredFrame.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
     
    toBeCenteredFrame.setLocation(x, y);
  }
}