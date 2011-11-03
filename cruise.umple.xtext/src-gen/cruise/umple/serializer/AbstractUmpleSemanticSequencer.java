package cruise.umple.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import cruise.umple.services.UmpleGrammarAccess;
import cruise.umple.umple.Association;
import cruise.umple.umple.AssociationClassDefinition;
import cruise.umple.umple.AssociationDefinition;
import cruise.umple.umple.AssociationPosition;
import cruise.umple.umple.Attribute;
import cruise.umple.umple.ClassDefinition;
import cruise.umple.umple.CodeInjection;
import cruise.umple.umple.Coordinate;
import cruise.umple.umple.Depend;
import cruise.umple.umple.ElementPosition;
import cruise.umple.umple.ExternalDefinition;
import cruise.umple.umple.Generate;
import cruise.umple.umple.Glossary;
import cruise.umple.umple.InlineAssociation;
import cruise.umple.umple.InterfaceDefinition;
import cruise.umple.umple.Key;
import cruise.umple.umple.Namespace;
import cruise.umple.umple.SingleAssociationEnd;
import cruise.umple.umple.Singleton;
import cruise.umple.umple.SymmetricReflexiveAssociation;
import cruise.umple.umple.UmpleModel;
import cruise.umple.umple.UmplePackage;
import cruise.umple.umple.UseStatement;
import cruise.umple.umple.Word;
import cruise.umple.umple.additiveExpression;
import cruise.umple.umple.block;
import cruise.umple.umple.conditionalAndExpression;
import cruise.umple.umple.conditionalExpression;
import cruise.umple.umple.conditionalOrExpression;
import cruise.umple.umple.equalityExpression;
import cruise.umple.umple.expression;
import cruise.umple.umple.expressionList;
import cruise.umple.umple.forControl;
import cruise.umple.umple.forInit;
import cruise.umple.umple.functionDeclaration;
import cruise.umple.umple.functionDefinition;
import cruise.umple.umple.isA;
import cruise.umple.umple.javaFunctionCall;
import cruise.umple.umple.javaFunctionDeclaration;
import cruise.umple.umple.javaFunctionDefinition;
import cruise.umple.umple.localVariableDeclaration;
import cruise.umple.umple.multiplicativeExpression;
import cruise.umple.umple.phpBlock;
import cruise.umple.umple.phpFunction;
import cruise.umple.umple.relationalExpression;
import cruise.umple.umple.statement;
import cruise.umple.umple.unaryExpression;
import cruise.umple.umple.variableDeclarator;
import cruise.umple.umple.variableDeclarators;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("restriction")
public class AbstractUmpleSemanticSequencer extends AbstractSemanticSequencer {

	@Inject
	protected UmpleGrammarAccess grammarAccess;
	
	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	@GenericSequencer
	protected Provider<ISemanticSequencer> genericSequencerProvider;
	
