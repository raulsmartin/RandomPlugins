package me.raulsmail.particle.listeners;

import me.raulsmail.particle.Main;
import me.raulsmail.particle.api.ParticleAPI;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryListener implements Listener {

  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    if (event.getWhoClicked() instanceof Player) {
      Player player = (Player) event.getWhoClicked();
      if (event.getClickedInventory() != null && event.getClickedInventory().getTitle() != null) {
        if (event.getClickedInventory().getTitle().equals("Particle Menu")) {
          event.setCancelled(true);
          if (event.getCurrentItem() != null && event.getCurrentItem().getType() != null
              && event.getCurrentItem().getItemMeta() != null
              && event.getCurrentItem().getItemMeta().getDisplayName() != null) {
            switch (event.getCurrentItem().getType()) {
              case REDSTONE:
                player.sendMessage(ChatColor.GREEN + "Hurray!");
                int taskId = new BukkitRunnable() {
                  @Override
                  public void run() {
                    ParticleAPI.spawnParticle(Particle.SPIT, player.getEyeLocation());
                    ParticleAPI.spawnParticle(Particle.DRIP_WATER, player.getEyeLocation());
                    ParticleAPI.spawnColoredParticle(Particle.REDSTONE, player.getEyeLocation(),
                        Color.fromRGB(255, 255, 153));
                    ParticleAPI
                        .spawnMovingParticle(Particle.FIREWORKS_SPARK, player.getEyeLocation(),
                            player.getEyeLocation().getDirection(), 0.5);
                  }
                }.runTaskTimer(Main.getInstance(), 0L, 1L).getTaskId();
                new BukkitRunnable() {
                  @Override
                  public void run() {
                    Main.getInstance().getServer().getScheduler().cancelTask(taskId);
                  }
                }.runTaskLater(Main.getInstance(), 100L);
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F,
                    1.0F);
                break;
            }
          }
        }
      }
    }
  }
}
