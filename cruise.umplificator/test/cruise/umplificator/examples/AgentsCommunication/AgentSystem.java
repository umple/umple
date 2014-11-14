/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.math.*;
import java.util.*;

// line 5 "AgentsCommunication.ump"
public class AgentSystem
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AgentSystem Associations
  private List<Agent> agents;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AgentSystem()
  {
    agents = new ArrayList<Agent>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Agent getAgent(int index)
  {
    Agent aAgent = agents.get(index);
    return aAgent;
  }

  public List<Agent> getAgents()
  {
    List<Agent> newAgents = Collections.unmodifiableList(agents);
    return newAgents;
  }

  public int numberOfAgents()
  {
    int number = agents.size();
    return number;
  }

  public boolean hasAgents()
  {
    boolean has = agents.size() > 0;
    return has;
  }

  public int indexOfAgent(Agent aAgent)
  {
    int index = agents.indexOf(aAgent);
    return index;
  }

  public static int minimumNumberOfAgents()
  {
    return 0;
  }

  public Agent addAgent(int aAgentNumber)
  {
    return new Agent(aAgentNumber, this);
  }

  public boolean addAgent(Agent aAgent)
  {
    boolean wasAdded = false;
    if (agents.contains(aAgent)) { return false; }
    AgentSystem existingAgentSystem = aAgent.getAgentSystem();
    boolean isNewAgentSystem = existingAgentSystem != null && !this.equals(existingAgentSystem);
    if (isNewAgentSystem)
    {
      aAgent.setAgentSystem(this);
    }
    else
    {
      agents.add(aAgent);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAgent(Agent aAgent)
  {
    boolean wasRemoved = false;
    //Unable to remove aAgent, as it must always have a agentSystem
    if (!this.equals(aAgent.getAgentSystem()))
    {
      agents.remove(aAgent);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAgentAt(Agent aAgent, int index)
  {  
    boolean wasAdded = false;
    if(addAgent(aAgent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAgents()) { index = numberOfAgents() - 1; }
      agents.remove(aAgent);
      agents.add(index, aAgent);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAgentAt(Agent aAgent, int index)
  {
    boolean wasAdded = false;
    if(agents.contains(aAgent))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAgents()) { index = numberOfAgents() - 1; }
      agents.remove(aAgent);
      agents.add(index, aAgent);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAgentAt(aAgent, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=agents.size(); i > 0; i--)
    {
      Agent aAgent = agents.get(i - 1);
      aAgent.delete();
    }
  }

  // line 11 "AgentsCommunication.ump"
  public Agent findAgent(int num){
    for(Agent agent : getAgents()) {
       if(agent.getAgentNumber() == num) {
          return(agent);
       }
     }
     return null;
  }

  // line 20 "AgentsCommunication.ump"
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
    int randomIndex;
    AgentSystem theAgentSystem = new AgentSystem();
    theAgentSystem.addAgent(new AgentA(1, theAgentSystem));
    theAgentSystem.addAgent(new AgentB(2, theAgentSystem));
    Random r = new Random();
    
    for(int i=0; i<1000; i++) 
    {
      // clock either agent depending on parity of a random number generator
      int theNext =Math.abs(r.nextInt());
      randomIndex = theNext % 2;
      //System.out.println("Int was "+theNext+ "Next random index = " + randomIndex);
      theAgentSystem.getAgent(randomIndex).clock();
    }
  }

  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler
  {
    public void uncaughtException(Thread t, Throwable e)
    {
      translate(e);
      if(e.getCause()!=null)
      {
        translate(e.getCause());
      }
      e.printStackTrace();
    }
    public void translate(Throwable e)
    {
      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();
      StackTraceElement[] elements = e.getStackTrace();
      try
      {
        for(StackTraceElement element:elements)
        {
          String className = element.getClassName();
          String methodName = element.getMethodName();
          boolean methodFound = false;
          int index = className.lastIndexOf('.')+1;
          try {
            java.lang.reflect.Method query = this.getClass().getMethod(className.substring(index)+"_"+methodName,new Class[]{});
            UmpleSourceData sourceInformation = (UmpleSourceData)query.invoke(this,new Object[]{});
            for(int i=0;i<sourceInformation.size();++i)
            {
              int distanceFromStart = element.getLineNumber()-sourceInformation.getJavaLine(i)-(("main".equals(methodName))?2:0);
              if(distanceFromStart>=0&&distanceFromStart<=sourceInformation.getLength(i))
              {
                result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),sourceInformation.getFileName(i),sourceInformation.getUmpleLine(i)+distanceFromStart));
                methodFound = true;
                break;
              }
            }
          }
          catch (Exception e2){}
          if(!methodFound)
          {
            result.add(element);
          }
        }
      }
      catch (Exception e1)
      {
        e1.printStackTrace();
      }
      e.setStackTrace(result.toArray(new StackTraceElement[0]));
    }
  //The following methods Map Java lines back to their original Umple file / line    
    public UmpleSourceData AgentSystem_findAgent(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump").setUmpleLines(10).setJavaLines(143).setLengths(3);}
    public UmpleSourceData AgentSystem_main(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump").setUmpleLines(19).setJavaLines(153).setLengths(3);}
    public UmpleSourceData Agent_send(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump").setUmpleLines(46).setJavaLines(184).setLengths(3);}
    public UmpleSourceData Agent_clock(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump").setUmpleLines(80).setJavaLines(221).setLengths(3);}
    public UmpleSourceData Agent_receive(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump").setUmpleLines(59).setJavaLines(198).setLengths(3);}
    public UmpleSourceData Agent_consume(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump").setUmpleLines(66).setJavaLines(206).setLengths(3);}
    public UmpleSourceData AgentA_clock(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump"," AgentsCommunication.ump").setUmpleLines(100, 103).setJavaLines(61, 70).setLengths(1, 1);}
    public UmpleSourceData AgentA_setSm(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump"," AgentsCommunication.ump").setUmpleLines(90, 96).setJavaLines(91, 95).setLengths(1, 1);}
    public UmpleSourceData AgentB_clock(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump"," AgentsCommunication.ump").setUmpleLines(118, 122).setJavaLines(57, 66).setLengths(1, 1);}
    public UmpleSourceData AgentB_setSm(){ return new UmpleSourceData().setFileNames("AgentsCommunication.ump"," AgentsCommunication.ump").setUmpleLines(114, 125).setJavaLines(91, 95).setLengths(1, 1);}

  }
  public static class UmpleSourceData
  {
    String[] umpleFileNames;
    Integer[] umpleLines;
    Integer[] umpleJavaLines;
    Integer[] umpleLengths;
    
    public UmpleSourceData(){
    }
    public String getFileName(int i){
      return umpleFileNames[i];
    }
    public Integer getUmpleLine(int i){
      return umpleLines[i];
    }
    public Integer getJavaLine(int i){
      return umpleJavaLines[i];
    }
    public Integer getLength(int i){
      return umpleLengths[i];
    }
    public UmpleSourceData setFileNames(String... filenames){
      umpleFileNames = filenames;
      return this;
    }
    public UmpleSourceData setUmpleLines(Integer... umplelines){
      umpleLines = umplelines;
      return this;
    }
    public UmpleSourceData setJavaLines(Integer... javalines){
      umpleJavaLines = javalines;
      return this;
    }
    public UmpleSourceData setLengths(Integer... lengths){
      umpleLengths = lengths;
      return this;
    }
    public int size(){
      return umpleFileNames.length;
    }
  } 
}