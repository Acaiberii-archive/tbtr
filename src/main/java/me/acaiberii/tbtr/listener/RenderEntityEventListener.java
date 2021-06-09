package me.acaiberii.tbtr.listener;

import me.acaiberii.tbtr.event.events.RenderEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import me.acaiberii.tbtr.util.*;

public class RenderEntityEventListener {
    @SubscribeEvent
    public void onRender(RenderEntityEvent event) {
        /// Gets if entities are colliding with the player.
        if (GetCollision.getIsCollidingX(event.getEntity()) && GetCollision.getIsCollidingY(event.getEntity()) && GetCollision.getIsCollidingZ(event.getEntity())) {
            event.cancel();
        }
    }
}
