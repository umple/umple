/*
 * @(#)Locator.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.draw.locator;

import org.jhotdraw.draw.*;
import java.awt.geom.*;

/**
 * A <em>locator</em> encapsulates a strategy for locating a point on a
 * {@link Figure}.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Strategy</em><br>
 * {@code Locator} encapsulates a strategy for locating a point on a
 * {@code Figure}.<br>
 * Strategy: {@link Locator}; Context: {@link Figure}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: Locator.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public interface Locator {

	/**
	 * Locates a position on the provided figure.
	 * @return a point on the figure.
	 */
	public Point2D.Double locate(Figure owner);
	/**
	 * Locates a position on the provided figure relative to the dependent
         * figure.
	 * @return a point on the figure.
	 */
	public Point2D.Double locate(Figure owner, Figure dependent);
}