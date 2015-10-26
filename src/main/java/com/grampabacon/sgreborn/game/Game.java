package com.grampabacon.sgreborn.game;

import com.grampabacon.sgreborn.Main;
import com.grampabacon.sgreborn.game.timers.LobbyTimer;
import org.bukkit.scheduler.BukkitTask;

/**
 * Created by Adam on 04/10/2015.
 */
public class Game {
    public enum Stage {
        LOBBY, STARTING, INGAME, DEATHMATCH, FINISHED
    }

    private static Stage stage = Stage.LOBBY;

    public void start() {
        BukkitTask lobbytimer = new LobbyTimer().runTaskTimer(Main.getInstance(), 0L, 20L);
    }

    public static Stage getStage() {
        return stage;
    }
}
