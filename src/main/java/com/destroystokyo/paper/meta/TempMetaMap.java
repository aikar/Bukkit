package com.destroystokyo.paper.meta;

import javax.annotation.Nonnull;

@SuppressWarnings("WeakerAccess")
public class TempMetaMap extends MetaMap<TempMetaKey> {

    public TempMetaMap() {
    }

    public TempMetaMap(TempMetaMap map) {
        super(map);
    }

    public <T> T getValue(@Nonnull TempMetaKey key) {
        return getObject0(key);
    }

    public <T> T getValue(@Nonnull TempMetaKey key, T def) {
        return getObject0(key, def);
    }

    public <T> T setValue(@Nonnull TempMetaKey key, T value) {
        return putObject0(key, value);
    }

    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override
    public TempMetaMap clone() {
        return new TempMetaMap(this);
    }
}
