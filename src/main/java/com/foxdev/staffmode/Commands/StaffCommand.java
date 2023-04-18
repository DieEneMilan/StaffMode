package com.foxdev.staffmode.Commands;

import com.foxdev.staffmode.StaffMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommand implements CommandExecutor {
    private StaffMode plugin;

    public StaffCommand(StaffMode plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)){

            sender.sendMessage("Alleen Spelers");
            return true;
        }

        Player player = (Player) sender;

        if(plugin.getStaffModeInventoryManager().isInStaffMode(player)){
            plugin.getStaffModeInventoryManager().deactivateStaffMode(player);
            player.sendMessage("Staff mode deactivated!");
        } else {
            plugin.getStaffModeInventoryManager().activateStaffMode(player);
            player.sendMessage("Staff mode activated");
        }

        return true;
    }
}
