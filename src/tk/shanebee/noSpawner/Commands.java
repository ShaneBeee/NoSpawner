package tk.shanebee.noSpawner;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;


public class Commands implements CommandExecutor {

    private final Main plugin;

    Commands(Main instance) {
        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("nospawner")) {
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                sender.sendMessage(ChatColor.GREEN + "Config reloaded successfully!");
            } else if (args[0].equalsIgnoreCase("about")) {

                PluginDescriptionFile desc = plugin.getDescription();
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "About NoSpawner");
                sender.sendMessage(ChatColor.GOLD + "Version: " + ChatColor.AQUA + desc.getVersion());
                sender.sendMessage(ChatColor.GOLD + "Author: " + ChatColor.AQUA + desc.getAuthors());

            }
        }
        return true;
    }

}
