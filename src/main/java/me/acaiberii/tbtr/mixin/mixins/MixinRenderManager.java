package me.acaiberii.tbtr.mixin.mixins;

import me.acaiberii.tbtr.wrapper.Wrapper;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import static me.acaiberii.tbtr.utility.pos.GetCollision.getIsCollidingXYZ;
import static me.acaiberii.tbtr.wrapper.Wrapper.mc;

@Mixin(RenderManager.class)
public class MixinRenderManager {
    @Inject(method = "shouldRender", at = @At("HEAD"), cancellable = true)
    public void onRender(Entity entityIn, ICamera camera, double camX, double camY, double camZ, final CallbackInfoReturnable<Boolean> callback)
    {
        if (!entityIn.equals(Wrapper.mc.player)) {
            if (entityIn.isInWeb)
                callback.setReturnValue(false);
            else if (entityIn.isOutsideBorder)
                callback.setReturnValue(false);
            else if (entityIn.isDead)
                callback.setReturnValue(false);
            else if (getIsCollidingXYZ(entityIn))
                callback.setReturnValue(false);
        }
    }
}
