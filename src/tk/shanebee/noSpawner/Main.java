package tk.shanebee.noSpawner;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private FileConfiguration config = this.getConfig();

    @Override
    public void onEnable() {
        getLogger().info("Successfully loaded!");

        config.addDefault("NoSpawner.Prefix", "[NoSpawner]");
        config.addDefault("NoSpawner.enabled", true);
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
