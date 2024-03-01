package webhead1104.webnetlobby.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import webhead1104.webnetlobby.WebNetLobby;

public class AdminCommand implements CommandExecutor {

    WebNetLobby plugin;

    public AdminCommand(WebNetLobby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;
        if (args[0].equalsIgnoreCase("reload")) {
            if (player.hasPermission("webnet.hub.reload")) {
                plugin.reloadConfig();
            } else player.sendMessage(ChatColor.RED + "You cannot do this");
        }
        return true;
    }
}