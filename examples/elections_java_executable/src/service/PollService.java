/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Election;
import shared.domain.Poll;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PollService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static PollService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private PollService()
  {}

  public static PollService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new PollService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  public List<Poll> getElectionPolls(Connection theConnection, Election election){
      List<Poll> polls=new ArrayList<Poll>();
		
		try {
			Statement stmt = theConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM poll where election_id_election="+election.getIdElection());
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int id=Integer.parseInt(rs.getString("id_poll"));
				Poll poll=new Poll(id, name, description, election);
				polls.add(poll);
			}
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		
		return polls;
  }


  public boolean openPoll(Connection theConnection, Poll poll){
      try {
			Statement stmt = theConnection.createStatement();
			stmt.executeUpdate("update elections.poll set status='open' where id_poll="+poll.getIdPoll());
			return true;
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
			return false;
		}
  }

}