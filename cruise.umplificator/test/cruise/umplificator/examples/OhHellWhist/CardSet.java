/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;

// line 10 "OhHellWhist.ump"
// line 92 "OhHellWhist.ump"
public class CardSet
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CardSet Associations
  private List<Card> cards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CardSet()
  {
    cards = new ArrayList<Card>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Card getCard(int index)
  {
    Card aCard = cards.get(index);
    return aCard;
  }

  /**
   * Could be a complete deck or a trick
   */
  public List<Card> getCards()
  {
    List<Card> newCards = Collections.unmodifiableList(cards);
    return newCards;
  }

  public int numberOfCards()
  {
    int number = cards.size();
    return number;
  }

  public boolean hasCards()
  {
    boolean has = cards.size() > 0;
    return has;
  }

  public int indexOfCard(Card aCard)
  {
    int index = cards.indexOf(aCard);
    return index;
  }

  public static int minimumNumberOfCards()
  {
    return 0;
  }

  public Card addCard(String aSuit, String aRank, boolean aIsJoker)
  {
    return new Card(aSuit, aRank, aIsJoker, this);
  }

  public boolean addCard(Card aCard)
  {
    boolean wasAdded = false;
    if (cards.contains(aCard)) { return false; }
    if (cards.contains(aCard)) { return false; }
    if (cards.contains(aCard)) { return false; }
    CardSet existingCardSet = aCard.getCardSet();
    boolean isNewCardSet = existingCardSet != null && !this.equals(existingCardSet);
    if (isNewCardSet)
    {
      aCard.setCardSet(this);
    }
    else
    {
      cards.add(aCard);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCard(Card aCard)
  {
    boolean wasRemoved = false;
    //Unable to remove aCard, as it must always have a cardSet
    if (!this.equals(aCard.getCardSet()))
    {
      cards.remove(aCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCardAt(Card aCard, int index)
  {  
    boolean wasAdded = false;
    if(addCard(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCardAt(Card aCard, int index)
  {
    boolean wasAdded = false;
    if(cards.contains(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCardAt(aCard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=cards.size(); i > 0; i--)
    {
      Card aCard = cards.get(i - 1);
      aCard.delete();
    }
  }

}