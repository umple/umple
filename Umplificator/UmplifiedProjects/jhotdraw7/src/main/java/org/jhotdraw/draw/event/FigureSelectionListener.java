/*
 * @(#)FigureSelectionListener.java
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
 * Interface implemented by observers of selection changes in 
 * {@link org.jhotdraw.draw.DrawingView} objects.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Observer</em><br>
 * Selection changes of {@code DrawingView} are observed by user interface
 * components which act on selected figures.<br>
 * Subject: {@link org.jhotdraw.draw.DrawingView}; Observer:
 * {@link FigureSelectionListener}; Event: {@link FigureSelectionEvent}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: FigureSelectionListener.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface FigureSelectionListener extends java.util.EventListener {
    public void selectionChanged(FigureSelectionEvent evt);
}
