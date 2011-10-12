/*
 * @(#)JColorWheel.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * The {@code JColorWheel} displays a wheel made of two components of a
 * {@code ColorSpace}.
 * <p>
 * The user can click at the wheel to pick a color.
 * <p>
 * The {@code JColorWheel} should be used together with a color slider for the
 * remaining color component(s) of the color system.
 *
 * @author  Werner Randelshofer
 * @version $Id: JColorWheel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class JColorWheel extends JPanel {
    private boolean isFlipX, isFlipY;

    public enum Type {

        POLAR,
        SQUARE,
        COMPLEX;
    }
    private Type type = Type.POLAR;
    private ColorSpace sys;
    protected Insets wheelInsets;
    @Nullable protected Image colorWheelImage;
    protected AbstractColorWheelImageProducer colorWheelProducer;
    protected ColorSliderModel model;
    /** Radial color component index. */
    protected int radialIndex = 1;
    /** Angular color component index. */
    protected int angularIndex = 0;
    /** Vertical color component index. */
    protected int verticalIndex = 2;

    private class MouseHandler extends MouseAdapter implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            update(e);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            update(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            update(e);
        }

        private void update(MouseEvent e) {
            float[] hsb = getColorAt(e.getX(), e.getY());
            model.setComponent(angularIndex, hsb[angularIndex]);
            model.setComponent(radialIndex, hsb[radialIndex]);

            // FIXME - We should only repaint the damaged area
            repaint();
        }
    }
    private MouseHandler mouseHandler;

    private class ModelHandler implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            repaint();
        }
    }
    private ModelHandler modelHandler;

    /**
     * Creates a new instance.
     */
    public JColorWheel() {
        this(HSBColorSpace.getInstance());
    }

    public JColorWheel(ColorSpace sys) {
        this.sys = sys;
        wheelInsets = new Insets(0, 0, 0, 0);
        model = new DefaultColorSliderModel(sys);
        initComponents();
        colorWheelProducer = createWheelProducer(0, 0);
        modelHandler = new ModelHandler();
        model.addChangeListener(modelHandler);
        installMouseListeners();
        setOpaque(false);
    }

    public void setType(Type type) {
        this.type = type;
        colorWheelProducer = createWheelProducer(0, 0);
    }

    protected void installMouseListeners() {
        mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    public void setModel(ColorSliderModel m) {
        if (model != null) {
            model.removeChangeListener(modelHandler);
        }
        model = m;
        if (model != null) {
            model.addChangeListener(modelHandler);
            colorWheelProducer = createWheelProducer(getWidth(), getHeight());
            repaint();
        }
    }

    public void setRadialComponentIndex(int newValue) {
        radialIndex = newValue;
        colorWheelImage = null;
        repaint();
    }

    public void setAngularComponentIndex(int newValue) {
        angularIndex = newValue;
        colorWheelImage = null;
        repaint();
    }

    public void setVerticalComponentIndex(int newValue) {
        verticalIndex = newValue;
        colorWheelImage = null;
        repaint();
    }

    public void setWheelInsets(Insets newValue) {
        wheelInsets = newValue;
        repaint();
    }

    public Insets getWheelInsets() {
        return wheelInsets;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    public ColorSliderModel getModel() {
        return model;
    }

    @Override
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        paintWheel(g);
        paintThumb(g);
    }

    public void setFlipX(boolean newValue) {
     isFlipX=newValue;
        colorWheelProducer = createWheelProducer(0, 0);
    }
    public void setFlipY(boolean newValue) {
     isFlipY=newValue;
        colorWheelProducer = createWheelProducer(0, 0);
    }
    public boolean isFlipX() {
        return isFlipX;
    }
    public boolean isFlipY() {
        return isFlipY;
    }
    protected AbstractColorWheelImageProducer createWheelProducer(int w, int h) {
        AbstractColorWheelImageProducer p;
        switch (type) {
            case POLAR:
            default:
                p = new PolarColorWheelImageProducer(model.getColorSpace(), w, h);
                break;
            case SQUARE:
                p = new ColorSquareImageProducer(model.getColorSpace(), w, h, isFlipX, isFlipY);
                break;
            case COMPLEX:
                p = new ComplexColorWheelImageProducer(model.getColorSpace(), w, h, isFlipX, isFlipY);
                break;
        }
        p.setAngularComponentIndex(angularIndex);
        p.setRadialComponentIndex(radialIndex);
        p.setVerticalComponentIndex(verticalIndex);
        return p;
    }

    protected void paintWheel(Graphics2D g) {
        int w = getWidth() - wheelInsets.left - wheelInsets.right;
        int h = getHeight() - wheelInsets.top - wheelInsets.bottom;

        if (colorWheelImage == null || colorWheelImage.getWidth(this) != w || colorWheelImage.getHeight(this) != h) {
            if (colorWheelImage != null) {
                colorWheelImage.flush();
            }
            colorWheelProducer = createWheelProducer(w, h);
            colorWheelImage = createImage(colorWheelProducer);
        }

        colorWheelProducer.setVerticalValue(model.getComponent(verticalIndex));
        if (colorWheelProducer.needsGeneration()) {
            // To keep the UI responsive, we only perform the time consuming
            // regeneration of the color track if we don't already have
            // a latency of more than a 10th of a second on the most recent event.
            long latency = System.currentTimeMillis() - EventQueue.getMostRecentEventTime();
            if (latency > 100) {
                repaint();
            } else {
                colorWheelProducer.regenerateColorWheel();
            }
        }

        g.drawImage(colorWheelImage, wheelInsets.left, wheelInsets.top, this);
    }

    protected void paintThumb(Graphics2D g) {
        Point p = getThumbLocation();

        g.setColor(Color.white);
        g.fillRect(p.x - 1, p.y - 1, 2, 2);
        g.setColor(Color.black);
        g.drawRect(p.x - 2, p.y - 2, 3, 3);
    }

    protected Point getCenter() {
        int w = getWidth() - wheelInsets.left - wheelInsets.right;
        int h = getHeight() - wheelInsets.top - wheelInsets.bottom;

        return new Point(
                wheelInsets.left + w / 2,
                wheelInsets.top + h / 2);
    }

    protected int getRadius() {
        return colorWheelProducer.getRadius();
    }

    protected Point getThumbLocation() {
        return getColorLocation(model.getComponents());
    }

    protected Point getColorLocation(Color c) {
        Point p = colorWheelProducer.getColorLocation(c);
        p.x += wheelInsets.left;
        p.y += wheelInsets.top;
        return p;
    }

    protected Point getColorLocation(float[] components) {
        Point p = colorWheelProducer.getColorLocation(components);
        p.x += wheelInsets.left;
        p.y += wheelInsets.top;
        return p;
    }

    protected float[] getColorAt(int x, int y) {
        float[] cc = colorWheelProducer.getColorAt(x - wheelInsets.left, y - wheelInsets.top);
        return cc;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
