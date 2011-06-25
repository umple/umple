lexer grammar InternalUmple;
@header {
package cruise.umple.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T14 : ':' ;
T15 : ';' ;
T16 : 'glossary' ;
T17 : '{' ;
T18 : '}' ;
T19 : 'generate' ;
T20 : 'Java' ;
T21 : 'Php' ;
T22 : 'Ruby' ;
T23 : 'use' ;
T24 : 'namespace' ;
T25 : 'external' ;
T26 : 'class' ;
T27 : 'isA' ;
T28 : ',' ;
T29 : 'boolean' ;
T30 : 'char' ;
T31 : 'byte' ;
T32 : 'short' ;
T33 : 'int' ;
T34 : 'long' ;
T35 : 'float' ;
T36 : 'double' ;
T37 : 'interface' ;
T38 : 'association' ;
T39 : 'associationClass' ;
T40 : '->' ;
T41 : '--' ;
T42 : '<-' ;
T43 : '><' ;
T44 : 'self' ;
T45 : '..' ;
T46 : '*' ;
T47 : 'singleton' ;
T48 : 'before' ;
T49 : 'after' ;
T50 : 'autounique' ;
T51 : 'unique' ;
T52 : '[]' ;
T53 : '=' ;
T54 : 'Date' ;
T55 : 'Time' ;
T56 : 'Double' ;
T57 : 'Integer' ;
T58 : 'integer' ;
T59 : 'Boolean' ;
T60 : 'String' ;
T61 : 'string' ;
T62 : 'key' ;
T63 : 'depend' ;
T64 : '.*' ;
T65 : 'statemachine' ;
T66 : 'as' ;
T67 : 'conc' ;
T68 : 'concurrent' ;
T69 : '|' ;
T70 : 'afterEvery' ;
T71 : '(' ;
T72 : ')' ;
T73 : 'wait' ;
T74 : '/' ;
T75 : 'entry' ;
T76 : 'exit' ;
T77 : 'do' ;
T78 : '[' ;
T79 : ']' ;
T80 : 'position' ;
T81 : 'position.association' ;
T82 : 'trace' ;
T83 : 'Trace' ;
T84 : 'tracecase' ;
T85 : 'cflow' ;
T86 : '()' ;
T87 : '>' ;
T88 : '<' ;
T89 : '==' ;
T90 : '>=' ;
T91 : '<=' ;
T92 : 'TraceUsing' ;
T93 : '+=' ;
T94 : '-=' ;
T95 : '?' ;
T96 : '||' ;
T97 : '&&' ;
T98 : '!=' ;
T99 : '+' ;
T100 : '-' ;
T101 : '%' ;
T102 : '++' ;
T103 : '~' ;
T104 : '!' ;
T105 : 'true' ;
T106 : 'TRUE' ;
T107 : 'false' ;
T108 : 'FALSE' ;
T109 : 'static' ;
T110 : 'public' ;
T111 : 'private' ;
T112 : 'protected' ;
T113 : 'void' ;
T114 : 'if' ;
T115 : 'else' ;
T116 : 'for' ;
T117 : 'while' ;
T118 : 'return' ;
T119 : 'break' ;
T120 : 'try' ;
T121 : 'catch' ;
T122 : 'function' ;
T123 : '.' ;
T124 : 'immutable' ;
T125 : 'settable' ;
T126 : 'internal' ;
T127 : 'defaulted' ;
T128 : 'const' ;

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8358
RULE_RUBY_FUNCTION : RULE_DEF ( options {greedy=false;} : . )*RULE_END;

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8360
RULE_DEF : 'def';

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8362
RULE_END : 'end';

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8364
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8366
RULE_INT : ('0'..'9')+;

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8368
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8370
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8372
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8374
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../cruise.umple/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8376
RULE_ANY_OTHER : .;


