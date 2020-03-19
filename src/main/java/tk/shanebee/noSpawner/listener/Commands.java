package tk.shanebee.noSpawner.listener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.jetbrains.annotations.NotNull;
import tk.shanebee.noSpawner.NoSpawner;

class Commands implements CommandExecutor {

    private final NoSpawner PLUGIN;

    Commands(NoSpawner plugin) {
        this.PLUGIN = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                this.PLUGIN.reloadConfig();
                this.PLUGIN.getListenerManager().loadDefaultConfig();
                sendMessage(sender, "&aConfig reloaded successfully!");
            } else if (args[0].equalsIgnoreCase("about")) {
                PluginDescriptionFile desc = PLUGIN.getDescription();
                sendMessage(sender, "&6&lAbout NoSpawner");
                sendMessage(sender, "&6Version: &b" + desc.getVersion());
                sendMessage(sender, "&6Author: &b" + desc.getAuthors());
            }
        }
        return true;
    }

    private void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(this.PLUGIN.getColString(message));
    }

}
