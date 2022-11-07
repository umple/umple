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
    construct selfParam [list method_parameter]
        'self
    construct modifiedParams [list method_parameter]
        _ [translateParam each params]
    construct newParams [list method_parameter]
        selfParam [, modifiedParams] [changeKeyArgumentNames]
    by
        'def methodName '( newParams '):  statements 
            [manageSpecialTypes params] 
            [replaceStatements] 
            [changeKeyArgumentNameInNestedIdentifier] 
            [addFunctionImports]
end rule

rule replaceAbstractMethod
    replace [abstract_method_declaration]
        _[acess_modifier] _[nested_class] methodName [id] '( params [list method_parameter] ');
    construct selfParam [list method_parameter]
        'self
    construct modifiedParams [list method_parameter]
        _ [translateParam each params]
    construct newParams [list method_parameter]
        selfParam [, modifiedParams] [changeKeyArgumentNames]
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
    construct selfParam [list method_parameter]
        'self
    construct modifiedParams [list method_parameter]
        _ [translateParam each params]
    construct newParams [list method_parameter]
        selfParam [, modifiedParams] [changeKeyArgumentNames]
    by
        'def '__init__( newParams '):  
            statements 
                [addNoneAssignments each memberVariables] 
                [manageSpecialTypes params] 
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

%Rule replaces argument names that are illegal in python
rule changeKeyArgumentNames
    skipping [nested_class]
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
        root [changeKeyArgumentNames]  rep
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

function translateParam PreviousParam [method_parameter]
    replace [list method_parameter]
        SequenceSoFar [list method_parameter]
    construct translated [method_parameter]
        PreviousParam [translateRegularParam] [translateVarArgParam]
    by
        SequenceSoFar [, translated]
end function

function translateRegularParam
    replace [method_parameter]
        _ [nested_class] paramName [id]
    construct cleanName [id]
        paramName [changeKeyArgumentNames]
    by 
        cleanName
end function

function translateVarArgParam
    replace [method_parameter]
        _ [nested_class] '... paramName [id]
    construct cleanName [id]
        paramName [changeKeyArgumentNames]
    by
        '* cleanName
end function

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

function manageSpecialTypes params [list method_parameter]
    replace [repeat statement]
        stmts [repeat statement]
    construct possibleVarArgName [opt id]
        _ [extractVarArgName params]
    import listMemberVariables [repeat id]
    construct paramLists [repeat id]
        _ [extractListNameFromMethodParam each params]
    construct varArgRepeat [repeat id]
        _ [reparse possibleVarArgName]
    construct allDeclarations [repeat variable_declaration]
        _ [^ stmts]
    construct statementLists [repeat id]
        _ [extractListNameFromVariableDeclaration each allDeclarations]
    construct allLists [repeat id]
        _ [. listMemberVariables] [. paramLists] [. varArgRepeat] [. statementLists]
    by
        stmts
            [changeVarArgTypeToList possibleVarArgName]
            [addAsterixToVarArgInSuperInit possibleVarArgName]
            [replaceAllLists allLists]
            [addAsterixToInternalFuncCalls possibleVarArgName]

end function

rule addAsterixToInternalFuncCalls possibleVarArgName [opt id]
    replace $ [nested_identifier]
        funcName [id] '( args [list value+] ')
    deconstruct possibleVarArgName
        varArgName [id]
    construct zero [number]
        '0
    construct argsLength [number]
        zero [length args]
    construct lastArg [list value]
        args [tail argsLength]
    where
        lastArg [containsId varArgName]
    import classMethods [repeat method_declaration]
    where
        classMethods [doesMethodHaveVarArg funcName]
    construct argsLengthMinusOne [number]
        argsLength [- 1]
    construct allArgsButLast [list value]
        args [head argsLengthMinusOne]
    construct unpacked [value]
        '* varArgName
    by  
        funcName'( allArgsButLast [, unpacked] ')
end rule

rule doesMethodHaveVarArg seeking [id]
    match [concrete_method_declaration]
        _ [opt decorator] _ [acess_modifier] _ [opt static] _ [nested_class] methodName [id] '( params [list method_parameter] ') _ [opt throws] '{ _ [repeat statement] '}
    where
        seeking [= methodName]
    construct varArgs [repeat var_arg]
        _ [^ params]
    construct zero [number]
        '0
    construct varArgsLength [number]
        zero [length varArgs]
    where 
        varArgsLength [= 1]
end rule

function extractListNameFromVariableDeclaration decl [variable_declaration]
    replace [repeat id]
        results [repeat id]
    deconstruct decl
        'ArrayList< _ [id] '> listName [id] '= _ [value] ';
    by 
        results [. listName]
end function

function extractListNameFromMethodParam param [method_parameter]
    replace [repeat id]
        result [repeat id]
    deconstruct param
        'List< _ [id] '> paramName [id]
    by
        result [. paramName]
end function


rule addAsterixToVarArgInSuperInit possibleVarArgName [opt id]
    replace $ [function_call]
        'super( vals [list value] ')
    deconstruct possibleVarArgName
        varArgName [id]
    by 
        'super( vals [addAsterixOnMatch varArgName] ')
end rule

rule addAsterixOnMatch seeking [id]
    replace $ [value]
        identifier [id]
    where
        identifier [= seeking]
    by 
        '* identifier
end rule

function changeVarArgTypeToList possibleVarArgName [opt id]
    replace [repeat statement]
        stmts [repeat statement]
    deconstruct possibleVarArgName
        varArgName [id]
    construct newStatement [repeat statement]
        varArgName '= 'list( varArgName ')
    by
        newStatement [. stmts]
end function

function extractVarArgName params [list method_parameter]
    replace [opt id]
        res [opt id]
    construct varArgs [repeat var_arg]
        _ [^ params]
    construct zero [number]
        '0
    construct length [number]
        zero [length varArgs]
    where
        length [= 1]
    construct optVarArg [opt var_arg]
        _ [reparse varArgs]
    deconstruct optVarArg
        _ [nested_class] '... varArgName [id]
    by 
        varArgName
end function

% Multiple constructors
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
        'def '__init__( params [list method_parameter] '):  stmts [repeat statement]
    where not
        stmts [containConstructorWithSelfParam]
    construct paramsWithoutSelf [list method_parameter]
        params [tail 2]
    construct clsParam [list method_parameter]
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
        'def '__init__( params [list method_parameter] '):  stmts [repeat statement]
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

