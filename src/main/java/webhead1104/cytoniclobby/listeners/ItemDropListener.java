package webhead1104.cytoniclobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import webhead1104.cytoniclobby.CytonicLobby;

public class ItemDropListener implements Listener {

    CytonicLobby plugin;
    public ItemDropListener(CytonicLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onDrop(PlayerDropItemEvent event) {
        event.setCancelled(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE));
    }



    @EventHandler
    private void onOffhand(PlayerSwapHandItemsEvent event) {
        event.setCancelled(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE));
    }
}