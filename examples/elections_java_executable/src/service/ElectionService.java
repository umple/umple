/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Election;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ElectionService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static ElectionService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private ElectionService()
  {}

  public static ElectionService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new ElectionService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  public List<Election> getAllElections(Connection theConnection){
      List<Election> elections=new ArrayList<Election>();
		
		try {
			Statement stmt = theConnection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM election");
			while (rs.next()) {
				String name = rs.getString("name");
				String description = rs.getString("description");
				int id=Integer.parseInt(rs.getString("idElection"));
				Election election=new Election(id, name, description);
				elections.add(election);
			}
		} catch(Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
		
		return elections;
  }

}