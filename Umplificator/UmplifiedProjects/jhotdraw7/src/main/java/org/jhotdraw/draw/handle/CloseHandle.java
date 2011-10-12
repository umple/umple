/*
 * @(#)CloseHandle.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.handle;

import org.jhotdraw.draw.locator.RelativeLocator;
import org.jhotdraw.draw.locator.Locator;
import org.jhotdraw.draw.*;
import java.awt.*;

/**
 * A {@link Handle} which requests to remove its owning figure when clicked.
 *
 * @author  Werner Randelshofer
 * @version $Id: CloseHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class CloseHandle extends LocatorHandle {
    private boolean pressed;
    
    /** Creates a new instance. */
    public CloseHandle(Figure owner) {
        this(owner, new RelativeLocator(1.0, 0.0));
    }
    /** Creates a new instance. */
    public CloseHandle(Figure owner, Locator locator) {
        super(owner, locator);
    }
    
    @Override
    protected int getHandlesize() {
        return 9;
    }
    
    /**
     * Draws this handle.
     */
    @Override
    public void draw(Graphics2D g) {
        drawRectangle(g, (pressed) ? Color.orange : Color.white, Color.black);
        Rectangle r = getBounds();
        g.drawLine(r.x, r.y, r.x+r.width, r.y+r.height);
        g.drawLine(r.x+r.width, r.y, r.x, r.y+r.height);
    }
    
    
    /**
     * Returns a cursor for the handle.
     */
    @Override
    public Cursor getCursor() {
        return Cursor.getDefaultCursor();
    }
    
    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
        pressed = basicGetBounds().contains(lead);
        if (pressed) getOwner().requestRemove();
        fireAreaInvalidated(getDrawingArea());
    }
    
    @Override
    public void trackStart(Point anchor, int modifiersEx) {
        pressed = true;
        fireAreaInvalidated(getDrawingArea());
    }
    
    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
        boolean oldValue = pressed;
        pressed = basicGetBounds().contains(lead);
        if (oldValue != pressed) fireAreaInvalidated(getDrawingArea());
    }
}
