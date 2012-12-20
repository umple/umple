/*
 * @(#)URIUtil.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.net;

import java.io.File;
import java.net.URI;

/**
 * URIUtil.
 *
 * @author Werner Randelshofer
 * @version $Id: URIUtil.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class URIUtil {

    /** Prevent instance creation. */
    private void URIUtil() {
    }

    /** Returns the name of an URI for display in the title bar of a window. */
    public static String getName(URI uri) {
        if (uri.getScheme()!=null&&uri.getScheme().equals("file")) {
            return new File(uri).getName();
        }
        return uri.toString();
    }
}
