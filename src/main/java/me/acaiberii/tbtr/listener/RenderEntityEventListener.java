package me.acaiberii.tbtr.listener;

import me.acaiberii.tbtr.event.events.RenderEntityEvent;
import me.acaiberii.tbtr.util.pos.GetCollision;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static me.acaiberii.tbtr.util.pos.GetFar.*;

public class RenderEntityEventListener {
    @SubscribeEvent
    public void onRender(RenderEntityEvent event) {
        /// Gets if entities are colliding with the player.
        if (GetCollision.getIsCollidingX(event.getEntity()) && GetCollision.getIsCollidingY(event.getEntity()) && GetCollision.getIsCollidingZ(event.getEntity())) {
            event.cancel();
        }
        else if (isFarX(event.getEntity(), 200) || isFarY(event.getEntity(), 200) || isFarZ(event.getEntity(), 200)) {
            event.cancel();
        }
    }
}
