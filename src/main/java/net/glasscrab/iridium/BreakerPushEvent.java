package net.glasscrab.iridium;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;

public class BreakerPushEvent implements Listener {

    @EventHandler
    public void onBreakerPush(BlockPistonExtendEvent e){
        if(e.getBlocks().isEmpty()) return;
        if(!e.getBlocks().getFirst().getType().equals(Material.END_ROD)) return;
        if(e.getBlocks().size() < 2) return;
        Block brokenBlock = e.getBlocks().get(1);
        if(brokenBlock.getType().getHardness() > 50) return;
        switch (brokenBlock.getType()){
            case STONE:
                brokenBlock.setType(Material.COBBLESTONE);
                break;
            case COBBLESTONE:
                brokenBlock.setType(Material.GRAVEL);
                break;
            case GRAVEL:
                brokenBlock.setType(Material.SAND);
                break;
        }
        brokenBlock.breakNaturally(true);
        e.setCancelled(true);
    }
}
