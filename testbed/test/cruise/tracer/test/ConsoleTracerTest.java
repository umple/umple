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
			String[] expectedOutput = {"Time",
					"Geoff",
					"Hamoud"};
			Integer[] testField = {0,9,9};
			@Override
			public void println(String x){
				if(index<expectedOutput.length){
					//System.out.println("test = "+x.split(",")[2]);
					Assert.assertEquals(expectedOutput[index],x.split(",")[testField[index]]);
					index++;
				}
				else {
					Assert.assertTrue(false);
				}
			}
		};
	  System.setErr(ps);
	  PersonA person = new PersonA(null);
	  
	  person.setName("Geoff");
	  person.setName("Hamoud");
	  
	  
  }
  
  @After
  public void cleanUp()
  {
	  System.setErr(defaultPS);
    //tracer = StringTracer.getInstance();
    //tracer.reset();
  }
}
