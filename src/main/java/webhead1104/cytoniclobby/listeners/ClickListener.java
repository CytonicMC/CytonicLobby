package webhead1104.cytoniclobby.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import webhead1104.cytoniclobby.CytonicLobby;

public class ClickListener implements Listener {

    CytonicLobby plugin;

    public ClickListener(CytonicLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onClick(PlayerInteractEvent event) {
        event.setCancelled(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE));
        if (event.getItem() != null && event.getItem().getType() == Material.COMPASS &&
                event.getItem().getItemMeta().getDisplayName().contains(ChatColor.RED + "Click to open the game menu!")) {
            plugin.gameMenu(event.getPlayer());
        }
        if (event.getItem() != null && event.getItem().getItemMeta().getDisplayName().contains(ChatColor.AQUA + "Lobby Selector")) {
            plugin.lobbyMenu(event.getPlayer());
        }

    }
}