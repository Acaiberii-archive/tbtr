package me.acaiberii.tbtr.handler;

import me.acaiberii.tbtr.Main;
import me.acaiberii.tbtr.listener.Listeners;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

import static me.acaiberii.tbtr.Main.*;

public class InitHandler {
    @Mod.EventHandler
    public void subInit(FMLInitializationEvent event) {
        Listeners listeners = new Listeners();
        EVENT_BUS.subscribe(listeners);
        LOGGER.log(Level.DEBUG, "Registered event system (ALPINE)");
        MinecraftForge.EVENT_BUS.register(Main.getInstance());
        LOGGER.log(Level.DEBUG, "Registered event system (FORGE)");
    }
}
