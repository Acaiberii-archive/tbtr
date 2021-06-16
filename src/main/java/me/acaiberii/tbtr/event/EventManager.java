package me.acaiberii.tbtr.event;

import me.acaiberii.tbtr.tbtr;
import net.minecraftforge.common.MinecraftForge;

public class EventManager {
    public EventManager() {
        MinecraftForge.EVENT_BUS.register(tbtr.getInstance());
    }
}
