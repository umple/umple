/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.text;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Font;
import java.text.ParseException;
import java.util.HashMap;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;

public class FontFormatter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public FontFormatter()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
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

    public static AbstractFormatterFactory createFormatterFactory(boolean allowsNullValue) {
        return new DefaultFormatterFactory(new FontFormatter(allowsNullValue));
    }
}