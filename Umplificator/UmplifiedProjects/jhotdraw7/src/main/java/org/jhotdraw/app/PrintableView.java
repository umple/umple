/*
 * @(#)PrintableView.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app;

import java.awt.print.*;

/**
 * The interface of a {@link View} which can print its document.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The interfaces and classes listed below define together the contracts
 * of a smaller framework inside of the JHotDraw framework for document oriented
 * applications.<br>
 * Contract: {@link PrintableView}.<br>
 * Client: {@link org.jhotdraw.app.action.file.PrintFileAction}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: PrintableView.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface PrintableView extends View {
public Pageable createPageable();   
}
