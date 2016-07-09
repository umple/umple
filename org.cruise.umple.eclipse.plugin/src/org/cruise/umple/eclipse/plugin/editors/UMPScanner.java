package org.cruise.umple.eclipse.plugin.editors;

import org.eclipse.jface.text.rules.*;
import org.eclipse.jface.text.*;

public class UMPScanner extends RuleBasedScanner {

	public UMPScanner(ColorManager manager) {

		 WordRule rule = new WordRule(new IWordDetector() {
	            public boolean isWordStart(char c) { 
	         	return Character.isJavaIdentifierStart(c); 
	            }
	            public boolean isWordPart(char c) {   
	            	return Character.isJavaIdentifierPart(c); 
	            }
	         });
		
		 IToken keyword = new Token(new TextAttribute(manager.getColor(IUMPColorConstants.KEYWOED), null, 1));
		 IToken comment = new Token(new TextAttribute(manager.getColor(IUMPColorConstants.UMP_COMMENT)));
		 IToken string = new Token(new TextAttribute(manager.getColor(IUMPColorConstants.STRING)));
		
         //add tokens for each reserved word
         for (int n = 0; n < Parser.KEYWORDS.length; n++) {
            rule.addWord(Parser.KEYWORDS[n], keyword);
         }
         for (int n = 0; n < Parser.KEYWORDS_TYPES.length; n++) {
             rule.addWord(Parser.KEYWORDS_TYPES[n], keyword);
         }
         for (int n = 0; n < Parser.KEYWORDS_VISIBILITY.length; n++) {
             rule.addWord(Parser.KEYWORDS_VISIBILITY[n], keyword);
         }
         for (int n = 0; n < Parser.KEYWORDS_LANGUAGES.length; n++) {
             rule.addWord(Parser.KEYWORDS_LANGUAGES[n], keyword);
         }
         
         
		IRule[] rules = new IRule[5];
		rules[0] = rule;
		rules[1] = new MultiLineRule("/*", "*/", comment);
		rules[2] = new SingleLineRule("//","", comment);
		rules[3] = new SingleLineRule("\"","\"", string);
		
		// Add generic whitespace rule.
		rules[4] = new WhitespaceRule(new UMPWhitespaceDetector());
		setRules(rules);
	}
}
