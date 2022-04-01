include "Python.Grm"


%--------------------%
%     Top level      %
%--------------------%
function main
    replace [program] 
	 _[repeat package_statement] 
     _[repeat import_statement]
     Classes [repeat class_declaration]
    by
	Classes
        [replaceConcreteClassesWithInheritance] 
        [replaceConcreteClassesNoInheritance]
        [replaceInterfacesWithInheritance]
        [replaceInterfacesNoInheritance]
        
end function

%--------------------%
%     Classes        %
%--------------------%
rule replaceConcreteClassesWithInheritance
    replace $ [concrete_class_declaration]
        _ [acess_modifier] 'class className [class_name] inheritances [repeat inheritance_list+] '{ classBody [class_body_decl] '} 
    construct inheritanceClasses [list class_name]
        _ [extractImportClasses each inheritances]
    construct imports [repeat import_statement]
        _ [addImportStatement each inheritanceClasses]
    by
    imports 'class className '( inheritanceClasses ')':  classBody  [replaceClassBody]
end rule

rule replaceConcreteClassesNoInheritance
    replace $ [concrete_class_declaration]
        _ [acess_modifier] 'class className [class_name] '{ classBody [class_body_decl] '} 
    by
    'class className ':  classBody  [replaceClassBody]
end rule


function extractImportClasses inheritanceList [inheritance_list]
    replace [list class_name]
        classes [list class_name]
    deconstruct inheritanceList
        _[inheritance_statement] classesToAdd [list class_name]
    by
        classes [, classesToAdd] 
end function

function addImportStatement a [class_name]
    replace [repeat import_statement]
        imports [repeat import_statement]
    construct newImport [import_statement]
        'from a 'import a
    by
        imports [. newImport]
end function

rule replaceInterfacesNoInheritance
    replace [interface_declaration]
        _ [acess_modifier] 'interface className [class_name] '{ classBody [class_body_decl] '} 
    by
        'from 'abc 'import 'ABC, 'abstractmethod 'class className '(ABC):  classBody [replaceClassBody] [replaceInterfaceBody]
end rule

rule replaceInterfacesWithInheritance
    replace [interface_declaration]
        _ [acess_modifier] 'interface className [class_name] inheritances [repeat inheritance_list+] '{ classBody [class_body_decl] '} 
    construct inheritanceClasses [list class_name]
        _ [extractImportClasses each inheritances]
    construct imports [repeat import_statement]
        _ [addImportStatement each inheritanceClasses]
    by
        'from 'abc 'import 'ABC, 'abstractmethod imports 'class className '(ABC, inheritanceClasses '):  classBody [replaceClassBody] [replaceInterfaceBody]
end rule

function replaceInterfaceBody
   replace [class_body_decl]
        declarations [repeat member_variable_declaration] methods [repeat method_declaration]
    construct memberVariables [repeat id]
        _ [addMemberVariable each declarations]
    construct listMemberVariables [repeat id]
        _ [addListMemberVariable each declarations]
    by
        '@abstractmethod 'def '__init__(self): 'pass methods [replaceAllMethods memberVariables listMemberVariables]
end function

function replaceClassBody
    replace [class_body_decl]
        declarations [repeat member_variable_declaration] oldConstructor [constructor] methods [repeat method_declaration]
    construct memberVariables [repeat id]
        _ [addMemberVariable each declarations]
    construct listMemberVariables [repeat id]
        _ [addListMemberVariable each declarations]
    construct newContructor [constructor]
        oldConstructor 
            [replaceAllLists listMemberVariables]
            [replaceAllMemberVariableNames memberVariables] 
            [replaceContructor] 
            [replaceContructorNoArgs]
    by
        newContructor methods [replaceAllMethods memberVariables listMemberVariables]
end function


function replaceContructor
    replace [constructor]
         mod [acess_modifier] className [id]'( params [list method_parameter +] ') '{ statements [repeat statement]  '}
    construct newParams [list id]
    by
        'def '__init__(self, newParams [translateParams each params]'):  statements [replaceStatements]
end function

function replaceContructorNoArgs
    replace [constructor]
         mod [acess_modifier] className [id]'() '{ statements [repeat statement]  '}
    by
        'def '__init__(self):  statements [replaceStatements]
end function


%--------------------%
%     General        %
%--------------------%
function translateParams PreviousParam [method_parameter]
    replace [list id]
        SequenceSoFar [list id]
    deconstruct PreviousParam
        _ [id] paramName [id]
    by
        SequenceSoFar [, paramName]
end function

function addListMemberVariable MemberVariable [member_variable_declaration]
    replace [repeat id]
        SequenceSoFar [repeat id]
    deconstruct MemberVariable
        _[opt acess_modifier] decl [variable_declaration]
    deconstruct decl
        'List '< _ [list id] '> memberName [id]';
    by
        SequenceSoFar [. memberName]
end function

function addMemberVariable MemberVariable [member_variable_declaration]
    replace [repeat id]
        SequenceSoFar [repeat id]
    deconstruct MemberVariable
        _[opt acess_modifier] decl [variable_declaration]
    deconstruct decl
        _ [class_name] memberName [id]';
    by
        SequenceSoFar [. memberName]
end function

function replaceAllMemberVariableNames memberVariables [repeat id]
    replace [any]
        any [any]
    by 
        any 
            [replaceMemberVariableNames memberVariables] 
            [replaceMemberVariableNamesWithThis memberVariables]
            [replaceMemberVariableNamesBrackets memberVariables]
end function

rule replaceMemberVariableNames memberVariables [repeat id]
    replace [nested_identifier]
         name [id] rep [repeat attribute_access]
    where 
        memberVariables [contains name]
    construct underscore [id]
        '_
    construct newName [id]
        underscore [+ name] 
    by
        'self '. newName rep
end rule

rule replaceMemberVariableNamesWithThis memberVariables [repeat id]
    replace [nested_identifier]
        'this '. name [id] rep [repeat attribute_access]
    where 
        memberVariables [contains name]
    construct underscore [id]
        '_
    by
        'self '. underscore [+ name] rep
end rule

rule replaceMemberVariableNamesBrackets memberVariables [repeat id]
    replace [nested_identifier]
         name [id] '[ val [value] ']  rep [repeat attribute_access]
    where 
        memberVariables [contains name]
    construct underscore [id]
        '_
    construct newName [id]
        underscore [+ name]
    by
        'self '. newName '[ val ']  rep
end rule


rule contains Object [id]
    match [id]
        Object
end rule


%--------------------%
%  List replacement  %
%--------------------%

function replaceAllLists memberLists [repeat id]
    replace [any]
        any [any]
    by 
        any
            [replaceListAssignement memberLists]
            [replaceListUnmutable memberLists]
            [replaceGetListContent memberLists]
            [replaceListGetSize memberLists]
            [replaceListGetIndex memberLists]
            [replaceListContains memberLists]
            [replaceListAddAtIndex memberLists]
            [replaceListAddNoIndex memberLists]
            [replaceListCopy]
end function 

rule replaceListAssignement memberLists [repeat id]
    replace [assignment]
        id [id] '= 'new 'ArrayList '< _[list id] '> '(') 
    where
        memberLists [contains id]
    by 
        id '= '[']
end rule

rule replaceListCopy
    replace [assignment]
        id [id] '= 'new 'ArrayList '< _[list id] '> '( oldList [nested_identifier]') 
    deconstruct oldList
        val [nestable_value] rep [repeat attribute_access]
    construct newNested [repeat attribute_access]
        '.copy()
    by 
        id '= val rep [. newNested]
end rule

rule replaceListUnmutable memberLists [repeat id]
    replace [value]
        'Collections.unmodifiableList( id [id] ')
    where
        memberLists [contains id]
    by 
        'tuple( id ')
end rule


rule replaceGetListContent memberLists [repeat id]
    replace [nested_identifier]
        id [id] '. 'get( index [value] ')  rest [repeat attribute_access]
    where
        memberLists [contains id]
    by 
        id '[ index '] rest 
end rule

rule replaceListGetSize memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.size()
    where
        memberLists [contains id]
    by 
        'len( id ')
end rule

rule replaceListGetIndex memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.indexOf( val [value] ')
    where
        memberLists [contains id]
    by 
        id '.index( val ')
end rule

rule replaceListContains memberLists [repeat id]
    replace [value]
        nested [nested_identifier]
    deconstruct nested
        id [id]'. 'contains '( val [value_no_recursion] ')
    where
        memberLists [contains id]
    by 
        val 'in id
end rule

rule replaceListAddAtIndex memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.add( position [value] ', value [value] ')
    where
        memberLists [contains id]
    by 
        id '.insert( position ', value ')
end rule

rule replaceListAddNoIndex memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.add( value [value] ')
    where
        memberLists [contains id]
    by 
        id '.append( value ')
end rule

%--------------------%
%     Methods        %
%--------------------%

function replaceAllMethods memberVariables [repeat id] memberLists [repeat id]
    replace [repeat method_declaration]
        methods [repeat method_declaration]
    by
        methods 
            [replaceAllLists memberLists]
            [replaceAllMemberVariableNames memberVariables] 
            [replaceToString]
            [replaceAbstractMethod]
            [replaceAbstractMethodNoArgs]
            [replaceConcreteMethod] 
            [replaceConcreteMethodNoArgs]
            [replaceStaticMethod]
end function

rule replaceConcreteMethod
    replace [concrete_method_declaration]
        _[acess_modifier] _[class_name] methodName [id]'( params [list method_parameter +] ') '{ statements [repeat statement] '}
    construct newParams [list id]
    by
        'def methodName '(self, newParams [translateParams each params] '):  statements [replaceStatements]
end rule

rule replaceConcreteMethodNoArgs
    replace [concrete_method_declaration]
        _[acess_modifier] _[class_name] methodName [id]'() '{ statements [repeat statement] '}
    by
        'def methodName '(self):  statements [replaceStatements]
end rule

rule replaceAbstractMethod
    replace [abstract_method_declaration]
        _[acess_modifier] _[class_name] methodName [id] '( params [list method_parameter +] ');
    construct newParams [list id]
    by
        '@abstractmethod 'def methodName '(self, newParams [translateParams each params] '): 'pass
