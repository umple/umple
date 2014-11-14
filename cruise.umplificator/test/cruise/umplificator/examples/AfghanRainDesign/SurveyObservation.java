/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



/**
 * Positioning
 */
// line 73 "AfghanRainDesign.ump"
// line 135 "AfghanRainDesign.ump"
public class SurveyObservation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //SurveyObservation Attributes
  private int id;
  private int rainfall_centimetres;
  private int humidity;
  private int temperature;
  private String other_observation_details;

  //SurveyObservation Associations
  private VillageSurvey villageSurvey;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SurveyObservation(int aId, int aRainfall_centimetres, int aHumidity, int aTemperature, String aOther_observation_details)
  {
    id = aId;
    rainfall_centimetres = aRainfall_centimetres;
    humidity = aHumidity;
    temperature = aTemperature;
    other_observation_details = aOther_observation_details;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setRainfall_centimetres(int aRainfall_centimetres)
  {
    boolean wasSet = false;
    rainfall_centimetres = aRainfall_centimetres;
    wasSet = true;
    return wasSet;
  }

  public boolean setHumidity(int aHumidity)
  {
    boolean wasSet = false;
    humidity = aHumidity;
    wasSet = true;
    return wasSet;
  }

  public boolean setTemperature(int aTemperature)
  {
    boolean wasSet = false;
    temperature = aTemperature;
    wasSet = true;
    return wasSet;
  }

  public boolean setOther_observation_details(String aOther_observation_details)
  {
    boolean wasSet = false;
    other_observation_details = aOther_observation_details;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public int getRainfall_centimetres()
  {
    return rainfall_centimetres;
  }

  public int getHumidity()
  {
    return humidity;
  }

  public int getTemperature()
  {
    return temperature;
  }

  public String getOther_observation_details()
  {
    return other_observation_details;
  }

  public VillageSurvey getVillageSurvey()
  {
    return villageSurvey;
  }

  public boolean hasVillageSurvey()
  {
    boolean has = villageSurvey != null;
    return has;
  }

  public boolean setVillageSurvey(VillageSurvey aNewVillageSurvey)
  {
    boolean wasSet = false;
    villageSurvey = aNewVillageSurvey;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    villageSurvey = null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "rainfall_centimetres" + ":" + getRainfall_centimetres()+ "," +
            "humidity" + ":" + getHumidity()+ "," +
            "temperature" + ":" + getTemperature()+ "," +
            "other_observation_details" + ":" + getOther_observation_details()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "villageSurvey = "+(getVillageSurvey()!=null?Integer.toHexString(System.identityHashCode(getVillageSurvey())):"null")
     + outputString;
  }
}