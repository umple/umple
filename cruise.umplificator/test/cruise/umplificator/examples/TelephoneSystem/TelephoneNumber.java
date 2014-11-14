/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 16 "TelephoneSystem.ump"
// line 71 "TelephoneSystem.ump"
public class TelephoneNumber
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TelephoneNumber Attributes
  private String digits;

  //TelephoneNumber Associations
  private List<TelephoneNumber> voicemail;
  private List<PhoneCall> call;
  private List<PhoneCall> phoneCalls;
  private TelephoneNumber number;
  private VoiceMailBox voiceMailBox;
  private List<Feature> features;
  private List<PhoneLine> phoneLines;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TelephoneNumber(String aDigits, VoiceMailBox aVoiceMailBox)
  {
    digits = aDigits;
    voicemail = new ArrayList<TelephoneNumber>();
    call = new ArrayList<PhoneCall>();
    phoneCalls = new ArrayList<PhoneCall>();
    boolean didAddVoiceMailBox = setVoiceMailBox(aVoiceMailBox);
    if (!didAddVoiceMailBox)
    {
      throw new RuntimeException("Unable to create telephoneNumber due to voiceMailBox");
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

  public PhoneCall getCall(int index)
  {
    PhoneCall aCall = call.get(index);
    return aCall;
  }

  public List<PhoneCall> getCall()
  {
    List<PhoneCall> newCall = Collections.unmodifiableList(call);
    return newCall;
  }

  public int numberOfCall()
  {
    int number = call.size();
    return number;
  }

  public boolean hasCall()
  {
    boolean has = call.size() > 0;
    return has;
  }

  public int indexOfCall(PhoneCall aCall)
  {
    int index = call.indexOf(aCall);
    return index;
  }

  public PhoneCall getPhoneCall(int index)
  {
    PhoneCall aPhoneCall = phoneCalls.get(index);
    return aPhoneCall;
  }

  public List<PhoneCall> getPhoneCalls()
  {
    List<PhoneCall> newPhoneCalls = Collections.unmodifiableList(phoneCalls);
    return newPhoneCalls;
  }

  public int numberOfPhoneCalls()
  {
    int number = phoneCalls.size();
    return number;
  }

  public boolean hasPhoneCalls()
  {
    boolean has = phoneCalls.size() > 0;
    return has;
  }

  public int indexOfPhoneCall(PhoneCall aPhoneCall)
  {
    int index = phoneCalls.indexOf(aPhoneCall);
    return index;
  }

  public TelephoneNumber getNumber()
  {
    return number;
  }

  public boolean hasNumber()
  {
    boolean has = number != null;
    return has;
  }

  public VoiceMailBox getVoiceMailBox()
  {
    return voiceMailBox;
  }

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

  public static int minimumNumberOfVoicemail()
  {
    return 0;
  }

  public boolean addVoicemail(TelephoneNumber aVoicemail)
  {
    boolean wasAdded = false;
    if (voicemail.contains(aVoicemail)) { return false; }
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

  public static int minimumNumberOfCall()
  {
    return 0;
  }

  public PhoneCall addCall(String aIsOnHold, String aStartTime, String aDuration)
  {
    return new PhoneCall(aIsOnHold, aStartTime, aDuration, this);
  }

  public boolean addCall(PhoneCall aCall)
  {
    boolean wasAdded = false;
    if (call.contains(aCall)) { return false; }
    TelephoneNumber existingOriginator = aCall.getOriginator();
    boolean isNewOriginator = existingOriginator != null && !this.equals(existingOriginator);
    if (isNewOriginator)
    {
      aCall.setOriginator(this);
    }
    else
    {
      call.add(aCall);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCall(PhoneCall aCall)
  {
    boolean wasRemoved = false;
    //Unable to remove aCall, as it must always have a originator
    if (!this.equals(aCall.getOriginator()))
    {
      call.remove(aCall);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCallAt(PhoneCall aCall, int index)
  {  
    boolean wasAdded = false;
    if(addCall(aCall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCall()) { index = numberOfCall() - 1; }
      call.remove(aCall);
      call.add(index, aCall);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCallAt(PhoneCall aCall, int index)
  {
    boolean wasAdded = false;
    if(call.contains(aCall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCall()) { index = numberOfCall() - 1; }
      call.remove(aCall);
      call.add(index, aCall);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCallAt(aCall, index);
    }
    return wasAdded;
  }

  public static int minimumNumberOfPhoneCalls()
  {
    return 0;
  }

  public boolean addPhoneCall(PhoneCall aPhoneCall)
  {
    boolean wasAdded = false;
    if (phoneCalls.contains(aPhoneCall)) { return false; }
    phoneCalls.add(aPhoneCall);
    if (aPhoneCall.indexOfParty(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPhoneCall.addParty(this);
      if (!wasAdded)
      {
        phoneCalls.remove(aPhoneCall);
      }
    }
    return wasAdded;
  }

  public boolean removePhoneCall(PhoneCall aPhoneCall)
  {
    boolean wasRemoved = false;
    if (!phoneCalls.contains(aPhoneCall))
    {
      return wasRemoved;
    }

    int oldIndex = phoneCalls.indexOf(aPhoneCall);
    phoneCalls.remove(oldIndex);
    if (aPhoneCall.indexOfParty(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPhoneCall.removeParty(this);
      if (!wasRemoved)
      {
        phoneCalls.add(oldIndex,aPhoneCall);
      }
    }
    return wasRemoved;
  }

  public boolean addPhoneCallAt(PhoneCall aPhoneCall, int index)
  {  
    boolean wasAdded = false;
    if(addPhoneCall(aPhoneCall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPhoneCalls()) { index = numberOfPhoneCalls() - 1; }
      phoneCalls.remove(aPhoneCall);
      phoneCalls.add(index, aPhoneCall);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePhoneCallAt(PhoneCall aPhoneCall, int index)
  {
    boolean wasAdded = false;
    if(phoneCalls.contains(aPhoneCall))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPhoneCalls()) { index = numberOfPhoneCalls() - 1; }
      phoneCalls.remove(aPhoneCall);
      phoneCalls.add(index, aPhoneCall);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPhoneCallAt(aPhoneCall, index);
    }
    return wasAdded;
  }

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

  public static int minimumNumberOfFeatures()
  {
    return 0;
  }

  public boolean addFeature(Feature aFeature)
  {
    boolean wasAdded = false;
    if (features.contains(aFeature)) { return false; }
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

  public static int minimumNumberOfPhoneLines()
  {
    return 0;
  }

  public boolean addPhoneLine(PhoneLine aPhoneLine)
  {
    boolean wasAdded = false;
    if (phoneLines.contains(aPhoneLine)) { return false; }
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
    for(int i=call.size(); i > 0; i--)
    {
      PhoneCall aCall = call.get(i - 1);
      aCall.delete();
    }
    ArrayList<PhoneCall> copyOfPhoneCalls = new ArrayList<PhoneCall>(phoneCalls);
    phoneCalls.clear();
    for(PhoneCall aPhoneCall : copyOfPhoneCalls)
    {
      aPhoneCall.removeParty(this);
    }
    if (number != null)
    {
      TelephoneNumber placeholderNumber = number;
      this.number = null;
      placeholderNumber.removeVoicemail(this);
    }
    VoiceMailBox placeholderVoiceMailBox = voiceMailBox;
    this.voiceMailBox = null;
    placeholderVoiceMailBox.removeTelephoneNumber(this);
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
	  String outputString = "";
    return super.toString() + "["+
            "digits" + ":" + getDigits()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "voiceMailBox = "+(getVoiceMailBox()!=null?Integer.toHexString(System.identityHashCode(getVoiceMailBox())):"null")
     + outputString;
  }
}