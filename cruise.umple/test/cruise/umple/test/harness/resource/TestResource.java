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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cruise.umple.parser.ParseResult;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleInternalParser;
import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.UmpleParser;
import cruise.umple.compiler.java.JavaClassGenerator;
import cruise.umple.parser.analysis.RuleBasedParser;
import cruise.umple.test.harness.compiler.JavaInternalCompiler;
import cruise.umple.test.harness.compiler.interfaces.ICompiler;
import cruise.umple.util.SampleFileWriter;
import junit.framework.Assert;

public class TestResource {
	public static final int timeout = 10000; 
	private String path;
	private String modelFilename;
	private String name;
	private String output;
	private String parserName;
	private List<TemplateGeneratedOutput> templateGeneratedOutputs;
	private UmpleModel umpleModel;

	private static final Map<String, ICompiler> internalCompilers;
	static
	{
		internalCompilers = new HashMap<String, ICompiler>();
		internalCompilers.put("Java", new JavaInternalCompiler());
	}

	public TestResource(String aName, String aPath, TemplateGeneratedOutput [] aTemplateGeneratedOutputs) {
		path = aPath;
		name = aName;
		parserName = "cruise.umple.compiler.UmpleInternalParser";
		modelFilename = "test.ump";
		output = "output.txt";
		templateGeneratedOutputs = new ArrayList<TemplateGeneratedOutput>();
		templateGeneratedOutputs.addAll(Arrays.asList(aTemplateGeneratedOutputs));
		initTestResources();
	}

	private void initTestResources(){	  
		String checkFile = getPath() + "/" + getModelFilename();
		if (!(new File(checkFile).exists())) { 
			Assert.fail("Unable to locate umple file: " + checkFile);
		}
		for(TemplateGeneratedOutput to : templateGeneratedOutputs) {
			String language = to.getLanguage();
			String codeFile = getPath() + "/" + language;
			for(String file : to.getFiles()) {
				checkFile = codeFile + "/" + file;
				if (!(new File(checkFile).exists())) { 
					Assert.fail("Unable to locate code file: " + checkFile);
				}
			}
		}
		
		// Nullify mainMainClass
		JavaClassGenerator.mainMainClass = null;
		UmpleFile umpFile = new UmpleFile(getPath(), getModelFilename());
		umpleModel = new UmpleModel(umpFile);
		umpleModel.setShouldGenerate(false);
		parseModel();
	}

	private void parseModel() {
		RuleBasedParser ruleParser = new RuleBasedParser();
		UmpleParser parser = new UmpleInternalParser(parserName, umpleModel, ruleParser);
		ParseResult result = ruleParser.parse(umpleModel.getUmpleFile());
		umpleModel.setLastResult(result);
		if (!result.getWasSuccess()) {
			Assert.fail("Syntax Failed at:" + result.getPosition());
		}
		for(TemplateGeneratedOutput to : templateGeneratedOutputs) {
			String language = to.getLanguage();
			umpleModel.addGenerate(language);
		}
		result = parser.analyze(true);
		if (!result.getWasSuccess()) {
			Assert.fail("Semantics Failed at:" + result.getPosition());
		}
	}

	public void assertUmpleTemplate() {
		assertUmpleTemplate(true,true);
	}

	public void assertUmpleTemplateCompilationAndRunOutput(String mainClass) {
		for(TemplateGeneratedOutput to : templateGeneratedOutputs) {
			String language = to.getLanguage();
			ICompiler compiler = internalCompilers.get(language);
			if(compiler.isEnabled()) {
				compiler.setTempPath(getPath());
				for(String file : to.getFiles()) {
					String actualCodeFileName = getPath() + "/" +removeTemplateExtension(file);
					File actualCodeFile = new File(actualCodeFileName);				  
					Assert.assertEquals(true, actualCodeFile.exists());
					try {
						byte[] encoded = Files.readAllBytes(actualCodeFile.toPath());
						String actual  = new String(encoded, Charset.defaultCharset());
						compiler.addFile(removeTemplateExtension(actualCodeFile.getName()), actual);
					} catch (IOException e) {
						Assert.fail("failed to read file: " + actualCodeFileName);
					}
				}
				compiler.compile();
				String actual = compiler.run(mainClass, timeout);
				compiler.close();
				String actualCodeFileName = getPath() + "/" + output;
				File expectedFile = new File(actualCodeFileName);
				if(expectedFile.exists()) {
					SampleFileWriter.assertFileContent(expectedFile, actual);
				}
			}
		}

	}

