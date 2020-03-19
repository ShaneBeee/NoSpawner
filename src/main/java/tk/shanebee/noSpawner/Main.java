package tk.shanebee.noSpawner;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin {

    private FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        getLogger().info("Successfully loaded!");

        config.addDefault("NoSpawner.Prefix", "[NoSpawner]");
        config.addDefault("NoSpawner.enableForAllWorlds", true);
        config.addDefault("NoSpawner.enableSpawnersInWorld", Arrays.asList("world", "world_nether"));
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new Event(this), this);
        this.getCommand("nospawner").setExecutor(new Commands(this));
        this.getCommand("nospawner").setTabCompleter(new TabCompleter());
    }

    @Override
    public void onDisable() {
        getLogger().info("Successfully unloaded!");
    }
}
