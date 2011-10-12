/*
 * @(#)CurvedLiner.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.liner;

import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.connector.Connector;
import org.jhotdraw.draw.ConnectionFigure;
import java.util.*;
import java.awt.geom.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;
import org.jhotdraw.xml.DOMStorable;

/**
 * A {@link Liner} that constrains a connection to a curved line.
 *
 * @author Werner Randelshofer
 * @version $Id: CurvedLiner.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class CurvedLiner
        implements Liner, DOMStorable {

    private double shoulderSize;

    /** Creates a new instance. */
    public CurvedLiner() {
        this(20);
    }

    public CurvedLiner(double slantSize) {
        this.shoulderSize = slantSize;
    }

    @Override
    public Collection<Handle> createHandles(BezierPath path) {
        return Collections.emptyList();
    }

    @Override
    public void lineout(ConnectionFigure figure) {
        BezierPath path = ((LineConnectionFigure) figure).getBezierPath();
        Connector start = figure.getStartConnector();
        Connector end = figure.getEndConnector();
        if (start == null || end == null || path == null) {
            return;
        }

        // Special treatment if the connection connects the same figure
        if (figure.getStartFigure() == figure.getEndFigure()) {
            // Ensure path has exactly 4 nodes
            while (path.size() < 4) {
                path.add(1, new BezierPath.Node(0, 0));
            }
            while (path.size() > 4) {
                path.remove(1);
            }
            Point2D.Double sp = start.findStart(figure);
            Point2D.Double ep = end.findEnd(figure);
            Rectangle2D.Double sb = start.getBounds();
            Rectangle2D.Double eb = end.getBounds();
            int soutcode = sb.outcode(sp);
            if (soutcode == 0) {
                soutcode = Geom.outcode(sb, eb);
            }
            int eoutcode = eb.outcode(ep);
            if (eoutcode == 0) {
                eoutcode = Geom.outcode(sb, eb);
            }

            path.get(0).moveTo(sp);
            path.get(path.size() - 1).moveTo(ep);


            switch (soutcode) {
                case Geom.OUT_TOP:
                    eoutcode = Geom.OUT_LEFT;
                    break;
                case Geom.OUT_RIGHT:
                    eoutcode = Geom.OUT_TOP;
                    break;
                case Geom.OUT_BOTTOM:
                    eoutcode = Geom.OUT_RIGHT;
                    break;
                case Geom.OUT_LEFT:
                    eoutcode = Geom.OUT_BOTTOM;
                    break;
                default:
                    eoutcode = Geom.OUT_TOP;
                    soutcode = Geom.OUT_RIGHT;
                    break;
            }
            //path.get(0).moveTo(sp.x + shoulderSize, sp.y);
            path.get(0).mask = BezierPath.C2_MASK;
            if ((soutcode & Geom.OUT_RIGHT) != 0) {
                path.get(0).x[2] = sp.x + shoulderSize;
                path.get(0).y[2] = sp.y;
            } else if ((soutcode & Geom.OUT_LEFT) != 0) {
                path.get(0).x[2] = sp.x - shoulderSize;
                path.get(0).y[2] = sp.y;
            } else if ((soutcode & Geom.OUT_BOTTOM) != 0) {
                path.get(0).x[2] = sp.x;
                path.get(0).y[2] = sp.y + shoulderSize;
            } else {
                path.get(0).x[2] = sp.x;
                path.get(0).y[2] = sp.y - shoulderSize;
            }
            path.get(1).mask = BezierPath.C2_MASK;
            path.get(1).moveTo(sp.x+shoulderSize, (sp.y+ep.y)/2);
                path.get(1).x[2] = sp.x + shoulderSize;
                path.get(1).y[2] = ep.y - shoulderSize;
            path.get(2).mask = BezierPath.C1_MASK;
            path.get(2).moveTo((sp.x+ep.x)/2, ep.y-shoulderSize);
                path.get(2).x[1] = sp.x + shoulderSize;
                path.get(2).y[1] = ep.y - shoulderSize;
            path.get(3).mask = BezierPath.C1_MASK;
            if ((eoutcode & Geom.OUT_RIGHT) != 0) {
                path.get(3).x[1] = ep.x + shoulderSize;
                path.get(3).y[1] = ep.y;
            } else if ((eoutcode & Geom.OUT_LEFT) != 0) {
                path.get(3).x[1] = ep.x - shoulderSize;
                path.get(3).y[1] = ep.y;
            } else if ((eoutcode & Geom.OUT_BOTTOM) != 0) {
                path.get(3).x[1] = ep.x;
                path.get(3).y[1] = ep.y + shoulderSize;
            } else {
                path.get(3).x[1] = ep.x;
                path.get(3).y[1] = ep.y - shoulderSize;
            }
        } else {
            Point2D.Double sp = start.findStart(figure);
            Point2D.Double ep = end.findEnd(figure);

            path.clear();

            if (sp.x == ep.x || sp.y == ep.y) {
                path.add(new BezierPath.Node(ep.x, ep.y));
            } else {
                Rectangle2D.Double sb = start.getBounds();
                sb.x += 5d;
                sb.y += 5d;
                sb.width -= 10d;
                sb.height -= 10d;
                Rectangle2D.Double eb = end.getBounds();
                eb.x += 5d;
                eb.y += 5d;
                eb.width -= 10d;
                eb.height -= 10d;

                int soutcode = sb.outcode(sp);
                if (soutcode == 0) {
                    soutcode = Geom.outcode(sb, eb);
                }
                int eoutcode = eb.outcode(ep);
                if (eoutcode == 0) {
                    eoutcode = Geom.outcode(eb, sb);
                }

                if ((soutcode & (Geom.OUT_TOP | Geom.OUT_BOTTOM)) != 0 &&
                        (eoutcode & (Geom.OUT_TOP | Geom.OUT_BOTTOM)) != 0) {
                    path.add(new BezierPath.Node(BezierPath.C2_MASK, sp.x, sp.y, sp.x, sp.y, sp.x, (sp.y + ep.y) / 2));
                    path.add(new BezierPath.Node(BezierPath.C1_MASK, ep.x, ep.y, ep.x, (sp.y + ep.y) / 2, ep.x, ep.y));
                } else if ((soutcode & (Geom.OUT_LEFT | Geom.OUT_RIGHT)) != 0 &&
                        (eoutcode & (Geom.OUT_LEFT | Geom.OUT_RIGHT)) != 0) {
                    path.add(new BezierPath.Node(BezierPath.C2_MASK, sp.x, sp.y, sp.x, sp.y, (sp.x + ep.x) / 2, sp.y));
                    path.add(new BezierPath.Node(BezierPath.C1_MASK, ep.x, ep.y, (sp.x + ep.x) / 2, ep.y, ep.x, ep.y));
                } else if (soutcode == Geom.OUT_BOTTOM || soutcode == Geom.OUT_TOP) {
                    path.add(new BezierPath.Node(BezierPath.C2_MASK, sp.x, sp.y, sp.x, sp.y, sp.x, ep.y));
                    path.add(new BezierPath.Node(ep.x, ep.y));
                } else {
                    path.add(new BezierPath.Node(BezierPath.C2_MASK, sp.x, sp.y, sp.x, sp.y, ep.x, sp.y));
                    path.add(new BezierPath.Node(ep.x, ep.y));
                }

            }
        }

        path.invalidatePath();
    }

    @Override
    public void read(DOMInput in) {
    }

    @Override
    public void write(DOMOutput out) {
    }

    @Override
    public Liner clone() {
        try {
            return (Liner) super.clone();
        } catch (CloneNotSupportedException ex) {
            InternalError error = new InternalError(ex.getMessage());
            error.initCause(ex);
            throw error;
        }
    }
}
