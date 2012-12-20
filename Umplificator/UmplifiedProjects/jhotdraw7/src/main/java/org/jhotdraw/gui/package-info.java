/* @(#)package-info.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 *
 * @author Werner Randelshofer
 * @version $Id: package-info.java 758 2011-09-08 11:59:27Z rawcoder $
*/

/**
 * Provides general purpose graphical user interface classes leveraging the
 * javax.swing package.
 * 
 * <hr>
 * <b>Features</b>
 *
 * <p><em>Activity monitoring</em><br>
 * Background activities can be monitored using the {@link org.jhotdraw.gui.ActivityModel} class.
 * A activity model can have an owner. This allows to associate activities to
 * different views of an application.
 * All current activity models can be viewed in the {@link org.jhotdraw.gui.JActivityWindow}.
 * A {@code JActivityIndicator} can be used to indicate that one or more 
 * activity is active. {@code JActivityIndicator} can either indicate all
 * running activities, or only those belonging to a specific owner.
 * </p>
 *
 */
@DefaultAnnotation(NonNull.class)
package org.jhotdraw.gui;

import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import edu.umd.cs.findbugs.annotations.NonNull;
