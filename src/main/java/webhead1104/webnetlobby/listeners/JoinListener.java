package webhead1104.webnetlobby.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import webhead1104.webnetlobby.WebNetLobby;

public class JoinListener implements Listener {

    WebNetLobby plugin;
    public JoinListener(WebNetLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        p.setInvulnerable(true);
        p.getInventory().clear();
        p.getInventory().setItem(0,plugin.getItems().compass);
        p.teleport(plugin.getSpawnLocation());




    }
}
