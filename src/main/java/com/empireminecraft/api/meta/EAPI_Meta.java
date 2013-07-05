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

import com.empireminecraft.api.Vector3i;
import com.empireminecraft.api.meta.MetaKey.TempKey;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

import java.util.Map;

public interface EAPI_Meta {
    PersistentMetaMap getTileEntityMetaMap(BlockState tileEntity, boolean isWrite);

    PersistentMetaMap getBlockMetaMap(Location loc, boolean isWrite);

    PersistentMetaMap getChunkMetaMap(Chunk chunk, boolean isWrite);

    TempMetaMap getChunkTempMetaMap(Chunk chunk, boolean isWrite);

    Map<Vector3i,PersistentMetaMap> getChunkMetaData(Chunk chunk);

    PersistentMetaMap getEntityMetaMap(Entity entity, boolean isWrite);

    PersistentMetaMap getWorldMetaMap(World world);

    Map<String,Object> getBlockTempMeta(Block block, boolean b);
}
