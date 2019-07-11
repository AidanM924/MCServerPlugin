package com.willburstein.test;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommand implements CommandExecutor {

    /*
    In the onCommand method you must check if the command name matches the command you declared in the plugin.yml. After this check, you can then perform various actions.
    Here, for example, it is responding to the player with a success message indicating that the 'test' command was executed.
     */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("test")) {
            sender.sendMessage("Test command executed!");
            return true;
        }
        return false;
    }
}
