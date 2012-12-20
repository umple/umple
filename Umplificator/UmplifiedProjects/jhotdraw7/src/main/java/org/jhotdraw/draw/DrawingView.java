/*
 * @(#)DrawingView.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.event.FigureSelectionListener;
import org.jhotdraw.draw.handle.Handle;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;

/**
 * A <em>drawing view</em> paints a {@link Drawing} on a {@code JComponent}.
 * <p>
 * A drawing view can hold only one drawing at a time, but a drawing can be in
 * multiple drawing views at the same time.
 * <p>
 * {@code DrawingView} can paint the drawing with a scale factor. It supports
 * conversion between view coordinates and drawing coordinates.
 * <p>
 * {@code DrawingView} maintains a selection of the {@link Figure}s contained in
 * the drawing. When a figure is selected, the drawing view request {@link Handle}s
 * from the figure and draws them on top of the drawing.
 * <p>
 * To support editing, a drawing view needs to be added to a {@link DrawingEditor}.
 * The current {@link org.jhotdraw.draw.tool.Tool} of the drawing editor
 * receives mouse and key events from all drawing views of the drawing editor.
 * When added to an editor, the drawing view paints the current {@link org.jhotdraw.draw.tool.Tool} on
 * top of the drawing. The selected figures and handles can be the targets of
 * the current tool of the drawing editor.
 * <p>
 * Editing operations can be constrained, for example by a grid. The constraints
 * are defined by a {@link Constrainer} object. Handles and tools should take
 * the constrainer of the drawing view into account when editing a figure.
 * <p>
 * The painting process of {@code DrawingView} view involves the following steps:
 * <ol>
 * <li>Paint the background of the drawing view.</li>
 * <li>Invoke {@link Drawing#drawCanvas}.</li>
 * <li>Invoke {@link Constrainer#draw} if a constrainer is set.</li>
 * <li>Invoke {@link Drawing#draw}.</li>
 * <li>Invoke {@link org.jhotdraw.draw.handle.Handle#draw} on the handles
 * of selected figures.</li>
 * <li>Invoke {@link org.jhotdraw.draw.tool.Tool#draw} if the drawing view
 * is the active view of the {@code DrawingEditor}.</li>
 * </ol>
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The following interfaces define the contracts of a framework for structured
 * drawing editors:<br>
 * Contract: {@link Drawing}, {@link Figure}, {@link DrawingView},
 * {@link DrawingEditor}, {@link org.jhotdraw.draw.handle.Handle} and
 * {@link org.jhotdraw.draw.tool.Tool}.
 *
 * <p><em>Chain of responsibility</em><br>
 * Mouse and keyboard events of the user occur on the drawing view, and are
 * preprocessed by the {@code DragTracker} of a {@code SelectionTool}. In
 * turn {@code org.jhotdraw.draw.selectiontool.DragTracker} invokes "track" methods on a {@code Handle} which in
 * turn changes an aspect of a figure.<br>
 * Client: {@link org.jhotdraw.draw.tool.SelectionTool};
 * Handler: {@link org.jhotdraw.draw.tool.DragTracker}, 
 * {@link org.jhotdraw.draw.handle.Handle}.
 * 
 * <p><em>Mediator</em><br>
 * {@code DrawingEditor} acts as a mediator for coordinating drawing tools
 * and drawing views:<br>
 * Mediator: {@link DrawingEditor}; 
 * Colleagues: {@link DrawingView}, {@link org.jhotdraw.draw.tool.Tool}.
 *
 * <p><em>Model-View-Controller</em><br>
 * The following classes implement together the Model-View-Controller design
 * pattern:<br>
 * Model: {@link Drawing}; View: {@link DrawingView}; Controller:
 * {@link DrawingEditor}.
 *
 * <p><em>Observer</em><br>
 * Selection changes of {@code DrawingView} are observed by user interface
 * components which act on selected figures.<br>
 * Subject: {@link org.jhotdraw.draw.DrawingView}; 
 * Observer: {@link org.jhotdraw.draw.event.FigureSelectionListener};
 * Event: {@link org.jhotdraw.draw.event.FigureSelectionEvent}.
 * 
 * <p><em>Observer</em><br>
 * State changes of figures can be observed by other objects. Specifically
 * {@code CompositeFigure} observes area invalidations and remove requests
 * of its child figures. {@code DrawingView} also observes area invalidations
 * of its drawing object.
 * Subject: {@link Figure}; Observer:
 * {@link org.jhotdraw.draw.event.FigureListener};
 * Event: {@link org.jhotdraw.draw.event.FigureEvent}; 
 * Concrete Observer: {@link CompositeFigure}, {@link DrawingView}.
 *
 * <p><em>Observer</em><br>
 * State changes of handles can be observed by other objects. Specifically
 * {@code DrawingView} observes area invalidations and remove requests of
 * handles.<br>
 * Subject: {@link Handle}; 
 * Observer: {@link org.jhotdraw.draw.event.HandleListener};
 * Event: {@link org.jhotdraw.draw.event.HandleEvent};
 * Concrete Observer: {@link DrawingView}.
 *
 * <p><em>Strategy</em><br>
 * Editing can be constrained by a constrainer which is associated to a
 * drawing view.<br>
 * Context: {@link DrawingView}; Strategy: {@link Constrainer}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: DrawingView.java 766 2011-09-29 19:40:06Z rawcoder $
 */
