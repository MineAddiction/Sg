package com.grampabacon.sgreborn.game.players.managers;

import com.grampabacon.sgreborn.game.players.GamePlayer;
import com.grampabacon.sgreborn.utils.dbhandler.DBConnector;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.util.UUID;

/**
 * Created by Adam on 06/10/2015.
 */
public class PlayerSql {
    String table = "GamePlayers";

    public PlayerSql() {
        if (!DBConnector.getInstance().tableExists(table)) {
            createTable();
        }
    }

    private void createTable() {
        String q = "CREATE TABLE IF NOT EXISTS " + table + " (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "uuid VARCHAR(60), " +
                "coins INT NOT NULL DEFAULT 30, " +
                "kills INT(11) NOT NULL DEFAULT 0, " +
                "deaths INT(11) NOT NULL DEFAULT 0, " +
                "wins INT(11) NOT NULL DEFAULT 0, " +
                "losses INT(11) NOT NULL DEFAULT 0, " +
                "games INT(11) NOT NULL DEFAULT 0, " +
                "kstreak INT(3) NOT NULL DEFAULT 0, " +
                "dstreak INT(3) NOT NULL DEFAULT 0, " +
                "longestkstreak INT(5) NOT NULL DEFAULT 0, " +
                "longestdstreak INT(5) NOT NULL DEFAULT 0, " +
                "lastplayed BIGINT(18) NOT NULL DEFAULT 0, " +
                "timeplayed INT(11) NOT NULL DEFAULT 0, " +
                "winstreak INT(11) NOT NULL DEFAULT 0, " +
                "lossstreak INT(11) NOT NULL DEFAULT 0, " +
                "longestwstreak INT(11) NOT NULL DEFAULT 0, " +
                "longestlstreak INT(11) NOT NULL DEFAULT 0);";
        DBConnector.getInstance().executeQuery(q);
    }

    public void createPlayer(Player player) {
        String query = "INSERT INTO " + table + " (uuid) VALUES ('" + player.getUniqueId().toString() + "');";
        DBConnector.getInstance().executeQuery(query);
    }

    public void savePlayer(GamePlayer player) {
        String delq = "DELETE FROM " + table + " WHERE uuid='" + player.getUuid() + "'";
        DBConnector.getInstance().executeQuery(delq);
        String insq = "INSERT INTO " + table + " (uuid, coins, kills, deaths, wins, losses, games, kstreak, dstreak, longestkstreak, longestdstreak, lastplayed, timeplayed, winstreak, lossstreak, longestwstreak, longestlstreak) " +
                "VALUES ('" + player.getUuid() + "'," +
                "'" + player.getCoins() + "'," +
                "'" + player.getKills() + "'," +
                "'" + player.getDeaths() + "'," +
                "'" + player.getWins() + "'," +
                "'" + player.getLosses() + "'," +
                "'" + player.getGamesPlayed() + "'," +
                "'" + player.getKillStreak() + "'," +
                "'" + player.getDeathStreak() + "'," +
                "'" + player.getLongestKillStreak() + "'," +
                "'" + player.getLongestDeathStreak() + "'," +
                "'" + player.getLastPlayed() + "'," +
                "'" + player.getTimePlayed() + "'," +
                "'" + player.getWinStreak() + "'," +
                "'" + player.getLossStreak() + "'," +
                "'" + player.getLongestWinStreak() + "'," +
                "'" + player.getLongestLossStreak() + "')";
        DBConnector.getInstance().executeQuery(insq);
    }

    public GamePlayer loadPlayer(UUID uuid) {
        ResultSet res = null;
        GamePlayer gamePlayer = new GamePlayer(uuid);
        try {
            res = DBConnector.getInstance().executeQueryAndGetData("SELECT * FROM " + table + " WHERE uuid='" + uuid.toString() + "'");
            while (res.next()) {
                gamePlayer.setCoins(res.getInt("coins"));
                gamePlayer.setKills(res.getInt("kills"));
                gamePlayer.setDeaths(res.getInt("deaths"));
                gamePlayer.setWins(res.getInt("wins"));
                gamePlayer.setLosses(res.getInt("losses"));
                gamePlayer.setGamesPlayed(res.getInt("games"));
                gamePlayer.setKillStreak(res.getInt("kstreak"));
                gamePlayer.setDeathStreak(res.getInt("dstreak"));
                gamePlayer.setLongestKillStreak(res.getInt("longestkstreak"));
                gamePlayer.setLongestDeathStreak(res.getInt("longestdstreak"));
                gamePlayer.setLastPlayed(res.getLong("lastplayed"));
                gamePlayer.setTimePlayed(res.getInt("timeplayed"));
                gamePlayer.setWinStreak(res.getInt("winstreak"));
                gamePlayer.setLossStreak(res.getInt("lossstreak"));
                gamePlayer.setLongestWinStreak(res.getInt("longestwstreak"));
                gamePlayer.setLongestLossStreak(res.getInt("longestlstreak"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                res.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return gamePlayer;
    }

    public boolean containsPlayer(UUID uuid) {
        ResultSet res = null;
        try {
            res = DBConnector.getInstance().executeQueryAndGetData("SELECT * FROM " + table + " WHERE uuid='" + uuid.toString() + "'");
            if (res.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                res.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
