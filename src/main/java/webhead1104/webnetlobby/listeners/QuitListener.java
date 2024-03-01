package webhead1104.webnetlobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import webhead1104.webnetlobby.WebNetLobby;

public class QuitListener implements Listener {

    WebNetLobby plugin;

    public QuitListener(WebNetLobby plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }
}
