# How to use :
#   - Copy the File contents for Java.Grm, Python.Grm and umpleJavaToPython.txl in their respective triple quoted strings
#   - Run the file (the file will generate a oneline string that can be outputed to generate a file)
#   - copy the strings in cruise.umple/src/generators/Generator_CodePython.ump (generateTxlFiles function -> strings with Content)

javaGrmFile = """
comments
    //
    /*  */
end comments

%--------------------%
%     Statements     %
%--------------------%

keys
 return true false
end keys

define acess_modifier
        'private
    |   'public
    |   'protected
end define


define boolean_operators
        '&&
    |   '|'|
end define

define comparator
        '==
    |   '!=
    |   '>
    |   '<
    |   '>=
    |   '<=
end define

define arithmatic_operator
        '+
    |   '-
    |   '*
    |   '/
    |   '%
end define

define arithmatic_expression
        '( [arithmatic_expression]')
    |   [arithmatic_expression] [arithmatic_operator] [arithmatic_expression]
    | [value]
end define

define variable_name
    [id]
end define

define value
        [variable_name]
    |   [number]
    |   [function_call]
    |   [arithmatic_expression]
    |   [boolean_expression]
    |   [stringlit]
    |   'true
    |   'false
end define

define variable_declaration
        [opt acess_modifier] [id] [assignment]
    |   [opt acess_modifier] [id] [variable_name]';
end define

define assignment
        [variable_name] '= [value] '; [NL]
end define

define stmt_return
        'return [value] '; [NL]
end define

define statement
        [variable_declaration]
    |   [stmt_return]
    |   [conditional_block]
    |   [for_loop]
    |   [function_call]'; [NL]
    |   [assignment]
end define

define for_loop
    'for( [id] [id] ': [variable_name] ') [NL] '{ [NL] [IN] [repeat statement] [EX] '} [NL]
end define

define conditional_block
    [if] [repeat else_if] [opt else]
end define

define if 
    'if '( [boolean_expression] ') [NL]'{ [NL] [IN] [repeat statement] [EX] '} [NL]
end define

define else_if
    'else 'if '( [boolean_expression] ') [NL]'{ [NL] [IN] [repeat statement] [EX] '} [NL]
end define

define else
    'else [NL]'{ [NL] [IN] [repeat statement] [EX] '} [NL]
end define

define function_call
        [variable_name] [SPOFF] '. [id]'( [SPON] [list value]')
    |   [id] [SPOFF]'( [SPON][list value]')
end define

define boolean_expression
        '( [boolean_expression] ')
    |   [boolean_expression] [boolean_operator] [boolean_expression]
    |   '! [boolean_expression]
    |   [condition]
end define

define condition
        [value] [comparator] [value]
    |   [value]
end define

define method_parameter
    [id] [id]
end define

define method_declaration
        [acess_modifier] [id] [id] '( [list method_parameter] ') [NL] '{ [NL] [IN] [repeat statement] [EX] '} [NL]
    |   [acess_modifier] [id] [id] '( [list method_parameter] '); [NL]
end define


%--------------------%
%        Class       %
%--------------------%
define class_declaration
    [acess_modifier] [class_type] [id] [NL] '{ [NL] [IN] [class_body_decl] [EX] '} [NL]
end define

define class_type
        'class
    |   'interface
end define

define constructor
    [acess_modifier] [id]'( [list method_parameter] ') [NL] '{ [NL] [IN] [repeat statement] [EX] '} [NL]
end define

define member_variable_declaration
    [opt acess_modifier] [variable_declaration]
end define

define class_body_decl
    [repeat member_variable_declaration] [opt constructor] [repeat method_declaration]
end define
"""

