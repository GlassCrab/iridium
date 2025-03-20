package net.glasscrab.iridium.iridium;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.registry.keys.SoundEventKeys;
import net.glasscrab.iridium.ItemManager;
import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collection;

public class IridiumPistonCraftEvent implements Listener {

    private final ItemManager itemManager;
    private final Plugin plugin;
    public IridiumPistonCraftEvent(ItemManager itemManager, Plugin plugin){
        this.itemManager = itemManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void PistonCraftEvent(BlockPistonExtendEvent e){
        if(e.getBlocks().isEmpty()) return;
        if(!e.getBlocks().getFirst().getType().equals(Material.NETHERITE_BLOCK)) return;
        if(!e.getBlocks().getFirst().getRelative(0, -2, 0).getType().equals(Material.LAVA_CAULDRON)) return;
        Block netheriteBlock = e.getBlocks().getFirst();
        Block cauldron = netheriteBlock.getRelative(0,-2,0);

        if(cauldron.getLocation().getNearbyEntitiesByType(Item.class,1.5).size() != 2) return;
        ItemStack recipeItem = new ItemStack(Material.STONE,1);
        ItemStack upgradeableItem = new ItemStack(Material.STONE, 1);
        //ItemStack iridiumFragment = new ItemStack(Material.STONE,1);
        Collection<Item> items = cauldron.getLocation().getNearbyEntitiesByType(Item.class,1);
        if (items.size() < 1) return;
        for(Item item: items){
            if(item.getItemStack().getData(DataComponentTypes.ITEM_MODEL).value().equals("iridium_ingot")){
                recipeItem = item.getItemStack();
            }
            if(itemManager.isPistonUpgradeableItem(item.getItemStack())){
                upgradeableItem = item.getItemStack();
            }
        }
        if(recipeItem.getType().equals(Material.STONE) || upgradeableItem.getType().equals(Material.STONE)) return;
        for(Item item: items){
            if(item.getItemStack().equals(recipeItem)){

                new BukkitRunnable() {

                    @Override
                    public void run() {
                        // What you want to schedule goes here
                        item.getItemStack().setAmount(item.getItemStack().getAmount()-1);
                    }

                }.runTaskLater(this.plugin, 1);

            }
            if(item.getItemStack().equals(upgradeableItem)){
                if(recipeItem.getData(DataComponentTypes.ITEM_MODEL).value().equals("iridium_ingot")){
                    switch (item.getItemStack().getData(DataComponentTypes.ITEM_MODEL).value()) {
                        case "netherite_mace":
                            item.setItemStack(itemManager.upgradeCombatTool(upgradeableItem, "Iridium Mace", new NamespacedKey("iridium", "iridium_mace"), 3046, 9, -3.4, ItemRarity.EPIC));
                            break;
                        case "netherite_shears":
                            item.setItemStack(itemManager.upgradeBasicTool(upgradeableItem, "Iridium Shears", new NamespacedKey("iridium", "iridium_shears"), 3046, ItemRarity.COMMON));
                            break;
                        case "netherite_elytra_item":
                            item.setItemStack(itemManager.upgradeBasicTool(upgradeableItem, "Iridium Elytra", new NamespacedKey("iridium", "iridium_elytra_item"), 3046, ItemRarity.EPIC));
                            break;
                        case "netherite_bow":
                            item.setItemStack(itemManager.upgradeBasicTool(upgradeableItem, "Iridium Bow", new NamespacedKey("iridium", "iridium_bow"), 3046, ItemRarity.COMMON));
                            break;
                        case "netherite_crossbow":
                            item.setItemStack(itemManager.upgradeBasicTool(upgradeableItem, "Iridium Crossbow", new NamespacedKey("iridium", "iridium_crossbow"), 3046, ItemRarity.COMMON));
                            break;
                        case "netherite_flint_and_steel":
                            item.setItemStack(itemManager.upgradeBasicTool(upgradeableItem, "Flint and Iridium", new NamespacedKey("iridium", "iridium_flint_and_steel"), 3046, ItemRarity.COMMON));
                            break;
                        case "netherite_fishing_rod":
                            item.setItemStack(itemManager.upgradeFishingRod(upgradeableItem, "Iridium Fishing Rod", new NamespacedKey("iridium", "iridium_fishing_rod"), 3046, ItemRarity.COMMON));
                            break;
                        case "netherite_carrot_on_a_stick":
                            item.setItemStack(itemManager.upgradeBasicTool(upgradeableItem, "Carrot on an Iridium Stick", new NamespacedKey("iridium", "iridium_carrot_on_a_stick"), 3046, ItemRarity.COMMON));
                            break;
                        case "netherite_warped_fungus_on_a_stick":
                            item.setItemStack(itemManager.upgradeBasicTool(upgradeableItem, "Warped Fungus on an Iridium Stick", new NamespacedKey("iridium", "iridium_warped_fungus_on_a_stick"), 3046, ItemRarity.COMMON));
                            break;
                        case "netherite_axe":
                            item.setItemStack(itemManager.upgradeMiningTool(upgradeableItem, "Iridium Axe", new NamespacedKey("iridium", "iridium_axe"), 3046, 5, ItemRarity.COMMON));
                            break;
                        case "netherite_pickaxe":
                            item.setItemStack(itemManager.upgradeMiningTool(upgradeableItem, "Iridium Pickaxe", new NamespacedKey("iridium", "iridium_pickaxe"), 3046, 5, ItemRarity.COMMON));
                            break;
                        case "netherite_shovel":
                            item.setItemStack(itemManager.upgradeMiningTool(upgradeableItem, "Iridium Shovel", new NamespacedKey("iridium", "iridium_shovel"), 3046, 5, ItemRarity.COMMON));
                            break;
                        case "netherite_hoe":
                            item.setItemStack(itemManager.upgradeMiningTool(upgradeableItem, "Iridium Hoe", new NamespacedKey("iridium", "iridium_hoe"), 3046, 5, ItemRarity.COMMON));
                            break;
                        case "netherite_sword":
                            item.setItemStack(itemManager.upgradeCombatTool(upgradeableItem, "Iridium Sword", new NamespacedKey("iridium", "iridium_sword"), 3046, 9, -2.4, ItemRarity.COMMON));
                            break;
                        case "netherite_helmet":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Helmet", new NamespacedKey("iridium", "iridium_helmet"), new NamespacedKey("iridium", "iridium"), EquipmentSlot.HEAD, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.HEAD));
                            break;
                        case "netherite_chestplate":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Chestplate", new NamespacedKey("iridium", "iridium_chestplate"), new NamespacedKey("iridium", "iridium"), EquipmentSlot.CHEST, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 9.0, 4.0, 0.1, 888, ItemRarity.COMMON, EquipmentSlotGroup.CHEST));
                            break;
                        case "netherite_leggings":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Leggings", new NamespacedKey("iridium", "iridium_leggings"), new NamespacedKey("iridium", "iridium"), EquipmentSlot.LEGS, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 7.0, 4.0, 0.1, 832, ItemRarity.COMMON, EquipmentSlotGroup.LEGS));
                            break;
                        case "netherite_boots":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Boots", new NamespacedKey("iridium", "iridium_boots"), new NamespacedKey("iridium", "iridium"), EquipmentSlot.FEET, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.FEET));
                            break;
                        case "netherite_brush":
                            item.setItemStack(itemManager.upgradeBrush(upgradeableItem, "Iridium Brush", new NamespacedKey("iridium", "iridium_brush"), 3046, 65, ItemRarity.COMMON));
                            break;
                    }
                }
                /*if(recipeItem.getData(DataComponentTypes.ITEM_MODEL).value().equals("iridium_fragment")) {
                    switch (item.getItemStack().getData(DataComponentTypes.ITEM_MODEL).value()) {
                        case "iridium_helmet":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Helmet", new NamespacedKey("iridium", "iridium_helmet"), new NamespacedKey("iridium", "invisible_iridium"), EquipmentSlot.HEAD, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.HEAD));
                            break;
                        case "iridium_chestplate":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Chestplate", new NamespacedKey("iridium", "iridium_chestplate"), new NamespacedKey("iridium", "invisible_iridium"), EquipmentSlot.CHEST, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 9.0, 4.0, 0.1, 888, ItemRarity.COMMON, EquipmentSlotGroup.CHEST));
                            break;
                        case "iridium_leggings":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Leggings", new NamespacedKey("iridium", "iridium_leggings"), new NamespacedKey("iridium", "invisible_iridium"), EquipmentSlot.LEGS, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 7.0, 4.0, 0.1, 832, ItemRarity.COMMON, EquipmentSlotGroup.LEGS));
                            break;
                        case "iridium_boots":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Boots", new NamespacedKey("iridium", "iridium_boots"), new NamespacedKey("iridium", "invisible_iridium"), EquipmentSlot.FEET, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.FEET));
                            break;
                        case "opal_helmet":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "◎ Iridium Helmet", new NamespacedKey("opal", "opal_helmet"), new NamespacedKey("opal", "invisible_opal"), EquipmentSlot.HEAD, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.HEAD));
                            break;
                        case "opal_chestplate":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "◎ Iridium Chestplate", new NamespacedKey("opal", "opal_chestplate"), new NamespacedKey("opal", "invisible_opal"), EquipmentSlot.CHEST, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 9.0, 4.0, 0.1, 888, ItemRarity.COMMON, EquipmentSlotGroup.CHEST));
                            break;
                        case "opal_leggings":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "◎ Iridium Leggings", new NamespacedKey("opal", "opal_leggings"), new NamespacedKey("opal", "invisible_opal"), EquipmentSlot.LEGS, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 7.0, 4.0, 0.1, 832, ItemRarity.COMMON, EquipmentSlotGroup.LEGS));
                            break;
                        case "opal_boots":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "◎ Iridium Boots", new NamespacedKey("opal", "opal_boots"), new NamespacedKey("opal", "invisible_opal"), EquipmentSlot.FEET, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.FEET));
                            break;
                        case "invisible_iridium_helmet":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Helmet", new NamespacedKey("iridium", "iridium_helmet"), new NamespacedKey("iridium", "iridium"), EquipmentSlot.HEAD, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.HEAD));
                            break;
                        case "invisible_iridium_chestplate":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Chestplate", new NamespacedKey("iridium", "iridium_chestplate"), new NamespacedKey("iridium", "iridium"), EquipmentSlot.CHEST, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 9.0, 4.0, 0.1, 888, ItemRarity.COMMON, EquipmentSlotGroup.CHEST));
                            break;
                        case "invisible_iridium_leggings":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Leggings", new NamespacedKey("iridium", "iridium_leggings"), new NamespacedKey("iridium", "iridium"), EquipmentSlot.LEGS, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 7.0, 4.0, 0.1, 832, ItemRarity.COMMON, EquipmentSlotGroup.LEGS));
                            break;
                        case "invisible_iridium_boots":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "Iridium Boots", new NamespacedKey("iridium", "iridium_boots"), new NamespacedKey("iridium", "iridium"), EquipmentSlot.FEET, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.FEET));
                            break;
                        case "invisible_opal_helmet":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "◎ Iridium Helmet", new NamespacedKey("opal", "opal_helmet"), new NamespacedKey("opal", "opal"), EquipmentSlot.HEAD, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.HEAD));
                            break;
                        case "invisible_opal_chestplate":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "◎ Iridium Chestplate", new NamespacedKey("opal", "opal_chestplate"), new NamespacedKey("opal", "opal"), EquipmentSlot.CHEST, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 9.0, 4.0, 0.1, 888, ItemRarity.COMMON, EquipmentSlotGroup.CHEST));
                            break;
                        case "invisible_opal_leggings":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "◎ Iridium Leggings", new NamespacedKey("opal", "opal_leggings"), new NamespacedKey("opal", "opal"), EquipmentSlot.LEGS, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 7.0, 4.0, 0.1, 832, ItemRarity.COMMON, EquipmentSlotGroup.LEGS));
                            break;
                        case "invisible_opal_boots":
                            item.setItemStack(itemManager.upgradeArmorItem(upgradeableItem, "◎ Iridium Boots", new NamespacedKey("opal", "opal_boots"), new NamespacedKey("opal", "opal"), EquipmentSlot.FEET, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(), 4.0, 4.0, 0.1, 721, ItemRarity.COMMON, EquipmentSlotGroup.FEET));
                            break;
                    }
                }*/

                cauldron.getWorld().spawnParticle(Particle.LAVA, cauldron.getLocation().add(0.5,1,0.5),30, 0.5,0,0.5, 0.3);
                cauldron.getWorld().spawnParticle(Particle.TRIAL_SPAWNER_DETECTION, cauldron.getLocation().add(0.5,1,0.5),100, 0.5,0,0.5, 0.3);
                cauldron.getWorld().playSound(cauldron.getLocation(), Sound.ITEM_TRIDENT_THUNDER, SoundCategory.BLOCKS,1 ,2);
                item.setGravity(false);
                item.teleport(cauldron.getLocation().add(0.5,0.3,0.5));
                item.setVelocity(new Vector(0,0,0));

                new BukkitRunnable() {

                    @Override
                    public void run() {
                        // What you want to schedule goes here
                        item.setVelocity(new Vector(0,0.02,0));
                    }

                }.runTaskLater(this.plugin, 20);

            }
        }

    }


}
