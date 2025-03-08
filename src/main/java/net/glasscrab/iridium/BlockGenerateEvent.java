package net.glasscrab.iridium;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;


public class BlockGenerateEvent implements Listener {


    private final Plugin plugin;
    public BlockGenerateEvent(Plugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onGenerateBlock(BlockFormEvent e){
        if(e.getNewState().getType().equals(Material.COBBLESTONE)){
            Block generatedBlock = e.getNewState().getBlock();
            Location blockLoc = generatedBlock.getLocation();
            if(blockLoc.getY() < 0 && blockLoc.getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                e.getNewState().setType(Material.COBBLED_DEEPSLATE);
            }

            else if(blockLoc.getWorld().getEnvironment().equals(World.Environment.THE_END)){
                e.getNewState().setType(Material.END_STONE);
            }
        }

        else if(e.getNewState().getType().equals(Material.STONE)){
            Block generatedBlock = e.getNewState().getBlock();
            Location blockLoc = generatedBlock.getLocation();
            if(blockLoc.getY() < 0 && blockLoc.getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                e.getNewState().setType(Material.DEEPSLATE);
            }

            else if(blockLoc.getWorld().getEnvironment().equals(World.Environment.THE_END)){
                e.getNewState().setType(Material.END_STONE);
            }
        }

        else if(e.getNewState().getType().equals(Material.BASALT)){
            Block generatedBlock = e.getNewState().getBlock();
            Location blockLoc = generatedBlock.getLocation();
            if(blockLoc.getWorld().getEnvironment().equals(World.Environment.NETHER)){
                e.getNewState().setType(Material.NETHERRACK);
            }
        }
    }
}
