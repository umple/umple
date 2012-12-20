package cruise.umple.ui.eclipse.editors;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class UmplePartitionScanner extends RuleBasedPartitionScanner {
	public final static String Umple_COMMENT = "__Umple_comment";
	public final static String Umple_TAG = "__Umple_tag";

	public UmplePartitionScanner() {

		IToken UmpleComment = new Token(Umple_COMMENT);
		IToken tag = new Token(Umple_TAG);

		IPredicateRule[] rules = new IPredicateRule[2];

		rules[0] = new MultiLineRule("<!--", "-->", UmpleComment);
		rules[1] = new TagRule(tag);

		setPredicateRules(rules);
	}
}
