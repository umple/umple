/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/

package cruise.umple.testparser;
import java.io.File;
import cruise.umple.*;
import cruise.umple.parser.Token;
import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.parser.ParseResult;
import cruise.umple.testgenerator.*;
import cruise.umple.testgenerator.Depend;
import java.util.*;

// line 4 "../../../../ump/mbt_parser_src.ump"
public class TestParser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestParser Attributes
  private boolean shouldProcessAgain;
  private RuleBasedParser mbt;
  private ParseResult parseResult;
  private String grammarFile;
  private File testModelFile;
  private TestModel aTestModel;
  private int locOrder;

  //TestParser Associations
  private List<Depend> depends;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestParser(ParseResult aParseResult, String aGrammarFile, File aTestModelFile, int aLocOrder)
  {
    shouldProcessAgain = false;
    mbt = new RuleBasedParser();
    parseResult = aParseResult;
    grammarFile = aGrammarFile;
    testModelFile = aTestModelFile;
    aTestModel = new TestModel(null, null, null, null, null, null, null, null);
    locOrder = aLocOrder;
    depends = new ArrayList<Depend>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setShouldProcessAgain(boolean aShouldProcessAgain)
  {
    boolean wasSet = false;
    shouldProcessAgain = aShouldProcessAgain;
    wasSet = true;
    return wasSet;
  }

  public boolean setMbt(RuleBasedParser aMbt)
  {
    boolean wasSet = false;
    mbt = aMbt;
    wasSet = true;
    return wasSet;
  }

  public boolean setParseResult(ParseResult aParseResult)
  {
    boolean wasSet = false;
    parseResult = aParseResult;
    wasSet = true;
    return wasSet;
  }

  public boolean setGrammarFile(String aGrammarFile)
  {
    boolean wasSet = false;
    grammarFile = aGrammarFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setTestModelFile(File aTestModelFile)
  {
    boolean wasSet = false;
    testModelFile = aTestModelFile;
    wasSet = true;
    return wasSet;
  }

  public boolean setATestModel(TestModel aATestModel)
  {
    boolean wasSet = false;
    aTestModel = aATestModel;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocOrder(int aLocOrder)
  {
    boolean wasSet = false;
    locOrder = aLocOrder;
    wasSet = true;
    return wasSet;
  }

  public boolean getShouldProcessAgain()
  {
    return shouldProcessAgain;
  }

  public RuleBasedParser getMbt()
  {
    return mbt;
  }

  public ParseResult getParseResult()
  {
    return parseResult;
  }

  /**
   * List<String> depends;
   */
  public String getGrammarFile()
  {
    return grammarFile;
  }

  public File getTestModelFile()
  {
    return testModelFile;
  }

  public TestModel getATestModel()
  {
    return aTestModel;
  }

  public int getLocOrder()
  {
    return locOrder;
  }
  /* Code from template association_GetMany */
  public Depend getDepend(int index)
  {
    Depend aDepend = depends.get(index);
    return aDepend;
  }

  public List<Depend> getDepends()
  {
    List<Depend> newDepends = Collections.unmodifiableList(depends);
    return newDepends;
  }

  public int numberOfDepends()
  {
    int number = depends.size();
    return number;
  }

  public boolean hasDepends()
  {
    boolean has = depends.size() > 0;
    return has;
  }

  public int indexOfDepend(Depend aDepend)
  {
    int index = depends.indexOf(aDepend);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDepends()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addDepend(Depend aDepend)
  {
    boolean wasAdded = false;
    if (depends.contains(aDepend)) { return false; }
    TestParser existingTestParser = aDepend.getTestParser();
    if (existingTestParser == null)
    {
      aDepend.setTestParser(this);
    }
    else if (!this.equals(existingTestParser))
    {
      existingTestParser.removeDepend(aDepend);
      addDepend(aDepend);
    }
    else
    {
      depends.add(aDepend);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDepend(Depend aDepend)
  {
    boolean wasRemoved = false;
    if (depends.contains(aDepend))
    {
      depends.remove(aDepend);
      aDepend.setTestParser(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDependAt(Depend aDepend, int index)
  {  
    boolean wasAdded = false;
    if(addDepend(aDepend))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepends()) { index = numberOfDepends() - 1; }
      depends.remove(aDepend);
      depends.add(index, aDepend);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDependAt(Depend aDepend, int index)
  {
    boolean wasAdded = false;
    if(depends.contains(aDepend))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepends()) { index = numberOfDepends() - 1; }
      depends.remove(aDepend);
      depends.add(index, aDepend);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDependAt(aDepend, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    while( !depends.isEmpty() )
    {
      depends.get(0).setTestParser(null);
    }
  }

  // line 29 "../../../../ump/mbt_parser_src.ump"
   public static  void init(){
    
  }

  // line 33 "../../../../ump/mbt_parser_src.ump"
   public void analyzeAllTokens(Token rootToken){
    int analysisStep = 0;
	    shouldProcessAgain = true;
	    analyzeModel(rootToken,analysisStep);
	    do
	    {
	      analysisStep += 1;
	      shouldProcessAgain = false;
	      for(Token t : rootToken.getSubTokens())
	      {
	    	  
	    	  if(t.getName().equals("generate"))
		    	 {
		    		 analyzeGenerate(t,analysisStep);
		    	 }
	    	  
	    	 if(t.getName().equals("depend"))
	    	 {
	    		 analyzeDepend(t,analysisStep);
	    	 }
	    	 
	    	 
	    	 if(t.getName().equals("model"))
	    	 {
	    		 analyzeModel(t,analysisStep);
	    	 }
	    	 
	    	 if(t.getName().equals("givenContent"))
	    	 {
	    		 analyzeGiven(t,analysisStep);
	    	 }
	    	 
	    	 if(t.getName().equals("givenUmpleModel"))
	    	 {
	    		 analyzeGivenModel(t,analysisStep);
	    	 }
	    	 
	    	 if(t.getName().equals("whenCont"))
	    	 {
	    		 analyzeWhen(t,analysisStep);
	    	 }
	    	 
	    	 if(t.getName().equals("parameter"))
	    	 {
	    		 analyzeParameter(t,analysisStep);
	    	 }
	    	 
	    	 if(t.getName().equals("thenCont"))
	    	 {
	    		 analyzeThen(t,analysisStep);
	    	 }
	    	  
	    	  
	        /*if (!getParseResult().getWasSuccess())
	        {
	          return;
	        }*/
	      }
	    }
	    while (shouldProcessAgain);
  }

  // line 97 "../../../../ump/mbt_parser_src.ump"
   private void analyzeAssertEqual(Token t, int analysisStep, TestCase aTestCase, int aLocOrder){
    //System.out.println("EqualAnalysis");
	  Token ts = t.getSubToken("assertEqualCode");
	  String assertCode = analyzeAssertEqualCode(ts, analysisStep);
	  //assertCode = ts.getValue("objectName1") +","+ts.getValue("objectName2");
	  aTestCase.addAssertion(new Assertion("AssertEqual", null, null, "equal", assertCode,null, null, locOrder));
	  System.out.println("\t\tEquLOC");
		System.out.println(locOrder);
	  locOrder++;
  }

  // line 108 "../../../../ump/mbt_parser_src.ump"
   private String analyzeAssertEqualCode(Token t, int analysisStep){
    String assertCode="";
	  String methodCallCode = "";
	  boolean isFirstObj = true;
	  boolean isFirstMethod = true;
	  for (Token tss : t.getSubTokens())
	  {
		  //System.out.println("EqToken");
		  //System.out.println(t.getName());		  
			if (tss.getName().equals("objectName1")) {
				if (aTestModel.getCodeLang().equals("PhpUnit")) {
					assertCode += "$" + tss.getValue();
				} 
				else if (aTestModel.getCodeLang().equals("RubyUnit")) {
					assertCode += tss.getValue();
				}
				else {
					assertCode += tss.getValue();
				}
				isFirstObj = true;
			}
			
			if (tss.getName().equals("objectName2")) {
				if (aTestModel.getCodeLang().equals("PhpUnit")) {
					assertCode += "$" + tss.getValue();
				} else if (aTestModel.getCodeLang().equals("RubyUnit")) {
						assertCode += "(" + tss.getValue() + ")";
					}
				else {
					assertCode += tss.getValue();
				}

				isFirstObj = false;

			}
			
		  if (tss.getName().equals(".")){ 
			  
				  if (aTestModel.getCodeLang().equals("PhpUnit"))
				  {
					  assertCode += "->";
				  }
				  else
				  {
				
					  assertCode += tss.getName();
				
				  }
			  }
		  if (tss.getName().equals("assertEqualMethodCall")) {
			  
			  for (Token sbt : tss.getSubTokens())
			  {
				  if(sbt.getName().equals("methodName")) {
					  if (aTestModel.getCodeLang().equals("RubyUnit") && (sbt.getValue().contains("get") || sbt.getValue().subSequence(0, 3).equals("set")))
					  {
						String dashedMethod = sbt.getValue().substring(0, 3) + "_" + sbt.getValue().substring(3, 4).toLowerCase() +sbt.getValue().substring(4, sbt.getValue().length());  
						methodCallCode+=dashedMethod;
					  }
					  
					  else if (aTestModel.getCodeLang().equals("RubyUnit") && sbt.getValue().contains("reset") )
					  {
						String dashedMethod = sbt.getValue().substring(0, 5) + "_" + sbt.getValue().substring(5, 6).toLowerCase() +sbt.getValue().substring(6, sbt.getValue().length());  
						methodCallCode+=dashedMethod;
					  }
					  else{
						  methodCallCode+=sbt.getValue();
					  }
					  }
				  if (sbt.getName().equals("(")){ 
					  if (aTestModel.getCodeLang().equals("RubyUnit"))
					  {
						  methodCallCode += "";
					  }
					  else{
						  methodCallCode += sbt.getName();
					  }
						  }
				  if (sbt.getName().equals(")")){
					  if (aTestModel.getCodeLang().equals("RubyUnit"))
					  {
						  methodCallCode += "";
					  }
					  else{
						  methodCallCode += sbt.getName();
					  }
					  }
			  }
			  if (aTestModel.getCodeLang().equals("RubyUnit") && (!isFirstObj))
			  {
				  assertCode = assertCode.substring(0, assertCode.length()-2);
				  assertCode += "."+methodCallCode + ")";
				  isFirstMethod = true;
			  }
			  else{
				  
				  assertCode += methodCallCode;
				  isFirstMethod = false;
			  }
			  
			  methodCallCode="";

			}
		  if (tss.getName().equals(",")){ 
			  if (aTestModel.getCodeLang().equals("RubyUnit"))
			  {
				  assertCode += ".equal?";
			  }
			  else {
				  assertCode += tss.getName();  
			  }
			  isFirstObj = false;
		  }
		   
		   
		  if (tss.getName().equals("(")){ assertCode += tss.getName();}
		  if (tss.getName().equals(")")){ assertCode += tss.getName();}
		  //if (tss.getName().equals("objectName") ) { assertCode += tss.getValue(); }
		  //if (tss.getName().equals("objectName") ) { assertCode += tss.getValue(); }
		  	  
	  }
	  
	  return assertCode;
  }

  // line 234 "../../../../ump/mbt_parser_src.ump"
   private void analyzeAssertFalse(Token t, int analysisStep, TestCase aTestCase, int aLocOrder){
    String assertCode = analyzeAssertCode(t, analysisStep, null);
	aTestCase.addAssertion(new Assertion("AssertFalse", null, null, "equal", assertCode,null, null, locOrder));
	System.out.println("\t\tFalseLOC");
	System.out.println(locOrder);
	locOrder++;
  }

  // line 242 "../../../../ump/mbt_parser_src.ump"
   private void analyzeAssertTrue(Token t, int analysisStep, TestCase aTestCase, int aLocOrder){
    String assertCode = analyzeAssertCode(t, analysisStep, null);
	aTestCase.addAssertion(new Assertion("AssertTrue", null, null, "equal", assertCode,null, null, locOrder));
	System.out.println("\t\tTrueLOC");
	System.out.println(locOrder);
	locOrder++;
  }

  // line 252 "../../../../ump/mbt_parser_src.ump"
   private void analyzeGenerate(Token t, int analysisStep){
    //setting the target platform
	System.out.println(t.getValue("codeLang"));
	aTestModel.setCodeLang(t.getValue("codeLang"));
  }

  // line 260 "../../../../ump/mbt_parser_src.ump"
   private String analyzeAssertCode(Token t, int analysisStep, Assertion as){
    String assertCode="";
	String methodCallCode="";
	boolean isFirst = true;
for ( Token st : t.getSubTokens())
		
	{
	
	if(st.getName().equals("assertCode"))
	 {
		for (Token sst: st.getSubTokens())
		{
			if (sst.getName().equals("methodCall"))
			{
				methodCallCode = analyzeMethodCall(sst, analysisStep, as);
				assertCode+= methodCallCode;
			}
			
			else if (sst.getName().equals("compValue"))
			{
				//System.out.println("compV");
				//System.out.println(sst.getValue());
				if (aTestModel.getCodeLang().equals("RubyUnit") )
				 {
					if (sst.getValue().contains("null"))
						assertCode+= sst.getValue().replace("null", "nil");
					else {
						assertCode+= sst.getValue();
					}
				 }
				else {
					assertCode+= sst.getValue();
				}
			}
			
			else if (sst.getName().equals("==") || sst.getName().equals("!="))
			{
				assertCode+= sst.getName();				
			}
			
			else{				
			assertCode += sst.getName();
			}
		}
	 }
	
		
	}
	
return assertCode;
  }

  // line 312 "../../../../ump/mbt_parser_src.ump"
   private String analyzeMethodCall(Token t, int analysisStep, Assertion as){
    String code="";
	boolean isFirst = true;
	
	for (Token st: t.getSubTokens())
	{
		//System.out.println(st.getName());
		
		if (st.getName().equals("objectName"))
		{

			if (aTestModel.getCodeLang().equals("PhpUnit"))
			{
				//System.out.println("codeLangforPhp");
				//System.out.println(aTestModel.getCodeLang());
				// Injecting '$' sign for Php objectName tokens.
				code += ("$" + st.getValue());
			}
			else
			{
				code += st.getValue();
			}
		}
		
		if (st.getName().equals("."))
		{
			if (aTestModel.getCodeLang().equals("PhpUnit"))
			{
				// replacing method call for PhpUnit with '->'
				code += "->";
			}
			else
			{
				code += st.getName();
			}
		}
		
		if (st.getName().equals("methodName"))
		{
			if (aTestModel.getCodeLang().equals("RubyUnit") && (st.getValue().contains("get") || st.getValue().subSequence(0, 3).equals("set")))
			  {
				String dashedMethod = st.getValue().substring(0, 3) + "_" + st.getValue().substring(3, 4).toLowerCase() +st.getValue().substring(4, st.getValue().length());  
				code+=dashedMethod;
			  }
			else if (aTestModel.getCodeLang().equals("RubyUnit") && st.getValue().contains("reset") )
			  {
				String dashedMethod = st.getValue().substring(0, 5) + "_" + st.getValue().substring(5, 6).toLowerCase() +st.getValue().substring(6, st.getValue().length());  
				code+=dashedMethod;
			  }
			  else{
				  code += st.getValue();
			  }
			
		}
		
		if (st.getName().equals("("))
		{
			if(aTestModel.getCodeLang().equals("RubyUnit"))
			{
				code += "";
			}
			
			else{
				code += st.getName();
			}
		}
		
		if (st.getName().equals("assertParameter"))
		{
			String parameterCode="";
		    Token sst = st.getSubToken("assertParameter"); 
			for (Token sbt : sst.getSubTokens())
			{
			 parameterCode += sbt.getValue();
			 //System.out.println("parCode");
			 //System.out.println(parameterCode);
			}
			code+= parameterCode;
			
		}
		
		if (st.getName().equals(")"))
		{
			if(aTestModel.getCodeLang().equals("RubyUnit"))
			{
				code += "";
			}
			
			else{
				code += st.getName();
			}
		}
		
		if (st.getName().equals(";"))
		{
			code += ";";
		}

		
		
	}
	//System.out.println("MethodCode");
	//System.out.println(code+";");
	return code;
  }

  // line 419 "../../../../ump/mbt_parser_src.ump"
   private void analyzeAssertions(Token t, int analysisStep, TestCase aTestCase, int aLocOrder){
    for ( Token st : t.getSubTokens())
		
	{
	
	if(st.getName().equals("assertionTrue"))
	 {
		 analyzeAssertTrue(st,analysisStep, aTestCase, locOrder);
		 
		 
	 }
	 
	 if(st.getName().equals("assertionFalse"))
	 {
		 analyzeAssertFalse(st,analysisStep, aTestCase, locOrder);
		 
	 }
	 
	 if(st.getName().equals("assertionEqual"))
	 {
		 analyzeAssertEqual(st,analysisStep, aTestCase, locOrder);
		 
	 }
		
	}
  }

  // line 451 "../../../../ump/mbt_parser_src.ump"
   private void analyzeTestCase(Token t, int analysisStep){
    locOrder=0;
	TestCase aTestCase = new TestCase(t.getValue("testCaseName"),locOrder);
	
for ( Token st : t.getSubTokens())
		
	{
	
	if(st.getName().equals("initialization"))
	 {
		System.out.println("\tInitlocOrder");
		System.out.println(locOrder);
		analyzeInit(st,analysisStep, aTestCase, locOrder);
		locOrder++;
	 }
	
	 if(st.getName().equals("methodCall"))
  	 {
		 System.out.println("\tMethlocOrder");
		 System.out.println(locOrder);
  		 analyzeMethodCall(st,analysisStep, aTestCase,locOrder);
  		 locOrder++;
  	 }
	
   	 if(st.getName().equals("assertions"))
   	 {
   		
   		analyzeAssertions(st,analysisStep, aTestCase, locOrder);
   	 }
		
	}
	System.out.println("TClocOrder");
	System.out.println("testName "+aTestCase.getName());
	System.out.println(locOrder);
	aTestCase.setLocOrder(locOrder);
	aTestModel.getTestSuite(0).addTestcase(aTestCase);
  }

  // line 492 "../../../../ump/mbt_parser_src.ump"
   private void analyzeMethodCall(Token t, int analysisStep, TestCase aTestCase, int locOrder){
    //MEthod calls within test cases example: object.delete();
	String code = "";
	
	for (Token st: t.getSubTokens())
	{
		//System.out.println(st.getName());
		
		if (st.getName().equals("objectName"))
		{

			if (aTestModel.getCodeLang().equals("PhpUnit"))
			{
				//System.out.println("codeLangforPhp");
				//System.out.println(aTestModel.getCodeLang());
				// Injecting '$' sign for Php objectName tokens.
				code += ("$" + st.getValue());
			}
			else
			{
				code += st.getValue();
			}
		}
		
		if (st.getName().equals("."))
		{
			if (aTestModel.getCodeLang().equals("PhpUnit"))
			{
				// replacing method call for PhpUnit with '->'
				code += "->";
			}
			else
			{
				code += st.getName();
			}
		}
		
		if (st.getName().equals("methodName"))
		{
			if (aTestModel.getCodeLang().equals("RubyUnit") && (st.getValue().contains("get") || st.getValue().subSequence(0, 3).equals("set")))
			  {
				String dashedMethod = st.getValue().substring(0, 3) + "_" + st.getValue().substring(3, 4).toLowerCase() +st.getValue().substring(4, st.getValue().length());  
				code+=dashedMethod;
			  }
			else if (aTestModel.getCodeLang().equals("RubyUnit") && st.getValue().contains("reset") )
			  {
				String dashedMethod = st.getValue().substring(0, 5) + "_" + st.getValue().substring(5, 6).toLowerCase() +st.getValue().substring(6, st.getValue().length());  
				code+=dashedMethod;
			  }
			  else{
				  code += st.getValue();
			  }
			
		}
		
		if (st.getName().equals("("))
		{
			code += st.getName();
		}
		
		if (st.getName().equals("assertParameter"))
		{
			String parameterCode="";
		    Token sst = st.getSubToken("assertParameter"); 
			for (Token sbt : sst.getSubTokens())
			{
			 parameterCode += sbt.getValue();
			 //System.out.println("parCode");
			 //System.out.println(parameterCode);
			}
			code+= parameterCode;
			
		}
		
		if (st.getName().equals(")"))
		{
			code += st.getName();
		}
		
		if (st.getName().equals(";"))
		{
			code += ";";
		}

		
		
	}
	//System.out.println("MethodCode");
	//System.out.println(code+";");
	//System.out.println("ActionCode");
	//System.out.println(code);
	aTestCase.addAction( new Action("",code,locOrder));
  }

  // line 587 "../../../../ump/mbt_parser_src.ump"
   private void analyzeInit(Token t, int analysisStep, TestCase aTestCase, int locOrder){
    TestInitialization aInit  = new TestInitialization (null, "construction", t.getValue("identifier"), t.getValue("name"), locOrder);
	Token st = t.getSubToken("parameter");
	//Parameter aParameter = new Parameter(t.getValue("Parameter"), t.getValue("identifier"), null);
	
for ( Token sst : st.getSubTokens())
		
	{
	if (sst.getName().equals("pValue"))
	 {	
		aInit.addParameter(new Parameter(sst.getValue(), "", sst.getValue()));
	 }
	}


	
	aTestCase.addInit(aInit);
  }

  // line 608 "../../../../ump/mbt_parser_src.ump"
   private void analyzeThen(Token t, int analysisStep){
    for ( Token st : t.getSubTokens())
		
	{
	if(st.getName().equals("testCase"))
	 {
		 analyzeTestCase(st,analysisStep);
	 }
		
	}
  }

  // line 623 "../../../../ump/mbt_parser_src.ump"
   private void analyzeParameter(Token t, int analysisStep){
    //System.out.println("analyzeParam"); analysis done within parent token
  }

  // line 627 "../../../../ump/mbt_parser_src.ump"
   private void analyzeWhen(Token t, int analysisStep){
    // TODO Auto-generated method stub
	
for ( Token st : t.getSubTokens())
		
	{
	if(st.getName().equals("initialization"))
	 {
		 analyzeInit(st,analysisStep);
	 }
		
	}
  }

  // line 642 "../../../../ump/mbt_parser_src.ump"
   private void analyzeGivenModel(Token t, int analysisStep){
    // TODO Auto-generated method stub
  }

  // line 647 "../../../../ump/mbt_parser_src.ump"
   private void analyzeGiven(Token t, int analysisStep){
    // TODO Auto-generated method stub
  }

  // line 652 "../../../../ump/mbt_parser_src.ump"
   private void analyzeModel(Token t, int analysisStep){
    TestSuite aTestSuite = new TestSuite(aTestModel);
	aTestModel.setFile(t.getValue("modelName")+".ump");	
	aTestModel.addTestSuite(aTestSuite);
  }

  // line 658 "../../../../ump/mbt_parser_src.ump"
   private void analyzeInit(Token t, int analysisStep){
    for ( Token st : t.getSubTokens())
		
	{
	if(st.getName().equals("parameter"))
	 {
		 analyzeParameter(st,analysisStep);
	 }
		
	}
  }

  // line 672 "../../../../ump/mbt_parser_src.ump"
   private void analyzeToken(Token t, int analysisStep){
    
  }

  // line 676 "../../../../ump/mbt_parser_src.ump"
   private void analyzeDepend(Token t, int analysisStep){
    //ArrayList<String> depends = new ArrayList<String>();
	 	  
	  for ( Token st : t.getSubTokens())
			
		{
		if(st.getName().equals("pValue"))
		 {
			depends.add(new Depend(st.getValue(),"",aTestModel));
		 }
			
		}
  }

  // line 690 "../../../../ump/mbt_parser_src.ump"
   public void prepare(){
    // TODO Auto-generated method stub
	  
	  mbt.addGrammarFile(grammarFile);
	  mbt.parse(testModelFile);
	  mbt.getGRootToken();
	  analyzeAllTokens(mbt.getRootToken());
  }


  public String toString()
  {
    return super.toString() + "["+
            "shouldProcessAgain" + ":" + getShouldProcessAgain()+ "," +
            "grammarFile" + ":" + getGrammarFile()+ "," +
            "locOrder" + ":" + getLocOrder()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "mbt" + "=" + (getMbt() != null ? !getMbt().equals(this)  ? getMbt().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "parseResult" + "=" + (getParseResult() != null ? !getParseResult().equals(this)  ? getParseResult().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "testModelFile" + "=" + (getTestModelFile() != null ? !getTestModelFile().equals(this)  ? getTestModelFile().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "aTestModel" + "=" + (getATestModel() != null ? !getATestModel().equals(this)  ? getATestModel().toString().replaceAll("  ","    ") : "this" : "null");
  }
}