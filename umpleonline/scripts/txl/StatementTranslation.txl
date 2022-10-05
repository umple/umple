%--------------------%
%     Statements     %
%--------------------%
function replaceStatements
    replace [repeat statement]
        statements [repeat statement]
    by 
        statements
            [reorderNestedIdentifier]
            [replaceSwitchCase]
            [addClassPrefixToEnum]
            [replaceForLoop]
            [replaceForInLoop]
            [replaceAssignmentStatement] 
            [replaceReturn] 
            [replaceNoStatements] 
            [addSelfToOwnMethodCalls]
            [replaceThisFunctionCall]
            [replaceNestedStatement]
            [replaceDecleration]
            [replaceTernary]
            [replaceAllBoolean]
            [replaceDeclerationWithAssignment]
            [replaceIf]
            [replaceElseIf]
            [replaceElse]
            [replaceWhile]
            [replaceNull]
            [replaceThis]
            [replaceIncrement]
            [replaceDecrement]
            [replaceThrowError]
            [replaceNewCall]
            [replaceCasting]
            [correctSuperInit]
            [correctSuperFunctions]
            [replaceSuperToString]
            [replaceNewLine]
            [replaceHexIdentity]
end function

function replaceNoStatements
    replace [repeat statement]
    by 
        'pass  
end function

rule replaceAssignmentStatement
    replace [statement]
        identifier [nested_identifier] '= val [value] '; 
    by 
        identifier '= val
end rule

rule replaceReturn
    replace [stmt_return]
        'return val [value] ';
    by 
        'return val
end rule

rule addSelfToOwnMethodCalls
    replace [nested_identifier]
        funcName [id] '( values [list value]') rep [repeat attribute_access]
    where
        funcName [~= 'str]
    by
        'self '. funcName '( values') rep
end rule

rule replaceThisFunctionCall
    replace [nested_identifier]
        'this. funcName [id] '( values [list value]')
    by
        'self '. funcName '( values')
end rule

rule replaceNestedStatement
    replace [statement]
        stmt [statement]
    deconstruct stmt
        value [nested_identifier] ';
    by
        value
end rule


rule replaceThis
    replace [value]
        'this
    by 
        'self
end rule

rule replaceDeclerationWithAssignment
    replace [variable_declaration]
        _ [class_name] assignment [assignment] ';
    by 
        assignment
end rule

rule replaceDecleration
    replace [variable_declaration]
        _[class_name] varName [id]';
    by 
        varName 
end rule

rule replaceIf
    replace [if]
        'if '( bool [value] ') '{ statements [repeat statement]  '}
    by 
        'if bool ': statements
end rule

rule replaceElseIf
    replace [else_if]
        'else 'if '( bool [value] ') '{  statements [repeat statement]  '} 
    by 
        'elif bool ': statements
end rule


rule replaceElse
    replace [else]
        'else '{  statements [repeat statement]  '} 
    by 
        'else ': statements
end rule


rule replaceTernary
    replace [ternary]
        condition [value_no_recursion] '? opt1 [value] ': opt2 [value]
    by
        '( opt1 ') 'if condition 'else opt2
end rule

rule replaceWhile
    replace [while_loop]
        'while( val [value] ')  '{ statements [repeat statement] '} 
    by
        'while val ':  statements 
end rule

rule replaceNull
    replace [value]
        'null
    by
        'None
end rule


rule replaceDecrement
    replace [assignment]
        nest [nestable_value] '--
    construct test [arithmatic_expression]
        nest '- '1
    by 
        nest '= test
end rule

rule replaceIncrement
    replace [assignment]
        nest [nestable_value] '++
    by 
        nest '= nest '+ '1
end rule

rule replaceForLoop
    replace [statement]
        'for( decl [variable_declaration] goal [value]'; assignment [assignment]') '{  stmts[repeat statement]  '} 
    deconstruct decl
        _[class_name] name [id] '= start [value] ';
    construct declaration [variable_declaration]
        name '= start
    construct newStatements [repeat statement]
        assignment
    by 
        declaration 'while goal ':  stmts  [. newStatements]
end rule

rule replaceForInLoop
    replace [for_in_loop]
        'for( _[class_name] var [id] ': nested [nested_identifier]')'{ stmts [repeat statement] '} 
    by 
        'for var 'in  nested':  stmts
end rule

rule replaceThrowError
    replace [throw_statement]
        'throw 'new _[id] '( message [stringlit] ');
    by
        'raise 'RuntimeError(  message ') 
end rule 

rule replaceCasting
    replace [value]
        '( _ [class_name]') name [nested_identifier]
    by 
        name 
end rule

rule replaceNewCall
    replace [value]
        'new class [class_name] '( vals [list value] ')
    deconstruct class
        id [id]
    by
        id '( vals ')
end rule

rule correctSuperInit
    replace [nested_identifier]
        'super( params [list value] ')
    by
        'super().__init__( params ')
