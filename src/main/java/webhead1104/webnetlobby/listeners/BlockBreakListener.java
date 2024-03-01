package webhead1104.webnetlobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import webhead1104.webnetlobby.WebNetLobby;

public class BlockBreakListener implements Listener {

    WebNetLobby plugin;

    public BlockBreakListener(WebNetLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onBreak(BlockBreakEvent event) {
        event.setCancelled(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE));
    }
}
