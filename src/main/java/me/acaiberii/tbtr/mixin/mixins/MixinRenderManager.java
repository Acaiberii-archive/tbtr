package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.Main;
import me.acaiberii.tbtr.event.events.RenderEntityEvent;
import me.acaiberii.tbtr.util.mc.mc;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderManager.class)
public class MixinRenderManager {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    public void onRender(Entity entityIn, ICamera camera, double camX, double camY, double camZ, final CallbackInfoReturnable<Boolean> callback)
    {
        if (!entityIn.getUniqueID().equals(mc.mc.player.getUniqueID())) {
            if (entityIn.isInWeb) callback.setReturnValue(false);
            else if (entityIn.isOutsideBorder) callback.setReturnValue(false);
            else if (entityIn.isDead) callback.setReturnValue(false);
            else if (entityIn.posX == mc.mc.player.posX && entityIn.posZ == mc.mc.player.posZ && entityIn.posY == mc.mc.player.posY) callback.setReturnValue(false);
        }
    }
}
