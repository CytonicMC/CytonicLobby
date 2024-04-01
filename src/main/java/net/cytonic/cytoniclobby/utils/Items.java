package net.cytonic.cytoniclobby.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import net.cytonic.cytoniclobby.CytonicLobby;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items {

    private final CytonicLobby plugin = CytonicLobby.INSTANCE;
    private final Map<String, ItemStack> itemRegistry = new HashMap<>();
    public NamespacedKey NAMESPACE = new NamespacedKey(plugin, "hubID");
    public NamespacedKey MOVE_BLACKLIST = new NamespacedKey(plugin, "move_blacklist");
    public NamespacedKey ALLOWED_SLOTS = new NamespacedKey(plugin, "allowed_slots");
    public NamespacedKey NO_DROP = new NamespacedKey(plugin, "no_drop");

    public ItemStack compass = createItem(ChatColor.RED + "Click to open the game menu!","COMPASS",Material.COMPASS);
    public ItemStack bedwarsLobby = createItem(ChatColor.RED + "Click to play bedwars!", "BEDWARS",Material.RED_BED);
    public ItemStack comingSoon = createItem(ChatColor.RED +""+ ChatColor.BOLD + "COMING SOON", "COMING_SOON",Material.BLACK_CONCRETE);
    public ItemStack lobbySelector = createItem(ChatColor.AQUA + "Lobby Selector","LOBBY_SELECTOR",Material.RECOVERY_COMPASS);

    public ItemStack lobby1 = createItem(ChatColor.AQUA + "Lobby 1","LOBBY_1",Material.WOODEN_AXE,"Click to go to lobby 1");
    public ItemStack lobby2 = createItem(ChatColor.AQUA + "Lobby 2","LOBBY_2",Material.STONE_AXE,"Click to go to lobby 2");
    public ItemStack lobby3 = createItem(ChatColor.AQUA + "Lobby 3","LOBBY_3",Material.IRON_AXE,"Click to go to lobby 3");
    public ItemStack lobby4 = createItem(ChatColor.AQUA + "Lobby 4","LOBBY_4",Material.GOLDEN_AXE,"Click to go to lobby 4");
    public ItemStack lobby5 = createItem(ChatColor.AQUA + "Lobby 5","LOBBY_5",Material.DIAMOND_AXE,"Click to go to lobby 5");

    private ItemStack createItem(String displayname, String id, Material type, boolean noMove, boolean noDrop, List<Integer> allowedSlots, String... lore){
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + displayname);
        meta.setLore(List.of(lore));
        meta.addItemFlags(ItemFlag.values());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        meta.setUnbreakable(true);
        if(noDrop) {
            pdc.set(NO_DROP, PersistentDataType.BOOLEAN, true);
        }
        if(noMove) {
            pdc.set(MOVE_BLACKLIST, PersistentDataType.BOOLEAN, true);
            pdc.set(ALLOWED_SLOTS, PersistentDataType.INTEGER_ARRAY, allowedSlots.stream().mapToInt(Integer::intValue).toArray());
        }
        pdc.set(NAMESPACE, PersistentDataType.STRING, id);

        item.setItemMeta(meta);
        itemRegistry.put(id, item);
        return item;
    }

    private ItemStack createItem(String displayname, String id, Material type, String... lore){
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + displayname);
        meta.setLore(List.of(lore));
        meta.addItemFlags(ItemFlag.values());
        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        meta.setUnbreakable(true);
        pdc.set(NAMESPACE, PersistentDataType.STRING, id);
        item.setItemMeta(meta);
        itemRegistry.put(id, item);
        return item;
    }
}