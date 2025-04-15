
package me.luckyblock.rewards;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import me.luckyblock.Main;
import me.luckyblock.hooks.VaultHook;

public enum RewardType {
    DIAMOND {
        @Override
        public void giveReward(Player player) {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 5));
        }
    },
    EMERALD {
        @Override
        public void giveReward(Player player) {
            player.getInventory().addItem(new ItemStack(Material.EMERALD, 3));
        }
    },
    MONEY {
        @Override
        public void giveReward(Player player) {
            VaultHook vaultHook = Main.getInstance().getVaultHook();
            if (vaultHook != null && vaultHook.hasEconomy()) {
                vaultHook.getEconomy().depositPlayer(player, 1000);
                player.sendMessage("§a§lHai vinto §e1000 monete§a!");
            }
        }
    };

    public abstract void giveReward(Player player);
}
