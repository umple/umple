%---------------------%
% Boolean expressions %
%---------------------%

function replaceAllBoolean
    replace [repeat statement]
        statements [repeat statement]

    by
        statements
            [replaceNullCheck]
            [replaceNotNullCheck]
            [replaceBoolNegation]
            [replaceBoolAnd]
            [replaceBoolOr]
            [replaceTrue]
            [replaceFalse]
            [replaceClassMatchCheck]
end function

rule replaceNullCheck
    replace [condition]
        elem [value_no_recursion] '== 'null
    by 
        elem 'is 'None
end rule

rule replaceNotNullCheck
    replace [condition]
        cond [condition]
    deconstruct cond
        elem [value_no_recursion] '!= 'null
    by 
        'not '( elem 'is 'None ')
end rule

rule replaceBoolNegation
    replace [value_no_recursion]
        '! val [value]
    by 
        'not val
end rule

rule replaceBoolAnd
    replace [boolean_operator]
        '&&
    by 
        'and
end rule

rule replaceBoolOr
    replace [boolean_operator]
        '|'|
    by 
        'or
end rule

rule replaceTrue
    replace [value]
        'true
    by 
        'True
end rule

rule replaceFalse
    replace [value]
        'false
    by 
        'False
end rule

rule replaceClassMatchCheck
    replace [value]
        'getClass().equals( id2 [id] '.getClass())
    by  
        'type(self) 'is 'type( id2 ')
end rule
