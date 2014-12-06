package cruise.umple.implementation.gv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class GvErdGeneratorTest extends TemplateTest {

	@Before
	public void setUp() {
		super.setUp();
	    language = "GvEntityRelationshipDiagram";
	    languagePath = "gv";
	}

	@After
	public void tearDown() {
		super.tearDown();
	    SampleFileWriter.destroy(pathToInput + "/gv/NormalEntityerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/TwoEntityerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/HiddenAttrEntityerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/InheritanceEntityerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/EmbeddedEntityerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/WeakEntityerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/ColouredEntityerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/ColouredDerivedAttrerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/Relationship11erd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/Relationship1Nerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/RelationshipN1erd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/RelationshipNNerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/RelationshipRangeerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/RelationshipReflexiveerd.gv");
	    SampleFileWriter.destroy(pathToInput + "/gv/RelationshipAttributeserd.gv");
	}

	// Also tests multi-valued attribute, derived attribute
	@Test
	public void Normal_Entity_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/NormalEntity.ump","gv/NormalEntity.gv.txt");
	}

	// Also tests key declaration
	@Test
	public void Two_Entity_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/TwoEntity.ump","gv/TwoEntity.gv.txt");
	}
	
	@Test
	public void Inheritance_Entity_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/InheritanceEntity.ump","gv/InheritanceEntity.gv.txt");
	}
	
	@Test
	public void Embedded_Entity_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/EmbeddedEntity.ump","gv/EmbeddedEntity.gv.txt");
	}
	
	@Test
	public void Weak_Entity_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/WeakEntity.ump","gv/WeakEntity.gv.txt");
	}
	
	@Test
	public void Coloured_Entity_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/ColouredEntity.ump","gv/ColouredEntity.gv.txt");
	}
	
	@Test
	public void Coloured_Derived_Attr_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/ColouredDerivedAttr.ump","gv/ColouredDerivedAttr.gv.txt");
	}
	
	@Test
	public void Hidden_Attr_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/HiddenAttrEntity.ump","gv/HiddenAttrEntity.gv.txt");
	}

	// No name
	@Test
	public void Relationship_One_One_Name_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/Relationship11.ump","gv/Relationship11.gv.txt");
	}
	
	// Left name
	@Test
	public void Relationship_One_N_Name_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/Relationship1N.ump","gv/Relationship1N.gv.txt");
	}
	
	// Right name
	@Test
	public void Relationship_N_One_Name_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/RelationshipN1.ump","gv/RelationshipN1.gv.txt");
	}
	
	// Same name for left and right
	@Test
	public void Relationship_N_N_Name_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/RelationshipNN.ump","gv/RelationshipNN.gv.txt");
	}
	
	// Different names for left and right
	@Test
	public void Relationship_Range_Name_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/RelationshipRange.ump","gv/RelationshipRange.gv.txt");
	}
	
	// Different names for left and right
	@Test
	public void Relationship_Reflexive_Name_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/RelationshipReflexive.ump","gv/RelationshipReflexive.gv.txt");
	}

	@Test
	public void Relationship_Attributes_Test() {
		language = null;
	    assertUmplePartialTemplateFor("gv/RelationshipAttributes.ump","gv/RelationshipAttributes.gv.txt");
	}	
}
