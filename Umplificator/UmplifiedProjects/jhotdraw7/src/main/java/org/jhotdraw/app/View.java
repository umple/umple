/*
 * @(#)View.java
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
import org.jhotdraw.gui.URIChooser;
import java.io.*;
import java.beans.*;
import java.net.URI;
import javax.swing.*;

/**
 * A <em>view</em> paints a document on a {@code JComponent} within an
 * {@link Application}.
 * <p>
 * The document is identified by an {@code URI} (for example a text document
 * which is identified by the URI {@code "file://home/readme.txt"}).
 * If the same {@code URI} is opened in multiple views, the application sets
 * a 'multiple open ID' on the view, so that the user can distinguish between
 * the views.
 * <p>
 * The life of view objects is managed by an application. See the class
 * comment of {@link Application} on how to launch an application.
 * <p>
 * The lifecycle of a view consists of the following steps:
 * <ol>
 * <li><b>Creation</b><br>
 * The application instantiates the view object by calling {@code newInstance()}
 * on the class of the view.
 * </li>
 * <li><b>Initialisation</b><br>
 * The application calls the following methods: {@code setActionMap();
 * setApplication(); init()}.
 * Then it either calls {@code clear()} or {@code read()} on a worker thread.
 * </li>
 * <li><b>Start</b><br>
 * The application adds the component of the view to a container (for example
 * a JFrame) and then calls {@code start()}.
 * </li>
 * <li><b>Activation</b><br>
 * When a view becomes the active view of the application, application calls
 * {@code activate()}.
 * </li>
 * <li><b>Deactivation</b><br>
 * When a view is not anymore the active view of the application, application
 * calls {@code deactivate()}. At a later time, the view may become activated again.
 * </li>
 * <li><b>Stop</b><br>
 * The application calls {@code stop()} on the view and then removes the
 * component from its container. At a later time, the view may be started
 * again.
 * </li>
 * <li><b>Dispose</b><br>
 * When the view is no longer needed, application calls {@code dispose()} on
 * the view, followed by {@code setApplication(null)} and then removes all
 * references to it, so that it can be garbage collected.
 * </li>
 * </ol>
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
 * @author Werner Randelshofer
 * @version $Id: View.java 733 2011-01-23 09:47:51Z rawcoder $
 */
public interface View extends Disposable {
    /**
     * The name of the uri property.
     */
    public final static String URI_PROPERTY = "uri";
    /**
     * The name of the application property.
     */
    public final static String APPLICATION_PROPERTY = "application";
    /**
     * The name of the title property.
     */
    public final static String TITLE_PROPERTY = "title";
    /**
     * The name of the enabled property.
     */
    public final static String ENABLED_PROPERTY = "enabled";
    /**
     * The name of the hasUnsavedChanges property.
     */
    public final static String HAS_UNSAVED_CHANGES_PROPERTY = "hasUnsavedChanges";
    /**
     * The name of the multipleOpenId property.
     */
    public final static String MULTIPLE_OPEN_ID_PROPERTY = "multipleOpenId";
    /**
     * The name of the showing property.
     */
    public final static String SHOWING_PROPERTY = "showing";
    /**
     * Gets the application to which this view belongs.
     */
    @Nullable public Application getApplication();
    
    /**
     * Sets the application of the view.
     * By convention, this is only invoked by Application.add() and
     * Application.remove().
     * This is a bound property.
     */
    public void setApplication(@Nullable Application newValue);
    
    /**
     * Returns the visual component of the view.
     */
    public JComponent getComponent();
    
    /**
     * Returns the enabled state of the view.
     */
    public boolean isEnabled();
    
    /**
     * Sets the enabled state of the view.
     *
     * The enabled state is used to prevent parallel invocation of actions
     * on the view. If an action consists of a sequential part and a
     * concurrent part, it must disable the view only for the sequential
     * part.
     *
     * Actions that act on the view must check in their actionPerformed
     * method whether the view is enabled.
     * If the view is disabled, they must do nothing.
     * If the view is enabled, they must disable the view,
     * perform the action and then enable the view again.
     *
     * This is a bound property.
     */
    public void setEnabled(boolean newValue);
    
    /**
     * Clears the view, for example by emptying the contents of
     * the view, or by reading a template contents from a file.
     * By convention this method is never invoked on the AWT Event Dispatcher Thread.
     * <p>
     * This method implements behavior for the following feature:
     * <em>Open URI on launch</em>.
     * See {@link org.jhotdraw.app}.
     */
    public void clear();
    
    /**
     * Whether the view is empty. A view is considered empty if the application
     * has implicit consent from the user to reuse or destroy the view at any
     * time. For example, an application may open an empty view immediately
     * after startup. If the user chooses to open a document, the document is
     * opened in this view rather than in a new view.
     * <p>
     * If this method returns true, {@link org.jhotdraw.app.action.file.OpenFileAction}
     * and similar actions will open a file in this view, instead of
     * opening a new view.
     * 
     * @return True if the view can be reused by open actions.
     */
    public boolean isEmpty();
    
