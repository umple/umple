%--------------------%
%     Statements     %
%--------------------%
%This file contains logic related to translating code at the statement level (ie code unside methods)

%Main function that calls most others
function replaceStatements
    replace [any]
        statements [any]
    by 
        statements

            [replacePrivateAttributeSetting]
            [replaceDefaultReadObject]
            [replaceSwitchCase]
            [addClassPrefixToEnum]
			[replaceTimerDeclaration]
			[replaceTimerSchedule]
			[replaceTimerStart]
			[replaceTimerStop]
            [replaceForLoop]
            [replaceForInLoop]
            [replaceAssignementIncrementBefore]
            [replaceAssignementDecrementBefore]
            [replaceAssignementIncrementAfter]
            [replaceAssignementDecrementAfter]
            [replaceAssignmentStatement] 
            [replaceReturn] 
            [replaceNoStatements] 
            [addSelfToOwnMethodCalls]
            [replaceThisFunctionCall]
            [replaceNestedStatement]
            [replaceDecleration]
            [replaceTernary]
            [replaceAllBoolean]
            [replaceTryCatch]
            [replaceInlineIf]
            [replaceIf]
            [replaceElseIf]
            [replaceElse]
            [replaceWhile]
            [replaceNull]
            [replaceThis]
            [replaceIncrementBefore]
            [replaceDecrementBefore]
            [replaceIncrementAfter]
            [replaceDecrementAfter]
            [replaceThrowError]
            [replaceNewArrayList]
            [replaceNewHashMap]
            [replaceNewCall]
            [addClassPrefixToNestedClasses]
            [replaceCasting]
            [correctSuperInit]
            [correctSuperFunctions]
            [replaceDotEquals]
            [replacePrintln]
            [replacePrint]
            [replacePrintf]
            [replaceInnerClassCreate]
            [replaceNewLine]
            [replaceHexIdentity]
            [replaceComparator]
            [translateToStringCall]
            [translateHashCall]
            [translateSelfEqualsCall]
            [translateNestedEqualsCall]
            [translateNestedContainsCall]
            [replaceIntegerValueOf]
            [replaceDoubleValueOf]
            [replaceFloatF]
            [replaceAllMemberVariableNames]
            [removeSemiColonFromValues]
            [replaceAutoTransitionExitSM]
            [replaceThreadSleep]

end function

%In Java, you dont need to have code within brackets. For example else{} is valid.
%In python we need a pass statement.
%Ideally this would be a rule, but the fact that it matches empty (hence why nothing after the replace)
%means it causes some recursion errors so it has to stay a function
%Because it is a function it then has to be called a a few places throught this file (as funcs dont search the pattern recursivly)
function replaceNoStatements
    replace [repeat statement]
    by 
        'pass  
end function

rule removeSemiColonFromValues
    replace [statement]
        val [value] ';
    by  
        val
end rule


rule replaceAssignementIncrementAfter
    replace [statement]
        nest1 [nested_identifier] '= nest2 [nested_identifier] '++ ';
    by
        nest1 ', nest2 '= nest2 ', nest2 '+ '1
end rule

rule replaceAssignementDecrementAfter
    replace [statement]
        nest1 [nested_identifier] '= nest2 [nested_identifier] '-- ';
    by
        nest1 ', nest2 '= nest2 ', nest2 '- '1
end rule

rule replaceAssignementIncrementBefore
    replace [statement]
        nest1 [nested_identifier] '= '++ nest2 [nested_identifier] ';
    by
        nest1 '= nest2 '= nest2 '+ '1
end rule

rule replaceAssignementDecrementBefore
    replace [statement]
        nest1 [nested_identifier] '= '-- nest2 [nested_identifier] ';
    by
        nest1 '= nest2 '= nest2 '- '1
end rule

rule replaceAssignmentStatement
    replace [statement]
        identifier [nested_identifier] '= val [value] ';
    by 
        identifier '= val
end rule

rule replaceReturn
    replace [stmt_return]
        'return val [opt value] ';
    by 
        'return val
end rule

