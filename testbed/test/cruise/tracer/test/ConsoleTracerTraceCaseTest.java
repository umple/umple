package cruise.tracer.test;

import java.io.PrintStream;

import org.junit.*;


public class ConsoleTracerTraceCaseTest extends ConsoleTracerTestTemplate
{

  @Test
  public void traceConsoleTraceCase()
  {
    PrintStream ps = new PrintStream(System.err){
      int index=0;

      String[] assocTraceExpected = {
          //---------------------- TraceCase A
          "at_s,id,0,100",
          "at_s,name,null,Ottawa",
          "sm_t,Off,flip,On",
          "sm_t,Normal,touch,Dimmed"
      };

      String[] expected = concatAll(assocTraceExpected);

      //--------------------------------------- Prepare Console tracer

      public void println(String x){
        if(index<expected.length){

          String[] actualOutput = x.split(",");
          String[] expectedOutput = expected[index].split(",");

          System.out.println("x = "+x);
          // header skip
          if( index != 0 )
            for( int i = 0 ; i < expectedOutput.length ; ++i )
              Assert.assertEquals(expectedOutput[i],actualOutput[i+6]);

          index++;
        }
        else 
          Assert.assertTrue(false);
      }
    };
    System.setErr(ps);

    //--------------------------------------- invoke tracecase tracing
    
    //---------------------- TraceCase A
    TraceCaseA ta = new TraceCaseA(null, 0);
    ta.setId(100);
    ta.setName("Ottawa");
    ta.flip();
    ta.touch();

  }

}
