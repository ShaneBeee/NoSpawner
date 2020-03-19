package tk.shanebee.noSpawner.listener;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import tk.shanebee.noSpawner.NoSpawner;

import java.util.Arrays;

public class ListenerManager {

    private final NoSpawner PLUGIN;
    private final FileConfiguration CONFIG;
    private final SpawnerListener SPAWNER_EVENT;

    @SuppressWarnings("ConstantConditions")
    public ListenerManager(NoSpawner plugin) {
        this.PLUGIN = plugin;
        this.CONFIG = plugin.getConfig();

        this.SPAWNER_EVENT = new SpawnerListener(this.PLUGIN);
        Bukkit.getPluginManager().registerEvents(this.SPAWNER_EVENT, this.PLUGIN);
        loadDefaultConfig();
        this.PLUGIN.getCommand("nospawner").setExecutor(new Commands(this.PLUGIN));
        this.PLUGIN.getCommand("nospawner").setTabCompleter(new TabCompleter());
    }

    /**
     * Load the default config
     */
    public void loadDefaultConfig() {
        CONFIG.addDefault("NoSpawner.Prefix", "&7[&bNo&3Spawner&7]");
        CONFIG.addDefault("NoSpawner.disabled-worlds", Arrays.asList("world", "world_nether"));
        CONFIG.options().copyDefaults(true);
        this.PLUGIN.saveConfig();
        this.SPAWNER_EVENT.loadWorldsConfig();
    }

}
