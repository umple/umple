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
  protected final String TEXT_1 = "  public static class UmpleExceptionHandler implements Thread.UncaughtExceptionHandler" + NL + "  {" + NL + "    public void uncaughtException(Thread t, Throwable e)" + NL + "    {" + NL + "      java.util.List<StackTraceElement> result = new java.util.ArrayList<StackTraceElement>();" + NL + "      StackTraceElement[] elements = e.getStackTrace();" + NL + "      try" + NL + "      {" + NL + "        for(StackTraceElement element:elements)" + NL + "        {" + NL + "          Class clazz = Class.forName(element.getClassName());" + NL + "          String methodName = element.getMethodName();" + NL + "          boolean methodFound = false;" + NL + "          for(java.lang.reflect.Method meth:clazz.getDeclaredMethods())" + NL + "          {" + NL + "            if(meth.getName().equals(methodName))" + NL + "            {" + NL + "              int line = -1;" + NL + "              String file = \"\";" + NL + "              for(java.lang.annotation.Annotation anno: meth.getAnnotations())" + NL + "              {" + NL + "                if(anno.annotationType().getSimpleName().equals(\"umplesourcefile\"))" + NL + "                {" + NL + "                  int methodlength = (Integer)anno.annotationType().getMethod(\"length\", new Class[]{}).invoke(anno,new Object[]{});" + NL + "                  int distanceFromStart = (element.getLineNumber()-(Integer)anno.annotationType().getMethod(\"javaline\", new Class[]{}).invoke(anno,new Object[]{}));" + NL + "                  distanceFromStart-=(\"main\".equals(methodName))?2:0;" + NL + "                  line = (Integer)anno.annotationType().getMethod(\"line\", new Class[]{}).invoke(anno,new Object[]{})+distanceFromStart;" + NL + "                  file = (String)anno.annotationType().getMethod(\"file\", new Class[]{}).invoke(anno,new Object[]{});" + NL + "                  if(file == \"\")" + NL + "                  {" + NL + "                    break;" + NL + "                  }" + NL + "                  else if(distanceFromStart>=0&&distanceFromStart<=methodlength)" + NL + "                  {" + NL + "                    result.add(new StackTraceElement(element.getClassName(),element.getMethodName(),file,line));" + NL + "                    methodFound = true;" + NL + "                    break;" + NL + "                  }" + NL + "                }" + NL + "              }" + NL + "              if(methodFound)" + NL + "              {" + NL + "                break;" + NL + "              }" + NL + "            }" + NL + "          }" + NL + "          if(!methodFound)" + NL + "          {" + NL + "            result.add(element);" + NL + "          }" + NL + "        }" + NL + "      }" + NL + "      catch (Exception e1)" + NL + "      {" + NL + "        e1.printStackTrace();" + NL + "      }" + NL + "      e.setStackTrace(result.toArray(new StackTraceElement[0]));" + NL + "      e.printStackTrace();" + NL + "    }" + NL + "  }";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
