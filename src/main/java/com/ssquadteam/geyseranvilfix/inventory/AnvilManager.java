package com.ssquadteam.geyseranvilfix.inventory;

import com.ssquadteam.geyseranvilfix.config.AnvilMode;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages anvil interactions and inventory tracking
 */
public class AnvilManager {
    private final Map<Integer, CustomAnvilInventory> inventories = new HashMap<>();
    private final AnvilMode mode;
    private final boolean forwardEnabled;
    
    /**
     * Creates a new anvil manager
     * 
     * @param mode The operation mode for the custom anvil
     * @param forwardEnabled Whether the forward button is enabled
     */
    public AnvilManager(AnvilMode mode, boolean forwardEnabled) {
        this.mode = mode;
        this.forwardEnabled = forwardEnabled;
    }
    
    /**
     * Adds an inventory to the manager
     * 
     * @param windowId The window ID
     * @param inventory The inventory
     */
    public void addInventory(int windowId, CustomAnvilInventory inventory) {
        inventories.put(windowId, inventory);
    }
    
    /**
     * Gets an inventory by window ID
     * 
     * @param windowId The window ID
     * @return The inventory, or null if not found
     */
    public CustomAnvilInventory getInventory(int windowId) {
        return inventories.get(windowId);
    }
    
    /**
     * Removes an inventory from the manager
     * 
     * @param windowId The window ID
     */
    public void removeInventory(int windowId) {
        inventories.remove(windowId);
    }
    
    /**
     * Gets the operation mode
     * 
     * @return The operation mode
     */
    public AnvilMode getMode() {
        return mode;
    }
    
    /**
     * Checks if the forward button is enabled
     * 
     * @return True if enabled, false otherwise
     */
    public boolean isForwardEnabled() {
        return forwardEnabled;
    }
    
    /**
     * Registers an inventory with the manager
     * 
     * @param menu The container menu
     */
    public void registerInventory(AbstractContainerMenu menu) {
        if (menu == null) {
            return;
        }
        
        int windowId = menu.containerId;
        CustomAnvilInventory inventory = new CustomAnvilInventory(menu);
        
        // Add the inventory to the manager
        addInventory(windowId, inventory);
    }
    
    /**
     * Opens the vanilla anvil for a player
     * 
     * @param player The player to open the vanilla anvil for
     */
    public void openVanillaAnvil(Player player) {
        player.closeInventory();
        player.openAnvil(null, true);
    }
} 