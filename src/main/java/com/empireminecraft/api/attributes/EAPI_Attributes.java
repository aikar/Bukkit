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

import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public interface EAPI_Attributes {

    /**
     * Defaults to Operation.ADD_NUMBER
     * @param item
     * @param attr
     * @param val
     */
    default void setAttribute(AttributeSlot slot, ItemStack item, Attribute attr, double val) {
        setAttribute(slot, item, attr, Operation.ADD_NUMBER, val);
    }

    /**
     * Set an attribute to the default respective slot. Unknown items will apply to all slots.
     * @param item
     * @param attr
     * @param operation
     * @param val
     */
    default void setAttribute(ItemStack item, Attribute attr, Operation operation, double val) {
        switch (item.getType()) {
            case DIAMOND_SWORD:
            case DIAMOND_AXE:
            case DIAMOND_PICKAXE:
            case DIAMOND_HOE:
            case DIAMOND_SHOVEL:
            case GOLDEN_SWORD:
            case GOLDEN_AXE:
            case GOLDEN_PICKAXE:
            case GOLDEN_HOE:
            case GOLDEN_SHOVEL:
            case IRON_SWORD:
            case IRON_AXE:
            case IRON_PICKAXE:
            case IRON_HOE:
            case IRON_SHOVEL:
            case BOW:
            case FISHING_ROD:
            case SHEARS:
            case FLINT_AND_STEEL:
                setAttribute(AttributeSlot.MAINHAND, item, attr, operation, val);
                setAttribute(AttributeSlot.OFFHAND, item, attr, operation, val);
                break;
            case SHIELD:
            case TOTEM_OF_UNDYING:
                setAttribute(AttributeSlot.OFFHAND, item, attr, operation, val);
                break;
            case DIAMOND_CHESTPLATE:
            case GOLDEN_CHESTPLATE:
            case IRON_CHESTPLATE:
            case CHAINMAIL_CHESTPLATE:
            case LEATHER_CHESTPLATE:
                setAttribute(AttributeSlot.CHEST, item, attr, operation, val);
                break;
            case DIAMOND_LEGGINGS:
            case GOLDEN_LEGGINGS:
            case IRON_LEGGINGS:
            case CHAINMAIL_LEGGINGS:
            case LEATHER_LEGGINGS:
                setAttribute(AttributeSlot.LEGS, item, attr, operation, val);
                break;
            case DIAMOND_BOOTS:
            case GOLDEN_BOOTS:
            case IRON_BOOTS:
            case CHAINMAIL_BOOTS:
            case LEATHER_BOOTS:
                setAttribute(AttributeSlot.FEET, item, attr, operation, val);
                break;
            case DIAMOND_HELMET:
            case GOLDEN_HELMET:
            case IRON_HELMET:
            case CHAINMAIL_HELMET:
            case LEATHER_HELMET:
            case JACK_O_LANTERN:
                setAttribute(AttributeSlot.HEAD, item, attr, operation, val);
                break;
            default:
                setAttribute(null, item, attr, operation, val);
        }
    }

    void setAttribute(AttributeSlot slot, ItemStack item, Attribute attr, Operation operation, double val);

    /**
     * Remove all of said attribute
     * @param item
     * @param attr
     */
    default void removeAttribute(ItemStack item, Attribute attr) {
        removeAttribute(item, attr, null);
        for (AttributeSlot attributeSlot : AttributeSlot.values()) {
            removeAttribute(item, attr, attributeSlot);
        }
    }

    /**
     * Only remove attribute at the specified slot
     * @param item
     * @param attr
     * @param slot
     */
    void removeAttribute(ItemStack item, Attribute attr, AttributeSlot slot);

    boolean setAttribute(LivingEntity livingEntity, Attribute attr, double val);
    Double getAttribute(LivingEntity livingEntity, Attribute attr);
}
