package webhead1104.webnetlobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import webhead1104.webnetlobby.WebNetLobby;

public class DeathListener implements Listener {

    WebNetLobby plugin;
    public DeathListener(WebNetLobby plugin) {this.plugin = plugin;}

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.getPlayer().teleport(plugin.getSpawnLocation());
        e.getPlayer().getInventory().setItem(0,plugin.getItems().compass);
        e.getPlayer().getInventory().setItem(8,plugin.getItems().lobbySelector);
    }
}