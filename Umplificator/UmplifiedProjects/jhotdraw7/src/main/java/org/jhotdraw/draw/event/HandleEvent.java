/*
 * @(#)HandleEvent.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.event;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.*;
import java.awt.*;
import java.util.*;
/**
 * An {@code EventObject} sent to {@link HandleListener}s.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Observer</em><br>
 * State changes of handles can be observed by other objects. Specifically
 * {@code DrawingView} observes area invalidations and remove requests of
 * handles.<br>
 * Subject: {@link Handle}; Observer: {@link HandleListener}; Event:
 * {@link HandleEvent}; Concrete Observer: {@link DrawingView}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: HandleEvent.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class HandleEvent extends EventObject {
    @Nullable private Rectangle invalidatedArea;
    
    /** Creates a new instance. */
    public HandleEvent(Handle src, @Nullable Rectangle invalidatedArea) {
        super(src);
        this.invalidatedArea = invalidatedArea;
    }
    
    public Handle getHandle() {
        return (Handle) getSource();
    }
    /**
     *  Gets the bounds of the invalidated area on the drawing view.
     */
    @Nullable public Rectangle getInvalidatedArea() {
        return invalidatedArea;
    }
}
