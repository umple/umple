/*
 * @(#)ColorSliderUI.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import org.jhotdraw.util.Images;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import org.jhotdraw.gui.plaf.palette.*;

/**
 * A UI delegate for color sliders. The track of the slider visualizes how
 * changing the value of the slider affects the color.
 *
 *
 * @author  Werner Randelshofer
 * @version $Id: ColorSliderUI.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ColorSliderUI extends BasicSliderUI {

    private final static Color foreground = new Color(0x949494);
    private final static Color trackBackground = new Color(0xffffff);
    private ColorTrackImageProducer colorTrackImageProducer;
    private Image colorTrackImage;
    private static final Dimension PREFERRED_HORIZONTAL_SIZE = new Dimension(160, 4);
    private static final Dimension PREFERRED_VERTICAL_SIZE = new Dimension(4, 160);
    private static final Dimension MINIMUM_HORIZONTAL_SIZE = new Dimension(16, 4);
    private static final Dimension MINIMUM_VERTICAL_SIZE = new Dimension(4, 16);

    /** Creates a new instance. */
    public ColorSliderUI(JSlider b) {
        super(b);
    }

    public static ComponentUI createUI(JComponent b) {
        if (null == UIManager.getIcon("Slider.northThumb.small")) {
            UIManager.put("Slider.northThumb.small",
                    new PaletteSliderThumbIcon(Images.createImage(
                    ColorSliderUI.class, "/org/jhotdraw/color/images/Slider.northThumbs.small.png"), 6, true));
        }
        if (null == UIManager.getIcon("Slider.westThumb.small")) {
            UIManager.put("Slider.westThumb.small",
                    new PaletteSliderThumbIcon(Images.createImage(
                    ColorSliderUI.class, "/org/jhotdraw/color/images/Slider.westThumbs.small.png"), 6, true));
        }
        return new ColorSliderUI((JSlider) b);
    }

    @Override
    protected void installDefaults(JSlider slider) {
        super.installDefaults(slider);
        focusInsets = new Insets(0, 0, 0, 0);
        slider.setOpaque(false);
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            slider.setBorder(new EmptyBorder(0, 1, -1, 1));
        } else {
            slider.setBorder(new EmptyBorder(0, 0, 0, 1));
        }
        //slider.setRequestFocusEnabled(QuaquaManager.getBoolean("Slider.requestFocusEnabled"));
        slider.setRequestFocusEnabled(true);
    }

    @Override
    protected Dimension getThumbSize() {
        Icon thumb = getThumbIcon();
        return new Dimension(thumb.getIconWidth(), thumb.getIconHeight());
    }
    @Override
    public Dimension getPreferredSize(JComponent c)    {
        recalculateIfInsetsChanged();
        Dimension d;
        if ( slider.getOrientation() == JSlider.VERTICAL ) {
            d = new Dimension(getPreferredVerticalSize());
	    d.width += insetCache.left + insetCache.right;
	    d.width += focusInsets.left + focusInsets.right;
	    d.width += trackRect.width + tickRect.width + labelRect.width;
        }
        else {
            d = new Dimension(getPreferredHorizontalSize());
	    d.height += insetCache.top + insetCache.bottom;
	    d.height += focusInsets.top + focusInsets.bottom;
	    d.height += trackRect.height + tickRect.height + labelRect.height;
        }

        return d;
    }

    @Override
    public Dimension getPreferredHorizontalSize() {
        return PREFERRED_HORIZONTAL_SIZE;
    }

    @Override
    public Dimension getPreferredVerticalSize() {
        return PREFERRED_VERTICAL_SIZE;
    }

    @Override
    public Dimension getMinimumHorizontalSize() {
        return MINIMUM_HORIZONTAL_SIZE;
    }

    @Override
    public Dimension getMinimumVerticalSize() {
        return MINIMUM_VERTICAL_SIZE;
    }

    @Override
    protected void calculateThumbLocation() {
        super.calculateThumbLocation();
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            thumbRect.y -= 3;
        } else {
            thumbRect.x -= 3;
        }
    }
    /*
    public void paint( Graphics g, JComponent c )   {
    g.setColor(Color.green);
    g.fillRect(0,0,c.getWidth(), c.getHeight());
    super.paint(g,c);
    }
     */

    protected Icon getThumbIcon() {
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            return UIManager.getIcon("Slider.northThumb.small");
        } else {
            return UIManager.getIcon("Slider.westThumb.small");
        }
    }

    @Override
    public void paintThumb(Graphics g) {
        Rectangle knobBounds = thumbRect;
        int w = knobBounds.width;
        int h = knobBounds.height;

        getThumbIcon().paintIcon(slider, g, knobBounds.x, knobBounds.y);
        /*
        g.setColor(Color.green);
        ((Graphics2D) g).draw(knobBounds);
         */
    }

    @Override
    public void paintTrack(Graphics g) {
        int cx, cy, cw, ch;
        int pad;

        Rectangle trackBounds = trackRect;
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            pad = trackBuffer;// - thumbRect.width / 2 + 2;
            cx = trackBounds.x - pad + 1;
            cy = trackBounds.y;
            //cy = (trackBounds.height / 2) - 4;
            cw = trackBounds.width + pad * 2 - 2;
            ch = trackBounds.height - 1;
        } else {
            pad = trackBuffer;
            //cx = (trackBounds.width / 2) - 4;
            //cx = (trackBounds.width / 2);
            //cx = thumbRect.x + 2;
            cx = trackBounds.x;
            //cy = pad;
            cy = contentRect.y + 2;
            cw = trackBounds.width - 1;
            //ch = trackBounds.height;
            ch = trackBounds.height + pad * 2 - 5;
        }
        g.setColor(trackBackground);
        g.fillRect(cx, cy, cw, ch);
        g.setColor(foreground);
        g.drawRect(cx, cy, cw - 1, ch - 1);
        paintColorTrack(g, cx + 2, cy + 2, cw - 4, ch - 4, trackBuffer);
    }

    @Override
    public void paintTicks(Graphics g) {
        Rectangle tickBounds = tickRect;
        int i;
        int maj, min, max;
        int w = tickBounds.width;
        int h = tickBounds.height;
        int centerEffect, tickHeight;
        /*
        g.setColor(slider.getBackground());
        g.fillRect(tickBounds.x, tickBounds.y, tickBounds.width, tickBounds.height);
         */
        g.setColor(foreground);

        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            g.translate(0, tickBounds.y);

            int value = slider.getMinimum();
            int xPos = 0;

            if (slider.getMinorTickSpacing() > 0) {
                while (value <= slider.getMaximum()) {
                    xPos = xPositionForValue(value);
                    paintMinorTickForHorizSlider(g, tickBounds, xPos);
                    value += slider.getMinorTickSpacing();
                }
            }

            if (slider.getMajorTickSpacing() > 0) {
                value = slider.getMinimum();

                while (value <= slider.getMaximum()) {
                    xPos = xPositionForValue(value);
                    paintMajorTickForHorizSlider(g, tickBounds, xPos);
                    value += slider.getMajorTickSpacing();
                }
            }

            g.translate(0, -tickBounds.y);
        } else {
            g.translate(tickBounds.x, 0);

            int value = slider.getMinimum();
            int yPos = 0;

            if (slider.getMinorTickSpacing() > 0) {
                int offset = 0;
                if (!slider.getComponentOrientation().isLeftToRight()) {
                    offset = tickBounds.width - tickBounds.width / 2;
                    g.translate(offset, 0);
                }

                while (value <= slider.getMaximum()) {
                    yPos = yPositionForValue(value);
                    paintMinorTickForVertSlider(g, tickBounds, yPos);
                    value += slider.getMinorTickSpacing();
                }

                if (!slider.getComponentOrientation().isLeftToRight()) {
                    g.translate(-offset, 0);
                }
            }

            if (slider.getMajorTickSpacing() > 0) {
                value = slider.getMinimum();
                if (!slider.getComponentOrientation().isLeftToRight()) {
                    g.translate(2, 0);
                }

                while (value <= slider.getMaximum()) {
                    yPos = yPositionForValue(value);
                    paintMajorTickForVertSlider(g, tickBounds, yPos);
                    value += slider.getMajorTickSpacing();
                }

                if (!slider.getComponentOrientation().isLeftToRight()) {
                    g.translate(-2, 0);
                }
            }
            g.translate(-tickBounds.x, 0);
        }
        /*
        g.setColor(Color.red);
        ((Graphics2D) g).draw(tickBounds);
         */
    }

    @Override
    protected void paintMajorTickForHorizSlider(Graphics g, Rectangle tickBounds, int x) {
        g.drawLine(x, 0, x, tickBounds.height - 1);
    }

    @Override
    protected void paintMinorTickForHorizSlider(Graphics g, Rectangle tickBounds, int x) {
        //g.drawLine( x, 0, x, tickBounds.height / 2 - 1 );
        g.drawLine(x, 0, x, tickBounds.height - 1);
    }

    @Override
    protected void paintMinorTickForVertSlider(Graphics g, Rectangle tickBounds, int y) {
        g.drawLine(tickBounds.width / 2, y, tickBounds.width / 2 - 1, y);
    }

    @Override
    protected void paintMajorTickForVertSlider(Graphics g, Rectangle tickBounds, int y) {
        g.drawLine(0, y, tickBounds.width - 1, y);
    }

    @Override
    public void paintFocus(Graphics g) {
    }

    public void paintColorTrack(Graphics g, int x, int y, int width, int height, int buffer) {
        //g.setColor(Color.black);
        //g.fillRect(x, y, width, height);
        if (colorTrackImageProducer == null
                || colorTrackImageProducer.getWidth() != width
                || colorTrackImageProducer.getHeight() != height) {
            if (colorTrackImage != null) {
                colorTrackImage.flush();
            }
            colorTrackImageProducer = new ColorTrackImageProducer(width, height, buffer + 2, slider.getOrientation() == JSlider.HORIZONTAL);
            if (slider.getClientProperty("colorSliderModel") != null) {
                colorTrackImageProducer.setColorSliderModel((ColorSliderModel) slider.getClientProperty("colorSliderModel"));
            }
            if (slider.getClientProperty("colorComponentIndex") != null) {
                colorTrackImageProducer.setColorComponentIndex(((Integer) slider.getClientProperty("colorComponentIndex")).intValue());
            }
            colorTrackImageProducer.generateColorTrack();
            colorTrackImage = slider.createImage(colorTrackImageProducer);
        } else {
            if (colorTrackImageProducer.needsGeneration()) {
                // To keep the UI responsive, we only perform the time consuming
                // regeneration of the color track if we don't already have
                // a latency of more than a 10th of a second on the most recent event.
                long latency = System.currentTimeMillis() - EventQueue.getMostRecentEventTime();
                if (latency > 100) {
                    slider.repaint();
                } else {
                    colorTrackImageProducer.regenerateColorTrack();
                }
            }
        }

        g.drawImage(colorTrackImage, x, y, slider);
    }

    @Override
    protected void calculateTrackRect() {
        int centerSpacing = 0; // used to center sliders added using BorderLayout.CENTER (bug 4275631)


        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            centerSpacing = thumbRect.height;


            if (slider.getPaintTicks()) {
                centerSpacing += getTickLength();
            }


            if (slider.getPaintLabels()) {
                centerSpacing += getHeightOfTallestLabel();
            }
            trackRect.x = contentRect.x + trackBuffer + 1;
            //trackRect.y = contentRect.y + (contentRect.height - centerSpacing - 1)/2;
            trackRect.height = 14;
            trackRect.y = contentRect.y + contentRect.height - trackRect.height;
            trackRect.width = contentRect.width - (trackBuffer * 2) - 1;


        } else {
            /*
            centerSpacing = thumbRect.width;
            if (! QuaquaUtilities.isLeftToRight(slider)) {
            if ( slider.getPaintTicks() ) centerSpacing += getTickLength();
            if ( slider.getPaintLabels() ) centerSpacing += getWidthOfWidestLabel();
            } else {
            if ( slider.getPaintTicks() ) centerSpacing -= getTickLength();
            if ( slider.getPaintLabels() ) centerSpacing -= getWidthOfWidestLabel();
            }
            trackRect.x = contentRect.x + (contentRect.width - centerSpacing - 1)/2 + 2;
             */
            trackRect.width = 14;
            trackRect.x = contentRect.x + (contentRect.width - trackRect.width)/2;
            trackRect.y = contentRect.y + trackBuffer;
            trackRect.height = contentRect.height - (trackBuffer * 2) + 1;


        }

    }

    @Override
    protected void calculateTickRect() {
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            tickRect.x = trackRect.x;
            //tickRect.y = trackRect.y + trackRect.height;
            tickRect.y = trackRect.y - getTickLength();
            tickRect.width = trackRect.width;
            tickRect.height = getTickLength();



            if (!slider.getPaintTicks()) {
                --tickRect.y;
                tickRect.height = 0;


            }
        } else {
            /*
            if(! QuaquaUtilities.isLeftToRight(slider)) {
            tickRect.x = trackRect.x + trackRect.width;
            tickRect.width = getTickLength();
            }
            else {
            tickRect.width = getTickLength();
            tickRect.x = trackRect.x - tickRect.width;
            }*/
            tickRect.width = getTickLength();
            tickRect.x = contentRect.x;//trackRect.x - tickRect.width - 1;
            tickRect.y = trackRect.y;
            tickRect.height = trackRect.height;



            if (!slider.getPaintTicks()) {
                --tickRect.x;
                tickRect.width = 0;


            }
        }
    }

    /**
     * Gets the height of the tick area for horizontal sliders and the width of the
     * tick area for vertical sliders.  BasicSliderUI uses the returned value to
     * determine the tick area rectangle.  If you want to give your ticks some room,
     * make this larger than you need and paint your ticks away from the sides in paintTicks().
     */
    @Override
    protected int getTickLength() {
        return 4;


    }

    @Override
    protected PropertyChangeListener createPropertyChangeListener(JSlider slider) {
        return new CSUIPropertyChangeHandler();






    }

    public class CSUIPropertyChangeHandler extends BasicSliderUI.PropertyChangeHandler {

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            String propertyName = e.getPropertyName();

            if (propertyName.equals("Frame.active")) {
                //calculateGeometry();
                slider.repaint();
            } else if (propertyName.equals("colorSliderModel")) {
                if (colorTrackImageProducer != null) {
                    colorTrackImageProducer.setColorSliderModel(((ColorSliderModel) e.getNewValue()));
                    if (colorTrackImageProducer.needsGeneration()) {
                        slider.repaint();
                    }
                }
            } else if (propertyName.equals("snapToTicks")) {
                if (colorTrackImageProducer != null) {
                    colorTrackImageProducer.markAsDirty();
                    slider.repaint();
                }
            } else if (propertyName.equals("colorComponentIndex")) {
                if (colorTrackImageProducer != null && e.getNewValue() != null) {
                    colorTrackImageProducer.setColorComponentIndex(((Integer) e.getNewValue()).intValue());
                    if (colorTrackImageProducer.needsGeneration()) {
                        slider.repaint();
                    }
                }
            } else if (propertyName.equals("colorComponentChange")) {
                Integer value = (Integer) e.getNewValue();
                if (value != null && colorTrackImageProducer != null) {
                    colorTrackImageProducer.componentChanged(value.intValue());
                    if (colorTrackImageProducer.needsGeneration()) {
                        slider.repaint();
                    }
                }
            } else if (propertyName.equals("colorComponentValue")) {
                Integer value = (Integer) slider.getClientProperty("colorComponentChange");
                if (value != null && colorTrackImageProducer != null) {
                    colorTrackImageProducer.componentChanged(value.intValue());
                    if (colorTrackImageProducer.needsGeneration()) {
                        slider.repaint();
                    }
                }
            } else if (propertyName.equals("orientation")) {
                if (slider.getOrientation() == JSlider.HORIZONTAL) {
                    slider.setBorder(new EmptyBorder(0, 1, -1, 1));
                } else {
                    slider.setBorder(new EmptyBorder(0, 0, 0, 1));
                }
            }

            super.propertyChange(e);
        }
    }

    @Override
    protected TrackListener createTrackListener(JSlider slider) {
        return new TrackListener();





    }

    /**
     * Track mouse movements.
     *
     * This inner class is marked &quot;public&quot; due to a compiler bug.
     * This class should be treated as a &quot;protected&quot; inner class.
     * Instantiate it only within subclasses of <Foo>.
     */
    {
    }

    public class TrackListener extends BasicSliderUI.TrackListener {

        /**
         * If the mouse is pressed above the "thumb" component
         * then reduce the scrollbars value by one page ("page up"),
         * otherwise increase it by one page.  If there is no
         * thumb then page up if the mouse is in the upper half
         * of the track.
         */
        @Override
        public void mousePressed(MouseEvent e) {
            if (!slider.isEnabled()) {
                return;
            }

            currentMouseX = e.getX();
            currentMouseY = e.getY();

            if (slider.isRequestFocusEnabled()) {
                slider.requestFocus();
            }

            // Clicked inside the Thumb area?
            if (thumbRect.contains(currentMouseX, currentMouseY)) {
                super.mousePressed(e);
            } else {
                switch (slider.getOrientation()) {
                    case JSlider.VERTICAL:
                        slider.setValue(valueForYPosition(currentMouseY));
                        break;
                    case JSlider.HORIZONTAL:
                        slider.setValue(valueForXPosition(currentMouseX));
                        break;
                }

                // FIXME:
                // We should set isDragging to false here. Unfortunately,
                // we can not access this variable in class BasicSliderUI.
            }
        }
    }
}
