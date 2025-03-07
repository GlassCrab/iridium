package net.glasscrab.iridium;

import io.papermc.paper.registry.keys.SoundEventKeys;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

public class NetheriteRecipes {

    private final ItemManager itemManager;
    private final Plugin plugin;

    public NetheriteRecipes(ItemManager itemManager, Plugin plugin){
        this.itemManager = itemManager;
        this.plugin = plugin;
    }

    public SmithingTransformRecipe NetheriteMaceSmithingTransformRecipe(){
        ItemStack netheriteMace = itemManager.makeCombatTool("Netherite Mace", Material.MACE, new NamespacedKey("iridium", "netherite_mace"),2031, 7, -3.4, ItemRarity.EPIC);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_mace");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteMace, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.MACE), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteBowSmithingTransformRecipe(){
        ItemStack netheriteBow = itemManager.makeBasicTool("Netherite Bow", Material.BOW, new NamespacedKey("iridium", "netherite_bow"), 2031, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_bow");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteBow, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.BOW), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteCrossbowSmithingTransformRecipe(){
        ItemStack netheriteCrossbow = itemManager.makeBasicTool("Netherite Crossbow", Material.CROSSBOW, new NamespacedKey("iridium", "netherite_crossbow"), 2031, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_crossbow");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteCrossbow, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.CROSSBOW), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteFlintAndSteelSmithingTransformRecipe(){
        ItemStack netheriteFlintAndSteel = itemManager.makeBasicTool("Flint and Netherite", Material.FLINT_AND_STEEL, new NamespacedKey("iridium", "netherite_flint_and_steel"), 2031, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_flint_and_steel");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteFlintAndSteel, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.FLINT_AND_STEEL), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteFishingRodSmithingTransformRecipe(){
        ItemStack netheriteFishingRod = itemManager.makeBasicTool("Netherite Fishing Rod", Material.FISHING_ROD, new NamespacedKey("iridium", "netherite_fishing_rod"), 2031, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_fishing_rod");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteFishingRod, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.FISHING_ROD), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteCarrotOnAStickSmithingTransformRecipe(){
        ItemStack netheriteCarrotOnAStick = itemManager.makeBasicTool("Carrot on a Netherite Stick", Material.CARROT_ON_A_STICK, new NamespacedKey("iridium", "netherite_carrot_on_a_stick"), 2031, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_carrot_on_a_stick");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteCarrotOnAStick, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.CARROT_ON_A_STICK), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteWarpedFungusOnAStickSmithingTransformRecipe(){
        ItemStack netheriteWarpedFungusOnAStick = itemManager.makeBasicTool("Warped Fungus on a Netherite Stick", Material.WARPED_FUNGUS_ON_A_STICK, new NamespacedKey("iridium", "netherite_warped_fungus_on_a_stick"), 2031, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_warped_fungus_on_a_stick");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteWarpedFungusOnAStick, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.WARPED_FUNGUS_ON_A_STICK), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteShearsSmithingTransformRecipe(){
        ItemStack netheriteShears = itemManager.makeBasicTool("Netherite Shears", Material.SHEARS, new NamespacedKey("iridium", "netherite_shears"), 2031, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_shears");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteShears, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.SHEARS), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteBrushSmithingTransformRecipe(){
        ItemStack netheriteBrush = itemManager.makeUpgradedBrush("Netherite Brush", Material.BRUSH, new NamespacedKey("iridium", "netherite_brush"), 2031, 12, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_brush");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteBrush, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.BRUSH), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }

    public SmithingTransformRecipe NetheriteElytraSmithingTransformRecipe(){
        ItemStack netheriteElytra = itemManager.makeArmorItem("Netherite Elytra", Material.ELYTRA, new NamespacedKey("iridium", "netherite_elytra_item"), new NamespacedKey("iridium","netherite_elytra"), EquipmentSlot.CHEST, SoundEventKeys.ITEM_ARMOR_EQUIP_NETHERITE.key(),2,1,0.1,2031,ItemRarity.EPIC, EquipmentSlotGroup.CHEST);
        NamespacedKey key = new NamespacedKey(plugin, "netherite_elytra");
        SmithingTransformRecipe recipe = new SmithingTransformRecipe(key, netheriteElytra, new RecipeChoice.MaterialChoice(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE), new RecipeChoice.MaterialChoice(Material.ELYTRA), new RecipeChoice.MaterialChoice(Material.NETHERITE_INGOT));
        return recipe;
    }
}
