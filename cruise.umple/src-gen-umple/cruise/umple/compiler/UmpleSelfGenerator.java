/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;

/**
 * @umplesource Generator.ump 70
 * @umplesource Generator_CodeUmpleSelf.ump 11
 */
// line 70 "../../../../src/Generator.ump"
// line 11 "../../../../src/Generator_CodeUmpleSelf.ump"
public class UmpleSelfGenerator implements CodeGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleSelfGenerator Attributes
  private UmpleModel model;
  private String output;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleSelfGenerator()
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

  @umplesourcefile(line={17},file={"Generator_CodeUmpleSelf.ump"},javaline={78},length={99})
   public void generate(){
    CodeGenerator internalGen = generateBasedOn();
    internalGen.prepare();

    StringBuilder code = new StringBuilder();
    ArrayList<Association> externalAssociations = new ArrayList<Association>();

    for (UmpleClass uClass : model.getUmpleClasses())
    {
      code.append(StringFormatter.format("\nclass {0}\n{\n", uClass.getName()));

      if (uClass.getExtendsClass() != null)
      {
        code.append(StringFormatter.format("  isA {0};\n", uClass.getExtendsClass().getName()));
      }

      for (Attribute av : uClass.getAttributes())
      {
        String typeName = av.getType() == null ? "String" : av.getType();
        String attrName = av.getIsList() ? model.getGlossary().getPlural(av.getName()) : model.getGlossary().getSingular(av.getName());

        code.append(" ");
        if (av.isIsLazy())
        {
          code.append(" lazy");
        }

        if (!av.getModifier().equals("settable"))
        {
          code.append(StringFormatter.format(" {0}", av.getModifier()));
        }

        if (av.isIsAutounique())
        {
          code.append(" autounique");
        }
        else if (!typeName.equals("String") || av.isImmutable() || av.isIsLazy())
        {
          code.append(StringFormatter.format(" {0}", typeName));
        }
        code.append(StringFormatter.format(" {0}", attrName));

        if (av.getValue() != null)
        {
          code.append(StringFormatter.format(" = {0}", av.getValue()));
        }

        code.append(";\n");
      }

      for (Association as : uClass.getAssociations())
      {
        AssociationEnd myEnd = as.getIsRightNavigable() ? as.getEnd(0) : as.getEnd(1);
        AssociationEnd theirEnd = as.getIsRightNavigable() ? as.getEnd(1) : as.getEnd(0);

        if (!myEnd.getClassName().equals(uClass.getName()))
        {
          continue;
        }
        if (as.isNamed())
        {
          externalAssociations.add(as);
          continue;
        }
        code.append(StringFormatter.format("  {0} {1} -- {3} {4} {2};\n", myEnd.getMultiplicity().getParserable(), myEnd.getRoleName(), theirEnd.getRoleName(), theirEnd.getMultiplicity().getParserable(), theirEnd.getClassName()));
      }

      for (CodeInjection ci : uClass.getCodeInjections())
      {
        code.append(StringFormatter.format("  {0} {1} { {2} }\n", ci.getType(), ci.getOperation(), ci.getCode()));
      }

      for (StateMachine sm : uClass.getStateMachines())
      {
        generateStateMachine(sm, 1, code);
      }

      for (Method m : uClass.getMethods())
      {
        generateMethod(m, code);
      }

      code.append("}\n");
    }

    for (Association as : externalAssociations)
    {
      AssociationEnd myEnd = as.getIsRightNavigable() ? as.getEnd(0) : as.getEnd(1);
      AssociationEnd theirEnd = as.getIsRightNavigable() ? as.getEnd(1) : as.getEnd(0);

      code.append(StringFormatter.format("\nassociation {0}\n{\n", as.getName()));
      code.append(StringFormatter.format("  {0} {1} {2} -- {4} {5} {3};\n", myEnd.getMultiplicity().getParserable(), myEnd.getRoleName(), myEnd.getClassName(), theirEnd.getRoleName(), theirEnd.getMultiplicity().getParserable(), theirEnd.getClassName()));
      code.append("}");
    }

    model.setCode(code.toString());
    writeModel();
    internalGen.postpare();
  }

  @umplesourcefile(line={118},file={"Generator_CodeUmpleSelf.ump"},javaline={179},length={10})
   private void generateMethod(Method m, StringBuilder code){
    code.append(StringFormatter.format("\n  {0} {1} {2}", m.getModifier().trim(), m.getType(), m.getName()));
    generateParams(m.getMethodParameters(), code, false);
    code.append(" {\n");
    String body = m.getMethodBody().getCodeblock().toString();
    if (body.length() > 0) { code.append("\n"); }
    code.append(body);
    if (body.length() > 0) { code.append("\n"); }
    code.append("  }\n");
  }

  @umplesourcefile(line={130},file={"Generator_CodeUmpleSelf.ump"},javaline={191},length={21})
   private void generateParams(List<MethodParameter> allParams, StringBuilder code, boolean ignoreIfDone){
    if (allParams.size() == 0)
    {
      if (!ignoreIfDone) { code.append("()"); }
    }
    else
    {
      code.append("(");
      boolean isFirst = true;
      for (MethodParameter p : allParams)
      {
        if (!isFirst)
        {
          code.append(", ");
        }
        code.append(StringFormatter.format("{0} {1}", p.getType(), p.getName()));
        isFirst = false;
      }
      code.append(")");
    }
  }

  @umplesourcefile(line={153},file={"Generator_CodeUmpleSelf.ump"},javaline={214},length={76})
   private void generateStateMachine(StateMachine sm, int level, StringBuilder code){
    String baseSpace = spacer(level * 2 + (level - 1) * 2);
    code.append(StringFormatter.format("{1}{0} {\n", name(sm), baseSpace));
    boolean isFirst;
    boolean hasConsumedActivity;
    for (State state : sm.getStates())
    {
      code.append(StringFormatter.format("{1}  {0} {", state.getName(), baseSpace));
      isFirst = true;
      hasConsumedActivity = false;
      for (Action a : state.getActions())
      {
        if (isFirst)
        {
          code.append("\n");
        }
        code.append(StringFormatter.format("{0}    ", baseSpace));
        code.append(StringFormatter.format("{0} / { {1} }\n", a.getActionType(), a.getActionCode()));
        isFirst = false;
      }

      for (Transition t : state.getTransitions())
      {
        if (isFirst)
        {
          code.append("\n");
        }
        code.append(StringFormatter.format("{0}    ", baseSpace));
        if (t.getGuard() != null)
        {
          code.append(StringFormatter.format("[{0}] ", t.getGuard().getCondition()));
        }
        
        Event event = t.getEvent();
        
        if (event.isAutoTransition() && state.getActivity() != null)
        {
          hasConsumedActivity = true;
          code.append(StringFormatter.format("do { {0} }", state.getActivity().getCodeblock().toString()));
        }
        else if (!event.isAutoTransition())
        {
          code.append(StringFormatter.format("{0}", t.getEvent().getName()));
        }
        generateParams(t.getEvent().getParams(), code, true);
        code.append(" -> ");
        if (t.getAction() != null)
        {
          code.append(StringFormatter.format("/ { {0} } ", t.getAction().getCodeblock().toString()));
        }
        code.append(StringFormatter.format("{0};", t.getNextState().getName()));
        code.append("\n");
        isFirst = false;
      }
      
      for (StateMachine subSm : state.getNestedStateMachines())
      {
        generateStateMachine(subSm, level+1, code);
      }

      if (state.getActivity() != null && !hasConsumedActivity)
      {
        if (isFirst)
        {
          code.append("\n");
        }
        code.append(StringFormatter.format("{0}    ", baseSpace));
        code.append(StringFormatter.format("do { {0} };\n", state.getActivity().getCodeblock().toString()));
        isFirst = false;
      }

      code.append(StringFormatter.format("{0}  }\n", baseSpace));
    }

    code.append(StringFormatter.format("{0}}\n", baseSpace));
  }

  @umplesourcefile(line={231},file={"Generator_CodeUmpleSelf.ump"},javaline={292},length={4})
   private String name(StateMachine sm){
    String input = sm.getFullName();
    return input.substring(0, 1).toUpperCase() + input.substring(1);
  }

  @umplesourcefile(line={237},file={"Generator_CodeUmpleSelf.ump"},javaline={298},length={8})
   private String spacer(int num){
    StringBuilder space = new StringBuilder();
    for (int i = 0; i < num; i++)
    {
      space.append(" ");
    }
    return space.toString();
  }

  @umplesourcefile(line={247},file={"Generator_CodeUmpleSelf.ump"},javaline={308},length={17})
   private void writeModel(){
    try
    {
      String path = model.getUmpleFile().getPath();
      File file = new File(path);
      file.mkdirs();
      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName() + ".umpself";
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(model.getCode());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating UmpleSelf code." + e, e);
    }
  }

  @umplesourcefile(line={266},file={"Generator_CodeUmpleSelf.ump"},javaline={327},length={13})
   private CodeGenerator generateBasedOn(){
    String targetLanguage = "Java";
    for (GenerateTarget target : model.getGenerates())
    {
      if (target.getLanguage().equals("UmpleSelf"))
      {
        continue;
      }
      targetLanguage = target.getLanguage();
      break;
    }
    return model.newGenerator(targetLanguage);
  }


  /**
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={23},file={"Generator.ump"},javaline={341},length={2})
  @Override
  public void prepare(){
          return ;
  }


  /**
   * Allows independent code generation tools
   * Different generators will do different things regarding where the files are put, etc.
   */
  @umplesourcefile(line={24},file={"Generator.ump"},javaline={352},length={2})
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