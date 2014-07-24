package cruise.tracer.test;

import java.io.PrintStream;
import java.util.Arrays;

import org.junit.*;


public class ConsoleTracerStateMachinesTest extends ConsoleTracerTestTemplate
{


  @Test
  public void traceConsoleStm()
  {
    PrintStream ps = new PrintStream(System.err){
      int index=0;

      String[] stmTraceExpected = {
          //=== GarageDoorA
          "sm_t,Open,buttonOrObstacle,Closing",
          "sm_t,Closing,reachBottom,Closed",
          "sm_t,Open,buttonOrObstacle,Closing",
          "sm_t,Closing,reachBottom,Closed",
          "sm_e,Closed,actionUmpleLine=46,GarageDoor",
          "sm_t,Closing,reachBottom,Closed",
          "sm_e,Closed,actionUmpleLine=46,GarageDoor",
          "sm_x,Closed,actionUmpleLine=81,GarageDoor",
          "sm_t,Closed,buttonOrObstacle,Opening",
          "sm_t,Open,buttonOrObstacle,Closing",
          "sm_t,Closed,buttonOrObstacle,Opening",
          "sm_t,Open,buttonOrObstacle,Closing",
          "sm_t,Closing,buttonOrObstacle,Opening",
          "sm_t,Opening,buttonOrObstacle,HalfOpen",
          //=== LightFixtureA
//          "sm_t,Open,flip,Closed",
//          "sm_da,Closed,doActivitedStarted,status",
//          "sm_di,Closed,doActivitedInterrupted,status",
//          "sm_t,Closed,flip,Open",
          //=== LightFixtureB
          "sm_t,Off,flip,On",
          "sm_t,Normal,touch,Dimmed",
          "sm_t,Dimmed,touch,Off",
          "sm_t,Off,flip,On",
          "sm_t,On,flip,Off",
          //=== NestedStateA
          "sm_t,sLevel1,e1,sLevel2b",
          "sm_t,sLevel2b,e2,sLevel2aLevel3a",
          "sm_t,sLevel2aLevel3a,e3,sLevel2aLevel3b",
          "sm_t,sLevel2aLevel3bLevel4,e4,outsideNested",
          //=== NestedStateB
          //					"sm_t,Off,flip,Idle",
          //					"sm_t,Idle,flip,Running",
          //=== NestedStateLevel1
          "sm_t,sLevel1,e1,sLevel2b",
          //=== NestedStateLevel2
          "sm_t,sLevel1,e1,sLevel2b",
          "sm_t,sLevel2b,e2,sLevel2aLevel3a",
          //=== NestedStateLevel4
          "sm_t,sLevel1,e1,sLevel2b",
          "sm_t,sLevel2b,e2,sLevel2aLevel3a",
          "sm_t,sLevel2aLevel3a,e3,sLevel2aLevel3b",
          "sm_t,sLevel2aLevel3bLevel4,e4,outsideNested",
          //=== ConcurrentStmA
          "sm_t,Off,turnOn,On",
          "sm_t,MotorIdle,flip,MotorRunning",
          "sm_t,FanIdle,flop,FanRunning",
          "sm_t,MotorRunning,flip,MotorIdle",
          "sm_t,MotorIdle,flup,Off"
          //=== TimedEventA
          //					"sm_t,Open,timeoutOpenToClosed,Closed",
          //					"sm_t,Closed,timeoutClosedToFinal,Final",
          //=== QueuedStmTraceA
          //					"sm_t,Open,register,Full",
          //					"sm_t,Full,reject,Full"
      };

      String[] expected = concatAll(stmTraceExpected);

      //--------------------------------------- Prepare Console tracer
      
      public void println(String x){
        if(index<expected.length){

          String[] actualOutput = x.split(",");
          String[] expectedOutput = expected[index].split(",");

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

    //--------------------------------------- invoke state machine tracing

    GarageDoorA gaTrace = new GarageDoorA();
    gaTrace.buttonOrObstacle();
    gaTrace.reachBottom();
    gaTrace.buttonOrObstacle();
    gaTrace.reachTop();
    gaTrace.buttonOrObstacle();

    GarageDoorB gbTrace = new GarageDoorB();
    gbTrace.buttonOrObstacle();
    gbTrace.reachBottom();
    gbTrace.buttonOrObstacle();
    gbTrace.reachTop();
    gbTrace.buttonOrObstacle();
    gbTrace.reachBottom();

    GarageDoorC gcTrace = new GarageDoorC();
    gcTrace.buttonOrObstacle();
    gcTrace.reachBottom();
    gcTrace.buttonOrObstacle();
    gcTrace.reachTop();
    gcTrace.buttonOrObstacle();
    gcTrace.reachBottom();

    GarageDoorD gD = new GarageDoorD();
    gD.buttonOrObstacle();
    gD.reachBottom();
    gD.buttonOrObstacle();
    gD.reachTop();
    gD.buttonOrObstacle();
    gD.buttonOrObstacle();
    gD.buttonOrObstacle();

    LightFixtureA lA = new LightFixtureA();
    lA.flip();
    try {Thread.sleep(500);} catch (InterruptedException e) { e.printStackTrace();}
    lA.flip();
    try {Thread.sleep(500);} catch (InterruptedException e) { e.printStackTrace();}

    LightFixtureB lB = new LightFixtureB();
    lB.flip();
    lB.touch();
    lB.touch();
    lB.flip();
    lB.flip();

    NestedStateA nsA = new NestedStateA();
    nsA.e1();
    nsA.e2();
    nsA.e3();
    nsA.e4();

    //	  NestedStateB nsB = new NestedStateB();
    //	  nsB.flip();
    //	  nsB.flip();

    NestedStateLevel1 ns1 = new NestedStateLevel1();
    ns1.e1();
    ns1.e2();
    ns1.e3();
    ns1.e4();

    NestedStateLevel2 ns2 = new NestedStateLevel2();
    ns2.e1();
    ns2.e2();
    ns2.e3();
    ns2.e4();

    NestedStateLevel4 ns4 = new NestedStateLevel4();
    ns4.e1();
    ns4.e2();
    ns4.e3();
    ns4.e4();

    ConcurrentStmA cA = new ConcurrentStmA();
    cA.turnOn();
    cA.flip();
    cA.flop();
    cA.flip();
    cA.flup();

    //	  TimedEventA tA = new TimedEventA();

    //	  HisTest ht = new HisTest();
    //
    //	   // Initial state s1a
    //	   ht.e1();  // s1b
    //	   ht.e2();  // s2a;
    //	   ht.e2();  // s1b based on history
    //	   ht.e2();  // s2a based on history
    //	   ht.e1();  // s2b;
    //	   ht.e2();  // s1b based on history
    //	   ht.e1();  // s1a;

    //	  QueuedStmTraceA qA = new QueuedStmTraceA();
    //	  qA.register();
    //	  qA.reject();


  }

}
