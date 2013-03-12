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
  protected final String TEXT_1 = NL + "public void trace(String name, String value)" + NL + "{" + NL + "\t";
  protected final String TEXT_2 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	for(TraceDirective td: uClass.getTraceDirectives())
	append(stringBuffer, "\n{0}", td.toString());
	
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
