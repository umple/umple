/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.text;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Color;
import java.awt.color.ColorSpace;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.prefs.Preferences;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.jhotdraw.color.ColorUtil;
import org.jhotdraw.color.HSBColorSpace;
import org.jhotdraw.util.prefs.PreferencesUtil;

public class ColorFormatter
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ColorFormatter()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  protected Format outputFormat = Format.RGB_INTEGER;
/**
     * Specifies the last used input format.
     */
    @Nullable protected Format lastUsedInputFormat = null;
/**
     * This regular expression is used for parsing the RGB_HEX format.
     */
    protected final static Pattern rgbHexPattern = Pattern.compile("^\\s*(?:[rR][gG][bB]\\s*#|#)\\s*([0-9a-fA-F]{3,6})\\s*$");
/**
     * This regular expression is used for parsing the RGB_INTEGER format.
     */
    protected final static Pattern rgbIntegerShortPattern = Pattern.compile("^\\s*([0-9]{1,3})(?:\\s*,\\s*|\\s+)([0-9]{1,3})(?:\\s*,\\s*|\\s+)([0-9]{1,3})\\s*$");
/**
     * This regular expression is used for parsing the RGB_INTEGER format.
     */
    protected final static Pattern rgbIntegerPattern = Pattern.compile("^\\s*(?:[rR][gG][bB])?\\s*([0-9]{1,3})(?:\\s*,\\s*|\\s+)([0-9]{1,3})(?:\\s*,\\s*|\\s+)([0-9]{1,3})\\s*$");
/**
     * This regular expression is used for parsing the RGB_PERCENTAGE format.
     */
    protected final static Pattern rgbPercentagePattern = Pattern.compile("^\\s*(?:[rR][gG][bB][%])?\\s*([0-9]{1,3}(?:\\.[0-9]+)?)(?:\\s*,\\s*|\\s+)([0-9]{1,3}(?:\\.[0-9]+)?)(?:\\s*,\\s*|\\s+)([0-9]{1,3}(?:\\.[0-9]+)?)\\s*$");
/**
     * This regular expression is used for parsing the HSB_PERCENTAGE format.
     * This format is recognized when the degree sign is present.
     */
    protected final static Pattern hsbPercentagePattern = Pattern.compile("^\\s*(?:[hH][sS][bB])?\\s*([0-9]{1,3}(?:\\.[0-9]+)?)(?:\\s*,\\s*|\\s+)([0-9]{1,3}(?:\\.[0-9]+)?)(?:\\s*,\\s*|\\s+)([0-9]{1,3}(?:\\.[0-9]+)?)\\s*$");
/**
     * This regular expression is used for parsing the GRAY_PERCENTAGE format.
     * This format is recognized when the degree sign is present.
     */
    protected final static Pattern grayPercentagePattern = Pattern.compile("^\\s*(?:[gG][rR][aA][yY])?\\s*([0-9]{1,3}(?:\\.[0-9]+)?)\\s*$");
/**
     * Specifies whether the formatter allows null values.
     */
    protected boolean allowsNullValue = true;
/**
     * Specifies whether the formatter should adaptively change its output
     * format depending on the last input format used by the user.
     */
    protected boolean isAdaptive = true;
/**
     * Preferences used for storing the last used input format.
     */
    protected Preferences prefs;
protected DecimalFormat numberFormat;
RGB_HEX
RGB_INTEGER_SHORT
RGB_INTEGER
RGB_PERCENTAGE
HSB_PERCENTAGE
GRAY_PERCENTAGE
CMYK_PERCENTAGE
/**
     * Sets the output format.
     * @param newValue
     */
    public void setOutputFormat(Format newValue) {
        if (newValue == null) {
            throw new NullPointerException("outputFormat may not be null");
        }
        outputFormat = newValue;
    }
/**
     * Gets the output format.
     */
    public Format getOutputFormat() {
        return outputFormat;
    }
