package com.grampabacon.sgreborn.game.players.managers;

import com.grampabacon.sgreborn.Main;
import com.grampabacon.sgreborn.game.players.GamePlayer;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Adam on 04/10/2015.
 */
public class PlayerManager {
    private ArrayList<UUID> alivePlayers;
    private ArrayList<UUID> spectatingPlayers;

    private ArrayList<GamePlayer> gamePlayers;

    private int maxPlayers;
    private int minPlayers;

    Main plugin;

    public PlayerManager() {
        alivePlayers = new ArrayList<>();
        spectatingPlayers = new ArrayList<>();

        gamePlayers = new ArrayList<>();

        maxPlayers = 24;
        minPlayers = 6;

        this.plugin = Main.getInstance();
    }

    public ArrayList<UUID> getAlivePlayers() {
        return alivePlayers;
    }

    public void addAlivePlayer(UUID uuid) {
        alivePlayers.add(uuid);
    }

    public ArrayList<UUID> getSpectatingPlayers() {
        return spectatingPlayers;
    }

    public void addSpectatingPlayer(UUID uuid) {
        spectatingPlayers.add(uuid);
    }

    public ArrayList<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void addGamePlayer(GamePlayer gamePlayer) {
        gamePlayers.add(gamePlayer);
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }
}
