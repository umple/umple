/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.8.1.2163 modeling language!*/

package afghan_rainfall;

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
    id = aId;
    return true;
  }

  public boolean setRainfall_centimetres(int aRainfall_centimetres)
  {
    rainfall_centimetres = aRainfall_centimetres;
    return true;
  }

  public boolean setHumidity(int aHumidity)
  {
    humidity = aHumidity;
    return true;
  }

  public boolean setTemperature(int aTemperature)
  {
    temperature = aTemperature;
    return true;
  }

  public boolean setOther_observation_details(String aOther_observation_details)
  {
    other_observation_details = aOther_observation_details;
    return true;
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
    villageSurvey = newVillageSurvey;
    return true;
  }

  public void delete()
  {
    villageSurvey = null;
  }

}