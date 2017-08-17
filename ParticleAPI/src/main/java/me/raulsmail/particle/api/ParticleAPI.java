package me.raulsmail.particle.api;

import me.raulsmail.particle.Main;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

import java.util.Collection;

public class ParticleAPI {

    public static void spawnParticle(Particle particle, Location location) {
        spawnParticle(particle, location, 1, null, Main.getInstance().getServer().getOnlinePlayers());
    }

    public static void spawnParticle(Particle particle, Location location, Collection<? extends Player> players) {
        spawnParticle(particle, location, 1, null, players);
    }

    public static void spawnParticle(Particle particle, Location location, int count) {
        spawnParticle(particle, location, count, null, Main.getInstance().getServer().getOnlinePlayers());
    }

    public static void spawnParticle(Particle particle, Location location, int count, Collection<? extends Player> players) {
        spawnParticle(particle, location, count, null, players);
    }

    public static <T> void spawnParticle(Particle particle, Location location, int count, T data) {
        spawnParticle(particle, location, count, data, Main.getInstance().getServer().getOnlinePlayers());
    }

    public static <T> void spawnParticle(Particle particle, Location location, int count, T data, Collection<? extends Player> players) {
        if (data != null && !particle.getDataType().isInstance(data)) {
            throw new IllegalArgumentException("data variable should be " + particle.getDataType() + ", but we've got " + data.getClass());
        } else {
            for (Player player : players) {
                player.spawnParticle(particle, location, count, data);
            }
        }
    }

    public static void spawnColoredParticle(Particle particle, Location location, Color color) {
        spawnColoredParticle(particle, location, color, Main.getInstance().getServer().getOnlinePlayers());
    }

    public static void spawnColoredParticle(Particle particle, Location location, Color color, Collection<? extends Player> players) {
        if (!particle.equals(Particle.REDSTONE) && !particle.equals(Particle.SPELL_MOB) && !particle.equals(Particle.SPELL_MOB_AMBIENT)) {
            throw new IllegalArgumentException("particle variable should be REDSTONE, SPELL_MOB or SPELL_MOB_AMBIENT, but we've got " + particle.name());
        } else {
            for (Player player : players) {
                player.spawnParticle(particle, location, 0, ((double) color.getRed()) / 255D, ((double) color.getGreen()) / 255D, ((double) color.getBlue()) / 255D, 1);
            }
        }
    }
}
