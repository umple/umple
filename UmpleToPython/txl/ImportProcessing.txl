function createImports classBody [class_body_decl] inheritances [repeat inheritance_list]
    replace [repeat import_statement]
        empty [repeat import_statement]
    construct declarations [repeat member_variable_declaration]
        _ [^ classBody]
    construct inheritanceImports [repeat id]
        _ [extractInheritanceImportClasses classBody each inheritances]
    construct allImports [repeat import_statement]
        _ [addImportStatement each inheritanceImports] [addExternalImports classBody]
    by
        allImports
end function 

function addImportStatement a [id]
    replace [repeat import_statement]
        imports [repeat import_statement]
    construct newImport [import_statement]
        'from a 'import a
    by
        imports [. newImport]
end function

function extractPossibleFunctionImports classBody [class_body_decl] declaration [member_variable_declaration]
    replace [repeat id]
        empty [repeat id]
    deconstruct declaration
        _[opt acess_modifier] _[opt static] _[opt volatile] varDec [variable_declaration]
    deconstruct varDec
        class [nested_identifier] _ [id]';
    construct classesToImport [repeat id]
        _ [extractListClass classBody class] [extractRegularClass classBody class]
    by 
        empty [addToRepeatIfNotThere each classesToImport] 
end function 

function isTypeEnum typeName [id]
    match * [enum_declaration]
        _ [opt acess_modifier] 'enum enumName [id] '{ _ [list id]'}
    where
        enumName [= typeName]
end function

function extractInheritanceBlockClasses inheritanceList [inheritance_list]
    replace [list nested_identifier]
        classes [list nested_identifier]
    deconstruct inheritanceList
        _[inheritance_statement] classesToAdd [list nested_identifier]
    by
        classes [inheritanceClassFilter each classesToAdd]
end function

function inheritanceClassFilter class [nested_identifier]
    replace [list nested_identifier]
        classes [list nested_identifier]
    construct unparsed [stringlit]
        _ [unparse class]
    construct filter [repeat nested_identifier]
        'java.io.Serializable 
    where not
        filter [containsNestedClass class]
    by
        classes [, class]
end function

function extractInheritanceImportClasses classBody [class_body_decl] inheritanceList [inheritance_list]
    replace [repeat id]
        classesToImport [repeat id]
    deconstruct inheritanceList
        _[inheritance_statement] classesToAdd [list nested_identifier]
    construct classIds [repeat id]
        _ [extractListClass classBody each classesToAdd] [extractRegularClass classBody each classesToAdd]
    by
        classesToImport [. classIds] 
end function


function concatenateRepeatNoDuplicates elems [repeat id]
    replace [repeat id]
        currentList [repeat id]
    by
        currentList [addToRepeatIfNotThere each elems] 
end function

function addToRepeatIfNotThere elem [id]
    replace [repeat id]
        currentList [repeat id]
    where not 
        currentList [containsId elem]
    by
        currentList [. elem]
end function

function extractListClass classBody [class_body_decl] class [nested_identifier]
    replace [repeat id]
        empty [repeat id]
    deconstruct class
        _ [id]'< ids [list id] '>
    construct unfiltered [repeat id]
        _ [listToRepeat ids] 
    construct filtered [repeat id]
        _ [filterOutUnwantedTypes classBody unfiltered]
    by
        filtered
end function

function filterOutUnwantedTypes classBody [class_body_decl] ids [repeat id]
    replace [repeat id]
        empty [repeat id]
    by 
        empty [importClassFilter classBody each ids]
end function

function importClassFilter classBody [class_body_decl] type [id]
    replace [repeat id]
        current [repeat id]
    where not 
        type [matchDefaultType]
    where not 
        classBody [isTypeEnum type]
    import className [nested_identifier]
    deconstruct className
        classNameId [id]
    where not
        classNameId [= type]
    by
        current [. type]
end function

rule matchDefaultType
    match [id]
        id [id]
    construct defaults [repeat id]
        'byte 'short 'int 'long 'float 'double 'boolean 'char 'String 'Array
    where
        defaults [containsId id]    
end rule

function extractRegularClass classBody [class_body_decl] class [nested_identifier]
    replace [repeat id]
        empty [repeat id]
    deconstruct class
        id [id]
    by
        empty [importClassFilter classBody id]
end function

function listToRepeat ids [list id]
    replace [repeat id]
        aRep [repeat id]
    by 
        aRep [addToRepeat each ids]
end function

function addToRepeat a [id]
     replace [repeat id]
        aRep [repeat id]
    by 
        aRep [. a]
end function

function repeatToList aRep [repeat id]
    replace [list id]
        aList [list id]
    by 
        aList [addToList each aRep]

end function


function addToList anys [id]
     replace [list id]
        aRep [list id]
    by 
        aRep [, anys]
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
        memberVariables [containsId name]
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
        memberVariables [containsId name]
    construct underscore [id]
        '_
    by
        'self '. underscore [+ name] rep
end rule

rule replaceMemberVariableNamesBrackets memberVariables [repeat id]
    replace [nested_identifier]
         name [id] '[ val [value] ']  rep [repeat attribute_access]
    where 
        memberVariables [containsId name]
    construct underscore [id]
        '_
    construct newName [id]
        underscore [+ name]
    by
        'self '. newName '[ val ']  rep
end rule


rule containsId Object [id]
    match [id]
        Object
end rule

rule containsNestedClass Object [nested_identifier]
    match [nested_identifier]
        Object
end rule

%--------------------%
%  External imports  %
%--------------------%

function addExternalImports body [class_body_decl]
    replace [repeat import_statement]
        imports [repeat import_statement]
    by
        imports [addOSImportIfNeeded body]
        [addEnumImportIfNeeded body]
        [addPickleImportIfNeeded]
end function


function addOSImportIfNeeded body [class_body_decl]
    replace [repeat import_statement]
        imports [repeat import_statement]
    where
        body [shouldOsImport]
    construct newImport [import_statement]
        'import 'os
    by 
        imports [. newImport]
end function

function shouldOsImport
    match * [nested_identifier]
        'System.getProperties().getProperty("line.separator")
end function

function addEnumImportIfNeeded body [class_body_decl]
    replace [repeat import_statement]
        imports [repeat import_statement]
    where
        body [shouldEnumImport]
    construct newImport [import_statement]
        'from 'enum 'import 'Enum, 'auto
    by 
        imports [. newImport]
end function

function shouldEnumImport
    match * [enum_declaration]
        _ [enum_declaration]
end function

function addPickleImportIfNeeded
    replace [repeat import_statement]
        imports [repeat import_statement]
    import Imports [repeat import_statement]
    where
        Imports [shouldImportPickle]
    construct newImport [import_statement]
        'import 'pickle
    by 
        imports [. newImport]
end function

function shouldImportPickle
    match * [import_statement]
        'import 'java.io.Serializable;
end function