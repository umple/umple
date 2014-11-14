/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 59 "PoliceSystem.ump"
// line 81 "PoliceSystem.ump"
public class Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String name;
  private String phone;
  private String sex;
  private String address;
  private String age;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aName, String aPhone, String aSex, String aAddress, String aAge)
  {
    name = aName;
    phone = aPhone;
    sex = aSex;
    address = aAddress;
    age = aAge;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public boolean setSex(String aSex)
  {
    boolean wasSet = false;
    sex = aSex;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setAge(String aAge)
  {
    boolean wasSet = false;
    age = aAge;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getPhone()
  {
    return phone;
  }

  public String getSex()
  {
    return sex;
  }

  public String getAddress()
  {
    return address;
  }

  public String getAge()
  {
    return age;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "phone" + ":" + getPhone()+ "," +
            "sex" + ":" + getSex()+ "," +
            "address" + ":" + getAddress()+ "," +
            "age" + ":" + getAge()+ "]"
     + outputString;
  }
}