/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.11.1.3376 modeling language!*/

package cruise.umple.compiler;

public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private int lineNumber;
  private int characterOffset;
  private int offset;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetLineNumber;
  private boolean canSetCharacterOffset;
  private boolean canSetOffset;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(int aLineNumber, int aCharacterOffset, int aOffset)
  {
    lineNumber = aLineNumber;
    characterOffset = aCharacterOffset;
    offset = aOffset;
    cachedHashCode = -1;
    canSetLineNumber = true;
    canSetCharacterOffset = true;
    canSetOffset = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLineNumber(int aLineNumber)
  {
    boolean wasSet = false;
    if (!canSetLineNumber) { return false; }
    lineNumber = aLineNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setCharacterOffset(int aCharacterOffset)
  {
    boolean wasSet = false;
    if (!canSetCharacterOffset) { return false; }
    characterOffset = aCharacterOffset;
    wasSet = true;
    return wasSet;
  }

  public boolean setOffset(int aOffset)
  {
    boolean wasSet = false;
    if (!canSetOffset) { return false; }
    offset = aOffset;
    wasSet = true;
    return wasSet;
  }

  public int getLineNumber()
  {
    return lineNumber;
  }

  public int getCharacterOffset()
  {
    return characterOffset;
  }

  public int getOffset()
  {
    return offset;
  }

  public boolean equals(Object obj)
  {
    if (obj == null) { return false; }
    if (!getClass().equals(obj.getClass())) { return false; }

    Position compareTo = (Position)obj;
  
    if (lineNumber != compareTo.lineNumber)
    {
      return false;
    }

    if (characterOffset != compareTo.characterOffset)
    {
      return false;
    }

    if (offset != compareTo.offset)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    if (cachedHashCode != -1)
    {
      return cachedHashCode;
    }
    cachedHashCode = 17;
    cachedHashCode = cachedHashCode * 23 + lineNumber;

    cachedHashCode = cachedHashCode * 23 + characterOffset;

    cachedHashCode = cachedHashCode * 23 + offset;

    canSetLineNumber = false;
    canSetCharacterOffset = false;
    canSetOffset = false;
    return cachedHashCode;
  }

  public void delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public Position copy()
  {
    return new Position(lineNumber,characterOffset,offset);
  }
  
  public Position add(Position more)
  {
    return new Position(getLineNumber() + more.getLineNumber() - 1, getCharacterOffset() + more.getCharacterOffset(), getOffset() + more.getOffset());
  }

  public String toString()
  {
    return cruise.umple.util.StringFormatter.format("[{0},{1}]", getLineNumber(), getCharacterOffset());
  }
}