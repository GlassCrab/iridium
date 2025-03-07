package net.glasscrab.iridium.farming;

import io.papermc.paper.datacomponent.DataComponentType;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.glasscrab.iridium.ItemManager;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class SeedPlaceEvent implements Listener {

    private final ItemManager itemManager;
    private final Plugin plugin;
    public SeedPlaceEvent(ItemManager itemManager, Plugin plugin){
        this.itemManager = itemManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onSeedPlace(PlayerInteractEvent e){
        if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if(!e.hasItem()) return;
        if(!e.getItem().hasData(DataComponentTypes.ITEM_MODEL)) return;
        if(!itemManager.isSeedItem(e.getItem())) return;
        if(e.getHand() != EquipmentSlot.HAND) return;

        //Location seedBlockLoc = new Location(e.getClickedBlock().getWorld(), e.getClickedBlock().getX(),(double) e.getClickedBlock().getY()+1,(double) e.getClickedBlock().getZ());
        //Block seedBlock = e.getPlayer().getWorld().getBlockAt(seedBlockLoc);

        new BukkitRunnable() {

            @Override
            public void run() {
                // What you want to schedule goes here
                Block seedBlock = e.getClickedBlock().getRelative(e.getBlockFace());
                Block farmLand = seedBlock.getRelative(0,-1,0);
                if(seedBlock.getType() != Material.AIR) return;
                if(farmLand.getType() != Material.FARMLAND) return;
                BlockState state = seedBlock.getState();
                BlockData data;
                Ageable age;

                switch (e.getItem().getData(DataComponentTypes.ITEM_MODEL).value()){
                    case "cabbage_seeds":
                        state.setType(Material.WHEAT);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(1);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                    case "garlic_seeds":
                        state.setType(Material.WHEAT);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(2);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                    case "pepper_seeds":
                        state.setType(Material.WHEAT);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(3);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                    case "ginger_seeds":
                        state.setType(Material.POTATOES);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(1);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                    case "onion_seeds":
                        state.setType(Material.POTATOES);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(2);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                    case "corn_seeds":
                        state.setType(Material.POTATOES);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(3);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                    case "rice_seeds":
                        state.setType(Material.CARROTS);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(1);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                    case "tomato_seeds":
                        state.setType(Material.CARROTS);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(2);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                    case "peanut_seeds":
                        state.setType(Material.CARROTS);
                        data = state.getBlockData();
                        age = (Ageable) data;
                        age.setAge(3);
                        state.setBlockData(data);
                        seedBlock.setBlockData(data);
                        seedBlock.setBlockData(age);
                        if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                            e.getPlayer().getInventory().getItemInMainHand().setAmount(e.getPlayer().getInventory().getItemInMainHand().getAmount()-1);
                        }
                        e.getPlayer().swingMainHand();
                        seedBlock.getWorld().playSound(seedBlock.getLocation(), Sound.ITEM_CROP_PLANT, SoundCategory.BLOCKS,1,1);
                        break;
                }
            }

        }.runTaskLater(this.plugin, 1);
    }

}
