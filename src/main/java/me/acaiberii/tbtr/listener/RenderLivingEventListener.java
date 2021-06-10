package me.acaiberii.tbtr.listener;

import me.acaiberii.tbtr.Main;
import me.acaiberii.tbtr.event.events.RenderEntityEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RenderLivingEventListener {
    @SubscribeEvent
    public void onLivingEvent(RenderLivingEvent event) {
        RenderEntityEvent postEvent = new RenderEntityEvent(event.getEntity());
        Main.EVENT_BUS.post(postEvent);
    }
}
