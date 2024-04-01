package net.cytonic.cytoniclobby.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import net.cytonic.cytoniclobby.CytonicLobby;

public class BlockBreakListener implements Listener {

    CytonicLobby plugin;
    public BlockBreakListener(CytonicLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onBreak(BlockBreakEvent event) {
        event.setCancelled(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE));
    }
}