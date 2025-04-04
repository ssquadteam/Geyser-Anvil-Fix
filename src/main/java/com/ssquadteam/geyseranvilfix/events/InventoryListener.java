package com.ssquadteam.geyseranvilfix.events;

import com.ssquadteam.geyseranvilfix.GeyserAnvilFixPlugin;
import com.ssquadteam.geyseranvilfix.config.AnvilMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.InventoryView;

/**
 * Listener for inventory events
 */
public class InventoryListener implements Listener {
    
    private final GeyserAnvilFixPlugin plugin;
    
    /**
     * Creates a new inventory listener
     * 
     * @param plugin The plugin instance
     */
    public InventoryListener(GeyserAnvilFixPlugin plugin) {
        this.plugin = plugin;
    }
    
    /**
     * Handles the inventory open event
     * 
     * @param event The event
     */
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        // Only process anvil inventories
        if (event.getInventory().getType() != InventoryType.ANVIL) {
            return;
        }
        
        Player player = (Player) event.getPlayer();
        
        // Check if the player is a Bedrock player
        if (!plugin.getBedrockPlayerProvider().isBedrockPlayer(player)) {
            return;
        }
        
        // Check the operation mode
        AnvilMode mode = plugin.getAnvilManager().getMode();
        
        if (mode == AnvilMode.DISABLED) {
            return;
        }
        
        if (mode == AnvilMode.PERMISSION && !player.hasPermission("geyseranvilfix.use")) {
            return;
        }
        
        // If PacketEvents is not enabled, we can't provide the custom interface
        if (!PacketHandler.isPacketsEnabled()) {
            plugin.getLogger().info("Bedrock player " + player.getName() + " opened an anvil, but PacketEvents is not available. Using default anvil.");
            return;
        }
        
        // For now, we'll use a placeholder message since we don't have the full implementation
        player.sendMessage("§a[Geyser_Anvil_Fix] §eCustom anvil interface will be implemented soon!");
        
        // In a proper implementation, we'd cancel the event and show our custom interface
        // event.setCancelled(true);
        // openCustomAnvil(player);
    }
    
    /**
     * Opens a custom anvil for a player
     * 
     * @param player The player
     */
    private void openCustomAnvil(Player player) {
        // Implementation would create a custom inventory and show it to the player
        // For now, we'll just open a vanilla anvil as a placeholder
        player.openAnvil(null, true);
    }
    
    /**
     * Opens a vanilla anvil for a player
     * 
     * @param player The player
     */
    public static void openVanillaAnvil(Player player) {
        // Simply open a vanilla anvil
        player.openAnvil(null, true);
    }
} 