package com.willburstein.test;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.world.WorldEvent;

import java.util.List;

public class ProjListener implements Listener {

    /*
    In the arguments block, you must choose a type of event (You can check the Bukkit API for the various types or just experiment around until you find an event class that works.
    This listener watches for the player death event. When a player dies it broadcasts a server message saying that the player (e.getEntity()) died.
    The variable attached to the event gives the developer access to objects related to the event such as the affected player, mob, block, or projectile.
     */

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent p) {
        if (p.getEntity() instanceof Snowball) {
            if (p.getHitBlock() != null) {

                p.getHitBlock().setType(Material.SNOW_BLOCK);


            }

            else if (p.getHitEntity() != null)

            {

                List<Entity> surrounding_entities = p.getHitEntity().getNearbyEntities(3, 3, 3);
                for (int i = 0; i < surrounding_entities.size(); i++) {
                    if (Bukkit.getEntity(surrounding_entities.get(i).getUniqueId()) instanceof LivingEntity) {
                        Entity ent = surrounding_entities.get(i);
                        ((LivingEntity) ent).setHealth(0);

                    }


                }

                if (p.getHitEntity() instanceof LivingEntity) {
                    ((LivingEntity) p.getHitEntity()).setHealth(0);
                }
            }
        }

        else if (p.getEntity() instanceof Arrow){

            if (p.getEntity() != null) {
                        p.getHitEntity().getWorld().createExplosion(p.getHitEntity().getLocation().getX(), p.getHitEntity().getLocation().getY(), p.getHitEntity().getLocation().getZ(), 5.0F, true);
            }

            //else if (p.getHitBlock() != null){
                Block blockHit = p.getHitBlock();
                BlockFace face = p.getHitBlockFace();
                if (p == null){
                    Bukkit.getServer().broadcastMessage("The projectile is null");
                }
if (blockHit.getWorld() == null){Bukkit.getServer().broadcastMessage("The world is null");}
else if ( p.getHitBlock() == null){Bukkit.getServer().broadcastMessage("The block is null");}
else if ( p.getHitBlock().getLocation() == null){Bukkit.getServer().broadcastMessage("The block location is null");}
else {Bukkit.getServer().broadcastMessage("The game is broken");}
                Location loc = blockHit.getLocation();
            //p.getHitBlock().getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 5.0F, true);

            //}
        }
    }
}
