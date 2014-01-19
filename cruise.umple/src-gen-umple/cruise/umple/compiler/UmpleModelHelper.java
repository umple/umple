/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.Reader;
import java.io.IOException;

/**
 * A common util for the implemented Measurment objects (@see MeasurmentObject).
 * @umplesource Generator_CodeAnalysis.ump 70
 */
// line 70 "../../../../src/Generator_CodeAnalysis.ump"
public class UmpleModelHelper
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static UmpleModelHelper theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private UmpleModelHelper()
  {}

  public static UmpleModelHelper getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new UmpleModelHelper();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={75},file={"Generator_CodeAnalysis.ump"},javaline={55},length={100})
  MeasurmentObject countLOC (String contents) throws java.io.IOException 
  {
    if(contents == null){
		contents = "";  		
  	}
  	
  	java.io.StringReader reader = new java.io.StringReader(contents);
  	MeasurmentObject object = doCount(reader);
  	reader.close();
  	return object;
  }

//  @umplesourcefile(line={86},file={"Generator_CodeAnalysis.ump"},javaline={68},length={87})
  MeasurmentObject countFileLOC (String filePath) throws java.io.IOException 
  {
    java.io.FileReader reader = new java.io.FileReader(filePath);
  	MeasurmentObject object = doCount(reader);
  	reader.close();
  	return object;
  }

//  @umplesourcefile(line={93},file={"Generator_CodeAnalysis.ump"},javaline={77},length={78})
  @umplesourcefile(line={94},file={"Generator_CodeAnalysis.ump"},javaline={78},length={77})
  private MeasurmentObject doCount (Reader reader)throws IOException 
  {
    int commentIndex;
  int starCommentStartIndex;
  int starCommentEndIndex;
  java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.BufferedReader(reader));
  String line = bufferedReader.readLine();
  
  int codeCount=0;
  int commentsCount=0;
  boolean codeBlock = false;
  
  while (line != null) {
   normalizeLine:{
    line= line.replaceAll("\t", "").replaceAll(" ", ""); //No spaces, and no tabs //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    
    int position1= line.indexOf("\""); //$NON-NLS-1$
    if(position1==-1){
     break normalizeLine;
    }
    
    int position2 = line.indexOf("\"", position1 + 1); //$NON-NLS-1$
    if(position2==-1|| position2 > position1){
     break normalizeLine;
    }
    line= line.substring(0, position1 + 1)+ line.substring(position1 + (position2 - position1),line.length());
   }
   
   if (line.length() == 0) {
    line = bufferedReader.readLine();
    continue;
   }
   
   commentIndex = line.indexOf("//"); //$NON-NLS-1$
   starCommentStartIndex = line.indexOf("/*"); //$NON-NLS-1$
   starCommentEndIndex = line.indexOf("*/"); //$NON-NLS-1$

   measure:{
    if (codeBlock) {
     commentsCount++;
     if (starCommentEndIndex != -1) {
      codeBlock = false;
     }
    } else {
     if (commentIndex != -1) {
      commentsCount++;
      
      line = line.substring(0, 2);
      if(starCommentStartIndex>0){
       codeCount++;
       break measure;
      }
     }
     else{
      if(starCommentStartIndex == -1 && starCommentEndIndex == -1){
       codeCount++;
       break measure;
      }
     }
     
     if (starCommentStartIndex != -1) {
      commentsCount++;
      if (starCommentEndIndex == -1) {
       codeBlock = true;
      }
     }
    }
    
    if (starCommentEndIndex != -1 && starCommentEndIndex < line.length() - 2){
     codeCount++;
    }
   }
   
   line = bufferedReader.readLine();
  }
  return new MeasurmentObject(codeCount, commentsCount);
  }

  
}