/*
 * @(#)StreamPosTokenizer.java
 *
 * Copyright (c) 1999-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.io;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.*;
import java.util.Vector;

/**
 * This extension of <code>StreamTokenizer</code> keeps track
 * of the position of the tokens in the input stream, and it can
 * parse hexadecimal numbers and double numbers with exponents.
 * <p>
 * The handling of numeric data is also different: a single dot
 * '.' and minus dot '-.' are not treated as numbers.
 *
 * @author  Werner Randelshofer, Hausmatt 10, Immensee, CH-6405, Switzerland
 * @version $Id: StreamPosTokenizer.java 717 2010-11-21 12:30:57Z rawcoder $
 */


public class StreamPosTokenizer
        /*extends StreamTokenizer*/ {
    @Nullable private Reader reader = null;
    
    /**
     * Position of the next character that will be read from the file.
     * rlw
     */
    private int readpos = 0;
    
    /**
     * Start and end position of the current token.
     * rlw
     */
    private int startpos = -1, endpos = -1;
    private Vector<Integer> unread = new Vector<Integer>();
    
    private char buf[] = new char[20];
    
    /**
     * The next character to be considered by the nextToken method.  May also
     * be NEED_CHAR to indicate that a new character should be read, or SKIP_LF
     * to indicate that a new character should be read and, if it is a '\n'
     * character, it should be discarded and a second new character should be
     * read.
     */
    private int peekc = NEED_CHAR;
    
    private static final int NEED_CHAR = Integer.MAX_VALUE;
    private static final int SKIP_LF = Integer.MAX_VALUE - 1;
    
    private boolean pushedBack;
    private boolean forceLower;
    /** The line number of the last token read */
    private int lineno = 1;
    
    private boolean eolIsSignificantP = false;
    private boolean slashSlashCommentsP = false;
    private boolean slashStarCommentsP = false;
    
    // rlw
    private char[] slashSlash = new char[] {'/','/'};
    private char[] slashStar = new char[] {'/','*'};
    private char[] starSlash = new char[] {'*','/'};
    
    private byte ctype[] = new byte[256];
    private static final byte CT_WHITESPACE = 1;
    private static final byte CT_DIGIT = 2;
    private static final byte CT_ALPHA = 4;
    private static final byte CT_QUOTE = 8;
    private static final byte CT_COMMENT = 16;
    
    private boolean isParseHexNumbers = false;
    private boolean isParseExponents = false;
    
    /**
     * After a call to the <code>nextToken</code> method, this field
     * contains the type of the token just read. For a single character
     * token, its value is the single character, converted to an integer.
     * For a quoted string token (see , its value is the quote character.
     * Otherwise, its value is one of the following:
     * <ul>
     * <li><code>TT_WORD</code> indicates that the token is a word.
     * <li><code>TT_NUMBER</code> indicates that the token is a number.
     * <li><code>TT_EOL</code> indicates that the end of line has been read.
     *     The field can only have this value if the
     *     <code>eolIsSignificant</code> method has been called with the
     *     argument <code>true</code>.
     * <li><code>TT_EOF</code> indicates that the end of the input stream
     *     has been reached.
     * </ul>
     *
     * @see     java.io.StreamTokenizer#eolIsSignificant(boolean)
     * @see     java.io.StreamTokenizer#nextToken()
     * @see     java.io.StreamTokenizer#quoteChar(int)
     * @see     java.io.StreamTokenizer#TT_EOF
     * @see     java.io.StreamTokenizer#TT_EOL
     * @see     java.io.StreamTokenizer#TT_NUMBER
     * @see     java.io.StreamTokenizer#TT_WORD
     */
    public int ttype = TT_NOTHING;
    
    /**
     * A constant indicating that the end of the stream has been read.
     */
    public static final int TT_EOF = -1;
    
    /**
     * A constant indicating that the end of the line has been read.
     */
    public static final int TT_EOL = '\n';
    
    /**
     * A constant indicating that a number token has been read.
     */
    public static final int TT_NUMBER = -2;
    
    /**
     * A constant indicating that a word token has been read.
     */
    public static final int TT_WORD = -3;
    
    /* A constant indicating that no token has been read, used for
     * initializing ttype.  FIXME This could be made public and
     * made available as the part of the API in a future release.
     */
    private static final int TT_NOTHING = -4;
    
    /**
     * If the current token is a word token, this field contains a
     * string giving the characters of the word token. When the current
     * token is a quoted string token, this field contains the body of
     * the string.
     * <p>
     * The current token is a word when the value of the
     * <code>ttype</code> field is <code>TT_WORD</code>. The current token is
     * a quoted string token when the value of the <code>ttype</code> field is
     * a quote character.
     *
     * @see     java.io.StreamTokenizer#quoteChar(int)
     * @see     java.io.StreamTokenizer#TT_WORD
     * @see     java.io.StreamTokenizer#ttype
     */
    public String sval;
    
    /**
     * If the current token is a number, this field contains the value
     * of that number. The current token is a number when the value of
     * the <code>ttype</code> field is <code>TT_NUMBER</code>.
     *
     * @see     java.io.StreamTokenizer#TT_NUMBER
     * @see     java.io.StreamTokenizer#ttype
     */
    public double nval;
    
    /** Initializes everything except the streams. */
    public StreamPosTokenizer() {
        wordChars('a', 'z');
        wordChars('A', 'Z');
        wordChars(128 + 32, 255);
        whitespaceChars(0, ' ');
        commentChar('/');
        quoteChar('"');
        quoteChar('\'');
        parseNumbers();
    }
    
    
    /**
     * Create a tokenizer that parses the given character stream.
     * @since   JDK1.1
     */
    public StreamPosTokenizer(Reader r) {
        this();
        if (r == null) {
            throw new NullPointerException();
        }
        reader = r;
    }
    
    /**
     * Sets the reader for the tokenizer.
     * 
     * @param r
     */
    public void setReader(Reader r) {
        this.reader = r;
        readpos = 0;
        unread.clear();
        peekc = NEED_CHAR;
        pushedBack = false;
        forceLower = false;
        lineno = 0;
        startpos = endpos = -1;
        ttype = TT_NOTHING;
    }
    
    /**
     * Resets this tokenizer's syntax table so that all characters are
     * "ordinary." See the <code>ordinaryChar</code> method
     * for more information on a character being ordinary.
     *
     * @see     java.io.StreamTokenizer#ordinaryChar(int)
     */
    public void resetSyntax() {
        for (int i = ctype.length; --i >= 0;)
            ctype[i] = 0;
    }
    
    /**
     * Specifies that all characters <i>c</i> in the range
     * <code>low&nbsp;&lt;=&nbsp;<i>c</i>&nbsp;&lt;=&nbsp;high</code>
     * are word constituents. A word token consists of a word constituent
     * followed by zero or more word constituents or number constituents.
     *
     * @param   low   the low end of the range.
     * @param   hi    the high end of the range.
     */
    public void wordChars(int low, int hi) {
        if (low < 0)
            low = 0;
        if (hi >= ctype.length)
            hi = ctype.length - 1;
        while (low <= hi)
            ctype[low++] |= CT_ALPHA;
    }
    
    /**
     * Specifies that all characters <i>c</i> in the range
     * <code>low&nbsp;&lt;=&nbsp;<i>c</i>&nbsp;&lt;=&nbsp;high</code>
     * are white space characters. White space characters serve only to
     * separate tokens in the input stream.
     *
     * @param   low   the low end of the range.
     * @param   hi    the high end of the range.
     */
    public void whitespaceChars(int low, int hi) {
        if (low < 0)
            low = 0;
        if (hi >= ctype.length)
            hi = ctype.length - 1;
        while (low <= hi)
            ctype[low++] = CT_WHITESPACE;
    }
    
    /**
     * Specifies that all characters <i>c</i> in the range
     * <code>low&nbsp;&lt;=&nbsp;<i>c</i>&nbsp;&lt;=&nbsp;high</code>
     * are "ordinary" in this tokenizer. See the
     * <code>ordinaryChar</code> method for more information on a
     * character being ordinary.
     *
     * @param   low   the low end of the range.
     * @param   hi    the high end of the range.
     * @see     java.io.StreamTokenizer#ordinaryChar(int)
     */
    public void ordinaryChars(int low, int hi) {
        if (low < 0)
            low = 0;
        if (hi >= ctype.length)
            hi = ctype.length - 1;
        while (low <= hi)
            ctype[low++] = 0;
    }
    
    /**
     * Specifies that the character argument is "ordinary"
     * in this tokenizer. It removes any special significance the
     * character has as a comment character, word component, string
     * delimiter, white space, or number character. When such a character
     * is encountered by the parser, the parser treates it as a
     * single-character token and sets <code>ttype</code> field to the
     * character value.
     *
     * @param   ch   the character.
     * @see     java.io.StreamTokenizer#ttype
     */
    public void ordinaryChar(int ch) {
        if (ch >= 0 && ch < ctype.length)
            ctype[ch] = 0;
    }
    
    /**
     * Specified that the character argument starts a single-line
     * comment. All characters from the comment character to the end of
     * the line are ignored by this stream tokenizer.
     *
     * @param   ch   the character.
     */
    public void commentChar(int ch) {
        if (ch >= 0 && ch < ctype.length)
            ctype[ch] = CT_COMMENT;
    }
    
    /**
     * Specifies that matching pairs of this character delimit string
     * constants in this tokenizer.
     * <p>
     * When the <code>nextToken</code> method encounters a string
     * constant, the <code>ttype</code> field is set to the string
     * delimiter and the <code>sval</code> field is set to the body of
     * the string.
     * <p>
     * If a string quote character is encountered, then a string is
     * recognized, consisting of all characters after (but not including)
     * the string quote character, up to (but not including) the next
     * occurrence of that same string quote character, or a line
     * terminator, or end of file. The usual escape sequences such as
     * <code>"&#92;n"</code> and <code>"&#92;t"</code> are recognized and
     * converted to single characters as the string is parsed.
     *
     * @param   ch   the character.
     * @see     java.io.StreamTokenizer#nextToken()
     * @see     java.io.StreamTokenizer#sval
     * @see     java.io.StreamTokenizer#ttype
     */
    public void quoteChar(int ch) {
        if (ch >= 0 && ch < ctype.length)
            ctype[ch] = CT_QUOTE;
    }
    
    /**
     * Specifies that numbers should be parsed by this tokenizer. The
     * syntax table of this tokenizer is modified so that each of the twelve
     * characters:
     * <blockquote><pre>
     *      0 1 2 3 4 5 6 7 8 9 . -
     * </pre></blockquote>
     * <p>
     * has the "numeric" attribute.
     * <p>
     * When the parser encounters a word token that has the format of a
     * double precision floating-point number, it treats the token as a
     * number rather than a word, by setting the the <code>ttype</code>
     * field to the value <code>TT_NUMBER</code> and putting the numeric
     * value of the token into the <code>nval</code> field.
     *
     * @see     java.io.StreamTokenizer#nval
     * @see     java.io.StreamTokenizer#TT_NUMBER
     * @see     java.io.StreamTokenizer#ttype
     */
    public void parseNumbers() {
        for (int i = '0'; i <= '9'; i++)
            ctype[i] |= CT_DIGIT;
        ctype['.'] |= CT_DIGIT;
        ctype['-'] |= CT_DIGIT;
        //ctype['+'] |= CT_DIGIT; // rlw
    }
    
    public void parsePlusAsNumber() {
        ctype['+'] |= CT_DIGIT;
    }
    
    /**
     * Enables number parsing for decimal numbers and for hexadecimal numbers
     */
    public void parseHexNumbers() {
        parseNumbers();
        isParseHexNumbers = true;
    }
    /**
     * Enables number parsing of exponents.
     * Exponents appear after the last digit of number with capital letter 'E'
     * or small letter 'e'.
     */
    public void parseExponents() {
        parseNumbers();
        isParseExponents = true;
    }
    
    /**
     * Determines whether or not ends of line are treated as tokens.
     * If the flag argument is true, this tokenizer treats end of lines
     * as tokens; the <code>nextToken</code> method returns
     * <code>TT_EOL</code> and also sets the <code>ttype</code> field to
     * this value when an end of line is read.
     * <p>
     * A line is a sequence of characters ending with either a
     * carriage-return character (<code>'&#92;r'</code>) or a newline
     * character (<code>'&#92;n'</code>). In addition, a carriage-return
     * character followed immediately by a newline character is treated
     * as a single end-of-line token.
     * <p>
     * If the <code>flag</code> is false, end-of-line characters are
     * treated as white space and serve only to separate tokens.
     *
     * @param   flag   <code>true</code> indicates that end-of-line characters
     *                 are separate tokens; <code>false</code> indicates that
     *                 end-of-line characters are white space.
     * @see     java.io.StreamTokenizer#nextToken()
     * @see     java.io.StreamTokenizer#ttype
     * @see     java.io.StreamTokenizer#TT_EOL
     */
    public void eolIsSignificant(boolean flag) {
        eolIsSignificantP = flag;
    }
    
    /**
     * Determines whether or not the tokenizer recognizes C-style comments.
     * If the flag argument is <code>true</code>, this stream tokenizer
     * recognizes C-style comments. All text between successive
     * occurrences of <code>/*</code> and <code>*&#47;</code> are discarded.
     * <p>
     * If the flag argument is <code>false</code>, then C-style comments
     * are not treated specially.
     *
     * @param   flag   <code>true</code> indicates to recognize and ignore
     *                 C-style comments.
     */
    public void slashStarComments(boolean flag) {
        slashStarCommentsP = flag;
    }
    
    /**
     * Determines whether or not the tokenizer recognizes C++-style comments.
     * If the flag argument is <code>true</code>, this stream tokenizer
     * recognizes C++-style comments. Any occurrence of two consecutive
     * slash characters (<code>'/'</code>) is treated as the beginning of
     * a comment that extends to the end of the line.
     * <p>
     * If the flag argument is <code>false</code>, then C++-style
     * comments are not treated specially.
     *
     * @param   flag   <code>true</code> indicates to recognize and ignore
     *                 C++-style comments.
     */
    public void slashSlashComments(boolean flag) {
        slashSlashCommentsP = flag;
    }
    
    /**
     * Determines whether or not word token are automatically lowercased.
     * If the flag argument is <code>true</code>, then the value in the
     * <code>sval</code> field is lowercased whenever a word token is
     * returned (the <code>ttype</code> field has the
     * value <code>TT_WORD</code> by the <code>nextToken</code> method
     * of this tokenizer.
     * <p>
     * If the flag argument is <code>false</code>, then the
     * <code>sval</code> field is not modified.
     *
     * @param   fl   <code>true</code> indicates that all word tokens should
     *               be lowercased.
     * @see     java.io.StreamTokenizer#nextToken()
     * @see     java.io.StreamTokenizer#ttype
     * @see     java.io.StreamTokenizer#TT_WORD
     */
    public void lowerCaseMode(boolean fl) {
        forceLower = fl;
    }
    
    /** Read the next character */
    private int read() throws IOException {
        // rlw
        int data;
        if (unread.size() > 0) {
            data = ((Integer) unread.lastElement()).intValue();
            unread.removeElementAt(unread.size() - 1);
        } else {
            data = reader.read();
        }
        if (data != -1) { readpos++; }
        return data;
    }
    /** Unread */
    private void unread(int c) {
        unread.addElement(c);
        readpos--;
    }
    
    /**
     * Parses the next token from the input stream of this tokenizer.
     * The type of the next token is returned in the <code>ttype</code>
     * field. Additional information about the token may be in the
     * <code>nval</code> field or the <code>sval</code> field of this
     * tokenizer.
     * <p>
     * Typical clients of this
     * class first set up the syntax tables and then sit in a loop
     * calling nextToken to parse successive tokens until TT_EOF
     * is returned.
     *
     * @return     the value of the <code>ttype</code> field.
     * @exception  IOException  if an I/O error occurs.
     * @see        java.io.StreamTokenizer#nval
     * @see        java.io.StreamTokenizer#sval
     * @see        java.io.StreamTokenizer#ttype
     */
    @SuppressWarnings("empty-statement")
    public int nextToken() throws IOException {
        if (pushedBack) {
            pushedBack = false;
            return ttype;
        }
        byte ct[] = ctype;
        sval = null;
        
        int c = peekc;
        if (c < 0)
            c = NEED_CHAR;
        if (c == SKIP_LF) {
            c = read();
            if (c < 0) {
                // rlw
                startpos = endpos = readpos - 1;
                return ttype = TT_EOF;
            }
            if (c == '\n')
                c = NEED_CHAR;
        }
        if (c == NEED_CHAR) {
            c = read();
            if (c < 0) {
                // rlw
                startpos = endpos = readpos - 1;
                return ttype = TT_EOF;
            }
        }
        ttype = c;    /* Just to be safe */
        
        /* Set peekc so that the next invocation of nextToken will read
         * another character unless peekc is reset in this invocation
         */
        peekc = NEED_CHAR;
        
        int ctype = c < 256 ? ct[c] : CT_ALPHA;
        while ((ctype & CT_WHITESPACE) != 0) {
            if (c == '\r') {
                lineno++;
                if (eolIsSignificantP) {
                    peekc = SKIP_LF;
                    // rlw
                    startpos = endpos = readpos - 1;
                    return ttype = TT_EOL;
                }
                c = read();
                if (c == '\n')
                    c = read();
            } else {
                if (c == '\n') {
                    lineno++;
                    if (eolIsSignificantP) {
                        // rlw
                        startpos = endpos = readpos - 1;
                        return ttype = TT_EOL;
                    }
                }
                c = read();
            }
            if (c < 0) {
                // rlw
                startpos = endpos = readpos;
                return ttype = TT_EOF;
            }
            ctype = c < 256 ? ct[c] : CT_ALPHA;
        }
        
        // rlw
        startpos = readpos - 1;
        
        // rlw hexadecimal
        hex: if (((ctype & CT_DIGIT) != 0) &&
                c == '0' && isParseHexNumbers) {
            c = read();
            if (c == 'x') {
                int digits = 0;
                long hval = 0;
                while (digits < 16) {
                    c = read();
                    if (c >= '0' && c <= '9') {
                        hval = (hval << 4) | (c - '0');
                    } else if (c >= 'A' && c <= 'F') {
                        hval = (hval << 4) | (c - 'A' + 10);
                    } else if (c >= 'a' && c <= 'f') {
                        hval = (hval << 4) | (c - 'a' + 10);
                    } else {
                        unread(c);
                        if (digits == 0) {
                            sval = "0x";
                            endpos = readpos - 1;
                            return ttype = TT_WORD;
                        } else {
                            nval = (double) hval;
                            endpos = readpos - 1;
                            return ttype = TT_NUMBER;
                        }
                    }
                    digits++;
                }
                nval = (double) hval;
                endpos = readpos - 1;
                return ttype = TT_NUMBER;
            } else {
                unread(c);
                c = '0';
            }
        }
        
        digit: if ((ctype & CT_DIGIT) != 0) {
            int digits = 0;
            boolean neg = false;
            if (c == '-') {
                c = read();
                if (c != '.' && (c < '0' || c > '9')) {
                    peekc = c;
                    // rlw
                    if (('-' & CT_ALPHA) != 0) {
                        unread(c);
                        c = '-';
                        break digit;
                    } else {
                        endpos = readpos - 1;
                        return ttype = '-';
                    }
                }
                neg = true;
            } else if (c == '+') {
                c = read();
                if (c != '.' && (c < '0' || c > '9')) {
                    peekc = c;
                    // rlw
                    if (('+' & CT_ALPHA) != 0) {
                        unread(c);
                        c = '+';
                        break digit;
                    } else {
                        endpos = readpos - 1;
                        return ttype = '-';
                    }
                }
                neg = false;
            }
            
            double v = 0;
            int decexp = 0;
            int seendot = 0;
            while (true) {
                if (c == '.' && seendot == 0)
                    seendot = 1;
                else if ('0' <= c && c <= '9') {
                    digits++;
                    v = v * 10 + (c - '0');
                    decexp += seendot;
                } else
                    break;
                c = read();
            }
            peekc = c;
            if (decexp != 0) {
                double denom = 10;
                decexp--;
                while (decexp > 0) {
                    denom *= 10;
                    decexp--;
                }
                /* Do one division of a likely-to-be-more-accurate number */
                v = v / denom;
            }
            nval = neg ? -v : v;
            // rlw
            endpos = (c == -1) ? readpos - 1 : readpos - 2;
            if (digits == 0) {
                if (('.' & CT_ALPHA) != 0) {
                    unread(c);
                    if (neg) {
                        unread('.');
                        c = '-';
                    } else {
                        read(); // consume full stop
                        c = '.';
                    }
                    break digit;
                } else {
                    return ttype = '.';
                }
            } else {
                if (isParseExponents) {
                    if (c == 'E' || c == 'e') {
                        c = read();
                        
                        digits = 0;
                        neg = false;
                        if (c == '-') {
                            c = read();
                            if (c < '0' || c > '9') {
                                unread(c);
                                unread('E');
                                return ttype = TT_NUMBER;
                            }
                            neg = true;
                        }
                        v = 0;
                        decexp = 0;
                        while (true) {
                            if ('0' <= c && c <= '9') {
                                digits++;
                                v = v * 10 + (c - '0');
                            } else {
                                break;
                            }
                            c = read();
                        }
                        peekc = c;
                        nval *= Math.pow(10, (neg) ? -v : v);
                    }
                }
                return ttype = TT_NUMBER;
            }
        }
        
        if ((ctype & CT_ALPHA) != 0) {
            int i = 0;
            do {
                if (i >= buf.length) {
                    char nb[] = new char[buf.length * 2];
                    System.arraycopy(buf, 0, nb, 0, buf.length);
                    buf = nb;
                }
                buf[i++] = (char) c;
                c = read();
                ctype = c < 0 ? CT_WHITESPACE : c < 256 ? ct[c] : CT_ALPHA;
            } while ((ctype & (CT_ALPHA | CT_DIGIT)) != 0);
            peekc = c;
            sval = String.copyValueOf(buf, 0, i);
            if (forceLower)
                sval = sval.toLowerCase();
            // rlw EOF must be treated specially
            endpos = (c == -1) ? readpos - 1 : readpos - 2;
            return ttype = TT_WORD;
        }
        
        if ((ctype & CT_QUOTE) != 0) {
            ttype = c;
            int i = 0;
            /* Invariants (because \Octal needs a lookahead):
             *   (i)  c contains char value
             *   (ii) d contains the lookahead
             */
            int d = read();
            while (d >= 0 && d != ttype && d != '\n' && d != '\r') {
                if (d == '\\') {
                    c = read();
                    int first = c;   /* To allow \377, but not \477 */
                    if (c >= '0' && c <= '7') {
                        c = c - '0';
                        int c2 = read();
                        if ('0' <= c2 && c2 <= '7') {
                            c = (c << 3) + (c2 - '0');
                            c2 = read();
                            if ('0' <= c2 && c2 <= '7' && first <= '3') {
                                c = (c << 3) + (c2 - '0');
                                d = read();
                            } else
                                d = c2;
                        } else
                            d = c2;
                    } else {
                        switch (c) {
                            case 'a':
                                c = 0x7;
                                break;
                            case 'b':
                                c = '\b';
                                break;
                            case 'f':
                                c = 0xC;
                                break;
                            case 'n':
                                c = '\n';
                                break;
                            case 'r':
                                c = '\r';
                                break;
                            case 't':
                                c = '\t';
                                break;
                            case 'v':
                                c = 0xB;
                                break;
                        }
                        d = read();
                    }
                } else {
                    c = d;
                    d = read();
                }
                if (i >= buf.length) {
                    char nb[] = new char[buf.length * 2];
                    System.arraycopy(buf, 0, nb, 0, buf.length);
                    buf = nb;
                }
                buf[i++] = (char)c;
            }
            
            /* If we broke out of the loop because we found a matching quote
             * character then arrange to read a new character next time
             * around; otherwise, save the character.
             */
            peekc = (d == ttype) ? NEED_CHAR : d;
            
            sval = String.copyValueOf(buf, 0, i);
            // rlw
            endpos = readpos - 2;
            return ttype;
        }
        /* rlw*/
        /*
        if (c == '/' && (slashSlashCommentsP || slashStarCommentsP)) {
            c = read();
            if (c == '*' && slashStarCommentsP) {
                int prevc = 0;
                while ((c = read()) != '/' || prevc != '*') {
                    if (c == '\r') {
                        lineno++;
                        c = read();
                        if (c == '\n') {
                            c = read();
                        }
                    } else {
                        if (c == '\n') {
                            lineno++;
                            c = read();
                        }
                    }
                    if (c < 0) {
                        endpos = readpos;
                        return ttype = TT_EOF;
                    }
                    prevc = c;
                }
                return nextToken();
            } else if (c == '/' && slashSlashCommentsP) {
                while ((c = read()) != '\n' && c != '\r' && c >= 0);
                peekc = c;
                return nextToken();
            } else {
                // Now see if it is still a single line comment
                if ((ct['/'] & CT_COMMENT) != 0) {
                    while ((c = read()) != '\n' && c != '\r' && c >= 0);
                    peekc = c;
                    return nextToken();
                } else {
                    peekc = c;
                    // rlw
                    endpos = readpos - 2;
                    return ttype = '/';
                }
            }
        }*/
        
        if (slashSlashCommentsP && c == slashSlash[0]
                || slashStarCommentsP && c == slashStar[0]) {
            if (c == slashStar[0] && slashStar.length == 1) {
                // This is the scanner code if the slashStar token
                // is one characters long
                while ((c = read()) != starSlash[0]) {
                    if (c == '\r') {
                        lineno++;
                        c = read();
                        if (c == '\n') {
                            c = read();
                        }
                    } else {
                        if (c == '\n') {
                            lineno++;
                            c = read();
                        }
                    }
                    if (c < 0) {
                        endpos = readpos;
                        return ttype = TT_EOF;
                    }
                }
                return nextToken();
            } else if (c == slashSlash[0] && slashSlash.length == 1) {
                // This is the scanner code if the slashSlash token
                // is one characters long
                while ((c = read()) != '\n' && c != '\r' && c >= 0);
                peekc = c;
                return nextToken();
            } else {
                // This is the scanner code if the slashStar and the slashSlash
                // tokens are two characters long
                c = read();
                if (c == slashStar[1] && slashStarCommentsP) {
                    int prevc = 0;
                    while ((c = read()) != starSlash[1] || prevc != starSlash[0]) {
                        if (c == '\r') {
                            lineno++;
                            c = read();
                            if (c == '\n') {
                                c = read();
                            }
                        } else {
                            if (c == '\n') {
                                lineno++;
                                c = read();
                            }
                        }
                        if (c < 0) {
                            endpos = readpos;
                            return ttype = TT_EOF;
                        }
                        prevc = c;
                    }
                    return nextToken();
                } else if (c == slashSlash[1] && slashSlashCommentsP) {
                    while ((c = read()) != '\n' && c != '\r' && c >= 0);
                    peekc = c;
                    return nextToken();
                } else {
                    // Now see if it is still a single line comment
                    if ((ct[slashSlash[0]] & CT_COMMENT) != 0) {
                        while ((c = read()) != '\n' && c != '\r' && c >= 0);
                        peekc = c;
                        return nextToken();
                    } else {
                        peekc = c;
                        // rlw
                        endpos = readpos - 2;
                        return ttype = slashSlash[0];
                    }
                }
            }
        }
        
        if ((ctype & CT_COMMENT) != 0) {
            while ((c = read()) != '\n' && c != '\r' && c >= 0);
            peekc = c;
            //lineno++;  removed because it counts line break twice
            return nextToken();
        }
        
        // rlw
        endpos = readpos - 1;
        return ttype = c;
    }
    /**
     * Reads the next character from the input stream, without
     * passing it to the tokenizer.
     */
    public int nextChar() throws IOException {
        if (pushedBack) {
            throw new IllegalStateException("can't read char when a token has been pushed back");
        }
        if (peekc == NEED_CHAR) {
            return read();
        } else {
            int ch = peekc;
            peekc = NEED_CHAR;
            return ch;
        }
    }
    /**
     * Unreads a character back into the input stream of the tokenizer.
     */
    public void pushCharBack(int ch) throws IOException {
        if (pushedBack) {
            throw new IllegalStateException("can't push back char when a token has been pushed back");
        }
        if (peekc == NEED_CHAR) {
            unread(ch);
        } else {
            unread(peekc);
            peekc = NEED_CHAR;
            unread(ch);
        }
    }
    /**
     * Sets the slash star and star slash tokens.
     * Due to limitations by this implementation, both tokens must have the
     * same number of characters and the character length must be either 1
     * or 2.
     */
    public void setSlashStarTokens(String slashStar, String starSlash) {
        if (slashStar.length() != starSlash.length()) {
            throw new IllegalArgumentException("SlashStar and StarSlash tokens must be of same length: '"+slashStar+"' '"+starSlash+"'");
        }
        if (slashStar.length() < 1 || slashStar.length() > 2) {
            throw new IllegalArgumentException("SlashStar and StarSlash tokens must be of length 1 or 2: '"+slashStar+"' '"+starSlash+"'");
        }
        this.slashStar = slashStar.toCharArray();
        this.starSlash = starSlash.toCharArray();
        commentChar(this.slashStar[0]);
    }
    /**
     * Sets the slash slash token.
     * Due to limitations by this implementation, the character length must be
     * either 1 or 2.
     */
    public void setSlashSlashToken(String slashSlash) {
        if (slashSlash.length() < 1 || slashSlash.length() > 2) {
            throw new IllegalArgumentException("SlashSlash token must be of length 1 or 2: '"+slashSlash+"'");
        }
        this.slashSlash = slashSlash.toCharArray();
        commentChar(this.slashSlash[0]);
    }
    
    /**
     * Causes the next call to the <code>nextToken</code> method of this
     * tokenizer to return the current value in the <code>ttype</code>
     * field, and not to modify the value in the <code>nval</code> or
     * <code>sval</code> field.
     *
     * @see     java.io.StreamTokenizer#nextToken()
     * @see     java.io.StreamTokenizer#nval
     * @see     java.io.StreamTokenizer#sval
     * @see     java.io.StreamTokenizer#ttype
     */
    public void pushBack() {
        if (ttype != TT_NOTHING)   /* No-op if nextToken() not called */
            pushedBack = true;
    }
    
    /**
     * Return the current line number.
     *
     * @return  the current line number of this stream tokenizer.
     */
    public int lineno() {
        return lineno;
    }
    
    /**
     * Returns the start position of the token relative
     * to the position that the stream had, when the
     * StreamPosTokenizer was constructed.
     *
     * @return  the start position of the token.
     */
    public int getStartPosition() {
        return startpos;
    }
    /**
     * Set the start position of the current token.
     */
    public void setStartPosition(int p) {
        startpos = p;
    }
    /**
     * Returns the end position of the token relative
     * to the position that the stream had, when the
     * StreamPosTokenizer was constructed.
     *
     * @return  the end position of the token.
     */
    public int getEndPosition() {
        return endpos;
    }
    
    /**
     * Consumes a substring from the current sval of the StreamPosTokenizer.
     */
    public void consumeGreedy(String greedyToken) {
        if (greedyToken.length() < sval.length()) {
            pushBack();
            setStartPosition(getStartPosition() + greedyToken.length());
            sval = sval.substring(greedyToken.length());
        }
    }
    /**
     * Returns the string representation of the current stream token.
     *
     * @return  a string representation of the token specified by the
     *          <code>ttype</code>, <code>nval</code>, and <code>sval</code>
     *          fields.
     * @see     java.io.StreamTokenizer#nval
     * @see     java.io.StreamTokenizer#sval
     * @see     java.io.StreamTokenizer#ttype
     */
    @Override
    public String toString() {
        String ret;
        switch (ttype) {
            case TT_EOF:
                ret = "EOF";
                break;
            case TT_EOL:
                ret = "EOL";
                break;
            case TT_WORD:
                ret = sval;
                break;
            case TT_NUMBER:
                ret = "n=" + nval;
                break;
            case TT_NOTHING:
                ret = "NOTHING";
                break;
            default:{
                char s[] = new char[3];
                s[0] = s[2] = '\'';
                s[1] = (char) ttype;
                ret = new String(s);
                break;
            }
        }
        return "Token[" + ret + "], line " + lineno;
    }
}
