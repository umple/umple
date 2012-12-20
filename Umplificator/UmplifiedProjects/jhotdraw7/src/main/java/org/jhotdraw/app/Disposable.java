/*
 * @(#)Disposable.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app;

import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * Interface for objects which explicitly must be disposed to free resources.
 *
 * @author Werner Randelshofer
 * @version $Id: Disposable.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface Disposable {
    /** Disposes of all resources held by this object so that they can be
     * garbage collected.
     */
    public void dispose();
}
