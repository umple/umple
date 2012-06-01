/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.addElection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import shared.listeners.GenericMouseListener;

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

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AddElectionView()
  {
    super();
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
		
		setLocationRelativeTo(null);
		
		pack();
		setSize(250, 200);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  public String getElectionName(){
      return electionNameTextField.getText();
  }


  public String getElectionDescription(){
      return electionDescriptionTextArea.getText();
  }

}