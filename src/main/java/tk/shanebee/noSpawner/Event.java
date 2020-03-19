package tk.shanebee.noSpawner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;


public class Event implements Listener {

    private Main plugin;

    Event(Main instance) {
        plugin = instance;
    }


    @EventHandler
    public void onSpawn(SpawnerSpawnEvent event) {
        if (plugin.getConfig().getBoolean("NoSpawner.enabled")) {

            event.setCancelled(true);
        }
    }
}
