/**
 * <copyright>
 * </copyright>
 *
 */
package cruise.umple.xtext.ext.java;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see cruise.umple.xtext.ext.java.JavaFactory
 * @model kind="package"
 * @generated
 */
public interface JavaPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "java";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.umple.cruise/xtext/ext/Java";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "java";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JavaPackage eINSTANCE = cruise.umple.xtext.ext.java.impl.JavaPackageImpl.init();

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.blockStatementImpl <em>block Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.blockStatementImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getblockStatement()
   * @generated
   */
  int BLOCK_STATEMENT = 21;

  /**
   * The number of structural features of the '<em>block Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.statementImpl <em>statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.statementImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getstatement()
   * @generated
   */
  int STATEMENT = 26;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__CONDITION = BLOCK_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>State1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__STATE1 = BLOCK_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>State2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__STATE2 = BLOCK_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__CONTROL = BLOCK_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__STATE = BLOCK_STATEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Ret Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__RET_VAL = BLOCK_STATEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__TRY_BLOCK = BLOCK_STATEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Catch Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT__CATCH_BLOCK = BLOCK_STATEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = BLOCK_STATEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.blockImpl <em>block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.blockImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getblock()
   * @generated
   */
  int BLOCK = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__CONDITION = STATEMENT__CONDITION;

  /**
   * The feature id for the '<em><b>State1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATE1 = STATEMENT__STATE1;

  /**
   * The feature id for the '<em><b>State2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATE2 = STATEMENT__STATE2;

  /**
   * The feature id for the '<em><b>Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__CONTROL = STATEMENT__CONTROL;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATE = STATEMENT__STATE;

  /**
   * The feature id for the '<em><b>Ret Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__RET_VAL = STATEMENT__RET_VAL;

  /**
   * The feature id for the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__TRY_BLOCK = STATEMENT__TRY_BLOCK;

  /**
   * The feature id for the '<em><b>Catch Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__CATCH_BLOCK = STATEMENT__CATCH_BLOCK;

  /**
   * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__BLOCKS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.unaryExpressionNotPlusMinusImpl <em>unary Expression Not Plus Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.unaryExpressionNotPlusMinusImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getunaryExpressionNotPlusMinus()
   * @generated
   */
  int UNARY_EXPRESSION_NOT_PLUS_MINUS = 12;

  /**
   * The number of structural features of the '<em>unary Expression Not Plus Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.primaryImpl <em>primary</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.primaryImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getprimary()
   * @generated
   */
  int PRIMARY = 13;

  /**
   * The number of structural features of the '<em>primary</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_FEATURE_COUNT = UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.parExpressionImpl <em>par Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.parExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getparExpression()
   * @generated
   */
  int PAR_EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>par Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PAR_EXPRESSION_FEATURE_COUNT = PRIMARY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.forUpdateImpl <em>for Update</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.forUpdateImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getforUpdate()
   * @generated
   */
  int FOR_UPDATE = 29;

  /**
   * The number of structural features of the '<em>for Update</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_UPDATE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.expressionListImpl <em>expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.expressionListImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getexpressionList()
   * @generated
   */
  int EXPRESSION_LIST = 2;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST__EXPRESSIONS = FOR_UPDATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>expression List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_LIST_FEATURE_COUNT = FOR_UPDATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.expressionImpl <em>expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.expressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getexpression()
   * @generated
   */
  int EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__CONDITION = PAR_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>State1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__STATE1 = PAR_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>State2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__STATE2 = PAR_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Control</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__CONTROL = PAR_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>State</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__STATE = PAR_EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Ret Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__RET_VAL = PAR_EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Try Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__TRY_BLOCK = PAR_EXPRESSION_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Catch Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__CATCH_BLOCK = PAR_EXPRESSION_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPRESSION1 = PAR_EXPRESSION_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Expression2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXPRESSION2 = PAR_EXPRESSION_FEATURE_COUNT + 9;

  /**
   * The number of structural features of the '<em>expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = PAR_EXPRESSION_FEATURE_COUNT + 10;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.conditionalExpressionImpl <em>conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.conditionalExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getconditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 4;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPRESSION2 = 1;

  /**
   * The feature id for the '<em><b>Expression3</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__EXPRESSION3 = 2;

  /**
   * The number of structural features of the '<em>conditional Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.conditionalOrExpressionImpl <em>conditional Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.conditionalOrExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getconditionalOrExpression()
   * @generated
   */
  int CONDITIONAL_OR_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>conditional Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_OR_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.conditionalAndExpressionImpl <em>conditional And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.conditionalAndExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getconditionalAndExpression()
   * @generated
   */
  int CONDITIONAL_AND_EXPRESSION = 6;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>conditional And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_AND_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.equalityExpressionImpl <em>equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.equalityExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getequalityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 7;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.relationalExpressionImpl <em>relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.relationalExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getrelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.additiveExpressionImpl <em>additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.additiveExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getadditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 9;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.multiplicativeExpressionImpl <em>multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.multiplicativeExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getmultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 10;

  /**
   * The feature id for the '<em><b>Expression1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPRESSION1 = 0;

  /**
   * The feature id for the '<em><b>Expression Rest</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST = 1;

  /**
   * The number of structural features of the '<em>multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.unaryExpressionImpl <em>unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.unaryExpressionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getunaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 11;

  /**
   * The feature id for the '<em><b>Exp1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXP1 = UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exp2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__EXP2 = UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_NOT_PLUS_MINUS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.literalImpl <em>literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.literalImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getliteral()
   * @generated
   */
  int LITERAL = 14;

  /**
   * The number of structural features of the '<em>literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = PRIMARY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.functionCallImpl <em>function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.functionCallImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getfunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 15;

  /**
   * The number of structural features of the '<em>function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.functionDeclarationImpl <em>function Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.functionDeclarationImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getfunctionDeclaration()
   * @generated
   */
  int FUNCTION_DECLARATION = 16;

  /**
   * The feature id for the '<em><b>Java</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION__JAVA = 0;

  /**
   * The number of structural features of the '<em>function Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.functionDefinitionImpl <em>function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.functionDefinitionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getfunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 17;

  /**
   * The feature id for the '<em><b>Java</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__JAVA = 0;

  /**
   * The number of structural features of the '<em>function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.javaFunctionDeclarationImpl <em>java Function Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.javaFunctionDeclarationImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getjavaFunctionDeclaration()
   * @generated
   */
  int JAVA_FUNCTION_DECLARATION = 18;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__RETURN_TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Arg List</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__ARG_LIST = 2;

  /**
   * The feature id for the '<em><b>Arg List ID</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION__ARG_LIST_ID = 3;

  /**
   * The number of structural features of the '<em>java Function Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DECLARATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.javaFunctionDefinitionImpl <em>java Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.javaFunctionDefinitionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getjavaFunctionDefinition()
   * @generated
   */
  int JAVA_FUNCTION_DEFINITION = 19;

  /**
   * The feature id for the '<em><b>Decl</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DEFINITION__DECL = 0;

  /**
   * The feature id for the '<em><b>Code</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DEFINITION__CODE = 1;

  /**
   * The number of structural features of the '<em>java Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.javaFunctionCallImpl <em>java Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.javaFunctionCallImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getjavaFunctionCall()
   * @generated
   */
  int JAVA_FUNCTION_CALL = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_CALL__NAME = LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_CALL__ARGS = LITERAL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>java Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FUNCTION_CALL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.localVariableDeclarationStatementImpl <em>local Variable Declaration Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.localVariableDeclarationStatementImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getlocalVariableDeclarationStatement()
   * @generated
   */
  int LOCAL_VARIABLE_DECLARATION_STATEMENT = 22;

  /**
   * The number of structural features of the '<em>local Variable Declaration Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT = BLOCK_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.localVariableDeclarationImpl <em>local Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.localVariableDeclarationImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getlocalVariableDeclaration()
   * @generated
   */
  int LOCAL_VARIABLE_DECLARATION = 23;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION__EXPRESSIONS = LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION__TYPE = LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Dec</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION__DEC = LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>local Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_VARIABLE_DECLARATION_FEATURE_COUNT = LOCAL_VARIABLE_DECLARATION_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.variableDeclaratorsImpl <em>variable Declarators</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.variableDeclaratorsImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getvariableDeclarators()
   * @generated
   */
  int VARIABLE_DECLARATORS = 24;

  /**
   * The feature id for the '<em><b>Vd</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATORS__VD = 0;

  /**
   * The number of structural features of the '<em>variable Declarators</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATORS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.variableDeclaratorImpl <em>variable Declarator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.variableDeclaratorImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getvariableDeclarator()
   * @generated
   */
  int VARIABLE_DECLARATOR = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATOR__NAME = 0;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATOR__EXP = 1;

  /**
   * The number of structural features of the '<em>variable Declarator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.forControlImpl <em>for Control</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.forControlImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getforControl()
   * @generated
   */
  int FOR_CONTROL = 27;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_CONTROL__INIT = 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_CONTROL__CONDITION = 1;

  /**
   * The feature id for the '<em><b>Update</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_CONTROL__UPDATE = 2;

  /**
   * The number of structural features of the '<em>for Control</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_CONTROL_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.forInitImpl <em>for Init</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.forInitImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getforInit()
   * @generated
   */
  int FOR_INIT = 28;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_INIT__EXPRESSIONS = 0;

  /**
   * The number of structural features of the '<em>for Init</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOR_INIT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.phpFunctionImpl <em>php Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.phpFunctionImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getphpFunction()
   * @generated
   */
  int PHP_FUNCTION = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_FUNCTION__NAME = 0;

  /**
   * The feature id for the '<em><b>Codeblock</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_FUNCTION__CODEBLOCK = 1;

  /**
   * The number of structural features of the '<em>php Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_FUNCTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link cruise.umple.xtext.ext.java.impl.phpBlockImpl <em>php Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see cruise.umple.xtext.ext.java.impl.phpBlockImpl
   * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getphpBlock()
   * @generated
   */
  int PHP_BLOCK = 31;

  /**
   * The feature id for the '<em><b>Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_BLOCK__CODE = 0;

  /**
   * The number of structural features of the '<em>php Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PHP_BLOCK_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.block <em>block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>block</em>'.
   * @see cruise.umple.xtext.ext.java.block
   * @generated
   */
  EClass getblock();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.block#getBlocks <em>Blocks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Blocks</em>'.
   * @see cruise.umple.xtext.ext.java.block#getBlocks()
   * @see #getblock()
   * @generated
   */
  EReference getblock_Blocks();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.parExpression <em>par Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>par Expression</em>'.
   * @see cruise.umple.xtext.ext.java.parExpression
   * @generated
   */
  EClass getparExpression();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.expressionList <em>expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>expression List</em>'.
   * @see cruise.umple.xtext.ext.java.expressionList
   * @generated
   */
  EClass getexpressionList();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.expressionList#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see cruise.umple.xtext.ext.java.expressionList#getExpressions()
   * @see #getexpressionList()
   * @generated
   */
  EReference getexpressionList_Expressions();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.expression <em>expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>expression</em>'.
   * @see cruise.umple.xtext.ext.java.expression
   * @generated
   */
  EClass getexpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.expression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.xtext.ext.java.expression#getExpression1()
   * @see #getexpression()
   * @generated
   */
  EReference getexpression_Expression1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.expression#getExpression2 <em>Expression2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression2</em>'.
   * @see cruise.umple.xtext.ext.java.expression#getExpression2()
   * @see #getexpression()
   * @generated
   */
  EReference getexpression_Expression2();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.conditionalExpression <em>conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>conditional Expression</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalExpression
   * @generated
   */
  EClass getconditionalExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.conditionalExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalExpression#getExpression1()
   * @see #getconditionalExpression()
   * @generated
   */
  EReference getconditionalExpression_Expression1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.conditionalExpression#getExpression2 <em>Expression2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression2</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalExpression#getExpression2()
   * @see #getconditionalExpression()
   * @generated
   */
  EReference getconditionalExpression_Expression2();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.conditionalExpression#getExpression3 <em>Expression3</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression3</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalExpression#getExpression3()
   * @see #getconditionalExpression()
   * @generated
   */
  EReference getconditionalExpression_Expression3();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.conditionalOrExpression <em>conditional Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>conditional Or Expression</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalOrExpression
   * @generated
   */
  EClass getconditionalOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.conditionalOrExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalOrExpression#getExpression1()
   * @see #getconditionalOrExpression()
   * @generated
   */
  EReference getconditionalOrExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.conditionalOrExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalOrExpression#getExpressionRest()
   * @see #getconditionalOrExpression()
   * @generated
   */
  EReference getconditionalOrExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.conditionalAndExpression <em>conditional And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>conditional And Expression</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalAndExpression
   * @generated
   */
  EClass getconditionalAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.conditionalAndExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalAndExpression#getExpression1()
   * @see #getconditionalAndExpression()
   * @generated
   */
  EReference getconditionalAndExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.conditionalAndExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.xtext.ext.java.conditionalAndExpression#getExpressionRest()
   * @see #getconditionalAndExpression()
   * @generated
   */
  EReference getconditionalAndExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.equalityExpression <em>equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>equality Expression</em>'.
   * @see cruise.umple.xtext.ext.java.equalityExpression
   * @generated
   */
  EClass getequalityExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.equalityExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.xtext.ext.java.equalityExpression#getExpression1()
   * @see #getequalityExpression()
   * @generated
   */
  EReference getequalityExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.equalityExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.xtext.ext.java.equalityExpression#getExpressionRest()
   * @see #getequalityExpression()
   * @generated
   */
  EReference getequalityExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.relationalExpression <em>relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>relational Expression</em>'.
   * @see cruise.umple.xtext.ext.java.relationalExpression
   * @generated
   */
  EClass getrelationalExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.relationalExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.xtext.ext.java.relationalExpression#getExpression1()
   * @see #getrelationalExpression()
   * @generated
   */
  EReference getrelationalExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.relationalExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.xtext.ext.java.relationalExpression#getExpressionRest()
   * @see #getrelationalExpression()
   * @generated
   */
  EReference getrelationalExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.additiveExpression <em>additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>additive Expression</em>'.
   * @see cruise.umple.xtext.ext.java.additiveExpression
   * @generated
   */
  EClass getadditiveExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.additiveExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.xtext.ext.java.additiveExpression#getExpression1()
   * @see #getadditiveExpression()
   * @generated
   */
  EReference getadditiveExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.additiveExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.xtext.ext.java.additiveExpression#getExpressionRest()
   * @see #getadditiveExpression()
   * @generated
   */
  EReference getadditiveExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.multiplicativeExpression <em>multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>multiplicative Expression</em>'.
   * @see cruise.umple.xtext.ext.java.multiplicativeExpression
   * @generated
   */
  EClass getmultiplicativeExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.multiplicativeExpression#getExpression1 <em>Expression1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression1</em>'.
   * @see cruise.umple.xtext.ext.java.multiplicativeExpression#getExpression1()
   * @see #getmultiplicativeExpression()
   * @generated
   */
  EReference getmultiplicativeExpression_Expression1();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.multiplicativeExpression#getExpressionRest <em>Expression Rest</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Rest</em>'.
   * @see cruise.umple.xtext.ext.java.multiplicativeExpression#getExpressionRest()
   * @see #getmultiplicativeExpression()
   * @generated
   */
  EReference getmultiplicativeExpression_ExpressionRest();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.unaryExpression <em>unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>unary Expression</em>'.
   * @see cruise.umple.xtext.ext.java.unaryExpression
   * @generated
   */
  EClass getunaryExpression();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.unaryExpression#getExp1 <em>Exp1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp1</em>'.
   * @see cruise.umple.xtext.ext.java.unaryExpression#getExp1()
   * @see #getunaryExpression()
   * @generated
   */
  EReference getunaryExpression_Exp1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.unaryExpression#getExp2 <em>Exp2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp2</em>'.
   * @see cruise.umple.xtext.ext.java.unaryExpression#getExp2()
   * @see #getunaryExpression()
   * @generated
   */
  EReference getunaryExpression_Exp2();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.unaryExpressionNotPlusMinus <em>unary Expression Not Plus Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>unary Expression Not Plus Minus</em>'.
   * @see cruise.umple.xtext.ext.java.unaryExpressionNotPlusMinus
   * @generated
   */
  EClass getunaryExpressionNotPlusMinus();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.primary <em>primary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>primary</em>'.
   * @see cruise.umple.xtext.ext.java.primary
   * @generated
   */
  EClass getprimary();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.literal <em>literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>literal</em>'.
   * @see cruise.umple.xtext.ext.java.literal
   * @generated
   */
  EClass getliteral();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.functionCall <em>function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>function Call</em>'.
   * @see cruise.umple.xtext.ext.java.functionCall
   * @generated
   */
  EClass getfunctionCall();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.functionDeclaration <em>function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>function Declaration</em>'.
   * @see cruise.umple.xtext.ext.java.functionDeclaration
   * @generated
   */
  EClass getfunctionDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.functionDeclaration#getJava <em>Java</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Java</em>'.
   * @see cruise.umple.xtext.ext.java.functionDeclaration#getJava()
   * @see #getfunctionDeclaration()
   * @generated
   */
  EReference getfunctionDeclaration_Java();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.functionDefinition <em>function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>function Definition</em>'.
   * @see cruise.umple.xtext.ext.java.functionDefinition
   * @generated
   */
  EClass getfunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.functionDefinition#getJava <em>Java</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Java</em>'.
   * @see cruise.umple.xtext.ext.java.functionDefinition#getJava()
   * @see #getfunctionDefinition()
   * @generated
   */
  EReference getfunctionDefinition_Java();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.javaFunctionDeclaration <em>java Function Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>java Function Declaration</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionDeclaration
   * @generated
   */
  EClass getjavaFunctionDeclaration();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.xtext.ext.java.javaFunctionDeclaration#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Return Type</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionDeclaration#getReturnType()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_ReturnType();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.xtext.ext.java.javaFunctionDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionDeclaration#getName()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_Name();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.xtext.ext.java.javaFunctionDeclaration#getArgList <em>Arg List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Arg List</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionDeclaration#getArgList()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_ArgList();

  /**
   * Returns the meta object for the attribute list '{@link cruise.umple.xtext.ext.java.javaFunctionDeclaration#getArgListID <em>Arg List ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Arg List ID</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionDeclaration#getArgListID()
   * @see #getjavaFunctionDeclaration()
   * @generated
   */
  EAttribute getjavaFunctionDeclaration_ArgListID();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.javaFunctionDefinition <em>java Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>java Function Definition</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionDefinition
   * @generated
   */
  EClass getjavaFunctionDefinition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.javaFunctionDefinition#getDecl <em>Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionDefinition#getDecl()
   * @see #getjavaFunctionDefinition()
   * @generated
   */
  EReference getjavaFunctionDefinition_Decl();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.javaFunctionDefinition#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Code</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionDefinition#getCode()
   * @see #getjavaFunctionDefinition()
   * @generated
   */
  EReference getjavaFunctionDefinition_Code();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.javaFunctionCall <em>java Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>java Function Call</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionCall
   * @generated
   */
  EClass getjavaFunctionCall();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.xtext.ext.java.javaFunctionCall#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionCall#getName()
   * @see #getjavaFunctionCall()
   * @generated
   */
  EAttribute getjavaFunctionCall_Name();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.javaFunctionCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Args</em>'.
   * @see cruise.umple.xtext.ext.java.javaFunctionCall#getArgs()
   * @see #getjavaFunctionCall()
   * @generated
   */
  EReference getjavaFunctionCall_Args();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.blockStatement <em>block Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>block Statement</em>'.
   * @see cruise.umple.xtext.ext.java.blockStatement
   * @generated
   */
  EClass getblockStatement();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.localVariableDeclarationStatement <em>local Variable Declaration Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>local Variable Declaration Statement</em>'.
   * @see cruise.umple.xtext.ext.java.localVariableDeclarationStatement
   * @generated
   */
  EClass getlocalVariableDeclarationStatement();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.localVariableDeclaration <em>local Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>local Variable Declaration</em>'.
   * @see cruise.umple.xtext.ext.java.localVariableDeclaration
   * @generated
   */
  EClass getlocalVariableDeclaration();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.xtext.ext.java.localVariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see cruise.umple.xtext.ext.java.localVariableDeclaration#getType()
   * @see #getlocalVariableDeclaration()
   * @generated
   */
  EAttribute getlocalVariableDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.localVariableDeclaration#getDec <em>Dec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dec</em>'.
   * @see cruise.umple.xtext.ext.java.localVariableDeclaration#getDec()
   * @see #getlocalVariableDeclaration()
   * @generated
   */
  EReference getlocalVariableDeclaration_Dec();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.variableDeclarators <em>variable Declarators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>variable Declarators</em>'.
   * @see cruise.umple.xtext.ext.java.variableDeclarators
   * @generated
   */
  EClass getvariableDeclarators();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.variableDeclarators#getVd <em>Vd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Vd</em>'.
   * @see cruise.umple.xtext.ext.java.variableDeclarators#getVd()
   * @see #getvariableDeclarators()
   * @generated
   */
  EReference getvariableDeclarators_Vd();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.variableDeclarator <em>variable Declarator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>variable Declarator</em>'.
   * @see cruise.umple.xtext.ext.java.variableDeclarator
   * @generated
   */
  EClass getvariableDeclarator();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.xtext.ext.java.variableDeclarator#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.xtext.ext.java.variableDeclarator#getName()
   * @see #getvariableDeclarator()
   * @generated
   */
  EAttribute getvariableDeclarator_Name();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.variableDeclarator#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see cruise.umple.xtext.ext.java.variableDeclarator#getExp()
   * @see #getvariableDeclarator()
   * @generated
   */
  EReference getvariableDeclarator_Exp();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.statement <em>statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>statement</em>'.
   * @see cruise.umple.xtext.ext.java.statement
   * @generated
   */
  EClass getstatement();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.statement#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see cruise.umple.xtext.ext.java.statement#getCondition()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_Condition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.statement#getState1 <em>State1</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State1</em>'.
   * @see cruise.umple.xtext.ext.java.statement#getState1()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_State1();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.statement#getState2 <em>State2</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State2</em>'.
   * @see cruise.umple.xtext.ext.java.statement#getState2()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_State2();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.statement#getControl <em>Control</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Control</em>'.
   * @see cruise.umple.xtext.ext.java.statement#getControl()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_Control();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.statement#getState <em>State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>State</em>'.
   * @see cruise.umple.xtext.ext.java.statement#getState()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_State();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.statement#getRetVal <em>Ret Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Ret Val</em>'.
   * @see cruise.umple.xtext.ext.java.statement#getRetVal()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_RetVal();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.statement#getTryBlock <em>Try Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Try Block</em>'.
   * @see cruise.umple.xtext.ext.java.statement#getTryBlock()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_TryBlock();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.statement#getCatchBlock <em>Catch Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Catch Block</em>'.
   * @see cruise.umple.xtext.ext.java.statement#getCatchBlock()
   * @see #getstatement()
   * @generated
   */
  EReference getstatement_CatchBlock();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.forControl <em>for Control</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>for Control</em>'.
   * @see cruise.umple.xtext.ext.java.forControl
   * @generated
   */
  EClass getforControl();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.forControl#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see cruise.umple.xtext.ext.java.forControl#getInit()
   * @see #getforControl()
   * @generated
   */
  EReference getforControl_Init();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.forControl#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see cruise.umple.xtext.ext.java.forControl#getCondition()
   * @see #getforControl()
   * @generated
   */
  EReference getforControl_Condition();

  /**
   * Returns the meta object for the containment reference '{@link cruise.umple.xtext.ext.java.forControl#getUpdate <em>Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Update</em>'.
   * @see cruise.umple.xtext.ext.java.forControl#getUpdate()
   * @see #getforControl()
   * @generated
   */
  EReference getforControl_Update();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.forInit <em>for Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>for Init</em>'.
   * @see cruise.umple.xtext.ext.java.forInit
   * @generated
   */
  EClass getforInit();

  /**
   * Returns the meta object for the containment reference list '{@link cruise.umple.xtext.ext.java.forInit#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see cruise.umple.xtext.ext.java.forInit#getExpressions()
   * @see #getforInit()
   * @generated
   */
  EReference getforInit_Expressions();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.forUpdate <em>for Update</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>for Update</em>'.
   * @see cruise.umple.xtext.ext.java.forUpdate
   * @generated
   */
  EClass getforUpdate();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.phpFunction <em>php Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>php Function</em>'.
   * @see cruise.umple.xtext.ext.java.phpFunction
   * @generated
   */
  EClass getphpFunction();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.xtext.ext.java.phpFunction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see cruise.umple.xtext.ext.java.phpFunction#getName()
   * @see #getphpFunction()
   * @generated
   */
  EAttribute getphpFunction_Name();

  /**
   * Returns the meta object for the reference '{@link cruise.umple.xtext.ext.java.phpFunction#getCodeblock <em>Codeblock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Codeblock</em>'.
   * @see cruise.umple.xtext.ext.java.phpFunction#getCodeblock()
   * @see #getphpFunction()
   * @generated
   */
  EReference getphpFunction_Codeblock();

  /**
   * Returns the meta object for class '{@link cruise.umple.xtext.ext.java.phpBlock <em>php Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>php Block</em>'.
   * @see cruise.umple.xtext.ext.java.phpBlock
   * @generated
   */
  EClass getphpBlock();

  /**
   * Returns the meta object for the attribute '{@link cruise.umple.xtext.ext.java.phpBlock#getCode <em>Code</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Code</em>'.
   * @see cruise.umple.xtext.ext.java.phpBlock#getCode()
   * @see #getphpBlock()
   * @generated
   */
  EAttribute getphpBlock_Code();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  JavaFactory getJavaFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.blockImpl <em>block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.blockImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getblock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getblock();

    /**
     * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__BLOCKS = eINSTANCE.getblock_Blocks();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.parExpressionImpl <em>par Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.parExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getparExpression()
     * @generated
     */
    EClass PAR_EXPRESSION = eINSTANCE.getparExpression();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.expressionListImpl <em>expression List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.expressionListImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getexpressionList()
     * @generated
     */
    EClass EXPRESSION_LIST = eINSTANCE.getexpressionList();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_LIST__EXPRESSIONS = eINSTANCE.getexpressionList_Expressions();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.expressionImpl <em>expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.expressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getexpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getexpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPRESSION1 = eINSTANCE.getexpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXPRESSION2 = eINSTANCE.getexpression_Expression2();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.conditionalExpressionImpl <em>conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.conditionalExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getconditionalExpression()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION = eINSTANCE.getconditionalExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXPRESSION1 = eINSTANCE.getconditionalExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXPRESSION2 = eINSTANCE.getconditionalExpression_Expression2();

    /**
     * The meta object literal for the '<em><b>Expression3</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__EXPRESSION3 = eINSTANCE.getconditionalExpression_Expression3();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.conditionalOrExpressionImpl <em>conditional Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.conditionalOrExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getconditionalOrExpression()
     * @generated
     */
    EClass CONDITIONAL_OR_EXPRESSION = eINSTANCE.getconditionalOrExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_OR_EXPRESSION__EXPRESSION1 = eINSTANCE.getconditionalOrExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_OR_EXPRESSION__EXPRESSION_REST = eINSTANCE.getconditionalOrExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.conditionalAndExpressionImpl <em>conditional And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.conditionalAndExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getconditionalAndExpression()
     * @generated
     */
    EClass CONDITIONAL_AND_EXPRESSION = eINSTANCE.getconditionalAndExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_AND_EXPRESSION__EXPRESSION1 = eINSTANCE.getconditionalAndExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_AND_EXPRESSION__EXPRESSION_REST = eINSTANCE.getconditionalAndExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.equalityExpressionImpl <em>equality Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.equalityExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getequalityExpression()
     * @generated
     */
    EClass EQUALITY_EXPRESSION = eINSTANCE.getequalityExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__EXPRESSION1 = eINSTANCE.getequalityExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EQUALITY_EXPRESSION__EXPRESSION_REST = eINSTANCE.getequalityExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.relationalExpressionImpl <em>relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.relationalExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getrelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getrelationalExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__EXPRESSION1 = eINSTANCE.getrelationalExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__EXPRESSION_REST = eINSTANCE.getrelationalExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.additiveExpressionImpl <em>additive Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.additiveExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getadditiveExpression()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION = eINSTANCE.getadditiveExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__EXPRESSION1 = eINSTANCE.getadditiveExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__EXPRESSION_REST = eINSTANCE.getadditiveExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.multiplicativeExpressionImpl <em>multiplicative Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.multiplicativeExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getmultiplicativeExpression()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getmultiplicativeExpression();

    /**
     * The meta object literal for the '<em><b>Expression1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__EXPRESSION1 = eINSTANCE.getmultiplicativeExpression_Expression1();

    /**
     * The meta object literal for the '<em><b>Expression Rest</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__EXPRESSION_REST = eINSTANCE.getmultiplicativeExpression_ExpressionRest();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.unaryExpressionImpl <em>unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.unaryExpressionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getunaryExpression()
     * @generated
     */
    EClass UNARY_EXPRESSION = eINSTANCE.getunaryExpression();

    /**
     * The meta object literal for the '<em><b>Exp1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXP1 = eINSTANCE.getunaryExpression_Exp1();

    /**
     * The meta object literal for the '<em><b>Exp2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPRESSION__EXP2 = eINSTANCE.getunaryExpression_Exp2();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.unaryExpressionNotPlusMinusImpl <em>unary Expression Not Plus Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.unaryExpressionNotPlusMinusImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getunaryExpressionNotPlusMinus()
     * @generated
     */
    EClass UNARY_EXPRESSION_NOT_PLUS_MINUS = eINSTANCE.getunaryExpressionNotPlusMinus();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.primaryImpl <em>primary</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.primaryImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getprimary()
     * @generated
     */
    EClass PRIMARY = eINSTANCE.getprimary();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.literalImpl <em>literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.literalImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getliteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getliteral();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.functionCallImpl <em>function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.functionCallImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getfunctionCall()
     * @generated
     */
    EClass FUNCTION_CALL = eINSTANCE.getfunctionCall();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.functionDeclarationImpl <em>function Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.functionDeclarationImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getfunctionDeclaration()
     * @generated
     */
    EClass FUNCTION_DECLARATION = eINSTANCE.getfunctionDeclaration();

    /**
     * The meta object literal for the '<em><b>Java</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DECLARATION__JAVA = eINSTANCE.getfunctionDeclaration_Java();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.functionDefinitionImpl <em>function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.functionDefinitionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getfunctionDefinition()
     * @generated
     */
    EClass FUNCTION_DEFINITION = eINSTANCE.getfunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Java</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__JAVA = eINSTANCE.getfunctionDefinition_Java();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.javaFunctionDeclarationImpl <em>java Function Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.javaFunctionDeclarationImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getjavaFunctionDeclaration()
     * @generated
     */
    EClass JAVA_FUNCTION_DECLARATION = eINSTANCE.getjavaFunctionDeclaration();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__RETURN_TYPE = eINSTANCE.getjavaFunctionDeclaration_ReturnType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__NAME = eINSTANCE.getjavaFunctionDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Arg List</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__ARG_LIST = eINSTANCE.getjavaFunctionDeclaration_ArgList();

    /**
     * The meta object literal for the '<em><b>Arg List ID</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_DECLARATION__ARG_LIST_ID = eINSTANCE.getjavaFunctionDeclaration_ArgListID();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.javaFunctionDefinitionImpl <em>java Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.javaFunctionDefinitionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getjavaFunctionDefinition()
     * @generated
     */
    EClass JAVA_FUNCTION_DEFINITION = eINSTANCE.getjavaFunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Decl</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_FUNCTION_DEFINITION__DECL = eINSTANCE.getjavaFunctionDefinition_Decl();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_FUNCTION_DEFINITION__CODE = eINSTANCE.getjavaFunctionDefinition_Code();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.javaFunctionCallImpl <em>java Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.javaFunctionCallImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getjavaFunctionCall()
     * @generated
     */
    EClass JAVA_FUNCTION_CALL = eINSTANCE.getjavaFunctionCall();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute JAVA_FUNCTION_CALL__NAME = eINSTANCE.getjavaFunctionCall_Name();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_FUNCTION_CALL__ARGS = eINSTANCE.getjavaFunctionCall_Args();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.blockStatementImpl <em>block Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.blockStatementImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getblockStatement()
     * @generated
     */
    EClass BLOCK_STATEMENT = eINSTANCE.getblockStatement();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.localVariableDeclarationStatementImpl <em>local Variable Declaration Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.localVariableDeclarationStatementImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getlocalVariableDeclarationStatement()
     * @generated
     */
    EClass LOCAL_VARIABLE_DECLARATION_STATEMENT = eINSTANCE.getlocalVariableDeclarationStatement();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.localVariableDeclarationImpl <em>local Variable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.localVariableDeclarationImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getlocalVariableDeclaration()
     * @generated
     */
    EClass LOCAL_VARIABLE_DECLARATION = eINSTANCE.getlocalVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOCAL_VARIABLE_DECLARATION__TYPE = eINSTANCE.getlocalVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Dec</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOCAL_VARIABLE_DECLARATION__DEC = eINSTANCE.getlocalVariableDeclaration_Dec();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.variableDeclaratorsImpl <em>variable Declarators</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.variableDeclaratorsImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getvariableDeclarators()
     * @generated
     */
    EClass VARIABLE_DECLARATORS = eINSTANCE.getvariableDeclarators();

    /**
     * The meta object literal for the '<em><b>Vd</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATORS__VD = eINSTANCE.getvariableDeclarators_Vd();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.variableDeclaratorImpl <em>variable Declarator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.variableDeclaratorImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getvariableDeclarator()
     * @generated
     */
    EClass VARIABLE_DECLARATOR = eINSTANCE.getvariableDeclarator();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATOR__NAME = eINSTANCE.getvariableDeclarator_Name();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATOR__EXP = eINSTANCE.getvariableDeclarator_Exp();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.statementImpl <em>statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.statementImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getstatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getstatement();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__CONDITION = eINSTANCE.getstatement_Condition();

    /**
     * The meta object literal for the '<em><b>State1</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__STATE1 = eINSTANCE.getstatement_State1();

    /**
     * The meta object literal for the '<em><b>State2</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__STATE2 = eINSTANCE.getstatement_State2();

    /**
     * The meta object literal for the '<em><b>Control</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__CONTROL = eINSTANCE.getstatement_Control();

    /**
     * The meta object literal for the '<em><b>State</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__STATE = eINSTANCE.getstatement_State();

    /**
     * The meta object literal for the '<em><b>Ret Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__RET_VAL = eINSTANCE.getstatement_RetVal();

    /**
     * The meta object literal for the '<em><b>Try Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__TRY_BLOCK = eINSTANCE.getstatement_TryBlock();

    /**
     * The meta object literal for the '<em><b>Catch Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENT__CATCH_BLOCK = eINSTANCE.getstatement_CatchBlock();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.forControlImpl <em>for Control</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.forControlImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getforControl()
     * @generated
     */
    EClass FOR_CONTROL = eINSTANCE.getforControl();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_CONTROL__INIT = eINSTANCE.getforControl_Init();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_CONTROL__CONDITION = eINSTANCE.getforControl_Condition();

    /**
     * The meta object literal for the '<em><b>Update</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_CONTROL__UPDATE = eINSTANCE.getforControl_Update();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.forInitImpl <em>for Init</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.forInitImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getforInit()
     * @generated
     */
    EClass FOR_INIT = eINSTANCE.getforInit();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOR_INIT__EXPRESSIONS = eINSTANCE.getforInit_Expressions();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.forUpdateImpl <em>for Update</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.forUpdateImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getforUpdate()
     * @generated
     */
    EClass FOR_UPDATE = eINSTANCE.getforUpdate();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.phpFunctionImpl <em>php Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.phpFunctionImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getphpFunction()
     * @generated
     */
    EClass PHP_FUNCTION = eINSTANCE.getphpFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHP_FUNCTION__NAME = eINSTANCE.getphpFunction_Name();

    /**
     * The meta object literal for the '<em><b>Codeblock</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PHP_FUNCTION__CODEBLOCK = eINSTANCE.getphpFunction_Codeblock();

    /**
     * The meta object literal for the '{@link cruise.umple.xtext.ext.java.impl.phpBlockImpl <em>php Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see cruise.umple.xtext.ext.java.impl.phpBlockImpl
     * @see cruise.umple.xtext.ext.java.impl.JavaPackageImpl#getphpBlock()
     * @generated
     */
    EClass PHP_BLOCK = eINSTANCE.getphpBlock();

    /**
     * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PHP_BLOCK__CODE = eINSTANCE.getphpBlock_Code();

  }

} //JavaPackage
