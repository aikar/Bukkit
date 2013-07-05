/*
 * Copyright (c) 2018 Daniel Ennis (Aikar) MIT License
 *
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.empireminecraft.api.meta;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class MetaMap <K extends MetaKey> extends HashMap<String, Object> {

    public MetaMap() {
        super(0);
    }

    public Integer getInteger(@Nonnull K key) {
        return getInteger(key, null);
    }
    public Integer getInteger(@Nonnull K key, Integer def) {
        Number number = (Number) get(key);
        return number != null ? number.intValue() : def;
    }
    public Long getLong(@Nonnull K key) {
        return getLong(key, null);
    }
    public Long getLong(@Nonnull K key, Long def) {
        Number number = (Number) get(key);
        return number != null ? number.longValue() : def;
    }
    public Double getDouble(@Nonnull K key) {
        return getDouble(key, null);
    }
    public Double getDouble(@Nonnull K key, Double def) {
        Number number = (Number) get(key);
        return number != null ? number.doubleValue() : def;
    }
    public Float getFloat(@Nonnull K key) {
        return getFloat(key, null);
    }
    public Float getFloat(@Nonnull K key, Float def) {
        Number number = (Number) get(key);
        return number != null ? number.floatValue() : def;
    }
    public Short getShort(@Nonnull K key) {
        return getShort(key, null);
    }
    public Short getShort(@Nonnull K key, Short def) {
        Number number = (Number) get(key);
        return number != null ? number.shortValue() : def;
    }
    public Boolean getBoolean(@Nonnull K key) {
        return getBoolean(key, null);
    }
    public Boolean getBoolean(@Nonnull K key, Boolean def) {
        Number number = (Number) get(key);
        return number != null ? number.intValue() != 0 : def;
    }
    public <T> T getValue(@Nonnull K key) {
        return (T) get(key);
    }
    public <T> T getValue(@Nonnull K key, T def) {
        Object value = get(key);
        return value != null ? (T) value : def;
    }

    public Object get(K key) {
        return get(key.key());
    }

    public Object put(MetaKey key, Object value) {
        return put(key.key(), value);
    }

    public boolean containsKey(K key) {
        return containsKey(key.key());
    }
}
