package me.acaiberii.tbtr;

import me.acaiberii.tbtr.listener.Listeners;
import me.acaiberii.tbtr.utility.CapeUtil;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(name = "TBTR", modid = "tbtr", version = "0.0.1")
public class Main {
    public static final EventBus EVENT_BUS = new EventManager();

    @Mod.Instance
    public static Main instance;

    public Main() {
        instance = this;
    }

    public static Main getInstance() {
        return instance;
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        Listeners listeners = new Listeners();
        EVENT_BUS.subscribe(listeners);
    }
}
