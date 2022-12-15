%--------------------%
%     Methods        %
%--------------------%

function replaceAllMethods memberVariables [repeat id]
    replace [repeat class_body_element]
        elems [repeat class_body_element]
    construct filtered [repeat class_body_element]
        _ [filterOutFunctions each elems]
    by
        filtered
            [replaceConstructor memberVariables]
            [fixMultipleConstructors]
            [removeOverrideDecorator]
            [removeSurpressWarningDecorator]
            [replaceAbstractMethod]
            [replaceUserMethod]
            [replaceConcreteMethod]
            [addGetState]
            [addDisambiguationMethods]
end function

rule removeOverrideDecorator
    replace [opt decorator]
        '@Override
    by 
        _
end rule

rule removeSurpressWarningDecorator
    replace [opt decorator]
        '@SuppressWarnings( _ [list base_value] ')
    by 
        _
end rule

rule replaceConcreteMethod
    replace [concrete_method_declaration]
        _[acess_modifier] possibleStatic [opt static] _[nested_identifier] methodName [id]'( params [list method_parameter] ') _ [opt throws] '{ statements [repeat statement] '}
    construct newParams [list method_parameter]
        _ [getPythonParams params possibleStatic]
    construct possibleStaticDecorator [repeat decorator]
        _ [createStaticDecorator possibleStatic]
    by
        possibleStaticDecorator 'def methodName [replaceSpecificMethodNames] [changeOverloadedMethodName params] '( newParams '):  statements 
            [manageSpecialTypes params] 
            [replaceStatements] 
            [changeKeyArgumentNameInNestedIdentifier] 
            [addFunctionImports]
            [addStrIfNeeded methodName]
end rule

function createStaticDecorator possibleStatic [opt static]
    replace [repeat decorator]
        result [repeat decorator]
    deconstruct possibleStatic
        _ [static]
    construct staticDecorator [decorator]
        '@staticmethod
    by
        result [. staticDecorator]
end function

rule replaceAbstractMethod
    replace [abstract_method_declaration]
        _[acess_modifier] _ [opt 'abstract] _[nested_identifier] methodName [id] '( params [list method_parameter] ');
    construct empty [opt static]
        _
    construct newParams [list method_parameter]
        _ [getPythonParams params empty]
    by
        '@abstractmethod 'def methodName [replaceSpecificMethodNames] '( newParams '): 'pass
end rule

rule replaceUserMethod
    replace [concrete_method_declaration]
        _[acess_modifier] possibleStatic [opt static] _[nested_identifier] methodName [id]'( params [list method_parameter] ') _ [opt throws] '{ _ [repeat statement] content [usercode] _[repeat statement] '}
    construct newParams [list method_parameter]
        _ [getPythonParams params possibleStatic]
    construct possibleStaticDecorator [repeat decorator]
        _ [createStaticDecorator possibleStatic]
    by
        possibleStaticDecorator 'def methodName '( newParams '):  content 
end rule

function getPythonParams javaParams [list method_parameter] possibleStatic [opt static]
    replace [list method_parameter]
        _ [list method_parameter]
    construct selfParam [list method_parameter]
        _ [addSelfIfNotStatic possibleStatic]
    construct modifiedParams [list method_parameter]
        _ [translateParam each javaParams]
    by
        selfParam [, modifiedParams] [changeKeyArgumentNames]
    
end function 

function addSelfIfNotStatic possibleStatic [opt static]
    replace [list method_parameter]
        result [list method_parameter]
    deconstruct possibleStatic
        _ [empty]
    construct selfParam [method_parameter]
        'self
    by 
        result [, selfParam]
end function

function replaceSpecificMethodNames
    replace [id]
        funcName [id]
    by
        funcName
            [replaceToStringMethodName]
            [replaceHashCodeMethodName]
end function

function replaceToStringMethodName
    replace [id]
        'toString
    by
        '__str__
end function

function replaceHashCodeMethodName
    replace [id]
        'hashCode
    by
        '__hash__
end function

rule addStrIfNeeded functionName [id]
    where functionName [= 'toString]
    skipping [parentheses_value]
    replace $ [value]
        baseVal [base_value] cont [value_continuation]
    where not
        baseVal [isString]
    by
        'str( baseVal ') cont
end rule

function isString
    match [base_value]
        _ [stringlit]
end function

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
    skipping [nested_identifier]
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
        _ [nested_identifier] paramName [id]
    construct cleanName [id]
        paramName [changeKeyArgumentNames]
    by 
        cleanName
end function

function translateVarArgParam
    replace [method_parameter]
        _ [nested_identifier] '... paramName [id]
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
        _ [extractListNameFromMethodParam each params] [extractArrayListListNameFromMethodParam each params]
    construct paramArrays [repeat id]
        _ [extractArrayNameFromMethodParam each params]
    construct varArgRepeat [repeat id]
        _ [reparse possibleVarArgName]
    construct allDeclerations [repeat statement]
        _ [extractDeclarationFromStatement each stmts]
    construct statementLists [repeat id]
        _ [extractListNameFromVariableDeclaration each allDeclerations]
    construct allLists [repeat id]
        _ [. listMemberVariables] [. paramLists] [. paramArrays] [. varArgRepeat] [. statementLists]
    import dictMemberVariables [repeat id]
    construct allHashMaps [repeat id]
        _ [extractHashMapNameFromVariableDeclaration each allDeclerations] [. dictMemberVariables]
    by
        stmts
            [changeVarArgTypeToList possibleVarArgName]
            [addAsterixToVarArgInSuperInit possibleVarArgName]
            [replaceAllSpecialTypes allLists allHashMaps]
            [addAsterixToInternalFuncCalls allLists]

end function

function extractDeclarationFromStatement stmt [statement]
    replace [repeat statement]
        result [repeat statement]
    deconstruct stmt
        _ [value] _ [value] ';
    by
        result [. stmt]
end function

rule addAsterixToInternalFuncCalls allIterables [repeat id]
    replace $ [nested_identifier]
        funcName [id] '( args [list value+] ')
    construct zero [number]
        '0
    construct argsLength [number]
        zero [length args]
    construct lastArgList [list value]
        args [tail argsLength]
    deconstruct lastArgList
        lastArg [nested_identifier]
    deconstruct lastArg
        root [id] rep [repeat attribute_access]
    where
        allIterables [containsId root]
    import classMethods [repeat method_declaration]
    where
        classMethods [doesMethodHaveVarArg funcName]
    construct argsLengthMinusOne [number]
        argsLength [- 1]
    construct allArgsButLast [list value]
        args [head argsLengthMinusOne]
    construct unpacked [value]
        '* lastArg
    by  
        funcName'( allArgsButLast [, unpacked] ')
