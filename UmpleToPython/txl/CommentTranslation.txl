#pragma -comment
%This files contains logic related to comment translation
%--------------------%
%     Comment        %
%--------------------%
%Rule to translate java comments to python
rule pycomments
    replace $ [comment_NL]
	    C1 [comment]
	construct H1 [comment]
	    '#
	construct N1 [number]
	    _[# C1]
	construct C2 [comment]
	    C1[deleteMultiline1][deleteMultiline2][deleteInline]
    by
	    H1[: 1 1] [+C2]
end rule 

%function to translate java inline // comment with python #
function deleteInline
    replace [comment]
	C1[comment]
    construct OIndex [number] 
        _ [index C1 "//"]
    deconstruct not OIndex
    0
    construct NIndex [number]
        OIndex[+2]
    construct N1 [number]
    _[# C1]
    by
	    C1 [: NIndex N1]
end function

%function to translate java multiline /* comment with python #
function deleteMultiline1
    replace [comment]
	    C1[comment]
    construct OIndex [number] 
        _ [index C1 "/*"]
    deconstruct not OIndex
        0
    construct NIndex [number]
        OIndex[+2]
    construct N1 [number]
        _[# C1]
    by
	    C1 [: NIndex N1]
end function

%function to erase java multiline end comment  */ 
function deleteMultiline2
    replace [comment]
	    C1[comment]
    construct OIndex [number] 
        _ [index C1 "*/"]
    deconstruct not OIndex
        0
    construct NIndex [number]
        OIndex[-1]
    by
	    C1 [: 1 NIndex]
end function



