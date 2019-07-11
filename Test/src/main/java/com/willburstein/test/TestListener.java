package com.willburstein.test;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class TestListener implements Listener {

    /*
    In the arguments block, you must choose a type of event (You can check the Bukkit API for the various types or just experiment around until you find an event class that works.
    This listener watches for the player death event. When a player dies it broadcasts a server message saying that the player (e.getEntity()) died.
    The variable attached to the event gives the developer access to objects related to the event such as the affected player, mob, block, or projectile.
     */

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setDeathMessage(null);

        Bukkit.getServer().broadcastMessage(e.getEntity().getName() + " got obliterated!");
    }
}
