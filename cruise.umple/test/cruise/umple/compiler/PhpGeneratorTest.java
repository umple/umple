package cruise.umple.compiler;

import cruise.umple.compiler.php.*;

import org.junit.*;

public class PhpGeneratorTest
{

  UmpleModel model;
  PhpGenerator generator;

  @Before
  public void setUp()
  {
    model = new UmpleModel(null);
    generator = new PhpGenerator();
    generator.setModel(model);
  }
  
  @Test
  public void empty()
  {
    generator.prepare();
    
  }
  
  @Test
  public void addGeneratedClass()
  {
    UmpleClass c = model.addUmpleClass("Student");
    generator.prepare();
    Assert.assertEquals(true,c.getGeneratedClass() != null);
  }

  @Test
  public void addParentGeneratedClass()
  {
    UmpleClass parent = model.addUmpleClass("Person");
    UmpleClass c = model.addUmpleClass("Student");
    c.setExtendsClass(parent);
    
    generator.prepare();
    Assert.assertEquals(parent.getGeneratedClass(),c.getGeneratedClass().getParentClass());
  }
  
  @Test
  public void addSuperParentGeneratedClass()
  {
    UmpleClass parent = model.addUmpleClass("Parent");
    UmpleClass child = model.addUmpleClass("Child");
    child.setExtendsClass(parent);
    UmpleClass grandChild = model.addUmpleClass("GrandChild");
    grandChild.setExtendsClass(child);
    
    generator.prepare();
    Assert.assertEquals(parent.getGeneratedClass(),child.getGeneratedClass().getParentClass());
    Assert.assertEquals(child.getGeneratedClass(),grandChild.getGeneratedClass().getParentClass());
  }

  
  @Test
  public void emptyConstructor()
  {
    UmpleClass c = model.addUmpleClass("Student");
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
  }
  
