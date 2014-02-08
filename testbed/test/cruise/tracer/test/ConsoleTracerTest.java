package cruise.tracer.test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.*;


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
			String[] attrTraceExpected = {"Time",
					"at_s,name,null,Geoff",
					"at_s,name,Geoff,Hamoud",
					"at_g,address,800 king Edward",
					"at_s,salary,0.0,1000.0",
					"at_g,salary,1000.0",
					"at_s,number1,7,8",
					"at_s,number2,22",
					"at_s,number2,33",
					"at_s,number3,45",
					"at_s,number3,46",
					"at_s,number4,5.5",
					"at_s,number4,6.6",
					"at_s,str,null,String 1",
					"at_s,str,String 1,String 2",
					"at_s,str,String 2,String 3"
			};
			
			String[] attrTraceCondExpected = {
					"at_s,n1,50,110",
					"at_s,n1,110,120",
					"at_s,n2,70",
					"at_s,n2,80",
					"at_s,n3,33",
					"at_s,n3,44",
					"at_s,n4,99.0"
			};
			
			String[] stmTraceExpected = {
					"sm_e,Close,status",
			};
			
			String[] recordTraceExpected = {
					"at_s,number1,0,100,TracingNumber1",
					"at_s,number2,0,200,Tracing Number2"
			};
			
			String[] expected = concatAll(attrTraceExpected, attrTraceCondExpected, stmTraceExpected, recordTraceExpected);
			
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
	  
	  //==== invoke attributes tracing
	  TraceAttr aTest = new TraceAttr(null, null, 0, false, 0, null, 0, 0, 0, 0, null);
	  
	  aTest.setName("Geoff");
	  aTest.setName("Hamoud");
	  aTest.getName();
	  
	  aTest.setFlag(false);
	  
	  aTest.setAddress("800 king Edward");
	  aTest.getAddress();
	  
	  aTest.setSalary(1000);
	  aTest.getSalary();
	  
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

	  aTest.setNumber4(5.5);
	  aTest.setNumber4(6.6);
	  aTest.setNumCond(-99);
	  aTest.setNumber4(7.7);
	  
	  aTest.setStr("String 1");
	  aTest.setStr("String 2");
	  aTest.setStr("String 3");
	  aTest.setStr("String 4");
	  
	  TraceAttrCond acTest = new TraceAttrCond(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
	  
	  acTest.setN1(50);
	  acTest.setN1(110);
	  acTest.setN1(120);
	  acTest.setN1(130);
	  
	  acTest.setN2(-2);
	  acTest.setN2(70);
	  acTest.setN2(80);
	  acTest.setN2(90);
	  
	  acTest.setN3(0);
	  acTest.setN3(22);
	  acTest.setN3(33);
	  acTest.setN3(44);
	  
	  acTest.setN4(99);
	  acTest.setN4(0.5);
	  acTest.setN4(-8);
	  
//	  acTest.setN5(35);
//	  acTest.setN5(15);
//	  acTest.setN5(55);
//	  acTest.setN5(-1);
	  
	  //==== invoke state machine tracing
	  TraceStm sTrace = new TraceStm();
	  sTrace.ev1();
	  sTrace.ev1();
	  
	  //==== invoke record trace
	  TraceRecord rTrace = new TraceRecord(0, 0, null);
	  
	  rTrace.setNumber1(100);
	  
	  rTrace.setStr("Tracing Number2");
	  rTrace.setNumber2(200);
	  
 }
  
 public static <String> String[] concatAll(String[] first, String[]... rest) {
	  int totalLength = first.length;
	  for (String[] array : rest) {
	    totalLength += array.length;
	  }
	  String[] result = Arrays.copyOf(first, totalLength);
	  int offset = first.length;
	  for (String[] array : rest) {
	    System.arraycopy(array, 0, result, offset, array.length);
	    offset += array.length;
	  }
	  return result;
	}
  
  @After
  public void cleanUp()
  {
	  System.setErr(defaultPS);
    //tracer = StringTracer.getInstance();
    //tracer.reset();
  }
}
