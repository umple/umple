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
package cruise.umple.cpp.util;

import java.util.ArrayList;
import java.util.List;

import cruise.umple.core.CommonConstants;
import cruise.umple.compiler.Association;
import cruise.umple.compiler.AssociationEnd;
import cruise.umple.compiler.AssociationVariable;
import cruise.umple.compiler.Comment;
import cruise.umple.compiler.Position;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleElement;
import cruise.umple.compiler.UmpleModel;

public class UmpleCPPGenerationUtil {

	public static String getQualifiedNme(UmpleElement umpleElement){
		
		String packageName = umpleElement.getPackageName();
		String name = umpleElement.getName();
		if(name== null){
			name= CommonConstants.BLANK;
		}
		
		if(packageName== null|| packageName.isEmpty()){
			return name.toUpperCase();
		}
		
		return packageName.replace(CommonConstants.DOT, CommonConstants.UNDERSCORE)+ 
				CommonConstants.UNDERSCORE+ name.toUpperCase();
	}
	
	//FIXME: Hack!. The method "getRelativePath" is designed for UmpleClass instances only which means that it won't be usable for UmpleElement even if they do have
	//Line numbers
	public static List<String> getPositions(List<Position> elementPositions,
			String language, UmpleElement umpleElement, UmpleModel modelPackage) {
		
		UmpleClass umpleClass = new UmpleClass(umpleElement.getName());
		umpleClass.setPackageName(umpleElement.getPackageName());
		umpleClass.setSourceModel(modelPackage);
		return getPositions(elementPositions, language, umpleClass);
	}
	
	public static List<String> getPositions(List<Position> elementPositions,
			String language, UmpleClass umpleClass) {
		List<String> positions = new ArrayList<String>();
		for (Position p : elementPositions) {
			if(p== null){
				continue;
			}
			StringBuffer stringBuffer= new StringBuffer();
		    stringBuffer.append("// line "); //$NON-NLS-1$
		    stringBuffer.append( p.getLineNumber() );
		    stringBuffer.append(" \""); //$NON-NLS-1$
		    stringBuffer.append( p.getRelativePath(umpleClass, language) );
		    stringBuffer.append("\""); //$NON-NLS-1$
		    positions.add(stringBuffer.toString());
		}
		return positions;
	}
	
	public static AssociationEnd getAssociationEnd(AssociationVariable associationVariable) {
		String typeName = associationVariable.getType();
		String otherEndType= associationVariable.getRelatedAssociation().getType();
		
		UmpleClass umpleClass = associationVariable.getUmpleClass();
		if(umpleClass== null){
			return null;
		}
		for(Association association: umpleClass.getAssociations()){
			List<AssociationEnd> ends = association.getEnds();
			AssociationEnd end1 = ends.get(0);
			String class1Name = end1.getClassName();
			AssociationEnd end2 = ends.get(1);
			String class2Name = end2.getClassName();
			
			if((class1Name.equals(typeName)&& class2Name.equals(otherEndType))||
					(class1Name.equals(otherEndType)&& class2Name.equals(typeName))){
				
				if(associationVariable.getMultiplicity().equals(end2.getMultiplicity())){
					return end1;
				}
				
				return end2;
			}
		}
		return null;
	}
	public static String getModelName(UmpleModel model){
		String defaultNamespace = model.getDefaultNamespace();
		return defaultNamespace!=null? defaultNamespace: model.getUmpleFile().getSimpleFileName();
	}
	
	public static List<String> getCommentStrings(List<Comment> comments){
		List<String> commentStrings= new ArrayList<String>(comments.size());
		for(Comment comment: comments){
			commentStrings.add(comment.getText());
		}
		return commentStrings;
	}
	
}
