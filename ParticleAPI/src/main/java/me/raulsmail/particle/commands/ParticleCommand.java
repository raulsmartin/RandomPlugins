package me.raulsmail.particle.commands;

import me.raulsmail.particle.Main;
import me.raulsmail.particle.api.ParticleAPI;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("me.raulsmail.particleapi.command")) {
                player.sendMessage(ChatColor.GREEN + "Hurray!");
                ParticleAPI.spawnParticle(Particle.EXPLOSION_HUGE, player.getLocation());
                int taskId = new BukkitRunnable() {
                    @Override
                    public void run() {
                        ParticleAPI.spawnColoredParticle(Particle.REDSTONE, player.getLocation(), Color.fromRGB(255, 255, 153));
                    }
                }.runTaskTimer(Main.getInstance(), 0L, 1L).getTaskId();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Main.getInstance().getServer().getScheduler().cancelTask(taskId);
                    }
                }.runTaskLater(Main.getInstance(), 100L);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
            } else {
                player.sendMessage(ChatColor.RED + "You don't have the necessary permissions to use that command.\n" + ChatColor.RED + "If you think this might be an error, contact with the server admin.");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You can only use this command as player!");
        }
        return true;
    }
}