end rule

rule doesMethodHaveVarArg seeking [id]
    match [concrete_method_declaration]
        _ [opt decorator] _ [acess_modifier] _ [opt static] _ [nested_identifier] methodName [id] '( params [list method_parameter] ') _ [opt throws] '{ _ [repeat statement] '}
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

function extractListNameFromVariableDeclaration decl [statement]
    replace [repeat id]
        results [repeat id]
    deconstruct decl
        'ArrayList '< _ [id] '> listName [id] _ [opt value_continuation] ';
    by 
        results [. listName]
end function

function extractHashMapNameFromVariableDeclaration decl [statement]
    replace [repeat id]
        results [repeat id]
    deconstruct decl
        'HashMap< _ [id] ', _ [id] '> listName [id] _ [opt value_continuation] ';
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

function extractArrayListListNameFromMethodParam param [method_parameter]
    replace [repeat id]
        result [repeat id]
    deconstruct param
        'ArrayList< _ [id] '> paramName [id]
    by
        result [. paramName]
end function

function extractArrayNameFromMethodParam param [method_parameter]
    replace [repeat id]
        result [repeat id]
    deconstruct param
        nested [nested_identifier] paramName [id] 
    construct nestables [repeat nestable_value]
        _ [^ nested]
    construct zero [number]
        '0
    construct length [number]
        zero [length nestables]
    construct lastNestableRepeat [repeat nestable_value]
        nestables [tail length]
    deconstruct lastNestableRepeat
        _ [id] '[ ']
    by
        result [. paramName]
