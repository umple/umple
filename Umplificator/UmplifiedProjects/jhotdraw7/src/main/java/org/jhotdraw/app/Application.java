/*
 * @(#)Application.java
 *
 * Copyright (c) 1996-2011 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.app;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Component;
import java.awt.Window;
import java.beans.PropertyChangeListener;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import javax.swing.ActionMap;
import javax.swing.JMenu;
import org.jhotdraw.gui.URIChooser;

/**
 * An <em>application</em> handles the lifecycle of {@link View} objects and
 * provides windows to present them on screen.
 * <p>
 * An application owns a {@link ApplicationModel} which provides meta-data about
 * the application, actions and factory methods for creating the views.
 * <p>
 * Depending on the document interface style used by the application, an
 * application can handle multiple views at the same time, or only one.
 * <p>
 * Typical document interface styles are the Single Document Interface (SDI),
 * the Multiple Document Interface (MDI) and the Mac OS X Application Interface
 * (OSX). Typically, for each of these styles an implementation of
 * {@code Application} exists.
 * <p>
 * Some applications have to decorate all opened windows and dialogs with
 * user interface elements and special behaviors. To make this work,
 * it is essential that all code which opens JFrame's, JDialog's or
 * JWindow's calls the addWindow/Palette and removeWindow/Palette methods on
 * the application object.
 * <p>
 * Unless stated otherwise all methods must be called from the AWT Event
 * Dispatcher Thread.
 * <p>
 * Typical usage of this class:
 * <pre>
 * public class MyMainClass {
 *     public static void main(String[] args) {
 *         Application app = new SDIApplication(); // or OSXApplication(), MDIApplication().
 *         DefaultApplicationModel model = new DefaultApplicationModel();
 *         model.setName("MyApplication");
 *         model.setVersion("1.0");
 *         model.setCopyright("Copyright 2006 (c) Werner Randelshofer. All Rights Reserved.");
 *         model.setViewClassName("org.jhotdraw.myapplication.MyView");
 *         app.setModel(model);
 *         app.launch(args);
 *     } 
 * </pre>
 * <hr>
 * <b>Features</b>
 *
 * <p><em>Open last URI on launch</em><br>
 * When the application is launched, it opens the last opened URI in a view.<br>
 * {@code Application} also provides an API for data suppliers in {@link #addRecentURI},
 * {@link #getRecentURIs}, {@link #clearRecentURIs}.<br>
 * See {@link org.jhotdraw.app} for a description of the feature.
 * </p>
 *
     * <hr>
     * <b>Design Patterns</b>
     *
     * <p><em>Framework</em><br>
     * The interfaces and classes listed below together with the {@code Action}
     * classes in the org.jhotddraw.app.action package define the contracts of a
     * framework for document oriented applications:<br>
     * Contract: {@link Application}, {@link ApplicationModel}, {@link View}.
     *
 * <p><em>Abstract Factory</em><br>
 * {@code MenuBuilder} is used by {@code Application} for creating menu items.
 * The {@code MenuBuilder} is provided by {@code ApplicationModel}.<br>
 * Abstract Factory: {@link MenuBuilder}<br>
 * Client: {@link Application}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: Application.java 758 2011-09-08 11:59:27Z rawcoder $
 */
public interface Application {

    /**
     * The property name of the activeView property.
     */
    public final static String ACTIVE_VIEW_PROPERTY = "activeView";
    /**
     * The property name of the recentURIs property.
     */
    public final static String RECENT_URIS_PROPERTY = "recentURIs";

    /**
     * Launches the application from the main method.
     * <p>
     * This method must be called from the main thread of the application.
     * <p>
     * Implementations of this method must invoke {@code configure()} on the
     * current thread and then {@code init(); applicationModel.initApplication(this);
     * start();} on the AWT Event Dispatcher Thread.
     * <p>
     * The launch method determines which URI's it wants to supply to the start()
     * method. Typically, if URI's have been passed in the {@code args}
     * parameter, they are passed on to the start() method. Otherwise, if the
     * property {@code openLastURIOnLaunch} of the application model is true,
     * the last opened URI is passed to the start method.
     * <p>
     * This method implements behavior for the following features:
     * <em>Launch application</em>, <em>Open last URI on launch</em>.
     * See {@link org.jhotdraw.app}.
     */
    public void launch(String[] args);