  @Test
  public void attributesConstructor_single()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("name","Integer",null,null,false));
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("$aName",g.getLookup("constructorSignature"));
    Assert.assertEquals("$aName",g.getLookup("constructorSignature_caller"));
  }  
  
  @Test
  public void attributesConstructor_defaulted()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("name","Integer","defaulted",null,false));
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));
  }  
  
  @Test
  public void attributesConstructor_multiple()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("fname","Integer",null,null,false));
    c.addAttribute(new Attribute("lname","Integer",null,null,false));
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("$aFname, $aLname",g.getLookup("constructorSignature"));
    Assert.assertEquals("$aFname, $aLname",g.getLookup("constructorSignature_caller"));
  }  
  
  @Test
  public void attributesConstructor_ignore()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("hasValue","Integer",null,"1",false));
    c.addAttribute(new Attribute("isAutounique","Integer",null,null,true));
    c.addAttribute(new Attribute("isUnique","Integer","unique",null,true));

    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));
  }  

  @Test
  public void attributesConstructor_defaultedWithValue()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("name","String","defaulted","\"1\"",false));
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));
  }  
  

  @Test
  public void typeOf()
  {
    Assert.assertEquals("int",JavaGenerator.typeOf("Integer"));
    Assert.assertEquals("String",JavaGenerator.typeOf(""));
    Assert.assertEquals("String",JavaGenerator.typeOf(null));
    Assert.assertEquals("double",JavaGenerator.typeOf("Double"));
    Assert.assertEquals("boolean",JavaGenerator.typeOf("Boolean"));
    Assert.assertEquals("Blah",JavaGenerator.typeOf("Blah"));
  }
  
  @Test
  public void nameOf()
  {
    Assert.assertEquals("aName",generator.nameOf("name",false));
    Assert.assertEquals("allName",generator.nameOf("name",true));
    Assert.assertEquals("a",generator.nameOf("",false));
    Assert.assertEquals("all",generator.nameOf("",true));
    Assert.assertEquals(null,generator.nameOf(null,false));
    Assert.assertEquals(null,generator.nameOf(null,true));
  }

  @Test
  public void nameOf_plural()
  {
    Assert.assertEquals("aNames",generator.nameOf("names",false));
    Assert.assertEquals("allNames",generator.nameOf("names",true));
  }
  
  @Test
  public void associationConstructor_oneToOne()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student",null,null,createMultiplicity(1,1),true);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    c.addAttribute(new Attribute("id","Integer",null,null,false));

    c2.addAssociationVariable(relatedAv);
    c2.addAttribute(new Attribute("name","String",null,null,false));
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("$aId, $aMentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("$aId, $aMentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("$aName, $aStudent",g2.getLookup("constructorSignature"));
    Assert.assertEquals("$aName, $aStudent",g2.getLookup("constructorSignature_caller"));
    
    Assert.assertEquals("$aId, $aNameForMentor",g.getLookup("constructorSignature_mandatory"));
    Assert.assertEquals("$aNameForMentor, $thisInstance",g.getLookup("constructorSignature_mandatory_mentor"));
    
  }   

  @Test
  public void associationConstructor_unidirectionalOne()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student",null,null,createMultiplicity(1,1),false);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    c.addAttribute(new Attribute("id","Integer",null,null,false));

    c2.addAssociationVariable(relatedAv);
    c2.addAttribute(new Attribute("name","String",null,null,false));
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("$aId, $aMentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("$aId, $aMentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("$aName",g2.getLookup("constructorSignature"));
    Assert.assertEquals("$aName",g2.getLookup("constructorSignature_caller"));

    Assert.assertEquals(null,g.getLookup("constructorSignature_mandatory"));
    Assert.assertEquals(null,g.getLookup("constructorSignature_mandatory_mentor"));

  }   
  
  @Test
  public void ignoreListAttributesInConstructor()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute av = new Attribute("name","Integer","defaulted","\"1\"",false);
    av.setIsList(true);
    c.addAttribute(av);
    generator.prepare();

    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));
    
  }   

  
  
  @Test
  public void associationConstructor_Many()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(0,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,null,createMultiplicity(1,-1),true);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    c.addAttribute(new Attribute("id","Integer",null,null,false));

    c2.addAssociationVariable(relatedAv);
    c2.addAttribute(new Attribute("name","String",null,null,false));
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("$aId",g.getLookup("constructorSignature"));
    Assert.assertEquals("$aId",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("$aName, $allStudents",g2.getLookup("constructorSignature"));
    Assert.assertEquals("$aName, $allStudents",g2.getLookup("constructorSignature_caller"));
    
  }   

  @Test
  public void associationConstructor_UnidirectionalMandatoryMany()
  {
    UmpleClass c = model.addUmpleClass("Mentor");
    UmpleClass c2 = model.addUmpleClass("Student");

    AssociationVariable av = new AssociationVariable("students","Student",null,null,createMultiplicity(1,5),true);
    AssociationVariable relatedAv = new AssociationVariable("mentors","Mentor",null,null,createMultiplicity(1,5),false);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    c.addAttribute(new Attribute("id","Integer",null,null,false));

    c2.addAssociationVariable(relatedAv);
    c2.addAttribute(new Attribute("name","String",null,null,false));
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("$aId, $allStudents",g.getLookup("constructorSignature"));
    Assert.assertEquals("$aId, $allStudents",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("$aName",g2.getLookup("constructorSignature"));
    Assert.assertEquals("$aName",g2.getLookup("constructorSignature_caller"));
    
  }   
  
  
  @Test
  public void associationConstructor_MN()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student",null,null,createMultiplicity(1,3),true);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    c.addAttribute(new Attribute("id","Integer",null,null,false));

    c2.addAssociationVariable(relatedAv);
    c2.addAttribute(new Attribute("name","String",null,null,false));
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("$aId, $aMentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("$aId, $aMentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("$aName",g2.getLookup("constructorSignature"));
    Assert.assertEquals("$aName",g2.getLookup("constructorSignature_caller"));
    
  }   
  
  @Test
  public void associationConstructor_MNtoMN()
  {
    assertIgnoreMany(2,4,1,3);
  }   

  @Test
  public void associationConstructor_NtoMStar()
  {
    assertIgnoreMany(4,4,3,-1);
  }   

  @Test
  public void associationConstructor_MNtoOptionalN()
  {
    assertIgnoreMany(2,4,0,3);
  }   
  
  @Test
  public void associationConstructor_NtoOptionalN()
  {
    assertIgnoreMany(4,4,0,3);
  }
  
  
  @Test
  public void imports_Time()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("name","Time","defaulted","\"1\"",false));
    generator.prepare();
    assertImport(c);
  }
  
  @Test
  public void imports_indirectlyTime()
  {
    UmpleClass airline = model.addUmpleClass("Airline");
    
    UmpleClass flight = model.addUmpleClass("Flight");
    flight.addAttribute(new Attribute("time","Time",null,null,false));
    
    AssociationVariable airlineVar = new AssociationVariable("airline","Airline","","",createMultiplicity(1,1),true);
    AssociationVariable flightVar = new AssociationVariable("flight","Flight","","",createMultiplicity(0,-1),true);

    airlineVar.setRelatedAssociation(flightVar);
    airline.addAssociationVariable(flightVar);
    flight.addAssociationVariable(airlineVar);
    
    generator.prepare();
    assertImport(airline,"java.util.*");
  }
  
  @Test
  public void imports_Date()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("name","Date","defaulted","\"1\"",false));
    generator.prepare();
    assertImport(c);
  }  

  @Test
  public void imports_None()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("name","Integer","defaulted","\"1\"",false));
    generator.prepare();
    assertImport(c);
  }
  
  @Test
  public void imports_ListAttribute()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute av = new Attribute("name","Integer","defaulted","\"1\"",false);
    av.setIsList(true);
    c.addAttribute(av);
    generator.prepare();
    assertImport(c);
  }  

  @Test
  public void imports_ExtendsClass()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass extendsClass = model.addUmpleClass("Person");
    c.setExtendsClass(extendsClass);
    c.setPackageName("cruise.one");
    extendsClass.setPackageName("cruise.two");
    
    generator.prepare();
    assertImport(c,"cruise.two.*");
  }  
  
  @Test
  public void imports_NotExtendsClassIfSamePackage()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass extendsClass = model.addUmpleClass("Person");
    c.setExtendsClass(extendsClass);
    c.setPackageName("cruise.one");
    extendsClass.setPackageName("cruise.one");
    
    generator.prepare();
    assertImport(c);
  } 
  
  @Test
  public void imports_NotExtendsClassIfNoneSet()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass extendsClass = model.addUmpleClass("Person");
    c.setExtendsClass(extendsClass);
    generator.prepare();
    assertImport(c);
  }  
  
  @Test
  public void translate_ParameterValueDateTime()
  {
    Attribute av;
    
    av = new Attribute("name","Time","defaulted","\"1\"",false);
    Assert.assertEquals("date(\"h:i:s\", strtotime(\"1\"))", generator.translate("parameterValue", av));

    av = new Attribute("name","Date","defaulted","\"2\"",false);
    Assert.assertEquals("date(\"y-m-d\", strtotime(\"2\"))", generator.translate("parameterValue", av));

    av = new Attribute("name","Time","defaulted","blah1()",false);
    Assert.assertEquals("blah1()", generator.translate("parameterValue", av));

    av = new Attribute("name","Date","defaulted","blah2()",false);
    Assert.assertEquals("blah2()", generator.translate("parameterValue", av));
    
    av = new Attribute("name","Time","defaulted",null,false);
    Assert.assertEquals("null", generator.translate("parameterValue", av));

    av = new Attribute("name","Date","defaulted",null,false);
    Assert.assertEquals("null", generator.translate("parameterValue", av));
    
  }  
  
  @Test
  public void translate_plural()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("names","String",null,null,false);
    attr.setIsList(true);
    c.addAttribute(attr);
    
    Assert.assertEquals("newNames",generator.translate("parameter",attr));    
    Assert.assertEquals("aName",generator.translate("parameterOne",attr));
    Assert.assertEquals("name",generator.translate("associationOne",attr));
    Assert.assertEquals("names",generator.translate("associationMany",attr));
    Assert.assertEquals("names",generator.translate("attribute",attr));    
    Assert.assertEquals("name",generator.translate("attributeOne",attr));
    Assert.assertEquals("names",generator.translate("attributeMany",attr));
    Assert.assertEquals("addName",generator.translate("addMethod",attr));
    Assert.assertEquals("removeName",generator.translate("removeMethod",attr));
    Assert.assertEquals("setName",generator.translate("setMethod",attr));
    Assert.assertEquals("enterName",generator.translate("enterMethod",attr));
    Assert.assertEquals("exitName",generator.translate("exitMethod",attr));
    Assert.assertEquals("getName",generator.translate("getMethod",attr));
    Assert.assertEquals("newNames",generator.translate("parameterMany",attr));
    Assert.assertEquals("newName",generator.translate("parameterNew",attr));
    Assert.assertEquals("allNames",generator.translate("parameterAll",attr));
    Assert.assertEquals("nextName",generator.translate("parameterNext",attr));
    Assert.assertEquals("setNames",generator.translate("setManyMethod",attr));
    Assert.assertEquals("didAddNames",generator.translate("didAddMany",attr));
    Assert.assertEquals("didAddName",generator.translate("didAdd",attr));
    Assert.assertEquals("numberOfNames",generator.translate("numberOfMethod",attr));
    Assert.assertEquals("indexOfName",generator.translate("indexOfMethod",attr));
    Assert.assertEquals("isNumberOfNamesValid",generator.translate("isNumberOfValidMethod",attr));
    Assert.assertEquals("verifiedNames",generator.translate("parameterVerifiedMany",attr));
    Assert.assertEquals("oldNames",generator.translate("parameterOldMany",attr));
    Assert.assertEquals("oldName",generator.translate("parameterOld",attr));
    Assert.assertEquals("existingName",generator.translate("parameterExisting",attr));
    Assert.assertEquals("checkNewNames",generator.translate("parameterCheckNewMany",attr));
    Assert.assertEquals("isNewName",generator.translate("parameterIsNew",attr));
    Assert.assertEquals("newName",generator.translate("associationNew",attr));
    Assert.assertEquals("copyOfNames",generator.translate("parameterCopyOfMany",attr));
    Assert.assertEquals("canSetName",generator.translate("canSetMethod",attr));
    Assert.assertEquals("currentName",generator.translate("parameterCurrent",attr));
    Assert.assertEquals("deleteName",generator.translate("deleteMethod",attr));
    Assert.assertEquals("requiredNumberOfNames",generator.translate("requiredNumberOfMethod",attr));    
  }  

  @Test
  public void translate_singularButHasPluralName()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("names","String",null,null,false);
    c.addAttribute(attr);
    
    Assert.assertEquals("aNames",generator.translate("parameter",attr));
    Assert.assertEquals("aNames",generator.translate("parameterOne",attr));
    Assert.assertEquals("names",generator.translate("associationOne",attr));
    Assert.assertEquals("names",generator.translate("associationMany",attr));
    Assert.assertEquals("names",generator.translate("attribute",attr));
    Assert.assertEquals("names",generator.translate("attributeOne",attr));
    Assert.assertEquals("names",generator.translate("attributeMany",attr));
    Assert.assertEquals("addNames",generator.translate("addMethod",attr));
    Assert.assertEquals("removeNames",generator.translate("removeMethod",attr));
    Assert.assertEquals("setNames",generator.translate("setMethod",attr));
    Assert.assertEquals("exitNames",generator.translate("exitMethod",attr));
    Assert.assertEquals("getNames",generator.translate("getMethod",attr));
    Assert.assertEquals("newNames",generator.translate("parameterMany",attr));
    Assert.assertEquals("newNames",generator.translate("parameterNew",attr));
    Assert.assertEquals("allNames",generator.translate("parameterAll",attr));
    Assert.assertEquals("nextNames",generator.translate("parameterNext",attr));
    Assert.assertEquals("setNames",generator.translate("setManyMethod",attr));
    Assert.assertEquals("didAddNames",generator.translate("didAddMany",attr));
    Assert.assertEquals("didAddNames",generator.translate("didAdd",attr));
    Assert.assertEquals("numberOfNames",generator.translate("numberOfMethod",attr));
    Assert.assertEquals("indexOfNames",generator.translate("indexOfMethod",attr));
    Assert.assertEquals("isNumberOfNamesValid",generator.translate("isNumberOfValidMethod",attr));
    Assert.assertEquals("verifiedNames",generator.translate("parameterVerifiedMany",attr));
    Assert.assertEquals("oldNames",generator.translate("parameterOldMany",attr));
    Assert.assertEquals("oldNames",generator.translate("parameterOld",attr));
    Assert.assertEquals("existingNames",generator.translate("parameterExisting",attr));
    Assert.assertEquals("checkNewNames",generator.translate("parameterCheckNewMany",attr));
    Assert.assertEquals("isNewNames",generator.translate("parameterIsNew",attr));
    Assert.assertEquals("newNames",generator.translate("associationNew",attr));
    Assert.assertEquals("copyOfNames",generator.translate("parameterCopyOfMany",attr));
    Assert.assertEquals("canSetNames",generator.translate("canSetMethod",attr));
    Assert.assertEquals("currentNames",generator.translate("parameterCurrent",attr));
    Assert.assertEquals("deleteNames",generator.translate("deleteMethod",attr));
    Assert.assertEquals("requiredNumberOfNames",generator.translate("requiredNumberOfMethod",attr));    
  }  

  @Test
  public void translate_Association()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,"3",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,"2",createMultiplicity(1,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    c2.addAssociationVariable(relatedAv);
    
    assertTranslate(av, av.getRelatedAssociation());
  }
  
  @Test
  public void translate_OtherAssociation()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,"3",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,"2",createMultiplicity(1,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    c2.addAssociationVariable(relatedAv);
    
    assertOtherTranslate(av);
  }
  
  @Test
  public void translate_Attribute()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute av = new Attribute("mentor","Mentor",null,"3",false);
    c.addAttribute(av);
    assertTranslate(av, null);
  }
  
  @Test
  public void translate_CanSetBasedOnMultiplicity_Attributes()
  {
    UmpleClass c = model.addUmpleClass("Student");

    Attribute avOne = new Attribute("id","String",null,null,false);
    Attribute avMany = new Attribute("values","String",null,null,false); 
    avMany.setIsList(true);
    
    c.addAttribute(avOne);
    c.addAttribute(avMany);
    
    Assert.assertEquals("canSetId", generator.translate("attributeCanSet", avOne));
    Assert.assertEquals("canSetValues", generator.translate("attributeCanSet", avMany));
  }
  
  @Test
  public void translate_CanSetBasedOnMultiplicity_Associations()
  {
    UmpleClass c = model.addUmpleClass("Student");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,"3",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,"2",createMultiplicity(1,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);

    Assert.assertEquals("canSetMentor", generator.translate("associationCanSet", av));
    Assert.assertEquals("canSetStudents", generator.translate("associationCanSet", relatedAv));
  }  
  
  @Test
  public void translate_packageDefinition()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Assert.assertEquals("",generator.translate("packageDefinition", c));
    
    c.setPackageName("cruise.umple");
    Assert.assertEquals("package cruise.umple;",generator.translate("packageDefinition", c));
  }  
  
  @Test
  public void translate_class()
  {
    UmpleClass c = model.addUmpleClass("Student");

    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",c));
    Assert.assertEquals("Student",generator.translate("type",c));
  } 
  
  @Test
  public void getType_isNullable()
  {
    Attribute av = new Attribute("mentor","Mentor",null,"3",false);
    Assert.assertEquals("Mentor",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("Mentor", generator.translate("type",av));
    Assert.assertEquals("Mentor", generator.translate("typeMany",av));

    av.setType("Integer");
    Assert.assertEquals("Integer",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("Integer", generator.translate("type",av));
    Assert.assertEquals("Integer", generator.translate("typeMany",av));

    av.setType("Boolean");
    Assert.assertEquals("Boolean",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("Boolean", generator.translate("type",av));
    
    av.setType("Double");
    Assert.assertEquals("Double",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("Double", generator.translate("type",av));

    av.setType("Float");
    Assert.assertEquals("Float",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("Float", generator.translate("type",av));

    av.setType("");
    Assert.assertEquals("String",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("String", generator.translate("type",av));
    
    av.setType(null);
    Assert.assertEquals("String",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("String", generator.translate("type",av));
    Assert.assertEquals("String", generator.translate("typeMany",av));

    
  }
  
  @Test
  public void translateCallerArguments()
  {
    
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor","","",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student","","",createMultiplicity(2,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    c2.addAssociationVariable(relatedAv);
    c2.addAttribute(new Attribute("name","String",null,null,false));
    c.addAttribute(new Attribute("number","Integer",null,null,false));

    generator.prepare();
    
    String callerArgs = generator.translate("callerArgumentsExcept", av);
    String methodArgs = generator.translate("methodArgumentsExcept", av);

    Assert.assertEquals("$aNumber, $this", callerArgs);
    Assert.assertEquals("$aNumber", methodArgs);
    
  }
  
  @Test
  public void isA_extends()
  {
    UmpleClass parent = model.addUmpleClass("Parent");
    UmpleClass child = model.addUmpleClass("Child");
    child.setExtendsClass(parent);
//    system.runPregenerationProcess();
    
    Assert.assertEquals("",generator.translate("isA", parent));
    Assert.assertEquals(" extends Parent",generator.translate("isA", child));
  }

  @Test
  public void isA_implements()
  {
    UmpleInterface parent = new UmpleInterface("Parent"); 
    model.addUmpleInterface(parent);
    UmpleClass child = model.addUmpleClass("Child");
    child.addParentInterface(parent);
    
    Assert.assertEquals(" implements Parent",generator.translate("isA", child));
  }

  @Test
  public void callerArgumentsForMandatory()
  {
    
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor","","",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student","","",createMultiplicity(1,1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    c2.addAssociationVariable(relatedAv);
    c2.addAttribute(new Attribute("name","String",null,null,false));
    c.addAttribute(new Attribute("number","Integer",null,null,false));

    generator.prepare();
    
    String callerArgFor1 = generator.translate("callerArgumentsForMandatory", av);
    Assert.assertEquals("$aNumberForStudent, $thisInstance", callerArgFor1);

    String callerArgFor2 = generator.translate("callerArgumentsForMandatory", relatedAv);
    Assert.assertEquals("$aNameForMentor, $thisInstance", callerArgFor2);

    Assert.assertEquals("$aNumber, $aNameForMentor", generator.translate("constructorMandatory",c));
    Assert.assertEquals("$aName, $aNumberForStudent", generator.translate("constructorMandatory",c2));
  }
  
  @Test
  public void getLanguageFor()
  {
    UmpleInterface aInterface = new UmpleInterface("IStudent");
    Assert.assertEquals(PhpInterfaceGenerator.class,generator.getLanguageFor(aInterface).getClass());
  }
  
  @Test
  public void translate_stateMachines()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("grade");
    sm.setUmpleClass(c);

    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",sm));
    Assert.assertEquals("grade",generator.translate("stateMachineOne",sm));
    Assert.assertEquals("getGrade",generator.translate("getMethod",sm));
  }
  
  @Test
  public void translate_states()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("grade");
    sm.setUmpleClass(c);
    
    State state = new State("Pass",sm);

    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",state));
    Assert.assertEquals("GradePass",generator.translate("stateOne",state));
    Assert.assertEquals("\"GradePass\"",generator.translate("stateString",state));

    Assert.assertEquals("doActivityGradePass",generator.translate("doActivityMethod",state));
    
    Activity activity = new Activity("//the code",state);
    state.setActivity(activity);
    Assert.assertEquals("doActivityGradePass",generator.translate("doActivityMethod",state));    
  }  
  
  @Test
  public void translate_event()
  {
    Event e = new Event("register");
    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",e));
    Assert.assertEquals("register",generator.translate("eventMethod",e));
    Assert.assertEquals("startRegisterHandler",generator.translate("eventStartMethod",e));
    Assert.assertEquals("stopRegisterHandler",generator.translate("eventStopMethod",e));
    Assert.assertEquals("registerHandler",generator.translate("eventHandler",e));
  }  
  
  @Test
  public void translate_nestedStateMachines()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine outerSm = new StateMachine("Vcr");
    outerSm.setUmpleClass(c);

    State s1 = new State("s1",outerSm);
    new State("s2",outerSm);
    
    StateMachine sm = new StateMachine("On");
    s1.addNestedStateMachine(sm);
    
    State s3 = new State("s3",sm);
    new State("s4",sm);
    
    StateMachine innerSm = new StateMachine("AlmostOn");
    s3.addNestedStateMachine(innerSm);

    State s5 = new State("s5",innerSm);
    
    
    
    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",sm));
    Assert.assertEquals("VcrOn",generator.translate("stateMachineOne",sm));
    Assert.assertEquals("aVcrOn",generator.translate("parameterOne",sm));
    Assert.assertEquals("placeholderVcrOn",generator.translate("removeParameterOne",sm));    
    Assert.assertEquals("getVcrOn",generator.translate("getMethod",sm));
    Assert.assertEquals("getVcrOnFullName",generator.translate("getFullMethod",sm));
    Assert.assertEquals("String",generator.translate("typeGet",sm));
    Assert.assertEquals("int",generator.translate("type",sm));
    Assert.assertEquals("VcrOnNull",generator.translate("stateNull",sm));
    Assert.assertEquals("VcrOnS3",generator.translate("stateOne",s3));
    Assert.assertEquals("VcrOnAlmostOnS5",generator.translate("stateOne",s5));
    Assert.assertEquals("VcrOnS3, VcrOnS4",generator.translate("listStates",sm));
    
  }  
  
  @Test
  public void prepare_postpare_nestedStateMachine()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    StateMachine sm = new StateMachine("bulb");
    StateMachine nestedSm = new StateMachine("On");

    sm.setUmpleClass(c);
    
    State onState = new State("On",sm);
    onState.addNestedStateMachine(nestedSm);
    State normalState = new State("Normal",nestedSm);
    normalState.setIsStartState(true);

    generator.prepare();
    Assert.assertEquals(2,onState.numberOfActions());

    Assert.assertEquals("exit",onState.getAction(0).getActionType());
    Assert.assertEquals("$this->exitOn();",onState.getAction(0).getActionCode());
    
    Assert.assertEquals("entry",onState.getAction(1).getActionType());
    Assert.assertEquals("if ($this->bulbOn == self::$BulbOnNull) { $this->setBulbOn(\"BulbOnNormal\"); }",onState.getAction(1).getActionCode());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,onState.numberOfActions());
  }    
  
  private void assertOtherTranslate(AssociationVariable av)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.relatedTranslate("blah", av));
    Assert.assertEquals("newStudents",generator.relatedTranslate("parameter",av));
    Assert.assertEquals("aStudent",generator.relatedTranslate("parameterOne",av));
    Assert.assertEquals("2",generator.relatedTranslate("parameterValue",av));
    Assert.assertEquals("student",generator.relatedTranslate("associationOne",av));
    Assert.assertEquals("students",generator.relatedTranslate("associationMany",av));
    Assert.assertEquals("students",generator.relatedTranslate("attribute",av));
    Assert.assertEquals("student",generator.relatedTranslate("attributeOne",av));
    Assert.assertEquals("students",generator.relatedTranslate("attributeMany",av));
    Assert.assertEquals("addStudent",generator.relatedTranslate("addMethod",av));
    Assert.assertEquals("addStudentVia",generator.relatedTranslate("addViaMethod",av));
    Assert.assertEquals("removeStudent",generator.relatedTranslate("removeMethod",av));
    Assert.assertEquals("setStudent",generator.relatedTranslate("setMethod",av));
    Assert.assertEquals("exitStudent",generator.relatedTranslate("exitMethod",av));
    Assert.assertEquals("resetStudent",generator.relatedTranslate("resetMethod",av));
    Assert.assertEquals("getStudent",generator.relatedTranslate("getMethod",av));
    Assert.assertEquals("getDefaultStudent",generator.relatedTranslate("getDefaultMethod",av));
    Assert.assertEquals("newStudents",generator.relatedTranslate("parameterMany",av));
    Assert.assertEquals("newStudent",generator.relatedTranslate("parameterNew",av));
    Assert.assertEquals("allStudents",generator.relatedTranslate("parameterAll",av));
    Assert.assertEquals("nextStudent",generator.relatedTranslate("parameterNext",av));
    Assert.assertEquals("setStudents",generator.relatedTranslate("setManyMethod",av));
    Assert.assertEquals("didAddStudents",generator.relatedTranslate("didAddMany",av));
    Assert.assertEquals("didAddStudent",generator.relatedTranslate("didAdd",av));
    Assert.assertEquals("numberOfStudents",generator.relatedTranslate("numberOfMethod",av));
    Assert.assertEquals("indexOfStudent",generator.relatedTranslate("indexOfMethod",av));
    Assert.assertEquals("isNumberOfStudentsValid",generator.relatedTranslate("isNumberOfValidMethod",av));
    Assert.assertEquals("minimumNumberOfStudents",generator.relatedTranslate("minimumNumberOfMethod",av));
    Assert.assertEquals("maximumNumberOfStudents",generator.relatedTranslate("maximumNumberOfMethod",av));
    Assert.assertEquals("verifiedStudents",generator.relatedTranslate("parameterVerifiedMany",av));
    Assert.assertEquals("oldStudents",generator.relatedTranslate("parameterOldMany",av));
    Assert.assertEquals("oldStudent",generator.relatedTranslate("parameterOld",av));
    Assert.assertEquals("existingStudent",generator.relatedTranslate("parameterExisting",av));
    Assert.assertEquals("existingSerializedStudent",generator.relatedTranslate("parameterExistingSerialized",av));
    Assert.assertEquals("checkNewStudents",generator.relatedTranslate("parameterCheckNewMany",av));
    Assert.assertEquals("isNewStudent",generator.relatedTranslate("parameterIsNew",av));
    Assert.assertEquals("newStudent",generator.relatedTranslate("associationNew",av));
    Assert.assertEquals("copyOfStudents",generator.relatedTranslate("parameterCopyOfMany",av));
    Assert.assertEquals("canSetStudent",generator.relatedTranslate("canSetMethod",av));
    Assert.assertEquals("currentStudent",generator.relatedTranslate("parameterCurrent",av));
    Assert.assertEquals("deleteStudent",generator.relatedTranslate("deleteMethod",av));
    Assert.assertEquals("getStudents",generator.relatedTranslate("getManyMethod",av));
    Assert.assertEquals("hasStudent",generator.relatedTranslate("hasMethod",av));
    Assert.assertEquals("hasStudents",generator.relatedTranslate("hasManyMethod",av));
    Assert.assertEquals("requiredNumberOfStudents",generator.relatedTranslate("requiredNumberOfMethod",av));
  }

  private void assertTranslate(AssociationVariable av, AssociationVariable relatedAv)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.translate("blah", av));
    Assert.assertEquals("aMentor",generator.translate("parameter",av));
    Assert.assertEquals("aMentor",generator.translate("parameterOne",av));
    Assert.assertEquals("3",generator.translate("parameterValue",av));
    Assert.assertEquals("mentor",generator.translate("associationOne",av));
    Assert.assertEquals("mentors",generator.translate("associationMany",av));
    Assert.assertEquals("mentor",generator.translate("attribute",av));
    Assert.assertEquals("mentor",generator.translate("attributeOne",av));
    Assert.assertEquals("mentors",generator.translate("attributeMany",av));
    Assert.assertEquals("addMentor",generator.translate("addMethod",av));
    Assert.assertEquals("addMentorVia",generator.translate("addViaMethod",av));
    Assert.assertEquals("removeMentor",generator.translate("removeMethod",av));
    Assert.assertEquals("setMentor",generator.translate("setMethod",av));
    Assert.assertEquals("exitMentor",generator.translate("exitMethod",av));
    Assert.assertEquals("getMentor",generator.translate("getMethod",av));
    Assert.assertEquals("newMentors",generator.translate("parameterMany",av));
    Assert.assertEquals("newMentor",generator.translate("parameterNew",av));
    Assert.assertEquals("allMentors",generator.translate("parameterAll",av));
    Assert.assertEquals("nextMentor",generator.translate("parameterNext",av));
    Assert.assertEquals("setMentors",generator.translate("setManyMethod",av));
    Assert.assertEquals("didAddMentors",generator.translate("didAddMany",av));
    Assert.assertEquals("didAddMentor",generator.translate("didAdd",av));
    Assert.assertEquals("numberOfMentors",generator.translate("numberOfMethod",av));
    Assert.assertEquals("indexOfMentor",generator.translate("indexOfMethod",av));
    Assert.assertEquals("isNumberOfMentorsValid",generator.translate("isNumberOfValidMethod",av));
    Assert.assertEquals("verifiedMentors",generator.translate("parameterVerifiedMany",av));
    Assert.assertEquals("oldMentors",generator.translate("parameterOldMany",av));
    Assert.assertEquals("oldMentor",generator.translate("parameterOld",av));
    Assert.assertEquals("existingMentor",generator.translate("parameterExisting",av));
    Assert.assertEquals("existingSerializedMentor",generator.translate("parameterExistingSerialized",av));
    Assert.assertEquals("checkNewMentors",generator.translate("parameterCheckNewMany",av));
    Assert.assertEquals("isNewMentor",generator.translate("parameterIsNew",av));
    Assert.assertEquals("newMentor",generator.translate("associationNew",av));
    Assert.assertEquals("copyOfMentors",generator.translate("parameterCopyOfMany",av));
    Assert.assertEquals("canSetMentor",generator.translate("canSetMethod",av));
    Assert.assertEquals("currentMentor",generator.translate("parameterCurrent",av));
    Assert.assertEquals("deleteMentor",generator.translate("deleteMethod",av));
    Assert.assertEquals("requiredNumberOfMentors",generator.translate("requiredNumberOfMethod",av));

    if (relatedAv == null)
    {
      return;
    }
    
    Assert.assertEquals("aStudent",generator.translate("parameterOne",relatedAv));
    Assert.assertEquals("2",generator.translate("parameterValue",relatedAv));
    Assert.assertEquals("student",generator.translate("associationOne",relatedAv));
    Assert.assertEquals("students",generator.translate("associationMany",relatedAv));
    Assert.assertEquals("students",generator.translate("attribute",relatedAv));
    Assert.assertEquals("student",generator.translate("attributeOne",relatedAv));
    Assert.assertEquals("students",generator.translate("attributeMany",relatedAv));
    Assert.assertEquals("addStudent",generator.translate("addMethod",relatedAv));
    Assert.assertEquals("addStudentVia",generator.translate("addViaMethod",relatedAv));
    Assert.assertEquals("removeStudent",generator.translate("removeMethod",relatedAv));
    Assert.assertEquals("setStudent",generator.translate("setMethod",relatedAv));
    Assert.assertEquals("exitStudent",generator.translate("exitMethod",relatedAv));
    Assert.assertEquals("getStudent",generator.translate("getMethod",relatedAv));    
    Assert.assertEquals("newStudents",generator.translate("parameterMany",relatedAv));
    Assert.assertEquals("newStudent",generator.translate("parameterNew",relatedAv));
    Assert.assertEquals("allStudents",generator.translate("parameterAll",relatedAv));
    Assert.assertEquals("nextStudent",generator.translate("parameterNext",relatedAv));
    Assert.assertEquals("setStudents",generator.translate("setManyMethod",relatedAv));
    Assert.assertEquals("didAddStudents",generator.translate("didAddMany",relatedAv));
    Assert.assertEquals("didAddStudent",generator.translate("didAdd",relatedAv));
    Assert.assertEquals("numberOfStudents",generator.translate("numberOfMethod",relatedAv));
    Assert.assertEquals("indexOfStudent",generator.translate("indexOfMethod",relatedAv));
    Assert.assertEquals("isNumberOfStudentsValid",generator.translate("isNumberOfValidMethod",relatedAv));
    Assert.assertEquals("minimumNumberOfStudents",generator.translate("minimumNumberOfMethod",relatedAv));
    Assert.assertEquals("maximumNumberOfStudents",generator.translate("maximumNumberOfMethod",relatedAv));
    Assert.assertEquals("verifiedStudents",generator.translate("parameterVerifiedMany",relatedAv));
    Assert.assertEquals("oldStudents",generator.translate("parameterOldMany",relatedAv));
    Assert.assertEquals("oldStudent",generator.translate("parameterOld",relatedAv));
    Assert.assertEquals("existingStudent",generator.translate("parameterExisting",relatedAv));
    Assert.assertEquals("existingSerializedStudent",generator.translate("parameterExistingSerialized",relatedAv));
    Assert.assertEquals("checkNewStudents",generator.translate("parameterCheckNewMany",relatedAv));
    Assert.assertEquals("isNewStudent",generator.translate("parameterIsNew",relatedAv));
    Assert.assertEquals("newStudent",generator.translate("associationNew",relatedAv));
    Assert.assertEquals("copyOfStudents",generator.translate("parameterCopyOfMany",relatedAv));
    Assert.assertEquals("canSetStudent",generator.translate("canSetMethod",relatedAv));
    Assert.assertEquals("currentStudent",generator.translate("parameterCurrent",relatedAv));
    Assert.assertEquals("deleteStudent",generator.translate("deleteMethod",relatedAv));
    Assert.assertEquals("requiredNumberOfStudents",generator.translate("requiredNumberOfMethod",relatedAv));
    

  }  
  
  private void assertTranslate(Attribute av, Attribute relatedAv)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.translate("blah", av));
    Assert.assertEquals("aMentor",generator.translate("parameter",av));
    Assert.assertEquals("aMentor",generator.translate("parameterOne",av));
    Assert.assertEquals("3",generator.translate("parameterValue",av));
    Assert.assertEquals("mentor",generator.translate("associationOne",av));
    Assert.assertEquals("mentors",generator.translate("associationMany",av));
    Assert.assertEquals("mentor",generator.translate("attribute",av));
    Assert.assertEquals("mentor",generator.translate("attributeOne",av));
    Assert.assertEquals("mentors",generator.translate("attributeMany",av));
    Assert.assertEquals("addMentor",generator.translate("addMethod",av));
    Assert.assertEquals("addMentorVia",generator.translate("addViaMethod",av));
    Assert.assertEquals("removeMentor",generator.translate("removeMethod",av));
    Assert.assertEquals("setMentor",generator.translate("setMethod",av));
    Assert.assertEquals("exitMentor",generator.translate("exitMethod",av));
    Assert.assertEquals("getMentor",generator.translate("getMethod",av));
    Assert.assertEquals("newMentors",generator.translate("parameterMany",av));
    Assert.assertEquals("newMentor",generator.translate("parameterNew",av));
    Assert.assertEquals("allMentors",generator.translate("parameterAll",av));
    Assert.assertEquals("nextMentor",generator.translate("parameterNext",av));
    Assert.assertEquals("setMentors",generator.translate("setManyMethod",av));
    Assert.assertEquals("didAddMentors",generator.translate("didAddMany",av));
    Assert.assertEquals("didAddMentor",generator.translate("didAdd",av));
    Assert.assertEquals("numberOfMentors",generator.translate("numberOfMethod",av));
    Assert.assertEquals("indexOfMentor",generator.translate("indexOfMethod",av));
    Assert.assertEquals("isNumberOfMentorsValid",generator.translate("isNumberOfValidMethod",av));
    Assert.assertEquals("verifiedMentors",generator.translate("parameterVerifiedMany",av));
    Assert.assertEquals("oldMentors",generator.translate("parameterOldMany",av));
    Assert.assertEquals("oldMentor",generator.translate("parameterOld",av));
    Assert.assertEquals("existingMentor",generator.translate("parameterExisting",av));
    Assert.assertEquals("existingSerializedMentor",generator.translate("parameterExistingSerialized",av));
    Assert.assertEquals("checkNewMentors",generator.translate("parameterCheckNewMany",av));
    Assert.assertEquals("isNewMentor",generator.translate("parameterIsNew",av));
    Assert.assertEquals("newMentor",generator.translate("associationNew",av));
    Assert.assertEquals("copyOfMentors",generator.translate("parameterCopyOfMany",av));
    Assert.assertEquals("canSetMentor",generator.translate("canSetMethod",av));
    Assert.assertEquals("currentMentor",generator.translate("parameterCurrent",av));
    Assert.assertEquals("deleteMentor",generator.translate("deleteMethod",av));
    Assert.assertEquals("requiredNumberOfMentors",generator.translate("requiredNumberOfMethod",av));

    if (relatedAv == null)
    {
      return;
    }
    
    Assert.assertEquals("aStudent",generator.translate("parameterOne",relatedAv));
    Assert.assertEquals("2",generator.translate("parameterValue",relatedAv));
    Assert.assertEquals("student",generator.translate("associationOne",relatedAv));
    Assert.assertEquals("students",generator.translate("associationMany",relatedAv));
    Assert.assertEquals("students",generator.translate("attribute",relatedAv));
    Assert.assertEquals("student",generator.translate("attributeOne",relatedAv));
    Assert.assertEquals("students",generator.translate("attributeMany",relatedAv));
    Assert.assertEquals("addStudent",generator.translate("addMethod",relatedAv));
    Assert.assertEquals("addStudentVia",generator.translate("addViaMethod",relatedAv));
    Assert.assertEquals("removeStudent",generator.translate("removeMethod",relatedAv));
    Assert.assertEquals("setStudent",generator.translate("setMethod",relatedAv));
    Assert.assertEquals("exitStudent",generator.translate("exitMethod",relatedAv));
    Assert.assertEquals("getStudent",generator.translate("getMethod",relatedAv));    
    Assert.assertEquals("newStudents",generator.translate("parameterMany",relatedAv));
    Assert.assertEquals("newStudent",generator.translate("parameterNew",relatedAv));
    Assert.assertEquals("allStudents",generator.translate("parameterAll",relatedAv));
    Assert.assertEquals("nextStudent",generator.translate("parameterNext",relatedAv));
    Assert.assertEquals("setStudents",generator.translate("setManyMethod",relatedAv));
    Assert.assertEquals("didAddStudents",generator.translate("didAddMany",relatedAv));
    Assert.assertEquals("didAddStudent",generator.translate("didAdd",relatedAv));
    Assert.assertEquals("numberOfStudents",generator.translate("numberOfMethod",relatedAv));
    Assert.assertEquals("indexOfStudent",generator.translate("indexOfMethod",relatedAv));
    Assert.assertEquals("isNumberOfStudentsValid",generator.translate("isNumberOfValidMethod",relatedAv));
    Assert.assertEquals("minimumNumberOfStudents",generator.translate("minimumNumberOfMethod",relatedAv));
    Assert.assertEquals("maximumNumberOfStudents",generator.translate("maximumNumberOfMethod",relatedAv));
    Assert.assertEquals("verifiedStudents",generator.translate("parameterVerifiedMany",relatedAv));
    Assert.assertEquals("oldStudents",generator.translate("parameterOldMany",relatedAv));
    Assert.assertEquals("oldStudent",generator.translate("parameterOld",relatedAv));
    Assert.assertEquals("existingStudent",generator.translate("parameterExisting",relatedAv));
    Assert.assertEquals("existingSerializedStudent",generator.translate("parameterExistingSerialized",relatedAv));
    Assert.assertEquals("checkNewStudents",generator.translate("parameterCheckNewMany",relatedAv));
    Assert.assertEquals("isNewStudent",generator.translate("parameterIsNew",relatedAv));
    Assert.assertEquals("newStudent",generator.translate("associationNew",relatedAv));
    Assert.assertEquals("copyOfStudents",generator.translate("parameterCopyOfMany",relatedAv));
    Assert.assertEquals("canSetStudent",generator.translate("canSetMethod",relatedAv));
    Assert.assertEquals("currentStudent",generator.translate("parameterCurrent",relatedAv));
    Assert.assertEquals("deleteStudent",generator.translate("deleteMethod",relatedAv));
    Assert.assertEquals("requiredNumberOfStudents",generator.translate("requiredNumberOfMethod",relatedAv));
    

  }    
  
  private void assertIgnoreMany(int lowerOne, int upperOne, int lowerTwo, int upperTwo)
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(lowerOne,upperOne),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student",null,null,createMultiplicity(lowerTwo,upperTwo),true);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    c.addAttribute(new Attribute("id","Integer",null,null,false));

    c2.addAssociationVariable(relatedAv);
    c2.addAttribute(new Attribute("name","String",null,null,false));
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("$aId",g.getLookup("constructorSignature"));
    Assert.assertEquals("$aId",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("$aName",g2.getLookup("constructorSignature"));
    Assert.assertEquals("$aName",g2.getLookup("constructorSignature_caller"));  
    }

  private void assertImport(UmpleClass c, String... expectedImports)
  {
    GeneratedClass g = c.getGeneratedClass();
    String[] actualImports = g.getMultiLookup("import");
    Assert.assertEquals(expectedImports.length,actualImports.length);
    
    for (int i=0; i<actualImports.length; i++)
    {
      Assert.assertEquals(expectedImports[i],actualImports[i]);  
    }
  }

  private Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }
  
}
