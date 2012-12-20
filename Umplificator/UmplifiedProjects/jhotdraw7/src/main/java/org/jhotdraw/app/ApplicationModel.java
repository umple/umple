/*
 * @(#)ApplicationModel.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
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
import org.jhotdraw.gui.URIChooser;

/**
 * {@code ApplicationModel} provides meta-data for an {@link Application},
 * actions and factory methods for creating {@link View}s, toolbars and
 * {@link URIChooser}s.
 *
 * <hr>
 * <b>Features</b>
 *
 * <p><em>Open last URI on launch</em><br>
 * When the application is started, the last opened URI is opened in a view.<br>
 * {@link #isOpenLastURIOnLaunch()} is used by {@link Application#start} to
 * determine whether this feature is enabled.
 * See {@link org.jhotdraw.app} for a list of participating classes.
 * </p>
 *
 * <p><em>Allow multiple views for URI</em><br>
 * Allows opening the same URI in multiple views.
 * When the feature is disabled, opening multiple views is prevented, and saving
 * to a file for which another view is open is prevented.<br>
 * {@code ApplicationModel} defines an API for this feature.<br>
 * See {@link org.jhotdraw.app}.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The interfaces and classes listed below together with the {@code Action}
 * classes in the org.jhotddraw.app.action package define the contracts of a
 * framework for document oriented applications:<br>
 * Contract: {@link Application}, {@link ApplicationModel}, {@link View}.
 * <hr>
 *
 * @author Werner Randelshofer.
 * @version $Id: ApplicationModel.java 732 2011-01-22 20:26:30Z rawcoder $
 */
public interface ApplicationModel {

    /**
     * Returns the name of the application.
     */
    public String getName();

    /**
     * Returns the version of the application.
     */
    public String getVersion();

    /**
     * Returns the copyright of the application.
     */
    public String getCopyright();

    /**
     * Creates a new view for the application.
     */
    public View createView();

    /** Inits the application. */
    public void initApplication(Application a);

    /** Destroys the application. */
    public void destroyApplication(Application a);

    /** Inits the supplied view for the application. */
    public void initView(Application a, View v);

    /** Destroys the supplied view. */
    public void destroyView(Application a, View v);

    /** Creates an action map.
     * <p>
     * This method is invoked once for the application, and once for each
     * created view.
     * <p>
     * The application adds the created map to a hierarchy of action maps.
     * Thus actions created for the application are accessible from the
     * action maps of the views.
     *
     * @param a Application.
     * @param v The view for which the toolbars need to be created, or null
     * if the actions are shared by multiple views.
     */
    public ActionMap createActionMap(Application a, @Nullable View v);

    /**
     * Creates tool bars.
     * <p>
     * Depending on the document interface of the application, this method
     * may be invoked only once for the application, or for each opened view.
     * <p>
     * @param a Application.
     * @param v The view for which the toolbars need to be created, or null
     * if the toolbars are shared by multiple views.
     */
    public List<JToolBar> createToolBars(Application a, @Nullable View v);

    /** Returns the abstract factory for building application menus. */
    public MenuBuilder getMenuBuilder();

    /**
     * Creates an open chooser.
     *
     * @param a Application.
     * @param v The view for which the chooser needs to be created, or null
     * if the chooser is shared by multiple views.
     */
    public URIChooser createOpenChooser(Application a, @Nullable View v);

    /**
     * Creates an open chooser for directories.
     *
     * @param a Application.
     * @param v The view for which the chooser needs to be created, or null
     * if the chooser is shared by multiple views.
     */
    public URIChooser createOpenDirectoryChooser(Application a, @Nullable View v);

    /**
     * Creates a save chooser.
     *
     * @param a Application.
     * @param v The view for which the chooser needs to be created, or null
     * if the chooser is shared by multiple views.
     */
    public URIChooser createSaveChooser(Application a, @Nullable View v);

    /**
     * Creates an import chooser.
     *
     * @param a Application.
     * @param v The view for which the chooser needs to be created, or null
     * if the chooser is shared by multiple views.
     */
    public URIChooser createImportChooser(Application a, @Nullable View v);

    /**
     * Creates an export chooser.
     *
     * @param a Application.
     * @param v The view for which the chooser needs to be created, or null
     * if the chooser is shared by multiple views.
     */
    public URIChooser createExportChooser(Application a, @Nullable View v);

    /** Returns true if the application should open the last opened URI on launch
     * instead of opening an empty view.
     * <p>
     * This method defines an API for the <em>Open last URI on Launch</em> feature.
     * See {@link org.jhotdraw.app}.
     * 
     * @return True if last used URI shall be opened on launch.
     */
    public boolean isOpenLastURIOnLaunch();

    /** Returns true if the application may open multiple views for the same
     * URI.
     * <p>
     * This method defines an API for the <em>Allow multiple views for URI</em> feature.
     * See {@link org.jhotdraw.app}.
     *
     * @return True if the application may open multiple views for the same URI.
     */
    public boolean isAllowMultipleViewsPerURI();
}
