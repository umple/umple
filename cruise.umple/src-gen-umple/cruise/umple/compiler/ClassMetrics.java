/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.text.*;

/**
 * @umplesource SimpleMetrics_Class.ump 39
 */
// line 39 "../../../../src/SimpleMetrics_Class.ump"
public class ClassMetrics extends SimpleMetricsGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassMetrics Attributes
  private StringBuilder code;
  private UmpleModel model;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassMetrics()
  {
    super();
    code = null;
    model = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(StringBuilder aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public StringBuilder getCode()
  {
    return code;
  }

  public UmpleModel getModel()
  {
    return model;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={47},file={"SimpleMetrics_Class.ump"},javaline={72},length={139})
  public void calculate(){
    CountClass cc = new CountClass();	
      int smCount = 0;
      int classCount = 0;
	  boolean FirstTime= true;

      code.append( "\n\n\n");
      code.append(Format.repeat("*",150) + "\n" );
      code.append(Format.repeat(" ",20)+" C L A S S   M E A S U R E S "+"\n");
      code.append(Format.repeat("*",150)+"\n");
   
	  // CALCULATE SOME CLASS METRICS
      // create a map in order to have several metric objects about the same class
      Set<String> allUmpFiles = new HashSet<String>();
      String fn = null;
      // Iterate through all the classes in the system, gathering statistics
      for (UmpleClass uClass : model.getUmpleClasses()) {   	      
        // Loop through all the places where parts of this class were
        // found in the code, gathering all the files
        for (Position p : uClass.getPositions()) {
          fn=p.getFilename();
          allUmpFiles.add(fn); // allUmpFiles is a set, so duplicates are removed
         }
      }
      
	  List<String>title = new ArrayList<String>();
      title.add(" Class Name                   ");
      title.add(" #State Machines ");
      title.add(" #Associations ");
      title.add(" #Subclasses ");
	  title.add(" #Deepest Subclasses ");
      title.add(" #Attributes ");
      title.add(" #Methods ");
      title.add(" #Method Parameters ");
      code.append(Format.repeat("-",150)+"\n");
      for (int i=0;i<title.size();i++){ code.append("|"+title.get(i));  }
      code.append(" |\n");
      code.append(Format.repeat("-",150)+"\n");
	  
	  DecimalFormat df = new DecimalFormat( "###,##0.0###");
	  classCount=0;
      smCount=0;
	  // calculate class metrics for each Umple Class
	  for ( UmpleClass uClass : model.getUmpleClasses() ) {
        cc.countDataClass( uClass ); 
  
        classCount++;         
        code.append( "| " +uClass.getName()+ Format.repeat(" ", title.get(0).length()-(""+uClass.getName()).length()-1 ) );
        code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+cc.getCountStateMachines()).length()-1 )+ cc.getCountStateMachines() );
        smCount += cc.getCountStateMachines();
        code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+cc.getCountAssociations()).length()-1 )+ cc.getCountAssociations() );
        code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+cc.getCountSubclasses()).length()-1 )+ cc.getCountSubclasses() );
		code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+cc.getCountDeepestSubclass()).length()-1 )+ cc.getCountDeepestSubclass() );
        code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+cc.getCountAttributes()).length()-1 )+ cc.getCountAttributes() );
        code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+cc.getCountMethods()).length()-1 )+ cc.getCountMethods() );
        code.append( "| " +Format.repeat(" ", title.get(7).length()-(""+cc.getCountParameters()).length()-1 )+ cc.getCountParameters() );
        code.append( " |\n" ); // closing the record. One record one line.
        code.append(Format.repeat("-",150)+"\n");
		
		if (FirstTime){
		  cc.setMinMax();
		  FirstTime= false;
		}
		cc.incTotal();
		cc.calcMinMax();
		cc.reset();
     } 
      // TOTAL OF CLASSES, STATE MACHINES, SOURCE FILES 
      code.append( "| TOTAL" + Format.repeat(" ", title.get(0).length()-("| TOTAL").length()+1 ) );
      code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+cc.getCountTotalStateMachines()).length()-1 )+ cc.getCountTotalStateMachines() );
      code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+cc.getCountTotalAssociations()).length()-1 )+ cc.getCountTotalAssociations() );
      code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+cc.getCountTotalSubclasses()).length()-1 )+ cc.getCountTotalSubclasses() );
	  code.append( "| " +Format.repeat(" ", title.get(4).length()-(" -X-X-").length()-1 )+ " -X-X-" );
      code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+cc.getCountTotalAttributes()).length()-1 )+ cc.getCountTotalAttributes() );
      code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+cc.getCountTotalMethods()).length()-1 )+ cc.getCountTotalMethods() );
      code.append( "| " +Format.repeat(" ", title.get(7).length()-(""+cc.getCountTotalParameters()).length()-1 )+ cc.getCountTotalParameters() );
      code.append( " |\n" ); // closing the record. One record one line.
      code.append(Format.repeat("-",150)+"\n");
	  
	  
	  // Print Averages
	  String res;
      code.append( "| AVERAGE" + Format.repeat(" ", title.get(0).length()-("| AVERAGE").length()+1 ) );
	  res =  df.format((double)cc.getCountTotalStateMachines()/classCount);
      code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+res).length()-1 )+ res );
	  res =  df.format((double)cc.getCountTotalAssociations()/classCount);
      code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+res).length()-1 )+ res );
	  res =  df.format((double)cc.getCountTotalSubclasses()/classCount);
      code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+res).length()-1 )+ res );
	  res =  " -X-X-";
	  code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+res).length()-1 )+ res );
	  res =  df.format((double)cc.getCountTotalAttributes()/classCount);
      code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+res).length()-1 )+ res );
	  res =  df.format((double)cc.getCountTotalMethods()/classCount);
      code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+res).length()-1 )+ res );
	  res =  df.format((double)cc.getCountTotalParameters()/classCount);
      code.append( "| " +Format.repeat(" ", title.get(7).length()-(""+res).length()-1 )+ res );
      code.append( " |\n" ); // closing the record. One record one line.
      code.append(Format.repeat("-",150)+"\n");	  
	  
	  
	  // Print MAXs
	  code.append( "| MAX" + Format.repeat(" ", title.get(0).length()-("| MAX").length()+1 ) );
      code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+cc.getCountStateMachinesMax()).length()-1 )+ cc.getCountStateMachinesMax() );
      code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+cc.getCountAssociationsMax()).length()-1 )+ cc.getCountAssociationsMax() );
      code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+cc.getCountSubclassesMax()).length()-1 )+ cc.getCountSubclassesMax() );
	  code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+cc.getCountDeepestSubclassMax()).length()-1 )+ cc.getCountDeepestSubclassMax() );
      code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+cc.getCountAttributesMax()).length()-1 )+ cc.getCountAttributesMax() );
      code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+cc.getCountMethodsMax()).length()-1 )+ cc.getCountMethodsMax() );
      code.append( "| " +Format.repeat(" ", title.get(7).length()-(""+cc.getCountParametersMax()).length()-1 )+ cc.getCountParametersMax() );
      code.append( " |\n" ); // closing the record. One record one line.
      code.append(Format.repeat("-",150)+"\n");	  
	  
	  // Print MINs
	  code.append( "| MIN" + Format.repeat(" ", title.get(0).length()-("| MIN").length()+1 ) );
      code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+cc.getCountStateMachinesMin()).length()-1 )+ cc.getCountStateMachinesMin() );
      code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+cc.getCountAssociationsMin()).length()-1 )+ cc.getCountAssociationsMin() );
      code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+cc.getCountSubclassesMin()).length()-1 )+ cc.getCountSubclassesMin() );
	  code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+cc.getCountDeepestSubclassMin()).length()-1 )+ cc.getCountDeepestSubclassMin() );
      code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+cc.getCountAttributesMin()).length()-1 )+ cc.getCountAttributesMin() );
      code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+cc.getCountMethodsMin()).length()-1 )+ cc.getCountMethodsMin() );
      code.append( "| " +Format.repeat(" ", title.get(7).length()-(""+cc.getCountParametersMin()).length()-1 )+ cc.getCountParametersMin() );
      code.append( " |\n" ); // closing the record. One record one line.
      code.append(Format.repeat("-",150)+"\n");	
	  
	  // Print Legend
	  code.append("Legend of Class Metrics:\n");
	  code.append("   #State Machines - Total of SM per class.\n");
	  code.append("   #Associations - Total of associaions per class.\n");
	  code.append("   #Subclasses - Total of subclasses conected directly per class.\n");
	  code.append("   #Deepth Subclasses - Amount of classes up to deepest subclasse.\n");
	  code.append("   #Attributes - Total of attributes per class, disregarding attribute modifiers.\n");
	  code.append("   #Methods - Total of methods per class, disregarding class modifiers. \n");
	  code.append("   #Method Parameters - Total of parameters in the class. \n");
	  
	  
	  super.setCode(code);
	  return;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "code" + "=" + (getCode() != null ? !getCode().equals(this)  ? getCode().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}