pythonGrmFile = """
include "Java.Grm"


compounds 
    self.
end compounds 
redefine boolean_operator
    'and
    | 'or
end redefine


redefine variable_name
    ...
    |   'self._ [SPOFF] [id] [SPON]
end redefine
redefine assignment
    ...
    |   [variable_name] '= [value] [NL]
end redefine

redefine value
    ...
    | 'True
    | 'False
end redefine
redefine statement
    ...
    |   [function_call] [NL]
    | 'pass
end redefine

redefine stmt_return
    ...
    |   'return [value] [NL]
end redefine

redefine for_loop
    ...
    |'for( [id] 'in [variable_name] '): [NL] [IN] [repeat statement] [EX] [NL]
end redefine

redefine if 
    ... 
    |   'if [boolean_expression] ': [NL] [IN] [repeat statement] [EX] [NL]
end redefine

redefine else_if
    ...
    |   'elif [boolean_expression] ': [NL] [IN] [repeat statement] [EX] [NL]
end redefine

redefine else
    ...
    |   'else:  [NL] [IN] [repeat statement] [EX] [NL]
end redefine

redefine boolean_expression
    ...
    |   'not [boolean_expression]
end redefine

redefine method_parameter
    ...
    | [id]
end redefine

redefine method_declaration
    ...
    |   'def  [id] [SPOFF]'(self, [SPON] [list id] [SPOFF] '): [SPON] [NL] [IN] [repeat statement] [NL] [EX] [NL]
    |   'def  [id] [SPOFF]'(self): [SPON] [NL] [IN] [repeat statement] [NL] [EX] [NL]
end redefine

redefine constructor
    ...
    | 'def '__init__ [SPOFF] '(self, [SPON] [list id] [SPOFF]'): [SPON] [NL] [IN] [repeat statement] [NL] [EX] [NL]
    | 'def '__init__ [SPOFF] '(self): [SPON] [NL] [IN] [repeat statement] [NL] [EX] [NL]
end redefine

redefine class_declaration
    ... 
    | 'class [id] [SPOFF] ': [SPON] [NL] [IN] [class_body_decl] [NL] [EX] [NL]
end redefine

redefine class_body_decl
    ...
    | 'pass
    | [opt constructor] [repeat method_declaration]
end define

redefine variable_declaration
    ...
    |   [assignment] [FL]
    |   [variable_name]
end define

redefine function_call
    ...
    |   'self. [SPOFF] [id]'( [SPON][list value]')
end define
"""

