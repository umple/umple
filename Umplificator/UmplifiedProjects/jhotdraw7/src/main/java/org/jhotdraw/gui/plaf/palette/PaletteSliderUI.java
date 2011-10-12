/**
 * @(#)PaletteSliderUI.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.gui.plaf.palette;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

/**
 * PaletteSliderUI.
 *
 * @author Werner Randelshofer
 * @version $Id: PaletteSliderUI.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteSliderUI extends BasicSliderUI {
    private final static float[] enabledStops = new float[]{0f, 0.35f, 0.351f, 1f};
    private final static Color[] enabledStopColors = new Color[]{new Color(0xf3f3f3), new Color(0xcccccc), new Color(0xbababa), new Color(0xf3f3f3)};
    private final static float[] disabledStops = new float[]{0f, 0.35f, 0.351f, 1f};
    private final static Color[] disabledStopColors = new Color[]{new Color(0xf3f3f3), new Color(0xeeeeee), new Color(0xcacaca), new Color(0xf3f3f3)};
    private final static float[] selectedStops = new float[]{0f, 0.2f, 1f};
    private final static Color[] selectedStopColors = new Color[]{new Color(0x999999), new Color(0xaaaaaa), new Color(0x666666)};
    
    public static ComponentUI createUI(JComponent b)    {
        return new PaletteSliderUI((JSlider)b);
    }
    public PaletteSliderUI(JSlider slider)   {
        super(slider);
    }
    @Override
    protected void installDefaults( JSlider slider ) {
        super.installDefaults(slider);
        
        PaletteLookAndFeel.installBorder(slider, "Slider.border");
        PaletteLookAndFeel.installColors(slider, "Slider.background", "Slider.foreground");
    }

    @Override
    public Dimension getPreferredHorizontalSize() {
        Dimension horizDim = (Dimension)PaletteLookAndFeel.getInstance().get("Slider.horizontalSize");
        if (horizDim == null) {
            horizDim = new Dimension(100, 21);
        }
        return horizDim;
    }

    @Override
    public Dimension getPreferredVerticalSize() {
        Dimension vertDim = (Dimension)PaletteLookAndFeel.getInstance().get("Slider.verticalSize");
        if (vertDim == null) {
            vertDim = new Dimension(21, 100);
        }
        return vertDim;
    }
    
    @Override
     public void paint( Graphics gr, JComponent c )   {
         Graphics2D g = (Graphics2D) gr;
         
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
         super.paint(g, c);
     }
   
    @Override
    public void paintFocus(Graphics g)  {        
        // empty
    }

    @Override
    public void paintTrack(Graphics g)  {        
        int cx, cy, cw, ch;
        int pad;

        Rectangle trackBounds = trackRect;

        if ( slider.getOrientation() == JSlider.HORIZONTAL ) {
            pad = trackBuffer;
            //cx = pad;
            cy = (trackBounds.height / 2) - 2;
            cw = trackBounds.width;

            g.translate(trackBounds.x, trackBounds.y + cy);

            g.setColor(getShadowColor());
            g.drawLine(0, 0, cw - 1, 0);
            g.drawLine(0, 1, 0, 2);
            g.setColor(getHighlightColor());
            g.drawLine(0, 3, cw, 3);
            g.drawLine(cw, 0, cw, 3);
            g.setColor(Color.black);
            g.drawLine(1, 1, cw-2, 1);

            g.translate(-trackBounds.x, -(trackBounds.y + cy));
        }
        else {
            pad = trackBuffer;
            cx = (trackBounds.width / 2) - 2;
            //cy = pad;
            ch = trackBounds.height;
            g.setColor(new Color(slider.isEnabled() ? 0x888888 : 0xaaaaaa));
            g.drawRoundRect( trackBounds.x + cx, trackBounds.y, 5, ch, 5, 5);
            
            
        }
    }
    @Override
    public void paintThumb(Graphics gr)  {        
        Graphics2D g = (Graphics2D) gr;
        Rectangle knobBounds = thumbRect;
        int w = knobBounds.width;
        int h = knobBounds.height;      

        g.translate(knobBounds.x, knobBounds.y);

                        float[] stops;
                        Color[] stopColors;
        if ( slider.isEnabled() ) {
            g.setColor(slider.getBackground());
            if (slider.getModel().getValueIsAdjusting()) {
                         stops = selectedStops;
                         stopColors = selectedStopColors;
                         } else {
                         stops = enabledStops;
                         stopColors = enabledStopColors;
                         }
        }
        else {
            g.setColor(slider.getBackground().darker());
                         stops = enabledStops;
                         stopColors = enabledStopColors;
        }

	Boolean paintThumbArrowShape =
	    (Boolean)slider.getClientProperty("Slider.paintThumbArrowShape");

	if ((!slider.getPaintTicks() && paintThumbArrowShape == null) ||
	    paintThumbArrowShape == Boolean.FALSE) {

	    // "plain" version

                        LinearGradientPaint lgp = new LinearGradientPaint(
                                new Point2D.Float(2, 2), new Point2D.Float(2, 2+h-4),
                                stops, stopColors,
                                MultipleGradientPaint.CycleMethod.REPEAT);
                        g.setPaint(lgp);
            g.fillOval(2,2,w - 4,h - 4);
            g.setColor(new Color(0x444444));
            g.drawOval(1,1,w - 3,h - 3);
        }
        else if ( slider.getOrientation() == JSlider.HORIZONTAL ) {
            int cw = w / 2;
            g.fillRect(1, 1, w-3, h-1-cw);
            Polygon p = new Polygon();
            p.addPoint(1, h-cw);
            p.addPoint(cw-1, h-1);
            p.addPoint(w-2, h-1-cw);
            g.fillPolygon(p);       

            g.setColor(getHighlightColor());
            g.drawLine(0, 0, w-2, 0);
            g.drawLine(0, 1, 0, h-1-cw);
            g.drawLine(0, h-cw, cw-1, h-1); 

            g.setColor(Color.black);
            g.drawLine(w-1, 0, w-1, h-2-cw);    
            g.drawLine(w-1, h-1-cw, w-1-cw, h-1);       

            g.setColor(getShadowColor());
            g.drawLine(w-2, 1, w-2, h-2-cw);    
            g.drawLine(w-2, h-1-cw, w-1-cw, h-2);       
        }
        else {  // vertical
            int cw = h / 2;
	    if(slider.getComponentOrientation().isLeftToRight()) {
		  g.fillRect(1, 1, w-1-cw, h-3);
	          Polygon p = new Polygon();
                  p.addPoint(w-cw-1, 0);
                  p.addPoint(w-1, cw);
                  p.addPoint(w-1-cw, h-2);
                  g.fillPolygon(p);

                  g.setColor(getHighlightColor());
	          g.drawLine(0, 0, 0, h - 2);                  // left
	          g.drawLine(1, 0, w-1-cw, 0);                 // top
	          g.drawLine(w-cw-1, 0, w-1, cw);              // top slant

                  g.setColor(Color.black);
	          g.drawLine(0, h-1, w-2-cw, h-1);             // bottom
	          g.drawLine(w-1-cw, h-1, w-1, h-1-cw);        // bottom slant

                  g.setColor(getShadowColor());
                  g.drawLine(1, h-2, w-2-cw,  h-2 );         // bottom
                  g.drawLine(w-1-cw, h-2, w-2, h-cw-1 );     // bottom slant
	    }
	    else {
		  g.fillRect(5, 1, w-1-cw, h-3);
	          Polygon p = new Polygon();
                  p.addPoint(cw, 0);
                  p.addPoint(0, cw);
                  p.addPoint(cw, h-2);
                  g.fillPolygon(p);

                  g.setColor(getHighlightColor());
                  g.drawLine(cw-1, 0, w-2, 0);             // top
                  g.drawLine(0, cw, cw, 0);                // top slant

                  g.setColor(Color.black);
                  g.drawLine(0, h-1-cw, cw, h-1 );         // bottom slant
                  g.drawLine(cw, h-1, w-1, h-1);           // bottom

                  g.setColor(getShadowColor());
                  g.drawLine(cw, h-2, w-2,  h-2 );         // bottom
                  g.drawLine(w-1, 1, w-1,  h-2 );          // right
	    }
        }

        g.translate(-knobBounds.x, -knobBounds.y);
    }
    @Override
    protected Dimension getThumbSize() {
        Dimension size = new Dimension();

        if ( slider.getOrientation() == JSlider.VERTICAL ) {
	    size.width = 15;
	    size.height = 15;
	}
	else {
	    size.width = 15;
	    size.height = 15;
	}

	return size;
    }


}
