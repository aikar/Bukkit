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

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * A type protected array for storing meta values
 */
@SuppressWarnings("PublicInnerClass")
public class PersistentMetaList<T> extends ArrayList<T> {
    public PersistentMetaList(int initialCapacity) {
        super(initialCapacity);
    }

    public PersistentMetaList() {
    }

    public PersistentMetaList(Collection<? extends T> c) {
        super(c);
    }

    @Override
    public boolean add(T o) {
        if (!Meta.isValidPersistentMeta(o)) {
            throw new InvalidParameterException();
        }
        return super.add(o);
    }

    @Override
    public T set(int index, T element) {
        if (!Meta.isValidPersistentMeta(element)) {
            throw new InvalidParameterException();
        }
        return super.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        if (!Meta.isValidPersistentMeta(element)) {
            throw new InvalidParameterException();
        }
        super.add(index, element);
    }

    public PersistentMetaList<T> clone()  {
        return new PersistentMetaList<>(this);
    }
}
