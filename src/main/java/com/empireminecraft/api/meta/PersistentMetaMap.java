/*
 * Copyright (c) 2016 Starlis LLC / Daniel Ennis (Aikar) - MIT License
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

import com.empireminecraft.api.meta.MetaKey.PersistentKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.security.InvalidParameterException;
import java.util.Map;

/**
 * A type protected hashmap for storing meta values
 */
@SuppressWarnings("PublicInnerClass")
public class PersistentMetaMap extends MetaMap<PersistentKey> {


    public <T extends PersistentMetaMap> T put(PersistentKey key, PersistentMetaMap value) {
        if (!Meta.isValidPersistentMeta(value)) {
            throw new InvalidParameterException();
        }
        return (T) super.put(key, value);
    }
    public <Z, T extends PersistentMetaList<Z>> T put(PersistentKey key, PersistentMetaList<Z> value) {
        if (!Meta.isValidPersistentMeta(value)) {
            throw new InvalidParameterException();
        }
        return (T) super.put(key, value);
    }
    public <T extends ItemStack> T put(PersistentKey key, ItemStack value) {
        return (T) super.put(key, value);
    }
    public <T extends Number> T put(PersistentKey key, Number value) {
        return (T) super.put(key, value);
    }
    public <T extends String> T put(PersistentKey key, String value) {
        return (T) super.put(key, value);
    }
    public <T extends String> T put(PersistentKey key, boolean value) {
        return (T) super.put(key, value ? 1 : 0);
    }

    public Object put(@Nonnull PersistentKey key, Object value) {
        return put(key.key(), value);
    }

    @Override
    public void putAll(Map<? extends String, ?> map) {
        for (Object value : map.values()) {
            if (!Meta.isValidPersistentMeta(value)) {
                throw new InvalidParameterException();
            }
        }

        super.putAll(map);
    }

    @Override
    public Object put(String key, Object value) {
        if (!Meta.isValidPersistentMeta(value)) {
            throw new InvalidParameterException();
        }
        return super.put(key, value);
    }

    public PersistentMetaMap clone() {
        PersistentMetaMap map = new PersistentMetaMap();
        map.putAll(this);
        return map;
    }
}
