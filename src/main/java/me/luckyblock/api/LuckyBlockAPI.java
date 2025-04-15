
package me.luckyblock.api;

import org.bukkit.entity.Player;
import me.luckyblock.objects.LuckyBlockObject;

public interface LuckyBlockAPI {
    void giveLuckyBlock(Player player, int amount);
    void spawnLuckyBlock(Player player);
    LuckyBlockObject createLuckyBlock();
}
