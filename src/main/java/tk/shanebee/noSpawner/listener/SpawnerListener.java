package tk.shanebee.noSpawner.listener;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import tk.shanebee.noSpawner.NoSpawner;

import java.util.List;

class SpawnerListener implements Listener {

    private final NoSpawner PLUGIN;
    private List<String> WORLDS_LIST;

    SpawnerListener(NoSpawner plugin) {
        this.PLUGIN = plugin;
    }

    void loadWorldsConfig() {
        this.WORLDS_LIST = this.PLUGIN.getConfig().getStringList("NoSpawner.enableSpawnersInWorld");
    }

    @EventHandler
    private void onSpawn(SpawnerSpawnEvent event) {
        if (event.isCancelled()) return;
        World world = event.getLocation().getWorld();
        if (world == null) return;

        if (this.WORLDS_LIST.contains(world.getName())) {
            event.setCancelled(true);
        }
    }

}
