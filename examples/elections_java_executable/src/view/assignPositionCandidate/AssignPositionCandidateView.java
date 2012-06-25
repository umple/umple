/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.assignPositionCandidate;
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
import shared.domain.Candidate;
import shared.domain.Candidature;
import shared.domain.ElectionForPosition;
import view.ViewUtils;
import view.main.*;

public class AssignPositionCandidateView extends JFrame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AssignPositionCandidateView Attributes
  private JButton updateButton;
  private JLabel positionsLabel;
  private JComboBox positionsComboBox;
  private JLabel candidatesLabel;
  private JList candidatesList;
  private List<Candidate> candidates;
  private List<ElectionForPosition> positions;
  private List<Candidature> candidatures;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AssignPositionCandidateView(List<Candidate> aCandidates, List<ElectionForPosition> aPositions)
  {
    super();
    candidates = aCandidates;
    positions = aPositions;
    getContentPane().setLayout(null);
  
    candidatesLabel=new JLabel("Select some candidates:");
    candidatesLabel.setBounds(10, 10, 200, 20);
    add(candidatesLabel);

    candidatesList=new JList(candidates.toArray());
    candidatesList.setBounds(10, 30, 200, 100);
    add(candidatesList);
    
    positionsLabel=new JLabel("Select a position:");
    positionsLabel.setBounds(10, 135, 200, 20);
    add(positionsLabel);

    positionsComboBox=new JComboBox(positions.toArray());
    positionsComboBox.setBounds(10, 155, 200, 20);
    add(positionsComboBox);
    
    updateButton=new JButton("update");
    updateButton.setBounds(75, 180, 75, 20);
    updateButton.addMouseListener(GenericMouseListener.AssignPositionCandidateViewMouseListener);
    add(updateButton);
    
    pack();
    setSize(250, 250);
    
    ViewUtils.getInstance().setToBeCenteredFrame(this);
    addWindowListener(GenericWindowListener.AssignPositionCandidateViewWindowListener);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCandidates(List<Candidate> aCandidates)
  {
    boolean wasSet = false;
    candidates = aCandidates;
    wasSet = true;
    return wasSet;
  }

  public boolean setPositions(List<ElectionForPosition> aPositions)
  {
    boolean wasSet = false;
    positions = aPositions;
    wasSet = true;
    return wasSet;
  }

  public boolean setCandidatures(List<Candidature> aCandidatures)
  {
    boolean wasSet = false;
    candidatures = aCandidatures;
    wasSet = true;
    return wasSet;
  }

  public List<Candidate> getCandidates()
  {
    return candidates;
  }

  public List<ElectionForPosition> getPositions()
  {
    return positions;
  }

  public List<Candidature> getCandidatures()
  {
    candidatures=new ArrayList<Candidature>();
    for (Object o:candidatesList.getSelectedValues()) {
    	candidatures.add(new Candidature(-1, (Candidate)o, (ElectionForPosition)positionsComboBox.getSelectedItem()));
    }
    return candidatures;
  }

  public void delete()
  {}

}