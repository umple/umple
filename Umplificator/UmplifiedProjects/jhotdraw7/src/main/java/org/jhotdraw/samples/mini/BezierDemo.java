/*
 * @(#)BezierDemo.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.mini;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import org.jhotdraw.geom.*;

/**
 * Demonstration of the curve fitting algorithm of class {@link Bezier}. 
 *
 * @author Werner Randelshofer
 * @version $Id: BezierDemo.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class BezierDemo extends javax.swing.JPanel {

    private static class Example {

        double error;
        BezierPath digitized = new BezierPath();
        @Nullable BezierPath bezier;
        @Nullable ArrayList<ArrayList<Point2D.Double>> segments;

        public void invalidate() {
            bezier = null;
            segments = null;
        }
    }
    private ArrayList<Example> examples = new ArrayList<Example>();
    private JDialog dumpDialog;
    private JTextArea dumpArea;

    private class MouseHandler implements MouseMotionListener, MouseListener {

        private Example example;

        @Override
        public void mouseDragged(MouseEvent e) {
            double zoomFactor = getZoomFactor();
            example.digitized.lineTo(e.getX() / zoomFactor, e.getY() / zoomFactor);
            example.invalidate();
            canvas.repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            example = new Example();
            examples.add(example);
            example.error = getError();
            double zoomFactor = getZoomFactor();
            example.digitized.moveTo(e.getX() / zoomFactor, e.getY() / zoomFactor);
            canvas.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    private MouseHandler handler = new MouseHandler();

    private class Canvas extends JPanel {

        @Override
        public void paintComponent(Graphics gr) {
            long start = System.currentTimeMillis();
            super.paintComponent(gr);
            Graphics2D g = (Graphics2D) gr;

            // Update examples
            for (Example ex : examples) {
                if (ex.bezier == null) {
                    ex.bezier = Bezier.fitBezierPath(ex.digitized, ex.error);
                }
                if (ex.segments == null) {
                    ArrayList<Point2D.Double> digitizedPoints = new ArrayList<Point2D.Double>();
                    for (BezierPath.Node node : ex.digitized) {
                        digitizedPoints.add(new Point2D.Double(node.x[0], node.y[0]));
                    }
                    // Split into segments at corners
                    ex.segments = new ArrayList<ArrayList<Point2D.Double>>();
                    ex.segments = Bezier.splitAtCorners(digitizedPoints, 77 / 180d * Math.PI, getError() * 2);

                    // Clean up the data in the segments
                    for (int i = 0, n = ex.segments.size(); i < n; i++) {
                        ArrayList<Point2D.Double> seg = ex.segments.get(i);

                        seg = Bezier.removeClosePoints(seg, getError());
                        seg = Bezier.reduceNoise(seg, 0.8);

                        ex.segments.set(i, seg);
                    }
                }
            }

            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform identityTransform = g.getTransform();
            AffineTransform tx = g.getTransform();
            double zoomFactor = getZoomFactor();
            tx.scale(zoomFactor, zoomFactor);
            g.setTransform(tx);


            if (showPolylineCheck.isSelected()) {
                g.setColor(Color.black);

                for (Example ex : examples) {
                    g.draw(ex.digitized);
                }
            }


            if (showBezierCheck.isSelected()) {
                g.setColor(Color.blue);
                for (Example ex : examples) {
                    g.draw(ex.bezier);
                }
            }

            g.setTransform(identityTransform);






            if (showDigitizedCheck.isSelected()) {
                for (Example ex : examples) {
                    g.setColor(Color.white);
                    for (BezierPath.Node node : ex.digitized) {
                        g.fillRect((int) (node.x[0] * zoomFactor - 2), (int) (node.y[0] * zoomFactor - 2), 5, 5);
                    }
                }
                for (Example ex : examples) {
                    g.setColor(Color.black);
                    for (BezierPath.Node node : ex.digitized) {
                        g.fillRect((int) (node.x[0] * zoomFactor - 1), (int) (node.y[0] * zoomFactor - 1), 3, 3);
                    }
                }
            }
            if (showPreprocessedCheck.isSelected()) {
                for (Example ex : examples) {
                    g.setColor(Color.WHITE);
                    for (ArrayList<Point2D.Double> seg : ex.segments) {
                        for (int i = 0, n = seg.size(); i < n; i++) {
                            Point2D.Double node = seg.get(i);
                            g.fillRect((int) (node.x * zoomFactor - 2), (int) (node.y * zoomFactor - 2), 5, 5);
                        }
                    }
                    for (ArrayList<Point2D.Double> seg : ex.segments) {
                        for (int i = 0, n = seg.size(); i < n; i++) {
                            Point2D.Double node = seg.get(i);
                            g.setColor((i == 0 || i == n - 1) ? Color.RED : Color.CYAN);
                            g.fillRect((int) (node.x * zoomFactor - 1), (int) (node.y * zoomFactor - 1), 3, 3);
                        }
                    }
                }
            }

            if (showControlsCheck.isSelected()) {
                for (Example ex : examples) {
                    for (BezierPath.Node node : ex.bezier) {
                        if (node.mask == BezierPath.C0_MASK) {
                        } else if (node.mask == BezierPath.C1C2_MASK && node.keepColinear) {
                            g.setColor(Color.WHITE);
                            g.fillRect((int) (node.x[1] * zoomFactor - 2), (int) (node.y[1] * zoomFactor - 2), 5, 5);
                            g.fillRect((int) (node.x[2] * zoomFactor - 2), (int) (node.y[2] * zoomFactor - 2), 5, 5);
                            g.setColor(Color.CYAN);
                            g.fillRect((int) (node.x[1] * zoomFactor - 1), (int) (node.y[1] * zoomFactor - 1), 3, 3);
                            g.draw(new Line2D.Double(node.x[1] * zoomFactor, node.y[1] * zoomFactor, node.x[0] * zoomFactor, node.y[0] * zoomFactor));
                            g.fillRect((int) (node.x[2] * zoomFactor - 1), (int) (node.y[2] * zoomFactor - 1), 3, 3);
                            g.draw(new Line2D.Double(node.x[2] * zoomFactor, node.y[2] * zoomFactor, node.x[0] * zoomFactor, node.y[0] * zoomFactor));
                        } else {
                            if ((node.mask & BezierPath.C1_MASK) == BezierPath.C1_MASK) {
                                g.setColor(Color.WHITE);
                                g.fillRect((int) (node.x[1] * zoomFactor - 2), (int) (node.y[1] * zoomFactor - 2), 5, 5);
                                g.setColor(Color.MAGENTA);
                                g.fillRect((int) (node.x[1] * zoomFactor - 1), (int) (node.y[1] * zoomFactor - 1), 3, 3);
                                g.draw(new Line2D.Double(node.x[1] * zoomFactor, node.y[1] * zoomFactor, node.x[0] * zoomFactor, node.y[0] * zoomFactor));
                            }
                            if ((node.mask & BezierPath.C2_MASK) == BezierPath.C2_MASK) {
                                g.setColor(Color.WHITE);
                                g.fillRect((int) (node.x[2] * zoomFactor - 2), (int) (node.y[2] * zoomFactor - 2), 5, 5);
                                g.setColor(Color.MAGENTA);
                                g.fillRect((int) (node.x[2] * zoomFactor - 1), (int) (node.y[2] * zoomFactor - 1), 3, 3);
                                g.draw(new Line2D.Double(node.x[2] * zoomFactor, node.y[2] * zoomFactor, node.x[0] * zoomFactor, node.y[0] * zoomFactor));
                            }
                        }
                    }
                    for (BezierPath.Node node : ex.bezier) {
                        g.setColor(Color.WHITE);
                        g.fillRect((int) (node.x[0] * zoomFactor - 2), (int) (node.y[0] * zoomFactor - 2), 5, 5);
                    }
                    for (BezierPath.Node node : ex.bezier) {
                        g.setColor((node.keepColinear && node.mask != BezierPath.C0_MASK) ? Color.BLUE : Color.RED);
                        g.fillRect((int) (node.x[0] * zoomFactor - 1), (int) (node.y[0] * zoomFactor - 1), 3, 3);
                    }
                }
            }
            long end = System.currentTimeMillis();
            g.setColor(Color.BLACK);
            g.drawString((end - start) + " ms", 5, g.getFontMetrics().getHeight());
        }
    }
    private Canvas canvas;

    /** Creates new form BezierDemo */
    public BezierDemo() {
        initComponents();
        canvas = new Canvas();
        canvas.setOpaque(true);
        canvas.setBackground(Color.WHITE);
        canvas.addMouseListener(handler);
        canvas.addMouseMotionListener(handler);
        add(canvas, BorderLayout.CENTER);

        Point2D.Double[] d = { //  Digitized points 
        };
        BezierPath digi = new BezierPath();
        digi.addPolyline(Arrays.asList(d));
        Example ex = new Example();
        examples.add(ex);
        ex.digitized = digi;
        ex.error = 2d;
    }

    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame f = new JFrame("Bezier Demo");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new BezierDemo());
                f.setPreferredSize(new Dimension(400, 300));
                f.pack();
                f.setVisible(true);
            }
        });
    }

    private double getSquaredError() {
        double error = getError();

        return error * error;
    }

    private double getError() {
        double error = 2d / getZoomFactor();
        return error;
    }

    private double getZoomFactor() {
        return zoomSlider.getValue() / 100d;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        toleranceLabel = new javax.swing.JLabel();
        zoomSlider = new javax.swing.JSlider();
        showDigitizedCheck = new javax.swing.JCheckBox();
        showPreprocessedCheck = new javax.swing.JCheckBox();
        showPolylineCheck = new javax.swing.JCheckBox();
        showBezierCheck = new javax.swing.JCheckBox();
        showControlsCheck = new javax.swing.JCheckBox();
        eraseButton = new javax.swing.JButton();
        dumpButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 20, 20, 20));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        toleranceLabel.setText("Zoom:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(toleranceLabel, gridBagConstraints);

        zoomSlider.setMaximum(800);
        zoomSlider.setMinimum(100);
        zoomSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zoomChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        jPanel1.add(zoomSlider, gridBagConstraints);

        showDigitizedCheck.setText("Show Source Points");
        showDigitizedCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(showDigitizedCheck, gridBagConstraints);

        showPreprocessedCheck.setText("Show Preprocessed Points");
        showPreprocessedCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(showPreprocessedCheck, gridBagConstraints);

        showPolylineCheck.setSelected(true);
        showPolylineCheck.setText("Show Polyline");
        showPolylineCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel1.add(showPolylineCheck, gridBagConstraints);

        showBezierCheck.setSelected(true);
        showBezierCheck.setText("Show Bezier Path");
        showBezierCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel1.add(showBezierCheck, gridBagConstraints);

        showControlsCheck.setText("Show Bezier Controls");
        showControlsCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(showControlsCheck, gridBagConstraints);

        eraseButton.setText("Erase");
        eraseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        jPanel1.add(eraseButton, gridBagConstraints);

        dumpButton.setText("Dump");
        dumpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dumpButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        jPanel1.add(dumpButton, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

private void eraseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eraseButtonActionPerformed
    examples.clear();
    canvas.repaint();
}//GEN-LAST:event_eraseButtonActionPerformed

private void zoomChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zoomChanged
    canvas.repaint();

}//GEN-LAST:event_zoomChanged

