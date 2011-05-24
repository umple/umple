lexer grammar InternalUmple;
@header {
package cruise.umple.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : ':' ;
T12 : ';' ;
T13 : 'glossary' ;
T14 : '{' ;
T15 : '}' ;
T16 : 'generate' ;
T17 : 'Java' ;
T18 : 'use' ;
T19 : 'namespace' ;
T20 : 'external' ;
T21 : 'class' ;
T22 : 'isA' ;
T23 : ',' ;
T24 : 'interface' ;
T25 : 'association' ;
T26 : 'associationClass' ;
T27 : '->' ;
T28 : '--' ;
T29 : '<-' ;
T30 : '><' ;
T31 : 'self' ;
T32 : '..' ;
T33 : '*' ;
T34 : 'singleton' ;
T35 : 'before' ;
T36 : 'after' ;
T37 : 'autounique' ;
T38 : 'unique' ;
T39 : '[]' ;
T40 : '=' ;
T41 : 'Date' ;
T42 : 'Time' ;
T43 : 'Double' ;
T44 : 'double' ;
T45 : 'Integer' ;
T46 : 'integer' ;
T47 : 'int' ;
T48 : 'Boolean' ;
T49 : 'boolean' ;
T50 : 'String' ;
T51 : 'string' ;
T52 : 'key' ;
T53 : 'depend' ;
T54 : '.*' ;
T55 : 'statemachine' ;
T56 : 'as' ;
T57 : 'conc' ;
T58 : 'concurrent' ;
T59 : '|' ;
T60 : 'afterEvery' ;
T61 : '(' ;
T62 : ')' ;
T63 : 'wait' ;
T64 : '/' ;
T65 : 'entry' ;
T66 : 'exit' ;
T67 : 'do' ;
T68 : '[' ;
T69 : ']' ;
T70 : 'position' ;
T71 : 'position.association' ;
T72 : '.' ;
T73 : 'trace' ;
T74 : 'Trace' ;
T75 : 'for' ;
T76 : 'during' ;
T77 : 'period' ;
T78 : 'execute' ;
T79 : 'until' ;
T80 : 'where' ;
T81 : 'tracecase' ;
T82 : 'activate' ;
T83 : 'on this' ;
T84 : 'on thisThread' ;
T85 : 'deactivate' ;
T86 : 'record' ;
T87 : 'cflow' ;
T88 : '()' ;
T89 : 'cardinality' ;
T90 : '>' ;
T91 : '<' ;
T92 : '==' ;
T93 : '>=' ;
T94 : '<=' ;
T95 : 'TraceUsing' ;
T96 : '+=' ;
T97 : '-=' ;
T98 : '?' ;
T99 : '||' ;
T100 : '&&' ;
T101 : '!=' ;
T102 : '+' ;
T103 : '-' ;
T104 : '%' ;
T105 : '++' ;
T106 : '~' ;
T107 : '!' ;
T108 : 'true' ;
T109 : 'TRUE' ;
T110 : 'false' ;
T111 : 'FALSE' ;
T112 : 'static' ;
T113 : 'public' ;
T114 : 'private' ;
T115 : 'protected' ;
T116 : 'void' ;
T117 : 'if' ;
T118 : 'else' ;
T119 : 'while' ;
T120 : 'return' ;
T121 : 'break' ;
T122 : 'immutable' ;
T123 : 'settable' ;
T124 : 'internal' ;
T125 : 'defaulted' ;
T126 : 'const' ;

// $ANTLR src "../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8963
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8965
RULE_INT : ('0'..'9')+;

// $ANTLR src "../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8967
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8969
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8971
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8973
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../cruise.umple.xtext/src-gen/cruise/umple/parser/antlr/internal/InternalUmple.g" 8975
RULE_ANY_OTHER : .;


