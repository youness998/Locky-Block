
package me.luckyblock.checker;

import org.bukkit.block.Block;
import org.bukkit.Material;

public class BlockChecker {
    public static boolean isValidBlock(Block block) {
        return block != null && block.getType() == Material.GOLD_BLOCK;
    }
    
    public static boolean isInProtectedRegion(Block block) {
        // Implementazione per controllo regioni protette
        return false;
    }
}
