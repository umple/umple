/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package telecome.telephone.direction;
import java.util.*;

// line 19 "../../../directionMutation_uModel.ump"
public class VoiceMailBox
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //VoiceMailBox Associations
  private List<VoiceMailMessage> voiceMailMessages;
  private List<TelephoneNumber> telephoneNumbers;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public VoiceMailBox()
  {
    voiceMailMessages = new ArrayList<VoiceMailMessage>();
    telephoneNumbers = new ArrayList<TelephoneNumber>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public VoiceMailMessage getVoiceMailMessage(int index)
  {
    VoiceMailMessage aVoiceMailMessage = voiceMailMessages.get(index);
    return aVoiceMailMessage;
  }

  public List<VoiceMailMessage> getVoiceMailMessages()
  {
    List<VoiceMailMessage> newVoiceMailMessages = Collections.unmodifiableList(voiceMailMessages);
    return newVoiceMailMessages;
  }

  public int numberOfVoiceMailMessages()
  {
    int number = voiceMailMessages.size();
    return number;
  }

  public boolean hasVoiceMailMessages()
  {
    boolean has = voiceMailMessages.size() > 0;
    return has;
  }

  public int indexOfVoiceMailMessage(VoiceMailMessage aVoiceMailMessage)
  {
    int index = voiceMailMessages.indexOf(aVoiceMailMessage);
    return index;
  }
  /* Code from template association_GetMany */
  public TelephoneNumber getTelephoneNumber(int index)
  {
    TelephoneNumber aTelephoneNumber = telephoneNumbers.get(index);
    return aTelephoneNumber;
  }

  public List<TelephoneNumber> getTelephoneNumbers()
  {
    List<TelephoneNumber> newTelephoneNumbers = Collections.unmodifiableList(telephoneNumbers);
    return newTelephoneNumbers;
  }

  public int numberOfTelephoneNumbers()
  {
    int number = telephoneNumbers.size();
    return number;
  }

  public boolean hasTelephoneNumbers()
  {
    boolean has = telephoneNumbers.size() > 0;
    return has;
  }

  public int indexOfTelephoneNumber(TelephoneNumber aTelephoneNumber)
  {
    int index = telephoneNumbers.indexOf(aTelephoneNumber);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfVoiceMailMessages()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addVoiceMailMessage(VoiceMailMessage aVoiceMailMessage)
  {
    boolean wasAdded = false;
    VoiceMailBox existingVoiceMailBox = aVoiceMailMessage.getVoiceMailBox();
    if (existingVoiceMailBox == null)
    {
      aVoiceMailMessage.setVoiceMailBox(this);
    }
    else if (!this.equals(existingVoiceMailBox))
    {
      existingVoiceMailBox.removeVoiceMailMessage(aVoiceMailMessage);
      addVoiceMailMessage(aVoiceMailMessage);
    }
    else
    {
      voiceMailMessages.add(aVoiceMailMessage);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeVoiceMailMessage(VoiceMailMessage aVoiceMailMessage)
  {
    boolean wasRemoved = false;
    if (voiceMailMessages.contains(aVoiceMailMessage))
    {
      voiceMailMessages.remove(aVoiceMailMessage);
      aVoiceMailMessage.setVoiceMailBox(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addVoiceMailMessageAt(VoiceMailMessage aVoiceMailMessage, int index)
  {  
    boolean wasAdded = false;
    if(addVoiceMailMessage(aVoiceMailMessage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVoiceMailMessages()) { index = numberOfVoiceMailMessages() - 1; }
      voiceMailMessages.remove(aVoiceMailMessage);
      voiceMailMessages.add(index, aVoiceMailMessage);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveVoiceMailMessageAt(VoiceMailMessage aVoiceMailMessage, int index)
  {
    boolean wasAdded = false;
    if(voiceMailMessages.contains(aVoiceMailMessage))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfVoiceMailMessages()) { index = numberOfVoiceMailMessages() - 1; }
      voiceMailMessages.remove(aVoiceMailMessage);
      voiceMailMessages.add(index, aVoiceMailMessage);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addVoiceMailMessageAt(aVoiceMailMessage, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTelephoneNumbers()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addTelephoneNumber(TelephoneNumber aTelephoneNumber)
  {
    boolean wasAdded = false;
    telephoneNumbers.add(aTelephoneNumber);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTelephoneNumber(TelephoneNumber aTelephoneNumber)
  {
    boolean wasRemoved = false;
    if (telephoneNumbers.contains(aTelephoneNumber))
    {
      telephoneNumbers.remove(aTelephoneNumber);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTelephoneNumberAt(TelephoneNumber aTelephoneNumber, int index)
  {  
    boolean wasAdded = false;
    if(addTelephoneNumber(aTelephoneNumber))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTelephoneNumbers()) { index = numberOfTelephoneNumbers() - 1; }
      telephoneNumbers.remove(aTelephoneNumber);
      telephoneNumbers.add(index, aTelephoneNumber);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTelephoneNumberAt(TelephoneNumber aTelephoneNumber, int index)
  {
    boolean wasAdded = false;
    if(telephoneNumbers.contains(aTelephoneNumber))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTelephoneNumbers()) { index = numberOfTelephoneNumbers() - 1; }
      telephoneNumbers.remove(aTelephoneNumber);
      telephoneNumbers.add(index, aTelephoneNumber);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTelephoneNumberAt(aTelephoneNumber, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !voiceMailMessages.isEmpty() )
    {
      voiceMailMessages.get(0).setVoiceMailBox(null);
    }
    telephoneNumbers.clear();
  }

}