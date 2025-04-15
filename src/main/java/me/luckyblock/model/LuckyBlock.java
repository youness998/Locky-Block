
package me.luckyblock.model;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;

public class LuckyBlock {
    private final Block block;
    private final double luck;

    public LuckyBlock(Block block, double luck) {
        this.block = block;
        this.luck = luck;
    }

    public boolean isLucky() {
        return Math.random() < luck;
    }

    public Block getBlock() {
        return block;
    }

    public double getLuck() {
        return luck;
    }

    public static boolean isLuckyBlock(Block block) {
        return block != null && block.getType() == Material.GOLD_BLOCK;
    }

    public static ItemStack createLuckyBlock() {
        ItemStack item = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6§lLucky Block");
        meta.setLore(Arrays.asList(
            "§7Rompi questo blocco per",
            "§7ottenere premi o punizioni!"
        ));
        item.setItemMeta(meta);
        return item;
    }
}
