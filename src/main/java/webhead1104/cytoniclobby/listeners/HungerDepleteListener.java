package webhead1104.cytoniclobby.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import webhead1104.cytoniclobby.CytonicLobby;

public class HungerDepleteListener implements Listener {

    CytonicLobby plugin;
    public HungerDepleteListener(CytonicLobby plugin) {this.plugin = plugin;}

    @EventHandler
    public void onHungerDeplete(FoodLevelChangeEvent e) {
        e.getEntity().setFoodLevel(20);
        e.setCancelled(true);
    }
}