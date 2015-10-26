package com.grampabacon.sgreborn.game.events.custom;

import com.grampabacon.sgreborn.game.players.GamePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Adam on 06/10/2015.
 */
public class GameEnd extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private GamePlayer winner;

    public GameEnd(GamePlayer winner) {
        this.winner = winner;
    }

    public GamePlayer getWinner() {
        return winner;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
