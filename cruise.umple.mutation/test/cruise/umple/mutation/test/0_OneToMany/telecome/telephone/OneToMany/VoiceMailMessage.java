/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.OneToMany;

// line 23 "../../../OneToManyMutation_uModel.ump"
public class VoiceMailMessage
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VoiceMailMessage Attributes
  private int digitizedSound;

  //VoiceMailMessage Associations
  private VoiceMailBox voiceMailBox;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VoiceMailMessage(int aDigitizedSound)
  {
    digitizedSound = aDigitizedSound;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDigitizedSound(int aDigitizedSound)
  {
    boolean wasSet = false;
    digitizedSound = aDigitizedSound;
    wasSet = true;
    return wasSet;
  }

  public int getDigitizedSound()
  {
    return digitizedSound;
  }
  /* Code from template association_GetOne */
  public VoiceMailBox getVoiceMailBox()
  {
    return voiceMailBox;
  }

  public boolean hasVoiceMailBox()
  {
    boolean has = voiceMailBox != null;
    return has;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setVoiceMailBox(VoiceMailBox aVoiceMailBox)
  {
    boolean wasSet = false;
    VoiceMailBox existingVoiceMailBox = voiceMailBox;
    voiceMailBox = aVoiceMailBox;
    if (existingVoiceMailBox != null && !existingVoiceMailBox.equals(aVoiceMailBox))
    {
      existingVoiceMailBox.removeVoiceMailMessage(this);
    }
    if (aVoiceMailBox != null)
    {
      aVoiceMailBox.addVoiceMailMessage(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (voiceMailBox != null)
    {
      VoiceMailBox placeholderVoiceMailBox = voiceMailBox;
      this.voiceMailBox = null;
      placeholderVoiceMailBox.removeVoiceMailMessage(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "digitizedSound" + ":" + getDigitizedSound()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "voiceMailBox = "+(getVoiceMailBox()!=null?Integer.toHexString(System.identityHashCode(getVoiceMailBox())):"null");
  }
}