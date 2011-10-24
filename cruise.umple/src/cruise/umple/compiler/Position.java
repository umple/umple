/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.14.0.957 modeling language!*/

package cruise.umple.compiler;

public class Position
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Position Attributes
  private String filename;
  private int lineNumber;
  private int characterOffset;
  private int offset;

  //Helper Variables
  private int cachedHashCode;
  private boolean canSetFilename;
  private boolean canSetLineNumber;
  private boolean canSetCharacterOffset;
  private boolean canSetOffset;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Position(String aFilename, int aLineNumber, int aCharacterOffset, int aOffset)
  {
    filename = aFilename;
    lineNumber = aLineNumber;
    characterOffset = aCharacterOffset;
    offset = aOffset;
    cachedHashCode = -1;
    canSetFilename = true;
    canSetLineNumber = true;
    canSetCharacterOffset = true;
    canSetOffset = true;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setFilename(String aFilename)
  {
    boolean wasSet = false;
    if (!canSetFilename) { return false; }
    filename = aFilename;
    wasSet = true;
    return wasSet;
  }

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

  public String getFilename()
  {
    return filename;
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
  
    if (filename == null && compareTo.filename != null)
    {
      return false;
    }
    else if (filename != null && !filename.equals(compareTo.filename))
    {
      return false;
    }

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
    if (filename != null)
    {
      cachedHashCode = cachedHashCode * 23 + filename.hashCode();
    }
    else
    {
      cachedHashCode = cachedHashCode * 23;
    }

    cachedHashCode = cachedHashCode * 23 + lineNumber;

    cachedHashCode = cachedHashCode * 23 + characterOffset;

    cachedHashCode = cachedHashCode * 23 + offset;

    canSetFilename = false;
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
  
   public Position(int aLineNumber,int aCharacterOffset,int aOffset)  {
this(null, aLineNumber, aCharacterOffset, aOffset);
  }
public Position copy()
  {
    return new Position(filename,lineNumber,characterOffset,offset);
  }
  
  public Position add(Position more)
  {
  	String tfile = filename == null ? more.getFilename() : filename;
    return new Position(filename, getLineNumber() + more.getLineNumber() - 1, getCharacterOffset() + more.getCharacterOffset(), getOffset() + more.getOffset());
  }

  public String toString()
  {
    return cruise.umple.util.StringFormatter.format("[{0},{1}]", getLineNumber(), getCharacterOffset());
  }
}