	private String readStrippedCommentLine(BufferedReader reader) throws IOException {
		String line = reader.readLine();
		// HACK: To deal with // line # comments
		while (line != null && line.indexOf("// line") != -1)
		{ //Ignore the line, go to next
			line = reader.readLine();
		}
		return line;
	}

	private void assertFileContent(BufferedReader expectedReader, BufferedReader actualReader, boolean ignoreLineComments){
		try {
			String expectedLine = null;
			String actualLine = null;
			int line = 0;
			do {
				actualLine = readStrippedCommentLine(actualReader);
				expectedLine = readStrippedCommentLine(expectedReader);
				line++;	        
				// HACK: To deal with umple version issues
				if (expectedLine != null && expectedLine.indexOf("This code was generated using the UMPLE") == -1)
				{
					Assert.assertEquals("Failed at:" + line,expectedLine,actualLine);  
				}
			} 
			while (expectedLine != null && actualLine != null);
		}
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
		finally
		{
			SampleFileWriter.closeAsRequired(expectedReader);
			SampleFileWriter.closeAsRequired(actualReader);
		}
	}


	private String removeTemplateExtension(String filename) {
		// Remove the extension.
		int extensionIndex = filename.lastIndexOf(".");
		if (extensionIndex == -1)
			return filename;
		return filename.substring(0, extensionIndex);
	}

	public void assertUmpleTemplate(boolean isFullMatch, boolean ignoreLineComments) {
		if(umpleModel != null) {
			for(TemplateGeneratedOutput to : templateGeneratedOutputs) {
				String language = to.getLanguage();
				String codeFilePath = getPath() + "/" + language;
				for(String file : to.getFiles()) {
					String codeFileName = codeFilePath + "/" + file;
					String actualCodeFileName = getPath() + "/" +removeTemplateExtension(file);
					File codeFile = new File(codeFileName);
					File actualCodeFile = new File(actualCodeFileName);				  

					Assert.assertEquals(true, actualCodeFile.exists());
					try {
						byte[] encoded = Files.readAllBytes(actualCodeFile.toPath());
						String actual  = new String(encoded, Charset.defaultCharset());
						if (isFullMatch) {
							assertFileContent(new BufferedReader(new FileReader(codeFile)),new BufferedReader(new FileReader(actualCodeFile)),ignoreLineComments);
						}
						else
						{
							SampleFileWriter.assertPartialFileContent(codeFile, actual);
						}
					} catch (IOException e) {
						Assert.fail("failed to read file: " + actualCodeFileName);
					}
				}
			}
		}
	}

	public void destroy() {
		for(TemplateGeneratedOutput to : templateGeneratedOutputs) {
			String generatedFilePath = path + "/";
			for(String file : to.getFiles()) {
				String filePath = generatedFilePath + removeTemplateExtension(file);
				SampleFileWriter.destroy(filePath);
			}
		}
		// Nullify mainMainClass
		JavaClassGenerator.mainMainClass = null;
	}

	public void setPath(String aPath) {
		path = aPath;
	}

	public void setName(String aName) {
		name = aName;
	}

	public void setModelFilename(String aModelFilename) {
		modelFilename = aModelFilename;
	}

	public void setOutput(String aOutput) {
		output = aOutput;
	}

	public String getPath()
	{
		return path;
	}

	public String getName()
	{
		return name;
	}

	public String getModelFilename()
	{
		return modelFilename;
	}

	public String getOutput()
	{
		return output;
	}

	public TemplateGeneratedOutput getTemplateGeneratedOutput(int index)
	{
		TemplateGeneratedOutput aTemplateGeneratedOutput = templateGeneratedOutputs.get(index);
		return aTemplateGeneratedOutput;
	}

	public List<TemplateGeneratedOutput> getTemplateGeneratedOutputs()
	{
		return templateGeneratedOutputs;
	}

	public int numberOfTemplateGeneratedOutputs()
	{
		int number = templateGeneratedOutputs.size();
		return number;
	}

	public boolean hasTemplateGeneratedOutputs()
	{
		boolean has = templateGeneratedOutputs.size() > 0;
		return has;
	}

	public int indexOfTemplateGeneratedOutput(TemplateGeneratedOutput aTemplateGeneratedOutput)
	{
		int index = templateGeneratedOutputs.indexOf(aTemplateGeneratedOutput);
		return index;
	}

	public boolean addTemplateGeneratedOutput(TemplateGeneratedOutput aTemplateGeneratedOutput)
	{
		return templateGeneratedOutputs.add(aTemplateGeneratedOutput);
	}

	public boolean removeTemplateGeneratedOutput(TemplateGeneratedOutput aTemplateGeneratedOutput)
	{
		return templateGeneratedOutputs.remove(aTemplateGeneratedOutput);
	}

}