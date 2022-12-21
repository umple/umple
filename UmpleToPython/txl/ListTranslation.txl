%--------------------%
%  List replacement  %
%--------------------%
%This file contains logic related to translating lists and dictionnairies (or hashmaps)
%A lot of methods for interacting with list and dicts are different between Java and Python
%By passing the ids of lists and dicts, we can then change the methods called from them to the appropriate Python ones


function replaceAllSpecialTypes lists [repeat id] hashMaps [repeat id]
    replace [any]
        any [any]
    by 
        any
            [replaceRemoveAll lists]
            [replaceListUnmutable lists]
            [replaceGetListContent lists]
            [replaceListGetSize lists]
            [replaceArrayLength lists]
            [replaceListGetIndex lists]
            [replaceListContains lists]
            [replaceListAddAtIndex lists]
            [replaceListAddNoIndex lists]
            [replaceListCopy]
            [replaceListSort lists]
            [replaceAddAll lists]
            [replaceToArray lists]
            [replacePut hashMaps]
            [replaceContainsKey hashMaps]
end function 


rule replaceListCopy
    replace [value]
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
        memberLists [containsId id]
    by 
        'tuple( id ')
end rule


rule replaceGetListContent memberLists [repeat id]
    replace [nested_identifier]
        id [id] '. 'get( index [value] ')  rest [repeat attribute_access]
    where
        memberLists [containsId id]
    by 
        id '[ index '] rest 
end rule

rule replaceListGetSize memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.size()
    where
        memberLists [containsId id]
    by 
        'len( id ')
end rule

rule replaceArrayLength memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.length
    where
        memberLists [containsId id]
    by 
        'len( id ')
end rule



rule replaceListGetIndex memberLists [repeat id]
    replace [value]
        id [id] '.indexOf( val [value] ') cont [opt value_continuation]
    where
        memberLists [containsId id]
    construct pythonVal [value]
        '( '-1 'if 'not val 'in id 'else id '.index( val ') ')
    by 
        pythonVal [appendOptToValue cont]
end rule

rule replaceListContains memberLists [repeat id]
    replace [value]
        id [id]'. 'contains '( val [value] ') cont [opt value_continuation]
    where
        memberLists [containsId id]
    deconstruct val
        baseContains [base_value] baseCont [opt value_continuation]
    by 
        '( baseContains baseCont ') 'in id cont
end rule

rule replaceListAddAtIndex memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.add( position [value] ', value [value] ')
    where
        memberLists [containsId id]
    by 
        id '.insert( position ', value ')
end rule

rule replaceListAddNoIndex memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.add( value [value] ')
    where
        memberLists [containsId id]
    by 
        id '.append( value ')
end rule

rule replaceListSort memberLists [repeat id]
    replace [nested_identifier]
        'Collections.sort( listId [id] ', priorityFunc [id] ')
    where
        memberLists [containsId listId]
    by 
        listId '.sort( 'key '= priorityFunc ')
end rule

rule replaceAddAll memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.addAll( value [value] ')
    where
        memberLists [containsId id]
    by 
        id '.extend( value ')
end rule

rule replaceToArray memberLists [repeat id]
    replace [nested_identifier]
        id [id] '.toArray( value [value] ')
    where
        memberLists [containsId id]
    by 
        id '.copy()
end rule

rule replaceRemoveAll memberLists [repeat id]
    replace [value]
        id [id] '.removeAll( otherList [value] ') cont [opt value_continuation]
    where
        memberLists [containsId id]
    by
        id '= 'list( 'filter( 'lambda 'a ': 'not 'a 'in otherList ', id ')) cont

end rule

rule replacePut dicts [repeat id]
    replace [value]
        id [id] '.put( key [value] ', val [value] ')
    where
        dicts [containsId id]
    by
        id '[ key '] '= val

end rule

rule replaceContainsKey dicts [repeat id]
    replace [value]
        id [id] '.containsKey( key [value] ')
    where
        dicts [containsId id]
    by
        '( key ') 'in id
end rule