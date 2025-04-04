package com.ssquadteam.geyseranvilfix;

import com.ssquadteam.geyseranvilfix.config.AnvilMode;
import com.ssquadteam.geyseranvilfix.events.InventoryListener;
import com.ssquadteam.geyseranvilfix.events.PacketHandler;
import com.ssquadteam.geyseranvilfix.hooks.BedrockPlayerProvider;
import com.ssquadteam.geyseranvilfix.hooks.FloodgateHook;
import com.ssquadteam.geyseranvilfix.hooks.GeyserHook;
import com.ssquadteam.geyseranvilfix.inventory.AnvilManager;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class GeyserAnvilFixPlugin extends JavaPlugin implements Listener {

    private static GeyserAnvilFixPlugin instance;
    private static Logger logger;
    private static boolean debug = false;
    private BedrockPlayerProvider bedrockPlayerProvider;
    private AnvilManager anvilManager;

    public static GeyserAnvilFixPlugin getInstance() {
        return instance;
    }

    public static void logDebug(String message) {
        if (debug) {
            logger.info("[Debug] " + message);
        }
    }

    @Override
    public void onLoad() {
        // We don't initialize PacketEvents in onLoad anymore, we'll do it in onEnable
    }

    @Override
    public void onEnable() {
        instance = this;
        logger = getLogger();
        
        // Save default config
        saveDefaultConfig();
        
        // Load configuration
        debug = getConfig().getBoolean("debug", false);
        AnvilMode mode = AnvilMode.valueOf(getConfig().getString("anvil.mode", "ENABLED"));
        boolean forwardEnabled = getConfig().getBoolean("anvil.forward", true);
        
        // Initialize the inventory manager
        anvilManager = new AnvilManager(mode, forwardEnabled);
        
        // Setup Geyser/Floodgate hook for detecting Bedrock players
        setupBedrockPlayerProvider();
        
        // Register event listeners
        getServer().getPluginManager().registerEvents(new InventoryListener(this), this);
        
        // Register packet handlers if we have a bedrock player provider
        if (bedrockPlayerProvider != null) {
            PacketHandler.register(this, anvilManager);
        }
        
        getLogger().info("Geyser_Anvil_Fix enabled successfully!");
    }
    
    @Override
    public void onDisable() {
        // No need to terminate PacketEvents
        getLogger().info("Geyser_Anvil_Fix disabled successfully!");
    }
    
    private void setupBedrockPlayerProvider() {
        try {
            bedrockPlayerProvider = new GeyserHook();
            getLogger().info("Using Geyser API for Bedrock player detection");
        } catch (ClassNotFoundException e) {
            try {
                bedrockPlayerProvider = new FloodgateHook();
                getLogger().warning("Geyser API not found, using Floodgate API for Bedrock player detection");
                getLogger().warning("Please add the mapping and resource pack files to Geyser's directory");
            } catch (ClassNotFoundException ex) {
                getLogger().severe("Neither Geyser nor Floodgate found. Plugin will be disabled.");
                Bukkit.getPluginManager().disablePlugin(this);
                return;
            }
        }
    }
    
    public BedrockPlayerProvider getBedrockPlayerProvider() {
        return bedrockPlayerProvider;
    }
    
    public AnvilManager getAnvilManager() {
        return anvilManager;
    }
} 