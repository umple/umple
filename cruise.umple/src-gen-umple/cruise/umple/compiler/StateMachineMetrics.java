/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.text.*;
import java.util.*;

/**
 * @umplesource SimpleMetrics_SM.ump 44
 */
// line 44 "../../../../src/SimpleMetrics_SM.ump"
public class StateMachineMetrics extends SimpleMetricsGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //StateMachineMetrics Attributes
  private StringBuilder code;
  private UmpleModel model;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateMachineMetrics()
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

  @umplesourcefile(line={53},file={"SimpleMetrics_SM.ump"},javaline={73},length={177})
  public void calculate(){
    // Output basic file header
      code.append( "\n\n\n");
      code.append(Format.repeat("*",126)+"\n");
      code.append(Format.repeat(" ",20)+"S T A T E   M A C H I N E  ( S M )   M E A S U R E S"+"\n");
      code.append(Format.repeat("*",126)+"\n");
	  
	  // Preparing Head (columns) of output file
      List<String>title = new ArrayList<String>();
      title.add(" Class Name                   ");
      title.add(" #State Machines ");
      title.add(" #States ");
	  title.add(" #Transitions ");
	  title.add(" #Different Transitions ");
      title.add(" #Events ");
	  title.add(" #Guards ");
      title.add(" #Actions ");
      title.add(" #Nested SM ");
	  title.add(" #Cycles ");
	  title.add(" #Self Cycles ");
      code.append(Format.repeat("-",170)+"\n");
      for (int i=0;i<title.size();i++){ code.append("|"+title.get(i));  }
      code.append(" |\n");
      code.append(Format.repeat("-",170)+"\n");

	  DecimalFormat df = new DecimalFormat( "###,##0.0###");

      CountSM countPerClass = new CountSM(); // Class that contains values per class of counting about State Machine Metrics
	  CountSM countTotals = new CountSM();   // Class that contains Max, Min and totals values of counting about State Machine Metrics
	  boolean FirstTime = true; // used to allow setting first counted values to Min and Max attributes
      for (UmpleClass uClass : model.getUmpleClasses()) {  
	    
		if (uClass!=null){

		  code.append( "| " +uClass.getName()+ Format.repeat(" ", title.get(0).length()-(""+uClass.getName()).length()-1 ) );

		  // CALCULATING STATE MACHINE METRICS
		  countPerClass.calculate(uClass);
		  
		  // writing and formating string to record in output file
		  code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+countPerClass.getTotalStateMachinesPerClass()).length()-1 )+ countPerClass.getTotalStateMachinesPerClass() );
          code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+countPerClass.getTotalStatesPerClass()).length()-1 )+ countPerClass.getTotalStatesPerClass() );
          code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+countPerClass.getTotalTransitionsPerClass()).length()-1 )+ countPerClass.getTotalTransitionsPerClass() );
		  code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+countPerClass.getTotalDifferentTransitionsPerClass()).length()-1 )+ countPerClass.getTotalDifferentTransitionsPerClass() );
          code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+countPerClass.getTotalEventsPerClass()).length()-1 )+ countPerClass.getTotalEventsPerClass() );
		  code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+countPerClass.getTotalGuardsPerClass()).length()-1 )+ countPerClass.getTotalGuardsPerClass() );
		  code.append( "| " +Format.repeat(" ", title.get(7).length()-(""+countPerClass.getTotalActionsPerClass()).length()-1 )+ countPerClass.getTotalActionsPerClass() );
          code.append( "| " +Format.repeat(" ", title.get(8).length()-(""+countPerClass.getTotalNestedStateMachinePerClass()).length()-1 )+ countPerClass.getTotalNestedStateMachinePerClass() );
		  code.append( "| " +Format.repeat(" ", title.get(9).length()-(""+countPerClass.getTotalCyclesPerClass()).length()-1 )+ countPerClass.getTotalCyclesPerClass() );
		  code.append( "| " +Format.repeat(" ", title.get(10).length()-(""+countPerClass.getTotalSelfCyclesPerClass()).length()-1 ) + countPerClass.getTotalSelfCyclesPerClass() );
          code.append( " |\n" ); // closing the record. One record one line.
          code.append(Format.repeat("-",170)+"\n");
		  
		  // Sum all values per class in Totals
		  countTotals.incTotal(countPerClass); 
		  
		  // if it is first loop, the first calculated values must be set like Max and Min values
		  if (FirstTime){
		    countTotals.setMinMax(countPerClass);
			FirstTime= false;
		  };
		  countTotals.calcMinMax(countPerClass); 
          countPerClass = new CountSM(); // Class that keep values of counting about State Machine Metrics
        }
      }

	  // printing totals
	  code.append( "| TOTALS " + Format.repeat(" ", title.get(0).length()-("| TOTALS ").length()+1 ) );
	  code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+countTotals.getTotalStateMachines()).length()-1 )+ countTotals.getTotalStateMachines() );
      code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+countTotals.getTotalStates()).length()-1 )+ countTotals.getTotalStates() );
      code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+countTotals.getTotalTransitions()).length()-1 )+ countTotals.getTotalTransitions() );
	  code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+countTotals.getTotalDifferentTransitions()).length()-1 )+ countTotals.getTotalDifferentTransitions() );
      code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+countTotals.getTotalEvents()).length()-1 )+ countTotals.getTotalEvents() );
	  code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+countTotals.getTotalGuards()).length()-1 )+ countTotals.getTotalGuards() );
      code.append( "| " +Format.repeat(" ", title.get(7).length()-(""+countTotals.getTotalActions()).length()-1 )+ countTotals.getTotalActions() );
      code.append( "| " +Format.repeat(" ", title.get(8).length()-(""+countTotals.getTotalNestedStateMachine()).length()-1 )+ countTotals.getTotalNestedStateMachine() );
	  code.append( "| " +Format.repeat(" ", title.get(9).length()-(""+countTotals.getTotalCycles()).length()-1 )+ countTotals.getTotalCycles() );
	  code.append( "| " +Format.repeat(" ", title.get(10).length()-(""+countTotals.getTotalSelfCycles()).length()-1 ) + countTotals.getTotalSelfCycles() );
      code.append( " |\n" ); // closing the record. One record one line.
      code.append(Format.repeat("-",170)+"\n");
	  
	  // printing averages
	  int tc = countTotals.getTotalClass();
	  String res;
	  code.append( "| AVERAGES " + Format.repeat(" ", title.get(0).length()-("| AVERAGES ").length()+1 ) );
	  res =  df.format((double)countTotals.getTotalStateMachines()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(1).length()-res.length()-1 )+ res );
      res =  df.format((double)countTotals.getTotalStates()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(2).length()-res.length()-1 )+ res );
      res =  df.format((double)countTotals.getTotalTransitions()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(3).length()-res.length()-1 )+ res );
	  res =  df.format((double)countTotals.getTotalDifferentTransitions()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(4).length()-res.length()-1 )+ res );
      res =  df.format((double)countTotals.getTotalEvents()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(5).length()-res.length()-1 )+ res );
	  res =  df.format((double)countTotals.getTotalGuards()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(6).length()-res.length()-1 )+ res );
      res =  df.format((double)countTotals.getTotalActions()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(7).length()-res.length()-1 )+ res );
      res =  df.format((double)countTotals.getTotalNestedStateMachine()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(8).length()-res.length()-1 )+ res );
	  res =  df.format((double)countTotals.getTotalCycles()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(9).length()-res.length()-1 )+ res );
	  res =  df.format((double)countTotals.getTotalSelfCycles()/tc);
	  code.append( "| " +Format.repeat(" ", title.get(10).length()-res.length()-1 )+ res );
	  code.append( " |\n" ); // closing the record. One record one line.
	  code.append(Format.repeat("-",170)+"\n");

	  
	  // printing MAX values
	  code.append( "| MAX VALUES " + Format.repeat(" ", title.get(0).length()-( "| MAX VALUES ").length()+1 ) );
	  res =  "" + countTotals.getTotalStateMachinesPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(1).length()-res.length()-1 )+ res );
      res =  "" + countTotals.getTotalStatesPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(2).length()-res.length()-1 )+ res );
      res =  "" + countTotals.getTotalTransitionsPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(3).length()-res.length()-1 )+ res );
	  res =  "" + countTotals.getTotalDifferentTransitionsPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(4).length()-res.length()-1 )+ res );
      res =  "" + countTotals.getTotalEventsPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(5).length()-res.length()-1 )+ res );
	  res =  "" + countTotals.getTotalGuardsPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(6).length()-res.length()-1 )+ res );
      res =  "" + countTotals.getTotalActionsPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(7).length()-res.length()-1 )+ res );
      res = "" + countTotals.getTotalNestedStateMachinePerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(8).length()-res.length()-1 )+ res );
	  res =  "" + countTotals.getTotalCyclesPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(9).length()-res.length()-1 )+ res );
	  res =  "" + countTotals.getTotalSelfCyclesPerClassMax();
	  code.append( "| " +Format.repeat(" ", title.get(10).length()-res.length()-1 )+ res );
	  code.append( " |\n" ); // closing the record. One record one line.
	  code.append(Format.repeat("-",170)+"\n");
	  
      // printing MIN values
	  code.append(  "| MIN VALUES " + Format.repeat(" ", title.get(0).length()-( "| MIN VALUES ").length()+1 ) );
	  res =  "" + countTotals.getTotalStateMachinesPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(1).length()-res.length()-1 )+ res );
      res =  "" + countTotals.getTotalStatesPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(2).length()-res.length()-1 )+ res );
      res =  "" + countTotals.getTotalTransitionsPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(3).length()-res.length()-1 )+ res );
	  res =  "" + countTotals.getTotalDifferentTransitionsPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(4).length()-res.length()-1 )+ res );
      res =  "" + countTotals.getTotalEventsPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(5).length()-res.length()-1 )+ res );
	  res =  "" + countTotals.getTotalGuardsPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(6).length()-res.length()-1 )+ res );
      res =  "" + countTotals.getTotalActionsPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(7).length()-res.length()-1 )+ res );
      res = "" + countTotals.getTotalNestedStateMachinePerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(8).length()-res.length()-1 )+ res );
	  res =  "" + countTotals.getTotalCyclesPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(9).length()-res.length()-1 )+ res );
	  res =  "" + countTotals.getTotalSelfCyclesPerClassMin();
	  code.append( "| " +Format.repeat(" ", title.get(10).length()-res.length()-1 )+ res );
	  code.append( " |\n" ); // closing the record. One record one line.
	  code.append(Format.repeat("-",170)+"\n");	  
	  
      
	  code.append("\n\n");
	  
	  code.append("Legend of State Machine Metrics:\n");
	  code.append("   #State Machines - Total of SM per class.\n");
	  code.append("   #States - Total of States per class.\n");
	  code.append("   #Transitions - Total of Transitions per class: All transitions are counted. Transitions with same name are counted the same number of times they appear.\n");
	  code.append("   #Different Transitions - Total of Different per SM: Transitions with the same name are counted once\n");
	  code.append("   #Events - Total of Events per class without repetition. \n");
	  code.append("   #Guards - Total of Guards per class without repetition. \n");
	  code.append("   #Actions - Total of Actions per SM. \n");
	  code.append("   #Nested SM - Total of Nested SM: Total of states that is other state machine.\n");
	  code.append("   #States with Cycles - Total of Cycles: Total of Cycles (self cycles + cycles).\n");
	  code.append("   #Self Cycles - Total of Self Cycles: Total of self Cycles.\n");
    
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