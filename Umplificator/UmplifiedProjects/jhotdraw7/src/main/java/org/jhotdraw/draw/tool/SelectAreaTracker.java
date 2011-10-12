/*
 * @(#)SelectAreaTracker.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.tool;

import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * A <em>select area tracker</em> provides the behavior for selecting figures
 * in a drawing area to the {@link SelectionTool}.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Strategy</em><br>
 * The different behavior states of the selection tool are implemented by
 * trackers.<br>
 * Context: {@link SelectionTool}; State: {@link DragTracker},
 * {@link HandleTracker}, {@link SelectAreaTracker}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: SelectAreaTracker.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public interface SelectAreaTracker extends Tool {

}
