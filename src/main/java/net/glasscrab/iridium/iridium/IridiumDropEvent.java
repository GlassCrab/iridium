package net.glasscrab.iridium.iridium;

import net.glasscrab.iridium.ItemManager;
import net.glasscrab.iridium.RNGManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.inventory.ItemRarity;

public class IridiumDropEvent implements Listener {
    
    private final RNGManager rngManager;
    private final ItemManager itemManager;
    
    public IridiumDropEvent(RNGManager rngManager, ItemManager itemManager){
        this.rngManager = rngManager;
        this.itemManager = itemManager;
    }


    @EventHandler
    public void onBreakEndstone(BlockBreakEvent e){
        if(e.getPlayer().getWorld().getEnvironment() != World.Environment.THE_END) return;
        if(e.getBlock().getType() != Material.END_STONE) return;
        if(e.getPlayer().getInventory().getItemInMainHand().getType() != Material.BRUSH) return;

        e.setCancelled(true);
        e.getBlock().setType(Material.AIR);
        e.getPlayer().getInventory().getItemInMainHand().damage(1,e.getPlayer());



        if(rngManager.jackpot(100)){

            itemManager.dropItemOnBlock(e.getBlock(), itemManager.makeBasicItem("Iridium Fragment", new NamespacedKey("iridium", "iridium_fragment"), ItemRarity.COMMON));
            e.getPlayer().getWorld().spawnParticle(Particle.END_ROD,e.getBlock().getLocation().add(0.5,0.5,0.5),10,0.5,0.5,0.5);
        }
        else{
            e.getPlayer().getWorld().spawnParticle(Particle.ASH,e.getBlock().getLocation().add(0.5,0.5,0.5),30,0.5,0.5,0.5);
        }

    }

    @EventHandler
    public void onBreakPurpurBlock(BlockBreakEvent e){
        if(e.getPlayer().getWorld().getEnvironment() != World.Environment.THE_END) return;
        if(e.getBlock().getType() != Material.PURPUR_BLOCK) return;
        if(e.getPlayer().getInventory().getItemInMainHand().getType() != Material.BRUSH) return;

        e.setDropItems(false);

        if(rngManager.jackpot(100)){

            itemManager.dropItemOnBlock(e.getBlock(), itemManager.makeBasicItem("Iridium Fragment", new NamespacedKey("iridium", "iridium_fragment"), ItemRarity.COMMON));
            e.getPlayer().getWorld().spawnParticle(Particle.END_ROD,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
        else{
            e.getPlayer().getWorld().spawnParticle(Particle.ASH,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
    }

    @EventHandler
    public void onBreakPurpurPillar(BlockBreakEvent e){
        if(e.getPlayer().getWorld().getEnvironment() != World.Environment.THE_END) return;
        if(e.getBlock().getType() != Material.PURPUR_PILLAR) return;
        if(e.getPlayer().getInventory().getItemInMainHand().getType() != Material.BRUSH) return;

        e.setDropItems(false);

        if(rngManager.jackpot(100)){

            itemManager.dropItemOnBlock(e.getBlock(), itemManager.makeBasicItem("Iridium Fragment", new NamespacedKey("iridium", "iridium_fragment"), ItemRarity.COMMON));
            e.getPlayer().getWorld().spawnParticle(Particle.END_ROD,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
        else{
            e.getPlayer().getWorld().spawnParticle(Particle.ASH,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
    }

    @EventHandler
    public void onBreakPurpurSlab(BlockBreakEvent e){
        if(e.getPlayer().getWorld().getEnvironment() != World.Environment.THE_END) return;
        if(e.getBlock().getType() != Material.PURPUR_SLAB) return;
        if(e.getPlayer().getInventory().getItemInMainHand().getType() != Material.BRUSH) return;

        e.setDropItems(false);

        if(rngManager.jackpot(100)){

            itemManager.dropItemOnBlock(e.getBlock(), itemManager.makeBasicItem("Iridium Fragment", new NamespacedKey("iridium", "iridium_fragment"), ItemRarity.COMMON));
            e.getPlayer().getWorld().spawnParticle(Particle.END_ROD,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
        else{
            e.getPlayer().getWorld().spawnParticle(Particle.ASH,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
    }

    @EventHandler
    public void onBreakPurpurStairs(BlockBreakEvent e){
        if(e.getPlayer().getWorld().getEnvironment() != World.Environment.THE_END) return;
        if(e.getBlock().getType() != Material.PURPUR_STAIRS) return;
        if(e.getPlayer().getInventory().getItemInMainHand().getType() != Material.BRUSH) return;

        e.setDropItems(false);

        if(rngManager.jackpot(100)){

            itemManager.dropItemOnBlock(e.getBlock(), itemManager.makeBasicItem("Iridium Fragment", new NamespacedKey("iridium", "iridium_fragment"), ItemRarity.COMMON));
            e.getPlayer().getWorld().spawnParticle(Particle.END_ROD,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
        else{
            e.getPlayer().getWorld().spawnParticle(Particle.ASH,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
    }

    @EventHandler
    public void onBreakDeepslate(BlockDropItemEvent e){
        if(e.getBlockState().getType() != Material.DEEPSLATE) return;
        if(e.getItems().getFirst().getItemStack().getType() != Material.COBBLED_DEEPSLATE) return;
        if(e.getPlayer().getInventory().getItemInMainHand().getType() != Material.NETHERITE_PICKAXE) return;

        if(rngManager.jackpot(1000)){
            itemManager.dropItemOnItem(e.getItems().getFirst(),itemManager.makeBasicItem("Iridium Fragment", new NamespacedKey("iridium", "iridium_fragment"), ItemRarity.COMMON));
            e.getPlayer().getWorld().spawnParticle(Particle.END_ROD,e.getBlock().getLocation().add(0.5,0.5,0.5),2,2,2,10);
        }
    }
}
