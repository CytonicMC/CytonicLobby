package webhead1104.cytoniclobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import webhead1104.cytoniclobby.CytonicLobby;

import java.util.Objects;

public class JoinListener implements Listener {

    CytonicLobby plugin;
    public JoinListener(CytonicLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        String rank = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(plugin.getConfig().getString("rank")));
        event.setJoinMessage(null);
        Player p = event.getPlayer();
        p.setInvulnerable(true);
        p.getInventory().clear();
        p.getInventory().setItem(0,plugin.getItems().compass);
        p.getInventory().setItem(8,plugin.getItems().lobbySelector);
        p.teleport(plugin.getSpawnLocation());
        p.setHealth(20);
        p.setSaturation(20);
        p.setGameMode(GameMode.SURVIVAL);
        if (!p.hasPlayedBefore()) {
            Bukkit.broadcastMessage(ChatColor.BLUE + rank + " " +ChatColor.DARK_GREEN + p.getName() + ChatColor.GOLD + " has joined for the first time!");
        }else Bukkit.broadcastMessage(ChatColor.BLUE + rank + " " +ChatColor.DARK_GREEN + p.getName() + ChatColor.GOLD +" joined the lobby");





    }
}
