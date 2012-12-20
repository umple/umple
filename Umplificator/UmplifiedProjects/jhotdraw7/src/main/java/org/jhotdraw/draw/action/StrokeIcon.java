/*
 * @(#)StrokeIcon.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.action;

import java.awt.*;

/**
 * StrokeIcon.
 *
 * @author  Werner Randelshofer
 * @version $Id: StrokeIcon.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class StrokeIcon implements javax.swing.Icon {
    private Stroke stroke;
    
    /** Creates a new instance. */
    public StrokeIcon(Stroke stroke) {
        this.stroke = stroke;
    }
    
    @Override
    public int getIconHeight() {
        return 12;
    }
    
    @Override
    public int getIconWidth() {
        return 40;
    }
    
    @Override
    public void paintIcon(java.awt.Component c, java.awt.Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        g.setStroke(stroke);
        g.setColor(c.isEnabled() ? Color.black : Color.GRAY);
        g.drawLine(x, y + getIconHeight() / 2, x + getIconWidth(), y + getIconHeight() / 2);
        /*
        g.setStroke(new BasicStroke());
        g.setColor(Color.red);
        g.drawLine(x, y, x + getIconWidth(), y + getIconHeight());
         */
    }
}
