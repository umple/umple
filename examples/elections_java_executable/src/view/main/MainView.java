/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package view.main;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import shared.listeners.GenericMouseListener;
import shared.listeners.GenericWindowListener;
import view.ViewUtils;

public class MainView extends JFrame
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static MainView theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MainView Attributes
  private JButton goButton;
  private JComboBox tasksComboBox;
  private JLabel taskLabel;
  private String selectedTask;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private MainView()
  {
    super();
    selectedTask = null;
    getContentPane().setLayout(null);
  
    setTitle("Main Menu");
  
    taskLabel=new JLabel("Select a task:");
    taskLabel.setBounds(10, 10, 200, 20);
    add(taskLabel);

    String[] selectionValues={"Open Poll", "Add Election", "Add Poll"
                            , "Add Position", "Assign Positions to Election", "Quit"};
    
    tasksComboBox=new JComboBox(selectionValues);
    tasksComboBox.setBounds(10, 35, 200, 20);
    add(tasksComboBox);
    
    goButton=new JButton("go");
    goButton.setBounds(75, 60, 75, 20);
    goButton.addMouseListener(GenericMouseListener.MainViewMouseListener);
    add(goButton);
    
    pack();
    setSize(225, 150);
    
    ViewUtils.getInstance().setToBeCenteredFrame(this);
    addWindowListener(GenericWindowListener.MainViewWindowListener);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static MainView getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new MainView();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSelectedTask(String aSelectedTask)
  {
    boolean wasSet = false;
    selectedTask = aSelectedTask;
    wasSet = true;
    return wasSet;
  }

  public String getSelectedTask()
  {
    selectedTask=(String)tasksComboBox.getSelectedItem();
    return selectedTask;
  }

  public void delete()
  {}

}