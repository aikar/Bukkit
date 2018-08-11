package com.destroystokyo.paper.meta;

public class TempMetaKey extends MetaKey {
    TempMetaKey(String namespace, String key) {
        super(namespace, key);
    }

    public TempMetaKey append(String suffix) {
        return new TempMetaKey(namespace(), key() + suffix);
    }
}
