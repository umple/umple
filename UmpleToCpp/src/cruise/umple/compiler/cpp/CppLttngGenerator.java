package cruise.umple.compiler.cpp;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class CppLttngGenerator implements ILang 
{

  protected static String nl;
  public static synchronized CppLttngGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CppLttngGenerator result = new CppLttngGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/* EXPERIMENTAL CODE - NON COMPILEABLE VERSION OF C++ */" + NL + "/*PLEASE DO NOT EDIT THIS CODE*/" + NL + "/*This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!*/";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "  //----------------------------------" + NL + "  // Tracepoint Event" + NL + "  //----------------------------------";
  protected final String TEXT_4 = NL + "\t" + NL + "  //----------------------------------" + NL + "  // Variables" + NL + "  //----------------------------------";
  protected final String TEXT_5 = NL + "appendl(tp_code,\"";
  protected final String TEXT_6 = ",\");" + NL + "  //----------------------------------" + NL + "  // Message" + NL + "  //----------------------------------" + NL + "\t";
  protected final String TEXT_7 = NL + "  //------------------------------------" + NL + "  // Tracepoint Arguments Macro" + NL + "  //------------------------------------" + NL + "  \t";
  protected final String TEXT_8 = "  " + NL + "  //------------------------------------" + NL + "  // Tracepoint Fields" + NL + "  //-----------------------------------" + NL + "\t";
  protected final String TEXT_9 = "\t\t  " + NL + ")" + NL + "  //------------------------------------" + NL + "  // Tracepoint Log Level (Optional)" + NL + "  //-----------------------------------";
  protected final String TEXT_10 = NL + "\tappendl(tp_code,\"TRACE_WARNING)\"); " + NL + "  ";
  protected final String TEXT_11 = NL + "\t" + NL + NL;
  protected final String TEXT_12 = NL;

  // Add a newline to the end of the input
  private void appendln(StringBuffer buffer, String input, Object... variables)
  {
    append(buffer, input + "\n", variables);
  }  

  // This method will be used to append formatted strings
  // i.e. format("Hello {0} {1}", "andrew","forward");
  private void append(StringBuffer buffer, String input, Object... variables)
  {
    buffer.append(StringFormatter.format(input,variables));
  }

  /* 
  * This method will return the generated code.
  */
  public String getCode(UmpleModel model, UmpleElement uElement)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	UmpleClass uClass = (UmpleClass) uElement;
  	GeneratedClass gClass = uClass.getGeneratedClass();
  	CppGenerator gen = new CppGenerator();
  	gen.setModel(model);
	StringBuffer tp_code = new StringBuffer();
  	
  	HashMap<String,String> codeInjectionMap = new HashMap<String,String>();
  for (CodeInjection inject : uClass.getCodeInjections())
  {
    String operation = StringFormatter.toUnderscore(inject.getOperation());
    String key = inject.getType() + ":" + operation;
    String newCodeToInject = "";
    if (codeInjectionMap.containsKey(key))
    {
      newCodeToInject = StringFormatter.format("{0}\n    {1}",codeInjectionMap.get(key),inject.getCode());
    }
    else
    {
      newCodeToInject = inject.getCode();
    }
    codeInjectionMap.put(key,newCodeToInject);
  }

  boolean isFirst = true;

 	

    stringBuffer.append(TEXT_2);
     if (uClass.numberOfComments() > 0) { if (!uClass.getComments().get(0).getIsInline()) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else {append(stringBuffer, "\n{0}", Comment.format("Slashes",uClass.getComments())); } } 
    stringBuffer.append(TEXT_3);
    for( TraceDirective td : uClass.getTraceDirectives() )
  {
    for( AttributeTraceItem traceAttr : td.getAttributeTraceItems() )
    {
	for( UmpleVariable att : traceAttr.getUmpleVariables() )
	{
	tp_code = null;
	appendln(tp_code,"TRACEPOINT_EVENT(");
	
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( att.getName());
    stringBuffer.append(TEXT_6);
    
if(att.getType() =="Integer")		
		{ appendln(tp_code,"intfield,"); }
		if(att.getType() == "Double")
		{ appendln(tp_code,"doublefield,") ;}
		if(att.getType() == "String")
		{ appendln(tp_code,"message,") ;} 
		
    stringBuffer.append(TEXT_7);
    
		if(att.getType() =="String")		
		{ appendln(tp_code,"TP_ARGS(char *, text),"); }
		if(att.getType() == "Integer")
		{ appendln(tp_code,"TP_ARGS(int, intfield),"); }
		if(att.getType() == "Double")
		{ appendln(tp_code,"TP_ARGS(double, doublefield),"); }

    stringBuffer.append(TEXT_8);
    
appendln(tp_code,"TP_FIELDS(");
		if(att.getType() =="Integer")		
		{ appendln(tp_code,"ctf_integer(int, intfield,{0})",att.getName()); }
		if(att.getType() == "Double")
		{ appendln(tp_code,"ctf_float(double, doublefield,{0})",att.getName()) ;}
		if(att.getType() == "String")
		{ appendln(tp_code,"ctf_string(message,{0})",att.getName()) ;} 
		appendln(tp_code,")");
	
    stringBuffer.append(TEXT_9);
    
	appendln(tp_code,"TRACEPOINT_LOGLEVEL(");
	appendln(tp_code,"{0},",att.getName());
		if(att.getType() =="Integer")		
		{ appendln(tp_code,"intfield"); }
		if(att.getType() == "Double")
		{ appendln(tp_code,"doublefield") ;}
		if(att.getType() == "String")
		{ appendln(tp_code,"message") ;} 
		
    stringBuffer.append(TEXT_10);
     //sending TP code to create @attribute_tracepoint.tp files
  try{
	gen.writeLttngFile(att.getName(),tp_code.toString(),null);
  }
  catch (Exception e) {
        System.err.println("Error writing TP files: " + e.getMessage());
    }
    }
    }
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}