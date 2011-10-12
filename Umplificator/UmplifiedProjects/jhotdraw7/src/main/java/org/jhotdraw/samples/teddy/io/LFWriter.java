/*
 * @(#)LFWriter.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.teddy.io;

import java.io.*;

/**
 * A character-output stream that converts line terminators into a configurable
 * line separator sequence.  A line is considered to be terminated by
 * any one of a line feed ('\n'), a carriage return ('\r'), or a carriage return
 * followed immediately by a linefeed.
 *
 * @author  Werner Randelshofer
 * @version $Id: LFWriter.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class LFWriter extends FilterWriter {
    /**
     * Line separator string.
     */
    private String lineSeparator = "\n";
    
    /** If the next character is a line feed, skip it */
    private boolean skipLF;
    
    /**
     * Create a new line-numbering writer.
     */
    public LFWriter(Writer out) {
        super(out);
        lineSeparator = (String) System.getProperty("line.separator");
    }
    
    /**
     * Gets the line separator of the println() methods.
     */
    public String getLineSeparator() {
        return lineSeparator;
    }
    
    /**
     * Sets the line separator for the println() methods.
     */
    public void setLineSeparator(String lineSeparator) {
        this.lineSeparator = lineSeparator;
    }
    
    /**
     * Write a single character.
     *
     * @exception  IOException  If an I/O error occurs
     */
    @Override
    public void write(int c) throws IOException {
        switch (c) {
            case '\r':
                out.write(lineSeparator);
                skipLF = true;
                break;
            case '\n':
                if (!skipLF) out.write(lineSeparator);
                skipLF = false;
                break;
            default :
                out.write(c);
                skipLF = false;
                break;
        }
    }
    
    /**
     * Write a portion of an array of characters.
     *
     * @param  cbuf  Buffer of characters to be written
     * @param  off   Offset from which to start reading characters
     * @param  len   Number of characters to be written
     *
     * @exception  IOException  If an I/O error occurs
     */
    @Override
    public void write(char cbuf[], int off, int len) throws IOException {
        int end = off + len;
        for (int i=off; i < end; i++) {
            switch (cbuf[i]) {
                case '\r':
                    out.write(cbuf, off, i - off);
                    off = i + 1;
                    out.write(lineSeparator);
                    skipLF = true;
                    break;
                case '\n':
                    out.write(cbuf, off, i - off);
                    off = i + 1;
                    if (skipLF) {
                        skipLF = false;
                    } else {
                        out.write(lineSeparator);
                    }
                    break;
                default :
                    skipLF = false;
                    break;
            }
        }
        if (off < end) out.write(cbuf, off, end - off);
    }
    
    /**
     * Write a portion of a string.
     *
     * @param  str  String to be written
     * @param  off  Offset from which to start reading characters
     * @param  len  Number of characters to be written
     *
     * @exception  IOException  If an I/O error occurs
     */
    public void write(String str, int off, int len) throws IOException {
        write(str.toCharArray(), off, len);
    }
}
