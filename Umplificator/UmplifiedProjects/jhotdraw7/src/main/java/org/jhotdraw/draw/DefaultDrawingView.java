/*
 * @(#)DefaultDrawingView.java
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
import org.jhotdraw.draw.event.FigureSelectionEvent;
import org.jhotdraw.draw.event.FigureSelectionListener;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.event.HandleListener;
import org.jhotdraw.draw.event.HandleEvent;
import org.jhotdraw.draw.event.FigureListener;
import org.jhotdraw.draw.event.FigureAdapter;
import org.jhotdraw.draw.event.FigureEvent;
import org.jhotdraw.draw.event.CompositeFigureListener;
import org.jhotdraw.draw.event.CompositeFigureEvent;
import javax.swing.undo.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.gui.EditableComponent;
import static org.jhotdraw.draw.AttributeKeys.*;
import java.awt.image.VolatileImage;

/**
 * A default implementation of {@link DrawingView} suited for viewing drawings
 * with a small number of figures.
 *
 * FIXME - Implement clone Method.
 * FIXME - Use double buffering for the drawing to improve performance.
 *
 * @author Werner Randelshofer
 * @version $Id: DefaultDrawingView.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DefaultDrawingView
        extends JComponent
        implements DrawingView, EditableComponent {

    /**
     * Set this to true to turn on debugging output on System.out.
     */
    private final static boolean DEBUG = false;
    @Nullable
    private Drawing drawing;
    /**
     * Holds the selected figures in an ordered put. The ordering reflects
     * the sequence that was used to select the figures.
     */
    private Set<Figure> selectedFigures = new LinkedHashSet<Figure>();
    private LinkedList<Handle> selectionHandles = new LinkedList<Handle>();
    private boolean isConstrainerVisible = false;
    private Constrainer visibleConstrainer = new GridConstrainer(8, 8);
    private Constrainer invisibleConstrainer = new GridConstrainer();
    private Handle secondaryHandleOwner;
    @Nullable private Handle activeHandle;
    private LinkedList<Handle> secondaryHandles = new LinkedList<Handle>();
    private boolean handlesAreValid = true;
    @Nullable
    private transient Dimension cachedPreferredSize;
    private double scaleFactor = 1;
    private Point translation = new Point(0, 0);
    private int detailLevel;
    @Nullable
    private DrawingEditor editor;
    private JLabel emptyDrawingLabel;
    protected BufferedImage backgroundTile;
    private FigureListener handleInvalidator = new FigureAdapter() {

        @Override
        public void figureHandlesChanged(FigureEvent e) {
            invalidateHandles();
        }
    };
    @Nullable
    private transient Rectangle2D.Double cachedDrawingArea;
    public final static String DRAWING_DOUBLE_BUFFERED_PROPERTY = "drawingDoubleBuffered";
    /** Whether the drawing is double buffered*/
    private boolean isDrawingDoubleBuffered = true;
    /** The drawingBuffer holds a rendered image of the drawing (in view coordinates). */
    @Nullable
    private VolatileImage drawingBufferV;
    /** The drawingBuffer holds a rendered image of the drawing (in view coordinates). */
    @Nullable
    private BufferedImage drawingBufferNV;
    /** Holds the drawing area (in view coordinates) which is in the drawing buffer. */
    private Rectangle bufferedArea = new Rectangle();
    /** Holds the drawing area (in view coordinates) which has not been redrawn yet in the drawing buffer. */
    private Rectangle dirtyArea = new Rectangle(0, 0, -1, -1);
    private boolean paintEnabled = true;
    private final static boolean isWindows;

    static {
        boolean b = false;
        try {
            if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
                b = true;
            }
        } catch (Throwable t) {
        }
        isWindows = b;
    }

    @Override
    public void repaintHandles() {
        validateHandles();
        Rectangle r = null;
        for (Handle h : getSelectionHandles()) {
            if (r == null) {
                r = h.getDrawingArea();
            } else {
                r.add(h.getDrawingArea());
            }
        }
        for (Handle h : getSecondaryHandles()) {
            if (r == null) {
                r = h.getDrawingArea();
            } else {
                r.add(h.getDrawingArea());
            }
        }
        if (r != null) {
            repaint(r);
        }
    }

    /** Draws the background of the drawing view. */
    protected void drawBackground(Graphics2D g) {
        if (drawing == null) {
            // there is no drawing and thus no canvas
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        } else if (drawing.get(CANVAS_WIDTH) == null
                || drawing.get(CANVAS_HEIGHT) == null) {
            // the canvas is infinitely large
            Color canvasColor = drawing.get(CANVAS_FILL_COLOR);
            double canvasOpacity = drawing.get(CANVAS_FILL_OPACITY);
            if (canvasColor != null) {
                if (canvasOpacity == 1) {
                    g.setColor(new Color(canvasColor.getRGB()));
                    g.fillRect(0, 0, getWidth(), getHeight());
                } else {
                    Point r = drawingToView(new Point2D.Double(0, 0));
                    g.setPaint(getBackgroundPaint(r.x, r.y));
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.setColor(new Color(canvasColor.getRGB() & 0xfffff | ((int) (canvasOpacity * 256) << 24), true));
                    g.fillRect(0, 0, getWidth(), getHeight());
                }
            } else {
                Point r = drawingToView(new Point2D.Double(0, 0));
                g.setPaint(getBackgroundPaint(r.x, r.y));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        } else {
            // the canvas has a fixed size
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
            Rectangle r = drawingToView(new Rectangle2D.Double(0, 0, drawing.get(CANVAS_WIDTH),
                    drawing.get(CANVAS_HEIGHT)));
            g.setPaint(getBackgroundPaint(r.x, r.y));
            g.fillRect(r.x, r.y, r.width, r.height);
        }
    }

    @Override
    public boolean isSelectionEmpty() {
        return selectedFigures.isEmpty();
    }

    private class EventHandler implements FigureListener, CompositeFigureListener, HandleListener, FocusListener {

        @Override
        public void figureAdded(CompositeFigureEvent evt) {
            if (drawing.getChildCount() == 1 && getEmptyDrawingMessage() != null) {
                repaint();
            } else {
                repaintDrawingArea(evt.getInvalidatedArea());
            }
            invalidateDimension();
        }

        @Override
        public void figureRemoved(CompositeFigureEvent evt) {
            if (drawing.getChildCount() == 0 && getEmptyDrawingMessage() != null) {
                repaint();
            } else {
                repaintDrawingArea(evt.getInvalidatedArea());
            }
            removeFromSelection(evt.getChildFigure());
            invalidateDimension();
        }

        @Override
        public void areaInvalidated(FigureEvent evt) {
            repaintDrawingArea(evt.getInvalidatedArea());
            invalidateDimension();
        }

        @Override
        public void areaInvalidated(HandleEvent evt) {
            repaint(evt.getInvalidatedArea());
            invalidateDimension();
        }

        @Override
        public void handleRequestSecondaryHandles(HandleEvent e) {
            secondaryHandleOwner = e.getHandle();
            secondaryHandles.clear();
            secondaryHandles.addAll(secondaryHandleOwner.createSecondaryHandles());
            for (Handle h : secondaryHandles) {
                h.setView(DefaultDrawingView.this);
                h.addHandleListener(eventHandler);
            }
            repaint();
        }

        @Override
        public void focusGained(FocusEvent e) {
            //   repaintHandles();
            if (editor != null) {
                editor.setActiveView(DefaultDrawingView.this);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            //   repaintHandles();
        }

        @Override
        public void handleRequestRemove(HandleEvent e) {
            selectionHandles.remove(e.getHandle());
            e.getHandle().dispose();
            invalidateHandles();
            repaint(e.getInvalidatedArea());
        }

        @Override
        public void attributeChanged(FigureEvent e) {
            if (e.getSource() == drawing) {
                AttributeKey a = e.getAttribute();
                if (a.equals(CANVAS_HEIGHT) || a.equals(CANVAS_WIDTH)) {
                    validateViewTranslation();
                    repaint(); // must repaint everything
                }
                if (e.getInvalidatedArea() != null) {
                    repaintDrawingArea(e.getInvalidatedArea());
                } else {
                    repaintDrawingArea(viewToDrawing(getCanvasViewBounds()));
                }
            } else {
                if (e.getInvalidatedArea() != null) {
                    repaintDrawingArea(e.getInvalidatedArea());
                }
            }
        }

        @Override
        public void figureHandlesChanged(FigureEvent e) {
        }

        @Override
        public void figureChanged(FigureEvent e) {
            repaintDrawingArea(e.getInvalidatedArea());
        }

        @Override
        public void figureAdded(FigureEvent e) {
        }

        @Override
        public void figureRemoved(FigureEvent e) {
        }

        @Override
        public void figureRequestRemove(FigureEvent e) {
        }
    }
    private EventHandler eventHandler;

    /** Creates new instance. */
    public DefaultDrawingView() {
        initComponents();
        eventHandler = createEventHandler();
        setToolTipText("dummy"); // Set a dummy tool tip text to turn tooltips on

        setFocusable(true);
        addFocusListener(eventHandler);
        setTransferHandler(new DefaultDrawingViewTransferHandler());
        setBackground(new Color(0xb0b0b0));
        setOpaque(true);
    }

    protected EventHandler createEventHandler() {
        return new EventHandler();
    }

    /** This method is called from within the constructor to
     * initialize the form.<p>
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.<p>
     * NOTE: To prevent undesired layout effects when using floating
     * text fields, the DefaultDrawingView must not use a layout manager.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    @Nullable
    public Drawing getDrawing() {
        return drawing;
    }

    @Override
    public String getToolTipText(MouseEvent evt) {
        if (getEditor() != null && getEditor().getTool() != null) {
            return getEditor().getTool().getToolTipText(this, evt);
        }
        return null;
    }

    public void setEmptyDrawingMessage(String newValue) {
        String oldValue = (emptyDrawingLabel == null) ? null : emptyDrawingLabel.getText();
        if (newValue == null) {
            emptyDrawingLabel = null;
        } else {
            emptyDrawingLabel = new JLabel(newValue);
            emptyDrawingLabel.setHorizontalAlignment(JLabel.CENTER);
        }
        firePropertyChange("emptyDrawingMessage", oldValue, newValue);
        repaint();
    }

    public String getEmptyDrawingMessage() {
        return (emptyDrawingLabel == null) ? null : emptyDrawingLabel.getText();
    }

    /**
     * Paints the drawing view.
     * Uses rendering hints for fast painting. Paints the canvasColor, the
     * grid, the drawing, the handles and the current tool.
     */
    @Override
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        setViewRenderingHints(g);
        drawBackground(g);
        drawCanvas(g);
        drawConstrainer(g);
        if (isDrawingDoubleBuffered()) {
            if (isWindows) {
                drawDrawingNonvolatileBuffered(g);
            } else {
                drawDrawingVolatileBuffered(g);
            }
        } else {
            drawDrawing(g);
        }
        drawHandles(g);
        drawTool(g);
    }

    /** Draws the drawing double buffered using a volatile image. */
    protected void drawDrawingVolatileBuffered(Graphics2D g) {
        Rectangle vr = getVisibleRect();
        Point shift = new Point(0, 0);
        if (bufferedArea.contains(vr)
                || bufferedArea.width >= vr.width && bufferedArea.height >= vr.height) {
            // The visible rect fits into the buffered area, but may be shifted; shift the buffered area.
            shift.x = bufferedArea.x - vr.x;
            shift.y = bufferedArea.y - vr.y;
            if (shift.x > 0) {
                dirtyArea.add(new Rectangle(bufferedArea.x - shift.x, vr.y, shift.x + bufferedArea.width - vr.width, bufferedArea.height));
            } else if (shift.x < 0) {
                dirtyArea.add(new Rectangle(bufferedArea.x + vr.width, vr.y, -shift.x + bufferedArea.width - vr.width, bufferedArea.height));
            }
            if (shift.y > 0) {
                dirtyArea.add(new Rectangle(vr.x, bufferedArea.y - shift.y, bufferedArea.width, shift.y + bufferedArea.height - vr.height));
            } else if (shift.y < 0) {
                dirtyArea.add(new Rectangle(vr.x, bufferedArea.y + vr.height, bufferedArea.width, -shift.y + bufferedArea.height - vr.height));
            }
            bufferedArea.x = vr.x;
            bufferedArea.y = vr.y;
        } else {
            // The buffered drawing area does not match the visible rect;
            // resize it, and mark everything as dirty.
            bufferedArea.setBounds(vr);
            dirtyArea.setBounds(vr);
            if (drawingBufferV != null && //
                    (drawingBufferV.getWidth() != vr.width
                    || drawingBufferV.getHeight() != vr.height)) {
                // The dimension of the drawing buffer does not fit into the visible rect;
                // throw the buffer away.
                drawingBufferV.flush();
                drawingBufferV = null;
            }
        }
        // Update the contents of the buffer if necessary
        while (true) {
            int valid = (drawingBufferV == null) ? //
                    VolatileImage.IMAGE_INCOMPATIBLE : //
                    drawingBufferV.validate(getGraphicsConfiguration());
            switch (valid) {
                case VolatileImage.IMAGE_INCOMPATIBLE:
                    // old buffer doesn't work with new GraphicsConfig; (re-)create it
                    try {
                        drawingBufferV = getGraphicsConfiguration().createCompatibleVolatileImage(vr.width, vr.height, Transparency.TRANSLUCENT);
                    } catch (OutOfMemoryError e) {
                        drawingBufferV = null;
                    }
                    dirtyArea.setBounds(bufferedArea);
                    break;
                case VolatileImage.IMAGE_RESTORED:
                    // image was restored, but buffer lost; redraw everything
                    dirtyArea.setBounds(bufferedArea);
                    break;
            }

            if (drawingBufferV == null) {
                // There is not enough memory available for a drawing buffer;
                // draw without buffering.
                drawDrawing(g);
                break;
            }

            if (!dirtyArea.isEmpty()) {
                // An area of the drawing buffer is dirty; repaint it
                Graphics2D gBuf = drawingBufferV.createGraphics();
                setViewRenderingHints(gBuf);

                // For shifting and cleaning, we need to erase everything underneath
                gBuf.setComposite(AlphaComposite.Src);

                // Perform shifting if needed
                if (shift.x != 0 || shift.y != 0) {
                    gBuf.copyArea(Math.max(0, -shift.x), Math.max(0, -shift.y), drawingBufferV.getWidth() - Math.abs(shift.x), drawingBufferV.getHeight() - Math.abs(shift.y), shift.x, shift.y);
                    shift.x = shift.y = 0;
                }

                // Clip the dirty area
                gBuf.translate(-bufferedArea.x, -bufferedArea.y);
                gBuf.clip(dirtyArea);

                // Clear the dirty area
                gBuf.setBackground(new Color(0x0, true));
                gBuf.clearRect(dirtyArea.x, dirtyArea.y, dirtyArea.width, dirtyArea.height);
                gBuf.setComposite(AlphaComposite.SrcOver);

                // Repaint the dirty area
                drawDrawing(gBuf);
                gBuf.dispose();
            }

            if (!drawingBufferV.contentsLost()) {
                g.drawImage(drawingBufferV, bufferedArea.x, bufferedArea.y, null);
            }

            if (drawingBufferV.contentsLost()) {
                dirtyArea.setBounds(bufferedArea);
            } else {
                dirtyArea.setSize(-1, -1);
                break;
            }
        }
    }

    /** Draws the drawing double buffered using a buffered image. */
    protected void drawDrawingNonvolatileBuffered(Graphics2D g) {
        Rectangle vr = getVisibleRect();
        Point shift = new Point(0, 0);
        if (bufferedArea.contains(vr)
                || bufferedArea.width >= vr.width && bufferedArea.height >= vr.height) {
            // The visible rect fits into the buffered area, but may be shifted; shift the buffered area.
            shift.x = bufferedArea.x - vr.x;
            shift.y = bufferedArea.y - vr.y;
            if (shift.x > 0) {
                dirtyArea.add(new Rectangle(bufferedArea.x - shift.x, vr.y, shift.x + bufferedArea.width - vr.width, bufferedArea.height));
            } else if (shift.x < 0) {
                dirtyArea.add(new Rectangle(bufferedArea.x + vr.width, vr.y, -shift.x + bufferedArea.width - vr.width, bufferedArea.height));
            }
            if (shift.y > 0) {
                dirtyArea.add(new Rectangle(vr.x, bufferedArea.y - shift.y, bufferedArea.width, shift.y + bufferedArea.height - vr.height));
            } else if (shift.y < 0) {
                dirtyArea.add(new Rectangle(vr.x, bufferedArea.y + vr.height, bufferedArea.width, -shift.y + bufferedArea.height - vr.height));
            }
            bufferedArea.x = vr.x;
            bufferedArea.y = vr.y;
        } else {
            // The buffered drawing area does not match the visible rect;
            // resize it, and mark everything as dirty.
            bufferedArea.setBounds(vr);
            dirtyArea.setBounds(vr);
            if (drawingBufferNV != null && //
                    (drawingBufferNV.getWidth() != vr.width
                    || drawingBufferNV.getHeight() != vr.height)) {
                // The dimension of the drawing buffer does not fit into the visible rect;
                // throw the buffer away.
                drawingBufferNV.flush();
                drawingBufferNV = null;
            }
        }
        // Update the contents of the buffer if necessary

        int valid = (drawingBufferNV == null) ? //
                VolatileImage.IMAGE_INCOMPATIBLE : VolatileImage.IMAGE_OK;
        switch (valid) {
            case VolatileImage.IMAGE_INCOMPATIBLE:
                // old buffer doesn't work with new GraphicsConfig; (re-)create it
                try {
                    drawingBufferNV = getGraphicsConfiguration().createCompatibleImage(vr.width, vr.height, Transparency.TRANSLUCENT);
                } catch (OutOfMemoryError e) {
                    drawingBufferNV = null;
                }
                dirtyArea.setBounds(bufferedArea);
                break;
        }

        if (drawingBufferNV == null) {
            // There is not enough memory available for a drawing buffer;
            // draw without buffering.
            drawDrawing(g);
            return;
        }

        if (!dirtyArea.isEmpty()) {
            // An area of the drawing buffer is dirty; repaint it
            Graphics2D gBuf = drawingBufferNV.createGraphics();
            setViewRenderingHints(gBuf);

            // For shifting and cleaning, we need to erase everything underneath
            gBuf.setComposite(AlphaComposite.Src);

            // Perform shifting if needed
            if (shift.x != 0 || shift.y != 0) {
                gBuf.copyArea(Math.max(0, -shift.x), Math.max(0, -shift.y), drawingBufferNV.getWidth() - Math.abs(shift.x), drawingBufferNV.getHeight() - Math.abs(shift.y), shift.x, shift.y);
                shift.x = shift.y = 0;
            }

            // Clip the dirty area
            gBuf.translate(-bufferedArea.x, -bufferedArea.y);
            gBuf.clip(dirtyArea);

            // Clear the dirty area
            gBuf.setBackground(new Color(0x0, true));
            gBuf.clearRect(dirtyArea.x, dirtyArea.y, dirtyArea.width, dirtyArea.height);
            gBuf.setComposite(AlphaComposite.SrcOver);

            // Repaint the dirty area
            drawDrawing(gBuf);
            gBuf.dispose();
        }

        g.drawImage(drawingBufferNV, bufferedArea.x, bufferedArea.y, null);

        dirtyArea.setSize(-1, -1);
    }

    /**
     * Prints the drawing view.
     * Uses high quality rendering hints for printing. Only prints the drawing.
     * Doesn't print the canvasColor, the grid, the handles and the tool.
     */
    @Override
    public void printComponent(Graphics gr) {

        Graphics2D g = (Graphics2D) gr;

        // Set rendering hints for quality
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        drawDrawing(g);
    }

    protected void setViewRenderingHints(Graphics2D g) {
        // Set rendering hints for speed
        g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    /**
     * Returns the bounds of the canvas on the drawing view.
     *
     * @return The current bounds of the canvas on the drawing view.
     */
    protected Rectangle getCanvasViewBounds() {
        // Position of the zero coordinate point on the view
        int x = -translation.x;
        int y = -translation.y;

        int w = getWidth();
        int h = getHeight();

        if (getDrawing() != null) {
            Double cw = getDrawing().get(CANVAS_WIDTH);
            Double ch = getDrawing().get(CANVAS_HEIGHT);
            if (cw != null && ch != null) {
                Point lowerRight = drawingToView(
                        new Point2D.Double(cw, ch));
                w = lowerRight.x - x;
                h = lowerRight.y - y;
            }

        }

        return new Rectangle(x, y, w, h);
    }

    /** Draws the canvas. If the {@code AttributeKeys.CANVAS_FILL_OPACITY} is
     * not fully opaque, the canvas area is filled with the background paint
     * before the {@code AttributeKeys.CANVAS_FILL_COLOR} is drawn.
     */
    protected void drawCanvas(Graphics2D gr) {
        if (drawing != null) {
            Graphics2D g = (Graphics2D) gr.create();
            AffineTransform tx = g.getTransform();
            tx.translate(-translation.x, -translation.y);
            tx.scale(scaleFactor, scaleFactor);
            g.setTransform(tx);

            drawing.setFontRenderContext(g.getFontRenderContext());
            drawing.drawCanvas(g);
            g.dispose();
        }
    }

    protected void drawConstrainer(Graphics2D g) {
        Shape clip = g.getClip();

        Rectangle r = getCanvasViewBounds();
        g.clipRect(r.x, r.y, r.width, r.height);
        getConstrainer().draw(g, this);

        g.setClip(clip);
    }

    protected void drawDrawing(Graphics2D gr) {

        if (drawing != null) {
            if (drawing.getChildCount() == 0 && emptyDrawingLabel != null) {
                emptyDrawingLabel.setBounds(0, 0, getWidth(), getHeight());
                emptyDrawingLabel.paint(gr);
            } else {
                Graphics2D g = (Graphics2D) gr.create();
                AffineTransform tx = g.getTransform();
                tx.translate(-translation.x, -translation.y);
                tx.scale(scaleFactor, scaleFactor);
                g.setTransform(tx);

                drawing.setFontRenderContext(g.getFontRenderContext());
                drawing.draw(g);

                g.dispose();
            }

        }
    }

    protected void drawHandles(java.awt.Graphics2D g) {
        if (editor != null && editor.getActiveView() == this) {
            validateHandles();
            for (Handle h : getSelectionHandles()) {
                h.draw(g);
            }

            for (Handle h : getSecondaryHandles()) {
                h.draw(g);
            }

        }
    }

    protected void drawTool(Graphics2D g) {
        if (editor != null && editor.getActiveView() == this && editor.getTool() != null) {
            editor.getTool().draw(g);
        }

    }

    @Override
    public void setDrawing(@Nullable Drawing newValue) {
        Drawing oldValue = drawing;
        if (this.drawing != null) {
            this.drawing.removeCompositeFigureListener(eventHandler);
            this.drawing.removeFigureListener(eventHandler);
            clearSelection();
        }

        this.drawing = newValue;
        if (this.drawing != null) {
            this.drawing.addCompositeFigureListener(eventHandler);
            this.drawing.addFigureListener(eventHandler);
        }
        dirtyArea.add(bufferedArea);

        firePropertyChange(DRAWING_PROPERTY, oldValue, newValue);

        // Revalidate without flickering
        revalidate();
        validateViewTranslation();
        paintEnabled = false;
        javax.swing.Timer t = new javax.swing.Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                paintEnabled = true;
            }
        });
        t.setRepeats(false);
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        if (paintEnabled) {
            super.paint(g);
        }
    }

    protected void repaintDrawingArea(Rectangle2D.Double r) {
        Rectangle vr = drawingToView(r);
        vr.grow(1, 1);
        dirtyArea.add(vr);

        repaint(vr);
    }

    @Override
    public void invalidate() {
        invalidateDimension();
        super.invalidate();
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
        if (drawingBufferNV != null) {
            drawingBufferNV.flush();
            drawingBufferNV = null;
        }
        if (drawingBufferV != null) {
            drawingBufferV.flush();
            drawingBufferV = null;
        }
    }

    /**
     * Adds a figure to the current selection.
     */
    @Override
    public void addToSelection(Figure figure) {
        if (DEBUG) {
            System.out.println("DefaultDrawingView" + ".addToSelection(" + figure + ")");
        }

        Set<Figure> oldSelection = new HashSet<Figure>(selectedFigures);
        if (selectedFigures.add(figure)) {
            figure.addFigureListener(handleInvalidator);
            Set<Figure> newSelection = new HashSet<Figure>(selectedFigures);
            Rectangle invalidatedArea = null;
            if (handlesAreValid && getEditor() != null) {
                for (Handle h : figure.createHandles(detailLevel)) {
                    h.setView(this);
                    selectionHandles.add(h);
                    h.addHandleListener(eventHandler);
                    if (invalidatedArea == null) {
                        invalidatedArea = h.getDrawingArea();
                    } else {
                        invalidatedArea.add(h.getDrawingArea());
                    }

                }
            }
            fireSelectionChanged(oldSelection, newSelection);
            if (invalidatedArea != null) {
                repaint(invalidatedArea);
            }

        }
    }

    /**
     * Adds a collection of figures to the current selection.
     */
    @Override
    public void addToSelection(Collection<Figure> figures) {
        Set<Figure> oldSelection = new HashSet<Figure>(selectedFigures);
        Set<Figure> newSelection = new HashSet<Figure>(selectedFigures);
        boolean selectionChanged = false;
        Rectangle invalidatedArea = null;
        for (Figure figure : figures) {
            if (selectedFigures.add(figure)) {
                selectionChanged = true;
                newSelection.add(figure);
                figure.addFigureListener(handleInvalidator);
                if (handlesAreValid && getEditor() != null) {
                    for (Handle h : figure.createHandles(detailLevel)) {
                        h.setView(this);
                        selectionHandles.add(h);
                        h.addHandleListener(eventHandler);
                        if (invalidatedArea == null) {
                            invalidatedArea = h.getDrawingArea();
                        } else {
                            invalidatedArea.add(h.getDrawingArea());
                        }

                    }
                }
            }
        }
        if (selectionChanged) {
            fireSelectionChanged(oldSelection, newSelection);
            if (invalidatedArea != null) {
                repaint(invalidatedArea);
            }

        }
    }

    /**
     * Removes a figure from the selection.
     */
    @Override
    public void removeFromSelection(Figure figure) {
        Set<Figure> oldSelection = new HashSet<Figure>(selectedFigures);
        if (selectedFigures.remove(figure)) {
            Set<Figure> newSelection = new HashSet<Figure>(selectedFigures);
            invalidateHandles();

            figure.removeFigureListener(handleInvalidator);
            fireSelectionChanged(oldSelection, newSelection);
            repaint();
        }
    }

    /**
     * If a figure isn't selected it is added to the selection.
     * Otherwise it is removed from the selection.
     */
    @Override
    public void toggleSelection(Figure figure) {
        if (selectedFigures.contains(figure)) {
            removeFromSelection(figure);
        } else {
            addToSelection(figure);
        }

    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        setCursor(Cursor.getPredefinedCursor(b ? Cursor.DEFAULT_CURSOR : Cursor.WAIT_CURSOR));
    }

    /**
     * Selects all selectable figures.
     */
    @Override
    public void selectAll() {
        Set<Figure> oldSelection = new HashSet<Figure>(selectedFigures);
        selectedFigures.clear();

        for (Figure figure : drawing.getChildren()) {
            if (figure.isSelectable()) {
                selectedFigures.add(figure);
            }

        }

        Set<Figure> newSelection = new HashSet<Figure>(selectedFigures);
        invalidateHandles();

        fireSelectionChanged(oldSelection, newSelection);
        repaint();

    }

    /**
     * Clears the current selection.
     */
    @Override
    public void clearSelection() {
        if (getSelectionCount() > 0) {
            Set<Figure> oldSelection = new HashSet<Figure>(selectedFigures);
            selectedFigures.clear();
            Set<Figure> newSelection = new HashSet<Figure>(selectedFigures);
            invalidateHandles();

            fireSelectionChanged(oldSelection, newSelection);
        }
    }

    /**
     * Test whether a given figure is selected.
     */
    @Override
    public boolean isFigureSelected(Figure checkFigure) {
        return selectedFigures.contains(checkFigure);
    }

    /**
     * Gets the current selection as a FigureSelection. A FigureSelection
     * can be cut, copied, pasted.
     */
    @Override
    public Set<Figure> getSelectedFigures() {
        return Collections.unmodifiableSet(selectedFigures);
    }

    /**
     * Gets the number of selected figures.
     */
    @Override
    public int getSelectionCount() {
        return selectedFigures.size();
    }

    /**
     * Gets the currently active selection handles.
     */
    private java.util.List<Handle> getSelectionHandles() {
        validateHandles();
        return Collections.unmodifiableList(selectionHandles);
    }

    /**
     * Gets the currently active secondary handles.
     */
    private java.util.List<Handle> getSecondaryHandles() {
        validateHandles();
        return Collections.unmodifiableList(secondaryHandles);
    }

    /**
     * Invalidates the handles.
     */
    private void invalidateHandles() {
        if (handlesAreValid) {
            handlesAreValid = false;

            Rectangle invalidatedArea = null;
            for (Handle handle : selectionHandles) {
                handle.removeHandleListener(eventHandler);
                if (invalidatedArea == null) {
                    invalidatedArea = handle.getDrawingArea();
                } else {
                    invalidatedArea.add(handle.getDrawingArea());
                }

                handle.dispose();
            }

            for (Handle handle : secondaryHandles) {
                handle.removeHandleListener(eventHandler);
                if (invalidatedArea == null) {
                    invalidatedArea = handle.getDrawingArea();
                } else {
                    invalidatedArea.add(handle.getDrawingArea());
                }

                handle.dispose();
            }

            selectionHandles.clear();
            secondaryHandles.clear();
            setActiveHandle(null);
            if (invalidatedArea != null) {
                repaint(invalidatedArea);
            }

        }
    }

    /**
     * Validates the handles.
     */
    private void validateHandles() {
        // Validate handles only, if they are invalid, and if
        // the DrawingView has a DrawingEditor.
        if (!handlesAreValid && getEditor() != null) {
            handlesAreValid = true;
            selectionHandles.clear();
            Rectangle invalidatedArea = null;
            while (true) {
                for (Figure figure : getSelectedFigures()) {
                    for (Handle handle : figure.createHandles(detailLevel)) {
                        handle.setView(this);
                        selectionHandles.add(handle);
                        handle.addHandleListener(eventHandler);
                        if (invalidatedArea == null) {
                            invalidatedArea = handle.getDrawingArea();
                        } else {
                            invalidatedArea.add(handle.getDrawingArea());
                        }

                    }
                }

                if (selectionHandles.size() == 0 && detailLevel != 0) {
                    // No handles are available at the desired detail level.
                    // Retry with detail level 0.
                    detailLevel = 0;
                    continue;
                }
                break;
            }

            if (invalidatedArea != null) {
                repaint(invalidatedArea);
            }

        }

    }

    /**
     * Finds a handle at a given coordinates.
     * @return A handle, null if no handle is found.
     */
    @Override
    public Handle findHandle(
            Point p) {
        validateHandles();

        for (Handle handle : new ReversedList<Handle>(getSecondaryHandles())) {
            if (handle.contains(p)) {
                return handle;
            }

        }
        for (Handle handle : new ReversedList<Handle>(getSelectionHandles())) {
            if (handle.contains(p)) {
                return handle;
            }

        }
        return null;
    }

    /**
     * Gets compatible handles.
     * @return A collection containing the handle and all compatible handles.
     */
    @Override
    public Collection<Handle> getCompatibleHandles(Handle master) {
        validateHandles();

        HashSet<Figure> owners = new HashSet<Figure>();
        LinkedList<Handle> compatibleHandles = new LinkedList<Handle>();
        owners.add(master.getOwner());
        compatibleHandles.add(master);

        for (Handle handle : getSelectionHandles()) {
            if (!owners.contains(handle.getOwner()) && handle.isCombinableWith(master)) {
                owners.add(handle.getOwner());
                compatibleHandles.add(handle);
            }

        }
        return compatibleHandles;

    }

    /**
     * Finds a figure at a given coordinates.
     * @return A figure, null if no figure is found.
     */
    @Override
    public Figure findFigure(
            Point p) {
        return getDrawing().findFigure(viewToDrawing(p));
    }

    @Override
    public Collection<Figure> findFigures(Rectangle r) {
        return getDrawing().findFigures(viewToDrawing(r));
    }

    @Override
    public Collection<Figure> findFiguresWithin(Rectangle r) {
        return getDrawing().findFiguresWithin(viewToDrawing(r));
    }

    @Override
    public void addFigureSelectionListener(FigureSelectionListener fsl) {
        listenerList.add(FigureSelectionListener.class, fsl);
    }

    @Override
    public void removeFigureSelectionListener(FigureSelectionListener fsl) {
        listenerList.remove(FigureSelectionListener.class, fsl);
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     * Also notify listeners who listen for
     * {@link EditableComponent#SELECTION_EMPTY_PROPERTY}.
     */
    protected void fireSelectionChanged(
            Set<Figure> oldValue,
            Set<Figure> newValue) {
        if (listenerList.getListenerCount() > 0) {
            FigureSelectionEvent event = null;
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i
                    >= 0; i -=
                            2) {
                if (listeners[i] == FigureSelectionListener.class) {
                    // Lazily create the event:
                    if (event == null) {
                        event = new FigureSelectionEvent(this, oldValue, newValue);
                    }
                    ((FigureSelectionListener) listeners[i + 1]).selectionChanged(event);
                }
            }

        }

        firePropertyChange(EditableComponent.SELECTION_EMPTY_PROPERTY, oldValue.isEmpty(), newValue.isEmpty());
    }

    protected void invalidateDimension() {
        cachedPreferredSize = null;
        cachedDrawingArea = null;
    }

    @Override
    public Constrainer getConstrainer() {
        return isConstrainerVisible() ? visibleConstrainer : invisibleConstrainer;
    }

    @Override
    public Dimension getPreferredSize() {
        if (cachedPreferredSize == null) {
            Rectangle2D.Double r = getDrawingArea();
            Double cw = getDrawing() == null ? null : getDrawing().get(CANVAS_WIDTH);
            Double ch = getDrawing() == null ? null : getDrawing().get(CANVAS_HEIGHT);
            Insets insets = getInsets();
            if (cw == null || ch == null) {
                cachedPreferredSize = new Dimension(
                        (int) Math.ceil((Math.max(0, r.x) + r.width) * scaleFactor) + insets.left + insets.right,
                        (int) Math.ceil((Math.max(0, r.y) + r.height) * scaleFactor) + insets.top + insets.bottom);
            } else {
                cachedPreferredSize = new Dimension(
                        (int) Math.ceil((-Math.min(0, r.x) + Math.max(Math.max(0, r.x) + r.width + Math.min(0, r.x), cw)) * scaleFactor) + insets.left + insets.right,
                        (int) Math.ceil((-Math.min(0, r.y) + Math.max(Math.max(0, r.y) + r.height + Math.min(0, r.y), ch)) * scaleFactor) + insets.top + insets.bottom);
            }
        }
        return (Dimension) cachedPreferredSize.clone();
    }

    protected Rectangle2D.Double getDrawingArea() {
        if (cachedDrawingArea == null) {
            if (drawing != null) {
                cachedDrawingArea = drawing.getDrawingArea();
            } else {
                cachedDrawingArea = new Rectangle2D.Double();
            }
        }

        return (Rectangle2D.Double) cachedDrawingArea.clone();
    }

    /**
     * Side effect: Changes view Translation.
     */
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        validateViewTranslation();
    }

    /**
     * Updates the view translation taking into account the current dimension
     * of the view JComponent, the size of the drawing, and the scale factor.
     */
    private void validateViewTranslation() {
        if (getDrawing() == null) {
            translation.x = translation.y = 0;
            return;

        }
        Point oldTranslation = (Point) translation.clone();

        int width = getWidth();
        int height = getHeight();
        Insets insets = getInsets();
        Rectangle2D.Double da = getDrawingArea();
        Rectangle r = new Rectangle((int) (da.x * scaleFactor), (int) (da.y * scaleFactor), (int) (da.width * scaleFactor), (int) (da.height * scaleFactor));

        Double cwd = getDrawing().get(CANVAS_WIDTH);
        Double chd = getDrawing().get(CANVAS_HEIGHT);
        if (cwd == null || chd == null) {
            // The canvas size is not explicitly specified.

            //Place the canvas at the top left
            translation.x = insets.top;
            translation.y = insets.left;
        } else {
            // The canvas size is explicitly specified.
            int cw, ch;
            cw = (int) (cwd * scaleFactor);
            ch = (int) (chd * scaleFactor);

            //Place the canvas at the center
            if (cw < width) {
                translation.x = insets.left + (width - insets.left - insets.right - cw) / -2;
            }
            if (ch < height) {
                translation.y = insets.top + (height - insets.top - insets.bottom - ch) / -2;
            }
        }

        if (r.y + r.height - translation.y > (height - insets.bottom)) {
            // We cut off the lower part of the drawing -> shift the canvas up
            translation.y = r.y + r.height - (height - insets.bottom);
        }
        if (Math.min(0, r.y) - translation.y < insets.top) {
            // We cut off the upper part of the drawing -> shift the canvas down
            translation.y = Math.min(0, r.y) - insets.top;
        }

        if (r.x + r.width - translation.x > (width - insets.right)) {
            // We cut off the right part of the drawing -> shift the canvas left
            translation.x = r.x + r.width - (width - insets.right);
        }
        if (Math.min(0, r.x) - translation.x < insets.left) {
            // We cut off the left part of the drawing -> shift the canvas right
            translation.x = Math.min(0, r.x) - insets.left;
        }

        if (!oldTranslation.equals(translation)) {
            bufferedArea.translate(oldTranslation.x - translation.x, oldTranslation.y - translation.y);
            fireViewTransformChanged();
        }
    }

    /**
     * Converts drawing coordinates to view coordinates.
     */
    @Override
    public Point drawingToView(
            Point2D.Double p) {
        return new Point(
                (int) (p.x * scaleFactor) - translation.x,
                (int) (p.y * scaleFactor) - translation.y);
    }

    @Override
    public Rectangle drawingToView(
            Rectangle2D.Double r) {
        return new Rectangle(
                (int) (r.x * scaleFactor) - translation.x,
                (int) (r.y * scaleFactor) - translation.y,
                (int) (r.width * scaleFactor),
                (int) (r.height * scaleFactor));
    }

    /**
     * Converts view coordinates to drawing coordinates.
     */
    @Override
    public Point2D.Double viewToDrawing(Point p) {
        return new Point2D.Double(
                (p.x + translation.x) / scaleFactor,
                (p.y + translation.y) / scaleFactor);
    }

    @Override
    public Rectangle2D.Double viewToDrawing(Rectangle r) {
        return new Rectangle2D.Double(
                (r.x + translation.x) / scaleFactor,
                (r.y + translation.y) / scaleFactor,
                r.width / scaleFactor,
                r.height / scaleFactor);
    }

    @Override
    public JComponent getComponent() {
        return this;
    }

    @Override
    public double getScaleFactor() {
        return scaleFactor;
    }

    @Override
    public void setScaleFactor(double newValue) {
        double oldValue = scaleFactor;
        scaleFactor = newValue;

        validateViewTranslation();
        dirtyArea.setBounds(bufferedArea);
        invalidateHandles();
        revalidate();
        repaint();
        firePropertyChange("scaleFactor", oldValue, newValue);
    }

    protected void fireViewTransformChanged() {
        for (Handle handle : selectionHandles) {
            handle.viewTransformChanged();
        }

        for (Handle handle : secondaryHandles) {
            handle.viewTransformChanged();
        }

    }

    @Override
    public void setHandleDetailLevel(int newValue) {
        if (newValue != detailLevel) {
            detailLevel = newValue;
            invalidateHandles();
            validateHandles();
        }
    }

    @Override
    public int getHandleDetailLevel() {
        return detailLevel;
    }

    @Override
    public AffineTransform getDrawingToViewTransform() {
        AffineTransform t = new AffineTransform();
        t.translate(-translation.x, -translation.y);
        t.scale(scaleFactor, scaleFactor);
        return t;
    }

    @Override
    public void delete() {
        final java.util.List<Figure> deletedFigures = drawing.sort(getSelectedFigures());

        // Abort, if not all of the selected figures may be removed from the
        // drawing
        for (Figure f : deletedFigures) {
            if (!f.isRemovable()) {
                getToolkit().beep();
                return;
            }
        }

        // Get z-indices of deleted figures
        final int[] deletedFigureIndices = new int[deletedFigures.size()];
        for (int i = 0; i
                < deletedFigureIndices.length; i++) {
            deletedFigureIndices[i] = drawing.indexOf(deletedFigures.get(i));
        }

        clearSelection();
        getDrawing().removeAll(deletedFigures);

        getDrawing().fireUndoableEditHappened(new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                return labels.getString("edit.delete.text");
            }

            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                clearSelection();

                Drawing d = getDrawing();
                for (int i = 0; i
                        < deletedFigureIndices.length; i++) {
                    d.add(deletedFigureIndices[i], deletedFigures.get(i));
                }

                addToSelection(deletedFigures);
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                for (int i = 0; i
                        < deletedFigureIndices.length; i++) {
                    drawing.remove(deletedFigures.get(i));
                }
            }
        });
    }

    @Override
    public void duplicate() {
        Collection<Figure> sorted = getDrawing().sort(getSelectedFigures());
        HashMap<Figure, Figure> originalToDuplicateMap = new HashMap<Figure, Figure>(sorted.size());

        clearSelection();

        final ArrayList<Figure> duplicates = new ArrayList<Figure>(sorted.size());
        AffineTransform tx = new AffineTransform();
        tx.translate(5, 5);
        for (Figure f : sorted) {
            Figure d = (Figure) f.clone();
            d.transform(tx);
            duplicates.add(d);
            originalToDuplicateMap.put(f, d);
            drawing.add(d);
        }

        for (Figure f : duplicates) {
            f.remap(originalToDuplicateMap, false);
        }

        addToSelection(duplicates);

        getDrawing().fireUndoableEditHappened(new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                return labels.getString("edit.duplicate.text");
            }

            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                getDrawing().removeAll(duplicates);
            }

            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                getDrawing().addAll(duplicates);
            }
        });
    }

    @Override
    public void removeNotify(DrawingEditor editor) {
        this.editor = null;
        repaint();

    }

    @Override
    public void addNotify(DrawingEditor editor) {
        DrawingEditor oldValue = editor;
        this.editor = editor;
        firePropertyChange("editor", oldValue, editor);
        invalidateHandles();

        repaint();

    }

    @Override
    public void setVisibleConstrainer(Constrainer newValue) {
        Constrainer oldValue = visibleConstrainer;
        visibleConstrainer =
                newValue;
        firePropertyChange(VISIBLE_CONSTRAINER_PROPERTY, oldValue, newValue);
    }

    @Override
    public Constrainer getVisibleConstrainer() {
        return visibleConstrainer;
    }

    @Override
    public void setInvisibleConstrainer(Constrainer newValue) {
        Constrainer oldValue = invisibleConstrainer;
        invisibleConstrainer =
                newValue;
        firePropertyChange(INVISIBLE_CONSTRAINER_PROPERTY, oldValue, newValue);
    }

    @Override
    public Constrainer getInvisibleConstrainer() {
        return invisibleConstrainer;
    }

    @Override
    public void setConstrainerVisible(boolean newValue) {
        boolean oldValue = isConstrainerVisible;
        isConstrainerVisible =
                newValue;
        firePropertyChange(CONSTRAINER_VISIBLE_PROPERTY, oldValue, newValue);
        repaint();

    }

    @Override
    public boolean isConstrainerVisible() {
        return isConstrainerVisible;
    }

    /** Sets whether the drawing is double buffered.
     * <p>
     * The default value is true.
     * <p>
     * This is a bound property.
     * <p>
     * If the drawing view is used for editing, you should leave this to true.
     * If the drawing view is used for viewing only, you should set this to false.
     */
    public void setDrawingDoubleBuffered(boolean newValue) {
        boolean oldValue = isDrawingDoubleBuffered;
        isDrawingDoubleBuffered =
                newValue;
        if (!isDrawingDoubleBuffered && drawingBufferV != null) {
            drawingBufferV.flush();
            drawingBufferV = null;
        }
        if (!isDrawingDoubleBuffered && drawingBufferNV != null) {
            drawingBufferNV.flush();
            drawingBufferNV = null;
        }

        firePropertyChange(DRAWING_DOUBLE_BUFFERED_PROPERTY, oldValue, newValue);
    }

    /** Returns true, if the the drawing is double buffered.
     */
    public boolean isDrawingDoubleBuffered() {
        return isDrawingDoubleBuffered;
    }

    /**
     * Returns a paint for drawing the background of the drawing area.
     * @return Paint.
     */
    protected Paint getBackgroundPaint(
            int x, int y) {
        if (backgroundTile == null) {
            backgroundTile = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = backgroundTile.createGraphics();
            g.setColor(Color.white);
            g.fillRect(0, 0, 16, 16);
            g.setColor(new Color(0xdfdfdf));
            g.fillRect(0, 0, 8, 8);
            g.fillRect(8, 8, 8, 8);
            g.dispose();
        }

        return new TexturePaint(backgroundTile,
                new Rectangle(x, y, backgroundTile.getWidth(), backgroundTile.getHeight()));
    }

    @Override
    public DrawingEditor getEditor() {
        return editor;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void setActiveHandle(@Nullable Handle newValue) {
        Handle oldValue = activeHandle;
        if (oldValue != null) {
            repaint(oldValue.getDrawingArea());
        }

        activeHandle = newValue;
        if (newValue != null) {
            repaint(newValue.getDrawingArea());
        }

        firePropertyChange(ACTIVE_HANDLE_PROPERTY, oldValue, newValue);
    }

    @Override
    public Handle getActiveHandle() {
        return activeHandle;
    }
}
