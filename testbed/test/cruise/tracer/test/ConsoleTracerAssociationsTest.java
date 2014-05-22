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
          "as_r,managerC,0",
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

          System.out.println("x = "+x);
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

    CompanyBiManyToManyRole compBiMA = new CompanyBiManyToManyRole();

    Manager m1 = new Manager();
    Manager m2 = new Manager();
    Manager m3 = new Manager();

    compBiMA.addManagerA(m1);
    compBiMA.addManagerA(m2);
    compBiMA.addManagerA(m3);
    compBiMA.removeManagerA(m1);
    compBiMA.addManagerA(m1);

    CompanyBiManyToManyAdd compBiMB = new CompanyBiManyToManyAdd();

    compBiMB.addManagerB(m1);
    compBiMB.addManagerB(m2);
    compBiMB.addManagerB(m3);
    compBiMB.removeManagerB(m3);
    compBiMB.addManagerB(m3);

    CompanyBiManyToManyRemove compBiMC = new CompanyBiManyToManyRemove();

    compBiMC.addManagerC(m1);
    compBiMC.addManagerC(m2);
    compBiMC.addManagerC(m3);
    compBiMC.removeManagerC(m3);
    compBiMC.removeManagerC(m2);
    compBiMC.removeManagerC(m1);
    
    CompanyUniManyToManyRole compUniMA = new CompanyUniManyToManyRole();

    compUniMA.addManagerA(m1);
    compUniMA.addManagerA(m2);
    compUniMA.addManagerA(m3);
    compUniMA.removeManagerA(m1);
    compUniMA.addManagerA(m1);

    CompanyUniManyToManyAdd compUniMB = new CompanyUniManyToManyAdd();

    compUniMB.addManagerB(m1);
    compUniMB.addManagerB(m2);
    compUniMB.addManagerB(m3);
    compUniMB.removeManagerB(m3);
    compUniMB.addManagerB(m3);

    CompanyUniManyToManyRemove compUniMC = new CompanyUniManyToManyRemove();

    compUniMC.addManagerC(m1);
    compUniMC.addManagerC(m2);
    compUniMC.addManagerC(m3);
    compUniMC.removeManagerC(m3);
    compUniMC.removeManagerC(m2);
    compUniMC.removeManagerC(m1);

  }

}
