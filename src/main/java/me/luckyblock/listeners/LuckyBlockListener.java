
package me.luckyblock.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import me.luckyblock.Main;
import me.luckyblock.model.LuckyBlock;

public class LuckyBlockListener implements Listener {
    private final Main plugin;

    public LuckyBlockListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (LuckyBlock.isLuckyBlock(event.getBlock())) {
            LuckyBlock luckyBlock = new LuckyBlock(event.getBlock(), plugin.getConfigManager().getDefaultLuck());
            
            if (luckyBlock.isLucky()) {
                plugin.getRewardManager().giveReward(event.getPlayer());
            } else {
                plugin.getExplosionManager().createExplosion(event.getBlock().getLocation(), event.getPlayer());
            }
        }
    }
}
