
package me.luckyblock.reflections;

import org.bukkit.Bukkit;

public class ReflectionUtils {
    public static String getVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

    public static Class<?> getNMSClass(String className) {
        try {
            return Class.forName("net.minecraft.server." + getVersion() + "." + className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
