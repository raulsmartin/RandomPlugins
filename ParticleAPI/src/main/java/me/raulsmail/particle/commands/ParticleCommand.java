package me.raulsmail.particle.commands;

import me.raulsmail.particle.menus.ParticleMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParticleCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player) sender;
      if (player.hasPermission("me.raulsmail.particleapi.command")) {
        ParticleMenu.open((Player) sender);
      } else {
        player.sendMessage(
            ChatColor.RED + "You don't have the necessary permissions to use that command.\n"
                + ChatColor.RED
                + "If you think this might be an error, contact with the server admin.");
      }
    } else {
      sender.sendMessage(ChatColor.RED + "You can only use this command as player!");
    }
    return true;
  }
}
