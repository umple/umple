/**
 * Mermaid brush for SyntaxHighlighter
 */
SyntaxHighlighter.brushes.Mermaid = function()
{
	var keywords =	'classDiagram stateDiagram-v2 direction class state as interface';

	this.regexList = [
		{ regex: new RegExp('%%.*$', 'gm'),						css: 'comments' },
		{ regex: SyntaxHighlighter.regexLib.doubleQuotedString,		css: 'string' },
		{ regex: /\b([\d]+(\.[\d]+)?)\b/gi,				css: 'value' },
		{ regex: new RegExp(this.getKeywords(keywords), 'gm'),		css: 'keyword' },
		{ regex: /(\<\|\-\-|\<\|\.\.|\-\-\>|\<\-\-|\-\-)/g,			css: 'keyword' },
		{ regex: /\[\*\]/g,										css: 'keyword' }
	];
};

SyntaxHighlighter.brushes.Mermaid.prototype	= new SyntaxHighlighter.Highlighter();
SyntaxHighlighter.brushes.Mermaid.aliases	= ['mermaid'];