    /**
     * Configures the application using the provided arguments array.
     * <p>
     * This method must be called from the main thread of the application.
     * <p>
     * This method implements behavior for the following feature:
     * <em>Open URIs from command line on launch</em>.
     * See {@link org.jhotdraw.app}.
     */
    public void configure(String[] args);

    /**
     * Initializes the application.
     * <p>
     * By convention this method is only called after {@link #configure} has
     * been called.
     */
    public void init();

    /**
     * Starts the application.
     * <p>
     * This method creates a view for each supplied URI, and adds it to the application.
     * If no URI has been supplied, this method may open an empty view.
     * <p>
     * By convention this method is only called after {@link #init} has
     * been called.
     * <p>
     * This method implements behavior for the following feature:
     * <em>Open URI on launch</em>.
     * See {@link org.jhotdraw.app}.
     *
     * @param uris Upon launch, the application may be requested to open views
     *             for a given list of URI's.
     */
    public void start(List<URI> uris);

    /**
     * Stops the application without saving any unsaved views.
     * <p>
     * By convention this method is only called after {@link #init} has
     * been called.
     * <p>
     * This method must be called from AWT Event Dispatcher Thread.
     */
    public void stop();

    /**
     * Stops the application and then calls System.exit(0).
     * <p>
     * By convention this method is only called after {@link #init} has
     * been called.
     * <p>
     * This method must be called from AWT Event Dispatcher Thread.
     */
    public void destroy();

    /**
     * Creates a new view for this application and initializes it, by calling
     * {@link View#init}.
     * The view has not been added to the application yet. 
     * To make the view usable with this application, call {@link #add(View)}.
     * To make it visible, first call {@code add(View)}, then {@link #show(View)}.
     */
    public View createView();

    /**
     * Adds a view to this application.
     * Fires a "documentCount" property change event.
     * Invokes method setApplication(this) on the view object.
     */
    public void add(View p);

    /**
     * Removes a view from this application and removes it from the users
     * view.
     * Fires a "documentCount" property change event.
     * Invokes method setApplication(null) on the view object.
     */
    public void remove(View p);

    /**
     * Shows a view.
     */
    public void show(View p);

    /**
     * Hides a view.
     */
    public void hide(View p);

    /**
     * This is a convenience method for removing a view and disposing it.
     */
    public void dispose(View p);

    /**
     * Returns a read only collection view of the views of this application.
     */
    public Collection<View> views();

    /**
     * Returns the active view. This is used for OSXApplication and 
     * MDIApplication which share actions among multiple View instances.
     * Active view may be become null, if the
     * application has no view.
     * <p>
     * This is a bound property. 
     */
    @Nullable
    public View getActiveView();

    /**
     * Returns the enabled state of the application.
     */
    public boolean isEnabled();

    /**
     * Sets the enabled state of the application.
     *
     * The enabled state is used to prevent parallel invocation of actions
     * on the application. If an action consists of a sequential part and a
     * concurrent part, it must disable the application only for the sequential
     * part.
     *
     * Actions that act on the application must check in their actionPerformed
     * method whether the application is enabled.
     * If the application is disabled, they must do nothing. 
     * If the application is enabled, they must disable the application,
     * perform the action and then enable the application again.
     *
     * This is a bound property.
     */
    public void setEnabled(boolean newValue);

    /**
     * Adds a property change listener.
     */
    public void addPropertyChangeListener(PropertyChangeListener l);

    /**
     * Removes a property change listener.
     */
    public void removePropertyChangeListener(PropertyChangeListener l);

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
     * Sets the application model.
     */
    public void setModel(ApplicationModel newValue);

    /**
     * Returns the application model.
     */
    public ApplicationModel getModel();

    /**
     * Returns true, if this application shares tools among multiple views.
     */
    public boolean isSharingToolsAmongViews();

