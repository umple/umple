/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

/**
 * @umplesource Generator.ump 56
 * @umplesource Generator_CodeEcore.ump 11
 */
// line 56 "../../../../src/Generator.ump"
// line 11 "../../../../src/Generator_CodeEcore.ump"
public class EcoreGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EcoreGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EcoreGenerator()
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

  @umplesourcefile(line={17},file={"Generator_CodeEcore.ump"},javaline={78},length={194})
   public void generate(){
    StringBuilder code = new StringBuilder();
    StringBuilder subCode;
    String packageName;
    String nsURI;
    List<String> allTypes = new ArrayList<String>();
    List<String> interfacesProcessed = new ArrayList<String>();

    code.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");

    boolean isFirst = true;
    for (UmpleClass uClass : model.getUmpleClasses())
    {
      subCode = new StringBuilder();
      if (isFirst)
      {
        isFirst = false;
        packageName = getTargetNamespaceName();
        nsURI = model.getDefaultNamespace() != null ? model.getDefaultNamespace(): model.getUmpleFile().getSimpleFileName();
        code.append(StringFormatter.format("<ecore:EPackage xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"{0}\" nsURI=\"{1}\" nsPrefix=\"{0}\">\n",packageName, nsURI));
        code.append(StringFormatter.format("  <eClassifiers xsi:type=\"ecore:EDataType\" name=\"Time\" instanceClassName=\"java.sql.Time\"/>\n"));
      }

      String superStructureFlag = "";
      String interfaceFlag = "";
      String abstractFlag = "";
      if (uClass.getExtendsClass() != null)
      {
        superStructureFlag = StringFormatter.format(" eSuperTypes=\"#//{0}\"",uClass.getExtendsClass().getName()); 
      }
      else if (uClass.hasParentInterface()){
        // add class element attributes
		List<UmpleInterface> uInterfaces = uClass.getParentInterface();
		StringBuilder interfacesToken = new StringBuilder();
		interfacesToken.append(" eSuperTypes=\"");
		for (UmpleInterface uInterface : uInterfaces) {
			if (interfacesToken.toString().contains("#//"))
				interfacesToken.append(" ");
			interfacesToken.append("#//" + uInterface.getName());
		}
		interfacesToken.append("\"");
		
		superStructureFlag = interfacesToken.toString();
		interfaceFlag = " interface=\"true\"";
		abstractFlag = "abstract=\"true\"";

		// add interfaces
		for (UmpleInterface uInterface : uInterfaces) {
			if (!(interfacesProcessed.contains(uInterface.getName()))) {
				interfacesProcessed.add(uInterface.getName());
				code.append(StringFormatter
						.format("  <eClassifiers xsi:type=\"ecore:EClass\" name=\"{0}\"{1} {2}>\n",
								uInterface.getName(), interfaceFlag,
								abstractFlag));
				code.append("  </eClassifiers>\n");
			}
		}
      }

      code.append(StringFormatter.format("  <eClassifiers xsi:type=\"ecore:EClass\" name=\"{0}\"{1}>\n",uClass.getName(),superStructureFlag));

      for(Attribute av : uClass.getAttributes())
      {
        String typeName = av.getType() == null ? "String" : av.getType();
        String upperBound = av.getIsList() ? " upperBound=\"-1\"" : "";
        String attrName = av.getIsList() ? model.getGlossary().getPlural(av.getName()) : model.getGlossary().getSingular(av.getName());

        if (typeName.equals("String") || typeName.equals("Boolean") || typeName.equals("Double") || typeName.equals("Date"))
        {
          code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"{0}\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//E{1}\"{2}/>\n",attrName,typeName,upperBound));
        }
        else if (typeName.equals("Integer"))
        {
          code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"{0}\" eType=\"ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//EInt\"{1}/>`\n",attrName,upperBound));
        }
        else if (typeName.equals("Time"))
        {
          code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"{0}\" eType=\"#//Time\"{1}/>\n",attrName,upperBound));        
        }
        else if (model.getUmpleClass(typeName) != null)
        {
          code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"{0}\" eType=\"#//{1}\"{2}/>\n",attrName,typeName,upperBound));
        }
        else
        {
          String safeType = typeName;
          safeType = safeType.replace("<", "%3C");
          safeType = safeType.replace(",","%2C");
          safeType = safeType.replace(">", "%3E");

          String safeType2 = typeName;
          safeType2 = safeType2.replace("<", "&lt;");
          String lookupType = typeName;
          int ltIndex = lookupType.indexOf("<");

          if (ltIndex >= 0)
          {
            lookupType = lookupType.substring(0,ltIndex);
          }
          code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"{0}\" eType=\"#//{1}\"{2}/>\n",attrName,safeType,upperBound));

          if (!allTypes.contains(safeType))
          {
            allTypes.add(safeType);
            String typeInstanceClassName = getFullyQualifiedName("java.lang",lookupType);

            if (typeInstanceClassName == null)
            {
              for (Depend d : uClass.getDepends())
              {
                typeInstanceClassName = getFullyQualifiedName(d.getPackageName(), lookupType);
                if (typeInstanceClassName != null)
                {
                  break;
                }
              }
            }
            if (typeInstanceClassName != null)
            {
              subCode.append(StringFormatter.format("  <eClassifiers xsi:type=\"ecore:EDataType\" name=\"{0}\" instanceClassName=\"{1}\"/>\n",safeType2,typeInstanceClassName)); 
            }
            else
            {
              subCode.append(StringFormatter.format("  <eClassifiers xsi:type=\"ecore:EDataType\" name=\"{0}\"/>\n",safeType2));
            }
          }

        }
      }

      ArrayList<Association> internalAssociations = new ArrayList<Association>();
      for(Association as : uClass.getAssociations())
      {
        AssociationEnd myEnd = as.getIsRightNavigable()?as.getEnd(0):as.getEnd(1);
        AssociationEnd theirEnd = as.getIsRightNavigable()?as.getEnd(1):as.getEnd(0);

        if (internalAssociations.contains(as))
          continue;

        if (myEnd.getClassName().equals(theirEnd.getClassName()))
        {
          internalAssociations.add(as);
          code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"{0}\" lowerBound=\"{1}\" upperBound=\"{2}\" eType=\"#//{3}\" eOpposite=\"#//{4}/{5}\"/>\n",myEnd.getRoleName(),myEnd.getMultiplicity().getLowerBound(),myEnd.getMultiplicity().getUpperBound(),myEnd.getClassName(),myEnd.getClassName(),theirEnd.getRoleName()));
          code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"{0}\" lowerBound=\"{1}\" upperBound=\"{2}\" eType=\"#//{3}\" eOpposite=\"#//{4}/{5}\"/>\n",theirEnd.getRoleName(),theirEnd.getMultiplicity().getLowerBound(),theirEnd.getMultiplicity().getUpperBound(),theirEnd.getClassName(),theirEnd.getClassName(),myEnd.getRoleName()));
        }
        else
        {
          boolean isBidirectional = as.getIsLeftNavigable()&&as.getIsRightNavigable();
          boolean isTheirEndClass = theirEnd.getClassName().equals(uClass.getName());
          //auto-link if bidirectional
          if (isTheirEndClass && isBidirectional)
          {
            myEnd = as.getEnd(1);
            theirEnd = as.getEnd(0);
          }
          //add ERef if MyEnd or bidirectional, uniDirectional Ref doesn't hv eOpposite field
          if(isBidirectional)
        	  code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"{0}\" lowerBound=\"{1}\" upperBound=\"{2}\" eType=\"#//{3}\" eOpposite=\"#//{4}/{5}\"/>\n",theirEnd.getRoleName(),theirEnd.getMultiplicity().getLowerBound(),theirEnd.getMultiplicity().getUpperBound(),theirEnd.getClassName(),theirEnd.getClassName(),myEnd.getRoleName()));
          else if(!isTheirEndClass)
        	  code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EReference\" name=\"{0}\" lowerBound=\"{1}\" upperBound=\"{2}\" eType=\"#//{3}\"/>\n",theirEnd.getRoleName(),theirEnd.getMultiplicity().getLowerBound(),theirEnd.getMultiplicity().getUpperBound(),theirEnd.getClassName()));
        }
      }

      for (StateMachine sm : uClass.getStateMachines())
      {
        if ("Simple".equals(sm.getType()))
        {
          String enumerationName = StringFormatter.toPascalCase(sm.getName());
          code.append(StringFormatter.format("    <eStructuralFeatures xsi:type=\"ecore:EAttribute\" name=\"{0}\" eType=\"#//{1}\" />\n",sm.getName(),enumerationName));          

          int index = 0;
          subCode.append(StringFormatter.format("  <eClassifiers xsi:type=\"ecore:EEnum\" name=\"{0}\">\n",enumerationName));
          for (State s : sm.getStates())
          {
            subCode.append(StringFormatter.format("    <eLiterals name=\"{0}\" value=\"{1}\"/>\n",s.getName(),index));
            index += 1;
          }
          subCode.append("  </eClassifiers>\n");
        }
      }

      code.append("  </eClassifiers>\n");
      code.append(subCode.toString());
    }

    if (!isFirst)
    {
      code.append("</ecore:EPackage>\n");
    }


    model.setCode(code.toString());
    writeModel();
  }

  @umplesourcefile(line={213},file={"Generator_CodeEcore.ump"},javaline={274},length={12})
   private String getFullyQualifiedName(String packageName, String className){
    try
    {
      String fullName = packageName + "." + className;
      Class.forName(fullName);
      return fullName;
    }
    catch (Exception e) 
    {
      return null;  
    }
  }

  @umplesourcefile(line={226},file={"Generator_CodeEcore.ump"},javaline={288},length={10})
   private String getTargetNamespaceName(){
    if (model.getDefaultNamespace() != null){
      if (model.getDefaultNamespace().length() > 0 )
      {
        String [] namespaces = model.getDefaultNamespace().split("\\.");	
        return namespaces[namespaces.length-1];
      }
    }
    return model.getUmpleFile().getSimpleFileName();
  }

  @umplesourcefile(line={238},file={"Generator_CodeEcore.ump"},javaline={300},length={17})
   private void writeModel(){
    try
    {
      String path = model.getUmpleFile().getPath();
      File file = new File(path);
      file.mkdirs();
      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + ".ecore";
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


  /**
   * Allows independent code generation tools
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={23},file={"Generator.ump"},javaline={318},length={2})
  @Override
  public void prepare(){
          return ;
  }


  /**
   * Allows independent code generation tools
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={24},file={"Generator.ump"},javaline={331},length={2})
  @Override
  public void postpare(){
          return ;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "output" + ":" + getOutput()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}