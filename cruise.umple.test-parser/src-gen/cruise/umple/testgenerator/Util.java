/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.25.0-963d2bd modeling language!*/

package cruise.umple.testgenerator;
import java.util.Random;
import cruise.umple.*;

// line 3 "../../../Utility.ump"
public class Util
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Util Attributes
  private Random random;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Util()
  {
    random = new Random ();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRandom(Random aRandom)
  {
    boolean wasSet = false;
    random = aRandom;
    wasSet = true;
    return wasSet;
  }

  public Random getRandom()
  {
    return random;
  }

  public void delete()
  {}


  /**
   * ------------------------
   * Random String Generator
   * ------------------------
   */
  // line 17 "../../../Utility.ump"
   public String randomGenerator(Random random, String characters, int length){
    char[] text = new char[length];
    for (int i = 0; i < length; i++)
    {
        text[i] = characters.charAt(random.nextInt(characters.length()));
    }
    return new String(text);
  }
   
 
   


  /**
   * ------------------------
   * Random Int Generator
   * ------------------------
   */
  // line 30 "../../../Utility.ump"
   public int randomGenerator(int range){
    int text = random.nextInt(range);
	  	
	return text;
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "random" + "=" + (getRandom() != null ? !getRandom().equals(this)  ? getRandom().toString().replaceAll("  ","    ") : "this" : "null");
  }
}