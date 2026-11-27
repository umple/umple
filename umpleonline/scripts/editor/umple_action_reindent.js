// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Reindentation of the code in the text editor

Action.reindent = function(lines, cursorPos)
{
  var offset = "";
  var codeAfterIndent = "";
  var len = lines.length;
  var inBlockComment = false;
  var statementEnd = true; // i.e. have semicolon at the end of the statement.
  var statementEndIndentSpace = 0;
  var indexOfCursor = -1;
  for (var i = 0; i < len; i++) 
  {
    var trimmedLine = lines[i].trim();

    // remove quotation
    var indexOfFirstQuote  = trimmedLine.indexOf("\"");
    var indexOfLastQuote = trimmedLine.indexOf("\"", indexOfFirstQuote + 1);
    while (indexOfFirstQuote != -1 && indexOfLastQuote != -1)
    {
      trimmedLine = trimmedLine.slice(0, indexOfFirstQuote) + trimmedLine.slice(indexOfLastQuote+1, trimmedLine.length);
      indexOfFirstQuote  = trimmedLine.indexOf("\"");
      indexOfLastQuote = trimmedLine.indexOf("\"", indexOfFirstQuote + 1);
    }

    // remove comment
    if (trimmedLine.indexOf("//") != -1)
    {
      trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("//")).trim();
    }

    if (inBlockComment)
    {
      if (trimmedLine.indexOf("*/") != -1)
      {
        trimmedLine = trimmedLine.substr(trimmedLine.indexOf("*/") + 2).trim();
        inBlockComment = false;
      }
      else {
        if (i != lines.length -1)
        {
          codeAfterIndent += lines[i] + "\n";
        } else {
          codeAfterIndent += lines[i];
        }
        continue;
      }
    }
    else if (trimmedLine.indexOf("/*") != -1)
    {
      if (trimmedLine.indexOf("*/") == -1)
      {
        inBlockComment = true;
        trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("/*")).trim();
      }
      else
      {
        trimmedLine = trimmedLine.substr(0, trimmedLine.indexOf("/*")) + trimmedLine.substr(trimmedLine.indexOf("*/") + 2).trim(); // remove block comment for trimmed line
      }
      
    }
    
    var indexOfOpenCurlyBrace = trimmedLine.indexOf("{");
    var indexOfCloseCurlyBrace = trimmedLine.indexOf("}");
    var indexOfSemiColon = trimmedLine.indexOf(";");

    
    if (indexOfSemiColon != -1 && indexOfSemiColon != trimmedLine.length - 1 && trimmedLine.substr(indexOfSemiColon+1).trim().charAt(0) != "}")
    {
      lines.splice(i + 1, 0, trimmedLine.substr(indexOfSemiColon + 1));
      if (i <= cursorPos.line)
      {
        cursorPos.line++;
      }
      lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfSemiColon + 1);
      Action.reindent(lines, cursorPos);
      return;
    }

    var doNotIndent = indexOfOpenCurlyBrace != -1 && indexOfCloseCurlyBrace != -1 && indexOfCloseCurlyBrace - indexOfOpenCurlyBrace < 40 && trimmedLine.substr(0, indexOfCloseCurlyBrace).indexOf("{", indexOfOpenCurlyBrace + 1) == -1;
    if (doNotIndent)
    {
      if (indexOfCloseCurlyBrace != trimmedLine.length - 1)
      {
        lines.splice(i + 1, 0, trimmedLine.substr(indexOfCloseCurlyBrace + 1));
        if (i <= cursorPos.line)
        {
          cursorPos.line++;
        }
        lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfCloseCurlyBrace + 1);
        Action.reindent(lines, cursorPos);
        return;
      }
      
      if (!statementEnd)
      {
        if (trimmedLine.slice(-1) == "{")
        {
          statementEnd = true;
        } 
        else 
        {
          lines[i] = offset + lines[i].match(/^\s*/)[0].substr(statementEndIndentSpace) + lines[i].trim();
          if (trimmedLine.indexOf(";") == trimmedLine.length - 1)
          {
            statementEnd = true;
          }
        }
      }
      else
      {
        lines[i] = offset + lines[i].trim();
      }
    }
    else 
    {
      if (indexOfOpenCurlyBrace != -1 && indexOfOpenCurlyBrace != trimmedLine.length - 1) // put code after an open curly bracket to next line
      {
        lines.splice(i + 1, 0, trimmedLine.substr(indexOfOpenCurlyBrace + 1));
        lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfOpenCurlyBrace + 1);
        if (i <= cursorPos.line)
        {
          cursorPos.line++;
        }
        Action.reindent(lines, cursorPos);
        return;
      }

      if (indexOfCloseCurlyBrace != -1 && trimmedLine.length > 1)
      {
        if (indexOfCloseCurlyBrace == 0)
        {
          lines.splice(i + 1, 0, trimmedLine.substr(1));
          lines[i] = "}";
          if (i <= cursorPos.line)
          {
            cursorPos.line++;
          }
        } else {
          lines.splice(i + 1, 0, "}");
          if (i <= cursorPos.line)
          {
            cursorPos.line++;
          }
          if (indexOfCloseCurlyBrace != trimmedLine.length - 1) // there is code after close curly bracket
          {
            lines.splice(i + 2, 0, trimmedLine.substr(indexOfCloseCurlyBrace + 1));
            if (i <= cursorPos.line)
            {
              cursorPos.line++;
            }
          }
          lines[i] = lines[i].substr(0, lines[i].match(/^\s*/)[0].length + indexOfCloseCurlyBrace);
        }
        Action.reindent(lines, cursorPos);
        return;
      }


      if (statementEnd && trimmedLine.indexOf(";") != trimmedLine.length - 1 && trimmedLine.slice(-1) != "{" && trimmedLine.slice(-1) != "}" && trimmedLine.slice(-2) != "||")
      {
        statementEnd = false;
        statementEndIndentSpace = lines[i].match(/^\s*/)[0].length;
      }

      if (indexOfCloseCurlyBrace != -1)
      {
        offset = offset.substr(2);
      }

      if (!statementEnd)
      {
        if (trimmedLine.slice(-1) == "{" || trimmedLine.slice(-2) == "||" && trimmedLine.slice(-1) == "}")
        {
          statementEnd = true;
          lines[i] = offset + lines[i].trim();
        } 
        else 
        {
          lines[i] = offset + lines[i].match(/^\s*/)[0].substr(statementEndIndentSpace) + lines[i].trim();
          if (trimmedLine.indexOf(";") == trimmedLine.length - 1)
          {
            statementEnd = true;
          }
        }
      }
      else
      {
        lines[i] = offset + lines[i].trim();
      }

      if (indexOfOpenCurlyBrace != -1)
      {
        offset += "  ";
      }
    }

    if (i != lines.length -1)
    {
      codeAfterIndent += lines[i] + "\n";
    } else {
      codeAfterIndent += lines[i];
    }
  }
  
  if(Page.codeMirrorOn) 
  {
    Page.codeMirrorEditor6.dispatch({
      changes: {from: 0, to: Page.codeMirrorEditor6.state.doc.length, insert: codeAfterIndent}
    })

  }
  
  // Refactoring definitive text location
  Action.updateCurrentUmpleTextBeingEdited(codeAfterIndent);

  var cursorLine = Page.getRawUmpleCodeCM6().split("\n")[Page.codeMirrorEditor6.state.doc.lineAt(Page.codeMirrorEditor6.state.selection.main.head).number];
  var whiteSpace = cursorLine.match(/^\s*/)[0].length;

  if (cursorPos.ch >= cursorLine.trim().length) 
  {
    Page.codeMirrorEditor6.dispatch({selection: {anchor: (cursorPos.line), head: (cursorLine.trim().length + whiteSpace)}});
  }
  else if (cursorPos.ch >= 0)
  {
    Page.codeMirrorEditor6.dispatch({selection: {anchor: (cursorPos.line), head: (cursorPos.ch+whiteSpace)}});  
  }
  else
  {
   const position = Page.codeMirrorEditor6.state.selection.main.head;
   Page.codeMirrorEditor6.dispatch({selection: {anchor: position, head: position}});
  }

  Page.codeMirrorEditor6.focus();
}
