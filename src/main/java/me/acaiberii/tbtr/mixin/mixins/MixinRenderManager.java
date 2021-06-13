package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.Main;
import me.acaiberii.tbtr.event.events.RenderEntityEvent;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(RenderManager.class)
public class MixinRenderManager {
    @Inject(method = "renderEntity", at = @At("HEAD"))
    public void onRenderEntity(Entity entityIn, double x, double y, double z, float yaw, float partialTicks, boolean p_188391_10_) {
        RenderEntityEvent event = new RenderEntityEvent(entityIn);
        Main.EVENT_BUS.post(event);
    }
}
