package cruise.associations;

import org.junit.*;

import cruise.associations.Flight;
import cruise.associations.Passenger;
import cruise.associations.Booking;


public class AssociationClassTest 
{
  @Test (expected=RuntimeException.class)
  public void cannotCreateMultipleLinkedInstances()
  {
    Flight f1 = new Flight(100);
    Passenger p1 = new Passenger("Tom");
    Passenger p2 = new Passenger("Jan");

    // Book f1 for p1 - first booking in system
    new Booking(f1,p1);
    
    // Book f1 for p2 - should be fine
    new Booking (f1,p2);
    
    // Book again f1 for p2 - should not be possible
    new Booking(f1, p2);
  }
}