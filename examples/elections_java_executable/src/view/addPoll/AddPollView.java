/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.addPoll;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import shared.listeners.GenericMouseListener;
import shared.listeners.GenericWindowListener;
import shared.domain.Election;
import view.ViewUtils;

public class AddPollView extends JFrame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AddPollView Attributes
  private JLabel pollNameLabel;
  private JLabel pollDescriptionLabel;
  private JTextField pollNameTextField;
  private JTextArea pollDescriptionTextArea;
  private JButton addPollButton;
  private JLabel electionsLabel;
  private JComboBox electionsComboBox;
  private String pollName;
  private String pollDescription;
  private List<Election> elections;
  private Election selectedElection;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AddPollView(List<Election> aElections)
  {
    super();
    pollName = null;
    pollDescription = null;
    elections = aElections;
    getContentPane().setLayout(null);
	
		pollNameLabel=new JLabel("poll Name:");
		pollNameLabel.setBounds(10, 10, 200, 20);
		add(pollNameLabel);
		
		pollNameTextField=new JTextField();
		pollNameTextField.setBounds(10, 30, 200, 20);
		add(pollNameTextField);
		
		pollDescriptionLabel=new JLabel("Add a description:");
		pollDescriptionLabel.setBounds(10, 50, 200, 20);
		add(pollDescriptionLabel);
		
		pollDescriptionTextArea=new JTextArea();
		pollDescriptionTextArea.setBounds(10, 70, 200, 60);
		add(pollDescriptionTextArea);
		
		electionsLabel=new JLabel("Select an election:");
		electionsLabel.setBounds(10, 135, 200, 20);
		add(electionsLabel);
		
		/*String[] electionNames=new String[elections.size()];
		int i=0;
		for (Election election:elections)
			electionNames[i++]=election.getName();*/
		electionsComboBox=new JComboBox(elections.toArray());
		electionsComboBox.setBounds(10, 155, 200, 20);
		add(electionsComboBox);
		
		addPollButton=new JButton("add");
		addPollButton.setBounds(75, 180, 75, 20);
		addPollButton.addMouseListener(GenericMouseListener.AddPollViewMouseListener);
		add(addPollButton);
		
		pack();
		setSize(250, 250);
		
		ViewUtils.getInstance().setToBeCenteredFrame(this);
		addWindowListener(GenericWindowListener.AddPollViewWindowListener);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPollName(String aPollName)
  {
    boolean wasSet = false;
    pollName = aPollName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPollDescription(String aPollDescription)
  {
    boolean wasSet = false;
    pollDescription = aPollDescription;
    wasSet = true;
    return wasSet;
  }

  public boolean setElections(List<Election> aElections)
  {
    boolean wasSet = false;
    elections = aElections;
    wasSet = true;
    return wasSet;
  }

  public boolean setSelectedElection(Election aSelectedElection)
  {
    boolean wasSet = false;
    selectedElection = aSelectedElection;
    wasSet = true;
    return wasSet;
  }

  public String getPollName()
  {
    pollName=pollNameTextField.getText();
    return pollName;
  }

  public String getPollDescription()
  {
    pollDescription=pollDescriptionTextArea.getText();
    return pollDescription;
  }

  public List<Election> getElections()
  {
    return elections;
  }

  public Election getSelectedElection()
  {
    selectedElection=(Election)electionsComboBox.getSelectedItem();
    return selectedElection;
  }

  public void delete()
  {}

}