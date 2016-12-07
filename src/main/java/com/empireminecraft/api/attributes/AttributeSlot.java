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

public enum AttributeSlot {

    MAINHAND(Function.HAND, 0, 0, "mainhand"),
    OFFHAND(Function.HAND, 1, 5, "offhand"),
    FEET(Function.ARMOR, 0, 1, "feet"),
    LEGS(Function.ARMOR, 1, 2, "legs"),
    CHEST(Function.ARMOR, 2, 3, "chest"),
    HEAD(Function.ARMOR, 3, 4, "head")
    ;

    private final Function function;
    private final int inventoryIndex;
    private final int i;
    private final String slotName;

    AttributeSlot(Function function, int i, int dunno, String slotName) {
        this.function = function;
        this.inventoryIndex = i;
        this.i = dunno;
        this.slotName = slotName;
    }

    public Function getFunction() {
        return this.function;
    }

    public int getInventoryIndex() {
        return 100 + this.inventoryIndex;
    }

    public String getSlotName() {
        return this.slotName;
    }

    public static AttributeSlot getSlotByName(String s) {
        AttributeSlot[] aenumitemslot = values();
        int i = aenumitemslot.length;

        for (int j = 0; j < i; ++j) {
            AttributeSlot enumitemslot = aenumitemslot[j];

            if (enumitemslot.getSlotName().equalsIgnoreCase(s)) {
                return enumitemslot;
            }
        }

        throw new IllegalArgumentException("Invalid slot \'" + s + "\'");
    }

    public enum Function {

        HAND, ARMOR;

        Function() {}
    }
}
