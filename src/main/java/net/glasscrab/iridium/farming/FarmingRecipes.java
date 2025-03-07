package net.glasscrab.iridium.farming;

import io.papermc.paper.datacomponent.item.consumable.ItemUseAnimation;
import net.glasscrab.iridium.ItemManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class FarmingRecipes {

    private final ItemManager itemManager;
    private final Plugin plugin;
    public FarmingRecipes(ItemManager itemManager, Plugin plugin){
        this.itemManager = itemManager;
        this.plugin = plugin;
    }

    public ShapelessRecipe milkBottleShapelessRecipe(){
        List<PotionEffect> effects = new ArrayList<PotionEffect>();
        ItemStack output = itemManager.makeBasicDrinkableItem(4,16,"Milk Bottle", new NamespacedKey("farming","milk_bottle"),1.61f, new NamespacedKey("minecraft", "entity.generic.drink"), ItemUseAnimation.DRINK, effects, 0f, ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "milk_bottle");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(1,new ItemStack(Material.MILK_BUCKET));
        return recipe;
    }

    public ShapelessRecipe saltShapelessRecipe(){
        ItemStack output = itemManager.makeBasicStackedItem(4,64,"Salt",new NamespacedKey("farming", "salt"),ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "salt");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(Material.WATER_BUCKET);
        return recipe;
    }

    public ShapelessRecipe butterShapelessRecipe(){
        ItemStack output = itemManager.makeBasicStackedItem(1,64,"Butter",new NamespacedKey("farming", "butter"),ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "butter");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        List<PotionEffect> effects = new ArrayList<PotionEffect>();
        recipe.addIngredient(itemManager.makeBasicDrinkableItem(1,16,"Milk Bottle", new NamespacedKey("farming","milk_bottle"),1.61f, new NamespacedKey("minecraft", "entity.generic.drink"), ItemUseAnimation.DRINK, effects, 0f, ItemRarity.COMMON));
        recipe.addIngredient(itemManager.makeBasicStackedItem(1,64,"Salt",new NamespacedKey("farming", "salt"),ItemRarity.COMMON));
        return recipe;
    }

    public ShapelessRecipe cheeseShapelessRecipe(){
        ItemStack output = itemManager.makeBasicStackedItem(1,64,"Cheese",new NamespacedKey("farming", "cheese"),ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "cheese");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        List<PotionEffect> effects = new ArrayList<PotionEffect>();
        recipe.addIngredient(itemManager.makeBasicDrinkableItem(1,16,"Milk Bottle", new NamespacedKey("farming","milk_bottle"),1.61f, new NamespacedKey("minecraft", "entity.generic.drink"), ItemUseAnimation.DRINK, effects, 0f, ItemRarity.COMMON));
        return recipe;
    }

    public ShapelessRecipe pepperoniShapelessRecipe(){
        ItemStack output = itemManager.makeBasicStackedItem(2,64,"Pepperoni",new NamespacedKey("farming", "pepperoni"),ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "pepperoni");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(1,Material.PORKCHOP);
        recipe.addIngredient(1,Material.BEEF);
        recipe.addIngredient(itemManager.makeBasicFoodItem(1, 64,"Pepper",new NamespacedKey("farming","pepper"),2,1f,1.61f,ItemRarity.COMMON));
        return recipe;
    }

    public ShapelessRecipe pizzaSliceShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1,64,"Pizza Slice",new NamespacedKey("farming", "pizza_slice"),4,2,1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "pizza_slice");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(itemManager.makeBasicStackedItem(1,64,"Cheese",new NamespacedKey("farming", "cheese"),ItemRarity.COMMON));
        recipe.addIngredient(itemManager.makeBasicStackedItem(1,64,"Pepperoni",new NamespacedKey("farming", "pepperoni"),ItemRarity.COMMON));
        recipe.addIngredient(1,Material.WHEAT);
        recipe.addIngredient(itemManager.makeBasicFoodItem(1, 64,"Tomato",new NamespacedKey("farming","tomato"),2,1f,1.61f,ItemRarity.COMMON));
        return recipe;
    }

    public ShapelessRecipe pizzaSliceShapelessRecipe2(){
        ItemStack output = itemManager.makeBasicFoodItem(8,64,"Pizza Slice",new NamespacedKey("farming", "pizza_slice"),4,2,1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "pizza_slice2");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(itemManager.makeBasicFoodItem(1,64,"Pizza",new NamespacedKey("farming", "pizza"),20,10,4f,ItemRarity.COMMON));
        return recipe;
    }

    public ShapelessRecipe pizzaShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1,64,"Pizza",new NamespacedKey("farming", "pizza"),20,10,4f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "pizza");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(itemManager.makeBasicFoodItem(8,64,"Pizza Slice",new NamespacedKey("farming", "pizza_slice"),4,2,1.61f,ItemRarity.COMMON));
        return recipe;
    }

    public ShapelessRecipe strawberryShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1,64,"Strawberry", new NamespacedKey("farming","strawberry"),3,2f, 1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "strawberry");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(1,new ItemStack(Material.WHEAT));
        recipe.addIngredient(1,new ItemStack(Material.SWEET_BERRIES));
        return recipe;
    }

    public ShapelessRecipe vanillaShapelessRecipe(){
        ItemStack output = itemManager.makeBasicItem("Vanilla Bean",new NamespacedKey("farming","vanilla"),ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "vanilla");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(1,new ItemStack(Material.COCOA_BEANS));
        recipe.addIngredient(1,new ItemStack(Material.WHITE_DYE));
        return recipe;
    }

    public FurnaceRecipe popcornFurnaceRecipe(){
        ItemStack input = itemManager.makeBasicFoodItem(1, 64,"Corn",new NamespacedKey("farming","corn"),2,1f,1.61f, ItemRarity.COMMON);
        ItemStack output = itemManager.makeBasicFoodItem(1, 64,"Popcorn",new NamespacedKey("farming","popcorn"),5,2f,1.61f,ItemRarity.COMMON);

        NamespacedKey key = new NamespacedKey(plugin, "popcorn");
        FurnaceRecipe recipe = new FurnaceRecipe(key, output, new RecipeChoice.ExactChoice(input),1f,200);
        return recipe;
    }

    public ShapelessRecipe sodaShapelessRecipe(){
        List<PotionEffect> effects = new ArrayList<PotionEffect>();
        effects.add(new PotionEffect(PotionEffectType.SPEED,15 * 20,2));
        ItemStack output = itemManager.makeBasicDrinkableItem(4, 16, "Soda", new NamespacedKey("farming", "soda"), 1.61f, new NamespacedKey("minecraft", "entity.generic.drink"), ItemUseAnimation.DRINK, effects,.5f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "soda");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(1,new ItemStack(Material.WATER_BUCKET));
        recipe.addIngredient(2,new ItemStack(Material.SUGAR));
        recipe.addIngredient(itemManager.makeBasicFoodItem(2,64,"Strawberry", new NamespacedKey("farming","strawberry"),3,2f, 1.61f,ItemRarity.COMMON));
        return recipe;
    }

    public ShapelessRecipe chocolateIceCreamShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1,64,"Chocolate Ice Cream", new NamespacedKey("farming","chocolate_ice_cream"),4,2f, 1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "chocolate_ice_cream");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        List<PotionEffect> effects = new ArrayList<PotionEffect>();
        recipe.addIngredient(itemManager.makeBasicDrinkableItem(1,16,"Milk Bottle", new NamespacedKey("farming","milk_bottle"),1.61f, new NamespacedKey("minecraft", "entity.generic.drink"), ItemUseAnimation.DRINK, effects, 0f, ItemRarity.COMMON));
        recipe.addIngredient(1, Material.SNOWBALL);
        recipe.addIngredient(1,new ItemStack(Material.COCOA_BEANS));
        recipe.addIngredient(1,Material.WHEAT);
        return recipe;
    }

    public ShapelessRecipe vanillaIceCreamShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1,64,"Vanilla Ice Cream", new NamespacedKey("farming","vanilla_ice_cream"),4,2f, 1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "vanilla_ice_cream");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        List<PotionEffect> effects = new ArrayList<PotionEffect>();
        recipe.addIngredient(itemManager.makeBasicDrinkableItem(1,16,"Milk Bottle", new NamespacedKey("farming","milk_bottle"),1.61f, new NamespacedKey("minecraft", "entity.generic.drink"), ItemUseAnimation.DRINK, effects, 0f, ItemRarity.COMMON));
        recipe.addIngredient(1, Material.SNOWBALL);
        recipe.addIngredient(itemManager.makeBasicItem("Vanilla Bean",new NamespacedKey("farming","vanilla"),ItemRarity.COMMON));
        recipe.addIngredient(1,Material.WHEAT);
        return recipe;
    }

    public ShapelessRecipe mintIceCreamShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1,64,"Mint Ice Cream", new NamespacedKey("farming","mint_ice_cream"),4,2f, 1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "mint_ice_cream");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        List<PotionEffect> effects = new ArrayList<PotionEffect>();
        recipe.addIngredient(itemManager.makeBasicDrinkableItem(1,16,"Milk Bottle", new NamespacedKey("farming","milk_bottle"),1.61f, new NamespacedKey("minecraft", "entity.generic.drink"), ItemUseAnimation.DRINK, effects, 0f, ItemRarity.COMMON));
        recipe.addIngredient(1, Material.SNOWBALL);
        recipe.addIngredient(1,new ItemStack(Material.FERN));
        recipe.addIngredient(1,Material.WHEAT);
        return recipe;
    }

    public ShapelessRecipe sausageShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(2,64,"Sausage", new NamespacedKey("farming","sausage"),4,1,1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "sausage");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(1,Material.COOKED_BEEF);
        return recipe;
    }

    public ShapelessRecipe hotDogShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1,64,"Hot Dog",new NamespacedKey("farming", "hotdog"),7,6,1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "hotdog");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(itemManager.makeBasicFoodItem(1,64,"Sausage", new NamespacedKey("farming","sausage"),4,1,1.61f,ItemRarity.COMMON));
        recipe.addIngredient(1,Material.BREAD);
        recipe.addIngredient(itemManager.makeBasicFoodItem(1, 64,"Tomato",new NamespacedKey("farming","tomato"),2,1f,1.61f,ItemRarity.COMMON));
        return recipe;
    }

    public ShapelessRecipe baconShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(2,64,"Bacon", new NamespacedKey("farming","bacon"),4,1,1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "bacon");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(1,Material.COOKED_PORKCHOP);
        return recipe;
    }

    public ShapelessRecipe sandwichShapelessRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1,64,"Sandwich",new NamespacedKey("farming", "sandwich"),7,6,1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "sandwich");
        ShapelessRecipe recipe = new ShapelessRecipe(key,output);
        recipe.addIngredient(itemManager.makeBasicFoodItem(1,64,"Bacon", new NamespacedKey("farming","bacon"),4,1,1.61f,ItemRarity.COMMON));
        recipe.addIngredient(1,Material.BREAD);
        recipe.addIngredient(itemManager.makeBasicFoodItem(1, 64,"Tomato",new NamespacedKey("farming","tomato"),2,1f,1.61f,ItemRarity.COMMON));
        recipe.addIngredient(itemManager.makeBasicFoodItem(1, 64,"Cabbage",new NamespacedKey("farming","cabbage"),2,1f,1.61f,ItemRarity.COMMON));
        return recipe;
    }

    public FurnaceRecipe friedEggFurnaceRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(1, 64,"Fried Egg",new NamespacedKey("farming","egg_fried"),5,2f,1.61f,ItemRarity.COMMON);

        NamespacedKey key = new NamespacedKey(plugin, "fried_egg");
        FurnaceRecipe recipe = new FurnaceRecipe(key, output, new RecipeChoice.MaterialChoice(Material.EGG) ,1f,200);
        return recipe;
    }

    public ShapedRecipe bagelShapedRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(4, 64,"Bagel",new NamespacedKey("farming","bagel"),5,2f,1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "bagel");
        ShapedRecipe recipe = new ShapedRecipe(key,output);
        recipe.shape("WWW", "WSW","WWW");
        recipe.setIngredient('W',Material.WHEAT);
        recipe.setIngredient('S',itemManager.makeBasicStackedItem(1,64,"Salt",new NamespacedKey("farming", "salt"),ItemRarity.COMMON));
        return recipe;
    }

    public ShapedRecipe doughnutShapedRecipe(){
        ItemStack output = itemManager.makeBasicFoodItem(4, 64,"Doughnut",new NamespacedKey("farming","doughnut_pink_sprinkles"),5,2f,1.61f,ItemRarity.COMMON);
        NamespacedKey key = new NamespacedKey(plugin, "doughnut");
        ShapedRecipe recipe = new ShapedRecipe(key,output);
        recipe.shape("WWW", "WSW","WWW");
        recipe.setIngredient('W',Material.WHEAT);
        recipe.setIngredient('S',Material.SUGAR);
        return recipe;
    }

}
