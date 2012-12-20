/*
 * @(#)FontFormatter.java
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
import java.awt.Font;
import java.text.ParseException;
import java.util.HashMap;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

/**
 * {@code FontFormatter} is used to format fonts into a textual representation
 * which can be edited in an entry field.
 * <p>
 *
 * @author Werner Randelshofer
 * @version $Id: FontFormatter.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class FontFormatter extends DefaultFormatter {

    /**
     * Specifies whether the formatter allows null values.
     */
    private boolean allowsNullValue = false;
    /**
     * Specifies whether the formatter allows unknown fonts.
     */
    private boolean allowsUnknownFont = false;
    /**
     * Map of generic font families.
     * By default, holds a map of HTML generic font families.
     * <a href="http://www.w3.org/TR/CSS2/fonts.html#generic-font-families"/>
     * http://www.w3.org/TR/CSS2/fonts.html#generic-font-families</a>.
     */
    @Nullable private HashMap<String, Font> genericFontFamilies = new HashMap<String, Font>();

    public FontFormatter() {
        this(true);
    }

    public FontFormatter(boolean allowsNullValue) {
        this.allowsNullValue = allowsNullValue;
        setOverwriteMode(false);

        // Map of HTML generic font families.
        // @see http://www.w3.org/TR/CSS2/fonts.html#generic-font-families
        putGenericFontFamily("serif", new Font("Serif", Font.PLAIN, 12));
        putGenericFontFamily("sans-serif", new Font("SansSerif", Font.PLAIN, 12));
        putGenericFontFamily("cursive", new Font("SansSerif", Font.ITALIC, 12));
        putGenericFontFamily("fantasy", new Font("Serif", Font.PLAIN, 12));
        putGenericFontFamily("monospace", new Font("Monospaced", Font.PLAIN, 12));
    }

    /**
     * Sets whether a null value is allowed.
     * @param newValue
     */
    public void setAllowsNullValue(boolean newValue) {
        allowsNullValue = newValue;
    }

    /**
     * Returns true, if null value is allowed.
     */
    public boolean getAllowsNullValue() {
        return allowsNullValue;
    }

    /**
     * Sets whether unknown font names are allowed.
     * @param newValue
     */
    public void setAllowsUnknownFont(boolean newValue) {
        allowsUnknownFont = newValue;
    }

    /**
     * Returns true, if unknown font names are allowed.
     */
    public boolean getAllowsUnknownFont() {
        return allowsUnknownFont;
    }

    /** Clears the generic font families map. */
    public void clearGenericFontFamilies() {
        genericFontFamilies = null;
    }

    /** Adds a generic font family. */
    public void putGenericFontFamily(String familyName, Font font) {
        genericFontFamilies.put(familyName.toLowerCase(), font);
    }

    @Override
    public Object stringToValue(String str) throws ParseException {

        // Handle null and empty case
        if (str == null || str.trim().length() == 0) {
            if (allowsNullValue) {
                return null;
            } else {
                throw new ParseException("Null value is not allowed.", 0);
            }
        }
        String strLC = str.trim().toLowerCase();

        Font f = null;
        f = genericFontFamilies.get(strLC);
        if (f == null) {
            f = Font.decode(str);
            if (f == null) {
                throw new ParseException(str, 0);
            }
            if (!allowsUnknownFont) {
                String fontName = f.getFontName().toLowerCase();
                String family = f.getFamily().toLowerCase();
                if (!fontName.equals(strLC) &&
                        !family.equals(strLC) &&
                        !fontName.equals(strLC + "-derived")) {
                    throw new ParseException(str, 0);
                }
            }
        }
        return f;
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
            if (!(value instanceof Font)) {
                throw new ParseException("Value is not a font " + value, 0);
            }

            Font f = (Font) value;
            str = f.getFontName();

        }
        return str;
    }

    /**
     * Convenience method for creating a formatter factory with a
     * {@code FontFormatter}.
     * Uses the RGB_INTEGER format and disallows null values.
     */
    public static AbstractFormatterFactory createFormatterFactory() {
        return createFormatterFactory(false);
    }

    /**
     * Convenience method for creating a formatter factory with a
     * 8@code FontFormatter}.
     */
    public static AbstractFormatterFactory createFormatterFactory(boolean allowsNullValue) {
        return new DefaultFormatterFactory(new FontFormatter(allowsNullValue));
    }
}
