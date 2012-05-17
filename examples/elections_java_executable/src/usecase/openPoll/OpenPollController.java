/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package usecase.openPoll;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Election;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import service.ElectionService;

public class OpenPollController
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static OpenPollController theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private OpenPollController()
  {}

  public static OpenPollController getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new OpenPollController();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  public void openPoll(Connection theConnection){
      List<Election> elections=ElectionService.getInstance().getAllElections(theConnection);
		String[] electionNames=new String[elections.size()];
		int i=0;
		for (Election election:elections)
			electionNames[i++]=election.getName();
		Object selectedElections = JOptionPane.showInputDialog(null, "Select an Election", "List of Elections", JOptionPane.QUESTION_MESSAGE, null, electionNames, electionNames[0]);
  }

}