	protected ISemanticSequencer genericSequencer;
	
	
	@Override
	public void init(ISemanticSequencer sequencer, ISemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		super.init(sequencer, sequenceAcceptor, errorAcceptor);
		this.genericSequencer = genericSequencerProvider.get();
		this.genericSequencer.init(sequencer, sequenceAcceptor, errorAcceptor);
	}
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == UmplePackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UmplePackage.ASSOCIATION:
				if(context == grammarAccess.getAssociationRule()) {
					sequence_Association(context, (Association) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.ASSOCIATION_CLASS_DEFINITION:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getAssociationClassDefinitionRule() ||
				   context == grammarAccess.getEntityRule()) {
					sequence_AssociationClassDefinition(context, (AssociationClassDefinition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.ASSOCIATION_DEFINITION:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getAssociationDefinitionRule() ||
				   context == grammarAccess.getEntityRule()) {
					sequence_AssociationDefinition(context, (AssociationDefinition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.ASSOCIATION_POSITION:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getAssociationPositionRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getPositionRule()) {
					sequence_AssociationPosition(context, (AssociationPosition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.ATTRIBUTE:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getAttributeRule() ||
				   context == grammarAccess.getClassContentRule()) {
					sequence_Attribute(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.CLASS_DEFINITION:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getClassDefinitionRule() ||
				   context == grammarAccess.getEntityRule() ||
				   context == grammarAccess.getUmpleElementRule()) {
					sequence_ClassDefinition(context, (ClassDefinition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.CODE_INJECTION:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getCodeInjectionRule() ||
				   context == grammarAccess.getSoftwarePatternRule()) {
					sequence_CodeInjection(context, (CodeInjection) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.COORDINATE:
				if(context == grammarAccess.getCoordinateRule()) {
					sequence_Coordinate(context, (Coordinate) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.DEPEND:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getDependRule()) {
					sequence_Depend(context, (Depend) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.ELEMENT_POSITION:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getElementPositionRule() ||
				   context == grammarAccess.getPositionRule()) {
					sequence_ElementPosition(context, (ElementPosition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.EXTERNAL_DEFINITION:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getEntityRule() ||
				   context == grammarAccess.getExternalDefinitionRule()) {
					sequence_ExternalDefinition(context, (ExternalDefinition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.GENERATE:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getGenerateRule()) {
					sequence_Generate(context, (Generate) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.GLOSSARY:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getGlossaryRule()) {
					sequence_Glossary(context, (Glossary) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.INLINE_ASSOCIATION:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getInlineAssociationRule()) {
					sequence_InlineAssociation(context, (InlineAssociation) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.INTERFACE_DEFINITION:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getEntityRule() ||
				   context == grammarAccess.getInterfaceDefinitionRule() ||
				   context == grammarAccess.getUmpleElementRule()) {
					sequence_InterfaceDefinition(context, (InterfaceDefinition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.KEY:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getKeyDefinitionRule() ||
				   context == grammarAccess.getSoftwarePatternRule()) {
					sequence_KeyDefinition(context, (Key) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.NAMESPACE:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getNamespaceRule()) {
					sequence_Namespace(context, (Namespace) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.SINGLE_ASSOCIATION_END:
				if(context == grammarAccess.getSingleAssociationEndRule()) {
					sequence_SingleAssociationEnd(context, (SingleAssociationEnd) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.SINGLETON:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getSingletonRule() ||
				   context == grammarAccess.getSoftwarePatternRule()) {
					sequence_Singleton(context, (Singleton) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.SYMMETRIC_REFLEXIVE_ASSOCIATION:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getSymmetricReflexiveAssociationRule()) {
					sequence_SymmetricReflexiveAssociation(context, (SymmetricReflexiveAssociation) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.UMPLE_MODEL:
				if(context == grammarAccess.getUmpleModelRule()) {
					sequence_UmpleModel(context, (UmpleModel) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.USE_STATEMENT:
				if(context == grammarAccess.getAbstractElementRule() ||
				   context == grammarAccess.getUseStatementRule()) {
					sequence_UseStatement(context, (UseStatement) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.WORD:
				if(context == grammarAccess.getWordRule()) {
					sequence_Word(context, (Word) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.ADDITIVE_EXPRESSION:
				if(context == grammarAccess.getAdditiveExpressionRule()) {
					sequence_additiveExpression(context, (additiveExpression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.BLOCK:
				if(context == grammarAccess.getBlockRule() ||
				   context == grammarAccess.getBlockStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_block(context, (block) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.CONDITIONAL_AND_EXPRESSION:
				if(context == grammarAccess.getConditionalAndExpressionRule()) {
					sequence_conditionalAndExpression(context, (conditionalAndExpression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.CONDITIONAL_EXPRESSION:
				if(context == grammarAccess.getConditionalExpressionRule()) {
					sequence_conditionalExpression(context, (conditionalExpression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.CONDITIONAL_OR_EXPRESSION:
				if(context == grammarAccess.getConditionalOrExpressionRule()) {
					sequence_conditionalOrExpression(context, (conditionalOrExpression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.EQUALITY_EXPRESSION:
				if(context == grammarAccess.getEqualityExpressionRule()) {
					sequence_equalityExpression(context, (equalityExpression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.EXPRESSION:
				if(context == grammarAccess.getBlockStatementRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getParExpressionRule() ||
				   context == grammarAccess.getPrimaryRule() ||
				   context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_expression(context, (expression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.EXPRESSION_LIST:
				if(context == grammarAccess.getExpressionListRule() ||
				   context == grammarAccess.getForUpdateRule()) {
					sequence_expressionList(context, (expressionList) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.FOR_CONTROL:
				if(context == grammarAccess.getForControlRule()) {
					sequence_forControl(context, (forControl) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.FOR_INIT:
				if(context == grammarAccess.getForInitRule()) {
					sequence_forInit(context, (forInit) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.FUNCTION_DECLARATION:
				if(context == grammarAccess.getFunctionDeclarationRule()) {
					sequence_functionDeclaration(context, (functionDeclaration) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.FUNCTION_DEFINITION:
				if(context == grammarAccess.getFunctionDefinitionRule()) {
					sequence_functionDefinition(context, (functionDefinition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.IS_A:
				if(context == grammarAccess.getAssociationClassContentRule() ||
				   context == grammarAccess.getClassContentRule() ||
				   context == grammarAccess.getSoftwarePatternRule() ||
				   context == grammarAccess.getIsARule()) {
					sequence_isA(context, (isA) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.JAVA_FUNCTION_CALL:
				if(context == grammarAccess.getFunctionCallRule() ||
				   context == grammarAccess.getJavaFunctionCallRule() ||
				   context == grammarAccess.getLiteralRule() ||
				   context == grammarAccess.getPrimaryRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_javaFunctionCall(context, (javaFunctionCall) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.JAVA_FUNCTION_DECLARATION:
				if(context == grammarAccess.getJavaFunctionDeclarationRule()) {
					sequence_javaFunctionDeclaration(context, (javaFunctionDeclaration) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.JAVA_FUNCTION_DEFINITION:
				if(context == grammarAccess.getJavaFunctionDefinitionRule()) {
					sequence_javaFunctionDefinition(context, (javaFunctionDefinition) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.LOCAL_VARIABLE_DECLARATION:
				if(context == grammarAccess.getBlockStatementRule() ||
				   context == grammarAccess.getForInitRule() ||
				   context == grammarAccess.getLocalVariableDeclarationRule() ||
				   context == grammarAccess.getLocalVariableDeclarationStatementRule()) {
					sequence_localVariableDeclaration(context, (localVariableDeclaration) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.MULTIPLICATIVE_EXPRESSION:
				if(context == grammarAccess.getMultiplicativeExpressionRule()) {
					sequence_multiplicativeExpression(context, (multiplicativeExpression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.PHP_BLOCK:
				if(context == grammarAccess.getPhpBlockRule()) {
					sequence_phpBlock(context, (phpBlock) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.PHP_FUNCTION:
				if(context == grammarAccess.getPhpFunctionRule()) {
					sequence_phpFunction(context, (phpFunction) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.RELATIONAL_EXPRESSION:
				if(context == grammarAccess.getRelationalExpressionRule()) {
					sequence_relationalExpression(context, (relationalExpression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.STATEMENT:
				if(context == grammarAccess.getBlockStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_statement(context, (statement) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.UNARY_EXPRESSION:
				if(context == grammarAccess.getUnaryExpressionRule() ||
				   context == grammarAccess.getUnaryExpressionNotPlusMinusRule()) {
					sequence_unaryExpression(context, (unaryExpression) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.VARIABLE_DECLARATOR:
				if(context == grammarAccess.getVariableDeclaratorRule()) {
					sequence_variableDeclarator(context, (variableDeclarator) semanticObject); 
					return; 
				}
				else break;
			case UmplePackage.VARIABLE_DECLARATORS:
				if(context == grammarAccess.getVariableDeclaratorsRule()) {
					sequence_variableDeclarators(context, (variableDeclarators) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID associationClassContent+=AssociationClassContent*)
	 *
	 * Features:
	 *    name[1, 1]
	 *    associationClassContent[0, *]
	 */
	protected void sequence_AssociationClassDefinition(EObject context, AssociationClassDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID association+=Association*)
	 *
	 * Features:
	 *    name[1, 1]
	 *    association[0, *]
	 */
	protected void sequence_AssociationDefinition(EObject context, AssociationDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID c1=Coordinate c2=Coordinate)
	 *
	 * Features:
	 *    name[1, 1]
	 *    c1[1, 1]
	 *    c2[1, 1]
	 */
	protected void sequence_AssociationPosition(EObject context, AssociationPosition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.ASSOCIATION_POSITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.ASSOCIATION_POSITION__NAME));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.ASSOCIATION_POSITION__C1) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.ASSOCIATION_POSITION__C1));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.ASSOCIATION_POSITION__C2) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.ASSOCIATION_POSITION__C2));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAssociationPositionAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAssociationPositionAccess().getC1CoordinateParserRuleCall_2_0(), semanticObject.getC1());
		feeder.accept(grammarAccess.getAssociationPositionAccess().getC2CoordinateParserRuleCall_3_0(), semanticObject.getC2());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type1=ID rolename1=ID? type2=ID rolename2=ID?)
	 *
	 * Features:
	 *    type1[1, 1]
	 *    rolename1[0, 1]
	 *    type2[1, 1]
	 *    rolename2[0, 1]
	 */
	protected void sequence_Association(EObject context, Association semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (autounique?='autounique' name=extendedID) | 
	 *         (
	 *             unique?='unique'? 
	 *             modifier=Modifier? 
	 *             ((type=UmpleAttributeType list?='[]'?) | (object=[ClassDefinition|ID] list?='[]'?))? 
	 *             name=extendedID 
	 *             value=UmplePrimitiveType?
	 *         )
	 *     )
	 *
	 * Features:
	 *    autounique[0, 1]
	 *         EXCLUDE_IF_UNSET name
	 *         MANDATORY_IF_SET name
	 *         EXCLUDE_IF_SET unique
	 *         EXCLUDE_IF_SET modifier
	 *         EXCLUDE_IF_SET type
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET object
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_SET name
	 *         EXCLUDE_IF_SET value
	 *    name[0, 2]
	 *    unique[0, 1]
	 *         EXCLUDE_IF_UNSET name
	 *         EXCLUDE_IF_SET autounique
	 *         EXCLUDE_IF_SET name
	 *    modifier[0, 1]
	 *         EXCLUDE_IF_UNSET name
	 *         EXCLUDE_IF_SET autounique
	 *         EXCLUDE_IF_SET name
	 *    type[0, 1]
	 *         MANDATORY_IF_SET list
	 *         EXCLUDE_IF_SET object
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_UNSET name
	 *         EXCLUDE_IF_SET autounique
	 *         EXCLUDE_IF_SET name
	 *    list[0, 2]
	 *         EXCLUDE_IF_UNSET name
	 *         EXCLUDE_IF_SET autounique
	 *         EXCLUDE_IF_SET name
	 *    object[0, 1]
	 *         MANDATORY_IF_SET list
	 *         EXCLUDE_IF_SET type
	 *         EXCLUDE_IF_SET list
	 *         EXCLUDE_IF_UNSET name
	 *         EXCLUDE_IF_SET autounique
	 *         EXCLUDE_IF_SET name
	 *    value[0, 1]
	 *         EXCLUDE_IF_UNSET name
	 *         EXCLUDE_IF_SET autounique
	 *         EXCLUDE_IF_SET name
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID classContent+=ClassContent*)
	 *
	 * Features:
	 *    name[1, 1]
	 *    classContent[0, *]
	 */
	protected void sequence_ClassDefinition(EObject context, ClassDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=extendedID code=STRING) | (name=extendedID code=STRING))
	 *
	 * Features:
	 *    name[0, 2]
	 *    code[0, 2]
	 */
	protected void sequence_CodeInjection(EObject context, CodeInjection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (x=INT y=INT)
	 *
	 * Features:
	 *    x[1, 1]
	 *    y[1, 1]
	 */
	protected void sequence_Coordinate(EObject context, Coordinate semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.COORDINATE__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.COORDINATE__X));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.COORDINATE__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.COORDINATE__Y));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCoordinateAccess().getXINTTerminalRuleCall_0_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getCoordinateAccess().getYINTTerminalRuleCall_2_0(), semanticObject.getY());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=extendedID
	 *
	 * Features:
	 *    name[1, 1]
	 */
	protected void sequence_Depend(EObject context, Depend semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.DEPEND__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.DEPEND__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDependAccess().getNameExtendedIDParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (x=INT y=INT width=INT height=INT)
	 *
	 * Features:
	 *    x[1, 1]
	 *    y[1, 1]
	 *    width[1, 1]
	 *    height[1, 1]
	 */
	protected void sequence_ElementPosition(EObject context, ElementPosition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.ELEMENT_POSITION__X) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.ELEMENT_POSITION__X));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.ELEMENT_POSITION__Y) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.ELEMENT_POSITION__Y));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.ELEMENT_POSITION__WIDTH) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.ELEMENT_POSITION__WIDTH));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.ELEMENT_POSITION__HEIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.ELEMENT_POSITION__HEIGHT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getElementPositionAccess().getXINTTerminalRuleCall_1_0(), semanticObject.getX());
		feeder.accept(grammarAccess.getElementPositionAccess().getYINTTerminalRuleCall_2_0(), semanticObject.getY());
		feeder.accept(grammarAccess.getElementPositionAccess().getWidthINTTerminalRuleCall_3_0(), semanticObject.getWidth());
		feeder.accept(grammarAccess.getElementPositionAccess().getHeightINTTerminalRuleCall_4_0(), semanticObject.getHeight());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID classContent+=ClassContent*)
	 *
	 * Features:
	 *    name[1, 1]
	 *    classContent[0, *]
	 */
	protected void sequence_ExternalDefinition(EObject context, ExternalDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (java?='Java' | Php?='Php' | Ruby='Ruby')
	 *
	 * Features:
	 *    java[0, 1]
	 *         EXCLUDE_IF_SET Php
	 *         EXCLUDE_IF_SET Ruby
	 *    Php[0, 1]
	 *         EXCLUDE_IF_SET java
	 *         EXCLUDE_IF_SET Ruby
	 *    Ruby[0, 1]
	 *         EXCLUDE_IF_SET java
	 *         EXCLUDE_IF_SET Php
	 */
	protected void sequence_Generate(EObject context, Generate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (words+=Word*)
	 *
	 * Features:
	 *    words[0, *]
	 */
	protected void sequence_Glossary(EObject context, Glossary semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (rolename1=ID? type=ID rolename2=ID?)
	 *
	 * Features:
	 *    rolename1[0, 1]
	 *    type[1, 1]
	 *    rolename2[0, 1]
	 */
	protected void sequence_InlineAssociation(EObject context, InlineAssociation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID depend+=Depend*)
	 *
	 * Features:
	 *    name[1, 1]
	 *    depend[0, *]
	 */
	protected void sequence_InterfaceDefinition(EObject context, InterfaceDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((keys+=ID keys+=ID*)?)
	 *
	 * Features:
	 *    keys[0, *]
	 */
	protected void sequence_KeyDefinition(EObject context, Key semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=ID
	 *
	 * Features:
	 *    value[1, 1]
	 */
	protected void sequence_Namespace(EObject context, Namespace semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.NAMESPACE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.NAMESPACE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamespaceAccess().getValueIDTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=extendedID rolename=ID?)
	 *
	 * Features:
	 *    type[1, 1]
	 *    rolename[0, 1]
	 */
	protected void sequence_SingleAssociationEnd(EObject context, SingleAssociationEnd semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     singleton?='singleton'
	 *
	 * Features:
	 *    singleton[1, 1]
	 */
	protected void sequence_Singleton(EObject context, Singleton semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.SINGLETON__SINGLETON) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.SINGLETON__SINGLETON));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSingletonAccess().getSingletonSingletonKeyword_0_0(), semanticObject.isSingleton());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     rolename=ID
	 *
	 * Features:
	 *    rolename[1, 1]
	 */
	protected void sequence_SymmetricReflexiveAssociation(EObject context, SymmetricReflexiveAssociation semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.SYMMETRIC_REFLEXIVE_ASSOCIATION__ROLENAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.SYMMETRIC_REFLEXIVE_ASSOCIATION__ROLENAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSymmetricReflexiveAssociationAccess().getRolenameIDTerminalRuleCall_2_0(), semanticObject.getRolename());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     elements+=AbstractElement*
	 *
	 * Features:
	 *    elements[0, *]
	 */
	protected void sequence_UmpleModel(EObject context, UmpleModel semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     file=ID
	 *
	 * Features:
	 *    file[1, 1]
	 */
	protected void sequence_UseStatement(EObject context, UseStatement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.USE_STATEMENT__FILE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.USE_STATEMENT__FILE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUseStatementAccess().getFileIDTerminalRuleCall_1_0(), semanticObject.getFile());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (singular=STRING plural=STRING)
	 *
	 * Features:
	 *    singular[1, 1]
	 *    plural[1, 1]
	 */
	protected void sequence_Word(EObject context, Word semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.WORD__SINGULAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.WORD__SINGULAR));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.WORD__PLURAL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.WORD__PLURAL));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getWordAccess().getSingularSTRINGTerminalRuleCall_0_0(), semanticObject.getSingular());
		feeder.accept(grammarAccess.getWordAccess().getPluralSTRINGTerminalRuleCall_2_0(), semanticObject.getPlural());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=multiplicativeExpression expressionRest+=multiplicativeExpression*)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expressionRest[0, *]
	 */
	protected void sequence_additiveExpression(EObject context, additiveExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     blocks+=blockStatement*
	 *
	 * Features:
	 *    blocks[0, *]
	 */
	protected void sequence_block(EObject context, block semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=equalityExpression expressionRest+=equalityExpression*)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expressionRest[0, *]
	 */
	protected void sequence_conditionalAndExpression(EObject context, conditionalAndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=conditionalOrExpression (expression2=expression expression3=expression)?)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expression2[0, 1]
	 *         EXCLUDE_IF_UNSET expression3
	 *         MANDATORY_IF_SET expression3
	 *    expression3[0, 1]
	 *         EXCLUDE_IF_UNSET expression2
	 *         MANDATORY_IF_SET expression2
	 */
	protected void sequence_conditionalExpression(EObject context, conditionalExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=conditionalAndExpression expressionRest+=conditionalAndExpression*)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expressionRest[0, *]
	 */
	protected void sequence_conditionalOrExpression(EObject context, conditionalOrExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=relationalExpression expressionRest+=relationalExpression*)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expressionRest[0, *]
	 */
	protected void sequence_equalityExpression(EObject context, equalityExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expressions+=expression expressions+=expression*)
	 *
	 * Features:
	 *    expressions[1, *]
	 */
	protected void sequence_expressionList(EObject context, expressionList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=conditionalExpression expression2=expression?)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expression2[0, 1]
	 */
	protected void sequence_expression(EObject context, expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (init=forInit? condition=expression? update=forUpdate?)
	 *
	 * Features:
	 *    init[0, 1]
	 *    condition[0, 1]
	 *    update[0, 1]
	 */
	protected void sequence_forControl(EObject context, forControl semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expressions+=expression expressions+=expression*)
	 *
	 * Features:
	 *    expressions[1, *]
	 */
	protected void sequence_forInit(EObject context, forInit semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     java=javaFunctionDeclaration
	 *
	 * Features:
	 *    java[1, 1]
	 */
	protected void sequence_functionDeclaration(EObject context, functionDeclaration semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.FUNCTION_DECLARATION__JAVA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.FUNCTION_DECLARATION__JAVA));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionDeclarationAccess().getJavaJavaFunctionDeclarationParserRuleCall_0(), semanticObject.getJava());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     java=javaFunctionDefinition
	 *
	 * Features:
	 *    java[1, 1]
	 */
	protected void sequence_functionDefinition(EObject context, functionDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.FUNCTION_DEFINITION__JAVA) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.FUNCTION_DEFINITION__JAVA));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFunctionDefinitionAccess().getJavaJavaFunctionDefinitionParserRuleCall_0(), semanticObject.getJava());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (extendsClass+=[UmpleElement|ID] extendsClass+=[UmpleElement|ID]*)
	 *
	 * Features:
	 *    extendsClass[1, *]
	 */
	protected void sequence_isA(EObject context, isA semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=extendedID args=expressionList?)
	 *
	 * Features:
	 *    name[1, 1]
	 *    args[0, 1]
	 */
	protected void sequence_javaFunctionCall(EObject context, javaFunctionCall semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (returnType=attributeType | referenceType=ID)? 
	 *         name=ID 
	 *         (argList+=attributeType argListID+=extendedID (argList+=attributeType argListID+=extendedID)*)?
	 *     )
	 *
	 * Features:
	 *    returnType[0, 1]
	 *         EXCLUDE_IF_SET referenceType
	 *    referenceType[0, 1]
	 *         EXCLUDE_IF_SET returnType
	 *    name[1, 1]
	 *    argList[0, *]
	 *         EXCLUDE_IF_UNSET argListID
	 *    argListID[0, *]
	 *         EXCLUDE_IF_UNSET argList
	 */
	protected void sequence_javaFunctionDeclaration(EObject context, javaFunctionDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (decl=javaFunctionDeclaration code=block)
	 *
	 * Features:
	 *    decl[1, 1]
	 *    code[1, 1]
	 */
	protected void sequence_javaFunctionDefinition(EObject context, javaFunctionDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.JAVA_FUNCTION_DEFINITION__DECL) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.JAVA_FUNCTION_DEFINITION__DECL));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.JAVA_FUNCTION_DEFINITION__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.JAVA_FUNCTION_DEFINITION__CODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJavaFunctionDefinitionAccess().getDeclJavaFunctionDeclarationParserRuleCall_0_0(), semanticObject.getDecl());
		feeder.accept(grammarAccess.getJavaFunctionDefinitionAccess().getCodeBlockParserRuleCall_1_0(), semanticObject.getCode());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=attributeType dec=variableDeclarators)
	 *
	 * Features:
	 *    type[1, 1]
	 *    dec[1, 1]
	 */
	protected void sequence_localVariableDeclaration(EObject context, localVariableDeclaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=unaryExpression expressionRest+=unaryExpression*)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expressionRest[0, *]
	 */
	protected void sequence_multiplicativeExpression(EObject context, multiplicativeExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     code=STRING
	 *
	 * Features:
	 *    code[1, 1]
	 */
	protected void sequence_phpBlock(EObject context, phpBlock semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.PHP_BLOCK__CODE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.PHP_BLOCK__CODE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPhpBlockAccess().getCodeSTRINGTerminalRuleCall_1_0(), semanticObject.getCode());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID codeblock=[phpBlock|ID])
	 *
	 * Features:
	 *    name[1, 1]
	 *    codeblock[1, 1]
	 */
	protected void sequence_phpFunction(EObject context, phpFunction semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.PHP_FUNCTION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.PHP_FUNCTION__NAME));
			if(transientValues.isValueTransient(semanticObject, UmplePackage.Literals.PHP_FUNCTION__CODEBLOCK) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, UmplePackage.Literals.PHP_FUNCTION__CODEBLOCK));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getPhpFunctionAccess().getNameIDTerminalRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getPhpFunctionAccess().getCodeblockPhpBlockIDTerminalRuleCall_3_0_1(), semanticObject.getCodeblock());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (expression1=additiveExpression expressionRest+=additiveExpression*)
	 *
	 * Features:
	 *    expression1[1, 1]
	 *    expressionRest[0, *]
	 */
	protected void sequence_relationalExpression(EObject context, relationalExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (condition=parExpression state1=statement state2=statement?) | 
	 *         (control=forControl state=statement) | 
	 *         (condition=parExpression state=statement) | 
	 *         retVal=expression? | 
	 *         (tryBlock=block catchBlock=block)
	 *     )
	 *
	 * Features:
	 *    condition[0, 2]
	 *         EXCLUDE_IF_SET control
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET retVal
	 *         EXCLUDE_IF_SET tryBlock
	 *         EXCLUDE_IF_SET catchBlock
	 *    state1[0, 1]
	 *         EXCLUDE_IF_UNSET condition
	 *         MANDATORY_IF_SET condition
	 *         MANDATORY_IF_SET state2
	 *         EXCLUDE_IF_SET control
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET retVal
	 *         EXCLUDE_IF_SET tryBlock
	 *         EXCLUDE_IF_SET catchBlock
	 *    state2[0, 1]
	 *         EXCLUDE_IF_UNSET condition
	 *         EXCLUDE_IF_UNSET state1
	 *         EXCLUDE_IF_SET control
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET retVal
	 *         EXCLUDE_IF_SET tryBlock
	 *         EXCLUDE_IF_SET catchBlock
	 *    control[0, 1]
	 *         EXCLUDE_IF_UNSET state
	 *         MANDATORY_IF_SET state
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state1
	 *         EXCLUDE_IF_SET state2
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET retVal
	 *         EXCLUDE_IF_SET tryBlock
	 *         EXCLUDE_IF_SET catchBlock
	 *    state[0, 2]
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state1
	 *         EXCLUDE_IF_SET state2
	 *         EXCLUDE_IF_SET retVal
	 *         EXCLUDE_IF_SET tryBlock
	 *         EXCLUDE_IF_SET catchBlock
	 *    retVal[0, 1]
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state1
	 *         EXCLUDE_IF_SET state2
	 *         EXCLUDE_IF_SET control
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET tryBlock
	 *         EXCLUDE_IF_SET catchBlock
	 *    tryBlock[0, 1]
	 *         EXCLUDE_IF_UNSET catchBlock
	 *         MANDATORY_IF_SET catchBlock
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state1
	 *         EXCLUDE_IF_SET state2
	 *         EXCLUDE_IF_SET control
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET retVal
	 *    catchBlock[0, 1]
	 *         EXCLUDE_IF_UNSET tryBlock
	 *         MANDATORY_IF_SET tryBlock
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state1
	 *         EXCLUDE_IF_SET state2
	 *         EXCLUDE_IF_SET control
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET condition
	 *         EXCLUDE_IF_SET state
	 *         EXCLUDE_IF_SET retVal
	 */
	protected void sequence_statement(EObject context, statement semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (exp1=unaryExpression | exp1=unaryExpression | exp1=unaryExpression | exp1=unaryExpression | exp2=unaryExpressionNotPlusMinus)
	 *
	 * Features:
	 *    exp1[0, 4]
	 *         EXCLUDE_IF_SET exp2
	 *    exp2[0, 1]
	 *         EXCLUDE_IF_SET exp1
	 *         EXCLUDE_IF_SET exp1
	 *         EXCLUDE_IF_SET exp1
	 *         EXCLUDE_IF_SET exp1
	 */
	protected void sequence_unaryExpression(EObject context, unaryExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=extendedID exp=expression?)
	 *
	 * Features:
	 *    name[1, 1]
	 *    exp[0, 1]
	 */
	protected void sequence_variableDeclarator(EObject context, variableDeclarator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (vd+=variableDeclarator vd+=variableDeclarator*)
	 *
	 * Features:
	 *    vd[1, *]
	 */
	protected void sequence_variableDeclarators(EObject context, variableDeclarators semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
