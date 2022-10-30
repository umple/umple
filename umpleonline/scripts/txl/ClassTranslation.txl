%--------------------%
%     Classes        %
%--------------------%
%decl and inheritance and external imports
rule replaceConcreteClassesWithInheritance
    replace $ [concrete_class_declaration]
        _ [acess_modifier] 'class className [nested_class] inheritances [repeat inheritance_list] '{ classBody [class_body_decl] '} 
    export className 
    construct inheritanceClasses [list nested_class]
        _ [extractInheritanceBlockClasses each inheritances]
    construct imports [repeat import_statement]
        _ [createImports classBody inheritances]
    by
        imports 'class className '( inheritanceClasses ')':  classBody  [replaceClassBody]
end rule

%inheritance  imports
rule replaceInterfacesWithInheritance
    replace [interface_declaration]
        _ [acess_modifier] 'interface className [nested_class] inheritances [repeat inheritance_list] '{ classBody [class_body_decl] '} 
    export className
    construct inheritanceClasses [list nested_class]
        _ [extractInheritanceBlockClasses each inheritances]
    construct imports [repeat import_statement]
        _ [createImports classBody inheritances]
    construct AbcClass [list nested_class]
        'ABC
    construct finalInheritances [list nested_class]
        AbcClass [, inheritanceClasses]
    by
        'from 'abc 'import 'ABC, 'abstractmethod imports 'class className '(  finalInheritances '):  classBody [replaceClassBody] [replaceInterfaceBody]
end rule

function replaceInterfaceBody
   replace [class_body_decl]
        elements [repeat class_body_element]
    construct declarations [repeat member_variable_declaration]
        _ [^ elements]
    export enumeratorDeclerations [repeat enum_declaration]
        _ [^ elements]
    construct memberVariables [repeat id]
        _ [addMemberVariable each declarations]
    construct listMemberVariables [repeat id]
        _ [addListMemberVariable each declarations]
    by
        '@abstractmethod 'def '__init__(self): 'pass elements [replaceAllMethods]
end function

function replaceClassBody
    replace [class_body_decl]
        elements [repeat class_body_element]
    construct declarations [repeat member_variable_declaration]
        _ [^ elements]
    construct transientMembers [repeat id]
        _ [addIfTransient each declarations]
    export transientMembers
    construct memberVariables [repeat id]
        _ [addMemberVariable each declarations]
    construct listMemberVariables [repeat id]
        _ [addListMemberVariable each declarations]
    export enumeratorDeclerations [repeat enum_declaration]
        _ [^ elements]
    by
        elements [removeMemberVariableDeclarations] [replaceEnumDeclaration] 
            [replaceAllLists listMemberVariables]
            [replaceConstructor] 
            [replaceConstructorNoArgs]
            [replaceAllMethods]
            [replaceAllMemberVariableNames memberVariables] 
end function

function getTransientMembers decls [repeat member_variable_declaration]
    replace [repeat id]
        result [repeat id]
    by
        result [addIfTransient each decls]
end function

function addIfTransient decl [member_variable_declaration]
    replace [repeat id]
        result [repeat id]
    deconstruct decl
        _ [opt acess_modifier] 'transient _ [opt static] _ [opt volatile] _ [variable_declaration]
    by
        result [addMemberVariable decl]
end function

function removeMemberVariableDeclarations
    replace [repeat class_body_element]
        elems [repeat class_body_element]
    construct empty [repeat class_body_element]
        _
    by
        empty [addIfNotMemberDecleration each elems]
end function

function addIfNotMemberDecleration elem [class_body_element]
    replace [repeat class_body_element]
        keepers [repeat class_body_element]
    construct declerations [repeat member_variable_declaration]
        _ [^ elem]
    construct declerationSize [number]
        _ [length declerations]
    where
        declerationSize [= 0]
    by
        keepers [. elem]
end function

function addMemberVariable MemberVariable [member_variable_declaration]
    replace [repeat id]
        SequenceSoFar [repeat id]
    deconstruct MemberVariable
        _[opt acess_modifier] _[opt transient] _[opt static] _[opt volatile]  decl [variable_declaration]
    deconstruct decl
        _ [nested_class] memberName [id]';
    by
        SequenceSoFar [. memberName]
end function