%In java, we can simply put the do methodName() in python we must have self.methodName()
rule addSelfToOwnMethodCalls
    replace [nested_identifier]
        funcName [id] extensions [repeat nestable_extension+] rep [repeat attribute_access]
    construct firstExtension [repeat nestable_extension]
        extensions [head 1]
    deconstruct firstExtension
        '( values [list value]')
    import classMethodNames [repeat id]
    where
        classMethodNames [containsId funcName]
    import staticElements [repeat id]
    where not
        staticElements [containsId funcName]
    by
        'self '. funcName '( values') rep
end rule

rule replaceThisFunctionCall
    replace [nested_identifier]
        'this. funcName [id] '( values [list value]')
    by
        'self '. funcName '( values')
end rule

rule replaceNestedStatement
    replace [statement]
        stmt [statement]
    deconstruct stmt
        value [nested_identifier] ';
    by
        value
end rule

rule replaceThis
    replace [value]
        'this
    by 
        'self
end rule

rule replaceDecleration
    replace [statement]
        _[nested_identifier] assignment [value]';
    by 
        assignment 
end rule

rule replaceTryCatch
    replace [try_catch]
        'try '{  tryStmts [repeat statement]  '} 'catch '( _ [method_parameter] ') '{ catchStmts [repeat statement] '} finally [opt finally]
    by 
        'try:
            tryStmts [replaceNoStatements]
        'except:
            catchStmts [replaceNoStatements]
        finally [replaceFinally]
end rule

function replaceFinally
    replace [opt finally]
        'finally '{ stmts [repeat statement] '}
    by  
        'finally: stmts [replaceNoStatements]
end function

rule replaceIf
    replace [if]
        'if '( bool [value] ') '{ statements [repeat statement]  '}
    by 
        'if bool ': statements
end rule

rule replaceInlineIf
     replace [if]
        'if '( bool [value] ')  statement [ statement]  
    by 
        'if bool ': statement
end rule

rule replaceElseIf
    replace [else_if]
        'else 'if '( bool [value] ') '{  statements [repeat statement]  '} 
    by 
        'elif bool ': statements
end rule

rule replaceElse
    replace [else]
        'else '{  statements [repeat statement]  '} 
    by 
        'else ': statements
end rule

rule containsAssignment
    match [value_continuation_assignment]
        _ [value_continuation_assignment]
end rule

%Replaces ternary statements. 
%Java: condition ? a : b
%Python: a if condition else b
%This one is a little complicated, so here is a breakdown
rule replaceTernary
    replace [value]
        val [value]
    skipping[parentheses_value]
    %This skip is for the searching deconstruct below
    %We do not want to cross a parentheses boundary hence the skip
    %ex: we would not want our val to be matched to "a+b+(c?x:z)" 
    %but just the ternary "c?x:z" 
    deconstruct * [ternary] val
        '? optTrue [value] ': optFalse [value]
    construct blankString [stringlit]
        ""
    %We unparse the whole matched value (turn it into a string so we can munipulate it easier)
    construct unparsed [stringlit]
        blankString [unparse val]
    construct zero [number]
        '0
    construct questionMark [stringlit]
        "?"
    %We find the index of the question mark to isolate the ternary condition
    construct questionMarkIndex [number]
        zero [index unparsed questionMark]
    construct questionMarkIndexMinusOne [number]
        questionMarkIndex [- 1]
    %Here is the isolated condition (still unparsed) 
    construct beforeQuestionMark [stringlit]
        unparsed [: 1 questionMarkIndexMinusOne]
    construct defaultShouldNotSee [value]
        'uhOh
    %Here we reparse the condition
    construct condition [value]
        defaultShouldNotSee [parse beforeQuestionMark]
    %If TXL supported mutliple skips, this would not be here and instead be another skip with the one above
    %This is to verify that we do not cross an assignment boundry from the beginning of the matched val to the question mark
    %Ex: we would not want to replace "a = b ? c : d" with "c if a = b else d"
    where not
        condition [containsAssignment] 
    by
        '( optTrue ') 'if condition 'else optFalse
end rule

rule replaceWhile
    replace [while_loop]
        'while( val [value] ')  '{ statements [repeat statement] '} 
    by
        'while val ':  statements 
