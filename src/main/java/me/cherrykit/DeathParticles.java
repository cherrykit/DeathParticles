package me.cherrykit;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathParticles extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {}
	
	//Is called when a player dies - adds particle effects to death and respawns player
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		//Gets information about death and respawns player
		Player p = e.getEntity();
		Location l = p.getLocation();
		World w = p.getWorld();
		p.spigot().respawn();
		
		//Spawns in particles
		new ParticleTask(w,l,20).runTaskTimer(this, 0, 3);
	}
	
}
