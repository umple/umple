package cruise.umple.ui.eclipse.editors;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
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
    rules.add(new SingleLineRule("clas", "s", structIdentifierToken));
    rules.add(new SingleLineRule("interfac", "e", structIdentifierToken));
    rules.add(new SingleLineRule("associatio", "n", structIdentifierToken));
    rules.add(new EndOfLineRule("//", commentToken));
    rules.add(new SingleLineRule("isA", " ", reservedWordToken));
    rules.add(new SingleLineRule("implements", " ", reservedWordToken));
    rules.add(new SingleLineRule("1", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("2", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("3", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("4", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("5", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("6", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("7", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("8", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("9", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("0", " ", associationMultToken));// number, in
    // an
    // association.
    rules.add(new SingleLineRule("*", " ", associationMultToken));// *, in an
    // association.
    rules.add(new SingleLineRule("String", " ", typeToken));// *, in an
    // association.
    rules.add(new SingleLineRule("Integer", " ", typeToken));// *, in an
    // association.
    rules.add(new SingleLineRule("Time", " ", typeToken));// *, in an
    // association.
    rules.add(new SingleLineRule("Date", " ", typeToken));// *, in an
    // association.
    rules.add(new SingleLineRule("immutable", " ", immutableToken));// *, in an
    // association.
    rules.add(new SingleLineRule("settable", " ", settableToken));// *, in an
    // association.
    rules.add(new SingleLineRule("namespac", "e", structIdentifierToken));
    rules.add(new SingleLineRule("us", "e", reservedWordTokenThin));
    rules.add(new SingleLineRule("uniqu", "e", uniqueToken));
    // Add generic whitespace rule.
    // rules[0] = new SingleLineRule("class", "class", tokenTwo);

    setRules((IRule[]) rules.toArray(new IRule[0]));
  }
}
