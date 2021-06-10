package me.acaiberii.tbtr;

import me.acaiberii.tbtr.listener.RenderEntityEventListener;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import me.zero.alpine.*;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
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
    public void init(FMLInitializationEvent event) {
        EVENT_BUS.subscribe(new RenderEntityEventListener());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
