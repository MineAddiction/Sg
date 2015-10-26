package com.grampabacon.sgreborn.game.events.custom;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Adam on 06/10/2015.
 */
public class GameStart extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
