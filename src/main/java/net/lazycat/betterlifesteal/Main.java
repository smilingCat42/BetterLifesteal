package net.lazycat.betterlifesteal;

import net.lazycat.betterlifesteal.hearts.HeartManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private static Main INSTANCE;
    public HeartManager heartManager;
    private FileConfiguration config;


    @Override
    public void onLoad() {
        this.saveDefaultConfig();
        INSTANCE = this;
        this.heartManager = new HeartManager(this);
        this. config = getConfig();


    }
    @Override
    public void onEnable() {
        heartManager.bannedPlayers = (LinkedList<UUID>) config.getList("bannedplayers.list");
    }
    @Override
    public void onDisable() {
        config.set("bannedplayers.list", heartManager.bannedPlayers);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return INSTANCE;
    }
}
