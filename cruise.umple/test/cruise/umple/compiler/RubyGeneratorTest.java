package cruise.umple.compiler;

import cruise.umple.compiler.ruby.*;

import org.junit.*;

//import com.sun.tools.javah.oldjavah.Gen;

public class RubyGeneratorTest
{

  UmpleModel model;
  RubyGenerator generator;

  @Before
  public void setUp()
  {
    model = new UmpleModel(null);
    generator = new RubyGenerator();
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
    Assert.assertEquals("a_name",g.getLookup("constructorSignature"));
    Assert.assertEquals("a_name",g.getLookup("constructorSignature_caller"));
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
    Assert.assertEquals("a_fname, a_lname",g.getLookup("constructorSignature"));
    Assert.assertEquals("a_fname, a_lname",g.getLookup("constructorSignature_caller"));
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
    Assert.assertEquals("a_name",generator.nameOf("name",false));
    Assert.assertEquals("all_name",generator.nameOf("name",true));
    Assert.assertEquals("a_",generator.nameOf("",false));
    Assert.assertEquals("all_",generator.nameOf("",true));
    Assert.assertEquals(null,generator.nameOf(null,false));
    Assert.assertEquals(null,generator.nameOf(null,true));
  }
  
  @Test
  public void nameOf_plural()
  {
    Assert.assertEquals("a_names",generator.nameOf("names",false));
    Assert.assertEquals("all_names",generator.nameOf("names",true));
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
    Assert.assertEquals("a_id, a_mentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("a_id, a_mentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("a_name, a_student",g2.getLookup("constructorSignature"));
    Assert.assertEquals("a_name, a_student",g2.getLookup("constructorSignature_caller"));
    
    Assert.assertEquals("a_id, a_nameForMentor",g.getLookup("constructorSignature_mandatory"));
    Assert.assertEquals("a_nameForMentor, thisInstance",g.getLookup("constructorSignature_mandatory_mentor"));
    
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
    Assert.assertEquals("a_id, a_mentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("a_id, a_mentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("a_name",g2.getLookup("constructorSignature"));
    Assert.assertEquals("a_name",g2.getLookup("constructorSignature_caller"));

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
    Assert.assertEquals("a_id",g.getLookup("constructorSignature"));
    Assert.assertEquals("a_id",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("a_name, all_students",g2.getLookup("constructorSignature"));
    Assert.assertEquals("a_name, all_students",g2.getLookup("constructorSignature_caller"));
    
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
    Assert.assertEquals("a_id, all_students",g.getLookup("constructorSignature"));
    Assert.assertEquals("a_id, all_students",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("a_name",g2.getLookup("constructorSignature"));
    Assert.assertEquals("a_name",g2.getLookup("constructorSignature_caller"));
    
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
    Assert.assertEquals("a_id, a_mentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("a_id, a_mentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("a_name",g2.getLookup("constructorSignature"));
    Assert.assertEquals("a_name",g2.getLookup("constructorSignature_caller"));
    
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
    assertImport(c, "time");
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
    assertImport(airline);
  }
  
  @Test
  public void imports_Date()
  {
    UmpleClass c = model.addUmpleClass("Student");
    c.addAttribute(new Attribute("name","Date","defaulted","\"1\"",false));
    generator.prepare();
    assertImport(c,"date");
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
  public void translate_attributeConstant()
  {
    Attribute av;
    
    av = new Attribute("name","Time","defaulted","\"1\"",false);
    Assert.assertEquals("Name", generator.translate("attributeConstant", av));
  }

  @Test
  public void translate_plural()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("names","String",null,null,false);
    attr.setIsList(true);
    c.addAttribute(attr);
    
    Assert.assertEquals("new_names",generator.translate("parameter",attr));    
    Assert.assertEquals("a_name",generator.translate("parameterOne",attr));
    Assert.assertEquals("name",generator.translate("associationOne",attr));
    Assert.assertEquals("names",generator.translate("associationMany",attr));
    Assert.assertEquals("name",generator.translate("attributeOne",attr));
    Assert.assertEquals("names",generator.translate("attributeMany",attr));
    Assert.assertEquals("add_name",generator.translate("addMethod",attr));
    Assert.assertEquals("remove_name",generator.translate("removeMethod",attr));
    Assert.assertEquals("set_name",generator.translate("setMethod",attr));
    Assert.assertEquals("exit_name",generator.translate("exitMethod",attr));
    Assert.assertEquals("get_name",generator.translate("getMethod",attr));
    Assert.assertEquals("new_names",generator.translate("parameterMany",attr));
    Assert.assertEquals("new_name",generator.translate("parameterNew",attr));
    Assert.assertEquals("all_names",generator.translate("parameterAll",attr));
    Assert.assertEquals("next_name",generator.translate("parameterNext",attr));
    Assert.assertEquals("set_names",generator.translate("setManyMethod",attr));
    Assert.assertEquals("did_add_names",generator.translate("didAddMany",attr));
    Assert.assertEquals("did_add_name",generator.translate("didAdd",attr));
    Assert.assertEquals("number_of_names",generator.translate("numberOfMethod",attr));
    Assert.assertEquals("index_of_name",generator.translate("indexOfMethod",attr));
    Assert.assertEquals("is_number_of_names_valid",generator.translate("isNumberOfValidMethod",attr));
    Assert.assertEquals("verified_names",generator.translate("parameterVerifiedMany",attr));
    Assert.assertEquals("old_names",generator.translate("parameterOldMany",attr));
    Assert.assertEquals("old_name",generator.translate("parameterOld",attr));
    Assert.assertEquals("existing_name",generator.translate("parameterExisting",attr));
    Assert.assertEquals("check_new_names",generator.translate("parameterCheckNewMany",attr));
    Assert.assertEquals("is_new_name",generator.translate("parameterIsNew",attr));
    Assert.assertEquals("new_name",generator.translate("associationNew",attr));
    Assert.assertEquals("copy_of_names",generator.translate("parameterCopyOfMany",attr));
    Assert.assertEquals("can_set_name",generator.translate("canSetMethod",attr));
    Assert.assertEquals("current_name",generator.translate("parameterCurrent",attr));
    Assert.assertEquals("delete_name",generator.translate("deleteMethod",attr));
    Assert.assertEquals("required_number_of_names",generator.translate("requiredNumberOfMethod",attr));    
  }
  
  @Test
  public void translate_ParameterValueDateTime()
  {
    Attribute av;
    
    av = new Attribute("name","Time","defaulted","\"1\"",false);
    Assert.assertEquals("Time.parse(\"1\")", generator.translate("parameterValue", av));

    av = new Attribute("name","Date","defaulted","\"2\"",false);
    Assert.assertEquals("Date.parse(\"2\")", generator.translate("parameterValue", av));

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
    
    Assert.assertEquals("can_set_id", generator.translate("attributeCanSet", avOne));
    Assert.assertEquals("can_set_values", generator.translate("attributeCanSet", avMany));
  }
  
  @Test
  public void translate_CanSetBasedOnMultiplicity_Associations()
  {
    UmpleClass c = model.addUmpleClass("Student");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,"3",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,"2",createMultiplicity(1,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);

    Assert.assertEquals("can_set_mentor", generator.translate("associationCanSet", av));
    Assert.assertEquals("can_set_students", generator.translate("associationCanSet", relatedAv));
  }  
  
  @Test
  public void translate_packageDefinition()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Assert.assertEquals("",generator.translate("packageDefinition", c));
    Assert.assertEquals("",generator.translate("packageDefinitionEnd", c));

    c.setPackageName("ProperFormat");
    Assert.assertEquals("module ProperFormat",generator.translate("packageDefinition", c));
    Assert.assertEquals("end",generator.translate("packageDefinitionEnd", c));

    c.setPackageName("cruise.umple");
    Assert.assertEquals("module CruiseUmple",generator.translate("packageDefinition", c));
    Assert.assertEquals("end",generator.translate("packageDefinitionEnd", c));
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

    Assert.assertEquals("a_number, self", callerArgs);
    Assert.assertEquals("a_number", methodArgs);
    
  }
  
  @Test
  public void isA_extends()
  {
    UmpleClass parent = model.addUmpleClass("Parent");
    UmpleClass child = model.addUmpleClass("Child");
    child.setExtendsClass(parent);
//    system.runPregenerationProcess();
    
    Assert.assertEquals("",generator.translate("isA", parent));
    Assert.assertEquals(" < Parent",generator.translate("isA", child));
  }

  @Test
  public void isA_implements()
  {
    UmpleClass parent = model.addUmpleClass("Parent");
    UmpleClass child = model.addUmpleClass("Child");
    parent.setModifier("interface");
    child.setExtendsClass(parent);
//    system.runPregenerationProcess();
    
    Assert.assertEquals("",generator.translate("isA", parent));
    Assert.assertEquals(" < Parent",generator.translate("isA", child));
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
    Assert.assertEquals("a_numberForStudent, thisInstance", callerArgFor1);

    String callerArgFor2 = generator.translate("callerArgumentsForMandatory", relatedAv);
    Assert.assertEquals("a_nameForMentor, thisInstance", callerArgFor2);

    Assert.assertEquals("a_number, a_nameForMentor", generator.translate("constructorMandatory",c));
    Assert.assertEquals("a_name, a_numberForStudent", generator.translate("constructorMandatory",c2));
  }
  
  @Test
  public void getLanguageFor()
  {
	UmpleInterface aInterface = new UmpleInterface("IStudent");
    Assert.assertEquals(RubyInterfaceGenerator.class,generator.getLanguageFor(aInterface).getClass());
  }
  
  @Test
  public void translate_stateMachines()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("grade");
    sm.setUmpleClass(c);

    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",sm));
    Assert.assertEquals("grade",generator.translate("stateMachineOne",sm));
    Assert.assertEquals("get_grade",generator.translate("getMethod",sm));
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
    Assert.assertEquals("start_register_handler",generator.translate("eventStartMethod",e));
    Assert.assertEquals("stop_register_handler",generator.translate("eventStopMethod",e));
    Assert.assertEquals("register_handler",generator.translate("eventHandler",e));
  }  
  
  private void assertOtherTranslate(AssociationVariable av)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.relatedTranslate("blah", av));
    Assert.assertEquals("new_students",generator.relatedTranslate("parameter",av));
    Assert.assertEquals("a_student",generator.relatedTranslate("parameterOne",av));
    Assert.assertEquals("2",generator.relatedTranslate("parameterValue",av));
    Assert.assertEquals("student",generator.relatedTranslate("associationOne",av));
    Assert.assertEquals("students",generator.relatedTranslate("associationMany",av));
    Assert.assertEquals("student",generator.relatedTranslate("attributeOne",av));
    Assert.assertEquals("students",generator.relatedTranslate("attributeMany",av));
    Assert.assertEquals("add_student",generator.relatedTranslate("addMethod",av));
    Assert.assertEquals("add_student_via",generator.relatedTranslate("addViaMethod",av));
    Assert.assertEquals("remove_student",generator.relatedTranslate("removeMethod",av));
    Assert.assertEquals("set_student",generator.relatedTranslate("setMethod",av));
    Assert.assertEquals("exit_student",generator.relatedTranslate("exitMethod",av));
    Assert.assertEquals("reset_student",generator.relatedTranslate("resetMethod",av));
    Assert.assertEquals("get_student",generator.relatedTranslate("getMethod",av));
    Assert.assertEquals("get_default_student",generator.relatedTranslate("getDefaultMethod",av));
    Assert.assertEquals("new_students",generator.relatedTranslate("parameterMany",av));
    Assert.assertEquals("new_student",generator.relatedTranslate("parameterNew",av));
    Assert.assertEquals("all_students",generator.relatedTranslate("parameterAll",av));
    Assert.assertEquals("next_student",generator.relatedTranslate("parameterNext",av));
    Assert.assertEquals("set_students",generator.relatedTranslate("setManyMethod",av));
    Assert.assertEquals("did_add_students",generator.relatedTranslate("didAddMany",av));
    Assert.assertEquals("did_add_student",generator.relatedTranslate("didAdd",av));
    Assert.assertEquals("number_of_students",generator.relatedTranslate("numberOfMethod",av));
    Assert.assertEquals("index_of_student",generator.relatedTranslate("indexOfMethod",av));
    Assert.assertEquals("is_number_of_students_valid",generator.relatedTranslate("isNumberOfValidMethod",av));
    Assert.assertEquals("minimum_number_of_students",generator.relatedTranslate("minimumNumberOfMethod",av));
    Assert.assertEquals("maximum_number_of_students",generator.relatedTranslate("maximumNumberOfMethod",av));
    Assert.assertEquals("verified_students",generator.relatedTranslate("parameterVerifiedMany",av));
    Assert.assertEquals("old_students",generator.relatedTranslate("parameterOldMany",av));
    Assert.assertEquals("old_student",generator.relatedTranslate("parameterOld",av));
    Assert.assertEquals("existing_student",generator.relatedTranslate("parameterExisting",av));
    Assert.assertEquals("existing_serialized_student",generator.relatedTranslate("parameterExistingSerialized",av));
    Assert.assertEquals("check_new_students",generator.relatedTranslate("parameterCheckNewMany",av));
    Assert.assertEquals("is_new_student",generator.relatedTranslate("parameterIsNew",av));
    Assert.assertEquals("new_student",generator.relatedTranslate("associationNew",av));
    Assert.assertEquals("copy_of_students",generator.relatedTranslate("parameterCopyOfMany",av));
    Assert.assertEquals("can_set_student",generator.relatedTranslate("canSetMethod",av));
    Assert.assertEquals("current_student",generator.relatedTranslate("parameterCurrent",av));
    Assert.assertEquals("delete_student",generator.relatedTranslate("deleteMethod",av));
    Assert.assertEquals("get_students",generator.relatedTranslate("getManyMethod",av));
    Assert.assertEquals("has_student",generator.relatedTranslate("hasMethod",av));
    Assert.assertEquals("has_students",generator.relatedTranslate("hasManyMethod",av));
    Assert.assertEquals("required_number_of_students",generator.relatedTranslate("requiredNumberOfMethod",av));
  }

  private void assertTranslate(Attribute av, Attribute relatedAv)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.translate("blah", av));
    Assert.assertEquals("a_mentor",generator.translate("parameter",av));
    Assert.assertEquals("a_mentor",generator.translate("parameterOne",av));
    Assert.assertEquals("3",generator.translate("parameterValue",av));
    Assert.assertEquals("mentor",generator.translate("associationOne",av));
    Assert.assertEquals("mentors",generator.translate("associationMany",av));
    Assert.assertEquals("mentor",generator.translate("attributeOne",av));
    Assert.assertEquals("mentors",generator.translate("attributeMany",av));
    Assert.assertEquals("add_mentor",generator.translate("addMethod",av));
    Assert.assertEquals("add_mentor_via",generator.translate("addViaMethod",av));
    Assert.assertEquals("remove_mentor",generator.translate("removeMethod",av));
    Assert.assertEquals("set_mentor",generator.translate("setMethod",av));
    Assert.assertEquals("exit_mentor",generator.translate("exitMethod",av));
    Assert.assertEquals("get_mentor",generator.translate("getMethod",av));
    Assert.assertEquals("new_mentors",generator.translate("parameterMany",av));
    Assert.assertEquals("new_mentor",generator.translate("parameterNew",av));
    Assert.assertEquals("all_mentors",generator.translate("parameterAll",av));
    Assert.assertEquals("next_mentor",generator.translate("parameterNext",av));
    Assert.assertEquals("set_mentors",generator.translate("setManyMethod",av));
    Assert.assertEquals("did_add_mentors",generator.translate("didAddMany",av));
    Assert.assertEquals("did_add_mentor",generator.translate("didAdd",av));
    Assert.assertEquals("number_of_mentors",generator.translate("numberOfMethod",av));
    Assert.assertEquals("index_of_mentor",generator.translate("indexOfMethod",av));
    Assert.assertEquals("is_number_of_mentors_valid",generator.translate("isNumberOfValidMethod",av));
    Assert.assertEquals("verified_mentors",generator.translate("parameterVerifiedMany",av));
    Assert.assertEquals("old_mentors",generator.translate("parameterOldMany",av));
    Assert.assertEquals("old_mentor",generator.translate("parameterOld",av));
    Assert.assertEquals("existing_mentor",generator.translate("parameterExisting",av));
    Assert.assertEquals("existing_serialized_mentor",generator.translate("parameterExistingSerialized",av));
    Assert.assertEquals("check_new_mentors",generator.translate("parameterCheckNewMany",av));
    Assert.assertEquals("is_new_mentor",generator.translate("parameterIsNew",av));
    Assert.assertEquals("new_mentor",generator.translate("associationNew",av));
    Assert.assertEquals("copy_of_mentors",generator.translate("parameterCopyOfMany",av));
    Assert.assertEquals("can_set_mentor",generator.translate("canSetMethod",av));
    Assert.assertEquals("current_mentor",generator.translate("parameterCurrent",av));
    Assert.assertEquals("delete_mentor",generator.translate("deleteMethod",av));
    Assert.assertEquals("required_number_of_mentors",generator.translate("requiredNumberOfMethod",av));

