package me.raulsmail.particle.menus;

import me.raulsmail.particle.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ParticleMenu {

  public static void open(Player player) {
    Inventory inventory = Main.getInstance().getServer().createInventory(null, 27, "Particle Menu");

    //TODO: include items

    ItemStack is = new ItemStack(Material.REDSTONE);
    ItemMeta im = is.getItemMeta();
    im.setDisplayName("Particles");
    im.addItemFlags(ItemFlag.values());
    is.setItemMeta(im);
    inventory.setItem(13, is);

    player.openInventory(inventory);
  }
}
