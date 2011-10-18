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
    

{

	//==== Tracing Code    
    if( model.getTraceType().equals("File") && uClass.hasTraceDirectives() )
	{
		appendln(stringBuffer, "");
		appendln(stringBuffer, "  //------------------------");
		appendln(stringBuffer, "  // FILE TRACER METHOD");
		appendln(stringBuffer, "  //------------------------\n");
		appendln(stringBuffer, "  static void fileTracer(Object obj)");
		appendln(stringBuffer, "  {");
		appendln(stringBuffer, "    FileOutputStream fout = null;");
		appendln(stringBuffer, "    Date date = new Date();");
		appendln(stringBuffer, "    try");
		appendln(stringBuffer, "    {");
		appendln(stringBuffer, "      // Open an output stream");
		appendln(stringBuffer, "      fout = new FileOutputStream ({0}TraceLog.txt{1},true);",'"','"');
		appendln(stringBuffer, "      new PrintStream(fout).println ({0}(Tracing log file){1});",'"','"');
		appendln(stringBuffer, "    }");
		appendln(stringBuffer, "    catch (IOException e)");
		appendln(stringBuffer, "    {");
	    appendln(stringBuffer, "      System.err.println ({0}Unable to write to file{1});",'"','"');
		appendln(stringBuffer, "      System.exit(-1);");
		appendln(stringBuffer, "    }");
		appendln(stringBuffer, "    // Write traced Item information");
		appendln(stringBuffer, "    new PrintStream(fout).println(\"Traced object value: \" + obj);");
		appendln(stringBuffer, "    new PrintStream(fout).println({0}Trace time : {1} + date);",'"','"');
		appendln(stringBuffer, "    try");
		appendln(stringBuffer, "    {");
		appendln(stringBuffer, "      // Close output stream");
		appendln(stringBuffer, "      fout.close();");
		appendln(stringBuffer, "    }");
		appendln(stringBuffer, "    catch (IOException e)");
		appendln(stringBuffer, "    {");
		appendln(stringBuffer, "      e.printStackTrace();");
		appendln(stringBuffer, "    }");
		appendln(stringBuffer, "  }");
	}
}


    return stringBuffer.toString();
  }
}
