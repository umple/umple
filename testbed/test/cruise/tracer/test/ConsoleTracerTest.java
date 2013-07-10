package cruise.tracer.test;

import java.io.PrintStream;

import org.junit.*;

import cruise.util.StringTracer;


public class ConsoleTracerTest
{
  
  //StringTracer tracer;
	PrintStream defaultPS;

	
  @Before
  public void setUp()
  {
    //tracer = StringTracer.getInstance();
    //tracer.reset();
	  defaultPS = System.err;
  }
  
  @Test 
  public void traceConsole()
  {
	  PrintStream ps = new PrintStream(System.err){
			int index=0;
			String[] expected = {"Time",
					"at_s,name,null,Geoff",
					"at_s,name,Geoff,Hamoud",
					"at_g,address,800 king Edward",
					"at_s,number1,7,8",
					"at_s,number2,22",
					"at_s,number2,33",
					"at_s,number3,45",
					"at_s,number3,46",
					"at_s,number4,55",
					"at_s,number4,66",
					"at_s,number5,0,1",
					"at_s,number5,1,2",
					"at_s,number5,2,3",
					"sm_e,Open,status",
					"sm_x,Open,status",
					"sm_t,Open,anEvent,Close",
					"sm_t,Close,anEvent,Open",
					"sm_e,Open,status",
					
					};
			Integer[] testField = {0,9,9};
			@Override
			public void println(String x){
				if(index<expected.length){
					
					System.out.println("out = "+x);
					String[] actualOutput = x.split(",");
					String[] expectedOutput = expected[index].split(",");
				
					// header skip
					if( index != 0 )
						for( int i = 0 ; i < expectedOutput.length ; ++i )
							Assert.assertEquals(expectedOutput[i],actualOutput[i+6]);
					
					index++;
				}
				else {
					Assert.assertTrue(false);
				}
			}
		};
	  System.setErr(ps);
	  
	  TraceAttr aTest = new TraceAttr(null,null, 0, null, 0, 0, 0, 0, 0);
	  
	  aTest.setName("Geoff");
	  aTest.setName("Hamoud");
	  aTest.getName();
	  
	  aTest.setAddress("800 king Edward");
	  aTest.getAddress();
	  
	  aTest.setNumber1(7);
	  aTest.setNumCond(110);
	  aTest.setNumber1(8);
	  
	  aTest.setNumber2(11);
	  aTest.setNumCond(20);
	  aTest.setNumber2(22);
	  aTest.setNumber2(33);
	  
	  aTest.setNumber3(44);
	  aTest.setNumCond(1);
	  aTest.setNumber3(45);
	  aTest.setNumber3(46);

	  aTest.setNumber4(55);
	  aTest.setNumber4(66);
	  aTest.setNumCond(-99);
	  aTest.setNumber4(77);
	  
	  aTest.setNumber5(1);
	  aTest.setNumber5(2);
	  aTest.setNumber5(3);
	  aTest.setNumber5(4);
	  
	  TraceStm sTrace = new TraceStm();
	  sTrace.anEvent();
	  sTrace.anEvent();
 }
  
  @After
  public void cleanUp()
  {
	  System.setErr(defaultPS);
    //tracer = StringTracer.getInstance();
    //tracer.reset();
  }
}
