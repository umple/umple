/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * end of class ClassMetrics
 * 
 * 
 * CLASS USED TO COUNT MEASURE STATE MACHINES
 * 
 * 
 * @umplesource Generator_CodeSimpleMetrics.ump 445
 */
// line 445 "../../../../src/Generator_CodeSimpleMetrics.ump"
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
  private CountSM countsm;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public StateMachineMetrics()
  {
    super();
    code = null;
    model = null;
    countsm = new CountSM();
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

  public boolean setCountsm(CountSM aCountsm)
  {
    boolean wasSet = false;
    countsm = aCountsm;
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

  public CountSM getCountsm()
  {
    return countsm;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={451},file={"Generator_CodeSimpleMetrics.ump"},javaline={91},length={71})
  public void calculate(){
    int totalStateMachinesPerClass= 0;
	  int totalStatesPerClass=0;
	  int smCount=0;
	  int totalStateMachines= 0;
      // Output basic file header
      code.append( "\n\n\n");
      code.append(Format.repeat("*",126)+"\n");
      code.append(Format.repeat(" ",20)+"S T A T E   M A C H I N E  ( S M )   M E A S U R E S"+"\n");
      code.append(Format.repeat("*",126)+"\n");
      
	  java.util.List<String>title = new java.util.ArrayList<String>();
      title.add(" Class Name                   ");
      title.add(" #State Machines ");
      title.add(" #Total of States ");
	  title.add(" #Transitions ");
      title.add(" #Total Events ");
      title.add(" #Total Actions ");
      title.add(" #States like SM ");
      code.append(Format.repeat("-",136)+"\n");
      for (int i=0;i<title.size();i++){ code.append("|"+title.get(i));  }
      code.append(" |\n");
      code.append(Format.repeat("-",136)+"\n");
	  
  
      for (UmpleClass uClass : model.getUmpleClasses()) {  
	    if (uClass!=null){

		  code.append( "| " +uClass.getName()+ Format.repeat(" ", title.get(0).length()-(""+uClass.getName()).length()-1 ) );

          //Look for State Machines
          totalStateMachinesPerClass= 0;
          totalStatesPerClass=0;
        
		  countsm.setTotalStateMachinesPerClass(0);
		  countsm.setTotalStates(0);
		  countsm.setTotalTransitions(0);
		  countsm.setTotalEvents(0);
		  countsm.setTotalActions(0);
		  countsm.setTotalNestedStateMachine(0);
		  
          for (StateMachine sm : uClass.getStateMachines()) {          
            ++totalStateMachinesPerClass;
			countsm.incTotalStateMachinesPerClass(1);
            nestedSM (sm, 0);

          }
		  code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+countsm.getTotalStateMachinesPerClass()).length()-1 )+ countsm.getTotalStateMachinesPerClass() );
          code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+countsm.getTotalStates()).length()-1 )+ countsm.getTotalStates() );
          code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+countsm.getTotalTransitions()).length()-1 )+ countsm.getTotalTransitions() );
          code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+countsm.getTotalEvents()).length()-1 )+ countsm.getTotalEvents() );
          code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+countsm.getTotalActions()).length()-1 )+ countsm.getTotalActions() );
          code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+countsm.getTotalNestedStateMachine()).length()-1 )+ countsm.getTotalNestedStateMachine() );
          code.append( " |\n" ); // closing the record. One record one line.
          code.append(Format.repeat("-",136)+"\n");
          countsm.incTotalStateMachines(countsm.getTotalStateMachinesPerClass());
          totalStateMachines+=totalStateMachinesPerClass;
		  smCount += countsm.getTotalStateMachinesPerClass();
        }
      }

      code.append("\n  Total Total of States Machines = "+countsm.getTotalStateMachines() + "\n");
      code.append("\n  Total Total of Transitions = "+countsm.getTotalTransitions() + "\n");

      code.append("\n  Total Total of States Machines = "+countsm.getTotalStateMachines() + "\n");
      code.append("\n  Total Total of Transitions = "+countsm.getTotalTransitions() + "\n");
      code.append("\n\n");
    
      super.setCode(code);
      return;
  }


  /**
   * End of method main
   */
  @umplesourcefile(line={524},file={"Generator_CodeSimpleMetrics.ump"},javaline={164},length={49})
  public void nestedSM(StateMachine sm, int level){
    int totalNestedStateMachine=0;  
  	  int totalStates= 0;
  	  int totalTransitions= 0;
  	  int totalEvents= 0;
  	
      ++totalNestedStateMachine; 
      countsm.incTotalNestedStateMachine(1);
      //code.append( Format.repeat(" ",(level+1)*3+2)+"Name of State Machine: "+sm.getName() + "\n" ); 
	  
      // Look for states
      totalStates= 0;
      for (State states: sm.getStates()) {          
        ++totalStates;
		countsm.incTotalStates(1);
        //code.append( Format.repeat(" ",(level+2)*3+2)+"Name of State: "+states.getName()  + "\n");
        
        // Look for Actions
		for (Action actions: states.getActions()) {  
		  countsm.incTotalActions(1);
		}
		
        // Look for transitions
        totalTransitions= 0;
        Event event=null;
        for (Transition transition: states.getTransitions()) {
          ++totalTransitions;
		  countsm.incTotalTransitions(1);
          if ( (event= transition.getEvent()) == null ){
            //code.append( Format.repeat(" ",(level+3)*3+2)+"Transition: "+transition.getFromState().getName()+" --> "+transition.getNextState().getName() + "\n" );
          }
          else { 
            countsm.incTotalEvents(1);		  
           // code.append( Format.repeat(" ",(level+3)*3+2)+"Transition: "+transition.getFromState().getName()+" --> "+transition.getNextState().getName() + " by event "+transition.getEvent().getName() + "\n" );    	
          }
        }
                   
        // Look for Nested StateMachine
        totalNestedStateMachine=0;
        for (StateMachine smnested: states.getNestedStateMachines()) {
          ++totalNestedStateMachine;
		  countsm.incTotalNestedStateMachine(1);
          nestedSM(smnested,level+1);     
        }               
      }
      //System.out.println( "          States: "+totalStates );
      //totalStatesPerClass+=totalStates;
	  return ;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "code" + "=" + (getCode() != null ? !getCode().equals(this)  ? getCode().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "countsm" + "=" + (getCountsm() != null ? !getCountsm().equals(this)  ? getCountsm().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}