package net.ssquadteam.geyseranvilfix.events;

import net.minecraft.world.inventory.AbstractContainerMenu;

import net.ssquadteam.geyseranvilfix.Geyser_Anvil_Fix;
import net.ssquadteam.geyseranvilfix.inventories.AnvilSim;
import net.ssquadteam.geyseranvilfix.inventories.SimInventory;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.inventory.CraftInventoryView;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;

import java.util.HashSet;
import java.util.Set;

import static net.ssquadteam.geyseranvilfix.Geyser_Anvil_Fix.instance;
import static net.ssquadteam.geyseranvilfix.Geyser_Anvil_Fix.openMenus;

public class PaperEvents implements Listener {

    private static final Set<HumanEntity> forwardSkips = new HashSet<>();

    public static void openForward(HumanEntity player) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(instance, () -> {
            player.closeInventory();
            forwardSkips.add(player);
            player.openAnvil(null, true);
        }, 1);
    }

    @EventHandler
    public static void onOpenInv(InventoryOpenEvent e){
        if(!Geyser_Anvil_Fix.geyserApi.isBedrockPlayer(e.getPlayer().getUniqueId())){
            return;
        }
        if(forwardSkips.contains(e.getPlayer())){
            forwardSkips.remove(e.getPlayer());
            return;
        }
        if(e.getInventory().getType() == InventoryType.ANVIL &&
           e.getInventory() instanceof AnvilInventory &&
           AnvilSim.mode.test(e.getPlayer())) {

            AbstractContainerMenu menu = ((CraftInventoryView) e.getView()).getHandle();
            SimInventory sim = openMenus.get(menu.containerId);
            if(sim == null){
                sim = new AnvilSim();
            }
            sim.menu = menu;
            openMenus.put(menu.containerId, sim);
        }
    }
}