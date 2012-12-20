/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.registerVoter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import shared.listeners.GenericMouseListener;
import shared.listeners.GenericWindowListener;
import view.ViewUtils;
import view.main.*;

public class RegisterVoterView extends JFrame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegisterVoterView Attributes
  private JLabel voterNameLabel;
  private JLabel voterAddressLabel;
  private JLabel voterTelephoneLabel;
  private JTextField voterNameTextField;
  private JTextField voterTelephoneTextField;
  private JTextArea voterAddressTextArea;
  private JButton registerVoterButton;
  private String voterName;
  private String voterAddress;
  private String voterTelephone;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RegisterVoterView()
  {
    super();
    voterName = null;
    voterAddress = null;
    voterTelephone = null;
    getContentPane().setLayout(null);
  
    voterNameLabel=new JLabel("Voter Name:");
    voterNameLabel.setBounds(10, 10, 200, 20);
    add(voterNameLabel);
    
    voterNameTextField=new JTextField();
    voterNameTextField.setBounds(10, 30, 200, 20);
    add(voterNameTextField);
    
    voterTelephoneLabel=new JLabel("Voter Telephone:");
    voterTelephoneLabel.setBounds(10, 50, 200, 20);
    add(voterTelephoneLabel);
    
    voterTelephoneTextField=new JTextField();
    voterTelephoneTextField.setBounds(10, 70, 200, 20);
    add(voterTelephoneTextField);
    
    voterAddressLabel=new JLabel("Add an address:");
    voterAddressLabel.setBounds(10, 90, 200, 20);
    add(voterAddressLabel);
    
    voterAddressTextArea=new JTextArea();
    voterAddressTextArea.setBounds(10, 110, 200, 60);
    add(voterAddressTextArea);
    
    registerVoterButton=new JButton("register");
    registerVoterButton.setBounds(50, 175, 125, 20);
    registerVoterButton.addMouseListener(GenericMouseListener.RegisterVoterViewMouseListener);
    add(registerVoterButton);
    
    pack();
    setSize(250, 250);
    ViewUtils.getInstance().setToBeCenteredFrame(this);
    addWindowListener(GenericWindowListener.RegisterVoterViewWindowListener);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setVoterName(String aVoterName)
  {
    boolean wasSet = false;
    voterName = aVoterName;
    wasSet = true;
    return wasSet;
  }

  public boolean setVoterAddress(String aVoterAddress)
  {
    boolean wasSet = false;
    voterAddress = aVoterAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setVoterTelephone(String aVoterTelephone)
  {
    boolean wasSet = false;
    voterTelephone = aVoterTelephone;
    wasSet = true;
    return wasSet;
  }

  public String getVoterName()
  {
    voterName=voterNameTextField.getText();
    return voterName;
  }

  public String getVoterAddress()
  {
    voterAddress=voterAddressTextArea.getText();
    return voterAddress;
  }

  public String getVoterTelephone()
  {
    voterTelephone=voterTelephoneTextField.getText();
    return voterTelephone;
  }

  public void delete()
  {}

}