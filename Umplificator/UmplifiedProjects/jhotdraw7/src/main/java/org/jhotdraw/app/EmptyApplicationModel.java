/*
 * @(#)EmptyApplicationModel.java
 *
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.app;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.*;
import javax.swing.*;

/**
 * An {@link ApplicationModel} which neither creates {@code Action}s,
 * nor overrides the menu bars, nor creates tool bars.
 * <p>
 * The {@code createActionMap} method of this model returns an empty ActionMap.
 *
 * @author Werner Randelshofer.
 * @version $Id: EmptyApplicationModel.java 732 2011-01-22 20:26:30Z rawcoder $
 */
public class EmptyApplicationModel
        extends AbstractApplicationModel {

    /** Returns an empty ActionMap. */
    @Override
    public ActionMap createActionMap(Application a, @Nullable View v) {
        return new ActionMap();
    }

    /** Returns an empty unmodifiable list. */
    @Override
    public List<JToolBar> createToolBars(Application app, @Nullable View v) {
        return Collections.emptyList();
    }

    @Override
    public MenuBuilder getMenuBuilder() {
        return new EmptyMenuBuilder();
    }



}
