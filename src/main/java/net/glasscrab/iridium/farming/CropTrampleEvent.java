package net.glasscrab.iridium.farming;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class CropTrampleEvent implements Listener {

    @EventHandler
    public void OnTrampleCrop(PlayerInteractEvent e){
        if(e.getAction() != Action.PHYSICAL) return;
        if(e.getClickedBlock().getType() != Material.FARMLAND) return;
        e.setCancelled(true);
    }
}
