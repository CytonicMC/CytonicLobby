package webhead1104.webnetlobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import webhead1104.webnetlobby.WebNetLobby;

public class BlockPlaceListener implements Listener {

    WebNetLobby plugin;

    public BlockPlaceListener(WebNetLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onPlace(BlockPlaceEvent event) {
        event.setCancelled(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE));
    }
}
