package com.grampabacon.sgreborn.game.events;

import com.grampabacon.sgreborn.Main;
import com.grampabacon.sgreborn.game.events.player.Join;
import com.grampabacon.sgreborn.game.events.player.TakeDamage;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;

/**
 * Created by Adam on 06/10/2015.
 */
public class EventManager {
    PluginManager pm = Main.getInstance().getServer().getPluginManager();

    public void registerListeners() {
        pm.registerEvents(new Join(), Main.getInstance());
        pm.registerEvents(new TakeDamage(), Main.getInstance());
    }

    public void unregisterListeners() {
        HandlerList.unregisterAll(Main.getInstance());
    }
}
