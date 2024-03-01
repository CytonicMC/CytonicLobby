package webhead1104.webnetlobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import webhead1104.webnetlobby.commands.AdminCommand;
import webhead1104.webnetlobby.commands.MenuCommand;
import webhead1104.webnetlobby.commands.SpawnCommand;
import webhead1104.webnetlobby.listeners.*;
import webhead1104.webnetlobby.utils.Items;

import java.io.File;
import java.util.List;

public final class WebNetLobby extends JavaPlugin {

    public static WebNetLobby INSTANCE;
    Items items;
    public Inventory compassMenu = Bukkit.createInventory(null, 54, ChatColor.BLACK + "Game Selector");
    @Override
    public void onEnable() {
        File file = new File("plugins/WebNetHubPlugin/config.yml");
        if(!file.exists())
            this.saveResource("config.yml", false);
        INSTANCE = this;
        items = new Items();
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
        getServer().getPluginManager().registerEvents(new ClickListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);

    }

    public void registerCommands() {
        getCommand("menu").setExecutor(new MenuCommand(this));
        getCommand("menu").setAliases(List.of("gamemenu","games"));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("hubadmin").setExecutor(new AdminCommand(this));
    }

    public void gameMenu(Player player) {
        compassMenu.setItem(20,items.bedwarsLobby);
        compassMenu.setItem(24, items.comingSoon);
        player.openInventory(compassMenu);
    }

    public Items getItems() {
        return items;
    }

    public Location getSpawnLocation() {
        return new Location(
                Bukkit.getWorld("world"),
                getConfig().getDouble("x"),
                getConfig().getDouble("y"),
                getConfig().getDouble("z"),
                (float) getConfig().getDouble("yaw"),
                (float) getConfig().getDouble("pitch")
        );
    }
}