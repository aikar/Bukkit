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

import com.empireminecraft.api.API;
import com.empireminecraft.api.Vector3i;
import com.empireminecraft.api.meta.MetaKey.PersistentKey;
import com.empireminecraft.api.meta.MetaKey.TempKey;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class Meta {
    private Meta() {}

    //////////////////////////////////////////////////
    //// UTIL & KEYS
    //////////////////////////////////////////////////

    public static TempKey createTempKey(String key) {
        return new TempKeyImpl(key);
    }
    public static PersistentKey createPersistentKey(String key) {
        return new PersistentKeyImpl(key);
    }

    /**
     * Checks if the passed object can be stored as Meta Data
     * @param value
     * @return
     */
    public static boolean isValidPersistentMeta(Object value) {
        return (value instanceof String) || (value instanceof Long) ||
            (value instanceof Integer) || (value instanceof ItemStack) ||
            (value instanceof Float) || (value instanceof Double) ||
            (value instanceof PersistentMetaMap) || (value instanceof PersistentMetaList);
    }

    /**
     * General method for determining if value is null to remove it, else set.
     * Return previous value
     *
     * @param map
     * @param key
     * @param val
     * @param <T>
     * @return
     */
    private static <T, K extends MetaKey> T setMetaMapValue(MetaMap<K> map, K key, Object val) {
        if (map == null) {
            return null;
        }
        if (val == null) {
            return (T) map.remove(key.key());
        } else {
            return (T) map.put(key.key(), val);
        }
    }


    //////////////////////////////////////////////////
    //// PERSISTENT WORLD META
    //////////////////////////////////////////////////

    public static PersistentMetaMap getWorldPersistentMetaMap(World world) {
        return world != null ? API.meta.getWorldMetaMap(world) : null;
    }

    public static <T> T getWorldMeta(World world, PersistentKey key) {
        return getWorldMeta(world, key, null);
    }

    public static <T> T getWorldMeta(World world, PersistentKey key, T def) {
        final PersistentMetaMap worldMetaMap = getWorldPersistentMetaMap(world);
        T ret = worldMetaMap != null && !worldMetaMap.isEmpty() ? (T) worldMetaMap.get(key.key()) : null;
        return ret != null ? ret : def;
    }

    public static boolean hasWorldMeta(World world, PersistentKey key) {
        final PersistentMetaMap worldMetaMap = getWorldPersistentMetaMap(world);
        return worldMetaMap != null && !worldMetaMap.isEmpty() && worldMetaMap.containsKey(key.key());
    }

    public static <T> T setWorldMeta(World world, PersistentKey key, Object val) {
        return setMetaMapValue(getWorldPersistentMetaMap(world), key, val);
    }

    public static <T> T removeWorldMeta(World world, PersistentKey key) {
        return setWorldMeta(world, key, null);
    }

    public static Integer getIntegerWorldMeta(World world, PersistentKey key) {
        Number worldMeta = getWorldMeta(world, key, null);
        return worldMeta != null ? worldMeta.intValue() : null;
    }
    public static Integer getIntegerWorldMeta(World world, PersistentKey key, Integer def) {
        Number worldMeta = getWorldMeta(world, key, def);
        return worldMeta != null ? worldMeta.intValue() : def;
    }
    public static Long getLongWorldMeta(World world, PersistentKey key) {
        Number worldMeta = getWorldMeta(world, key, null);
        return worldMeta != null ? worldMeta.longValue() : null;
    }
    public static Long getLongWorldMeta(World world, PersistentKey key, Long def) {
        Number worldMeta = getWorldMeta(world, key, def);
        return worldMeta != null ? worldMeta.longValue() : def;
    }
    public static Double getDoubleWorldMeta(World world, PersistentKey key) {
        Number worldMeta = getWorldMeta(world, key, null);
        return worldMeta != null ? worldMeta.doubleValue() : null;
    }
    public static Double getDoubleWorldMeta(World world, PersistentKey key, Double def) {
        Number worldMeta = getWorldMeta(world, key, def);
        return worldMeta != null ? worldMeta.doubleValue() : def;
    }
    public static Float getFloatWorldMeta(World world, PersistentKey key) {
        Number worldMeta = getWorldMeta(world, key, null);
        return worldMeta != null ? worldMeta.floatValue() : null;
    }
    public static Float getFloatWorldMeta(World world, PersistentKey key, Float def) {
        Number worldMeta = getWorldMeta(world, key, def);
        return worldMeta != null ? worldMeta.floatValue() : def;
    }


    public static double incrementWorldMeta(World world, PersistentKey key, double val) {
        return incrementWorldMeta(world, key, val, 0D);
    }

    public static double incrementWorldMeta(World world, PersistentKey key, double val, double start) {
        Number orig = getWorldMeta(world, key, start);
        setWorldMeta(world, key, orig.doubleValue() + val);
        return orig.doubleValue();
    }
    
    //////////////////////////////////////////////////
    //// PERSISTENT ENTITY META
    //////////////////////////////////////////////////

    public static PersistentMetaMap getEntityPersistentMetaMap(Entity entity, boolean isWrite) {
        return entity != null ? API.meta.getEntityMetaMap(entity, isWrite) : null;
    }

    public static <T> T getEntityMeta(Entity entity, PersistentKey key) {
        return getEntityMeta(entity, key, null);
    }

    public static <T> T getEntityMeta(Entity entity, PersistentKey key, T def) {
        final PersistentMetaMap entityMetaMap = getEntityPersistentMetaMap(entity, false);
        T ret = entityMetaMap != null && !entityMetaMap.isEmpty() ? (T) entityMetaMap.get(key.key()) : null;
        return ret != null ? ret : def;
    }

    public static boolean hasEntityMeta(Entity entity, PersistentKey key) {
        final PersistentMetaMap entityMetaMap = getEntityPersistentMetaMap(entity, false);
        return entityMetaMap != null && !entityMetaMap.isEmpty() && entityMetaMap.containsKey(key.key());
    }

    public static <T> T setEntityMeta(Entity entity, PersistentKey key, Object val) {
        return setMetaMapValue(getEntityPersistentMetaMap(entity, true), key, val);
    }

    public static <T> T removeEntityMeta(Entity entity, PersistentKey key) {
        return setMetaMapValue(getEntityPersistentMetaMap(entity, false), key, null);
    }

    public static Integer getIntegerEntityMeta(Entity entity, PersistentKey key) {
        Number entityMeta = getEntityMeta(entity, key, null);
        return entityMeta != null ? entityMeta.intValue() : null;
    }
    public static Integer getIntegerEntityMeta(Entity entity, PersistentKey key, Integer def) {
        Number entityMeta = getEntityMeta(entity, key, def);
        return entityMeta != null ? entityMeta.intValue() : def;
    }
    public static Long getLongEntityMeta(Entity entity, PersistentKey key) {
        Number entityMeta = getEntityMeta(entity, key, null);
        return entityMeta != null ? entityMeta.longValue() : null;
    }
    public static Long getLongEntityMeta(Entity entity, PersistentKey key, Long def) {
        Number entityMeta = getEntityMeta(entity, key, def);
        return entityMeta != null ? entityMeta.longValue() : def;
    }
    public static Double getDoubleEntityMeta(Entity entity, PersistentKey key) {
        Number entityMeta = getEntityMeta(entity, key, null);
        return entityMeta != null ? entityMeta.doubleValue() : null;
    }
    public static Double getDoubleEntityMeta(Entity entity, PersistentKey key, Double def) {
        Number entityMeta = getEntityMeta(entity, key, def);
        return entityMeta != null ? entityMeta.doubleValue() : def;
    }
    public static Float getFloatEntityMeta(Entity entity, PersistentKey key) {
        Number entityMeta = getEntityMeta(entity, key, null);
        return entityMeta != null ? entityMeta.floatValue() : null;
    }
    public static Float getFloatEntityMeta(Entity entity, PersistentKey key, Float def) {
        Number entityMeta = getEntityMeta(entity, key, def);
        return entityMeta != null ? entityMeta.floatValue() : def;
    }


    public static double incrementEntityMeta(Entity entity, PersistentKey key, double val) {
        return incrementEntityMeta(entity, key, val, 0D);
    }

    public static double incrementEntityMeta(Entity entity, PersistentKey key, double val, double start) {
        Number orig = getEntityMeta(entity, key, start);
        setEntityMeta(entity, key, orig.doubleValue() + val);
        return orig.doubleValue();
    }

    //////////////////////////////////////////////////
    //// PERSISTENT CHUNK META
    //////////////////////////////////////////////////

    /**
     * Only provided for low level access as debug command
     * @param chunk
     * @return
     */
    @Deprecated
    public static Map<Vector3i, PersistentMetaMap> getChunkMetaData(Chunk chunk) {
        return API.meta.getChunkMetaData(chunk);
    }

    public static PersistentMetaMap getChunkPersistentMetaMap(Chunk chunk, boolean isWrite) {
        return chunk != null ? API.meta.getChunkMetaMap(chunk, isWrite) : null;
    }

    public static boolean hasChunkMeta(Chunk chunk, PersistentKey key) {
        final PersistentMetaMap chunkMetaMap = getChunkPersistentMetaMap(chunk, false);
        return chunkMetaMap != null && !chunkMetaMap.isEmpty() && chunkMetaMap.containsKey(key.key());
    }

    public static <T> T getChunkMeta(Chunk chunk, PersistentKey key) {
        return getChunkMeta(chunk, key, null);
    }

    public static <T> T getChunkMeta(Chunk chunk, PersistentKey key, T def) {
        final PersistentMetaMap chunkMetaMap = getChunkPersistentMetaMap(chunk, false);
        T ret = chunkMetaMap != null && !chunkMetaMap.isEmpty() ? (T) getChunkPersistentMetaMap(chunk, false).get(key.key()) : null;
        return ret != null ? ret : def;
    }

    public static <T> T setChunkMeta(Chunk chunk, PersistentKey key, Object val) {
        return setMetaMapValue(getChunkPersistentMetaMap(chunk, true), key, val);
    }

    public static <T> T removeChunkMeta(Chunk chunk, PersistentKey key) {
        return setMetaMapValue(getChunkPersistentMetaMap(chunk, false), key, null);
    }
    public static Integer getIntegerChunkMeta(Chunk chunk, PersistentKey key) {
        Number chunkMeta = getChunkMeta(chunk, key, null);
        return chunkMeta != null ? chunkMeta.intValue() : null;
    }
    public static Integer getIntegerChunkMeta(Chunk chunk, PersistentKey key, Integer def) {
        Number chunkMeta = getChunkMeta(chunk, key, def);
        return chunkMeta != null ? chunkMeta.intValue() : def;
    }
    public static Long getLongChunkMeta(Chunk chunk, PersistentKey key) {
        Number chunkMeta = getChunkMeta(chunk, key, null);
        return chunkMeta != null ? chunkMeta.longValue() : null;
    }
    public static Long getLongChunkMeta(Chunk chunk, PersistentKey key, Long def) {
        Number chunkMeta = getChunkMeta(chunk, key, def);
        return chunkMeta != null ? chunkMeta.longValue() : def;
    }
    public static Double getDoubleChunkMeta(Chunk chunk, PersistentKey key) {
        Number chunkMeta = getChunkMeta(chunk, key, null);
        return chunkMeta != null ? chunkMeta.doubleValue() : null;
    }
    public static Double getDoubleChunkMeta(Chunk chunk, PersistentKey key, Double def) {
        Number chunkMeta = getChunkMeta(chunk, key, def);
        return chunkMeta != null ? chunkMeta.doubleValue() : def;
    }
    public static Float getFloatChunkMeta(Chunk chunk, PersistentKey key) {
        Number chunkMeta = getChunkMeta(chunk, key, null);
        return chunkMeta != null ? chunkMeta.floatValue() : null;
    }
    public static Float getFloatChunkMeta(Chunk chunk, PersistentKey key, Float def) {
        Number chunkMeta = getChunkMeta(chunk, key, def);
        return chunkMeta != null ? chunkMeta.floatValue() : def;
    }


    public static Long incrementChunkMeta(Chunk chunk, PersistentKey key, Long amount) {
        return incrementChunkMeta(chunk, key, amount, 0L);
    }
    public static Long incrementChunkMeta(Chunk chunk, PersistentKey key, Long amount, Long start) {
        Long val = getChunkMeta(chunk, key);
        Long origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setChunkMeta(chunk, key, val);
        return val;
    }

    public static Double incrementChunkMeta(Chunk chunk, PersistentKey key, Double amount) {
        return incrementChunkMeta(chunk, key, amount, 0D);
    }
    public static Double incrementChunkMeta(Chunk chunk, PersistentKey key, Double amount, Double start) {
        Double val = getChunkMeta(chunk, key);
        Double origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setChunkMeta(chunk, key, val);
        return val;
    }
    //////////////////////////////////////////////////
    //// PERSISTENT BLOCK META
    //////////////////////////////////////////////////

    public static PersistentMetaMap getBlockPersistentMetaMap(Location loc, boolean isWrite) {
        return loc != null ? API.meta.getBlockMetaMap(loc, isWrite) : null;
    }

    public static boolean hasBlockMeta(Location loc, PersistentKey key) {
        final PersistentMetaMap blockMetaMap = getBlockPersistentMetaMap(loc, false);
        return blockMetaMap != null && !blockMetaMap.isEmpty() && blockMetaMap.containsKey(key.key());
    }

    public static <T> T getBlockMeta(Location loc, PersistentKey key) {
        return getBlockMeta(loc, key, null);
    }

    public static <T> T getBlockMeta(Location loc, PersistentKey key, T def) {
        final PersistentMetaMap blockMetaMap = getBlockPersistentMetaMap(loc, false);
        T ret = blockMetaMap != null && !blockMetaMap.isEmpty() ? (T) blockMetaMap.get(key.key()) : null;
        return ret != null ? ret : def;
    }

    public static <T> T setBlockMeta(Location loc, PersistentKey key, Object val) {
        return setMetaMapValue(getBlockPersistentMetaMap(loc, true), key, val);
    }

    public static <T> T removeBlockMeta(Location loc, PersistentKey key) {
        return setMetaMapValue(getBlockPersistentMetaMap(loc, false), key, null);
    }

    public static Integer getIntegerBlockMeta(Location loc, PersistentKey key) {
        Number blockMeta = getBlockMeta(loc, key, null);
        return blockMeta != null ? blockMeta.intValue() : null;
    }
    public static Integer getIntegerBlockMeta(Location loc, PersistentKey key, Integer def) {
        Number blockMeta = getBlockMeta(loc, key, def);
        return blockMeta != null ? blockMeta.intValue() : def;
    }
    public static Long getLongBlockMeta(Location loc, PersistentKey key) {
        Number blockMeta = getBlockMeta(loc, key, null);
        return blockMeta != null ? blockMeta.longValue() : null;
    }
    public static Long getLongBlockMeta(Location loc, PersistentKey key, Long def) {
        Number blockMeta = getBlockMeta(loc, key, def);
        return blockMeta != null ? blockMeta.longValue() : def;
    }
    public static Double getDoubleBlockMeta(Location loc, PersistentKey key) {
        Number blockMeta = getBlockMeta(loc, key, null);
        return blockMeta != null ? blockMeta.doubleValue() : null;
    }
    public static Double getDoubleBlockMeta(Location loc, PersistentKey key, Double def) {
        Number blockMeta = getBlockMeta(loc, key, def);
        return blockMeta != null ? blockMeta.doubleValue() : def;
    }
    public static Float getFloatBlockMeta(Location loc, PersistentKey key) {
        Number blockMeta = getBlockMeta(loc, key, null);
        return blockMeta != null ? blockMeta.floatValue() : null;
    }
    public static Float getFloatBlockMeta(Location loc, PersistentKey key, Float def) {
        Number blockMeta = getBlockMeta(loc, key, def);
        return blockMeta != null ? blockMeta.floatValue() : def;
    }


    public static Long incrementBlockMeta(Location loc, PersistentKey key, Long amount) {
        return incrementBlockMeta(loc, key, amount, 0L);
    }
    public static Long incrementBlockMeta(Location loc, PersistentKey key, Long amount, Long start) {
        Long val = getBlockMeta(loc, key);
        Long origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setBlockMeta(loc, key, val);
        return val;
    }

    public static Double incrementBlockMeta(Location loc, PersistentKey key, Double amount) {
        return incrementBlockMeta(loc, key, amount, 0D);
    }
    public static Double incrementBlockMeta(Location loc, PersistentKey key, Double amount, Double start) {
        Double val = getBlockMeta(loc, key);
        Double origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setBlockMeta(loc, key, val);
        return val;
    }

    //////////////////////////////////////////////////
    //// PERSISTENT TILE ENTITY META
    //////////////////////////////////////////////////

    public static PersistentMetaMap getTileEntityPersistentMetaMap(Location tileEntity, boolean isWrite) {
        return API.meta.getTileEntityMetaMap(tileEntity.getBlock().getState(), isWrite);
    }

    public static PersistentMetaMap getTileEntityPersistentMetaMap(BlockState tileEntity, boolean isWrite) {
        return API.meta.getTileEntityMetaMap(tileEntity, isWrite);
    }

    public static boolean hasTileEntityMeta(Location tileEntity, PersistentKey key) {
        return hasTileEntityMeta(tileEntity.getBlock().getState(), key);
    }

    public static boolean hasTileEntityMeta(BlockState tileEntity, PersistentKey key) {
        final PersistentMetaMap tileEntityMetaMap = getTileEntityPersistentMetaMap(tileEntity, false);
        return tileEntityMetaMap != null && !tileEntityMetaMap.isEmpty() && tileEntityMetaMap.containsKey(key.key());
    }

    public static <T> T getTileEntityMeta(Location tileEntity, PersistentKey key) {
        return getTileEntityMeta(tileEntity.getBlock().getState(), key, null);
    }

    public static <T> T getTileEntityMeta(BlockState tileEntity, PersistentKey key) {
        return getTileEntityMeta(tileEntity, key, null);
    }

    public static <T> T getTileEntityMeta(Location tileEntity, PersistentKey key, T def) {
        return getTileEntityMeta(tileEntity.getBlock().getState(), key, def);
    }

    public static <T> T getTileEntityMeta(BlockState tileEntity, PersistentKey key, T def) {
        final PersistentMetaMap tileEntityMetaMap = getTileEntityPersistentMetaMap(tileEntity, false);
        T ret = tileEntityMetaMap != null && !tileEntityMetaMap.isEmpty() ? (T) tileEntityMetaMap.get(key.key()) : null;
        return ret != null ? ret : def;
    }

    public static <T> T setTileEntityMeta(Location tileEntity, PersistentKey key, Object val) {
        return setTileEntityMeta(tileEntity.getBlock().getState(), key, val);
    }

    public static <T> T setTileEntityMeta(BlockState tileEntity, PersistentKey key, Object val) {
        return setMetaMapValue(getTileEntityPersistentMetaMap(tileEntity, true), key, val);
    }

    public static <T> T removeTileEntityMeta(Location tileEntity, PersistentKey key) {
        return removeTileEntityMeta(tileEntity.getBlock().getState(), key);
    }

    public static <T> T removeTileEntityMeta(BlockState tileEntity, PersistentKey key) {
        return setMetaMapValue(getTileEntityPersistentMetaMap(tileEntity, false), key, null);
    }

    //////////////////////////////////////////////////
    //// TEMP ENTITY META
    //////////////////////////////////////////////////

    public static TempMetaMap getEntityTempMetaMap(Entity entity) {
        return entity != null ? entity.getTempMeta() : null;
    }

    public static boolean hasEntityMeta(Entity entity, TempKey key) {
        TempMetaMap metaMap = getEntityTempMetaMap(entity);
        if (metaMap == null) {
            return false;
        }
        return metaMap.containsKey(key.key());
    }

    public static <T> T setEntityMeta(Entity entity, TempKey key, Object val) {
        TempMetaMap metaMap = getEntityTempMetaMap(entity);
        if (metaMap == null) {
            return null;
        }
        return (T) metaMap.put(key.key(), val);
    }


    public static <T> T removeEntityMeta(Entity entity, TempKey key) {
        TempMetaMap metaMap = getEntityTempMetaMap(entity);
        if (metaMap == null) {
            return null;
        }
        return (T) metaMap.remove(key.key());
    }

    public static <T> T getEntityMeta(Entity entity, TempKey key) {
        return getEntityMeta(entity, key, null);
    }

    public static <T> T getEntityMeta(Entity entity, TempKey key, T def) {
        TempMetaMap metaMap = getEntityTempMetaMap(entity);
        if (metaMap == null) {
            return def;
        }
        Object val = metaMap.get(key.key());
        if (val != null) {
            return (T) val;
        }
        return def;
    }

    public static Integer getIntegerEntityMeta(Entity entity, TempKey key) {
        Number entityMeta = getEntityMeta(entity, key, null);
        return entityMeta != null ? entityMeta.intValue() : null;
    }
    public static Integer getIntegerEntityMeta(Entity entity, TempKey key, Integer def) {
        Number entityMeta = getEntityMeta(entity, key, def);
        return entityMeta != null ? entityMeta.intValue() : def;
    }
    public static Long getLongEntityMeta(Entity entity, TempKey key) {
        Number entityMeta = getEntityMeta(entity, key, null);
        return entityMeta != null ? entityMeta.longValue() : null;
    }
    public static Long getLongEntityMeta(Entity entity, TempKey key, Long def) {
        Number entityMeta = getEntityMeta(entity, key, def);
        return entityMeta != null ? entityMeta.longValue() : def;
    }
    public static Double getDoubleEntityMeta(Entity entity, TempKey key) {
        Number entityMeta = getEntityMeta(entity, key, null);
        return entityMeta != null ? entityMeta.doubleValue() : null;
    }
    public static Double getDoubleEntityMeta(Entity entity, TempKey key, Double def) {
        Number entityMeta = getEntityMeta(entity, key, def);
        return entityMeta != null ? entityMeta.doubleValue() : def;
    }
    public static Float getFloatEntityMeta(Entity entity, TempKey key) {
        Number entityMeta = getEntityMeta(entity, key, null);
        return entityMeta != null ? entityMeta.floatValue() : null;
    }
    public static Float getFloatEntityMeta(Entity entity, TempKey key, Float def) {
        Number entityMeta = getEntityMeta(entity, key, def);
        return entityMeta != null ? entityMeta.floatValue() : def;
    }

    public static Long incrementEntityMeta(Entity entity, TempKey key, Long amount) {
        return incrementEntityMeta(entity, key, amount, 0L);
    }
    public static Long incrementEntityMeta(Entity entity, TempKey key, Long amount, Long start) {
        Long val = getEntityMeta(entity, key);
        Long origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setEntityMeta(entity, key, val);
        return val;
    }

    public static Double incrementEntityMeta(Entity entity, TempKey key, Double amount) {
        return incrementEntityMeta(entity, key, amount, 0D);
    }
    public static Double incrementEntityMeta(Entity entity, TempKey key, Double amount, Double start) {
        Double val = getEntityMeta(entity, key);
        Double origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setEntityMeta(entity, key, val);
        return val;
    }



    //////////////////////////////////////////////////
    //// TEMP BLOCK META
    //////////////////////////////////////////////////

    public static boolean hasBlockMeta(Block block, TempKey key) {
        Map<String, Object> blockMeta = API.meta.getBlockTempMeta(block, false);
        return blockMeta != null && blockMeta.containsKey(key.key());
    }

    public static <T> T setBlockMeta(Block block, TempKey key, Object val) {
        Map<String, Object> blockMeta = API.meta.getBlockTempMeta(block, true);
        return (T) blockMeta.put(key.key(), val);
    }

    public static <T> T removeBlockMeta(Block block, TempKey key) {
        Map<String, Object> blockMeta = API.meta.getBlockTempMeta(block, true);
        return (T) blockMeta.remove(key.key());
    }

    public static <T> T getBlockMeta(Block block, TempKey key) {
        return getBlockMeta(block, key, null);
    }

    public static <T> T getBlockMeta(Block block, TempKey key, T def) {
        Map<String, Object> blockMeta = API.meta.getBlockTempMeta(block, false);
        if (blockMeta == null) {
            return null;
        }
        Object val = blockMeta.get(key.key());
        if (val != null) {
            return (T) val;
        }
        return def;
    }

    public static Integer getIntegerBlockMeta(Block block, TempKey key) {
        Number blockMeta = getBlockMeta(block, key, null);
        return blockMeta != null ? blockMeta.intValue() : null;
    }
    public static Integer getIntegerBlockMeta(Block block, TempKey key, Integer def) {
        Number blockMeta = getBlockMeta(block, key, def);
        return blockMeta != null ? blockMeta.intValue() : def;
    }
    public static Long getLongBlockMeta(Block block, TempKey key) {
        Number blockMeta = getBlockMeta(block, key, null);
        return blockMeta != null ? blockMeta.longValue() : null;
    }
    public static Long getLongBlockMeta(Block block, TempKey key, Long def) {
        Number blockMeta = getBlockMeta(block, key, def);
        return blockMeta != null ? blockMeta.longValue() : def;
    }
    public static Double getDoubleBlockMeta(Block block, TempKey key) {
        Number blockMeta = getBlockMeta(block, key, null);
        return blockMeta != null ? blockMeta.doubleValue() : null;
    }
    public static Double getDoubleBlockMeta(Block block, TempKey key, Double def) {
        Number blockMeta = getBlockMeta(block, key, def);
        return blockMeta != null ? blockMeta.doubleValue() : def;
    }
    public static Float getFloatBlockMeta(Block block, TempKey key) {
        Number blockMeta = getBlockMeta(block, key, null);
        return blockMeta != null ? blockMeta.floatValue() : null;
    }
    public static Float getFloatBlockMeta(Block block, TempKey key, Float def) {
        Number blockMeta = getBlockMeta(block, key, def);
        return blockMeta != null ? blockMeta.floatValue() : def;
    }


    public static Long incrementBlockMeta(Block block, TempKey key, Long amount) {
        return incrementBlockMeta(block, key, amount, 0L);
    }
    public static Long incrementBlockMeta(Block block, TempKey key, Long amount, Long start) {
        Long val = getBlockMeta(block, key);
        Long origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setBlockMeta(block, key, val);
        return val;
    }

    public static Double incrementBlockMeta(Block block, TempKey key, Double amount) {
        return incrementBlockMeta(block, key, amount, 0D);
    }
    public static Double incrementBlockMeta(Block block, TempKey key, Double amount, Double start) {
        Double val = getBlockMeta(block, key);
        Double origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setBlockMeta(block, key, val);
        return val;
    }



    //////////////////////////////////////////////////
    //// TEMP CHUNK META
    //////////////////////////////////////////////////


    public static TempMetaMap getChunkTempMetaMap(Chunk chunk, boolean isWrite) {
        return API.meta.getChunkTempMetaMap(chunk, isWrite);
    }

    public static boolean hasChunkMeta(Chunk chunk, TempKey key) {
        final TempMetaMap chunkMetaMap = getChunkTempMetaMap(chunk, false);
        return chunkMetaMap != null && !chunkMetaMap.isEmpty() && chunkMetaMap.containsKey(key);
    }

    public static <T> T getChunkMeta(Chunk chunk, TempKey key) {
        return getChunkMeta(chunk, key, null);
    }

    public static <T> T getChunkMeta(Chunk chunk, TempKey key, T def) {
        final TempMetaMap chunkMetaMap = getChunkTempMetaMap(chunk, false);
        T ret = chunkMetaMap != null && !chunkMetaMap.isEmpty() ? (T) getChunkTempMetaMap(chunk, false).get(key) : null;
        return ret != null ? ret : def;
    }

    public static <T> T setChunkMeta(Chunk chunk, TempKey key, Object val) {
        TempMetaMap chunkMap = getChunkTempMetaMap(chunk, true);
        return setMetaMapValue(chunkMap, key, val);
    }

    public static <T> T removeChunkMeta(Chunk chunk, TempKey key) {
        TempMetaMap chunkMap = getChunkTempMetaMap(chunk, false);
        return setMetaMapValue(chunkMap, key, null);
    }

    public static Integer getIntegerChunkMeta(Chunk chunk, TempKey key) {
        Number chunkMeta = getChunkMeta(chunk, key, null);
        return chunkMeta != null ? chunkMeta.intValue() : null;
    }
    public static Integer getIntegerChunkMeta(Chunk chunk, TempKey key, Integer def) {
        Number chunkMeta = getChunkMeta(chunk, key, def);
        return chunkMeta != null ? chunkMeta.intValue() : def;
    }
    public static Long getLongChunkMeta(Chunk chunk, TempKey key) {
        Number chunkMeta = getChunkMeta(chunk, key, null);
        return chunkMeta != null ? chunkMeta.longValue() : null;
    }
    public static Long getLongChunkMeta(Chunk chunk, TempKey key, Long def) {
        Number chunkMeta = getChunkMeta(chunk, key, def);
        return chunkMeta != null ? chunkMeta.longValue() : def;
    }
    public static Double getDoubleChunkMeta(Chunk chunk, TempKey key) {
        Number chunkMeta = getChunkMeta(chunk, key, null);
        return chunkMeta != null ? chunkMeta.doubleValue() : null;
    }
    public static Double getDoubleChunkMeta(Chunk chunk, TempKey key, Double def) {
        Number chunkMeta = getChunkMeta(chunk, key, def);
        return chunkMeta != null ? chunkMeta.doubleValue() : def;
    }
    public static Float getFloatChunkMeta(Chunk chunk, TempKey key) {
        Number chunkMeta = getChunkMeta(chunk, key, null);
        return chunkMeta != null ? chunkMeta.floatValue() : null;
    }
    public static Float getFloatChunkMeta(Chunk chunk, TempKey key, Float def) {
        Number chunkMeta = getChunkMeta(chunk, key, def);
        return chunkMeta != null ? chunkMeta.floatValue() : def;
    }


    public static Long incrementChunkMeta(Chunk chunk, TempKey key, Long amount) {
        return incrementChunkMeta(chunk, key, amount, 0L);
    }
    public static Long incrementChunkMeta(Chunk chunk, TempKey key, Long amount, Long start) {
        Long val = getChunkMeta(chunk, key);
        Long origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setChunkMeta(chunk, key, val);
        return val;
    }

    public static Double incrementChunkMeta(Chunk chunk, TempKey key, Double amount) {
        return incrementChunkMeta(chunk, key, amount, 0D);
    }
    public static Double incrementChunkMeta(Chunk chunk, TempKey key, Double amount, Double start) {
        Double val = getChunkMeta(chunk, key);
        Double origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setChunkMeta(chunk, key, val);
        return val;
    }
    //////////////////////////////////////////////////
    //// TEMP INVENTORY META
    //////////////////////////////////////////////////

    public static boolean hasInventoryMeta(Inventory inv, TempKey key) {
        return inv.getMeta().containsKey(key.key());
    }

    public static <T> T setInventoryMeta(Inventory inv, TempKey key, Object val) {
        return (T) inv.getMeta().put(key.key(), val);
    }

    public static <T> T removeInventoryMeta(Inventory inv, TempKey key) {
        return (T) inv.getMeta().remove(key.key());
    }

    public static <T> T getInventoryMeta(Inventory inv, TempKey key) {
        return getInventoryMeta(inv, key, null);
    }

    public static <T> T getInventoryMeta(Inventory inv, TempKey key, T def) {
        Object val = inv.getMeta().get(key.key());
        if (val != null) {
            return (T) val;
        }
        return def;
    }

    public static Integer getIntegerInventoryMeta(Inventory inv, TempKey key) {
        Number invMeta = getInventoryMeta(inv, key, null);
        return invMeta != null ? invMeta.intValue() : null;
    }
    public static Integer getIntegerInventoryMeta(Inventory inv, TempKey key, Integer def) {
        Number invMeta = getInventoryMeta(inv, key, def);
        return invMeta != null ? invMeta.intValue() : def;
    }
    public static Long getLongInventoryMeta(Inventory inv, TempKey key) {
        Number invMeta = getInventoryMeta(inv, key, null);
        return invMeta != null ? invMeta.longValue() : null;
    }
    public static Long getLongInventoryMeta(Inventory inv, TempKey key, Long def) {
        Number invMeta = getInventoryMeta(inv, key, def);
        return invMeta != null ? invMeta.longValue() : def;
    }
    public static Double getDoubleInventoryMeta(Inventory inv, TempKey key) {
        Number invMeta = getInventoryMeta(inv, key, null);
        return invMeta != null ? invMeta.doubleValue() : null;
    }
    public static Double getDoubleInventoryMeta(Inventory inv, TempKey key, Double def) {
        Number invMeta = getInventoryMeta(inv, key, def);
        return invMeta != null ? invMeta.doubleValue() : def;
    }
    public static Float getFloatInventoryMeta(Inventory inv, TempKey key) {
        Number invMeta = getInventoryMeta(inv, key, null);
        return invMeta != null ? invMeta.floatValue() : null;
    }
    public static Float getFloatInventoryMeta(Inventory inv, TempKey key, Float def) {
        Number invMeta = getInventoryMeta(inv, key, def);
        return invMeta != null ? invMeta.floatValue() : def;
    }


    public static Long incrementInventoryMeta(Inventory inv, TempKey key, Long amount) {
        return incrementInventoryMeta(inv, key, amount, 0L);
    }
    public static Long incrementInventoryMeta(Inventory inv, TempKey key, Long amount, Long start) {
        Long val = getInventoryMeta(inv, key);
        Long origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setInventoryMeta(inv, key, val);
        return val;
    }

    public static Double incrementInventoryMeta(Inventory inv, TempKey key, Double amount) {
        return incrementInventoryMeta(inv, key, amount, 0D);
    }
    public static Double incrementInventoryMeta(Inventory inv, TempKey key, Double amount, Double start) {
        Double val = getInventoryMeta(inv, key);
        Double origVal = val;
        if (val == null) {
            val = start;
        }
        val += amount;
        setInventoryMeta(inv, key, val);
        return val;
    }

}
