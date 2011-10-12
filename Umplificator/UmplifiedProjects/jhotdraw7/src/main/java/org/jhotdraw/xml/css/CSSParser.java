/*
 * @(#)CSSLoader.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 *
 * Original code taken from article "Swing and CSS" by Joshua Marinacci 10/14/2003
 * http://today.java.net/pub/a/today/2003/10/14/swingcss.html
 */

package org.jhotdraw.xml.css;

import java.io.*;
import java.util.*;
/**
 * Parsers a Cascading Style Sheet (CSS).
 * <pre>
 * IDENT  {ident}
 * ATKEYWORD  @{ident}
 * STRING  {string}
 * INVALID  {invalid}
 * HASH  #{name}
 * NUMBER  {num}
 * PERCENTAGE  {num}%
 * DIMENSION  {num}{ident}
 * URI  url\({w}{string}{w}\)
 * |url\({w}([!#$%&*-~]|{nonascii}|{escape})*{w}\)
 * UNICODE-RANGE  U\+[0-9A-F?]{1,6}(-[0-9A-F]{1,6})?
 * CDO  <!--
 * CDC  -->
 * ;  ;
 * {  \{
 * }  \}
 * (  \(
 * )  \)
 * [  \[
 * ]  \]
 * S  [ \t\r\n\f]+
 * COMMENT  \/\*[^*]*\*+([^/*][^*]*\*+)*\/
 * FUNCTION  {ident}\(
 * INCLUDES  ~=
 * DASHMATCH  |=
 * DELIM  any other character not matched by the above rules, and neither a single nor a double quote
 *
 *
 * stylesheet  : [ CDO | CDC | S | statement ]*;
 * statement   : ruleset | at-rule;
 * at-rule     : ATKEYWORD S* any* [ block | ';' S* ];
 * block       : '{' S* [ any | block | ATKEYWORD S* | ';' S* ]* '}' S*;
 * ruleset     : selector? '{' S* declaration? [ ';' S* declaration? ]* '}' S*;
 * selector    : any+;
 * declaration : DELIM? property S* ':' S* value;
 * property    : IDENT;
 * value       : [ any | block | ATKEYWORD S* ]+;
 * any         : [ IDENT | NUMBER | PERCENTAGE | DIMENSION | STRING
 * | DELIM | URI | HASH | UNICODE-RANGE | INCLUDES
 * | DASHMATCH | FUNCTION S* any* ')'
 * | '(' S* any* ')' | '[' S* any* ']' ] S*;
 * </pre>
 *
 * @author Werner Randelshofer
 * @version $Id: CSSParser.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class CSSParser {
    public void parse(String css, StyleManager rm) throws IOException {
        parse(new StringReader(css), rm);
    }
    public void parse(Reader css, StyleManager rm) throws IOException {
        StreamTokenizer tt = new StreamTokenizer(css);
        tt.resetSyntax();
        tt.wordChars('a', 'z');
        tt.wordChars('A', 'Z');
        tt.wordChars('0', '9');
        tt.wordChars(128 + 32, 255);
        tt.whitespaceChars(0, ' ');
        tt.commentChar('/');
        tt.slashStarComments(true);
        parseStylesheet(tt, rm);
    }
    
    private void parseStylesheet(StreamTokenizer tt, StyleManager rm) throws IOException {
        while (tt.nextToken() != StreamTokenizer.TT_EOF) {
            tt.pushBack();
            parseRuleset(tt, rm);
        }
    }
    private void parseRuleset(StreamTokenizer tt, StyleManager rm) throws IOException {
        // parse selector list
        List<String> selectors = parseSelectorList(tt);
        if (tt.nextToken() != '{') throw new IOException("Ruleset '{' missing for "+selectors);
        Map<String,String> declarations = parseDeclarationMap(tt);
        if (tt.nextToken() != '}') throw new IOException("Ruleset '}' missing for "+selectors);
        
        for (String selector : selectors) {
            rm.add(new CSSRule(selector, declarations));
            
           // System.out.println("CSSParser.add("+selector+","+declarations);
            
            /*
            for (Map.Entry<String,String> entry : declarations.entrySet()) {
                   rm.add(new CSSRule(selector, entry.getKey(), entry.getValue()));
            }*/
        }
    }
    private List<String> parseSelectorList(StreamTokenizer tt) throws IOException {
        LinkedList<String> list = new LinkedList<String>();
        
        StringBuilder selector = new StringBuilder();
        boolean needsWhitespace = false;
        while (tt.nextToken() != StreamTokenizer.TT_EOF &&
                tt.ttype != '{') {
            
            switch (tt.ttype) {
                case StreamTokenizer.TT_WORD :
                    if (needsWhitespace) selector.append(' ');
                    selector.append(tt.sval);
                    needsWhitespace = true;
                    break;
                case ',' :
                    list.add(selector.toString());
                    selector.setLength(0);
                    needsWhitespace = false;
                    break;
                default :
                    if (needsWhitespace) selector.append(' ');
                    selector.append((char) tt.ttype);
                    needsWhitespace = false;
                    break;
            }
        }
        if (selector.length() != 0) {
            list.add(selector.toString());
        }
        
        tt.pushBack();
        //System.out.println("selectors:"+list);
        return list;
    }
    private Map<String,String> parseDeclarationMap(StreamTokenizer tt) throws IOException {
        HashMap<String,String> map = new HashMap<String, String>();
        
        do {
            // Parse key
            StringBuilder key = new StringBuilder();
            while (tt.nextToken() != StreamTokenizer.TT_EOF &&
                    tt.ttype != '}' && tt.ttype != ':' && tt.ttype != ';') {
                
                switch (tt.ttype) {
                    case StreamTokenizer.TT_WORD :
                        key.append(tt.sval);
                        break;
                    default :
                        key.append((char) tt.ttype);
                        break;
                }
            }
            if (tt.ttype == '}' && key.length() == 0) { break; }
            if (tt.ttype != ':') throw new IOException("Declaration ':' missing for "+key);
            
            // Parse value
            StringBuilder value = new StringBuilder();
            boolean needsWhitespace = false;
            while (tt.nextToken() != StreamTokenizer.TT_EOF &&
                    tt.ttype != ';' && tt.ttype != '}') {
                
                switch (tt.ttype) {
                    case StreamTokenizer.TT_WORD :
                        if (needsWhitespace) value.append(' ');
                        value.append(tt.sval);
                        needsWhitespace = true;
                        break;
                    default :
                        value.append((char) tt.ttype);
                        needsWhitespace = false;
                        break;
                }
            }
            
            map.put(key.toString(), value.toString());
            //System.out.println("  declaration: "+key+":"+value);
        } while (tt.ttype != '}' && tt.ttype != StreamTokenizer.TT_EOF);
        
        tt.pushBack();
        return map;
    }
}