package net.ssquadteam.geyseranvilfix.hooks;

import net.ssquadteam.geyseranvilfix.Geyser_Anvil_Fix;
import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.EventBus;
import org.geysermc.geyser.api.event.EventRegistrar;
import org.geysermc.geyser.api.event.lifecycle.GeyserDefineCustomItemsEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserLoadResourcePacksEvent;
import org.geysermc.geyser.api.item.custom.CustomItemData;
import org.geysermc.geyser.api.item.custom.CustomItemOptions;

import java.io.File;

public class GeyserEvents implements EventRegistrar {
    public GeyserEvents(GeyserHook hook){
        EventBus<EventRegistrar> bus = hook.api.eventBus();
        bus.register(this, this);
        bus.subscribe(this, GeyserLoadResourcePacksEvent.class, this::onGeyserLoadResourcePacks);
        bus.subscribe(this, GeyserDefineCustomItemsEvent.class, this::onGeyserDefineCustomItems);
    }
    @Subscribe
    public void onGeyserDefineCustomItems(GeyserDefineCustomItemsEvent e){
        e.register("minecraft:structure_void", CustomItemData.builder().customItemOptions(
                CustomItemOptions.builder().customModelData(593721).build()
        ).name("empty").displayName(" ").build());
    }
    @Subscribe
    public void onGeyserLoadResourcePacks(GeyserLoadResourcePacksEvent e){
        File rp = new File(Geyser_Anvil_Fix.instance.getDataFolder(), "geyseranvilfix-Pack.mcpack");
        if(!rp.exists()){
            Geyser_Anvil_Fix.instance.saveResource("geyseranvilfix-Pack.mcpack", true);
        }
        e.resourcePacks().add(rp.toPath());
    }
}
