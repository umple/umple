package cruise.tracer.test;

import java.io.PrintStream;

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

      //--------------------------------------- Prepare Console tracer

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
        else 
          Assert.assertTrue(false);
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

  }

}
