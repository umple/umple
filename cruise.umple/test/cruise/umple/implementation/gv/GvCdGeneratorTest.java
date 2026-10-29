package cruise.umple.implementation.gv;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class GvCdGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "GvClassDiagram";
    languagePath = "gv";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/gv/Attributescd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Methodscd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Abstractcd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Associationscd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Compositionscd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Interfacecd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ManyClasscd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ManyClassAbstractcd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/EmptyClasscd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ColourParsingcd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ColourParsingTest2cd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/ColourParsingTest3cd.gv");

    SampleFileWriter.destroy(pathToInput + "/gv/IncreaseClassSepcd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/Enumerationcd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/AssociationClassescd.gv");
  }

  @Test
  public void tooltips_for_attributes()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Attributes.ump","gv/Attributes.gv.txt");
  }  
  
  @Test
  public void tooltips_for_methods()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Methods.ump","gv/Methods.gv.txt");
  } 

  @Test
  public void display_empty_class()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/EmptyClass.ump","gv/EmptyClass.gv.txt");
  } 
  
  @Test
  public void display_abstract()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Abstract.ump","gv/Abstract.gv.txt");
  } 

  @Test
  public void display_associations()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Associations.ump","gv/Associations.gv.txt");
  }

  @Test
  public void display_association_classes()
  {
    String code = createUmpleSystem(pathToInput, "gv/AssociationClasses.ump").getCode();
    assertTrue(code.contains("\"Ticket association\" [shape=point"));
    assertTrue(code.contains("\"Ticket\" -> \"Ticket association\" [dir=\"none\", style=dashed"));
    assertTrue(code.contains("\"Ticket association\" -> \"Performance\" [dir=\"none\", headlabel=\"* \""));
    assertTrue(code.contains("\"Ticket association\" -> \"TicketHolder\" [dir=\"none\", headlabel=\"* \""));
    assertTrue(code.contains("seatNumber : String"));
    assertFalse(code.contains("\"Ticket\" -> \"Performance\""));
    assertFalse(code.contains("\"Ticket\" -> \"TicketHolder\""));
    assertTrue(code.contains("\"Ticket\" -> \"Receipt\""));
    assertFalse(code.contains("\"Ticket association\" -> \"Receipt\""));
    assertTrue(code.contains("\"Assignment association\" -> \"Member\" [dir=\"none\", headlabel=\"1..* mentor\""));
    assertTrue(code.contains("\"Assignment association\" -> \"Member\" [dir=\"none\", headlabel=\"0..2 mentee\""));
    assertTrue(code.contains("\"Booking association\" -> \"Performance\" [dir=\"none\", headlabel=\"* shows\""));
    assertTrue(code.contains("\"Booking association\" -> \"TicketHolder\" [dir=\"none\", headlabel=\"1..* holders\""));
    assertTrue(code.contains("\"Subscription association\" -> \"Performance\" [dir=\"none\", headlabel=\"* \""));
    assertTrue(code.contains("\"Subscription association\" -> \"TicketHolder\" [dir=\"none\", headlabel=\"* \""));
    assertTrue(code.contains("\"Subscription association\" -> \"Season\" [dir=\"none\", headlabel=\"* \""));
    assertFalse(code.contains("\"Subscription\" -> \"Season\""));
    assertFalse(code.contains("Action.selectClass(&quot;Ticket association&quot;)"));
    assertFalse(code.contains("Action.selectAssociation('Ticket association"));
  }

  @Test
  public void display_compositions()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Compositions.ump","gv/Compositions.gv.txt");
  }

  @Ignore
  public void display_interface()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Interface.ump","gv/Interface.gv.txt");
  }
  @Test
  public void display_many_classes()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ManyClass.ump","gv/ManyClass.gv.txt");
  } 
  
  @Test
  public void display_many_class_abstract()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ManyClassAbstract.ump","gv/ManyClassAbstract.gv.txt");
  } 
   @Test
  public void colour_parsing_error_test()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ColourParsing.ump","gv/ColourParsing.gv.txt");
  } 
  @Test
  public void colour_parsing_error_test2()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ColourParsingTest2.ump","gv/ColourParsingTest2.gv.txt");
  } 
  @Test
  public void colour_parsing_error_test3()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/ColourParsingTest3.ump","gv/ColourParsingTest3.gv.txt");
  } 
  @Test
  public void nodeSeparationCd()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/IncreaseClassSep.ump","gv/IncreaseClassSep.gv.txt");
  }

  @Test
  public void display_enumerations()
  {
    language = null;
    assertUmplePartialTemplateFor("gv/Enumeration.ump","gv/Enumeration.gv.txt");
  }
}
