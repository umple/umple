/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package service;
import java.util.List;
import java.util.ArrayList;
import shared.domain.Election;
import shared.domain.Position;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import shared.Credentials;

public class PositionService
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static PositionService theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PositionService Attributes
  private Position selectedPosition;
  private Position newPosition;
  private Position positionById;
  private Election selectedElection;
  private List<Position> positions;
  private Connection theConnection;
  private boolean positionOpenned;
  private boolean positionAdded;
  private Position positionToSearch;
  private boolean positionFound;

  //PositionService State Machines
  enum PositionServiceCycle { Idle, CreatingPosition, FindingPosition, FindingPositionById, LoadingAllPositions }
  private PositionServiceCycle PositionServiceCycle;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private PositionService()
  {
    positionOpenned = false;
    positionAdded = false;
    positionFound = false;
    setPositionServiceCycle(PositionServiceCycle.Idle);
  }

  public static PositionService getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new PositionService();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setSelectedPosition(Position aSelectedPosition)
  {
    boolean wasSet = false;
    selectedPosition = aSelectedPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean setNewPosition(Position aNewPosition)
  {
    boolean wasSet = false;
    newPosition = aNewPosition;
    wasSet = true;
    createPosition();
    return wasSet;
  }

  public boolean setPositionById(Position aPositionById)
  {
    boolean wasSet = false;
    positionById = aPositionById;
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

  public boolean setPositions(List<Position> aPositions)
  {
    boolean wasSet = false;
    positions = aPositions;
    wasSet = true;
    return wasSet;
  }

  public boolean setTheConnection(Connection aTheConnection)
  {
    boolean wasSet = false;
    theConnection = aTheConnection;
    wasSet = true;
    return wasSet;
  }

  public boolean setPositionOpenned(boolean aPositionOpenned)
  {
    boolean wasSet = false;
    positionOpenned = aPositionOpenned;
    wasSet = true;
    return wasSet;
  }

  public boolean setPositionAdded(boolean aPositionAdded)
  {
    boolean wasSet = false;
    positionAdded = aPositionAdded;
    wasSet = true;
    return wasSet;
  }

  public boolean setPositionToSearch(Position aPositionToSearch)
  {
    boolean wasSet = false;
    positionToSearch = aPositionToSearch;
    wasSet = true;
    findPosition();
    return wasSet;
  }

  public boolean setPositionFound(boolean aPositionFound)
  {
    boolean wasSet = false;
    positionFound = aPositionFound;
    wasSet = true;
    return wasSet;
  }

  public Position getSelectedPosition()
  {
    return selectedPosition;
  }

  public Position getNewPosition()
  {
    return newPosition;
  }

  public Position getPositionById()
  {
    findPositionById();
    return positionById;
  }

  public Election getSelectedElection()
  {
    return selectedElection;
  }

  public List<Position> getPositions()
  {
    getAllPositions();
    return positions;
  }

  public Connection getTheConnection()
  {
    return theConnection;
  }

  public boolean getPositionOpenned()
  {
    return positionOpenned;
  }

  public boolean getPositionAdded()
  {
    return positionAdded;
  }

  public Position getPositionToSearch()
  {
    return positionToSearch;
  }

  public boolean getPositionFound()
  {
    return positionFound;
  }

  public boolean isPositionOpenned()
  {
    return positionOpenned;
  }

  public boolean isPositionAdded()
  {
    return positionAdded;
  }

  public boolean isPositionFound()
  {
    return positionFound;
  }

  public String getPositionServiceCycleFullName()
  {
    String answer = PositionServiceCycle.toString();
    return answer;
  }

  public PositionServiceCycle getPositionServiceCycle()
  {
    return PositionServiceCycle;
  }

  public boolean createPosition()
  {
    boolean wasEventProcessed = false;
    
    PositionServiceCycle aPositionServiceCycle = PositionServiceCycle;
    switch (aPositionServiceCycle)
    {
      case Idle:
        setPositionServiceCycle(PositionServiceCycle.CreatingPosition);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean findPosition()
  {
    boolean wasEventProcessed = false;
    
    PositionServiceCycle aPositionServiceCycle = PositionServiceCycle;
    switch (aPositionServiceCycle)
    {
      case Idle:
        setPositionServiceCycle(PositionServiceCycle.FindingPosition);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean getAllPositions()
  {
    boolean wasEventProcessed = false;
    
    PositionServiceCycle aPositionServiceCycle = PositionServiceCycle;
    switch (aPositionServiceCycle)
    {
      case Idle:
        setPositionServiceCycle(PositionServiceCycle.LoadingAllPositions);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  public boolean findPositionById()
  {
    boolean wasEventProcessed = false;
    
    PositionServiceCycle aPositionServiceCycle = PositionServiceCycle;
    switch (aPositionServiceCycle)
    {
      case Idle:
        setPositionServiceCycle(PositionServiceCycle.FindingPositionById);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition633__()
  {
    boolean wasEventProcessed = false;
    
    PositionServiceCycle aPositionServiceCycle = PositionServiceCycle;
    switch (aPositionServiceCycle)
    {
      case CreatingPosition:
        setPositionServiceCycle(PositionServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition634__()
  {
    boolean wasEventProcessed = false;
    
    PositionServiceCycle aPositionServiceCycle = PositionServiceCycle;
    switch (aPositionServiceCycle)
    {
      case FindingPosition:
        setPositionServiceCycle(PositionServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition635__()
  {
    boolean wasEventProcessed = false;
    
    PositionServiceCycle aPositionServiceCycle = PositionServiceCycle;
    switch (aPositionServiceCycle)
    {
      case FindingPositionById:
        setPositionServiceCycle(PositionServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private boolean __autotransition636__()
  {
    boolean wasEventProcessed = false;
    
    PositionServiceCycle aPositionServiceCycle = PositionServiceCycle;
    switch (aPositionServiceCycle)
    {
      case LoadingAllPositions:
        setPositionServiceCycle(PositionServiceCycle.Idle);
        wasEventProcessed = true;
        break;
    }

    return wasEventProcessed;
  }

  private void setPositionServiceCycle(PositionServiceCycle aPositionServiceCycle)
  {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      theConnection = DriverManager.getConnection("jdbc:mysql://"+Credentials.db_hostname+"/elections", Credentials.db_username, Credentials.db_password);
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
    PositionServiceCycle = aPositionServiceCycle;

    // entry actions and do activities
    switch(PositionServiceCycle)
    {
      case CreatingPosition:
        addPosition();
        __autotransition633__();
        break;
      case FindingPosition:
        searchForPosition();
        __autotransition634__();
        break;
      case FindingPositionById:
        searchForPositionById();
        __autotransition635__();
        break;
      case LoadingAllPositions:
        loadAllPositions();
        __autotransition636__();
        break;
    }
  }

  public void delete()
  {}


  public void loadAllPositions(){
      positions=new ArrayList<Position>();
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM position");
      while (rs.next()) {
        String name = rs.getString("name");
        String description = rs.getString("description");
        int id=Integer.parseInt(rs.getString("id_position"));
        Position position=new Position(id, name, description);
        positions.add(position);
      }
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }


  public void addPosition(){
      try {
      Statement stmt = theConnection.createStatement();
      stmt.executeUpdate("insert into elections.position (name, description) values ('"+newPosition.getName()+"', '"+newPosition.getDescription()+"')");
      positionAdded=true;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      positionAdded=false;
    }
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private void searchForPosition() {
    positionFound=true;
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM elections.position where name='"+positionToSearch.getName()+"'");
      if (!rs.next())
        positionFound=false;
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
      positionFound=false;
    }
  }

  private void searchForPositionById() {
    positionFound=true;
    try {
      Statement stmt = theConnection.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM elections.position where id_position='"+positionById.getIdPosition()+"'");
      if (rs.next()) {
        String name = rs.getString("name");
        String description = rs.getString("description");
        positionById.setName(name);
        positionById.setDescription(description);
      }
    } catch(Exception e) {
      System.err.println("Exception: " + e.getMessage());
    }
  }
}