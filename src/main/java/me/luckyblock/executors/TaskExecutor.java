
package me.luckyblock.executors;

import org.bukkit.Bukkit;
import me.luckyblock.Main;

public class TaskExecutor {
    private final Main plugin;

    public TaskExecutor(Main plugin) {
        this.plugin = plugin;
    }

    public void executeAsync(Runnable task) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, task);
    }

    public void executeLater(Runnable task, long delay) {
        Bukkit.getScheduler().runTaskLater(plugin, task, delay);
    }
}
