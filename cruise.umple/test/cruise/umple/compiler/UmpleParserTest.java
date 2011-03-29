package cruise.umple.compiler;

import java.io.File;
import java.util.*;

import org.junit.*;

import cruise.umple.util.*;

public class UmpleParserTest
{

  UmpleParser parser;
  UmpleModel model;
  String pathToInput;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
  }

  @Test
  public void empty()
  {
    assertParse("001_empty.ump", "");
  }
  
  @Test
  public void languageDefault()
  {
    assertParse("001_empty.ump", "");
    Assert.assertEquals("Java", model.getDefaultGenerate());
  }
  
  @Test
  public void javaLanguage()
  {
    assertParse("001_javaLanguage.ump","[generate:Java]");
    Assert.assertEquals("Java", model.getDefaultGenerate());
  }

  @Test
  public void phpLanguage()
  {
    assertParse("001_phpLanguage.ump","[generate:Php]");
    Assert.assertEquals("Php", model.getDefaultGenerate());
  }

  @Test
  public void otherLanguage()
  {
    assertFailedParse("001_otherLanguage.ump", new Position(1,9,9));
  }
  
  @Test
  public void namespace()
  {
    assertParse("002_namespace.ump", "[namespace:cruise][namespace:cruise.umple][namespace:example]");
    Assert.assertEquals("cruise",model.getDefaultNamespace());
    
  }

  @Test
  public void invalidNamespace_noName()
  {
    assertFailedParse("002_invalidNamespace_noName.ump", new Position(1,10,10));
  }

  @Test
  public void emptyClass()
  {
    assertParse("003_emptyClass.ump", "[classDefinition][name:Student]");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Student",aClass.getName());
    Assert.assertEquals(false,aClass.getKey().isProvided());
  }
  
  @Test
  public void innerClass()
  {
    assertParse("003_innerClass.ump", "[classDefinition][name:Person][attribute][name:name][classDefinition][name:Student][attribute][name:Integer]");
    UmpleClass person = model.getUmpleClass("Person");
    Assert.assertEquals("Person",person.getName());
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(person,student.getExtendsClass());
    Assert.assertEquals("Student",student.getName());
    
  }  
  
  @Test
  public void unknownClass()
  {
    assertFailedParse("003_unknownClass.ump", new Position(5,9,27));
  }
  
  @Test
  public void commentsInClass()
  {
    assertParse("003_commentsInClass.ump", "[classDefinition][name:Student][inlineComment:A name][attribute][name:name][inlineComment:the time][attribute][type:Time][name:t]");
  }
  
  @Test
  public void depend()
  {
    assertParse("004_depend.ump", "[classDefinition][name:Student][depend:java.util.Map]");
    UmpleClass aClass = model.getUmpleClass("Student");
    
    Assert.assertEquals(1,aClass.numberOfDepends());
    Assert.assertEquals("java.util.Map", aClass.getDepend(0).getName());
  }  

  @Test
  public void multipleClasses()
  {
    assertParse("004_multipleClasses.ump", "[classDefinition][name:Student][classDefinition][name:Mentor]");
  }

  @Test
  public void classAndNamespaces()
  {
    assertParse("004_multipleClassesAndNamespaces.ump", "[namespace:cruise.util][classDefinition][name:Student][namespace:cruise.core][classDefinition][name:Mentor]");

    UmpleClass studentClass = model.getUmpleClass("Student");
    Assert.assertEquals("cruise.util",studentClass.getPackageName());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals("cruise.core",mentorClass.getPackageName());

  }
  
  @Test
  public void referencedPackages()
  {
    assertParse("004_referencedPackages.ump", "[namespace:example][classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:0][upperBound:1][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][namespace:anotherExample][classDefinition][name:Mentor]");

    UmpleClass studentClass = model.getUmpleClass("Student");
    String[] referenced = studentClass.getNamespaces();
    Assert.assertEquals(1,referenced.length);
    Assert.assertEquals("anotherExample", referenced[0]);
    
    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    referenced = mentorClass.getNamespaces();
    Assert.assertEquals(1,referenced.length);
    Assert.assertEquals("example", referenced[0]);
  }

  @Test
  public void isA()
  {
    assertParse("007_isA.ump", "[classDefinition][name:Student][extendsName:Person][classDefinition][name:Person]");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Person",aClass.getExtendsClass().getName());
    Assert.assertEquals(false,aClass.isRoot());
  }
  
  @Test
  public void implementsInterface()
  {
    assertParse("007_implements.ump", "[classDefinition][name:Student][implementsName:IStudent][interfaceDefinition][name:IStudent]");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("IStudent",aClass.getParentInterface(0).getName());
  }
 
  @Test
  public void implementsMultipleInterfaces()
  {
	  String expectedResult = "[classDefinition][name:Student]" +
	  		"[implementsName:IStudent][implementsName:IPerson][implementsName:IMan]" +
	  		"[interfaceDefinition][name:IStudent]" +
	  		"[interfaceDefinition][name:IPerson]" +
	  		"[interfaceDefinition][name:IMan]";
    assertParse("007_implementsMultipleInterfaces.ump", expectedResult);
    UmpleClass aClass = model.getUmpleClass("Student");
    
    Assert.assertEquals("IStudent",aClass.getParentInterface(0).getName());
    Assert.assertEquals("IPerson",aClass.getParentInterface(1).getName());
    Assert.assertEquals("IMan",aClass.getParentInterface(2).getName());
  }
  
  @Test
  public void implementsMultipleInterfacesAndIsA()
  {
    String expectedResult = "[classDefinition][name:Student][extendsName:Human]" +
	  		"[implementsName:IStudent][implementsName:IPerson][implementsName:IMan]" +
	  		"[interfaceDefinition][name:IStudent]" +
	  		"[interfaceDefinition][name:IPerson]" +
	  		"[interfaceDefinition][name:IMan]" +
	  		"[classDefinition][name:Human]";
    assertParse("007_implementsMultipleInterfacesIsA.ump", expectedResult);
    UmpleClass aClass = model.getUmpleClass("Student");
    // EXTENDS
    Assert.assertEquals("Human",aClass.getExtendsClass().getName());
    // IMPLEMENTS
    Assert.assertEquals("IStudent",aClass.getParentInterface(0).getName());
    Assert.assertEquals("IPerson",aClass.getParentInterface(1).getName());
    Assert.assertEquals("IMan",aClass.getParentInterface(2).getName());
    // Root?
    Assert.assertEquals(false,aClass.isRoot());
  }
  
  
  @Test
  public void isAGrouped()
  {
    assertParse("007_isAGrouped.ump", "[classDefinition][name:Student][extendsName:Person][classDefinition][name:Student][classDefinition][name:Person]");
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Person",aClass.getExtendsClass().getName());
    Assert.assertEquals(false,aClass.isRoot());
  }

  @Test
  public void singleton()
  {
    assertParse("007_singleton.ump", "[classDefinition][name:Airline][singleton:singleton]");
    UmpleClass aClass = model.getUmpleClass("Airline");
    Assert.assertEquals(true,aClass.getIsSingleton());
  }

  @Test
  public void isABlahAttribute()
  {
    assertParse("008_isABlahAttribute.ump", "[classDefinition][name:Student][attribute][type:Boolean][name:isActNow]");
    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable = aClass.getAttribute("isActNow");
    Assert.assertEquals("isActNow", variable.getName());
    Assert.assertEquals(false, variable.getIsList());
  }  
  
  @Test
  public void attribute_simple()
  {
    assertParse("008_simpleAttribute.ump", "[classDefinition][name:Student][attribute][name:number]");
    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable = aClass.getAttribute("number");
    Assert.assertEquals("number", variable.getName());
    Assert.assertEquals(false, variable.getIsList());
  }

  @Test
  public void attribute_list()
  {
    assertParse("008_listAttribute.ump", "[classDefinition][name:Token][attribute][list:[]][name:blah][attribute][type:String][list:[]][name:name][attribute][type:Position][list:[]][name:start][attribute][type:Integer][list:[]][name:number][classDefinition][name:Position][attribute][type:Integer][name:lineNumber][attribute][type:Integer][name:offset]");
    UmpleClass aClass = model.getUmpleClass("Token");
    Attribute variable = aClass.getAttribute("name");
    Assert.assertEquals("name", variable.getName());
    Assert.assertEquals("String", variable.getType());
    Assert.assertEquals(true, variable.getIsList());

    Attribute blah = aClass.getAttribute("blah");
    Assert.assertEquals("blah", blah.getName());
    Assert.assertEquals("String", blah.getType());
    Assert.assertEquals(true, blah.getIsList());
  }

  @Test
  public void attribute_derived()
  {
    assertParse("008_derivedAttribute.ump", "[classDefinition][name:Position][attribute][type:Integer][name:perimeter][derivedValue:2*l + 2*w][attribute][type:Integer][name:w][attribute][type:Integer][name:l]");

    UmpleClass aClass = model.getUmpleClass("Position");
    Attribute variable = aClass.getAttribute("perimeter");
    Assert.assertEquals("perimeter", variable.getName());
    Assert.assertEquals("Integer", variable.getType());
    Assert.assertEquals(false, variable.getIsList());
    Assert.assertEquals("2*l + 2*w",variable.getValue());
    Assert.assertEquals(true, variable.getIsDerived());

    variable = aClass.getAttribute("l");
    Assert.assertEquals("l", variable.getName());
    Assert.assertEquals("Integer", variable.getType());
    Assert.assertEquals(false, variable.getIsList());
    Assert.assertEquals(false, variable.getIsDerived());

  }
  
  @Test
  public void attribute_defaultedWithoutAValue()
  {
    assertFailedParse("008_defaultWithoutValue.ump", new Position(4,2,19));
  }
  
  @Test
  public void association_attribute()
  {
    assertParse("008_associationAttribute.ump", "[classDefinition][name:Token][attribute][name:number][attribute][type:Position][name:startPosition][classDefinition][name:Position][attribute][type:Integer][name:lineNumber][attribute][type:Integer][name:offset]");
    UmpleClass aClass = model.getUmpleClass("Token");
    Attribute variable = aClass.getAttribute("startPosition");
    Assert.assertEquals("startPosition", variable.getName());
    Assert.assertEquals("Position", variable.getType());
  }  
  
  @Test @Ignore
  public void complexClassWithAssociationsCannotBeAttribute()
  {
    assertFailedParse("008_complexAttribute.ump", new Position(5,2,10));
  }

  @Test
  public void attribute_Type()
  {
    assertParse("008_typeAttribute.ump", "[classDefinition][name:Student][attribute][type:Integer][name:name][attribute][type:String][name:name2][attribute][type:Time][name:name3][attribute][type:Date][name:name4][attribute][type:Double][name:name5]");
    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable;
    
    variable = aClass.getAttribute("name");
    Assert.assertEquals("name", variable.getName());
    Assert.assertEquals("Integer", variable.getType());
    
    variable = aClass.getAttribute("name2");
    Assert.assertEquals("name2", variable.getName());
    Assert.assertEquals("String", variable.getType());
    
    variable = aClass.getAttribute("name3");
    Assert.assertEquals("name3", variable.getName());
    Assert.assertEquals("Time", variable.getType());

    variable = aClass.getAttribute("name4");
    Assert.assertEquals("name4", variable.getName());
    Assert.assertEquals("Date", variable.getType());

    variable = aClass.getAttribute("name5");
    Assert.assertEquals("name5", variable.getName());
    Assert.assertEquals("Double", variable.getType());
  }

  @Test
  public void attribute_Unique()
  {
    assertParse("008_uniqueAttribute.ump", "[classDefinition][name:Student][attribute][unique:unique][name:number]");
    UmpleClass aClass = model.getUmpleClass("Student");
    UmpleVariable variable = aClass.getUniqueIdentifier();
    Assert.assertEquals("number", variable.getName());
  }

  @Test
  public void attribute_assignedValue()
  {
    assertParse("008_assignedValueAttribute.ump", "[classDefinition][name:Student][attribute][unique:unique][type:Integer][name:number][value:1][attribute][modifier:settable][type:String][name:s][value:\"s\"][attribute][name:s2][value:\"s2\"]");
    UmpleClass aClass = model.getUmpleClass("Student");
    UmpleVariable variable;
    
    variable = aClass.getUniqueIdentifier();
    Assert.assertEquals("number", variable.getName());    
    Assert.assertEquals("1", variable.getValue());

    variable = aClass.getAttribute("s");
    Assert.assertEquals("\"s\"", variable.getValue());

    variable = aClass.getAttribute("s2");
    Assert.assertEquals("\"s2\"", variable.getValue());
  }

  @Test
  public void attribute_autounique()
  {
    assertParse("008_autouniqueAttribute.ump", "[classDefinition][name:Student][attribute][autounique:autounique][name:id]");

    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable = aClass.getAttribute("id");
    Assert.assertEquals(true,variable.getIsAutounique());
    Assert.assertEquals("Integer",variable.getType());
  }
  
  @Test
  public void attributeComplexAssigned()
  {
    assertParse("008_complexAssignedAttribute.ump", "[classDefinition][name:Student][attribute][type:Time][name:t][value:new Time(\"now\")]");

    UmpleClass aClass = model.getUmpleClass("Student");
    Attribute variable = aClass.getAttribute("t");
    Assert.assertEquals("new Time(\"now\")",variable.getValue());
  }
  
  @Test
  public void associationName()
  {
    assertParse("009_externalNamedAssociation.ump", "[classDefinition][name:Student][classDefinition][name:Mentor][associationDefinition][name:Counsellor][association][associationEnd][lowerBound:4][upperBound:5][type:Student][arrow:--][associationEnd][lowerBound:6][upperBound:9][type:Mentor]");
    
    Association as = model.getAssociation(0);
    Assert.assertEquals("Counsellor",as.getName());
  }

  @Test
  public void associationWithUnknownClass()
  {
    assertFailedParse("009_associationWithUnknownClass.ump", new Position(7,15,53));
  }
  
  @Test
  public void externalAssociationWithUnknownClass()
  {
    assertFailedParse("009_externalAssociationWithUnknownClass.ump", new Position(6,23,58));
  }
  
  @Test
  public void association()
  {
    assertParse("009_association.ump", "[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:2][upperBound:3][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][roleName:aMentor][inlineAssociation][inlineAssociationEnd][bound:*][roleName:me][arrow:--][associationEnd][bound:*][type:Student][roleName:them][classDefinition][name:Mentor]");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("aMentor");
    Assert.assertEquals(0,variable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,variable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Mentor",variable.getType());
    Assert.assertEquals("aMentor",variable.getName());
    Assert.assertEquals(true,variable.getIsNavigable());
    
    AssociationVariable relatedVariable = variable.getRelatedAssociation();
    Assert.assertEquals(2,relatedVariable.getMultiplicity().getLowerBound());
    Assert.assertEquals(3,relatedVariable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Student",relatedVariable.getType());
    Assert.assertEquals("students",relatedVariable.getName());
    Assert.assertEquals(true,relatedVariable.getIsNavigable());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals(relatedVariable, mentorClass.getAssociationVariable("students"));
    Assert.assertEquals(variable, mentorClass.getAssociationVariable("students").getRelatedAssociation());

    
    List<Association> iter = model.getAssociations();
    Assert.assertEquals(2,iter.size());
    Association one = iter.get(0);
    Association two = iter.get(1);
    
    Assert.assertEquals(2,one.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(3,one.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("students",one.getEnd(0).getRoleName());
    Assert.assertEquals("Student",one.getEnd(0).getClassName());
    Assert.assertEquals("Mentor",one.getEnd(0).getReferenceToClassName());

    Assert.assertEquals(0,one.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(1,one.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("aMentor",one.getEnd(1).getRoleName());
    Assert.assertEquals("Mentor",one.getEnd(1).getClassName());
    Assert.assertEquals("Student",one.getEnd(1).getReferenceToClassName());
    
    Assert.assertEquals(0,two.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,two.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("me",two.getEnd(0).getRoleName());
    Assert.assertEquals("Student",two.getEnd(0).getClassName());
    Assert.assertEquals("Student",two.getEnd(0).getReferenceToClassName());

    Assert.assertEquals(0,two.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,two.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("them",two.getEnd(1).getRoleName());
    Assert.assertEquals("Student",two.getEnd(1).getClassName());
    Assert.assertEquals("Student",two.getEnd(1).getReferenceToClassName());
  }
  
  @Test
  public void association_invalidMultiplicityOutOfOrder()
  {
    assertFailedParse("009_association_multiplicityOutOfOrder.ump", new Position(4,2,19));
  }  

  @Test
  public void association_external()
  {
    assertParse("009_externalAssociation.ump", "[classDefinition][name:Student][classDefinition][name:Mentor][associationDefinition][association][associationEnd][lowerBound:4][upperBound:5][type:Student][arrow:--][associationEnd][lowerBound:6][upperBound:9][type:Mentor][roleName:myMentor][association][associationEnd][bound:*][type:Student][roleName:me][arrow:--][associationEnd][bound:*][type:Student][roleName:them]");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("myMentor");
    Assert.assertEquals(6,variable.getMultiplicity().getLowerBound());
    Assert.assertEquals(9,variable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Mentor",variable.getType());
    Assert.assertEquals("myMentor",variable.getName());
    Assert.assertEquals(true,variable.getIsNavigable());
    
    AssociationVariable relatedVariable = variable.getRelatedAssociation();
    Assert.assertEquals(4,relatedVariable.getMultiplicity().getLowerBound());
    Assert.assertEquals(5,relatedVariable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Student",relatedVariable.getType());
    Assert.assertEquals("students",relatedVariable.getName());
    Assert.assertEquals(true,relatedVariable.getIsNavigable());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals(relatedVariable, mentorClass.getAssociationVariable("students"));
    Assert.assertEquals(variable, mentorClass.getAssociationVariable("students").getRelatedAssociation());

    List<Association> iter = model.getAssociations();
    Assert.assertEquals(2,iter.size());
    Association one = iter.get(0);
    Association two = iter.get(1);
    
    Assert.assertEquals(4,one.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(5,one.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("students",one.getEnd(0).getRoleName());
    Assert.assertEquals("Student",one.getEnd(0).getClassName());
    Assert.assertEquals("Mentor",one.getEnd(0).getReferenceToClassName());

    Assert.assertEquals(6,one.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(9,one.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("myMentor",one.getEnd(1).getRoleName());
    Assert.assertEquals("Mentor",one.getEnd(1).getClassName());
    Assert.assertEquals("Student",one.getEnd(1).getReferenceToClassName());
    
    Assert.assertEquals(0,two.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,two.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("me",two.getEnd(0).getRoleName());
    Assert.assertEquals("Student",two.getEnd(0).getClassName());
    Assert.assertEquals("Student",two.getEnd(0).getReferenceToClassName());

    Assert.assertEquals(0,two.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,two.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("them",two.getEnd(1).getRoleName());
    Assert.assertEquals("Student",two.getEnd(1).getClassName());
    Assert.assertEquals("Student",two.getEnd(1).getReferenceToClassName());
  }

  @Test
  public void oneWayAssociation()
  {
    assertParse("009_oneWayAssociation.ump", "[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:0][upperBound:1][arrow:->][associationEnd][lowerBound:0][upperBound:1][type:Mentor][classDefinition][name:Mentor]");

    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("mentor");
    Assert.assertEquals(0,variable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,variable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Mentor",variable.getType());
    Assert.assertEquals("mentor",variable.getName());
    Assert.assertEquals(true,variable.getIsNavigable());
    
    AssociationVariable relatedVariable = variable.getRelatedAssociation();
    Assert.assertEquals(0,relatedVariable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,relatedVariable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Student",relatedVariable.getType());
    Assert.assertEquals("student",relatedVariable.getName());
    Assert.assertEquals(false,relatedVariable.getIsNavigable());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals(relatedVariable, mentorClass.getAssociationVariable("student"));
    Assert.assertEquals(variable, mentorClass.getAssociationVariable("student").getRelatedAssociation());

  }
  
  @Test
  public void otherWayAssociation()
  {
    assertParse("009_otherWayAssociation.ump", "[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][lowerBound:0][upperBound:1][arrow:<-][associationEnd][lowerBound:0][upperBound:1][type:Mentor][classDefinition][name:Mentor]");

    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("mentor");
    Assert.assertEquals(0,variable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,variable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Mentor",variable.getType());
    Assert.assertEquals("mentor",variable.getName());
    Assert.assertEquals(false,variable.getIsNavigable());
    
    AssociationVariable relatedVariable = variable.getRelatedAssociation();
    Assert.assertEquals(0,relatedVariable.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,relatedVariable.getMultiplicity().getUpperBound());
    Assert.assertEquals("Student",relatedVariable.getType());
    Assert.assertEquals("student",relatedVariable.getName());
    Assert.assertEquals(true,relatedVariable.getIsNavigable());

    UmpleClass mentorClass = model.getUmpleClass("Mentor");
    Assert.assertEquals(relatedVariable, mentorClass.getAssociationVariable("student"));
    Assert.assertEquals(variable, mentorClass.getAssociationVariable("student").getRelatedAssociation());

  }  
  
  @Test
  public void association_nonZeroReflexiveAssociation()
  {
    assertFailedParse("009_nonZeroReflexiveAssociation.ump", new Position(5,10,28));
  }  

  

  @Test
  public void symmetricReflexiveAssociation()
  {
    assertParse("009_reflexiveSymmetricAssociation.ump", "[classDefinition][name:Student][symmetricReflexiveAssociation][lowerBound:0][upperBound:1][roleName:partner]");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    AssociationVariable variable = aClass.getAssociationVariable("partner");
    
    Assert.assertEquals(true,variable.isSymmetricReflexive());
  }

  @Test
  public void associationByItself()
  {
    assertParse("009_associationByItself.ump", "[associationDefinition][association][associationEnd][lowerBound:0][upperBound:1][type:Student][roleName:aStudent][arrow:--][associationEnd][lowerBound:0][upperBound:1][type:Mentor][roleName:aMentor][association][associationEnd][bound:*][type:Event][arrow:--][associationEnd][bound:*][type:Location][classDefinition][name:Event][classDefinition][name:Location][classDefinition][name:Student][classDefinition][name:Mentor]");

    List<Association> iter = model.getAssociations();
    Assert.assertEquals(2,iter.size());
    Association one = iter.get(0);
    Association two = iter.get(1);
    
    Assert.assertEquals(0, one.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(1, one.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("aStudent", one.getEnd(0).getRoleName());
    Assert.assertEquals("Student", one.getEnd(0).getClassName());
    Assert.assertEquals(0, one.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(1, one.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("aMentor", one.getEnd(1).getRoleName());
    Assert.assertEquals("Mentor", one.getEnd(1).getClassName());
    Assert.assertEquals(true, one.getIsLeftNavigable());
    Assert.assertEquals(true, one.getIsRightNavigable());
    
    Assert.assertEquals(0, two.getEnd(0).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1, two.getEnd(0).getMultiplicity().getUpperBound());
    Assert.assertEquals("events", two.getEnd(0).getRoleName());
    Assert.assertEquals("Event", two.getEnd(0).getClassName());
    Assert.assertEquals(0, two.getEnd(1).getMultiplicity().getLowerBound());
    Assert.assertEquals(-1, two.getEnd(1).getMultiplicity().getUpperBound());
    Assert.assertEquals("locations", two.getEnd(1).getRoleName());
    Assert.assertEquals("Location", two.getEnd(1).getClassName());
    Assert.assertEquals(true, two.getIsLeftNavigable());
    Assert.assertEquals(true, two.getIsRightNavigable());
  
  }

  @Test
  public void associationClass2()
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, "010_associationClass2.ump"));
    parser = new UmpleParser();
    boolean answer = parser.parse("associationClassDefinition", input).getWasSuccess();
    Assert.assertEquals(true,answer);
  }
  
  @Test
  public void associationClassMultipleDefinitions()
  {
	assertParse("010_associationClassMultipleDefinitions.ump", "[associationClassDefinition][name:Relationship][singleAssociationEnd][bound:*][type:Student][singleAssociationEnd][bound:*][type:Mentor][classDefinition][name:Student][classDefinition][name:Mentor][classDefinition][name:Relationship][elementPosition][x:1][y:2][width:3][height:4]");
	UmpleClass associationClass = model.getUmpleClass("Relationship");
    Coordinate position = new Coordinate(1,2,3,4);
      
	Assert.assertEquals(position.getX(), associationClass.getPosition().getX());
    Assert.assertEquals(position.getY(), associationClass.getPosition().getY());
    Assert.assertEquals(position.getWidth(), associationClass.getPosition().getWidth());
    Assert.assertEquals(position.getHeight(), associationClass.getPosition().getHeight());
  }
  
  @Test
  public void associationClassAdditionalAssociations()
  {
    assertParse("010_associationClassOtherAssociations.ump", "[associationClassDefinition][name:VotesInPoll][singleAssociationEnd][bound:*][type:Candidature][singleAssociationEnd][bound:*][type:PollInElection][inlineAssociation][inlineAssociationEnd][bound:*][arrow:--][associationEnd][bound:*][type:Location][classDefinition][name:Candidature][classDefinition][name:PollInElection][classDefinition][name:Location]");
    
    UmpleClass votes = model.getUmpleClass("VotesInPoll");
    Assert.assertEquals(3,votes.numberOfAssociationVariables());
      
  }
  
  @Test
  public void associationClassMissingLeft()
  {
    assertFailedParse("010_associationClassMissingLeft.ump", new Position(2,0,1));
  }  
  
  @Test
  public void associationClassMissingRight()
  {
    assertFailedParse("010_associationClassMissingRight.ump", new Position(2,0,1));
  }
  
  @Test
  public void associationClass()
  {
    assertParse("010_associationClass.ump", "[namespace:example][classDefinition][name:Thing][associationClassDefinition][name:Ticket][extendsName:Thing][attribute][name:name][attribute][type:Integer][name:type][value:1][singleAssociationEnd][bound:*][type:Event][roleName:event][singleAssociationEnd][bound:*][type:Location][extraCode:public int one() {return 1;}][classDefinition][name:Event][classDefinition][name:Location]");

    UmpleClass aClass = model.getUmpleClass("Ticket");
    
    Assert.assertEquals("example",aClass.getPackageName());
    Assert.assertEquals("Thing", aClass.getExtendsClass().getName());
    Assert.assertEquals("public int one() {return 1;}",aClass.getExtraCode());
    Assert.assertEquals("name",aClass.getAttribute("name").getName());
    Assert.assertEquals("type",aClass.getAttribute("type").getName());
    
    AssociationVariable av1 = aClass.getAssociationVariable("event");
    Assert.assertEquals(0,av1.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,av1.getMultiplicity().getUpperBound());
    Assert.assertEquals("event",av1.getName());
    Assert.assertEquals("Event", av1.getType());
    
    AssociationVariable relatedAv1 = av1.getRelatedAssociation();
    Assert.assertEquals(0,relatedAv1.getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,relatedAv1.getMultiplicity().getUpperBound());
    Assert.assertEquals("tickets",relatedAv1.getName());
    Assert.assertEquals("Ticket", relatedAv1.getType());
    
    AssociationVariable av2 = aClass.getAssociationVariable("location");
    Assert.assertEquals(0,av2.getMultiplicity().getLowerBound());
    Assert.assertEquals(1,av2.getMultiplicity().getUpperBound());
    Assert.assertEquals("location",av2.getName());
    Assert.assertEquals("Location", av2.getType());
    
    AssociationVariable relatedAv2 = av2.getRelatedAssociation();
    Assert.assertEquals(0,relatedAv2.getMultiplicity().getLowerBound());
    Assert.assertEquals(-1,relatedAv2.getMultiplicity().getUpperBound());
    Assert.assertEquals("tickets",relatedAv2.getName());
    Assert.assertEquals("Ticket", relatedAv2.getType());
    
    List<Association> iter = model.getAssociations();
    Assert.assertEquals(2,iter.size());
  }

  @Test
  public void inlineComments()
  {
    assertParse("013_inlineComments.ump", "[inlineComment:c 5][inlineComment:c 5b][namespace:example][inlineComment:c 6][inlineComment:c 7][inlineComment:c 7b][inlineComment:c 7c]");
  }

  @Test
  public void multilineComments()
  {
    assertParse("013_multilineComments.ump", "[multilineComment:c 1\n  c 1b][multilineComment:c 1c\n  c 1d][multilineComment:c 2][multilineComment:c 2b\n  c 2c][multilineComment:c 2d\n  c 2e][multilineComment:c 2f\n  c 2g][multilineComment:c 3][multilineComment:c 3b\n  c 3c][namespace:example][multilineComment:c 4][multilineComment:c 4b\n  c 4c][multilineComment:c 4d\n  c 4e]");
  }
   
  @Test
  public void attributesAndAssocations()
  {
    assertParse("012_attributesAndAssociations.ump", "[namespace:example][classDefinition][name:Mentor][attribute][name:name][inlineAssociation][inlineAssociationEnd][bound:*][arrow:->][associationEnd][bound:*][type:Student][classDefinition][name:Student][attribute][name:number]");
  }

  /* Test to verify the isA relationship between classes and Interfaces*/
  @Test
  public void interfaceImplementation()
  {
	assertParse("014_interface_implementation.ump", "[interfaceDefinition][name:ISomething][classDefinition][name:Something][implementsName:ISomething]");
	   
    UmpleClass aClass = model.getUmpleClass("Something");
    Assert.assertEquals("ISomething",aClass.getParentInterface(0).getName());

  }
  
  /* Test to verify the the methods inside an Interface*/
  @Test
  public void interfaceWithMethodAndParameters()
  {
	assertParse("014_interface_methodAndParam.ump", "[interfaceDefinition][name:ISomething][interfaceMemberDeclaration][abstractMethodDeclaration][type:String[]][methodDeclarator][methodName:getMethod][parameterList][parameter][type:String][list:[]][name:aname][parameter][type:Integer][name:anotherType]");
  }
  
  @Test
  public void interfaceWithPosition()
  {
	assertParse("014_interface_position.ump", "[interfaceDefinition][name:ISomething][interfaceMemberDeclaration][elementPosition][x:10][y:20][width:30][height:40]");
  }
  
  /* Test to verify the the methods WITH NO parameters inside an Interface*/
  @Test
  public void interfaceWithMethodAndNOTParameters()
  {
	assertParse("014_interface_methodNoParam.ump","[interfaceDefinition][name:I_Something][interfaceMemberDeclaration][abstractMethodDeclaration][type:String][methodDeclarator][methodName:getSomething][parameterList]");
  }
  
  
  /* Test to verify the the constants inside an Interface*/
  @Test
  public void interfaceWithConstants()
  {
	assertParse("014_interface_constant.ump", "[interfaceDefinition][name:ISomething][interfaceMemberDeclaration][constantDeclaration][type:String][name:aVariable][value:aValue]");
  }
  
  /* Test to verify all Members (Constants and Methods)  inside an Interface*/
  @Test
  public void interfaceWithMultipleMembers()
  {
    String parseResult = "[interfaceDefinition][name:ISomething][interfaceMemberDeclaration][constantDeclaration][type:String][name:aVariable][value:aValue]" +
    					 "[interfaceMemberDeclaration][constantDeclaration][type:String][name:aSecondVariable][value:aSecondValue]"+
    					 "[interfaceMemberDeclaration][abstractMethodDeclaration][type:String][methodDeclarator][methodName:getMethod][parameterList][parameter][type:String][name:name]";
	assertParse("014_interface_allMembers.ump", parseResult);
  }
  @Test
  public void interfaceClassDepend()
  {
    assertParse("014_interfaceDepend.ump", "[interfaceDefinition][name:IMe][depend:java.util.*]");
    
    UmpleInterface aInterface = model.getUmpleInterface("IMe");
    Assert.assertEquals(1,aInterface.numberOfDepends());
    Assert.assertEquals("java.util.*", aInterface.getDepend(0).getName());
  }  
  
  /* Test to verify extra code inside interfaces*/
  @Test
  public void interfaceWithExtraCode()
  {
	assertParse("014_interface_extracode.ump", "[interfaceDefinition][name:ISomething][interfaceMemberDeclaration][extraCode:public void getCode();]");
  }
  
  /* Test to verify extra code inside interfaces*/
  public void classWithImplementedMethods()
  {
	assertParse("015_ClassWithImplementedMethods.ump", "[interfaceDefinition][name:ISomething][interfaceMemberDeclaration][extraCode:public void getCode();]");
  }
  
  
  @Test
  public void mixDifferentFiles()
  {
    assertParse("015_base.ump", "[use:015_Student.ump][use:015_Mentor.ump][classDefinition][name:Student][use:015_Student.ump][classDefinition][name:Mentor][extendsName:Student]");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Student",aClass.getName());

    aClass = model.getUmpleClass("Mentor");
    Assert.assertEquals("Mentor",aClass.getName());
  }
  
  @Test
  public void classPosition()
  {
    assertParse("016_classPosition.ump", "[classDefinition][name:Student][elementPosition][x:10][y:20][width:30][height:40]");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Student",aClass.getName());
    Assert.assertEquals(new Coordinate(10,20,30,40),aClass.getPosition());
  }
  
  @Test
  public void classPosition_default()
  {
    assertParse("016_defaultClassPosition.ump", "[classDefinition][name:Student][elementPosition][x:10][y:20][width:30][height:40]");
    
    UmpleClass aClass = model.getUmpleClass("Student");
    Assert.assertEquals("Student",aClass.getName());
    Assert.assertEquals(new Coordinate(10,20,30,40),aClass.getPosition());
  }  
  
  @Test
  public void positionAssociation()
  {
    assertParse("016_associationPosition.ump", "[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][bound:1][arrow:--][associationEnd][bound:*][type:Mentor][elementPosition][x:10][y:20][width:30][height:40][associationPosition][name:Mentor__Student][coordinate][x:1][y:2][coordinate][x:3][y:4][classDefinition][name:Mentor]");
    
    Association assoc = model.getAssociations().get(0);
    Assert.assertEquals("Mentor__Student",assoc.getName());
    Assert.assertEquals(2, assoc.numberOfPositions());
    Assert.assertEquals(new Coordinate(1,2,0,0), assoc.getPosition(0));
    Assert.assertEquals(new Coordinate(3,4,0,0), assoc.getPosition(1));
  }  

  @Test @Ignore
  public void positionAssociationClass_Mixin()
  {
    assertParse("016_associationClassMixinPosition.ump", "");
    
    Assert.assertEquals(3, model.numberOfUmpleClasses());
    
    UmpleClass aClass = model.getUmpleClass("Relationship");
    Assert.assertEquals("Relationship",aClass.getName());
    Assert.assertEquals(new Coordinate(10,20,30,40),aClass.getPosition());
    
 // make sure that "isWellDefined" is true
  } 

  @Test @Ignore
  public void positionAssociationClass_NoAssociation()
  {
    assertParse("016_associationClassRelationshipNotDefined.ump", "fill_me_in");
    
    // fill me in with checks
    // make sure that "isWellDefined" is false
  } 
  
  @Test
  public void positionUnknownAssociation()
  {
    assertParse("016_unknownAssociationPosition.ump", "[classDefinition][name:Student][elementPosition][x:10][y:20][width:30][height:40][associationPosition][name:Mentor__Student][coordinate][x:1][y:2][coordinate][x:3][y:4]");
    Assert.assertEquals(0, model.getAssociations().size());
  }  
  
  @Test
  public void associationClassPosition()
  {
    assertParse("016_associationClassPosition.ump", "[classDefinition][name:Student][inlineAssociation][inlineAssociationEnd][bound:1][arrow:--][associationEnd][bound:*][type:Mentor][elementPosition][x:1][y:2][width:3][height:4][associationPosition][name:Mentor__Student][coordinate][x:1][y:2][coordinate][x:3][y:4][classDefinition][name:Mentor][associationClassDefinition][name:Relationship][singleAssociationEnd][bound:*][type:Student][singleAssociationEnd][bound:*][type:Mentor][elementPosition][x:10][y:20][width:30][height:40]");
    
    UmpleClass aClass = model.getUmpleClass("Relationship");
    Assert.assertEquals("Relationship",aClass.getName());
    Assert.assertEquals(new Coordinate(10,20,30,40),aClass.getPosition());
  }  
  
  @Test
  public void glossary()
  {
    assertParse("017_glossary.ump","[glossary][word][singular:entity][plural:entities]");
    Glossary g = model.getGlossary();
    Assert.assertEquals("entities",g.getPlural("entity"));
    Assert.assertEquals("entity",g.getSingular("entities"));
  }

  @Test
  public void cannotHaveDuplicateKeys()
  {
    assertFailedParse("018_cannotHaveDuplicateKeys.ump",new Position(8,2,55));
  }

  @Test
  public void cannotHaveKeyAndDefaultKey()
  {
    assertFailedParse("018_cannotHaveKeyAndDefaultKey.ump",new Position(8,2,55));
  }  
  
  @Test
  public void key()
  {
    assertParse("018_key.ump","[classDefinition][name:Student][attribute][name:id][attribute][name:name][key][keyId:id][keyId:name][classDefinition][name:Mentor][attribute][name:employeeId][key][keyId:employeeId][extraCode:;][classDefinition][name:Course][attribute][name:code][defaultKey]");
    
    UmpleClass student = model.getUmpleClass("Student");
    Key key = student.getKey();
    Assert.assertEquals(true, key.isProvided());
    Assert.assertEquals(2,key.numberOfMembers());
    Assert.assertEquals("id",key.getMember(0));
    Assert.assertEquals("name",key.getMember(1));
    
    UmpleClass mentor = model.getUmpleClass("Mentor");
    key = mentor.getKey();
    Assert.assertEquals(true, key.isProvided());
    Assert.assertEquals(1,key.numberOfMembers());
    Assert.assertEquals("employeeId",key.getMember(0));
    
    UmpleClass course = model.getUmpleClass("Course");
    key = course.getKey();
    Assert.assertEquals(true, key.isProvided());
    Assert.assertEquals(0,key.numberOfMembers());
    Assert.assertEquals(true,key.getIsDefault());
  }
  
  @Test
  public void beforeKeyword()
  {
    assertParse("019_before.ump","[classDefinition][name:Student][attribute][name:name][beforeCode][operationName:setName][code:doSomething();]");

    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfCodeInjections());
    
    CodeInjection inject = student.getCodeInjection(0);
    Assert.assertEquals("before",inject.getType());
    Assert.assertEquals("setName",inject.getOperation());
    Assert.assertEquals("doSomething();",inject.getCode());
  }

  @Test
  public void afterKeyword()
  {
    assertParse("019_after.ump","[classDefinition][name:Student][attribute][name:name][afterCode][operationName:getName][code:notReallyPossible();]");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfCodeInjections());
    
    CodeInjection inject = student.getCodeInjection(0);
    Assert.assertEquals("after",inject.getType());
    Assert.assertEquals("getName",inject.getOperation());
    Assert.assertEquals("notReallyPossible();",inject.getCode());
  }

  @Test
  public void enumAttributeEmpty()
  {
    assertParse("020_enumEmpty.ump","[classDefinition][name:Student][stateMachine][enum][name:status]");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfStateMachines());
    StateMachine sm = student.getStateMachine(0);
    Assert.assertEquals("Simple",sm.getType());
  }

  @Test
  public void enumShortHandSyntax()
  {
    assertParse("020_enum.ump","[classDefinition][name:Student][stateMachine][enum][name:status][stateName:FullTime][stateName:PartTime][stateName:MidTime][stateMachine][enum][name:grade][stateName:High]");
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(2,student.numberOfStateMachines());
    StateMachine sm = student.getStateMachine(0);
    Assert.assertEquals("Simple",sm.getType());
    
    Assert.assertEquals(3,sm.numberOfStates());
    Assert.assertEquals("FullTime", sm.getState(0).getName());
    Assert.assertEquals("PartTime", sm.getState(1).getName());
    Assert.assertEquals("MidTime", sm.getState(2).getName());
  }

  @Test
  public void enumLongHandSyntax()
  {
    assertParse("020_enumLongHand.ump","[classDefinition][name:Student][stateMachine][inlineStateMachine][name:status][state][stateName:FullTime][state][stateName:PartTime]");
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(1,student.numberOfStateMachines());
    StateMachine sm = student.getStateMachine(0);
    Assert.assertEquals("Simple",sm.getType());
    
    Assert.assertEquals(2,sm.numberOfStates());
    Assert.assertEquals("FullTime", sm.getState(0).getName());
    Assert.assertEquals("PartTime", sm.getState(1).getName());
  }
  
  @Test
  public void nestedUseStatements()
  {
    assertParse("021_nestedUse.ump","[classDefinition][name:Student][attribute][name:fisrtName][use:021_nestedUse_B.ump][classDefinition][name:Student][attribute][name:lastName][use:021_nestedUse_C.ump][classDefinition][name:Student][attribute][name:middleName]");
    
    UmpleClass student = model.getUmpleClass("Student");
    Assert.assertEquals(3,student.numberOfAttributes());
    
  }

  private void assertParse(String filename, String expectedOutput)
  {
    assertParse(filename, expectedOutput, true);
  }

  private void assertFailedParse(String filename, Position expectedPosition)
  {
    assertParse(filename, "", false);
    Assert.assertEquals(expectedPosition, parser.getParseResult().getPosition());
  }

  private void assertParse(String filename, String expectedOutput, boolean expected)
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, filename));
    model = new UmpleModel(new UmpleFile(pathToInput,filename));
    model.setShouldGenerate(false);
    parser = new UmpleParser(model);
    boolean answer = parser.parse("program", input).getWasSuccess();
    
    if (answer)
    {
      answer = parser.analyze(false).getWasSuccess();
    }

    if (answer == false && expected)
    {
      System.out.println("failed at:" + parser.getParseResult().getPosition());
    }
    
    Assert.assertEquals(expected, answer);
    if (expected)
    {
      Assert.assertEquals(expectedOutput, parser.toString());  
    }
  }

}
