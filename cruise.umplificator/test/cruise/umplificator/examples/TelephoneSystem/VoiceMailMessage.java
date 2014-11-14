/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/



// line 24 "TelephoneSystem.ump"
// line 66 "TelephoneSystem.ump"
public class VoiceMailMessage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VoiceMailMessage Attributes
  private String digitizedSound;

  //VoiceMailMessage Associations
  private VoiceMailBox voiceMailBox;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VoiceMailMessage(String aDigitizedSound, VoiceMailBox aVoiceMailBox)
  {
    digitizedSound = aDigitizedSound;
    boolean didAddVoiceMailBox = setVoiceMailBox(aVoiceMailBox);
    if (!didAddVoiceMailBox)
    {
      throw new RuntimeException("Unable to create voiceMailMessage due to voiceMailBox");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDigitizedSound(String aDigitizedSound)
  {
    boolean wasSet = false;
    digitizedSound = aDigitizedSound;
    wasSet = true;
    return wasSet;
  }

  public String getDigitizedSound()
  {
    return digitizedSound;
  }

  public VoiceMailBox getVoiceMailBox()
  {
    return voiceMailBox;
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
      existingVoiceMailBox.removeVoiceMailMessage(this);
    }
    voiceMailBox.addVoiceMailMessage(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    VoiceMailBox placeholderVoiceMailBox = voiceMailBox;
    this.voiceMailBox = null;
    placeholderVoiceMailBox.removeVoiceMailMessage(this);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "digitizedSound" + ":" + getDigitizedSound()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "voiceMailBox = "+(getVoiceMailBox()!=null?Integer.toHexString(System.identityHashCode(getVoiceMailBox())):"null")
     + outputString;
  }
}