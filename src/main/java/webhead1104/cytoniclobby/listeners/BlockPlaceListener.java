package webhead1104.cytoniclobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import webhead1104.cytoniclobby.CytonicLobby;

public class BlockPlaceListener implements Listener {

    CytonicLobby plugin;

    public BlockPlaceListener(CytonicLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlace(BlockPlaceEvent event) {
        event.setCancelled(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE));
    }
}
