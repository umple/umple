/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

/**
 * @umplesource Generator.ump 55
 * @umplesource Generator_CodePapyrus.ump 12
 */
// line 55 "../../../../src/Generator.ump"
// line 12 "../../../../src/Generator_CodePapyrus.ump"
public class PapyrusGenerator implements CodeGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PapyrusGenerator Attributes
  private UmpleModel model;
  private String output;
  private String smName;
  private String diagramID;
  private String smID;
  private String regionID;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PapyrusGenerator()
  {
    model = null;
    output = "";
    smName = null;
    diagramID = generatePapyrusID();
    smID = generatePapyrusID();
    regionID = generatePapyrusID();
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

  public boolean setSmName(String aSmName)
  {
    boolean wasSet = false;
    smName = aSmName;
    wasSet = true;
    return wasSet;
  }

  public boolean setDiagramID(String aDiagramID)
  {
    boolean wasSet = false;
    diagramID = aDiagramID;
    wasSet = true;
    return wasSet;
  }

  public boolean setSmID(String aSmID)
  {
    boolean wasSet = false;
    smID = aSmID;
    wasSet = true;
    return wasSet;
  }

  public boolean setRegionID(String aRegionID)
  {
    boolean wasSet = false;
    regionID = aRegionID;
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

  public String getSmName()
  {
    return smName;
  }

  public String getDiagramID()
  {
    return diagramID;
  }

  public String getSmID()
  {
    return smID;
  }

  public String getRegionID()
  {
    return regionID;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "," +
            "smName" + ":" + getSmName()+ "," +
            "diagramID" + ":" + getDiagramID()+ "," +
            "smID" + ":" + getSmID()+ "," +
            "regionID" + ":" + getRegionID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + getModel() != null ? !getModel() .equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 21 ../../../../src/Generator_CodePapyrus.ump
  public void generate()
  {
    boolean hasStateMachine = false; //true if the umple file has one or more state machines in it.
    boolean hasClassDiagram = false; //true if the umple file has one or more class diagrams in it.
    StringBuilder code = new StringBuilder();
    StringBuilder smcode = new StringBuilder(); //Holds the xml for state machines in the umple file
    StringBuilder smSubCode = new StringBuilder();
    StringBuilder subCode;
    ArrayList<StateMachine> allStateMachines = new ArrayList<StateMachine>();
    ArrayList<Association> allAssociations = new ArrayList<Association>();

    code.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

    boolean isFirst = true;
    int packageAssociationIndex = 0;
    for (UmpleClass uClass : model.getUmpleClasses())
    {

      if(!uClass.hasStateMachines())
      {
        hasClassDiagram = true;
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
        code.append("  </packagedElement>\n");
        code.append(subCode.toString());
      }
      for (StateMachine sm : uClass.getStateMachines())
      {
        hasStateMachine = true;
        smName = sm.getName();
        smcode.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        smcode.append(StringFormatter.format("<uml:Model xmi:version=\"2.1\" xmlns:xmi=\"http://schema.omg.org/spec/XMI/2.1\" xmlns:uml=\"http://www.eclipse.org/uml2/3.0.0/UML\" xmi:id=\"_{0}\" name=\"model\">\n",model.getUmpleFile().getSimpleFileName()));
        smcode.append(StringFormatter.format("  <packagedElement xmi:type=\"uml:StateMachine\" xmi:id=\"_{0}\" name=\"{1}\">\n",smID, sm.getName()));
        smcode.append(StringFormatter.format("    <region xmi:id=\"_{0}\" name=\"Region0\">\n",regionID));

        for (State s : sm.getStates())
        {
          int numActions = s.numberOfActions();

          if(numActions > 0){
          smcode.append(StringFormatter.format("      <subvertex xmi:type=\"uml:State\" xmi:id=\"_{0}\" name=\"{0}\">\n",s.getName()));
          }
          else{
          smcode.append(StringFormatter.format("      <subvertex xmi:type=\"uml:State\" xmi:id=\"_{0}\" name=\"{0}\"/>\n",s.getName()));
          }
          for (Action a : s.getActions()){
            smcode.append(StringFormatter.format("        <connectionPoint xmi:id=\"_{0}\" name=\"{1}\" kind=\"{2}Point\"/>\n",generatePapyrusID(), a.getActionCode(), a.getActionType() ));
            smcode.append(StringFormatter.format("        <region xmi:id=\"_{0}\" name=\"Region0\"/>\n",generatePapyrusID() ));
          }
          if(numActions > 0){
            smcode.append("      </subvertex>\n");
          }

          for (Transition t : s.getTransitions())
          {
            smSubCode.append(StringFormatter.format("      <transition xmi:id=\"_{0}\" name=\"{0}\" source=\"_{1}\" target=\"_{2}\"/>\n",t.getEvent().getName(), t.getFromState().getName(), t.getNextState().getName() ));
          }
        }
        smcode.append(smSubCode.toString());
        smcode.append("    </region>\n");
        smcode.append("  </packagedElement>\n");
        smcode.append("</uml:Model>");
      }
    }

    boolean isFirstInterface = model.hasUmpleInterfaces() ? true : false;
    for (UmpleInterface uInterface : model.getUmpleInterfaces())
    {
      if (isFirstInterface)
      {
        isFirstInterface = false;
        String clientDependency = StringFormatter.format(" clientDependency=\"{0}-_interfaceRealization.0\"",uInterface.getName()) ;
        String packageType = "uml:Interface";
        code.append(StringFormatter.format("  <packagedElement xmi:type=\"{1}\" xmi:id=\"{0}\" name=\"{0}\"/>\n",uInterface.getName(),packageType,clientDependency));
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


   //At this point calls the writeModel() function to write the contents of code to a file.
   //to facilitate loading into Papyrus, it creates a directory with the name of the umple file
   //and calls the uml file generated model.uml

    if(hasStateMachine)
    {
      model.setCode(smcode.toString());
      writeModel(false);
      writeModNotation(false); // model.notation
      writeModDI(false); // model.di
      writeModProject(); //.project
    }

    if(hasClassDiagram){
    model.setCode(code.toString());
    writeModel(true);
    writeModNotation(true); // model.notation
    writeModDI(true); // model.di
    writeModProject(); //.project
    }

  }

  //This method generates random ID's to be used in 'model.notation'
  private String generatePapyrusID(){
     final String ALPHA_NUM = "012345ABCDEFGHIJKLMNOPQRSTUWXYZavkilrms";
     final int ID_LENGTH = 22;
     String id = "";

    for (int i=0; i<ID_LENGTH; i++){
      id += ALPHA_NUM.charAt((int) (Math.random() * ALPHA_NUM.length()));
    }
    return id;
  }

  // Creates a "model.notation" file. This file specifies the visual layout and style of the diagram.
  // As currently created, it is very bare bones. To increase Papyrus functionality, you will need to improve this function.
  private void writeModNotation(boolean isClassDiagram)
  {
    try {
      String path = model.getUmpleFile().getPath();
      StringBuilder noteCode = new StringBuilder();
      String modelFilename = null;

      noteCode.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

      if(isClassDiagram)
      {
      noteCode.append("<notation:Diagram xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:notation=\"http://www.eclipse.org/gmf/runtime/1.0.2/notation\"");
      noteCode.append(StringFormatter.format(" xmlns:uml=\"http://www.eclipse.org/uml2/3.0.0/UML\" xmi:id=\"_{0}\"",diagramID));
      noteCode.append(StringFormatter.format(" type=\"PapyrusUMLClassDiagram\" name=\"{0}\" measurementUnit=\"Pixel\">\n",model.getUmpleFile().getSimpleFileName()));
      noteCode.append(StringFormatter.format("  <styles xmi:type=\"notation:DiagramStyle\" xmi:id=\"_{0}DiagramStyle\"/>\n",model.getUmpleFile().getSimpleFileName()));
      noteCode.append(StringFormatter.format("  <element xmi:type=\"uml:Model\" href=\"model.uml#_{0}\"/>\n",model.getUmpleFile().getSimpleFileName()));
      noteCode.append("</notation:Diagram>\n");

      modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + File.separator + "model.notation";
      }

      else{
      noteCode.append("<notation:Diagram xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" xmlns:notation=\"http://www.eclipse.org/gmf/runtime/1.0.2/notation\"");
      noteCode.append(StringFormatter.format(" xmlns:uml=\"http://www.eclipse.org/uml2/3.0.0/UML\" xmi:id=\"_{0}\"", diagramID));
      noteCode.append(StringFormatter.format(" type=\"PapyrusUMLStateMachineDiagram\" name=\"{0}\" measurementUnit=\"Pixel\">\n",smName));
      noteCode.append(StringFormatter.format("  <children xmi:type=\"notation:Shape\" xmi:id=\"_{0}\" type=\"2000\" fontName=\"Lucida Grande\" fontHeight=\"11\" lineColor=\"0\">\n",generatePapyrusID()));
      noteCode.append(StringFormatter.format("    <children xmi:type=\"notation:DecorationNode\" xmi:id=\"_{0}\" type=\"2001\">\n",generatePapyrusID()));
      noteCode.append(StringFormatter.format("      <layoutConstraint xmi:type=\"notation:Bounds\" xmi:id=\"_{0}\" width=\"700\" height=\"13\"/>\n",generatePapyrusID()));
      noteCode.append                       ("    </children>\n");
      noteCode.append(StringFormatter.format("    <children xmi:type=\"notation:DecorationNode\" xmi:id=\"_{0}\" type=\"2002\">\n",generatePapyrusID()));
      noteCode.append(StringFormatter.format("      <children xmi:type=\"notation:Shape\" xmi:id=\"_{0}\" type=\"3000\" fontName=\"Lucida Grande\" fontHeight=\"11\" lineColor=\"0\">\n",generatePapyrusID()));
      noteCode.append(StringFormatter.format("        <eAnnotations xmi:type=\"ecore:EAnnotation\" xmi:id=\"_{0}\" source=\"RegionAnnotationKey\">\n",generatePapyrusID()));
      noteCode.append(StringFormatter.format("          <details xmi:type=\"ecore:EStringToStringMapEntry\" xmi:id=\"_{0}\" key=\"RegionZoneKey\" value=\"\"/>\n",generatePapyrusID()));
      noteCode.append                       ("        </eAnnotations>\n");
      noteCode.append(StringFormatter.format("        <children xmi:type=\"notation:DecorationNode\" xmi:id=\"_{0}\" type=\"3002\">\n",generatePapyrusID()));
      noteCode.append(StringFormatter.format("          <layoutConstraint xmi:type=\"notation:Bounds\" xmi:id=\"_{0}\"/>\n",generatePapyrusID()));
      noteCode.append                       ("        </children>\n");
      noteCode.append(StringFormatter.format("        <element xmi:type=\"uml:Region\" href=\"{0}.uml#_{1}\"/>\n",smName, regionID));
      noteCode.append(StringFormatter.format("        <layoutConstraint xmi:type=\"notation:Bounds\" xmi:id=\"_{0}\" width=\"700\" height=\"287\"/>\n",generatePapyrusID()));
      noteCode.append                       ("      </children>\n");
      noteCode.append(StringFormatter.format("      <layoutConstraint xmi:type=\"notation:Bounds\" xmi:id=\"_{0}\" y=\"13\" width=\"700\" height=\"287\"/>\n",generatePapyrusID()));
      noteCode.append                       ("    </children>\n");
      noteCode.append(StringFormatter.format("    <element xmi:type=\"uml:StateMachine\" href=\"{0}.uml#_{1}\"/>\n",smName, smID));
      noteCode.append(StringFormatter.format("    <layoutConstraint xmi:type=\"notation:Bounds\" xmi:id=\"_{0}\" x=\"30\" y=\"30\" width=\"700\" height=\"300\"/>\n",generatePapyrusID()));
      noteCode.append                       ("  </children>\n");
      noteCode.append(StringFormatter.format("  <styles xmi:type=\"notation:DiagramStyle\" xmi:id=\"_{0}\"/>\n",generatePapyrusID()));
      noteCode.append(StringFormatter.format("  <element xmi:type=\"uml:StateMachine\" href=\"{0}.uml#_{1}\"/>\n",smName, smID));
      noteCode.append                       ("</notation:Diagram>\n");

      modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + File.separator + smName + ".notation";
      }
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(noteCode.toString());
      bw.flush();
      bw.close();

    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating Xmi code." + e, e);
    }
  }

  // Creates a "model.di" file. This file specifies what types of models are part of the Papyrus project.
  private void writeModDI(boolean isClassDiagram)
  {
    try {
      String path = model.getUmpleFile().getPath();
      StringBuilder diCode = new StringBuilder();
      String modelFilename = null;
      if(isClassDiagram){
        diCode.append("<?xml version=\"1.0\" encoding=\"ASCII\"?>\n");
        diCode.append("<di:SashWindowsMngr xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:di=\"http://www.eclipse.org/papyrus/0.7.0/sashdi\">\n");
        diCode.append("  <pageList>\n    <availablePage>\n");
        diCode.append(StringFormatter.format("      <emfPageIdentifier href=\"model.notation#_{0}\"/>\n",diagramID));
        diCode.append("    </availablePage>\n  </pageList>\n");
        diCode.append("  <sashModel currentSelection=\"//@sashModel/@windows.0/@children.0\">\n");
        diCode.append("    <windows>\n      <children xsi:type=\"di:TabFolder\">\n        <children>\n");
        diCode.append(StringFormatter.format("          <emfPageIdentifier href=\"model.notation#_{0}\"/>\n",diagramID));
        diCode.append("        </children>\n      </children>\n    </windows>\n");
        diCode.append("  </sashModel>\n</di:SashWindowsMngr>\n");

        modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + File.separator + "model.di";
      }
      else{
        diCode.append("<?xml version=\"1.0\" encoding=\"ASCII\"?>\n");
        diCode.append("<di:SashWindowsMngr xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:di=\"http://www.eclipse.org/papyrus/0.7.0/sashdi\">\n");
        diCode.append("  <pageList>\n    <availablePage>\n");
        diCode.append(StringFormatter.format("      <emfPageIdentifier href=\"{0}.notation#_{1}\"/>\n",smName, diagramID));
        diCode.append("    </availablePage>\n  </pageList>\n");
        diCode.append("  <sashModel currentSelection=\"//@sashModel/@windows.0/@children.0\">\n");
        diCode.append("    <windows>\n      <children xsi:type=\"di:TabFolder\">\n        <children>\n");
        diCode.append(StringFormatter.format("          <emfPageIdentifier href=\"{0}.notation#_{1}\"/>\n",smName, diagramID));
        diCode.append("        </children>\n      </children>\n    </windows>\n");
        diCode.append("  </sashModel>\n</di:SashWindowsMngr>\n");

        modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + File.separator + smName + ".di";
      }

        BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
        bw.write(diCode.toString());
        bw.flush();
        bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating Xmi code." + e, e);
    }
  }

  // Creates a ".project" file for Eclipse. This allows the Papyrus output to be easily loaded into Eclipse for editing.
  private void writeModProject()
  {
    try {
      String path = model.getUmpleFile().getPath();
      StringBuilder projectCode = new StringBuilder();

      projectCode.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
      projectCode.append("<projectDescription>\n");
      projectCode.append(StringFormatter.format("    <name>{0}</name>\n",model.getUmpleFile().getSimpleFileName()));
      projectCode.append("    <comment></comment>\n    <projects>\n    </projects>\n");
      projectCode.append("    <buildSpec>\n    </buildSpec>\n    <natures>\n    </natures>\n");
      projectCode.append("</projectDescription>\n");

      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + File.separator + ".project";
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(projectCode.toString());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating Xmi code." + e, e);
    }

  }

  // Creates a "model.uml" file. This specifies the mechanical attributes and relationships of the classes and associations in the diagram.
  // The code generation for this file is done above, in the 'generate()' function.
  private void writeModel(boolean isClassDiagram)
  {
    try
    {
      String path = model.getUmpleFile().getPath();
      File file = new File(path);
      file.mkdirs();

      File file2 = new File(path + File.separator + model.getUmpleFile().getSimpleFileName());
      file2.mkdirs();

      String modelFilename = null;

      if(isClassDiagram){
      modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + File.separator + "model.uml";
      }
      else{
      modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + File.separator + smName+ ".uml";
      }

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