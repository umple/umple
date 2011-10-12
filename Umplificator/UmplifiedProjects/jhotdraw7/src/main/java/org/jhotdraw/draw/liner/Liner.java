/*
 * @(#)Liner.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.liner;

import java.util.*;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.geom.*;

/**
 * A <em>liner</em> encapsulates a strategy for laying out the bezier path of
 * a {@link ConnectionFigure}.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Strategy</em><br>
 * The control points of the bezier path of a connection figure can be laid out
 * using different layout algorithms which are implemented by liners.<br>
 * Context: {@link ConnectionFigure}; Strategy: {@link Liner}.
 * <hr>
 * 
 * @author Werner Randelshofer
 * @version $Id: Liner.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public interface Liner extends Cloneable {
    
    /**
     * Layouts the Path. This may alter the number and type of points
     * in the Path.
     *
     * @param figure The ConnectionFigure to be lined out.
     */
    public void lineout(ConnectionFigure figure);
    
    /**
     * Creates Handle's for the Liner.
     * The ConnectionFigure can provide these handles to the user, in order
     * to let her control the lineout.
     * 
     * @param path The path for which to create handles.
     */
    public Collection<Handle> createHandles(BezierPath path);
    
    public Liner clone();
}
