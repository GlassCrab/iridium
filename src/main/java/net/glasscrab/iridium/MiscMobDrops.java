package net.glasscrab.iridium;

import org.bukkit.Material;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MiscMobDrops implements Listener {

    private final RNGManager rngManager;

    public MiscMobDrops(RNGManager rngManager){
        this.rngManager = rngManager;
    }

    @EventHandler
    public void onDragonDeath(EntityDeathEvent e){
        if(!(e.getEntity() instanceof EnderDragon)) return;
        e.getDrops().add(new ItemStack(Material.DRAGON_HEAD));
    }

    @EventHandler
    public void onGuardianDeath(EntityDeathEvent e){
        if(!(e.getEntity() instanceof Guardian)) return;
        if(!(e.getDamageSource().getDirectEntity() instanceof Player)) return;
        if(rngManager.jackpot(100)) {
            e.getDrops().add(new ItemStack(Material.SPONGE));
        }
    }
}
