/*
 * @(#)CompositeColor.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Color;
import java.awt.color.ColorSpace;

/**
 * {@code CompositeColor} is identical to {@code java.awt.Color} with
 * the exception that it allows to construct an instance with color components
 * outside of the range of 0 and 1.
 *
 * @author Werner Randelshofer
 * @version $Id: CompositeColor.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class CompositeColor extends Color {

    /**
     * The color value in the native <code>ColorSpace</code> as
     * <code>float</code> components (no alpha).
     * If <code>null</code> after object construction, this must be an
     * sRGB color constructed with 8-bit precision, so compute from the
     * <code>int</code> color value.
     * @serial
     * @see #getRGBColorComponents
     * @see #getRGBComponents
     */
    @Nullable
    private float fvalue[] = null;
    /**
     * The alpha value as a <code>float</code> component.
     * If <code>frgbvalue</code> is <code>null</code>, this is not valid
     * data, so compute from the <code>int</code> color value.
     * @serial
     * @see #getRGBComponents
     * @see #getComponents
     */
    private float falpha = 0.0f;
    /**
     * The <code>ColorSpace</code>.  If <code>null</code>, then it's
     * default is sRGB.
     * @serial
     * @see #getColor
     * @see #getColorSpace
     * @see #getColorComponents
     */
    @Nullable
    private ColorSpace cs = null;

    /**
     * Creates a color in the specified <code>ColorSpace</code>
     * with the color components specified in the <code>float</code>
     * array and the specified alpha.  The number of components is
     * determined by the type of the <code>ColorSpace</code>.  For
     * example, RGB requires 3 components, but CMYK requires 4
     * components.
     * @param cspace the <code>ColorSpace</code> to be used to
     *			interpret the components
     * @param components an arbitrary number of color components
     *                      that is compatible with the <code>ColorSpace</code>
     * @param alpha alpha value
     * @throws IllegalArgumentException if any of the values in the
     *         <code>components</code> array or <code>alpha</code> is
     *         outside of the range supported by cspace.
     * @see #getComponents
     * @see #getColorComponents
     */
    public CompositeColor(ColorSpace cspace, float components[], float alpha) {
        super(((int) (alpha * 255) << 24) | ColorUtil.toRGB(cspace, components), true);
        boolean rangeError = false;
        StringBuilder badComponentString = new StringBuilder();
        int n = cspace.getNumComponents();
        fvalue = new float[n];
        for (int i = 0; i < n; i++) {
            if (components[i] < cspace.getMinValue(i) || components[i] > cspace.getMaxValue(i)) {
                rangeError = true;
                badComponentString.append("Component ");
                badComponentString.append(i);
                badComponentString.append(' ');
            } else {
                fvalue[i] = components[i];
            }
        }
        if (alpha < 0.0 || alpha > 1.0) {
            rangeError = true;
            badComponentString.append("Alpha");
        } else {
            falpha = alpha;
        }
        if (rangeError) {
            throw new IllegalArgumentException(
                    "Color parameter outside of expected range: "
                    + badComponentString);
        }
        cs = cspace;
    }

    /**
     * Returns a <code>float</code> array containing the color and alpha
     * components of the <code>Color</code>, in the
     * <code>ColorSpace</code> of the <code>Color</code>.
     * If <code>compArray</code> is <code>null</code>, an array with
     * length equal to the number of components in the associated
     * <code>ColorSpace</code> plus one is created for
     * the return value.  Otherwise, <code>compArray</code> must have at
     * least this length and it is filled in with the components and
     * returned.
     * @param compArray an array that this method fills with the color and
     *		alpha components of this <code>Color</code> in its
     *		<code>ColorSpace</code> and returns
     * @return the color and alpha components in a <code>float</code>
     * 		array.
     */
    @Override
    public float[] getComponents(float[] compArray) {
        if (fvalue == null) {
            return getRGBComponents(compArray);
        }
        float[] f;
        int n = fvalue.length;
        if (compArray == null) {
            f = new float[n + 1];
        } else {
            f = compArray;
        }
        for (int i = 0; i < n; i++) {
            f[i] = fvalue[i];
        }
        f[n] = falpha;
        return f;
    }

    /**
     * Returns a <code>float</code> array containing only the color
     * components of the <code>Color</code>, in the
     * <code>ColorSpace</code> of the <code>Color</code>.
     * If <code>compArray</code> is <code>null</code>, an array with
     * length equal to the number of components in the associated
     * <code>ColorSpace</code> is created for
     * the return value.  Otherwise, <code>compArray</code> must have at
     * least this length and it is filled in with the components and
     * returned.
     * @param compArray an array that this method fills with the color
     *		components of this <code>Color</code> in its
     *		<code>ColorSpace</code> and returns
     * @return the color components in a <code>float</code> array.
     */
    @Override
    public float[] getColorComponents(float[] compArray) {
        if (fvalue == null) {
            return getRGBColorComponents(compArray);
        }
        float[] f;
        int n = fvalue.length;
        if (compArray == null) {
            f = new float[n];
        } else {
            f = compArray;
        }
        for (int i = 0; i < n; i++) {
            f[i] = fvalue[i];
        }
        return f;
    }

    /**
     * Returns a <code>float</code> array containing the color and alpha
     * components of the <code>Color</code>, in the
     * <code>ColorSpace</code> specified by the <code>cspace</code>
     * parameter.  If <code>compArray</code> is <code>null</code>, an
     * array with length equal to the number of components in
     * <code>cspace</code> plus one is created for the return value.
     * Otherwise, <code>compArray</code> must have at least this
     * length, and it is filled in with the components and returned.
     * @param cspace a specified <code>ColorSpace</code>
     * @param compArray an array that this method fills with the
     *		color and alpha components of this <code>Color</code> in
     *		the specified <code>ColorSpace</code> and returns
     * @return the color and alpha components in a <code>float</code>
     * 		array.
     */
    @Override
    public float[] getComponents(ColorSpace cspace, float[] compArray) {
        if (cs == null) {
            cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        }
        float f[];
        if (fvalue == null) {
            f = new float[3];
            f[0] = ((float) getRed()) / 255f;
            f[1] = ((float) getGreen()) / 255f;
            f[2] = ((float) getBlue()) / 255f;
        } else {
            f = fvalue;
        }
        float tmp[] = cs.toCIEXYZ(f);
        float tmpout[] = cspace.fromCIEXYZ(tmp);
        if (compArray == null) {
            compArray = new float[tmpout.length + 1];
        }
        for (int i = 0; i < tmpout.length; i++) {
            compArray[i] = tmpout[i];
        }
        if (fvalue == null) {
            compArray[tmpout.length] = ((float) getAlpha()) / 255f;
        } else {
            compArray[tmpout.length] = falpha;
        }
        return compArray;
    }

    /**
     * Returns a <code>float</code> array containing only the color
     * components of the <code>Color</code> in the
     * <code>ColorSpace</code> specified by the <code>cspace</code>
     * parameter. If <code>compArray</code> is <code>null</code>, an array
     * with length equal to the number of components in
     * <code>cspace</code> is created for the return value.  Otherwise,
     * <code>compArray</code> must have at least this length, and it is
     * filled in with the components and returned.
     * @param cspace a specified <code>ColorSpace</code>
     * @param compArray an array that this method fills with the color
     *		components of this <code>Color</code> in the specified
     * 		<code>ColorSpace</code>
     * @return the color components in a <code>float</code> array.
     */
    @Override
    public float[] getColorComponents(ColorSpace cspace, float[] compArray) {
        if (cs == null) {
            cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        }
        float f[];
        if (fvalue == null) {
            f = new float[3];
            f[0] = ((float) getRed()) / 255f;
            f[1] = ((float) getGreen()) / 255f;
            f[2] = ((float) getBlue()) / 255f;
        } else {
            f = fvalue;
        }
        float tmp[] = cs.toCIEXYZ(f);
        float tmpout[] = cspace.fromCIEXYZ(tmp);
        if (compArray == null) {
            return tmpout;
        }
        for (int i = 0; i < tmpout.length; i++) {
            compArray[i] = tmpout[i];
        }
        return compArray;
    }

    /**
     * Returns the <code>ColorSpace</code> of this <code>Color</code>.
     * @return this <code>Color</code> object's <code>ColorSpace</code>.
     */
    @Override
    public ColorSpace getColorSpace() {
        if (cs == null) {
            cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
        }
        return cs;
    }
}
