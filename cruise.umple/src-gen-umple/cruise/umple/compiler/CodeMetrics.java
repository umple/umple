/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * END CLASS
 * 
 * 
 * CLASS USED TO COUNT MEASURE CODE
 * 
 * 
 * @umplesource Generator_CodeSimpleMetrics.ump 81
 */
// line 81 "../../../../src/Generator_CodeSimpleMetrics.ump"
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

  @umplesourcefile(line={86},file={"Generator_CodeSimpleMetrics.ump"},javaline={76},length={93})
  public void calculate(){
    // COUNT LINES PER FILE 
      int totalLineCount = 0; 
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

      java.util.List<String>title  = new java.util.ArrayList<String>();
      title.add(" file                                                                    ");
      title.add("    LOC    ");
      title.add(" Comment Lines ");
      title.add(" Blank Lines ");
      title.add(" Total of Lines ");
      code.append(Format.repeat("-",135)+"\n");
            
      for (int i=0;i<title.size();i++){ code.append("|"+title.get(i));  }
      code.append(" |\n");          
      code.append(Format.repeat("-",135)+"\n");
      
	  
      for( String fn1 : allUmpFiles){
          int fileLineCount = 0;
     
         try {
             cl = countLinesInFile(fn1);
             /*  code.append("\n      LOC = "+cl.getCountCode());
             code.append("\n      Comment Lines = "+cl.getCountComments());
             code.append("\n      Blank Lines = "+cl.getCountBlanks());   
             code.append("\n      Total of Lines = "+cl.getCountLines()+'\n');    
             */
         
             //String s = Format.repeat(" ", title.get(1).length()-(""+cc.getCountAssociations()).length() );
             code.append( "| " +fn1+ Format.repeat(" ", title.get(0).length()-(""+fn1).length()-1 ) );
             code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+cl.getCountCode()).length()-1 )+ cl.getCountCode() );
             code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+cl.getCountComments()).length()-1 )+ cl.getCountComments() );
             code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+cl.getCountBlanks()).length()-1 )+ cl.getCountBlanks() );
             code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+cl.getCountLines()).length()-1 )+ cl.getCountLines() );
             code.append( " |\n" ); // closing the record. One record one line.
             code.append(Format.repeat("-",135)+"\n");
          }
	 	  catch (java.io.IOException e) {
             try {
                 cl = countLinesInFile(model.getUmpleFile().getPath()+java.io.File.separator+fn1);
                 /*code.append ("\n      LOC = "+cl.getCountCode());
                 code.append("\n      Comment Lines = "+cl.getCountComments());
                 code.append("\n      Blank Lines = "+cl.getCountBlanks());
                 code.append("\n      Total of Lines = "+cl.getCountLines()+'\n'); 
                  */
              
                 code.append(fn1+ Format.repeat(" ", title.get(0).length()-(""+fn1).length() ) );
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
  //  @umplesourcefile(line={181},file={"Generator_CodeSimpleMetrics.ump"},javaline={183},length={86})
  CountLines countLinesInFile(String filename)throws java.io.IOException 
  {
    //CountLines countLinesInFile(String filename) throws IOException
     CountLines cl = new CountLines();
     cl.setCountLines(0);
     cl.setCountComments(0);
     cl.setCountBlanks(0);
     cl.setCountCode(0);
  
      boolean insideblock=false;
     //System.out.println("processing:"+filename);
     // try {
          int ind1,ind2,ind3;
          java.io.FileReader arq = new java.io.FileReader(filename);
          java.io.BufferedReader lerArq = new java.io.BufferedReader(arq);
          String orgline;
          String line = lerArq.readLine(); // Read first line of a file
      	  
          while (line != null) {
          ind1=-1;
          ind2=-1;
          ind3=-1;
          
          //System.out.println(line);
          
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
          // System.out.println(line + line.length());
          //System.out.print(line);
          if ( line.length() == 0){
            cl.incCountBlanks();
            //System.out.println("[blank]");
          }else{      
            //comment in one line
            if ( ((ind1 = line.indexOf("//")) != -1) && (!insideblock) ) {
              cl.incCountComments();
              line = line.substring(0,2); // consume the line to avoid parsing mistakes
              //System.out.println("[//]");
            }
            // block of comments
            if (insideblock){
              cl.incCountComments();
              //System.out.println("[/* inside */]");
              if ( (ind3 = line.indexOf("*/")) != -1 ) {
                insideblock=false;
              }
            } 
            else if ( ((ind2 = line.indexOf("/*")) != -1) && (!insideblock) )
            {
              cl.incCountComments();
              //System.out.println("[/* */]");
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
                //System.out.println("[code] "+ind1+", "+ind2+", "+ind3+", "+insideblock);   
            }
          }
            line = lerArq.readLine(); // get next line or value null if doesn't have another one
          } // close while (line != null)
          arq.close();
/*          
      } catch (java.io.IOException e) {
          System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
      }
*/
       //System.out.println("======================="+cl.toString());
       return cl;
  }

}