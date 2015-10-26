package com.grampabacon.sgreborn;

import com.grampabacon.sgreborn.game.Game;
import com.grampabacon.sgreborn.game.events.EventManager;
import com.grampabacon.sgreborn.game.players.managers.PlayerManager;
import com.grampabacon.sgreborn.game.players.managers.PlayerSql;
import com.grampabacon.sgreborn.utils.dbhandler.DBConnector;
import de.slikey.effectlib.EffectLib;
import de.slikey.effectlib.EffectManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Adam on 02/10/2015.
 */
public class Main extends JavaPlugin {

    public PlayerManager playerManager;
    public PlayerSql playerSql;

    public Game game;

    public EffectManager effectManager;

    EventManager eventManager;

    public boolean isTimerRunning;

    static Main instance;
    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        isTimerRunning = false;
        initialiseConnections();
        loadClasses();

        loadEffects();

        eventManager.registerListeners();
    }

    public void onDisable() {
        DBConnector.getInstance().disconnect();
        eventManager.unregisterListeners();
        effectManager.disposeOnTermination();
    }

    private void initialiseConnections() {
        new DBConnector();
    }

    private void loadClasses() {
        playerManager = new PlayerManager();
        playerSql = new PlayerSql();
        game = new Game();
        eventManager = new EventManager();
    }

    private void loadEffects() {
        EffectLib lib = EffectLib.instance();
        effectManager = new EffectManager(lib);
    }
}