end rule

rule replaceNull
    replace [value]
        'null
    by
        'None
end rule

rule replaceDecrementBefore
    replace [value]
        '-- nest [nested_identifier]
    by 
        nest '-= 1
end rule

rule replaceIncrementBefore
    replace [value]
        '++ nest [nested_identifier]
    by 
        nest '+= '1
end rule

rule replaceDecrementAfter
    replace [value]
        nest [nested_identifier] '--
    by 
        nest '-= 1
end rule

rule replaceIncrementAfter
    replace [value]
        nest [nested_identifier] '++ 
    by 
        nest '+= '1
end rule

rule replaceForLoop
    replace [statement]
        'for( decl [double_value] '; goal [value]'; assignment [value]') '{  stmts[repeat statement]  '} 
    deconstruct decl
        _[nested_identifier] name [id] '= start [value]
    construct declaration [value]
        name '= start
    construct newStatements [repeat statement]
        assignment
    by 
        declaration 'while goal ':  stmts  [. newStatements]
end rule

rule replaceForInLoop
    replace [for_in_loop]
        'for( _[nested_identifier] var [id] ': nested [nested_identifier]')'{ stmts [repeat statement] '} 
    by 
        'for var 'in  nested':  stmts
end rule

rule replaceThrowError
    replace [throw_statement]
        'throw 'new _[id] '( vals [list value] ');
    construct firstVal [list value]
        vals [head 1]
    deconstruct firstVal
        message [stringlit]
    by
        'raise 'RuntimeError(  message ') 
end rule 

rule replaceCasting
    replace [value]
        '( _ [nested_identifier]') name [value]
    by 
        name 
end rule

rule replaceNewCall
    replace [value]
        'new nested [nested_identifier]
    deconstruct nested 
        className [id] ext [repeat nestable_extension]
    deconstruct * [func_call_parentheses] ext
        '( vals [list value] ')
    by
        className '( vals ')
end rule

rule correctSuperInit
    replace [nested_identifier]
        'super( params [list value] ')
    by
        'super().__init__( params ')
end rule

%Umple generates some strange Java code to allow an object to change the private attribute of an other
%in certain associations. In python nothing is private anyways so we can change the other's attribute normally.
rule replacePrivateAttributeSetting
    replace [repeat statement]
        'java.lang.reflect.Field fieldVar [id] '= modified [id] '.getClass().getDeclaredField( attributeName [stringlit] ');
        fieldVar '.setAccessible(true);
        fieldVar '.set( modified ', val [value] ');
    construct attributeAccessBeginning [stringlit]
        "._"
    construct unparsedAttributeAccess [stringlit]
        attributeAccessBeginning [+ attributeName]
    construct attributeAccessParsed [opt attribute_access]
        _ [parse unparsedAttributeAccess]
    deconstruct attributeAccessParsed
        attributeAccess [attribute_access]
    by
        modified attributeAccess '= val
end rule

rule correctSuperFunctions
    replace [nested_identifier]
        'super rep [repeat attribute_access]
    by
        'super() rep
end rule


rule replaceTimerDeclaration
	replace [statement]
		 var [id] ' = new Timer();
	by
		var '= None			
end rule

rule replaceTimerSchedule
	replace [repeat statement]
		 var[id]'.schedule(this, (long) time[nested_identifier] '*1000); 
	by
		 var '= Timer( time ', 'self.run '); var '.start()			
end rule

rule replaceTimerStart
	replace [repeat statement]
		 var [id] ' = new TimedEventHandler(this, temp[value] ', val [value] ');
	by
		 var '= self.TimedEventHandler( 'this, temp ', val ') 			
end rule

rule replaceTimerStop
	replace [repeat statement]
		 var [id] '.stop();
	by
		 var '.stop() 			
end rule

%to match Java Code "doActivityStateMachine1TopLevelThread1".equals(doActivityMethodName)
rule replaceDotEquals
    replace [value]
        s1 [stringlit] '.equals( s2[value] ')
    by
        s1 == s2
