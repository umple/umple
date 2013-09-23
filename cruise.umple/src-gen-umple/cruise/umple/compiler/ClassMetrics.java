/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * 
 * 
 * CLASS USED TO MEASURE CLASSES
 * 
 * 
 * @umplesource Generator_CodeSimpleMetrics.ump 275
 */
// line 275 "../../../../src/Generator_CodeSimpleMetrics.ump"
public class ClassMetrics extends SimpleMetricsGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassMetrics Attributes
  private StringBuilder code;
  private UmpleModel model;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassMetrics()
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

  @umplesourcefile(line={280},file={"Generator_CodeSimpleMetrics.ump"},javaline={75},length={71})
  public void calculate(){
    CountClass cc = new CountClass();	
      int smCount = 0;
      int classCount = 0;

      code.append( "\n\n\n");
      code.append(Format.repeat("*",126) + "\n" );
      code.append(Format.repeat(" ",20)+" C L A S S   M E A S U R E S "+"\n");
      code.append(Format.repeat("*",126)+"\n");
   
	  // CALCULATE SOME CLASS METRICS
      // create a map in order to have several metric objects about the same class
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
      java.util.Map<UmpleClass, CountClass> mapOfUmpleClass = new java.util.HashMap<UmpleClass, CountClass>();
      for ( UmpleClass uClass : model.getUmpleClasses() ) {
          cc= countDataClass( uClass); 
          mapOfUmpleClass.put(uClass, cc);     
      }    
    
      java.util.List<String>title = new java.util.ArrayList<String>();
      title.add(" Class Name                   ");
      title.add(" #State Machines ");
      title.add(" #Associations ");
      title.add(" Subclasses ");
      title.add(" #Attributes ");
      title.add(" #Methods ");
      title.add(" #Method Parameters ");
      code.append(Format.repeat("-",126)+"\n");
      for (int i=0;i<title.size();i++){ code.append("|"+title.get(i));  }
      code.append(" |\n");
      code.append(Format.repeat("-",126)+"\n");
          
      java.util.Set<UmpleClass> keys = mapOfUmpleClass.keySet(); 
      classCount=0;
      smCount=0;
      for (UmpleClass key : keys) {
        classCount++;  
        cc= (CountClass) mapOfUmpleClass.get(key);            
        code.append( "| " +key.getName()+ Format.repeat(" ", title.get(0).length()-(""+key.getName()).length()-1 ) );
        code.append( "| " +Format.repeat(" ", title.get(1).length()-(""+cc.getCountStateMachines()).length()-1 )+ cc.getCountStateMachines() );
        smCount += cc.getCountStateMachines();
        code.append( "| " +Format.repeat(" ", title.get(2).length()-(""+cc.getCountAssociations()).length()-1 )+ cc.getCountAssociations() );
        code.append( "| " +Format.repeat(" ", title.get(3).length()-(""+cc.getCountSubclasses()).length()-1 )+ cc.getCountSubclasses() );
        code.append( "| " +Format.repeat(" ", title.get(4).length()-(""+cc.getCountAttributes()).length()-1 )+ cc.getCountAttributes() );
        code.append( "| " +Format.repeat(" ", title.get(5).length()-(""+cc.getCountMethods()).length()-1 )+ cc.getCountMethods() );
        code.append( "| " +Format.repeat(" ", title.get(6).length()-(""+cc.getCountParameters()).length()-1 )+ cc.getCountParameters() );
        code.append( " |\n" ); // closing the record. One record one line.
        code.append(Format.repeat("-",126)+"\n");
      }
    
      // TOTAL OF CLASSES, STATE MACHINES, SOURCE FILES 
      code.append("\n\n");
      code.append(Format.repeat("-",50)+"\n");
      code.append(" SOME TOTALS:\n");
      code.append(" class count = "+classCount+"\n");
      code.append(" state machine count = "+smCount+"\n");
      code.append(" source file count = "+allUmpFiles.size()+"\n");
      code.append(Format.repeat("-",50)+"\n");
	  super.setCode(code);
	  return;
  }


  /**
   * end of method
   */
  @umplesourcefile(line={353},file={"Generator_CodeSimpleMetrics.ump"},javaline={148},length={83})
  public CountClass countDataClass(UmpleClass uClass){
    int classCount=0;
      CountClass countclass = new CountClass();
      
      Attribute attribute = null;
      Method method = null;
      MethodParameter parameter = null;
      Association vassociation = null;
       
      //System.out.println("=======================================");
      //for (UmpleClass uClass : model.getUmpleClasses())
      
        if (uClass!=null){
          //System.out.println( "Class: "+uClass.getName() );
         
          //Look for State Machines
          for (StateMachine sm : uClass.getStateMachines()) {
            countclass.incStateMachines();
          }   
        
          // Look for subclasses
          UmpleClass subclass=null;
          java.util.List subclasslist = uClass.getSubclasses();
          if (subclasslist.size()>0){
            java.util.Iterator it = subclasslist.iterator();

          //System.out.println( "File: "+fn+"    class: "+uClass.getName() );
            while ( it.hasNext() ) {
              subclass = (UmpleClass)it.next();
              //System.out.println( "      Subclasse: "+ subclass.getName() );
              countclass.incCountSubclasses();
              //countclass.incCountAttributes();
            }
          }
        
          // Look for Associations
          Association[] associationlist = uClass.getAssociations();
          for( int i = 0; i < associationlist.length; i++ )
          {
            vassociation = associationlist[i];
            //System.out.println( "      Association: "+ vassociation.getName() );
            countclass.incCountAssociations();
          }
        
          // Look for Attributes
          java.util.List attributelist = uClass.getAttributes();
          if (attributelist != null){
            java.util.Iterator it = attributelist.iterator();
  
            while ( it.hasNext() ) {
              attribute = (Attribute)it.next();
              //System.out.println( "      Attribute: "+ attribute.getName() );
              countclass.incCountAttributes();
            }
          }

          // Look for Methods
          java.util.List methodlist = uClass.getMethods();
          //System.out.println("Method list= "+methodlist.size());
          if (methodlist != null){
            java.util.Iterator it1 = methodlist.iterator();
                    
            while ( it1.hasNext() ) {
              method = (Method)it1.next();
              //System.out.println("       Method: "+ method.getName() );
              countclass.incCountMethods();
              
              // Look for Parameters
              java.util.List parameterlist = method.getMethodParameters();
              if (parameterlist != null){
                java.util.Iterator it3 = parameterlist.iterator();
                      
                while ( it3.hasNext() ) {
                  parameter = (MethodParameter)it3.next();
                  //System.out.println("             Parameter: "+ parameter.getName() );
                  //countclass.incCountMethods();
                }
              }
            }
          }
        }
 	    return countclass;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "code" + "=" + (getCode() != null ? !getCode().equals(this)  ? getCode().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}