/*
 * @(#)ToolListener.java
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
 * Interface implemented by observers of {@link org.jhotdraw.draw.tool.Tool}s.
 * 
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Observer</em><br>
 * State changes of tools can be observed by other objects. Specifically
 * {@code DrawingEditor} observes area invalidations of tools and repaints
 * its active drawing view accordingly.<br>
 * Subject: {@link org.jhotdraw.draw.tool.Tool};
 * Observer: {@link ToolListener}; Event: {@link ToolEvent};
 * Concrete Observer: {@link org.jhotdraw.draw.DrawingEditor}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: ToolListener.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface ToolListener extends EventListener {
    /**
     * Informs the listener that a tool has starteds interacting with a 
     * specific drawing view.
     */
    void toolStarted(ToolEvent event);
    /**
     * Informs the listener that a tool has done its interaction.
     * This method can be used to switch back to the default tool.
     */
    void toolDone(ToolEvent event);
    /**
     * Sent when an area of the drawing view needs to be repainted.
     */
    public void areaInvalidated(ToolEvent e);
    /**
     * Sent when the tool has edited an area outside of the bounds
     * of the canvas.
     */
    public void boundsInvalidated(ToolEvent e);
    
}
