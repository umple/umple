/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.util.*;
import java.io.*;
import cruise.umple.compiler.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.util.StringFormatter;

/**
 * @umplesource Compiler.ump 13
 */
// line 13 "../../../../src/Compiler.ump"
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

  @umplesourcefile(line={25},file={"Compiler.ump"},javaline={40},length={19})
   public static  boolean compile(UmpleModel model, String entryClass, String... extraArgs){
    boolean error_flag = true;
    String extra = "";
    for(String arg:extraArgs)
    {
      extra+=arg;
    }
    for (UmpleElement currentElement : model.getUmpleElements())
    {
      if ("external".equals(currentElement.getModifier()))
      {
        continue;
      }
      if (entryClass.equals("-") || entryClass.equals(currentElement.getName())) {
        error_flag = error_flag && compileJava(currentElement, model,extra);
      }
    }
    return error_flag;
  }

  @umplesourcefile(line={45},file={"Compiler.ump"},javaline={61},length={27})
   private static  boolean compileJava(UmpleElement aClass, UmpleModel model, String args){
    String path="";
    for (GenerateTarget gt : model.getGenerates()) {
      if (gt.getLanguage().equals("Java")) {
        path = StringFormatter.addPathOrAbsolute( 
            model.getUmpleFile().getPath() +"/"+ gt.getPath(), "") + 
          aClass.getPackageName().replace(".", File.separator);
      }
    }
    String filename = path + File.separator + aClass.getName() + ".java";
    //System.out.println("filename: "+filename+args);
    boolean successful = true;
    try {
      Process p = Runtime.getRuntime().exec("javac "+filename+args);
      BufferedReader reader=new BufferedReader(new InputStreamReader(p.getErrorStream())); 
      String line=reader.readLine(); 

      while (line!=null) {
        System.err.println(translateLineToUmple(line, model));
        line = reader.readLine();
        successful = false;
      }
    } catch (IOException e) {
      println(e.getMessage());
    }
    return successful;
  }


  /**
   * To do: Use model to determine generation path
   */
  @umplesourcefile(line={74},file={"Compiler.ump"},javaline={90},length={43})
   private static  String translateLineToUmple(String line, UmpleModel model){
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
    String javaFile = lineParts[0];//javaFileParts[javaFileParts.length-1];
    
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

  @umplesourcefile(line={119},file={"Compiler.ump"},javaline={139},length={4})
   private static  void println(String output){
    console += output + "\n";
    System.out.println(output);
  }

  @umplesourcefile(line={126},file={"Compiler.ump"},javaline={145},length={11})
   public static  String getSimpleFileName(String fileName){
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

  @umplesourcefile(line={139},file={"Compiler.ump"},javaline={158},length={22})
   public static  List<UmpleClass> getMainClasses(UmpleModel model){
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
        else if(line.matches("(.*)[ |\\t]+void([ |\\t]+)main([ |\\t]*)[(]([ |\\t]*)String[ |\\t]+[a-z|A-Z|0-9|_]+[ |\\t]*\\[[ |\\t]*\\][ |\\t]*[)](.*)"))
        {
          mainClasses.add(c);
          break;
        }
      }
        
      
    }
    return mainClasses;
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={21},file={"Compiler.ump"},javaline={184},length={2})
  public static String console ;

  
}