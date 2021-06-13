package me.acaiberii.tbtr.listener;

import me.acaiberii.tbtr.event.events.RenderEntityEvent;
import me.acaiberii.tbtr.event.events.TickEvent;
import me.acaiberii.tbtr.util.pos.GetCollision;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static me.acaiberii.tbtr.util.pos.GetFar.*;

public class Listeners implements Listenable {
    @EventHandler
    public Listener<RenderEntityEvent> rEEList = new Listener<>(event -> {
        /// Gets if entities are colliding with the player.
        if (GetCollision.getIsCollidingX(event.getEntity()) && GetCollision.getIsCollidingY(event.getEntity()) && GetCollision.getIsCollidingZ(event.getEntity())) {
            event.cancel();
        } else if (isFarX(event.getEntity(), 200) || isFarY(event.getEntity(), 200) || isFarZ(event.getEntity(), 200)) {
            event.cancel();
        }
    });

    @Mod.EventHandler
    public void onTick(TickEvent event) {
        TickEvent postEvent = new TickEvent();
        MinecraftForge.EVENT_BUS.post(postEvent);
    }

    @SubscribeEvent
    public void renderCape(RenderPlayerEvent event){
        if(event.getEntityPlayer() instanceof AbstractClientPlayer){

        }
    }
}