umpleJavaToPython = """
include "Python.Grm"


%--------------------%
%     Top level      %
%--------------------%
function main
    replace [program] 
	P [program]
    by
	P [replaceClasses]
end function

define program
    [repeat class_declaration]
end define

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


function addMemberVariable MemberVariable [member_variable_declaration]
    replace [repeat id]
        SequenceSoFar [repeat id]
    deconstruct MemberVariable
        _[opt acess_modifier] decl [variable_declaration]
    deconstruct decl
        _ [id] memberName [id]';
    by
        SequenceSoFar [. memberName]
end function

rule replaceMemberVariableNames memberVariables [repeat id]
    replace [variable_name]
        name [variable_name]
    deconstruct name 
        id [id]
    where 
        memberVariables [contains id]
    by
        'self._ id
end rule

rule contains Object [id]
    match [id]
        Object
end rule



%--------------------%
%     Classes        %
%--------------------%
rule replaceClasses
    replace $ [class_declaration]
        _ [acess_modifier] _ [class_type] className [id] '{ classBody [class_body_decl] '} 
    by
    'class className ':  classBody [replaceClassBody] [replaceClassBodyNoConstructor]
end rule


function replaceClassBody
    replace [class_body_decl]
        declarations [repeat member_variable_declaration] oldConstructor [constructor] methods [repeat method_declaration]
    construct memberVariables [repeat id]
        _ [addMemberVariable each declarations]
    construct newContructor [constructor]
        oldConstructor [replaceMemberVariableNames memberVariables] [replaceContructor] [replaceContructorNoArgs]
    by
        newContructor methods  [replaceAllMethods memberVariables]
end function

function replaceClassBodyNoConstructor
    replace [class_body_decl]
        declarations [repeat member_variable_declaration] methods [repeat method_declaration]
    construct memberVariables [repeat id]
        _ [addMemberVariable each declarations]
    by
        'def __init__(self): 'raise 'NotImplementedError("The interface is not implemented") methods [replaceAllMethods memberVariables]
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
%     Methods        %
%--------------------%

function replaceAllMethods memberVariables [repeat id]
    replace [repeat method_declaration]
        methods [repeat method_declaration]
    by
        methods 
            [replaceMemberVariableNames memberVariables] 
            [replaceToString]
            [replaceAbstractMethod]
            [replaceAbstractMethodNoArgs]
            [replaceMethod] 
            [replaceMethodNoArgs]
            
end function

rule replaceMethod
    replace [method_declaration]
        _[acess_modifier] _[id] methodName [id]'( params [list method_parameter +] ') '{ statements [repeat statement] '}
    construct newParams [list id]
    by
        'def methodName '(self, newParams [translateParams each params] '):  statements [replaceStatements]
end rule

rule replaceMethodNoArgs
    replace [method_declaration]
        _[acess_modifier] _[id] methodName [id]'() '{ statements [repeat statement] '}
    by
        'def methodName '(self):  statements [replaceStatements]
end rule

rule replaceAbstractMethod
    replace [method_declaration]
        _[acess_modifier] _[id] methodName [id] '( params [list method_parameter +] ');
    construct newParams [list id]
    by
        'def methodName '(self, newParams [translateParams each params] '): 'raise 'NotImplementedError("The interface is not implemented")
end rule

rule replaceAbstractMethodNoArgs
    replace [method_declaration]
        _[acess_modifier] _[id] methodName [id]'();
    by
        'def methodName '(self): 'raise 'NotImplementedError("The interface is not implemented")
end rule

rule replaceToString
    replace [method_declaration]
        _[acess_modifier] _[id]  'toString '() '{ statements [repeat statement] '}
    by
        'def '__str__ '(self):  statements [replaceStatements]
end rule

%--------------------%
%     Statements     %
%--------------------%
function replaceStatements
    replace [repeat statement]
        statements [repeat statement]
    by 
        statements 
            [replaceAssignment] 
            [replaceReturn] 
            [replaceNoStateMents] 
            [addSelfToFunctionCalls]
            [replaceDecleration]
            [replaceDeclerationWithAssignment]
            [replaceTrue]
            [replaceFalse]
end function

function replaceNoStateMents
    replace [repeat statement]
        _ [empty]
    by 
        'pass
end function

rule replaceAssignment
    replace [assignment]
        name [variable_name] '= val [value] '; 
    by 
        name '= val
end rule

rule replaceReturn
    replace [stmt_return]
        'return val [value] ';
    by 
        'return val
end rule

rule addSelfToFunctionCalls
    replace [function_call]
        funcName [id]'( values [list value]')
    by
        'self. funcName '( values')
end rule

rule replaceDeclerationWithAssignment
    replace [variable_declaration]
        _ [id] assignment [assignment]
    by 
        assignment
end rule

rule replaceDecleration
    replace [variable_declaration]
        _[id] varName [variable_name]';
    by 
        varName
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
"""

formatted_output_1 = javaGrmFile.replace('\n', '\\n').replace('\t', '\\t').replace('\"', '\\"')
formatted_output_2 = pythonGrmFile.replace('\n', '\\n').replace('\t', '\\t').replace('\"', '\\"')
formatted_output_3 = umpleJavaToPython.replace('\n', '\\n').replace('\t', '\\t').replace('\"', '\\"')

print("\n----- Start of new file (Java.Grm) -----\n" + formatted_output_1 + "\n----- End of file (Java.Grm) -----\n")
print("\n----- Start of new file (Python.Grm) -----\n" + formatted_output_2 + "\n----- End of file (Python.Grm) -----\n")
print("\n----- Start of new file (umpleJavaToPython.txl) -----\n" + formatted_output_3 + "\n----- End of file (umpleJavaToPython.txl) -----\n")
