package webhead1104.webnethubplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import webhead1104.webnethubplugin.WebNetHubPlugin;

public class JoinListener implements Listener {

    WebNetHubPlugin plugin;
    public JoinListener(WebNetHubPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        p.setInvulnerable(true);
        p.getInventory().clear();




    }
}
