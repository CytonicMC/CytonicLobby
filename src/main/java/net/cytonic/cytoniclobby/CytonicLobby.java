package net.cytonic.cytoniclobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import net.cytonic.cytoniclobby.commands.AdminCommand;
import net.cytonic.cytoniclobby.commands.MenuCommand;
import net.cytonic.cytoniclobby.commands.SpawnCommand;
import net.cytonic.cytoniclobby.listeners.*;
import net.cytonic.cytoniclobby.utils.Items;
import java.io.File;
import java.util.List;

public final class CytonicLobby extends JavaPlugin {

    public static CytonicLobby INSTANCE;
    Items items;
    public Inventory compassMenu = Bukkit.createInventory(null, 54, ChatColor.BLACK + "Game Selector");
    public Inventory lobbyMenu = Bukkit.createInventory(null,54,ChatColor.BLUE + "Lobby Selector");
    @Override
    public void onEnable() {
        File file = new File("plugins/cytonicLobby/config.yml");
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
        getServer().getPluginManager().registerEvents(new ItemDropListener(this), this);
        getServer().getPluginManager().registerEvents(new QuitListener(this), this);
        getServer().getPluginManager().registerEvents(new HungerDepleteListener(this), this);
        getServer().getPluginManager().registerEvents(new DeathListener(this), this);

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
    public void lobbyMenu(Player player) {
        lobbyMenu.setItem(10,items.lobby1);
        lobbyMenu.setItem(11,items.lobby2);
        lobbyMenu.setItem(12,items.lobby3);
        lobbyMenu.setItem(13,items.lobby4);
        lobbyMenu.setItem(14,items.lobby5);
        player.openInventory(lobbyMenu);
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