public interface DrawingView {

    /**
     * This constant is used to identify the drawing property of the DrawingView.
     */
    public final static String DRAWING_PROPERTY = "drawing";
    /**
     * This constant is used to identify the cursor property of the DrawingView.
     */
    public final static String CURSOR_PROPERTY = "cursor";
    /**
     * This constant is used to identify the constrainer property of the DrawingView.
     */
    public final static String CONSTRAINER_PROPERTY = "constrainer";
    /**
     * This constant is used to identify the visible constrainer property of the DrawingView.
     */
    public final static String VISIBLE_CONSTRAINER_PROPERTY = "visibleConstrainer";
    /**
     * This constant is used to identify the invisible constrainer property of the DrawingView.
     */
    public final static String INVISIBLE_CONSTRAINER_PROPERTY = "invisibleConstrainer";
    /**
     * This constant is used to identify the constrainer visible property of the DrawingView.
     */
    public final static String CONSTRAINER_VISIBLE_PROPERTY = "constrainerVisible";
    /**
     * This constant is used to identify the scale factor property of the DrawingView.
     */
    public final static String SCALE_FACTOR_PROPERTY = "scaleFactor";
    /**
     * This constant is used to identify the handle detail level property of the DrawingView.
     */
    public final static String HANDLE_DETAIL_LEVEL_PROPERTY = "handleDetailLevel";
    /**
     * This constant is used to identify the enabled property of the DrawingView.
     */
    public final static String ENABLED_PROPERTY = "enabled";
    /**
     * This constant is used to identify the activeHandle property of the DrawingView.
     */
    public final static String ACTIVE_HANDLE_PROPERTY = "activeHandle";

    /**
     * Gets the drawing.
     * This is a bound property.
     */
    @Nullable
    public Drawing getDrawing();

    /**
     * Sets and installs another drawing in the view.
     * This is a bound property.
     */
    public void setDrawing(@Nullable Drawing d);

    /**
     * Sets the cursor of the DrawingView.
     * This is a bound property.
     */
    public void setCursor(@Nullable Cursor c);

    /**
     * Test whether a given figure is selected.
     */
    public boolean isFigureSelected(Figure checkFigure);

    /**
     * Adds a figure to the current selection.
     */
    public void addToSelection(Figure figure);

    /**
     * Adds a collection of figures to the current selection.
     */
    public void addToSelection(Collection<Figure> figures);

    /**
     * Removes a figure from the selection.
     */
    public void removeFromSelection(Figure figure);

    /**
     * If a figure isn't selected it is added to the selection.
     * Otherwise it is removed from the selection.
     */
    public void toggleSelection(Figure figure);

    /**
     * Clears the current selection.
     */
    public void clearSelection();

    /**
     * Selects all figures.
     */
    public void selectAll();

    /**
     * Gets the selected figures. Returns an empty set, if no figures are selected. 
     */
    public Set<Figure> getSelectedFigures();

    /**
     * Gets the number of selected figures.
     */
    public int getSelectionCount();

    /**
     * Finds a handle at the given coordinates.
     * @return A handle, null if no handle is found.
     */
    @Nullable
    public Handle findHandle(Point p);

    /**
     * Gets compatible handles.
     * @return A collection containing the handle and all compatible handles.
     */
    public Collection<Handle> getCompatibleHandles(Handle handle);

    /**
     * Sets the active handle.
     */
    public void setActiveHandle(@Nullable Handle newValue);

    /**
     * Gets the active handle.
     */
    @Nullable
    public Handle getActiveHandle();

    /**
     * Finds a figure at the given point.
     * @return A figure, null if no figure is found.
     */
    @Nullable
    public Figure findFigure(Point p);

    /**
     * Returns all figures that lie within or intersect the specified
     * bounds. The figures are returned in Z-order from back to front.
     */
    public Collection<Figure> findFigures(Rectangle r);

    /**
     * Returns all figures that lie within the specified
     * bounds. The figures are returned in Z-order from back to front.
     */
    public Collection<Figure> findFiguresWithin(Rectangle r);

    /**
     * Informs the view that it has been added to the specified editor.
     * The view must draw the tool of the editor, if getActiveView() of the
     * editor returns the view.
     */
    public void addNotify(DrawingEditor editor);

    /**
     * Informs the view that it has been removed from the specified editor.
     * The view must not draw the tool from the editor anymore.
     */
    public void removeNotify(DrawingEditor editor);

    /**
     * Gets the drawing editor associated to the DrawingView.
     * This is a bound property.
     */
    @Nullable
    public DrawingEditor getEditor();

