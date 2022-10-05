function createImports classBody [class_body_decl] inheritances [repeat inheritance_list]
    replace [repeat import_statement]
        empty [repeat import_statement]
    construct declarations [repeat member_variable_declaration]
        _ [^ classBody]
    construct declarationClassesToImport [repeat id]
        _ [getClassesToImport classBody each declarations]
    construct allInternalClassesToImport [repeat id]
        _ [extractInheritanceImportClasses classBody each inheritances] [concatenateRepeatNoDuplicates declarationClassesToImport]
    construct allImports [repeat import_statement]
        _ [addImportStatement each allInternalClassesToImport] [addExternalImports classBody]
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

function getClassesToImport classBody [class_body_decl] declaration [member_variable_declaration]
    replace [repeat id]
        empty [repeat id]
    deconstruct declaration
        _[opt acess_modifier] _[opt static] _[opt volatile] varDec [variable_declaration]
    deconstruct varDec
        class [class_name] _ [id]';
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
    replace [list class_name]
        classes [list class_name]
    deconstruct inheritanceList
        _[inheritance_statement] classesToAdd [list class_name]
    by
        classes [, classesToAdd] 
end function

function extractInheritanceImportClasses classBody [class_body_decl] inheritanceList [inheritance_list]
    replace [repeat id]
        classesToImport [repeat id]
    deconstruct inheritanceList
        _[inheritance_statement] classesToAdd [list class_name]
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
        currentList [contains elem]
    by
        currentList [. elem]
end function

function extractListClass classBody [class_body_decl] class [class_name]
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
        empty [addIfNotDefaultTypeOrEnum classBody each ids]
end function

function addIfNotDefaultTypeOrEnum classBody [class_body_decl] id [id]
    replace [repeat id]
        current [repeat id]
    where not 
        id [matchDefaultType]
    where not 
        classBody [isTypeEnum id]
    by
        current [. id] 
end function

rule matchDefaultType
    match [id]
        id [id]
    construct defaults [repeat id]
        'byte 'short 'int 'long 'float 'double 'boolean 'char 'String 'Array
    where
        defaults [contains id]    
end rule

function extractRegularClass classBody [class_body_decl] class [class_name]
    replace [repeat id]
        empty [repeat id]
    deconstruct class
        id [id]
    where not 
        id [matchDefaultType]
    where not 
        classBody [isTypeEnum id]
    by
        empty [. id]
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
%  External imports  %
%--------------------%

function addExternalImports body [class_body_decl]
    replace [repeat import_statement]
        imports [repeat import_statement]
    by
        imports [addOSImportIfNeeded body]
        [addEnumImportIfNeeded body]
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