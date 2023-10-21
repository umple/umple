package cruise.umple.statemachine.implementation.py;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.statemachine.implementation.StateMachineTest;
import cruise.umple.util.SampleFileWriter;

public class PythonStateMachineTest extends StateMachineTest
{
 @Before
  public void setUp()
  {
    super.setUp();
    language = "Python";
    languagePath = "py";
  }
  
  

}