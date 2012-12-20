/*
 * @(#)JavaNumberFormatter.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.text;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

/**
 * {@code ScaledNumberFormatter} is used to format numbers written in the
 * Java programming syntax.
 *
 * @author Werner Randelshofer
 * @version $Id: JavaNumberFormatter.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class JavaNumberFormatter extends DefaultFormatter {

    /**
     * Specifies whether the formatter allows null values.
     */
    private boolean allowsNullValue = false;
    private Comparable min;
    private Comparable max;
    @Nullable private String unit;
    private DecimalFormat decimalFormat;
    private DecimalFormat scientificFormat;
    private double multiplier = 1;
    private int minIntDigits;
    private int maxIntDigits;
    private int minFractionDigits;
    private int maxFractionDigits;
    private int minNegativeExponent = -3;
    private int minPositiveExponent = 8;
    private boolean usesScientificNotation = true;

    /**
     * Creates a <code>NumberFormatter</code> with the a default
     * <code>NumberFormat</code> instance obtained from
     * <code>NumberFormat.getNumberInstance()</code>.
     */
    public JavaNumberFormatter() {
        super();
        initFormats();
    }

    /**
     * Creates a NumberFormatter with the specified Format instance.
     */
    public JavaNumberFormatter(double min, double max, double multiplier) {
        this(min, max, multiplier, false, null);
    }

    /**
     * Creates a NumberFormatter with the specified Format instance.
     */
    public JavaNumberFormatter(double min, double max, double multiplier, boolean allowsNullValue) {
        this(min, max, multiplier, allowsNullValue, null);
    }
    /**
     * Creates a NumberFormatter with the specified Format instance.
     */
    public JavaNumberFormatter(double min, double max, double multiplier, boolean allowsNullValue, @Nullable String unit) {
        super();
        initFormats();
        setMinimum(min);
        setMaximum(max);
        setMultiplier(multiplier);
        setAllowsNullValue(allowsNullValue);
        setOverwriteMode(false);
        setUnit(unit);
    }

    private void initFormats() {
        DecimalFormatSymbols s = new DecimalFormatSymbols(Locale.ENGLISH);
        decimalFormat = new DecimalFormat("#################0.#################", s);
        scientificFormat = new DecimalFormat("0.0################E0", s);
    }

    /**
     * Sets the minimum permissible value. If the <code>valueClass</code> has
     * not been specified, and <code>minimum</code> is non null, the
     * <code>valueClass</code> will be set to that of the class of
     * <code>minimum</code>.
     *
     * @param minimum Minimum legal value that can be input
     * @see #setValueClass
     */
    public void setMinimum(Comparable minimum) {
        if (getValueClass() == null && minimum != null) {
            setValueClass(minimum.getClass());
        }
        min = minimum;
    }

    /**
     * Returns the minimum permissible value.
     *
     * @return Minimum legal value that can be input
     */
    public Comparable getMinimum() {
        return min;
    }

    /**
     * Sets the maximum permissible value. If the <code>valueClass</code> has
     * not been specified, and <code>max</code> is non null, the
     * <code>valueClass</code> will be set to that of the class of
     * <code>max</code>.
     *
     * @param max Maximum legal value that can be input
     * @see #setValueClass
     */
    public void setMaximum(Comparable max) {
        if (getValueClass() == null && max != null) {
            setValueClass(max.getClass());
        }
        this.max = max;
    }

    /**
     * Returns the maximum permissible value.
     *
     * @return Maximum legal value that can be input
     */
    public Comparable getMaximum() {
        return max;
    }

    /**
     * Sets the multiplier for use in percent, per mille, and similar formats.
     */
    public void setMultiplier(double newValue) {
        multiplier = newValue;
    }

    /**
     * Gets the multiplier for use in percent, per mille, and similar formats.
     */
    public double getMultiplier() {
        return multiplier;
    }

    /**
     * Allows/Disallows null values.
     *
     * @param newValue
     */
    public void setAllowsNullValue(boolean newValue) {
        allowsNullValue = newValue;
    }

    /**
     * Returns true if null values are allowed.
     */
    public boolean getAllowsNullValue() {
        return allowsNullValue;
    }

    /**
     * Specifies whether ".0" is appended to double and float
     * values. By default this is true.
     *
     * @param newValue
     */
    public void setMinimumFractionDigits(int newValue) {
        minFractionDigits = newValue;
        decimalFormat.setMinimumFractionDigits(newValue);
    }

    /**
     * Returns true if null values are allowed.
     */
    public int getMinimumFractionDigits() {
        return minFractionDigits;
    }

    /**
     * Returns a String representation of the Object <code>value</code>.
     * This invokes <code>format</code> on the current <code>Format</code>.
     *
     * @throws ParseException if there is an error in the conversion
     * @param value Value to convert
     * @return String representation of value
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value == null && allowsNullValue) {
            return "";
        }

        StringBuilder buf = new StringBuilder();
        if (value instanceof Double) {
            double v = ((Double) value).doubleValue();
            v = v * multiplier;
            String str;
            BigDecimal big = new BigDecimal(v);
            int exponent = big.scale() >= 0 ? big.precision() - big.scale() : -big.scale();
            if (!usesScientificNotation || exponent > minNegativeExponent && exponent < minPositiveExponent) {
                str = decimalFormat.format(v);
            } else {
                str = scientificFormat.format(v);
            }
            buf.append(str);
        } else if (value instanceof Float) {
            float v = ((Float) value).floatValue();
            v = (float) (v * multiplier);
            String str;// = Float.toString(v);
            BigDecimal big = new BigDecimal(v);
            int exponent = big.scale() >= 0 ? big.precision() - big.scale() : -big.scale();
            if (!usesScientificNotation || exponent > minNegativeExponent && exponent < minPositiveExponent) {
                str = decimalFormat.format(v);
            } else {
                str = scientificFormat.format(v);
            }
            buf.append(str);
        } else if (value instanceof Long) {
            long v = ((Long) value).longValue();
            v = (long) (v * multiplier);
            buf.append(Long.toString(v));
        } else if (value instanceof Integer) {
            int v = ((Integer) value).intValue();
            v = (int) (v * multiplier);
            buf.append(Integer.toString(v));
        } else if (value instanceof Byte) {
            byte v = ((Byte) value).byteValue();
            v = (byte) (v * multiplier);
            buf.append(Byte.toString(v));
        } else if (value instanceof Short) {
            short v = ((Short) value).shortValue();
            v = (short) (v * multiplier);
            buf.append(Short.toString(v));
        }
        if (buf.length() != 0) {
            if (unit != null) {
                buf.append(unit);
            }
            return buf.toString();
        }
        throw new ParseException("Value is of unsupported class " + value, 0);
    }

    /**
     * Returns the <code>Object</code> representation of the
     * <code>String</code> <code>text</code>.
     *
     * @param text <code>String</code> to convert
     * @return <code>Object</code> representation of text
     * @throws ParseException if there is an error in the conversion
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        if ((text == null || text.length() == 0) && getAllowsNullValue()) {
            return null;
        }

        // Remove unit from text
        if (unit != null) {
            int p = text.lastIndexOf(unit);
            if (p != -1) {
                text = text.substring(0, p);
            }
        }

        Class valueClass = getValueClass();
        Object value;
        if (valueClass != null) {
            try {
                if (valueClass == Integer.class) {
                    int v = Integer.parseInt(text);
                    v = (int) (v / multiplier);
                    value = v;
                } else if (valueClass == Long.class) {
                    long v = Long.parseLong(text);
                    v = (long) (v / multiplier);
                    value = v;
                } else if (valueClass == Float.class) {
                    float v = Float.parseFloat(text);
                    v = (float) (v / multiplier);
                    value = new Float(v);
                } else if (valueClass == Double.class) {
                    double v = Double.parseDouble(text);
                    v = (double) (v / multiplier);
                    value = new Double(v);
                } else if (valueClass == Byte.class) {
                    byte v = Byte.parseByte(text);
                    v = (byte) (v / multiplier);
                    value = v;
                } else if (valueClass == Short.class) {
                    short v = Short.parseShort(text);
                    v = (short) (v / multiplier);
                    value = v;
                } else {
                    throw new ParseException("Unsupported value class " + valueClass, 0);
                }
            } catch (NumberFormatException e) {
                throw new ParseException(e.getMessage(), 0);
            }
        } else {
            throw new ParseException("Unsupported value class " + valueClass, 0);
        }

        try {
            if (!isValidValue(value, true)) {
                throw new ParseException("Value not within min/max range", 0);
            }
        } catch (ClassCastException cce) {
            throw new ParseException("Class cast exception comparing values: " + cce, 0);
        }
        return value;
    }

    /**
     * Returns true if <code>value</code> is between the min/max.
     *
     * @param wantsCCE If false, and a ClassCastException is thrown in
     *                 comparing the values, the exception is consumed and
     *                 false is returned.
     */
    @SuppressWarnings("unchecked")
    boolean isValidValue(Object value, boolean wantsCCE) {
        try {
            if (min != null && min.compareTo(value) > 0) {
                return false;
            }
        } catch (ClassCastException cce) {
            if (wantsCCE) {
                throw cce;
            }
            return false;
        }

        try {
            if (max != null && max.compareTo(value) < 0) {
                return false;
            }
        } catch (ClassCastException cce) {
            if (wantsCCE) {
                throw cce;
            }
            return false;
        }
        return true;
    }

    /** If non-null the unit string is appended to the value. */
    public void setUnit(@Nullable String value) {
        unit = value;
    }

    /** If non-null the unit string is appended to the value. */
    @Nullable public String getUnit() {
        return unit;
    }

    /**
     * Gets the minimum number of digits allowed in the integer portion of a
     * number.
     */
    public int getMinimumIntegerDigits() {
        return minIntDigits;
    }

    /**
     * Sets the minimum number of digits allowed in the integer portion of a
     * number.
     */
    public void setMinimumIntegerDigits(int newValue) {
        decimalFormat.setMinimumIntegerDigits(newValue);
        scientificFormat.setMinimumIntegerDigits(newValue);
        this.minIntDigits = newValue;
    }

    /**
     * Gets the maximum number of digits allowed in the integer portion of a
     * number.
     */
    public int getMaximumIntegerDigits() {
        return maxIntDigits;
    }

    /**
     * Sets the maximum number of digits allowed in the integer portion of a
     * number.
     */
    public void setMaximumIntegerDigits(int newValue) {
        decimalFormat.setMaximumIntegerDigits(newValue);
        scientificFormat.setMaximumIntegerDigits(newValue);
        this.maxIntDigits = newValue;
    }

    /**
     * Gets the maximum number of digits allowed in the fraction portion of a
     * number.
     */
    public int getMaximumFractionDigits() {
        return maxFractionDigits;
    }

    /**
     * Sets the maximum number of digits allowed in the fraction portion of a
     * number.
     */
    public void setMaximumFractionDigits(int newValue) {
        decimalFormat.setMaximumFractionDigits(newValue);
        scientificFormat.setMaximumFractionDigits(newValue);
        this.maxFractionDigits = newValue;
    }

    /**
     * Gets the minimum negative exponent value for scientific notation.
     */
    public int getMinimumNegativeExponent() {
        return minNegativeExponent;
    }

    /**
     * Sets the minimum negative exponent value for scientific notation.
     */
    public void setMinimumNegativeExponent(int newValue) {
        this.minNegativeExponent = newValue;
    }

    /**
     * Gets the minimum positive exponent value for scientific notation.
     */
    public int getMinimumPositiveExponent() {
        return minPositiveExponent;
    }

    /**
     * Sets the minimum positive exponent value for scientific notation.
     */
    public void setMinimumPositiveExponent(int newValue) {
        this.minPositiveExponent = newValue;
    }

    /**
     * Returns true if scientific notation is used.
     */
    public boolean isUsesScientificNotation() {
        return usesScientificNotation;
    }

    /**
     * Sets whether scientific notation is used.
     */
    public void setUsesScientificNotation(boolean newValue) {
        this.usesScientificNotation = newValue;
    }

    /**
     * Convenience method for creating a formatter factory with a
     * {@code ScalableNumberFormatter} and a Java-style DecimalFormat.
     * Doesn't allow null values and doesn't append ".0" to double and float values.
     */
    public static AbstractFormatterFactory createFormatterFactory(double min, double max, double multiplier) {
        return createFormatterFactory(min, max, multiplier, false, null);
    }

    /**
     * Convenience method for creating a formatter factory with a
     * {@code ScalableNumberFormatter} and a Java-style DecimalFormat.
     */
    public static AbstractFormatterFactory createFormatterFactory(double min, double max, double multiplier, boolean allowsNullValue) {
        JavaNumberFormatter formatter = new JavaNumberFormatter(min, max, multiplier, allowsNullValue, null);
        return new DefaultFormatterFactory(formatter);
    }

    /**
     * Convenience method for creating a formatter factory with a
     * {@code ScalableNumberFormatter} and a Java-style DecimalFormat.
     */
    public static AbstractFormatterFactory createFormatterFactory(double min, double max, double multiplier, boolean allowsNullValue, @Nullable String unit) {
        JavaNumberFormatter formatter = new JavaNumberFormatter(min, max, multiplier, allowsNullValue, unit);
        return new DefaultFormatterFactory(formatter);
    }
}
