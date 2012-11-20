package cruise.umple.compiler.sql;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class SqlInterfaceGenerator implements ILang 
{

  protected static String nl;
  public static synchronized SqlInterfaceGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SqlInterfaceGenerator result = new SqlInterfaceGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "-- PLEASE DO NOT EDIT THIS CODE" + NL + "-- This code was generated using the UMPLE 1.15.0.1751 modeling language!";
  protected final String TEXT_2 = NL;

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
    
// Interfaces don't really make sense with Sql.
// A possible solution around this, is to make 
// every class that uses said interface X, also 
// generate the attributes/associations for interface X.
// This file should probably ignored.
// We should also prevent SqlGenerator from
// trying to create an interface.


    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}