end rule

rule replaceAbstractMethodNoArgs
    replace [abstract_method_declaration]
        _[acess_modifier] _[class_name] methodName [id]'();
    by
        '@abstractmethod 'def methodName '(self): 'pass
end rule


rule replaceToString
    replace [method_declaration]
        _[acess_modifier] _[class_name]  'toString '() '{ statements [repeat statement] '}
    by
        'def '__str__ '(self):  statements [replaceStatements]
end rule

rule replaceStaticMethod
    replace [method_declaration]
        _[acess_modifier] _[static] _[class_name] methodName [id]'() '{ statements [repeat statement] '}
    by
        '@staticmethod 'def methodName'():  statements [replaceStatements]
end rule

%--------------------%
%     Statements     %
%--------------------%
function replaceStatements
    replace [repeat statement]
        statements [repeat statement]
    by 
        statements 
            [replaceForLoop]
            [replaceForInLoop]
            [replaceAssignmentStatement] 
            [replaceReturn] 
            [replaceNoStateMents] 
            [addSelfToOwnMethodCalls]
            [replaceThisFunctionCall]
            [replaceNestedStatement]
            [replaceDecleration]
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
end function


function replaceNoStateMents
    replace [repeat statement]
        _ [empty]
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


rule replaceWhile
    replace [while_loop]
        'while( bool [boolean_expression] ')  '{ statements [repeat statement] '} 
    by
        'while bool ':  statements 
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

