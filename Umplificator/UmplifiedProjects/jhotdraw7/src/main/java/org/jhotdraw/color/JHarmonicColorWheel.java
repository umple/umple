/**
 * @(#)JHarmonicColorWheel.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.awt.geom.*;
import java.beans.*;
import javax.swing.event.*;

/**
 * JHarmonicColorWheel.
 * 
 * FIXME - This is an experimental class. Do not use it.
 *
 * @author Werner Randelshofer
 * @version $Id: JHarmonicColorWheel.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class JHarmonicColorWheel extends JColorWheel {

    public final static String SELECTED_INDEX_PROPERTY = "selectedIndex";
    private HarmonicColorModel harmonicModel;
    private int selectedIndex = -1;
    private float handleRadius = 4f;
    private float baseRadius = 7f;

    private class MouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            update(e);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int closestIndex = -1;
            if (harmonicModel != null && harmonicModel.size() > 0) {
                int closestError = Integer.MAX_VALUE;
                for (int i = 0, n = harmonicModel.size(); i < n; i++) {
                    Color c = harmonicModel.get(i);
                    if (c != null) {
                        Point p = getColorLocation(harmonicModel.get(i));
                        int error = (p.x - x) * (p.x - x) +
                                (p.y - y) * (p.y - y);
                        if (error < closestError) {
                            closestIndex = i;
                            closestError = error;
                        }
                    }
                }
                if (closestIndex != -1) {
                    if (closestError > 20) {
                        closestIndex = -1;
                    }
                }
            }
            setSelectedIndex(closestIndex);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            //update(e);
        }

        private void update(MouseEvent e) {
            if (selectedIndex != -1) {
                float[] hsb = getColorAt(e.getX(), e.getY());
                hsb[1] = harmonicModel.get(selectedIndex).getColorComponents(null)[1];
                //if (hsb != null) {
                harmonicModel.set(selectedIndex, new Color(harmonicModel.getColorSpace(), hsb, 1f));
                //}
                repaint();
            }
        }
    }
    private MouseHandler mouseHandler;

    private class ModelHandler implements PropertyChangeListener, ListDataListener {

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            String name = evt.getPropertyName();
            if (name == HarmonicColorModel.COLOR_SPACE_PROPERTY) {
                model.setColorSpace(harmonicModel.getColorSpace());
                model.setComponent(1, 1f);
                colorWheelProducer = createWheelProducer(getWidth(), getHeight());
                colorWheelImage = null;
            }
            repaint();
        }

        @Override
        public void intervalAdded(ListDataEvent e) {
            repaint();
        }

        @Override
        public void intervalRemoved(ListDataEvent e) {
            repaint();
        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            repaint();
        }
    }
    private ModelHandler modelHandler;

    /** Creates new form. */
    public JHarmonicColorWheel() {
        super(HSLPhysiologicColorSpace.getInstance());
        initComponents();

        setRadialComponentIndex(2);
        setVerticalComponentIndex(1);
        getModel().setComponent(1, 1f);
        setWheelInsets(new Insets(5, 5, 5, 5));

        modelHandler = new ModelHandler();

        DefaultHarmonicColorModel p = new DefaultHarmonicColorModel();
        setHarmonicColorModel(p);
        setToolTipText("");

    }

    public void setColorSpace(ColorSpace newValue) {
        harmonicModel.setColorSpace(newValue);
        getModel().setColorSpace(newValue);
        getModel().setComponent(1, 1f);
    }

    public HarmonicColorModel getHarmonicColorModel() {
        return harmonicModel;
    }

    @Override
    public String getToolTipText(MouseEvent evt) {
        float[] hsb = getColorAt(evt.getX(), evt.getY());
        if (hsb == null) {
            return null;
        }

        StringBuilder buf = new StringBuilder();

        buf.append(Math.round(hsb[0] * 360));
        buf.append(",");
        buf.append(Math.round(hsb[1] * 100f));
        buf.append(",");
        buf.append(Math.round(hsb[2] * 100f));

        if (buf.length() > 0) {
            buf.insert(0, "<html>");

            return buf.toString();
        } else {
            return null;
        }
    }

    @Override
    protected void installMouseListeners() {
        mouseHandler = new MouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    public void setHarmonicColorModel(HarmonicColorModel newValue) {
        HarmonicColorModel oldValue = harmonicModel;
        if (oldValue != null) {
            oldValue.removePropertyChangeListener(modelHandler);
            oldValue.removeListDataListener(modelHandler);
        }
        harmonicModel = newValue;
        if (newValue != null) {
            newValue.addPropertyChangeListener(modelHandler);
            newValue.addListDataListener(modelHandler);
            colorWheelProducer = createWheelProducer(getWidth(), getHeight());
        }
    }

    @Override
    public void paintComponent(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        super.paintComponent(g);
    }

    @Override
    protected void paintThumb(Graphics2D g) {
        paintTicks(g);

        if (harmonicModel != null) {
            Point center = getCenter();
            Ellipse2D.Float oval = new Ellipse2D.Float(0, 0, 0, 0);

            float[] comp = null;
            for (int i = harmonicModel.size() - 1; i >= 0; i--) {
                if (harmonicModel.get(i) != null) {
                    Point p = getColorLocation(harmonicModel.get(i));
                    g.setColor(Color.black);
                    g.drawLine(center.x, center.y, p.x, p.y);
                }
            }
            for (int i = harmonicModel.size() - 1; i >= 0; i--) {
                if (harmonicModel.get(i) != null) {
                    Point p = getColorLocation(harmonicModel.get(i));
                    Color mixerColor = harmonicModel.get(i);
                    comp = ColorUtil.fromColor(harmonicModel.getColorSpace(),mixerColor);
                    if (i == selectedIndex) {
                        g.setColor(Color.white);
                        oval.x = p.x - baseRadius;
                        oval.y = p.y - baseRadius;
                        oval.width = baseRadius * 2f;
                        oval.height = baseRadius * 2f;
                        g.fill(oval);
                    }
                    g.setColor(mixerColor);
                    oval.x = p.x - handleRadius;
                    oval.y = p.y - handleRadius;
                    oval.width = handleRadius * 2f;
                    oval.height = handleRadius * 2f;
                    g.fill(oval);
                    g.setColor(Color.black);
                    g.draw(oval);
                    if (i == harmonicModel.getBase()) {
                        oval.x = p.x - baseRadius;
                        oval.y = p.y - baseRadius;
                        oval.width = baseRadius * 2f;
                        oval.height = baseRadius * 2f;
                        g.draw(oval);
                    }
                // g.drawString(i+"", p.x, p.y);
                }
            }
        }
    }

    protected void paintTicks(Graphics2D g) {
        if (true) return;
        if (harmonicModel != null) {
            Point center = getCenter();
            float radius = getRadius();
            Ellipse2D.Float oval = new Ellipse2D.Float(0, 0, 0, 0);

            int baseIndex = harmonicModel.getBase();
            Color bc = harmonicModel.get(baseIndex);
            g.setColor(Color.DARK_GRAY);
            for (int i = 0; i < 12; i++) {
                float angle = bc.getColorComponents(null)[0] + i / 12f;

                float radial1 = radius;
                /*g.draw(new Line2D.Double(
                        center.x + radius * Math.cos(angle * Math.PI * 2d),
                        center.y - radius * Math.sin(angle * Math.PI * 2d),
                        center.x + (radius + 2) * Math.cos(angle * Math.PI * 2d),
                        center.y - (radius + 2) * Math.sin(angle * Math.PI * 2d)));
               */
                g.fill(new Ellipse2D.Double(
                        center.x + (radius+2) * Math.cos(angle * Math.PI * 2d)-2,
                        center.y - (radius+2) * Math.sin(angle * Math.PI * 2d)-2,
                        4,
                        4));

            }

            for (int i = 0, n = harmonicModel.size(); i < n; i++) {
                if (i != baseIndex) {
                    Color dc = harmonicModel.get(i);
                    if (dc != null) {
                        float angle = dc.getColorComponents(null)[0];

                        float diff = Math.abs(angle - bc.getColorComponents(null)[0]) * 12;
                        if (Math.abs(diff - Math.round(diff)) < 0.02f) {
                        g.draw(new Line2D.Double(
                                center.x + (radius + 6) * Math.cos(angle * Math.PI * 2d),
                                center.y - (radius + 6) * Math.sin(angle * Math.PI * 2d),
                                center.x + (radius - 2) * Math.cos(angle * Math.PI * 2d),
                                center.y - (radius - 2) * Math.sin(angle * Math.PI * 2d)));
                        } else {
                        
                        g.draw(new Line2D.Double(
                                center.x + (radius) * Math.cos(angle * Math.PI * 2d),
                                center.y - (radius) * Math.sin(angle * Math.PI * 2d),
                                center.x + (radius - 1) * Math.cos(angle * Math.PI * 2d),
                                center.y - (radius - 1) * Math.sin(angle * Math.PI * 2d)));
                        }
                    }
                }
            }
        }
    }

    public void setSelectedIndex(int newValue) {
        int oldValue = selectedIndex;
        selectedIndex = newValue;
        firePropertyChange(SELECTED_INDEX_PROPERTY, oldValue, newValue);
        repaint();
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    @Override
    protected Point getColorLocation(Color c) {
        Point p = colorWheelProducer.getColorLocation(c);
        p.x += wheelInsets.left;
        p.y += wheelInsets.top;
        return p;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.FlowLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
