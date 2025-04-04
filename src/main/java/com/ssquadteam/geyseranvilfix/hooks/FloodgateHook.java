package com.ssquadteam.geyseranvilfix.hooks;

import org.bukkit.entity.Player;
import org.geysermc.floodgate.api.FloodgateApi;

/**
 * Implementation of BedrockPlayerProvider using Floodgate API
 */
public class FloodgateHook implements BedrockPlayerProvider {
    /**
     * Creates a new Floodgate hook
     * 
     * @throws ClassNotFoundException If Floodgate API is not found
     */
    public FloodgateHook() throws ClassNotFoundException {
        // Just try to load the Floodgate API class
        Class.forName("org.geysermc.floodgate.api.FloodgateApi");
    }
    
    @Override
    public boolean isBedrockPlayer(Player player) {
        return FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId());
    }
} 