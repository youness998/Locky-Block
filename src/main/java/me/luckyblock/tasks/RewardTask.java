
package me.luckyblock.tasks;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.entity.Player;
import me.luckyblock.rewards.RewardType;

public class RewardTask extends BukkitRunnable {
    private final Player player;
    private final RewardType rewardType;

    public RewardTask(Player player, RewardType rewardType) {
        this.player = player;
        this.rewardType = rewardType;
    }

    @Override
    public void run() {
        rewardType.giveReward(player);
    }
}
