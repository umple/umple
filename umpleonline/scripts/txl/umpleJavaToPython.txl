
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
