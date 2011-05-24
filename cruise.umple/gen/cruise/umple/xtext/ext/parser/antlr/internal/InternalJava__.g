lexer grammar InternalJava;
@header {
package cruise.umple.xtext.ext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T14 : '{' ;
T15 : '}' ;
T16 : '(' ;
T17 : ')' ;
T18 : '=' ;
T19 : '+=' ;
T20 : '-=' ;
T21 : ',' ;
T22 : '?' ;
T23 : ':' ;
T24 : '||' ;
T25 : '&&' ;
T26 : '==' ;
T27 : '!=' ;
T28 : '<=' ;
T29 : '<' ;
T30 : '>=' ;
T31 : '>' ;
T32 : '+' ;
T33 : '-' ;
T34 : '*' ;
T35 : '/' ;
T36 : '%' ;
T37 : '++' ;
T38 : '--' ;
T39 : '~' ;
T40 : '!' ;
T41 : 'true' ;
T42 : 'TRUE' ;
T43 : 'false' ;
T44 : 'FALSE' ;
T45 : 'static' ;
T46 : 'public' ;
T47 : 'private' ;
T48 : 'protected' ;
T49 : 'void' ;
T50 : ';' ;
T51 : 'if' ;
T52 : 'else' ;
T53 : 'for' ;
T54 : 'while' ;
T55 : 'return' ;
T56 : 'break' ;
T57 : 'try' ;
T58 : 'catch' ;
T59 : '.' ;
T60 : 'Date' ;
T61 : 'Time' ;
T62 : 'Double' ;
T63 : 'double' ;
T64 : 'Integer' ;
T65 : 'integer' ;
T66 : 'int' ;
T67 : 'Boolean' ;
T68 : 'boolean' ;
T69 : 'String' ;
T70 : 'string' ;

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2762
RULE_RUBY_FUNCTION : RULE_DEF ( options {greedy=false;} : . )*RULE_END;

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2764
RULE_DEF : 'def';

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2766
RULE_END : 'end';

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2768
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2770
RULE_INT : ('0'..'9')+;

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2772
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2774
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2776
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2778
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../cruise.umple.xtext.ext.java/src-gen/cruise/umple/xtext/ext/parser/antlr/internal/InternalJava.g" 2780
RULE_ANY_OTHER : .;