%---------------------%
% Boolean expressions %
%---------------------%

function replaceAllBoolean
    replace [repeat statement]
        statements [repeat statement]

    by
        statements
            [replaceNullCheck]
            [replaceNotNullCheck]
            [replaceBoolNegation]
            [replaceBoolAnd]
            [replaceBoolOr]
            [replaceTrue]
            [replaceFalse]
            [replaceClassMatchCheck]
end function

rule replaceNullCheck
    replace [condition]
        elem [value_no_recursion] '== 'null
    by 
        elem 'is 'None
end rule

rule replaceNotNullCheck
    replace [boolean_expression]
        cond [condition]
    deconstruct cond
        elem [value_no_recursion] '!= 'null
    by 
        'not '( elem 'is 'None ')
end rule

rule replaceBoolNegation
    replace [value_no_recursion]
        '! expr [boolean_expression]
    by 
        'not expr
end rule

rule replaceBoolAnd
    replace [boolean_operator]
        '&&
    by 
        'and
end rule

rule replaceBoolOr
    replace [boolean_operator]
        '|'|
    by 
        'or
end rule

rule replaceTrue
    replace [value]
        'true
    by 
        'True
end rule

rule replaceFalse
    replace [value]
        'false
    by 
        'False
end rule

rule replaceClassMatchCheck
    replace [boolean_expression]
        'getClass().equals( id2 [id] '.getClass())
    by  
        'type(self) 'is 'type( id2 ')
end rule
