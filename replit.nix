
package me.luckyblock;

import org.bukkit.plugin.java.JavaPlugin;
import me.luckyblock.hooks.VaultHook;
import me.luckyblock.managers.*;
import me.luckyblock.listeners.LuckyBlockListener;
import me.luckyblock.commands.LuckyBlockCommand;

public class Main extends JavaPlugin {
    private static Main instance;
    private ConfigManager configManager;
    private RewardManager rewardManager;
    private ExplosionManager explosionManager;
    private VaultHook vaultHook;

    @Override
    public void onEnable() {
        instance = this;
        
        // Initialize managers
        this.configManager = new ConfigManager(this);
        this.rewardManager = new RewardManager(this);
        this.explosionManager = new ExplosionManager(this);
        
        // Register events
        getServer().getPluginManager().registerEvents(new LuckyBlockListener(this), this);
        
        // Initialize Vault
        this.vaultHook = new VaultHook(this);
        
        // Register commands
        getCommand("luckyblock").setExecutor(new LuckyBlockCommand(this));
        
        getLogger().info("LuckyBlock Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("LuckyBlock Plugin disabled!");
    }

    public static Main getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public RewardManager getRewardManager() {
        return rewardManager;
    }

    public ExplosionManager getExplosionManager() {
        return explosionManager;
    }

    public VaultHook getVaultHook() {
        return vaultHook;
    }
}
