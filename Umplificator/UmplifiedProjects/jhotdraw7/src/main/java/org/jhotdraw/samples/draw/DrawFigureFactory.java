/*
 * @(#)DrawFigureFactory.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.draw;

import org.jhotdraw.draw.liner.ElbowLiner;
import org.jhotdraw.draw.liner.CurvedLiner;
import org.jhotdraw.draw.connector.ChopTriangleConnector;
import org.jhotdraw.draw.connector.ChopRoundRectangleConnector;
import org.jhotdraw.draw.connector.ChopRectangleConnector;
import org.jhotdraw.draw.connector.ChopEllipseConnector;
import org.jhotdraw.draw.connector.ChopDiamondConnector;
import org.jhotdraw.draw.connector.ChopBezierConnector;
import org.jhotdraw.draw.decoration.ArrowTip;
import org.jhotdraw.draw.*;
import org.jhotdraw.xml.DefaultDOMFactory;
/**
 * DrawFigureFactory.
 *
 * @author  Werner Randelshofer
 * @version $Id: DrawFigureFactory.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DrawFigureFactory extends DefaultDOMFactory {
    private final static Object[][] classTagArray = {
        { DefaultDrawing.class, "drawing" },
        { QuadTreeDrawing.class, "drawing" },
        { DiamondFigure.class, "diamond" },
        { TriangleFigure.class, "triangle" },
        { BezierFigure.class, "bezier" },
        { RectangleFigure.class, "r" },
        { RoundRectangleFigure.class, "rr" },
        { LineFigure.class, "l" },
        { BezierFigure.class, "b" },
        { LineConnectionFigure.class, "lnk" },
        { EllipseFigure.class, "e" },
        { TextFigure.class, "t" },
        { TextAreaFigure.class, "ta" },
        { ImageFigure.class, "image" },
        { GroupFigure.class, "g" },
        
        { ArrowTip.class, "arrowTip" },
        { ChopRectangleConnector.class, "rConnector" },
        { ChopEllipseConnector.class, "ellipseConnector" },
        { ChopRoundRectangleConnector.class, "rrConnector" },
        { ChopTriangleConnector.class, "triangleConnector" },
        { ChopDiamondConnector.class, "diamondConnector" },
        { ChopBezierConnector.class, "bezierConnector" },
        
        { ElbowLiner.class, "elbowLiner" },
        { CurvedLiner.class, "curvedLiner" },
    };
    private final static Object[][] enumTagArray = {
        { AttributeKeys.StrokePlacement.class, "strokePlacement" },
        { AttributeKeys.StrokeType.class, "strokeType" },
        { AttributeKeys.Underfill.class, "underfill" },
        { AttributeKeys.Orientation.class, "orientation" },
    };
    
    /** Creates a new instance. */
    public DrawFigureFactory() {
        for (Object[] o : classTagArray) {
            addStorableClass((String) o[1], (Class) o[0]);
        }
        for (Object[] o : enumTagArray) {
            addEnumClass((String) o[1], (Class) o[0]);
        }
    }
}
