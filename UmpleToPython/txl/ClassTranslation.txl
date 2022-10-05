%--------------------%
%     Classes        %
%--------------------%
%decl and inheritance and external imports
rule replaceConcreteClassesWithInheritance
    replace $ [concrete_class_declaration]
        _ [acess_modifier] 'class className [class_name] inheritances [repeat inheritance_list] '{ classBody [class_body_decl] '} 
    export className [class_name]
        className
    construct inheritanceClasses [list class_name]
        _ [extractInheritanceBlockClasses each inheritances]
    construct imports [repeat import_statement]
        _ [createImports classBody inheritances]
    by
        imports 'class className '( inheritanceClasses ')':  classBody  [replaceClassBody]
end rule

%decl and external imports
rule replaceConcreteClassesNoInheritance
    replace $ [concrete_class_declaration]
        _ [acess_modifier] 'class className [class_name] '{ classBody [class_body_decl] '} 
    export className [class_name]
        className
    construct emptyArgument [repeat inheritance_list]
        _
    construct imports [repeat import_statement]
        _ [createImports classBody emptyArgument]
    by
    imports 'class className ':  classBody  [replaceClassBody]
end rule

%no imports
rule replaceInterfacesNoInheritance
    replace [interface_declaration]
        _ [acess_modifier] 'interface className [class_name] '{ classBody [class_body_decl] '} 
    export className [class_name]
        className
    by
        'from 'abc 'import 'ABC, 'abstractmethod 'class className '(ABC):  classBody [replaceClassBody] [replaceInterfaceBody]
end rule

%inheritance  imports
rule replaceInterfacesWithInheritance
    replace [interface_declaration]
        _ [acess_modifier] 'interface className [class_name] inheritances [repeat inheritance_list] '{ classBody [class_body_decl] '} 
    export className [class_name]
        className
    construct inheritanceClasses [list class_name]
        _ [extractInheritanceBlockClasses each inheritances]
    construct imports [repeat import_statement]
        _ [createImports classBody inheritances]
    by
        'from 'abc 'import 'ABC, 'abstractmethod imports 'class className '(ABC, inheritanceClasses '):  classBody [replaceClassBody] [replaceInterfaceBody]
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

%WIP HERE 
function replaceClassBody
    replace [class_body_decl]
        elements [repeat class_body_element]
    construct declarations [repeat member_variable_declaration]
        _ [^ elements]
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