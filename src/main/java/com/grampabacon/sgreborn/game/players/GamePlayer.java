package com.grampabacon.sgreborn.game.players;

import com.grampabacon.sgreborn.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Adam on 04/10/2015.
 */
public class GamePlayer {
    private UUID uuid;
    private UUID spectating;
    private String selectedKit;

    private int coins;
    private int wins, losses;
    private int gamesPlayed;
    private int kills, deaths;
    private int killStreak, deathStreak;
    private int longestKillStreak, longestDeathStreak;
    private int winStreak, lossStreak;
    private int longestWinStreak, longestLossStreak;

    private long lastPlayed;
    private int timePlayed;

    Main plugin;

    public GamePlayer() {
        this.plugin = Main.getInstance();
    }

    public GamePlayer(UUID uuid) {
        this.uuid = uuid;
        this.spectating = null;

        selectedKit = null;

        coins = 0;

        wins = 0;
        losses = 0;
        gamesPlayed = 0;

        kills = 0;
        deaths = 0;
        killStreak = 0;
        deathStreak = 0;
        longestKillStreak = 0;
        longestDeathStreak = 0;
        winStreak = 0;
        lossStreak = 0;
        longestWinStreak = 0;
        longestLossStreak = 0;

        lastPlayed = System.currentTimeMillis();
        timePlayed = 0;

        Main.getInstance().playerManager.addGamePlayer(this);
    }

    public Player getPlayer(UUID uuid) {
        return Bukkit.getPlayer(this.uuid);
    }

    public void setPlayer(Player player) {
        this.uuid = player.getUniqueId();
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public UUID getSpectating() {
        return this.spectating;
    }

    public void setSpectating(UUID spectating) {
        this.spectating = spectating;
    }

    public String getSelectedKit() {
        return this.selectedKit;
    }

    public void setSelectedKit(String kit) {
        this.selectedKit = kit;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getKillStreak() {
        return killStreak;
    }

    public void setKillStreak(int killStreak) {
        this.killStreak = killStreak;
    }

    public int getDeathStreak() {
        return deathStreak;
    }

    public void setDeathStreak(int deathStreak) {
        this.deathStreak = deathStreak;
    }

    public int getLongestKillStreak() {
        return longestKillStreak;
    }

    public void setLongestKillStreak(int longestKillStreak) {
        this.longestKillStreak = longestKillStreak;
    }

    public int getLongestDeathStreak() {
        return longestDeathStreak;
    }

    public void setLongestDeathStreak(int longestDeathStreak) {
        this.longestDeathStreak = longestDeathStreak;
    }

    public long getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(long lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getWinStreak() {
        return winStreak;
    }

    public void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    public int getLossStreak() {
        return lossStreak;
    }

    public void setLossStreak(int lossStreak) {
        this.lossStreak = lossStreak;
    }

    public int getLongestWinStreak() {
        return longestWinStreak;
    }

    public void setLongestWinStreak(int longestWinStreak) {
        this.longestWinStreak = longestWinStreak;
    }

    public int getLongestLossStreak() {
        return longestLossStreak;
    }

    public void setLongestLossStreak(int longestLossStreak) {
        this.longestLossStreak = longestLossStreak;
    }
}