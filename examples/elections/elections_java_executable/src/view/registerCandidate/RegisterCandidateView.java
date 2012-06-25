/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.registerCandidate;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import shared.listeners.GenericMouseListener;
import shared.listeners.GenericWindowListener;
import view.ViewUtils;
import view.main.*;

public class RegisterCandidateView extends JFrame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //RegisterCandidateView Attributes
  private JLabel candidateNameLabel;
  private JLabel candidateAddressLabel;
  private JLabel candidateTelephoneLabel;
  private JTextField candidateNameTextField;
  private JTextField candidateTelephoneTextField;
  private JTextArea candidateAddressTextArea;
  private JButton registerCandidateButton;
  private String candidateName;
  private String candidateAddress;
  private String candidateTelephone;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public RegisterCandidateView()
  {
    super();
    candidateName = null;
    candidateAddress = null;
    candidateTelephone = null;
    getContentPane().setLayout(null);
  
    candidateNameLabel=new JLabel("Candidate Name:");
    candidateNameLabel.setBounds(10, 10, 200, 20);
    add(candidateNameLabel);
    
    candidateNameTextField=new JTextField();
    candidateNameTextField.setBounds(10, 30, 200, 20);
    add(candidateNameTextField);
    
    candidateTelephoneLabel=new JLabel("Candidate Telephone:");
    candidateTelephoneLabel.setBounds(10, 50, 200, 20);
    add(candidateTelephoneLabel);
    
    candidateTelephoneTextField=new JTextField();
    candidateTelephoneTextField.setBounds(10, 70, 200, 20);
    add(candidateTelephoneTextField);
    
    candidateAddressLabel=new JLabel("Add an address:");
    candidateAddressLabel.setBounds(10, 90, 200, 20);
    add(candidateAddressLabel);
    
    candidateAddressTextArea=new JTextArea();
    candidateAddressTextArea.setBounds(10, 110, 200, 60);
    add(candidateAddressTextArea);
    
    registerCandidateButton=new JButton("register");
    registerCandidateButton.setBounds(50, 175, 125, 20);
    registerCandidateButton.addMouseListener(GenericMouseListener.RegisterCandidateViewMouseListener);
    add(registerCandidateButton);
    
    pack();
    setSize(250, 250);
    ViewUtils.getInstance().setToBeCenteredFrame(this);
    addWindowListener(GenericWindowListener.RegisterCandidateViewWindowListener);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCandidateName(String aCandidateName)
  {
    boolean wasSet = false;
    candidateName = aCandidateName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCandidateAddress(String aCandidateAddress)
  {
    boolean wasSet = false;
    candidateAddress = aCandidateAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setCandidateTelephone(String aCandidateTelephone)
  {
    boolean wasSet = false;
    candidateTelephone = aCandidateTelephone;
    wasSet = true;
    return wasSet;
  }

  public String getCandidateName()
  {
    candidateName=candidateNameTextField.getText();
    return candidateName;
  }

  public String getCandidateAddress()
  {
    candidateAddress=candidateAddressTextArea.getText();
    return candidateAddress;
  }

  public String getCandidateTelephone()
  {
    candidateTelephone=candidateTelephoneTextField.getText();
    return candidateTelephone;
  }

  public void delete()
  {}

}