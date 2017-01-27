package me.cherrykit;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleTask extends BukkitRunnable {

	//Attributes
	World world;
	int amount;
	Location location;
	
	//Constructor
	public ParticleTask(World w, Location l, int amount) {
		world = w;
		location = l;
		location.setY(location.getY()+1);
		this.amount = amount;
	}
	
	//Task which gradually spawns in particles
	@Override
	public void run() {
		//If amount of particles larger than 0 - spawns in particles and decreases amount
		if (amount > 0) {
			world.spawnParticle(Particle.ITEM_CRACK, location, amount, 0.5, 0.5, 0.5, new ItemStack(Material.RED_NETHER_BRICK));
			amount = amount-2;
		//Cancels task if no particles are to be spawned
		} else {
			this.cancel();
		}
	}
	
}
