/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package paper.Double;
import java.util.*;

// line 15 "../../DoubleMutation_uModel_telephone.ump"
public class TelephoneNumber
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TelephoneNumber Attributes
  private String digits;

  //TelephoneNumber Associations
  private List<TelephoneNumber> voicemail;
  private PhoneCall call;
  private PhoneCall phoneCall;
  private TelephoneNumber number;
  private VoiceMailBox voiceMailBox;
  private List<Feature> features;
  private List<PhoneLine> phoneLines;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TelephoneNumber(String aDigits, PhoneCall aCall, VoiceMailBox aVoiceMailBox)
  {
    digits = aDigits;
    voicemail = new ArrayList<TelephoneNumber>();
    boolean didAddCall = setCall(aCall);
    if (!didAddCall)
    {
      throw new RuntimeException("Unable to create originator due to call. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddVoiceMailBox = setVoiceMailBox(aVoiceMailBox);
    if (!didAddVoiceMailBox)
    {
      throw new RuntimeException("Unable to create telephoneNumber due to voiceMailBox. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    features = new ArrayList<Feature>();
    phoneLines = new ArrayList<PhoneLine>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDigits(String aDigits)
  {
    boolean wasSet = false;
    digits = aDigits;
    wasSet = true;
    return wasSet;
  }

  public String getDigits()
  {
    return digits;
  }
  /* Code from template association_GetMany */
  public TelephoneNumber getVoicemail(int index)
  {
    TelephoneNumber aVoicemail = voicemail.get(index);
    return aVoicemail;
  }

  public List<TelephoneNumber> getVoicemail()
  {
    List<TelephoneNumber> newVoicemail = Collections.unmodifiableList(voicemail);
    return newVoicemail;
  }

  public int numberOfVoicemail()
  {
    int number = voicemail.size();
    return number;
  }

  public boolean hasVoicemail()
  {
    boolean has = voicemail.size() > 0;
    return has;
  }

  public int indexOfVoicemail(TelephoneNumber aVoicemail)
  {
    int index = voicemail.indexOf(aVoicemail);
    return index;
  }
  /* Code from template association_GetOne */
  public PhoneCall getCall()
  {
    return call;
  }
  /* Code from template association_GetOne */
  public PhoneCall getPhoneCall()
  {
    return phoneCall;
  }

  public boolean hasPhoneCall()
  {
    boolean has = phoneCall != null;
    return has;
  }
  /* Code from template association_GetOne */
  public TelephoneNumber getNumber()
  {
    return number;
  }

  public boolean hasNumber()
  {
    boolean has = number != null;
    return has;
  }
  /* Code from template association_GetOne */
  public VoiceMailBox getVoiceMailBox()
  {
    return voiceMailBox;
  }
  /* Code from template association_GetMany */
  public Feature getFeature(int index)
  {
    Feature aFeature = features.get(index);
    return aFeature;
  }

  public List<Feature> getFeatures()
  {
    List<Feature> newFeatures = Collections.unmodifiableList(features);
    return newFeatures;
  }

  public int numberOfFeatures()
  {
    int number = features.size();
    return number;
  }

  public boolean hasFeatures()
  {
    boolean has = features.size() > 0;
    return has;
  }

  public int indexOfFeature(Feature aFeature)
  {
    int index = features.indexOf(aFeature);
    return index;
  }
  /* Code from template association_GetMany */
  public PhoneLine getPhoneLine(int index)
  {
    PhoneLine aPhoneLine = phoneLines.get(index);
    return aPhoneLine;
  }

  public List<PhoneLine> getPhoneLines()
  {
    List<PhoneLine> newPhoneLines = Collections.unmodifiableList(phoneLines);
    return newPhoneLines;
  }

  public int numberOfPhoneLines()
  {
    int number = phoneLines.size();
    return number;
  }

  public boolean hasPhoneLines()
  {
    boolean has = phoneLines.size() > 0;
    return has;
  }

  public int indexOfPhoneLine(PhoneLine aPhoneLine)
  {
    int index = phoneLines.indexOf(aPhoneLine);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVoicemail()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addVoicemail(TelephoneNumber aVoicemail)
  {
    boolean wasAdded = false;
    TelephoneNumber existingNumber = aVoicemail.getNumber();
    if (existingNumber == null)
    {
      aVoicemail.setNumber(this);
    }
    else if (!this.equals(existingNumber))
    {
      existingNumber.removeVoicemail(aVoicemail);
      addVoicemail(aVoicemail);
    }
    else
    {
      voicemail.add(aVoicemail);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVoicemail(TelephoneNumber aVoicemail)
  {
    boolean wasRemoved = false;
    if (voicemail.contains(aVoicemail))
    {
      voicemail.remove(aVoicemail);
      aVoicemail.setNumber(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVoicemailAt(TelephoneNumber aVoicemail, int index)
  {  
    boolean wasAdded = false;
    if(addVoicemail(aVoicemail))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVoicemail()) { index = numberOfVoicemail() - 1; }
      voicemail.remove(aVoicemail);
      voicemail.add(index, aVoicemail);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoicemailAt(TelephoneNumber aVoicemail, int index)
  {
    boolean wasAdded = false;
    if(voicemail.contains(aVoicemail))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVoicemail()) { index = numberOfVoicemail() - 1; }
      voicemail.remove(aVoicemail);
      voicemail.add(index, aVoicemail);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoicemailAt(aVoicemail, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCall(PhoneCall aCall)
  {
    boolean wasSet = false;
    if (aCall == null)
    {
      return wasSet;
    }

    PhoneCall existingCall = call;
    call = aCall;
    if (existingCall != null && !existingCall.equals(aCall))
    {
      existingCall.removeOriginator(this);
    }
    call.addOriginator(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setPhoneCall(PhoneCall aPhoneCall)
  {
    boolean wasSet = false;
    PhoneCall existingPhoneCall = phoneCall;
    phoneCall = aPhoneCall;
    if (existingPhoneCall != null && !existingPhoneCall.equals(aPhoneCall))
    {
      existingPhoneCall.removeParty(this);
    }
    if (aPhoneCall != null)
    {
      aPhoneCall.addParty(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setNumber(TelephoneNumber aNumber)
  {
    boolean wasSet = false;
    TelephoneNumber existingNumber = number;
    number = aNumber;
    if (existingNumber != null && !existingNumber.equals(aNumber))
    {
      existingNumber.removeVoicemail(this);
    }
    if (aNumber != null)
    {
      aNumber.addVoicemail(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setVoiceMailBox(VoiceMailBox aVoiceMailBox)
  {
    boolean wasSet = false;
    if (aVoiceMailBox == null)
    {
      return wasSet;
    }

    VoiceMailBox existingVoiceMailBox = voiceMailBox;
    voiceMailBox = aVoiceMailBox;
    if (existingVoiceMailBox != null && !existingVoiceMailBox.equals(aVoiceMailBox))
    {
      existingVoiceMailBox.removeTelephoneNumber(this);
    }
    voiceMailBox.addTelephoneNumber(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfFeatures()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addFeature(Feature aFeature)
  {
    boolean wasAdded = false;
    features.add(aFeature);
    if (aFeature.indexOfTelephoneNumber(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aFeature.addTelephoneNumber(this);
      if (!wasAdded)
      {
        features.remove(aFeature);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeFeature(Feature aFeature)
  {
    boolean wasRemoved = false;
    if (!features.contains(aFeature))
    {
      return wasRemoved;
    }

    int oldIndex = features.indexOf(aFeature);
    features.remove(oldIndex);
    if (aFeature.indexOfTelephoneNumber(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aFeature.removeTelephoneNumber(this);
      if (!wasRemoved)
      {
        features.add(oldIndex,aFeature);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addFeatureAt(Feature aFeature, int index)
  {  
    boolean wasAdded = false;
    if(addFeature(aFeature))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFeatures()) { index = numberOfFeatures() - 1; }
      features.remove(aFeature);
      features.add(index, aFeature);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveFeatureAt(Feature aFeature, int index)
  {
    boolean wasAdded = false;
    if(features.contains(aFeature))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfFeatures()) { index = numberOfFeatures() - 1; }
      features.remove(aFeature);
      features.add(index, aFeature);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addFeatureAt(aFeature, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPhoneLines()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPhoneLine(PhoneLine aPhoneLine)
  {
    boolean wasAdded = false;
    phoneLines.add(aPhoneLine);
    if (aPhoneLine.indexOfTelephoneNumber(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPhoneLine.addTelephoneNumber(this);
      if (!wasAdded)
      {
        phoneLines.remove(aPhoneLine);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePhoneLine(PhoneLine aPhoneLine)
  {
    boolean wasRemoved = false;
    if (!phoneLines.contains(aPhoneLine))
    {
      return wasRemoved;
    }

    int oldIndex = phoneLines.indexOf(aPhoneLine);
    phoneLines.remove(oldIndex);
    if (aPhoneLine.indexOfTelephoneNumber(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPhoneLine.removeTelephoneNumber(this);
      if (!wasRemoved)
      {
        phoneLines.add(oldIndex,aPhoneLine);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPhoneLineAt(PhoneLine aPhoneLine, int index)
  {  
    boolean wasAdded = false;
    if(addPhoneLine(aPhoneLine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPhoneLines()) { index = numberOfPhoneLines() - 1; }
      phoneLines.remove(aPhoneLine);
      phoneLines.add(index, aPhoneLine);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePhoneLineAt(PhoneLine aPhoneLine, int index)
  {
    boolean wasAdded = false;
    if(phoneLines.contains(aPhoneLine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPhoneLines()) { index = numberOfPhoneLines() - 1; }
      phoneLines.remove(aPhoneLine);
      phoneLines.add(index, aPhoneLine);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPhoneLineAt(aPhoneLine, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !voicemail.isEmpty() )
    {
      voicemail.get(0).setNumber(null);
    }
    PhoneCall placeholderCall = call;
    this.call = null;
    if(placeholderCall != null)
    {
      placeholderCall.removeOriginator(this);
    }
    if (phoneCall != null)
    {
      PhoneCall placeholderPhoneCall = phoneCall;
      this.phoneCall = null;
      placeholderPhoneCall.removeParty(this);
    }
    if (number != null)
    {
      TelephoneNumber placeholderNumber = number;
      this.number = null;
      placeholderNumber.removeVoicemail(this);
    }
    VoiceMailBox placeholderVoiceMailBox = voiceMailBox;
    this.voiceMailBox = null;
    if(placeholderVoiceMailBox != null)
    {
      placeholderVoiceMailBox.removeTelephoneNumber(this);
    }
    ArrayList<Feature> copyOfFeatures = new ArrayList<Feature>(features);
    features.clear();
    for(Feature aFeature : copyOfFeatures)
    {
      aFeature.removeTelephoneNumber(this);
    }
    ArrayList<PhoneLine> copyOfPhoneLines = new ArrayList<PhoneLine>(phoneLines);
    phoneLines.clear();
    for(PhoneLine aPhoneLine : copyOfPhoneLines)
    {
      aPhoneLine.removeTelephoneNumber(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "digits" + ":" + getDigits()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "call = "+(getCall()!=null?Integer.toHexString(System.identityHashCode(getCall())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "phoneCall = "+(getPhoneCall()!=null?Integer.toHexString(System.identityHashCode(getPhoneCall())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "voiceMailBox = "+(getVoiceMailBox()!=null?Integer.toHexString(System.identityHashCode(getVoiceMailBox())):"null");
  }
}