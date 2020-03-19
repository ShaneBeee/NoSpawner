package tk.shanebee.noSpawner.listener;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TabCompleter implements org.bukkit.command.TabCompleter {

    private static final List<String> COMMANDS = Arrays.asList("reload", "about");
    private static final List<String> BLANK = Arrays.asList("", "");

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] args) {
        if (cmd.getName().equalsIgnoreCase("nospawner")) {
            if (args.length <= 1) {
                return StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<>());
            }
        } return BLANK;
    }

}
