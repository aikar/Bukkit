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

package com.empireminecraft.api.attributes;

// part of this copied from https://bukkit.org/threads/util-edit-itemstack-attributes-adding-speed-damage-or-health-bonuses.158316/
public enum Operation {
    ADD_NUMBER(0),
    MULTIPLY_PERCENTAGE(1),
    ADD_PERCENTAGE(2);
    private final int id;

    Operation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Operation fromId(int id) {
        // Linear scan is very fast for small N
        for (Operation op : values()) {
            if (op.getId() == id) {
                return op;
            }
        }
        throw new IllegalArgumentException("Corrupt operation ID " + id + " detected.");
    }
}
