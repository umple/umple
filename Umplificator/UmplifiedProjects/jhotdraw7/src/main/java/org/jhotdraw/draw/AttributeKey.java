/*
 * @(#)AttributeKey.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.Serializable;
import java.util.*;
import javax.swing.undo.*;
import org.jhotdraw.util.*;

/**
 * An <em>attribute key</em> provides typesafe access to an attribute of
 * a {@link Figure}.
 * <p>
 * An AttributeKey has a name, a type and a default value. The default value
 * is returned by Figure.get, if a Figure does not have an attribute
 * of the specified key.
 * <p>
 * The following code example shows how to set and get an attribute on a Figure.
 * <pre>
 * Figure aFigure;
 * AttributeKeys.STROKE_COLOR.put(aFigure, Color.blue);
 * </pre>
 * <p>
 * See {@link AttributeKeys} for a list of useful attribute keys.
 * 
 * @author Werner Randelshofer
 * @version $Id: AttributeKey.java 764 2011-09-09 19:57:15Z rawcoder $
 */
public class AttributeKey<T> implements Serializable {

    /**
     * Holds a String representation of the attribute key.
     */
    private String key;
    /**
     * Holds the default value.
     */
    @Nullable private T defaultValue;
    /**
     * Specifies whether null values are allowed.
     */
    private boolean isNullValueAllowed;
    /**
     * Holds labels for the localization of the attribute.
     */
    private ResourceBundleUtil labels;
    /** This variable is used as a "type token" so that we can check for
     * assignability of attribute values at runtime.
     */
    private Class<T> clazz;

    /** Creates a new instance with the specified attribute key, type token class,
     * default value null, and allowing null values. */
    public AttributeKey(String key, Class<T> clazz) {
        this(key, clazz, null, true);
    }

    /** Creates a new instance with the specified attribute key, type token class,
     * and default value, and allowing null values. */
    public AttributeKey(String key, Class<T> clazz, @Nullable T defaultValue) {
        this(key, clazz, defaultValue, true);
    }

    /** Creates a new instance with the specified attribute key, type token class,
     * default value, and allowing or disallowing null values. */
    public AttributeKey(String key, Class<T> clazz, @Nullable T defaultValue, boolean isNullValueAllowed) {
        this(key, clazz, defaultValue, isNullValueAllowed, null);
    }

    /** Creates a new instance with the specified attribute key, type token class,
     * default value, and allowing or disallowing null values. 
     * 
     * @param key The key string. 
     * @param clazz This is used as a "type token" for assignability checks
     * at runtime.
     * @param isNullValueAllowed whether null values are allowed.
     * @param labels ResourceBundle for human friendly representation of this
     * attribute key. The ResourceBundle must have a property named
     * {@code "attribute." + key + ".text"}.
     */
    public AttributeKey(String key, Class<T> clazz, @Nullable T defaultValue, boolean isNullValueAllowed, @Nullable ResourceBundleUtil labels) {
        this.key = key;
        this.clazz = clazz;
        this.defaultValue = defaultValue;
        this.isNullValueAllowed = isNullValueAllowed;
        this.labels = (labels == null) ? ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels") : labels;
    }

    /**
     * Returns the key string.
     * @return key string.
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns a localized human friendly presentation of the key.
     * @return the presentation name of the key.
     */
    public String getPresentationName() {
        return (labels == null) ? key : labels.getString("attribute." + key + ".text");
    }

    /**
     * Returns the default value of the attribute.
     *
     * @return the default value.
     */
    @Nullable
    public T getDefaultValue() {
        return defaultValue;
    }

    /**
     * Gets a clone of the value from the Figure.
     */
    @SuppressWarnings("unchecked")
    @Nullable
    public T getClone(Figure f) {
        T value = f.get(this);
        try {
            return value == null ? null : clazz.cast(Methods.invoke(value, "clone"));
        } catch (NoSuchMethodException ex) {
            InternalError e = new InternalError();
            e.initCause(ex);
            throw e;
        }
    }

    /**
     * Gets the value of the attribute denoted by this AttributeKey from
     * a Figure.
     * 
     * @param f A figure.
     * @return The value of the attribute.
     */
    @Nullable
    public T get(Figure f) {
        return f.get(this);
    }

