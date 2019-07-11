package com.willburstein.test;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

public final class Test extends JavaPlugin{
    /*
    The onEnable method performs initializing tasks during the server's boot such as setting up event listeners or commands
     */
    @Override
    public void onEnable() {


        Bukkit.getServer().broadcastMessage("Server has been started!");


        /*
        Listeners watch for various Minecraft events such as when a player dies or an arrow lands. You can track these events to add custom functionality to the game.
         */
        Bukkit.getPluginManager().registerEvents(new TestListener(), this);
        Bukkit.getPluginManager().registerEvents(new ProjListener(), this);


        /*
        Commands must be registered in your plugin.yml file located in the resources folder. If they aren't declared, there will be an error during your setExecutor method.
        Sample plugin.yml:

        name: PluginName
        main: <main package>.<main class> (Package in essentially a backwards url that you choose and it is used for file routing) (The main class is whatever class has your onEnable and onDisable methods and extends JavaPlugin.
        version: 1.0
        author: <your IGN or name>
        commands:
            <command>:
                description: This is a demo command.
                usage: /<command> [player]
         */

        this.getCommand("test").setExecutor(new TestCommand());


    }

    @Override
    public void onDisable() {
        /*
        The onDisable method performs any tasks that is needed prior to shutdown. This usually is used that often, but it can be utilized to save various data or send general closing messages to players.
         */
    }

}
