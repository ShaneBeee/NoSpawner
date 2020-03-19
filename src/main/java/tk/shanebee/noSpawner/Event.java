package tk.shanebee.noSpawner;

import org.bukkit.World;
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
        World worldWhereMobHasSpawned = event.getLocation().getWorld();
        if (noSpawnerIsEnabledForAllWorlds() || spawnerIsEnabledInWorld(worldWhereMobHasSpawned)) {
            event.setCancelled(true);
        }
    }

    private boolean noSpawnerIsEnabledForAllWorlds(){
        return plugin.getConfig().getBoolean("NoSpawner.enableForAllWorlds");
    }

    private boolean spawnerIsEnabledInWorld(World world){
        String worldName = world.getName();
        return plugin.getConfig().getStringList("NoSpawner.enableSpawnersInWorld")
                .stream().noneMatch(worldName::equals);
    }

}
