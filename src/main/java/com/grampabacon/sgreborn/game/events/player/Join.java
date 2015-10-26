package com.grampabacon.sgreborn.game.events.player;

import com.grampabacon.sgreborn.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Adam on 06/10/2015.
 */
public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!Main.getInstance().playerSql.containsPlayer(player.getUniqueId())) {
            Main.getInstance().playerSql.createPlayer(player);
        }

        Main.getInstance().playerManager.addGamePlayer(Main.getInstance().playerSql.loadPlayer(player.getUniqueId()));

        Main.getInstance().game.start();
    }
}
