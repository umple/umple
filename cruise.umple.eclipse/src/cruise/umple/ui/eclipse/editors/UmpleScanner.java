package cruise.umple.ui.eclipse.editors;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;

public class UmpleScanner extends RuleBasedScanner {

  public UmpleScanner(ColorManager manager) {

    IToken immutableToken =
      new Token(new TextAttribute(manager
        .getColor(IUmpleColorConstants.IMMUTABLE), null, SWT.NONE));

    IToken settableToken =
      new Token(new TextAttribute(manager
        .getColor(IUmpleColorConstants.RESERVED_WORD), null, SWT.NONE));

    IToken structIdentifierToken =
      new Token(new TextAttribute(manager.getColor(IUmpleColorConstants.TOKEN),
        null, SWT.BOLD));

    IToken associationMultToken =
      new Token(new TextAttribute(manager
        .getColor(IUmpleColorConstants.ASSOC_MULT), null, SWT.BOLD));

    IToken typeToken =
      new Token(new TextAttribute(manager
        .getColor(IUmpleColorConstants.ASSOC_MULT), null, SWT.NONE));

    IToken reservedWordToken =
      new Token(new TextAttribute(manager
        .getColor(IUmpleColorConstants.RESERVED_WORD), null, SWT.BOLD));

    IToken reservedWordTokenThin =
      new Token(new TextAttribute(manager
        .getColor(IUmpleColorConstants.RESERVED_WORD), null, SWT.NONE));

    IToken commentToken =
      new Token(new TextAttribute(manager
        .getColor(IUmpleColorConstants.COMMENT), null, SWT.NONE));
    
    IToken uniqueToken =
      new Token(new TextAttribute(manager
        .getColor(IUmpleColorConstants.ASSOC_MULT), null, SWT.ITALIC));
    // IToken tokenTwo = new Token(new
    // TextAttribute(manager.getColor(IXMLColorConstants.TAG)));

    List<IRule> rules = new LinkedList<IRule>();

    // IRule[] rules = new IRule[21];
    // Add rule for processing instructions
    rules.add(new SingleWordRule("class", structIdentifierToken));
    rules.add(new SingleWordRule("interface", structIdentifierToken));
    rules.add(new SingleWordRule("association", structIdentifierToken));
    rules.add(new EndOfLineRule("//", commentToken));
    rules.add(new SingleWordRule("isA", reservedWordToken));
    rules.add(new SingleWordRule("implements", reservedWordToken));
    rules.add(new RegexRule("([0-9]|\\Q*\\E)+", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleWordRule("String", typeToken));// *, in an
    // association.
    rules.add(new SingleWordRule("Integer", typeToken));// *, in an
    // association.
    rules.add(new SingleWordRule("Time", typeToken));// *, in an
    // association.
    rules.add(new SingleWordRule("Date", typeToken));// *, in an
    // association.
    rules.add(new SingleWordRule("immutable", immutableToken));// *, in an
    // association.
    rules.add(new SingleWordRule("settable", settableToken));// *, in an
    // association.
    rules.add(new SingleWordRule("namespace", structIdentifierToken));
    rules.add(new SingleWordRule("use", reservedWordTokenThin));
    rules.add(new SingleWordRule("unique", uniqueToken));
    // Add generic whitespace rule.
    // rules[0] = new SingleLineRule("class", "class", tokenTwo);

    setRules((IRule[]) rules.toArray(new IRule[0]));
  }
  
  public class RegexRule implements IRule {
	private IToken token;
	private String regex;
	public RegexRule(String regex, IToken associationMultToken){
		this.token = associationMultToken;
		this.regex = regex;
	}
	@Override
	public IToken evaluate(ICharacterScanner scanner) {
		String input = ""+(char)scanner.read();
		if(!input.matches(regex)){
			scanner.unread();
			return Token.UNDEFINED;
		}
		else {
			while(input.matches(regex)){
				input += (char)scanner.read();
			}
			scanner.unread();
			return token;
		}
	}	  
  }
  
  public class SingleWordRule implements IRule {
		private IToken token;
		private String word;
		public SingleWordRule(String word, IToken associationMultToken){
			this.token = associationMultToken;
			this.word = word+" ";
		}
		@Override
		public IToken evaluate(ICharacterScanner scanner) {
			String input = "";
			for(int i=0;i<word.length();i++){
				input += (char)scanner.read();
			}			
			if(!input.equals(word)){
				for(int i=0;i<word.length();i++){
					scanner.unread();
				}
				return Token.UNDEFINED;
			}
			else {				
				scanner.unread();
				return token;
			}
		}	  
	  }
}
