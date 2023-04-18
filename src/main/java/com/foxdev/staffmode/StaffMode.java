package com.foxdev.staffmode;

import com.foxdev.staffmode.Commands.StaffCommand;
import com.foxdev.staffmode.Manager.StaffModeInventoryManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffMode extends JavaPlugin {

    private StaffModeInventoryManager staffModeInventoryManager;
    @Override
    public void onEnable() {
        staffModeInventoryManager = new StaffModeInventoryManager(this);
        getCommand("staffmode").setExecutor(new StaffCommand(this));

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public StaffModeInventoryManager getStaffModeInventoryManager() {
        return staffModeInventoryManager;
    }
}