/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.sql.Date;

/**
 * A comment can just be applied to a ChangeRequest
 */
// line 106 "Decisions.ump"
// line 169 "Decisions.ump"
public class Comment extends Annotation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Comment(String aText, Date aDateMade)
  {
    super(aText, aDateMade);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}