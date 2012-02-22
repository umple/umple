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
    
  
  // SQL doesn't have a notion of a static 'member' or variable,
  // however, it may be useful to document static members in the code
  // so this template has been left as is.
  
  if (uClass.getIsSingleton())
  {
    append(stringBuffer, "  include Singleton");
  }

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
      appendln(stringBuffer, "");
      appendln(stringBuffer, "  /*-----------------------*/");
      appendln(stringBuffer, "  /* STATIC VARIABLES      */");
      appendln(stringBuffer, "  /*-----------------------*/");
      isFirst = false;
    }
  
    appendln(stringBuffer, "");
    appendln(stringBuffer, "  {0} {1} DEFAULT '{2}' CHECK ({1} = '{2}'),", gen.translate("attributeConstant",av), gen.translate("type",av), gen.translate("parameterValue",av));
  }
  

    return stringBuffer.toString();
  }
}
