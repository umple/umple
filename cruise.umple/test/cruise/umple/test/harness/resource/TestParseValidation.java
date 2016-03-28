/*******************************************************************************
* Copyright (c) 2016 Ahmed M.Orabi, Mahmoud M.Orabi.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Ahmed M.Orabi
*     Mahmoud M.Orabi
*
* Please refer to the code authors before making any changes. 
* For any code reuse or copy, contact the authors and it is a MUST 
* to refer author names.
*
* @author -Ahmed M.Orabi {@link ahmedvc@hotmail.com}
* @author Mahmoud M.Orabi {@link mahmoud_3rabi@hotmail.com}
*******************************************************************************/
package cruise.umple.test.harness.resource;

import java.io.File;
import java.util.List;

import cruise.umple.parser.ErrorMessage;
import cruise.umple.parser.ParseResult;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleInternalParser;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.UmpleParser;
import cruise.umple.compiler.java.JavaClassGenerator;
import cruise.umple.parser.analysis.RuleBasedParser;
import junit.framework.Assert;

public class TestParseValidation {

  private String name;
  private String path;
  private int msgNumber;
  private UmpleModel umpleModel;
  private String parserName;

  public TestParseValidation(String aName, String aPath, int aMsgNumber) {
	name = aName;
    path = aPath;
    msgNumber = aMsgNumber;
    parserName = "cruise.umple.compiler.UmpleInternalParser";
  }
  
  private void initUmpleModel(){	  
		String checkFile = getPath();
		if (!(new File(checkFile).exists())) { 
			Assert.fail("Unable to locate umple file: " + checkFile);
		}
		// Nullify mainMainClass
		JavaClassGenerator.mainMainClass = null;
		UmpleFile umpFile = new UmpleFile(getPath());
		umpleModel = new UmpleModel(umpFile);
	}
  
  	private void assertParseResults(ParseResult result) {
	    List<ErrorMessage> errors = result.getErrorMessages();
	    Assert.assertEquals(errors.size(), 1);
	    for(ErrorMessage er : errors) {
	      Assert.assertTrue(er.toString().contains(String.valueOf(msgNumber)));
	    }
  	}

	public void assertParsing() {
		initUmpleModel();
		RuleBasedParser ruleParser = new RuleBasedParser();
		UmpleParser parser = new UmpleInternalParser(parserName, umpleModel, ruleParser);
    File file = new File(umpleModel.getUmpleFile().getPath() + File.separator + umpleModel.getUmpleFile().getFileName());
		ParseResult result = ruleParser.parse( file );
		umpleModel.setLastResult(result);
		result = parser.analyze(true);
		assertParseResults(result);
	}

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPath(String aPath)
  {
    boolean wasSet = false;
    path = aPath;
    wasSet = true;
    return wasSet;
  }

  public boolean setMsgNumber(int aMsgNumber)
  {
    boolean wasSet = false;
    msgNumber = aMsgNumber;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getPath()
  {
    return path;
  }

  public int getMsgNumber()
  {
    return msgNumber;
  }



}