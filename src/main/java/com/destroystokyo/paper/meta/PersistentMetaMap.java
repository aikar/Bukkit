package com.destroystokyo.paper.meta;

import javax.annotation.Nonnull;

/**
 * A type protected hashmap for storing meta values
 * <p>
 * This API is not thread safe!
 */
@SuppressWarnings({"PublicInnerClass", "unchecked", "WeakerAccess"})
public class PersistentMetaMap extends MetaMap<PersistentMetaKey> {


    public PersistentMetaMap() {
    }

    public PersistentMetaMap(PersistentMetaMap map) {
        super(map);
    }

    public PersistentMetaMap setPersistentMap(@Nonnull PersistentMetaKey key, PersistentMetaMap value) {
        return putObject0(key, value);
    }

    public PersistentMetaMap getPersistentMap(@Nonnull PersistentMetaKey key) {
        return getObject0(key, null);
    }

    public PersistentMetaMap getPersistentMap(@Nonnull PersistentMetaKey key, PersistentMetaMap def) {
        return getObject0(key, def);
    }

    public <Z> PersistentMetaList<Z> setPersistentList(@Nonnull PersistentMetaKey key, PersistentMetaList<Z> value) {
        return putObject0(key, value);
    }

    public <Z> PersistentMetaList<Z> getPersistentList(@Nonnull PersistentMetaKey key) {
        return getObject0(key, null);
    }

    public <Z> PersistentMetaList<Z> getPersistentList(@Nonnull PersistentMetaKey key, PersistentMetaList<Z> def) {
        return getObject0(key, def);
    }


    public <Z> PersistentMetaSet<Z> setPersistentSet(@Nonnull PersistentMetaKey key, PersistentMetaSet<Z> value) {
        return putObject0(key, value);
    }

    public <Z> PersistentMetaSet<Z> getPersistentSet(@Nonnull PersistentMetaKey key) {
        return getObject0(key, null);
    }

    public <Z> PersistentMetaSet<Z> getPersistentSet(@Nonnull PersistentMetaKey key, PersistentMetaSet<Z> def) {
        return getObject0(key, def);
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    public PersistentMetaMap clone() {
        return new PersistentMetaMap(this);
    }
}
