
package me.luckyblock.managers;

import org.bukkit.configuration.file.FileConfiguration;
import me.luckyblock.Main;

public class ConfigManager {
    private final Main plugin;
    private FileConfiguration config;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    private void loadConfig() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    public double getDefaultLuck() {
        return config.getDouble("default-luck", 0.5);
    }

    public void reloadConfig() {
        plugin.reloadConfig();
        config = plugin.getConfig();
    }
}
