package net.glasscrab.iridium.farming;

import net.glasscrab.iridium.BlockManager;
import net.glasscrab.iridium.RNGManager;
import org.bukkit.*;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class PlayerBonemealCropEvent implements Listener {

    private final BlockManager blockManager;
    private final RNGManager rngManager;
    private final Plugin plugin;
    
    public PlayerBonemealCropEvent(BlockManager blockManager, RNGManager rngManager, Plugin plugin){
        this.blockManager = blockManager;
        this.rngManager = rngManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerBonemeal(PlayerInteractEvent e){
        if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if(e.getItem() == null) return;
        if(e.getItem().getType() != Material.BONE_MEAL) return;
        if(!blockManager.isCustomCrop(e.getClickedBlock().getType())) return;

        e.setCancelled(true);

        new BukkitRunnable() {

            @Override
            public void run() {
                // What you want to schedule goes here
                Ageable crop = (Ageable) e.getClickedBlock().getBlockData();

                BlockState state = e.getClickedBlock().getState();
                BlockData data = state.getBlockData();
                Ageable age = (Ageable) data;

                if(crop.getAge() < 4){
                    age.setAge(age.getAge()+4);
                    ((Ageable) data).setAge(age.getAge());
                    state.setBlockData(data);
                    e.getClickedBlock().setBlockData(data);
                    if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                        e.getItem().setAmount(e.getItem().getAmount()-1);
                    }
                    e.getClickedBlock().getWorld().spawnParticle(Particle.HAPPY_VILLAGER,e.getClickedBlock().getLocation().add(0.5,0.5,0.5),15,0.2,0.2,0.2);
                    e.getClickedBlock().getWorld().playSound(e.getClickedBlock().getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.PLAYERS,1,1);
                }

                /*if(crop.getAge() >= 0 && crop.getAge() <= 3){
                    if(age.getAge()+4 > age.getMaximumAge()){
                        age.setAge(age.getMaximumAge());
                    }
                    else if(age.getAge()+3 <= age.getMaximumAge()){
                        age.setAge(age.getAge()+3);
                    }



                    //Bukkit.broadcast(Component.text(((Ageable) e.getNewState().getBlockData()).getAge()+ " " + e.getNewState().getType()));
                }*/
            }

        }.runTaskLater(this.plugin, 1);
    }
}
