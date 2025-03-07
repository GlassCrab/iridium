package net.glasscrab.iridium.farming;

import net.glasscrab.iridium.BlockManager;
import net.glasscrab.iridium.RNGManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;
import org.bukkit.plugin.Plugin;

public class CropGrowEvent implements Listener {

    private final BlockManager blockManager;
    private final RNGManager rngManager;
    private final Plugin plugin;
    public CropGrowEvent(BlockManager blockManager, RNGManager rngManager, Plugin plugin){
        this.blockManager = blockManager;
        this.rngManager = rngManager;
        this.plugin = plugin;
    }

    @EventHandler
    public void onCropGrow(BlockGrowEvent e){
        if(!blockManager.isCustomCrop(e.getBlock().getType())) return;
        Ageable crop = (Ageable) e.getNewState().getBlockData();

        BlockState state = e.getNewState();
        BlockData data = state.getBlockData();
        Ageable age = (Ageable) data;

        if(crop.getAge() >= 1 && crop.getAge() <= 4){
            if(rngManager.jackpot(8)){
                if(age.getAge()+3 > age.getMaximumAge()){
                    age.setAge(age.getMaximumAge());
                }
                else if(age.getAge()+3 <= age.getMaximumAge()){
                    age.setAge(age.getAge()+3);
                }
                ((Ageable) data).setAge(age.getAge());

                state.setBlockData(data);
                e.getBlock().setBlockData(data);
            }
            else{
                e.setCancelled(true);
            }
            //Bukkit.broadcast(Component.text(((Ageable) e.getNewState().getBlockData()).getAge()+ " " + e.getNewState().getType()));
        }
        else if(crop.getAge() > 3){
            e.setCancelled(true);
        }
    }

}
