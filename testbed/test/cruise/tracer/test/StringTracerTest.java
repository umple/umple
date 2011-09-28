package cruise.tracer.test;

import org.junit.*;

import cruise.util.StringTracer;

@Ignore
public class StringTracerTest
{
  
  StringTracer tracer;

  @Before
  public void setUp()
  {
    tracer = StringTracer.getInstance();
    tracer.reset();
  }
  
  @Test
  public void traceStrings()
  {
    PersonA person = new PersonA();
    Assert.assertEquals(0,tracer.numberOfTraces());
    person.setName("aha");
    Assert.assertEquals(1,tracer.numberOfTraces());
    Assert.assertEquals("name=aha",tracer.getTrace(0));
  }
  
}
