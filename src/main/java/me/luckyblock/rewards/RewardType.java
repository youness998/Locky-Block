package me.luckyblock.rewards;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import me.luckyblock.Main;
import me.luckyblock.hooks.VaultHook;

public enum RewardType {
    DIAMOND {
        @Override
        public void giveReward(Player player) {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND, 5));
            player.sendMessage("§a§lHai trovato §b5 diamanti§a!");
        }
    },
    EMERALD {
        @Override
        public void giveReward(Player player) {
            player.getInventory().addItem(new ItemStack(Material.EMERALD, 3));
            player.sendMessage("§a§lHai trovato §23 smeraldi§a!");
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
    },
    NETHERITE {
        @Override
        public void giveReward(Player player) {
            player.getInventory().addItem(new ItemStack(Material.NETHERITE_INGOT, 1));
            player.sendMessage("§a§lHai trovato §8netherite§a!");
        }
    },
    SPEED_BOOST {
        @Override
        public void giveReward(Player player) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
            player.sendMessage("§a§lHai ottenuto §bvelocità§a!");
        }
    },
    GOLDEN_APPLE {
        @Override
        public void giveReward(Player player) {
            player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 3));
            player.sendMessage("§a§lHai trovato §63 mele d'oro§a!");
        }
    };

    public abstract void giveReward(Player player);
}
