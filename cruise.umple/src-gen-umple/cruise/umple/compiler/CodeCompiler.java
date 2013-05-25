/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.util.StringFormatter;

/**
 * @umplesource Compiler.ump 14
 */
// line 14 "../../../../src/Compiler.ump"
public class CodeCompiler
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeCompiler()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  // line 22 ../../../../src/Compiler.ump
  public static String console;

  @umplesourcefile(line={24},file={"Compiler.ump"},javaline={45},length={14})
  public static boolean compile(UmpleModel model, String entryClass) {
    boolean error_flag = true;
    for (UmpleElement currentElement : model.getUmpleElements())
    {
      if ("external".equals(currentElement.getModifier()))
      {
        continue;
      }
      if (entryClass.equals("-") || entryClass.equals(currentElement.getName())) {
        error_flag = error_flag && compileJava(currentElement, model);
      }
    }
    return error_flag;
  }

  @umplesourcefile(line={39},file={"Compiler.ump"},javaline={61},length={27})
  private static boolean compileJava(UmpleElement aClass, UmpleModel model) {
    String path="";
    for (GenerateTarget gt : model.getGenerates()) {
      if (gt.getLanguage().equals("Java")) {
        path = StringFormatter.addPathOrAbsolute( 
            model.getUmpleFile().getPath() +"/"+ gt.getPath(), "") + 
          aClass.getPackageName().replace(".", File.separator);
      }
    }
    String filename = path + File.separator + aClass.getName() + ".java";
    //System.out.println("filename: "+filename);
    boolean error_exist = true;
    try {
      Process p = Runtime.getRuntime().exec("javac "+filename);
      BufferedReader reader=new BufferedReader(new InputStreamReader(p.getErrorStream())); 
      String line=reader.readLine(); 

      while (line!=null) {
        System.err.println(translateLineToUmple(line, model));
        line = reader.readLine();
        error_exist = false;
      }
    } catch (IOException e) {
      println(e.getMessage());
    }
    return error_exist;
  }

  // To do: Use model to determine generation path
  @umplesourcefile(line={68},file={"Compiler.ump"},javaline={91},length={43})
  private static String translateLineToUmple(String line, UmpleModel model) {
    String modifiedLine = line;
    StackTraceElement ust;
    String javaFileName;
    int javaLineNumber;
    String lineParts[] = line.split(":",3);
    
    // Case 1: No colons so nothing to translate
    if(lineParts.length < 3) {
      return line;
    }
    
    // case 2: no colon before .java, so nothing to translate
    if (!lineParts[0].endsWith(".java")) {
      return line;
    }
    
    // We have a line that needs translating
    String javaFileParts[] =
      lineParts[0].split("\\"+System.getProperty("file.separator"),-1);
    String javaFile = javaFileParts[javaFileParts.length-1];
    
    String declaringClass = javaFile.substring(0,javaFile.length()-5);
    for(int i=javaFileParts.length-2; i>=0 ; i--) {
      if(!javaFileParts[i].equals(".")) {
        declaringClass = javaFileParts[i]+"."+declaringClass;
      }
    }
    // System.err.println("**"+declaringClass+"**"+javaFile); //debug
    
    //Code Smell: javaToUmpleStackTrace needs to not be static
    ust = cruise.umple.util.ExceptionDumper.javaToUmpleStackTrace(
      new StackTraceElement(
        declaringClass,
        "",
        javaFile,
        Integer.parseInt(lineParts[1])),  "");
    // System.err.println("*"+lineParts[0]+"*"); // Debug
    if(ust==null) {
      return line;
    }
    return(ust.getFileName()+":"+ust.getLineNumber()+":"+lineParts[2]);
  }

  @umplesourcefile(line={112},file={"Compiler.ump"},javaline={136},length={5})
  private static void println(String output)
  {
    console += output + "\n";
    System.out.println(output);
  }

  @umplesourcefile(line={118},file={"Compiler.ump"},javaline={143},length={13})
  public static String getSimpleFileName(String fileName)
  {

    int lastIndex = fileName.lastIndexOf("/");
    if (lastIndex == -1)
    {
      return fileName;
    }
    else
    {
      return fileName.substring(lastIndex+1, fileName.length());
    }
  }
  
  @umplesourcefile(line={132},file={"Compiler.ump"},javaline={158},length={18})
  public static List<UmpleClass> getMainClasses(UmpleModel model)
  {
    List<UmpleClass> mainClasses = new ArrayList<UmpleClass>();
    for(UmpleClass c:model.getUmpleClasses())
    {
      for(String line:c.getExtraCode().split("\\n"))
      {
        if(line.matches(".*(public)[ |\\t]+(static)[ |\\t]+(void)[ |\\t]+(main)[ |\\t]*[(][ |\\t]*(String)[ |\\t]*\\[\\].*"))
        {
          mainClasses.add(c);
          break;
        }
      }
        
      
    }
    return mainClasses;
  }

}