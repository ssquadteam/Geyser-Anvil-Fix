package com.ssquadteam.geyseranvilfix.inventory;

import net.minecraft.world.inventory.AbstractContainerMenu;
import org.bukkit.entity.Player;

/**
 * Represents a custom anvil inventory that will be displayed to Bedrock players
 */
public class CustomAnvilInventory {
    /**
     * Enum representing the different slot types in the anvil
     */
    public enum AnvilSlot {
        /**
         * The left input slot
         */
        INPUT_LEFT(0),
        
        /**
         * The right input slot
         */
        INPUT_RIGHT(1),
        
        /**
         * The result slot
         */
        RESULT(2);
        
        private final int index;
        
        AnvilSlot(int index) {
            this.index = index;
        }
        
        /**
         * Gets the index of the slot
         * 
         * @return The index
         */
        public int getIndex() {
            return index;
        }
    }
    
    private final AbstractContainerMenu menu;
    private int cost = 0;
    
    /**
     * Creates a new custom anvil inventory
     * 
     * @param menu The container menu
     */
    public CustomAnvilInventory(AbstractContainerMenu menu) {
        this.menu = menu;
    }
    
    /**
     * Gets the container menu
     * 
     * @return The container menu
     */
    public AbstractContainerMenu getMenu() {
        return menu;
    }
    
    /**
     * Gets the XP cost
     * 
     * @return The XP cost
     */
    public int getCost() {
        return cost;
    }
    
    /**
     * Sets the XP cost
     * 
     * @param cost The XP cost
     * @param player The player
     */
    public void setCost(int cost, Player player) {
        this.cost = cost;
        
        // Update the cost display to the player
        // This would typically be done with a packet or inventory title
    }
    
    /**
     * Converts a backend slot index to a frontend slot index
     * 
     * @param backendIndex The backend slot index
     * @return The frontend slot index, or -1 if not found
     */
    public int getFrontendIndex(int backendIndex) {
        // In a simplified implementation, we'll use a direct mapping
        // This would typically be more complex based on the custom layout
        
        // Anvil slots mapping:
        // 0 -> left input
        // 1 -> right input
        // 2 -> result
        
        if (backendIndex >= 0 && backendIndex <= 2) {
            return backendIndex;
        }
        
        return -1;
    }
    
    /**
     * Converts a frontend slot index to a backend slot index
     * 
     * @param frontendIndex The frontend slot index
     * @return The backend slot index, or -1 if not found
     */
    public int getBackendIndex(int frontendIndex) {
        // In a simplified implementation, we'll use a direct mapping
        // This would typically be more complex based on the custom layout
        
        // Special slots:
        // -2 -> forward button
        
        // Check for special slot
        if (frontendIndex == 8) {
            return -2; // Forward button
        }
        
        // Anvil slots mapping:
        // 0 -> left input
        // 1 -> right input
        // 2 -> result
        
        if (frontendIndex >= 0 && frontendIndex <= 2) {
            return frontendIndex;
        }
        
        return -1;
    }
} 