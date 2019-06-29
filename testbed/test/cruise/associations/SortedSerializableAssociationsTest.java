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
    Assert.assertEquals(result,"deserialized");

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

    Assert.assertEquals(c2.getSortedSerializableRegistration(0).getSortedSerializableStudent().getName(),c22.getSortedSerializableRegistration(0).getSortedSerializableStudent().getName());
    Assert.assertEquals(c2.getSortedSerializableRegistration(1).getSortedSerializableStudent().getName(),c22.getSortedSerializableRegistration(1).getSortedSerializableStudent().getName());
    } 
    
    catch(Exception ex) 
    { 
      result = ex.getMessage();
    } 
    Assert.assertEquals(result,"added");
  }
  
}