end rule 


rule replacePrintln
    replace [nested_identifier]
        'System.out.println( val [value] ')
    by
        'print( val ')
end rule 

rule replacePrint
    replace [nested_identifier]
        'System.out.print( val [value] ')
    by
        'print( val ')
end rule 

rule replacePrintf
    replace [nested_identifier]
        'System.out.printf(val [value] ')
    by
        'print( val ')
end rule 

%   outerObject.new InnerClass(); -> outerObject.InnerClass()
rule replaceInnerClassCreate
    replace [new_call_inner]
        outerObject [nested_identifier] '.new innerObject [nested_identifier]
    by
        outerObject '. innerObject
end rule


rule replaceNewLine
    replace [nested_identifier]
        'System.getProperties().getProperty("line.separator")
    by
        'os.linesep
end rule 

rule replaceHexIdentity
    replace [nested_identifier]
        'Integer.toHexString(System.identityHashCode( val [value] '))
    by
        'format( 'id( val '), '"x")
end rule

%WHile the latest versions of python have a switch case functionnality, we decided to translate the 
%switch cases to if/elif/else to support older python versions
rule replaceSwitchCase
    replace [statement]
        'switch( val [value] ') '{ cases [repeat switch_case_case]  default [opt switch_case_default] '}
    construct firstCase [repeat switch_case_case]
        cases [head 1]
    construct otherCases [repeat switch_case_case]
        cases [tail 2]
    construct ifElses [repeat else_if]
        _ [replaceSwitchCaseCase val each otherCases]
    construct throwAwayIf [if]
        'if 'a: 'pass
    construct realIf [if]
        throwAwayIf [replaceFirstSwitchCaseCase val each firstCase]
    construct else [opt else]
        _ [replaceSwitchCaseDefault default]
    by
        realIf ifElses else
end rule


function replaceFirstSwitchCaseCase switch [value] firstCase [switch_case_case] 
    replace [if]
        _ [if]
    deconstruct firstCase
        'case val [value] ': stmts [repeat statement] 'break;
    construct cont [value_continuation]
        '== val [fixEnumValueWithNoEnum]
    construct condition [value]
        switch [appendToValue cont]
    construct newIf [if]
        'if condition ': stmts [replaceNoStatements] [removeBreak]
    by 
        newIf
end function

%Values are recursive types. Values have optional continuations which often contain values. 
%It can then be a bother to, for example,  add a "+ 3" to an existing value.
%This function simplifies the process.
function appendToValue cont [value_continuation]
    replace [value]
        val [value]
    construct emptyString [stringlit]
        ""
    construct spaceString [stringlit]
        " "
    %We unparse the value
    construct unparsedVal [stringlit]
        emptyString [unparse val]
    %Unparse the continuation
    construct unparsedCont [stringlit]
        emptyString [unparse cont]
    %Stick em together
    construct concatenated [stringlit]
        unparsedVal [+ spaceString] [+ unparsedCont]
    %We replace the val with the reparsed concatenation
    by
        val [parse concatenated]
end function

%Utility function to add an opt value_continuation to a value
function appendOptToValue cont [opt value_continuation]
    replace [value]
        val [value]
    deconstruct cont
        realCont [value_continuation]
    by
        val [appendToValue realCont]
end function

function replaceSwitchCaseCase switch [value] aCase [switch_case_case] 
    replace [repeat else_if]
        rep [repeat else_if]
    deconstruct aCase
        'case val [value] ': stmts [repeat statement] 'break;
    construct cont [value_continuation]
        '== val [fixEnumValueWithNoEnum]
    construct condition [value]
        switch [appendToValue cont]
    construct elseIf [else_if]
        'elif condition ': stmts [replaceNoStatements] [removeBreak]
    by 
        rep [. elseIf]
end function

function replaceSwitchCaseDefault defaultCase [opt switch_case_default]
    replace [opt else]
        _ [opt else]
    deconstruct defaultCase
        'default ': stmts [repeat statement]
    by
        'else: stmts [replaceNoStatements] [removeBreak]

end function

