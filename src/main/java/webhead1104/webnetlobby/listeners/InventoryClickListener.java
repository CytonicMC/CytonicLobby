package webhead1104.webnetlobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import webhead1104.webnetlobby.WebNetLobby;

public class InventoryClickListener implements Listener {


    WebNetLobby plugin;

    public InventoryClickListener(WebNetLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        ItemStack clickedItem = event.getCurrentItem();

        if (clickedInventory != null && clickedItem != null) {
            if (clickedInventory == plugin.compassMenu)
                if (clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName()) {
                    if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.RED + "Click to play bedwars!")) {
                        Bukkit.dispatchCommand(event.getWhoClicked(), "bedwars");
                        event.setCancelled(true);
                    }
            }
        }
    }
}