end function

rule addAsterixToVarArgInSuperInit possibleVarArgName [opt id]
    replace $ [nested_identifier]
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
        _ [nested_identifier] '... varArgName [id]
    by 
        varArgName
end function

%-----------------------%
% Multiple constructors %
%-----------------------%
function fixMultipleConstructors 
    replace [repeat class_body_element]
        rep [repeat class_body_element]
    import constructorCount [number]
    where
        constructorCount [> 1]
    by
        rep [fixNoArgDefaultMultipleConstructors] [fixOneToOneMultipleConstructors] 
        
end function

function fixOneToOneMultipleConstructors
    replace [repeat class_body_element]
        elems [repeat class_body_element]
    where 
        elems [existsOneToOneConstructor]
    by
        elems [replaceOneToOneConstructor] [targetRemainingConstructor]
end function

function fixNoArgDefaultMultipleConstructors
    replace [repeat class_body_element]
        elems [repeat class_body_element]
    where not
        elems [existsOneToOneConstructor]
    by
        elems [replaceExtraConstructorNoArgs]
end function

rule existsOneToOneConstructor
    match [constructor] 
        'def '__init__( _ [list method_parameter] '):  stmts [repeat statement]
    where 
        stmts [containConstructorWithSelfParam]
end rule

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
        call [nested_identifier]
    where 
        call [containConstructorWithSelfParam]
    deconstruct call
        className [id] '( args [list value] ')
    by
        className '. 'alternateConstructor( args ')
end rule

rule containConstructorWithSelfParam
    match [nested_identifier]
        instantiatedClass [id] '( params [list value]')
    deconstruct instantiatedClass
        instantiatedClassGeneric [any]
    construct optInstantiatedClassName [opt id]
        _ [extractClassId instantiatedClassGeneric]
    deconstruct optInstantiatedClassName
        instantiatedClassName [id]
    import possibleFunctionImports [repeat id]
    import className [nested_identifier]
    deconstruct className 
        classNameGeneric [any]
    construct optCurrentClassName [opt id]
        _ [extractClassId instantiatedClass]
    deconstruct optCurrentClassName
        currentClassName [id]
    construct possibleImportsPlusCurrentClass [repeat id]
        possibleFunctionImports [. currentClassName]
    where
        possibleImportsPlusCurrentClass [containsId instantiatedClassName]
    where   
        params [containsSelfValue]
end rule


function extractClassId target [any]
    replace [opt id]
        result [opt id]
    by
        result [extractIdFromNonGenericClass target] [extractIdFromGenericClass target]
end function

function extractIdFromGenericClass class [any]
    replace [opt id]
        result [opt id]
    deconstruct * [nested_identifier] class
        genericClass [nested_identifier]
    deconstruct genericClass
        className[id] '< _[list id] '>
    by
        className 
end function

function extractIdFromNonGenericClass class [any]
    replace [opt id]
        result [opt id]
    skipping [list id]
    deconstruct * [id] class
        className [id]
    by
        className
end function


rule containsSelfValue
    skipping [nested_identifier]
    match [value]
        'self
end rule

%-----------------------%
%   Overloaded methods  %
%-----------------------%
function addOverloadArg javaParam [method_parameter]
    replace [repeat overload_data_arg]
        res [repeat overload_data_arg]
    deconstruct javaParam
        type [nested_identifier] _ [id]
    construct optAdding [opt overload_data_arg]
        _
            [translateArrayListType type]
            [translateArrayType type]
            [translateListType type]
            [translateBaseTypesOverload type]
    deconstruct optAdding  
        adding [overload_data_arg]
    by
        res [. adding]
end function

function translateBaseTypesOverload javaType [nested_identifier]
    replace [opt overload_data_arg]
    deconstruct javaType
        baseType [id]
    by
        baseType [translateBaseTypes]
end function

function translateBaseTypes 
    replace [id]
        baseType [id]
    by
        baseType [translateStringType]  [translateBooleanType] [translateDoubleType]
