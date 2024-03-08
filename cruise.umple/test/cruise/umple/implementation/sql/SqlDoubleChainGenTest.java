package cruise.umple.implementation.sql;

import org.junit.*;
import cruise.umple.implementation.*;

public class SqlDoubleChainGenTest extends DoubleChainGenTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Sql";
    languagePath = "sql";
  }

  @Test //Specific test for SQL generation with an empty class in the middle of a double chain
  public void Parent()
  {
    assertUmpleTemplateFor("sql/DoubleChainGenEmptyTest.ump", "sql/DoubleChainGenEmptyTest_Parent.sql.txt","Person");
  }
  
  @Test
  public void Middle()
  {
    assertUmpleTemplateFor("sql/DoubleChainGenEmptyTest.ump", "sql/DoubleChainGenEmptyTest_Middle.sql.txt","Employee");
  } 
  
  @Test
  public void Child()
  {
    assertUmpleTemplateFor("sql/DoubleChainGenEmptyTest.ump", "sql/DoubleChainGenEmptyTest_Child.sql.txt","Admin");
  }  

}