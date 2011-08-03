package cruise.umple.umplificator.core.analyzer;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;

import cruise.umple.umplificator.core.types.UmpleType;

/**
 * Class used to analyze a Java Field.
 * Uses JDT Framework
 * @author Miguel Garzon
 *
 */

public class FieldAnalyzer {

	private static Logger logger = Logger.getLogger(FieldAnalyzer.class);
	
	public static boolean isAnAssociation(IField field){
		return !isPrimitiveType(field);
	}
	
	public static boolean hasValue(IField field) {
		int index;
		try {
			index = field.getSource().indexOf("=");
			if (index==-1){
				return false;
			}
			else{
				return true;
			}
		} catch (JavaModelException e) {
			logger.error("Unable to retrieve source from Field" + field.getElementName());
			return false;
		} 
	}
	
	public static String getValue(IField field){
		try {
			String source= field.getSource();
		
			if (hasValue(field)){
				return source.substring(source.indexOf("=") + 1, source.length() - 1);
			}
			else{
				return "";
			}
		} catch (JavaModelException e) {
			logger.error("Unable to retrieve source from Field" + field.getElementName());
			return null;
		}
		
	}

	public static String getUmpleType(IField f){
		String signature;
		try {
			signature = f.getTypeSignature();

			if (signature.equals(Signature.SIG_INT)) {
				return UmpleType.INTEGER.toString();
			} else if (signature.equals(Signature.SIG_SHORT)) {
				return UmpleType.INTEGER.toString();
			} else if (signature.equals(Signature.SIG_BYTE)) {
				return UmpleType.INTEGER.toString();
			} else if (signature.equals(Signature.SIG_BOOLEAN)) {
				return UmpleType.BOOLEAN.toString();
			} else if (signature.equals(Signature.SIG_CHAR)) {
				return UmpleType.STRING.toString();
			} else if (signature.equals(Signature.SIG_DOUBLE)) {
				return UmpleType.INTEGER.toString();
			} else if (signature.equals(Signature.SIG_FLOAT)) {
				return UmpleType.INTEGER.toString();
			} else if (signature.equals(Signature.SIG_LONG)) {
				return UmpleType.INTEGER.toString();
			}
			else if (signature.equals("QString;")) { 
				return UmpleType.STRING.toString();
			}
			else if (signature.equals("QDate;")) { 
				return UmpleType.DATE.toString();
			}else if (signature.equals("QCalendar;")) { 
				return UmpleType.STRING.toString();
			}
			else{
				return UmpleType.STRING.toString();
			}
		} catch (JavaModelException e) {
			logger.error("Unabe to retrieve Type Signature from field " + f.getElementName());
			return null;
		}		
		
	}

	public static boolean isPrimitiveType(IField f){
		String signature;
		try {
			signature = f.getTypeSignature();

			if (signature.equals(Signature.SIG_INT)) {
				return true;
			} else if (signature.equals(Signature.SIG_SHORT)) {
				return true;
			} else if (signature.equals(Signature.SIG_BYTE)) {
				return true;
			} else if (signature.equals(Signature.SIG_BOOLEAN)) {
				return true;
			} else if (signature.equals(Signature.SIG_CHAR)) {
				return true;
			} else if (signature.equals(Signature.SIG_DOUBLE)) {
				return true;
			} else if (signature.equals(Signature.SIG_FLOAT)) {
				return true;
			} else if (signature.equals(Signature.SIG_LONG)) {
				return true;
			}
			else if (signature.equals("QString;")) { 
				return true;
			}
			else if (signature.equals("QDate;")) { 
				return true;
			}else if (signature.equals("QCalendar;")) { 
				return true;
			}
			else{
				return false;
			}
		} catch (JavaModelException e) {
			logger.error("Unabe to retrieve Type Signature from field " + f.getElementName());
			return false;
		}		
	}




}
