/*
 * Copyright (c) 2016. Starlis LLC / dba Empire Minecraft
 *
 * This source code is proprietary software and must not be redistributed without Starlis LLC's approval
 *
 */

package com.empireminecraft.customevents;

import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class UnknownCommandEvent extends Event implements Cancellable {
    private final CommandSender sender;
    private final String sentCommandLabel;
    private final String commandLine;

    public UnknownCommandEvent(CommandSender sender, String sentCommandLabel, String commandLine) {
        this.sender = sender;
        this.sentCommandLabel = sentCommandLabel;
        this.commandLine = commandLine;
    }

    public CommandSender getSender() {
        return sender;
    }

    public String getSentCommandLabel() {
        return sentCommandLabel;
    }

    public String getCommandLine() {
        return commandLine;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    private boolean cancelled = false;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}
