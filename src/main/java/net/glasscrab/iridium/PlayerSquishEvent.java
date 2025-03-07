package net.glasscrab.iridium;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import java.util.Collection;

public class PlayerSquishEvent implements Listener {

    @EventHandler
    public void onPlayerSquish (BlockPistonExtendEvent e){
        if(e.getBlocks().isEmpty()) return;
        if(!e.getBlocks().getFirst().getType().equals(Material.NETHERITE_BLOCK)) return;
        if(!e.getBlocks().getFirst().getRelative(0, -2, 0).getType().equals(Material.CAULDRON)) return;
        Block netheriteBlock = e.getBlocks().getFirst();
        Block cauldron = netheriteBlock.getRelative(0,-2,0);

        Collection<Player> players = cauldron.getLocation().getNearbyEntitiesByType(Player.class,0.5);

        for(Player p : players){
            if(p.getAttribute(Attribute.SCALE).getBaseValue() == 1) {
                p.getAttribute(Attribute.SCALE).setBaseValue(0.5);
                cauldron.getWorld().playSound(cauldron.getLocation(), Sound.BLOCK_ANVIL_PLACE, SoundCategory.BLOCKS, 1, 2);
            }
        }

    }

    @EventHandler
    public void onPlayerExtend(BlockPistonRetractEvent e){
        if(e.getBlocks().isEmpty()) return;
        if(!e.getBlocks().getFirst().getType().equals(Material.SLIME_BLOCK)) return;
        if(!e.getBlocks().getFirst().getRelative(0, -2, 0).getType().equals(Material.SLIME_BLOCK)) return;
        Block netheriteBlock = e.getBlocks().getFirst();
        Block cauldron = netheriteBlock.getRelative(0,-1,0);

        Collection<Player> players = cauldron.getLocation().getNearbyEntitiesByType(Player.class,0.5);

        for(Player p : players){
            if(p.getAttribute(Attribute.SCALE).getBaseValue() == 0.5){
                p.getAttribute(Attribute.SCALE).setBaseValue(1);
                cauldron.getWorld().playSound(cauldron.getLocation(), Sound.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.BLOCKS,1 ,2);
            }

        }
    }


}
