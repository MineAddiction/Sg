package com.grampabacon.sgreborn.game.timers;

import com.grampabacon.sgreborn.Main;
import com.grampabacon.sgreborn.utils.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Adam on 15/07/2015.
 */
public class LobbyTimer extends BukkitRunnable {
    int time = 60;

    Location spawn;

    Main plugin;
    public LobbyTimer() {
        this.plugin = Main.getInstance();
        spawn = Main.getInstance().getServer().getWorld("world").getSpawnLocation();
    }

    @Override
    public void run() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.setLevel(time);
        }

        if (time == 60) {
            Bukkit.broadcastMessage(ChatColor.GOLD + "[SGR] Game begins in " + ChatColor.RED + time + ChatColor.GOLD + " seconds.");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 1.0f, 1.0f);
            }
        }
        if (time == 30) {
            Bukkit.broadcastMessage(ChatColor.GOLD + "[SGR] Game begins in " + ChatColor.RED + time + ChatColor.GOLD + " seconds.");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 1.0f, 1.0f);
            }
        }
        if (time == 10) {
            Bukkit.broadcastMessage(ChatColor.GOLD + "[SGR] Game begins in " + ChatColor.RED + time + ChatColor.GOLD + " seconds.");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.NOTE_BASS_GUITAR, 1.0f, 1.0f);
            }
        }
        if (time < 5 && time > 1) {
            Bukkit.broadcastMessage(ChatColor.GOLD + "[SGR] Game begins in " + ChatColor.RED + time + ChatColor.GOLD + " seconds.");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }
        }
        if (time == 1) {
            Bukkit.broadcastMessage(ChatColor.GOLD + "[SGR] Game begins in " + ChatColor.RED + time + ChatColor.GOLD + " second.");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.playSound(p.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }
        }
        if (time <= 10 && time > 0) {
            Title title = new Title("" + time + "", "Game Starting!", 0, 1, 0);
            title.setTitleColor(ChatColor.DARK_GREEN);
            title.setSubtitleColor(ChatColor.GOLD);
            title.broadcast();
        }
        if (time < 1) {
            cancel();
            if (Bukkit.getOnlinePlayers().size() < plugin.playerManager.getMinPlayers()) {
                time = 60;
                Bukkit.broadcastMessage("§6[SGR] Not enough players to start, restarting timer.");
                Main.getInstance().isTimerRunning = false;
                runTaskTimer(Main.getInstance(), 0L, 20L);
                cancel();
                return;
            }
            for (Player player : Bukkit.getOnlinePlayers()) {

                // TODO: ADD TELEPORT + give items
                plugin.playerManager.preparePlayer(player);
                player.teleport(spawn;
                cancel();
            }
        }
        time--;
    }
}
