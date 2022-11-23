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
    replace [value]
        base [base_value] '== 'null cont [opt value_continuation]
    by 
        base 'is 'None cont
end rule

rule replaceNotNullCheck
    replace [value]
        base [base_value] '!= 'null cont [opt value_continuation]
    by 
        'not '( base 'is 'None ') cont
end rule

rule replaceBoolNegation
    replace [base_value]
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
    replace [base_value]
        'true
    by 
        'True
end rule

rule replaceFalse
    replace [base_value]
        'false
    by 
        'False
end rule

rule replaceClassMatchCheck
    replace [value]
        'getClass().equals( id2 [id] '.getClass() ')
    by  
        'type(self) 'is 'type( id2 ')
end rule
