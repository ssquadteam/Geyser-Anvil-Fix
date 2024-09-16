package net.ssquadteam.geyseranvilfix.hooks;

import net.ssquadteam.geyseranvilfix.Geyser_Anvil_Fix;
import org.bukkit.Bukkit;
import org.geysermc.floodgate.api.FloodgateApi;

import java.io.File;
import java.util.UUID;

public class FloodgateHook implements Hook {
    public FloodgateApi api;

    public FloodgateHook() throws ClassNotFoundException {
        if(!setup()) {
            throw new ClassNotFoundException();
        }
    }

    private boolean setup(){
        if(Bukkit.getPluginManager().getPlugin("floodgate") == null){
            return false;
        }
        api = FloodgateApi.getInstance();

        File rpf = new File(Geyser_Anvil_Fix.instance.getDataFolder(), "geyseranvilfix-Pack.mcpack");
        if(!rpf.exists()){
            Geyser_Anvil_Fix.instance.saveResource("geyseranvilfix-Pack.mcpack", true);
        }

        File mf = new File(Geyser_Anvil_Fix.instance.getDataFolder(), "geyseranvilfix-Mappings.json");
        if(!mf.exists()){
            Geyser_Anvil_Fix.instance.saveResource("geyseranvilfix-Mappings.json", true);
        }

        return true;
    }


    @Override
    public boolean isBedrockPlayer(UUID player) {
        return api.isFloodgatePlayer(player);
    }
}
