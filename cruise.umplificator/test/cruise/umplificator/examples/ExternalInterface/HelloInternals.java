/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import javax.swing.JFrame;
import javax.swing.JLabel;

// line 20 "ExternalInterface.ump"
public class HelloInternals extends JFrame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HelloInternals Attributes

  /**
   * messageLabel is a component of the frame; often we don't want sub-components
   * of a GUI unit to be settable/gettable. By making them internal Umple will avoid
   * generating setter/getter for messageLabel. Using lazy Umple will avoid adding a
   * constructor parameter for this component
   */
  private JLabel messageLabel;
  private String message;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public HelloInternals(String aMessage)
  {
    super();
    message = aMessage;
    // line 50 "ExternalInterface.ump"
    getContentPane().setLayout(null);
      
        messageLabel=new JLabel(message);
        messageLabel.setBounds(10, 10, 200, 20);
        add(messageLabel);
        
        pack();
        setSize(250, 200);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMessage(String aMessage)
  {
    boolean wasSet = false;
    message = aMessage;
    wasSet = true;
    // line 45 "ExternalInterface.ump"
    messageLabel.setText(message);
    return wasSet;
  }

  /**
   * the contents of messageLabel
   */
  public String getMessage()
  {
    // line 39 "ExternalInterface.ump"
    message=messageLabel.getText();
    return message;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "message" + ":" + getMessage()+ "]"
     + outputString;
  }
}