%This function looks complicated because it uses another generic function (in TXL, generic functions are funcs that take type [any] as argument)
%To do this a lot of casting is needed
%This function translates in.defaultReadObject(); into the two lines self.__dict__.clear() and self.__dict__.update(pickle.load(input).__dict__)
%These are used to deserialize an object
function replaceDefaultReadObject
    replace [repeat statement]
        rep [repeat statement]
    construct seeking [statement]
        'in.defaultReadObject();
    deconstruct seeking
        seekingAny [any]
    where 
        rep [containsGeneric seekingAny]
    construct repAny [repeat any]
        _ [repeatStatementToAny each rep]
    construct beforeAfter [repeat sequence_any]
        _ [getBeforeAfter seekingAny repAny]
    deconstruct beforeAfter 
        beforeAfterRep [repeat sequence_any]
    %reparse result to get back to original type
    construct before [repeat sequence_any]
        beforeAfterRep [select 1 1] 
    construct after [repeat sequence_any]
        beforeAfterRep [select 2 2]
    construct beforeReparsed [repeat statement]
        _ [reparse before]
    construct afterReparsed [repeat statement]
        _ [reparse after]
    construct clearStatement [statement]
        'self '.__dict__ '.clear()
    construct updateStatement [statement]
        'self '.__dict__ '.update(pickle '.load(input) '.__dict__)
    construct middle [repeat statement]
        clearStatement
        updateStatement
    by 
        beforeReparsed [. middle] [. afterReparsed]
end function

%Casts a statement to [any] and adds it to a result repeat
function repeatStatementToAny stmt [statement]
    replace [repeat any]
        rep [repeat any]
    deconstruct stmt
        stmtAny [any]
    by
        rep [. stmtAny]
end function

rule replaceComparator
    replace [value]
        'Comparator.comparing( class [nested_identifier] ':: funcName [id] ')
    by
        'lambda 'x ': 'x '. funcName '()
end rule

rule replaceIntegerValueOf
    replace [value]
        'Integer '.valueOf( val [value] ')
    by 
        'int( val ')
end rule 

rule replaceDoubleValueOf
    replace [value]
        'Double '.valueOf( val [value] ')
    by 
        'float( val ')
end rule 

rule replaceFloatF
    replace [base_value]
        num [number] 'f
    by 
        num
end rule 

