package com.ssquadteam.geyseranvilfix.hooks;

import org.bukkit.entity.Player;
import org.geysermc.geyser.api.GeyserApi;

/**
 * Implementation of BedrockPlayerProvider using Geyser API
 */
public class GeyserHook implements BedrockPlayerProvider {
    /**
     * Creates a new Geyser hook
     * 
     * @throws ClassNotFoundException If Geyser API is not found
     */
    public GeyserHook() throws ClassNotFoundException {
        // Just try to load the Geyser API class
        Class.forName("org.geysermc.geyser.api.GeyserApi");
    }
    
    @Override
    public boolean isBedrockPlayer(Player player) {
        return GeyserApi.api().isBedrockPlayer(player.getUniqueId());
    }
} 