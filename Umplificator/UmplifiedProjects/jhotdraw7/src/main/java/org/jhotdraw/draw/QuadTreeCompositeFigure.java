/*
 * @(#)QuadTreeCompositeFigure.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.event.FigureAdapter;
import org.jhotdraw.draw.event.FigureEvent;
import org.jhotdraw.geom.Dimension2DDouble;
import org.jhotdraw.geom.QuadTree;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.event.*;
import org.jhotdraw.util.*;
import java.util.*;
import static org.jhotdraw.draw.AttributeKeys.*;
/**
 * QuadTreeCompositeFigure.
 * 
 * 
 * @author Werner Randelshofer
 * @version $Id: QuadTreeCompositeFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class QuadTreeCompositeFigure 
        extends AbstractCompositeFigure {
    private QuadTree<Figure> quadTree = new QuadTree<Figure>();
    private boolean needsSorting = false;
    private FigureHandler figureHandler;
    private Dimension2DDouble canvasSize;
    
    /** Creates a new instance. */
    public QuadTreeCompositeFigure() {
        figureHandler = createFigureHandler();
    }
    
    protected FigureHandler createFigureHandler() {
        return new FigureHandler();
    }
    
    @Override
    public int indexOf(Figure figure) {
        return children.indexOf(figure);
    }
    
    @Override
    public void basicAdd(int index, Figure figure) {
        children.add(index, figure);
        quadTree.add(figure, figure.getDrawingArea());
        figure.addFigureListener(figureHandler);
        needsSorting = true;
    }
    @Override
    public Figure basicRemoveChild(int index) {
        Figure figure = children.get(index); 
        children.remove(index);
        quadTree.remove(figure);
        figure.removeFigureListener(figureHandler);
        needsSorting = true;
        return figure;
    }
    
    @Override
    public void draw(Graphics2D g) {
        Rectangle2D clipBounds = g.getClipBounds();
        if (clipBounds != null) {
            Collection<Figure> c = quadTree.findIntersects(clipBounds);
            Collection<Figure> toDraw = sort(c);
            draw(g, toDraw);
        } else {
            draw(g, children);
        }
    }
    
    /**
     * Implementation note: Sorting can not be done for orphaned children.
     */
    public java.util.List<Figure> sort(Collection<Figure> c) {
        ensureSorted();
        ArrayList<Figure> sorted = new ArrayList<Figure>(c.size());
        for (Figure f : children) {
            if (c.contains(f)) {
                sorted.add(f);
            }
        }
        return sorted;
    }
    
    public void draw(Graphics2D g, Collection<Figure> c) {
        for (Figure f : c) {
            f.draw(g);
        }
    }
    
    
    
    public java.util.List<Figure> getFigures(Rectangle2D.Double bounds) {
        return new LinkedList<Figure>(quadTree.findInside(bounds));
    }
    
    @Override
    public java.util.List<Figure> getChildren() {
        return Collections.unmodifiableList(children);
    }
    
    @Override
    public Figure findFigureInside(Point2D.Double p) {
        Collection<Figure> c = quadTree.findContains(p);
        for (Figure f : getFiguresFrontToBack()) {
            if (c.contains(f) && f.contains(p)){
                return f.findFigureInside(p);
            }
        }
        return null;
        
    }
    
    /**
     * Returns an iterator to iterate in
     * Z-order front to back over the children.
     */
    public java.util.List<Figure> getFiguresFrontToBack() {
        ensureSorted();
        return new ReversedList<Figure>(children);
    }
    
    @Nullable public Figure findFigure(Point2D.Double p) {
        Collection<Figure> c = quadTree.findContains(p);
        switch (c.size()) {
            case 0 :
                return null;
            case 1: {
                Figure f = c.iterator().next();
                return (f.contains(p)) ? f : null;
            }
            default : {
                for (Figure f : getFiguresFrontToBack()) {
                    if (c.contains(f) && f.contains(p)) return f;
                }
                return null;
            }
        }
    }
    @Nullable public Figure findFigureExcept(Point2D.Double p, Figure ignore) {
        Collection<Figure> c = quadTree.findContains(p);
        switch (c.size()) {
            case 0 : {
                return null;
            }
            case 1: {
                Figure f = c.iterator().next();
                return (f == ignore || ! f.contains(p)) ? null : f;
            }
            default : {
                for (Figure f : getFiguresFrontToBack()) {
                    if (f != ignore && f.contains(p)) return f;
                }
                return null;
            }
        }
    }
    @Nullable public Figure findFigureExcept(Point2D.Double p, Collection ignore) {
        Collection<Figure> c = quadTree.findContains(p);
        switch (c.size()) {
            case 0 : {
                return null;
            }
            case 1: {
                Figure f = c.iterator().next();
                return (! ignore.contains(f) || ! f.contains(p)) ? null : f;
            }
            default : {
                for (Figure f : getFiguresFrontToBack()) {
                    if (! ignore.contains(f) && f.contains(p)) return f;
                }
                return null;
            }
        }
    }
    @Nullable public Figure findFigureBehind(Point2D.Double p, Figure figure) {
        boolean isBehind = false;
        for (Figure f : getFiguresFrontToBack()) {
            if (isBehind) {
                if (f.isVisible() && f.contains(p)) {
                    return f;
                }
            } else {
                isBehind = figure == f;
            }
        }
        return null;
    }
    @Nullable public Figure findFigureBehind(Point2D.Double p, Collection<Figure> figures) {
        int inFrontOf = figures.size();
        for (Figure f : getFiguresFrontToBack()) {
            if (inFrontOf == 0) {
                if (f.isVisible() && f.contains(p)) {
                    return f;
                }
            } else {
                if (figures.contains(f)) {
                    inFrontOf--;
                }
            }
        }
        return null;
    }
    
    public java.util.List<Figure> findFigures(Rectangle2D.Double r) {
        LinkedList<Figure> c = new LinkedList<Figure>(quadTree.findIntersects(r));
        switch (c.size()) {
            case 0 :
                // fall through
            case 1:
                return c;
            default :
                return sort(c);
        }
    }
    public java.util.List<Figure> findFiguresWithin(Rectangle2D.Double bounds) {
        LinkedList<Figure> contained = new LinkedList<Figure>();
        for (Figure f : children) {
            Rectangle2D r = f.getBounds();
            if (f.get(TRANSFORM) != null) {
                r = f.get(TRANSFORM).createTransformedShape(r).getBounds2D();
            }
            if (f.isVisible() && bounds.contains(r)) {
                contained.add(f);
            }
        }
        return contained;
    }
    
    @Override
    public void bringToFront(Figure figure) {
        if (children.remove(figure)) {
            children.add(figure);
            needsSorting = true;
            fireAreaInvalidated(figure.getDrawingArea());
        }
    }
    @Override
    public void sendToBack(Figure figure) {
        if (children.remove(figure)) {
            children.add(0, figure);
            needsSorting = true;
            fireAreaInvalidated(figure.getDrawingArea());
        }
    }
    
    @Override
    public boolean contains(Figure f) {
        return children.contains(f);
    }
    
    /**
     * Ensures that the children are sorted in z-order sequence.
     */
    private void ensureSorted() {
        if (needsSorting) {
            Collections.sort(children, FigureLayerComparator.INSTANCE);
            needsSorting = false;
        }
    }
    
    public void setCanvasSize(Dimension2DDouble newValue) {
        Dimension2DDouble oldValue = canvasSize;
        canvasSize = newValue;
        firePropertyChange("canvasSize", oldValue, newValue);
    }
    
    public Dimension2DDouble getCanvasSize() {
        return canvasSize;
    }
    
    /**
     * Handles all figure events fired by Figures contained in the Drawing.
     */
    protected class FigureHandler extends FigureAdapter implements UndoableEditListener {
        /**
         * We propagate all edit events from our children to
         * undoable edit listeners, which have registered with us.
         */
        @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            fireUndoableEditHappened(e.getEdit());
        }
        
        @Override public void areaInvalidated(FigureEvent e) {
            fireAreaInvalidated(e.getInvalidatedArea());
        }
        @Override public void figureChanged(FigureEvent e) {
            quadTree.remove(e.getFigure());
            quadTree.add(e.getFigure(), e.getFigure().getDrawingArea());
            needsSorting = true;
            if (! isChanging()) fireAreaInvalidated(e.getInvalidatedArea());
        }
        @Override public void figureRequestRemove(FigureEvent e) {
            remove(e.getFigure());
        }
    }
}
