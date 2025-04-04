package com.ssquadteam.geyseranvilfix.hooks;

import org.bukkit.entity.Player;

/**
 * Interface for detecting Bedrock players
 */
public interface BedrockPlayerProvider {
    /**
     * Checks if a player is a Bedrock player
     * 
     * @param player The player to check
     * @return True if the player is a Bedrock player, false otherwise
     */
    boolean isBedrockPlayer(Player player);
} 