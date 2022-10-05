%--------------------%
%  List replacement  %
%--------------------%

function replaceAllLists memberLists [repeat id]
    replace [any]
        any [any]
    by 
        any
            [replaceListAssignement memberLists]
            [replaceListUnmutable memberLists]
            [replaceGetListContent memberLists]
            [replaceListGetSize memberLists]
            [replaceListGetIndex memberLists]
            [replaceListContains memberLists]
            [replaceListAddAtIndex memberLists]
            [replaceListAddNoIndex memberLists]
            [replaceListCopy]
end function 

rule replaceListAssignement memberLists [repeat id]
    replace [assignment]
        id [id] '= 'new 'ArrayList '< _[list id] '> '(') 
    where
        memberLists [contains id]
    by 
        id '= '[']
end rule

rule replaceListCopy
    replace [assignment]
        id [id] '= 'new 'ArrayList '< _[list id] '> '( oldList [nested_identifier]') 
    deconstruct oldList
        val [nestable_value] rep [repeat attribute_access]
    construct newNested [repeat attribute_access]
        '.copy()
    by 
        id '= val rep [. newNested]
end rule

rule replaceListUnmutable memberLists [repeat id]
    replace [value]
        'Collections.unmodifiableList( id [id] ')
    where
        memberLists [contains id]
    by 
        'tuple( id ')
end rule


rule replaceGetListContent memberLists [repeat id]
    replace [nested_identifier]
        id [id] '. 'get( index [value] ')  rest [repeat attribute_access]
    where
        memberLists [contains id]
    by 
        id '[ index '] rest 
end rule

rule replaceListGetSize memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.size()
    where
        memberLists [contains id]
    by 
        'len( id ')
end rule

rule replaceListGetIndex memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.indexOf( val [value] ')
    where
        memberLists [contains id]
    by 
        id '.index( val ')
end rule

rule replaceListContains memberLists [repeat id]
    replace [value]
        nested [nested_identifier]
    deconstruct nested
        id [id]'. 'contains '( val [value_no_recursion] ')
    where
        memberLists [contains id]
    by 
        val 'in id
end rule

rule replaceListAddAtIndex memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.add( position [value] ', value [value] ')
    where
        memberLists [contains id]
    by 
        id '.insert( position ', value ')
end rule

rule replaceListAddNoIndex memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.add( value [value] ')
    where
        memberLists [contains id]
    by 
        id '.append( value ')
end rule