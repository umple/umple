/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.addElection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import shared.listeners.GenericMouseListener;
import shared.listeners.GenericWindowListener;
import view.ViewUtils;
import view.addPoll.*;

public class AddElectionView extends JFrame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AddElectionView Attributes
  private JLabel electionNameLabel;
  private JLabel electionDescriptionLabel;
  private JTextField electionNameTextField;
  private JTextArea electionDescriptionTextArea;
  private JButton addElectionButton;
  private String electionName;
  private String electionDescription;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AddElectionView()
  {
    super();
    electionName = null;
    electionDescription = null;
    getContentPane().setLayout(null);
	
		electionNameLabel=new JLabel("Election Name:");
		electionNameLabel.setBounds(10, 10, 200, 20);
		add(electionNameLabel);
		
		electionNameTextField=new JTextField();
		electionNameTextField.setBounds(10, 30, 200, 20);
		add(electionNameTextField);
		
		electionDescriptionLabel=new JLabel("Add a description:");
		electionDescriptionLabel.setBounds(10, 50, 200, 20);
		add(electionDescriptionLabel);
		
		electionDescriptionTextArea=new JTextArea();
		electionDescriptionTextArea.setBounds(10, 70, 200, 60);
		add(electionDescriptionTextArea);
		
		addElectionButton=new JButton("add");
		addElectionButton.setBounds(75, 135, 75, 20);
		addElectionButton.addMouseListener(GenericMouseListener.AddElectionViewMouseListener);
		add(addElectionButton);
		
		pack();
		setSize(250, 200);
		ViewUtils.getInstance().setToBeCenteredFrame(this);
		addWindowListener(GenericWindowListener.AddElectionViewWindowListener);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setElectionName(String aElectionName)
  {
    boolean wasSet = false;
    electionName = aElectionName;
    wasSet = true;
    return wasSet;
  }

  public boolean setElectionDescription(String aElectionDescription)
  {
    boolean wasSet = false;
    electionDescription = aElectionDescription;
    wasSet = true;
    return wasSet;
  }

  public String getElectionName()
  {
    electionName=electionNameTextField.getText();
    return electionName;
  }

  public String getElectionDescription()
  {
    electionDescription=electionDescriptionTextArea.getText();
    return electionDescription;
  }

  public void delete()
  {}

}