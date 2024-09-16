package net.ssquadteam.geyseranvilfix.config;

import org.bukkit.entity.HumanEntity;

public enum WorkstationMode {

    DISABLED,
    ENABLED,
    SNEAKING,
    NOTSNEAKING;

    public boolean test(HumanEntity player){
        switch (this){
            case ENABLED -> {
                return true;
            }
            case SNEAKING -> {
                return player.isSneaking();
            }
            case NOTSNEAKING -> {
                return !player.isSneaking();
            }
            default -> {
                return false;
            }
        }
    }
}
