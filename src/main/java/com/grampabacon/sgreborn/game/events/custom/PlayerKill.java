package com.grampabacon.sgreborn.game.events.custom;

import com.grampabacon.sgreborn.game.players.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Adam on 06/10/2015.
 */
public class PlayerKill extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private GamePlayer killer;
    private GamePlayer victim;

    public PlayerKill(GamePlayer killer, GamePlayer victim) {
        this.killer = killer;
        this.victim = victim;
    }

    public GamePlayer getKiller() {
        return killer;
    }

    public GamePlayer getVictim() {
        return victim;
    }

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
