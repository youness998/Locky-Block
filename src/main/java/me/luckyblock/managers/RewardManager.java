
package me.luckyblock.managers;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.configuration.ConfigurationSection;
import me.luckyblock.Main;
import java.util.Random;

public class RewardManager {
    private final Main plugin;
    private final Random random;

    public RewardManager(Main plugin) {
        this.plugin = plugin;
        this.random = new Random();
    }

    public void giveReward(Player player) {
        if (random.nextDouble() < 0.5) {
            giveMoney(player);
        } else {
            giveItems(player);
        }
    }

    private void giveMoney(Player player) {
        int min = plugin.getConfig().getInt("rewards.money.min");
        int max = plugin.getConfig().getInt("rewards.money.max");
        int money = random.nextInt(max - min + 1) + min;
        
        if (plugin.getVaultHook() != null && plugin.getVaultHook().hasEconomy()) {
            plugin.getVaultHook().getEconomy().depositPlayer(player, money);
            player.sendMessage("§a§lHai vinto §e" + money + " §amonete!");
        }
    }

    private void giveItems(Player player) {
        ConfigurationSection items = plugin.getConfig().getConfigurationSection("rewards.items");
        if (items == null) {
            ItemStack reward = new ItemStack(Material.DIAMOND, random.nextInt(5) + 1);
            player.getInventory().addItem(reward);
            player.sendMessage("§a§lHai vinto dei diamanti!");
            return;
        }

        for (String key : items.getKeys(false)) {
            double chance = items.getDouble(key + ".chance");
            if (random.nextDouble() < chance) {
                String itemName = items.getString(key + ".name");
                int amount = items.getInt(key + ".amount");
                
                ItemStack item = new ItemStack(Material.valueOf(itemName), amount);
                player.getInventory().addItem(item);
                player.sendMessage("§a§lHai vinto §ex" + amount + " " + itemName + "§a!");
                return;
            }
        }
    }
}
