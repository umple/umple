/*
 * @(#)HandleListener.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.draw.event;

import java.util.*;

/**
 * Interface implemented by observers of {@link org.jhotdraw.draw.handle.Handle}s.
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Observer</em><br>
 * State changes of handles can be observed by other objects. Specifically
 * {@code DrawingView} observes area invalidations and remove requests of
 * handles.<br>
 * Subject: {@link org.jhotdraw.draw.handle.Handle};
 * Observer: {@link HandleListener};
 * Event: {@link HandleEvent};
 * Concrete Observer: {@link org.jhotdraw.draw.DrawingView}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: HandleListener.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface HandleListener extends EventListener {
    /**
     * Sent when an area of the drawing view needs to be repainted.
     */
    public void areaInvalidated(HandleEvent e);
    
    /**
     * Sent when requesting to remove a handle.
     */
    public void handleRequestRemove(HandleEvent e);
    /**
     * Sent when requesting to add secondary handles.
     */
    public void handleRequestSecondaryHandles(HandleEvent e);
}
