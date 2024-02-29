package webhead1104.webnethubplugin.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import webhead1104.webnethubplugin.WebNetHubPlugin;

public class BlockBreakListener implements Listener {

    WebNetHubPlugin plugin;

    public BlockBreakListener(WebNetHubPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onBreak(BlockBreakEvent event) {
        event.setCancelled(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE));
    }
}
