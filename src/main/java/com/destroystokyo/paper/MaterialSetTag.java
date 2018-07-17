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

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaterialSetTag implements Tag<Material> {

    private final Set<Material> materials;

    public MaterialSetTag(Predicate<Material> filter) {
        this(Stream.of(Material.values()).filter(filter).collect(Collectors.toList()));
    }

    public MaterialSetTag(Collection<Material> materials) {
        this.materials = Sets.newEnumSet(materials, Material.class);
    }

    public MaterialSetTag(Material... materials) {
        this.materials = Sets.newEnumSet(Lists.newArrayList(materials), Material.class);
    }

    public MaterialSetTag add(MaterialSetTag tags) {
        add(tags.getValues());
        return this;
    }

    public MaterialSetTag add(Material... material) {
        this.materials.addAll(Lists.newArrayList(material));
        return this;
    }

    public MaterialSetTag add(Collection<Material> materials) {
        this.materials.addAll(materials);
        return this;
    }

    public MaterialSetTag endsWith(String with) {
        return add(mat -> mat.name().endsWith(with));
    }


    public MaterialSetTag startsWith(String with) {
        return add(mat -> mat.name().startsWith(with));
    }

    public MaterialSetTag add(Predicate<Material> filter) {
        add(Stream.of(Material.values()).filter(filter).collect(Collectors.toList()));
        return this;
    }

    public MaterialSetTag not(MaterialSetTag tags) {
        not(tags.getValues());
        return this;
    }

    public MaterialSetTag not(Material... material) {
        this.materials.removeAll(Lists.newArrayList(material));
        return this;
    }

    public MaterialSetTag not(Collection<Material> materials) {
        this.materials.removeAll(materials);
        return this;
    }

    public MaterialSetTag not(Predicate<Material> filter) {
        not(Stream.of(Material.values()).filter(filter).collect(Collectors.toList()));
        return this;
    }

    public MaterialSetTag notEndsWith(String with) {
        return not(mat -> mat.name().endsWith(with));
    }


    public MaterialSetTag notStartsWith(String with) {
        return not(mat -> mat.name().startsWith(with));
    }

    public Set<Material> getValues() {
        return this.materials;
    }

    public boolean isTagged(BlockData block) {
        return isTagged(block.getMaterial());
    }

    public boolean isTagged(BlockState block) {
        return isTagged(block.getType());
    }

    public boolean isTagged(Block block) {
        return isTagged(block.getType());
    }

    public boolean isTagged(ItemStack item) {
        return isTagged(item.getType());
    }

    public boolean isTagged(Material material) {
        return this.materials.contains(material);
    }

    public MaterialSetTag ensureSize(String label, int size) {
        long actual = this.materials.stream().filter(((Predicate<Material>) Material::isLegacy).negate()).count();
        if (size != actual) {
            throw new IllegalStateException(label + " - Expected " + size + " materials, got " + actual);
        }
        return this;
    }
}