    if (relatedAv == null)
    {
      return;
    }
    
    Assert.assertEquals("a_student",generator.translate("parameter",relatedAv));
    Assert.assertEquals("a_student",generator.translate("parameterOne",relatedAv));
    Assert.assertEquals("2",generator.translate("parameterValue",relatedAv));
    Assert.assertEquals("student",generator.translate("associationOne",relatedAv));
    Assert.assertEquals("students",generator.translate("associationMany",relatedAv));
    Assert.assertEquals("student",generator.translate("attributeOne",relatedAv));
    Assert.assertEquals("students",generator.translate("attributeMany",relatedAv));
    Assert.assertEquals("add_student",generator.translate("addMethod",relatedAv));
    Assert.assertEquals("add_student_via",generator.translate("addViaMethod",relatedAv));
    Assert.assertEquals("remove_student",generator.translate("removeMethod",relatedAv));
    Assert.assertEquals("set_student",generator.translate("setMethod",relatedAv));
    Assert.assertEquals("exit_student",generator.translate("exitMethod",relatedAv));
    Assert.assertEquals("get_student",generator.translate("getMethod",relatedAv));    
    Assert.assertEquals("new_students",generator.translate("parameterMany",relatedAv));
    Assert.assertEquals("new_student",generator.translate("parameterNew",relatedAv));
    Assert.assertEquals("all_students",generator.translate("parameterAll",relatedAv));
    Assert.assertEquals("next_student",generator.translate("parameterNext",relatedAv));
    Assert.assertEquals("set_students",generator.translate("setManyMethod",relatedAv));
    Assert.assertEquals("did_add_students",generator.translate("didAddMany",relatedAv));
    Assert.assertEquals("did_add_student",generator.translate("didAdd",relatedAv));
    Assert.assertEquals("number_of_students",generator.translate("numberOfMethod",relatedAv));
    Assert.assertEquals("index_of_student",generator.translate("indexOfMethod",relatedAv));
    Assert.assertEquals("is_number_of_students_valid",generator.translate("isNumberOfValidMethod",relatedAv));
    Assert.assertEquals("minimum_number_of_students",generator.translate("minimumNumberOfMethod",relatedAv));
    Assert.assertEquals("maximum_number_of_students",generator.translate("maximumNumberOfMethod",relatedAv));
    Assert.assertEquals("verified_students",generator.translate("parameterVerifiedMany",relatedAv));
    Assert.assertEquals("old_students",generator.translate("parameterOldMany",relatedAv));
    Assert.assertEquals("old_student",generator.translate("parameterOld",relatedAv));
    Assert.assertEquals("existing_student",generator.translate("parameterExisting",relatedAv));
    Assert.assertEquals("existing_serialized_student",generator.translate("parameterExistingSerialized",relatedAv));
    Assert.assertEquals("check_new_students",generator.translate("parameterCheckNewMany",relatedAv));
    Assert.assertEquals("is_new_student",generator.translate("parameterIsNew",relatedAv));
    Assert.assertEquals("new_student",generator.translate("associationNew",relatedAv));
    Assert.assertEquals("copy_of_students",generator.translate("parameterCopyOfMany",relatedAv));
    Assert.assertEquals("can_set_student",generator.translate("canSetMethod",relatedAv));
    Assert.assertEquals("current_student",generator.translate("parameterCurrent",relatedAv));
    Assert.assertEquals("delete_student",generator.translate("deleteMethod",relatedAv));
    Assert.assertEquals("required_number_of_students",generator.translate("requiredNumberOfMethod",relatedAv));
    

  }  
 
  private void assertTranslate(AssociationVariable av, AssociationVariable relatedAv)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.translate("blah", av));
    Assert.assertEquals("a_mentor",generator.translate("parameter",av));
    Assert.assertEquals("a_mentor",generator.translate("parameterOne",av));
    Assert.assertEquals("3",generator.translate("parameterValue",av));
    Assert.assertEquals("mentor",generator.translate("associationOne",av));
    Assert.assertEquals("mentors",generator.translate("associationMany",av));
    Assert.assertEquals("mentor",generator.translate("attributeOne",av));
    Assert.assertEquals("mentors",generator.translate("attributeMany",av));
    Assert.assertEquals("add_mentor",generator.translate("addMethod",av));
    Assert.assertEquals("add_mentor_via",generator.translate("addViaMethod",av));
    Assert.assertEquals("remove_mentor",generator.translate("removeMethod",av));
    Assert.assertEquals("set_mentor",generator.translate("setMethod",av));
    Assert.assertEquals("exit_mentor",generator.translate("exitMethod",av));
    Assert.assertEquals("get_mentor",generator.translate("getMethod",av));
    Assert.assertEquals("new_mentors",generator.translate("parameterMany",av));
    Assert.assertEquals("new_mentor",generator.translate("parameterNew",av));
    Assert.assertEquals("all_mentors",generator.translate("parameterAll",av));
    Assert.assertEquals("next_mentor",generator.translate("parameterNext",av));
    Assert.assertEquals("set_mentors",generator.translate("setManyMethod",av));
    Assert.assertEquals("did_add_mentors",generator.translate("didAddMany",av));
    Assert.assertEquals("did_add_mentor",generator.translate("didAdd",av));
    Assert.assertEquals("number_of_mentors",generator.translate("numberOfMethod",av));
    Assert.assertEquals("index_of_mentor",generator.translate("indexOfMethod",av));
    Assert.assertEquals("is_number_of_mentors_valid",generator.translate("isNumberOfValidMethod",av));
    Assert.assertEquals("verified_mentors",generator.translate("parameterVerifiedMany",av));
    Assert.assertEquals("old_mentors",generator.translate("parameterOldMany",av));
    Assert.assertEquals("old_mentor",generator.translate("parameterOld",av));
    Assert.assertEquals("existing_mentor",generator.translate("parameterExisting",av));
    Assert.assertEquals("existing_serialized_mentor",generator.translate("parameterExistingSerialized",av));
    Assert.assertEquals("check_new_mentors",generator.translate("parameterCheckNewMany",av));
    Assert.assertEquals("is_new_mentor",generator.translate("parameterIsNew",av));
    Assert.assertEquals("new_mentor",generator.translate("associationNew",av));
    Assert.assertEquals("copy_of_mentors",generator.translate("parameterCopyOfMany",av));
    Assert.assertEquals("can_set_mentor",generator.translate("canSetMethod",av));
    Assert.assertEquals("current_mentor",generator.translate("parameterCurrent",av));
    Assert.assertEquals("delete_mentor",generator.translate("deleteMethod",av));
    Assert.assertEquals("required_number_of_mentors",generator.translate("requiredNumberOfMethod",av));

    if (relatedAv == null)
    {
      return;
    }
    
    Assert.assertEquals("new_students",generator.translate("parameter",relatedAv));
    Assert.assertEquals("a_student",generator.translate("parameterOne",relatedAv));
    Assert.assertEquals("2",generator.translate("parameterValue",relatedAv));
    Assert.assertEquals("student",generator.translate("associationOne",relatedAv));
    Assert.assertEquals("students",generator.translate("associationMany",relatedAv));
    Assert.assertEquals("student",generator.translate("attributeOne",relatedAv));
    Assert.assertEquals("students",generator.translate("attributeMany",relatedAv));
    Assert.assertEquals("add_student",generator.translate("addMethod",relatedAv));
    Assert.assertEquals("add_student_via",generator.translate("addViaMethod",relatedAv));
    Assert.assertEquals("remove_student",generator.translate("removeMethod",relatedAv));
    Assert.assertEquals("set_student",generator.translate("setMethod",relatedAv));
    Assert.assertEquals("exit_student",generator.translate("exitMethod",relatedAv));
    Assert.assertEquals("get_student",generator.translate("getMethod",relatedAv));    
    Assert.assertEquals("new_students",generator.translate("parameterMany",relatedAv));
    Assert.assertEquals("new_student",generator.translate("parameterNew",relatedAv));
    Assert.assertEquals("all_students",generator.translate("parameterAll",relatedAv));
    Assert.assertEquals("next_student",generator.translate("parameterNext",relatedAv));
    Assert.assertEquals("set_students",generator.translate("setManyMethod",relatedAv));
    Assert.assertEquals("did_add_students",generator.translate("didAddMany",relatedAv));
    Assert.assertEquals("did_add_student",generator.translate("didAdd",relatedAv));
    Assert.assertEquals("number_of_students",generator.translate("numberOfMethod",relatedAv));
    Assert.assertEquals("index_of_student",generator.translate("indexOfMethod",relatedAv));
    Assert.assertEquals("is_number_of_students_valid",generator.translate("isNumberOfValidMethod",relatedAv));
    Assert.assertEquals("minimum_number_of_students",generator.translate("minimumNumberOfMethod",relatedAv));
    Assert.assertEquals("maximum_number_of_students",generator.translate("maximumNumberOfMethod",relatedAv));
    Assert.assertEquals("verified_students",generator.translate("parameterVerifiedMany",relatedAv));
    Assert.assertEquals("old_students",generator.translate("parameterOldMany",relatedAv));
    Assert.assertEquals("old_student",generator.translate("parameterOld",relatedAv));
    Assert.assertEquals("existing_student",generator.translate("parameterExisting",relatedAv));
    Assert.assertEquals("existing_serialized_student",generator.translate("parameterExistingSerialized",relatedAv));
    Assert.assertEquals("check_new_students",generator.translate("parameterCheckNewMany",relatedAv));
    Assert.assertEquals("is_new_student",generator.translate("parameterIsNew",relatedAv));
    Assert.assertEquals("new_student",generator.translate("associationNew",relatedAv));
    Assert.assertEquals("copy_of_students",generator.translate("parameterCopyOfMany",relatedAv));
    Assert.assertEquals("can_set_student",generator.translate("canSetMethod",relatedAv));
    Assert.assertEquals("current_student",generator.translate("parameterCurrent",relatedAv));
    Assert.assertEquals("delete_student",generator.translate("deleteMethod",relatedAv));
    Assert.assertEquals("required_number_of_students",generator.translate("requiredNumberOfMethod",relatedAv));
    

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
    Assert.assertEquals("a_id",g.getLookup("constructorSignature"));
    Assert.assertEquals("a_id",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("a_name",g2.getLookup("constructorSignature"));
    Assert.assertEquals("a_name",g2.getLookup("constructorSignature_caller"));  
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
