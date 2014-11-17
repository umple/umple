/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.util.*;
import java.sql.Date;

/**
 * Requirements for the above
 * 
 * Many organization have decisions to make that are made by various committees in a hierarchical manner. Committees exist at various levels. For example, there might be a departmental committee that makes a decision, and passes the decision up to a division council for further approval, and that then passes the result to the board of directors for final approval.
 * 
 * Some committees might consist of a single individual, e.g. a department head or director.
 * 
 * The system you will model needs to be able to handle any kind of organization; the committees or individuals will have different names in each organization. In a university, for example, there might be many levels: Department curriculum committee, department council, faculty curriculum committee, faculty council, undergraduate council and Senate.
 * 
 * Decisions are of various types, with each type having an importance levels. Based on its importance, a decision only needs to be approved up to a certain level in the hierarchy. For example, the decision about which courses to offer in a given year might only need to be approved by the department curriculum committee, but a new program of studies might need to be approved by the Senate (and every level from department curriculum committee up to Senate). In a company, an expense less than $1000 might need approval by a department head. Expenses of over $1000000 might need approval by the Board of Directors.
 * 
 * Each decision has a 'short summary' that describes the decision. Examples might be: 'Purchase Photocopier model AB309 from Xerox for $2570' or 'Create course SEG2104 with title: "Model driven development", and description: 'Model driven development using Umple', and prerequisites: "SEG2105"'
 * 
 * Short summaries can have multiple versions (as changes are made).
 * 
 * Each decision has associated with it a set of documents. Each document has an id, a filename, a type (MS Word, Excel, Pdf etc.) and a set of versions.
 * 
 * When a committee approves a decision, it does so by approving the short summary, and possibly modifying the set of documents by adding new versions of existing documents or adding new documents.
 * 
 * A committee might turn down a decision based on one version of a document and request a list of change requests that are simple blocks of text. Users or other committees may add comments to the change requests and may create new versions of documents and an updated version of the short summary. A decision may therefore go up the hierarchy, be rejected, come back down for revisions, go back up again, back down again, and eventually be approved at the highest needed level, or rejected or dropped at any level.
 * 
 * It is also possible for a committee to split a decision into separate decisions, or merge two decisions together, or approve one decision conditional on approval of one or more other decisions.
 * 
 * Committees have members. Each member has a start and end date on the committee. Each document has a set of authors. Each version has a date and a set of authors.
 */
// line 100 "Decisions.ump"
// line 154 "Decisions.ump"
public class ChangeRequest extends Annotation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ChangeRequest Associations
  private List<Comment> comments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ChangeRequest(String aText, Date aDateMade)
  {
    super(aText, aDateMade);
    comments = new ArrayList<Comment>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Comment getComment(int index)
  {
    Comment aComment = comments.get(index);
    return aComment;
  }

  public List<Comment> getComments()
  {
    List<Comment> newComments = Collections.unmodifiableList(comments);
    return newComments;
  }

  public int numberOfComments()
  {
    int number = comments.size();
    return number;
  }

  public boolean hasComments()
  {
    boolean has = comments.size() > 0;
    return has;
  }

  public int indexOfComment(Comment aComment)
  {
    int index = comments.indexOf(aComment);
    return index;
  }

  public static int minimumNumberOfComments()
  {
    return 0;
  }

  public boolean addComment(Comment aComment)
  {
    boolean wasAdded = false;
    if (comments.contains(aComment)) { return false; }
    comments.add(aComment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeComment(Comment aComment)
  {
    boolean wasRemoved = false;
    if (comments.contains(aComment))
    {
      comments.remove(aComment);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addCommentAt(Comment aComment, int index)
  {  
    boolean wasAdded = false;
    if(addComment(aComment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfComments()) { index = numberOfComments() - 1; }
      comments.remove(aComment);
      comments.add(index, aComment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCommentAt(Comment aComment, int index)
  {
    boolean wasAdded = false;
    if(comments.contains(aComment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfComments()) { index = numberOfComments() - 1; }
      comments.remove(aComment);
      comments.add(index, aComment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCommentAt(aComment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    comments.clear();
    super.delete();
  }

}