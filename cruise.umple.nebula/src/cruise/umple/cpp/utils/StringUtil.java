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

import cruise.umple.core.CommonConstants;

public class StringUtil {
	
	public static String firstCharacterToLowerCase(String string, boolean normalized) {
		String firstCharacterToLowerCase = firstCharacterToLowerCase(string);
		if(normalized&& firstCharacterToLowerCase!= null){
			firstCharacterToLowerCase= firstCharacterToLowerCase.replace(CommonConstants.UNDERSCORE, CommonConstants.BLANK);
		}
		return firstCharacterToLowerCase;
	}
	
	public static String firstCharacterToUpperCase(String string, boolean normalized) {
		String firstCharacterToLowerCase = firstCharacterToUpperCase(string);
		if(normalized&& firstCharacterToLowerCase!= null){
			firstCharacterToLowerCase= firstCharacterToLowerCase.replace(CommonConstants.UNDERSCORE, CommonConstants.BLANK);
		}
		return firstCharacterToLowerCase;
	}
	
	public static String firstCharacterToLowerCase(String string) {
		if(string== null|| string.isEmpty()){
			return string;
		}
		if(string.length()==1){
			return string.toLowerCase();
		}
		return Character.toLowerCase(string.charAt(0)) + string.substring(1);
	}
	
	public static String firstCharacterToUpperCase(String string) {
		if(string== null|| string.isEmpty()){
			return string;
		}
		if(string.length()==1){
			return string.toUpperCase();
		}
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}
	
	public static String indent(String source, int level) {
		return indent(source, CommonConstants.TAB, level);
	}
	
	public static String indent(String source, String indentStr, int level) {
		String result = source;
		
		for(int index=0; index<level; index++){
			result= indent(result, indentStr);
		}
		
		return result;
	}
	
	public static String indent(String source, String indentStr) {
		String result = CommonConstants.BLANK;
		String[] lines = source.split(CommonConstants.NEW_LINE);
		for (int i=0; i<lines.length; i++) {
			result += indentStr + lines[i];
			if (i<lines.length-1) {
				result += CommonConstants.NEW_LINE;
			}
		}
		return result;
	}
	
	public static String startCommentLine(String extraComment, int indentLevel){
		return addNewCommentLine(CommonConstants.BLANK, extraComment, indentLevel);
	}
	
	public static String addNewCommentLine(String comment, String extraComment, int indentLevel){
		String updatedComment= comment;
		String commentLine = CommonConstants.SPACE+ CommonConstants.ASTERISK+ CommonConstants.SPACE;
		
		updatedComment= updatedComment+ CommonConstants.NEW_LINE;
		updatedComment= updatedComment+ StringUtil.indent(commentLine, indentLevel);
		updatedComment= updatedComment+ extraComment;
		return updatedComment;
	}
	
}
