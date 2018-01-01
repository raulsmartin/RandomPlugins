package me.raulsmail.heads.commands;

import me.raulsmail.heads.api.HeadsAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HeadsCommand implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player) sender;
      if (player.hasPermission("me.raulsmail.headsapi.command")) {
        player.sendMessage(ChatColor.GREEN + "Hurray!");
        player.getInventory().addItem(HeadsAPI.createNameItemHead("raulsmail"), HeadsAPI
            .createBase64ItemHead(
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTE1ZGNiMmRhMDJjZjczNDgyOWUxZTI3M2UzMDI1NjE3ZDgwNzE1MTZmOTUzMjUxYjUyNTQ1ZGE4ZDNlOGRiOCJ9fX0="
                    .getBytes()), HeadsAPI.createTextureURLItemHead(
            "http://textures.minecraft.net/texture/b6287e255cba7e426b6a0389018ddd43e8133781ba419b426a62a07adb0cc"));
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
