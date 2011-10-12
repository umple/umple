/*
 * @(#)MatchType.java
 *
  * Copyright (c) 2004-2005 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.teddy.regex;

/**
 * Typesafe Enumeration of Syntaxes for the Parser.
 *
 * @author  Werner Randelshofer
 * @version $Id: MatchType.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class MatchType  /*implements Comparable*/ {
    private MatchType() {
    }

    public static final MatchType CONTAINS = new MatchType();
    public static final MatchType STARTS_WITH = new MatchType();
    public static final MatchType FULL_WORD = new MatchType();
}
