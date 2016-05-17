/*
 * Copyright (c) 2016. Starlis LLC / dba Empire Minecraft
 *
 * This source code is proprietary software and must not be redistributed without Starlis LLC's approval
 *
 */

package com.empireminecraft;

import javax.annotation.Nonnull;
import java.util.UUID;

public class UniqueIdentifier implements Identifier {
    private final UUID uuid;
    public UniqueIdentifier(@Nonnull UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        UniqueIdentifier that = (UniqueIdentifier) o;

        return uuid.equals(that.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }
}
