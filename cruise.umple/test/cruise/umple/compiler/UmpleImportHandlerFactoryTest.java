/**
 * 
 */
package cruise.umple.compiler;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @since 19 Mar 2015
 */
public class UmpleImportHandlerFactoryTest {
  
  /**
   * Test creation of {@link UmpleImportHandler}s
   */
  @Test
  public void create() {
    // check that the proper classes are created
    assertEquals(UmpleImportHandlerFactory.create(UmpleImportType.ECORE).getClass(), EcoreImportHandler.class);
    assertEquals(UmpleImportHandlerFactory.create(UmpleImportType.SCXML).getClass(), ScxmlImportHandler.class);
  }
  
  @Test
  public void importTypeStructure() {
    assertTrue(UmpleImportType.ALL.contains(UmpleImportType.ECORE));
    assertTrue(UmpleImportType.ALL.contains(UmpleImportType.SCXML));
  }

}
