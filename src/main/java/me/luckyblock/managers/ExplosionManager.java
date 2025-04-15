
package me.luckyblock.managers;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import me.luckyblock.Main;

public class ExplosionManager {
    private final Main plugin;

    public ExplosionManager(Main plugin) {
        this.plugin = plugin;
    }

    public void createExplosion(Location location, Player player) {
        location.getWorld().createExplosion(location, 2.0f, false, false);
        player.sendMessage("Sfortuna! Il Lucky Block è esploso!");
    }
}
