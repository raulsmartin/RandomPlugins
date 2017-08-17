package me.raulsmail.particle;

import me.raulsmail.particle.commands.ParticleCommand;
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
        //TODO: Register Listeners (?)
    }
}
