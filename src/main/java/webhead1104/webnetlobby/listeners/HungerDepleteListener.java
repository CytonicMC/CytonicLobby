package webhead1104.webnetlobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import webhead1104.webnetlobby.WebNetLobby;

public class HungerDepleteListener implements Listener {

   WebNetLobby plugin;
    public HungerDepleteListener(WebNetLobby plugin) {this.plugin = plugin;}

    @EventHandler
    public void onHungerDeplete(FoodLevelChangeEvent e) {
        e.getEntity().setFoodLevel(20);
        e.setCancelled(true);
    }
}