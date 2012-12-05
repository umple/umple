package cruise.umple.ignore;

public class Ignore
{
  protected static String nl;
  public static synchronized Ignore create(String lineSeparator)
  {
    nl = lineSeparator;
    Ignore result = new Ignore();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
  /*
  This file declares constant attributes for tables. 
  The "constant" requirement is enforced with a check statement.
  */
  
  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
  
    if (!av.isConstant())
    {
      continue;
    }

    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  /*{0} Constants*/", gen.translate("type", uClass));      
      isFirst = false;
    }
  
    appendln(stringBuffer, "  {0} {1} DEFAULT {2} CHECK ({0} = {2}),", gen.translate("attributeConstant",av), gen.translate("type",av), gen.translate("parameterValueQuoted",av));
  }

    return stringBuffer.toString();
  }
}
