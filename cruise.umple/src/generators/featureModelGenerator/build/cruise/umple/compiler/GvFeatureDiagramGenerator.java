/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4607.2d2b84eb8 modeling language!*/

package cruise.umple.compiler;
import cruise.umple.compiler.FeatureLink.FeatureConnectingOpType;
import java.util.regex.Pattern;

// line 17 "../../../../Generator_CodeGvFeatureDiagram.ump"
public class GvFeatureDiagramGenerator
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  public static final String NL = System.getProperty("line.separator");
  public static final String TEXT_0 = " /*This code was generated using the UMPLE ";
  public static final String TEXT_1 = " modeling language! */" + NL + "  " + NL + "digraph FeatureModel { " + NL + "  node [shape=rectangle]  " + NL + "  edge [arrowhead=none] " + NL;
  public static final String TEXT_2 = " " + NL + "  node [shape=plaintext];" + NL + "  message [fixedsize=true label =\"No require-statement found in the umple file.\" width=4];" + NL;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //GvFeatureDiagramGenerator Attributes
  private UmpleModel model;
  private FeatureModel featureModel;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public GvFeatureDiagramGenerator()
  {
    model = null;
    featureModel = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setModel(UmpleModel aModel)
  {
    boolean wasSet = false;
    model = aModel;
    wasSet = true;
    return wasSet;
  }

  public boolean setFeatureModel(FeatureModel aFeatureModel)
  {
    boolean wasSet = false;
    featureModel = aFeatureModel;
    wasSet = true;
    return wasSet;
  }

  public UmpleModel getModel()
  {
    return model;
  }

  public FeatureModel getFeatureModel()
  {
    return featureModel;
  }

  public void delete()
  {}

  // line 42 "../../../../Generator_CodeGvFeatureDiagram.ump"
   public void generateFeatureNodeShape(FeatureLink featureLink, StringBuilder code){
    FeatureNode featureNode = featureLink.getTargetFeatureNode();
    FeatureNode sourceFeatureNode = featureLink.getSourceFeatureNode();
    int indentLevel = 2;
    appendSpaces(code,indentLevel);
    if(featureNode.getIsLeaf())
    { 
      // link source to leaf node 
        code.append(""+sourceFeatureNode.getUniqueFeatureNodeName()+" -> "+featureNode.getName()+" ");
        code.append(getGvTargetShape(featureLink.getFeatureConnectingOpType(), featureLink.getIsSub() ));
        code.append(" ;"+"\n");    
        fillColorOfFeatureNode(code,featureNode,indentLevel);
    }
    else //if the node is not leaf node 
    {
      if(featureNode.getIsCompoundFeature())
      {
        MultiplicityFeatureConnectingOpType multiplicityFeatureLink = (MultiplicityFeatureConnectingOpType) featureLink;
        int upperBound = multiplicityFeatureLink.getMultiplicity().getUpperBound();
        int lowerBound = multiplicityFeatureLink.getMultiplicity().getLowerBound();        
        String minMax =""+lowerBound+".."+upperBound;
        code.append(sourceFeatureNode.getUniqueFeatureNodeName() + getGvMultiplicityShape(minMax));
        indentLevel+=2;
        List<FeatureNode> featureNodes = ((CompoundFeatureNode) featureNode).getChildFeatures();
        for(int i=0 ; i < featureNodes.size(); i++){
          FeatureLeaf fLeaf = ((FeatureLeaf)featureNodes.get(i));
          appendSpaces(code,indentLevel);
          code.append(sourceFeatureNode.getUniqueFeatureNodeName() +" -> "+ fLeaf.getName()+" ;"+"\n");
          fillColorOfFeatureNode(code,fLeaf,indentLevel);
        }
      }
      else{
      code.append(getGvNodeShape(featureLink.getFeatureConnectingOpType(),featureNode.getUniqueFeatureNodeName()));
      appendSpaces(code,indentLevel);
      code.append(""+sourceFeatureNode.getUniqueFeatureNodeName()+" -> "+featureNode.getUniqueFeatureNodeName()+" ;"+"\n");
      }
    }
    
    List<FeatureLink> outgoingLinks = featureNode.getOutgoingFeatureLinks();
    for(int i=0 ; i<outgoingLinks.size(); i++){
      generateFeatureNodeShape(outgoingLinks.get(i),code);
    }
  }


  /**
   * This overrides the superclass's method.
   */
  // line 87 "../../../../Generator_CodeGvFeatureDiagram.ump"
   public void generate(){
    StringBuilder code = new StringBuilder();
    featureModel = getModel().getFeatureModel(); 
     // Output basic gv file header
    _graphStart(0,code);
    if(featureModel == null)
    {
      code.append("// Umple code does not have a feature diagram. // \n");
      _nofeatureDiagram(0,code);
    }
    else
    {
    //display the status of the invariant of FM
    code.append(configurationStatus());
    // Iterate through each root feature. 
    for (FeatureNode featureNode : featureModel.getRootFeatures())
    {
      List <FeatureLink> featureNodeOutLinks = featureNode.getOutgoingFeatureLinks();
      for(FeatureLink flink : featureNodeOutLinks)
      {
        code.append("  "+featureNode.getUniqueFeatureNodeName()+" [label=\""+featureNode.getName()+" \" ]; \n");
        generateFeatureNodeShape(flink,code);
      }		    
    }
    }
    terminateCode(code);
  }

  // line 116 "../../../../Generator_CodeGvFeatureDiagram.ump"
   public static  String getGvTargetShape(FeatureConnectingOpType featureConnectingOpType, boolean isSub){
    String shapeProp = " ";
	  if(! isSub)
    shapeProp = " constraint=false ";

    switch(featureConnectingOpType)
    {
      case Exclude:
      return "["+ shapeProp +" arrowhead=normal color=red label=exclude " +" ]";
      case Mandatory:
      shapeProp += " arrowhead=dot ";
      return "["+ shapeProp +" ]";
      case Include:
      shapeProp += " arrowhead=normal label=include color=blue ";
      return "["+ shapeProp +" ]";
      case Optional:
      return "[arrowhead=odot "+shapeProp+" ]";
      case Conjunctive:
      return "[arrowhead=dot "+shapeProp+" ]";
      default:
      return "[ "+shapeProp+" ]";
    }
  }

  // line 141 "../../../../Generator_CodeGvFeatureDiagram.ump"
   public static  String getGvMultiplicityShape(String minMax){
    return "[label=\""+minMax + "\"]"+ ";"+"\n";
  }

  // line 145 "../../../../Generator_CodeGvFeatureDiagram.ump"
   public static  String getGvNodeShape(FeatureConnectingOpType featureConnectingOpType, String nodeName){
    String end = ";"+"\n";
    switch(featureConnectingOpType)
    {
      case Conjunctive:
      return nodeName+" [label=\" and \" ] "+end;
      case XOR:
      return nodeName+" [label=\"\" shape=triangle fixedsize=true  color=black width=.3 height=0.3 margin=0 ] "+end;
      case Disjunctive:
      return nodeName+" [label=\"\" shape=triangle fixedsize=true style=filled color=black width=.3 height=0.3 margin=0 ]"+end;
      case Multiplicity: // nothing to add here. It will be handled in getGvMultiplicityShape(...)
      return "\n";
      default:
      return nodeName +end;
    }
  }


  /**
   * This method fills the background color of a featureLeaf if it is used.
   */
  // line 164 "../../../../Generator_CodeGvFeatureDiagram.ump"
   public void fillColorOfFeatureNode(StringBuilder code, FeatureNode featureNode, int indentLevel){
    if(featureNode.getIsLeaf())
    {
      boolean shouldColor = featureModel.isUsedFeatureLeaf((FeatureLeaf)featureNode);
      if(shouldColor)
      { 
        appendSpaces(code,indentLevel);
        code.append(featureNode.getName()+" [style=filled fillcolor=\"chartreuse\"]" + "; \n"); 
      }
    }
  }

  // line 177 "../../../../Generator_CodeGvFeatureDiagram.ump"
   public String configurationStatus(){
    String result = "  InvariantstatusNode[label=\"  Configuration Status:\" shape=plaintext] \n";
    if(featureModel.satisfyFeatureModel())
    {
      result = result + "  validStatus[label=\"Valid\" shape=plaintext fontcolor=blue];\n";
    }
    else 
    result = result + "  validStatus[label=\"Not Valid  \" shape=plaintext fontcolor=red];\n";

    return result;
  }

  // line 189 "../../../../Generator_CodeGvFeatureDiagram.ump"
   protected void terminateCode(StringBuilder code){
    code.append("\n"+"}"+"\n");
    model.setCode(code.toString());
    writeModel();
  }

  // line 195 "../../../../Generator_CodeGvFeatureDiagram.ump"
   protected String generatorType(){
    return "GvFeatureDiagram";
  }


  /**
   * copied from "Generator_SuperGvGenerator.ump"
   */
  // line 200 "../../../../Generator_CodeGvFeatureDiagram.ump"
   private void appendSpaces(StringBuilder code, int numSpaces){
    for(int i=0; i<numSpaces; i++) 
    {
      code.append(" ");
    }
  }


  /**
   * 
   * Output the graphviz file to a file with the .gv suffix
   * copied from "Generator_SuperGvGenerator.ump"
   */
  // line 211 "../../../../Generator_CodeGvFeatureDiagram.ump"
   protected void writeModel(){
    try
    {
      String path = model.getUmpleFile().getPath();
      File file = new File(path);
      file.mkdirs();
      String modelFilename = path + File.separator + model.getUmpleFile().getSimpleFileName()
          + generatorType() + ".gv";
      BufferedWriter bw = new BufferedWriter(new FileWriter(modelFilename));
      bw.write(model.getCode());
      bw.flush();
      bw.close();
    }
    catch (Exception e)
    {
      throw new UmpleCompilerException("There was a problem with generating GraphViz feature model code." + e, e);
    }
  }

  private String _createSpacesString(int numSpaces){
    
  StringBuilder spaces =  new StringBuilder();
      for(int i=0; i <numSpaces; i++) {
          spaces.append(" ");
      }
      return spaces.toString();
  }

  public StringBuilder _graphStart(Integer numSpaces, StringBuilder sb){
    String spaces="";
    StringBuilder newCode = new StringBuilder();
    StringBuilder realSb = sb;
    if(numSpaces > 0) {
        realSb = newCode;
        spaces = _createSpacesString(numSpaces);
        newCode.append(spaces);
    }
    
    realSb.append(TEXT_0);
    realSb.append(UmpleModel.VERSION_NUMBER);
    realSb.append(TEXT_1);

    if(numSpaces > 0) {
        newCode.replace(0, newCode.length(), Pattern.compile(NL).matcher(newCode).replaceAll(NL + spaces));
        sb.append(newCode);
    }
    return sb; 
  }

  public String graphStart(){
        StringBuilder sb = new StringBuilder();
    return this._graphStart(0,sb).toString(); 
  }

  public StringBuilder _nofeatureDiagram(Integer numSpaces, StringBuilder sb){
    String spaces="";
    StringBuilder newCode = new StringBuilder();
    StringBuilder realSb = sb;
    if(numSpaces > 0) {
        realSb = newCode;
        spaces = _createSpacesString(numSpaces);
        newCode.append(spaces);
    }
    
    realSb.append(TEXT_2);

    if(numSpaces > 0) {
        newCode.replace(0, newCode.length(), Pattern.compile(NL).matcher(newCode).replaceAll(NL + spaces));
        sb.append(newCode);
    }
    return sb; 
  }

  public String nofeatureDiagram(){
        StringBuilder sb = new StringBuilder();
    return this._nofeatureDiagram(0,sb).toString(); 
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "model" + "=" + (getModel() != null ? !getModel().equals(this)  ? getModel().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "featureModel" + "=" + (getFeatureModel() != null ? !getFeatureModel().equals(this)  ? getFeatureModel().toString().replaceAll("  ","    ") : "this" : "null");
  }
}