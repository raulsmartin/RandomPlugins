package me.raulsmail.heads;

import me.raulsmail.heads.commands.HeadsCommand;
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
    getCommand("headsapi").setExecutor(new HeadsCommand());
  }
}
