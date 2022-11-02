%--------------------%
%     Methods        %
%--------------------%

function replaceAllMethods memberVariables [repeat id]
    replace [repeat class_body_element]
        elems [repeat class_body_element]
    by
        elems
            [replaceConstructor memberVariables]
            [fixMultipleConstructors]
            [removeOverrideDecorator]
            [replaceToString]
            [replaceAbstractMethod]
            [replaceConcreteMethod]
            [replaceStaticMethod]
            [addGetState]
end function

rule removeOverrideDecorator
    replace [opt decorator]
        '@Override
    by 
        _
end rule

rule replaceConcreteMethod
    replace [concrete_method_declaration]
        _[acess_modifier] _[nested_class] methodName [id]'( params [list method_parameter] ') _ [opt throws] '{ statements [repeat statement] '}
    construct selfParam [list id]
        'self
    construct newParams [list id]
        _ [translateParams each params]
    by
        'def methodName '( selfParam [, newParams] '):  statements [replaceStatements] [changeKeyArgumentNameInNestedIdentifier] [addFunctionImports]
end rule

rule replaceAbstractMethod
    replace [abstract_method_declaration]
        _[acess_modifier] _[nested_class] methodName [id] '( params [list method_parameter] ');
    construct selfParam [list id]
        'self
    construct newParams [list id]
        _ [translateParams each params]
    by
        '@abstractmethod 'def methodName '( selfParam [, newParams] '): 'pass
end rule

rule replaceToString
    replace [method_declaration]
        _[acess_modifier] _[nested_class]  'toString '() _ [opt throws] '{ statements [repeat statement] '}
    by
        'def '__str__ '(self):  statements [replaceStatements] [targetToStringArithmatic]
end rule

rule targetToStringArithmatic
    replace $ [arithmatic_expression]
        root [value_no_recursion] rep [repeat arithmatic_continuation+]
    by
        root rep [addStrIfNeeded]
end rule

