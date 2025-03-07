package net.glasscrab.iridium.opal;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Equippable;
import io.papermc.paper.datacomponent.item.ItemEnchantments;
import net.glasscrab.iridium.ItemManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;


public class OpalRecipies implements Listener {

    private final ItemManager itemManager;
    public OpalRecipies(ItemManager itemManager, Plugin plugin){
        this.itemManager = itemManager;
    }

    @EventHandler
    public void onOpalUpgrade(PlayerSwapHandItemsEvent e){
        if(e.getOffHandItem().getType().equals(Material.AIR)) return;
        if(e.getMainHandItem().getType().equals(Material.AIR)) return;
        if(!e.getMainHandItem().getData(DataComponentTypes.ITEM_MODEL).value().equals("charged_opal")) return;
        if(!itemManager.isOpalUpgradeableItem(e.getOffHandItem())) return;

        ItemStack opal = e.getMainHandItem();
        ItemStack upgradeableTool = e.getOffHandItem();

        e.setCancelled(true);

        if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().equals("iridium_flint_and_steel")){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.UNBREAKING) && upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING) >= 3 && upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING) < 6){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING);
                upgradeableTool.removeEnchantment(Enchantment.UNBREAKING);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.UNBREAKING,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", "opal_flint_and_steel"));
                    String newName = e.getOffHandItem().getItemMeta().getItemName().replace("Iridium", "◎ Iridium");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text("◎ Opal and Iridium"));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 4:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 5:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().equals("iridium_warped_fungus_on_a_stick")){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.UNBREAKING) && upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING) >= 3 && upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING) < 6){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING);
                upgradeableTool.removeEnchantment(Enchantment.UNBREAKING);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.UNBREAKING,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text("◎ Warped Fungus on an Iridium Stick"));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 4:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 5:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().equals("iridium_carrot_on_a_stick")){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.UNBREAKING) && upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING) >= 3 && upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING) < 6){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING);
                upgradeableTool.removeEnchantment(Enchantment.UNBREAKING);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.UNBREAKING,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text("◎ Carrot on an Iridium Stick"));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 4:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 5:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().equals("iridium_crossbow") || e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().equals("opal_crossbow")){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.QUICK_CHARGE) && upgradeableTool.getEnchantmentLevel(Enchantment.QUICK_CHARGE) >= 3 && upgradeableTool.getEnchantmentLevel(Enchantment.QUICK_CHARGE) < 5){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.QUICK_CHARGE);
                upgradeableTool.removeEnchantment(Enchantment.QUICK_CHARGE);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.QUICK_CHARGE,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text("◎ Iridium Crossbow"));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 4:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 5:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(itemManager.opalUpgradeEfficiency(e.getOffHandItem())){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.EFFICIENCY) && upgradeableTool.getEnchantmentLevel(Enchantment.EFFICIENCY) >= 5 && upgradeableTool.getEnchantmentLevel(Enchantment.EFFICIENCY) < 10){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.EFFICIENCY);
                upgradeableTool.removeEnchantment(Enchantment.EFFICIENCY);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.EFFICIENCY,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    String newName = e.getOffHandItem().getItemMeta().getItemName().replace("Iridium", "◎ Iridium");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text(newName));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 7:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.890899f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 8:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 9:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.334840f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 10:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(itemManager.opalUpgradeUnbreaking(e.getOffHandItem())){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.UNBREAKING) && upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING) >= 3 && upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING) < 6){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.UNBREAKING);
                upgradeableTool.removeEnchantment(Enchantment.UNBREAKING);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.UNBREAKING,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    String newName = e.getOffHandItem().getItemMeta().getItemName().replace("Iridium", "◎ Iridium");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text(newName));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 4:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 5:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(itemManager.opalUpgradeLure(e.getOffHandItem())){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.LURE) && upgradeableTool.getEnchantmentLevel(Enchantment.LURE) >= 3 && upgradeableTool.getEnchantmentLevel(Enchantment.LURE) < 6){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.LURE);
                upgradeableTool.removeEnchantment(Enchantment.LURE);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.LURE,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    String newName = e.getOffHandItem().getItemMeta().getItemName().replace("Iridium", "◎ Iridium");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text(newName));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 4:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 5:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(itemManager.opalUpgradeProtection(e.getOffHandItem())){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.PROTECTION) && upgradeableTool.getEnchantmentLevel(Enchantment.PROTECTION) >= 4 && upgradeableTool.getEnchantmentLevel(Enchantment.PROTECTION) < 8){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.PROTECTION);
                upgradeableTool.removeEnchantment(Enchantment.PROTECTION);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.PROTECTION,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    Equippable.Builder equippable = e.getOffHandItem().getData(DataComponentTypes.EQUIPPABLE).toBuilder()
                            .assetId(new NamespacedKey("opal", "opal"));
                    e.getOffHandItem().setData(DataComponentTypes.EQUIPPABLE, equippable);
                    String newName = e.getOffHandItem().getItemMeta().getItemName().replace("Iridium", "◎ Iridium");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text(newName));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 5:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.890899f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 7:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 8:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(itemManager.opalUpgradePower(e.getOffHandItem())){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.POWER) && upgradeableTool.getEnchantmentLevel(Enchantment.POWER) >= 5 && upgradeableTool.getEnchantmentLevel(Enchantment.POWER) < 10){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.POWER);
                upgradeableTool.removeEnchantment(Enchantment.POWER);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.POWER,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    String newName = e.getOffHandItem().getItemMeta().getItemName().replace("Iridium", "◎ Iridium");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text(newName));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 7:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.890899f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 8:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 9:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.334840f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 10:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(itemManager.opalUpgradeSharpness(e.getOffHandItem())){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.SHARPNESS) && upgradeableTool.getEnchantmentLevel(Enchantment.SHARPNESS) >= 5 && upgradeableTool.getEnchantmentLevel(Enchantment.SHARPNESS) < 10){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.SHARPNESS);
                upgradeableTool.removeEnchantment(Enchantment.SHARPNESS);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.SHARPNESS,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    String newName = e.getOffHandItem().getItemMeta().getItemName().replace("Iridium", "◎ Iridium");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text(newName));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);
                switch (enchLevel+1){
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 7:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.890899f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 8:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 9:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.334840f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 10:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }
                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }

        else if(itemManager.opalUpgradeDensity(e.getOffHandItem())){
            if(upgradeableTool.getEnchantments().containsKey(Enchantment.DENSITY) && upgradeableTool.getEnchantmentLevel(Enchantment.DENSITY) >= 5 && upgradeableTool.getEnchantmentLevel(Enchantment.DENSITY) < 10){
                int enchLevel = upgradeableTool.getEnchantmentLevel(Enchantment.DENSITY);
                upgradeableTool.removeEnchantment(Enchantment.DENSITY);
                e.getOffHandItem().addUnsafeEnchantment(Enchantment.DENSITY,enchLevel+1);
                e.getMainHandItem().setAmount(e.getMainHandItem().getAmount()-1);

                if(e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().contains("iridium")){
                    String newModel = e.getOffHandItem().getData(DataComponentTypes.ITEM_MODEL).value().replace("iridium", "opal");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_MODEL, new NamespacedKey("opal", newModel));
                    String newName = e.getOffHandItem().getItemMeta().getItemName().replace("Iridium", "◎ Iridium");
                    e.getOffHandItem().setData(DataComponentTypes.ITEM_NAME, Component.text(newName));
                    e.getOffHandItem().setData(DataComponentTypes.TOOLTIP_STYLE, new NamespacedKey("minecraft", "opal"));
                }

                e.getPlayer().getInventory().setItemInMainHand(upgradeableTool);
                e.getPlayer().getInventory().setItemInOffHand(opal);


                switch (enchLevel+1){
                    case 6:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.707107f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 7:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,0.890899f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 8:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.059463f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 9:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.334840f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                    case 10:
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, SoundCategory.PLAYERS,1,1.414214f);
                        e.getPlayer().getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_COPPER_GRATE_STEP, SoundCategory.PLAYERS,1,1);
                        break;
                }

                e.getPlayer().swingOffHand();

            }
            else{
                e.getPlayer().sendActionBar(Component.text("This item cannot be inset",TextColor.fromCSSHexString("#FF5555")));
            }
        }
    }

}
