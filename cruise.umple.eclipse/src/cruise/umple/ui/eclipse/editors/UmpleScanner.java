package cruise.umple.ui.eclipse.editors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;

import cruise.umple.ui.eclipse.editors.UmpleScanner.RegexRule;

public class UmpleScanner extends RuleBasedScanner {
	private boolean nextNameIsAnAttributeName = false;
	private boolean nextNameIsNotAType = false;
	private boolean nextTypeIsAClass=false;
	private boolean inMethod = false;
	private String currentClass = "";
	Scope currentScope;
	IToken attributeToken;
	IToken defaultToken;
	Scope rootScope;
	public UmpleScanner(ColorManager manager) {
		super();
		currentScope = new Scope();
		rootScope = currentScope;
		IToken modifierToken =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.RESERVED_WORD), null, SWT.ITALIC));

		IToken structIdentifierToken =
				new Token(new TextAttribute(manager.getColor(IUmpleColorConstants.TOKEN),
						null, SWT.BOLD));

		IToken associationMultToken =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.ASSOC_MULT), null, SWT.BOLD));

		IToken typeToken =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.DEFAULT), null, SWT.ITALIC));

		IToken defaultTokenBold =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.DEFAULT), null, SWT.BOLD));

		defaultToken =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.DEFAULT), null, SWT.BOLD));

		IToken reservedWordToken =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.RESERVED_WORD), null, SWT.BOLD));

		IToken reservedWordTokenThin =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.RESERVED_WORD), null, SWT.NONE));

		IToken commentToken =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.COMMENT), null, SWT.NONE));

		attributeToken =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.ATTRIBUTE), null, SWT.NONE));

		IToken quoteToken =
				new Token(new TextAttribute(manager
						.getColor(IUmpleColorConstants.QUOTE), null, SWT.NONE));
		
		
		// IToken tokenTwo = new Token(new
		// TextAttribute(manager.getColor(IXMLColorConstants.TAG)));

		List<IRule> rules = new LinkedList<IRule>();

		// IRule[] rules = new IRule[21];
		// Add rule for processing instructions
		rules.add(new ClassRule("class", structIdentifierToken));
		rules.add(new ClassRule("interface", structIdentifierToken));
		rules.add(new ClassRule("association", structIdentifierToken));
		rules.add(new EndOfLineRuleRule("//", commentToken));
		rules.add(new MultiLineRuleRule("/*","*/", commentToken));
		rules.add(new SingleLineRuleRule("\"","\"", quoteToken,'\\'));
		rules.add(new SingleLineRuleRule("\'","\'", quoteToken,'\\'));
		rules.add(new RegexWordRule("\\s([0-9]|\\Q*\\E)+(\\.\\.?([0-9]|\\Q*\\E)*)?",2,false, associationMultToken));// number or asterisk in an association
		rules.add(new RegexWordRule("[^a-zA-Z0-9](\\Q--\\E|\\Q->\\E|\\Q<-\\E)",3,false, associationMultToken));// number or asterisk in an association
		rules.add(new RegexWordRule("[^a-zA-Z0-9](if)[\\s\\(]",4,false, reservedWordToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](int)\\s",5,true, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](new|for|try|isA)[\\s\\(]",5,false, reservedWordToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](void|char)\\s",6,true, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](else|true|null)[\\s\\(;]",6,false, reservedWordToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](while|catch|false)[\\s\\(;]",7,false, reservedWordToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](float)\\s",7,true, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](public|return)\\s",8,false, structIdentifierToken));
		rules.add(new RegexRule("[^a-zA-Z0-9](return)[\\s;]",8,2, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](double)\\s",8,true, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](private)\\s",9,false, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](boolean)\\s",9,true, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](generate|glossary)\\s",10,false, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](protected)\\s",11,false, structIdentifierToken));
		rules.add(new RegexWordRule("[^a-zA-Z0-9](strictness)\\s",12,false, structIdentifierToken));
		rules.add(new SingleWordRule("immutable", modifierToken));
		rules.add(new SingleWordRule("settable", modifierToken));
		rules.add(new SingleWordRule("unique", modifierToken));
		rules.add(new SingleWordRule("const", modifierToken));
		rules.add(new SingleWordRule("lazy", modifierToken));
		rules.add(new SingleWordRule("defaulted", modifierToken));
		rules.add(new SingleWordRule("sorted", modifierToken));
		rules.add(new SingleWordRule("const", modifierToken));
		rules.add(new SingleWordRule("internal", modifierToken));
		rules.add(new SingleWordRule("namespace", structIdentifierToken));
		rules.add(new SingleWordRule("external", reservedWordTokenThin));
		rules.add(new SingleWordRule("use", reservedWordTokenThin));
		rules.add(new SingleWordRule("depend", reservedWordTokenThin));
		rules.add(new AttributeRule(attributeToken));
		rules.add(new TypeRule(typeToken));
		rules.add(new ScopeRule("\\{","\\}",1,defaultTokenBold));
		rules.add(new SingleWordRule(";", defaultToken));
		// Add generic whitespace rule.
		// rules[0] = new SingleLineRule("class", "class", tokenTwo);
		setRules((IRule[]) rules.toArray(new IRule[0]));
	}

	public class RegexRule implements IRule {
		private IToken token;
		private String regex;
		private int min;
		private int rewind;
		protected String input;
		public RegexRule(String regex, int minimum, IToken associationMultToken){
			this.token = associationMultToken;
			this.regex = regex;
			this.min = minimum;
			this.rewind = 1;
		}
		public RegexRule(String regex, int minimum,int rewind, IToken associationMultToken){
			this.token = associationMultToken;
			this.regex = regex;
			this.min = minimum;
			this.rewind = rewind;
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			input = "";
			if(min>1){
			  scanner.unread();	
			}			
			for(int i=0;i<min;i++){
				input += (char)scanner.read();
			}
			if(!input.matches(regex)){
				for(int i=0;i<min-(min>1?1:0);i++){
					scanner.unread();
				}
				return Token.UNDEFINED;
			}
			else {
				while(input.matches(regex)){
					input += (char)scanner.read();
				}
				for(int i=0;i<rewind;i++){
					scanner.unread();
				}
				return token;
			}
		}
		protected void rewind(ICharacterScanner scanner){
			int size = input.length()-2;
			for(int i=0;i<size;i++){
				scanner.unread();
			}
		}
	}
	public class EndOfLineRuleRule extends EndOfLineRule {
		public EndOfLineRuleRule(String startSequence, IToken token) {
			super(startSequence, token);
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			IToken token = super.evaluate(scanner);
			if(token.equals(Token.UNDEFINED)){
				return token;
			}
			nextNameIsAnAttributeName = false;
			return token;
		}
	}
	public class SingleLineRuleRule extends SingleLineRule {
		public SingleLineRuleRule(String startSequence, String endSequence,
				IToken token, char escapeCharacter) {
			super(startSequence, endSequence, token, escapeCharacter);
		}

		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			IToken token = super.evaluate(scanner);
			if(token.equals(Token.UNDEFINED)){
				return token;
			}
			nextNameIsAnAttributeName = false;
			return token;
		}
	}
	public class MultiLineRuleRule extends MultiLineRule {
		public MultiLineRuleRule(String startSequence, String endSequence,
				IToken token) {
			super(startSequence, endSequence, token);
		}

		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			IToken token = super.evaluate(scanner);
			if(token.equals(Token.UNDEFINED)){
				return token;
			}
			nextNameIsAnAttributeName = false;
			return token;
		}
	}

	public class SingleWordRule extends RegexRule {
		public SingleWordRule(String word, IToken token){
			super("[^a-zA-Z0-9]"+word+"\\s",word.length()+2,token);
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {

			IToken token = super.evaluate(scanner);
			if(!token.equals(Token.UNDEFINED)){
				nextNameIsAnAttributeName = false;
			}
			//nextNameIsNotAType = true;
			return token;
		}
	}
	public class RegexWordRule extends RegexRule {
		private boolean nextAttr;
		public RegexWordRule(String word,int min,boolean nextAttr, IToken token){
			super(word,min,token);
			this.nextAttr = nextAttr;
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {

			IToken token = super.evaluate(scanner);
			if(!token.equals(Token.UNDEFINED)){
				nextNameIsAnAttributeName = nextAttr;
			}
			//nextNameIsNotAType = true;
			return token;
		}
	}
	public class TypeRule extends RegexRule {
		private RegexWordRule arrows1;
		private RegexWordRule square;
		public TypeRule(IToken token){ 
			super("[^a-zA-Z0-9][A-Z][a-zA-Z0-9_-]*",2,1,token);
			arrows1 = new RegexWordRule("<[^>]*>?",1,true,token);
			square = new RegexWordRule("[\\s*]?",1,true,token);
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			if(!nextNameIsAnAttributeName){
				IToken token = super.evaluate(scanner);				
				if(token.equals(Token.UNDEFINED)){
					return token;
				}
				int current = input.charAt(input.length()-1);
				if(current=='<'){
					if(arrows1.evaluate(scanner)==Token.UNDEFINED){						
						return Token.UNDEFINED;
					}
					scanner.unread();
				}
				else if(current=='['){
					if(square.evaluate(scanner)==Token.UNDEFINED){
						return Token.UNDEFINED;
					}
				}
				else if(current!=' '&&current!='\t'&&current!='\n'&&current!=';'){
					rewind(scanner);
					return Token.UNDEFINED;
				}
				nextNameIsAnAttributeName = true;
				return token;
			}
			else {
				return Token.UNDEFINED;
			}
		}
	}
	public class AttributeRule extends RegexRule {
		public AttributeRule(IToken token){
			super("[^a-zA-Z0-9][a-zA-Z_][a-zA-Z0-9_-]*",2,1,token);
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			//if(!"".equals(currentClass)){
				IToken token = super.evaluate(scanner);
				if(!token.equals(Token.UNDEFINED)){
					String name = input.substring(1,input.length()-1);
					AttributeDefinition ad = currentScope.getAttribute(name);
					boolean contains =  ad!=null;
					//System.out.print(nextNameIsAnAttributeName);
					if(nextNameIsAnAttributeName||contains){
						if(nextNameIsAnAttributeName&&!contains){
							//System.out.println(nextNameIsAnAttributeName);
							currentScope.add(new AttributeDefinition(name,fOffset-currentScope.getBegin()-name.length(),fOffset-currentScope.getBegin()));
						}
						else if(!nextNameIsAnAttributeName&&contains){
							ad.add(new AttributeDefinition(name,fOffset-currentScope.getBegin()-name.length(),fOffset-currentScope.getBegin()));							
						}
						else {
							currentScope.addFloatingDefinition(new AttributeDefinition(name,fOffset-currentScope.getBegin()-name.length(),fOffset-currentScope.getBegin()));
						}
						nextNameIsAnAttributeName = false;
						return token;
					}
					nextNameIsAnAttributeName = false;
				}
				int current = input.charAt(input.length()-1);
				rewind(scanner);
				return Token.UNDEFINED;
			//}
			//else {
			//	return Token.UNDEFINED;
			//}
		}
	}
	public class ClassRule extends RegexRule {
		public ClassRule(String word, IToken token){
			super("[^a-zA-Z0-9]"+word+"\\s",word.length()+2,token);
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			IToken token = super.evaluate(scanner);
			if(!token.equals(Token.UNDEFINED)){
				nextNameIsAnAttributeName = false;
				nextTypeIsAClass = true;
			}
			return token;
		}
	}
	public class ScopeRule implements IRule {
		IRule open;
		IRule close;
		IToken token;
		public ScopeRule(String open,String close,int min, IToken token){
			this.open = new RegexWordRule(open,min,false,token);
			this.close = new RegexWordRule(close,min,false,token);
			this.token = token;
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {

			if(!open.evaluate(scanner).equals(Token.UNDEFINED)){
					currentScope = new Scope(currentScope);
					currentScope.begin(fOffset);
				return token;
			}
			else if(!close.evaluate(scanner).equals(Token.UNDEFINED)){
				currentScope.end(fOffset);
				if(currentScope.parent!=null){
					currentScope = currentScope.parent;
				}
				return token;
			}
			else
			{
				return Token.UNDEFINED;
			}
			//nextNameIsNotAType = true;
		}
	}
	public Integer getDifference(int length) {
		return length-fOffset;
	}
	public void reset() {
		nextNameIsAnAttributeName = false;
		
	}


}
