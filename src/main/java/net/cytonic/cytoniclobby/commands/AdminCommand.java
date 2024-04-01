package net.cytonic.cytoniclobby.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import net.cytonic.cytoniclobby.CytonicLobby;

public class AdminCommand implements CommandExecutor {

    CytonicLobby plugin;
    public AdminCommand(CytonicLobby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;
        if (args[0].equalsIgnoreCase("reload")) {
            if (player.hasPermission("cytonic.hub.reload")) {
                plugin.reloadConfig();
            } else player.sendMessage(ChatColor.RED + "You cannot do this");
        }
        return true;
    }
}