    /**
     * Returns the application component. 
     * This may return null, if the application is not represented by a component
     * of its own on the user interface.
     */
    @Nullable
    public Component getComponent();

    /**
     * Adds a palette window to the application.
     */
    public void addPalette(Window palette);

    /**
     * Removes a palette window from the application.
     */
    public void removePalette(Window palette);

    /**
     * Adds a (non-palette) window to the application.
     *
     * @param window The window.
     * @param view The View to which this window is associated, or null
     * if the window is associated to the application.
     */
    public void addWindow(Window window, @Nullable View view);

    /**
     * Removes a (non-palette) window from the application.
     */
    public void removeWindow(Window window);

    /**
     * Returns the recently opened URIs. By convention, this is an unmodifiable list.
     * The first item in the list is the most recently opened URI.
     * <p>
     * The most recent URI is used by the <em>Open last URI on launch</em> feature.
     * See {@link org.jhotdraw.app}.
     */
    public java.util.List<URI> getRecentURIs();

    /**
     * Adds an URI to the start of the list of recent URIs.
     * <p>
     * This fires a property change event for the property "recentURIs".
     * <p>
     * The recent URIs are persisted (for example using the Java Preferences API)
     * so that they are available on the next launch of the application.
     * <p>
     * The most recent URI is used by the <em>Open last URI on launch</em> feature.
     * See {@link org.jhotdraw.app}.
     */
    public void addRecentURI(URI uri);

    /**
     * Clears the list of recent URIs.
     * This fires a property change event for the property "recentURIs".
     * <p>
     * The recent URIs are persisted (for example using the Java Preferences API)
     * so that they are available on the next launch of the application.
     * <p>
     * The most recent URI is used by the <em>Open last URI on launch</em> feature.
     * See {@link org.jhotdraw.app}.
     */
    public void clearRecentURIs();

    /**
     * Creates a file menu for the specified view or for the entire application.
     *
     * @param v A view or null.
     * @return A JMenu or null, if the menu is empty.
     */
    @Nullable
    public JMenu createFileMenu(@Nullable View v);

    /**
     * Creates an edit menu for the specified view or for the entire application.
     *
     * @param v A view or null.
     * @return A JMenu or null, if the menu is empty.
     */
    @Nullable
    public JMenu createEditMenu(@Nullable View v);

    /**
     * Creates a view menu for the specified view or for the entire application.
     *
     * @param v A view or null.
     * @return A JMenu or null, if the menu is empty.
     */
    @Nullable
    public JMenu createViewMenu(@Nullable View v);

    /**
     * Creates a window menu for the specified view or for the entire application.
     *
     * @param v A view or null.
     * @return A JMenu or null, if the menu is empty.
     */
    @Nullable
    public JMenu createWindowMenu(@Nullable View v);

    /** 
     * Creates a help menu for the specified view of for the entire application.
     *
     * @param v A view or null.
     * @return A JMenu or null, if the menu is empty.
     */
    @Nullable
    public JMenu createHelpMenu(@Nullable View v);

    /**
     * Gets an open chooser for the specified view or for the entire application.
     *
     * @param v A view or null.
     * @return A chooser.
     */
    public URIChooser getOpenChooser(@Nullable View v);

    /**
     * Gets a save chooser for the specified view or for the entire application.
     *
     * @param v A view or null.
     * @return A chooser.
     */
    public URIChooser getSaveChooser(@Nullable View v);

    /**
     * Gets an export chooser for the specified view or for the entire application.
     *
     * @param v A view or null.
     * @return A chooser.
     */
    public URIChooser getExportChooser(@Nullable View v);

    /**
     * Gets an import chooser for the specified view or for the entire application.
     *
     * @param v A view or null.
     * @return A chooser.
     */
    public URIChooser getImportChooser(@Nullable View v);

    /**
     * Gets an action map for the specified view or for the entire application.
     *
     * @param v A view or null
     */
    public ActionMap getActionMap(@Nullable View v);

    /** Returns an unmodifiable list of all views of the application.
     * <p>
     * The list of views is used by the <em>Allow multiple views per URI</em> feature.
     * See {@link org.jhotdraw.app}.
     */
    public List<View> getViews();
}
