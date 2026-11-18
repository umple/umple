/**
 * SyntaxHighlighter
 * http://alexgorbatchev.com/
 *
 * SyntaxHighlighter is donationware. If you are using it, please donate.
 * http://alexgorbatchev.com/wiki/SyntaxHighlighter:Donate
 *
 * @version
 * 2.0.296 (March 01 2009)
 *
 * @copyright
 * Copyright (C) 2004-2009 Alex Gorbatchev.
 *
 * @license
 * This file is part of SyntaxHighlighter.
 *
 * SyntaxHighlighter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SyntaxHighlighter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SyntaxHighlighter.  If not, see <http://www.gnu.org/licenses/>.
 */
SyntaxHighlighter.brushes.JScript = function()
{
	var keywords =	'break case catch class const continue default delete do else enum export extends false ' +
					'finally for function if implements import in instanceof interface let new null package ' +
					'private protected public return static super switch this throw true try typeof var void ' +
					'while with yield await async of get set';

	var builtins =	'Array Boolean Date Error JSON Map Math Number Object Promise RangeError Reference RegExp Set ' +
					'String Symbol TypeError WeakMap console exports globalThis module require undefined';

	this.regexList = [
		{ regex: SyntaxHighlighter.regexLib.singleLineCComments,		css: 'comments' },	// one line comments
		{ regex: SyntaxHighlighter.regexLib.multiLineCComments,			css: 'comments' },	// multiline comments
		{ regex: SyntaxHighlighter.regexLib.doubleQuotedString,			css: 'string' },	// double quoted strings
		{ regex: SyntaxHighlighter.regexLib.singleQuotedString,			css: 'string' },	// single quoted strings
		{ regex: /`([^`\\]|\\.)*`/g,									css: 'string' },	// template literals
		{ regex: /\b([\d]+(\.[\d]+)?|0x[a-f0-9]+)\b/gi,					css: 'value' },		// numbers
		{ regex: new RegExp(this.getKeywords(keywords), 'gm'),			css: 'keyword' },	// keywords
		{ regex: new RegExp(this.getKeywords(builtins), 'gm'),			css: 'color1' }		// built-in objects
		];

	this.forHtmlScript(SyntaxHighlighter.regexLib.scriptScriptTags);
};

SyntaxHighlighter.brushes.JScript.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.JScript.aliases	= ['js', 'jscript', 'javascript'];
