package webhead1104.webnethubplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import webhead1104.webnethubplugin.WebNetHubPlugin;

public class ClickListener implements Listener {


    WebNetHubPlugin plugin;

    public ClickListener(WebNetHubPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onClick(PlayerInteractEvent event) {
        if (event.getItem() == plugin.compass) {
            Inventory compassMenu = Bukkit.createInventory(null,53, ChatColor.GREEN + "Game Selector");

            compassMenu.setItem(20, plugin.bedwarsLobby);

        }
    }
}
