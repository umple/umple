/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.xml;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.regex.Matcher;

public class JavaPrimitivesDOMFactory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public JavaPrimitivesDOMFactory()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private String escape(String name) {
        // Escape dollar characters by two full-stop characters
        name = name.replaceAll("\\$", "..");
        return name;

    }
private String unescape(String name) {
        // Unescape dollar characters from two full-stop characters
        name = name.replaceAll("\\.\\.", Matcher.quoteReplacement("$"));
        return name;
    }
@Override
    public String getName(Object o) {
        if (o == null) {
            return "null";
        } else if (o instanceof Boolean) {
            return "boolean";
        } else if (o instanceof Byte) {
            return "byte";
        } else if (o instanceof Character) {
            return "char";
        } else if (o instanceof Short) {
            return "short";
        } else if (o instanceof Integer) {
            return "int";
        } else if (o instanceof Long) {
            return "long";
        } else if (o instanceof Float) {
            return "float";
        } else if (o instanceof Double) {
            return "double";
        } else if (o instanceof Color) {
            return "color";
        } else if (o instanceof Font) {
            return "font";
        } else if (o instanceof byte[]) {
            return "byteArray";
        } else if (o instanceof char[]) {
            return "charArray";
        } else if (o instanceof short[]) {
            return "shortArray";
        } else if (o instanceof int[]) {
            return "intArray";
        } else if (o instanceof long[]) {
            return "longArray";
        } else if (o instanceof float[]) {
            return "floatArray";
        } else if (o instanceof double[]) {
            return "doubleArray";
        } else if (o instanceof String) {
            return "string";
        } else if (o instanceof Enum) {
            return "enum";
        } else if (o instanceof Color) {
            return "color";
        } else if (o instanceof Font) {
            return "font";
        }
        return escape(o.getClass().getName());
    }
@Override
    public Object create(String name) {
        name = unescape(name);

        try {
            return Class.forName(name).newInstance();
        } catch (InstantiationException ex) {
            IllegalArgumentException e = new IllegalArgumentException("Class " + name + " can not instantiate an object");
            e.initCause(ex);
            throw e;
        } catch (IllegalAccessException ex) {
            IllegalArgumentException e = new IllegalArgumentException("Class " + name + " is not public");
            e.initCause(ex);
            throw e;
        } catch (ClassNotFoundException ex) {
            IllegalArgumentException e = new IllegalArgumentException("Class " + name + " does not exist");
            e.initCause(ex);
            throw e;
        }
    }
protected String getEnumName(Enum o) {
        return escape(o.getClass().getName());
    }
protected String getEnumValue(Enum o) {
        return o.name();
    }
@SuppressWarnings("unchecked")
    protected Enum createEnum(String name, String value) {
        name = unescape(name);

        Class enumClass;
        try {
            enumClass = Class.forName(name);
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("Class not found for Enum with name:" + name);
        }
        if (enumClass == null) {
            throw new IllegalArgumentException("Enum name not known to factory:" + name);
        }
        return Enum.valueOf(enumClass, value);
    }
