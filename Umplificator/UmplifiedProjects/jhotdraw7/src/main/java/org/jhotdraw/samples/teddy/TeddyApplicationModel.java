/*
 * @(#)TeddyApplicationModel.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.teddy;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.app.action.file.PrintFileAction;
import javax.swing.*;
import org.jhotdraw.app.*;
import java.util.*;
import org.jhotdraw.app.action.*;
import org.jhotdraw.gui.JFileURIChooser;
import org.jhotdraw.samples.teddy.action.*;

/**
 * Provides meta-data and factory methods for an application.
 * <p>
 * See {@link ApplicationModel} on how this class interacts with an application.
 *
 * @author Werner Randelshofer
 * @version $Id: TeddyApplicationModel.java 731 2011-01-22 09:21:06Z rawcoder $
 */
public class TeddyApplicationModel extends DefaultApplicationModel {

    /** Creates a new instance. */
    public TeddyApplicationModel() {
    }

    @Override
    public ActionMap createActionMap(Application a, @Nullable View v) {
        ActionMap m = super.createActionMap(a, v);
        AbstractAction aa;

        m.put(FindAction.ID, new FindAction(a, v));
        m.put(ToggleLineWrapAction.ID, new ToggleLineWrapAction(a, v));
        m.put(ToggleStatusBarAction.ID, new ToggleStatusBarAction(a, v));
        m.put(ToggleLineNumbersAction.ID, new ToggleLineNumbersAction(a, v));
        m.put(PrintFileAction.ID, null);

        return m;
    }

    @Override
    public void initView(Application a, @Nullable View v) {
    }

    /** Creates the MenuBuilder. */
    @Override
    protected MenuBuilder createMenuBuilder() {
        return new DefaultMenuBuilder() {

            @Override
            public void addOtherViewItems(JMenu m, Application app, @Nullable View v) {
                ActionMap am = app.getActionMap(v);
                JCheckBoxMenuItem cbmi;
                cbmi = new JCheckBoxMenuItem(am.get(ToggleLineWrapAction.ID));
                ActionUtil.configureJCheckBoxMenuItem(cbmi, am.get(ToggleLineWrapAction.ID));
                m.add(cbmi);
                cbmi = new JCheckBoxMenuItem(am.get(ToggleLineNumbersAction.ID));
                ActionUtil.configureJCheckBoxMenuItem(cbmi, am.get(ToggleLineNumbersAction.ID));
                m.add(cbmi);
                cbmi = new JCheckBoxMenuItem(am.get(ToggleStatusBarAction.ID));
                ActionUtil.configureJCheckBoxMenuItem(cbmi, am.get(ToggleStatusBarAction.ID));
                m.add(cbmi);
            }
        };
    }

    /**
     * Creates toolbars for the application.
     * This class returns an empty list - we don't want toolbars in a text editor.
     */
    @Override
    public List<JToolBar> createToolBars(Application app, @Nullable View p) {
        return Collections.emptyList();
    }

    @Override
    public JFileURIChooser createOpenChooser(Application app, @Nullable View p) {
        JFileURIChooser chooser = new JFileURIChooser();
        chooser.setAccessory(new CharacterSetAccessory());
        return chooser;
    }

    @Override
    public JFileURIChooser createSaveChooser(Application app, @Nullable View p) {
        JFileURIChooser chooser = new JFileURIChooser();
        chooser.setAccessory(new CharacterSetAccessory());
        return chooser;
    }
}
