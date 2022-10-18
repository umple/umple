%--------------------%
%     Methods        %
%--------------------%

function replaceAllMethods
    replace [repeat class_body_element]
        elems [repeat class_body_element]
    by
        elems
            [removeOverrideDecorator]
            [replaceToString]
            [replaceAbstractMethod]
            [replaceAbstractMethodNoArgs]
            [replaceConcreteMethod]
            [replaceConcreteMethodNoArgs]
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
        _[acess_modifier] _[nested_class] methodName [id]'( params [list method_parameter +] ') _ [opt throws] '{ statements [repeat statement] '}
    construct newParams [list id]
    by
        'def methodName '(self, newParams [translateParams each params] '):  statements [replaceStatements] [changeKeyArgumentNameInNestedIdentifier]
end rule

rule replaceConcreteMethodNoArgs
    replace [concrete_method_declaration]
        _[acess_modifier] _[nested_class] methodName [id]'() _ [opt throws] '{ statements [repeat statement] '}
    by
        'def methodName '(self):  statements [replaceStatements]
end rule

rule replaceAbstractMethod
    replace [abstract_method_declaration]
        _[acess_modifier] _[nested_class] methodName [id] '( params [list method_parameter +] ');
    construct newParams [list id]
    by
        '@abstractmethod 'def methodName '(self, newParams [translateParams each params] '): 'pass
end rule

rule replaceAbstractMethodNoArgs
    replace [abstract_method_declaration]
        _[acess_modifier] _[nested_class] methodName [id]'();
    by
        '@abstractmethod 'def methodName '(self): 'pass
end rule

rule replaceToString
    replace [method_declaration]
        _[acess_modifier] _[nested_class]  'toString '() _ [opt throws] '{ statements [repeat statement] '}
    by
        'def '__str__ '(self):  statements [replaceStatements] 
end rule

rule replaceStaticMethod
    replace [method_declaration]
        _[acess_modifier] _[static] _[nested_class] methodName [id]'() _ [opt throws] '{ statements [repeat statement] '}
    by
        '@staticmethod 'def methodName '():  statements [replaceStatements] [changeKeyArgumentNameInNestedIdentifier]
end rule

rule replaceConstructor
    replace [constructor]
         mod [acess_modifier] className [id]'( params [list method_parameter +] ') _ [opt throws] '{ statements [repeat statement]  '}
    construct newParams [list id]
    by
        'def '__init__(self, newParams [translateParams each params]'):  statements [replaceStatements] [changeKeyArgumentNameInNestedIdentifier]
end rule

rule replaceConstructorNoArgs
    replace [constructor]
         mod [acess_modifier] className [id]'() _ [opt throws] '{ statements [repeat statement]  '}
    by
        'def '__init__(self):  statements [replaceStatements]
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