%--------------------------------%
%  Switch case Enum correction   %
%--------------------------------%
%In Java when doing a switch case that uses an Enum for the switch value,
%The cases will just contain the Enum value name (ex: switch(adoorStatus){ ... case Open:) 
%In python we always need the EnumName before the enum value (Ex: switch(adoorStatus){ ... case DoorStatus.Open:)

%This rule adds the EnumName before the enumValue (ex: Open -> DoorStatus.Open)
rule fixEnumValueWithNoEnum
    replace $ [nested_identifier]
        val [nested_identifier]
    deconstruct val
        _ [id]
    import enumeratorDeclerations [repeat enum_declaration]
    by
        val [fixEnumValueWithNoEnumCheck each enumeratorDeclerations]
end rule

%This function adds the enumName of aEnum to the EnumValue if the EnumValue is a value of aEnum 
rule fixEnumValueWithNoEnumCheck aEnum [enum_declaration]
    replace [nested_identifier]
        identifier [id]
    deconstruct aEnum 
        _ [opt acess_modifier] 'enum enumName [id] '{ vals [list id]'}
    where
        vals [containsId identifier] 
    by
        enumName '. identifier
end rule

%Since the Enums in python are just nested classes, we need to add the current class as prefix
%Ex: DoorStatus.Open -> Garage.DoorStatus.Open
rule addClassPrefixToEnum
    replace [nested_identifier]
        enumName [id] '.  enumVal [id]
    where
        enumName [isAnEnum]
    import className [nested_identifier]
    deconstruct className
        root [nestable_value] accesses [repeat attribute_access]
    construct enumAccess [attribute_access] 
        '. enumName
    construct enumValueAccess [attribute_access] 
        '. enumVal  
    by
        root accesses [. enumAccess] [. enumValueAccess]
end rule

function isAnEnum
    match [id]
        name [id]
    import enumeratorDeclerations [repeat enum_declaration]
    where
        name [isSpecificEnum each enumeratorDeclerations]
end function

function isSpecificEnum aEnum [enum_declaration]
    match [id]
        name [id]
    deconstruct aEnum    
        _ [opt acess_modifier] 'enum enumName [id] '{ _ [list id]'}
    where
        name [= enumName]
end function


rule removeBreak
    replace $ [repeat statement]
        stmts [repeat statement]
    construct zero [number]
        '0
    construct length [number]
        zero [length stmts]
    construct lastStatement [repeat statement]
        stmts [tail length]
    deconstruct lastStatement
        'break;
    construct lengthMinusOne [number]
        length [- 1]
    by  
        stmts [head lengthMinusOne]
end rule

rule replaceNewArrayList
    replace [base_value]
        'new 'ArrayList< _[id] '>() 
    by
        '[ ']
end rule

rule replaceNewHashMap
    replace [base_value]
        'new 'HashMap< _ [id] ', _ [id] '>()
    by
        'dict()
end rule
%--------------------------------%
%  Attribute access translation  %
%--------------------------------%

rule translateToStringCall
    replace [attribute_access]
        '.toString()
    by
        '.__str__()
end rule

rule translateHashCall
    replace [attribute_access]
        '.hashCode()
    by
        '.__hash__()
end rule


rule translateSelfEqualsCall
    replace [value]
        'equals( val [value] ')
    by
        'self '== val 
end rule

%Translates a.equals(b) into a == b
%Will also translate a.b.c.equals(d.e.f) into a.b.c == d.e.f
rule translateNestedEqualsCall
    replace [value]
        nested [nested_identifier] cont [opt value_continuation]
    deconstruct nested
        root [nestable_value] rep [repeat attribute_access]
    construct seeking [id]
        'equals
    where 
        rep [containsId seeking]
    construct zero [number]
        '0
    construct repLength [number]
        zero [length rep]
    construct lastAttrRep [repeat attribute_access]
        rep [tail repLength]
    deconstruct lastAttrRep 
        '.equals( val [value] ')
    construct lengthMinusOne [number]
        repLength [- 1]
    construct firstAttrs [repeat attribute_access]
        rep [head lengthMinusOne]
    construct pythonEquals [value_continuation]
        '== val 
    construct newPythonEquals [value]
        root firstAttrs '== val
    by
         newPythonEquals [appendOptToValue cont]
end rule

%Translates a.contains(b) into b in a
%Will also translate a.b.c.contains(d.e.f) into d.e.f == a.b.c
rule translateNestedContainsCall
    replace [value]
        nested [nested_identifier] initalCont [opt value_continuation]
    deconstruct nested
        root [nestable_value] rep [repeat attribute_access]
    construct seeking [id]
        'contains
    where 
        rep [containsId seeking]
    construct zero [number]
        '0
    construct repLength [number]
        zero [length rep]
    construct lastAttrRep [repeat attribute_access]
        rep [tail repLength]
    deconstruct lastAttrRep 
        '.contains( val [value] ')
    construct lengthMinusOne [number]
        repLength [- 1]
    construct firstAttrs [repeat attribute_access]
        rep [head lengthMinusOne]
    construct cont [value_continuation]
        'in root firstAttrs
    by
        val [appendToValue cont] [appendOptToValue initalCont]
end rule



%--------------------------------%
%  Generic Before/after search   %
%--------------------------------%
%The following code relates to a function getBeforeAfter. This function was created as there is no built in function in TXL
%that has this functionality. The function takes and returns values of the type [any], so some casting is required to use the
%function with specific types. The function takes a target (seeking) and a repeat. It will return a two dementional array
%of the type any. The first elem of the returned value is going to be the elements of the repeat before the target and the
%second will be elements of the repeat after the target

%Intermediate type used to create a two dimentional array of any. You cant do double repeats in TXL so this was needed.
define sequence_any
    [repeat any]
end define

