package cruise.umple.implementation.sql;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class SqlAttributeTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Sql";
    languagePath = "sql";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/sql/Attributes.sql");
  }

  @Test
  public void Attributes()
  {
    assertUmpleTemplateFor(languagePath + "/Attributes.ump",languagePath + "/Attributes." + languagePath + ".txt", "Mentor");
  }
}
