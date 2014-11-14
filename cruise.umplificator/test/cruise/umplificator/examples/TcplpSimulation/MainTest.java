/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/


import java.lang.Thread;

/**
 * mainTest class
 */
// line 448 "TcpIpSimulation.ump"
public class MainTest
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MainTest()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  // line 452 "TcpIpSimulation.ump"
   public static  void main(String [] args){
    Thread.currentThread().setUncaughtExceptionHandler(new UmpleExceptionHandler());
    Thread.setDefaultUncaughtExceptionHandler(new UmpleExceptionHandler());
    Tcp_Server server= new Tcp_Server();
    server.start();
    Tcp_Client client= new Tcp_Client();
    client.start();
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
    public UmpleSourceData Tcp_passiveClose(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(61).setJavaLines(319).setLengths(1);}
    public UmpleSourceData Tcp_syn(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(36).setJavaLines(159).setLengths(1);}
    public UmpleSourceData Tcp_finAck(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(70).setJavaLines(339).setLengths(1);}
    public UmpleSourceData Tcp_data(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(57).setJavaLines(299).setLengths(1);}
    public UmpleSourceData Tcp_fin(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump"," TcpIpSimulation.ump"," TcpIpSimulation.ump").setUmpleLines(55, 69, 73).setJavaLines(247, 253, 259).setLengths(1, 1, 1);}
    public UmpleSourceData Tcp_activeOpen(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(32).setJavaLines(139).setLengths(1);}
    public UmpleSourceData Tcp_activeClose(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(56).setJavaLines(279).setLengths(1);}
    public UmpleSourceData Tcp_synAck(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(49).setJavaLines(227).setLengths(1);}
    public UmpleSourceData Queue_1_release_semC(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(140).setJavaLines(75).setLengths(3);}
    public UmpleSourceData Queue_1_release_semS(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(152).setJavaLines(89).setLengths(3);}
    public UmpleSourceData Queue_1_acquire_semC(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(132).setJavaLines(66).setLengths(3);}
    public UmpleSourceData Queue_1_acquire_semS(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(144).setJavaLines(80).setLengths(3);}
    public UmpleSourceData Queue_Tcp_isEmptyMessage(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(182).setJavaLines(52).setLengths(3);}
    public UmpleSourceData Receiver_run(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(199).setJavaLines(49).setLengths(3);}
    public UmpleSourceData MySocket_send(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(236).setJavaLines(115).setLengths(3);}
    public UmpleSourceData MySocket_connect(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(221).setJavaLines(97).setLengths(3);}
    public UmpleSourceData MySocket_close(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(241).setJavaLines(121).setLengths(3);}
    public UmpleSourceData MyServerSocket_accept(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(264).setJavaLines(115).setLengths(3);}
    public UmpleSourceData Tcp_Client_run(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(299).setJavaLines(129).setLengths(3);}
    public UmpleSourceData Tcp_Server_serverStopped(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(434).setJavaLines(226).setLengths(3);}
    public UmpleSourceData Tcp_Server_run(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(363).setJavaLines(154).setLengths(3);}
    public UmpleSourceData Tcp_Server_stopListening(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(439).setJavaLines(235).setLengths(3);}
    public UmpleSourceData Tcp_Server_serverStarted(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(430).setJavaLines(221).setLengths(3);}
    public UmpleSourceData MainTest_main(){ return new UmpleSourceData().setFileNames("TcpIpSimulation.ump").setUmpleLines(451).setJavaLines(32).setLengths(3);}

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