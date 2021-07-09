/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/


import java.io.*;
import java.net.*;
import java.util.*;
import cruise.umple.parser.Token;
import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.parser.ParseResult;

/**
 * Copyright: All contributers to the Umple Project
 * 
 * This file is made available subject to the open source license found at:
 * http://umple.org/license
 * This is our internal parser implementation for the Umple language.  It uses
 * a generic Parser that can read an external EBNF grammar file, and then populate
 * an abstract syntax tree.
 * 
 * The work of the UmpleInternalParser is 
 * 
 * a) The grammar definition (defined externally in *.grammar files)
 * b) Analyzing the AST to populate an Umple meta model instance
 * c) Delegating to our code generator to produce the necessary artifacts (i.e. Java / PHP / Ruby code)
 * 
 * Please refer to UmpleInternalParser_Code.ump for implementation details.
 */
// line 26 "UmpleRuleBasedParserExternized.ump"
public class TestParser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TestParser Attributes
  private RuleBasedParser rbp;
  private File file;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TestParser()
  {
    rbp = new RuleBasedParser();
    file = new File("TestFileAsSample.txt");
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRbp(RuleBasedParser aRbp)
  {
    boolean wasSet = false;
    rbp = aRbp;
    wasSet = true;
    return wasSet;
  }

  public boolean setFile(File aFile)
  {
    boolean wasSet = false;
    file = aFile;
    wasSet = true;
    return wasSet;
  }

  public RuleBasedParser getRbp()
  {
    return rbp;
  }

  /**
   * rbp.addGrammarFile("RuleBaseParserGrammarSample.grammar");
   */
  public File getFile()
  {
    return file;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "rbp" + "=" + (getRbp() != null ? !getRbp().equals(this)  ? getRbp().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "file" + "=" + (getFile() != null ? !getFile().equals(this)  ? getFile().toString().replaceAll("  ","    ") : "this" : "null");
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 37 "UmpleRuleBasedParserExternized.ump"
  rbp.parse(file) ;

  
}