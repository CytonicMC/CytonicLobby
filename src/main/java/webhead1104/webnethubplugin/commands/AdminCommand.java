package webhead1104.webnethubplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import webhead1104.webnethubplugin.WebNetHubPlugin;

public class AdminCommand implements CommandExecutor {

    WebNetHubPlugin plugin;
    public AdminCommand(WebNetHubPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;
        if (player.hasPermission("webnet.hub.reload")) {
            plugin.reloadConfig();
        }else player.sendMessage(ChatColor.RED + "You cannot do this");
        return true;
    }
}
