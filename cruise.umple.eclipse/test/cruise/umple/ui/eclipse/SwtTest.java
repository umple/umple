package cruise.umple.ui.eclipse;

import org.eclipse.swt.widgets.*;
import org.junit.*;

import cruise.umple.ui.eclipse.Activator;


public class SwtTest {

  public Shell parent;
  private static Display display;
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    display = new Display();
  }

  @Before
  public void setUp() throws Exception {
    parent = new Shell(display);
    Activator.loadDefaultAsRequired();
  }
  
  @After
  public void tearDown() throws Exception {
    parent.dispose();
    Activator.resetDefault();
  }
  
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    if (display != null)
    {
      display.dispose();  
    }
  }
  
  @Test
  public void empty()
  {}

}
