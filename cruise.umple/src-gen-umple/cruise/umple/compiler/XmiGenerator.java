/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

/**
 * @umplesource Generator.ump 69
 * @umplesource Generator_CodeXmi.ump 12
 */
// line 69 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodeXmi.ump"
public class XmiGenerator implements CodeGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //XmiGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public XmiGenerator()
  {
    model = null;
    output = "";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public boolean setOutput(String aOutput)
  {
    boolean wasSet = false;
    output = aOutput;
    wasSet = true;
    return wasSet;
  }

  /**
   * Contains various aspects from an Umple file (.ump), such as classes, attributes, associations and methods.  Generated output is based
   * off of what's contained in here.
   */
  public UmpleModel getModel()
  {
    return model;
  }

  public String getOutput()
  {
    return output;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + getModel() != null ? !getModel() .equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 15 ../../../../src/Generator_CodeXmi.ump
  public void generate()
  {
    StringBuilder code = new StringBuilder();
    StringBuilder subCode;
    ArrayList<Association> allAssociations = new ArrayList<Association>();

    code.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

    boolean isFirst = true;
    int packageAssociationIndex = 0;
    for (UmpleClass uClass : model.getUmpleClasses())
    {
      subCode = new StringBuilder();
      if (isFirst)
      {
        isFirst = false;

        code.append(StringFormatter.format("<uml:Package xmi:version=\"2.1\" xmlns:xmi=\"http://schema.omg.org/spec/XMI/2.1\" xmlns:uml=\"http://www.eclipse.org/uml2/3.0.0/UML\" xmi:id=\"_0\" name=\"{0}\">\n",uClass.getPackageName()));
        code.append("  <packageImport xmi:id=\"_packageImport.0\" importedPackage=\"dataType\"/>\n");
        code.append("  <packagedElement xmi:type=\"uml:Package\" xmi:id=\"dataType\" name=\"dataType\">\n");
        code.append("    <packagedElement xmi:type=\"uml:PrimitiveType\" xmi:id=\"dataType-String\" name=\"String\"/>\n");
        code.append("    <packagedElement xmi:type=\"uml:PrimitiveType\" xmi:id=\"dataType-Integer\" name=\"Integer\"/>\n");
        code.append("    <packagedElement xmi:type=\"uml:PrimitiveType\" xmi:id=\"dataType-Double\" name=\"Double\"/>\n");
        code.append("    <packagedElement xmi:type=\"uml:PrimitiveType\" xmi:id=\"dataType-Date\" name=\"Date\"/>\n");
        code.append("    <packagedElement xmi:type=\"uml:PrimitiveType\" xmi:id=\"dataType-Time\" name=\"Time\"/>\n");
        code.append("    <packagedElement xmi:type=\"uml:PrimitiveType\" xmi:id=\"dataType-Boolean\" name=\"Boolean\"/>\n");
        code.append("  </packagedElement>\n");
      }

      String packageType = "uml:Class"; 
      code.append(StringFormatter.format("  <packagedElement xmi:type=\"{1}\" xmi:id=\"{0}\" name=\"{0}\">\n",uClass.getName(),packageType));

      if (uClass.getExtendsClass() != null)
      {
        code.append(StringFormatter.format("    <generalization xmi:id=\"{0}-_generalization.0\" general=\"{1}\"/>\n",uClass.getName(),uClass.getExtendsClass().getName()));
      }

      String implementedInterfaces="";
      if (uClass.hasParentInterface()){
        for (UmpleInterface uInterface : uClass.getParentInterface())
        {
          implementedInterfaces += uInterface.getName() + "," ; 
        }
        implementedInterfaces = implementedInterfaces.substring(0, implementedInterfaces.length()-1);	
        code.append(StringFormatter.format("    <interfaceRealization xmi:id=\"{0}-_interfaceRealization.0\" supplier=\"{1}\" client=\"{0}\" contract=\"{1}\"/>\n",uClass.getName(),implementedInterfaces));
      }

      for(Attribute av : uClass.getAttributes())
      {
        String typeName = av.getType() == null ? "String" : av.getType();
        if (av.isPrimitive())
        {
          typeName = StringFormatter.format("dataType-{0}",typeName);
        } 

        code.append(StringFormatter.format("    <ownedAttribute xmi:id=\"{0}-{1}\" name=\"{1}\" visibility=\"private\" type=\"{2}\">\n",uClass.getName(),av.getName(),typeName));
        code.append(StringFormatter.format("      <upperValue xmi:type=\"uml:LiteralUnlimitedNatural\" xmi:id=\"{0}-{1}-_upperValue\" value=\"1\"/>\n",uClass.getName(),av.getName()));
        code.append(StringFormatter.format("      <lowerValue xmi:type=\"uml:LiteralUnlimitedNatural\" xmi:id=\"{0}-{1}-_lowerValue\" value=\"1\"/>\n",uClass.getName(),av.getName()));
        code.append("    </ownedAttribute>\n");
      }

      for(Association as : uClass.getAssociations())
      {
        if (allAssociations.contains(as))
        {
          continue;
        }
        allAssociations.add(as);
        AssociationEnd left = as.getEnd(0);
        AssociationEnd right = as.getEnd(1);
        String[] leftRange = left.getMultiplicity().getRangeParts();
        String[] rightRange = right.getMultiplicity().getRangeParts();

        String associationId = as.getName() == null ? StringFormatter.format("_packagedElement.{0}",packageAssociationIndex) : as.getName();
        String associationName = as.getName() == null ? "" : StringFormatter.format(" name=\"{0}\"",as.getName());

        subCode.append(StringFormatter.format("  <packagedElement xmi:type=\"uml:Association\" xmi:id=\"{0}\"{3} memberEnd=\"{0}-{1} {0}-{2}\" navigableOwnedEnd=\"{0}-{1} {0}-{2}\">\n",associationId,left.getRoleName(),right.getRoleName(),associationName));

        subCode.append(StringFormatter.format("    <ownedEnd xmi:id=\"{0}-{1}\" name=\"{1}\" type=\"{2}\" association=\"{0}\">\n",associationId,left.getRoleName(),left.getClassName()));
        subCode.append(StringFormatter.format("      <upperValue xmi:type=\"uml:LiteralUnlimitedNatural\" xmi:id=\"{0}-{1}-_upperValue\" value=\"{2}\"/>\n",associationId,left.getRoleName(),leftRange[1]));
        subCode.append(StringFormatter.format("      <lowerValue xmi:type=\"uml:LiteralInteger\" xmi:id=\"{0}-{1}-_lowerValue\" value=\"{2}\"/>\n",associationId,left.getRoleName(),leftRange[0]));
        subCode.append("    </ownedEnd>\n");
        subCode.append(StringFormatter.format("    <ownedEnd xmi:id=\"{0}-{1}\" name=\"{1}\" type=\"{2}\" association=\"{0}\">\n",associationId,right.getRoleName(),right.getClassName()));
        subCode.append(StringFormatter.format("      <upperValue xmi:type=\"uml:LiteralUnlimitedNatural\" xmi:id=\"{0}-{1}-_upperValue\" value=\"{2}\"/>\n",associationId,right.getRoleName(),rightRange[1]));
        subCode.append(StringFormatter.format("      <lowerValue xmi:type=\"uml:LiteralInteger\" xmi:id=\"{0}-{1}-_lowerValue\" value=\"{2}\"/>\n",associationId,right.getRoleName(),rightRange[0]));
        subCode.append("    </ownedEnd>\n");
        subCode.append("  </packagedElement>\n");
        packageAssociationIndex += 1;          
      }

      for (StateMachine sm : uClass.getStateMachines())
      {
        if ("Simple".equals(sm.getType()))
        {
          String enumerationName = StringFormatter.toPascalCase(sm.getName());
          code.append(StringFormatter.format("    <ownedAttribute xmi:id=\"{0}-{1}\" name=\"{1}\" visibility=\"private\" type=\"{2}\">\n",uClass.getName(),sm.getName(),enumerationName));
          code.append(StringFormatter.format("      <upperValue xmi:type=\"uml:LiteralUnlimitedNatural\" xmi:id=\"{0}-{1}-_upperValue\" value=\"1\"/>\n",uClass.getName(),sm.getName()));
          code.append(StringFormatter.format("      <lowerValue xmi:type=\"uml:LiteralUnlimitedNatural\" xmi:id=\"{0}-{1}-_lowerValue\" value=\"1\"/>\n",uClass.getName(),sm.getName()));
          code.append("    </ownedAttribute>\n");

          subCode.append(StringFormatter.format("  <packagedElement xmi:type=\"uml:Enumeration\" xmi:id=\"{0}\" name=\"{0}\">\n",enumerationName));
          for (State s : sm.getStates())
          {
            subCode.append(StringFormatter.format("    <ownedLiteral xmi:id=\"{0}-{1}\" name=\"{1}\"/>\n",enumerationName,s.getName()));
          }
          subCode.append("  </packagedElement>\n");
        }
      }

      code.append("  </packagedElement>\n");
      code.append(subCode.toString());
    }
    boolean isFirstInterface = model.hasUmpleInterfaces() ? true : false;
    for (UmpleInterface uInterface : model.getUmpleInterfaces())
    {
      if (isFirstInterface)
      {
        isFirstInterface = false;
        String clientDependency = StringFormatter.format(" clientDependency=\"{0}-_interfaceRealization.0\"",uInterface.getName()) ;
        String packageType = "uml:Interface"; 
        code.append(StringFormatter.format("  <packagedElement xmi:type=\"{1}\" xmi:id=\"{0}\" name=\"{0}\">\n",uInterface.getName(),packageType,clientDependency));
      }
    }

    if (!isFirst && !isFirstInterface)
    {
      code.append("</uml:Package>\n");
    }

    model.setCode(code.toString());
    writeModel();
  }

  private void writeModel()
  {
    try
    {
      String path = model.getUmpleFile().getPath();
      File file = new File(path);
      file.mkdirs();
      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + ".uml";
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(model.getCode());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating Xmi code." + e, e);
    }
  }
}