    /**
     * Returns true, if the view has unsaved changes.
     * This is a bound property.
     */
    public boolean hasUnsavedChanges();
    /**
     * Marks all changes as saved.
     * This changes the state of hasUnsavedChanges to false.
     */
    public void markChangesAsSaved();
    
    /**
     * Executes the specified runnable on the worker thread of the view.
     * Execution is performed sequentially in the same sequence as the
     * runnables have been passed to this method.
     * <p>
     * Use this method for long running tasks which affect the contents
     * of the view as a whole. For example for loading and saving a document.
     */
    public void execute(Runnable worker);
    
    /**
     * Initializes the view.
     * This is invoked right before the application shows the view.
     * A view must not consume many resources before method init() is called.
     * This is crucial for the responsivenes of an application.
     * <p>
     * After a view has been initialized using init(),
     * either method clear() must be called
     * or method read, in order to fully initialize a  View.
     */
    public void init();
    
    /**
     * Starts the view.
     * Invoked after a view has been made visible to the user.
     * Multiple view can be visible at the same time.
     */
    public void start();
    /**
     * Activates the view.
     * This occurs, when the user activated the parent window of the view.
     * Only one view can be active at any given time.
     * This method is only invoked on a started view.
     */
    public void activate();
    /**
     * Deactivates the view.
     * This occurs, when the user closes the view, or activated another view.
     * This method is only invoked on a started view.
     */
     public void deactivate();    
    /**
     * Stops the view.
     * Invoked after a view window has been minimized or made invisible.
     */
     public void stop();    
    /**
     * Gets rid of all the resources of the view.
     * No other methods should be invoked on the view afterwards.
     * A view must not consume many resources after method dispose() has been called.
     * This is crucial for the responsivenes of an application.
     */
    @Override
    public void dispose();
    
    /**
     * Gets the action map of the view.
     */
    public ActionMap getActionMap();
    
    /**
     * Sets the action map for the view.
     */
    public void setActionMap(ActionMap m);
    
    /**
     * Adds a property change listener.
     */
    public void addPropertyChangeListener(PropertyChangeListener l);
    
    /**
     * Removes a property change listener.
     */
    public void removePropertyChangeListener(PropertyChangeListener l);
    
    /**
     * Sets the multiple open id.
     * The id is used to help distinguish multiply opened views.
     * The id should be displayed in the title of the view.
     */
    public void setMultipleOpenId(int newValue);
    
    /**
     * Returns the multiple open id.
     * If a view is open only once this should be 1.
     */
    public int getMultipleOpenId();
    
    /**
     * This is used by Application to keep track if a view is showing.
     */
    public boolean isShowing();
    /**
     * This is used by Application to keep track if a view is showing.
     */
    public void setShowing(boolean newValue);
    
    /**
     * Sets the title of the view. 
     * <p>
     * The title is generated by the application, based on the current
     * URI of the view. The application ensures that the title uniquely
     * identifies each open view.
     * <p> 
     * The application displays the title in the title bar of the view 
     * window and in all windows which are associated to the view.
     * <p>
     * This is a bound property.
     */
    public void setTitle(String newValue);
    
    /**
     * Gets the title of the view. 
     */
    public String getTitle();
    
    /**
     * Adds a disposable object, which will be disposed when the view
     * is disposed.
     *
     * @param disposable
     */
    public void addDisposable(Disposable disposable);
    /**
     * Removes a disposable object, which was previously added.
     *
     * @param disposable
     */
    public void removeDisposable(Disposable disposable);

    /**
     * Returns the URI which holds the document of the view.
     * <p>
     * The URI is used by the <em>Allow multiple views per URI</em> feature.
     * See {@link org.jhotdraw.app}.
     */
    @Nullable public URI getURI();

    /**
     * Sets the uri of the view.
     * This is a bound property.
     */
    public void setURI(@Nullable URI newValue);

    /**
     * Returns true, if this view can be saved to the specified URI.
     * A reason why the view can't be saved to a URI, is that the
     * view is unable to write to a file-URI with the given filename
     * extension without losing data.
     * <p>
     * The SaveAction uses this method to decide, whether to display
     * a save dialog before saving the URI.
     *
     * @param uri An URI. If this parameter is null, a NullPointerException
     * is thrown.
     */
    public boolean canSaveTo(URI uri);

    /**
     * Writes the view to the specified URI.
     * <p>
     * By convention this method is never invoked on the AWT Event Dispatcher Thread.
     *
     * @param uri The location where to write the view.
     * @param chooser The chooser which was used for selecting the URI. This
     * parameter is null if no chooser was used.
     */
    public void write(URI uri, @Nullable URIChooser chooser) throws IOException;

    /**
     * Reads the view from the specified URI.
     * <p>
     * By convention this method is never invoked on the AWT Event Dispatcher Thread.
     * <p>
     * This method implements behavior for the following feature:
     * <em>Open URI on launch</em>.
     * See {@link org.jhotdraw.app}.
     *
     * @param uri The location where to write the view.
     * @param chooser The chooser which was used for selecting the URI. This
     * parameter is null if no chooser was used.
     */
    public void read(URI uri, @Nullable URIChooser chooser) throws IOException;


}
