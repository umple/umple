/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package afghan_rainfall;

/**
 * Positioning
 */
// line 69 "../AfghanRainDesign.ump"
// line 131 "../AfghanRainDesign.ump"
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

  public boolean setVillageSurvey(VillageSurvey newVillageSurvey)
  {
    boolean wasSet = false;
    villageSurvey = newVillageSurvey;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    villageSurvey = null;
  }

}