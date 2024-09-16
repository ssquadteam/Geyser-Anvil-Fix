package net.ssquadteam.geyseranvilfix;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import net.ssquadteam.geyseranvilfix.config.WorkstationMode;
import net.ssquadteam.geyseranvilfix.events.PaperEvents;
import net.ssquadteam.geyseranvilfix.events.ProtocolEvents;
import net.ssquadteam.geyseranvilfix.hooks.FloodgateHook;
import net.ssquadteam.geyseranvilfix.hooks.GeyserHook;
import net.ssquadteam.geyseranvilfix.hooks.Hook;
import net.ssquadteam.geyseranvilfix.inventories.AnvilSim;
import net.ssquadteam.geyseranvilfix.inventories.SimInventory;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public final class Geyser_Anvil_Fix extends JavaPlugin implements Listener {

    public static Geyser_Anvil_Fix instance;
    public static ProtocolManager manager;
    public static Map<Integer, SimInventory> openMenus = new HashMap<>();
    public static Hook geyserApi;

    public static Logger logger;
    private static boolean debug = false;

    public static void debugInfo(String message){
        if(debug){
            logger.info(message);
        }
    }

    @Override
    public void onEnable() {
        instance = this;
        manager = ProtocolLibrary.getProtocolManager();
        logger = getLogger();
        saveDefaultConfig();
        debug = getConfig().getBoolean("debug");
        AnvilSim.mode = WorkstationMode.valueOf(getConfig().getString("anvil.mode"));
        AnvilSim.forwardEnabled = getConfig().getBoolean("anvil.forward", true);

        try {
            geyserApi = new GeyserHook();
        } catch (ClassNotFoundException e) {
            try {
                geyserApi = new FloodgateHook();
            } catch (ClassNotFoundException ex) {
                getLogger().severe("Geyser nor Floodgate found. Shutting down");
                Bukkit.getPluginManager().disablePlugin(this);
            }
        }
        if(geyserApi instanceof FloodgateHook){
            getLogger().warning("Geyser was not found but floodgate was. Take Mappings and Pack from this plugin's folder and add them to Geyser's");
        }

        getServer().getPluginManager().registerEvents(new PaperEvents(), this);
        ProtocolEvents.addListeners();
    }
}
