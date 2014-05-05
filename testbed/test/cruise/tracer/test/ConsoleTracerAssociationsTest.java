package cruise.tracer.test;

import java.io.PrintStream;
import java.util.Arrays;

import org.junit.*;


public class ConsoleTracerAssociationsTest extends ConsoleTracerTestTemplate
{

  @Test
  public void traceConsoleAssoc()
  {
    PrintStream ps = new PrintStream(System.err){
      int index=0;

      String[] assocTraceExpected = {"Header",
          "as_a,manager,1",
          "as_a,manager,2",
          "as_r,manager,1"
      };

      String[] expected = concatAll(assocTraceExpected);

      
      Integer[] testField = {0,9,9};
      @Override
      public void println(String x){
        for(int i = 0 ; i<expected.length;++i )
          System.out.println("expected["+i+"]"+" = "+expected[i]);
        if(index<expected.length){

          					System.out.println("out from println = "+x);
          String[] actualOutput = x.split(",");
          String[] expectedOutput = expected[index].split(",");

          for(int i = 0 ; i<actualOutput.length;++i )
            System.out.println("actualOutput["+i+"]"+" = "+actualOutput[i]);
          for(int i = 0 ; i<expectedOutput.length;++i )
            System.out.println("expectedOutput["+i+"]"+" = "+expectedOutput[i]);
          // header skip
          if( index != 0 )
            for( int i = 0 ; i < expectedOutput.length ; ++i )
            {
              System.out.println("e = "+expectedOutput[i]);
              System.out.println("a = "+actualOutput[i+6]);
              Assert.assertEquals(expectedOutput[i],actualOutput[i+6]);
            }

          index++;
        }
        else {
          Assert.assertTrue(false);
        }
      }
    };
    System.setErr(ps);

    //--------------------------------------- invoke associations tracing

    CompanyA compA = new CompanyA();
    Manager m1 = new Manager();
    Manager m2 = new Manager();
    compA.addManager(m1);
    compA.addManager(m2);
    compA.removeManager(m1);

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
    for(int i = 0 ; i<result.length;++i )
    System.out.println("result[i] = "+result[i]);
    return result;
  }

}
