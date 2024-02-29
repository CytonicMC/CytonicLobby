package webhead1104.webnethubplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import webhead1104.webnethubplugin.WebNetHubPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items {

    private final WebNetHubPlugin plugin = WebNetHubPlugin.INSTANCE;
    private final Map<String, ItemStack> itemRegistry = new HashMap<>();
    public NamespacedKey NAMESPACE = new NamespacedKey(plugin, "hubID");
    public NamespacedKey MOVE_BLACKLIST = new NamespacedKey(plugin, "move_blacklist");
    public NamespacedKey ALLOWED_SLOTS = new NamespacedKey(plugin, "allowed_slots");
    public NamespacedKey NO_DROP = new NamespacedKey(plugin, "no_drop");


    public ItemStack compass = createItem(ChatColor.RED + "Click to open the game menu!","COMPASS",Material.COMPASS);
    public ItemStack bedwarsLobby = createItem(ChatColor.RED + "Click to play bedwars!", "BEDWARS",Material.RED_BED);
    public ItemStack comingSoon = createItem(ChatColor.RED +""+ ChatColor.BOLD + "COMING SOON", "COMING_SOON",Material.BLACK_CONCRETE);










    private ItemStack createItem(String displayname, String id, Material type, boolean noMove, boolean noDrop, List<Integer> allowedSlots, Map<Enchantment, Integer> enchants, String... lore){
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RESET + displayname);
        meta.setLore(List.of(lore));
        meta.addItemFlags(ItemFlag.values());
        enchants.forEach((enchantment, integer) -> meta.addEnchant(enchantment, integer, true));
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