end function

function translateStringType
    replace [id]
        'String
    by 
        'str
end function

function translateArrayListType javaType [nested_identifier]
    replace [opt overload_data_arg]
    deconstruct javaType
        'ArrayList< type [id] '>
    by
        'list type [translateBaseTypes]
end function

function translateArrayType javaType [nested_identifier]
    replace [opt overload_data_arg]
    deconstruct javaType
        type [id] '[ ']
    by
        'list type [translateBaseTypes]
end function

function translateListType javaType [nested_identifier]
    replace [opt overload_data_arg]
    deconstruct javaType
        'List< type [id] '>
    by
        'list type [translateBaseTypes]
end function

function translateBooleanType 
    replace [id]
        'boolean
    by  
        'bool
end function

function translateDoubleType 
    replace [id]
        'double
    by  
        'float
end function

function isMethodOverloaded
    match [id]
        methodName [id]
    import classMethodNames [repeat id]
    construct zero [number]
        '0
    construct count [number]
        zero [incrementIfMatch methodName each classMethodNames]
    where 
        count [> 1]
end function

function incrementIfMatch id1[id] id2[id] 
    replace [number]
        result [number]
    where
        id1 [= id2]
    by
        result [+ 1]
end function

define overload_data
    [id] [repeat overload]
end define

define overload
    [id] [repeat overload_data_arg]
end define 

define overload_data_arg
    [id] [opt id]
end define

function changeOverloadedMethodName params [list method_parameter]
    replace [id]
        methodName [id]
    where
        methodName [isMethodOverloaded]
    import overloadData [repeat overload_data]
    construct newMethodName [id]
        methodName [!]
    export overloadData
        overloadData [appendToOverloadData methodName newMethodName params]
    by
        newMethodName
end function


function appendToOverloadData oldName [id] newName [id] params [list method_parameter]
    replace [repeat overload_data]
        data [repeat overload_data]
    construct alreadyPresent [opt overload_data]
        _ [getOverloadData oldName each data]
    by
        data [appendToExistingOverloadEntry oldName newName params] [createNewOverloadEntry oldName newName params] 
end function

function getOverloadData seeking [id] data [overload_data]
    replace [opt overload_data]
        result [opt overload_data]
    deconstruct data
        dataName [id] _ [repeat overload]
    where dataName [= seeking]
    by
        data
end function

rule doesOverloadEntryExist oldName [id]
    match [overload_data]
        dataOldName [id] _ [repeat overload]
    where 
        dataOldName [= oldName]
end rule

rule appendToExistingOverloadEntry oldName [id] newName [id] param [list method_parameter]
    replace $ [overload_data]
        data [overload_data]
    deconstruct data
        dataOldName [id] overloads [repeat overload]
    where
        dataOldName [= oldName]
    construct overloadArgs [repeat overload_data_arg]
        _ [addOverloadArg each param]
    construct newOverload [overload]
        newName overloadArgs
    by
        dataOldName overloads [. newOverload]
end rule

function createNewOverloadEntry oldName [id] newName [id] param [list method_parameter]
    replace [repeat overload_data]
        results [repeat overload_data]
    where not
        results [doesOverloadEntryExist oldName]
    construct overloadArgs [repeat overload_data_arg]
        _ [addOverloadArg each param]
    construct newOverloadEntry [overload_data]
        oldName newName overloadArgs
    by
        results [. newOverloadEntry]

end function