    /**
     * Add a listener for selection changes in this DrawingView.
     * @param fsl jhotdraw.framework.FigureSelectionListener
     */
    public void addFigureSelectionListener(FigureSelectionListener fsl);

    /**
     * Remove a listener for selection changes in this DrawingView.
     * @param fsl jhotdraw.framework.FigureSelectionListener
     */
    public void removeFigureSelectionListener(FigureSelectionListener fsl);

    /** This is a convenience method for invoking
     * {@code getComponent().requestFocus()}. */
    public void requestFocus();

    /**
     * Converts drawing coordinates to view coordinates.
     */
    public Point drawingToView(Point2D.Double p);

    /**
     * Converts view coordinates to drawing coordinates.
     */
    public Point2D.Double viewToDrawing(Point p);

    /**
     * Converts drawing coordinates to view coordinates.
     */
    public Rectangle drawingToView(Rectangle2D.Double p);

    /**
     * Converts view coordinates to drawing coordinates.
     */
    public Rectangle2D.Double viewToDrawing(Rectangle p);

    /**
     * Gets the current constrainer of this view. 
     * If isConstrainerVisible is true, this method returns getVisibleConstrainer,
     * otherwise it returns getInvisibleConstrainer.
     * This is a bound property.
     */
    @Nullable public Constrainer getConstrainer();

    /**
     * Sets the editor's constrainer for this view, for use, when the
     * visible constrainer is turned on.
     * This is a bound property.
     */
    public void setVisibleConstrainer(@Nullable Constrainer constrainer);

    /**
     * Gets the editor's constrainer for this view, for use, when the
     * visible constrainer is turned on.
     * This is a bound property.
     */
    @Nullable public Constrainer getVisibleConstrainer();

    /**
     * Sets the editor's constrainer for this view, for use, when the
     * visible constrainer is turned off.
     * This is a bound property.
     */
    public void setInvisibleConstrainer(Constrainer constrainer);

    /**
     * Gets the editor's constrainer for this view, for use, when the
     * visible constrainer is turned off.
     * This is a bound property.
     */
    public Constrainer getInvisibleConstrainer();

    /**
     * Changes between a visible Constrainer and an invisible Constrainer.
     * This is a bound property.
     */
    public void setConstrainerVisible(boolean newValue);

    /**
     * Returns true, if the visible Constrainer is in use, returns false,
     * if the invisible Constrainer is in use.
     * This is a bound property.
     */
    public boolean isConstrainerVisible();

    /**
     * Returns the JComponent of the drawing view.
     * <p>
     * The drawing framework supports only two use cases, where this 
     * component may be accessed:
     * <ul>
     * <li>The component can be used to add the drawing view to a parent Swing
     * component.</li>
     * <li>The currently active {@link org.jhotdraw.draw.tool.Tool} may add 
     * child components to the drawing view. The tool <b>must</b> remove these
     * components when it becomes inactive.</li>
     * </ul>
     */
    public JComponent getComponent();

    /**
     * Gets an transform which can be used to convert
     * drawing coordinates to view coordinates.
     */
    public AffineTransform getDrawingToViewTransform();

    /**
     * Gets the scale factor of the drawing view.
     * This is a bound property.
     */
    public double getScaleFactor();

    /**
     * Sets the scale factor of the drawing view.
     * This is a bound property.
     */
    public void setScaleFactor(double newValue);

    /**
     * The detail level of the handles.
     * This is a bound property.
     */
    public void setHandleDetailLevel(int newValue);

    /**
     * Returns the detail level of the handles.
     * This is a bound property.
     */
    public int getHandleDetailLevel();

    /**
     * Sets the enabled state of the drawing view.
     * This is a bound property.
     */
    public void setEnabled(boolean newValue);

    /**
     * Gets the enabled state of the drawing view.
     * This is a bound property.
     */
    public boolean isEnabled();

    /** Repaints the handles of the view. */
    public void repaintHandles();

    /**
     * Adds a property change listener to the drawing view.
     * 
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener);

    /**
     * Removes a property change listener to the drawing view.
     * 
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener);

    /**
     * Adds a mouse listener to the drawing view.
     * 
     * @param l the listener.
     */
    public void addMouseListener(MouseListener l);

    /**
     * Removes a mouse listener to the drawing view.
     * 
     * @param l the listener.
     */
    public void removeMouseListener(MouseListener l);

    /**
     * Adds a key listener to the drawing view.
     * 
     * @param l the listener.
     */
    public void addKeyListener(KeyListener l);

    /**
     * Removes a key listener to the drawing view.
     * 
     * @param l the listener.
     */
    public void removeKeyListener(KeyListener l);

    /**
     * Adds a mouse motion  listener to the drawing view.
     * 
     * @param l the listener.
     */
    public void addMouseMotionListener(MouseMotionListener l);

    /**
     * Removes a mouse motion listener to the drawing view.
     * 
     * @param l the listener.
     */
    public void removeMouseMotionListener(MouseMotionListener l);
}
