package webhead1104.webnethubplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import webhead1104.webnethubplugin.listeners.ClickListener;
import webhead1104.webnethubplugin.listeners.JoinListener;

import java.util.List;

public final class WebNetHubPlugin extends JavaPlugin {

    public ItemStack compass = new ItemStack(Material.COMPASS);
    public ItemStack bedwarsLobby = new ItemStack(Material.RED_BED);
    @Override
    public void onEnable() {
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName(ChatColor.RED + "Game Selector");
        compassMeta.setLore(List.of(ChatColor.GOLD + "Click to select a game!"));
        compass.setItemMeta(compassMeta);

        ItemMeta bedwarsLobbyMeta = bedwarsLobby.getItemMeta();
        bedwarsLobbyMeta.setDisplayName(ChatColor.RED + "Click to play bedwars!");
        bedwarsLobby.setItemMeta(bedwarsLobbyMeta);

        registerListeners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new ClickListener(this), this);
    }


}
