package tk.shanebee.noSpawner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import tk.shanebee.noSpawner.listener.ListenerManager;

public class NoSpawner extends JavaPlugin {

    private final FileConfiguration config = this.getConfig();
    private ListenerManager listenerManager;

    @Override
    public void onEnable() {
        log("Loading config...");
        this.listenerManager = new ListenerManager(this);
        log("&aSuccessfully loaded!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Successfully unloaded!");
    }

    /**
     * Get the plugin's listener manager
     *
     * @return Listener Manager
     */
    public ListenerManager getListenerManager() {
        return listenerManager;
    }

    /**
     * Log a message to console
     * <p>Will include the plugin's prefix</p>
     *
     * @param message Message to log to console
     */
    public void log(@NotNull String message) {
        String prefix = this.config.getString("NoSpawner.Prefix", "&7[&bNo&3Spawner&7]");
        Bukkit.getConsoleSender().sendMessage(getColString(prefix + " " + message));
    }

    /**
     * Get a colored string
     *
     * @param string String with color codes
     * @return String that has color applied
     */
    public String getColString(@NotNull String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
