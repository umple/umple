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
          //---------------- CompanyManyToManyRole
          "as_a,managerA,1",
          "as_a,managerA,2",
          "as_a,managerA,3",
          "as_r,managerA,2",
          "as_a,managerA,3",
          //---------------- CompanyManyToManyAdd
          "as_a,managerB,1",
          "as_a,managerB,2",
          "as_a,managerB,3",
          "as_a,managerB,3",
          //---------------- CompanyManyToManyRemove
          "as_r,managerC,2",
          "as_r,managerC,1",
          "as_r,managerC,0"

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

    CompanyManyToManyRole compMA = new CompanyManyToManyRole();

    Manager m1 = new Manager();
    Manager m2 = new Manager();
    Manager m3 = new Manager();

    compMA.addManagerA(m1);
    compMA.addManagerA(m2);
    compMA.addManagerA(m3);
    compMA.removeManagerA(m1);
    compMA.addManagerA(m1);


    CompanyManyToManyAdd compMB = new CompanyManyToManyAdd();

    compMB.addManagerB(m1);
    compMB.addManagerB(m2);
    compMB.addManagerB(m3);
    compMB.removeManagerB(m3);
    compMB.addManagerB(m3);

    CompanyManyToManyRemove compMC = new CompanyManyToManyRemove();

    compMC.addManagerC(m1);
    compMC.addManagerC(m2);
    compMC.addManagerC(m3);
    compMC.removeManagerC(m3);
    compMC.removeManagerC(m2);
    compMC.removeManagerC(m1);

    //    CompanyManyToManyRole compM = new CompanyManyToMany();
    //
    //    ManagerA ma1 = new ManagerA();
    //    ManagerA ma2 = new ManagerA();
    //    ManagerA ma3 = new ManagerA();
    //
    //    compM.addManagerA(ma1);
    //    compM.addManagerA(ma2);
    //    compM.addManagerA(ma3);
    //    compM.removeManagerA(ma3);
    //    compM.addManagerA(ma3);
    //
    //    ManagerB mb1 = new ManagerB();
    //    ManagerB mb2 = new ManagerB();
    //    ManagerB mb3 = new ManagerB();
    //
    //    compM.addManagerB(mb1);
    //    compM.addManagerB(mb2);
    //    compM.addManagerB(mb3);
    //    compM.removeManagerB(mb3);
    //    compM.addManagerB(mb3);
    //    
    //    ManagerC mc1 = new ManagerC();
    //    ManagerC mc2 = new ManagerC();
    //    ManagerC mc3 = new ManagerC();
    //    
    //    compM.addManagerC(mc1);
    //    compM.addManagerC(mc2);
    //    compM.addManagerC(mc3);
    //    compM.removeManagerC(mc3);
    //    compM.removeManagerC(mc2);
    //    compM.removeManagerC(mc1);
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
