package net.glasscrab.iridium.iridium;

import io.papermc.paper.registry.keys.SoundEventKeys;
import net.glasscrab.iridium.ItemManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class IridiumRecipes {

    private final ItemManager itemManager;
    private final Plugin plugin;
    public IridiumRecipes(ItemManager itemManager, Plugin plugin){
        this.itemManager = itemManager;
        this.plugin = plugin;
    }

    public ShapelessRecipe iridumChunkShapelessRecipe(){
        ItemStack iridiumFragment = itemManager.makeBasicItem("Iridium Fragment", new NamespacedKey("iridium", "iridium_fragment"), ItemRarity.COMMON);
        ItemStack iridumChunk = itemManager.makeBasicItem("Iridium Chunk",  new NamespacedKey("iridium", "iridium_chunk"), ItemRarity.COMMON);

        NamespacedKey iridumChunkKey = new NamespacedKey(plugin, "iridium_chunk");
        ShapelessRecipe iridumChunkRecipe = new ShapelessRecipe(iridumChunkKey,iridumChunk);
        iridumChunkRecipe.addIngredient(9,iridiumFragment);
        return iridumChunkRecipe;
    }


    public FurnaceRecipe IridiumIngotFurnaceRecipe(){
        ItemStack iridumChunk = itemManager.makeBasicItem("Iridium Chunk",  new NamespacedKey("iridium", "iridium_chunk"), ItemRarity.COMMON);
        ItemStack iridiumIngot = itemManager.makeBasicItem("Iridium Ingot",  new NamespacedKey("iridium", "iridium_ingot"), ItemRarity.COMMON);

        NamespacedKey iridiumIngotKey = new NamespacedKey(plugin, "iridium_ingot");
        FurnaceRecipe iridiumIngotRecipe = new FurnaceRecipe(iridiumIngotKey, iridiumIngot, new RecipeChoice.ExactChoice(iridumChunk),40f,400);
        return iridiumIngotRecipe;
    }
}
