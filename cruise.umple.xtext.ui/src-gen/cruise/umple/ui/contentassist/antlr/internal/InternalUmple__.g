lexer grammar InternalUmple;
@header {
package cruise.umple.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T14 : 'boolean' ;
T15 : 'char' ;
T16 : 'byte' ;
T17 : 'short' ;
T18 : 'int' ;
T19 : 'long' ;
T20 : 'float' ;
T21 : 'double' ;
T22 : '->' ;
T23 : '--' ;
T24 : '<-' ;
T25 : '><' ;
T26 : '*' ;
T27 : 'Date' ;
T28 : 'Time' ;
T29 : 'Double' ;
T30 : 'Integer' ;
T31 : 'integer' ;
T32 : 'Boolean' ;
T33 : 'String' ;
T34 : 'string' ;
T35 : 'trace' ;
T36 : 'Trace' ;
T37 : '>' ;
T38 : '<' ;
T39 : '==' ;
T40 : '>=' ;
T41 : '<=' ;
T42 : '=' ;
T43 : '+=' ;
T44 : '-=' ;
T45 : '!=' ;
T46 : '+' ;
T47 : '-' ;
T48 : '/' ;
T49 : '%' ;
T50 : '++' ;
T51 : 'true' ;
T52 : 'TRUE' ;
T53 : 'false' ;
T54 : 'FALSE' ;
T55 : 'public' ;
T56 : 'private' ;
T57 : 'protected' ;
T58 : 'void' ;
T59 : '()' ;
T60 : ';' ;
T61 : 'immutable' ;
T62 : 'settable' ;
T63 : 'internal' ;
T64 : 'defaulted' ;
T65 : 'const' ;
T66 : ':' ;
T67 : 'glossary' ;
T68 : '{' ;
T69 : '}' ;
T70 : 'generate' ;
T71 : 'use' ;
T72 : 'namespace' ;
T73 : 'class' ;
T74 : 'isA' ;
T75 : ',' ;
T76 : 'interface' ;
T77 : 'association' ;
T78 : 'associationClass' ;
T79 : 'self' ;
T80 : '..' ;
T81 : 'before' ;
T82 : 'after' ;
T83 : 'key' ;
T84 : 'depend' ;
T85 : '.*' ;
T86 : 'statemachine' ;
T87 : 'as' ;
T88 : 'conc' ;
T89 : 'concurrent' ;
T90 : '|' ;
T91 : 'afterEvery' ;
T92 : '(' ;
T93 : ')' ;
T94 : 'wait' ;
T95 : 'do' ;
T96 : '[' ;
T97 : ']' ;
T98 : 'position' ;
T99 : 'position.association' ;
T100 : 'tracecase' ;
T101 : 'TraceUsing' ;
T102 : '?' ;
T103 : '||' ;
T104 : '&&' ;
T105 : '~' ;
T106 : '!' ;
T107 : 'static' ;
T108 : 'if' ;
T109 : 'else' ;
T110 : 'for' ;
T111 : 'while' ;
T112 : 'return' ;
T113 : 'break' ;
T114 : 'try' ;
T115 : 'catch' ;
T116 : 'function' ;
T117 : '.' ;
T118 : 'Java' ;
T119 : 'Php' ;
T120 : 'Ruby' ;
T121 : 'external' ;
T122 : 'singleton' ;
T123 : 'autounique' ;
T124 : 'unique' ;
T125 : '[]' ;
T126 : 'entry' ;
T127 : 'exit' ;
T128 : 'cflow' ;

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18760
RULE_RUBY_FUNCTION : RULE_DEF ( options {greedy=false;} : . )*RULE_END;

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18762
RULE_DEF : 'def';

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18764
RULE_END : 'end';

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18766
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18768
RULE_INT : ('0'..'9')+;

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18770
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18772
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18774
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18776
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../cruise.umple.xtext.ui/src-gen/cruise/umple/ui/contentassist/antlr/internal/InternalUmple.g" 18778
RULE_ANY_OTHER : .;


