package com.grampabacon.sgreborn.game.events.player;

import com.grampabacon.sgreborn.Main;
import de.slikey.effectlib.effect.BleedEffect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Adam on 06/10/2015.
 */
public class TakeDamage implements Listener {

    BleedEffect bleed;

    @EventHandler
    public void onTakeDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        Player player = (Player) event.getEntity();

        /*if (Game.getStage() != Game.Stage.INGAME) {
            return;
        }
        */
        bleed = new BleedEffect(Main.getInstance().effectManager);
        bleed.period = 1;
        bleed.setEntity(player);
        bleed.run();
    }
}
