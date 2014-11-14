/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Time;

// line 8 "AirlineExample.ump"
// line 101 "AirlineExample.ump"
public class Airline
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Airline Associations
  private List<RegularFlight> regularFlights;
  private List<Person> persons;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Airline()
  {
    regularFlights = new ArrayList<RegularFlight>();
    persons = new ArrayList<Person>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public RegularFlight getRegularFlight(int index)
  {
    RegularFlight aRegularFlight = regularFlights.get(index);
    return aRegularFlight;
  }

  public List<RegularFlight> getRegularFlights()
  {
    List<RegularFlight> newRegularFlights = Collections.unmodifiableList(regularFlights);
    return newRegularFlights;
  }

  public int numberOfRegularFlights()
  {
    int number = regularFlights.size();
    return number;
  }

  public boolean hasRegularFlights()
  {
    boolean has = regularFlights.size() > 0;
    return has;
  }

  public int indexOfRegularFlight(RegularFlight aRegularFlight)
  {
    int index = regularFlights.indexOf(aRegularFlight);
    return index;
  }

  public Person getPerson(int index)
  {
    Person aPerson = persons.get(index);
    return aPerson;
  }

  public List<Person> getPersons()
  {
    List<Person> newPersons = Collections.unmodifiableList(persons);
    return newPersons;
  }

  public int numberOfPersons()
  {
    int number = persons.size();
    return number;
  }

  public boolean hasPersons()
  {
    boolean has = persons.size() > 0;
    return has;
  }

  public int indexOfPerson(Person aPerson)
  {
    int index = persons.indexOf(aPerson);
    return index;
  }

  public static int minimumNumberOfRegularFlights()
  {
    return 0;
  }

  public RegularFlight addRegularFlight(Time aTime, int aFlightNumber)
  {
    return new RegularFlight(aTime, aFlightNumber, this);
  }

  public boolean addRegularFlight(RegularFlight aRegularFlight)
  {
    boolean wasAdded = false;
    if (regularFlights.contains(aRegularFlight)) { return false; }
    Airline existingAirline = aRegularFlight.getAirline();
    boolean isNewAirline = existingAirline != null && !this.equals(existingAirline);
    if (isNewAirline)
    {
      aRegularFlight.setAirline(this);
    }
    else
    {
      regularFlights.add(aRegularFlight);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeRegularFlight(RegularFlight aRegularFlight)
  {
    boolean wasRemoved = false;
    //Unable to remove aRegularFlight, as it must always have a airline
    if (!this.equals(aRegularFlight.getAirline()))
    {
      regularFlights.remove(aRegularFlight);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addRegularFlightAt(RegularFlight aRegularFlight, int index)
  {  
    boolean wasAdded = false;
    if(addRegularFlight(aRegularFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRegularFlights()) { index = numberOfRegularFlights() - 1; }
      regularFlights.remove(aRegularFlight);
      regularFlights.add(index, aRegularFlight);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRegularFlightAt(RegularFlight aRegularFlight, int index)
  {
    boolean wasAdded = false;
    if(regularFlights.contains(aRegularFlight))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRegularFlights()) { index = numberOfRegularFlights() - 1; }
      regularFlights.remove(aRegularFlight);
      regularFlights.add(index, aRegularFlight);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRegularFlightAt(aRegularFlight, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPersons()
  {
    return 0;
  }

  public Person addPerson(String aName, int aIdNumber)
  {
    return new Person(aName, aIdNumber, this);
  }

  public boolean addPerson(Person aPerson)
  {
    boolean wasAdded = false;
    if (persons.contains(aPerson)) { return false; }
    Airline existingAirline = aPerson.getAirline();
    boolean isNewAirline = existingAirline != null && !this.equals(existingAirline);
    if (isNewAirline)
    {
      aPerson.setAirline(this);
    }
    else
    {
      persons.add(aPerson);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePerson(Person aPerson)
  {
    boolean wasRemoved = false;
    //Unable to remove aPerson, as it must always have a airline
    if (!this.equals(aPerson.getAirline()))
    {
      persons.remove(aPerson);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addPersonAt(Person aPerson, int index)
  {  
    boolean wasAdded = false;
    if(addPerson(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePersonAt(Person aPerson, int index)
  {
    boolean wasAdded = false;
    if(persons.contains(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPersonAt(aPerson, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=regularFlights.size(); i > 0; i--)
    {
      RegularFlight aRegularFlight = regularFlights.get(i - 1);
      aRegularFlight.delete();
    }
    for(int i=persons.size(); i > 0; i--)
    {
      Person aPerson = persons.get(i - 1);
      aPerson.delete();
    }
  }

}