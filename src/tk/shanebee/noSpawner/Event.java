package tk.shanebee.noSpawner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

public class Event implements Listener {

    @EventHandler
    public void onSpawn(SpawnerSpawnEvent event) {
        event.setCancelled(true);
    }
}
