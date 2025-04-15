
package me.luckyblock.hooks;

import org.bukkit.plugin.RegisteredServiceProvider;
import net.milkbowl.vault.economy.Economy;
import me.luckyblock.Main;

public class VaultHook {
    private Economy economy;
    private final Main plugin;

    public VaultHook(Main plugin) {
        this.plugin = plugin;
        setupEconomy();
    }
    
    private boolean setupEconomy() {
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public Economy getEconomy() {
        return economy;
    }

    public boolean hasEconomy() {
        return economy != null;
    }
}