end rule

rule correctSuperFunctions
    replace [nested_identifier]
        'super rep [repeat attribute_access]
    by
        'super() rep
end rule

rule replaceSuperToString
    replace [nested_identifier]
        'super().toString() rep [repeat attribute_access]
    by
        'super().__str__() rep
end rule

rule replaceNewLine
    replace [nested_identifier]
        'System.getProperties().getProperty("line.separator")
    by
        'os.linesep
end rule 

rule replaceHexIdentity
    replace [nested_identifier]
        'Integer.toHexString(System.identityHashCode( val [value_no_recursion] '))
    by
        'format( 'id( val '), '"x")
end rule

rule replaceSwitchCase
    replace [switch_case]
        'switch( val [value] ') '{ cases [repeat switch_case_case]  default [opt switch_case_default] '}
    by
        'match val ': cases [replaceSwitchCaseCase]  default [replaceSwitchCaseDefault]
end rule

rule replaceSwitchCaseCase
    replace [switch_case_case]
        'case val [value] ': stmts [repeat statement] 'break;
    by
        'case val [fixEnumValueWithNoEnum] ': stmts [replaceNoStatements]
end rule

rule replaceSwitchCaseDefault
    replace [switch_case_default]
        'default ': stmts [repeat statement]
    by
        'case 'default ': stmts [replaceNoStatements]
end rule

rule fixEnumValueWithNoEnum
    replace $ [value]
        val [value]
    deconstruct val
        _ [id]
    import enumeratorDeclerations [repeat enum_declaration]
    by
        val [fixEnumValueWithNoEnumCheck each enumeratorDeclerations]
end rule

rule fixEnumValueWithNoEnumCheck enum [enum_declaration]
    replace [value]
        identifier [id]
    deconstruct enum 
        _ [opt acess_modifier] 'enum enumName [id] '{ vals [list id]'}
    where
        identifier [= each vals]
    by
        enumName '. identifier
end rule

rule addClassPrefixToEnum
    replace [nested_identifier]
        enumName [id] '.  enumVal [id]
    where
        enumName [isAnEnum]
    import className [class_name]
    construct test [id]
        enumName
    by
        className '. enumName '. enumVal [debug]
end rule

function isAnEnum
    match [id]
        name [id]
    import enumeratorDeclerations [repeat enum_declaration]
    where
        name [isSpecificEnum each enumeratorDeclerations]
end function

function isSpecificEnum enum [enum_declaration]
    match [id]
        name [id]
    deconstruct enum    
        _ [opt acess_modifier] 'enum enumName [id] '{ _ [list id]'}
    where
        name [= enumName]
end function
%--------------------------------%
%  Nested Identifier reordering  %
%--------------------------------%

rule reorderNestedIdentifier
    replace [nested_identifier]
        nested [nested_identifier]
    construct seeking [attribute_access]
        '.toString()
    where 
        nested [containsAttributeAccess seeking]
    by
        nested [reorderToString]
end rule

function reorderToString
    replace [nested_identifier]
        nested [nested_identifier]
    construct funcName [id]
        'str
    construct seeking [attribute_access]
        '.toString()
    by
        nested [reorderSpecific seeking funcName]
end function

function reorderSpecific seeking [attribute_access] funcName [id]
    replace [nested_identifier]
        nested [nested_identifier]
    deconstruct nested
        root [nestable_value] rep [repeat attribute_access]
    where 
        nested [containsAttributeAccess seeking]
    construct zero [number]
        '0 
    construct count [number]
        zero [findCount seeking rep]
    by
        nested [swap count funcName]
end function

function findCount seeking [attribute_access] rep [repeat attribute_access]
    replace [number]
        count [number]
    construct repLength [number]
        _ [length rep]
    construct head [repeat attribute_access]
        rep [head 1]
    where 
        repLength [> 0]
    construct remaining [repeat attribute_access]
        rep [tail 2]
    where not
        head [containsAttributeAccess seeking] 
    by
        count [+ 1] [findCount seeking remaining]
end function

function swap count [number] funcName [id]
    replace [nested_identifier]
        root [nestable_value] rep [repeat attribute_access]
    construct before [repeat attribute_access]
        rep [head count]
    construct countWithSkip [number]
        count [+ 2]
    construct after [repeat attribute_access]
        rep [tail countWithSkip]
    by
        funcName '( root before ') after
end function

rule containsAttributeAccess seeking [attribute_access]
    match [attribute_access]
        seeking
end rule


