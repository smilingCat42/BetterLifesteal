package net.lazycat.betterlifesteal.hearts;

import net.lazycat.betterlifesteal.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class HeartManager {
    private Plugin plugin;
    public List<UUID> bannedPlayers;
    public FileConfiguration config;

    public HeartManager(Plugin plugin) {
        this.plugin = plugin;
        this.config = Main.getInstance().getConfig();
        this.bannedPlayers = new LinkedList<UUID>();
        if (bannedPlayers.isEmpty()) {
            config.set("bannedplayers.list", bannedPlayers);
        }
    }

    public void banDeadPlayer(Player player) {
        Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), ChatColor.DARK_RED + "You have died.", null, "LifeSteal");
        bannedPlayers.add(player.getUniqueId());
    }
    public void unbanDeadPlayer(Player player) {
        Bukkit.getBanList(BanList.Type.NAME).pardon(player.getName());
        bannedPlayers.remove(player.getUniqueId());
    }
}
