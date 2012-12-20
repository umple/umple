/*
 * @(#)CompositeFigureListener.java
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
 * Interface implemented by observers of {@link org.jhotdraw.draw.CompositeFigure}.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Observer</em><br>
 * Changes in the composition of a composite figure can be observed.<br>
 * Subject: {@link org.jhotdraw.draw.CompositeFigure}; Observer:
 * {@link CompositeFigureListener}; Event: {@link CompositeFigureEvent}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: CompositeFigureListener.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface CompositeFigureListener extends EventListener {
    /**
     * Sent when a figure was added.
     */
    public void figureAdded(CompositeFigureEvent e);
    
    /**
     * Sent when a figure was removed.
     */
    public void figureRemoved(CompositeFigureEvent e);
}
