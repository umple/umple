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
package cruise.umple.implementation.umpleTL;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.test.harness.resource.TemplateGeneratedOutput;
import cruise.umple.test.harness.resource.TestParseValidation;
import cruise.umple.test.harness.resource.TestResource;
import cruise.umple.util.SampleFileWriter;

public class UmpleTLTest {	
	public String pathToInput;
	private List<TestResource> tests;
	
	@Before
	public void setUp() {
		pathToInput = SampleFileWriter.rationalize("test/cruise/umple/implementation/umpleTL/resources");
		tests = new ArrayList<TestResource>();
	}
	
	@After
	  public void tearDown() {
		  for(TestResource test : tests) {
			  test.destroy();
		  }
	  }

	@Test 
	public void testExpressions() {
		TestResource test = new TestResource("Expressions", pathToInput + "/UmpleTL_Expressions",
				new TemplateGeneratedOutput[] {
						new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt"})
			});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}
	
	@Test 
	public void testCommentBlock() {
		TestResource test = new TestResource("CommentBlock", pathToInput + "/UmpleTL_CommentBlock",
				new TemplateGeneratedOutput[] {
						new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt"})
				});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}
	
	@Test 
	public void testComplexExample() {
		TestResource test = new TestResource("Complex", pathToInput + "/UmpleTL_complex_Generation",
				new TemplateGeneratedOutput[] {
						new TemplateGeneratedOutput("Java", new String[] {"HtmlNode.java.txt"})
				});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("HtmlNode");
	}
	
	@Test 
	public void testEmitMethodWithSharedTemplateDefinitions() {
		TestResource test = new TestResource("Emit Method - refer to a referenced templateDefinition", pathToInput + "/UmpleTL_Emit_referToSharedTemplateDefinition",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"SharedTemplateHelper1.java.txt","SharedTemplateHelper2.java.txt","TemplateTest.java.txt"})
				});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}
	

	@Test 
	public void testEmitMethodWithManyTemplateDefinitions() {
		TestResource test = new TestResource("Emit Method - many templateDefinitions", pathToInput + "/UmpleTL_Emit_with_many_templateDefinitions",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt"})
				});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
		
	}

	@Test 
	public void testEmitMethodWithManyParameters() {
		TestResource test = new TestResource("Emit Method - many parameters", pathToInput + "/UmpleTL_Emit_with_parameters",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt"})
				});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}

	@Test 
	public void testSpaceFormattingMethods() {
		TestResource test =new TestResource("Space formatting methods", pathToInput + "/UmpleTL_ExactSpace_methods",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt"})
				});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}
	
	@Test 
	public void testCodBlocksAndExpressions() {
		TestResource test =new TestResource("CodeBlock and Expressions", pathToInput + "/UmpleTL_CodeBlock_and_Expression",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt"})
				});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}
	
	@Test 
	public void testNestedReferenceTemplates() {
		TestResource test =new TestResource("Nested Reference templates", pathToInput + "/UmpleTL_Nested_reference_templates",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"ClassGenerator.java.txt"})
		});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("ClassGenerator");
	}

	@Test 
	public void testSimpleCodeBlock() {
		TestResource test =new TestResource("Simple CodeBlock", pathToInput + "/UmpleTL_simpleCodeBlock",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt"})
		});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}

	@Test 
	public void basicTest() {
		TestResource test =new TestResource("Basic Test", pathToInput + "/UmpleTL_simpleTest",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt"})
		});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}
	
	@Test 
	public void testStaticEmit() {
		TestResource test =new TestResource("Static Emit", pathToInput + "/UmpleTL_SingletonEmit",
				new TemplateGeneratedOutput[] {
				new TemplateGeneratedOutput("Java", new String[] {"TemplateTest.java.txt","HelperTemplate.java.txt"})
		});
		tests.add(test);
		test.assertUmpleTemplate();
		test.assertUmpleTemplateCompilationAndRunOutput("TemplateTest");
	}

	@Test 
	public void testDuplicatedEmitMethods() {
		TestParseValidation test =new TestParseValidation("duplicated emit methods", pathToInput+ "/UmpleTL_parsingTests/emitMethod_duplicated.ump", 3507);
		test.assertParsing();
	}
	
	@Test 
	public void testTemplateDefinitionCanNotReferToItself() {
		TestParseValidation test =new TestParseValidation("templateDefinition can not refer to itself", pathToInput+ "/UmpleTL_parsingTests/templateDefinition_canNotReferToItself.ump", 3503);
		test.assertParsing();
	}
	
	@Test 
	public void testCyclicCheck1() {
		TestParseValidation test =new TestParseValidation("cyclic check", pathToInput+ "/UmpleTL_parsingTests/templateDefinition_cyclicCheck1.ump", 3505);
		test.assertParsing();
	}
	
	@Test 
	public void testCyclicCheck2() {
		TestParseValidation test =new TestParseValidation("cyclic check", pathToInput+ "/UmpleTL_parsingTests/templateDefinition_cyclicCheck2.ump", 3505);
		test.assertParsing();
	}
	
	
	@Test 
	public void testTemplateDefinitionInvalidName() {
		TestParseValidation test =new TestParseValidation("templateDefinition invalid name", pathToInput+ "/UmpleTL_parsingTests/templateDefinition_invalidname.ump", 3500);
		test.assertParsing();
	}
	
	@Test 
	public void testTemplateDefinitionNotResolved() {
		TestParseValidation test =new TestParseValidation("templateDefinition can not be resolved", pathToInput+ "/UmpleTL_parsingTests/templateDefinition_non_resolved.ump", 3502);
		test.assertParsing();
	}
	
	@Test 
	public void testDuplicatedTemplateDefinition() {
		TestParseValidation test =new TestParseValidation("duplicated emit templateDefinitions", pathToInput+ "/UmpleTL_parsingTests/templateDefinition_duplicated.ump", 3506);
		test.assertParsing();
		SampleFileWriter.destroy(pathToInput+ "/UmpleTL_parsingTests/TemplateTest.java");
	}
	
}
