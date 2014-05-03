package cruise.tracer.test;

import java.io.PrintStream;

import org.junit.*;

@Ignore
public class ConsoleTracerTestTemplate
{

  PrintStream defaultPS;

  @Before
  public void setUp()
  {
    defaultPS = System.err;
  }

  @After
  public void cleanUp()
  {
    System.setErr(defaultPS);
  }
}