%Given a target (seeking) and a repeat, returns a two dementional array of type [any]. The first value in the two dementional array
%are the elements in the repeat before the target, and the second value are the elements of the repeat after the target
function getBeforeAfter seeking [any] rep [repeat any]
    replace [repeat sequence_any]
    where 
        rep [containsGeneric seeking]
    deconstruct rep
        repAny [repeat any]
    construct zero [number]
        '0 
    construct index [number]
        zero [getIndex seeking repAny]
    by 
        _ [createBeforeAfter index repAny]
end function

function createBeforeAfter index [number] rep [repeat any]
    replace [repeat sequence_any]
        empty [repeat sequence_any]
    construct beforeIndex [number]
        index
    construct before [sequence_any]
        rep [head beforeIndex]
    construct countWithSkip [number]
        index [+ 2]
    construct after [sequence_any]
        rep [tail countWithSkip]
    by
        empty [. before] [. after]
end function

function getIndex  seeking [any] rep [repeat any]
    replace [number]
        index [number]
    construct repLength [number]
        _ [length rep]
    construct head [repeat any]
        rep [head 1]
    where 
        repLength [> 0]
    construct remaining [repeat any]
        rep [tail 2]
    where not
        head [containsGeneric seeking] 
    by
        index [+ 1] [getIndex seeking remaining]
end function

rule containsGeneric seeking [any]
    match [any]
        seeking
end rule



%--------------------------------%
%  Member variable Corrections   %
%--------------------------------%
%This section contains code related to treating member variables.
%There is not public/private in Python, so we add an _ to member variables to indicate they should not be accesed this way
%We also have to add self. to access them
% personName -> self._personName

function replaceAllMemberVariableNames
    replace [any]
        any [any]
    import memberVariables [repeat id]
    by 
        any 
            [replaceMemberVariableNames memberVariables] 
            [replaceMemberVariableNamesWithThis memberVariables]
            [replaceMemberVariableNamesBrackets memberVariables]
            [replaceStaticMemberVariableNames]
end function

rule replaceMemberVariableNames memberVariables [repeat id]
    replace [nested_identifier]
         name [id] rep  [repeat attribute_access]
    where 
        memberVariables [containsId name]
    construct underscore [id]
        '_
    construct newName [id]
        underscore [+ name] 
    by
        'self '. newName rep
end rule

rule replaceStaticMemberVariableNames
    replace [nested_identifier]
        name [id] ext [repeat nestable_extension] staticRep [repeat attribute_access]
    import staticElements [repeat id]
    import className [nested_identifier]
    deconstruct className
        root [nestable_value] rep [repeat attribute_access]
    construct newAccess [repeat attribute_access]
        '. name ext
    where 
        staticElements [containsId name]
    by
        root rep [. newAccess] [. staticRep]
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

%---------------------%
% Boolean expressions %
%---------------------%
%Grouped up a few boolean related translations
function replaceAllBoolean
    replace [any]
        statements [any]
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

% need to convert milliseconds to seconds
rule replaceThreadSleep
    replace [statement]
        'Thread.sleep( val [number] ')
    by
        'time.sleep( val  [/ 1000]')
end rule

% self.exitSm() is making the python AutoTransition not work, comment out for workaround.
rule replaceAutoTransitionExitSM
    replace [statement]
        'exitSm()
    by
        'exit()
end rule

rule addClassPrefixToNestedClasses
    replace [nested_identifier]
        innerClass [id]'( params [list value] ')
    where
        innerClass [isAnInnerClass]
    import className [nested_identifier]
    deconstruct className
        root [nestable_value] accesses [repeat attribute_access]
    construct innerAccess [attribute_access] 
        '. innerClass( params ')
    by
        root accesses [. innerAccess]
end rule

function isAnInnerClass
    match [id]
        name [id]
    import nestedClassDeclerations [repeat inner_class_declaration]
    where
        name [isSpecificInnerClass each nestedClassDeclerations]
end function

function isSpecificInnerClass aIClass [inner_class_declaration]
    match [id]
        name [id]
    deconstruct aIClass
        'class iclassName [id] _ [opt inheritance_group] ': _ [class_body_decl] 
    where
        name [= iclassName]
end function