/*
 * @(#)CIELCHabColorSpace.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import java.awt.color.ColorSpace;

/**
 * The 1976 CIE L*CHa*b* color space (CIELCH).
 * <p>
 * The L* coordinate of an object is the lightness intensity as measured on a
 * scale from 0 to 100, where 0 represents black and 100 represents white.
 * <p>
 * The C and H coordinates are projections of the a* and b* colors of the
 * CIE L*a*b* color space into polar coordinates.
 * <pre>
 * a = C * cos(H)
 * b = C * sin(H)
 * </pre>
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class CIELCHabColorSpace extends ColorSpace implements NamedColorSpace {

    /** The XYZ coordinates of the CIE Standard Illuminant D65 reference white.*/
    private final static double[] D65 = {0.9505d, 1d, 1.0890d};
    private double Xr;
    /** The Y coordinate of the D50 reference white.*/
    private double Yr;
    /** The Z coordinate of the D50 reference white.*/
    private double Zr;
    private final static double eps = 216d / 24389d;
    private final static double k = 24389d / 27d;
    private final static ColorSpace sRGB = ColorSpace.getInstance(ColorSpace.CS_sRGB);
    /** By default, clamps non-displayable RGB values. */
    private boolean isClampRGB = true;

    public CIELCHabColorSpace() {
        super(ColorSpace.TYPE_Lab, 3);

        Xr = D65[0];
        Yr = D65[1];
        Zr = D65[2];
    }

    @Override
    public float[] toRGB(float[] colorvalue) {
        float[] ciexyz = toCIEXYZ(colorvalue);

        // Convert to sRGB as described in
        // http://www.w3.org/Graphics/Color/sRGB.html
        double X = ciexyz[0];
        double Y = ciexyz[1];
        double Z = ciexyz[2];

        double Rs = 3.2410 * X + -1.5374 * Y + -0.4986 * Z;
        double Gs = -0.9692 * X + 1.8760 * Y + -0.0416 * Z;
        double Bs = 0.0556 * X + -0.2040 * Y + 1.0570 * Z;

        if (Rs <= 0.00304) {
            Rs = 12.92 * Rs;
        } else {
            Rs = 1.055 * Math.pow(Rs, 1d / 2.4) - 0.055;
        }
        if (Gs <= 0.00304) {
            Gs = 12.92 * Gs;
        } else {
            Gs = 1.055 * Math.pow(Gs, 1d / 2.4) - 0.055;
        }
        if (Bs <= 0.00304) {
            Bs = 12.92 * Bs;
        } else {
            Bs = 1.055 * Math.pow(Bs, 1d / 2.4) - 0.055;
        }

        if (isClampRGB) {
            Rs = Math.min(1, Math.max(0, Rs));
            Gs = Math.min(1, Math.max(0, Gs));
            Bs = Math.min(1, Math.max(0, Bs));
        }

        return new float[]{(float)Rs, (float)Gs, (float)Bs};
        //       return sRGB.fromCIEXYZ(ciexyz);
    }

    @Override
    public float[] fromRGB(float[] rgbvalue) {
        float[] ciexyz = sRGB.fromRGB(rgbvalue);
        return fromCIEXYZ(ciexyz);
    }

    /**
     * Lab to XYZ.
     * <pre>
     * X = xr*Xr;
     * Y = yr*Yr;
     * Z = zr*Zr;
     * </pre>
     * where
     * <pre>
     * xr = fx^3, if fx^3 &gt; eps
     *    = (116*fx - 16)/k, if fx^3 &lt;= eps
     *
     * yr = ((L+16)/116)^3, if L > k*eps
     *    = L/k, if L &lt;= k*eps
     *
     * zr = fz^3, if fz^3 &gt; eps
     *    = (116*fz - 16)/k, if fz^3 &lt;= eps
     *
     * fx = a/500+fy
     *
     * fz = fy - b / 200
     *
     * fy = (L+16)/116
     *
     * eps = 216/24389
     * k = 24389/27
     * </pre>
     *
     * Source: <a href="http://www.brucelindbloom.com/index.html?Equations.html"
     * >http://www.brucelindbloom.com/index.html?Equations.html</a>
     *
     * @param colorvalue Lab color value.
     * @return CIEXYZ color value.
     */
    @Override
    public float[] toCIEXYZ(float[] colorvalue) {
        double L = colorvalue[0];
        double C = colorvalue[1];
        double H = colorvalue[2];
        double a = C * Math.cos(H);
        double b = C * Math.sin(H);

        double fy = (L + 16d) / 116d;

        double fx = a / 500d + fy;

        double fz = fy - b / 200d;

        double xr, yr, zr;

        double fxp3 = fx * fx * fx;
        if (fxp3 > eps) {
            xr = fxp3;
        } else {
            xr = (116d * fx - 16d) / k;
        }
        if (L > k * eps) {
            yr = ((L + 16d) / 116d);
            yr = yr * yr * yr;
        } else {
            yr = L / k;
        }

        double fzp3 = fz * fz * fz;
        if (fzp3 > eps) {
            zr = fzp3;
        } else {
            zr = (116d * fz - 16f) / k;
        }

        double X = xr * Xr;
        double Y = yr * Yr;
        double Z = zr * Zr;

        return new float[]{(float)X, (float)Y, (float)Z};
    }

    /**
     * XYT to Lab.
     * <pre>
     * L = 116*fy - 16
     * a = 500 * (fx - fy)
     * b = 200 * (fy - fz)
     * </pre>
     * where
     * <pre>
     * fx = xr^(1/3), if xr &gt; eps
     *    = (k*xr + 16) / 116 if xr &lt;= eps
     *
     * fy = yr^(1/3), if yr &gt; eps
     *    = (k*yr + 16) / 116 if yr &lt;= eps
     *
     * fz = zr^(1/3), if zr &gt; eps
     *    = (k*zr + 16) / 116 if zr &lt;= eps
     *
     * xr = X / Xr
     * yr = Y / Yr
     * zr = Z / Zr
     *
     * eps = 216/24389
     * k = 24389/27
     * </pre>
     *
     * Source: <a href="http://www.brucelindbloom.com/index.html?Equations.html"
     * >http://www.brucelindbloom.com/index.html?Equations.html</a>
     *
     * @param colorvalue CIEXYZ color value.
     * @return Lab color value.
     */
    @Override
    public float[] fromCIEXYZ(float[] colorvalue) {
        double X = colorvalue[0];
        double Y = colorvalue[1];
        double Z = colorvalue[2];

        double xr = X / Xr;
        double yr = Y / Yr;
        double zr = Z / Zr;

        double fx, fy, fz;
        if (xr > eps) {
            fx = Math.pow(xr, 1d / 3d);
        } else {
            fx = (k * xr + 16d) / 116d;
        }
        if (yr > eps) {
            fy = Math.pow(yr, 1d / 3d);
        } else {
            fy = (k * yr + 16d) / 116d;
        }
        if (zr > eps) {
            fz = Math.pow(zr, 1d / 3d);
        } else {
            fz = (k * zr + 16) / 116;
        }

        double L = 116d * fy - 16;
        double a = 500d * (fx - fy);
        double b = 200d * (fy - fz);

        double C = Math.sqrt(a*a+b*b);
        double H = Math.atan2(b, a);

        return new float[]{(float)L, (float)C, (float)H};

    }

    @Override
    public String getName() {
        return "CIE 1976 L*CHa*b*";
    }

    @Override
    public float getMinValue(int component) {
        switch (component) {
            case 0:
                return 0f;
            case 1:
                return -127f;
            case 2:
                return 0f;
        }
        throw new IllegalArgumentException("Illegal component:" + component);
    }

    @Override
    public float getMaxValue(int component) {
        switch (component) {
            case 0:
                return 100f;
            case 1:
                return 128f;
            case 2:
                return 320f;
        }
        throw new IllegalArgumentException("Illegal component:" + component);
    }

    @Override
    public String getName(int component) {
        switch (component) {
            case 0:
                return "L*";
            case 1:
                return "a*";
            case 2:
                return "b*";
        }
        throw new IllegalArgumentException("Illegal component:" + component);
    }

    public void setClampRGBValues(boolean b) {
        isClampRGB = b;
    }

    public boolean isClampRGBValues() {
        return isClampRGB;
    }

    public static void main(String[] arg) {
        CIELCHabColorSpace cs = new CIELCHabColorSpace();
        float[] lchab = cs.fromRGB(new float[]{1, 1, 1});
        System.out.println("rgb->LCHab:" + lchab[0] + "," + lchab[1] + "," + lchab[2]);

        float[] xyz = cs.toCIEXYZ(new float[]{0.75f, 0.25f, 0.1f});
        System.out.println("    lab->xyz:" + xyz[0] + "," + xyz[1] + "," + xyz[2]);
        lchab = cs.fromCIEXYZ(xyz);
        System.out.println("R xyz->LCHab:" + lchab[0] + "," + lchab[1] + "," + lchab[2]);

        lchab = cs.fromCIEXYZ(new float[]{1, 1, 1});
        System.out.println("xyz->LCHab:" + lchab[0] + "," + lchab[1] + "," + lchab[2]);


        lchab = cs.fromCIEXYZ(new float[]{0.5f, 1, 1});
        System.out.println("xyz->LCHab:" + lchab[0] + "," + lchab[1] + "," + lchab[2]);
    }
}
