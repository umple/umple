package cruise.associations;

import org.junit.*;
import java.io.*;
import java.nio.file.*;

import cruise.associations.SortedSerializableAcademy;
import cruise.associations.SortedSerializableStudent;
import cruise.associations.SortedSerializableRegistration;
import cruise.associations.SortedSerializableCourse;

public class SortedSerializableAssociationsTest
{

  @Test
  public void SortedAssociationSerialization()
  {
    String result = null;
    String filename = "SortedSerializableAssociationsFile.ser"; 

    SortedSerializableAcademy ac = new SortedSerializableAcademy(); 
    SortedSerializableStudent j = ac.addRegistrant(12,"Jim");
    SortedSerializableStudent a = ac.addRegistrant(4,"Ali");
    SortedSerializableCourse c = ac.addSortedSerializableCourse("CS191");
    j.addSortedSerializableRegistration(c);
    a.addSortedSerializableRegistration(c);    

    //serialization
    try
    { 
      FileOutputStream file = new FileOutputStream(filename); 
      ObjectOutputStream out = new ObjectOutputStream(file); 
      out.writeObject(ac);       
      out.close(); 
      file.close();       
      result = "serialized"; 
    } 
    
    catch(Exception ex) 
    { 
      result = ex.getMessage();
    } 

    //verifying serialization
  	Assert.assertEquals(result,"serialized");

    SortedSerializableAcademy ac2 = null; 

    // Deserialization 
    try
    { 
      FileInputStream file = new FileInputStream(filename); 
      ObjectInputStream in = new ObjectInputStream(file);       
      ac2 = (SortedSerializableAcademy)in.readObject();       
      in.close(); 
      file.close();
      // Tear down SortedSerializableAssociationsFile.ser
	  Files.deleteIfExists(Paths.get("SortedSerializableAssociationsFile.ser"));
      result = "deserialized";
    } 
    
    catch(Exception ex) 
    { 
      result = ex.getMessage();
    } 

    //verifying deserialization
    Assert.assertEquals(result,"deserialized");

    //verifying object after deserialization
    Assert.assertEquals(ac.getRegistrant(0).getName(),ac2.getRegistrant(0).getName());
    Assert.assertEquals("Ali",ac2.getRegistrant(0).getName());

    // Adding new elements and comparing 
    try
    { 
	SortedSerializableStudent m = ac2.addRegistrant(8,"Mary");
	SortedSerializableStudent f = ac2.addRegistrant(3,"Francois");
	SortedSerializableCourse c2 = ac2.addSortedSerializableCourse("AN234"); 
	m.addSortedSerializableRegistration(c2);
	f.addSortedSerializableRegistration(c2);

	SortedSerializableStudent m2 = ac.addRegistrant(8,"Mary");
    SortedSerializableStudent f2 = ac.addRegistrant(3,"Francois");
    SortedSerializableCourse c22 = ac.addSortedSerializableCourse("AN234"); 
    m2.addSortedSerializableRegistration(c22);
    f2.addSortedSerializableRegistration(c22);

    result = "added";
    } 
    
    catch(Exception ex) 
    { 
      result = ex.getMessage();
    }

    //verifying ability to add new elements after deserialization 
    Assert.assertEquals(result,"added");

    //verifying students sort in academy after deserialization (sorted by id)
    Assert.assertEquals(ac.getRegistrant(0).getName(),ac2.getRegistrant(0).getName());
    Assert.assertEquals("Francois",ac2.getRegistrant(0).getName());

    //verifying courses sort in academy after deserialization (sorted by code)
    Assert.assertEquals(ac.getSortedSerializableCourse(0).getCode(),ac2.getSortedSerializableCourse(0).getCode());
    Assert.assertEquals("AN234",ac2.getSortedSerializableCourse(0).getCode());

    //verifying students sort in course after deserialization (sorted by name)
    Assert.assertEquals(ac.getSortedSerializableCourse(1).getSortedSerializableRegistration(1).getName(),ac2.getSortedSerializableCourse(1).getSortedSerializableRegistration(1).getName());
    Assert.assertEquals("Mary",ac2.getSortedSerializableCourse(0).getSortedSerializableRegistration(1).getName());

  }
  
}