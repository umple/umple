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
					"at_s,name,Geoff,Hamoud"};
			Integer[] testField = {0,9,9};
			@Override
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
				else {
					Assert.assertTrue(false);
				}
			}
		};
	  System.setErr(ps);
	  
	  ConsoleTracerTester cTest = new ConsoleTracerTester(null);
	  
	  cTest.setName("Geoff");
	  cTest.setName("Hamoud");
	  
  }
  
  @After
  public void cleanUp()
  {
	  System.setErr(defaultPS);
    //tracer = StringTracer.getInstance();
    //tracer.reset();
  }
}