function createDisambiguationMethod data [overload_data]
    replace [repeat class_body_element]
        results [repeat class_body_element]
    deconstruct data
        name [id] overloads [repeat overload]
    construct stmts [repeat statement]
        _ [addDisambiguationIf each overloads]
    construct throwStmt [statement]
        'raise 'TypeError( "No method matches provided parameters" ')
    construct method [class_body_element]
        'def name '(self, '*argv): stmts [. throwStmt] [addFunctionImports]
    by 
        results [. method]
end function

function addDisambiguationIf over [overload]
    replace [repeat statement]
        results [repeat statement]
    deconstruct over
        newName [id] args [repeat overload_data_arg]
    construct zero [number]
        '0
    construct argLength [number]
        zero [length args]
    construct typeChecks [opt value_continuation]
        _ [createDisambiguationTypeChecks args '0]
    construct condition [value]
        'len(argv) '== argLength typeChecks
    construct funcCall [repeat statement]
        _ [createDisambiguatedMethodCall newName argLength]
    construct ifStatement [statement]
        'if condition ':
            funcCall
    by
        results [. ifStatement]
end function

function createDisambiguationTypeChecks args [repeat overload_data_arg] counter [number]
    replace [opt value_continuation]
    construct repFirstElem [repeat overload_data_arg]
        args [head 1]
    construct otherElems [repeat overload_data_arg]
        args [tail 2] %maybe 2?
    deconstruct repFirstElem
        head  [overload_data_arg]
    construct optTypeCheck [opt value]
        _ [createTypeCheck head counter]
    deconstruct optTypeCheck
        typeCheck [value]
    construct increment [number]
        counter [+ 1]
    construct optTypeCheckContinuation [opt value_continuation]
        _ [createDisambiguationTypeChecks otherElems increment]
    by
        'and typeCheck [appendOptToValue optTypeCheckContinuation] 
end function

function createTypeCheck arg [overload_data_arg] counter [number]
    replace [opt value]
    construct result [opt value]
        _ 
        [createListTypeCheck arg counter]
        [createNormalTypeCheck arg counter]
    by
        result
end function

function createNormalTypeCheck arg [overload_data_arg] counter [number]
    replace [opt value]
    deconstruct arg
        type [id]
    construct castedType [value]
        type
    by
        'isinstance( 'argv '[ counter '], castedType [mutlipleTypeCheck]')
end function

function createListTypeCheck arg [overload_data_arg] counter [number]
    replace [opt value]
    deconstruct arg
        'list type [id]
    construct castedType [value]
        type
    by
        '( 'isinstance(argv '[ counter '], 'list) 'and '( 'not 'len(argv '[ counter ']) 'or 'isinstance(argv '[ counter '] '[ '0 '], castedType [mutlipleTypeCheck]')))
end function

function mutlipleTypeCheck
    replace [value]
        original [value]
    by
        original [floatToFloatInt] 
end function

function floatToFloatInt
    replace [value]
        'float
    by 
        '( 'float, 'int)
end function

function addDisambiguationMethods   
    replace [repeat class_body_element]
        results [repeat class_body_element]
    import overloadData [repeat overload_data]
    construct disambiguationMethods [repeat class_body_element]
        _ [createDisambiguationMethod each overloadData]
    by
        results [. disambiguationMethods]
end function

function createDisambiguatedMethodCall funcName [id] argLength [number]
    replace [repeat statement]
    construct funcCallArgs [list value]
        _ [addArgvParam 0 argLength]
    by
        'return 'self '. funcName '( funcCallArgs ')
end function 

function addArgvParam count [number] argLength [number]
    replace [list value]
        result [list value]
    where
        argLength [> count]
    construct param [value]
        'argv '[ count ']
    construct increment [number]
        count [+ 1]
    by
        result [, param] [addArgvParam increment argLength]
end function

function filterOutFunctions elem [class_body_element]
    replace $ [repeat class_body_element]
        result [repeat class_body_element]
    where not
        elem
            [checkAlreadyStrFunc]
            [checkAlreadyHashFunc]
    by
        result [. elem]
end function

function checkAlreadyStrFunc
    match [class_body_element]
        _[opt decorator] _[acess_modifier] _[nested_identifier] 'toString '( _ [list method_parameter] ') '{ _ [method_content] '}
    import classMethodNames [repeat id]
    where
        classMethodNames [containsId '__str__]
end function

function checkAlreadyHashFunc
    match [class_body_element]
        _[opt decorator] _[acess_modifier] _[nested_identifier] 'hashCode '( _ [list method_parameter] ') '{ _ [method_content] '}
    import classMethodNames [repeat id]
    where
        classMethodNames [containsId '__hash__]
end function