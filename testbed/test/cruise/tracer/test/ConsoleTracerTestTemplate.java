package cruise.tracer.test;

import java.io.PrintStream;
import java.util.Arrays;

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
  
  public static String[] concatAll(String[] first, String[]... rest) {
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
  }
}
