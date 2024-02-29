package webhead1104.webnethubplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import webhead1104.webnethubplugin.WebNetHubPlugin;

public class InventoryClickListener implements Listener {


    WebNetHubPlugin plugin;

    public InventoryClickListener(WebNetHubPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        if (event.getCursor() == plugin.bedwarsLobby){
            Bukkit.dispatchCommand(event.getWhoClicked(), "bedwars");
        }
    }
}
