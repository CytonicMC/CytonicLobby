package webhead1104.webnetlobby.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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

        if (clickedInventory != null && clickedItem != null && clickedItem.hasItemMeta() && clickedItem.getItemMeta().hasDisplayName()) {
            if (clickedInventory == plugin.compassMenu) {
                if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.RED + "Click to play bedwars!")) {
                    Bukkit.dispatchCommand(event.getWhoClicked(), "bedwars");
                    event.setCancelled(true);
                }
                if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.RED +""+ ChatColor.BOLD + "COMING SOON")) event.setCancelled(true);
            }


            if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.RED + "Click to open the game menu!")) {
                event.setCancelled(!event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE));
            }
            if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.AQUA + "Lobby Selector")) {
                event.setCancelled(!event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE));
            }


            //lobbys
            if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.AQUA + "Lobby 1")) {
                Bukkit.dispatchCommand(event.getWhoClicked(), "lobby 1");
                event.setCancelled(!event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE));
            }

            if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.AQUA + "Lobby 2")) {
                Bukkit.dispatchCommand(event.getWhoClicked(), "lobby 2");
                event.setCancelled(!event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE));
            }

            if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.AQUA + "Lobby 3")) {
                Bukkit.dispatchCommand(event.getWhoClicked(), "lobby 3");
                event.setCancelled(!event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE));
            }

            if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.AQUA + "Lobby 4")) {
                Bukkit.dispatchCommand(event.getWhoClicked(), "lobby 4");
                event.setCancelled(!event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE));
            }
            if (clickedItem.getItemMeta().getDisplayName().contains(ChatColor.AQUA + "Lobby 5")) {
                Bukkit.dispatchCommand(event.getWhoClicked(), "lobby 5");
                event.setCancelled(!event.getWhoClicked().getGameMode().equals(GameMode.CREATIVE));
            }
        }
    }
}



