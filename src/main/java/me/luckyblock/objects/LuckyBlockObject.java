
package me.luckyblock.objects;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.luckyblock.utils.ColorUtils;
import java.util.Arrays;

public class LuckyBlockObject {
    private final ItemStack item;
    private final double luck;

    public LuckyBlockObject(double luck) {
        this.luck = luck;
        this.item = createItem();
    }

    private ItemStack createItem() {
        ItemStack item = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ColorUtils.colorize("&6&lLucky Block"));
        meta.setLore(Arrays.asList(
            ColorUtils.colorize("&7Rompi questo blocco per"),
            ColorUtils.colorize("&7ottenere premi o punizioni!")
        ));
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack getItem() {
        return item;
    }

    public double getLuck() {
        return luck;
    }
}
