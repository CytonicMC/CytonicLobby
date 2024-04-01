package net.cytonic.cytoniclobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import net.cytonic.cytoniclobby.CytonicLobby;

public class MenuCommand implements CommandExecutor {

    CytonicLobby plugin;
    public MenuCommand(CytonicLobby plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player player = (Player) commandSender;
        plugin.gameMenu(player);
        return true;
    }
}