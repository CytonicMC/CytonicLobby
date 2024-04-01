package net.cytonic.cytoniclobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import net.cytonic.cytoniclobby.CytonicLobby;

public class QuitListener implements Listener {

    CytonicLobby plugin;
    public QuitListener(CytonicLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
}