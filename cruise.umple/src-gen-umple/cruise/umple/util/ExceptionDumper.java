/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.util;
import java.util.Scanner;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

/**
 * @umplesource Util_Code.ump 997
 */
// line 997 "../../../../src/Util_Code.ump"
public class ExceptionDumper
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ExceptionDumper()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={1004},file={"Util_Code.ump"},javaline={42},length={120})
  @umplesourcefile(line={1005},file={"Util_Code.ump"},javaline={43},length={21})
  public static void dumpCompilerError(Exception ex) {
     String generatedSourcePath = System.getenv("GeneratedSourcePath");
    if (generatedSourcePath == null) {
      System.err.println("To locate the error in the original Umple source, set GeneratedSourcePath to where the generated Java is located:\ne.g. setenv GeneratedSourcePath ~/umple/cruise.umple/src-gen-umple");
    }
    else {
      System.err.println("Using GeneratedSourcePath="+generatedSourcePath);
    }
    System.err.println("Exception "+ex.getClass().getName()+" in");
    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(),ex);
    /*StackTraceElement [] st = ex.getStackTrace();
    StackTraceElement ust = null;
    for (int i=0;i<st.length;i++) {
      System.err.println(st[i].toString());
      if(generatedSourcePath != null) {
         ust = javaToUmpleStackTrace(st[i], generatedSourcePath);
        if(ust != null) {
          System.err.println("   => "+ust.getFileName()+":"+ust.getLineNumber());
         }
      }
    }*/
  }
  
    // Translate the java stack trace line information into the corresponding Umple line
  @umplesourcefile(line={1029},file={"Util_Code.ump"},javaline={68},length={95})
    public static StackTraceElement javaToUmpleStackTrace(StackTraceElement javaStack, String generatedSourcePath) {
      StackTraceElement newSt;
      String javaFileName = javaStack.getFileName();
      String umpleFileName="Did not find line = information in Java code";
      int javaLineNumber = javaStack.getLineNumber();;
      int umpleLineNumber=javaStack.getLineNumber(); // Dummy so errors can be noticed
      String fullClassPath = javaStack.getClassName();
      
      // TODO -- need to test on Windows
      // We have hopefully found the file, now open it
      Scanner sc;
      try {
        sc = new Scanner(new BufferedReader(new FileReader(javaFileName)));
      }
      catch (FileNotFoundException fne) {
        return null;
      }
      
      int lineNumber = 1;
      Pattern umpleSourceFileFormat = Pattern.compile(".*@umplesourcefile[(].*\\{(.*)\\}.*\\{(.*)\\}.*\\{(.*)\\}.*\\{(.*)\\}[)].*");
      List<String> umpleSourceFiles = new ArrayList<String>();
      List<String> umpleSourceLines = new ArrayList<String>();
      List<String> umpleSourceJavaLines = new ArrayList<String>();
      List<String> umpleSourceLengths = new ArrayList<String>();
      
      boolean isInMain = false;
      boolean firstBraceFound = false;
      int braces = 0;
      
      while(lineNumber<=javaLineNumber)
      {
    	String line = sc.nextLine();
    	Matcher umpleSourceFileMatcher = umpleSourceFileFormat.matcher(line);
    	//System.out.println(line);
    	if(umpleSourceFileMatcher.matches())
    	{
    	  umpleSourceLines.add(umpleSourceFileMatcher.group(1));
          umpleSourceFiles.add(umpleSourceFileMatcher.group(2));
    	  umpleSourceJavaLines.add(umpleSourceFileMatcher.group(3));
    	  umpleSourceLengths.add(umpleSourceFileMatcher.group(4));
    	}
    	else if(line.matches(".*(public)[ |\\t]+(static)[ |\\t]+(void)[ |\\t]+(main)[ |\\t]*[(][ |\\t]*(String)[ |\\t]*\\[\\].*"))
        {
          isInMain=true;
        }
        else if(line.matches("(.*)[ |\\t]+void([ |\\t]+)main([ |\\t]*)[(]([ |\\t]*)String[ |\\t]+[a-z|A-Z|0-9|_]+[ |\\t]*\\[[ |\\t]*\\][ |\\t]*[)](.*)"))
        {
          isInMain=true;        
        }
    	if(isInMain)
    	{
    	  braces += (line.length()-line.replace("{", "").length()) - (line.length()-line.replace("}", "").length());
    	  if(!firstBraceFound && (line.length()-line.replace("{", "").length())>0)
    	  {
    	    firstBraceFound = true;
    	  }
    	  if(braces<=0 && firstBraceFound)
    	  {
    	    firstBraceFound=false;
    		isInMain=false;
    		braces=0;
    	  }    	  
    	}
    	lineNumber++;
      }
      
      
      Integer javaLine;
        Integer length;
      for(int j = 0; j < umpleSourceJavaLines.size();j++)
      {
        String[] umpleSourceJavaLinesSplit = umpleSourceJavaLines.get(j).split(",");
        String[] umpleSourceLengthsSplit = umpleSourceLengths.get(j).split(",");
         
        for(int i = 0; i < umpleSourceJavaLinesSplit.length; i++)
        {
          if(umpleSourceJavaLines.equals(""))
          {
            break;
          }
    	  javaLine = Integer.parseInt(umpleSourceJavaLinesSplit[i]);
    	  length = Integer.parseInt(umpleSourceLengthsSplit[i]);
    	
    	  if(javaLineNumber-javaLine<length)
    	  {
    	    umpleFileName = umpleSourceFiles.get(j).split(",")[i].replace(" ","");
    	    umpleLineNumber = Integer.parseInt(umpleSourceLines.get(j).split(",")[i])+javaLineNumber-javaLine-(isInMain?2:0);
    	    return new StackTraceElement(javaStack.getClassName(),  javaStack.getMethodName(), umpleFileName.replace("\\","/").replaceAll(".*/", "").replace("\"",""), umpleLineNumber);
    	  }
        }
            
        
      }
      return javaStack;
    }

}