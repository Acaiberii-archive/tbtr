package me.acaiberii.tbtr.event.events;

import me.acaiberii.tbtr.event.Event;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class RenderEntityEvent extends Event {
    public Entity getEntity() {
        return entity;
    }

    private final Entity entity;

    public RenderEntityEvent(Entity entityIn) {
        this.entity = entityIn;
    }
}
