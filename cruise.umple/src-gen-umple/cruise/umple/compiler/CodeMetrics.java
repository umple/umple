/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource SimpleMetrics_CodeLines.ump 58
 */
// line 58 "../../../../src/SimpleMetrics_CodeLines.ump"
public class CodeMetrics extends SimpleMetricsGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CodeMetrics Attributes
  private StringBuilder code;
  private UmpleModel model;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CodeMetrics()
  {
    super();
    code = null;
    model = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCode(StringBuilder aCode)
  {
    boolean wasSet = false;
    code = aCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public StringBuilder getCode()
  {
    return code;
  }

  public UmpleModel getModel()
  {
    return model;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={64},file={"SimpleMetrics_CodeLines.ump"},javaline={70},length={85})
  public void calculate(){
    int totalLineCount = 0; //count lines per file
      int totalLoc = 0;
      int totalComments = 0;
      int totalBlanks = 0;
	  CountLines cl = new CountLines();
	
      java.util.Set<String> allUmpFiles = new java.util.HashSet<String>();
      String fn = null;
  
      // Iterate through all the classes in the system, gathering statistics
      for (UmpleClass uClass : model.getUmpleClasses()) {
        // Loop through all the places where parts of this class were
        // found in the code, gathering all the files
        for (Position p : uClass.getPositions()) {
          fn=p.getFilename();
          allUmpFiles.add(fn); // allUmpFiles is a set, so duplicates are removed
        }
      }

	  code.append( "\n\n\n");
      code.append(Format.repeat("*",126)+"\n");
      code.append(Format.repeat(" ",20)+"C O D E   L I N E   M E A S U R E S"+"\n");
      code.append(Format.repeat("*",126)+"\n");
	  
      java.util.List<String>title  = new java.util.ArrayList<String>();
      title.add(" file                                                     ");
      title.add("    LOC    ");
      title.add(" Comment Lines ");
      title.add(" Blank Lines ");
      title.add(" Total of Lines ");
      code.append(Format.repeat("-",120)+"\n");
            
      for (int i=0;i<title.size();i++){ code.append("|"+title.get(i));  }
      code.append(" |\n");          
      code.append(Format.repeat("-",120)+"\n");
      
	  
      for( String fn1 : allUmpFiles){
          int fileLineCount = 0;
     
         try {
             cl = countLinesInFile(fn1);
            
			 String vartemp = fn1.substring( fn1.lastIndexOf("\\")+1);
             code.append( "| " +vartemp+ Format.repeat(" ", title.get(0).length()-vartemp.length()-1 ) );
             code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+cl.getCountCode()).length()-1 )+ cl.getCountCode() );
             code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+cl.getCountComments()).length()-1 )+ cl.getCountComments() );
             code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+cl.getCountBlanks()).length()-1 )+ cl.getCountBlanks() );
             code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+cl.getCountLines()).length()-1 )+ cl.getCountLines() );
             code.append( " |\n" ); // closing the record. One record one line.
             code.append(Format.repeat("-",120)+"\n");
          }
	 	  catch (java.io.IOException e) {
             try {
                 cl = countLinesInFile(model.getUmpleFile().getPath()+java.io.File.separator+fn1);
         
                 code.append("| "+fn1.substring( fn1.lastIndexOf("\\")+1)+ Format.repeat(" ", title.get(0).length()-(""+fn1).length() ) );
                 code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+cl.getCountCode()).length() )+ cl.getCountCode() );
                 code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+cl.getCountComments()).length() )+ cl.getCountComments() );
                 code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+cl.getCountBlanks()).length() )+ cl.getCountBlanks() );
                 code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+cl.getCountLines()).length() )+ cl.getCountLines() );
                 code.append( " |\n" ); // closing the record. One record one line.
                 code.append(Format.repeat("-",135)+"\n");
          
              }
              catch (java.io.IOException e2) {  
                 fileLineCount = 0;
                 cl.setCountLines(0);
                 code.append("Unreadable\n");
              } 
            }
   	        totalLoc += cl.getCountCode();
            totalComments += cl.getCountComments();
            totalBlanks += cl.getCountBlanks();
            totalLineCount += cl.getCountLines();  
	    }
  	    code.append("\n\n");
        code.append("\n  Total Line of Code = "+totalLoc);
        code.append("\n  Total Comment Lines  = "+totalComments );
        code.append("\n  Total Blank Lines  = "+totalBlanks);
        code.append("\n  Total Total of Lines = "+totalLineCount + "\n");
	    code.append("\n\n");
		return;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "code" + "=" + (getCode() != null ? !getCode().equals(this)  ? getCode().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={149},file={"SimpleMetrics_CodeLines.ump"},javaline={169},length={73})
  CountLines countLinesInFile (String filename)throws java.io.IOException 
  {
    CountLines cl = new CountLines();
     cl.setCountLines(0);
     cl.setCountComments(0);
     cl.setCountBlanks(0);
     cl.setCountCode(0);
  
      boolean insideblock=false;
          int ind1,ind2,ind3;
          java.io.FileReader arq = new java.io.FileReader(filename);
          java.io.BufferedReader lerArq = new java.io.BufferedReader(arq);
          String orgline;
          String line = lerArq.readLine(); // Read first line of a file
      	  
          while (line != null) {
          ind1=-1;
          ind2=-1;
          ind3=-1;
          
          cl.incCountLines();
          line = line.replaceAll(" ",""); // Eliminate all spaces
          line = line.replaceAll("\t",""); // Eliminate all tabs \t
           
          // destroy quoted/string          
          int pos1, pos2 = -1;
          if ( (pos1 = line.indexOf("\"")) >= 0 ){
          	if ( ( (pos2= line.indexOf("\"",pos1+1)) > 0 ) && (pos2 > pos1) ){
         		line = line.substring( 0, pos1+1 ) + line.substring( pos1 + (pos2-pos1), line.length() ) ;
          	}
          }

          if ( line.length() == 0){
            cl.incCountBlanks();

          }else{    
		  
            //comment in one line
            if ( ((ind1 = line.indexOf("//")) != -1) && (!insideblock) ) {
              cl.incCountComments();
              line = line.substring(0,2); // consume the line to avoid parsing mistakes

            }
			
            // block of comments
            if (insideblock){
              cl.incCountComments();
              if ( (ind3 = line.indexOf("*/")) != -1 ) {
                insideblock=false;
              }
            } 
            else if ( ((ind2 = line.indexOf("/*")) != -1) && (!insideblock) )
            {
              cl.incCountComments();
              if ( (ind3 = line.indexOf("*/")) == -1 ) {
                insideblock = true;
              }
            }
			
            // line of code
            if  ( ( (!insideblock) && (  (ind1 > 0) || (ind2 > 0) ) )|| // ind1 check "//"  and ind 2 check "/*"
            	     ( (ind3 > 0) && (ind3 < line.length()-2) ) || // close braces before code line 
                     ( (ind1==-1) && (ind2==-1) && (ind3==-1) && (!insideblock)  ) //
                 )  {
                cl.incCountCode();     
            }
          }
            line = lerArq.readLine(); // get next line or value null if doesn't have another one
          } // close while (line != null)
          arq.close();
       return cl;
  }

  
}