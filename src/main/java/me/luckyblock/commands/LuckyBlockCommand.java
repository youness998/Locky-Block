package me.luckyblock.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import me.luckyblock.Main;
import me.luckyblock.model.LuckyBlock;

public class LuckyBlockCommand implements CommandExecutor {
    private final Main plugin;

    public LuckyBlockCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cQuesto comando può essere usato solo da un giocatore!");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("luckyblock.give")) {
            player.sendMessage("§cNon hai il permesso di usare questo comando!");
            return true;
        }

        int amount = 1;
        if (args.length > 0) {
            try {
                amount = Integer.parseInt(args[0]);
                if (amount < 1 || amount > 64) {
                    player.sendMessage("§cLa quantità deve essere tra 1 e 64!");
                    return true;
                }
            } catch (NumberFormatException e) {
                player.sendMessage("§cQuantità non valida!");
                return true;
            }
        }

        ItemStack luckyBlock = LuckyBlock.createLuckyBlock();
        luckyBlock.setAmount(amount);
        player.getInventory().addItem(luckyBlock);
        player.sendMessage("§aHai ricevuto §6" + amount + " Lucky Block§a!");

        return true;
    }
}