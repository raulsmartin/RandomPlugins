package me.raulsmail.particle;

import me.raulsmail.particle.commands.ParticleCommand;
import me.raulsmail.particle.listeners.InventoryListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  private static Main instance;

  public static Main getInstance() {
    return instance;
  }

  @Override
  public void onEnable() {
    instance = this;
    //Registering Commands
    getCommand("particleapi").setExecutor(new ParticleCommand());
    //Registering Listeners
    getServer().getPluginManager().registerEvents(new InventoryListener(), instance);
  }
}
