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
					"at_s,number1,7,8",
					"at_s,number2,22",
					"at_s,number2,33",
					"at_s,number3,45",
					"at_s,number3,46",
					"at_s,number4,55",
					"at_s,number4,66",
					"at_s,number5,0,1",
					"at_s,number5,1,2",
					"at_s,number5,2,3"
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
	  
	  ConsoleTracerTesterA cTest = new ConsoleTracerTesterA(null, 0, null, 0, 0, 0, 0, 0);
	  
	  cTest.setName("Geoff");
	  cTest.setName("Hamoud");
	  cTest.getName();
	  
	  cTest.setNumber1(7);
	  cTest.setNumCond(110);
	  cTest.setNumber1(8);
	  
	  cTest.setNumber2(11);
	  cTest.setNumCond(20);
	  cTest.setNumber2(22);
	  cTest.setNumber2(33);
	  
	  cTest.setNumber3(44);
	  cTest.setNumCond(1);
	  cTest.setNumber3(45);
	  cTest.setNumber3(46);

	  cTest.setNumber4(55);
	  cTest.setNumber4(66);
	  cTest.setNumCond(-99);
	  cTest.setNumber4(77);
	  
	  cTest.setNumber5(1);
	  cTest.setNumber5(2);
	  cTest.setNumber5(3);
	  cTest.setNumber5(4);
	  
  }
  
  @After
  public void cleanUp()
  {
	  System.setErr(defaultPS);
    //tracer = StringTracer.getInstance();
    //tracer.reset();
  }
}
