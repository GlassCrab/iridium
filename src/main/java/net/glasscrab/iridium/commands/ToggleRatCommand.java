package net.glasscrab.iridium.commands;

import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleRatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args){
        if(!(sender instanceof Player player)) {
            sender.sendMessage(Component.text("Iridium: You must be a player to use this command.", TextColor.fromCSSHexString("#FF5555")));
            return true;
        }

        if(args.length > 0){
            sender.sendMessage(Component.text("Iridium: Usage: /togglerat", TextColor.fromCSSHexString("#FF5555")));
            return true;
        }

        Player p = (Player) sender;

        if(p.getAttribute(Attribute.SCALE).getBaseValue() == 0.25){
            p.getAttribute(Attribute.SCALE).setBaseValue(1.0);
            sender.sendMessage(Component.text("Back to normal...", TextColor.fromCSSHexString("#9a9697")));

            return true;
        }

        else if((p.getLocation().getBlockX() == -25 && p.getLocation().getBlockY() == 224 && p.getLocation().getBlockZ() == -25)){
            sender.sendMessage(Component.text("YOU HAVE JOINED THEM!", TextColor.fromCSSHexString("#c32900"), TextDecoration.BOLD));
            sender.sendMessage(Component.text("Ping glasscrab on the Iridium discord with the message '123ratthew321'", TextColor.fromCSSHexString("#9a9697")));
            p.playSound(Sound.sound(new NamespacedKey("minecraft","entity.lightning_bolt.thunder"), Sound.Source.MASTER,1.0f,2.0f));
            p.getAttribute(Attribute.SCALE).setBaseValue(0.25);
            return true;
        }

        sender.sendMessage(Component.text("This isn't it, this doesn't feel like the right spot...", TextColor.fromCSSHexString("#9a9697")));


        return true;
    }
}
