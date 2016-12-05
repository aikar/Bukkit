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

package com.empireminecraft.api;

import com.empireminecraft.api.EntityTask.TaskHandler;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public interface EAPI_Entity {

    byte[] serializeEntity(Entity craftentity);
    Entity deserializeEntity(byte[] data, World world);

    void cancelTasks(Entity entity);

    default <T extends Entity> EntityTask<T> scheduleTask(T entity, int interval, Runnable task) {
        return scheduleTask(entity, interval, new EntityTask<T>() {
            @Override
            public void run(T entity) {
                task.run();
            }
        });
    }

    default <T extends Entity> EntityTask<T> scheduleDelayedTask(T entity, int delay, Runnable task) {
        return scheduleTask(entity, delay, new EntityTask<T>(1) {
            @Override
            public void run(T entity) {
                task.run();
            }
        });
    }

    default <T extends Entity> EntityTask<T> scheduleDelayedTask(T entity, int delay, TaskHandler<T> task) {
        return scheduleTask(entity, delay, new EntityTask<T>(1) {
            @Override
            public void run(T entity) {
                task.run(entity, this);
            }
        });
    }

    default <T extends Entity> EntityTask<T> scheduleTask(T entity, int interval, TaskHandler<T> task) {
        return scheduleTask(entity, interval, new EntityTask<T>() {
            @Override
            public void run(T entity) {
                task.run(entity, this);
            }
        });
    }

    default <T extends Entity> EntityTask<T> scheduleTask(T entity, int interval, int limit, TaskHandler<T> task) {
        return scheduleTask(entity, interval, new EntityTask<T>(limit) {
            @Override
            public void run(T entity) {
                task.run(entity, this);
            }
        });
    }

    default <T extends Entity> EntityTask<T> scheduleTask(T entity, int interval, int limit, Runnable task) {
        return scheduleTask(entity, interval, new EntityTask<T>(limit) {
            @Override
            public void run(T entity) {
                task.run();
            }
        });
    }

    <T extends Entity> EntityTask<T> scheduleTask(T entity, int interval, EntityTask<T> task);
}
