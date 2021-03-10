/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4607.2d2b84eb8 modeling language!*/

package cruise.umple.compiler;

// line 18 "../../../../Generator_CodeGvClassDiagram.ump"
public class GvClassDiagramGenerator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GvClassDiagramGenerator()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}


  /**
   * Returns what is being generated - called SuperGvGenerator
   */
  // line 23 "../../../../Generator_CodeGvClassDiagram.ump"
   protected String generatorType(){
    return "cd";
  }


  /**
   * Create the association between a class and its parent
   * - called VisitClass in SuperGvGenerator
   */
  // line 30 "../../../../Generator_CodeGvClassDiagram.ump"
   protected void parentClassAssoc(StringBuilder code, String className, String parentName){
    code.append("  \""+className+"\" -> \""+parentName+"\""
        +" [arrowhead=\"empty\"; samehead=\"gen\"];\n\n");
  }


  /**
   * Create each class - called VisitClass in SuperGvGenerator
   */
  // line 37 "../../../../Generator_CodeGvClassDiagram.ump"
   protected void classCreation(UmpleClass uClass, StringBuilder code){
    boolean manyClass = getModel().getUmpleClasses().size() >= 200 ? true : false;

    String className = uClass.getName();
    String classColor = uClass.getDisplayColor();
    if (!classColor.equals("")) classColor=" style=filled, fillcolor="+classColor+" ";
    code.append("\n  // Class: "+className+"\n");
    
    if (manyClass) {
      code.append("  \""+className+"\" ["+classColor+"shape=record, label=\"{"+className);

      if(uClass.getIsAbstract()) {  // add abstract tag
        code.append("\n&laquo;abstract&raquo;");
      }
    } 
    else {
      code.append("  \""+className+"\" ["+classColor+"shape=plaintext margin=0 label=");
	    
      // Different cellpadding for if the class has nothing but the
      // name because of a glitch in graphviz's graphics
      if ((uClass.getAttributes().size() == 0 || hasSuboption("hideattributes")) && 
          (uClass.getMethods().size() == 0 || !hasSuboption("showmethods")) 
          && !uClass.getIsAbstract()) {
	    code.append("<<table border=\"1\" cellspacing=\"0\" cellborder=\"0\" cellpadding=\"10\">"
		   			+"<tr><td>    "+className+"    </td></tr>");
      }
      else {
        code.append("<<table border=\"1\" cellspacing=\"0\" cellborder=\"0\" cellpadding=\"2\">"
                    +"<tr><td cellpadding=\"4\">    "+className+"    </td></tr>");
		  }
      if(uClass.getIsAbstract()) {  // add abstract tag
        code.append("<tr><td cellpadding=\"4\">&laquo;abstract&raquo;"+"</td></tr>");
      }
    }
    
    attributeCreation(uClass, code, manyClass);
    methodCreation(uClass, code, manyClass);

    // Terminate outputting the class attributes
    if(manyClass) code.append("}\"");
   	else code.append("</table>>"); 
    
    
    // Output the tooltip : Class name followed by any comment
    code.append(",\n   tooltip=\"class "+className+"\n");
    code.append(appendTooltipComment(uClass.getComments(), false));
    code.append("\"");

    // Terminate the class as a whole
    code.append("];\n");
  }


  /**
   * Create each attribute for each class - called by classCreation
   */
  // line 91 "../../../../Generator_CodeGvClassDiagram.ump"
   private void attributeCreation(UmpleClass uClass, StringBuilder code, boolean manyClass){
    // Iterate through attributes of the class]
    boolean isFirst = true;

    if (!hasSuboption("hideattributes")) { 
      for (Attribute uAttribute : uClass.getAttributes()) {
        if (!uAttribute.isConstant()) 
        {
          if (manyClass) {
            if (isFirst) code.append("|"); // attribute block starter
            else code.append("\\\n"); // separator between attributes
          }
          else {
            if (isFirst) code.append("<hr/>"); // attribute block starter
          }
          String isList = uAttribute.getIsList() ? "[]" : ""; //Hello
          String type = uAttribute.getType().replace("<","&lt;").replace(">","&gt;");
          
          if (manyClass) {
            code.append(""+uAttribute.getName()+"\\ :\\ "+type+isList+"\\l");
          }
          else {
            StringBuilder attrTooltip = new StringBuilder();
            attrTooltip.append(type+isList+" "+uAttribute.getName()+"&#13;");
            attrTooltip.append(appendTooltipComment(uAttribute.getComments(), true));        
            code.append("<tr><td align=\"left\" href=\"\" title=\""+attrTooltip+"\">"
                  +"  "+uAttribute.getName()+" : "
                  +type+isList+"  </td></tr>");
          }
          
          isFirst = false;
        }
      }
    }
  }


  /**
   * Create each method for each class - called by classCreation
   */
  // line 129 "../../../../Generator_CodeGvClassDiagram.ump"
   private void methodCreation(UmpleClassifier inUmpleClassifier, StringBuilder code, boolean manyClass){
    if (hasSuboption("showmethods")) {
      boolean isFirstMethod = true;
      for (Method uMethod : inUmpleClassifier.getMethods()) {
      	if (uMethod.getSource() == Method.Source.fAutoAPI)
      	  continue;

        if (manyClass) {
          if(isFirstMethod) code.append("|"); // method block starter
          else code.append("\\\n"); // separator between attributes
        }
        else {
          if (isFirstMethod) code.append("<hr/>"); // method block starter
        }
        String accessModifier = "";
        switch (uMethod.getModifier().trim()) {
          case "": accessModifier = "+"; break;
          case "private": accessModifier = "-"; break;
          case "protected": accessModifier = "#"; break;
          case "public": accessModifier = "+"; break;
        }
        String parameters = "";
        if(uMethod.hasMethodParameters()) {
          for (MethodParameter mp : uMethod.getMethodParameters()) {
            parameters += mp.getFullType() + ",";
          }
          parameters = parameters.substring(0, parameters.length() - 1); // delete last comma
        }
        parameters = parameters.replace("<","&lt;").replace(">","&gt;");
        String type = uMethod.getType().replace("<","&lt;").replace(">","&gt;");
        boolean isAbstract = uMethod.getIsAbstract();
      
        if (manyClass) {
          if (isAbstract) {
            code.append(accessModifier+ "<I>" + uMethod.getName()+"</I> ("+parameters+")\\ :\\ "+type+"\\l");
          }
          else {
            code.append(accessModifier+uMethod.getName()+"("+parameters+")\\ :\\ "+type+"\\l");
          }
        }
        else {
          StringBuilder methTooltip = new StringBuilder();
          methTooltip.append(type+" "+uMethod.getName()+"("+parameters+")"+"&#13;");
          methTooltip.append(appendTooltipComment(uMethod.getComments(), true));
      
          StringBuilder hrefString = new StringBuilder();
          hrefString.append("javascript:Action.selectMethod('");
          hrefString.append(uMethod.getName()+"','"+type+"','"+uMethod.getModifier().trim()+"')");
         
          if (isAbstract) {
            code.append("<tr><td align=\"left\" href=\""+hrefString+"\" title=\""+methTooltip+"\">"
                +"  "+accessModifier+ "<I>" + uMethod.getName() + "</I>" 
                +" ("+parameters+") : "+type+"  </td></tr>");
          }
          else {
            code.append("<tr><td align=\"left\" href=\""+hrefString+"\" title=\""+methTooltip+"\">"
              +"  "+accessModifier+uMethod.getName()
              +"("+parameters+") : "+type+"  </td></tr>");  
          }
          isFirstMethod = false;
        }
      }
    }
  }


  /**
   * Create each interface for each class - called by classCreation
   */
  // line 196 "../../../../Generator_CodeGvClassDiagram.ump"
   protected void interfaceCreation(UmpleClass uClass, StringBuilder code){
    // Add any interface implementations so they are output at the end
    for(UmpleInterface uInterface : uClass.getParentInterface()) {
      String intColor = uInterface.getDisplayColor();
      // TO DO needs fixing - interface colour does not appear
      if (!intColor.equals("")) {
        code.append("  \""+(uInterface.getName().replace("<","&lt;").replace(">","&gt;"))
          +"\" [style=filled, fillcolor="+intColor+"];\n\n ");
      } 
      code.append("  \""+uClass.getName()+
        "\" -> \""+(uInterface.getName().replace("<","&lt;").replace(">","&gt;")));
      code.append("\" [  arrowhead=\"empty\"; samehead=\"gen\"; style=dashed];\n\n");
    }
  }


  /**
   * Create the associations in the class diagram
   * - called VisitClass in SuperGvGenerator
   */
  // line 214 "../../../../Generator_CodeGvClassDiagram.ump"
   protected void associationCreation(UmpleClass uClass, Association uAssoc, StringBuilder associations, String className){
    AssociationEnd leftEnd = uAssoc.getEnd(0);
    AssociationEnd rightEnd = uAssoc.getEnd(1);
    String modifierOne = leftEnd.getModifier();
    String modifierTwo = rightEnd.getModifier();
    String visualLeftEnd, visualRightEnd, toolTip, label;

    // Only output them when visiting one class
    if(leftEnd.getClassName().equals(className)) {
      String[] arrows = retArrows(uAssoc);
        
      if ("symmetricreflexive".equals(modifierOne) && "symmetricreflexive".equals(modifierTwo)) 
      {
        if ("undefined".equals(rightEnd.getDisplayRoleName()))
          label = leftEnd.toSimpleString()+" "+leftEnd.getDisplayRoleName();
        else label = rightEnd.toSimpleString()+" "+rightEnd.getDisplayRoleName();
          
        toolTip = leftEnd.getClassName() + " " + label + " " + rightEnd.getClassName() + "TEST NATURAL LANGUAGE B";
          
        associations.append(labelAssociation(leftEnd.getClassName(),
          rightEnd.getClassName(), arrows[0], label, toolTip));
      }
      else 
      {
        visualLeftEnd = leftEnd.toSimpleString()+" "+leftEnd.getDisplayRoleName();
        visualRightEnd = rightEnd.toSimpleString()+" "+rightEnd.getDisplayRoleName();
        toolTip = leftEnd.getClassName() + " " + visualLeftEnd +
            " " + arrows[1] + " " + visualRightEnd + " " + rightEnd.getClassName() + "TEST NATURAL LANGUAGE A";
          
        associations.append(twoLabelAssociation(leftEnd.getClassName(),
          rightEnd.getClassName(), arrows[0], visualRightEnd, visualLeftEnd, toolTip));
      }
    }
  }


  /**
   * Used to indent code
   */
  // line 250 "../../../../Generator_CodeGvClassDiagram.ump"
   private void appendSpaces(StringBuilder code, int numSpaces){
    for(int i=0; i<numSpaces; i++) {
      code.append(" ");
    }
  }


  /**
   * This overrides a method used for generating the necessary tags for interfaces and also their hierarchies.
   */
  // line 257 "../../../../Generator_CodeGvClassDiagram.ump"
   protected void createInterfacesAndTheirHirerarchy(UmpleInterface inInterface, StringBuilder code){
    boolean manyInterface = getModel().getUmpleInterfaces().size() >= 200 ? true : false;

	    String interfaceName = inInterface.getName();
	    String interfaceColor = inInterface.getDisplayColor();
	    if (!interfaceColor.equals("")) interfaceColor=" style=filled, fillcolor="+interfaceColor+" ";
	    
	    if (manyInterface) {
	      code.append("  \""+manyInterface+"\" ["+interfaceColor+"shape=record, label=\"{"+"&laquo;interface&raquo;<BR/>"+interfaceName);
	    } 
	    else {
	      code.append("  \""+interfaceName+"\" ["+interfaceColor+"shape=plaintext margin=0 label=");
		    
	      // Different cellpadding for if the class has nothing but the
	      // name because of a glitch in graphviz's graphics
		    code.append("<<table border=\"1\" cellspacing=\"0\" cellborder=\"0\" cellpadding=\"10\">"
			   			+"<tr><td>"+"&laquo;interface&raquo;<BR/>"+interfaceName+"</td></tr>");
	    }
	    if ((inInterface.getMethods().size()<=0) || (!hasSuboption("showmethods"))){
	    	code.append("<hr/><tr><td cellpadding=\"4\">   </td></tr>");
	    }
	    methodCreation(inInterface, code, manyInterface);

	    // Terminate outputting the class attributes
	    if(manyInterface) code.append("}\"");
	   	else code.append("</table>>"); 
	    
	    
	    // Output the tooltip : Class name followed by any comment
	    code.append(",\n   tooltip=\"interface "+interfaceName+"\n");
//	    code.append(appendTooltipComment(uInterface.getComments(), false));
	    code.append("\"");

	    // Terminate the class as a whole
	    code.append("];\n");
	    createInterfaceHierarchyAssociations(inInterface,code);
  }


  /**
   * This creates tags which are necessary to show hierarchies.
   */
  // line 296 "../../../../Generator_CodeGvClassDiagram.ump"
   protected void createInterfaceHierarchyAssociations(UmpleInterface inInterface, StringBuilder code){
    for(UmpleInterface uInt : inInterface.getExtendsInterface()) {
	        String intColor = uInt.getDisplayColor();
	        // TO DO needs fixing - interface colour does not appear
	        if (!intColor.equals("")) {
	          code.append("  \""+uInt.getName()
	            +"\" [style=filled, fillcolor="+intColor+"];\n\n ");
	        } 
	        code.append("  \""+inInterface.getName()+"\" -> \""+uInt.getName());
	        code.append("\" [  arrowhead=\"empty\"; samehead=\"gen\"];\n\n");
	      }
  }

}