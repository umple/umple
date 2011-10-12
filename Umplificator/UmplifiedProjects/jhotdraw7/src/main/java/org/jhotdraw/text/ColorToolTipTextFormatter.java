/*
 * @(#)ColorFormatter.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.text;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.text.ParseException;
import org.jhotdraw.color.HSBColorSpace;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * {@code ColorFormatter} is used to format colors into a textual representation
 * which can be displayed as a tooltip.
 * <p>
 * By default, the formatter is adaptive, meaning that the format depends
 * on the {@code ColorSpace} of the current {@code Color} value.
 * <p>
 *
 * @author Werner Randelshofer
 * @version $Id: ColorFormatter.java 632 2010-01-21 16:06:59Z rawcoder $
 */
public class ColorToolTipTextFormatter extends ColorFormatter {

    private ResourceBundleUtil labels;

    public ColorToolTipTextFormatter() {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
    }

    @Override
    public String valueToString(Object value) throws ParseException {
        String str = null;

        if (value == null) {
            if (allowsNullValue) {
                str = "";
            } else {
                throw new ParseException("Null value is not allowed.", 0);
            }
        } else {
            if (!(value instanceof Color)) {
                throw new ParseException("Value is not a color " + value, 0);
            }

            Color c = (Color) value;

            Format f = outputFormat;

            if (isAdaptive) {
                if (c.getColorSpace().equals(HSBColorSpace.getInstance())) {
                    f = Format.HSB_PERCENTAGE;
                } else if (c.getColorSpace().equals(ColorSpace.getInstance(ColorSpace.CS_GRAY))) {
                    f = Format.GRAY_PERCENTAGE;
                } else {
                    f = Format.RGB_INTEGER;
                }
            }
            switch (f) {
                case RGB_HEX:
                    str = "000000" + Integer.toHexString(c.getRGB() & 0xffffff);
                    str = labels.getFormatted("attribute.color.rgbHexComponents.toolTipText",//
                            str.substring(str.length() - 6));
                    break;
                case RGB_INTEGER:
                    str = labels.getFormatted("attribute.color.rgbComponents.toolTipText",//
                            numberFormat.format(c.getRed()),//
                            numberFormat.format(c.getGreen()),//
                            numberFormat.format(c.getBlue()));
                    break;
                case RGB_PERCENTAGE:
                    str = labels.getFormatted("attribute.color.rgbPercentageComponents.toolTipText",//
                            numberFormat.format(c.getRed() / 255f),//
                            numberFormat.format(c.getGreen() / 255f),//
                            numberFormat.format(c.getBlue() / 255f));
                    break;
                case HSB_PERCENTAGE: {
                    float[] components;
                    if (c.getColorSpace().equals(HSBColorSpace.getInstance())) {
                        components = c.getComponents(null);
                    } else {
                        components = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), new float[3]);
                    }
                    str = labels.getFormatted("attribute.color.hsbComponents.toolTipText",//
                            numberFormat.format(components[0] * 360),//
                            numberFormat.format(components[1] * 100),//
                            numberFormat.format(components[2] * 100));
                    break;
                }
                case GRAY_PERCENTAGE: {
                    float[] components;
                    if (c.getColorSpace().equals(ColorSpace.getInstance(ColorSpace.CS_GRAY))) {
                        components = c.getComponents(null);
                    } else {
                        components = c.getColorComponents(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
                    }
                    str = labels.getFormatted("attribute.color.grayComponents.toolTipText",//
                            numberFormat.format(components[0] * 100));
                    break;
                }
            }
        }
        return str;
    }
}
