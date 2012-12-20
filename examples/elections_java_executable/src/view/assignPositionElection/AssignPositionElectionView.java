/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.assignPositionElection;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import shared.listeners.GenericMouseListener;
import shared.listeners.GenericWindowListener;
import shared.domain.Election;
import shared.domain.Position;
import shared.domain.ElectionForPosition;
import view.ViewUtils;
import view.main.*;

public class AssignPositionElectionView extends JFrame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssignPositionElectionView Attributes
  private JButton updateButton;
  private JLabel electionsLabel;
  private JComboBox electionsComboBox;
  private JLabel positionsLabel;
  private JList positionsList;
  private List<Election> elections;
  private List<Position> positions;
  private List<ElectionForPosition> electionForPositions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssignPositionElectionView(List<Election> aElections, List<Position> aPositions)
  {
    super();
    elections = aElections;
    positions = aPositions;
    getContentPane().setLayout(null);
  
    positionsLabel=new JLabel("Select some positions:");
    positionsLabel.setBounds(10, 10, 200, 20);
    add(positionsLabel);

    positionsList=new JList(positions.toArray());
    positionsList.setBounds(10, 30, 200, 100);
    add(positionsList);
    
    electionsLabel=new JLabel("Select an election:");
    electionsLabel.setBounds(10, 135, 200, 20);
    add(electionsLabel);

    electionsComboBox=new JComboBox(elections.toArray());
    electionsComboBox.setBounds(10, 155, 200, 20);
    add(electionsComboBox);
    
    updateButton=new JButton("update");
    updateButton.setBounds(75, 180, 75, 20);
    updateButton.addMouseListener(GenericMouseListener.AssignPositionElectionViewMouseListener);
    add(updateButton);
    
    pack();
    setSize(250, 250);
    
    ViewUtils.getInstance().setToBeCenteredFrame(this);
    addWindowListener(GenericWindowListener.AssignPositionElectionViewWindowListener);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setElections(List<Election> aElections)
  {
    boolean wasSet = false;
    elections = aElections;
    wasSet = true;
    return wasSet;
  }

  public boolean setPositions(List<Position> aPositions)
  {
    boolean wasSet = false;
    positions = aPositions;
    wasSet = true;
    return wasSet;
  }

  public boolean setElectionForPositions(List<ElectionForPosition> aElectionForPositions)
  {
    boolean wasSet = false;
    electionForPositions = aElectionForPositions;
    wasSet = true;
    return wasSet;
  }

  public List<Election> getElections()
  {
    return elections;
  }

  public List<Position> getPositions()
  {
    return positions;
  }

  public List<ElectionForPosition> getElectionForPositions()
  {
    electionForPositions=new ArrayList<ElectionForPosition>();
    for (Object o:positionsList.getSelectedValues()) {
    	electionForPositions.add(new ElectionForPosition(-1, (Election)electionsComboBox.getSelectedItem(), (Position)o));
    }
    return electionForPositions;
  }

  public void delete()
  {}

}