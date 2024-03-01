package webhead1104.webnetlobby.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import webhead1104.webnetlobby.WebNetLobby;

public class ClickListener implements Listener {

    WebNetLobby plugin;
    public ClickListener(WebNetLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onClick(PlayerInteractEvent event) {
        if (event.getAction().isRightClick() && event.getItem() != null && event.getItem().getType() == Material.COMPASS) {
                plugin.gameMenu(event.getPlayer());
        }
    }
}