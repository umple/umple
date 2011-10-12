/*
 * @(#)NullHandle.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.draw.handle;

import org.jhotdraw.draw.locator.Locator;
import org.jhotdraw.draw.locator.RelativeLocator;
import org.jhotdraw.draw.*;
import java.awt.*;
import java.util.*;
/**
 * A handle that doesn't change the owned figure. Its only purpose is
 * to show feedback that a figure is selected.
 *
 * @author Werner Randelshofer
 * @version $Id: NullHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class NullHandle extends LocatorHandle {
    
    /** Creates a new instance. */
    public NullHandle(Figure owner, Locator locator) {
        super(owner, locator);
    }
    
    @Override
    public Cursor getCursor() {
        return Cursor.getDefaultCursor();
    }
    
    @Override
    public void trackStart(Point anchor, int modifiersEx) {
        
    }
    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
        
    }
    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
        
    }
    
    /**
     * Creates handles for each lead of a
     * figure and adds them to the provided collection.
     */
    static public void addLeadHandles(Figure f, Collection<Handle> handles) {
        handles.add(new NullHandle(f, new RelativeLocator(0f,0f)));
        handles.add(new NullHandle(f, new RelativeLocator(0f,1f)));
        handles.add(new NullHandle(f, new RelativeLocator(1f,0f)));
        handles.add(new NullHandle(f, new RelativeLocator(1f,1f)));
    }
    /**
     * Draws this handle.
     * Null Handles are drawn as unfilled rectangles.
     */
    @Override
    public void draw(Graphics2D g) {
        drawRectangle(g, 
                (Color) getEditor().getHandleAttribute(HandleAttributeKeys.NULL_HANDLE_FILL_COLOR),
                (Color) getEditor().getHandleAttribute(HandleAttributeKeys.NULL_HANDLE_STROKE_COLOR)
                );
    }
    
}
