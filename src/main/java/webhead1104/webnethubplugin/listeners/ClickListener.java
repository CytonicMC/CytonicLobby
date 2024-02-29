package webhead1104.webnethubplugin.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickListener implements Listener {

    webhead1104.WebNetHubPlugin.WebNetHubPlugin plugin;
    public ClickListener(WebNetHubPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onClick(PlayerInteractEvent event) {
        if (event.getAction().isRightClick() && event.getItem() != null && event.getItem().getType() == Material.COMPASS) {
                plugin.gameMenu(event.getPlayer());
        }
    }
}