    /**
     * Gets the value of the attribute denoted by this AttributeKey from
     * a Map.
     * 
     * @param a A Map.
     * @return The value of the attribute.
     */
    @SuppressWarnings("unchecked")
    @Nullable
    public T get(Map<AttributeKey, Object> a) {
        return a.containsKey(this) ? (T) a.get(this) : defaultValue;
    }

    /**
     * Convenience method for setting a value on a Figure.
     * <p>
     * Note: Unlike in previous versions of JHotDraw 7, this method does
     * not call {@code f.willChange()} before setting the value, and
     * {@code f.changed()} afterwards.
     *
     * @param f the Figure
     * @param value the attribute value
     */
    public void set(Figure f, @Nullable T value) {
        if (value == null && !isNullValueAllowed) {
            throw new NullPointerException("Null value not allowed for AttributeKey " + key);
        }
        f.set(this, value);
    }

    /**
     * Sets the attribute and returns an UndoableEditEvent which can be used
     * to undo it.
     * <p>
     * Note: Unlike in previous versions of JHotDraw 7, this method does
     * not call {@code f.willChange()} before setting the value, and
     * {@code f.changed()} afterwards.
     */
    public UndoableEdit setUndoable(final Figure f, @Nullable final T value) {
        if (value == null && !isNullValueAllowed) {
            throw new NullPointerException("Null value not allowed for AttributeKey " + key);
        }

        final Object restoreData = f.getAttributesRestoreData();
        f.set(this, value);

        UndoableEdit edit = new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                return AttributeKey.this.getPresentationName();
            }

            @Override
            public void undo() {
                super.undo();
                f.willChange();
                f.restoreAttributesTo(restoreData);
                f.changed();
            }

            @Override
            public void redo() {
                super.redo();
                f.willChange();
                f.set(AttributeKey.this, value);
                f.changed();
            }
        };
        return edit;

    }

    /**
     * Convenience method for setting a clone of a value on a figure.
     * <p>
     * Note: Unlike in previous versions of JHotDraw 7, this method does
     * not call {@code f.willChange()} before setting the value, and
     * {@code f.changed()} afterwards.
     *
     * @param f the Figure
     * @param value the attribute value
     */
    public void setClone(Figure f, @Nullable T value) {
        try {
            f.set(this, value == null ? null : clazz.cast(Methods.invoke(value, "clone")));

        } catch (NoSuchMethodException ex) {
            InternalError e = new InternalError();
            e.initCause(ex);
            throw e;
        }
    }

    /**
     * Convenience method for putting a clone of a value on a map.
     *
     * @param a the map
     * @param value the attribute value
     */
    public void putClone(Map<AttributeKey, Object> a, @Nullable T value) {
        try {
            put(a, value == null ? null : clazz.cast(Methods.invoke(value, "clone")));

        } catch (NoSuchMethodException ex) {
            InternalError e = new InternalError();
            e.initCause(ex);
            throw e;
        }
    }

    /**
     * Use this method to perform a type-safe put operation of an attribute
     * into a Map.
     *
     * @param a An attribute map.
     * @param value The new value.
     * @return The old value.
     */
    @SuppressWarnings("unchecked")
    @Nullable
    public T put(Map<AttributeKey, Object> a, @Nullable T value) {
        if (value == null && !isNullValueAllowed) {
            throw new NullPointerException("Null value not allowed for AttributeKey " + key);
        }
        return (T) a.put(this, value);
    }

    /**
     * Returns true if null values are allowed.
     * @return true if null values are allowed.
     */
    public boolean isNullValueAllowed() {
        return isNullValueAllowed;
    }

    /**
     * Returns true if the specified value is assignable with this key.
     *
     * @param value
     * @return True if assignable.
     */
    public boolean isAssignable(@Nullable Object value) {
        if (value == null) {
            return isNullValueAllowed();
        }

        return clazz.isInstance(value);
    }

    /** Returns the key string. */
    @Override
    public String toString() {
        return key;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof AttributeKey) {
            return ((AttributeKey) that).key.equals(this.key);
        }
        return false;
    }
}
