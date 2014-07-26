/*
 * JsMin
 * Javascript Compressor
 * http://www.crockford.com/
 * http://www.smallsharptools.com/
*/

dp.sh.Brushes.CSharp=function()
{var keywords='abstract active after as association associationClass autounique before base bool break '+'byte case catch char checked class const '+'continue decimal default defaulted delegate depend do double else entry enum event exit explicit '+'extern false finally fixed float for foreach get giving goto '+'if immutable implicit in int isA '+'interface internal is lazy lock long namespace '+'new null object operator out '+'override params private protected public readonly ref return '+'sbyte sealed set settable singleton '+'short sizeof sorted stackalloc static string strictness struct switch this throw trace tracer trait true try '+'typeof uint ulong unchecked unsafe ushort use using virtual void where while';this.regexList=[{regex:dp.sh.RegexLib.SingleLineCComments,css:'comment'},{regex:dp.sh.RegexLib.MultiLineCComments,css:'comment'},{regex:dp.sh.RegexLib.DoubleQuotedString,css:'string'},{regex:dp.sh.RegexLib.SingleQuotedString,css:'string'},{regex:new RegExp('^\\s*#.*','gm'),css:'preprocessor'},{regex:new RegExp(this.GetKeywords(keywords),'gm'),css:'keyword'}];this.CssClass='dp-c';this.Style='.dp-c .vars { color: #d00; }';}
dp.sh.Brushes.CSharp.prototype=new dp.sh.Highlighter();dp.sh.Brushes.CSharp.Aliases=['c#','c-sharp','csharp'];

