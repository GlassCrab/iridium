package net.glasscrab.iridium.iridium;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Equippable;
import net.glasscrab.iridium.ItemManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class IridiumArmorVanishEvent implements Listener {

    private final ItemManager itemManager;
    private final Plugin plugin;
    public IridiumArmorVanishEvent(ItemManager itemManager, Plugin plugin){
        this.itemManager = itemManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void IridiumArmorVanish(PlayerInteractEvent e){
        if(!e.getPlayer().isSneaking()) return;
        if(e.getAction() != Action.LEFT_CLICK_AIR) return;
        if(e.getHand() != EquipmentSlot.HAND) return;
        if(e.getItem() == null) return;
        if(!itemManager.canBeInvisible(e.getItem())) return;



        ItemStack armorItem = e.getItem();

        if(e.getItem().getData(DataComponentTypes.EQUIPPABLE).assetId().namespace().equals(e.getItem().getData(DataComponentTypes.ITEM_MODEL).namespace())){
            Equippable.Builder equip = e.getItem().getData(DataComponentTypes.EQUIPPABLE).toBuilder()
                    .assetId(new NamespacedKey("invisible", e.getItem().getData(DataComponentTypes.EQUIPPABLE).assetId().value()));
            armorItem.setData(DataComponentTypes.EQUIPPABLE, equip);
            e.getPlayer().playSound(e.getPlayer(), Sound.BLOCK_CANDLE_EXTINGUISH, 1.0f, 0.5f);
            e.getPlayer().sendActionBar(Component.text("The item shimmers into a mist, no longer visible to others.", TextColor.fromCSSHexString("#a7fff0")));

        }
        else if(!e.getItem().getData(DataComponentTypes.EQUIPPABLE).assetId().namespace().equals(e.getItem().getData(DataComponentTypes.ITEM_MODEL).namespace())){

            Equippable.Builder equip = e.getItem().getData(DataComponentTypes.EQUIPPABLE).toBuilder()
                    .assetId(new NamespacedKey(e.getItem().getData(DataComponentTypes.ITEM_MODEL).namespace(), e.getItem().getData(DataComponentTypes.EQUIPPABLE).assetId().value()));
            armorItem.setData(DataComponentTypes.EQUIPPABLE, equip);
            e.getPlayer().playSound(e.getPlayer(), Sound.BLOCK_CANDLE_EXTINGUISH, 1.0f, 0.5f);
            e.getPlayer().sendActionBar(Component.text("The item solidifies back into a visible form.", TextColor.fromCSSHexString("#a7fff0")));
        }
        
        e.getPlayer().getInventory().setItemInMainHand(armorItem);
        
        
        /*if(!e.getPlayer().isSneaking()) return;
        if(!e.getItem().hasData(DataComponentTypes.ITEM_MODEL)) return;
        if(!e.getItem().hasData(DataComponentTypes.EQUIPPABLE)) return;
        if(e.getItem().getData(DataComponentTypes.EQUIPPABLE).assetId() == null) return;
        if(!itemManager.opalUpgradeProtection(e.getNewItem())) return;
        if(cd.containsKey(e.getPlayer())) return;
        cd.put(e.getPlayer(),e.getPlayer().getName());
        ItemStack newItem = e.getItem();

        if(e.getNewItem().getData(DataComponentTypes.EQUIPPABLE).assetId().namespace().equals(e.getNewItem().getData(DataComponentTypes.ITEM_MODEL).namespace())){
            Equippable.Builder equip = e.getNewItem().getData(DataComponentTypes.EQUIPPABLE).toBuilder()
                            .assetId(new NamespacedKey("invisible", e.getNewItem().getData(DataComponentTypes.EQUIPPABLE).assetId().value()));
            newItem.setData(DataComponentTypes.EQUIPPABLE, equip);
            e.getPlayer().playSound(e.getPlayer(), Sound.BLOCK_CANDLE_EXTINGUISH, 1.0f, 0.5f);
            e.getPlayer().sendActionBar(Component.text("The item shimmers into a mist, no longer visible to others.", TextColor.fromCSSHexString("#a7fff0")));

        }
        else if(!e.getNewItem().getData(DataComponentTypes.EQUIPPABLE).assetId().namespace().equals(e.getNewItem().getData(DataComponentTypes.ITEM_MODEL).namespace())){

            Equippable.Builder equip = e.getNewItem().getData(DataComponentTypes.EQUIPPABLE).toBuilder()
                    .assetId(new NamespacedKey(e.getNewItem().getData(DataComponentTypes.ITEM_MODEL).namespace(), e.getNewItem().getData(DataComponentTypes.EQUIPPABLE).assetId().value()));
            newItem.setData(DataComponentTypes.EQUIPPABLE, equip);
            e.getPlayer().playSound(e.getPlayer(), Sound.BLOCK_CANDLE_EXTINGUISH, 1.0f, 0.5f);
            e.getPlayer().sendActionBar(Component.text("The item solidifies back into a visible form.", TextColor.fromCSSHexString("#a7fff0")));
        }

        e.getPlayer().getInventory().setItemInMainHand(newItem);
        e.getPlayer().getInventory().setItem(e.getNewItem().getData(DataComponentTypes.EQUIPPABLE).slot(),e.getOldItem());

        new BukkitRunnable() {
            public void run() {
                cd.remove(e.getPlayer());
                }
            }.runTaskLater(plugin, 5);*/
    }
}
