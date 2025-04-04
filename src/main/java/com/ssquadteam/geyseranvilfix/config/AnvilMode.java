package com.ssquadteam.geyseranvilfix.config;

/**
 * Represents the operation mode of the custom anvil interface
 */
public enum AnvilMode {
    /**
     * Custom anvil interface is enabled for all Bedrock players
     */
    ENABLED,
    
    /**
     * Custom anvil interface is disabled
     */
    DISABLED,
    
    /**
     * Custom anvil interface is enabled only for Bedrock players with the permission
     */
    PERMISSION
} 