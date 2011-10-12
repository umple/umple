/*
 * @(#)FigureAdapter.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.event;

import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * An abstract adapter class for receiving {@link FigureEvent}s. This class
 * exists as a convenience for creating {@link FigureListener} objects.
 * 
 * @author Werner Randelshofer
 * @version $Id: FigureAdapter.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class FigureAdapter implements FigureListener {
    @Override
    public void areaInvalidated(FigureEvent e) {
    }
    
    @Override
    public void attributeChanged(FigureEvent e) {
    }
    
    @Override
    public void figureAdded(FigureEvent e) {
    }
    
    @Override
    public void figureChanged(FigureEvent e) {
    }
    
    @Override
    public void figureRemoved(FigureEvent e) {
    }
    
    @Override
    public void figureRequestRemove(FigureEvent e) {
    }

    @Override
    public void figureHandlesChanged(FigureEvent e) {
    }
    
}
