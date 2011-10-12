/**
 * @(#)RotationDirection.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw;

/**
 * Specifies the possible directions for rotations on a two-dimensional plane.
 * <p>
 * This enumeration is used by drawing tools and handles to perform constrained
 * transforms of figures on a drawing.
 *
 * @see Constrainer
 * 
 * @author Werner Randelshofer
 * @version $Id: RotationDirection.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public enum RotationDirection {
    CLOCKWISE,
    COUNTER_CLOCKWISE
}
