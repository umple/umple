/*
 * @(#)ListFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.layouter.VerticalLayouter;
import org.jhotdraw.geom.*;

/**
 * A ListFigure consists of a list of Figures and a RectangleFigure.
 *
 * @author  Werner Randelshofer
 * @version $Id: ListFigure.java 727 2011-01-09 13:23:59Z rawcoder $
 */
public class ListFigure
extends GraphicalCompositeFigure {
    /** Creates a new instance. */
    public ListFigure() {
        this(null);
    }
    /** Creates a new instance with the specified presentation figure
     * and layout insets of [top=4,left=8,right=4,bottom=8]. */
    public ListFigure(@Nullable Figure presentationFigure) {
        super(presentationFigure); 
        setLayouter(new VerticalLayouter());
        set(LAYOUT_INSETS, new Insets2D.Double(4,8,4,8));
    }
}
