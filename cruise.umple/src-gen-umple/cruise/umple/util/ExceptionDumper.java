/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.util;
import java.util.Scanner;
import java.util.regex.*;
import java.io.*;

// line 997 "../../../../src/Util_Code.ump"
public class ExceptionDumper
{

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
  
  // line 1003 ../../../../src/Util_Code.ump
  public static void dumpCompilerError(Exception ex) {
     String generatedSourcePath = System.getenv("GeneratedSourcePath");
    if (generatedSourcePath == null) {
      System.err.println("To locate the error in the original Umple source, set GeneratedSourcePath to where the generated Java is located:\ne.g. setenv GeneratedSourcePath ~/umple/cruise.umple/src-gen-umple");
    }
    else {
      System.err.println("Using GeneratedSourcePath="+generatedSourcePath);
    }
    System.err.println("Exception "+ex.getClass().getName()+" in");
    StackTraceElement [] st = ex.getStackTrace();
    StackTraceElement ust = null;
    for (int i=0;i<st.length;i++) {
      System.err.println(st[i].toString());
      if(generatedSourcePath != null) {
         ust = javaToUmpleStackTrace(st[i], generatedSourcePath);
        if(ust != null) {
          System.err.println("   => "+ust.getFileName()+":"+ust.getLineNumber());
         }
      }
    }
  }
  
    // Translate the java stack trace line information into the corresponding Umple line
    public static StackTraceElement javaToUmpleStackTrace(StackTraceElement javaStack, String generatedSourcePath) {
      StackTraceElement newSt;
      String javaFileName = javaStack.getFileName();
      String umpleFileName="Did not find line = information in Java code";
      int javaLineNumber = javaStack.getLineNumber();;
      int umpleLineNumber=1000000; // Dummy so errors can be noticed
      String fullClassPath = javaStack.getClassName();
      
      // TODO -- need to test on Windows
      
      // Walk up the class name packages to find the Java file
      String fileToScan=generatedSourcePath;
      String dirs[] = fullClassPath.split("\\.",-1);
      int walks = 0; // Depth of tree we will walk
      for (int d=0; d<dirs.length; d++) {
        String trialFile = fileToScan+System.getProperty("file.separator")+dirs[d];
        File f = new File(trialFile);
        if(!f.isDirectory()) {
          break; // We have gone too far
        }
        fileToScan = trialFile;
        walks++;
      }
      
      // At this point fileToScan is either invalid or contains the directory of the
      // file we need 
      fileToScan=fileToScan+System.getProperty("file.separator")+javaFileName;
      
      // System.err.println("!!"+fileToScan); //debug

      // We have hopefully found the file, now open it
      Scanner sc;
      try {
        sc = new Scanner(new BufferedReader(new FileReader(fileToScan)));
      }
      catch (FileNotFoundException fne) {
        return null;
      }

      String foundLine;
      Pattern linePattern = Pattern.compile(".*line ([0-9]+) (.*)");
      MatchResult result;
      
      for (int lineNum=1; sc.hasNextLine(); lineNum++) {
        foundLine = sc.nextLine();
        
        // if foundLine is a line directive reset the line directive counter
        Matcher m = linePattern.matcher(foundLine);
        if(m.matches()) {
          umpleFileName = m.group(2);
          umpleLineNumber = Integer.parseInt(m.group(1))-1;
        }
        else {
          umpleLineNumber++;
        }

        if(lineNum == javaLineNumber) {
          break;         
        }
      }
      
      // If umpleFileName has leading "../" remove as many of them as there were 
      // levels that we walked up
      String prefix = ".."+System.getProperty("file.separator");
      for(int w=0; w<walks; w++) {
        if(umpleFileName.startsWith(prefix)) {
          umpleFileName = umpleFileName.substring(3,umpleFileName.length());
        }
      }
            
      return new StackTraceElement(javaStack.getClassName(),  javaStack.getMethodName(), umpleFileName, umpleLineNumber);
     
    }
}