rule addStrIfNeeded
    skipping [arithmatic_expression]
    replace $ [arithmatic_continuation]
        '+ val [value_no_recursion]
    where not
        val [isString]
    by
        '+ 'str( val ')
end rule

function isString
    match [value_no_recursion]
        _ [stringlit]
end function

rule replaceStaticMethod
    replace [method_declaration]
        _[acess_modifier] _[static] _[nested_class] methodName [id]'() _ [opt throws] '{ statements [repeat statement] '}
    by
        '@staticmethod 'def methodName '():  statements [replaceStatements] [changeKeyArgumentNameInNestedIdentifier]
end rule

rule replaceConstructor memberVariables [repeat id]
    replace [constructor]
         mod [acess_modifier] className [id]'( params [list method_parameter] ') _ [opt throws] '{ statements [repeat statement]  '}
    construct selfParam [list id]
        'self
    construct modifiedParams [list id]
        _ [translateParams each params]
    by
        'def '__init__( selfParam [, modifiedParams] '):  
            statements 
                [addNoneAssignments each memberVariables] 
                [replaceStatements] 
                [changeKeyArgumentNameInNestedIdentifier]
                [addFunctionImports]
end rule


function addGetState
    replace [repeat class_body_element]
        rep [repeat class_body_element]
    import transientMembers [repeat id]
    construct transientCount [number]
        _ [length transientMembers]
    where 
        transientCount [> 0]
    construct stateDeclaration [repeat statement]
        'state '= 'dict(self '.__dict__ ')
    construct pops [repeat statement]
        _ [createGetStatePop each transientMembers]
    construct returnStatement [statement]
        'return 'state
    construct getStateStatements [repeat statement]
        stateDeclaration [. pops] [.returnStatement]
    construct getStateFunc [class_body_element]
        'def '__getstate__(self):
            getStateStatements
    by
        rep [. getStateFunc]
end function

function createGetStatePop id [id]
    replace [repeat statement] 
        result [repeat statement] 
    construct memberAsString [stringlit]
        _ [unparse id]
    construct underscore [stringlit]
        "_"
    construct memberAsStringWithUnderscore [stringlit]
        underscore [+ memberAsString]
    construct pop [statement]
        'state '.pop( memberAsStringWithUnderscore ')
    by
        result [. pop]
end function

function translateParams PreviousParam [method_parameter]
    replace [list id]
        SequenceSoFar [list id]
    deconstruct PreviousParam
        _ [nested_class] paramName [id]
    construct cleanName [id]
        paramName [changeKeyArgumentName]
    by
        SequenceSoFar [, cleanName]
end function

rule changeKeyArgumentName
    replace $ [id]
        argName [id]
    by  
        argName
            [replaceInKeyArgument]
end rule

rule changeKeyArgumentNameInNestedIdentifier
    replace $ [nested_identifier]
        root [id] rep [repeat attribute_access]
    by 
        root [changeKeyArgumentName]  rep
end rule

rule replaceInKeyArgument
    replace [id]
        'in
    by 
        'input
end rule


function addNoneAssignments memberVariable [id]
    replace [repeat statement]
        stmts [repeat statement]
    construct noneAssignment [repeat statement]
        memberVariable '= 'None
    by
        noneAssignment [. stmts]
end function



function fixMultipleConstructors 
    replace [repeat class_body_element]
        rep [repeat class_body_element]
    import constructorCount [number]
    where
        constructorCount [> 1]
    by
        rep [replaceExtraConstructorNoArgs] 
        [replaceOneToOneConstructor]
        [replaceOneToOneConstructorCall]
        [targetRemainingConstructor]
end function


rule replaceExtraConstructorNoArgs
    replace [class_body_element]
        'def '__init__(self):  stmts [repeat statement]
    construct newConstructorStatements [repeat statement]
        'self '= 'cls.__new__(cls)
    construct returnStatement [statement]
        'return 'self
    by 
        '@classmethod 'def 'alternateConstructor(cls): newConstructorStatements [. stmts] [. returnStatement]
end rule

rule replaceOneToOneConstructor
    replace [class_body_element]
        'def '__init__( params [list id] '):  stmts [repeat statement]
    where not
        stmts [containConstructorWithSelfParam]
    construct paramsWithoutSelf [list id]
        params [tail 2]
    construct clsParam [list id]
        'cls
    construct newConstructorStatements [repeat statement]
        'self '= 'cls.__new__(cls)
    construct returnStatement [statement]
        'return 'self
    by 
        '@classmethod 'def 'alternateConstructor( clsParam [, paramsWithoutSelf] '): newConstructorStatements [. stmts] [. returnStatement]
end rule

rule targetRemainingConstructor
    replace $ [class_body_element]
        'def '__init__( params [list id] '):  stmts [repeat statement]
    where
        stmts [containConstructorWithSelfParam]
    by 
        'def '__init__( params '):  stmts [replaceOneToOneConstructorCall]
end rule

rule replaceOneToOneConstructorCall
    replace $ [value] 
        call [function_call]
    where 
        call [containConstructorWithSelfParam]
    deconstruct call
        className [id] '( args [list value] ')
    by
        className '. 'alternateConstructor( args ')
end rule

rule containConstructorWithSelfParam
    match [function_call]
        name [id] '( params [list value]')
    import possibleFunctionImports [repeat id]
    where
        possibleFunctionImports [containsId name]
    where   
        params [containsSelfValue]
end rule

rule containsSelfValue
    skipping [nested_identifier]
    match [value]
        'self
end rule

function addFunctionImports
    replace [repeat statement]
        stmts [repeat statement]
    import possibleFunctionImports [repeat id]
    by
        stmts [addFunctionImport each possibleFunctionImports]
end function

function addFunctionImport seeking [id]
    replace [repeat statement]
        stmts [repeat statement]
    where 
        stmts [containsId seeking]
    construct imp [import_statement]
        'from seeking 'import seeking
    construct funcImport [repeat statement]
        imp
    by
        funcImport [. stmts]
end function