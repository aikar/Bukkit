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

package com.destroystokyo.paper;

import org.bukkit.Material;

public class Tags {
    /**
     * Cover all 16 colors of beds.
     */
    public static final MaterialSetTag BEDS = new MaterialSetTag()
        .endsWith("_BED")
        .ensureSize("BEDS", 16);

    /**
     * Covers all 16 dyes.
     */
    public static final MaterialSetTag DYES = new MaterialSetTag()
        .endsWith("_DYE")
        .add(Material.INK_SAC)
        .ensureSize("DYES", 16);

    /**
     * Covers all 6 wood variants and nether brick fence.
     */
    public static final MaterialSetTag FENCES = new MaterialSetTag()
        .endsWith("_FENCE")
        .ensureSize("FENCES", 7);

    /**
     * Covers the non-colored glass and 16 stained glass (not panes).
     */
    public static final MaterialSetTag GLASS = new MaterialSetTag()
        .endsWith("_GLASS")
        .ensureSize("GLASS", 17);

    /**
     * Covers the non-colored glass panes and 16 stained glass panes (panes only).
     */
    public static final MaterialSetTag GLASS_PANES = new MaterialSetTag()
        .endsWith("_GLASS_PANE")
        .ensureSize("GLASS_PANES", 17);

    /**
     * Covers all 6 wooden pressure plates and the 2 weighted pressure plates.
     */
    public static final MaterialSetTag PRESSURE_PLATES = new MaterialSetTag()
        .endsWith("_PRESSURE_PLATE")
        .ensureSize("PRESSURE_PLATES", 8);

    /**
     * Covers the non-colored and 16 colored shulker boxes.
     */
    public static final MaterialSetTag SHULKER_BOXES = new MaterialSetTag()
        .endsWith("_SHULKER_BOX")
        .ensureSize("SHULKER_BOXES", 34);

    /**
     * Covers zombie, creeper, skeleton, dragon, and player heads.
     */
    public static final MaterialSetTag SKULLS = new MaterialSetTag()
        .endsWith("_HEAD")
        .endsWith("_SKULL")
        .ensureSize("SKULLS", 12);

    /**
     * Covers all spawn egg items.
     */
    public static final MaterialSetTag SPAWN_EGGS = new MaterialSetTag()
        .endsWith("_SPAWN_EGG");

    /**
     * Covers all 6 wood variants of gates.
     */
    public static final MaterialSetTag WOODEN_GATES = new MaterialSetTag()
        .endsWith("_GATE")
        .ensureSize("WOODEN_GATES", 6);

    /**
     * Covers all 6 wood variants of trapdoors.
     */
    public static final MaterialSetTag WOODEN_TRAPDOORS = new MaterialSetTag()
        .endsWith("_TRAPDOOR")
        .ensureSize("WOODEN_TRAPDOORS", 6);
}
