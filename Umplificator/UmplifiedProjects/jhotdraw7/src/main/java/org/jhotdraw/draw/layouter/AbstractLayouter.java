/*
 * @(#)AbstractLayouter.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.layouter;

import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;

/**
 * This abstract class can be extended to implement a {@link Layouter}
 * which has its own attribute set.
 *
 * @author  Werner Randelshofer
 * @version $Id: AbstractLayouter.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public abstract class AbstractLayouter implements Layouter {
    
    public Insets2D.Double getInsets(Figure child) {
        Insets2D.Double value =  child.get(CompositeFigure.LAYOUT_INSETS);
        return (value == null) ? new Insets2D.Double() : (Insets2D.Double) value.clone();
    }
}