@Override
    public void write(DOMOutput out, Object o) throws IOException {
        if (o == null) {
            // nothing to do
        } else if (o instanceof DOMStorable) {
            ((DOMStorable) o).write(out);
        } else if (o instanceof String) {
            out.addText((String) o);
        } else if (o instanceof Integer) {
            out.addText(o.toString());
        } else if (o instanceof Long) {
            out.addText(o.toString());
        } else if (o instanceof Double) {
            out.addText(o.toString());
        } else if (o instanceof Float) {
            out.addText(o.toString());
        } else if (o instanceof Boolean) {
            out.addText(o.toString());
        } else if (o instanceof Color) {
            Color c = (Color) o;
            out.addAttribute("rgba", "#" + Integer.toHexString(c.getRGB()));
        } else if (o instanceof byte[]) {
            byte[] a = (byte[]) o;
            for (int i = 0; i < a.length; i++) {
                out.openElement("byte");
                write(out, a[i]);
                out.closeElement();
            }
        } else if (o instanceof boolean[]) {
            boolean[] a = (boolean[]) o;
            for (int i = 0; i < a.length; i++) {
                out.openElement("boolean");
                write(out, a[i]);
                out.closeElement();
            }
        } else if (o instanceof char[]) {
            char[] a = (char[]) o;
            for (int i = 0; i < a.length; i++) {
                out.openElement("char");
                write(out, a[i]);
                out.closeElement();
            }
        } else if (o instanceof short[]) {
            short[] a = (short[]) o;
            for (int i = 0; i < a.length; i++) {
                out.openElement("short");
                write(out, a[i]);
                out.closeElement();
            }
        } else if (o instanceof int[]) {
            int[] a = (int[]) o;
            for (int i = 0; i < a.length; i++) {
                out.openElement("int");
                write(out, a[i]);
                out.closeElement();
            }
        } else if (o instanceof long[]) {
            long[] a = (long[]) o;
            for (int i = 0; i < a.length; i++) {
                out.openElement("long");
                write(out, a[i]);
                out.closeElement();
            }
        } else if (o instanceof float[]) {
            float[] a = (float[]) o;
            for (int i = 0; i < a.length; i++) {
                out.openElement("float");
                write(out, a[i]);
                out.closeElement();
            }
        } else if (o instanceof double[]) {
            double[] a = (double[]) o;
            for (int i = 0; i < a.length; i++) {
                out.openElement("double");
                write(out, a[i]);
                out.closeElement();
            }
        } else if (o instanceof Font) {
            Font f = (Font) o;
            out.addAttribute("name", f.getName());
            out.addAttribute("style", f.getStyle());
            out.addAttribute("size", f.getSize());
        } else if (o instanceof Enum) {
            Enum e = (Enum) o;
            out.addAttribute("type", getEnumName(e));
            out.addText(getEnumValue(e));
        } else {
            throw new IllegalArgumentException("Unsupported object type:" + o);
        }
    }
@Override
    @Nullable
    public Object read(DOMInput in) throws IOException {
        Object o;

        String tagName = in.getTagName();
        if (tagName.equals("null")) {
            o = null;
        } else if (tagName.equals("boolean")) {
            o = Boolean.valueOf(in.getText());
        } else if (tagName.equals("byte")) {
            o = Byte.decode(in.getText());
        } else if (tagName.equals("short")) {
            o = Short.decode(in.getText());
        } else if (tagName.equals("int")) {
            o = Integer.decode(in.getText());
        } else if (tagName.equals("long")) {
            o = Long.decode(in.getText());
        } else if (tagName.equals("float")) {
            o = new Float(Float.parseFloat(in.getText()));
        } else if (tagName.equals("double")) {
            o = new Double(Double.parseDouble(in.getText()));
        } else if (tagName.equals("string")) {
            o = in.getText();
        } else if (tagName.equals("enum")) {
            o = createEnum(in.getAttribute("type", (String) null), in.getText());
        } else if (tagName.equals("color")) {
            o = new Color(in.getAttribute("rgba", 0xff));
        } else if (tagName.equals("font")) {
            o = new Font(in.getAttribute("name", "Dialog"), in.getAttribute("style", 0), in.getAttribute("size", 0));
        } else if (tagName.equals("byteArray")) {
            byte[] a = new byte[in.getElementCount()];
            for (int i = 0; i < a.length; i++) {
                a[i] = ((Byte) in.readObject(i)).byteValue();
            }
            o = a;
        } else if (tagName.equals("shortArray")) {
            short[] a = new short[in.getElementCount()];
            for (int i = 0; i < a.length; i++) {
                a[i] = ((Short) in.readObject(i)).shortValue();
            }
            o = a;
        } else if (tagName.equals("intArray")) {
            int[] a = new int[in.getElementCount()];
            for (int i = 0; i < a.length; i++) {
                a[i] = ((Integer) in.readObject(i)).intValue();
            }
            o = a;
        } else if (tagName.equals("longArray")) {
            long[] a = new long[in.getElementCount()];
            for (int i = 0; i < a.length; i++) {
                a[i] = ((Long) in.readObject(i)).longValue();
            }
            o = a;
        } else if (tagName.equals("floatArray")) {
            float[] a = new float[in.getElementCount()];
            for (int i = 0; i < a.length; i++) {
                a[i] = ((Float) in.readObject(i)).floatValue();
            }
            o = a;
        } else if (tagName.equals("doubleArray")) {
            double[] a = new double[in.getElementCount()];
            for (int i = 0; i < a.length; i++) {
                a[i] = ((Double) in.readObject(i)).doubleValue();
            }
            o = a;
        } else {
            o = create(in.getTagName());
        }
        return o;
    }
}