/**
     * Gets the last used input format.
     */
    public Format getLastUsedInputFormat() {
        return lastUsedInputFormat;
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
     * Sets whether the color formatter adaptively selects its output
     * format depending on the last input format used by the user.
     *
     * @param newValue
     */
    public void setAdaptive(boolean newValue) {
        isAdaptive = newValue;
        if (newValue && lastUsedInputFormat != null) {
            outputFormat = lastUsedInputFormat;
        }
    }
/**
     * Returns true, if the color formatter is adaptive.
     */
    public boolean isAdaptive() {
        return isAdaptive;
    }
private void setLastUsedInputFormat(Format newValue) {
        lastUsedInputFormat = newValue;
        if (isAdaptive) {
            outputFormat = lastUsedInputFormat;
        }
        prefs.put("ColorFormatter.lastUsedInputFormat", newValue.name());
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

        // Format RGB_HEX
        Matcher matcher = rgbHexPattern.matcher(str);
        if (matcher.matches()) {
            setLastUsedInputFormat(Format.RGB_HEX);
            try {
                String group1 = matcher.group(1);
                if (group1.length() == 3) {
                    return new Color(Integer.parseInt(
                            "" + group1.charAt(0) + group1.charAt(0) + //
                            group1.charAt(1) + group1.charAt(1) + //
                            group1.charAt(2) + group1.charAt(2), //
                            16));
                } else if (group1.length() == 6) {
                    return new Color(Integer.parseInt(group1, 16));
                } else {
                    throw new ParseException("Hex color must have 3 or 6 digits.", 1);
                }
            } catch (NumberFormatException nfe) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(nfe);
                throw pe;
            }
        }

        // Format RGB_INTEGER_SHORT and RGB_INTEGER
        matcher = rgbIntegerShortPattern.matcher(str);
        if (matcher.matches()) {
            setLastUsedInputFormat(Format.RGB_INTEGER_SHORT);
        } else {
            matcher = rgbIntegerPattern.matcher(str);
            if (matcher.matches()) {
                setLastUsedInputFormat(Format.RGB_INTEGER);
            }
        }
        if (matcher.matches()) {
            try {
                return new Color(//
                        Integer.parseInt(matcher.group(1)), //
                        Integer.parseInt(matcher.group(2)), //
                        Integer.parseInt(matcher.group(3)));
            } catch (NumberFormatException nfe) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(nfe);
                throw pe;
            } catch (IllegalArgumentException iae) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(iae);
                throw pe;
            }
        }

        // Format RGB_PERCENTAGE
        matcher = rgbPercentagePattern.matcher(str);
        if (matcher.matches()) {
            setLastUsedInputFormat(Format.RGB_PERCENTAGE);
            try {
                return new Color(//
                        numberFormat.parse(matcher.group(1)).floatValue() / 100f, //
                        numberFormat.parse(matcher.group(2)).floatValue() / 100f, //
                        numberFormat.parse(matcher.group(3)).floatValue() / 100f);
            } catch (NumberFormatException nfe) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(nfe);
                throw pe;
            } catch (IllegalArgumentException iae) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(iae);
                throw pe;
            }
        }

        // Format HSB_PERCENTAGE
        matcher = hsbPercentagePattern.matcher(str);
        if (matcher.matches()) {
            setLastUsedInputFormat(Format.HSB_PERCENTAGE);
            try {
                return new Color(HSBColorSpace.getInstance(),
                        new float[]{//
                            matcher.group(1) == null ? 0f : numberFormat.parse(matcher.group(1)).floatValue() / 360f, //
                            matcher.group(2) == null ? 1f : numberFormat.parse(matcher.group(2)).floatValue() / 100f, //
                            matcher.group(3) == null ? 1f : numberFormat.parse(matcher.group(3)).floatValue() / 100f},//
                        1f);
            } catch (NumberFormatException nfe) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(nfe);
                throw pe;
            } catch (IllegalArgumentException iae) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(iae);
                throw pe;
            }
        }

        // Format GRAY_PERCENTAGE
        matcher = grayPercentagePattern.matcher(str);
        if (matcher.matches()) {
            setLastUsedInputFormat(Format.GRAY_PERCENTAGE);
            try {
                return ColorUtil.toColor(ColorSpace.getInstance(ColorSpace.CS_GRAY),
                        new float[]{//
                            matcher.group(1) == null ? 0f : numberFormat.parse(matcher.group(1)).floatValue() / 100f}//
                        );
            } catch (NumberFormatException nfe) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(nfe);
                throw pe;
            } catch (IllegalArgumentException iae) {
                ParseException pe = new ParseException(str, 0);
                pe.initCause(iae);
                throw pe;
            }
        }

        throw new ParseException(str, 0);
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
                switch (c.getColorSpace().getType()) {
                    case ColorSpace.TYPE_HSV:
                        f = Format.HSB_PERCENTAGE;
                        break;
                    case ColorSpace.TYPE_GRAY:
                        f = Format.GRAY_PERCENTAGE;
                        break;
                    case ColorSpace.TYPE_RGB:
                    default:
                        f = Format.RGB_INTEGER_SHORT;
                }
            }
            switch (f) {
                case RGB_HEX:
                    str = "000000" + Integer.toHexString(c.getRGB() & 0xffffff);
                    str = "#" + str.substring(str.length() - 6);
                    break;
                case RGB_INTEGER_SHORT:
                    str = c.getRed() + " " + c.getGreen() + " " + c.getBlue();
                    break;
                case RGB_INTEGER:
                    str = "rgb " + c.getRed() + " " + c.getGreen() + " " + c.getBlue();
                    break;
                case RGB_PERCENTAGE:
                    str = "rgb% " + numberFormat.format(c.getRed() / 255f) + " " + numberFormat.format(c.getGreen() / 255f) + " " + numberFormat.format(c.getBlue() / 255f) + "";
                    break;
                case HSB_PERCENTAGE: {
                    float[] components;
                    if (c.getColorSpace().getType()==ColorSpace.TYPE_HSV) {
                        components = c.getComponents(null);
                    } else {
                        components = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), new float[3]);
                    }
                    str = "hsb " + numberFormat.format(components[0] * 360) + " "//
                            + numberFormat.format(components[1] * 100) + " " //
                            + numberFormat.format(components[2] * 100) + "";
                    break;
                }
                case GRAY_PERCENTAGE: {
                    float[] components;
                    if (c.getColorSpace().getType()==ColorSpace.TYPE_GRAY) {
                        components = c.getComponents(null);
                    } else {
                        components = c.getColorComponents(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
                    }
                    str = "gray " + numberFormat.format(components[0] * 100) + "";
                    break;
                }
            }
        }
        return str;
    }

    public static AbstractFormatterFactory createFormatterFactory() {
        return createFormatterFactory(Format.RGB_INTEGER_SHORT, true, true);
    }

    public static AbstractFormatterFactory createFormatterFactory(Format outputFormat, boolean allowsNullValue, boolean isAdaptive) {
        return new DefaultFormatterFactory(new ColorFormatter(outputFormat, allowsNullValue, isAdaptive));
    }
}