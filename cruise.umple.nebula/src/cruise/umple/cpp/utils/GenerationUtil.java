/*******************************************************************************
* Copyright (c) 2013 Ahmed M.Orabi, Mahmoud M.Orabi.
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
package cruise.umple.cpp.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cruise.umple.core.CommonConstants;
import cruise.umple.core.GenerationPolicyRegistry;


public class GenerationUtil {

	private GenerationUtil() {
		// prevent external construction
	}

	public static String getFileOutputName(String fileName, String extension) {
		return extension != null ? fileName + CommonConstants.DOT + extension: fileName;
	}

	public static String singleLineComment(List<String> comments){
		if(comments== null|| comments.isEmpty()){
			return CommonConstants.BLANK;
		}
		
		String doubleSlash = CommonConstants.FORWARD_SLASH+ CommonConstants.FORWARD_SLASH;
		String commentString= doubleSlash;
		Iterator<String> iterator = comments.iterator();
		
		while(iterator.hasNext()){
			String operationComment= iterator.next();
			operationComment= operationComment.trim();
			commentString= commentString+ operationComment; 
			if(iterator.hasNext()){
				commentString= commentString + CommonConstants.NEW_LINE + doubleSlash;
			}
		}
		return commentString;
	}
	
	public static String multiLineComment(List<String> comments){
		if(comments== null|| comments.isEmpty()){
			return CommonConstants.BLANK;
		}
		
		String commentString= CommonConstants.FORWARD_SLASH+ CommonConstants.ASTERISK+ CommonConstants.NEW_LINE;
		Iterator<String> iterator = comments.iterator();
		
		while(iterator.hasNext()){
			String operationComment= iterator.next();
			commentString= commentString+ CommonConstants.SPACE+ CommonConstants.ASTERISK+ CommonConstants.SPACE+ operationComment; 
			if(iterator.hasNext()){
				commentString= commentString + CommonConstants.NEW_LINE;
			}
		}
		commentString= commentString+ CommonConstants.NEW_LINE+ CommonConstants.SPACE+ CommonConstants.ASTERISK+ CommonConstants.FORWARD_SLASH;
		return commentString;
	}

	public static String getImplementationAndIndentDetails(GenerationPolicyRegistry generationValueGetter, String id, int seaprate, int indent, Object... element) {
		return listToGeneratedString(seaprate, indent, generationValueGetter.getValues(id, element));
	}

	public static String listToGeneratedString(int seaprate, int indent, List<?> values) {
		if(values== null){
			return CommonConstants.BLANK;
		}
		
		int size=0;
		
		List<Object> appends= new ArrayList<Object>();
		Iterator<?> iterator = values.iterator();
		
		int newLineSize = CommonConstants.NEW_LINE.length();
		while(iterator.hasNext()){
			Object next = iterator.next();
			appends.add(next);
			size+= next.toString().length();
			
			if(iterator.hasNext()){
				appends.add(CommonConstants.NEW_LINE);
				size+= newLineSize;
				for(int index=0; index< seaprate; index++){
					appends.add(CommonConstants.NEW_LINE);
					size+= newLineSize;
				}
			}
		}
		
		if(appends.isEmpty()){
			return CommonConstants.BLANK;
		}
		
		StringBuffer results= new StringBuffer(size);
		if(values.size()>1&& seaprate>0){
			results= new StringBuffer(size+1);
			results.append(CommonConstants.BLANK);
		}else{
			results= new StringBuffer(size);
		}
		
		for(Object object: appends){
			results.append(object);
		}
		
		if(indent>0){
			results= new StringBuffer(StringUtil.indent(results.toString(), indent));
		}
		
		return results.toString();
	}
	
	public static String asStringParameters(List<?> list, String... sepratorMessage) {
		String string= CommonConstants.BLANK;
		
		if(list== null|| list.isEmpty()){
			return string;
		}
		
		Iterator<?> eventsParametersIterator = list.iterator();
		while(eventsParametersIterator.hasNext()){
			Object next = eventsParametersIterator.next();
			
			if(!eventsParametersIterator.hasNext()){
				if(sepratorMessage.length>0&& !string.isEmpty()){
					string= string+ sepratorMessage[0]+ CommonConstants.SPACE;
				}
			}
			
			string= string+ next.toString().trim();
			
			if(eventsParametersIterator.hasNext()){
				string= string+ CommonConstants.COMMA_SEPARATOR;
			}
		}
		return string;
	}
	
}
