package me.acaiberii.tbtr.listener;

import me.acaiberii.tbtr.event.events.RenderEntityEvent;
import me.acaiberii.tbtr.util.pos.GetCollision;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.renderer.entity.Render;

import static me.acaiberii.tbtr.util.pos.GetFar.*;

public class RenderEntityEventListener implements Listenable {
    @EventHandler
    public Listener<RenderEntityEvent> rEEList = new Listener<>(event -> {
        /// Gets if entities are colliding with the player.
        if (GetCollision.getIsCollidingX(event.getEntity()) && GetCollision.getIsCollidingY(event.getEntity()) && GetCollision.getIsCollidingZ(event.getEntity())) {
            event.cancel();
        } else if (isFarX(event.getEntity(), 200) || isFarY(event.getEntity(), 200) || isFarZ(event.getEntity(), 200)) {
            event.cancel();
        }
    });
}
