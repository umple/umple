package cruise.umple.implementation.sql;

import org.junit.*;
import cruise.umple.implementation.*;

public class SqlSingleGenTest extends SingleGenTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Sql";
    languagePath = "sql";
  }
}