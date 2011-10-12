/*
 * @(#)PathTool.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.odg;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.tool.BezierTool;
import org.jhotdraw.samples.svg.figures.*;
import org.jhotdraw.draw.*;
import java.util.*;
/**
 * Tool to scribble a ODGPath
 *
 * @author  Werner Randelshofer
 * @version $Id: PathTool.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PathTool extends BezierTool {
    /**
     * Set this to true to turn on debugging output on System.out.
     */
    private final static boolean DEBUG = false;
    /**
     * The path prototype for new figures.
     */
    private SVGPathFigure pathPrototype;
    
    /** Creates a new instance. */
    public PathTool(SVGPathFigure pathPrototype, SVGBezierFigure bezierPrototype) {
        this(pathPrototype, bezierPrototype, null);
    }
    /** Creates a new instance. */
    public PathTool(SVGPathFigure pathPrototype, SVGBezierFigure bezierPrototype, @Nullable Map<AttributeKey,Object> attributes) {
        super(bezierPrototype, attributes);
        this.pathPrototype = pathPrototype;
    }
    @SuppressWarnings("unchecked")
    protected SVGPathFigure createPath() {
        SVGPathFigure f = (SVGPathFigure) pathPrototype.clone();
        getEditor().applyDefaultAttributesTo(f);
        if (attributes != null) {
            for (Map.Entry<AttributeKey, Object> entry : attributes.entrySet()) {
                f.set(entry.getKey(), entry.getValue());
            }
        }
        return f;
    }
    @Override protected void finishCreation(BezierFigure createdFigure, DrawingView creationView) {
        if (DEBUG) System.out.println("PathTool.finishCreation "+createdFigure);
        creationView.getDrawing().remove(createdFigure);
        SVGPathFigure createdPath = createPath();
        createdPath.removeAllChildren();
        createdPath.add(createdFigure);
        creationView.getDrawing().add(createdPath);
        creationView.addToSelection(createdPath);
        fireUndoEvent(createdPath, creationView);
    }
}
