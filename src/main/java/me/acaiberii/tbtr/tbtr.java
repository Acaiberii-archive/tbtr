package me.acaiberii.tbtr;

import me.acaiberii.tbtr.exception.NetNotReachableException;
import me.acaiberii.tbtr.utility.CapeUtil;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.*;

import java.net.InetAddress;

import static org.apache.logging.log4j.LogManager.getLogger;

@Mod(name = "TBTR", modid = "tbtr", version = "0.0.1")
public class tbtr {
    public static CapeUtil capeUtil = new CapeUtil();
    public static Logger logger = LogManager.getLogger("tbtr");
    public static EventBus EVENT_BUS = new EventManager();

    @Mod.Instance
    public static tbtr instance;

    public tbtr() {
        instance = this;
    }

    public static tbtr getInstance() {
        return instance;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        logger.info("Getting version...");
        me.acaiberii.tbtr.utility.get.Version.getVersion();
        logger.info("Registering events...");
        me.acaiberii.tbtr.event.EventManager eventManager = new me.acaiberii.tbtr.event.EventManager();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("Finished initializing.");
    }
}
