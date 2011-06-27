/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.12.1.605 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

public class PapyrusGenerator implements CodeGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PapyrusGenerator Attributes
  private UmpleModel model;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PapyrusGenerator()
  {
    model = null;
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

  public UmpleModel getModel()
  {
    return model;
  }

  public void delete()
  {}

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
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
        
        code.append(StringFormatter.format("<uml:Model xmi:version=\"2.1\" xmlns:xmi=\"http://schema.omg.org/spec/XMI/2.1\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" xmlns:uml=\"http://www.eclipse.org/uml2/2.1.0/UML\" xmi:id=\"_{0}\" name=\"{0}\">\n",model.getUmpleFile().getSimpleFileName()));
        code.append(StringFormatter.format("  <packageImport xmi:id=\"_packageImport.0\">\n"));
        code.append(StringFormatter.format("    <importedPackage xmi:type=\"uml:Model\" href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#_0\"/>\n"));
        code.append(StringFormatter.format("  </packageImport>\n"));
        code.append("  <packagedElement xmi:type=\"uml:Model\" xmi:id=\"dataType\" name=\"dataType\">\n");
        code.append("    <packagedElement xmi:type=\"uml:PrimitiveType\" xmi:id=\"dataType-Time\" name=\"Time\"/>\n");
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

        if (typeName.equals("String") || typeName.equals("Integer") || typeName.equals("Boolean"))
        {
          code.append(StringFormatter.format("    <ownedAttribute xmi:id=\"{0}-{1}\" name=\"{1}\" visibility=\"private\">\n",uClass.getName(),av.getName()));
          code.append(StringFormatter.format("      <type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml#{0}\"/>\n",typeName));
        }
        else if (typeName.equals("Double") || typeName.equals("Date"))
        { 
          code.append(StringFormatter.format("    <ownedAttribute xmi:id=\"{0}-{1}\" name=\"{1}\" visibility=\"private\">\n",uClass.getName(),av.getName()));
          code.append(StringFormatter.format("      <type xmi:type=\"uml:PrimitiveType\" href=\"pathmap://UML_METAMODELS/Ecore.metamodel.uml#E{0}\"/>\n",typeName));
        }
        else if (av.isPrimitive())
        {
          typeName = StringFormatter.format("dataType-{0}",typeName);
          code.append(StringFormatter.format("    <ownedAttribute xmi:id=\"{0}-{1}\" name=\"{1}\" visibility=\"private\" type=\"{2}\">\n",uClass.getName(),av.getName(),typeName));
        } 

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
      code.append("  <profileApplication xmi:id=\"_profileApplication.0\">\n");
      code.append("    <eAnnotations xmi:id=\"_eAnnotations.0\" source=\"http://www.eclipse.org/uml2/2.0.0/UML\">\n");
      code.append("      <references xmi:type=\"ecore:EPackage\" href=\"http://www.eclipse.org/uml2/schemas/Standard/1#/\"/>\n");
      code.append("    </eAnnotations>\n");
      code.append("    <appliedProfile href=\"pathmap://UML_PROFILES/Standard.profile.uml#_0\"/>\n");
      code.append("  </profileApplication>\n");
      code.append("</uml:Model>\n");
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