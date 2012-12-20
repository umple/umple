/*
 * @(#)DefaultDrawing.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import java.awt.*;
import java.awt.geom.*;
import org.jhotdraw.util.*;
import java.util.*;
import org.jhotdraw.geom.Geom;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * A default implementation of {@link Drawing} useful for drawings which
 * contain only a few figures.
 * <p>
 * For larger drawings, {@link QuadTreeDrawing} is recommended.
 * <p>
 * FIXME - Maybe we should rename this class to SimpleDrawing or we should
 * get rid of this class altogether.
 *
 *
 * @author Werner Randelshofer
 * @version $Id: DefaultDrawing.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DefaultDrawing
        extends AbstractDrawing {

    private boolean needsSorting = false;

    /** Creates a new instance. */
    public DefaultDrawing() {
    }

    @Override
    public void basicAdd(int index, Figure figure) {
        super.basicAdd(index, figure);
        invalidateSortOrder();
    }

    @Override
    public void draw(Graphics2D g) {
        synchronized (getLock()) {
            ensureSorted();
            ArrayList<Figure> toDraw = new ArrayList<Figure>(getChildren().size());
            Rectangle clipRect = g.getClipBounds();
            for (Figure f : getChildren()) {
                if (f.getDrawingArea().intersects(clipRect)) {
                    toDraw.add(f);
                }
            }
            draw(g, toDraw);
        }
    }

    public void draw(Graphics2D g, Collection<Figure> children) {
        Rectangle2D clipBounds = g.getClipBounds();
        if (clipBounds != null) {
            for (Figure f : children) {
                if (f.isVisible() && f.getDrawingArea().intersects(clipBounds)) {
                    f.draw(g);
                }
            }
        } else {
            for (Figure f : children) {
                if (f.isVisible()) {
                    f.draw(g);
                }
            }
        }
    }

    @Override
    public java.util.List<Figure> sort(Collection<? extends Figure> c) {
        HashSet<Figure> unsorted = new HashSet<Figure>();
        unsorted.addAll(c);
        ArrayList<Figure> sorted = new ArrayList<Figure>(c.size());
        for (Figure f : getChildren()) {
            if (unsorted.contains(f)) {
                sorted.add(f);
                unsorted.remove(f);
            }
        }
        for (Figure f : c) {
            if (unsorted.contains(f)) {
                sorted.add(f);
                unsorted.remove(f);
            }
        }
        return sorted;
    }

    @Override
    public Figure findFigure(Point2D.Double p) {
        for (Figure f : getFiguresFrontToBack()) {
            if (f.isVisible() && f.contains(p)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public Figure findFigureExcept(Point2D.Double p, Figure ignore) {
        for (Figure f : getFiguresFrontToBack()) {
            if (f != ignore && f.isVisible() && f.contains(p)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public Figure findFigureBehind(Point2D.Double p, Figure figure) {
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

    @Override
    public Figure findFigureBehind(Point2D.Double p, Collection<? extends Figure> children) {
        int inFrontOf = children.size();
        for (Figure f : getFiguresFrontToBack()) {
            if (inFrontOf == 0) {
                if (f.isVisible() && f.contains(p)) {
                    return f;
                }
            } else {
                if (children.contains(f)) {
                    inFrontOf--;
                }
            }
        }
        return null;
    }

    @Override
    public Figure findFigureExcept(Point2D.Double p, Collection<? extends Figure> ignore) {
        for (Figure f : getFiguresFrontToBack()) {
            if (!ignore.contains(f) && f.isVisible() && f.contains(p)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public java.util.List<Figure> findFigures(Rectangle2D.Double bounds) {
        LinkedList<Figure> intersection = new LinkedList<Figure>();
        for (Figure f : getChildren()) {
            if (f.isVisible() && f.getBounds().intersects(bounds)) {
                intersection.add(f);
            }
        }
        return intersection;
    }

    @Override
    public java.util.List<Figure> findFiguresWithin(Rectangle2D.Double bounds) {
        LinkedList<Figure> contained = new LinkedList<Figure>();
        for (Figure f : getChildren()) {
            Rectangle2D.Double r = f.getBounds();
            if (f.get(TRANSFORM) != null) {
                Rectangle2D rt = f.get(TRANSFORM).createTransformedShape(r).getBounds2D();
                r = (rt instanceof Rectangle2D.Double) ? (Rectangle2D.Double) rt : new Rectangle2D.Double(rt.getX(), rt.getY(), rt.getWidth(), rt.getHeight());
            }
            if (f.isVisible() && Geom.contains(bounds, r)) {
                contained.add(f);
            }
        }
        return contained;
    }

    @Override
    public Figure findFigureInside(Point2D.Double p) {
        Figure f = findFigure(p);
        return (f == null) ? null : f.findFigureInside(p);
    }

    /**
     * Returns an iterator to iterate in
     * Z-order front to back over the children.
     */
    @Override
    public java.util.List<Figure> getFiguresFrontToBack() {
        ensureSorted();
        return new ReversedList<Figure>(getChildren());
    }

    /**
     * Invalidates the sort order.
     */
    private void invalidateSortOrder() {
        needsSorting = true;
    }

    /**
     * Ensures that the children are sorted in z-order sequence from back to
     * front.
     */
    private void ensureSorted() {
        if (needsSorting) {
            Collections.sort(children, FigureLayerComparator.INSTANCE);
            needsSorting = false;
        }
    }

    @Override
    protected void setAttributeOnChildren(AttributeKey key, Object newValue) {
        // empty
    }

    @Override
    public int indexOf(Figure figure) {
        return children.indexOf(figure);
    }

    @Override
    protected void drawFill(Graphics2D g) {
        //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void drawStroke(Graphics2D g) {
        //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void drawCanvas(Graphics2D g) {
        if (get(CANVAS_WIDTH) != null && get(CANVAS_HEIGHT) != null) {
            // Determine canvas color and opacity
            Color canvasColor = get(CANVAS_FILL_COLOR);
            Double fillOpacity = get(CANVAS_FILL_OPACITY);
            if (canvasColor != null && fillOpacity > 0) {
                canvasColor = new Color(
                        (canvasColor.getRGB() & 0xffffff)
                        | ((int) (fillOpacity * 255) << 24), true);

                // Fill the canvas
                Rectangle2D.Double r = new Rectangle2D.Double(
                        0, 0, get(CANVAS_WIDTH), get(CANVAS_HEIGHT));

                g.setColor(canvasColor);
                g.fill(r);
            }
        }
    }
}