private void dumpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dumpButtonActionPerformed
    if (dumpDialog == null) {
        dumpDialog = new JDialog();
        dumpDialog.setTitle("Dump");
        dumpArea = new JTextArea();
        dumpDialog.add(new JScrollPane(dumpArea));
        dumpDialog.setSize(400, 400);
    }
    StringBuilder buf = new StringBuilder();
    buf.append("        Point2D.Double[] d = { //  Digitized points \n");
    for (int i = 0; i < examples.size(); i++) {
        for (BezierPath.Node node : examples.get(i).digitized) {
            buf.append("            new Point2D.Double(");
            buf.append(node.x[0]);
            buf.append(",");
            buf.append(node.y[0]);
            buf.append("),\n");
        }
    }
    buf.append("        };\n");
    dumpArea.setText(buf.toString());
    dumpDialog.setVisible(true);
}//GEN-LAST:event_dumpButtonActionPerformed

private void checkboxPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxPerformed
    canvas.repaint();
}//GEN-LAST:event_checkboxPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dumpButton;
    private javax.swing.JButton eraseButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox showBezierCheck;
    private javax.swing.JCheckBox showControlsCheck;
    private javax.swing.JCheckBox showDigitizedCheck;
    private javax.swing.JCheckBox showPolylineCheck;
    private javax.swing.JCheckBox showPreprocessedCheck;
    private javax.swing.JLabel toleranceLabel;
    private javax.swing.JSlider zoomSlider;
    // End of variables declaration//GEN-END:variables
}
