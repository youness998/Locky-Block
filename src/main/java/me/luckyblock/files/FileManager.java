
package me.luckyblock.files;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class FileManager {
    private final File dataFolder;
    
    public FileManager(File dataFolder) {
        this.dataFolder = dataFolder;
    }

    public YamlConfiguration loadConfig(String fileName) {
        File file = new File(dataFolder, fileName);
        return YamlConfiguration.loadConfiguration(file);
    }

    public void saveConfig(YamlConfiguration config, String fileName) throws IOException {
        File file = new File(dataFolder, fileName);
        config.save(file);
    }
}
