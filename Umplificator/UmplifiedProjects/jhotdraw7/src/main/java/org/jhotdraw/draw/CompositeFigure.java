/*
 * @(#)CompositeFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw;

import org.jhotdraw.draw.layouter.Layouter;
import org.jhotdraw.draw.event.CompositeFigureListener;
import org.jhotdraw.geom.*;

/**
 * A <em>composite figure</em> is composed of several child {@link Figure}s.
 * <p>
 * A composite figure can be laid out using a {@link Layouter}.
 * <p>
 * {@code CompositeFigure} listens to {@code requestRemove} events
 * sent by its child figures, and then removes the child figure which sent
 * the event.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Composite</em><br>
 * Composite figures can be composed of other figures.<br>
 * Component: {@link Figure}; Composite: {@link CompositeFigure}.
 *
 * <p><em>Observer</em><br>
 * State changes of figures can be observed by other objects. Specifically
 * {@code CompositeFigure} observes area invalidations and remove requests
 * of its child figures. {@link DrawingView} also observes area invalidations
 * of its drawing object.<br>
 * Subject: {@link Figure}; 
 * Observer: {@link org.jhotdraw.draw.event.FigureListener};
 * Event: {@link org.jhotdraw.draw.event.FigureEvent};
 * Concrete Observer: {@link CompositeFigure}, {@link DrawingView}.
 *
 * <p><em>Observer</em><br>
 * Changes in the composition of a composite figure can be observed.<br>
 * Subject: {@link CompositeFigure}; Observer:
 * {@link org.jhotdraw.draw.event.CompositeFigureListener};
 * Event: {@link org.jhotdraw.draw.event.CompositeFigureEvent}.
 *
 * <p><em>Strategy</em><br>
 * Composite figures can be laid out using different layout algorithms which
 * are implemented by layouters.<br>
 * Context: {@link CompositeFigure}; Strategy: {@link Layouter}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: CompositeFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface CompositeFigure extends Figure {
    /**
     * The value of this attribute is a Insets2D.Double object.
     */
    public final static AttributeKey<Insets2D.Double> LAYOUT_INSETS = new AttributeKey<Insets2D.Double>("layoutInsets", Insets2D.Double.class, new Insets2D.Double());
    
    /**
     * Adds a child to the figure.
     * <p>
     * This is a convenience method for {@code add(getChildCount(), child);}
     * <p>
     * This method calls {@code figureAdded} on all registered
     * {@code CompositeFigureListener}s.
     * 
     * @return {@code true} if this CompositeFigure changed as a result of the
     *         call
     */
    public boolean add(Figure child);
    /**
     * Adds a child to the figure at the specified index.
     * <p>
     * This method calls {@code figureAdded} on all registered
     * {@code CompositeFigureListener}s.
     */
    public void add(int index, Figure child);
    /**
     * Adds a child to the figure without firing events.
     * <p>
     * This method can be used to reinsert a child figure which has been
     * temporarily removed from this CompositeFigure (for example to reorder
     * the sequence of the children) and to efficiently build a drawing from 
     * an {@link org.jhotdraw.draw.io.InputFormat}.
     * 
     * This is a convenience method for calling
     * {@code basicAdd(getChildCount(), child);}.
     */
    public void basicAdd(Figure child);
    /**
     * Adds a child to the figure at the specified index without
     * firing events.
     * <p>
     * This method can be used to reinsert a child figure which has been
     * temporarily removed from this CompositeFigure (for example to reorder
     * the sequence of the children) and to efficiently build a drawing from 
     * an {@link org.jhotdraw.draw.io.InputFormat}.
     */
    public void basicAdd(int index, Figure child);
    /**
     * Removes the specified child.
     * Returns true, if the Figure contained the removed child.
     * <p>
     * This is a convenience method for calling 
     * {@code removeChild(getChildren().indexOf(child));}
     * <p>
     * This method calls {@code figureRemoved} on all registered
     * {@code CompositeFigureListener}'s.
     */
    public boolean remove(Figure child);
    /**
     * Removes the child at the specified index.
     * Returns the removed child figure.
     * <p>
     * Calls {@code figureRemoved} on all registered
     * {@code CompositeFigureListener}'s.
     */
    public Figure removeChild(int index);
    /**
     * Removes all children from the composite figure.
     * <p>
     * This is a convenience method for 
     * {@code while(getChildCount() > 0) removeChild(0); }
     */
    public void removeAllChildren();
    /**
     * Removes the specified child without firing events.
     * <p>
     * This method can be used to temporarily remove a child from this 
     * CompositeFigure (for example to reorder the sequence of the children).
     * <p>
     * This is a convenience method for calling 
     * {@code basicRemove(indexOf(child));}.
     * <p>
     * Returns the index of the removed figure. Returns -1 if the
     * figure was not a child of this CompositeFigure.
     */
    public int basicRemove(Figure child);
    /**
     * Removes the child at the specified index without firing events.
     * <p>
     * This method can be used to temporarily remove a child from this 
     * CompositeFigure (for example to reorder the sequence of the children).
     * <p>
     * Returns the removed child figure.
     */
    public Figure basicRemoveChild(int index);
    /**
     * Removes all children from the composite figure without firing events.
     * <p>
     * This method can be used to temporarily remove a child from this 
     * CompositeFigure (for example to reorder the sequence of the children).
     * <p>
     * This is a convenience method for 
     * {@code while(getChildCount() > 0) basicRemoveChild(0); }
     */
    public void basicRemoveAllChildren();
    
    /**
     * Returns an unchangeable list view on the children.
     */
    public java.util.List<Figure> getChildren();
    
    /**
     * Returns the number of children.
     * <p>
     * This is a convenience method for calling 
     * {@code getChildren().size();}.
     */
    public int getChildCount();
    
    /**
     * Returns the child figure at the specified index.
     * <p>
     * This is a convenience method for calling 
     * {@code getChildren().get(index);}.
     */
    public Figure getChild(int index);
    /**
     * Returns the index of the specified child.
     * <p>
     * This is a convenience method for calling 
     * {@code getChildren().indexOf(index);}.
     * 
     * @return The index of the child, or -1 if the specified figure is not
     * a child of this CompositeFigure.
     */
    public int indexOf(Figure child);
    /**
     * Returns true if this composite figure contains the specified figure.
     * <p>
     * This is a convenience method for calling 
     * {@code getChildren().contains(f);}.
     */
    public boolean contains(Figure f);
    /**
     * Get a Layouter object which encapsulated a layout
     * algorithm for this figure. Typically, a Layouter
     * accesses the child components of this figure and arranges
     * their graphical presentation.
        *
     * @return layout strategy used by this figure
     */
    public Layouter getLayouter();
    /**
     * A layout algorithm is used to define how the child components
     * should be laid out in relation to each other.
     * <p>
     * This method first calls layout() on all child figures which implement
     * the CompositeFigure interface. Then the children are laid out.
     * <p>
     * The task for laying out the child figures is delegated to a Layouter
     * which can be plugged in at runtime.
     */
    public void layout();
    /**
     * Set a Layouter object which encapsulated a layout
     * algorithm for this figure. Typically, a Layouter
     * accesses the child components of this figure and arranges
     * their graphical presentation. It is a good idea to put
     * the Layouter in the protected initialize() method
     * so it can be recreated if a GraphicalCompositeFigure is
     * read and restored from a StorableInput stream.
     *
     *
     * @param newValue	encapsulation of a layout algorithm.
     */
    public void setLayouter(Layouter newValue);
    
    /**
     * Adds a listener for this composite figure.
     */
    public void addCompositeFigureListener(CompositeFigureListener listener);
    
    /**
     * Removes a listener from this composite figure.
     */
    public void removeCompositeFigureListener(CompositeFigureListener listener);
}
