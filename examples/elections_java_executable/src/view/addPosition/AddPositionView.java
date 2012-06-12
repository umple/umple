/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.addPosition;
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
import view.main.*;

public class AddPositionView extends JFrame
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AddPositionView Attributes
  private JLabel positionNameLabel;
  private JLabel positionDescriptionLabel;
  private JTextField positionNameTextField;
  private JTextArea positionDescriptionTextArea;
  private JButton addPositionButton;
  private String positionName;
  private String positionDescription;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AddPositionView()
  {
    super();
    positionName = null;
    positionDescription = null;
    getContentPane().setLayout(null);
	
		positionNameLabel=new JLabel("Position Name:");
		positionNameLabel.setBounds(10, 10, 200, 20);
		add(positionNameLabel);
		
		positionNameTextField=new JTextField();
		positionNameTextField.setBounds(10, 30, 200, 20);
		add(positionNameTextField);
		
		positionDescriptionLabel=new JLabel("Add a description:");
		positionDescriptionLabel.setBounds(10, 50, 200, 20);
		add(positionDescriptionLabel);
		
		positionDescriptionTextArea=new JTextArea();
		positionDescriptionTextArea.setBounds(10, 70, 200, 60);
		add(positionDescriptionTextArea);
		
		addPositionButton=new JButton("add");
		addPositionButton.setBounds(75, 180, 75, 20);
		addPositionButton.addMouseListener(GenericMouseListener.AddPositionViewMouseListener);
		add(addPositionButton);
		
		pack();
		setSize(250, 250);
		
		ViewUtils.getInstance().setToBeCenteredFrame(this);
		addWindowListener(GenericWindowListener.AddPositionViewWindowListener);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPositionName(String aPositionName)
  {
    boolean wasSet = false;
    positionName = aPositionName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPositionDescription(String aPositionDescription)
  {
    boolean wasSet = false;
    positionDescription = aPositionDescription;
    wasSet = true;
    return wasSet;
  }

  public String getPositionName()
  {
    positionName=positionNameTextField.getText();
    return positionName;
  }

  public String getPositionDescription()
  {
    positionDescription=positionDescriptionTextArea.getText();
    return positionDescription;
  }

  public void delete()
  {}

}