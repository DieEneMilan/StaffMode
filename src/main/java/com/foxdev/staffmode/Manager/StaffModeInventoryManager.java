package com.foxdev.staffmode.Manager;

import com.foxdev.staffmode.StaffMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class StaffModeInventoryManager {


    private StaffMode plugin;
    private HashMap<Player, Inventory> savedInvnetories = new HashMap<>();

    public StaffModeInventoryManager(StaffMode plugin){
        this.plugin = plugin;
    }

    public void activateStaffMode(Player player){

        Inventory savedInventory = plugin.getServer().createInventory(null, 36);
        savedInvnetories.put(player, savedInventory);

        for(int i = 0; i < player.getInventory().getSize(); i++){
            savedInventory.setItem(i, player.getInventory().getItem(i));
            player.getInventory().clear();
        }


        ItemStack staffItem1 = new ItemStack(Material.FEATHER);
        player.getInventory().addItem(staffItem1);

    }

    public void deactivateStaffMode(Player player){
        player.getInventory().clear();

        Inventory savedInventory = savedInvnetories.get(player);
        for(int i = 0; i < savedInventory.getSize(); i++){
            player.getInventory().setItem(i, savedInventory.getItem(i));
        }

        savedInvnetories.remove(player);
    }

    public boolean isInStaffMode(Player player){
        return savedInvnetories.containsKey(player);
    }

}
