package net.cytonic.cytoniclobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import net.cytonic.cytoniclobby.CytonicLobby;

public class DeathListener implements Listener {

    CytonicLobby plugin;
    public DeathListener(CytonicLobby plugin) {this.plugin = plugin;}

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.getPlayer().teleport(plugin.getSpawnLocation());
        e.getPlayer().getInventory().setItem(0,plugin.getItems().compass);
        e.getPlayer().getInventory().setItem(8,plugin.getItems().lobbySelector);
    }
}