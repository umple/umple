package cruise.umple.serializer;

import com.google.inject.Inject;
import cruise.umple.services.UmpleGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractUmpleSyntacticSequencer extends AbstractSyntacticSequencer {

	protected UmpleGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Association_GreaterThanSignLessThanSignKeyword_3_3_or_HyphenMinusGreaterThanSignKeyword_3_0_or_HyphenMinusHyphenMinusKeyword_3_1_or_LessThanSignHyphenMinusKeyword_3_2;
	protected AbstractElementAlias match_Depend_FullStopAsteriskKeyword_2_q;
	protected AbstractElementAlias match_InlineAssociation_GreaterThanSignLessThanSignKeyword_2_3_or_HyphenMinusGreaterThanSignKeyword_2_0_or_HyphenMinusHyphenMinusKeyword_2_1_or_LessThanSignHyphenMinusKeyword_2_2;
	protected AbstractElementAlias match_additiveExpression_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0;
	protected AbstractElementAlias match_equalityExpression_EqualsSignEqualsSignKeyword_1_0_0_or_ExclamationMarkEqualsSignKeyword_1_0_1;
	protected AbstractElementAlias match_javaFunctionCall_LeftParenthesisRightParenthesisKeyword_1_1_or___LeftParenthesisKeyword_1_0_0_RightParenthesisKeyword_1_0_2__;
	protected AbstractElementAlias match_javaFunctionDeclaration_LeftParenthesisRightParenthesisKeyword_4_1_or___LeftParenthesisKeyword_4_0_0_RightParenthesisKeyword_4_0_2__;
	protected AbstractElementAlias match_javaFunctionDeclaration_PrivateKeyword_1_1_or_ProtectedKeyword_1_2_or_PublicKeyword_1_0;
	protected AbstractElementAlias match_javaFunctionDeclaration_StaticKeyword_0_q;
	protected AbstractElementAlias match_literal_DOUBLEParserRuleCall_1_or_ExtendedIDParserRuleCall_3_or_FALSEKeyword_8_or_FalseKeyword_7_or_INTTerminalRuleCall_0_or_STRINGTerminalRuleCall_2_or_TRUEKeyword_6_or_TrueKeyword_5;
	protected AbstractElementAlias match_multiplicativeExpression_AsteriskKeyword_1_0_0_or_PercentSignKeyword_1_0_2_or_SolidusKeyword_1_0_1;
	protected AbstractElementAlias match_statement_SemicolonKeyword_5_or___BreakKeyword_6_0_SemicolonKeyword_6_1___or___ReturnKeyword_4_0_SemicolonKeyword_4_2__;
	protected AbstractElementAlias match_unaryExpressionNotPlusMinus_ExclamationMarkKeyword_1_0_or_TildeKeyword_0_0;
	protected AbstractElementAlias match_unaryExpressionNotPlusMinus___HyphenMinusHyphenMinusKeyword_2_1_1_or_PlusSignPlusSignKeyword_2_1_0__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (UmpleGrammarAccess) access;
		match_Association_GreaterThanSignLessThanSignKeyword_3_3_or_HyphenMinusGreaterThanSignKeyword_3_0_or_HyphenMinusHyphenMinusKeyword_3_1_or_LessThanSignHyphenMinusKeyword_3_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAssociationAccess().getGreaterThanSignLessThanSignKeyword_3_3()), new TokenAlias(false, false, grammarAccess.getAssociationAccess().getHyphenMinusGreaterThanSignKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getAssociationAccess().getHyphenMinusHyphenMinusKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getAssociationAccess().getLessThanSignHyphenMinusKeyword_3_2()));
		match_Depend_FullStopAsteriskKeyword_2_q = new TokenAlias(true, false, grammarAccess.getDependAccess().getFullStopAsteriskKeyword_2());
		match_InlineAssociation_GreaterThanSignLessThanSignKeyword_2_3_or_HyphenMinusGreaterThanSignKeyword_2_0_or_HyphenMinusHyphenMinusKeyword_2_1_or_LessThanSignHyphenMinusKeyword_2_2 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getInlineAssociationAccess().getGreaterThanSignLessThanSignKeyword_2_3()), new TokenAlias(false, false, grammarAccess.getInlineAssociationAccess().getHyphenMinusGreaterThanSignKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getInlineAssociationAccess().getHyphenMinusHyphenMinusKeyword_2_1()), new TokenAlias(false, false, grammarAccess.getInlineAssociationAccess().getLessThanSignHyphenMinusKeyword_2_2()));
		match_additiveExpression_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getAdditiveExpressionAccess().getHyphenMinusKeyword_1_0_1()), new TokenAlias(false, false, grammarAccess.getAdditiveExpressionAccess().getPlusSignKeyword_1_0_0()));
		match_equalityExpression_EqualsSignEqualsSignKeyword_1_0_0_or_ExclamationMarkEqualsSignKeyword_1_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getEqualityExpressionAccess().getEqualsSignEqualsSignKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getEqualityExpressionAccess().getExclamationMarkEqualsSignKeyword_1_0_1()));
		match_javaFunctionCall_LeftParenthesisRightParenthesisKeyword_1_1_or___LeftParenthesisKeyword_1_0_0_RightParenthesisKeyword_1_0_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getJavaFunctionCallAccess().getLeftParenthesisKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getJavaFunctionCallAccess().getRightParenthesisKeyword_1_0_2())), new TokenAlias(false, false, grammarAccess.getJavaFunctionCallAccess().getLeftParenthesisRightParenthesisKeyword_1_1()));
		match_javaFunctionDeclaration_LeftParenthesisRightParenthesisKeyword_4_1_or___LeftParenthesisKeyword_4_0_0_RightParenthesisKeyword_4_0_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getJavaFunctionDeclarationAccess().getLeftParenthesisKeyword_4_0_0()), new TokenAlias(false, false, grammarAccess.getJavaFunctionDeclarationAccess().getRightParenthesisKeyword_4_0_2())), new TokenAlias(false, false, grammarAccess.getJavaFunctionDeclarationAccess().getLeftParenthesisRightParenthesisKeyword_4_1()));
		match_javaFunctionDeclaration_PrivateKeyword_1_1_or_ProtectedKeyword_1_2_or_PublicKeyword_1_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getJavaFunctionDeclarationAccess().getPrivateKeyword_1_1()), new TokenAlias(false, false, grammarAccess.getJavaFunctionDeclarationAccess().getProtectedKeyword_1_2()), new TokenAlias(false, false, grammarAccess.getJavaFunctionDeclarationAccess().getPublicKeyword_1_0()));
		match_javaFunctionDeclaration_StaticKeyword_0_q = new TokenAlias(true, false, grammarAccess.getJavaFunctionDeclarationAccess().getStaticKeyword_0());
		match_literal_DOUBLEParserRuleCall_1_or_ExtendedIDParserRuleCall_3_or_FALSEKeyword_8_or_FalseKeyword_7_or_INTTerminalRuleCall_0_or_STRINGTerminalRuleCall_2_or_TRUEKeyword_6_or_TrueKeyword_5 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getLiteralAccess().getDOUBLEParserRuleCall_1()), new TokenAlias(false, false, grammarAccess.getLiteralAccess().getExtendedIDParserRuleCall_3()), new TokenAlias(false, false, grammarAccess.getLiteralAccess().getFALSEKeyword_8()), new TokenAlias(false, false, grammarAccess.getLiteralAccess().getFalseKeyword_7()), new TokenAlias(false, false, grammarAccess.getLiteralAccess().getINTTerminalRuleCall_0()), new TokenAlias(false, false, grammarAccess.getLiteralAccess().getSTRINGTerminalRuleCall_2()), new TokenAlias(false, false, grammarAccess.getLiteralAccess().getTRUEKeyword_6()), new TokenAlias(false, false, grammarAccess.getLiteralAccess().getTrueKeyword_5()));
		match_multiplicativeExpression_AsteriskKeyword_1_0_0_or_PercentSignKeyword_1_0_2_or_SolidusKeyword_1_0_1 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getMultiplicativeExpressionAccess().getAsteriskKeyword_1_0_0()), new TokenAlias(false, false, grammarAccess.getMultiplicativeExpressionAccess().getPercentSignKeyword_1_0_2()), new TokenAlias(false, false, grammarAccess.getMultiplicativeExpressionAccess().getSolidusKeyword_1_0_1()));
		match_statement_SemicolonKeyword_5_or___BreakKeyword_6_0_SemicolonKeyword_6_1___or___ReturnKeyword_4_0_SemicolonKeyword_4_2__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getStatementAccess().getBreakKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getStatementAccess().getSemicolonKeyword_6_1())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getStatementAccess().getReturnKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getStatementAccess().getSemicolonKeyword_4_2())), new TokenAlias(false, false, grammarAccess.getStatementAccess().getSemicolonKeyword_5()));
		match_unaryExpressionNotPlusMinus_ExclamationMarkKeyword_1_0_or_TildeKeyword_0_0 = new AlternativeAlias(false, false, new TokenAlias(false, false, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getExclamationMarkKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getTildeKeyword_0_0()));
		match_unaryExpressionNotPlusMinus___HyphenMinusHyphenMinusKeyword_2_1_1_or_PlusSignPlusSignKeyword_2_1_0__q = new AlternativeAlias(true, false, new TokenAlias(false, false, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getHyphenMinusHyphenMinusKeyword_2_1_1()), new TokenAlias(false, false, grammarAccess.getUnaryExpressionNotPlusMinusAccess().getPlusSignPlusSignKeyword_2_1_0()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getDOUBLERule())
			return getDOUBLEToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getINTRule())
			return getINTToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getSTRINGRule())
			return getSTRINGToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getAssignmentOperatorRule())
			return getassignmentOperatorToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getExtendedIDRule())
			return getextendedIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getMultiplicityRule())
			return getmultiplicityToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getRelationalOpRule())
			return getrelationalOpToken(semanticObject, ruleCall, node);
		return "";
	}
	
	protected String getDOUBLEToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return ".";
	}
	protected String getINTToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	protected String getSTRINGToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\"\"";
	}
	protected String getassignmentOperatorToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "=";
	}
	protected String getextendedIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	protected String getmultiplicityToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	protected String getrelationalOpToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "<=";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Association_GreaterThanSignLessThanSignKeyword_3_3_or_HyphenMinusGreaterThanSignKeyword_3_0_or_HyphenMinusHyphenMinusKeyword_3_1_or_LessThanSignHyphenMinusKeyword_3_2.equals(syntax))
				emit_Association_GreaterThanSignLessThanSignKeyword_3_3_or_HyphenMinusGreaterThanSignKeyword_3_0_or_HyphenMinusHyphenMinusKeyword_3_1_or_LessThanSignHyphenMinusKeyword_3_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Depend_FullStopAsteriskKeyword_2_q.equals(syntax))
				emit_Depend_FullStopAsteriskKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_InlineAssociation_GreaterThanSignLessThanSignKeyword_2_3_or_HyphenMinusGreaterThanSignKeyword_2_0_or_HyphenMinusHyphenMinusKeyword_2_1_or_LessThanSignHyphenMinusKeyword_2_2.equals(syntax))
				emit_InlineAssociation_GreaterThanSignLessThanSignKeyword_2_3_or_HyphenMinusGreaterThanSignKeyword_2_0_or_HyphenMinusHyphenMinusKeyword_2_1_or_LessThanSignHyphenMinusKeyword_2_2(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_additiveExpression_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0.equals(syntax))
				emit_additiveExpression_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_equalityExpression_EqualsSignEqualsSignKeyword_1_0_0_or_ExclamationMarkEqualsSignKeyword_1_0_1.equals(syntax))
				emit_equalityExpression_EqualsSignEqualsSignKeyword_1_0_0_or_ExclamationMarkEqualsSignKeyword_1_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_javaFunctionCall_LeftParenthesisRightParenthesisKeyword_1_1_or___LeftParenthesisKeyword_1_0_0_RightParenthesisKeyword_1_0_2__.equals(syntax))
				emit_javaFunctionCall_LeftParenthesisRightParenthesisKeyword_1_1_or___LeftParenthesisKeyword_1_0_0_RightParenthesisKeyword_1_0_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_javaFunctionDeclaration_LeftParenthesisRightParenthesisKeyword_4_1_or___LeftParenthesisKeyword_4_0_0_RightParenthesisKeyword_4_0_2__.equals(syntax))
				emit_javaFunctionDeclaration_LeftParenthesisRightParenthesisKeyword_4_1_or___LeftParenthesisKeyword_4_0_0_RightParenthesisKeyword_4_0_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_javaFunctionDeclaration_PrivateKeyword_1_1_or_ProtectedKeyword_1_2_or_PublicKeyword_1_0.equals(syntax))
				emit_javaFunctionDeclaration_PrivateKeyword_1_1_or_ProtectedKeyword_1_2_or_PublicKeyword_1_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_javaFunctionDeclaration_StaticKeyword_0_q.equals(syntax))
				emit_javaFunctionDeclaration_StaticKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_literal_DOUBLEParserRuleCall_1_or_ExtendedIDParserRuleCall_3_or_FALSEKeyword_8_or_FalseKeyword_7_or_INTTerminalRuleCall_0_or_STRINGTerminalRuleCall_2_or_TRUEKeyword_6_or_TrueKeyword_5.equals(syntax))
				emit_literal_DOUBLEParserRuleCall_1_or_ExtendedIDParserRuleCall_3_or_FALSEKeyword_8_or_FalseKeyword_7_or_INTTerminalRuleCall_0_or_STRINGTerminalRuleCall_2_or_TRUEKeyword_6_or_TrueKeyword_5(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_multiplicativeExpression_AsteriskKeyword_1_0_0_or_PercentSignKeyword_1_0_2_or_SolidusKeyword_1_0_1.equals(syntax))
				emit_multiplicativeExpression_AsteriskKeyword_1_0_0_or_PercentSignKeyword_1_0_2_or_SolidusKeyword_1_0_1(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_statement_SemicolonKeyword_5_or___BreakKeyword_6_0_SemicolonKeyword_6_1___or___ReturnKeyword_4_0_SemicolonKeyword_4_2__.equals(syntax))
				emit_statement_SemicolonKeyword_5_or___BreakKeyword_6_0_SemicolonKeyword_6_1___or___ReturnKeyword_4_0_SemicolonKeyword_4_2__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_unaryExpressionNotPlusMinus_ExclamationMarkKeyword_1_0_or_TildeKeyword_0_0.equals(syntax))
				emit_unaryExpressionNotPlusMinus_ExclamationMarkKeyword_1_0_or_TildeKeyword_0_0(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_unaryExpressionNotPlusMinus___HyphenMinusHyphenMinusKeyword_2_1_1_or_PlusSignPlusSignKeyword_2_1_0__q.equals(syntax))
				emit_unaryExpressionNotPlusMinus___HyphenMinusHyphenMinusKeyword_2_1_1_or_PlusSignPlusSignKeyword_2_1_0__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '->' | '<-' | '--' | '><'
	 */
	protected void emit_Association_GreaterThanSignLessThanSignKeyword_3_3_or_HyphenMinusGreaterThanSignKeyword_3_0_or_HyphenMinusHyphenMinusKeyword_3_1_or_LessThanSignHyphenMinusKeyword_3_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '.*'?
	 */
	protected void emit_Depend_FullStopAsteriskKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '--' | '><' | '->' | '<-'
	 */
	protected void emit_InlineAssociation_GreaterThanSignLessThanSignKeyword_2_3_or_HyphenMinusGreaterThanSignKeyword_2_0_or_HyphenMinusHyphenMinusKeyword_2_1_or_LessThanSignHyphenMinusKeyword_2_2(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '+' | '-'
	 */
	protected void emit_additiveExpression_HyphenMinusKeyword_1_0_1_or_PlusSignKeyword_1_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '!=' | '=='
	 */
	protected void emit_equalityExpression_EqualsSignEqualsSignKeyword_1_0_0_or_ExclamationMarkEqualsSignKeyword_1_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '()' | ('(' ')')
	 */
	protected void emit_javaFunctionCall_LeftParenthesisRightParenthesisKeyword_1_1_or___LeftParenthesisKeyword_1_0_0_RightParenthesisKeyword_1_0_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')') | '()'
	 */
	protected void emit_javaFunctionDeclaration_LeftParenthesisRightParenthesisKeyword_4_1_or___LeftParenthesisKeyword_4_0_0_RightParenthesisKeyword_4_0_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'private' | 'public' | 'protected'
	 */
	protected void emit_javaFunctionDeclaration_PrivateKeyword_1_1_or_ProtectedKeyword_1_2_or_PublicKeyword_1_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'static'?
	 */
	protected void emit_javaFunctionDeclaration_StaticKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     (
	     INT | 
	     'false' | 
	     'true' | 
	     extendedID | 
	     DOUBLE | 
	     'TRUE' | 
	     STRING | 
	     'FALSE'
	 )
	 */
	protected void emit_literal_DOUBLEParserRuleCall_1_or_ExtendedIDParserRuleCall_3_or_FALSEKeyword_8_or_FalseKeyword_7_or_INTTerminalRuleCall_0_or_STRINGTerminalRuleCall_2_or_TRUEKeyword_6_or_TrueKeyword_5(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '*' | '%' | '/'
	 */
	protected void emit_multiplicativeExpression_AsteriskKeyword_1_0_0_or_PercentSignKeyword_1_0_2_or_SolidusKeyword_1_0_1(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('break' ';') | ('return' ';') | ';'
	 */
	protected void emit_statement_SemicolonKeyword_5_or___BreakKeyword_6_0_SemicolonKeyword_6_1___or___ReturnKeyword_4_0_SemicolonKeyword_4_2__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '!' | '~'
	 */
	protected void emit_unaryExpressionNotPlusMinus_ExclamationMarkKeyword_1_0_or_TildeKeyword_0_0(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('++' | '--')?
	 */
	protected void emit_unaryExpressionNotPlusMinus___HyphenMinusHyphenMinusKeyword_2_1_1_or_PlusSignPlusSignKeyword_2_1_0__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
