package me.acaiberii.tbtr;

import me.acaiberii.tbtr.utility.CapeUtil;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.*;

import static org.apache.logging.log4j.LogManager.getLogger;

@Mod(name = "TBTR", modid = "tbtr", version = "0.0.1")
public class tbtr {
    public static CapeUtil capeUtil = new CapeUtil();
    public static Logger logger = LogManager.getLogger("tbtr");

    @Mod.Instance
    public static tbtr instance;

    public tbtr() {
        instance = this;
    }

    public static tbtr getInstance() {
        return instance;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        me.acaiberii.tbtr.utility.get.Version.getVersion();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
