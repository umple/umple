package cruise.umple.implementation;

import org.junit.Test;

public class AssociationInterfaceTest extends TemplateTest {
	
	@Test
	public void shouldNotGenerateDuplicateMethods() {
	    assertUmpleTemplateFor("AssociationInterfaceTest.ump", languagePath + "/AssociationInterfaceTest."+ languagePath +".txt", "Person");
	}

}
